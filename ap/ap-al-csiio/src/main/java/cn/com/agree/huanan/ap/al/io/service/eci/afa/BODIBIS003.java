package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODIBIS003  脸脸对比 
 *  BODIBIS003 
 *  综合前置
 * @author XZF
 */
@Component
public class BODIBIS003 extends EciChannelService {

	private static BODIBIS003_I i = new BODIBIS003_I();
	private static BODIBIS003_O o = new BODIBIS003_O();
	public BODIBIS003() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODIBIS003_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("methodName", new MsgField(ContentEnum.MessageType.STRING.toString(), "methodName", 255,0, false, "方法名" )))
					.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 16,0, false, "调用渠道" )))
					.addNode(new FieldNode("cId", new MsgField(ContentEnum.MessageType.STRING.toString(), "cId", 20,0, false, "证件号码" )))
					.addNode(new FieldNode("cName", new MsgField(ContentEnum.MessageType.STRING.toString(), "cName", 16,0, false, "姓    名" )))
					.addNode(new FieldNode("cType", new MsgField(ContentEnum.MessageType.STRING.toString(), "cType", 16,0, false, "证件类型" )))
					.addNode(new FieldNode("img1", new MsgField(ContentEnum.MessageType.STRING.toString(), "img1", 1024,0, false, "相片1" )))
					.addNode(new FieldNode("img2", new MsgField(ContentEnum.MessageType.STRING.toString(), "img2", 1024,0, false, "相片2" )))
					.addNode(new FieldNode("custProperty", new MsgField(ContentEnum.MessageType.STRING.toString(), "custProperty", 16,0, false, "客户属性" )))
					.addNode(new FieldNode("channelTradingFlowNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelTradingFlowNum", 32,0, false, "渠道交易流水号" )))
					.addNode(new FieldNode("channelTradingDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelTradingDate", 20,0, false, "渠道交易日期" )))
					.addNode(new FieldNode("channelTradingTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelTradingTime", 20,0, false, "渠道交易时间" )))
					.addNode(new FieldNode("equipmentNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "equipmentNum", 50,0, false, "设备号" )))
					.addNode(new FieldNode("organizationNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "organizationNum", 32,0, false, "机构号" )))
					.addNode(new FieldNode("tellerNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerNum", 16,0, false, "柜员号" )))
					.addNode(new FieldNode("bankcardNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankcardNum", 32,0, false, "银行卡号" )))
					.addNode(new FieldNode("authTellerNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "authTellerNum", 32,0, false, "授权柜员号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODIBIS003_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("code", new MsgField(ContentEnum.MessageType.STRING.toString(), "code", 16,0, false, "处理状态" )))
					.addNode(new FieldNode("message", new MsgField(ContentEnum.MessageType.STRING.toString(), "message", 127,0, false, "返回信息" )))
					.addNode(new FieldNode("sim", new MsgField(ContentEnum.MessageType.STRING.toString(), "sim", 1024,0, false, "相似度" )))
					.addNode(new FieldNode("simResult", new MsgField(ContentEnum.MessageType.STRING.toString(), "simResult", 1024,0, false, "相似度结果" )))
					.addNode(new FieldNode("imgFlowNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "imgFlowNo", 32,0, false, "交易流水号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

