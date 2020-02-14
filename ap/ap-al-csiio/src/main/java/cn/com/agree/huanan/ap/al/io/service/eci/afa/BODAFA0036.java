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
 * 
 * @author zhuzc
 * BASESVC BODAFA0036 贷记卡行内转账
 * BODAFA0036 883310
 * ATM
 */
@Component
public class BODAFA0036 extends EciChannelService{
	private static BODAFA0036_I i = new BODAFA0036_I();
	private static BODAFA0036_O o = new BODAFA0036_O();
	public BODAFA0036() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0036_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("termid", new MsgField(ContentEnum.MessageType.STRING.toString(), "termid", 8,0, false, "终端编号" )))
					.addNode(new FieldNode("currtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "currtype", 2,0, false, "币种" )))
					.addNode(new FieldNode("tradetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradetype", 2,0, false, "交易方式" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 22,0, false, "卡号" )))
					.addNode(new FieldNode("passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "passwd", 16,0, false, "交易密码" )))
					.addNode(new FieldNode("track2", new MsgField(ContentEnum.MessageType.STRING.toString(), "track2", 40,0, false, "二磁道" )))
					.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "amount", 12,0, false, "交易金额" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 22,0, false, "转出卡号" )))
					.addNode(new FieldNode("prechannelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "prechannelserno", 40,0, false, "原渠道流水" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 1,0, false, "是否需要密码" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 20,0, false, "密钥序号" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 20,0, false, "密码的来源" )))
					.addNode(new FieldNode("p_entry", new MsgField(ContentEnum.MessageType.STRING.toString(), "p_entry", 3,0, false, "服务点进入方式" )))
					.addNode(new FieldNode("fridcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "fridcode", 20,0, false, "转发机构代码 " )))
					.addNode(new FieldNode("acidcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "acidcode", 20,0, false, "代理行机构代码" )))
					.addNode(new FieldNode("cardflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardflag", 1,0, false, "卡标志" )))
					.addNode(new FieldNode("trsmtg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trsmtg", 1,0, false, " 是否累计限额标志" )))
					.addNode(new FieldNode("trcttg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trcttg", 1,0, false, "是否控制限额标识" )))
					.addNode(new FieldNode("ndtrpw", new MsgField(ContentEnum.MessageType.STRING.toString(), "ndtrpw", 1,0, false, "上主机验密标志" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0036_O extends MsgBody {
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
