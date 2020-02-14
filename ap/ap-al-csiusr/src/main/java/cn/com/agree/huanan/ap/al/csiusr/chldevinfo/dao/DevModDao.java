package cn.com.agree.huanan.ap.al.csiusr.chldevinfo.dao;

import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po.DevMod;
public interface DevModDao {

	/**
	* 插入
	* @param devMod
	* @return
	*/
	public int insertDevMod(DevMod devMod);
	   	
	   
	/**
	*  删除
	* @param devtypeno
	* @return
	*/
	public int deleteDevMod(String devtypeno);	

	/**
	 *  删除
	 * @param devtypeno
	 * @param devmodulenum
	 * @return
	 */
	public int deleteDevMod(String devtypeno, String devmodulenum);


}
