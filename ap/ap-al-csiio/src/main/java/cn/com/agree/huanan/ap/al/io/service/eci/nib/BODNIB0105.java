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
 * BASESVC BODNIB0105  UKEY领用 
 *  BODNIB0105 
 *  新个人网银
 * @author XZF
 */
@Component
public class BODNIB0105 extends EciChannelService {

	private static BODNIB0105_I i = new BODNIB0105_I();
	private static BODNIB0105_O o = new BODNIB0105_O();
	public BODNIB0105() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNIB0105_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("fromchannel", new MsgField(ContentEnum.MessageType.STRING.toString(), "fromchannel", 1024,0, true, "上送渠道" )))
					.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 1024,0, true, "操作渠道" )))
					.addNode(new FieldNode("personid", new MsgField(ContentEnum.MessageType.STRING.toString(), "personid", 1024,0, true, "客户号" )))
					.addNode(new FieldNode("ukeyflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ukeyflag", 1024,0, true, "UKEY使用标志" )))
					.addNode(new FieldNode("keytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "keytype", 1024,0, false, "Key类型" )))
					.addNode(new FieldNode("usbkeyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "usbkeyno", 1024,0, true, "UKEY编号" )))
					.addNode(new FieldNode("zoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "zoneno", 1024,0, true, "操作分行" )))
					.addNode(new FieldNode("mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mbrno", 1024,0, true, "操作支行" )))
					.addNode(new FieldNode("csbxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "csbxno", 1024,0, true, "柜员钱箱号" )))
					.addNode(new FieldNode("accountno", new MsgField(ContentEnum.MessageType.STRING.toString(), "accountno", 1024,0, true, "账号" )))
					.addNode(new FieldNode("frpflg", new MsgField(ContentEnum.MessageType.STRING.toString(), "frpflg", 1024,0, true, "柜员钱箱号" )))
					.addNode(new FieldNode("feeamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "feeamt", 1024,0, true, "柜员钱箱号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODNIB0105_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("opflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "opflag", 1024,0, true, "操作标识" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

