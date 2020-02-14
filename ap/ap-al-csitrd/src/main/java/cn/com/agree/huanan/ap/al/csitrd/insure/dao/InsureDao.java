package cn.com.agree.huanan.ap.al.csitrd.insure.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.insure.po.Insure;

/**
 * 
 * @author jiangzf
 */

public interface InsureDao {
	/**
	 * 新增一条贵金属相关记录
	 * @param nbnt
	 */
	public int addInsure(Insure insure);

	/**
	 * 修改一条贵金属相关记录
	 * @param nbnt
	 */
	public int editInsure(Map<String,Object> insure);
}
