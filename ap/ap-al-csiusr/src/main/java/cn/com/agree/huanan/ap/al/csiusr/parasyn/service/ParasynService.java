package cn.com.agree.huanan.ap.al.csiusr.parasyn.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiusr.branch.dao.BranchDao;
import cn.com.agree.huanan.ap.al.csiusr.branch.exception.BranchNotFoundException;
import cn.com.agree.huanan.ap.al.csiusr.branch.po.Branch;
import cn.com.agree.huanan.ap.al.csiusr.parasyn.dao.ParasynDao;
import cn.com.agree.huanan.ap.al.csiusr.parasyn.exception.ParasynInsertException;
import cn.com.agree.huanan.ap.al.csiusr.parasyn.exception.ParasynUpdateException;
import cn.com.agree.huanan.ap.al.csiusr.parasyn.po.Parasyn;
import cn.com.agree.huanan.ap.rl.bank.base.dao.SysParaDao;
import cn.com.agree.huanan.ap.rl.bank.base.po.Syspara;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApSelectNotFoundException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApUpdateFailException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
/**
 * 综合后管同步登记表Service
 * @author xuzhen
 *
 */
@Service
public class ParasynService {

	@Autowired ParasynDao parasynDao;
	@Autowired Logger logger;
	@Autowired DbOperator dbo;
	@Autowired SysParaDao sysParaDao;    
	@Autowired BranchDao branchDao;
	
	/**
	 * 登记操作信息
	 * @param parasynMap 登记信息
	 * @return 
	 * @return
	 */
	public String addNewRecord(Map<String,Object>parasynMap) {
		logger.info("新增综合后管同步登记表信息");
//		//判断是否重推,根据推送流水号查询是否有记录
//		Parasyn parasyn = parasynDao.queryByBatchNo(parasynMap.get("batchno")+"");
//		if(parasyn!=null) {
//			logger.debug("已存在记录,不再新增流水");
//			return parasyn.getSerialNo();
//		}
		//判断是否为机构撤并
		if("0".equals(parasynMap.get("syntype"))&&"6".equals(parasynMap.get("opttype"))) {
			//判断被并机构是否存在
			String mrbrno = parasynMap.get("brno")+"";
			Branch mrBranchInfo = branchDao.queryBranchByNo(mrbrno);
			if(mrBranchInfo==null) {
				logger.error("机构["+mrbrno+"]不存在");
				throw new BranchNotFoundException(mrbrno);
			}
			//被并机构名称
			parasynMap.put("brna", mrBranchInfo.getBrnas());
			//判断合并机构是否存在
			String unbranchno = parasynMap.get("unbranchno")+"";
			Branch unbranchInfo = branchDao.queryBranchByNo(unbranchno);
			if(unbranchInfo==null) {
				logger.error("机构["+unbranchno+"]不存在");
				throw new BranchNotFoundException(unbranchno);
			}
		}else if ("0".equals(parasynMap.get("syntype"))&&"7".equals(parasynMap.get("opttype"))){
			//判断机构是否存在
			String brno = parasynMap.get("brno")+"";
			Branch branchInfo = branchDao.queryBranchByNo(brno);
			if(branchInfo==null) {
				logger.error("机构["+brno+"]不存在");
				throw new BranchNotFoundException(brno);
			}
		}
		//插入数据
		int count = parasynDao.insert(parasynMap);
		//判断是否插入成功
		if(count!=1) {
			logger.error("插入数据异常,登记失败");
			dbo.rollback();
			throw new ParasynInsertException("插入数据异常,登记失败");
		}
		dbo.commit();
		return parasynMap.get("serialno")+"";
	}
	
	/**
	 * 根据操作流水号更新同步登记表信息
	 * @param serialNo
	 * @param parasynMap
	 * @return
	 */
	public int changeParasynInfo(String serialNo,Map<String,Object>parasynMap) {
		logger.info("更新同步登记表信息");
		//更新同步登记表信息
		int count = parasynDao.updateParasynInfo(serialNo, parasynMap);
		//判断是否修改成功
		if(count!=1) {
			logger.error("更新数据异常,更新同步登记表信息失败");
			dbo.rollback();
			throw new ParasynUpdateException("更新数据异常,更新同步登记表信息失败");
		}
		dbo.commit();
		return count;
	}
	
