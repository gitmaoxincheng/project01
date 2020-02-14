package cn.com.agree.huanan.ap.al.csiusr.mutitable.dao;

import java.util.List;
import java.util.Map;

/**
 * 设备模块多表查询
 * @author HWW
 *
 */
public interface DevInfoMutiDao {
	/**
	 * 获取设备信息
	 * @param devType 设备类型
	 * @param devip 设备型号
	 * @return 设备信息
	 */
	public Map<String, Object> getDevInfo(String devType, String devip,String devno);
	/**
	 * 根据设备Id查询全部模块
	 * @param devid
	 * @return
	 */
	public List<Map<String,Object>> getModuleInfosByDevid(String devTypeno);
}
