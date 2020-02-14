package cn.com.agree.huanan.ap.al.csitrd.mutitable.service;
/**
 * 单据列表关联查询
 * @author wangbo
 *
 */

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.mutitable.dao.BillMutiDao;
@Service
public class BillMutiService {
	@Autowired
	private BillMutiDao billDao;
	public Map<String, Object> getBillInfoList(Map<String, String> map){
		return billDao.selectTradeBillInfo(map);
	}
}
