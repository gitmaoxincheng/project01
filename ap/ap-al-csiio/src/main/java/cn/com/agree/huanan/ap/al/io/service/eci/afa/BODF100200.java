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
 * BASESVC BODF100200  理财产品购买（认购）交易 
 *  BODF100200 
 *  综合前置
 * @author XZF
 */
@Component
public class BODF100200 extends EciF10ChannelService {

	private static BODF100200_I i = new BODF100200_I();
	private static BODF100200_O o = new BODF100200_O();
	public BODF100200() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100200_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("BankAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankAcc", 40,0, true, "银行账号" )))
					.addNode(new FieldNode("Passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "Passwd", 300,0, false, "密码" )))
					.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 20,0, true, "产品代码" )))
					.addNode(new FieldNode("Amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Amt", 17,0, true, "金额" )))
					.addNode(new FieldNode("Vol", new MsgField(ContentEnum.MessageType.STRING.toString(), "Vol", 10,0, true, "份额" )))
					.addNode(new FieldNode("ClientManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientManager", 30,0, false, "客户经理代码代码" )))
					.addNode(new FieldNode("PrdKind", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdKind", 1,0, false, "产品业务模式" )))
					.addNode(new FieldNode("SellerCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "SellerCode", 30,0, false, "合作商号" )))
					.addNode(new FieldNode("AccType", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccType", 1,0, true, "客户标识类型" )))
					.addNode(new FieldNode("Account", new MsgField(ContentEnum.MessageType.STRING.toString(), "Account", 32,0, true, "客户标识" )))
					.addNode(new FieldNode("IdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 6,0, true, "证件类型" )))
					.addNode(new FieldNode("ClientGroup", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientGroup", 6,0, true, "客户分组" )))
					.addNode(new FieldNode("CashFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "CashFlag", 1,0, false, "钞汇标志" )))
					.addNode(new FieldNode("ClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 1,0, false, "客户类型" )))
					.addNode(new FieldNode("OpenBranch", new MsgField(ContentEnum.MessageType.STRING.toString(), "OpenBranch", 10,0, true, "开卡机构" )))
					.addNode(new FieldNode("DivMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivMode", 1,0, false, "分红方式" )))
					.addNode(new FieldNode("RollExistFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "RollExistFlag", 1,0, false, "是否开通滚存协议标志" )))
					.addNode(new FieldNode("DiscountFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "DiscountFlag", 1,0, false, "秒杀标志" )))
					.addNode(new FieldNode("CardType", new MsgField(ContentEnum.MessageType.STRING.toString(), "CardType", 1,0, true, "卡种" )))
					.addNode(new FieldNode("ClientManagerPro", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientManagerPro", 30,0, false, "客户经理贡献度占比" )))
					.addNode(new FieldNode("MutiRecommender", new MsgField(ContentEnum.MessageType.STRING.toString(), "MutiRecommender", 30,0, false, "推荐人" )))
					.addNode(new FieldNode("RecordeSeqNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "RecordeSeqNo", 30,0, false, "录音录像流水" )))
					.addNode(new FieldNode("HoldDays", new MsgField(ContentEnum.MessageType.STRING.toString(), "HoldDays", 10,0, false, "收益天数" )))
					.addNode(new FieldNode("DiscountSerial", new MsgField(ContentEnum.MessageType.STRING.toString(), "DiscountSerial", 30,0, false, "折扣流水" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100200_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("SerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "SerialNo", 30,0, true, "流水号" )))
					.addNode(new FieldNode("ClientNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientNo", 30,0, true, "客户号" )))
					.addNode(new FieldNode("ClientName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientName", 80,0, true, "客户名称" )))
					.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 30,0, true, "TA代码" )))
					.addNode(new FieldNode("TAName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TAName", 80,0, true, "TA名称" )))
					.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 20,0, true, "产品代码" )))
					.addNode(new FieldNode("PrdName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdName", 80,0, true, "产品名称" )))
					.addNode(new FieldNode("CurrType", new MsgField(ContentEnum.MessageType.STRING.toString(), "CurrType", 10,0, true, "币种" )))
					.addNode(new FieldNode("CashFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "CashFlag", 10,0, true, "钞汇标志" )))
					.addNode(new FieldNode("Amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Amt", 17,0, true, "金额" )))
					.addNode(new FieldNode("Vol", new MsgField(ContentEnum.MessageType.STRING.toString(), "Vol", 10,0, false, "份额" )))
					.addNode(new FieldNode("ShareClass", new MsgField(ContentEnum.MessageType.STRING.toString(), "ShareClass", 10,0, false, "收费方式" )))
					.addNode(new FieldNode("Agio", new MsgField(ContentEnum.MessageType.STRING.toString(), "Agio", 10,0, true, "折扣率" )))
					.addNode(new FieldNode("ClientManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientManager", 20,0, false, "客户经理代码代码" )))
					.addNode(new FieldNode("ManagerName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ManagerName", 80,0, false, "客户经理代码名称" )))
					.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 1,0, true, "交易状态" )))
					.addNode(new FieldNode("StatusName", new MsgField(ContentEnum.MessageType.STRING.toString(), "StatusName", 80,0, true, "交易状态名称" )))
					.addNode(new FieldNode("Summary", new MsgField(ContentEnum.MessageType.STRING.toString(), "Summary", 100,0, false, "备注" )))
					.addNode(new FieldNode("HostSerial", new MsgField(ContentEnum.MessageType.STRING.toString(), "HostSerial", 40,0, false, "主机流水号" )))
					.addNode(new FieldNode("TransName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransName", 100,0, true, "交易名称" )))
					.addNode(new FieldNode("FirstFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "FirstFlag", 1,0, true, "首次购买标识" )))
					.addNode(new FieldNode("DivMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivMode", 1,0, true, "分红方式" )))
					.addNode(new FieldNode("DivModeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivModeName", 100,0, true, "分红方式名称" )))
					.addNode(new FieldNode("ManageCharge", new MsgField(ContentEnum.MessageType.STRING.toString(), "ManageCharge", 10,0, false, "外收费手续费" )))
					.addNode(new FieldNode("AutoOpenAccFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "AutoOpenAccFlag", 1,0, true, "自动开理财账户标识" )))
					.addNode(new FieldNode("AutoOpenAccInfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "AutoOpenAccInfo", 100,0, false, "自动开理财账户提示信息" )))
					.addNode(new FieldNode("Reserve1", new MsgField(ContentEnum.MessageType.STRING.toString(), "Reserve1", 100,0, false, "购买变更分红方式失败信息" )))
					.addNode(new FieldNode("MonitorFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "MonitorFlag", 100,0, false, "风险等级不匹配提示信息" )))
					.addNode(new FieldNode("ReprName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprName", 100,0, false, "法人代表" )))
					.addNode(new FieldNode("EstabDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "EstabDate", 8,0, false, "产品成立日" )))
					.addNode(new FieldNode("EndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "EndDate", 8,0, false, "产品到期日" )))
					.addNode(new FieldNode("GuestRate", new MsgField(ContentEnum.MessageType.STRING.toString(), "GuestRate", 3,0, false, "预期收益率" )))
					.addNode(new FieldNode("IncomeDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "IncomeDate", 8,0, false, "产品起息日" )))
					.addNode(new FieldNode("PrdAccount", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdAccount", 16,0, true, "产品归集账号" )))
					.addNode(new FieldNode("DivModeChangFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivModeChangFlag", 10,0, false, "联动变更分红方式标志" )))
					.addNode(new FieldNode("TransType", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransType", 2,0, true, "交易类型" )))
					.addNode(new FieldNode("ModelComment", new MsgField(ContentEnum.MessageType.STRING.toString(), "ModelComment", 3,0, false, "预期收益率(字符型的)" )))
					.addNode(new FieldNode("TypeNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "TypeNo", 1,0, false, "收益分类" )))
					.addNode(new FieldNode("RefundDays", new MsgField(ContentEnum.MessageType.STRING.toString(), "RefundDays", 6,0, false, "产品到期资金到账天数" )))
					.addNode(new FieldNode("InvestRemark", new MsgField(ContentEnum.MessageType.STRING.toString(), "InvestRemark", 10,0, false, "产品投资范围" )))
					.addNode(new FieldNode("PrdRemark", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdRemark", 100,0, false, "产品备注" )))
					.addNode(new FieldNode("DiscountRatio", new MsgField(ContentEnum.MessageType.STRING.toString(), "DiscountRatio", 3,0, false, "秒杀收益率" )))
					.addNode(new FieldNode("DiscountSerial", new MsgField(ContentEnum.MessageType.STRING.toString(), "DiscountSerial", 40,0, false, "秒杀编号" )))
					.addNode(new FieldNode("InterestDays", new MsgField(ContentEnum.MessageType.STRING.toString(), "InterestDays", 10,0, true, "产品期限" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

