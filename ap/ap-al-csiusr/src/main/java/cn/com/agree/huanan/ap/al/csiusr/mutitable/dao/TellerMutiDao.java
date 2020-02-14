package cn.com.agree.huanan.ap.al.csiusr.mutitable.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.po.IPage;
/**
 * 柜员模块多表查询
 * @author HCP
 *
 */
public interface TellerMutiDao {
	
	/**
	 * 柜员信息查询
	 * @param tellerNo 柜员号
	 * @param tellerType 柜员类型
	 * @param name 柜员名称
	 * @param brNo 网点号
	 * @param pageSize 页大小
	 * @param pageFlag 当前页
	 * @param devtype 设备类型
	 * @param myBank 法人号
	 * @param userst 在线状态
	 * @return
	 */
	public Map<String, Object> selectTellerDutyInfo(String tellerNo, String tellerType, String name, String brNo, int pageSize,
			int pageFlag, String devtype, String myBank, String userst);

	/**
	 * 柜员信息及认证方式查询
	 * @param tellerNo
	 * @return
	 */
	public Map<String, Object> selectTellerByTellerNo(String tellerNo);

	
    /**
     * 柜员信息变动记录查询
     * @param pageFlag 页码
	 * @param maxNum 每页最多记录数
	 * @param bgDate 起始日期
	 * @param edDate 截止日期
	 * @param strTellerNo 柜员号
	 * @param transStatus 状态
	 * @param brNo 当前机构号
	 * @param myBank 法人号
     * @return 柜员信息变动记录
     */
	public IPage<Map<String,Object>> selectTelrChaRecs(int pageFlag, int maxNum, String bgDate, String edDate,
			String strTellerNo, String transStatus, String brNo, String myBank);
	
	/**
	 * 柜员管理交易流水查询
	  * @param pageFlag 页码
	 * @param maxNum 每页最多记录数
	 * @param bgDate 起始日期
	 * @param edDate 截止日期
	 * @param bgSerialNo 起始流水
	 * @param edSerialNo 结束流水
	 * @param strTellerNo 柜员号
	 * @param strtBrNo 机构号
	 * @param brNo 登录机构
	 * @param myBank 法人号
	 * @return 柜员管理交易流水
	 */
	public IPage<Map<String,Object>> selectTelManTraSeri(int pageFlag, int maxNum, String bgDate, String edDate,
			String bgSerialNo, String edSerialNo, String strTellerNo,String brNo, String myBank);
	
	/**
	 * 移动营销柜员信息
	 * @param tellerno 柜员号
	 * @param brno 机构号
	 * @return 
	 */
	public Map<String, Object> queryMobTellerInfo(String tellerno, String brno);
	
	/**
	 * 柜面柜员登录查询
	 * @param tellerno 柜员号
	 * @return 
	 */
	public Map<String, Object> queryLoginTellerList(String tellerno, String brno);
	
	/**
	 * 授权柜员查询
	 * @param tradeDate 日期
	 * @param brno 机构号
	 * @param status 状态
	 * @param dutylevel 岗位类型级别
	 * @return
	 */
	public List<Map<String, Object>> queryTellerTypeList(String tradeDate, String brno, String status, String dutylevel);
}
