package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODAFA1066 录音录像通知交易 录音录像通知交易
 * BODAFA1066 205007 params
 * 20 前置AFA
 * @author JZF
 */
@Component
public class BODAFA1066 extends EciChannelService {
	/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCBODAFA1066', 'BASESVC', '前置AFA', 'BODAFA1066', '录音录像通知交易', 'ECI.AFA', 'ECI-AFA系统', 'BODAFA1066', '录音录像通知交易', '205007', 'params', '录音录像通知交易', '1', '0', '录音录像通知交易');

	 */
	private static BODAFA1066_I i = new BODAFA1066_I();
	private static BODAFA1066_O o = new BODAFA1066_O();

	public BODAFA1066() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1066_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedate", 8,0, false, "交易日期" )))
					.addNode(new FieldNode("wmvserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "wmvserno", 20,0, false, "录制编号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODAFA1066_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
