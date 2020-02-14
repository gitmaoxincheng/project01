package cn.com.agree.huanan.ap.al.csitrd.base.dao;

import java.util.List;

import cn.com.agree.huanan.ap.al.csitrd.base.po.OccuCode;

/**
 * @author liaowen
 */
public interface OccuCodeDao {

	/**
	 * 查询职业信息
	 * @param upoccucode 父级职业编码 
	 * @param tacode  保险公司代码
	 * @return
	 */
	List<OccuCode> queryOccuCode(String upoccucode, String tacode);

}
