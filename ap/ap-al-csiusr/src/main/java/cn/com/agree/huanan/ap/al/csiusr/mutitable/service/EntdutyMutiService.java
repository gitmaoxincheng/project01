package cn.com.agree.huanan.ap.al.csiusr.mutitable.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.dao.DutyinfoDao;
import cn.com.agree.huanan.ap.al.csiusr.mutitable.dao.EntdutyMutiDao;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class EntdutyMutiService {

	@Autowired EntdutyMutiDao entdutyMutiDao;
	@Autowired DutyinfoDao dutyinfoDao;
	@Autowired Logger logger;

	// 机构岗位使用情况查询
	public Map<String, Object> queryDutyUsage(int pageFlag, int maxNum, String strZoneNo,
			String strMBrNo,String strBrNo, String strDutyNo) {
		if (maxNum < 1 || pageFlag < 1) {
			throw new ApIllegalParamException("maxNum/pageFlag 要大于 1");
		}
		
		// 查询总记录数
		long count = dutyinfoDao.getDutyInfoSum();
		// 在实体岗人数
		List<Map<String, Object>> usnumbList = entdutyMutiDao.getUsnumbList(pageFlag, maxNum, strZoneNo, strMBrNo, strBrNo, strDutyNo);
		// 实体岗数量
		List<Map<String, Object>> entdutynumList = entdutyMutiDao.getEntdutynumList(pageFlag, maxNum, strZoneNo, strMBrNo, strBrNo, strDutyNo);
		
		List<Map<String, Object>> list = new ArrayList<>();
		
		// 拼接list
		for (int i = 0; i < entdutynumList.size(); i++) {
			
			Map<String, Object> tmpMap = new HashMap<>();
			tmpMap.put("strdutyno", entdutynumList.get(i).get("strdutyno"));
			tmpMap.put("dutyname", entdutynumList.get(i).get("dutyname"));
			
			long usnumb = 0;
			long entdutynum = 0;
		
			for (int j = 0; j < usnumbList.size(); j++) {
				if ((entdutynumList.get(i).get("strdutyno")).equals(usnumbList.get(j).get("dutyno"))) {
					// 设置在实体岗人数
					Object cnt1 = usnumbList.get(j).get("usnumb");
			        if (cnt1 instanceof Number) {
			        	usnumb = ((Number) cnt1).longValue();
			        }
			        break;
				}
			}
			// 设置实体岗数量
			Object cnt2 = entdutynumList.get(i).get("entdutynum");
			if (cnt2 instanceof Number) {
	        	entdutynum = ((Number) cnt2).longValue();
	        }
			
			tmpMap.put("usnumb", usnumb);
			tmpMap.put("entdutynum", entdutynum);
			list.add(tmpMap);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("rowcnt", count);
		resultMap.put("listnm", list.size());
		resultMap.put("bodrcd_list", list);
		
		return resultMap;
		
	}
}
