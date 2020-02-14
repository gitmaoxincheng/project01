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
 * BASESVC BODAFA0096 贷记IC卡圈存 BODAFA0096 regflw 渠道整合
 * 
 * @author HYS
 */
@Component
public class BODAFA0096 extends EciChannelService {
	
	private static BODAFA0096_I i = new BODAFA0096_I();
	private static BODAFA0096_O o = new BODAFA0096_O();

	public BODAFA0096() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0096_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode
					.addStructNode(new StructNode("APPBody", true, "Body")
							.addNode(new FieldNode("cardno",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 20, 0, false,
											"贷记卡号")))
							.addNode(new FieldNode("tranam",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "tranam", 3, 0, false,
											"圈存金额")))
							.addNode(new FieldNode("trantp",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "trantp", 10, 0, false,
											"交易类型")))
							.addNode(new FieldNode("toacct",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "toacct", 60, 0, false,
											"转出卡号")))
							.addNode(new FieldNode("passwd",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "passwd", 16, 0, false,
											"交易密码")))
							.addNode(new FieldNode("needpwd",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 1, 0, true,
											"是否需要密码")))
							.addNode(new FieldNode("iccardseq",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "iccardseq", 3, 0, false,
											"IC卡序列号")))
							.addNode(new FieldNode("icdata",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "icdata", 300, 0, false,
											"IC卡数据")))
							.addNode(new FieldNode("ableflag",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "ableflag", 1, 0, false,
											"终端读取能力")))
							.addNode(new FieldNode("ictjdm",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "ictjdm", 1, 0, false,
											"IC卡条件代码")))
							.addNode(new FieldNode("fridcode",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "fridcode", 20, 0, false,
											"转发机构代码")))
							.addNode(new FieldNode("acidcode",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "acidcode", 20, 0, false,
											"代理行机构代码")))
							.addNode(new FieldNode("zmackey",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 20, 0, false,
											"密钥序号")))
							.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(),
									"zpwdfrm", 20, 0, false, "密码的来源"))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0096_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode
					.addStructNode(new StructNode("Body", true, "APPBody")
							.addNode(new FieldNode("icdata",new MsgField(ContentEnum.MessageType.STRING.toString(), "icdata", 300, 0, true,"IC卡数据"))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
