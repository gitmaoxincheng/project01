package cn.com.agree.huanan.ap.al.csiopr.keep.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiopr.keep.dao.KeepDao;
import cn.com.agree.huanan.ap.al.csiopr.keep.exception.InsertKeepFailException;
import cn.com.agree.huanan.ap.al.csiopr.keep.exception.KeepExistException;
import cn.com.agree.huanan.ap.al.csiopr.keep.exception.KeepNotExistException;
import cn.com.agree.huanan.ap.al.csiopr.keep.exception.KeepOutBoundException;
import cn.com.agree.huanan.ap.al.csiopr.keep.exception.NoBranChnoException;
import cn.com.agree.huanan.ap.al.csiopr.keep.po.Keep;
import cn.com.agree.huanan.ap.al.csiopr.keeppara.exception.FindNoDataException;
import cn.com.agree.huanan.ap.al.csiopr.keeppara.exception.GetKeepParaListFailException;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;


@Service
public class KeepService {

	@Autowired KeepDao keepDao;
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	@Autowired Logger logger;

	/**
	 * 插入代保管物品参数表
	 * 
	 * */
	public String insertKeep(Keep keep) {

		String keepDate = keep.getKeepDate();
		//获取代保管编号
		String keepNo = keepDao.getKeepNo(keepDate);
		Keep temp = keepDao.queryKeepByKeepNo(keepNo);
		if(null != temp ) {
			throw new KeepExistException();
		}
		keep.setKeepNo(keepNo);
		int count = keepDao.insertKeep(keep);
		if( count !=1 ) {
			logger.error("插入代保管物品信息失败");
			throw new InsertKeepFailException();
		}
		logger.error("插入代保管物品信息成功");
		logger.info("提交");
		dbo.commit();

		return keepNo;
	}

	/**
	 * 代保管物品信息出库处理
	 * 
	 * */
	public void outBoundKeepByKeepNo(Keep keep) {
		String keepNo = keep.getKeepNo();
		String branChno = keep.getBranchNo();
		Keep temp = keepDao.queryKeepByKeepNo(keepNo);
		if( keepNo == null) {
			throw new InsertKeepFailException("没有输入代保管编号");
		}else if(branChno == null) {
			throw new NoBranChnoException("没有出库网点号");
		}else if(null == temp ) {
			throw new KeepNotExistException();
		}else if("1".equals(temp.getStatus())) {
			throw new KeepOutBoundException();
		}else if(!branChno.equals(temp.getBranchNo())) {
			throw new NoBranChnoException("不能跨机构办理");
		}


		int count = keepDao.updateKeep(keep);
		if( count !=1 ) {
			logger.error("代保管物品出库失败");
			throw new InsertKeepFailException("代保管物品出库失败");
		}
		logger.error("代保管物品信息出库成功");
		logger.info("提交");
		dbo.commit();

	}

	/**
	 * 修改代保管物品信息
	 * 
	 * */
	public void modifyKeep(Keep keep) {
		String keepNo = keep.getKeepNo();
		String branChno = keep.getBranchNo();
		Keep temp = keepDao.queryKeepByKeepNo(keepNo);

		if( temp == null) {
			throw new KeepNotExistException();
		}else if(branChno == null) {
			throw new NoBranChnoException();
		}else if(!branChno.equals(temp.getBranchNo())) {
			throw new NoBranChnoException("不能跨机构办理");
		}

		int count = keepDao.updateKeep(keep);
		if( count !=1 ) {
			logger.error("代保管物品修改失败");
			throw new InsertKeepFailException("代保管物品修改失败");
		}
		logger.error("代保管物品信息修改成功");
		logger.info("提交");
		dbo.commit();

	}

	/**
	 * 代保管物品信息查询
	 * */
	public Map<String, Object> getKeepList(Integer pageflag, Integer maxnum, String keepno, String keeptype,String keepname, String strstatus, String begkeepdate, String endkeepdate, String strbrno,String localBrno) {

		//本地网点号不能为空
		if(StringUtils.isEmpty(localBrno)) {
			throw new NoBranChnoException("本地网点号不能为空");
		}

		//总行可以查询所有代保管品  机构类型为0表示总行
		String type = keepDao.queryTypeofBranch(localBrno);
		//特殊总行号 临时SIT UAT 用来测试用
		String theBrno = keepDao.queryBrnoFromSysPara();
		logger.info("本地网点号："+localBrno);
		logger.info("本地网点号的类型:"+type);
		logger.info("特殊总行号："+theBrno);
		
		//非总行且不是特殊总行
		if(!"0".equals(type)&(!localBrno.equals(theBrno))) {
			//分行只能查自己
			if(StringUtils.isEmpty(strbrno)) {
				//当查询网点号为空就查本地网点号
				strbrno = localBrno; 
			}
			//本地网点号和查询网点号不同时 不能跨机构办理
			if(!localBrno.equals(strbrno)) {
				throw new NoBranChnoException("不能跨机构办理");
			}
		}
		if(pageflag < 1) {
			logger.error("每页查询记录数不可小于1");
			throw new GetKeepParaListFailException("pageflag");
		}
		if(maxnum < 1) {
			logger.error("每页最多记录数");
			throw new GetKeepParaListFailException("maxnum");
		}

		Map<String,Object> result = new HashMap<>();
		IPage<Map<String,Object>> pageInfo = keepDao.getKeepParaList(pageflag,maxnum,keepno,keeptype,keepname,strstatus,begkeepdate,endkeepdate,strbrno);

		if(0 == pageInfo.getSize()) {
			throw new FindNoDataException();
		}

		result.put("rowcnt", pageInfo.getTotal());// 总笔数
		result.put("listnm", pageInfo.getSize());// 返回记录数
		result.put("keep_list", pageInfo.getRecords());// 返回数据
		return result;
	}



}
