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
 * BASESVC BODAFA0164  贷记卡自扣还款账号查询和维护 
 *  BODAFA0164 
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA0164 extends EciChannelService {

	private static BODAFA0164_I i = new BODAFA0164_I();
	private static BODAFA0164_O o = new BODAFA0164_O();
	public BODAFA0164() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0164_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 19,0, true, "卡号" )))
					.addNode(new FieldNode("passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "passwd", 300,0, false, "交易密码" )))
					.addNode(new FieldNode("flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "flag", 2,0, true, "查询修改标志" )))
					.addNode(new FieldNode("currnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "currnum", 3,0, true, "币种" )))
					.addNode(new FieldNode("acct", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct", 19,0, false, "还款账号" )))
					.addNode(new FieldNode("repaycode", new MsgField(ContentEnum.MessageType.STRING.toString(), "repaycode", 1,0, false, "自扣还款方式" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 2,0, true, "证件种类" )))
					.addNode(new FieldNode("idno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idno", 18,0, true, "证件号码" )))
					.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 30,0, false, "姓名" )))
					.addNode(new FieldNode("idtype2", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype2", 2,0, false, "还款账号的证件类型" )))
					.addNode(new FieldNode("idno2", new MsgField(ContentEnum.MessageType.STRING.toString(), "idno2", 18,0, false, "还款账号的证件号码" )))
					.addNode(new FieldNode("passwd2", new MsgField(ContentEnum.MessageType.STRING.toString(), "passwd2", 300,0, false, "密码" )))
					.addNode(new FieldNode("custnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "custnm", 80,0, true, "持卡人姓名" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 2,0, false, "是否需要转密" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 18,0, false, "密钥序号" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 10,0, false, "密码的来源" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0164_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("currnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "currnum", 2,0, false, "币种" )))
					.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 30,0, false, "交易流水" )))
					.addNode(new FieldNode("acct", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct", 20,0, false, "还款账号" )))
					.addNode(new FieldNode("repaycode", new MsgField(ContentEnum.MessageType.STRING.toString(), "repaycode", 5,0, false, "自扣还款方式" )))
					.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 100,0, false, "持卡人姓名" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 10,0, false, "还款账号关系状态" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

