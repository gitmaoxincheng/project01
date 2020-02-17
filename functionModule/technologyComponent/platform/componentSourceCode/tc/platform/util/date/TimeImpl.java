package tc.platform.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cn.com.agree.afa.svc.javaengine.AppLogger;
import tc.platform.constant.exception.CommonErrorCodeEnum;
import tc.platform.context.exception.BaseException;

public class TimeImpl {
	/**
	 * 
	 * @param srctime 源时间(YYYYMMDDHHMMSSxxx,支持8位,14位和20位日期格式)
	 * @param addtime 累加的时间
	 * @param timeunit 时间单位(seconds/minutes/hours/days)
	 * @return
	 * @throws Exception
	 */
	public static String formatCalculateTime(String srctime, long addtime,
			String timeunit) throws BaseException {

		String calsrctime = srctime;
		if (srctime.length() == 8) {
			calsrctime = srctime + "000000";
		} else if (srctime.length() == 20) {
			calsrctime = srctime.substring(0, 14);
		} else if (srctime.length() != 14) {
			throw new BaseException(CommonErrorCodeEnum.FMT_TIME_EXCEPTION, "不支持的时间格式[" + srctime + "]");
		}
		DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date srcDate;
		try {
			srcDate = sdf.parse(calsrctime);
		} catch (ParseException e) {
			AppLogger.error(e);
			throw new BaseException(CommonErrorCodeEnum.FMT_TIME_EXCEPTION, e.getMessage());
		}
		long diff = srcDate.getTime();
		long time_dif = 0;
		if (timeunit.equals("seconds")) {
			time_dif = addtime * 1000 + diff;
		} else if (timeunit.equals("minutes")) {
			time_dif = addtime * 60 * 1000 + diff;
		} else if (timeunit.equals("hours")) {
			time_dif = addtime * 60 * 60 * 1000 + diff;
		} else if (timeunit.equals("days")) {
			time_dif = addtime * 24 * 60 * 60 * 1000 + diff;
		} else {

			AppLogger.error("不支持的时间单位[" + timeunit + "]");
			throw new BaseException(CommonErrorCodeEnum.FMT_TIME_EXCEPTION, "不支持的时间单位[" + timeunit + "]");
		}
		String result = null;
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time_dif);
		if (srctime.length() == 8) {
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			result = df.format(cal.getTime());
		} else if (srctime.length() == 20) {
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			result = df.format(cal.getTime()) + srctime.substring(14);
		} else {
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			result = df.format(cal.getTime());
		}
		
		return result;
	}
}
