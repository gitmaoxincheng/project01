package cn.com.agree.huanan.ap.al.csitrd.base.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.csitrd.base.po.OccuCode;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class OccuCodeDaoImpl implements OccuCodeDao {
	@Autowired DbOperator dbo;
	@Autowired OrmOperator ormOper;
	//private static String TABLE = "TRADEINFO_OCCU_CODE";
	public final Logger logger = Logger.getLogger(OccuCodeDaoImpl.class);

	@Override
	public List<OccuCode> queryOccuCode(String upoccucode, String tacode) {
		List<OccuCode> list = ormOper.getOrmSelecter(OccuCode.class).where(w -> {
			w.setUpoccucode(upoccucode);
			w.setTacode(tacode);
		}).fetchAll();

		return list;
	}

}
