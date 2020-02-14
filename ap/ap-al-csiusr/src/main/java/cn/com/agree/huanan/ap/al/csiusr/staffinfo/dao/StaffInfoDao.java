package cn.com.agree.huanan.ap.al.csiusr.staffinfo.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.staffinfo.po.StaffInfo;


/**
 * 行员操作Dao
 * @author lixq
 *
 */
public interface StaffInfoDao {

	/**
	 * 根据柜员号查询行员
	 * @param tellerNo
	 * @return
	 */
    public StaffInfo queryTellerByNo(String tellerNo);
    
	/**
	 * 新增行员信息
	 * @param StaffInfo
	 * @return
	 */
    public int insertStaff(StaffInfo staffInfo); 
    
    /**
     * 更新行员信息
     * @param map
     * @return
     */

	public int updateStaffInfo(Map<String, Object> map);
	
	/**
	 * 更新柜员信息
	 * @param map
	 * @return
	 */
	public int updateTellerInfo(Map<String, Object> map) ;

	/**
	 * 查询[行员信息生成]所需要的字段数据
	 * @return
	 */
	public List<Map<String, Object>> findStaffInfoGenerate();
	
}
