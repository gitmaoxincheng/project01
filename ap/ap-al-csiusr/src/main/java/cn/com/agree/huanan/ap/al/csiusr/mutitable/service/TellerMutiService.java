package cn.com.agree.huanan.ap.al.csiusr.mutitable.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.branch.dao.BranchDao;
import cn.com.agree.huanan.ap.al.csiusr.branch.exception.BranchNotFoundException;
import cn.com.agree.huanan.ap.al.csiusr.branch.po.Branch;
import cn.com.agree.huanan.ap.al.csiusr.mutitable.dao.TellerMutiDao;
import cn.com.agree.huanan.ap.al.csiusr.teller.dao.TellerDao;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerBranchNotSubjectionException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerNotExistException;
import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerInfo;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class TellerMutiService {
	@Autowired TellerMutiDao tellerMutiDao;
	@Autowired TellerDao tellerDao;
	@Autowired BranchDao branchDao;
	@Autowired Logger logger;
	
	public Map<String, Object> queryTellerDutyInfo(String tellerNo, String tellerType, String name, String brNo, int pageSize, int pageFlag, 
			String logBrno, String devtype, String userst) {
		
		// 检查柜员是否存在
		logger.info("----------检查柜员是否存在----------");
		if (!StringUtils.isEmpty(tellerNo)) {
			List<TellerInfo> tellerInfoList = tellerDao.selectTellerByTellerNo(tellerNo);
			if (null == tellerInfoList || 0 == tellerInfoList.size()) {
				throw new TellerNotExistException(tellerNo);
			}
		}
		
		// 检查网点号是否存在
		logger.info("----------检查网点号是否存在----------");
		if (!StringUtils.isEmpty(brNo)) {
			Branch strBranch = branchDao.queryBranchByNo(brNo);
			if (null == strBranch) {
				throw new BranchNotFoundException(brNo);
			}
		}
		
		// 检查柜员是否注册该网点
		if (!StringUtils.isEmpty(tellerNo) && !StringUtils.isEmpty(brNo)) {
			logger.info("----------检查柜员是否注册该网点----------");
			TellerInfo tellerInfo = tellerDao.queryTellerByNo(tellerNo, brNo);
			if (null == tellerInfo) {
				throw new TellerBranchNotSubjectionException(tellerNo);
			}
		}
		
		if (pageSize < 1 || pageFlag < 1) {
			throw new ApIllegalParamException("maxNum/pageFlag 要大于 1");
		}
		
		String myBank = logBrno.substring(0,3);
		Branch logBranch = branchDao.queryBranchByNo(logBrno);
		if (null != logBranch && "4".equals(logBranch.getBrtp())) {
			if (StringUtils.isEmpty(brNo)) {	
				brNo = "";
			}
		} else {
			if (!StringUtils.isEmpty(brNo)) {
				if (!logBrno.equals(brNo)) {
					throw new ApIllegalParamException("不能查询非本机构柜员");
				}
			}
			brNo = logBrno;
		}
		
		return tellerMutiDao.selectTellerDutyInfo(tellerNo, tellerType, name, brNo, pageSize, pageFlag, devtype, myBank, userst);
	}
	
	/**
	 * 柜员信息及认证方式查询
	 * @param tellerNo
	 * @return
	 */
	public Map<String, Object> queryTellerByTellerNo(String tellerNo) {
		
		if (tellerNo == null) {
			logger.error("请输入柜员号！");
			throw new ApIllegalParamException("请输入柜员号！");	
		}
		//查找柜员信息
		Map<String, Object> result = tellerMutiDao.selectTellerByTellerNo(tellerNo);
		//柜员信息不存在
		if(result.isEmpty()) {
			logger.error("柜员号["+tellerNo+"]信息不存在");
			throw new ApIllegalParamException("柜员号["+tellerNo+"]信息不存在");	
		}
		
		return result;
	}

	/**
	 * 柜员信息变动记录查询
	 * @param pageFlag 页码
	 * @param maxNum 每页最多记录数
	 * @param bgDate 起始日期
	 * @param edDate 截止日期
	 * @param strTellerNo 柜员号
	 * @param transStatus 状态
	 * @param brNo 当前机构号
	 * @return 总笔数，返回记录数，循环体
	 */
	public Map<String, Object> queryTelrChaRecs(int pageFlag, int maxNum, String bgDate, String edDate, String strTellerNo,
			String transStatus, String brNo) {
		Map<String, Object> result = new HashMap<>();
		
		if (maxNum < 1 || pageFlag < 1) {
			throw new ApIllegalParamException("maxNum/pageFlag 要大于 1");
		}
		
		int date =  Integer.parseInt(edDate) - Integer.parseInt(bgDate);
		if (date < 0) {
			throw new ApIllegalParamException("结束时间不能小于起始日期");
		}
		
		String myBank = brNo.substring(0,3);
		Branch logBranch = branchDao.queryBranchByNo(brNo);
		if (null != logBranch && "4".equals(logBranch.getBrtp())) {
			brNo = "";
		}
		
		IPage<Map<String,Object>> pageInfo = tellerMutiDao.selectTelrChaRecs(pageFlag, maxNum, bgDate, edDate, strTellerNo, transStatus, brNo, myBank);
		result.put("rowcnt", pageInfo.getTotal());// 总笔数
		result.put("listnm", pageInfo.getSize());// 返回记录数
		result.put("bodrcd_list", pageInfo.getRecords());// 返回数据
		return result;
	}

	/**
	 * 柜员管理交易流水查询
	 * @param pageFlag 页码
	 * @param maxNum 每页最多记录数
	 * @param bgDate 起始日期
	 * @param edDate 截止日期
	 * @param bgSerialNo 起始流水
	 * @param edSerialNo 截止流水
	 * @param strTellerNo 柜员号
	 * @param strBrNo 网点号
	 * @param brNo 当前机构号
	 * @return 总笔数，返回记录数，循环体
	 */
	public Map<String, Object> queryTelManTraSeri(int pageFlag, int maxNum, String bgDate, String edDate, String bgSerialNo,
			String edSerialNo, String strTellerNo, String strBrNo, String brNo) {
		if (maxNum < 1 || pageFlag < 1) {
			throw new ApIllegalParamException("maxNum/pageFlag 要大于 1");
		}
		
		int date =  Integer.parseInt(edDate) - Integer.parseInt(bgDate);
		if (date < 0) {
			throw new ApIllegalParamException("结束时间不能小于起始日期");
		}
		
		String myBank = brNo.substring(0,3);
		Branch logBranch = branchDao.queryBranchByNo(brNo);
		if (null != logBranch && "4".equals(logBranch.getBrtp())) {
			if (StringUtils.isEmpty(strBrNo)) {	
				strBrNo = "";
			}
		} else {
			if (!StringUtils.isEmpty(strBrNo)) {
				if (!strBrNo.equals(brNo)) {
					throw new ApIllegalParamException("不能查询非本机构柜员");
				}
			}
			strBrNo = brNo;
		}
		
		Map<String, Object> result = new HashMap<>() ;
		IPage<Map<String,Object>> pageInfo  = tellerMutiDao.selectTelManTraSeri(pageFlag, maxNum, bgDate, edDate, bgSerialNo, edSerialNo, strTellerNo, strBrNo, myBank);
		result.put("rowcnt", pageInfo.getTotal());// 总笔数
		result.put("listnm", pageInfo.getSize());// 返回记录数
		result.put("bodrcd_list", pageInfo.getRecords());// 返回数据
		
		return result;
	}
	
	
	/**
	 * 移动营销柜员信息
	 * @param tellerno 柜员号
	 * @param brno 机构号
	 * @return 
	 */
	public Map<String, Object> queryMobTellerInfo(String tellerno, String brno) {
		
		return tellerMutiDao.queryMobTellerInfo(tellerno, brno);
	}
	
	/**
	 * 柜面柜员登录查询
	 * @param tellerno 柜员号
	 * @return 
	 */
	public  Map<String, Object> queryLoginTellerList(String tellerno,String brno) {
		
		return tellerMutiDao.queryLoginTellerList(tellerno,brno);
	}
}
