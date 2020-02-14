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
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;

/**
 * BASESVC BODF100309  客户历史成交查询交易 
 *  BODF100309 
 *  综合前置
 * @author XZF
 */
@Component
public class BODF100309 extends EciF10ChannelService {

	private static BODF100309_I i = new BODF100309_I();
	private static BODF100309_O o = new BODF100309_O();
	public BODF100309() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100309_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("AccType", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccType", 1,0, true, "客户标识类型" )))
					.addNode(new FieldNode("Account", new MsgField(ContentEnum.MessageType.STRING.toString(), "Account", 32,0, true, "客户标识" )))
					.addNode(new FieldNode("IdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 1,0, false, "证件类型" )))
					.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 20,0, false, "TA代码" )))
					.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 20,0, false, "产品代码" )))
					.addNode(new FieldNode("BusinCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "BusinCode", 20,0, false, "业务类别" )))
					.addNode(new FieldNode("StartDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "StartDate", 8,0, true, "开始日期" )))
					.addNode(new FieldNode("EndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "EndDate", 8,0, true, "截止日期" )))
					.addNode(new FieldNode("OrderFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "OrderFlag", 1,0, false, "排序标志" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 50,0, true, "定位串" )))
					.addNode(new FieldNode("QueryNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "QueryNum", 10,0, true, "查询行数" )))
					.addNode(new FieldNode("BusinCodes", new MsgField(ContentEnum.MessageType.STRING.toString(), "BusinCodes", 1,0, false, "业务码组合" )))
					.addNode(new FieldNode("ClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 1,0, false, "客户类型" )))
					.addNode(new FieldNode("Statuss", new MsgField(ContentEnum.MessageType.STRING.toString(), "Statuss", 10,0, false, "交易状态组合" )))
					.addNode(new FieldNode("SerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "SerialNo", 10,0, false, "流水号" )))
					.addNode(new FieldNode("BidFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "BidFlag", 40,0, false, "招投表产品标志" )))
					.addNode(new FieldNode("CfmNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "CfmNo", 1,0, false, "确认流水号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100309_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("TotNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNum", 10,0, true, "总行数" )))
					.addNode(new FieldNode("RetNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "RetNum", 10,0, true, "本次返回行数" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 50,0, true, "定位串" )))
					.addNode(new ArrayNode("bodrcd",true,"detail_list")
							.addNode(new FieldNode("ClientNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientNo", 40,0, true, "客户编号" )))
							.addNode(new FieldNode("ClientName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientName", 16,0, true, "交易时间" )))
							.addNode(new FieldNode("ClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 1,0, true, "客户类型" )))
							.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 20,0, true, "TA代码" )))
							.addNode(new FieldNode("BusinCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "BusinCode", 10,0, true, "业务代码" )))
							.addNode(new FieldNode("BusinName", new MsgField(ContentEnum.MessageType.STRING.toString(), "BusinName", 80,0, true, "业务名称" )))
							.addNode(new FieldNode("TransDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransDate", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("SerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "SerialNo", 30,0, false, "流水号" )))
							.addNode(new FieldNode("CfmNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "CfmNo", 30,0, false, "确认序号" )))
							.addNode(new FieldNode("CfmDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "CfmDate", 8,0, true, "确认日期" )))
							.addNode(new FieldNode("ClearDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClearDate", 8,0, true, "划款日期" )))
							.addNode(new FieldNode("AssetAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "AssetAcc", 30,0, true, "理财账号" )))
							.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 80,0, true, "TA名称" )))
							.addNode(new FieldNode("PrdName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdName", 80,0, true, "产品名称" )))
							.addNode(new FieldNode("Amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Amt", 17,0, false, "金额" )))
							.addNode(new FieldNode("Vol", new MsgField(ContentEnum.MessageType.STRING.toString(), "Vol", 17,0, false, "理财产品份额" )))
							.addNode(new FieldNode("CfmAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "CfmAmt", 17,0, true, "确认金额" )))
							.addNode(new FieldNode("CfmVol", new MsgField(ContentEnum.MessageType.STRING.toString(), "CfmVol", 17,0, true, "确认份额" )))
							.addNode(new FieldNode("Charge", new MsgField(ContentEnum.MessageType.STRING.toString(), "Charge", 17,0, false, "手续费总额" )))
							.addNode(new FieldNode("TransferFee", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransferFee", 17,0, false, "过户费" )))
							.addNode(new FieldNode("StampTax", new MsgField(ContentEnum.MessageType.STRING.toString(), "StampTax", 17,0, false, "印花税" )))
							.addNode(new FieldNode("OtherFee1", new MsgField(ContentEnum.MessageType.STRING.toString(), "OtherFee1", 17,0, false, "其他费用1" )))
							.addNode(new FieldNode("OtherFee2", new MsgField(ContentEnum.MessageType.STRING.toString(), "OtherFee2", 17,0, false, "其他费用2" )))
							.addNode(new FieldNode("Interest", new MsgField(ContentEnum.MessageType.STRING.toString(), "Interest", 17,0, false, "利息" )))
							.addNode(new FieldNode("InterestTax", new MsgField(ContentEnum.MessageType.STRING.toString(), "InterestTax", 17,0, false, "利息税" )))
							.addNode(new FieldNode("Price", new MsgField(ContentEnum.MessageType.STRING.toString(), "Price", 10,0, false, "成交价格" )))
							.addNode(new FieldNode("CurrType", new MsgField(ContentEnum.MessageType.STRING.toString(), "CurrType", 30,0, true, "币种" )))
							.addNode(new FieldNode("TargPrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TargPrdCode", 30,0, false, "转入产品代码" )))
							.addNode(new FieldNode("TargSellerCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TargSellerCode", 30,0, false, "对方销售商代码" )))
							.addNode(new FieldNode("TargAssetAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "TargAssetAcc", 80,0, false, "对方理财账号" )))
							.addNode(new FieldNode("Side", new MsgField(ContentEnum.MessageType.STRING.toString(), "Side", 10,0, true, "业务发起人" )))
							.addNode(new FieldNode("DivMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivMode", 30,0, true, "分红方式" )))
							.addNode(new FieldNode("BankAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankAcc", 100,0, true, "银行账号" )))
							.addNode(new FieldNode("BranchNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BranchNo", 10,0, true, "交易机构" )))
							.addNode(new FieldNode("Channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "Channel", 100,0, true, "交易渠道" )))
							.addNode(new FieldNode("Summary", new MsgField(ContentEnum.MessageType.STRING.toString(), "Summary", 17,0, true, "摘要" )))
							.addNode(new FieldNode("NAV", new MsgField(ContentEnum.MessageType.STRING.toString(), "NAV", 17,0, true, "成交产品净值" )))
							.addNode(new FieldNode("PostVol", new MsgField(ContentEnum.MessageType.STRING.toString(), "PostVol", 17,0, false, "交易后余额" )))
							.addNode(new FieldNode("TransAccountType", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransAccountType", 1,0, true, "交易介质类型" )))
							.addNode(new FieldNode("TransAccount", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransAccount", 10,0, false, "交易介质" )))
							.addNode(new FieldNode("ManageCharge", new MsgField(ContentEnum.MessageType.STRING.toString(), "ManageCharge", 10,0, false, "外收费手续费" )))
							.addNode(new FieldNode("TAName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TAName", 100,0, false, "TA名称" )))
							.addNode(new FieldNode("DivModeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivModeName", 100,0, false, "分红方式名称" )))
							.addNode(new FieldNode("TransCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransCode", 10,0, false, "交易码" )))
							.addNode(new FieldNode("TransName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransName", 100,0, false, "交易名称" )))
							.addNode(new FieldNode("CashFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "CashFlag", 1,0, false, "钞汇标志" )))
							.addNode(new FieldNode("OperNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "OperNo", 10,0, true, "交易柜员" )))
							.addNode(new FieldNode("BranchNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BranchNo", 10,0, true, "交易机构" )))
							.addNode(new FieldNode("OpenBranch", new MsgField(ContentEnum.MessageType.STRING.toString(), "OpenBranch", 10,0, true, "交易所属机构" )))
							.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 1,0, true, "交易状态" )))
							.addNode(new FieldNode("StatusName", new MsgField(ContentEnum.MessageType.STRING.toString(), "StatusName", 100,0, true, "交易状态名称" )))
							.addNode(new FieldNode("TargPrdName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TargPrdName", 100,0, false, "目标产品名称" )))
							.addNode(new FieldNode("VolOfInt", new MsgField(ContentEnum.MessageType.STRING.toString(), "VolOfInt", 10,0, false, "利息转份额所得份额" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

