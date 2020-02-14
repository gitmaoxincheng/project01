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
 * BASESVC BODAFA0049  修改客户签约 
 *  BODAFA0049 
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA0049 extends EciChannelService {

	private static BODAFA0049_I i = new BODAFA0049_I();
	private static BODAFA0049_O o = new BODAFA0049_O();
	public BODAFA0049() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0049_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("custtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype", 1,0, false, "客户类型" )))
					.addNode(new FieldNode("vouhtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "vouhtype", 3,0, false, "凭证类型" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 32,0, false, "签约卡号/凭证号" )))
					.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 80,0, false, "账户名称" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 1,0, false, "证件类型" )))
					.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 19,0, false, "证件号码" )))
					.addNode(new FieldNode("paysac", new MsgField(ContentEnum.MessageType.STRING.toString(), "paysac", 32,0, false, "备注1" )))
					.addNode(new FieldNode("paysdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "paysdm", 3,0, false, "备注2" )))
					.addNode(new FieldNode("paysna", new MsgField(ContentEnum.MessageType.STRING.toString(), "paysna", 80,0, false, "备注3" )))
					.addNode(new FieldNode("ndpypw", new MsgField(ContentEnum.MessageType.STRING.toString(), "ndpypw", 1,0, false, "付费账号验密标识" )))
					.addNode(new FieldNode("payspw", new MsgField(ContentEnum.MessageType.STRING.toString(), "payspw", 300,0, false, "付费账号密码" )))
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
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 6,0, false, "记录数" )))
					.addNode(new FieldNode("oldphone", new MsgField(ContentEnum.MessageType.STRING.toString(), "oldphone", 120,0, false, "旧手机号码" )))
					.addNode(new FieldNode("phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone", 120,0, false, "新用户号" )))
					.addNode(new FieldNode("intram", new MsgField(ContentEnum.MessageType.STRING.toString(), "intram", 12,0, false, "单笔转入限额" )))
					.addNode(new FieldNode("outram", new MsgField(ContentEnum.MessageType.STRING.toString(), "outram", 12,0, false, "单笔转出限额" )))
					.addNode(new FieldNode("memotp", new MsgField(ContentEnum.MessageType.STRING.toString(), "memotp", 1,0, false, "余额" )))
					.addNode(new FieldNode("nemotp", new MsgField(ContentEnum.MessageType.STRING.toString(), "nemotp", 1,0, false, "摘要" )))
					.addNode(new FieldNode("acctname", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctname", 20,0, false, "昵称" )))
					.addNode(new FieldNode("dknote", new MsgField(ContentEnum.MessageType.STRING.toString(), "dknote", 1,0, false, "贷款通知" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0049_O extends MsgBody {
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

