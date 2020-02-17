package tc.bank.message;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ab.trademessagesender.AFATradeMessageSender;
import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.TCResult;
import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * 给制定交易发送消息.
 * 
 * @author 刘绕兴
 * @date 2019-07-19 10:34:27
 */
@ComponentGroup(level = "银行", groupName = "AB交易组件")
public class B_ABTradeMessageSender {

	@InParams(param = {
			@Param(name = "parentConnectionUrl", comment = "服务器地址(tcp://10.1.1.50:50002)", type = java.lang.String.class),
			@Param(name = "clientOid", comment = "客户端Oid", type = java.lang.String.class),
			@Param(name = "tradeCode", comment = "AB交易码", type = java.lang.String.class),
			@Param(name = "app", comment = "消息类型", type = java.lang.String.class),
			@Param(name = "message", comment = "消息内容", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"),
			@Return(id = "1", desp = "成功") })
	@Component(label = "给制定oid客户指定交易发送消息", style = "判断型", type = "同步组件", comment = "给制定oid客户指定交易同步发送消息", date = "2019-07-18 02:04:39")
	public static TCResult sendByOid(String serverUrl, String clientOid,
			String tradeCode, String app, String message) {
		AppLogger.debug(String.format(
				"给(%s)的oid(%s)的交易(%s)发送app=%s,message=%s", serverUrl,
				clientOid, tradeCode, app, message));
		AFATradeMessageSender sender = new AFATradeMessageSender(serverUrl);
		Map<String, String> props = new HashMap<String, String>();
		props.put("tradeCode", tradeCode);
		try {
			sender.sendByOid(clientOid, props, app, message);
		} catch (IOException e) {
			AppLogger.error(e);
			return TCResult.newFailureResult("3", "消息发送失败!");
		}
		return TCResult.newSuccessResult();
	}

	@InParams(param = {
			@Param(name = "parentConnectionUrl", comment = "服务器地址", type = java.lang.String.class),
			@Param(name = "clientOid", comment = "客户端Oid", type = java.lang.String.class),
			@Param(name = "tradeCode", comment = "AB交易码", type = java.lang.String.class),
			@Param(name = "app", comment = "消息类型", type = java.lang.String.class),
			@Param(name = "message", comment = "消息内容", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"),
			@Return(id = "1", desp = "成功") })
	@Component(label = "给制定oid客户指定交易发送消息", style = "判断型", type = "同步组件", comment = "给制定oid客户指定交易异步发送消息", date = "2019-07-18 02:04:39")
	public static TCResult oneWayByOid(String serverUrl, String clientOid,
			String tradeCode, String app, String message) {
		AppLogger.debug(String.format(
				"给(%s)的oid(%s)的交易(%s)发送app=%s,message=%s", serverUrl,
				clientOid, tradeCode, app, message));
		AFATradeMessageSender sender = new AFATradeMessageSender(serverUrl);
		Map<String, String> props = new HashMap<String, String>();
		props.put("tradeCode", tradeCode);
		try {
			sender.oneWayByOid(clientOid, props, app, message);
		} catch (IOException e) {
			AppLogger.error(e);
			return TCResult.newFailureResult("3", "消息发送失败!");
		}
		return TCResult.newSuccessResult();
	}
}
