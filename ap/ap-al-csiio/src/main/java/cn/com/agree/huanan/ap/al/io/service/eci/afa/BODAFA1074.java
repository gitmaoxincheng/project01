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
 * BASESVC BODAFA1074  前置超时交易状态查询
 * BODAFA1074 203041 203041
 *  综合前置
 * @author zhonggp
 */
@Component
public class BODAFA1074 extends EciChannelService {
	
	private static BODAFA1074_I i = new BODAFA1074_I();
	private static BODAFA1074_O o = new BODAFA1074_O();

	public BODAFA1074() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1074_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("origchannelcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "origchannelcode", 3,0, true, "原渠道分类" )))
					.addNode(new FieldNode("origsubchannelcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "origsubchannelcode", 3,0, true, "原渠道码" )))
					.addNode(new FieldNode("origtradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "origtradedate", 8,0, true, "原渠道日期" )))
					.addNode(new FieldNode("origchannelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "origchannelserno", 40,0, true, "原渠道流水" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODAFA1074_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("serverworkdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "serverworkdate", 8,0, false, "服务端交易日期" )))
					.addNode(new FieldNode("serverserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "serverserialno", 40,0, false, "服务端交易流水号" )))
					.addNode(new FieldNode("servererrorcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "servererrorcode", 8,0, false, "服务端交易返回错误代码" )))
					.addNode(new FieldNode("servererrormsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "servererrormsg", 300,0, false, "服务端交易返回信息" )))
					.addNode(new FieldNode("endstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "endstatus", 1,0, false, "交易状态" )))
					.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedate", 8,0, false, "前置日期" )))
					.addNode(new FieldNode("tradeseno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradeseno", 8,0, false, "前置流水" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
