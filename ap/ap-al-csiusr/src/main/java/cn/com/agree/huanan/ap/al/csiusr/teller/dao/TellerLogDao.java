package cn.com.agree.huanan.ap.al.csiusr.teller.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerLog;



/**
 * 柜员操作流水Dao
 * @author HWW
 *
 */
public interface TellerLogDao {

	/**
	 * 根据柜员号和操作日期查询柜员操作流水
	 * @param tellerNo
	 * @return
	 */
    public List<TellerLog> queryTLByTelNoAndODate(String tellerNo, String optDate);
    
    /**
     * 根据变动柜员号和交易结果查询柜员操作流水
     * @param tellerNo
     * @param transStatus
     * @return
     */
    public List<TellerLog> queryTLByChaTelNoAndSta(String tellerNo, String transStatus);

    /**
     * 插入柜员操作流水记录
     * @param tellerLog
     * @return
     */
	public int insertTellerLog(TellerLog tellerLog);
	
	
	/**
	 * 查询交易结果
	 * @param optdate
	 * @param serialno
	 * @return
	 */
	public TellerLog selectTellerLog(String optdate,String serialno );
	

	/**
	 * 删除 柜员操作流水记录
	 * @param serialNo
	 * @param optDate
	 * @return
	 */
	public int deleteTellerLogByNo(String serialNo, String optDate);
	
	/**
	 * 根据请求方日期，请求方流水和应用系统标识查询柜员操作流水
	 * @param srcDate 请求方日期
	 * @param reqNo 请求方流水
	 * @param sysId 应用系统标识
	 * @return
	 */
	public TellerLog queryByOri(String srcDate, String reqNo, String sysId);
	
	/**
	 * 登记操作流水
	 * @param map
	 * @return
	 */
	public int serialnoRegister(Map<String, Object> map);

	/**
	 * 更新操作流水
	 * @param serialNo
	 * @param optDate
	 * @param map
	 * @return
	 */
	public int updateTellerLogMap(String serialNo, String optDate, Map<String, Object> map);
	/**
	 * 查询柜员流水信息
	 * @param SvrCode 内部服务码
	 * @param tellerno	调出柜员号
	 * @param status	状态
	 * @param brNo       操作机构
	 * @param opttellerNo  操作柜员
	 */
	public  List<TellerLog> selectInfo(String SvrCode, String tellerno, String status, String opttellerNo, String brNo);
	
	/**
	 * 修改交易状态
	 * @param transStatus 交易状态
	 * @param serialNo 流水号
	 * @param optDate 交易日期 
	 * @return
	 */
	public int updateTellerStatus(String transStatus, String serialNo, String optDate);

	/**
	 * 查询当天所有柜员调出预处理记录
	 * @param svrCode 应用码
	 * @param transStatus 交易状态
	 * @return
	 */ 
	public List<TellerLog> selectCurrTellerLog(String svrCode, String transStatus);

	/**
	 * 检查柜员操作流水时间
	 * @param strTellerNo 柜员号
	 * @param strBrNo 网点号
	 * @param svrCode 应用码
	 * @param optDate 操作日期
	 * @return
	 */
	public Map<String, Object> checkTellerLogTime(String strTellerNo, String strBrNo, String svrCode, String optDate);

	
}
