package cn.com.agree.huanan.ap.al.csiusr.rtmh.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.rtmh.po.DevcInfo;
import cn.com.agree.huanan.ap.al.csiusr.rtmh.po.UserInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;


/**
 * 获取设备信息
 */
@Component
public class UserRegisterDaoImpl implements UserRegisterDao{

	private static String TABLE  = "csis_channel_devinfo";
	public final Logger logger = Logger.getLogger(UserRegisterDaoImpl.class);
	@Autowired OrmOperator  ormOper;
	@Autowired DbOperator dbo;
	
	//查询
	@Override
	public DevcInfo selectDevcInfo(String devno,String applyid,String admbrno) {
		OrmSelecter<DevcInfo> ormSelecter = ormOper.getOrmSelecter(DevcInfo.class);
		DevcInfo devcInfo = ormSelecter.where(w -> {
			w.setDevNo(devno);
		}).fetchOne();
		return devcInfo;
	}

	//更新
	@Override
	public DevcInfo updateInfo(String devno, String applyid, String pinkey, String status) {
		OrmSelecter<DevcInfo> ormSelecter = ormOper.getOrmSelecter(DevcInfo.class);
		DevcInfo devcInfo = ormSelecter.where(w -> {
			w.setDevNo(devno);
			w.setApplyId(applyid);
			w.setPinKey(pinkey);
			w.setStatus(status);
		}).fetchOne();
		return devcInfo;
	}
	
	
	//更新认证码
	@Override
	public int updateDevcAuthcode(Map<String, Object> devcInfo) {
		//更新数据
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("devNo", devcInfo.get("devNo"));
			}).set("authCode", devcInfo.get("authCode")).execute();
		return count;
	}
	
	
	//根据设备号修改设备信息
	@Override
	public int updateDevcInfoNo(Map<String, Object> devcInfo) {
		if (StringUtils.isEmpty(devcInfo.get("devNo"))) {
			throw new ApIllegalParamException("devNo");	
		}
		//修改数据
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("devNo", devcInfo.get("devNo"));
			}).set(devcInfo).execute();
		return count;
	}
	
	//查询设备号
	@Override
	public DevcInfo updateDevno(String devno) {
		OrmSelecter<DevcInfo> ormSelecter = ormOper.getOrmSelecter(DevcInfo.class);
		DevcInfo devcInfo = ormSelecter.where(w -> {
			w.setDevNo(devno);
		}).fetchOne();
		return devcInfo;
	}

}
