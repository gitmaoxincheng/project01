package cn.com.agree.huanan.ap.al.csiusr.mutitable.dao;

import java.util.List;
import java.util.Map;

/**
 * 机构模块多表查询
 * @author HWW
 *
 */
public interface EntdutyMutiDao {

	/**
	 * 机构岗位使用情况查询(查询在实体岗人数)
	 * @param pageFlag 页码
	 * @param maxNum 每页最多记录数
	 * @param strZoneNo 分行号
	 * @param strMBrNo 支行号
	 * @param strBrNo 网点号
	 * @param strDutyNo 岗位类型编号
	 */
	public List<Map<String, Object>> getUsnumbList(int pageFlag, int maxNum, String strZoneNo, String strMBrNo, String strBrNo,String strDutyNo);
	
	/**
	 * 机构岗位使用情况查询(实体岗数量)
	 * @param pageFlag 页码
	 * @param maxNum 每页最多记录数
	 * @param strZoneNo 分行号
	 * @param strMBrNo 支行号
	 * @param strBrNo 网点号
	 * @param strDutyNo 岗位类型编号
	 */
	public List<Map<String, Object>> getEntdutynumList(int pageFlag, int maxNum, String strZoneNo, String strMBrNo, String strBrNo,String strDutyNo);
	
	/**
	 * 柜员签退受控系统查询(登录岗位是否签退)
	 * @param tradeDate 受控日期
	 * @param tellerNo 柜员号
	 * @param brNo 机构号
	 * @param status 状态 0-已完成,1-未完成
	 * @return
	 */
	public List<Map<String, Object>> getExitTellerNoList(String tradeDate, String tellerNo, String brNo, String status);

	/**
	 * 
	 * @param strDate 签退日期
	 * @param strTellerNo 签退柜员
	 * @param strBrNo 签退机构
	 * @param status 签退状态
	 * @return
	 */
	public List<Map<String, Object>> getExitTellerBrNoList(String strDate, String strTellerNo, String strBrNo, String status);
}
