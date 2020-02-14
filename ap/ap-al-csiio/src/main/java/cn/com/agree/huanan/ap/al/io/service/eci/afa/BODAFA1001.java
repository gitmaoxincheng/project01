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
@Component
public class BODAFA1001 extends EciChannelService {

	private static BODAFA1001_I i = new BODAFA1001_I();
	private static BODAFA1001_O o = new BODAFA1001_O();
	public BODAFA1001() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1001_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("svacbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "svacbr", 20,0, false, "考核机构" )))
					.addNode(new FieldNode("payeracc", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeracc", 32,0, false, "付款人账号" )))
					.addNode(new FieldNode("payername", new MsgField(ContentEnum.MessageType.STRING.toString(), "payername", 40,0, false, "付款人名称" )))
					.addNode(new FieldNode("payeraddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeraddr", 20, 0, false, "付款人地址")))
					.addNode(new FieldNode("currtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "currtype", 3, 0, false, "币种")))
					.addNode(new FieldNode("payeeacc", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeeacc", 32, 0, false, "接收人账号")))
					.addNode(new FieldNode("payeename", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeename", 30, 0, false, "接收人姓名")))
					.addNode(new FieldNode("payeeaccbank", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeeaccbank", 20, 0, false, "收款方开户行")))
					.addNode(new FieldNode("payeeaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeeaddr", 50, 0, false, "收款人地址")))
					.addNode(new FieldNode("receiver", new MsgField(ContentEnum.MessageType.STRING.toString(), "receiver", 20, 0, false, "接收行号")))
					.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "amount", 17, 0, false, "交易金额")))
					.addNode(new FieldNode("chargeamount", new MsgField(ContentEnum.MessageType.STRING.toString(), "chargeamount", 17, 0, false, "手续费金额")))
					.addNode(new FieldNode("chargeacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "chargeacctno", 32, 0, false, "手续费账号")))
					.addNode(new FieldNode("channeldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "channeldate", 8, 0, false, "渠道日期")))
					.addNode(new FieldNode("reqpostscript", new MsgField(ContentEnum.MessageType.STRING.toString(), "reqpostscript", 80, 0, false, "附言")))
					.addNode(new FieldNode("priority", new MsgField(ContentEnum.MessageType.STRING.toString(), "priority", 1, 0, false, "优先级")))
					.addNode(new FieldNode("opertg", new MsgField(ContentEnum.MessageType.STRING.toString(), "opertg", 10, 0, false, "走大小额标识")))
					.addNode(new FieldNode("payeracctype", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeracctype", 1, 0, false, "业务类型")))
					.addNode(new FieldNode("chrgfg", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrgfg", 1, 0, false, "是否收手续费标志")))
					.addNode(new FieldNode("xnumflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "xnumflag", 17, 0, false, "交易方式")))
					.addNode(new FieldNode("smrycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "smrycd", 5, 0, false, "摘要码")))
					.addNode(new FieldNode("trsmtg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trsmtg", 1, 0, false, " 是否累计限额标志")))
					.addNode(new FieldNode("trcttg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trcttg", 1, 0, false, "是否控制限额标识")))
					.addNode(new FieldNode("idckfg", new MsgField(ContentEnum.MessageType.STRING.toString(), "idckfg", 1, 0, false, "是否校验证件有效期标志")))
					.addNode(new FieldNode("dscrtx", new MsgField(ContentEnum.MessageType.STRING.toString(), "dscrtx", 255, 0, false, "交易摘要")))
					.addNode(new FieldNode("limttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "limttp", 10, 0, false, "消费限额统计")))
					
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1001_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("payeracc", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeracc", 32,0, false, "付款人账号" )))
					.addNode(new FieldNode("payername", new MsgField(ContentEnum.MessageType.STRING.toString(), "payername", 40,0, false, "付款人名称" )))
					.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "amount", 17, 0, false, "交易金额")))				
					.addNode(new FieldNode("hostdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "hostdate", 8,0, false, "核心日期" )))
					.addNode(new FieldNode("hostserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "hostserialno", 20,0, false, "核心流水" )))
					.addNode(new FieldNode("opertg", new MsgField(ContentEnum.MessageType.STRING.toString(), "opertg", 20, 0, false, "系统标识")))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}

