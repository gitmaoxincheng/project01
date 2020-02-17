package tc.platform.service.common;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.afa.util.StringUtils;
import tc.platform.constant.exception.CommonErrorCodeEnum;
import tc.platform.context.exception.BaseRuntimeException;

public class ComponentAppImpl {
	/**
	 * 获取系统日期
	 * 
	 * @return
	 */
	public static String getSysDate() {
		AppLogger.info("方法(获取系统日期) --- P_AfaFunc.getSysDate()--- start ---");

		try {
			Date nowTimeDate = new Date(System.currentTimeMillis());
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String workDate = simpleDateFormat.format(nowTimeDate);
			AppLogger.info("系统日期:" + workDate);
			return workDate;
		} catch (Exception e) {
			AppLogger.info(e.getMessage());
			throw new BaseRuntimeException(CommonErrorCodeEnum.GET_SYSTEM_DATE_EXCEPTION);
		} finally {
			AppLogger.info("方法(获取系统日期) --- P_AfaFunc.getSysDate()--- end ---");
		}
	}

	/**
	 * 获取系统时间
	 * 
	 * @return
	 */
	public static String getSysTimes() {
		AppLogger.info("方法(获取系统时间) --- P_AfaFunc.getSysTimes()--- start ---");

		try {
			Date nowTimeDate = new Date(System.currentTimeMillis());
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
			String workTime = simpleDateFormat.format(nowTimeDate);
			AppLogger.info("系统时间:" + workTime);
			return workTime;
		} catch (Exception e) {
			AppLogger.info(e.getMessage());
			throw new BaseRuntimeException(CommonErrorCodeEnum.GET_SYSTEM_TIME_EXCEPTION);
		} finally {
			AppLogger.info("方法(获取系统时间) --- P_AfaFunc.getSysTimes()--- end ---");
		}
	}

	/**
	 * 日期相加减
	 * 
	 * @param sDate
	 * @param sDays
	 * @return
	 */
	public static String addDays(String sDate, String sDays) {
		AppLogger.info("方法(日期相加减) --- P_AfaFunc.addDays()--- start ---");

		try {
			AppLogger.info("处理前日期:" + sDate);
			if (StringUtils.isNullOrEmpty(sDate)) {
				AppLogger.info("日期为空!");
				return null;
			}
			if (StringUtils.isNullOrEmpty(sDays)) {
				AppLogger.info("相加天数为空!");
				return null;
			}
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			Date currDate = simpleDateFormat.parse(sDate);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(currDate);
			calendar.add(Calendar.DATE, Integer.parseInt(sDays));
			Date endDate = calendar.getTime();
			String endDateString = simpleDateFormat.format(endDate);
			AppLogger.info("处理后日期:" + endDateString);
			return endDateString;
		} catch (Exception e) {
			AppLogger.info(e.getMessage());
			throw new BaseRuntimeException(CommonErrorCodeEnum.ADD_DATE_EXCEPTION);
		} finally {
			AppLogger.info("方法(日期相加减) --- P_AfaFunc.addDays()--- end ---");
		}
	}

	/**
	 * 时间相加减
	 * 
	 * @param sDateTime
	 * @param sTimes
	 * @param type
	 * @return
	 */
	public static String addTimes(String sDateTime, String sTimes, String type) {
		AppLogger.info("方法(时间相加减) --- P_AfaFunc.addTimes()--- start ---");

		try {
			AppLogger.info("处理前时间:" + sDateTime);
			if (StringUtils.isNullOrEmpty(sDateTime)) {
				AppLogger.info("日期为空!");
				return null;
			}
			if (StringUtils.isNullOrEmpty(sTimes)) {
				AppLogger.info("相加时间为空!");
				return null;
			}
			if (StringUtils.isNullOrEmpty(type)) {
				AppLogger.info("类型为空!");
				return null;
			}
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			Date currTimeDate = simpleDateFormat.parse(sDateTime);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(currTimeDate);

			// 相加的类型，可以是S-秒、M-分、H-小时、D-天、W-星期
			switch (type) {
			case "S":
				calendar.add(Calendar.SECOND, Integer.parseInt(sTimes));
				break;
			case "M":
				calendar.add(Calendar.MINUTE, Integer.parseInt(sTimes));
				break;
			case "H":
				calendar.add(Calendar.HOUR, Integer.parseInt(sTimes));
				break;
			case "D":
				calendar.add(Calendar.DATE, Integer.parseInt(sTimes));
				break;
			case "W":
				calendar.add(Calendar.WEEK_OF_YEAR, Integer.parseInt(sTimes));
				break;
			default:
				AppLogger.error("type参数不合法");
				return null;
			}

			Date endTimeDate = calendar.getTime();
			String endTimeString = simpleDateFormat.format(endTimeDate);
			AppLogger.info("处理后时间:" + endTimeString);
			return endTimeString;
		} catch (Exception e) {
			AppLogger.info(e.getMessage());
			throw new BaseRuntimeException(CommonErrorCodeEnum.ADD_TIME_EXCEPTION);
		} finally {
			AppLogger.info("方法(时间相加减) --- P_AfaFunc.addTimes()--- end ---");
		}
	}

	
	public static String addMonths(String sourceDate, String monthNum) {
		AppLogger.info("方法(日期加月数得到新日期) --- P_AfaFunc.addMonths()--- start ---");

		try {
			AppLogger.info("处理前日期:" + sourceDate);
			if (StringUtils.isNullOrEmpty(sourceDate)) {
				AppLogger.info("日期为空!");
				return null;
			}
			if (StringUtils.isNullOrEmpty(monthNum)) {
				AppLogger.info("相加月份为空!");
				return null;
			}
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			Date currDate = simpleDateFormat.parse(sourceDate);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(currDate);
			calendar.add(Calendar.MONTH, Integer.parseInt(monthNum));
			Date endDate = calendar.getTime();
			String endDateString = simpleDateFormat.format(endDate);

			AppLogger.info("处理后日期:" + endDateString);
			return endDateString;
		} catch (Exception e) {
			AppLogger.info(e.getMessage());
			throw new BaseRuntimeException(CommonErrorCodeEnum.ADD_MONTH_EXCEPTION);
		} finally {
			AppLogger.info("方法(日期加月数得到新日期) --- P_AfaFunc.addMonths()--- end ---");
		}
	}

