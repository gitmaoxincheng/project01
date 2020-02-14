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
 * BASESVC BODAFA1658  回单机签约 
 *  BODAFA1658 8815701
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1658 extends EciChannelService {

	private static BODAFA1658_I i = new BODAFA1658_I();
	private static BODAFA1658_O o = new BODAFA1658_O();
	public BODAFA1658() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1658_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("dealmode", new MsgField(ContentEnum.MessageType.STRING.toString(), "dealmode", 2,0, false, "扣款方式" )))
					.addNode(new FieldNode("dealacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dealacctno", 40,0, false, "缴费账号" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 32,0, false, "账号" )))
					.addNode(new FieldNode("acctnoidtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctnoidtype", 3,0, false, "证件类型" )))
					.addNode(new FieldNode("acctnoid", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctnoid", 132,0, false, "证件号码" )))
					.addNode(new FieldNode("operator", new MsgField(ContentEnum.MessageType.STRING.toString(), "operator", 220,0, false, "经办人" )))
					.addNode(new FieldNode("operatoridtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatoridtype", 3,0, false, "经办人证件类型" )))
					.addNode(new FieldNode("operatorid", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatorid", 32,0, false, "经办人证件号码" )))
					.addNode(new FieldNode("operatorphone", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatorphone", 32,0, false, "经办人手机" )))
					.addNode(new FieldNode("password", new MsgField(ContentEnum.MessageType.STRING.toString(), "password", 300,0, false, "回单机密码" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 1,0, false, "是否需要密码转换" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 30,0, false, "密钥序号" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 20,0, false, "密码的来源" )))
					.addNode(new FieldNode("zacctno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zacctno1", 20,0, false, "第一个密码所涉及的账号" )))
					.addNode(new FieldNode("zpwdfd1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfd1", 300,0, false, "第一个密码" )))
					.addNode(new FieldNode("zdcmttp1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmttp1", 20,0, false, "第一个密码涉及账号的凭证类型" )))
					.addNode(new FieldNode("zdcmtno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmtno1", 20,0, false, "填第一个账号对应凭证号码在上送报文中的字段名" )))
					.addNode(new FieldNode("isopenacctrl", new MsgField(ContentEnum.MessageType.STRING.toString(), "isopenacctrl", 1024,0, false, "是否转密" )))
					.addNode(new FieldNode("zeroac", new MsgField(ContentEnum.MessageType.STRING.toString(), "zeroac", 32,0, false, "账号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1658_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("clientserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "clientserialno", 32,0, false, "前端流水" )))
					.addNode(new FieldNode("hostserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "hostserialno", 32,0, false, "核心流水" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

