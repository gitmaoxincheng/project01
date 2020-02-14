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
 * BASESVC BODAFA1677  销户检查 
 *  BODAFA1677 204008
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1677 extends EciChannelService {

	private static BODAFA1677_I i = new BODAFA1677_I();
	private static BODAFA1677_O o = new BODAFA1677_O();
	public BODAFA1677() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1677_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 1024,0, false, "卡号" )))
					.addNode(new FieldNode("chcktp", new MsgField(ContentEnum.MessageType.STRING.toString(), "chcktp", 1024,0, false, "" )))
					.addNode(new FieldNode("convtg", new MsgField(ContentEnum.MessageType.STRING.toString(), "convtg", 1024,0, false, "" )))
					.addNode(new FieldNode("crcycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "crcycd", 1024,0, false, "币种" )))
					.addNode(new FieldNode("acctna", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctna", 1024,0, false, "户名" )))
					.addNode(new FieldNode("acctpw", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctpw", 1024,0, false, "密码" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 1024,0, false, "证件类型" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 1024,0, false, "证件号码" )))
					.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranam", 1024,0, false, "交易金额" )))
					.addNode(new FieldNode("trantp", new MsgField(ContentEnum.MessageType.STRING.toString(), "trantp", 1024,0, false, "交易类型" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 1024,0, false, "是否需要检查密码" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 1024,0, false, "加密主键名称" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 1024,0, false, "密码来源" )))
					.addNode(new FieldNode("zacctno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zacctno1", 1024,0, false, "加密账号字段" )))
					.addNode(new FieldNode("zdcmttp1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmttp1", 1024,0, false, "加密凭证类型字段" )))
					.addNode(new FieldNode("zdcmtno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmtno1", 1024,0, false, "加密凭证号码字段" )))
					.addNode(new FieldNode("zpwdfd1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfd1", 1024,0, false, "加密密码字段" )))
					.addNode(new FieldNode("gtagtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "gtagtp", 1024,0, false, "柜面通通存通兑标志" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1677_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
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

