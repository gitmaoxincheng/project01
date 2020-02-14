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
 * BASESVC BODAFA1562  重点关注对象确认书签署 
 *  BODAFA1562 8810908
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1562 extends EciChannelService {

	private static BODAFA1562_I i = new BODAFA1562_I();
	private static BODAFA1562_O o = new BODAFA1562_O();
	public BODAFA1562() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1562_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("idtype_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype_code", 3,0, false, "证件类型" )))
					.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 50,0, false, "证件号码" )))
					.addNode(new FieldNode("ctycode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctycode", 5,0, false, "国别" )))
					.addNode(new FieldNode("person_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "person_name", 200,0, false, "姓名" )))
					.addNode(new FieldNode("biz_tx_chnl_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "biz_tx_chnl_code", 2,0, false, "业务办理渠道代码" )))
					.addNode(new FieldNode("opbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "opbrno", 10,0, false, "外汇账户开户行号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1562_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq", 12,0, false, "报文流水" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 255,0, false, "出错信息" )))
					.addNode(new FieldNode("script", new MsgField(ContentEnum.MessageType.STRING.toString(), "script", 8,0, false, "出错脚本" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

