package cn.com.agree.huanan.ap.al.csicop.mbs.nacinfo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csicop.mbs.exception.InsertException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.SelectException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.UpdateException;
import cn.com.agree.huanan.ap.al.csicop.mbs.nacinfo.dao.NacInfoDao;
import cn.com.agree.huanan.ap.al.csicop.mbs.nacinfo.po.NacInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 网申信用卡信息表service
 * 
 * @author guyulong
 */

@Service
public class NacInfoService {
	@Autowired
	private NacInfoDao nacInfoDao;
	@Autowired
	private Logger logger;
	@Autowired
	private DbOperator dbo;

	/**
	 * 新增网申办卡信息
	 * 
	 * @param nacInfo
	 *            办卡信息
	 * @return
	 */
	public void addNacInfo(Map<String, Object> nacInfo) {
		logger.info("新增网申办卡信息");
		int count = nacInfoDao.insertNacInfo(nacInfo);
		if (count < 1) {
			throw new InsertException("新增网申办卡信息失败");
		}
		dbo.commit();
	}

	/** 信用卡客户申请办理进度查询 */
	public Map<String, Object> findNacApplicationProgress(List<Map<String, Object>> list) {
		logger.info("信用卡客户申请办理进度查询");
		if (list == null) {
			logger.info("查询无记录");
			throw new SelectException("查询无记录");
		}
		int number = list.size();
		for (int i = 0; i < number; i++) {
			String applno = (String) list.get(i).get("appl_no");
			list.get(i).putAll(nacInfoDao.findNacProgress(applno));
		}
		Map<String, Object> map = new HashMap<>();
		map.put("totalnum", number);
		map.put("listnm", number);
		map.put("data_list", list);
		return map;
	}

	/** 网申产品查询 */
	public Map<String, Object> findNacProduct(List<Map<String, Object>> list) {
		logger.info("网申产品查询");
		if (list == null) {
			logger.info("查询无记录");
			throw new SelectException("查询无记录");
		}
		int number = list.size();
		Map<String, Object> map = new HashMap<>();
		map.put("totalnum", number);
		map.put("listnm", number);
		map.put("data_list", list);
		return map;
	}

	/**
	 * 查询网申申请信息
	 * 
	 * @param name
	 *            姓名
	 * @param idtftp
	 *            证件类型
	 * @param idtfno
	 *            证件号码
	 * @return
	 */
	public Map<String, Object> findNacInfo(String name, String idtftp, String idtfno) {
		List<Map<String, Object>> nacList = nacInfoDao.findNacInfo(name, idtftp, idtfno);
		if (nacList == null || nacList.isEmpty()) {
			logger.info("查询无记录");
			throw new SelectException("没有对应的数据");
		}
		int number = nacList.size();
		Map<String, Object> map = new HashMap<>();
		map.put("count", number);
		map.put("data_list", nacList);
		return map;
	}

	/**
	 * 根据流水号+日期 查询信用卡申请信息
	 * 
	 * @param serialno
	 *            流水号
	 * @param tradedate
	 *            交易日期
	 * @return
	 */
	public Map<String, Object> findNacInfo(String serialno, String tradedate) {
		NacInfo nacInfo = nacInfoDao.findNacInfo(serialno, tradedate);
		if (nacInfo == null) {
			logger.info("查询信用卡申请信息失败");
			throw new SelectException("查询无数据");
		}
		return NacInfo.getMap(nacInfo);
	}

	/**
	 * 根据流水号+日期 更新信用卡申请信息
	 * 
	 * @param serialno
	 *            流水号
	 * @param tradedate
	 *            交易日期
	 * @param nacMap
	 *            更新信息
	 * @return
	 */
	public void updateNacInfo(String serialno, String tradedate, Map<String, Object> nacMap) {
		int count = nacInfoDao.updateNacInfo(serialno, tradedate, nacMap);
		if (count != 1) {
			logger.info("更新信用卡申请信息失败");
			dbo.rollback();
			throw new UpdateException();
		}
		dbo.commit();
	}
}
