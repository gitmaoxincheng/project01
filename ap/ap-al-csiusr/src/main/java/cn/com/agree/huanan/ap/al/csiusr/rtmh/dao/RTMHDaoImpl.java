package cn.com.agree.huanan.ap.al.csiusr.rtmh.dao;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import cn.com.agree.huanan.ap.al.csiusr.rtmh.po.RTMHTradInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

public class RTMHDaoImpl implements RTMHDao{
	
	
	private static String TABLE="COMP_TRAD_FLOW";
	private final Logger logger=Logger.getLogger(RTMHDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	
	@Override
	public int insertRTMH(Map<String, Object> rtmhMap) {
		//向数据库中插入数据
		logger.info("新增其他P交易流水表");
		int count=dbo.getInserter().insertInto(TABLE).values(rtmhMap).execute();
		return count;
	}

	
	@Override
	public RTMHTradInfo query(String tradeDate, String serialNo) {
		//通过交易日期和交易流水查询交易表记录
		logger.info("查询其他特色P交易流水表记录");
		OrmSelecter<RTMHTradInfo> ormselecter=ormOper.getOrmSelecter(RTMHTradInfo.class);
		RTMHTradInfo rtmhTradInfo=ormselecter.where(w->{
			if(!StringUtils.isEmpty(tradeDate)) {
				w.setTradeDate(tradeDate);
			}
			if(!StringUtils.isEmpty(serialNo)) {
				w.setSerialNo(serialNo);
			}
		}).fetchOne();
		return rtmhTradInfo;
	}
	
	@Override
	public int updateTtmhTrad(String tradeDate, String serialNo, Map<String, Object> rtmhTrad) {
		//根据交易日期和交易流水更新交易记录
		logger.info("更新其他特色P交易流水表");
		int count=dbo.getUpdater().update(TABLE).where(w->{
			if(!StringUtils.isEmpty(tradeDate)&&!"".equals(tradeDate)){
			w.eq("tradeDate",tradeDate);
		}
			
			if(!StringUtils.isEmpty(serialNo)&&!"".equals(serialNo)){
				w.eq("serialNo",serialNo);
			}
		}).set(rtmhTrad).execute();
		
		return count;
	}

	

	//更新数据
	public int updateTradinfo(Map<String, Object> paramMap) {
		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}
		
		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("tradeDate", paramMap.get("tradeDate"));
			w.eq("serialNo", paramMap.get("serialNo"));
		}).set(paramMap).execute();
		return count;
	}
	
	
	
	@Override
	public List<RTMHTradInfo> queryListUserByNo(String userCode, String userno){
		OrmSelecter<RTMHTradInfo> ormSelecter = ormOper.getOrmSelecter(RTMHTradInfo.class);
		List<RTMHTradInfo> list = ormSelecter.where( w ->{
			w.setSerialNo(userCode);
			if(!StringUtils.isEmpty(userno)) {
				w.setBrNo(userno);
			}
		}).fetchAll();		
		return null;
		
	}

}
