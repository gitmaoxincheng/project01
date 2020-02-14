package cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.po.ExitCtrlDtsy;

public interface ExitCtrlDtsyDao {

	/**
	 * 查询岗位受控系统
	 * @param dutyNo
	 * @param status
	 * @return
	 */
	public ExitCtrlDtsy queryByNoAndStatus(String dutyNo, String status);
	
	
	/**
     * 多表查询，岗位签退查询
     * @param pageFlag 当前页
     * @param pageSize 页大小
     * @param strdutyno 岗位类型
     * @param myBank 法人号
     * @return
     */
    public Map<String, Object> selectExitCtrlDtsy(int pageFlag, int pageSize, String strdutyno, String myBank);
    
    /**
     * 增加
     * @param exitCtrlDtsy
     * @return
     */
    public int insertExitCtrlDtsy(ExitCtrlDtsy exitCtrlDtsy);
    
    /**
     * 修改
     * @param strdutyno
     * @param map
     * @return
     */
    public int updateExitCtrlDtsy(String strdutyno, Map<String, Object> map);
    
    /**
     * 查询受控表
     * @param strdutyno
     * @return
     */
    public ExitCtrlDtsy selectExitCtrlDtsy(String strdutyno);

}
