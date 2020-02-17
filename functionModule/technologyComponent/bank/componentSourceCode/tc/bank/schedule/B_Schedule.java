package tc.bank.schedule;

import org.springframework.util.StringUtils;

import ap.ide.techcomp.TechComp;
import cn.com.agree.afa.jcomponent.TradeResponseSender;
import cn.com.agree.afa.svc.context.IContext;
import cn.com.agree.afa.svc.holder.EnvContextHolder;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommParam;
import cn.com.agree.huanan.ap.rl.bank.base.exception.ApMsgInformFailException;
import cn.com.agree.huanan.ap.rl.bank.base.util.SernoGenUtil;
import cn.com.agree.huanan.ap.rl.bank.schedule.exception.ApScheduleStatusException;
import cn.com.agree.huanan.ap.rl.bank.schedule.po.Schedule;
import cn.com.agree.huanan.ap.rl.bank.schedule.po.ScheduleFlow;
import cn.com.agree.huanan.ap.rl.bank.schedule.service.ScheduleService;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApParamNotExistException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;
import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * @date 2019-10-14 15:8:10
 */
@ComponentGroup(level = "银行", groupName = "调度任务")
public class B_Schedule {

	private static Logger logger = Logger.getLogger(B_Schedule.class);

	/**
	 * @category 调度作业总控
	 * @param REQ
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param RSP
	 *            入参|返回容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since scheInfo
	 *        出参|调度信息|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 预查询<br>
	 *         2 调起<br>
	 *         3 回查<br>
	 */
	@InParams(param = {
			@Param(name = "REQ", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "RSP", comment = "返回容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = {
			@Param(name = "scheInfo", comment = "调度信息", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "预查询"),
			@Return(id = "2", desp = "调起"), @Return(id = "3", desp = "回查") })
	@galaxy.ide.tech.cpt.Component(label = "调度作业总控", style = "判断型", type = "同步组件", comment = "调度作业总控", date = "2019-12-19 08:03:59")
	public static TCResult B_ScheduleController(JavaDict REQ, JavaDict RSP) {
		return TechComp.callWithBean(true, ScheduleService.class, (scheduleService) -> {

			// 服务调度信息整合
			logger.info("调度信息整合");
			String jobId = REQ.getStringItem("jobid");
			String jobName = REQ.getStringItem("jobname");
			String tradeDate = REQ.getStringItem("tradedate", DateTimeUtil.getSysDate());
			String tradeTime = REQ.getStringItem("tradetime", DateTimeUtil.getSysTime());
			String schetype = REQ.getStringItem("schetype");
			String jobtype = REQ.getStringItem("jobtype");
			if (StringUtils.isEmpty(jobId) || StringUtils.isEmpty(jobtype)) {
				throw new ApParamNotExistException("调度任务jobid或调度类型jobtype");
			}
			// 1、判断日终类型或者定时类型调度
			if ("1".equals(jobtype)) {
				logger.info("调度为定时类");
				Schedule schedule = scheduleService.querySchedule(jobId);
				String status = schedule.getStatus();
				if (!"1".equals(status)) { // 检查调度状态是否为可执行状态
					throw new ApScheduleStatusException(status, jobId);
				}
				logger.info("1111");
				JavaDict csisHeader = new JavaDict();
				String globalSerNo = SernoGenUtil.getGSerno(CommParam.COMPNO, "COMP_SCHE_SEQ");// 生成流水号
				csisHeader.put(CommConstant.GloSeqNo, globalSerNo);
				csisHeader.put(CommConstant.SRCDATE, tradeDate);
				csisHeader.put(CommConstant.SRCTIME, tradeTime);
				JavaDict appBody = new JavaDict();
				appBody.put("jobid", schedule.getJobId());
				appBody.put("jobename", schedule.getJobEname());
				appBody.put("jobname", schedule.getJobName());
				appBody.put("jobid", schedule.getJobId());
				JavaDict header = new JavaDict();
				// XXX Header需要填充什么数据，待议
				header.put(CommConstant.SVCCODE, schedule.getSvcCode());
				header.put(CommConstant.SCNCODE, schedule.getScnCode());
				header.put(CommConstant.SVCGTOUP, schedule.getSvcGroup());
				logger.info("登记调度流水信息");
				// 登记调度流水信息
				ScheduleFlow scheduleFlow = new ScheduleFlow();
				scheduleFlow.setSeriNo(globalSerNo);
				scheduleFlow.setJobId(schedule.getJobId());
				scheduleFlow.setJobName(schedule.getJobName());
				scheduleFlow.setJobType(schedule.getJobType());
				scheduleFlow.setTradeDate(tradeDate);
				scheduleFlow.setTradeTime(tradeTime);
				scheduleFlow.setSvcCode(schedule.getSvcCode());
				scheduleFlow.setScnCode(schedule.getScnCode());
				scheduleFlow.setSvcGroup(schedule.getSvcGroup());
				scheduleFlow.setStatus("U");// 调度刚开始，状态未知
				scheduleFlow.setErrorCode(CommConstant.UNKNOWCODE);
				scheduleFlow.setErrorMsg(CommConstant.UNKNOWMSG);
				scheduleService.addScheduleFlow(scheduleFlow);
				// 更新调度状态
				schedule.setStatus("4");// 调度状态未知
				schedule.setCurCount(schedule.getCurCount() + 1);
				schedule.setCurDate(tradeDate);
				schedule.setCurSerno(globalSerNo);
				scheduleService.updateScheBeforeInvoke(schedule);
				return new Object[] { 2, null };
			} else {
				logger.info("调度为日终类");
				// 2、 判断调度请求的状态， 预查询-0，调起-1，回查-2
				if ("0".equals(schetype)) { // 预查询
					Schedule schedule = scheduleService.querySchedule(jobId);
					String status = schedule.getStatus();
					logger.info("1111:%s", status);
					if (!"1".equals(status)) { // 检查调度状态是否为可执行状态
						throw new ApScheduleStatusException(status, jobId);
					}
					return new Object[] { 1, null };
				} else if ("2".equals(schetype)) {// 回查
					Schedule schedule = scheduleService.querySchedule(jobId);
					String status = schedule.getStatus();
					logger.info("2222:%s", status);
					if (!"1".equals(status)) { // 检查调度状态是否为可执行状态
						throw new ApScheduleStatusException(status, jobId);
					}
					return new Object[] { 3, null };
				} else if ("1".equals(schetype)) { // 调起
					Schedule schedule = scheduleService.querySchedule(jobId);
					String status = schedule.getStatus();
					logger.info("33333A:%s", status);
					if (!"1".equals(status)) { // 检查调度状态是否为可执行状态
						throw new ApScheduleStatusException(status, jobId);
					}
					logger.info("3333SSS");
					JavaDict csisHeader = new JavaDict();
					String globalSerNo = SernoGenUtil.getGSerno(CommParam.COMPNO, "COMP_SCHE_SEQ");// 生成流水号
					csisHeader.put(CommConstant.GloSeqNo, globalSerNo);
					csisHeader.put(CommConstant.SRCDATE, tradeDate);
					csisHeader.put(CommConstant.SRCTIME, tradeTime);
					JavaDict appBody = new JavaDict();
					appBody.put("jobid", schedule.getJobId());
					appBody.put("jobename", schedule.getJobEname());
					appBody.put("jobname", schedule.getJobName());
					appBody.put("jobid", schedule.getJobId());
					JavaDict header = new JavaDict();
					// XXX Header需要填充什么数据，待议
					header.put(CommConstant.SVCCODE, schedule.getSvcCode());
					header.put(CommConstant.SCNCODE, schedule.getScnCode());
					header.put(CommConstant.SVCGTOUP, schedule.getSvcGroup());
					logger.info("登记调度流水信息");
					// 登记调度流水信息
					ScheduleFlow scheduleFlow = new ScheduleFlow();
					scheduleFlow.setSeriNo(globalSerNo);
					scheduleFlow.setJobId(schedule.getJobId());
					scheduleFlow.setJobName(schedule.getJobName());
					scheduleFlow.setJobType(schedule.getJobType());
					scheduleFlow.setTradeDate(tradeDate);
					scheduleFlow.setTradeTime(tradeTime);
					scheduleFlow.setSvcCode(schedule.getSvcCode());
					scheduleFlow.setScnCode(schedule.getScnCode());
					scheduleFlow.setSvcGroup(schedule.getSvcGroup());
					scheduleFlow.setStatus("U");// 调度刚开始，状态未知
					scheduleFlow.setErrorCode(CommConstant.UNKNOWCODE);
					scheduleFlow.setErrorMsg(CommConstant.UNKNOWMSG);
					scheduleService.addScheduleFlow(scheduleFlow);
					JavaDict rqd = new JavaDict();
					rqd.put(CommConstant.CSIS_HEADER, csisHeader);
					rqd.put(CommConstant.HEADER, header);
					rqd.put(CommConstant.APP_BODY, appBody);
					// 更新调度状态
					return new Object[] { 2, rqd };
				} else {
					throw new ApIllegalParamException("schetype");
				}
			}
		});
	}

	/**
	 * @category 调度作业总控消息返回
	 * @param REQ
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param RSP
	 *            入参|返回容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param status
	 *            入参|状态|{@link java.lang.String}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "REQ", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "RSP", comment = "返回容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "status", comment = "状态", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "调度作业总控消息返回", style = "判断型", type = "同步组件", comment = "调度作业总控", date = "2019-10-19 12:00:41")
	public static TCResult B_ScheduleControllerBack(JavaDict REQ, JavaDict RSP, String status) {
		return TechComp.call(() -> {

			logger.debug("RSP: " + RSP.toString());
			logger.debug("相关调度信息拼接");
			String outCode = "";
			String outMsg = "";
			JavaDict csisHeader = RSP.getDictItem(CommConstant.CSIS_HEADER, new JavaDict());// XXX
			JavaDict appBody = RSP.getDictItem(CommConstant.APP_BODY, new JavaDict());// XXX
			/*
			 * 返回信息组成： 错误码，错误信息，流水号，调度日期，调度时间，任务ID，任务名称，服务码，场景码，服务器，应用日志名
			 */
			if (status.equals("S")) {
				logger.info("设置成功错误码");
				String ErrorCode = csisHeader.getStringItem(CommConstant.ERROR_CODE, CommConstant.SUCCCODE);
				String ErrorMsg = csisHeader.getStringItem(CommConstant.ERROR_MSG, CommConstant.SUCCMSG);
				csisHeader.put(CommConstant.STATUS, status);
				csisHeader.put(CommConstant.ERROR_CODE, ErrorCode);
				csisHeader.put(CommConstant.ERROR_MSG, ErrorMsg);
			} else {// 失败/异常
				IContext context = EnvContextHolder.getHolder().getContext();
				csisHeader.put(CommConstant.STATUS, csisHeader.getStringItem(CommConstant.STATUS, status));
				if (csisHeader.get(CommConstant.ERROR_CODE) == null) { // XXX 去掉该判断，是否效率更好？
					csisHeader.put(CommConstant.ERROR_CODE,
							context.getProperty("ERR_CODE") == null ? CommConstant.FAILCODE
									: CommConstant.AFAFAIL.equals(context.getProperty("ERR_CODE"))
											? CommConstant.FAILCODE
											: context.getProperty("ERR_CODE"));
				}
				if (csisHeader.get(CommConstant.ERROR_MSG) == null) {
					csisHeader.put(CommConstant.ERROR_MSG, context.getProperty("ERR_MSG") == null ? CommConstant.FAILMSG
							: context.getProperty("ERR_MSG"));
				}
			}
			RSP.clear();
			RSP.put("OUT_CODE", outCode);
			RSP.put("OUT_MESG", outMsg);
			return null;
		});
	}

	/**
	 * @category 新增调度流水
	 * @param REQ
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param RSP
	 *            入参|返回容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "REQ", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "RSP", comment = "返回容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "新增调度流水", style = "判断型", type = "同步组件", comment = "新增调度流水", date = "2019-10-14 05:01:15")
	public static TCResult B_addScheduleFlow(JavaDict REQ, JavaDict RSP) {
		return TechComp.callWithBean(ScheduleService.class, (scheduleService) -> {
			logger.info("更新调度流水信息");
			JavaDict csisHeader = REQ.getDictItem(CommConstant.CSIS_HEADER);
			String gloSerNo = csisHeader.getStringItem(CommConstant.GloSeqNo);
			String status = csisHeader.getStringItem(CommConstant.STATUS);
			String errorCode = csisHeader.getStringItem(CommConstant.ERROR_CODE);
			String errorMsg = csisHeader.getStringItem(CommConstant.ERROR_MSG);
			ScheduleFlow scheduleFlow = new ScheduleFlow();
			scheduleService.updateScheduleFlow(scheduleFlow);
			// JavaDict appBody = REQ.getDictItem(CommConstant.APP_BODY);

			// if (condition) {
			// //XXX是否有某种情况下，要更新Sehedule配置表的信息？
			// }

			return null;
		});
	}

	/**
	 * @category 更新调度状态
	 * @param REQ
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param RSP
	 *            入参|返回容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "REQ", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "RSP", comment = "返回容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "更新调度状态", style = "判断型", type = "同步组件", comment = "更新调度状态", date = "2019-10-14 05:06:25")
	public static TCResult B_updateSchedule(JavaDict REQ, JavaDict RSP) {
		return TechComp.callWithBean(ScheduleService.class, (scheduleService) -> {
			JavaDict csisHeader = REQ.getDictItem(CommConstant.CSIS_HEADER);
			JavaDict appBody = REQ.getDictItem(CommConstant.APP_BODY);
			scheduleService.updateScheduleStatus(appBody.getStringItem("jobid"),
					csisHeader.getStringItem(CommConstant.STATUS, "U"));
			return null;
		});
	}

	/**
	 * @category 更新调度流水
	 * @param REQ
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param RSP
	 *            入参|返回容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "REQ", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "RSP", comment = "返回容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "更新调度流水", style = "判断型", type = "同步组件", comment = "更新调度流水", date = "2019-10-14 05:01:49")
	public static TCResult B_updateScheduleFlow(JavaDict REQ, JavaDict RSP) {
		return TechComp.callWithBean(ScheduleService.class, (scheduleService) -> {
			JavaDict csisHeader = REQ.getDictItem(CommConstant.CSIS_HEADER);
			JavaDict appBody = REQ.getDictItem(CommConstant.APP_BODY);
			ScheduleFlow scheduleFlow = new ScheduleFlow();
			scheduleFlow.setSeriNo(csisHeader.getStringItem(CommConstant.GloSeqNo));
			scheduleFlow.setErrorCode(csisHeader.getStringItem(CommConstant.ERROR_CODE)); // XXX 这三个状态信息，待完善
			scheduleFlow.setErrorMsg(csisHeader.getStringItem(CommConstant.ERROR_MSG));
			scheduleFlow.setStatus(csisHeader.getStringItem(CommConstant.STATUS));
			scheduleFlow.setTime(appBody.getIntItem("time"));
			scheduleFlow.setServer(appBody.getStringItem("server"));
			scheduleFlow.setServerLog(appBody.getStringItem("serverlog"));
			scheduleFlow.setProcessId(appBody.getStringItem("processid"));
			logger.info("ScheduleFlow: " + scheduleFlow);
			scheduleService.updateScheduleFlow(scheduleFlow);
			return null;
		});
	}

	/**
	 * @category 调度结果通知
	 * @param REQ
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param RSP
	 *            入参|返回容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "REQ", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "RSP", comment = "返回容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "调度结果通知", style = "判断型", type = "同步组件", comment = "调度结果通知", date = "2019-10-14 05:09:38")
	public static TCResult B_ScheduleFeedBack(JavaDict REQ, JavaDict RSP) {
		return TechComp.callWithBean(ScheduleService.class, (scheduleService) -> {
			JavaDict csisHeader = REQ.getDictItem(CommConstant.CSIS_HEADER);
			JavaDict appBody = REQ.getDictItem(CommConstant.APP_BODY);
			ScheduleFlow scheduleFlow = new ScheduleFlow();
			scheduleFlow.setSeriNo(csisHeader.getStringItem(CommConstant.GloSeqNo));
			scheduleFlow.setErrorCode(csisHeader.getStringItem(CommConstant.ERROR_CODE)); // XXX 这三个状态信息，待完善
			scheduleFlow.setErrorMsg(csisHeader.getStringItem(CommConstant.ERROR_MSG));
			scheduleFlow.setStatus(csisHeader.getStringItem(CommConstant.STATUS));
			scheduleFlow.setTime(appBody.getIntItem("time"));
			scheduleFlow.setServer(appBody.getStringItem("server"));
			scheduleFlow.setServerLog(appBody.getStringItem("serverlog"));
			scheduleFlow.setProcessId(appBody.getStringItem("processid"));
			scheduleService.updateScheduleFlow(scheduleFlow);
			return null;
		});
	}

	/**
	 * @category 调度交易开始
	 * @param req
	 *            入参|请求容器| {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param rsp
	 *            入参|应答容器| {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	@InParams(param = {
			@Param(name = "req", comment = "请求容器", defaultParam = "__REQ__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "rsp", comment = "应答容器", defaultParam = "__RSP__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class), })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@Component(label = "调度交易开始", style = "判断型", type = "同步组件", author = "acz,hcp", date = "2019-01-24 02:54:12")
	public static TCResult B_tradeStart(JavaDict req, JavaDict rsp) {
		return TechComp.call(() -> {
			logger.info("调度交易初始化并预先通知调度总控");
			if (!rsp.hasKey(CommConstant.CSIS_HEADER)) {
				rsp.put(CommConstant.CSIS_HEADER, req.get(CommConstant.CSIS_HEADER));
			}
			if (!rsp.hasKey(CommConstant.HEADER)) {
				rsp.put(CommConstant.HEADER, new JavaDict());
			}
			if (!rsp.hasKey(CommConstant.APP_HEADER)) {
				rsp.put(CommConstant.APP_HEADER, new JavaDict());
			}
			if (!rsp.hasKey(CommConstant.APP_BODY)) {
				rsp.put(CommConstant.APP_BODY, new JavaDict());
			}
			rsp.getDictItem(CommConstant.CSIS_HEADER).put(CommConstant.STATUS, CommConstant.HANDSTATUS);
			rsp.getDictItem(CommConstant.CSIS_HEADER).put(CommConstant.ERROR_CODE, CommConstant.HANDCODE);
			rsp.getDictItem(CommConstant.CSIS_HEADER).put(CommConstant.ERROR_MSG, CommConstant.HANDMSG);
			// 通知调度总控，调度任务已开始
			TCResult msgResult = TradeResponseSender.sendResponseByBus(rsp);
			int status = msgResult.getStatus();
			if (status != 1) {
				throw new ApMsgInformFailException("调度执行进程", "调度总控进程");
			}
			// logger.debug("线程睡眠5秒");
			// Thread.sleep(5000);

			// 通知成功后，进行正常的交易处理之前，要清除状态码与消息码，避免影响后续交易流程。
			rsp.getDictItem(CommConstant.CSIS_HEADER).remove(CommConstant.STATUS);
			rsp.getDictItem(CommConstant.CSIS_HEADER).remove(CommConstant.ERROR_CODE);
			rsp.getDictItem(CommConstant.CSIS_HEADER).remove(CommConstant.ERROR_MSG);

			return null;

		});
	}

	/**
	 * @category 调度交易退出
	 * @param req
	 *            入参|请求容器| {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param rsp
	 *            入参|应答容器| {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param status
	 *            入参|状态|{@link java.lang.String}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	@InParams(param = {
			@Param(name = "req", comment = "请求容器", defaultParam = "__REQ__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "rsp", comment = "应答容器", defaultParam = "__RSP__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "status", comment = "状态", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@Component(label = "调度交易退出", style = "判断型", type = "同步组件", author = "HCP", date = "2019-10-17 02:54:12")
	public static TCResult A_tradeExit(JavaDict req, JavaDict rsp, String status) {
		return TechComp.call(() -> {
			logger.debug("RSP: " + rsp.toString());
			JavaDict csisHeader = rsp.getDictItem(CommConstant.CSIS_HEADER, new JavaDict());// XXX
			if (status.equals("S")) {
				logger.info("设置成功错误码");
				String ErrorCode = csisHeader.getStringItem(CommConstant.ERROR_CODE, CommConstant.SUCCCODE);
				String ErrorMsg = csisHeader.getStringItem(CommConstant.ERROR_MSG, CommConstant.SUCCMSG);
				csisHeader.put(CommConstant.STATUS, status);
				csisHeader.put(CommConstant.ERROR_CODE, ErrorCode);
				csisHeader.put(CommConstant.ERROR_MSG, ErrorMsg);
			} else {// 失败/异常
				IContext context = EnvContextHolder.getHolder().getContext();
				csisHeader.put(CommConstant.STATUS, csisHeader.getStringItem(CommConstant.STATUS, status));
				if (csisHeader.get(CommConstant.ERROR_CODE) == null) { // XXX 去掉该判断，是否效率更好？
					csisHeader.put(CommConstant.ERROR_CODE,
							context.getProperty("ERR_CODE") == null ? CommConstant.FAILCODE
									: CommConstant.AFAFAIL.equals(context.getProperty("ERR_CODE"))
											? CommConstant.FAILCODE
											: context.getProperty("ERR_CODE"));
				}
				if (csisHeader.get(CommConstant.ERROR_MSG) == null) {
					csisHeader.put(CommConstant.ERROR_MSG, context.getProperty("ERR_MSG") == null ? CommConstant.FAILMSG
							: context.getProperty("ERR_MSG"));
				}
			}
			return null;
		});
	}

	/**
	 * @category 定时任务请求容器初始化
	 * @param seqName
	 *            入参|获取流水序列名称|{@link java.lang.String}
	 * @param req
	 *            入参|请求容器,用于保存应用系统参数信息|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = { @Param(name = "seqName", comment = "获取流水序列名称", type = java.lang.String.class),
			@Param(name = "req", comment = "请求容器,用于保存应用系统参数信息", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "定时任务请求容器初始化", style = "判断型", type = "同步组件", date = "2019-12-24 02:21:00")
	public static TCResult B_scheContainerInit(String seqName, JavaDict req) {
		return TechComp.call(() -> {
			// 报文头初始化
			JavaDict CsisHeader = new JavaDict();
			// CsisHeader请求信息初始化
			CsisHeader.setItem("VrsNo", "100");
			CsisHeader.setItem("ScnNo", "10");
			CsisHeader.setItem("SrcDate", DateTimeUtil.getSysDate());
			CsisHeader.setItem("SrcTime", DateTimeUtil.getSysTime());
			CsisHeader.setItem("SrcSysId", "0310");
			CsisHeader.setItem("SrcCalCod", "CSI");
			CsisHeader.setItem("GloSeqNo", SernoGenUtil.getGSerno("0310", seqName));
			CsisHeader.setItem("GloEndTime", "");
			CsisHeader.setItem("ReqNo", SernoGenUtil.getSerno(seqName));
			CsisHeader.setItem("BrNo", "0010102301"); // 所属网点
			CsisHeader.setItem("TellerNo", "001M00005"); // 虚拟柜员
			CsisHeader.setItem("TellerTp", "1"); // 柜员类型 0真实柜员 1虚拟柜员
			CsisHeader.setItem("ZoneNo", "0010101904"); // 所属分行
			CsisHeader.setItem("MyBank", "001"); // 法人号
			// 请求容器初始化
			req.setItem("APPBody", new JavaDict());
			req.setItem("CsisHeader", CsisHeader);
			req.setItem("AppHeader", new JavaDict());

			return new Object[] {};
		});
	}
}
