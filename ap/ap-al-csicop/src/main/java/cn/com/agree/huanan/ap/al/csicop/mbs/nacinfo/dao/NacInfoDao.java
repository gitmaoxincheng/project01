package cn.com.agree.huanan.ap.al.csicop.mbs.nacinfo.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csicop.mbs.nacinfo.po.NacInfo;

/**
 * 网申信用卡信息表dao
 * 
 * @author guyulong
 */
public interface NacInfoDao {

	/**
	 * 新增网申办卡信息
	 * 
	 * @param nacInfo
	 *            办卡信息
	 * @return
	 */
	int insertNacInfo(Map<String, Object> nacInfo);

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
	List<Map<String, Object>> findNacInfo(String name, String idtftp, String idtfno);

	/**
	 * 根据申请编号查询网申进度查询本地数据
	 * 
	 * @param applno
	 *            申请编号
	 * @return
	 */
	Map<String, Object> findNacProgress(String applno);

	/**
	 * 根据流水号+日期 查询信用卡申请信息
	 * 
	 * @param serialno
	 *            流水号
	 * @param tradedate
	 *            交易日期
	 * @return
	 */
	NacInfo findNacInfo(String serialno, String tradedate);

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
	int updateNacInfo(String serialno, String tradedate, Map<String, Object> nacMap);
}
