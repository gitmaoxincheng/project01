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
 * BASESVC.BODAFA1682 .同步签约信息登记 
 * BODAFA1682.203048 203048
 *  渠道整合
 * @author JZF
 */
@Component
public class BODAFA1682 extends EciChannelService {

	private static BODAFA1682_I i = new BODAFA1682_I();
	private static BODAFA1682_O o = new BODAFA1682_O();
	public BODAFA1682() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1682_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("custno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 1024,0, false, "客户号" )))
					.addNode(new FieldNode("trandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt", 1024,0, false, "交易日期" )))
					.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 1024,0, false, "交易流水" )))
					.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 1024,0, false, "客户名称" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 1024,0, false, "证件类型" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 1024,0, false, "证件号码" )))
					.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl", 1024,0, false, "电话号码" )))
					.addNode(new FieldNode("odmobi", new MsgField(ContentEnum.MessageType.STRING.toString(), "odmobi", 1024,0, false, "旧手机号码" )))
					.addNode(new FieldNode("systid", new MsgField(ContentEnum.MessageType.STRING.toString(), "systid", 1024,0, false, "同步系统标识" )))
					.addNode(new FieldNode("offitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "offitl", 1024,0, false, "单位电话" )))
					.addNode(new FieldNode("mailad", new MsgField(ContentEnum.MessageType.STRING.toString(), "mailad", 1024,0, false, "地址" )))
					.addNode(new FieldNode("mailcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "mailcd", 1024,0, false, "邮编" )))
					.addNode(new FieldNode("e_mail", new MsgField(ContentEnum.MessageType.STRING.toString(), "e_mail", 1024,0, false, "电子邮箱" )))
					.addNode(new FieldNode("gender", new MsgField(ContentEnum.MessageType.STRING.toString(), "gender", 1024,0, false, "性别" )))
					.addNode(new FieldNode("custlv", new MsgField(ContentEnum.MessageType.STRING.toString(), "custlv", 1024,0, false, "客户级别" )))
					.addNode(new FieldNode("odoffi", new MsgField(ContentEnum.MessageType.STRING.toString(), "odoffi", 1024,0, false, "原单位电话" )))
					.addNode(new FieldNode("odmail", new MsgField(ContentEnum.MessageType.STRING.toString(), "odmail", 1024,0, false, "原地址" )))
					.addNode(new FieldNode("odmlcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "odmlcd", 1024,0, false, "原邮编" )))
					.addNode(new FieldNode("ode_ma", new MsgField(ContentEnum.MessageType.STRING.toString(), "ode_ma", 1024,0, false, "原地址邮箱" )))
					.addNode(new FieldNode("odgend", new MsgField(ContentEnum.MessageType.STRING.toString(), "odgend", 1024,0, false, "原性别" )))
					.addNode(new FieldNode("odcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "odcust", 1024,0, false, "原客户级别" )))
					.addNode(new FieldNode("odidtf", new MsgField(ContentEnum.MessageType.STRING.toString(), "odidtf", 1024,0, false, "原证件类型" )))
					.addNode(new FieldNode("odidno", new MsgField(ContentEnum.MessageType.STRING.toString(), "odidno", 1024,0, false, "原证件号码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1682_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody"));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
