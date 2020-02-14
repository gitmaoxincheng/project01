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
 * BASESVC BODF100331  理财产品信息查询 
 *  BODF100331 
 *  综合前置
 * @author XZF
 */
@Component
public class BODF100331 extends EciF10ChannelService {

	private static BODF100331_I i = new BODF100331_I();
	private static BODF100331_O o = new BODF100331_O();
	public BODF100331() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100331_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 20,0, false, "TA代码" )))
					.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 20,0, false, "产品代码" )))
					.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 1,0, false, "产品状态" )))
					.addNode(new FieldNode("RiskLevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskLevel", 10,0, false, "风险等级" )))
					.addNode(new FieldNode("PrdManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdManager", 10,0, false, "产品管理人代码" )))
					.addNode(new FieldNode("PrdAttr", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdAttr", 10,0, false, "产品属性" )))
					.addNode(new FieldNode("ClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 1,0, false, "客户允许类型" )))
					.addNode(new FieldNode("TypeNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "TypeNo", 1,0, false, "产品收益分类" )))
					.addNode(new FieldNode("TemplateCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TemplateCode", 10,0, false, "模板代码" )))
					.addNode(new FieldNode("OrderFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "OrderFlag", 1,0, false, "排序标志" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 40,0, true, "定位串" )))
					.addNode(new FieldNode("QueryNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "QueryNum", 10,0, true, "查询行数" )))
					.addNode(new FieldNode("IncomeDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "IncomeDate", 8,0, false, "产品起息日期" )))
					.addNode(new FieldNode("IncomeEndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "IncomeEndDate", 8,0, false, "收益到期日" )))
					.addNode(new ArrayNode("Flag",false)
							).addNode(new FieldNode("BidFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "BidFlag", 1,0, false, "招投标产品过滤标志" )))
					.addNode(new FieldNode("QueryFields", new MsgField(ContentEnum.MessageType.STRING.toString(), "QueryFields", 512,0, true, "额外的产品信息" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100331_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("TotNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNum", 3,0, true, "总行数" )))
					.addNode(new FieldNode("RetNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "RetNum", 3,0, true, "本次返回行数" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 40,0, true, "定位串" )))
					.addNode(new StructNode("bodrcd",true)
							.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 20,0, true, "产品代码" )))
							.addNode(new FieldNode("PrdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdType", 40,0, true, "产品类别" )))
							.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 20,0, true, "TA代码" )))
							.addNode(new FieldNode("TAName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TAName", 100,0, true, "TA名称" )))
							.addNode(new FieldNode("PrdName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdName", 40,0, true, "产品名称" )))
							.addNode(new FieldNode("NAV", new MsgField(ContentEnum.MessageType.STRING.toString(), "NAV", 32,0, true, "产品净值" )))
							.addNode(new FieldNode("FaceValue", new MsgField(ContentEnum.MessageType.STRING.toString(), "FaceValue", 32,0, false, "产品面值" )))
							.addNode(new FieldNode("IssPrice", new MsgField(ContentEnum.MessageType.STRING.toString(), "IssPrice", 20,0, false, "发行价格" )))
							.addNode(new FieldNode("IpoStartDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "IpoStartDate", 8,0, false, "募集开始日期" )))
							.addNode(new FieldNode("IpoEndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "IpoEndDate", 8,0, false, "募集结束日期" )))
							.addNode(new FieldNode("EstabDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "EstabDate", 8,0, false, "产品成立日期" )))
							.addNode(new FieldNode("PrdScale", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdScale", 40,0, true, "产品规模" )))
							.addNode(new FieldNode("TotVol", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotVol", 17,0, true, "总份额" )))
							.addNode(new FieldNode("PsubUnit", new MsgField(ContentEnum.MessageType.STRING.toString(), "PsubUnit", 10,0, true, "个人最小购买单位" )))
							.addNode(new FieldNode("OsubUnit", new MsgField(ContentEnum.MessageType.STRING.toString(), "OsubUnit", 20,0, true, "最小购买单位" )))
							.addNode(new FieldNode("RedDays", new MsgField(ContentEnum.MessageType.STRING.toString(), "RedDays", 10,0, true, "赎回资金到账天数" )))
							.addNode(new FieldNode("DivDays", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivDays", 10,0, true, "分红资金到账天数" )))
							.addNode(new FieldNode("RefundDays", new MsgField(ContentEnum.MessageType.STRING.toString(), "RefundDays", 10,0, true, "认申购退款结算天数" )))
							.addNode(new FieldNode("FailDays", new MsgField(ContentEnum.MessageType.STRING.toString(), "FailDays", 10,0, true, "发行失败资金到账天数" )))
							.addNode(new FieldNode("PminRed", new MsgField(ContentEnum.MessageType.STRING.toString(), "PminRed", 17,0, true, "个人单笔最少赎回份额" )))
							.addNode(new FieldNode("OminRed", new MsgField(ContentEnum.MessageType.STRING.toString(), "OminRed", 32,0, true, "机构单笔最小赎回份额" )))
							.addNode(new FieldNode("PmaxRed", new MsgField(ContentEnum.MessageType.STRING.toString(), "PmaxRed", 17,0, true, "个人单笔最大赎回份额" )))
							.addNode(new FieldNode("OmaxRed", new MsgField(ContentEnum.MessageType.STRING.toString(), "OmaxRed", 17,0, true, "机构单笔最大赎回份额" )))
							.addNode(new FieldNode("PfirstAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "PfirstAmt", 17,0, true, "个人首次最低投资金额" )))
							.addNode(new FieldNode("OfirstAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "OfirstAmt", 17,0, true, "机构首次最低投资金额" )))
							.addNode(new FieldNode("PappAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "PappAmt", 17,0, true, "个人追加最低投资金额" )))
							.addNode(new FieldNode("OappAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "OappAmt", 17,0, true, "机构追加最低投资金额" )))
							.addNode(new FieldNode("PminConvVol", new MsgField(ContentEnum.MessageType.STRING.toString(), "PminConvVol", 17,0, true, "最低基金转换份额" )))
							.addNode(new FieldNode("OminConvVol", new MsgField(ContentEnum.MessageType.STRING.toString(), "OminConvVol", 17,0, true, "机构最低基金转换份额" )))
							.addNode(new FieldNode("PminInvestAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "PminInvestAmt", 17,0, true, "最低自动申购金额" )))
							.addNode(new FieldNode("OminInvestAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "OminInvestAmt", 17,0, true, "机构最低自动申购金额" )))
							.addNode(new FieldNode("PrdSponsor", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdSponsor", 20,0, true, "产品发起人" )))
							.addNode(new FieldNode("PrdTrustee", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdTrustee", 80,0, true, "产品托管人" )))
							.addNode(new FieldNode("PrdManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdManager", 17,0, true, "产品管理人" )))
							.addNode(new FieldNode("CurrType", new MsgField(ContentEnum.MessageType.STRING.toString(), "CurrType", 80,0, true, "币种" )))
							.addNode(new FieldNode("DivModes", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivModes", 40,0, true, "允许的分红方式" )))
							.addNode(new FieldNode("DivMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivMode", 80,0, false, "默认分红方式" )))
							.addNode(new FieldNode("OpenTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "OpenTime", 8,0, true, "开市时间" )))
							.addNode(new FieldNode("CloseTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "CloseTime", 32,0, true, "闭市时间" )))
							.addNode(new FieldNode("ConvFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ConvFlag", 20,0, true, "转换标志" )))
							.addNode(new FieldNode("Channels", new MsgField(ContentEnum.MessageType.STRING.toString(), "Channels", 80,0, true, "允许渠道组" )))
							.addNode(new FieldNode("PrdAttr", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdAttr", 40,0, false, "产品属性" )))
							.addNode(new FieldNode("RiskLevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskLevel", 10,0, false, "风险等级" )))
							.addNode(new FieldNode("RiskName", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskName", 40,0, false, "风险等级名称" )))
							.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 2,0, true, "产品状态" )))
							.addNode(new FieldNode("StatusName", new MsgField(ContentEnum.MessageType.STRING.toString(), "StatusName", 100,0, true, "产品状态名称" )))
							.addNode(new FieldNode("PminHold", new MsgField(ContentEnum.MessageType.STRING.toString(), "PminHold", 10,0, true, "个人最低持有份额" )))
							.addNode(new FieldNode("OminHold", new MsgField(ContentEnum.MessageType.STRING.toString(), "OminHold", 10,0, true, "机构最低持有份额" )))
							.addNode(new FieldNode("TotNav", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNav", 1,0, false, "产品累计净值" )))
							.addNode(new FieldNode("CashFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "CashFlag", 1,0, true, "钞汇标志" )))
							.addNode(new FieldNode("PerAllow", new MsgField(ContentEnum.MessageType.STRING.toString(), "PerAllow", 1,0, false, "对私是否允许" )))
							.addNode(new FieldNode("InstAllow", new MsgField(ContentEnum.MessageType.STRING.toString(), "InstAllow", 1,0, false, "对公是否允许" )))
							.addNode(new FieldNode("ShareClass", new MsgField(ContentEnum.MessageType.STRING.toString(), "ShareClass", 1,0, false, "收费方式" )))
							.addNode(new FieldNode("DirFreeDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "DirFreeDate", 8,0, false, "定向预约释放日期" )))
							.addNode(new FieldNode("InterestDays", new MsgField(ContentEnum.MessageType.STRING.toString(), "InterestDays", 10,0, false, "产品计息天数" )))
							.addNode(new FieldNode("ProtocolName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ProtocolName", 100,0, false, "协议书名称" )))
							.addNode(new FieldNode("EndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "EndDate", 8,0, false, "产品结束日" )))
							.addNode(new FieldNode("GuestRate", new MsgField(ContentEnum.MessageType.STRING.toString(), "GuestRate", 10,0, false, "预期收益率" )))
							.addNode(new FieldNode("IncomeDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "IncomeDate", 8,0, false, "产品起息日期" )))
							.addNode(new FieldNode("TransWay", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransWay", 10,0, false, "交易方式" )))
							.addNode(new FieldNode("TypeNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "TypeNo", 1,0, false, "产品收益分类代码" )))
							.addNode(new FieldNode("TypeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TypeName", 100,0, false, "产品收益分类名称" )))
							.addNode(new FieldNode("SaleStatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "SaleStatus", 10,0, false, "销售状态" )))
							.addNode(new FieldNode("PrdTemplate", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdTemplate", 10,0, true, "模板代码" )))
							.addNode(new FieldNode("ModelComment", new MsgField(ContentEnum.MessageType.STRING.toString(), "ModelComment", 10,0, false, "预期收益率" )))
							.addNode(new FieldNode("PrdMinBala", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdMinBala", 10,0, true, "产品最低募集金额" )))
							.addNode(new FieldNode("PrdMaxBala", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdMaxBala", 10,0, true, "产品最高募集金额" )))
							.addNode(new FieldNode("IncomeEndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "IncomeEndDate", 10,0, true, "收益到期日" )))
							.addNode(new FieldNode("PMaxAccAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "PMaxAccAmt", 10,0, true, "个人单户累计最大购买金额，" )))
							.addNode(new FieldNode("OMaxAccAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "OMaxAccAmt", 10,0, true, "机构单户累计最大购买金额" )))
							.addNode(new FieldNode("PMaxAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "PMaxAmt", 10,0, true, "个人单笔最大购买金额" )))
							.addNode(new FieldNode("OMaxAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "OMaxAmt", 10,0, true, "机构单笔最大购买金额" )))
							.addNode(new FieldNode("IsCyclePrd", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsCyclePrd", 10,0, true, "是否周期型产品" )))
							.addNode(new FieldNode("ClientGroups", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientGroups", 10,0, true, "允许的客户组别" )))
							.addNode(new FieldNode("ControlFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ControlFlag", 250,0, true, "控制标字段" )))
							.addNode(new FieldNode("CycleDays", new MsgField(ContentEnum.MessageType.STRING.toString(), "CycleDays", 10,0, true, "周期天数" )))
							.addNode(new FieldNode("OrderDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "OrderDate", 10,0, true, "预约开始日期" )))
							.addNode(new FieldNode("EnableTrans", new MsgField(ContentEnum.MessageType.STRING.toString(), "EnableTrans", 3,0, true, "允许交易类型" )))
							.addNode(new FieldNode("NavDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "NavDate", 8,0, true, "净值日期" )))
							.addNode(new FieldNode("PredUnit", new MsgField(ContentEnum.MessageType.STRING.toString(), "PredUnit", 8,0, false, "个人最小赎回单位" )))
							.addNode(new FieldNode("OredUnit", new MsgField(ContentEnum.MessageType.STRING.toString(), "OredUnit", 8,0, false, "机构最小赎回单位" )))
							.addNode(new FieldNode("AlimitEndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "AlimitEndDate", 8,0, true, "封闭到期日" )))
							.addNode(new FieldNode("IpoTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "IpoTime", 8,0, false, "发行时间" )))
							.addNode(new FieldNode("AutouninstDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "AutouninstDate", 8,0, true, "额度自动回收日期" )))
							.addNode(new FieldNode("AutouninstTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "AutouninstTime", 8,0, false, "额度自动回收时间" )))
							.addNode(new FieldNode("fee_account", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_account", 9,0, false, "转让手续费账号" )))
							.addNode(new FieldNode("start_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "start_date", 10,0, false, "转让开始日期" )))
							.addNode(new FieldNode("end_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_date", 11,0, false, "转让结束日期" )))
							.addNode(new FieldNode("min_price", new MsgField(ContentEnum.MessageType.STRING.toString(), "min_price", 12,0, false, "转让最低单价" )))
							.addNode(new FieldNode("max_price", new MsgField(ContentEnum.MessageType.STRING.toString(), "max_price", 13,0, false, "转让最高单价" )))
							.addNode(new FieldNode("conv_unit", new MsgField(ContentEnum.MessageType.STRING.toString(), "conv_unit", 14,0, false, "转让最小单位" )))
							.addNode(new FieldNode("zr_min_vol", new MsgField(ContentEnum.MessageType.STRING.toString(), "zr_min_vol", 15,0, false, "转让最小份额" )))
							.addNode(new FieldNode("zr_max_vol", new MsgField(ContentEnum.MessageType.STRING.toString(), "zr_max_vol", 16,0, false, "转让最大份额" )))
							.addNode(new FieldNode("zr_channels", new MsgField(ContentEnum.MessageType.STRING.toString(), "zr_channels", 17,0, false, "转让允许渠道组" )))
							.addNode(new FieldNode("conv_mode", new MsgField(ContentEnum.MessageType.STRING.toString(), "conv_mode", 18,0, false, "费用模式" )))
							.addNode(new FieldNode("match_rule", new MsgField(ContentEnum.MessageType.STRING.toString(), "match_rule", 19,0, false, "转让撮合规则是否同分行" )))
							.addNode(new FieldNode("price", new MsgField(ContentEnum.MessageType.STRING.toString(), "price", 20,0, false, "转让价格" )))
							.addNode(new FieldNode("IpoType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IpoType", 20,0, false, "产品募集方式代码" )))
							.addNode(new FieldNode("IpoTypeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "IpoTypeName", 20,0, false, "产品募集方式名称" )))
							.addNode(new FieldNode("PrdInvestType", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdInvestType", 20,0, false, "产品投资性质分类代码" )))
							.addNode(new FieldNode("PrdInvestTypeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdInvestTypeName", 20,0, false, "产品投资性质分类名称" )))
							.addNode(new FieldNode("clt_rapid_maxvol", new MsgField(ContentEnum.MessageType.STRING.toString(), "clt_rapid_maxvol", 20,0, false, "客户当日垫资额度" )))
							.addNode(new FieldNode("IsAllowPledge", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsAllowPledge", 20,0, false, "是否允许产品质押" )))
							.addNode(new FieldNode("debt_regist_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "debt_regist_code", 20,0, false, "中债登记编码" )))
							.addNode(new FieldNode("DebtRegistCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "DebtRegistCode", 20,0, false, "中债登记编码" )))
							.addNode(new FieldNode("MinHold", new MsgField(ContentEnum.MessageType.STRING.toString(), "MinHold", 20,0, false, "最低持有份额" )))
							.addNode(new FieldNode("internal_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "internal_type", 20,0, false, "产品分类" )))
							.addNode(new FieldNode("cycle_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "cycle_date", 20,0, false, "最后确认日（清算日）" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

