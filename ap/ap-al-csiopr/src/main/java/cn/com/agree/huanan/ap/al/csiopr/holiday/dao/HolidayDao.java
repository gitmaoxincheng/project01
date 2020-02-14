package cn.com.agree.huanan.ap.al.csiopr.holiday.dao;

import cn.com.agree.huanan.ap.al.csiopr.holiday.po.Holiday;

public interface HolidayDao {

	/**
	 * 节假日表新增
	 * @param holiday 节假日信息
	 * @return 
	 */
	public int insertHoliday(Holiday holiday);

	/**
	 * 根据日期删除节假日表信息
	 * @param sysDate 日期
	 * @return
	 */
	public int delectHoliday(String upddate);

	/**
	 * 根据日期查询节假日表信息数量
	 * @param sysDate 日期
	 * @return
	 */
	public int queryHoliday(String sysDate);

}
