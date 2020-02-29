package cn.com.agree.huanan.ap.rl.bank.base.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.rl.bank.base.dao.SysParaDao;
import cn.com.agree.huanan.ap.rl.bank.base.po.Syspara;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApUpdateFailException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 柜员服务层
 * @author lixq
 */
@Service
public class SysparaService {

	@Autowired SysParaDao sysParaDao;
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
    
	/**
	 * 查询参数列表
	 * @param tellerNo
	 * @return
	 */
	public List<Syspara> queryByItem(String queryByItem) {
		return sysParaDao.queryByItem(queryByItem);
	}
	/**
	 * 卡种校验
	 * @param queryByItem
	 * @return
	 */
	public Map<String, String> acctCheckRust(String queryByItem,String acctno) {
		
		Map<String, String> acctCheckRust = new HashMap<>();
		
		String acctFlag = "";
		
		List<Syspara> list = sysParaDao.queryByItem(queryByItem);
		boolean isFind = false;
		for (Syspara syspara : list) {
			
			if(syspara.getParaCode().equals(acctno.substring(0, 6))) {
				isFind = true;
				acctFlag = syspara.getParaValue1();
				break;
			}
			
		}
		if (!isFind) {
			acctFlag = "99";
		}


		acctCheckRust.put("acct_flag",acctFlag);
		
		return acctCheckRust;
	}
	

	/**
	 * 查询参数列表
	 * @param paraItem
	 * @param paraCode
	 * @return
	 */
	public List<Syspara> queryList(String paraItem,String paraCode) {
		return sysParaDao.queryList(paraItem,paraCode);
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	public int updateInfo(Map<String, Object> map) {
		int count = sysParaDao.updateInfo(map);
		if (0 == count) {
			logger.error("更新失败");
			dbo.rollback();
			throw new ApUpdateFailException("参数信息");
		}
		dbo.commit();
		
		return count;
	}
	
}
