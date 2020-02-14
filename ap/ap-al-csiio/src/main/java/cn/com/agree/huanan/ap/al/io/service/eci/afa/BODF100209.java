package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciF10ChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODF100209  定期定额修改交易 
 *  BODF100209 regflw
 *  综合前置
 * @author XZF
 */
@Component
public class BODF100209 extends EciF10ChannelService {
	
	private static BODF100209_I i = new BODF100209_I();
	private static BODF100209_O o = new BODF100209_O();
	public BODF100209() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100209_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("BankAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankAcc", 30,0, true, "银行账号" )))
					.addNode(new FieldNode("Passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "Passwd", 10,0, false, "密码" )))
					.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 10,0, true, "产品代码" )))
					.addNode(new FieldNode("SerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "SerialNo", 30,0, false, "定投编号" )))
					.addNode(new FieldNode("Amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Amt", 17,0, true, "金额" )))
					.addNode(new FieldNode("OverFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "OverFlag", 1,0, true, "终止模式" )))
					.addNode(new FieldNode("Period", new MsgField(ContentEnum.MessageType.STRING.toString(), "Period", 10,0, true, "投资周期" )))
					.addNode(new FieldNode("Span", new MsgField(ContentEnum.MessageType.STRING.toString(), "Span", 10,0, true, "投资间隔" )))
					.addNode(new FieldNode("EndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "EndDate", 8,0, true, "结束日期" )))
					.addNode(new FieldNode("InvestTimes", new MsgField(ContentEnum.MessageType.STRING.toString(), "InvestTimes", 10,0, true, "投资期数" )))
					.addNode(new FieldNode("EndAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "EndAmt", 17,0, true, "成功金额" )))
					.addNode(new FieldNode("InvestDay", new MsgField(ContentEnum.MessageType.STRING.toString(), "InvestDay", 8,0, false, "投资日" )))
					.addNode(new FieldNode("ClientManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientManager", 30,0, false, "客户经理代码" )))
					.addNode(new FieldNode("AccType", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccType", 1,0, true, "客户标识类型" )))
					.addNode(new FieldNode("Account", new MsgField(ContentEnum.MessageType.STRING.toString(), "Account", 32,0, true, "客户标识" )))
					.addNode(new FieldNode("IdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 6,0, true, "证件类型" )))
					.addNode(new FieldNode("StartInvestDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "StartInvestDate", 8,0, false, "定投开始日期" )))
					.addNode(new FieldNode("CashFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "CashFlag", 1,0, false, "钞汇标志" )))
					.addNode(new FieldNode("ClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 1,0, false, "客户类型" )))
					.addNode(new FieldNode("TransFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransFlag", 1,0, false, "交易标志" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100209_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("SerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "SerialNo", 30,0, true, "系统流水号" )))
					.addNode(new FieldNode("ClientNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientNo", 40,0, true, "客户编号" )))
					.addNode(new FieldNode("ClientName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientName", 80,0, true, "客户名称" )))
					.addNode(new FieldNode("TAName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TAName", 80,0, true, "TA名称" )))
					.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 10,0, true, "产品代码" )))
					.addNode(new FieldNode("PrdName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdName", 80,0, true, "产品名称" )))
					.addNode(new FieldNode("CurrType", new MsgField(ContentEnum.MessageType.STRING.toString(), "CurrType", 10,0, true, "币种" )))
					.addNode(new FieldNode("CashFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "CashFlag", 1,0, true, "钞汇标志" )))
					.addNode(new FieldNode("Amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Amt", 17,0, true, "金额" )))
					.addNode(new FieldNode("InvestTimes", new MsgField(ContentEnum.MessageType.STRING.toString(), "InvestTimes", 8,0, true, "投资期数" )))
					.addNode(new FieldNode("InvestDay", new MsgField(ContentEnum.MessageType.STRING.toString(), "InvestDay", 8,0, true, "自动投资日" )))
					.addNode(new FieldNode("EndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "EndDate", 8,0, true, "结束日期" )))
					.addNode(new FieldNode("NextInvestDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "NextInvestDate", 8,0, true, "下一投资日" )))
					.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 1,0, true, "交易状态" )))
					.addNode(new FieldNode("Summary", new MsgField(ContentEnum.MessageType.STRING.toString(), "Summary", 100,0, false, "备注" )))
					.addNode(new FieldNode("DivMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivMode", 1,0, true, "分红方式" )))
					.addNode(new FieldNode("DivModeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivModeName", 100,0, true, "分红方式名称" )))
					.addNode(new FieldNode("ManageCharge", new MsgField(ContentEnum.MessageType.STRING.toString(), "ManageCharge", 10,0, false, "外收费手续费" )))
					.addNode(new FieldNode("StatusName", new MsgField(ContentEnum.MessageType.STRING.toString(), "StatusName", 100,0, true, "交易状态名称" )))
					.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 10,0, true, "TA代码" )))
					.addNode(new FieldNode("TotTimes", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotTimes", 10,0, false, "已成功期数" )))
					.addNode(new FieldNode("RemainTimes", new MsgField(ContentEnum.MessageType.STRING.toString(), "RemainTimes", 10,0, false, "剩余投资期数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

