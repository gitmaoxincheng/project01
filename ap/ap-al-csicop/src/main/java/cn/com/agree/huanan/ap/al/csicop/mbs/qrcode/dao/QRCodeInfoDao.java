package cn.com.agree.huanan.ap.al.csicop.mbs.qrcode.dao;

import java.util.Map;

/**
 * 二维码信息表dao
 * 
 * @author guyulong
 */
public interface QRCodeInfoDao {
	/**
	 * 二维码参数查询
	 * 
	 * @param key
	 *            唯一值 生成二维码时返回的key值
	 * @param funcid
	 *            功能值 由微网点定义的固定值 00000002-企业网银生成二维码
	 * @param patype
	 *            申成方式
	 * @return
	 */
	Map<String, Object> findParamas(String key, String funcid, String patype);

	/**
	 * 二维码信息更新
	 * 
	 * @param serialno
	 *            交易流水号
	 * @param tradedate
	 *            交易日期
	 * @param updateMap
	 *            更新信息
	 * @return
	 */
	int updateQRInfo(String serialno, String tradedate, Map<String, Object> updateMap);

	/**
	 * 二维码信息删除
	 * 
	 * @param serialno
	 *            交易流水号
	 * @param tradedate
	 *            交易日期
	 * @return
	 */
	int deleteQRInfo(String serialno, String tradedate);

	/**
	 * 查询推荐人id
	 * 
	 * @param serialno
	 *            交易流水号
	 * @param tradedate
	 *            交易日期
	 * @return
	 */
	Map<String, Object> findRefid(String serialno, String tradedate);

	/**
	 * 根据paramas查询二维码
	 * 
	 * @param paramas
	 *            二维码参数
	 * @return
	 */
	Map<String, Object> findQRCode(String paramas);

	/**
	 * 根据paramas更新二维码
	 * 
	 * @param paramas
	 *            二维码参数
	 * @param updateMap
	 *            更新信息
	 * @return
	 */
	int updateQRCode(String paramas, Map<String, Object> updateMap);

	/**
	 * 生成二维码
	 * 
	 * @param insertMap
	 *            二维码信息
	 * @return
	 */
	int insertQRCode(Map<String, Object> insertMap);

	/**
	 * 查询二维码
	 * 
	 * @param paramas
	 *            参数
	 * @param patype
	 *            生成方式
	 * @param funcid
	 *            功能id
	 * @return
	 */
	Map<String, Object> findQRCode(String paramas, String patype, String funcid);

	/**
	 * 更新二维码
	 * 
	 * @param paramas
	 *            二维码参数
	 * @param updateMap
	 *            更新信息
	 * @return
	 */
	int updateQRCode(String paramas, String patype, String funcid, Map<String, Object> updateMap);

	/**
	 * 查询二维码
	 * 
	 * @param serialno
	 *            流水号
	 * @param tradedate
	 *            交易日期
	 * @return
	 */
	int findQRCode(String serialno, String tradedate);

	/**
	 * 推荐人信息查询(aweb)
	 * 
	 * @param refid
	 *            推荐人id
	 * @return
	 */
	Map<String, Object> findQRCodeInfo(String refid);
}
