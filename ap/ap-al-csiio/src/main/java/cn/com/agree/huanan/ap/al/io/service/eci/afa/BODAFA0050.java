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
 * BASESVC BODAFA0050  解约客户签约 
 *  BODAFA0050 
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA0050 extends EciChannelService {

	private static BODAFA0050_I i = new BODAFA0050_I();
	private static BODAFA0050_O o = new BODAFA0050_O();
	public BODAFA0050() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0050_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("custtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtp", 1,0, false, "客户类型" )))
					.addNode(new FieldNode("vouhtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "vouhtype", 3,0, false, "凭证类型" )))
					.addNode(new FieldNode("vouhno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vouhno", 32,0, false, "凭证号码" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 32,0, false, "签约卡号/凭证号" )))
					.addNode(new FieldNode("acctrl", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctrl", 32,0, false, "账户帐号" )))
					.addNode(new FieldNode("acctname", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctname", 32,0, false, "户名" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 3,0, false, "证件类型" )))
					.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 20,0, false, "证件号码" )))
					.addNode(new FieldNode("isflag1", new MsgField(ContentEnum.MessageType.STRING.toString(), "isflag1", 1,0, false, "手机号码标识" )))
					.addNode(new FieldNode("isflag2", new MsgField(ContentEnum.MessageType.STRING.toString(), "isflag2", 1,0, false, "手机号码标识" )))
					.addNode(new FieldNode("isflag3", new MsgField(ContentEnum.MessageType.STRING.toString(), "isflag3", 1,0, false, "手机号码标识" )))
					.addNode(new FieldNode("isflag4", new MsgField(ContentEnum.MessageType.STRING.toString(), "isflag4", 1,0, false, "手机号码标识" )))
					.addNode(new FieldNode("isflag5", new MsgField(ContentEnum.MessageType.STRING.toString(), "isflag5", 1,0, false, "手机号码标识" )))
					.addNode(new FieldNode("phone1", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone1", 13,0, false, "手机号码" )))
					.addNode(new FieldNode("phone2", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone2", 13,0, false, "手机号码" )))
					.addNode(new FieldNode("phone3", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone3", 13,0, false, "手机号码" )))
					.addNode(new FieldNode("phone4", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone4", 13,0, false, "手机号码" )))
					.addNode(new FieldNode("phone5", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone5", 13,0, false, "手机号码" )))
					.addNode(new FieldNode("phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone", 13,0, false, "手机号码" )))
					.addNode(new FieldNode("ndtrpw", new MsgField(ContentEnum.MessageType.STRING.toString(), "ndtrpw", 1,0, false, "签约账号验密标识" )))
					.addNode(new FieldNode("tranpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranpwd", 300,0, false, "签约卡号/凭证号密码" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 1,0, true, "密码相关字段" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 30,0, false, "密码相关字段" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 10,0, false, "密码相关字段" )))
					.addNode(new FieldNode("zacctno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zacctno1", 32,0, false, "密码相关字段" )))
					.addNode(new FieldNode("zpwdfd1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfd1", 16,0, false, "密码相关字段" )))
					.addNode(new FieldNode("zdcmttp1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmttp1", 3,0, false, "密码相关字段" )))
					.addNode(new FieldNode("zdcmtno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmtno1", 16,0, false, "密码相关字段" )))
					.addNode(new FieldNode("zacctno2", new MsgField(ContentEnum.MessageType.STRING.toString(), "zacctno2", 32,0, false, "密码相关字段" )))
					.addNode(new FieldNode("zpwdfd2", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfd2", 16,0, false, "密码相关字段" )))
					.addNode(new FieldNode("zdcmttp2", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmttp2", 3,0, false, "密码相关字段" )))
					.addNode(new FieldNode("zdcmtno2", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmtno2", 16,0, false, "密码相关字段" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0050_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
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

