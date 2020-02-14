package cn.com.agree.huanan.ap.al.csiusr.exittellerno.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.exittellerno.po.ExitTellerNo;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

public interface ExitTellerNoDao {

	/**
	 * 根据联合主键查询
	 * @param tradeDate 日期
	 * @param tellerNo 柜员号
	 * @param sysId 日终受控系统
	 * @param entdutyNo 实体岗
	 * @param status 日终状态
	 * @return
	 */
	
	public List<ExitTellerNo> queryExitTellerNoByNo(String tradeDate, String tellerNo, String sysId, String entdutyNo, String status);
	
	/**
	 * 删除信息
	 * @param tradeDate
	 * @param tellerNo
	 * @param strbrno
	 * @return
	 */
	public int deleteByNoAndDate(String tradeDate, String tellerNo,String strbrno);
	
   /**
 	 * 保存信息
 	 * @param exitTellerNo
 	 * @return
 	 */
     public int insertExitTellerInfo(ExitTellerNo exitTellerNo);
     
     /**
 	 * 根据联合主键查询
 	 * @param tradeDate
 	 * @param tellerNo
 	 * @param sysId
 	 * @return
 	 */
 	public List<ExitTellerNo> queryExitTellerInfo(String tradeDate, String tellerNo, String status);
 	
 	
 	 /**
 	 * 更新信息
 	 * @param strTellerNo 柜员号
 	 * @param strBrNo 机构号
 	 * @param tradeDate 受控日期
 	 * @param sysId 受控系统
 	 * @param paramMap 修改信息
 	 * @return
 	 */
     public int updateExitTellerInfo(String strTellerNo, String strBrNo, String tradeDate, String sysId, Map<String, Object> paramMap);
     
     /**
      * 多表查询，柜员受控系统
      * @param pageFlag 当前页
      * @param pageSize 页大小
      * @param tradeDate 受控日期
      * @param strTellerNo 查询柜员号
      * @param brNo 登录机构号
      * @param myBank 法人号
      * @return
      */
     public IPage<Map<String, Object>> selectDutyExittellerno(int pageFlag, int pageSize,String tradeDate,String strTellerNo, String brNo, String myBank);
     
     /**
 	 * 查询信息
 	 * @param tradeDate
 	 * @param tellerNo
 	 * @return
 	 */
 	public List<ExitTellerNo> queryInfoByBrno(String tradeDate, String brno);
 	
 	/**
 	 * 查询信息
 	 * @param tradeDate
 	 * @param tellerNo
 	 * @param status
 	 * @return
 	 */
 	public List<ExitTellerNo> queryInfoByBrnoAndStatus(String tradeDate, String brno, String status);
     
 	/**
 	 * 查询信息
 	 * @param tradeDate
 	 * @param tellerNo
 	 * @param brno
 	 * @return
 	 */
 	public List<ExitTellerNo> queryInfoByDateTellerBrno(String tradeDate, String tellerNo, String brno); 
}
