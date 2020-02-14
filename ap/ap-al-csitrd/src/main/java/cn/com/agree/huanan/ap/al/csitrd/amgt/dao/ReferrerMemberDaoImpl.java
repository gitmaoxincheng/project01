package cn.com.agree.huanan.ap.al.csitrd.amgt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.amgt.po.ReferrerMember;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 营销人员推荐人信息表dao实现类
 * @author lanshaojun
 *
 */
@Component
public class ReferrerMemberDaoImpl implements ReferrerMemberDao{
	private static String TABLE = "TRADEINFO_REFERRER";
	
	@Autowired DbOperator dbOperator;
	public final Logger logger = Logger.getLogger(ReferrerMemberDaoImpl.class);
	
	@Override
	public int insertReferrerMember(ReferrerMember referrerMember) {
		int count = dbOperator.getInserter().insertInto(TABLE).values(ReferrerMember.getMap(referrerMember)).execute();
		return count;	
	}

	@Override
	public int updateReferrerMember(ReferrerMember referrerMember) {
		if(!StringUtils.isEmpty(referrerMember.getSerialNo())) {
			logger.error("营销人员推荐人信息更新传入参数为空：serialNo");
		}
		int count = dbOperator.getUpdater().update(TABLE).where(w->{
				w.eq("SERIALNO", referrerMember.getSerialNo());
		}).set(ReferrerMember.getMap(referrerMember)).execute();
		return count;	
	}
}
