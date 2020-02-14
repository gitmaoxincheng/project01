package cn.com.agree.huanan.ap.al.csiusr.dutyinfo.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.po.DutyInfo;
import cn.com.agree.huanan.ap.al.csiusr.entduty.po.Entduty;
import cn.com.agree.huanan.ap.tl.db.po.IPage;


public interface DutyinfoDao {

	/**
	 * 根据岗位类型号查询岗位类型
	 * @param dutyNo
	 * @return
	 */
    public DutyInfo queryByDutyNo(String dutyNo);
    
    /**
	 * 根据网点号查询岗位类型
	 * @param brno
	 * @return
	 */
    public List<DutyInfo> queryByBrno(String brno);
    
    /**
   	 * 获取最大前缀码
   	 * @param brno
   	 * @return
   	 */
     public String getMaxNo(String brno);
     
     /**
 	 * 保存岗位类型
 	 * @param dutyInfo
 	 * @return
 	 */
     public int insertDutyInfo(DutyInfo dutyInfo);
     
     /**
	 * 获取最大参数码
     * @param upDutyNo 
	 * @param brno
	 * @return
	 */
     public String getMaxParaCode(String upDutyNo);
      
     /**
      * 新增岗位类型基本信息
      * @param addDutyInfo
      * @return
      */
     public int dutyAdd(DutyInfo addDutyInfo);

    /**
     * 岗位基本信息查询
     * @param pageFlag 当前页
     * @param maxNum 页大小
     * @param strZoneno 分行号
     * @param strDutyno 岗位类型编号
     * @param status 状态
     * @param strupdutyno 上级岗位编号
     * @param myBank 法人号
     * @param branchType 岗位类别
     * @return
     */
	public IPage<Map<String, Object>> getDutyInfoPageList(int pageFlag, int maxNum, String strZoneno, String strDutyno,
			String status, String strupdutyno, String myBank, String branchType);
	
	/**
	 * 更新岗位类型状态
	 * @param dutyNo 岗位类型编号
	 * @param paramMap 修改信息
	 * @return
	 */
	public int updateDutyInfo(String dutyNo, Map<String, Object> paramMap);
	
	/**
	 * @summary 根据岗位类型编号查询岗位名称
	 * @param dutyno
	 * @return
	 */
	public String getEntdutyName(String dutyno);
	
	/**
	 * @summary 是否机构坐班
	 * @param dutyno
	 * @return
	 */
	public boolean isBrnoAdmin(String dutyno);
	
	/**
	 * 查询岗位类型基本信息记录数
	 * @return
	 */
	public long getDutyInfoSum();
	
	/**
	 * 坐班岗位类型查询
	 * @param strbrno 
	 * @return
	 */
	public Map<String, Object> getDutyInfoOnPageList(String strbrno);
}
