package cn.com.agree.huanan.ap.al.io.service.enc;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.C013002001 超时交易结果查询.ECIF超时交易结果查询 
 * C0130020.01 ECIF119
 * 0337 企业级客户信息管理系统
 * @author zhonggp
 */
@Component
public class C013002001 extends EsbChannelService {

	private static C013002001_I i = new C013002001_I();
	private static C013002001_O o = new C013002001_O();

	public C013002001() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013002001_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("serialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "reqseqno", 50,0, true, "消费方流水号" )))
					.addNode(new FieldNode("reqsyscd", new MsgField(ContentEnum.MessageType.STRING.toString(), "reqsyscd", 4,0, true, "消费方系统标识" )))
					.addNode(new FieldNode("trandate", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandate", 8,0, true, "交易日期" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class C013002001_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("txcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "txcode", 32,0, false, "ESB交易码(服务ID+场景ID)" )))
					.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, false, "客户号" )))
					.addNode(new FieldNode("txname", new MsgField(ContentEnum.MessageType.STRING.toString(), "txname", 32,0, false, "ECIF交易码" )))
					.addNode(new FieldNode("txcnname", new MsgField(ContentEnum.MessageType.STRING.toString(), "txcnname", 80,0, false, "交易名称" )))
					.addNode(new FieldNode("txrtncd", new MsgField(ContentEnum.MessageType.STRING.toString(), "errorcode", 10,0, false, "交易返回码" )))
					.addNode(new FieldNode("txrtnmsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "errormsg", 255,0, false, "交易返回描述" )))
					.addNode(new FieldNode("srcsyscd", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysid", 4,0, false, "源请求方系统标识" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
		
		
	}
	@Override
	public Map<String, Object> initOutContent(Map<String, Object> sendContext, Map<String, Object> recvContext) {
		super.initOutContent(sendContext, recvContext);
		if (CommConstant.SUCCSTATUS.equals(isTradeSuccess(recvContext))) {
			// 企业级客户信息管理系统
			//   txrtncd     交易返回码：10个A成功，其它算失败。
			//   txrtnmsg    交易返回描述
			Map<String, Object> body = (Map<String, Object>)recvContext.get(CommConstant.APP_BODY);
			String errorCode = (String) body.get("errorcode");
			switch (errorCode) {
			case "AAAAAAAAAA":
				body.put("status", "S");break;
			default:
				body.put("status", "N");break;
			}			
		}
		return recvContext;
	}
}
