package tc.platform.component.commom;

import cn.com.agree.afa.svc.context.IDict;
import cn.com.agree.afa.svc.holder.EnvContextHolder;
import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.afa.util.StringUtils;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;
import tc.platform.constant.exception.CommonErrorCodeEnum;
import tc.platform.context.CIResult;
import tc.platform.service.common.ComponentAppImpl;

/**
 * 通用工具类
 * 
 * @date 2019-02-26 9:34:35
 */
@ComponentGroup(level = "平台", groupName = "通用工具类")
public class P_ComponentApp {

	/**
	 * @category 取消节点值
	 * @param continer
	 *            入参|要删除KEY的容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param keyList
	 *            入参|要删除的key值|{@link cn.com.agree.afa.svc.javaengine.context.JavaList}
	 * @return 1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "continer", comment = "要删除KEY的容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "keyList", comment = "要删除的key值", type = cn.com.agree.afa.svc.javaengine.context.JavaList.class) })
	@Returns(returns = { @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "取消节点值", style = "处理型", type = "同步组件", comment = "取消节点值", author = "admin", date = "2019-03-11 04:47:39")
	public static TCResult P_removeVariable(JavaDict continer, JavaList keyList) {
		AppLogger.info("Function --- P_BComponentApp.removeVariable() --- start ---");
		try {
			AppLogger.info("容器处理前:" + continer);
			if (continer.isEmpty() || !(continer instanceof JavaDict)) {
				AppLogger.info("B_ComponentApp.removeVariable()传入参数[" + continer + "]类型不是JavaDict");
			}
			if (keyList.isEmpty() || !(keyList instanceof JavaList)) {
				AppLogger.info("B_ComponentApp.removeVariable()传入参数[" + keyList + "]类型不是JavaList");
			}
			for (Object object : keyList) {
				if (continer.containsKey(object)) {
					continer.removeItem(object);
				}
			}
			AppLogger.info("容器处理后:" + continer);
			return TCResult.newSuccessResult();
		} catch (Exception e) {
			return TCResult.newFailureResult("A01D022", "取消节点值失败:" + e.getMessage());
		} finally {
			AppLogger.info("Function --- P_BComponentApp.removeVariable() --- end ---");
		}
	}

	/**
	 * @category 获取系统日期
	 * @return 1 成功<br>
	 */
	@Returns(returns = { @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "获取系统日期", style = "处理型", type = "同步组件", comment = "获取系统日期", author = "admin", date = "2019-03-11 04:52:48")
	public static TCResult P_getSysDate() {
		AppLogger.info("Function --- A_AfaFunc.P_getSysDate() --- start ---");
		IDict __REQ__ = EnvContextHolder.getHolder().getContext().getRequest();
		try {
			__REQ__.setItem("workDate", ComponentAppImpl.getSysDate());
			AppLogger.info("系统日期:" + ComponentAppImpl.getSysDate());
			return TCResult.newSuccessResult();
		} catch (Exception e) {
			e.printStackTrace();
			AppLogger.error(e.getMessage());
			return null;
		} finally {
			AppLogger.info("Function --- A_AfaFunc.P_getSysDate() --- succ end --- workDate = ["
					+ ComponentAppImpl.getSysDate() + "] ---");
		}
	}

	/**
	 * @category 获取系统时间
	 * @return 1 成功<br>
	 */
	@Returns(returns = { @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "获取系统时间", style = "处理型", type = "同步组件", comment = "获取系统时间", author = "admin", date = "2019-03-11 04:56:21")
	public static TCResult P_getSysTime() {
		AppLogger.info("Function --- A_AfaFunc.P_getSysTime() --- start ---");
		try {
			IDict __REQ__ = EnvContextHolder.getHolder().getContext().getRequest();
			__REQ__.setItem("workTime", ComponentAppImpl.getSysTimes());
			AppLogger.info("系统时间:" + ComponentAppImpl.getSysTimes());
			return TCResult.newSuccessResult();
		} catch (Exception e) {
			e.printStackTrace();
			AppLogger.error(e.getMessage());
			return null;
		} finally {
			AppLogger.info("Function --- A_AfaFunc.P_getSysTime() --- succ end --- workTime = ["
					+ ComponentAppImpl.getSysTimes() + "] ---");
		}
	}

	/**
	 * @category 日期相加减
	 * @param sDate
	 *            入参|原日期|{@link java.lang.String}
	 * @param sDays
	 *            入参|相加天数|{@link java.lang.String}
	 * @return 1 成功<br>
	 */
	@InParams(param = { @Param(name = "sDate", comment = "原日期", type = java.lang.String.class),
			@Param(name = "sDays", comment = "相加天数", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "日期相加减", style = "处理型", type = "同步组件", comment = "日期相加减", author = "admin", date = "2019-03-11 04:58:56")
	public static TCResult P_addDays(String sDate, String sDays) {
		AppLogger.info("******日期加一个天数,得到一个新日期 addDays begin****************");
		try {
			IDict __REQ__ = EnvContextHolder.getHolder().getContext().getRequest();

			if (StringUtils.isNullOrEmpty(sDate)) {
				return TCResult.newFailureResult("COMM1002", "原日期为空");
			}
			if (sDate.length() != 8) {
				AppLogger.error("Function --- A_AfaFunc.addDays()--- sDate日期参数不合法 ---");
				return TCResult.newFailureResult("COMM1010", "sDate日期参数不合法");
			}
			if (StringUtils.isNullOrEmpty(sDays)) {
				return TCResult.newFailureResult("COMM1002", "相加天数为空");
			}
			if (__REQ__.hasKey("APP_CUSTOM_DATE")) {
				return TCResult.newFailureResult("COMM1002", "__REQ__中已经存在变量:APP_CUSTOM_DATE");
			}

			__REQ__.setItem("APP_CUSTOM_DATE", ComponentAppImpl.addDays(sDate, sDays));
			return TCResult.newSuccessResult();
		} catch (Exception e) {
			e.printStackTrace();
			AppLogger.error(e.getMessage());

			return TCResult.newFailureResult("COMM1003", e.getMessage());
		} finally {
			AppLogger.info("******日期加一个天数,得到一个新日期 addDays end****************");
		}
	}

	/**
	 * @category 时间相加减
	 * @param sDateTime
	 *            入参|原日期|{@link java.lang.String}
	 * @param sTimes
	 *            入参|要相加的时间|{@link java.lang.String}
	 * @param type
	 *            入参|相加的类型，可以是S-秒、M-分、H-小时、D-天、W-星期|{@link java.lang.String}
	 * @return 1 成功<br>
	 */
	@InParams(param = { @Param(name = "sDateTime", comment = "原日期", type = java.lang.String.class),
			@Param(name = "sTimes", comment = "要相加的时间", type = java.lang.String.class),
			@Param(name = "type", comment = "相加的类型，可以是S-秒、M-分、H-小时、D-天、W-星期", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "时间相加减", style = "处理型", type = "同步组件", comment = "时间相加减", author = "admin", date = "2019-03-11 05:03:13")
	public static TCResult P_addTimes(String sDateTime, String sTimes, String type) {
		AppLogger.info("******时间加一个时间,得到一个新时间 addTimes begin****************");

		try {
			IDict __REQ__ = EnvContextHolder.getHolder().getContext().getRequest();

			if (StringUtils.isNullOrEmpty(sDateTime)) {
				return TCResult.newFailureResult("COMM1002", "原日期为空");
			}
			if (sDateTime.length() != 14) {
				AppLogger.error("Function --- A_AfaFunc.addDays()--- sDate日期参数不合法 ---");
				return TCResult.newFailureResult("COMM1010", "sDate日期参数不合法");
			}
			if (StringUtils.isNullOrEmpty(sTimes)) {
				return TCResult.newFailureResult("COMM1002", "相加时间为空");
			}
			if (StringUtils.isNullOrEmpty(type)) {
				return TCResult.newFailureResult("COMM1002", "类型为空");
			}
			if (__REQ__.hasKey("APP_CUSTOM_TIME")) {
				return TCResult.newFailureResult("COMM1002", "__REQ__中已经存在变量:APP_CUSTOM_TIME");
			}

			__REQ__.setItem("APP_CUSTOM_TIME", ComponentAppImpl.addTimes(sDateTime, sTimes, type));
			return TCResult.newSuccessResult();
		} catch (Exception e) {
			e.printStackTrace();
			AppLogger.error(e.getMessage());
			return TCResult.newFailureResult("COMM1003", e.getMessage());
		} finally {
			AppLogger.info("******时间加一个时间,得到一个新时间 addTimes end****************");
		}
	}

	/**
	 * @category 日期加月数得到新日期
	 * @param sourceDate
	 *            入参|原日期|{@link java.lang.String}
	 * @param monthNum
	 *            入参|要相加的月数|{@link java.lang.String}
	 * @param variableName
	 *            入参|存放新日期的变量名称|{@link java.lang.String}
	 * @param ctxFlag
	 *            入参|容器标识|{@link java.lang.String}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = { @Param(name = "sourceDate", comment = "原日期", type = java.lang.String.class),
			@Param(name = "monthNum", comment = "要相加的月数", type = java.lang.String.class),
			@Param(name = "variableName", comment = "存放新日期的变量名称", type = java.lang.String.class),
			@Param(name = "ctxFlag", comment = "容器标识", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "日期加月数得到新日期", style = "判断型", type = "同步组件", comment = "日期加月数得到新日期", author = "admin", date = "2019-03-11 05:08:07")
	public static TCResult P_addMonths(String sourceDate, String monthNum, String variableName, String ctxFlag) {
		AppLogger.info("******时间加一个月数,得到一个新日期 addMonths begin****************");
		try {
			if (StringUtils.isNullOrEmpty(sourceDate)) {
				return TCResult.newFailureResult("COMM1002", "日期为空");
			}
			if (sourceDate.length() != 8) {
				AppLogger.error("Function --- A_AfaFunc.addDays()--- sourcedate日期参数不合法 ---");
				return TCResult.newFailureResult("COMM1010", "sourcedate日期参数不合法");
			}
			if (StringUtils.isNullOrEmpty(monthNum)) {
				return TCResult.newFailureResult("COMM1002", "月份为空");
			}
			if (StringUtils.isNullOrEmpty(variableName)) {
				return TCResult.newFailureResult("COMM1002", "变量名称为空");
			}
			if (StringUtils.isNullOrEmpty(ctxFlag)) {
				ctxFlag = "REQ";
			}

			AppLogger.info("ctxFlag容器标识是:" + ctxFlag);
			if (ctxFlag.equals("REQ")) {
				IDict __REQ__ = EnvContextHolder.getHolder().getContext().getRequest();
				__REQ__.setItem("variableName", ComponentAppImpl.addMonths(sourceDate, monthNum));
			} else {
				IDict __RSP__ = EnvContextHolder.getHolder().getContext().getResponse();
				__RSP__.setItem("variableName", ComponentAppImpl.addMonths(sourceDate, monthNum));
			}
			return TCResult.newSuccessResult();
		} catch (Exception e) {
			e.printStackTrace();
			AppLogger.error(e.getMessage());
			return TCResult.newFailureResult("COMM1003", e.getMessage());
		} finally {
			AppLogger.info("******时间加一个月数,得到一个新日期 addMonths end****************");
		}
	}

	/**
	 * @category 格式化日期
	 * @param dateString
	 *            入参|格式化前日期|{@link java.lang.String}
	 * @param formatString
	 *            入参|格式化字符串|{@link java.lang.String}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = { @Param(name = "dateString", comment = "格式化前日期", type = java.lang.String.class),
			@Param(name = "formatString", comment = "格式化字符串", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "格式化日期", style = "判断型", type = "同步组件", comment = "格式化日期", author = "admin", date = "2019-03-11 05:12:12")
	public static TCResult P_fmtDate(String dateString, String formatString) {
		AppLogger.info("******格式化日期 P_fmtDate begin****************");
		try {
			IDict __REQ__ = EnvContextHolder.getHolder().getContext().getRequest();
			if (StringUtils.isNullOrEmpty(dateString)) {
				return TCResult.newFailureResult("COMM1002", "待格式化日期为空");
			}
			if (StringUtils.isNullOrEmpty(formatString)) {
				return TCResult.newFailureResult("COMM1002", "格式化字符串为空");
			}
			__REQ__.setItem("workDate", ComponentAppImpl.fmtDate(dateString, formatString));

			return TCResult.newSuccessResult();
		} catch (Exception e) {
			e.printStackTrace();
			AppLogger.error(e.getMessage());
			return TCResult.newFailureResult("COMM1003", e.getMessage());
		} finally {
			AppLogger.info("******格式化日期 fmtDate end****************");
		}
	}

	/**
	 * @category 格式化时间
	 * @param timeString
	 *            入参|待格式化时间|{@link java.lang.String}
	 * @param formatString
	 *            入参|格式化字符串|{@link java.lang.String}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = { @Param(name = "timeString", comment = "待格式化时间", type = java.lang.String.class),
			@Param(name = "formatString", comment = "格式化字符串", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "格式化时间", style = "判断型", type = "同步组件", comment = "格式化时间", author = "admin", date = "2019-03-11 05:14:51")
	public static TCResult P_fmtTime(String timeString, String formatString) {
		AppLogger.info("******格式化时间 P_fmtTime begin****************");
		try {
			IDict __REQ__ = EnvContextHolder.getHolder().getContext().getRequest();
			if (StringUtils.isNullOrEmpty(timeString)) {
				return TCResult.newFailureResult("COMM1002", "待格式化时间为空");
			}
			if (StringUtils.isNullOrEmpty(formatString)) {
				return TCResult.newFailureResult("COMM1002", "格式化字符串为空");
			}
			__REQ__.setItem("workTime", ComponentAppImpl.fmtTime(timeString, formatString));

			return TCResult.newSuccessResult();
		} catch (Exception e) {
			e.printStackTrace();
			AppLogger.error(e.getMessage());
			return TCResult.newFailureResult("COMM1003", e.getMessage());
		} finally {
			AppLogger.info("******格式化时间 fmtTime end****************");
		}
	}

	/**
	 * @category 金额通用
	 * @param amount
	 *            入参|金额|{@link java.lang.String}
	 * @param digit
	 *            入参|数字字符|{@link java.lang.String}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = { @Param(name = "amount", comment = "金额", type = java.lang.String.class),
			@Param(name = "digit", comment = "数字字符", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "金额通用", style = "判断型", type = "同步组件", comment = "金额通用", author = "admin", date = "2019-03-11 05:17:25")
	public static TCResult P_dealAmountFormat(String amount, String digit) {
		AppLogger.info("******金额通用 P_dealAmountFormat begin****************");
		try {
			IDict __REQ__ = EnvContextHolder.getHolder().getContext().getRequest();
			if (StringUtils.isNullOrEmpty(amount)) {
				return TCResult.newFailureResult("COMM1002", "金额为空");
			}
			if (StringUtils.isNullOrEmpty(digit)) {
				return TCResult.newFailureResult("COMM1002", "输入数字字符为空");
			}
			if (!amount.trim().matches("^[0-9]+(.[0-9]+)?$")) {
				return TCResult.newFailureResult("COMM1010", "输入金额格式不正确");
			}
			if (!digit.trim().matches("^[1-3]*")) {
				return TCResult.newFailureResult("COMM1010", "输入数字字符格式不正确");
			}
			__REQ__.setItem("amount", ComponentAppImpl.dealAmountFormat(amount, digit));

			return TCResult.newSuccessResult();
		} catch (Exception e) {
			e.printStackTrace();
			AppLogger.error(e.getMessage());
			return TCResult.newFailureResult("COMM1003", e.getMessage());
		} finally {
			AppLogger.info("******金额通用 P_dealAmountFormat end****************");
		}
	}

	/**
	 * @category 通用金额加减组件
	 * @param amountList
	 *            入参|金额列表|{@link cn.com.agree.afa.svc.javaengine.context.JavaList}
	 * @param variableName
	 *            入参|结果存放变量名|{@link java.lang.String}
	 * @param reFlag
	 *            入参|全局变量类型(REQ或者RSP)|{@link java.lang.String}
	 * @return 1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "amountList", comment = "金额列表", type = cn.com.agree.afa.svc.javaengine.context.JavaList.class),
			@Param(name = "variableName", comment = "结果存放变量名", type = java.lang.String.class),
			@Param(name = "reFlag", comment = "全局变量类型(REQ或者RSP)", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "通用金额加减组件", style = "处理型", type = "同步组件", comment = "通用金额加减组件", author = "admin", date = "2019-03-11 09:49:50")
	public static TCResult P_public_Stock_Data_In_Amount_Out(JavaList amountList, String variableName, String reFlag) {

		AppLogger.info("******通用金额加减组件P_public_Stock_Data_In_Amount_Out begin****************");

		if (!(amountList instanceof JavaList) || amountList.isEmpty()) {
			return TCResult.newFailureResult("COMM1002", "输入的金额列表amountList类型为JavaList且不能为空");
		}
		if (!(variableName instanceof String) || StringUtils.isNullOrEmpty(variableName)) {
			return TCResult.newFailureResult("COMM1002", "输入的结果存放变量名类型为字符串且不能为空");
		}
		if (!(reFlag instanceof String) || StringUtils.isNullOrEmpty(reFlag)
				|| !(reFlag.equals("REQ") || reFlag.equals("RSP"))) {
			return TCResult.newFailureResult("COMM1002", "输入的全局变量类型为字符串不能为空,且值为REQ或RSP");
		}

		if (reFlag.equals("REQ")) {
			IDict __REQ__ = EnvContextHolder.getHolder().getContext().getRequest();
			__REQ__.setItem(variableName, ComponentAppImpl.public_Stock_Data_In_Amount_Out(amountList));
		} else {
			IDict __RSP__ = EnvContextHolder.getHolder().getContext().getResponse();
			__RSP__.setItem(variableName, ComponentAppImpl.public_Stock_Data_In_Amount_Out(amountList));
		}
		AppLogger.info("******通用金额加减组件P_public_Stock_Data_In_Amount_Out end****************");
		return TCResult.newSuccessResult();
	}

	/**
	 * @category 比较两个输入值
	 * @param first
	 *            入参|第一个参数|{@link java.lang.String}
	 * @param second
	 *            入参|第二个参数|{@link java.lang.String}
	 * @param type
	 *            入参|比较类型|{@link java.lang.String}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = { @Param(name = "first", comment = "第一个参数", type = java.lang.String.class),
			@Param(name = "second", comment = "第二个参数", type = java.lang.String.class),
			@Param(name = "type", comment = "比较类型", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "比较两个输入值", style = "判断型", type = "同步组件", comment = "比较两个输入值", author = "admin", date = "2019-03-11 10:58:01")
	public static TCResult P_compTwoInput(String first, String second, String type) {
		AppLogger.info("******比较两个输入值P_compTwoInput begin****************");
		IDict __RSP__ = EnvContextHolder.getHolder().getContext().getResponse();
		if (StringUtils.isNullOrEmpty(type)) {
			AppLogger.error("比较类型为空");
			return TCResult.newFailureResult("COMM1002", "比较类型不能为空");
		}
		if (type.equals("date") && StringUtils.isNullOrEmpty(first)) {
			AppLogger.error("当比较类型为date,第一个参数为空");
			return TCResult.newFailureResult("COMM1002", "当比较类型为date,第一个参数不能为空");
		}
		if (type.equals("date2") && StringUtils.isAnyNullOrEmpty(first, second)) {
			AppLogger.error("当比较类型为date2,第一或第二个参数为空");
			return TCResult.newFailureResult("COMM1002", "当比较类型为date2,第一和第二个参数不能为空");
		}

		if (type.equals("date")) {
			if (StringUtils.isNullOrEmpty(second)) {
				second = ComponentAppImpl.getSysDate();
			}
		}
		JavaList results = ComponentAppImpl.compTwoInput(first, second, type);
		__RSP__.setItem("results", results);

		AppLogger.info("******比较两个输入值P_compTwoInput end****************");
		return TCResult.newSuccessResult();
	}

	/**
	 * @category 设置节点值组件
	 * @param argContext
	 *            入参|容器变量|{@link java.lang.String}
	 * @param varlist
	 *            入参|元素值|{@link cn.com.agree.afa.svc.javaengine.context.JavaList}
	 * @return 1 成功<br>
	 */
	@InParams(param = { @Param(name = "argContext", comment = "容器变量", type = java.lang.String.class),
			@Param(name = "varlist", comment = "元素值", type = cn.com.agree.afa.svc.javaengine.context.JavaList.class) })
	@Returns(returns = { @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "设置节点值组件", style = "处理型", type = "同步组件", comment = "设置节点值,容器变量为'__REQ__'或者'__RSP__',元素值为[key,value]", author = "admin", date = "2019-04-16 03:11:52")
	public static TCResult P_setDataValue(String argContext, JavaList varlist) {
		AppLogger.info("******设置节点值组件P_setDataValue begin****************");
		try {
			IDict context = null;
			if (!(varlist instanceof JavaList)) {
				AppLogger.error("元素值为空");
				return TCResult.newFailureResult("COMM1002", "元素值不能为空");
			}
			if (argContext.trim().equals("__REQ__")) {
				context = EnvContextHolder.getHolder().getContext().getRequest();
			} else if (argContext.trim().equals("__RSP__")) {
				context = EnvContextHolder.getHolder().getContext().getResponse();
			} else {
				AppLogger.error("容器变量输入错误,输入值为:" + argContext);
				return TCResult.newFailureResult("COMM1002", "容器变量不在[__REQ__,__RSP__]范围内");
			}
			for (Object varObject : varlist) {
				if (!(varObject instanceof JavaList) && varlist.size() != 2) {
					return TCResult.newFailureResult("COMM1002", "组件[A_setDataValue]参数[varlist]个数错误");
				} else if (!(varObject instanceof JavaList)) {
					context.setItem(varlist.getItem(0), varlist.getItem(1));
				} else {
					context.setItem(((JavaList) varObject).getItem(0), ((JavaList) varObject).getItem(1));
				}
			}

			AppLogger.info("******设置节点值组件P_setDataValue end****************");
			return TCResult.newSuccessResult();
		} catch (Exception e) {
			AppLogger.error(e);
			return TCResult.newFailureResult("SI0101", "系统错误");
		}
	}

	/**
	 * @category 获取错误码枚举信息
	 * @param enumString
	 *            入参|枚举字符串|{@link java.lang.String}
	 * @since to 出参|返回容器|{@link java.lang.String}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = { @Param(name = "enumString", comment = "枚举字符串", type = java.lang.String.class) })
	@OutParams(param = { @Param(name = "to", comment = "返回容器", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "获取错误码枚举信息", style = "判断型", type = "同步组件", comment = "根据枚举字符串获取枚举信息", date = "2019-06-19 05:58:36")
	public static TCResult P_getErrorCodeEnumInfo(String enumString) {
		AppLogger.info("---------------获取错误码枚举信息 P_getErrorCodeEnumInfo() 开始-------------------");
		try {
			CommonErrorCodeEnum target = CommonErrorCodeEnum.valueOf(enumString);
			JavaDict res = new JavaDict();
			res.setItem("errorCode", target.getCode());
			res.setItem("errorMsg", target.getMsg());
			return CIResult.newSuccessResult(res);
		} catch (Exception e) {
			AppLogger.error(String.format("[error]-获取错误码枚举信息失败: %s", e));
			AppLogger.error(e);
			return CIResult.newFailureResult(CommonErrorCodeEnum.GET_ERROR_ENUM_ERROR);
		} finally {
			AppLogger.info("---------------获取错误码枚举信息 P_getErrorCodeEnumInfo() 结束-------------------");
		}
	}


}