	public static String fmtDate(String dateString, String formatString) {
		AppLogger.info("方法(格式化日期) --- P_AfaFunc.fmtDate()--- start ---");

		try {
			AppLogger.info("处理前日期:" + dateString);
			if (StringUtils.isNullOrEmpty(dateString)) {
				AppLogger.info("待格式化日期为空");
				return null;
			}
			if (StringUtils.isNullOrEmpty(formatString)) {
				AppLogger.info("格式化字符串为空");
				return null;
			}
			String dateHandleString = dateString.trim();
			String yearString = null;
			String monthString = null;
			String dayString = null;
			String patternString = "^([1-9][0-9][0-9][0-9])\\D{0,2}([0-1]?[0-9])\\D{0,2}([0-3]?[0-9])\\D{0,2}$";
			Matcher matcher = Pattern.compile(patternString).matcher(dateHandleString);
			if (!Pattern.matches(patternString, dateHandleString)) {
				AppLogger.info("待格式化日期输入格式错误");
				return null;
			}
			while (matcher.find()) {
				yearString = matcher.group(1);
				monthString = matcher.group(2);
				dayString = matcher.group(3);
			}
			
			// todo 对formatString进行校验
			String affterString = formatString.replace("yyyy", yearString).replace("mm", monthString).replace("dd", dayString);
			AppLogger.info("处理后日期:" + affterString);
			return affterString;
		} catch (Exception e) {
			AppLogger.info(e.getMessage());
			throw new BaseRuntimeException(CommonErrorCodeEnum.FMT_DATE_EXCEPTION);
		} finally {
			AppLogger.info("方法(格式化日期) --- P_AfaFunc.fmtDate()--- end ---");
		}
	}

	public static String fmtTime(String timeString, String formatString) {
		AppLogger.info("方法(格式化时间) --- P_AfaFunc.fmtTime()--- start ---");

		try {
			AppLogger.info("处理前时间:" + timeString);
			if (StringUtils.isNullOrEmpty(timeString)) {
				AppLogger.info("待格式化时间为空");
				return null;
			}
			if (StringUtils.isNullOrEmpty(formatString)) {
				AppLogger.info("格式化字符串为空");
				return null;
			}
			String timeHandleString = timeString;
			String hourString = null;
			String minuteString = null;
			String secondString = null;
			timeHandleString.trim();
			String patternString = "^([0-2]?[0-9])\\D{0,2}([0-6]?[0-9])\\D{0,2}([0-6]?[1-9])\\D{0,2}$";
			Matcher matcher = Pattern.compile(patternString).matcher(timeString);
			if (!Pattern.matches(patternString, timeString)) {
				AppLogger.info("待格式化时间输入格式错误");
				return null;
			}
			while (matcher.find()) {
				hourString = matcher.group(1);
				minuteString = matcher.group(2);
				secondString = matcher.group(3);
			}
			// todo 对formatString进行校验?
			String affterString = formatString.replace("hh", hourString).replace("mm", minuteString).replace("ss", secondString);

			AppLogger.info("处理后日期:" + affterString);
			return affterString;
		} catch (Exception e) {
			AppLogger.info(e.getMessage());
			throw new BaseRuntimeException(CommonErrorCodeEnum.FMT_TIME_EXCEPTION);
		} finally {
			AppLogger.info("方法(格式化时间) --- P_AfaFunc.fmtTime()--- end ---");
		}
	}

