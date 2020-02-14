package cn.com.agree.huanan.ap.al.io.service.eci.nib;

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
 * BASESVC BODNIB0106  客户证书信息查询 
 *  BODNIB0106 regflw
 *  新个人网银
 * @author XZF
 */
@Component
public class BODNIB0106 extends EciChannelService {

	private static BODNIB0106_I i = new BODNIB0106_I();
	private static BODNIB0106_O o = new BODNIB0106_O();
	public BODNIB0106() {	
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNIB0106_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 1024,0, true, "证件类型" )))
					.addNode(new FieldNode("idnumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "idnumber", 1024,0, true, "证件号码" )))
					.addNode(new FieldNode("flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "flag", 1024,0, true, "操作标识" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODNIB0106_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("id", new MsgField(ContentEnum.MessageType.STRING.toString(), "id", 1024,0, true, "证书主键" )))
					.addNode(new FieldNode("cifno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cifno", 1024,0, true, "核心客户号" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 1024,0, true, "证件类型" )))
					.addNode(new FieldNode("idnumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "idnumber", 1024,0, true, "证件号码" )))
					.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 1024,0, true, "客户姓名" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1024,0, true, "证书状态" )))
					.addNode(new FieldNode("certid", new MsgField(ContentEnum.MessageType.STRING.toString(), "certid", 1024,0, true, "证书id" )))
					.addNode(new FieldNode("certdn", new MsgField(ContentEnum.MessageType.STRING.toString(), "certdn", 1024,0, true, "证书DN" )))
					.addNode(new FieldNode("refno", new MsgField(ContentEnum.MessageType.STRING.toString(), "refno", 1024,0, true, "参考号" )))
					.addNode(new FieldNode("authno", new MsgField(ContentEnum.MessageType.STRING.toString(), "authno", 1024,0, true, "授权码" )))
					.addNode(new FieldNode("certruletype", new MsgField(ContentEnum.MessageType.STRING.toString(), "certruletype", 1024,0, true, "证书算法类型" )))
					.addNode(new FieldNode("keytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "keytype", 1024,0, true, "Key类型" )))
					.addNode(new FieldNode("usbkey", new MsgField(ContentEnum.MessageType.STRING.toString(), "usbkey", 1024,0, true, "KEY编号" )))
					.addNode(new FieldNode("applydate", new MsgField(ContentEnum.MessageType.STRING.toString(), "applydate", 1024,0, true, "申请时间" )))
					.addNode(new FieldNode("enddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "enddate", 1024,0, true, "到期时间" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

