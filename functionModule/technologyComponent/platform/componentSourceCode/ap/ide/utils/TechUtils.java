package ap.ide.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.com.agree.afa.svc.javaengine.AppLogger;
import tc.platform.constant.exception.CommonErrorCodeEnum;
import tc.platform.context.exception.BaseRuntimeException;

public class TechUtils {

	/**
	 * 不确定类型对象返回长度
	 * @param obj
	 * @return
	 */
	public static int len(Object obj) {
		if (obj == null) {
			return 0;
		}
		if (obj instanceof String) {
			return ((String) obj).length();
		}
		if (obj instanceof List) {
			return ((List) obj).size();
		}
		if (obj instanceof Map) {
			return ((Map) obj).size();
		}
		AppLogger.info("不确定类型对象返回长度不在范围{String,List,Map}返回0");
		return 0;
	}
	
	/**
	 * 获取系统日期
	 * 
	 * @return
	 */
	public static String getSysDate() {
		try {
			Date nowTimeDate = new Date(System.currentTimeMillis());
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String workDate = simpleDateFormat.format(nowTimeDate);
			AppLogger.info("[info]-获取系统日期:" + workDate);
			return workDate;
		} catch (Exception e) {
			AppLogger.info("[info]-获取系统日期失败," + e);
			throw new BaseRuntimeException(CommonErrorCodeEnum.GET_SYSTEM_DATE_EXCEPTION);
		}
	}

	/**
	 * 获取系统时间
	 * 
	 * @return
	 */
	public static String getSysTimes() {
		try {
			Date nowTimeDate = new Date(System.currentTimeMillis());
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
			String workTime = simpleDateFormat.format(nowTimeDate);
			AppLogger.info("[info]-获取系统时间:" + workTime);
			return workTime;
		} catch (Exception e) {
			AppLogger.info("[info]-获取系统时间失败," + e);
			throw new BaseRuntimeException(CommonErrorCodeEnum.GET_SYSTEM_TIME_EXCEPTION);
		}
	}
	
}
