package cn.com.agree.huanan.ap.al.csiusr.chldevinfo.dao;

import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po.DevModuleInfo;

public interface DevMoudleInfoDao {

	/**
	 * 根据设备模块id查询设备模块信息表
	 * @param devmodulenum 设备模块id
	 * @return 设备模块信息
	 */
	public DevModuleInfo queryModuleinfoByID(String devmodulenum);

	/**
	 * 新增设备模块信息
	 * @param devModule 设备模块信息
	 * @return 
	 */
	public int addModuleinfo(DevModuleInfo devModule);

	/**
	 * 新增设备模块信息
	 * @param devModule 设备模块信息
	 * @return 
	 */
	public int updataModuleinfo(DevModuleInfo devModule);

	/**
	 * 删除设备模块信息
	 * @param devmodulenum 设备模块id
	 * @return 
	 */
	public int deleteModuleinfo(String devmodulenum);

}
