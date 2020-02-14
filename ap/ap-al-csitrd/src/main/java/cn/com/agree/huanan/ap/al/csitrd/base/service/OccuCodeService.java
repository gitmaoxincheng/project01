package cn.com.agree.huanan.ap.al.csitrd.base.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.base.dao.OccuCodeDao;
import cn.com.agree.huanan.ap.al.csitrd.base.po.OccuCode;

/**
 * 职业信息服务
 * @author liaowen
 */
@Service
public class OccuCodeService {
	@Autowired OccuCodeDao occuCodeDao;
//	private Logger logger = Logger.getLogger(OccuCodeService.class);

	/**
	 * 查询职业信息
	 * @param upoccucode 父级职业编码
	 * @param tacode   保险公司代码
	 * @return
	 */
	public Map<String, Object> queryOccuCodeInfo(String upoccucode, String tacode) {
		
		List<OccuCode> list = occuCodeDao.queryOccuCode(upoccucode,tacode);
		
		Map<String, Object> result = new HashMap<>();
		result.put("listnm", list.size());
		result.put("occu_list", list);
		return result;
	}
	
	

}
