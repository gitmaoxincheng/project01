package cn.com.agree.huanan.ap.al.csiusr.rtmh.dao;

import java.util.Map; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.rtmh.exception.UserLoginException;
import cn.com.agree.huanan.ap.al.csiusr.rtmh.po.RTMHTradInfo;
import cn.com.agree.huanan.ap.tl.db.base.DbConnection;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

public class UserLoginDaoImpl implements UserLoginDao{

	public final Logger logger = Logger.getLogger(UserLoginDaoImpl.class);
	private static String TABLE="COMP_TRAD_FLOW";
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
    @Autowired DbConnection dbcon;
    
	@Override
	public String queryUserNo(String scrSysId) {
		if (StringUtils.isEmpty(scrSysId)) {
			throw new ApIllegalParamException("scrSysId");	
		}
		OrmSelecter<RTMHTradInfo> ormSelecter = ormOper.getOrmSelecter(RTMHTradInfo.class);		
		RTMHTradInfo rtmhTradInfo = ormSelecter.where(w ->{
			w.setScrSysId(scrSysId);
    	}).fetchOne();
		String CalCod = rtmhTradInfo.getReqCalCod();
		logger.info("请求方渠道码获取结束"+CalCod);
		return CalCod;
	}

	//新增签约信息
	@Override
	public int insertUserNo(RTMHTradInfo RtmhInfo) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE).values(RTMHTradInfo.getMap(RtmhInfo)).execute();
		if(count!=1) {
			dbo.rollback();
			throw new UserLoginException("新增失败！");
		}
		dbo.commit();
		return count;
	}

	//新增签约信息
	@Override
	public int updateUserNo(Map<String, Object> map) {
		// 检验参数
		if (null == map.get("tradeDate") || StringUtils.isEmpty(map.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}
		
		if (null == map.get("serialNo") || StringUtils.isEmpty(map.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}		
		//更新数据
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("tradeDate", map.get("tradeDate"));
			w.eq("serialNo", map.get("serialNo"));
			}).set(map).execute();
		return count;
	}
}
