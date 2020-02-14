package cn.com.agree.huanan.ap.al.csiopr.holiday.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.csiopr.holiday.po.Holiday;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

@Component
public class HolidayDaoImpl implements HolidayDao {
	private static String TABLE1 = "csis_holiday";
	@Autowired DbOperator dbo;
	
	//新增节假日表
	@Override
	public int insertHoliday(Holiday holiday) {
		return dbo.getInserter().insertInto(TABLE1).values(Holiday.getMap(holiday)).execute();
	}

	//根据日期删除节假日表信息
	@Override
	public int delectHoliday(String upddate) {
		return dbo.getDeleter().deleteFrom(TABLE1).where(w -> {
			w.op("UPDDATE", ">=", upddate);
		}).execute();
	}

	//根据日期查询节假日表信息数量
	@Override
	public int queryHoliday(String upddate) {
		return (int)dbo.getSelecter().from(TABLE1).where(w -> {
			w.op("UPDDATE", ">=", upddate);
		}).count();
	}

}
