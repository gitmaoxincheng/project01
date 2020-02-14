package cn.com.agree.huanan.ap.al.io.service.eci.hst;

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
 * BASESVC BODHST1159  日日盈签约 
 *  BODHST1159 
 *  旧核心系统
 * @author XZF
 */
@Component
public class BODHST1159 extends EciChannelService {

	private static BODHST1159_I i = new BODHST1159_I();
	private static BODHST1159_O o = new BODHST1159_O();
	public BODHST1159() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODHST1159_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("ot_acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "ot_acctno", 40,0, false, "转出账号" )))
					.addNode(new FieldNode("ot_dcmttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ot_dcmttp", 3,0, false, "转出凭证类型" )))
					.addNode(new FieldNode("ot_dcmtno", new MsgField(ContentEnum.MessageType.STRING.toString(), "ot_dcmtno", 20,0, false, "转出凭证号码" )))
					.addNode(new FieldNode("ot_tranpw", new MsgField(ContentEnum.MessageType.STRING.toString(), "ot_tranpw", 16,0, false, "转出密码" )))
					.addNode(new FieldNode("ot_idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ot_idtftp", 1,0, false, "转出证件类型" )))
					.addNode(new FieldNode("ot_idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "ot_idtfno", 50,0, false, "转出证件号码" )))
					.addNode(new FieldNode("dispno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dispno", 20,0, false, "转入卡号" )))
					.addNode(new FieldNode("crcycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "crcycd", 2,0, false, "币种" )))
					.addNode(new FieldNode("debtcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "debtcd", 3,0, false, "储种" )))
					.addNode(new FieldNode("remnam", new MsgField(ContentEnum.MessageType.STRING.toString(), "remnam", 20,0, false, "保留金额" )))
					.addNode(new FieldNode("signtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtp", 1,0, false, "设定转账类型" )))
					.addNode(new FieldNode("signam", new MsgField(ContentEnum.MessageType.STRING.toString(), "signam", 20,0, false, "转账金额" )))
					.addNode(new FieldNode("signdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "signdt", 8,0, false, "转账日期" )))
					.addNode(new FieldNode("termcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "termcd", 3,0, false, "存期" )))
					.addNode(new FieldNode("pmtdtg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pmtdtg", 1,0, false, "自动转存" )))
					.addNode(new FieldNode("custno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 12,0, false, "客户号" )))
					.addNode(new FieldNode("trantp", new MsgField(ContentEnum.MessageType.STRING.toString(), "trantp", 2,0, false, "交易类型" )))
					.addNode(new FieldNode("spectp", new MsgField(ContentEnum.MessageType.STRING.toString(), "spectp", 1,0, false, "账户类型" )))
					.addNode(new FieldNode("dcmttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcmttp", 3,0, false, "凭证类型" )))
					.addNode(new FieldNode("dcmtno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcmtno", 20,0, false, "凭证号码" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 1,0, true, "是否需要密码转换" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 30,0, false, "密钥序号" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 20,0, false, "密码来源" )))
					.addNode(new FieldNode("zacctno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zacctno1", 20,0, false, "密码所涉及的账号字段名" )))
					.addNode(new FieldNode("zpwdfd1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfd1", 20,0, false, "密码所在字段名" )))
					.addNode(new FieldNode("zdcmttp1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmttp1", 20,0, false, "凭证字段名" )))
					.addNode(new FieldNode("zdcmtno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmtno1", 20,0, false, "凭证号字段名" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODHST1159_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("script", new MsgField(ContentEnum.MessageType.STRING.toString(), "script", 255,0, false, "脚本" )))
					.addNode(new FieldNode("ot_acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "ot_acctno", 40,0, false, "通知账号" )))
					.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 20,0, false, "交易流水" )))
					.addNode(new FieldNode("otacna", new MsgField(ContentEnum.MessageType.STRING.toString(), "otacna", 80,0, false, "转出户名" )))
					.addNode(new FieldNode("debtcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "debtcd", 3,0, false, "储种" )))
					.addNode(new FieldNode("acctna", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctna", 80,0, false, "转入户名" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

