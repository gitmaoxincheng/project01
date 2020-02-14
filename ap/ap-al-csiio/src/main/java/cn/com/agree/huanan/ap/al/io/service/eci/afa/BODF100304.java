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
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;


/**
 * BASESVC BODF100304  客户理财产品查询交易 
 *  BODF100304 
 *  综合前端
 * @author XZF
 */
@Component
public class BODF100304 extends EciF10ChannelService {

	private static BODF100304_I i = new BODF100304_I();
	private static BODF100304_O o = new BODF100304_O();
	public BODF100304() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100304_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("AccType", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccType", 1,0, true, "客户标识类型" )))
					.addNode(new FieldNode("Account", new MsgField(ContentEnum.MessageType.STRING.toString(), "Account", 32,0, true, "客户标识" )))
					.addNode(new FieldNode("IdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 1,0, true, "证件类型" )))
					.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 20,0, false, "TA代码" )))
					.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 20,0, false, "产品代码" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 50,0, true, "定位串" )))
					.addNode(new FieldNode("QueryNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "QueryNum", 10,0, true, "查询行数" )))
					.addNode(new FieldNode("SellerType", new MsgField(ContentEnum.MessageType.STRING.toString(), "SellerType", 1,0, false, "是否代销" )))
					.addNode(new FieldNode("GtypeA", new MsgField(ContentEnum.MessageType.STRING.toString(), "GtypeA", 10,0, false, "分类A" )))
					.addNode(new FieldNode("GTypeB", new MsgField(ContentEnum.MessageType.STRING.toString(), "GTypeB", 10,0, false, "分类B" )))
					.addNode(new FieldNode("ClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 1,0, false, "客户类型" )))
					.addNode(new FieldNode("HostClientNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "HostClientNo", 10,0, false, "主机客户号" )))
					.addNode(new FieldNode("BidFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "BidFlag", 1,0, false, "是否过滤招投标产品" )))
					.addNode(new FieldNode("PrdTemplates", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdTemplates", 10,0, false, "产品模板代码" )))
					.addNode(new FieldNode("Flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "Flag", 1,0, true, "快速赎回使用标志" )))
					.addNode(new FieldNode("RealTimeRedFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "RealTimeRedFlag", 1,0, false, "产品是否允许实时赎回" )))
					.addNode(new FieldNode("Flag2", new MsgField(ContentEnum.MessageType.STRING.toString(), "Flag2", 1,0, false, "产品是否允许实时赎回" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100304_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("TotNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNum", 10,0, true, "总行数" )))
					.addNode(new FieldNode("RetNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "RetNum", 10,0, true, "本次返回行数" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 50,0, true, "定位串" )))
					.addNode(new ArrayNode("bodrcd",true,"tran_list")
							.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 20,0, true, "TA代码" )))
							.addNode(new FieldNode("TAShortName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TAShortName", 80,0, true, "TA简称" )))
							.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 20,0, true, "产品代码" )))
							.addNode(new FieldNode("PrdName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdName", 80,0, true, "产品名称" )))
							.addNode(new FieldNode("CurrType", new MsgField(ContentEnum.MessageType.STRING.toString(), "CurrType", 10,0, true, "币种" )))
							.addNode(new FieldNode("Vol", new MsgField(ContentEnum.MessageType.STRING.toString(), "Vol", 50,0, true, "理财产品份额" )))
							.addNode(new FieldNode("UseVol", new MsgField(ContentEnum.MessageType.STRING.toString(), "UseVol", 50,0, true, "可用份额" )))
							.addNode(new FieldNode("FrozenVol", new MsgField(ContentEnum.MessageType.STRING.toString(), "FrozenVol", 50,0, true, "交易冻结份额" )))
							.addNode(new FieldNode("LongFrozenVol", new MsgField(ContentEnum.MessageType.STRING.toString(), "LongFrozenVol", 50,0, true, "长期冻结份额" )))
							.addNode(new FieldNode("GroupVol", new MsgField(ContentEnum.MessageType.STRING.toString(), "GroupVol", 50,0, true, "组合投资份额" )))
							.addNode(new FieldNode("PrdValue", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdValue", 50,0, true, "产品市值" )))
							.addNode(new FieldNode("DivMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivMode", 10,0, true, "分红方式" )))
							.addNode(new FieldNode("DivModeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivModeName", 50,0, true, "分红方式名称" )))
							.addNode(new FieldNode("DivRate", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivRate", 80,0, true, "分红比例" )))
							.addNode(new FieldNode("Cost", new MsgField(ContentEnum.MessageType.STRING.toString(), "Cost", 17,0, true, "买入成本" )))
							.addNode(new FieldNode("TotIncome", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotIncome", 17,0, true, "累计收入" )))
							.addNode(new FieldNode("IncomeRate", new MsgField(ContentEnum.MessageType.STRING.toString(), "IncomeRate", 10,0, true, "收益率" )))
							.addNode(new FieldNode("SellerType", new MsgField(ContentEnum.MessageType.STRING.toString(), "SellerType", 1,0, false, "是否代销" )))
							.addNode(new FieldNode("GtypeA", new MsgField(ContentEnum.MessageType.STRING.toString(), "GtypeA", 10,0, false, "分类A" )))
							.addNode(new FieldNode("GTypeB", new MsgField(ContentEnum.MessageType.STRING.toString(), "GTypeB", 10,0, false, "分类B" )))
							.addNode(new FieldNode("SellerTypeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "SellerTypeName", 80,0, false, "是否代销名称" )))
							.addNode(new FieldNode("GtypeAName", new MsgField(ContentEnum.MessageType.STRING.toString(), "GtypeAName", 80,0, false, "分类A名称" )))
							.addNode(new FieldNode("GtypeBName", new MsgField(ContentEnum.MessageType.STRING.toString(), "GtypeBName", 80,0, false, "分类B名称" )))
							.addNode(new FieldNode("EstabDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "EstabDate", 8,0, false, "当作为购买日" )))
							.addNode(new FieldNode("OnwayAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "OnwayAmt", 10,0, false, "在途资金" )))
							.addNode(new FieldNode("BankAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankAcc", 40,0, true, "银行帐号" )))
							.addNode(new FieldNode("OtherFrozenVol", new MsgField(ContentEnum.MessageType.STRING.toString(), "OtherFrozenVol", 10,0, true, "本地冻结份额" )))
							.addNode(new FieldNode("InterestDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "InterestDate", 8,0, true, "起息日" )))
							.addNode(new FieldNode("EndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "EndDate", 8,0, true, "到期日" )))
							.addNode(new FieldNode("CashFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "CashFlag", 1,0, false, "钞汇标志" )))
							.addNode(new FieldNode("TransAccountType", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransAccountType", 1,0, false, "交易介质类型" )))
							.addNode(new FieldNode("TransAccount", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransAccount", 10,0, false, "交易介质" )))
							.addNode(new FieldNode("NAV", new MsgField(ContentEnum.MessageType.STRING.toString(), "NAV", 10,0, false, "净值" )))
							.addNode(new FieldNode("TotNav", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNav", 10,0, false, "累计净值" )))
							.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 1,0, false, "产品状态" )))
							.addNode(new FieldNode("TransWay", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransWay", 10,0, false, "交易方式" )))
							.addNode(new FieldNode("Channels", new MsgField(ContentEnum.MessageType.STRING.toString(), "Channels", 10,0, false, "允许渠道组" )))
							.addNode(new FieldNode("ConvFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ConvFlag", 1,0, false, "产品转换允许标识" )))
							.addNode(new FieldNode("PrdAttr", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdAttr", 10,0, false, "产品属性" )))
							.addNode(new FieldNode("CurValue", new MsgField(ContentEnum.MessageType.STRING.toString(), "CurValue", 50,0, false, "当前市值" )))
							.addNode(new FieldNode("TotCost", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotCost", 50,0, false, "累计投资金额" )))
							.addNode(new FieldNode("TotDivAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotDivAmt", 50,0, false, "累积现金红利" )))
							.addNode(new FieldNode("TotDivVol", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotDivVol", 50,0, false, "累计份额红利" )))
							.addNode(new FieldNode("TotIncomeAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotIncomeAmt", 50,0, false, "累计收益金额" )))
							.addNode(new FieldNode("ProfitLoss", new MsgField(ContentEnum.MessageType.STRING.toString(), "ProfitLoss", 50,0, false, "当前浮动盈亏" )))
							.addNode(new FieldNode("TotProfitLoss", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotProfitLoss", 50,0, false, "累计浮动盈亏" )))
							.addNode(new FieldNode("ProfitLossRate", new MsgField(ContentEnum.MessageType.STRING.toString(), "ProfitLossRate", 50,0, false, "盈亏率" )))
							.addNode(new FieldNode("UnitCost", new MsgField(ContentEnum.MessageType.STRING.toString(), "UnitCost", 50,0, false, "单位成本" )))
							.addNode(new FieldNode("CalcStartDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "CalcStartDate", 8,0, false, "收益计算开始时间" )))
							.addNode(new FieldNode("CalcEndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "CalcEndDate", 8,0, false, "收益计算结束时间" )))
							.addNode(new FieldNode("PrdTemplate", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdTemplate", 10,0, true, "模板代码" )))
							.addNode(new FieldNode("PsubUnit", new MsgField(ContentEnum.MessageType.STRING.toString(), "PsubUnit", 100,0, true, "个人最小购买单位" )))
							.addNode(new FieldNode("OsubUnit", new MsgField(ContentEnum.MessageType.STRING.toString(), "OsubUnit", 1,0, true, "机构最小购买单位" )))
							.addNode(new FieldNode("ControlFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ControlFlag", 256,0, true, "产品控制位" )))
							.addNode(new FieldNode("ControlFlag2", new MsgField(ContentEnum.MessageType.STRING.toString(), "ControlFlag2", 256,0, true, "产品控制位" )))
							.addNode(new FieldNode("ModelComment", new MsgField(ContentEnum.MessageType.STRING.toString(), "ModelComment", 50,0, true, "预期收益率（文本型）" )))
							.addNode(new FieldNode("GuestRate", new MsgField(ContentEnum.MessageType.STRING.toString(), "GuestRate", 50,0, true, "预期收益率（数字型）" )))
							.addNode(new FieldNode("BuyAmtOnWay", new MsgField(ContentEnum.MessageType.STRING.toString(), "BuyAmtOnWay", 50,0, false, "在途申购金额" )))
							.addNode(new FieldNode("RedAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "RedAmt", 50,0, false, "已快速赎回导出金额" )))
							.addNode(new FieldNode("IncomeOnWay", new MsgField(ContentEnum.MessageType.STRING.toString(), "IncomeOnWay", 50,0, false, "未付收益" )))
							.addNode(new FieldNode("UsedIncomeOnWay", new MsgField(ContentEnum.MessageType.STRING.toString(), "UsedIncomeOnWay", 50,0, false, "已使用未付收益" )))
							.addNode(new FieldNode("AllRed", new MsgField(ContentEnum.MessageType.STRING.toString(), "AllRed", 1,0, false, "全额赎回标志" )))
							.addNode(new FieldNode("TotPrdValue", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotPrdValue", 50,0, true, "产品总市值" )))
							.addNode(new FieldNode("RealTimeRedFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "RealTimeRedFlag", 50,0, false, "产品是否允许实时赎回" )))
							.addNode(new FieldNode("LastDayIncome", new MsgField(ContentEnum.MessageType.STRING.toString(), "LastDayIncome", 50,0, false, "昨日浮动盈亏" )))
							.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 10,0, false, "TA代码" )))
							.addNode(new FieldNode("YstdyPrdValue", new MsgField(ContentEnum.MessageType.STRING.toString(), "YstdyPrdValue", 50,0, false, "产品昨日市值" )))
							.addNode(new FieldNode("YebTotIncome", new MsgField(ContentEnum.MessageType.STRING.toString(), "YebTotIncome", 50,0, false, "余额宝累计收益" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

