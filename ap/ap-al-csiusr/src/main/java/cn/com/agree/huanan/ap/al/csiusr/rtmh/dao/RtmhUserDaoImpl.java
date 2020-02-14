package cn.com.agree.huanan.ap.al.csiusr.rtmh.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.csiusr.rtmh.po.UserInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;



/**
 * 用户登录
 */
@Component
public class RtmhUserDaoImpl implements RtmhUserDao{

	public final Logger logger = Logger.getLogger(RtmhUserDaoImpl.class);
	@Autowired OrmOperator  ormOper;
	@Autowired DbOperator dbo;
	
	@Override
	public UserInfo queryUserInfo(String tlid) {
		
		OrmSelecter<UserInfo> ormSelecter = ormOper.getOrmSelecter(UserInfo.class);
		UserInfo userInfo = ormSelecter.where(w -> {
			w.setTlId(tlid);
		}).fetchOne();
		
		return userInfo;
	}

}
