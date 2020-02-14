package cn.com.agree.huanan.ap.al.csitrd.rtmh.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.rtmh.exception.SelectInfoException;
import cn.com.agree.huanan.ap.al.csitrd.rtmh.po.RTMHTradInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

public class RecesiptDaoImpl implements RecesiptDao{

	private static String TABLE = "COMP_TRAD_FLOW";
	public final Logger logger = Logger.getLogger(RecesiptDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	
	@Override
	public String selectRecesipt(String serialNo) {
		if(!StringUtils.isEmpty(serialNo)) {
			throw new SelectInfoException("serialNo");
		}
		OrmSelecter<RTMHTradInfo> ormSelecter = ormOper.getOrmSelecter(RTMHTradInfo.class);
		RTMHTradInfo trmhTradInfo= ormSelecter.where(w ->{
    		w.setSerialNo(serialNo);
    	}).fetchOne();
		String yfk = trmhTradInfo.getGolSeqNo();
		return yfk;
	}

}
