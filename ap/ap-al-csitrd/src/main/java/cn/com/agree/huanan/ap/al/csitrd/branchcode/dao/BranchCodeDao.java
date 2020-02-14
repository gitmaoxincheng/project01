package cn.com.agree.huanan.ap.al.csitrd.branchcode.dao;

import cn.com.agree.huanan.ap.al.csitrd.branchcode.po.BranchCode;

/**
 * 机构身份识别码表dao
 * @author lanshaojun
 *
 */
public interface BranchCodeDao {
	
	/**
	 * 查询机构身份识别码记录
	 * @param strbranch 网点号
	 * @return 机构身份识别码记录
	 *
	 */
	public BranchCode getBranchCode(String strbranch);

	/**
	 * 插入机构身份识别码数据
	 * @param branchCode 机构身份识别码
	 * @return 成功执行的操作数
	 *
	 */
	public int insertBranchCode(BranchCode branchCode);

	/**
	 * 删除机构身份识别码数据
	 * @param branchCode 机构身份识别码
	 * @return 成功执行的操作数
	 *
	 */
	public int deleteBranchCode(BranchCode branchCode);

	/**
	 * 更新机构身份识别码数据
	 * @param branchCode 机构身份识别码
	 * @return 成功执行的操作数
	 *
	 */
	public int updateBranchCode(BranchCode branchCode);

}
