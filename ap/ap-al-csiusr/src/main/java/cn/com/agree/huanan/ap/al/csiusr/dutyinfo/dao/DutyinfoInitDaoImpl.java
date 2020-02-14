package cn.com.agree.huanan.ap.al.csiusr.dutyinfo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.po.DutyInfoInit;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class DutyinfoInitDaoImpl implements DutyinfoInitDao{

	private static String TABLE1="csis_dutyinfo_init";
    public final Logger logger = Logger.getLogger(DutyinfoInitDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
	@Override
	public List<DutyInfoInit> queryList(String bankFlag) {
		
		OrmSelecter<DutyInfoInit> ormSelecter = ormOper.getOrmSelecter(DutyInfoInit.class);
		List<DutyInfoInit> list = ormSelecter.where(w ->{
    		w.setStatus("1");
    		w.setBankFlag(bankFlag);
    	}).fetchAll();
    	return list;
	}
}
