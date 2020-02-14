package cn.com.agree.huanan.ap.al.csitrd.base.dao;

import java.util.List;

import cn.com.agree.huanan.ap.al.csitrd.base.po.CertarCode;

public interface CertarCodeDao {

	/**
	 * 发证机关代码查询
	 * @param certarcode 发证机关代码查询
	 * @param certarname 发证机关名称查询
	 * @return 
	 */
	CertarCode queryCertarCode(String certarcode, String certarname);

	/**
	 * 查询发证机关代码的所有数据
	 * @return
	 */
	List<CertarCode> queryCertarCodeAll();

}
