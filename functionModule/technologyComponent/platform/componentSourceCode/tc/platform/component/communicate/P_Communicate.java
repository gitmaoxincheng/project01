package tc.platform.component.communicate;

import java.util.Collections;
import java.util.Map;

import ap.ide.techcomp.TechComp;
import ap.ide.utils.JavaDictUtil;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.service.ChannelServiceImpl;
import cn.com.agree.huanan.ap.tl.communicate.comm.adapter.context.AdapterContext;
import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.comm.manager.CommunicateAdapterManager;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;
import tc.platform.base.P_Logger;

/**
 * 通信类
 * 
 * @date 2019-07-02 9:17:6
 */
@ComponentGroup(level = "平台", groupName = "通讯类组件")
public class P_Communicate {
	private static Logger logger = Logger.getLogger(P_Logger.class);

	/**
	 * @category 通信组件（字符串）
	 * @param appId
	 *            入参|应用ID标识|{@link java.lang.String}
	 * @param commItem
	 *            入参|通信配置|{@link java.lang.String}
	 * @param msg
	 *            入参|发送报文|{@link java.lang.String}
	 * @param paramMap
	 *            入参|发送报文|{@link java.util.Map}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	@InParams(param = { @Param(name = "appId", comment = "应用ID标识", type = java.lang.String.class),
			@Param(name = "commItem", comment = "通信配置", type = java.lang.String.class),
			@Param(name = "msg", comment = "发送报文", type = java.lang.String.class),
			@Param(name = "paramMap", comment = "附加参数", type = java.util.Map.class) })
	@OutParams(param = { @Param(name = "result", comment = "返回结果", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@Component(label = "通信组件（字符串）", style = "判断型", type = "同步组件", comment = "通信组件（字符串）", author = "luo.hp", date = "2018-08-31 01:57:08")
	public static TCResult P_commString(String appId, String commItem, String msg, Map<String, Object> paramMap) {
		return TechComp.call(() -> {
			CommunicateAdapterManager.getCommAdapter(appId, commItem, "");
			logger.debug(msg);
			return new Object[] { CommunicateAdapterManager.getCommAdapter(appId, commItem)
					.addAdditionParam(paramMap == null ? Collections.emptyMap() : paramMap).comm(msg).getMessage()
					.getStringMsg() };
		});
	}

	/**
	 * @category 通信组件（字节数组）
	 * @param appId
	 *            入参|应用ID标识|{@link java.lang.String}
	 * @param commItem
	 *            入参|通信配置|{@link java.lang.String}
	 * @param msg
	 *            入参|发送报文|byte
	 * @param paramMap
	 *            入参|附加参数|{@link java.util.Map}
	 * @param encoding
	 *            入参|返回字节数组编码|{@link java.lang.String}
	 * @since result 出参|返回结果|byte
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = { @Param(name = "appId", comment = "应用ID标识", type = java.lang.String.class),
			@Param(name = "commItem", comment = "通信配置", type = java.lang.String.class),
			@Param(name = "msg", comment = "发送报文", type = byte[].class),
			@Param(name = "paramMap", comment = "附加参数", type = java.util.Map.class),
			@Param(name = "encoding", comment = "返回字节数组编码", defaultParam = "'UTF-8'", type = java.lang.String.class) })
	@OutParams(param = { @Param(name = "result", comment = "返回结果", type = byte[].class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@Component(label = "通信组件（字节数组）", style = "判断型", type = "同步组件", comment = "通信组件（字节数组）", author = "Administrator", date = "2018-08-31 02:02:15")
	public static TCResult P_commBytes(String appId, String commItem, byte[] msg, Map<String, Object> paramMap, String encoding) {
		return TechComp.call(() -> {
			AdapterContext contextAdapter = CommunicateAdapterManager.getCommAdapter(appId, commItem);
			contextAdapter.addAdditionParam(paramMap == null ? Collections.emptyMap() : paramMap);
			CommContext context = contextAdapter.comm(msg);
			logger.debug("接收返回的报文：" + context.getMessage().getStringMsg());
			return new Object[] { context.getMessage().getBytesMsg(encoding) };
		});
	}

	/**
	 * @category 通讯组件
	 * @param appId 入参|应用ID标识|{@link java.lang.String}
	 * @param commItem 入参|通信配置|{@link java.lang.String}
	 * @param req 入参|请求报文容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since rsp 出参|返回报文容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>1 成功<br>
	 */
	@InParams(param = { @Param(name = "appId", comment = "应用ID标识", type = java.lang.String.class),
			@Param(name = "commItem", comment = "通信配置", type = java.lang.String.class),
			@Param(name = "req", comment = "请求报文容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = {
			@Param(name = "rsp", comment = "返回报文容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "通讯组件", style = "判断型", type = "同步组件", date = "2019-12-09 07:22:12")
	public static TCResult P_comm(String appId, String commItem, JavaDict req) {
		return TechComp.call(() -> {
			// 通过报文解析器将请求容器(JavaDict)转为XML/JSON
			String messageType = "JSON"; // TODO 从配置表获取
			String encoding = "UTF-8";
			ChannelServiceImpl channelServiceImpl = new ChannelServiceImpl(appId, commItem, messageType, encoding, encoding);
			Map<String, Object> reqMsgMap = JavaDictUtil.dictToMap(req, String.class, Object.class);
			channelServiceImpl.setRequestMsgMap(reqMsgMap);

			// 加载通讯配置,通讯发送请求报文(XML/JSON),通过报文解析器将返回报文(XML/JSON)解析到配置的O表里
			channelServiceImpl.exchange();

			// 将O表转为JavaDict
			Map<String, Object> rspMsgMap = channelServiceImpl.getResponseMsgMap();
			JavaDict rsp = JavaDictUtil.mapToDict(rspMsgMap);
			return new Object[] { rsp };
		});
	}

}
