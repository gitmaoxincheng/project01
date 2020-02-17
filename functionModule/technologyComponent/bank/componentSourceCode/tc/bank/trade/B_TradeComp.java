package tc.bank.trade;

import java.util.Map;

import ap.ide.techcomp.TechComp;
import cn.com.agree.afa.svc.holder.EnvContextHolder;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.base.constant.SvcParam;
import cn.com.agree.huanan.ap.rl.bank.encrypt.exception.MacCheckException;
import cn.com.agree.huanan.ap.rl.bank.encrypt.service.UnionAPIService;
import cn.com.agree.huanan.ap.rl.bank.trade.po.TimeOutFlow;
import cn.com.agree.huanan.ap.rl.bank.trade.po.TradeFlow;
import cn.com.agree.huanan.ap.rl.bank.trade.service.TradeFlowService;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;
import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * @date 2019-10-28 11:54:32
 */
@ComponentGroup(level = "银行", groupName = "渠道交易组件")
public class B_TradeComp {
	private static Logger logger = Logger.getLogger(B_TradeComp.class);
	private static SvcParam svcParam = SpringUtil.getBean(SvcParam.class);

	/**
	 * @category 渠道请求处理
	 * @param req
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param authInfo
	 *            入参|授权信息|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since RQD 出参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "req", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "authInfo", comment = "授权信息", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = {
			@Param(name = "RQD", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@Component(label = "渠道请求处理", style = "判断型", type = "同步组件", comment = "渠道请求处理", date = "2019-12-30 01:01:17")
	public static TCResult B_dealReqInfo(JavaDict req, JavaDict authInfo) {
		return TechComp.callWithBean(TradeFlowService.class, (tradeFlowService) -> {
			JavaDict RQD = req.getDictItem("__RQD__"); // 正式
			JavaDict header = RQD.getDictItem(CommConstant.HEADER);
			JavaDict oriheader = req.getDictItem(CommConstant.HEADER);
			JavaDict rHeader = new JavaDict();
			rHeader.put(CommConstant.REQCALCOD, authInfo.get(CommConstant.REQCALCOD));
			rHeader.put(CommConstant.ADDRESS, oriheader.get(CommConstant.ADDRESS));
			rHeader.put(CommConstant.EXSVC, authInfo.get(CommConstant.EXSVC));
			rHeader.put(CommConstant.EXSCN, authInfo.get(CommConstant.EXSCN));
			RQD.put(CommConstant.HEADER, rHeader);
			oriheader.putAll(authInfo);
			// header.put(CommConstant.REQCALCOD, authInfo.get(CommConstant.REQCALCOD));
			// header.put(CommConstant.EXSVC, authInfo.get(CommConstant.EXSVC));
			// header.put(CommConstant.EXSCN, authInfo.get(CommConstant.EXSCN));
			// header.remove(CommConstant.ACTION);
			String regflag = authInfo.getStringItem(CommConstant.REGFLG); // 场景级别标识
			// String chkFlag = authInfo.getStringItem(CommConstant.CHKFLG);// 渠道级别标识
			if ("0".equals(regflag)) {
				// 添加流水记录
				logger.info("登记渠道请求流水");
				TradeFlow tradeFlow = B_TradeComp.gatheTradeFlow(req);
				tradeFlowService.addTradeFlow(tradeFlow);
				req.put("__REGFLOW__", true); // 登记流水标识
			} else if ("2".equals(regflag)) {
				logger.info("登记超时交易流水");
				TimeOutFlow timeOutFlow = B_TradeComp.gatheTimeOutFlow(req);
				tradeFlowService.addTimeOut(timeOutFlow);
				req.put("__REGFLOW2__", true); // 登记流水,超时流水登记标识是否要区分XXX
			} else {
				logger.info("不登记交易流水");
				// 其他则不做任何处理
			}
			
			String svcType = authInfo.getStringItem(CommConstant.SVCTYPE);//交易类型
			if ("4".equals(svcType)) { //超时流水列表查询，直接返回流水列表给请求方
				Map<String, Object> timeOutFlowListInfo = getTimeOutFlowList(req);
				JavaDict rsp = (JavaDict) EnvContextHolder.getHolder().getContext().getResponse();
				rsp.put(CommConstant.APP_BODY, timeOutFlowListInfo);
			}else if ("5".equals(svcType)) { //超时流水处理
				Map<String, Object> timeOutFlow = getTimeOutFlow(req);
				JavaDict body = req.getDictItem(CommConstant.APP_BODY);
				body.putAll(timeOutFlow); //将流水信息带到超时流水处理交易
			}
			// 正式交易请求报文重组
			RQD.put(CommConstant.APP_BODY, req.get(CommConstant.APP_BODY));
			return new Object[] { RQD };
		});
	}

	/**
	 * @category 服务路由
	 * @param req
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param authInfo
	 *            入参|授权信息|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since RQD 出参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "req", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "authInfo", comment = "授权信息", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = {
			@Param(name = "RQD", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@Component(label = "服务路由", style = "判断型", type = "同步组件", comment = "服务路由", date = "2019-12-30 01:41:23")
	public static TCResult B_routeReq(JavaDict req, JavaDict authInfo) {
		return TechComp.call(() -> {
			// 服务请求信息处理
			// 服务路由
			// 服务返回信息处理
			return null;
		});
	}

	/**
	 * @category 登记渠道请求流水
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
	@Component(label = "登记渠道请求流水", style = "判断型", type = "同步组件", comment = "登记渠道请求流水", date = "2019-10-14 05:01:15")
	public static TCResult B_addTradeFlow(JavaDict REQ, JavaDict RSP) {
		return TechComp.callWithBean(TradeFlowService.class, (tradeFlowService) -> {
			JavaDict header = REQ.getDictItem(CommConstant.HEADER);
			String regflag = header.getStringItem(CommConstant.REGFLG); // 该部分应该可以换成把授权数据作为一部分传递进来
			if ("0".equals(regflag)) {
				// 添加流水记录
				logger.info("登记渠道请求流水");
				TradeFlow tradeFlow = B_TradeComp.gatheTradeFlow(REQ);
				tradeFlowService.addTradeFlow(tradeFlow);
				REQ.put("__REGFLOW__", true); // 登记流水标识
			} else if ("2".equals(regflag)) {
				logger.info("登记超时交易流水");
				TimeOutFlow timeOutFlow = B_TradeComp.gatheTimeOutFlow(REQ);
				tradeFlowService.addTimeOut(timeOutFlow);
				REQ.put("__REGFLOW2__", true); // 登记流水,超时流水登记标识是否要区分XXX
			} else {
				logger.info("不登记交易流水");
				// 不登记流水 0 ，或者非1,2，则不做任何东西
			}
			return null;
		});
	}

	/**
	 * @category 更新渠道请求流水
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
	@Component(label = "更新渠道请求流水", style = "判断型", type = "同步组件", comment = "更新渠道请求流水", date = "2019-10-28 03:43:49")
	public static TCResult B_updateTradeFlow(JavaDict REQ, JavaDict RSP) {
		return TechComp.callWithBean(TradeFlowService.class, (tradeFlowService) -> {
			logger.info("更新渠道请求流水");
			JavaDict csisHeader = REQ.getDictItem(CommConstant.CSIS_HEADER);
			JavaDict header = REQ.getDictItem(CommConstant.HEADER);
			// TradeFlow tradeFlow = new TradeFlow();
			// CsisHeader上的内容
			String reqSerialNo = csisHeader.getStringItem(CommConstant.REQNO);// 请求交易流水号
			String reqSysId = header.getStringItem(CommConstant.REQSYSID);// 请求渠道编号
			String status = csisHeader.getStringItem(CommConstant.STATUS);
			String errorCode = csisHeader.getStringItem(CommConstant.ERROR_CODE);
			String errorMsg = csisHeader.getStringItem(CommConstant.ERROR_MSG);
			int tolTime = (int) (System.currentTimeMillis() - REQ.getLongItem("__TRADETIME__")); // 交易耗时
			tradeFlowService.updateTradeFlow(reqSysId, reqSerialNo, status, errorCode, errorMsg, tolTime);
			String regflag = header.getStringItem(CommConstant.REGFLG);
			logger.info("regflag : " + regflag);
			if (regflag.equals("2")) { // regflag为2，则更新
				logger.info("更新超时交易流水");
				tradeFlowService.updateTimeOut(reqSysId, reqSerialNo, status, errorCode, errorMsg, 100);
			}
			return null;
		});
	}

	public static TimeOutFlow gatheTimeOutFlow(JavaDict REQ) {
		logger.info("获取渠道超时流水数据");
		JavaDict csisHeader = REQ.getDictItem(CommConstant.CSIS_HEADER);
		JavaDict header = REQ.getDictItem(CommConstant.HEADER);
		JavaDict appHeader = REQ.getDictItem(CommConstant.APP_HEADER);
		// JavaDict appBody = REQ.getDictItem(CommConstant.APP_BODY);
		TimeOutFlow timeOutFlow = new TimeOutFlow();
		// CsisHeader上的内容
		timeOutFlow.setReqSerialNo(csisHeader.getStringItem(CommConstant.REQNO)); // 请求交易流水号
		timeOutFlow.setSrcSysId(csisHeader.getStringItem(CommConstant.SRCSYSID));// 源请求方系统标识
		timeOutFlow.setSrcCalCod(csisHeader.getStringItem(CommConstant.SRCCALCOD));// 源请求方渠道编码
		timeOutFlow.setGloSeqNo(csisHeader.getStringItem(CommConstant.GloSeqNo));// 全局流水号
		timeOutFlow.setTradeDate(DateTimeUtil.getSysDate());// 平台交易日期
		timeOutFlow.setTradeTime(DateTimeUtil.getSysTime());// 平台交易时间
		timeOutFlow.setReqDate(csisHeader.getStringItem(CommConstant.SRCDATE));// 请求方日期
		timeOutFlow.setReqTime(csisHeader.getStringItem(CommConstant.SRCTIME));// 请求方时间
		timeOutFlow.setTellerNo(csisHeader.getStringItem(CommConstant.TLRNO));// 柜员号
		timeOutFlow.setTellerTp(csisHeader.getStringItem(CommConstant.TLRTP));// 柜员类型
		timeOutFlow.setMyBank(csisHeader.getStringItem(CommConstant.MYBANK)); // 法人号
		timeOutFlow.setZoneNo(csisHeader.getStringItem(CommConstant.ZONENO));// 分行号
		timeOutFlow.setBrNo(csisHeader.getStringItem(CommConstant.BRNO));// 网点号
		timeOutFlow.setSerialNo(csisHeader.getStringItem(CommConstant.SERINO));// 平台流水号
		// Header上的内容
		timeOutFlow.setSvcOutCode(header.getStringItem(CommConstant.EXSVC));
		timeOutFlow.setScnOutCode(header.getStringItem(CommConstant.EXSCN));
		timeOutFlow.setReqSysId(header.getStringItem(CommConstant.ADDRESS));
		timeOutFlow.setSvcCode(header.getStringItem(CommConstant.SVCCODE));
		timeOutFlow.setScnCode(header.getStringItem(CommConstant.SCNCODE));
		// AppHeader上的内容
		timeOutFlow.setDevNo(appHeader.getStringItem(CommConstant.DEVNO));// 设备编号
		timeOutFlow.setAuthTellerNo(appHeader.getStringItem(CommConstant.AUTHNO));// 授权柜员
		timeOutFlow.setMbrNo(appHeader.getStringItem(CommConstant.MBRNO));// 支行号
		timeOutFlow.setBussCeNo(appHeader.getStringItem(CommConstant.BUSINO));// 业务流水号
		timeOutFlow.setUpdDate(timeOutFlow.getTradeDate());
		timeOutFlow.setTradeTime(timeOutFlow.getTradeTime());

		timeOutFlow.setTraceId(REQ.getStringItem(CommConstant.TraceId));
		// 业务参数
		Map<String, Object> billInfo = (Map<String, Object>) appHeader.get("BillJson");
		if (null != billInfo) {
			timeOutFlow.setTradeName(header.getStringItem("tradename")); // 交易名称
			timeOutFlow.setCustNo((String) billInfo.get("custno")); // 客户号
			timeOutFlow.setCustName((String) billInfo.get("custname")); // 客户名称
			timeOutFlow.setAcctNo((String) billInfo.get("acctno")); // 账号
			timeOutFlow.setOppAcctNo((String) billInfo.get("oppacctno")); // 账户名称
			timeOutFlow.setAmount((String) billInfo.get("amount")); // 金额
			timeOutFlow.setBillNo((String) billInfo.get("billno")); // 单据号
			timeOutFlow.setBillType((String) billInfo.get("billtype")); // 交易类型
		}

		// 预填错误信息
		timeOutFlow.setRespSts(CommConstant.UNKNOWSTATUS);
		timeOutFlow.setErrorMsg(CommConstant.UNKNOWMSG);
		timeOutFlow.setErrorCode(CommConstant.UNKNOWCODE);
		return timeOutFlow;
	}

	public static TradeFlow gatheTradeFlow(JavaDict REQ) {
		logger.info("获取渠道请求流水数据");
		JavaDict csisHeader = REQ.getDictItem(CommConstant.CSIS_HEADER);
		JavaDict header = REQ.getDictItem(CommConstant.HEADER);
		JavaDict appHeader = REQ.getDictItem(CommConstant.APP_HEADER);
		// JavaDict appBody = REQ.getDictItem(CommConstant.APP_BODY);
		TradeFlow tradeFlow = new TradeFlow();
		// CsisHeader上的内容
		tradeFlow.setReqSerialNo(csisHeader.getStringItem(CommConstant.REQNO)); // 请求交易流水号
		tradeFlow.setSrcSysId(csisHeader.getStringItem(CommConstant.SRCSYSID));// 源请求方系统标识
		tradeFlow.setSrcCalCod(csisHeader.getStringItem(CommConstant.SRCCALCOD));// 源请求方渠道编码
		tradeFlow.setGloSeqNo(csisHeader.getStringItem(CommConstant.GloSeqNo));// 全局流水号
		tradeFlow.setTradeDate(DateTimeUtil.getSysDate());// 平台交易日期
		tradeFlow.setTradeTime(DateTimeUtil.getSysTime());// 平台交易时间
		tradeFlow.setReqDate(csisHeader.getStringItem(CommConstant.SRCDATE));// 请求方日期
		tradeFlow.setReqTime(csisHeader.getStringItem(CommConstant.SRCTIME));// 请求方时间
		tradeFlow.setTellerNo(csisHeader.getStringItem(CommConstant.TLRNO));// 柜员号
		tradeFlow.setTellerTp(csisHeader.getStringItem(CommConstant.TLRTP));// 柜员类型
		tradeFlow.setMyBank(csisHeader.getStringItem(CommConstant.MYBANK)); // 法人号
		tradeFlow.setZoneNo(csisHeader.getStringItem(CommConstant.ZONENO));// 分行号
		tradeFlow.setBrNo(csisHeader.getStringItem(CommConstant.BRNO));// 网点号
		tradeFlow.setSerialNo(csisHeader.getStringItem(CommConstant.SERINO));// 平台流水号

		// Header上的内容
		tradeFlow.setSvcOutCode(header.getStringItem(CommConstant.EXSVC));
		tradeFlow.setScnOutCode(header.getStringItem(CommConstant.EXSCN));
		tradeFlow.setReqCalCod(header.getStringItem(CommConstant.REQCALCOD));
		tradeFlow.setReqSysId(header.getStringItem(CommConstant.ADDRESS));
		tradeFlow.setSvcCode(header.getStringItem(CommConstant.SVCCODE));
		tradeFlow.setScnCode(header.getStringItem(CommConstant.SCNCODE));

		// AppHeader上的内容
		tradeFlow.setDevNo(appHeader.getStringItem(CommConstant.DEVNO));// 设备编号
		tradeFlow.setAuthTellerNo(appHeader.getStringItem(CommConstant.AUTHNO));// 授权柜员
		tradeFlow.setMbrNo(appHeader.getStringItem(CommConstant.MBRNO));// 支行号
		tradeFlow.setBussCeNo(appHeader.getStringItem(CommConstant.SRCTIME));// 业务流水号

		tradeFlow.setTraceId(REQ.getStringItem(CommConstant.TraceId));
		tradeFlow.setUpdDate(tradeFlow.getTradeDate());
		tradeFlow.setUpdTime(tradeFlow.getTradeTime());

		// 预填错误信息
		tradeFlow.setRespSts(CommConstant.UNKNOWSTATUS);
		tradeFlow.setErrorMsg(CommConstant.UNKNOWMSG);
		tradeFlow.setErrorCode(CommConstant.UNKNOWCODE);

		return tradeFlow;
	}
	
	/**
	 * 超时流水列表查询
	 */
	public static Map<String, Object> getTimeOutFlowList(JavaDict reqDict) {
			logger.info("超时流水列表查询");
			// 获取JsonHeader容器
			JavaDict appBody = reqDict.getDictItem("APPBody");
			String pageFlag = appBody.getStringItem("pageflag");// 页码
			String maxNum = appBody.getStringItem("maxnum");// 每页最多记录数
			String begDate = appBody.getStringItem("begdate");// 交易起始日期
			String endDate = appBody.getStringItem("endate");// 交易截止日期
			String sysId = appBody.getStringItem("sysid");// 交易截止日期
			String tellerNo = appBody.getStringItem("sysid");// 交易截止日期
			String brNo = appBody.getStringItem("brno");// 交易截止日期
			String billNo = appBody.getStringItem("billno");// 交易截止日期
/*			if (!StringUtils.isEmpty(trantype) && !"".equals(trantype) && trantype.length() == 13) {
				svcoutCode = trantype.substring(0, 10);
				scnoutCode = trantype.substring(10);
			}*/
/*			Map<String, Object> map = new HashMap<String, Object>();
			map.put("srcsysid", appBody.getStringItem("srcsysid"));
			map.put("billno", appBody.getStringItem("strbillno", ""));
			map.put("tellerno", appBody.getStringItem("strtellerno", ""));
			map.put("strbrno", appBody.getStringItem("strbrno", ""));
			map.put("svcoutCode", svcoutCode);
			map.put("scnoutCode", scnoutCode);*/
			TradeFlowService tradeFlowService = SpringUtil.getBean(TradeFlowService.class); //查询超时流水列表并返回
			Map<String, Object> result =tradeFlowService.queryTimeOutFlow(pageFlag, maxNum, begDate, endDate, sysId, tellerNo, brNo, billNo);
			return result;
	}
	
