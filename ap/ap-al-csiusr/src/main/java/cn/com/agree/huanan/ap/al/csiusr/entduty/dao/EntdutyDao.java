package cn.com.agree.huanan.ap.al.csiusr.entduty.dao;


import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.entduty.po.Entduty;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

public interface EntdutyDao {

	/**
	 * 根据柜员号查询实体岗
	 * @param tellerNo 柜员号
	 * @param status 岗位状态
	 * @return
	 */
    public List<Entduty> queryEntdutysByTellerNo(String tellerNo,String status);
    
	/**
	 * 根据柜员号查询实体岗
	 * @param tellerNo
	 * @param brno
	 * @return
	 */
    public Entduty queryEntdutyByCond(String tellerNo,String brno);
    
    /**
     * 根据机构号查询实体岗
     * @param brNo 操作机构
     * @param status 岗位状态
     * @return
     */
    public List<Entduty> queryEntdutyBybrNo(String brNo, String status);
    
    /**
     * 根据实体岗号查询实体岗
     * @param entdutyNo
     * @return
     */
    public Entduty queryEntdutyByEntdutyNo(String entdutyNo);
    
    /**
     * 更新实体岗(上岗撤岗)
     * @param entduty
     * @return
     */
    public int updateEntduty(String entdutyNo, Map<String, Object> map);
    
 

	/**
	 * @summary 实体岗新增
	 * @param entdutyMap
	 * @return
	 */
	public int insertEntduty(Entduty entdutyMap);
	
	/**
	 * 
	 * @param dutyName	岗位名称
	 * @param substring 机构号后5位
	 */
	public int getMaxEntName(String dutyName, String substring);
	
	/**
	 * @summary 获取本机构岗位编号最大值
	 * @param brno 机构号
	 */
	public String getEntNumber(String brno);

	/**
	 * @summary 实体岗删除
	 * @param entdutyno 实体岗编号
	 * @return
	 */
	public int entdutyDelete(String entdutyno);

	/**
	 * @summary 查询实体岗信息列表
	 * @param pageFlag 当前页
	 * @param maxNum 页大小
	 * @param zoneNo 分行号
	 * @param mBrNo 支行号
	 * @param brNo 网点号
	 * @param userst 在线状态
	 * @param status 状态
	 * @param entdutyNo 实体岗编号
	 * @param myBank 法人号
	 */
	public IPage<Map<String, Object>> FindEntdutyList(String pageFlag, String maxNum, String zoneNo, String mBrNo, String brNo,
			String userst, String status, String entdutyNo, String myBank,String tellerno);


	/**
	 * 根据网点号查询该网点实体岗的岗位数量
	 * @param strbrno 网点号
	 * 
	 */
	public int SelectEntdutyCountByBrno(String strbrno);

	//查询实体岗信息列表
	public int findCountEntduty(String zoneno,String mbrno,String brno,String status);

	/**
	 * 根据柜员号，机构号和状态查询实体岗
	 * @param tellerNo 柜员号
	 * @param brNo 机构号
	 * @param status 岗位状态
	 * @return 实体岗信息
	 */
    public List<Entduty> queryEntdutyByTelNoAndBrNo(String tellerNo, String brNo, String status);
    
    /**
	 * 根据机构号和库管员标签查询实体岗
	 * @param brNo 机构号
	 * @param wareHouserFlg 库管员标签
	 * @return 实体岗信息
	 */
    public Entduty queryEntdutyByBrNoAndWarFlg(String brNo, String wareHouserFlg);
    
    /**
     * 删除机构下属所有岗位信息
     * @param brno 机构号
     * @return
     */
    public int deleteEntdutyInfoByBrno(String brno);
    
    /**
	 * 查询岗位类型是否存在柜员
	 * @param strdutyno 
	 * @return
	 */
	public  List<Entduty>  queryByStrdutyno(String strDutyNo);
}
