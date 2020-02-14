package cn.com.agree.huanan.ap.al.csiopr.service.dao;


import cn.com.agree.huanan.ap.al.csiopr.service.po.ChlService;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChlServiceDaoImpl implements ChlServiceDao {
	@Autowired private  OrmOperator ormOper;

	@Override
	public ChlService selectChlService(String svcCode, String scnCode) {

		OrmSelecter<ChlService> ormSelecter = ormOper.getOrmSelecter(ChlService.class);
		ChlService chlService = ormSelecter.where(w ->{
			w.setSvcCode(svcCode);
			w.setScnCode(scnCode);
		}).fetchOne();
		return chlService;
	}
}