	/**
	 * 根据操作流水号查询该操作流水号的信息
	 * @param serialNo
	 * @return
	 */
	public Parasyn queryParasynBySerialNo(String serialNo) {
		logger.info("查询同步登记表信息");
		//查询同步登记表信息
		Parasyn parasyn=parasynDao.queryBySerialNo(serialNo);
		//判断是否查询到该流水号信息
		if(parasyn==null) {
			logger.error("查询无记录");
			throw new ApSelectNotFoundException("查询失败");
		}
		return parasyn;
	}
	
	/**
	 * 查询机构撤并明细列表
	 * @param strbrno 被撤并机构号
	 * @param unbrno 并入机构号
	 * @param strdate 日期
	 * @param strstatus 处理状态
	 * @param pagenum 查询页码
	 * @param pagesize 查询条数
	 * @return
	 */
	public Map<String, Object> selectDetailInfo(String strbrno, String unbrno, String strdate, String strstatus,
			int pagenum, int pagesize){
		if (pagesize < 1 || pagenum < 1) {
			throw new ApIllegalParamException("pagenum/pagesize 要大于 1");
		}
		//查询明细列表
		IPage<Map<String, Object>> detailInfo = parasynDao.queryDetailInfo(strbrno, unbrno, strdate, strstatus, pagenum, pagesize);
		if(detailInfo.getSize()<=0) {
			throw new ApSelectNotFoundException("查询失败");
		}
		//返回信息
		List<Map<String,Object>>rspList = new ArrayList<>();
		//查询机构名称
		for (Map<String, Object> detail : detailInfo.getRecords()) {
			//赋值默认值
			Map<String,Object>detailInfo1 = new HashMap<>();
			detailInfo1.put("serialno", detail.getOrDefault("serialno", ""));
			detailInfo1.put("optdate", detail.getOrDefault("optdate", ""));
			detailInfo1.put("strbrno", detail.getOrDefault("strbrno", ""));
			detailInfo1.put("strbrnona", detail.getOrDefault("strbrnona", ""));
			detailInfo1.put("unbrno", detail.getOrDefault("unbrno", ""));
			detailInfo1.put("unbrnona",detail.getOrDefault("unbrnona", ""));
			detailInfo1.put("brdate", detail.getOrDefault("brdate", ""));
			detailInfo1.put("strstatus", detail.getOrDefault("strstatus", ""));
			detailInfo1.put("wtstat", detail.getOrDefault("wtstat", ""));
			detailInfo1.put("wtnum", detail.getOrDefault("wtnum", ""));
			detailInfo1.put("rspcode", detail.getOrDefault("rspcode", ""));
			detailInfo1.put("rspmsg", detail.getOrDefault("rspmsg", ""));
			rspList.add(detailInfo1);
		}
		//返回容器
		Map<String,Object>rspMap = new HashMap<>();
		rspMap.put("rowcnt", detailInfo.getTotal());
		rspMap.put("listnm", detailInfo.getSize());
		rspMap.put("detail_list", rspList);
		return rspMap ;
	}

	/**
	 * 更新撤并状态
	 * @param serialno 流水号
	 * @param optdate 操作日期
	 * @param updInfo 状态信息
	 */
	public void updMergeSta(String serialno, String optdate, Map<String, Object> updInfo) {
		logger.debug("更新撤并状态");
		//判断记录是否存在
		queryParasynBySerialNo(serialno);
		//更新记录
		int count = parasynDao.updateMergeSta(serialno,optdate,updInfo);
		if(count<=0) {
			logger.error("更新撤并状态失败");
			dbo.rollback();
			throw new ApUpdateFailException("");
		}
		dbo.commit();
	}
	
	/**
	 * 查询所有需回写的同步记录
	 * @param wtnum 回写次数
	 * @return
	 */
	public List<Map<String,Object>>getBackWriteList(String paraItem,String paraCode){
		//查询回写次数
		int wtnum = 10 ;
		List<Syspara> queryList = sysParaDao.queryList(paraItem, paraCode);
		if(queryList.size()==1) {
			wtnum = Integer.parseInt(queryList.get(0).getParaValue1());
		}
		return parasynDao.queryBackWriteList(wtnum);
		
	}
	
	/**
	 * 获取所有当日待执行的撤并记录
	 * @param nowDate 当前日期
	 * @return
	 */
	public List<Map<String,Object>>queryBackoutList(String nowDate){
		//更新所有超期未处理记录为处理失败
		int count = parasynDao.updOutOfDate(nowDate);
		dbo.commit();
		//获取所有当日待执行的撤并记录
		return parasynDao.queryBackoutList(nowDate);
	}
}
