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
 * BASESVC BODNIB0115  签约账户管理 
 *  BODNIB0115 
 *  新个人网银
 * @author XZF
 */
@Component
public class BODNIB0115 extends EciChannelService {

	private static BODNIB0115_I i = new BODNIB0115_I();
	private static BODNIB0115_O o = new BODNIB0115_O();
	public BODNIB0115() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNIB0115_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("fromchannel", new MsgField(ContentEnum.MessageType.STRING.toString(), "fromchannel", 1024,0, true, "上送渠道" )))
					.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 1024,0, true, "操作渠道" )))
					.addNode(new FieldNode("idType", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 1024,0, true, "证件类型" )))
					.addNode(new FieldNode("idNumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "idnumber", 1024,0, true, "证件号码" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 1024,0, true, "记录数" )))
					.addNode(new StructNode("acct_list",true,"bodrcd")
							.addNode(new FieldNode("accountno", new MsgField(ContentEnum.MessageType.STRING.toString(), "accountno", 1024,0, true, "客户账号" )))
							.addNode(new FieldNode("accountname", new MsgField(ContentEnum.MessageType.STRING.toString(), "accountname", 1024,0, true, "账户名称" )))
							.addNode(new FieldNode("opennode", new MsgField(ContentEnum.MessageType.STRING.toString(), "opennode", 1024,0, true, "账户网点" )))
							.addNode(new FieldNode("opennodename", new MsgField(ContentEnum.MessageType.STRING.toString(), "opennodename", 1024,0, true, "账户网点名称" )))
							.addNode(new FieldNode("authorities", new MsgField(ContentEnum.MessageType.STRING.toString(), "authorities", 1024,0, true, "账户权限" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODNIB0115_O extends MsgBody {
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

