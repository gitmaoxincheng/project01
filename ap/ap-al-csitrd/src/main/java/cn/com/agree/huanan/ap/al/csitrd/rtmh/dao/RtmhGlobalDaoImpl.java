package cn.com.agree.huanan.ap.al.csitrd.rtmh.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.rtmh.po.RTMHTradInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;



/**
 * 其他P交易流水表Dao层
 * @author xuzhen
 *
 */

@Component
public class RtmhGlobalDaoImpl implements RtmhGlobalDao{

	private static String TABLE="COMP_TRAD_FLOW ";
	public final Logger logger = Logger.getLogger(RtmhGlobalDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	
	
	@Override
	public int insertRtmh(Map<String, Object> rtmhMap) {
		// 向数据库中插入数据
		logger.info("新增其他p交易流水表记录");
		int count = dbo.getInserter().insertInto(TABLE).values(rtmhMap).execute();
		return count;
		
	}

	@Override
	public RTMHTradInfo queryRtmh(String traneDate, String serialNo) {
		// 通过交易日期和交易流水查询账单表记录
		logger.info("查询atm特色p交易流水表记录");
		OrmSelecter<RTMHTradInfo> ormSelecter = ormOper.getOrmSelecter(RTMHTradInfo.class);
		RTMHTradInfo RTMHTradFlow = ormSelecter.where(w->{
			if(!StringUtils.isEmpty(traneDate)) {
				w.setTradeDate(traneDate);
			}
			if(!StringUtils.isEmpty(serialNo)) {
				w.setSerialNo(serialNo);
			}
		}).fetchOne();
		return RTMHTradFlow;
	}

	@Override
	public int updateRtmh(String traneDate, String serialNo, Map<String, Object> rtmhTran) {		
		// 根据交易日期和交易流水更新账单记录
		logger.info("更新atm特色p交易流水表");
		int count = dbo.getUpdater().update(TABLE).where(w->{
			if(!StringUtils.isEmpty(traneDate)&&!"".equals(traneDate)) {
				w.eq("traneDate", traneDate);
			}
			if(!StringUtils.isEmpty(serialNo)&&!"".equals(serialNo)) {
				w.eq("serialNo", serialNo);
			}
		}).set(rtmhTran).execute();
		return count;
		
	}

}
