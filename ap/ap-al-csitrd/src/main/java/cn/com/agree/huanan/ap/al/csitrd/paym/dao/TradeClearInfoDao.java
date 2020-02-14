package cn.com.agree.huanan.ap.al.csitrd.paym.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.paym.po.TradeClearInfo;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
/**
 * 收支清分登记簿Dao
 * @author ZS
 *
 */
public interface TradeClearInfoDao {
	
	/**
	 * 新增收支清分信息
	 * @param signInfo 收支清分信息实体类
	 * @return 
	 */
	int insertTradeClearInfo(TradeClearInfo tradeClearInfo);
	
	/**
	 * 修改收支清分信息
	 * @param map 收支清分信息map
	 * @return
	 */
	int updateTradeClearInfo(Map<String,Object> map);
	
	/**
	 * 修改收支清分的状态
	 * @param errorCode 调用基础服务的返回状态码
	 * @return
	 */
	int updateTradeClearStatus(String status,String tradeDate,String serialNo);
	
	/**
	 * 查询收支清分交易数据信息
	 * @param mdcldt 汇总日期
	 * @param mdclsq 汇总流水
	 * @return
	 */
	Map<String,Object> selectTradeClearInfo(String mdcldt,String coltdate);
	
	/**
	 * 通过汇总日期和汇总流水查询收支清分记录
	 * @return
	 */
	Map<String, Object> selectByDateAndSeri(String coltdate,String coltserialno);
	
	/**
	 * 复核记账存量数据检查查询
	 * @return
	 */
	Map<String, Object> selectDataCheck(String coltdate,String coltserialno);
	
	/**
	 * 通过汇总日期和汇总流水查询复核冲正异常记录
	 * @return
	 */
	Map<String, Object> selectExceptionData(String coltdate,String coltserialno);
	
	/**
	 * 通过日期和流水  进行分页查询
	 * @param strartdate 开始日期
	 * @param enddate  截止日期
	 * @param coltserialno 汇总流水
	 * @param brNo 机构号
	 * @param pageflag 页码
	 * @param maxnum   每页记录数
	 * @return
	 */
	IPage<Map<String,Object>> selectTradeExeception(String strartdate,String enddate,String coltserialno,
			String brNo,Integer pageflag,Integer maxnum);
	
	/**
	 * 根据法人号查询入账内部账户和入账内部账户名称
	 * @return
	 */
	Map<String,Object> queryOutAcctNoAndName(String paracode);
}
