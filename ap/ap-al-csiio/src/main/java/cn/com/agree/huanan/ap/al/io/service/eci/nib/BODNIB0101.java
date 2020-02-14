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
 * BASESVC BODNIB0101  统一签约 
 *  BODNIB0101 
 *  新个人网银
 * @author XZF
 */
@Component
public class BODNIB0101 extends EciChannelService {

	private static BODNIB0101_I i = new BODNIB0101_I();
	private static BODNIB0101_O o = new BODNIB0101_O();
	public BODNIB0101() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNIB0101_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("fromchannel", new MsgField(ContentEnum.MessageType.STRING.toString(), "fromchannel", 1024,0, true, "上送渠道" )))
					.addNode(new FieldNode("cifno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cifno", 1024,0, true, "核心客户号" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 1024,0, true, "证件类型" )))
					.addNode(new FieldNode("idnumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "idnumber", 1024,0, true, "证件号码" )))
					.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 1024,0, true, "客户姓名" )))
					.addNode(new FieldNode("sex", new MsgField(ContentEnum.MessageType.STRING.toString(), "sex", 1024,0, false, "客户性别" )))
					.addNode(new FieldNode("logonalias", new MsgField(ContentEnum.MessageType.STRING.toString(), "logonalias", 1024,0, false, "登录别名" )))
					.addNode(new FieldNode("mobileno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobileno", 1024,0, false, "手机号码" )))
					.addNode(new FieldNode("phoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "phoneno", 1024,0, false, "电话号码" )))
					.addNode(new FieldNode("address", new MsgField(ContentEnum.MessageType.STRING.toString(), "address", 1024,0, false, "联系地址" )))
					.addNode(new FieldNode("zipcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "zipcode", 1024,0, false, "邮政编码" )))
					.addNode(new FieldNode("email", new MsgField(ContentEnum.MessageType.STRING.toString(), "email", 1024,0, false, "电子邮箱" )))
					.addNode(new FieldNode("custmsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "custmsg", 1024,0, false, "预留信息" )))
					.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 1024,0, true, "开通渠道" )))
					.addNode(new FieldNode("registernode", new MsgField(ContentEnum.MessageType.STRING.toString(), "registernode", 1024,0, true, "签约网点" )))
					.addNode(new FieldNode("password", new MsgField(ContentEnum.MessageType.STRING.toString(), "password", 300,0, true, "网银登陆密码" )))
					.addNode(new FieldNode("ukeyflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ukeyflag", 1024,0, false, "UKEY使用标志" )))
					.addNode(new FieldNode("usbkeyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "usbkeyno", 1024,0, false, "UKEY编号" )))
					.addNode(new FieldNode("keytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "keytype", 1024,0, false, "Key类型" )))
					.addNode(new FieldNode("saleno", new MsgField(ContentEnum.MessageType.STRING.toString(), "saleno", 1024,0, false, "营销人员编号" )))
					.addNode(new FieldNode("salename", new MsgField(ContentEnum.MessageType.STRING.toString(), "salename", 1024,0, false, "营销人员姓名" )))
					.addNode(new FieldNode("zoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "zoneno", 1024,0, false, "操作分行" )))
					.addNode(new FieldNode("mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mbrno", 1024,0, false, "操作支行" )))
					.addNode(new FieldNode("cstxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstxno", 1024,0, false, "柜员钱箱号" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 2,0, true, "是否需要密码转换" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 18,0, true, "密钥序号" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 10,0, true, "密码来源" )))
					.addNode(new FieldNode("chkval", new MsgField(ContentEnum.MessageType.STRING.toString(), "chkval", 2,0, true, "chkval校验值" )))
					.addNode(new FieldNode("tranto", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranto", 10,0, true, "密码目标" )))
					.addNode(new FieldNode("zacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "zacctno", 32,0, true, "密码所涉及的账号字段" )))
					.addNode(new FieldNode("zpwdfd", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfd", 300,0, true, "加密密码字段" )))
					.addNode(new FieldNode("zdcmttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmttp", 15,0, false, "凭证类型字段" )))
					.addNode(new FieldNode("zdcmtno", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmtno", 15,0, false, "凭证号字段" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 1024,0, true, "记录数" )))
					.addNode(new StructNode("bodrcd",true)
							.addNode(new FieldNode("accountno", new MsgField(ContentEnum.MessageType.STRING.toString(), "accountno", 1024,0, true, "卡号/账号" )))
							.addNode(new FieldNode("accountname", new MsgField(ContentEnum.MessageType.STRING.toString(), "accountname", 1024,0, true, "账户名称" )))
							.addNode(new FieldNode("opennode", new MsgField(ContentEnum.MessageType.STRING.toString(), "opennode", 1024,0, true, "账户网点" )))
							.addNode(new FieldNode("opennodename", new MsgField(ContentEnum.MessageType.STRING.toString(), "opennodename", 1024,0, true, "账户网点名称" )))
							.addNode(new FieldNode("currency", new MsgField(ContentEnum.MessageType.STRING.toString(), "currency", 1024,0, false, "币种" )))
							.addNode(new FieldNode("accname", new MsgField(ContentEnum.MessageType.STRING.toString(), "accname", 1024,0, true, "账号所属客户姓名" )))
							.addNode(new FieldNode("smssingle", new MsgField(ContentEnum.MessageType.STRING.toString(), "smssingle", 1024,0, false, "短信单笔限额" )))
							.addNode(new FieldNode("smsday", new MsgField(ContentEnum.MessageType.STRING.toString(), "smsday", 1024,0, false, "短信日累计限额" )))
							.addNode(new FieldNode("keysingle", new MsgField(ContentEnum.MessageType.STRING.toString(), "keysingle", 1024,0, false, "UKEY单笔限额" )))
							.addNode(new FieldNode("keyday", new MsgField(ContentEnum.MessageType.STRING.toString(), "keyday", 1024,0, false, "UKEY日累计限额" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODNIB0101_O extends MsgBody {
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

