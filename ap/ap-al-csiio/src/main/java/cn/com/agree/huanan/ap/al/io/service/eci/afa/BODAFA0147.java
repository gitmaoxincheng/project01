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
 * BASESVC BODAFA0147 ATM无卡取款appoint12 BODAFA0147 regflw 渠道整合
 * 
 * @author HYS
 */
@Component
public class BODAFA0147 extends EciChannelService {
	/*
	 * 
	 * INSERT INTO CSIS_ATOMIC_SERVICE (AT_SVCID, AT_SVCCODE, AT_SVCNAME,
	 * AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME,
	 * SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES
	 * ('BASESVCBODAFA0147', 'BASESVC', '渠道整合', 'BODAFA0147', '', 'ECI.AFA',
	 * 'ECI_AFA系统', 'BODAFA0147', 'ATM无卡取款appoint12', 'appoint12','regflw' ,'', '1',
	 * '0', '');
	 * 
	 */
	private static BODAFA0147_I i = new BODAFA0147_I();
	private static BODAFA0147_O o = new BODAFA0147_O();

	public BODAFA0147() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0147_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode
					.addStructNode(new StructNode("APPBody", true, "Body")
							.addNode(new FieldNode("custtel",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "custtel", 15, 0, false,
											"手机号")))
							.addNode(new FieldNode("userno",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "userno", 10, 0, false,
											"预约码")))
							.addNode(new FieldNode("usernopwd",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "usernopwd", 32, 0, false,
											"预约密码")))
							.addNode(new FieldNode("termid",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "termid", 20, 0, false,
											"终端号")))
							.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(),
									"amount", 17, 0, false, "取款金额"))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0147_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody").addNode(new StructNode("bodrcd", true)
					.addNode(new FieldNode("avamount",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "avamount", 17, 0, false,
									"可用预约余额")))
					.addNode(new FieldNode("avresnum",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "avresnum", 3, 0, false, "可用预约次数")))
					.addNode(new FieldNode("pervalday", new MsgField(ContentEnum.MessageType.STRING.toString(),
							"pervalday", 18, 0, true, "预约有效期")))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
