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
 * BASESVC BODNIB0104  重置密码 
 *  BODNIB0104 pretonib
 *  新个人网银
 * @author XZF
 */
@Component
public class BODNIB0104 extends EciChannelService {

	private static BODNIB0104_I i = new BODNIB0104_I();
	private static BODNIB0104_O o = new BODNIB0104_O();
	public BODNIB0104() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNIB0104_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("fromchannel", new MsgField(ContentEnum.MessageType.STRING.toString(), "fromchannel", 1024,0, true, "上送渠道" )))
					.addNode(new FieldNode("operatechannel", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatechannel", 1024,0, true, "操作渠道" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 1024,0, true, "证件类型" )))
					.addNode(new FieldNode("idnumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "idnumber", 1024,0, true, "证件号码" )))
					.addNode(new FieldNode("password", new MsgField(ContentEnum.MessageType.STRING.toString(), "password", 1024,0, true, "密码" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 2,0, true, "是否需要密码转换" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 18,0, true, "密钥序号" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 10,0, true, "密码来源" )))
					.addNode(new FieldNode("chkval", new MsgField(ContentEnum.MessageType.STRING.toString(), "chkval", 2,0, true, "chkval校验值" )))
					.addNode(new FieldNode("tranto", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranto", 50,0, true, "密码目标" )))
					.addNode(new FieldNode("zacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "zacctno", 32,0, true, "密码所涉及的账号字段" )))
					.addNode(new FieldNode("zpwdfd", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfd", 45,0, true, "加密密码字段" )))
					.addNode(new FieldNode("zdcmttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmttp", 15,0, false, "凭证类型字段" )))
					.addNode(new FieldNode("zdcmtno", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmtno", 15,0, false, "凭证号字段" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODNIB0104_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("personid", new MsgField(ContentEnum.MessageType.STRING.toString(), "personid", 1024,0, true, "网银客户号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

