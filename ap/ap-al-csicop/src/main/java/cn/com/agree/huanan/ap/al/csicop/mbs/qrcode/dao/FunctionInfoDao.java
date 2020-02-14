package cn.com.agree.huanan.ap.al.csicop.mbs.qrcode.dao;

import java.util.Map;

/**
 * 功能表dao
 * 
 * @author guyulong
 */
public interface FunctionInfoDao {
	/**
	 * 根据funcid查询url
	 * 
	 * @param funcid
	 *            功能id
	 * @return
	 */
	Map<String, Object> findUrl(String funcid);
}