	/**
	 * 超时流水单笔验证
	 */
	public static Map<String, Object> getTimeOutFlow(JavaDict req) {
			logger.info("超时流水查询");
			JavaDict params = req.getDictItem(CommConstant.APP_BODY); // 超时参数
			JavaDict header = req.getDictItem(CommConstant.HEADER); // 超时参数
			String reqSerialNo = params.getStringItem("oriserialno");
			String reqDate = params.getStringItem("oritradedate"); // 要不要考虑reqdate 跟 tradedate的区别?
			String sysId = params.getStringItem(CommConstant.ADDRESS);
			TradeFlowService tradeFlowService = SpringUtil.getBean(TradeFlowService.class);
			// 查询超时流水表
			Map<String, Object> record = tradeFlowService.queryTimeOutFlow(reqSerialNo, reqDate, sysId);
			return record;
	}
	
	
	/**
	 * @category Mac校验
	 * @param request
	 *            入参|请求报文|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param authInfo
	 *            入参|权限信息|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "request", comment = "请求报文", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "authInfo", comment = "权限信息", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@Component(label = "Mac校验", style = "判断型", type = "同步组件", comment = "mac校验", date = "2020-01-02 12:20:46")
	public static TCResult B_macCheck(JavaDict request, JavaDict authInfo) {
		if (!svcParam.isMacCheck()) { // Mac校验开关
			return TCResult.newSuccessResult();
		}
		String svcType = authInfo.getStringItem(CommConstant.SVCTYPE); //场景级别-交易类型
		if ("3".equals(svcType)) { // 如果类型为3，则不校验
			logger.info("非校验Mac交易");
			return TCResult.newSuccessResult();
		}
		return TechComp.callWithBean(UnionAPIService.class, (unionAPIService) -> {
			try {
				// 获取mac、devNo和原报文
				String mac = request.getStringItem("__MAC__");
				String devNo = request.getDictItem(CommConstant.APP_HEADER).getStringItem(CommConstant.DEVNO);
				String reqString = request.getStringItem("__MACS__");
				unionAPIService.macCheck(devNo, reqString, mac); // MAC校验,
			} catch (Exception e) {
				logger.exception(e);
				throw new MacCheckException();
			}
			return null;
		});
	}

}
