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
 * BASESVC BODAFA0148 ATM无卡取款冲正point13 BODAFA0148 regflw 渠道整合
 * 
 * @author HYS
 */
@Component
public class BODAFA0148 extends EciChannelService {
	/*
	 * 
	 * INSERT INTO CSIS_ATOMIC_SERVICE (AT_SVCID, AT_SVCCODE, AT_SVCNAME,
	 * AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME,
	 * SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES
	 * ('BASESVCBODAFA0148', 'BASESVC', '渠道整合', 'BODAFA0148', '', 'ECI.AFA',
	 * 'ECI_AFA系统', 'BODAFA0148', 'ATM无卡取款冲正point13', 'appoint13','regflw' ,'', '1',
	 * '0', '');
	 * 
	 */
	private static BODAFA0148_I i = new BODAFA0148_I();
	private static BODAFA0148_O o = new BODAFA0148_O();

	public BODAFA0148() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0148_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("prechannelserno",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "prechannelserno", 40, 0, false,
									"原渠道流水号")))
					.addNode(new FieldNode("custtel",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "custtel", 15, 0, false, "原手机号")))
					.addNode(new FieldNode("userno",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "userno", 10, 0, false, "原预约码")))
					.addNode(new FieldNode("usernopwd", new MsgField(ContentEnum.MessageType.STRING.toString(),
							"usernopwd", 32, 0, false, "原预约密码"))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0148_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
