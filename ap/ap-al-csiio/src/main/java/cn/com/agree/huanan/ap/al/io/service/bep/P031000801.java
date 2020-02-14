package cn.com.agree.huanan.ap.al.io.service.bep;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P031000801 跨行转账.普通跨行转账 
 * P0310008.01 620500
 * 0062 小额支付系统二代
 * @author LSJ
 */
@Component
public class P031000801 extends EsbChannelService {

	private static P031000801_I i = new P031000801_I();
	private static P031000801_O o = new P031000801_O();

	public P031000801() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P031000801_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("payeracc", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeracc", 40,0, true, "付款人账号" )))
					.addNode(new FieldNode("payername", new MsgField(ContentEnum.MessageType.STRING.toString(), "payername", 256,0, true, "付款人名称" )))
					.addNode(new FieldNode("payeraddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeraddr", 120,0, false, "付款人地址" )))
					.addNode(new FieldNode("currtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "currtype", 3,0, true, "币种" )))
					.addNode(new FieldNode("payeeacc", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeeacc", 40,0, true, "收款人账号" )))
					.addNode(new FieldNode("payeename", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeename", 256,0, true, "收款人姓名" )))
					.addNode(new FieldNode("payeeaccbank", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeeaccbank", 14,0, true, "收款人开户行" )))
					.addNode(new FieldNode("payeeaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeeaddr", 120,0, false, "收款人地址" )))
					.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "amount", 18,2, true, "交易金额" )))
					.addNode(new FieldNode("priority", new MsgField(ContentEnum.MessageType.STRING.toString(), "priority", 1,0, true, "优先级" )))
					.addNode(new FieldNode("chrgfg", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrgfg", 1,0, true, "是否收手续费标志" )))
					.addNode(new FieldNode("chargeamount", new MsgField(ContentEnum.MessageType.INT.toString(), "chargeamount", 18,2, false, "手续费金额" )))
					.addNode(new FieldNode("chargeacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "chargeacctno", 40,0, false, "手续费账号" )))
					.addNode(new FieldNode("reqpostscript", new MsgField(ContentEnum.MessageType.STRING.toString(), "reqpostscript", 120,0, false, "附言" )))
					.addNode(new FieldNode("smrycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "smrycd", 10,0, false, "摘要码" )))
					.addNode(new FieldNode("dscrtx", new MsgField(ContentEnum.MessageType.STRING.toString(), "dscrtx", 225,0, false, "交易摘要" )))
					.addNode(new FieldNode("payervouchtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "payervouchtype", 8,0, false, "凭证类型" )))
					.addNode(new FieldNode("payervouchno", new MsgField(ContentEnum.MessageType.STRING.toString(), "payervouchno", 35,0, false, "凭证号码" )))
					.addNode(new FieldNode("payervouchdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "payervouchdate", 8,0, false, "凭证日期" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class P031000801_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("workdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "workdate", 8,0, false, "前置记账日期" )))
					.addNode(new FieldNode("worktime", new MsgField(ContentEnum.MessageType.STRING.toString(), "worktime", 6,0, false, "前置记账时间" )))
					.addNode(new FieldNode("serialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "serialno", 20,0, false, "前置记账流水" )))
					.addNode(new FieldNode("payeracc", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeracc", 40,0, false, "付款人账号" )))
					.addNode(new FieldNode("payername", new MsgField(ContentEnum.MessageType.STRING.toString(), "payername", 256,0, false, "付款人名称" )))
					.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "amount", 18,2, false, "交易金额" )))
					.addNode(new FieldNode("hostdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "hostdate", 8,0, false, "核心日期" )))
					.addNode(new FieldNode("hostserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "hostserialno", 40,0, false, "核心流水" )))
					.addNode(new FieldNode("sysid", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysid", 4,0, false, "系统标识" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
