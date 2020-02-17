package tc.bank.trade;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import ap.ide.techcomp.TechComp;
import ap.ide.utils.JavaDictUtil;
import cn.com.agree.afa.jcomponent.GlobalErrorHolder;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.trade.po.TimeOutCfg;
import cn.com.agree.huanan.ap.rl.bank.trade.service.TradeFlowService;
import cn.com.agree.huanan.ap.tl.logging.Logger;
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
public class B_ExptComp {
	private static Logger logger = Logger.getLogger(B_ExptComp.class);



	/**
	 * @category 获取超时处理方法
	 * @param params
	 *            入参|传入参数|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since resultMap
	 *        出参|返回结果|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 不需要处理<br>
	 *         2 超时处理<br>
	 *         3 渠道处理<br>
	 */
	@InParams(param = {
			@Param(name = "params", comment = "传入参数", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = {
			@Param(name = "resultMap", comment = "返回结果", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "不需要处理"),
			@Return(id = "2", desp = "超时处理"), @Return(id = "3", desp = "渠道处理") })
	@galaxy.ide.tech.cpt.Component(label = "获取超时处理方法", style = "判断型", type = "同步组件", date = "2019-12-28 10:52:03")
	public static TCResult B_findTreatmentTimeout(JavaDict params) {
		logger.info("获取超时处理方法");
		return TechComp.callWithBean(true, TradeFlowService.class, (tradeFlowService) -> {
			String reqserialno = params.getStringItem("oriserialno");
			String reqdate = params.getStringItem("oritradedate");
			String oritradecode = params.getStringItem("oritradecode");
			Map<String, Object> map = null; // TODO 未完成
			// tradeFlowService.findTimeOutFlow(reqserialno, reqdate, oritradecode);
			JavaDict resultMap = JavaDictUtil.mapToDict(map);
			if ("".equals(map.get("status"))) {
				if ("BASESVC".equals(map.get("tosvccode"))) {
					return new Object[] { 2, resultMap };
				} else {
					return new Object[] { 3, resultMap };
				}
			} else {
				return new Object[] { 1, resultMap };
			}
		});
	}

	/**
	 * @category 超时处理
	 * @param req
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since resultMap 出参|返回结果|{@link Object}
	 * @since cfginfo 出参|超时配置信息|{@link Object}
	 * @since rqd 出参|请求信息|{@link Object}
	 * @return 0 失败<br>
	 *         1 本地状态返回<br>
	 *         2 状态级联查询<br>
	 */
	@InParams(param = {
			@Param(name = "req", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = { @Param(name = "resultMap", comment = "返回结果", type = Object.class),
			@Param(name = "cfginfo", comment = "超时配置信息", type = Object.class),
			@Param(name = "rqd", comment = "请求信息", type = Object.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "本地状态返回"),
			@Return(id = "2", desp = "状态级联查询") })
	@galaxy.ide.tech.cpt.Component(label = "超时处理", style = "判断型", type = "同步组件", date = "2020-01-05 08:09:22")
	public static TCResult B_dealTimeOutFlow(JavaDict req) {
		return TechComp.callWithBean(true, TradeFlowService.class, (tradeFlowService) -> {
			logger.info("超时处理");
			JavaDict params = req.getDictItem(CommConstant.APP_BODY); // 超时参数
			String reqSerialNo = params.getStringItem("oriserialno");
			String reqDate = params.getStringItem("oritradedate"); // 要不要考虑reqdate 跟 tradedate的区别?
			String tradeCode = params.getStringItem("oritradecode");
			String sysId = params.getStringItem("oritradecode");
			String serialNo = params.getStringItem("serialno");
			String tradeDate = params.getStringItem("tradedate");
			// 入参：服务码，场景码（交易码），(由渠道上送) + 渠道流水号，交易日期，渠道系统标识（目前由接入层）
			/*
			 * 1、查询超时映射配置， 2、查询主登记簿流水状态 3、如果涉及需要后台交易查证的，则查询后台交易验证状态
			 */
			// 查询超时配置
			TimeOutCfg cfgInfo = tradeFlowService.queryTimeOutCfg(tradeCode);
			String mainTable = cfgInfo.getMainTable();
			String subTable = cfgInfo.getSubTable();
			String tradeType = cfgInfo.getTradeType();
			String toSvcCode = cfgInfo.getToSvcCode();
			String toScnCode = cfgInfo.getToScnCode();

			// Map<String, String> cfgMap = new HashMap<>();

			// 类型0，直接以后台统一超时接口为准
			if ("0".equals(tradeType)) {
				JavaDict rqd = new JavaDict();
				rqd.put(CommConstant.CSIS_HEADER, req.getDictItem(CommConstant.CSIS_HEADER));
				rqd.put(CommConstant.APP_BODY, req.getDictItem(CommConstant.APP_BODY));
				rqd.put(CommConstant.HEADER, req.getDictItem(CommConstant.HEADER));
				req.put("__toSvcCode__", toSvcCode);
				req.put("__toScnCode__", toScnCode);
				return new Object[] { 2, null, cfgInfo, rqd };
			}
			// 查询登记簿
			Map<String, Object> record = tradeFlowService.queryRegistInfo(mainTable, subTable, serialNo, tradeDate);
			String status = (String) record.get("status");
			Map<String, Object> result = new HashMap<>();
			result.put("tradedate", record.get("tradedate"));
			result.put("serialno", serialNo);
			result.put("status", record.get("respsts"));
			result.put("errorcode", record.get("errorcode"));
			result.put("errormsg", record.get("errormsg"));

			// 从登记簿查询到交易已为终态，直接返回
			if ("F".equals(status) || "S".equals(status)) {
				return new Object[] { 1, result, null, null };
			}

			// 类型1，查询本地登记簿后，如未确定交易终态，则以后台统一超时接口为准
			if ("1".equals(tradeType)) {// 查询后台交易状态
				JavaDict rqd = new JavaDict();
				rqd.put(CommConstant.CSIS_HEADER, req.getDictItem(CommConstant.CSIS_HEADER));
				rqd.put(CommConstant.APP_BODY, req.getDictItem(CommConstant.APP_BODY));
				rqd.put(CommConstant.HEADER, req.getDictItem(CommConstant.HEADER));
				req.put("__toSvcCode__", toSvcCode);
				req.put("__toScnCode__", toScnCode);
				return new Object[] { 2, null, cfgInfo, rqd };
			} else {
				// 类型2，查询本地登记簿后，以登记簿交易状态为准
				return new Object[] { 1, result, null, null };
			}
		});
	}

	/**
	 * @category 处理级联流水
	 * @param req
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param cfgInfo
	 *            入参|超时配置信息|{@link Object}
	 * @param backFlow
	 *            入参|级联交易流水信息|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since resultMap
	 *        出参|返回结果|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "req", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "cfgInfo", comment = "超时配置信息", type = Object.class),
			@Param(name = "backFlow", comment = "级联交易流水信息", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = {
			@Param(name = "resultMap", comment = "返回结果", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "处理级联流水", style = "判断型", type = "同步组件", comment = "处理级联流水", date = "2020-01-05 08:18:28")
	public static TCResult B_dealBackSysFlow(JavaDict req, Object cfgInfo, JavaDict backFlow) {
		return TechComp.callWithBean(TradeFlowService.class, (tradeFlowService) -> {
			logger.info("超时处理");
			// 入参：服务码，场景码（交易码），(由渠道上送) + 渠道流水号，交易日期，渠道系统标识（目前由接入层）
			/*
			 * 1、查询超时映射配置， 2、查询主登记簿流水状态 3、如果涉及需要后台交易查证的，则查询后台交易验证状态
			 */
			// 查询超时配置
			Map<String, Object> record = null;
			// 查询登记簿

			// 后台返回信息
			JavaDict csisHeader = backFlow.getDictItem(CommConstant.CSIS_HEADER);
			// 这部分逻辑应持续验证，如果后台系统能保持同一返回规则，将交易状态在报文体返回，则可使用该判断
			String rspSts = csisHeader.getStringItem(CommConstant.STATUS);
			String rspCode = csisHeader.getStringItem(CommConstant.ERROR_CODE);
			String respMsg = csisHeader.getStringItem(CommConstant.ERROR_MSG);
			if (!"S".equals(rspSts)) {
				GlobalErrorHolder.setGlobalError(rspSts, rspCode, "同步关联系统交易状态失败，原因:" + respMsg);
				return new Object[] { 0 };
			}

			JavaDict body = backFlow.getDictItem(CommConstant.APP_BODY); // 具体的交易状态放在APPBody返回
			String backStatus = body.getStringItem("status");
			String backErrorMsg = body.getStringItem("errormsg");
			String backErrorCode = body.getStringItem("errorcode");

			JavaDict params = req.getDictItem(CommConstant.APP_BODY); // 超时参数
			String reqSerialNo = params.getStringItem("oriserialno");
			String reqDate = params.getStringItem("oritradedate"); // 要不要考虑reqdate 跟 tradedate的区别?
			String tradeCode = params.getStringItem("oritradecode");
			String sysId = params.getStringItem("oritradecode");
			String serialNo = params.getStringItem("serialno");
			String tradeDate = params.getStringItem("tradedate");
			// 更新登记簿消息，现定义只有终态才更新
			if ("S".equals(backStatus) || "F".equals(backStatus)) {
				logger.info("已查询关联后台系统确定交易状态，更新本系统交易登记簿");
				TimeOutCfg cfgBean = (TimeOutCfg) cfgInfo;
				String tableName = cfgBean.getMainTable();
				tradeFlowService.updateTable(tableName, serialNo, tradeDate, backStatus, backErrorCode, backErrorCode);
				// 目前规则更新失败则返回报错
			}
			// 以上步骤没问题则返回交易状态
			Map<String, Object> result = new HashMap<>();
			result.put("tradedate", record.get("tradedate"));
			result.put("serialno", serialNo);
			result.put("status", backStatus);
			result.put("errorcode", backErrorCode);
			result.put("errormsg", backErrorMsg);
			return new Object[] { result };
		});
	}

}
