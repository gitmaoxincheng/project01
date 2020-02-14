package cn.com.agree.huanan.ap.al.io.service.eci.ebp;

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
 * BASESVC BODEBP0006  客户信息维护
 * BODEBP0006 addSqs regflw
 *  国结系统
 * @author ouyang
 */
@Component
public class BODEBP0006 extends EciChannelService {

	private static BODEBP0006_I i = new BODEBP0006_I();
	private static BODEBP0006_O o = new BODEBP0006_O();

	public BODEBP0006() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODEBP0006_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
            .addNode(new FieldNode("launchMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "launchMode", 1,0, false, "交易渠道" )))
            .addNode(new FieldNode("bizNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "bizNo", 50,0, false, "渠道业务编号" )))
            .addNode(new FieldNode("ghName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ghName", 50,0, false, "购汇人姓名" )))
            .addNode(new FieldNode("cardNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardNo", 20,0, false, "购汇人身份证件号码" )))
            .addNode(new FieldNode("ghCur", new MsgField(ContentEnum.MessageType.STRING.toString(), "ghCur", 5,0, false, "购汇币种" )))
            .addNode(new FieldNode("ghAmt", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "ghAmt", 18,2, false, "购汇金额" )))
            .addNode(new FieldNode("rmbAcctNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "rmbAcctNo", 30,0, false, "人民币账号" )))
            .addNode(new FieldNode("whAcctNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "whAcctNo", 30,0, false, "外汇账号" )))
            .addNode(new FieldNode("proxyName", new MsgField(ContentEnum.MessageType.STRING.toString(), "proxyName", 50,0, false, "代理人姓名" )))
            .addNode(new FieldNode("proxyCardNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "proxyCardNo", 20,0, false, "代理人身份证件号码" )))
            .addNode(new FieldNode("preUseTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "preUseTime", 20,0, true, "预计用汇时间" )))
            .addNode(new FieldNode("ghType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ghType", 2,0, false, "购汇用途类型" )))
            .addNode(new FieldNode("exinfo1", new MsgField(ContentEnum.MessageType.STRING.toString(), "exinfo1", 300,0, false, "购汇说明1" )))
            .addNode(new FieldNode("exinfo2", new MsgField(ContentEnum.MessageType.STRING.toString(), "exinfo2", 50,0, false, "购汇说明2" )))
            .addNode(new FieldNode("exinfo3", new MsgField(ContentEnum.MessageType.STRING.toString(), "exinfo3", 50,0, false, "购汇说明3" )))
            .addNode(new FieldNode("exinfo4", new MsgField(ContentEnum.MessageType.STRING.toString(), "exinfo4", 50,0, false, "购汇说明4" ))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODEBP0006_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
            .addNode(new FieldNode("code", new MsgField(ContentEnum.MessageType.STRING.toString(), "code", 8,0, false, "错误码" ))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
