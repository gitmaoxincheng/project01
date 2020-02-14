package cn.com.agree.huanan.ap.al.csitrd.amgt.dao;

import cn.com.agree.huanan.ap.al.csitrd.amgt.po.ReferrerMember;

/**
 * 营销人员推荐人信息表dao
 * @author lanshaojun
 *
 */
public interface ReferrerMemberDao {

	/**
	 * 插入营销人员推荐人信息
	 * @param referrerMember 营销人员推荐人信息bean
	 * @return 操作状态
	 */
	int insertReferrerMember(ReferrerMember referrerMember);

	/**
	 * 修改营销人员推荐人信息
	 * @param referrerMember 营销人员推荐人信息bean
	 * @return 操作状态
	 */
	int updateReferrerMember(ReferrerMember referrerMember);

}
