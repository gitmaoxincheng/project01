package cn.com.agree.huanan.ap.al.csiopr.keep.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiopr.keep.dao.KeepDao;
import cn.com.agree.huanan.ap.al.csiopr.keep.dao.KeepFlowDao;
import cn.com.agree.huanan.ap.al.csiopr.keep.exception.HandleOverException;
import cn.com.agree.huanan.ap.al.csiopr.keep.exception.KeepNotExistException;
import cn.com.agree.huanan.ap.al.csiopr.keep.po.Keep;
import cn.com.agree.huanan.ap.al.csiopr.keep.po.KeepFlow;
import cn.com.agree.huanan.ap.al.csiopr.keeppara.exception.FindNoDataException;
import cn.com.agree.huanan.ap.al.csiopr.teller.dao.TellerDao;
//import cn.com.agree.huanan.ap.rl.bank.base.util.SernoGenUtil;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class KeepFlowService {

	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	@Autowired KeepDao keepDao;
	@Autowired KeepFlowDao keepFlowDao;
	@Autowired TellerDao tellerDao;


	/**
	 * 查询代保管物品
	 * */
	public Keep queryKeepByKeepNo(String keepNo) {
		logger.info(keepNo);
		Keep keep = keepDao.queryKeepByKeepNo(keepNo);
		if(keep == null) {
			throw new KeepNotExistException();
		}
		logger.info(keep.toString());
		return keep;
	}

	/**
	 * 登记代保管物品交接校验
	 * @param listnm 根据机构号柜员号进行柜员信息查询的返回记录数
	 * @param oldBrNo 原机构号
	 * @param BrNo 发起机构号
	 * @param oldtellerNo 原保管人
	 * @param tellerNo 交接人
	 * 
	 * */
	public void checkKeepFlow(String listnm ,String oldBrNo, String BrNo, String oldtellerNo , String tellerNo , Keep keep) {
		//只能在本机构内进行代保管物品交接，不能跨机构办理
		logger.info("本机构为："+oldBrNo+"  发起交接机构为："+BrNo);
		if(!oldBrNo.equals(BrNo)) {
			logger.info("只能在本机构内进行代保管物品交接，不能跨机构办理");
			throw new HandleOverException("只能在本机构内进行代保管物品交接，不能跨机构办理");
		}

		//接收人必须为本机构柜员
		if(!"1".equals(listnm)) {
			logger.info("接收人必须为本机构柜员");
			throw new HandleOverException("接收人必须为本机构柜员");
		}

		logger.info("原保管人："+oldtellerNo+"  操作员为："+tellerNo);
		if(!oldtellerNo.equals(tellerNo)) {
			//代保管物[**（代保管编号）]的保管人为[操作员号]，您暂无权限进行操作！
			logger.info("代保管物["+keep.getKeepName()+"("+keep.getKeepNo()+")]的保管人为["+oldtellerNo+"]，您暂无权限进行操作！");
			throw new HandleOverException("代保管物["+keep.getKeepName()+"("+keep.getKeepNo()+")]的保管人为["+oldtellerNo+"]，您暂无权限进行操作！");
		}

		//只能对状态为“已入库”的代保管物进行交接，已出库的无需交接    0-已入库   1-已出库
		String status = keep.getStatus();
		logger.info("代保管品状态："+status);
		if(!"0".equals(status)) {
			logger.info("只能对状态为“已入库”的代保管物进行交接");
			throw new HandleOverException("只能对状态为“已入库”的代保管物进行交接");
		}

	}

	/**
	 * 登记代保管物品交接流水表
	 * 
	 * */
	public void insertKeepFlow(KeepFlow keepFlow) {

		String keepNo = keepFlow.getKeepNo();

		//根据代保管编号查代保管品信息
		Keep keep = keepDao.queryKeepByKeepNo(keepNo);
		logger.info("keepNo:"+keepNo+"  "+keep);

		//keepFlow.setSeriNo(SernoGenUtil.getSerno(CommParam.TRD_SEQ)); //操作流水号
		keepFlow.setSeriNo("SernoGenUtil.getSerno(CommParam.TRD_SEQ)"); //操作流水号
		keepFlow.setKeepType(keep.getKeepType());
		keepFlow.setKeepNum(keep.getKeepNum());
		keepFlow.setUnit(keep.getUnit());

		//登记 代保管物品交接流水表
		int count = keepFlowDao.insertKeepFlow(keepFlow);
		if(count != 1) {
			logger.error("登记代保管物品交接流水表失败");
			throw new HandleOverException("登记代保管物品交接流水表失败");
		}

		//更新代保管物品表的保管人
		count = keepDao.updateKeepTlrNoByKeepNo(keepNo, keepFlow.getRcvTlrNo());
		if(count != 1) {
			logger.error("更新代保管物品表的保管人");
			throw new HandleOverException("更新代保管物品表的保管人");
		}


	}

	/**
	 * 查询
	 * */
	public Map<String, Object> queryKeepFlow(String pageflag, String maxnum, String keepno) {

		IPage<Map<String,Object>> pageInfo = keepFlowDao.getKeepFlowList(pageflag, maxnum, keepno);
		logger.info("pageInfo:  "+pageInfo);

		if(0 == pageInfo.getSize()) {
			throw new FindNoDataException();
		}

		Map<String,Object> result = new HashMap<>();
		result.put("rowcnt", pageInfo.getTotal());// 总笔数
		result.put("listnm", pageInfo.getSize());// 返回记录数
		result.put("keep_list", pageInfo.getRecords());// 返回数据
		logger.info("result:  "+result);
		return result;
	}










}
