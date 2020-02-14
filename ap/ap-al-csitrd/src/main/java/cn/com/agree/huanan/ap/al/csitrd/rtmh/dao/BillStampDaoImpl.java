package cn.com.agree.huanan.ap.al.csitrd.rtmh.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


import cn.com.agree.huanan.ap.al.csitrd.rtmh.po.RTMHTradInfo;
import cn.com.agree.huanan.ap.al.csitrd.rtmh.po.RTMHTradInfo.COMP_TRAD_FLOW;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class BillStampDaoImpl implements BillStampDao{
	
	private static String TABLE = "COMP_TRAD_FLOW";
	public final Logger logger = Logger.getLogger(BillStampDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	
	
	@Override
	public int insertTrad(Map<String, Object> rtmhtradflowMap) {
		// 向数据库中插入数据
		logger.info("新增其他p流水表用户信息");
		int count = dbo.getInserter().insertInto(TABLE).values(rtmhtradflowMap).execute();
		return count;
	}
	
	
	@Override
	public RTMHTradInfo queryTrad(String serialNo) {
		//根据流水号查询信息
		logger.info("查询登陆账号账单信息！");
		OrmSelecter<RTMHTradInfo> ormSelecter = ormOper.getOrmSelecter(RTMHTradInfo.class);
		RTMHTradInfo rtmhTradInfo = ormSelecter.where(w->{
			if(!StringUtils.isEmpty(serialNo)) {
				w.setSerialNo(serialNo);
			}
		}).fetchOne();
		return rtmhTradInfo;
	}
	

}
