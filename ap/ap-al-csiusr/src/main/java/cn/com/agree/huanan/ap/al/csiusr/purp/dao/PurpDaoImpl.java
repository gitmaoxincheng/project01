package cn.com.agree.huanan.ap.al.csiusr.purp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.csiusr.purp.po.Purp;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

@Component
public class PurpDaoImpl implements PurpDao{
	private static String TABLE="csis_purp";
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	
	@Override
	public int insertPurp(Purp purp) {
		int count = dbo.getInserter().insertInto(TABLE).values(Purp.getMap(purp)).execute();
		return count;
	}

}
