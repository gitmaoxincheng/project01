package cn.com.agree.huanan.ap.al.io.service.sbc;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbSbcChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.C022001402 贵金属订单管理.贵金属订单 
 * C0220014.02 MT0201
 * 0212 金融互联网服务平台
 * @author XZF
 */
@Component
public class C022001402 extends EsbSbcChannelService {

	private static C022001402_I i = new C022001402_I();
	private static C022001402_O o = new C022001402_O();
	public C022001402() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C022001402_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cstNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstNo", 50,0, false, "客户号" )))
					.addNode(new FieldNode("cifNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "cifNo", 50,0, true, "核心客户号" )))
					.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 10,0, true, "渠道" )))
					.addNode(new FieldNode("payAccount", new MsgField(ContentEnum.MessageType.STRING.toString(), "payAccount", 50,0, true, "付款账号" )))
					.addNode(new ArrayNode("orderNumList",false)
							.addNode(new FieldNode("orderNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "orderNum", 50,0, true, "订单号" )))
							).addNode(new FieldNode("payName", new MsgField(ContentEnum.MessageType.STRING.toString(), "payName", 20,0, true, "付款名" )))
					.addNode(new FieldNode("pickType", new MsgField(ContentEnum.MessageType.STRING.toString(), "pickType", 10,0, true, "提货方式" )))
					.addNode(new FieldNode("recommend", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommend", 50,0, false, "推荐人编号" )))
					.addNode(new FieldNode("node", new MsgField(ContentEnum.MessageType.STRING.toString(), "node", 10,0, true, "提货网点" )))
					.addNode(new FieldNode("nodeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "nodeName", 50,0, true, "提货网点名称" )))
					.addNode(new FieldNode("pickPhone", new MsgField(ContentEnum.MessageType.STRING.toString(), "pickPhone", 20,0, true, "提货人电话" )))
					.addNode(new FieldNode("headType", new MsgField(ContentEnum.MessageType.STRING.toString(), "headType", 10,0, false, "发票抬头类型" )))
					.addNode(new FieldNode("head", new MsgField(ContentEnum.MessageType.STRING.toString(), "head", 20,0, false, "发票抬头" )))
					.addNode(new FieldNode("unitAddress", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitAddress", 100,0, false, "发票单位地址" )))
					.addNode(new FieldNode("openBank", new MsgField(ContentEnum.MessageType.STRING.toString(), "openBank", 50,0, false, "发票开户银行" )))
					.addNode(new FieldNode("taxpayerNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "taxpayerNum", 50,0, false, "发票纳税人识别号" )))
					.addNode(new FieldNode("phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone", 20,0, false, "发票手机号码" )))
					.addNode(new FieldNode("account", new MsgField(ContentEnum.MessageType.STRING.toString(), "account", 50,0, false, "发票收款账号" )))
					.addNode(new FieldNode("ieType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ieType", 50,0, false, "发票类型" )))
					.addNode(new FieldNode("nodeAddress", new MsgField(ContentEnum.MessageType.STRING.toString(), "nodeAddress", 100,0, false, "网点地址" )))
					.addNode(new FieldNode("cstName", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstName", 20,0, true, "客户名称" )))
					.addNode(new FieldNode("productId", new MsgField(ContentEnum.MessageType.STRING.toString(), "productId", 50,0, false, "产品ID" )))
					.addNode(new FieldNode("pickCertType", new MsgField(ContentEnum.MessageType.STRING.toString(), "pickCertType", 10,0, true, "提货人证件类型" )))
					.addNode(new FieldNode("pickCertNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "pickCertNo", 50,0, true, "提货人证件号码" )))
					.addNode(new FieldNode("recommendPhone", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommendPhone", 20,0, false, "推荐人手机号" )))
					.addNode(new FieldNode("recommendName", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommendName", 20,0, false, "推荐人姓名" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C022001402_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

