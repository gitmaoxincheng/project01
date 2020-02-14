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
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;

/**
 * BASESVC BODAFA1073  查询客户该手机签约的渠道 
 *  BODAFA1073 881003
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1073 extends EciChannelService {

	private static BODAFA1073_I i = new BODAFA1073_I();
	private static BODAFA1073_O o = new BODAFA1073_O();
	public BODAFA1073() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1073_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("custno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 20,0, false, "客户号" )))
					.addNode(new FieldNode("custinfo_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "custinfo_type", 1024,0, false, "查询类型" )))
					.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl", 20,0, false, "原手机号码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1073_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 10,0, false, "返回记录数" )))
					.addNode(new ArrayNode("bodrcd",false,"sign_list")
							.addNode(new FieldNode("strsysid", new MsgField(ContentEnum.MessageType.STRING.toString(), "strsysid", 10,0, false, "系统标识" )))
							.addNode(new FieldNode("sysidname", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysidname", 128,0, false, "系统名称" )))
							.addNode(new FieldNode("signst", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst", 1,0, false, "签约状态" )))
							.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl", 20,0, false, "手机号码" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

