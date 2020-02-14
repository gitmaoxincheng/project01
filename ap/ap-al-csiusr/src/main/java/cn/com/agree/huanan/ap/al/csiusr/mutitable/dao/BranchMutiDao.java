package cn.com.agree.huanan.ap.al.csiusr.mutitable.dao;

import java.util.Map;

/**
 * 机构模块多表查询
 * @author HCP
 *
 */
public interface BranchMutiDao {

	/**
	 * 未签退查询
	 * @param brNo
	 * @param idxBrno
	 * @param pageSize
	 * @param pageFlag
	 * @return
	 */
	public Map<String, Object> selectBranchExitInfo(String brNo,String idxBrno, int pageSize, int pageFlag);
}