	public static String dealAmountFormat(String amount, String digit) {
		AppLogger.info("方法(金额通用) --- P_AfaFunc.dealAmountFormat()--- start ---");

		try {
			AppLogger.info("处理前金额:" + amount);
			if (StringUtils.isNullOrEmpty(amount)) {
				AppLogger.error("金额为空");
				return null;
			}
			if (StringUtils.isNullOrEmpty(digit)) {
				AppLogger.error("输入数字字符为空");
				return null;
			}
			if (!amount.trim().matches("^[0-9]+(.[0-9]+)?$")) {
				AppLogger.error("输入金额格式不正确");
				return null;
			}
			if (!digit.trim().matches("^[1-3]*")) {
				AppLogger.error("输入数字字符格式不正确");
				return null;
			}
			switch (digit) {
			// 格式100--->100.00
			case "1":
				int i = amount.indexOf(".");
				if (i < 0) {
					amount = amount.concat(".00");
				} else {
					AppLogger.error("输入数字字符格式不正确");
					return null;
				}
				break;
			// 分转元
			case "2":
				amount = (BigDecimal.valueOf(Long.valueOf(amount)).divide(new BigDecimal(100))).toString();
				break;
			// 元转分
			case "3":
				amount = (BigDecimal.valueOf(Long.valueOf(amount)).multiply(new BigDecimal(100))).toString();
				break;
			default:
				break;
			}
			AppLogger.info("处理后金额:" + amount);
			return amount;
		} catch (Exception e) {
			AppLogger.info(e.getMessage());
			throw new BaseRuntimeException(CommonErrorCodeEnum.AMOUNT_HANDLE_EXCEPTION);
		} finally {
			AppLogger.info("方法(金额通用) --- P_AfaFunc.dealAmountFormat()--- end ---");
		}

	}
	
	public static String public_Stock_Data_In_Amount_Out(JavaList amountList) {
		AppLogger.info("方法(通用金额加减组件) --- P_AfaFunc.public_Stock_Data_In_Amount_Out()--- start ---");
		if(!(amountList instanceof JavaList) || amountList.isEmpty()) {
			AppLogger.info("输入的金额列表amountList类型为JavaList且不能为空");
			return null;
		}
		BigDecimal sum = new BigDecimal(0.0d);
		for (int i = 0; i < amountList.size(); i++) {
			String amount = amountList.getStringItem(i);
			sum.add(BigDecimal.valueOf(Long.valueOf(amount)));
		}
		AppLogger.info("方法(通用金额加减组件) --- P_AfaFunc.public_Stock_Data_In_Amount_Out()--- end ---");
		return sum.toString();
	}
	
	
	public static JavaList compTwoInput(String first,String second,String type) {
		AppLogger.info("方法(比较两个输入值) --- P_AfaFunc.P_compTwoInput--- start ---");
		JavaList results = new JavaList();
		if (StringUtils.isNullOrEmpty(type)) {
			AppLogger.error("比较类型为空");
			return null;
		}
		if (type.equals("date") && StringUtils.isNullOrEmpty(first)) {
			AppLogger.error("当比较类型为date,第一个参数为空");
			return null;
		}
		if (type.equals("date2") && StringUtils.isAnyNullOrEmpty(first,second)) {
			AppLogger.error("当比较类型为date2,第一或第二个参数为空");
			return null;
		}
		
		//验证输入的格式
		switch (type) {
		case "date":
			if (StringUtils.isNullOrEmpty(second)) {
				second = getSysDate();
			}
			if (first.compareTo(second)>0) {
				AppLogger.error("开始日期大于结束日期");
				return null;
			}
			break;
		case "date2":
			if (first.compareTo(second)>0) {
				AppLogger.error("开始日期大于结束日期");
				return null;
			}
			if (second.compareTo(getSysDate())>0) {
				AppLogger.error("结束日期大于当前日期");
				return null;
			}
			break;
		case "amount":
			if (StringUtils.isNullOrEmpty(first)) {
				first = "0.00";
			}
			if (StringUtils.isNullOrEmpty(second)) {
				second = "0.00";
			}
			if (BigDecimal.valueOf(Long.valueOf(first)).compareTo(BigDecimal.valueOf(Long.valueOf(second)))>0) {
				AppLogger.error("第一个参数大于第二个参数");
				return null;
			}
			break;
		default:
			AppLogger.error("类型输入错误,输入为:"+type);
			break;
		}
		results.add(first);
		results.add(second);
		AppLogger.info("方法(比较两个输入值) --- P_AfaFunc.P_compTwoInput--- end ---");
		return results;
	}
	
}
