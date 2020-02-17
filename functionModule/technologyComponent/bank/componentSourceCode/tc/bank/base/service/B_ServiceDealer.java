package tc.bank.base.service;

import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.util.StringUtils;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.base.exception.IllegalReqFormatException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.StrUtil;
import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;
import tc.platform.constant.exception.CommonErrorCodeEnum;
import tc.platform.context.exception.BaseException;

/**
 * 服务事件
 * 
 * @date 2019-06-28 21:7:4
 */
@ComponentGroup(level = "银行", groupName = "服务治理")
public class B_ServiceDealer {
	public static final Logger logger = Logger.getLogger(B_ServiceDealer.class);

	/**
	 * @category 渠道通用校验
	 * @param req
	 *            入参|源请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since outReq
	 *        出参|转换后容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 * 		2 异常<br>
	 */
	@InParams(param = {
			@Param(name = "req", comment = "源请求容器", defaultParam = "__REQ__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = {
			@Param(name = "outReq", comment = "转换后容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功"),
			@Return(id = "2", desp = "异常") })
	@Component(label = "渠道通用校验", style = "判断型", type = "同步组件", comment = "渠道通用校验", date = "2020-01-05 08:24:03")
	public static TCResult B_chnlAuthCheck(JavaDict req) {
		// 注意：如果不做I校验，这里应该要有队REQ拆包完后的内容进行处理
		JavaDict header = req.getDictItem(CommConstant.HEADER);
		// 拆分对外服务码和场景码
		if(header==null) {
			throw new IllegalReqFormatException("请求Header不能为空");
		}
		if(header.getStringItem(CommConstant.ACTION)==null) {
			throw new IllegalReqFormatException("请求Action不能为空");
		}
		String[] action = header.getStringItem(CommConstant.ACTION).replaceAll(CommConstant.NAMESPACE, "") //XXX可优化
				.split("/");
		// 获取拆包中的对外服务码和场景码
		if (action.length < 2 || StrUtil.isEmpty(action[0]) || StrUtil.isEmpty(action[1])) {
			throw new IllegalReqFormatException("请求Action格式不正确");
		}
		logger.info("请求服务码:" + action[0] + ", 场景码:" + action[1]);
		
		JavaDict checkReq = new JavaDict();
		checkReq.put(CommConstant.CSIS_HEADER, req.getDictItem(CommConstant.CSIS_HEADER, new JavaDict()));
		checkReq.put(CommConstant.HEADER, header);
		
//		outReq.put(CommConstant.APP_HEADER, req.getDictItem(CommConstant.APP_HEADER, new JavaDict()));
		// outReq.put(CommConstant.APP_BODY, req.getDictItem(CommConstant.APP_BODY, new JavaDict()));//渠道权限认证不需要报文体内容
		// logger.info("outReq:"+outReq.toString());
		req.put("__RQD__", checkReq);
		return B_ServiceInvoker.B_syncInvoke("OPRCNTER", "CHNL0000", checkReq);
	}

	/**
	 * @category 标准报文请求重组
	 * @param req
	 *            入参|源请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since outReq
	 *        出参|转换后容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "req", comment = "源请求容器", defaultParam = "__REQ__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = {
			@Param(name = "outReq", comment = "转换后容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@Component(label = "标准报文请求重组", style = "判断型", type = "同步组件", comment = "服务异步调用", date = "2019-08-14 12:05:52")
	public static TCResult B_reCombineReq(JavaDict req) {
		JavaDict outReq = new JavaDict();
		outReq.put(CommConstant.CSIS_HEADER, req.getDictItem(CommConstant.CSIS_HEADER, new JavaDict()));
		outReq.put(CommConstant.HEADER, req.getDictItem(CommConstant.HEADER, new JavaDict()));
		outReq.put(CommConstant.APP_HEADER, req.getDictItem(CommConstant.APP_HEADER, new JavaDict()));
		// outReq.put(CommConstant.APP_BODY, req.getDictItem(CommConstant.APP_BODY, new
		// JavaDict()));//渠道权限认证不需要报文体内容
		// logger.info("outReq:"+outReq.toString());
		// return TechComp.callWithBean(beanType, tcRunner)
		return TCResult.newSuccessResult(outReq);
	}

	/**
	 * @category 请求内容重组
	 * @param req
	 *            入参|源请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since outReq
	 *        出参|转换后容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 * @throws BaseException
	 */
	@InParams(param = {
			@Param(name = "req", comment = "源请求容器", defaultParam = "__REQ__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = {
			@Param(name = "outReq", comment = "转换后容器", defaultParam = "__REQ__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "Soap报文请求重组", style = "判断型", type = "同步组件", comment = "服务异步调用", date = "2019-07-08 04:44:15")
	public static TCResult B_reCombineReq2(JavaDict req) throws BaseException { // XXX
		// 获取header报文头
		JavaDict header = req.getDictItem(CommConstant.HEADER);
		// 获取req节点
		JavaDict reqNode = req.getDictItem(CommConstant.SOAP_BODY, new JavaDict()).getDictItem(CommConstant.SOAP_REQ,
				new JavaDict());
		// 获取csisHeader
		JavaDict csisHeader = reqNode.getDictItem(CommConstant.CSIS_HEADER, new JavaDict());
		// 校验请求报文合法性
		String address = header.getDictItem(CommConstant.SOAP_HEADER_FROM, new JavaDict())
				.getStringItem(CommConstant.ADDRESS);
		String srcDate = csisHeader.getStringItem(CommConstant.SRCDATE);
		String reqNo = csisHeader.getStringItem(CommConstant.REQNO);
		if (StringUtils.isNullOrEmpty(address)) {
			throw new BaseException(CommonErrorCodeEnum.MESSAGE_FIELD_EMPTY, "请求方系统标识Address缺失");
		}
		if (StringUtils.isNullOrEmpty(srcDate)) {
			throw new BaseException(CommonErrorCodeEnum.MESSAGE_FIELD_EMPTY, "请求方日期SrcDate缺失");
		}
		if (StringUtils.isNullOrEmpty(reqNo)) {
			throw new BaseException(CommonErrorCodeEnum.MESSAGE_FIELD_EMPTY, "上送流水ReqNo缺失");
		}

		JavaDict outReq = new JavaDict();
		outReq.put(CommConstant.CSIS_HEADER, csisHeader);
		outReq.put(CommConstant.HEADER, header);
		outReq.put(CommConstant.APP_HEADER, reqNode.getDictItem(CommConstant.APP_HEADER, new JavaDict()));
		outReq.put(CommConstant.APP_BODY, reqNode.getDictItem(CommConstant.APP_BODY, new JavaDict()));
		logger.info(outReq.toString());
		// return TechComp.callWithBean(beanType, tcRunner)
		return TCResult.newSuccessResult(outReq);
	}

}
