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
 * BASESVC BODAFA0120  通用工本费收取接口 
 *  BODAFA0120 8810404
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA0120 extends EciChannelService {

	private static BODAFA0120_I i = new BODAFA0120_I();
	private static BODAFA0120_O o = new BODAFA0120_O();
	public BODAFA0120() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0120_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("sfserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "sfserialno", 30,0, true, "唯一流水号" )))
					.addNode(new FieldNode("svcdcl", new MsgField(ContentEnum.MessageType.STRING.toString(), "svcdcl", 20,0, false, "收费大类" )))
					.addNode(new FieldNode("chrgtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrgtp", 10,0, true, "收费种类" )))
					.addNode(new FieldNode("subtyp", new MsgField(ContentEnum.MessageType.STRING.toString(), "subtyp", 20,0, false, "收费子类" )))
					.addNode(new FieldNode("jktype", new MsgField(ContentEnum.MessageType.STRING.toString(), "jktype", 1,0, true, "交易类型" )))
					.addNode(new FieldNode("currtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "currtype", 5,0, false, "币种" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 30,0, false, "账号" )))
					.addNode(new FieldNode("acctna", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctna", 100,0, false, "账号户名" )))
					.addNode(new FieldNode("dcmttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcmttp", 3,0, false, "凭证类型" )))
					.addNode(new FieldNode("dcmtno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcmtno", 30,0, false, "凭证号码" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 1,0, false, "证件类别" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 40,0, false, "证件号码" )))
					.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "amount", 20,0, false, "应收金额" )))
					.addNode(new FieldNode("ismessage", new MsgField(ContentEnum.MessageType.STRING.toString(), "ismessage", 1,0, false, "是否短信通知" )))
					.addNode(new FieldNode("phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone", 20,0, false, "手机号码" )))
					.addNode(new FieldNode("message", new MsgField(ContentEnum.MessageType.STRING.toString(), "message", 400,0, false, "短信内容" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0120_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

