package cn.com.agree.huanan.ap.al.csitrd.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.csitrd.base.po.AreaCode;
import cn.com.agree.huanan.ap.al.csitrd.base.po.OccuCode;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;


@Component
public class AreaCodeDaoImpl implements AreaCodeDao {
	@Autowired DbOperator dbo;
	@Autowired OrmOperator ormOper;
	private static String TABLE = "TRADEINFO_AREA_CODE";
	
	
	@Override
	public List<Map<String, Object>> queryAreaCode(String querycont ,String query) {
		List<Map<String, Object>> fetchAll = null;
		
		if(query.equals("0")) {
			fetchAll = dbo.getSelecter().select("AREACODE as areacode", "AREANAME as areaname").from(TABLE).where(w -> {
				w.op("AREACODE", "like", "%0000");
			}).fetchAll();
		}
		if(query.equals("1")) {
			fetchAll = dbo.getSelecter().select("AREACODE as areacode", "AREANAME as areaname").from(TABLE).where(w -> {
				w.between("AREACODE", querycont, querycont.replace("0000", "9900"));
				w.op("AREACODE", "like", "%00");
				w.op("AREACODE","not like", querycont);
			}).fetchAll();
		}
		if(query.equals("2")) {
			fetchAll = dbo.getSelecter().select("AREACODE as areacode", "AREANAME as areaname").from(TABLE).where(w -> {
				w.between("AREACODE", querycont, new StringBuffer(querycont).replace(4, 6,"99").toString());
				w.op("AREACODE","not like", querycont);
			}).fetchAll();
		}
		
		return fetchAll;
		
	}

    //查询所有行政区域代码数据
	@Override
	public List<AreaCode> queryAreaCodeAll() {
		List<AreaCode> result = ormOper.getOrmSelecter(AreaCode.class).fetchAll();
		return result;
	}

}
