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
 * BASESVC BODAFA0073  贷记卡临时挂失 
 *  BODAFA0073 881004
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA0073 extends EciChannelService {

	private static BODAFA0073_I i = new BODAFA0073_I();
	private static BODAFA0073_O o = new BODAFA0073_O();
	public BODAFA0073() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0073_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 19,0, false, "卡号" )))
					.addNode(new FieldNode("cancode", new MsgField(ContentEnum.MessageType.STRING.toString(), "cancode", 2,0, false, "挂失代码" )))
					.addNode(new FieldNode("lostdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "lostdate", 8,0, true, "遗失日期" )))
					.addNode(new FieldNode("losttime", new MsgField(ContentEnum.MessageType.STRING.toString(), "losttime", 4,0, false, "遗失时间" )))
					.addNode(new FieldNode("losttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "losttype", 3,0, false, "挂失方式" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 2,0, false, "证件种类" )))
					.addNode(new FieldNode("idno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idno", 18,0, false, "证件号码" )))
					.addNode(new FieldNode("expire", new MsgField(ContentEnum.MessageType.STRING.toString(), "expire", 4,0, true, "有效期" )))
					.addNode(new FieldNode("cardnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardnm", 30,0, false, "持卡人姓名" )))
					.addNode(new FieldNode("pin_flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pin_flag", 1,0, false, "是否检查密码标志" )))
					.addNode(new FieldNode("passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "passwd", 300,0, false, "密码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0073_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("sts", new MsgField(ContentEnum.MessageType.STRING.toString(), "sts", 2,0, false, "卡片当前状态" )))
					.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 30,0, false, "交易流水" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

