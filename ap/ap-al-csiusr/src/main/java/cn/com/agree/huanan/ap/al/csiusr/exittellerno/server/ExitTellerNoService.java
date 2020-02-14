package cn.com.agree.huanan.ap.al.csiusr.exittellerno.server;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.branch.dao.BranchDao;
import cn.com.agree.huanan.ap.al.csiusr.branch.po.Branch;
import cn.com.agree.huanan.ap.al.csiusr.exittellerno.dao.ExitTellerNoDao;
import cn.com.agree.huanan.ap.al.csiusr.exittellerno.po.ExitTellerNo;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class ExitTellerNoService {
	@Autowired ExitTellerNoDao exitTellerNoDao;
	@Autowired Logger logger;
	@Autowired DbOperator dbo;
	@Autowired BranchDao branchDao;
	
	//多表查询
	public Map<String, Object> queryExitBrnoInfo(int pageFlag, int pageSize,String tradeDate,String strTellerNo, String brNo) {	
		if (pageSize < 1 || pageFlag < 1) {
			throw new ApIllegalParamException("maxNum/pageFlag 要大于 1");
		}
		
		String myBank = brNo.substring(0, 3);
		Branch logBranch = branchDao.queryBranchByNo(brNo);
		if (null != logBranch && "4".equals(logBranch.getBrtp())) {
			brNo = "";
		}
		IPage<Map<String, Object>> iPage = exitTellerNoDao.selectDutyExittellerno(pageFlag, pageSize, tradeDate, strTellerNo, brNo, myBank);
		Map<String, Object> resultMap = new HashMap<String, Object>();		
		resultMap.put("rowcnt", iPage.getTotal());// 总笔数
		resultMap.put("listnm", iPage.getSize());// 返回记录数
		resultMap.put("bodrcd_list", iPage.getRecords());// 返回数据
		return resultMap;
	}
	
	
	/**
	 * 获取柜员签退信息
	 * @param tradedate
	 * @param strtellerno
	 * @return
	 */ 
	public ExitTellerNo getTodayInfo(String tradedate,String strtellerno,String entdutyNo) {	
		List<ExitTellerNo> exitTellerNoList = exitTellerNoDao.queryExitTellerNoByNo(tradedate, strtellerno, "0005", entdutyNo, "");
		if(null == exitTellerNoList || exitTellerNoList.size() < 1) {
	        return null;
		};
		ExitTellerNo exitTellerNo = exitTellerNoList.get(0);
		if (null == exitTellerNo || StringUtils.isEmpty(exitTellerNo.getStatus()) || "1".equals(exitTellerNo.getStatus())) {
			logger.info("----------查询数据错误----------"+exitTellerNo);
			return null;
		}
		return exitTellerNo;	
	}
	
}
