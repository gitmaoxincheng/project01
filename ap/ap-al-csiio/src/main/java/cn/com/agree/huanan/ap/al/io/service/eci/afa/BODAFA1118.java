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
 * BASESVC BODAFA1118  支付系统次日转账
 * BODAFA1118 612010 612010
 *  综合前置
 * @author zhonggp
 */
@Component
public class BODAFA1118 extends EciChannelService {

	private static BODAFA1118_I i = new BODAFA1118_I();
	private static BODAFA1118_O o = new BODAFA1118_O();

	public BODAFA1118() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1118_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("channeldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "channeldate", 8,0, false, "渠道日期" )))
					.addNode(new FieldNode("svacbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "svacbr", 20,0, true, "考核机构" )))
					.addNode(new FieldNode("payeracc", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeracc", 32,0, false, "付款人账号" )))
					.addNode(new FieldNode("payername", new MsgField(ContentEnum.MessageType.STRING.toString(), "payername", 60,0, false, "付款人名称" )))
					.addNode(new FieldNode("payeraddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeraddr", 20,0, false, "付款人地址" )))
					.addNode(new FieldNode("payeeacc", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeeacc", 32,0, false, "接收人账号" )))
					.addNode(new FieldNode("payeename", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeename", 60,0, false, "接收人姓名" )))
					.addNode(new FieldNode("payeeaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeeaddr", 60,0, false, "收款人地址" )))
					.addNode(new FieldNode("payeebank", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeebank", 14,0, true, "接收行号" )))
					.addNode(new FieldNode("smrycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "smrycd", 5,0, false, "摘要码" )))
					.addNode(new FieldNode("reqpostscript", new MsgField(ContentEnum.MessageType.STRING.toString(), "reqpostscript", 60,0, false, "附言" )))
					.addNode(new FieldNode("isothdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "isothdate", 1,0, false, "转账模式" )))
					.addNode(new FieldNode("isothbank", new MsgField(ContentEnum.MessageType.STRING.toString(), "isothbank", 1,0, false, "转账类别" )))
					.addNode(new FieldNode("chrgfg", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrgfg", 1,0, false, "是否收手续费标志" )))
					.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "amount", 17,0, false, "交易金额" )))
					.addNode(new FieldNode("chargeamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "chargeamt", 17,0, false, "手续费金额" )))
					.addNode(new FieldNode("chargeacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "chargeacctno", 32,0, false, "手续费账号" )))
					.addNode(new FieldNode("trsmtg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trsmtg", 1,0, false, "是否累计限额标志" )))
					.addNode(new FieldNode("trcttg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trcttg", 1,0, false, "是否控制限额标识" )))
					
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODAFA1118_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("paymode", new MsgField(ContentEnum.MessageType.STRING.toString(), "paymode", 1,0, false, "转账方式" )))
					.addNode(new FieldNode("payeracc", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeracc", 32,0, false, "付款人账号" )))
					.addNode(new FieldNode("payername", new MsgField(ContentEnum.MessageType.STRING.toString(), "payername", 60,0, false, "付款人名称" )))
					.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "amount", 17,0, false, "交易金额" )))
					.addNode(new FieldNode("hostdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "hostdate", 8,0, false, "核心日期" )))
					.addNode(new FieldNode("hostserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "hostserialno", 20,0, false, "核心流水" )))
					.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedate", 8,0, false, "报文前置日期" )))
					.addNode(new FieldNode("tradeserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradeserno", 40,0, false, "报文前置流水" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
