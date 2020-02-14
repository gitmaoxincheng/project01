package cn.com.agree.huanan.ap.al.csitrd.amgt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.amgt.dao.ReferrerMemberDao;
import cn.com.agree.huanan.ap.al.csitrd.amgt.exception.InsertReferrerMemberFailException;
import cn.com.agree.huanan.ap.al.csitrd.amgt.exception.UpdateReferrerMemberFailException;
import cn.com.agree.huanan.ap.al.csitrd.amgt.po.ReferrerMember;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 营销人员推荐人信息表service
 * @author lanshaojun
 *
 */
@Service
public class ReferrerMemberService {
	@Autowired DbOperator dbOperator;
	@Autowired ReferrerMemberDao referrerMemberDao;
	private Logger logger = Logger.getLogger(ReferrerMemberService.class);
	
	/**
	 * 插入营销人员推荐人信息
	 * @param referrerMember 营销人员推荐人信息bean
	 * @return 操作状态
	 */
	public int insertReferrerMember(ReferrerMember referrerMember) {
		int count = referrerMemberDao.insertReferrerMember(referrerMember);
		if(count == 0) {
			dbOperator.rollback();
			logger.error("插入 营销人员推荐人信息失败！");
			throw new InsertReferrerMemberFailException();
		}
		dbOperator.commit();
		return count;
	}
	
	/**
	 * 更新营销人员推荐人信息
	 * @param referrerMember 营销人员推荐人信息bean
	 * @return 操作状态
	 */
	public int updateReferrerMember(ReferrerMember referrerMember) {
		int count = referrerMemberDao.updateReferrerMember(referrerMember);
		if(count == 0) {
			dbOperator.rollback();
			logger.error("更新营销人员推荐人信息失败！");
			throw new UpdateReferrerMemberFailException();
		}
		dbOperator.commit();
		return count;
	}
}
