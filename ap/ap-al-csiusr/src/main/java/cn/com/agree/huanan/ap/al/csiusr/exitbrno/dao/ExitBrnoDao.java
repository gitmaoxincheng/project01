package cn.com.agree.huanan.ap.al.csiusr.exitbrno.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.exitbrno.po.ExitBrno;

public interface ExitBrnoDao {
	
	/**
	 * 查询列表
	 * @param tradeDate
	 * @param brno
	 * @return
	 */
	public List<ExitBrno> queryExitBrNoByDate(String tradeDate,String brno);
	
	/**
	 * 更新信息
	 * @param paramMap
	 * @return
	 */
	public int updateInfo(ExitBrno exitBrno);
	
	/**
	 * 更新机构受控系统信息
	 * @param strBrNo 机构号
	 * @param tradeDate 受控日期
	 * @param sysId 受控系统
	 * @param paramMap 更改信息
	 * @return
	 */
	public int updateExitBrNoInfo(String strBrNo, String tradeDate, String sysId, Map<String, Object> paramMap);
	
   /**
 	 * 保存信息
 	 * @param exitTellerNo
 	 * @return
 	 */
     public int insertExitBrnoInfo(ExitBrno exitBrno);
     
     /**
      * 查询列表
      * @param brNo
      * @param pageSize
      * @param pageFlag
      * @param logBrNo
      * @return
      */
     public Map<String, Object> selectBranchExitInfo( String brNo,int pageSize, int pageFlag, String logBrNo);

}
