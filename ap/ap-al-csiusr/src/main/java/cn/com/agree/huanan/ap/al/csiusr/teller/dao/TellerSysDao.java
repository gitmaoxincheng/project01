package cn.com.agree.huanan.ap.al.csiusr.teller.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerSys;

/**
 * 柜员注册系统表Dao
 * @author HCP
 *
 */
public interface TellerSysDao {
	/**
	 * 根据柜员号与系统ID查询柜员注册信息
	 * @param tellerNo
	 * @return
	 */
    public TellerSys queryTellerSys(String tellerNo,String sysId);
    
	/**
	 * 新增柜员注册信息
	 * @param tellerInfo
	 * @return
	 */
    public int insertTellerSys(TellerSys tellerSys);
    
    /**
	 * 更新柜员注册信息
	 * @param tellerNo 柜员号
	 * @param sysId 应用系统代码
	 * @param map 更新信息
	 * @return
	 */
	public int updateTellerInfo(String tellerNo, String sysId, Map<String,Object> map);
	
	/**
	 * 查询
	 * @param tellerNo
	 * @return
	 */
	public TellerSys selectTellerSys(String tellerNo);
}
