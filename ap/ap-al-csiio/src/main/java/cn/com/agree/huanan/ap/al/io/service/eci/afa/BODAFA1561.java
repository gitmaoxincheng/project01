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
 * BASESVC BODAFA1561  人事编号信息查询 
 *  BODAFA1561 008001
 *  综合前置
 * @author xuzhen
 */
@Component
public class BODAFA1561 extends EciChannelService {

	private static BODAFA1561_I i = new BODAFA1561_I();
	private static BODAFA1561_O o = new BODAFA1561_O();
	public BODAFA1561() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODAFA1561_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
.addStructNode(new StructNode("APPBody",true,"Body")
.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
.addNode(new FieldNode("persno", new MsgField(ContentEnum.MessageType.STRING.toString(), "persno", 40,0, false, "人事编号" )))
.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 1,0, false, "证件类型" )))
.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 40,0, false, "证件号码" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1561_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
.addStructNode(new StructNode("Body",true,"APPBody")
.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
.addNode(new FieldNode("persno", new MsgField(ContentEnum.MessageType.STRING.toString(), "persno", 1024,0, false, "人事编号" )))
.addNode(new FieldNode("persna", new MsgField(ContentEnum.MessageType.STRING.toString(), "persna", 1024,0, false, "姓名" )))
.addNode(new FieldNode("perstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "perstatus", 1024,0, false, "状态" )))
.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 1024,0, false, "证件类型" )))
.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 1024,0, false, "证件号码" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

