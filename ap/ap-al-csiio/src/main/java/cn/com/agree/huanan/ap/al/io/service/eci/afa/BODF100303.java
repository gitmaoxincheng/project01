package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciF10ChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODF100303 定期定额信息查询交易 BODF100303 regflw 综合前置
 * 
 * @author XZF
 */
@Component
public class BODF100303 extends EciF10ChannelService {

	private static BODF100303_I i = new BODF100303_I();
	private static BODF100303_O o = new BODF100303_O();

	public BODF100303() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100303_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode
					.addStructNode(new StructNode("APPBody", true, "Body")
							.addNode(new FieldNode("AccType",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "AccType", 1, 0, true,
											"客户标识类型")))
							.addNode(new FieldNode("Account",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "Account", 32, 0, true,
											"客户标识")))
							.addNode(new FieldNode("IdType",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 1, 0, true,
											"证件类型")))
							.addNode(new FieldNode("PrdCode",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 20, 0, false,
											"产品代码")))
							.addNode(new FieldNode("TACode",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 20, 0, false,
											"TA代码")))
							.addNode(new FieldNode("OffSet",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 50, 0, true,
											"定位串")))
							.addNode(new FieldNode("QueryNum",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "QueryNum", 10, 0, true,
											"查询行数")))
							.addNode(new FieldNode("SerialNo",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "SerialNo", 10, 0, false,
											"定投编号")))
							.addNode(new FieldNode("ClientType",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 1, 0, false,
											"客户类型")))
							.addNode(new FieldNode("FinishFlag",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "FinishFlag", 1, 0, false,
											"结束标志")))
							.addNode(new FieldNode("Flag", new MsgField(ContentEnum.MessageType.STRING.toString(),
									"Flag", 1, 0, false, "过滤标志"))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100303_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode
					.addStructNode(new StructNode("Body", true, "APPBody")
							.addNode(new FieldNode("TotNum",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNum", 10, 0, true,
											"总行数")))
							.addNode(new FieldNode("RetNum",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "RetNum", 10, 0, true,
											"本次返回行数")))
							.addNode(new FieldNode("OffSet",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 50, 0, true,
											"定位串")))
							.addNode(new ArrayNode("bodrcd", true,"amt_list")
									.addNode(new FieldNode("ClientNo",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientNo", 40, 0,
													true, "客户编号")))
									.addNode(new FieldNode("ClientName",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientName", 80, 0,
													true, "客户名称")))
									.addNode(new FieldNode("SetDate",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "SetDate", 8, 0,
													true, "开通日期")))
									.addNode(new FieldNode("BankAcc",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "BankAcc", 30, 0,
													true, "银行账号")))
									.addNode(new FieldNode("AssetAcc",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "AssetAcc", 30, 0,
													false, "理财账号")))
									.addNode(new FieldNode("PrdCode",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 30, 0,
													true, "产品代码")))
									.addNode(new FieldNode("PrdName",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdName", 80, 0,
													true, "产品名称")))
									.addNode(new FieldNode("Amt",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "Amt", 17, 0, true,
													"保留金额")))
									.addNode(new FieldNode("InvestDay",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "InvestDay", 8, 0,
													true, "投资日")))
									.addNode(new FieldNode("Agio",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "Agio", 10, 0, true,
													"折扣率")))
									.addNode(new FieldNode("InvestTimes",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "InvestTimes", 10,
													0, true, "投资期数")))
									.addNode(new FieldNode("RemainTimes",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "RemainTimes", 10,
													0, true, "剩余投资期数")))
									.addNode(new FieldNode("TotTimes",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "TotTimes", 10, 0,
													true, "成功期数")))
									.addNode(new FieldNode("FailTimes",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "FailTimes", 10, 0,
													true, "连续失败期数")))
									.addNode(new FieldNode("LastInvestDate",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "LastInvestDate", 8,
													0, true, "最近投资日期")))
									.addNode(new FieldNode("LastMsg",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "LastMsg", 100, 0,
													false, "最近处理信息")))
									.addNode(new FieldNode("ClientManager",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientManager", 20,
													0, false, "客户经理代码")))
									.addNode(new FieldNode("SerialNo",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "SerialNo", 30, 0,
													false, "定投编号")))
									.addNode(new FieldNode("EndDate",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "EndDate", 8, 0,
													false, "终止日期")))
									.addNode(new FieldNode("NextInvestDate",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "NextInvestDate", 8,
													0, true, "下一投资日")))
									.addNode(new FieldNode("Period",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "Period", 10, 0,
													true, "投资周期")))
									.addNode(new FieldNode("Span",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "Span", 10, 0, true,
													"投资间隔")))
									.addNode(new FieldNode("OverFlag",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "OverFlag", 10, 0,
													true, "终止模式")))
									.addNode(new FieldNode("FinishFlag",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "FinishFlag", 1, 0,
													true, "结束标志")))
									.addNode(new FieldNode("StartInvestDate",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "StartInvestDate",
													8, 0, false, "定投开始日期")))
									.addNode(new FieldNode("CashFlag",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "CashFlag", 1, 0,
													false, "钞汇标志")))
									.addNode(new FieldNode("CurrType",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "CurrType", 3, 0,
													true, "币种")))
									.addNode(new FieldNode("TACode",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 10, 0,
													true, "TA代码")))
									.addNode(new FieldNode("RiskLevel",
											new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskLevel", 10, 0,
													true, "风险等级"))))
							.addNode(new FieldNode("EndAmt", new MsgField(
									ContentEnum.MessageType.STRING.toString(), "EndAmt", 17, 0, false, "成功金额"))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
