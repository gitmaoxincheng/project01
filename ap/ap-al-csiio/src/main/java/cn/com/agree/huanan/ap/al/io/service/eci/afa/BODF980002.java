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
 * BASESVC BODF980002  理财产品信息及额度查询 
 *  BODF980002 
 *  综合前置
 * @author XZF
 */
@Component
public class BODF980002 extends EciF10ChannelService {

	private static BODF980002_I i = new BODF980002_I();
	private static BODF980002_O o = new BODF980002_O();
	public BODF980002() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF980002_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 20,0, true, "TA代码" )))
					.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 20,0, true, "产品代码" )))
					.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 32,0, false, "产品状态" )))
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
					.addNode(new FieldNode("Flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "Flag", 1,0, false, "产品列表查询标识" )))
					.addNode(new FieldNode("BidFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "BidFlag", 1,0, false, "招投标产品过滤标志" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF980002_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("TotNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNum", 3,0, true, "总行数" )))
					.addNode(new FieldNode("RetNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "RetNum", 3,0, true, "本次返回行数" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 40,0, true, "定位串" )))
					.addNode(new ArrayNode("bodrcd",true,"prod_list")
							.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 20,0, true, "产品代码" )))
							.addNode(new FieldNode("PrdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdType", 40,0, true, "产品类别" )))
							.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 20,0, true, "TA代码" )))
							.addNode(new FieldNode("PrdName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdName", 40,0, true, "产品名称" )))
							.addNode(new FieldNode("NAV", new MsgField(ContentEnum.MessageType.STRING.toString(), "NAV", 32,0, true, "产品净值" )))
							.addNode(new FieldNode("FaceValue", new MsgField(ContentEnum.MessageType.STRING.toString(), "FaceValue", 32,0, true, "产品面值" )))
							.addNode(new FieldNode("IssPrice", new MsgField(ContentEnum.MessageType.STRING.toString(), "IssPrice", 20,0, true, "发行价格" )))
							.addNode(new FieldNode("IpoStartDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "IpoStartDate", 8,0, true, "募集开始日期" )))
							.addNode(new FieldNode("IpoEndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "IpoEndDate", 8,0, true, "募集结束日期" )))
							.addNode(new FieldNode("EstabDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "EstabDate", 8,0, true, "产品成立日期" )))
							.addNode(new FieldNode("PrdScale", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdScale", 40,0, true, "产品规模" )))
							.addNode(new FieldNode("TotVol", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotVol", 17,0, true, "总份额" )))
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
							.addNode(new FieldNode("PrdAttr", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdAttr", 40,0, true, "产品属性" )))
							.addNode(new FieldNode("RiskLevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskLevel", 10,0, true, "风险等级" )))
							.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 2,0, true, "产品状态" )))
							.addNode(new FieldNode("Debit_Account", new MsgField(ContentEnum.MessageType.STRING.toString(), "Debit_Account", 32,0, true, "募集帐号" )))
							.addNode(new FieldNode("EnableTrans", new MsgField(ContentEnum.MessageType.STRING.toString(), "EnableTrans", 10,0, true, "允许交易类型" )))
							.addNode(new FieldNode("PrdEndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdEndDate", 8,0, true, "产品到期日" )))
							.addNode(new FieldNode("GTypeA", new MsgField(ContentEnum.MessageType.STRING.toString(), "GTypeA", 10,0, true, "分类A" )))
							.addNode(new FieldNode("GTypeAName", new MsgField(ContentEnum.MessageType.STRING.toString(), "GTypeAName", 80,0, true, "分类A名称" )))
							.addNode(new FieldNode("GTypeB", new MsgField(ContentEnum.MessageType.STRING.toString(), "GTypeB", 10,0, true, "分类B" )))
							.addNode(new FieldNode("GTypeBName", new MsgField(ContentEnum.MessageType.STRING.toString(), "GTypeBName", 80,0, true, "分类B名称" )))
							.addNode(new FieldNode("GTypeC", new MsgField(ContentEnum.MessageType.STRING.toString(), "GTypeC", 10,0, true, "分类C" )))
							.addNode(new FieldNode("GTypeCName", new MsgField(ContentEnum.MessageType.STRING.toString(), "GTypeCName", 80,0, true, "分类C名称" )))
							.addNode(new FieldNode("SellerType", new MsgField(ContentEnum.MessageType.STRING.toString(), "SellerType", 1,0, true, "产品自营标志" )))
							.addNode(new FieldNode("SellerTypeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "SellerTypeName", 80,0, true, "产品自营标志名称" )))
							.addNode(new FieldNode("TotLimit", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotLimit", 10,0, true, "产品可认/申购额度" )))
							.addNode(new FieldNode("TotLocal", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotLocal", 10,0, true, "本支行分配的销售额度" )))
							.addNode(new FieldNode("TotUseLimit", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotUseLimit", 10,0, true, "本支行分配的剩余销售额度" )))
							.addNode(new FieldNode("OrgUseLimit", new MsgField(ContentEnum.MessageType.STRING.toString(), "OrgUseLimit", 10,0, true, "可用机构额度" )))
							.addNode(new FieldNode("PersonUseLimit", new MsgField(ContentEnum.MessageType.STRING.toString(), "PersonUseLimit", 10,0, true, "可用个人额度" )))
							.addNode(new FieldNode("AdjustUseLimit", new MsgField(ContentEnum.MessageType.STRING.toString(), "AdjustUseLimit", 10,0, true, "全行公共销售额度" )))
							.addNode(new FieldNode("EndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "EndDate", 8,0, true, "分配销售额度的有效日期" )))
							.addNode(new FieldNode("EndTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "EndTime", 6,0, true, "分配销售额度的有效时间" )))
							.addNode(new FieldNode("TotPersonAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotPersonAmt", 10,0, true, "本支行分配的个人销售额度" )))
							.addNode(new FieldNode("TotOrgUseAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotOrgUseAmt", 10,0, true, "本支行分配的机构销售额度" )))
							.addNode(new FieldNode("TotNav", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNav", 10,0, false, "产品累计净值" )))
							.addNode(new FieldNode("CashFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "CashFlag", 10,0, true, "钞汇标志" )))
							.addNode(new FieldNode("PerAllow", new MsgField(ContentEnum.MessageType.STRING.toString(), "PerAllow", 1,0, false, "对私是否允许" )))
							.addNode(new FieldNode("InstAllow", new MsgField(ContentEnum.MessageType.STRING.toString(), "InstAllow", 1,0, false, "对公是否允许" )))
							.addNode(new FieldNode("ShareClass", new MsgField(ContentEnum.MessageType.STRING.toString(), "ShareClass", 1,0, false, "收费方式" )))
							.addNode(new FieldNode("DirFreeDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "DirFreeDate", 8,0, false, "定向预约释放日期" )))
							.addNode(new FieldNode("InterestDays", new MsgField(ContentEnum.MessageType.STRING.toString(), "InterestDays", 10,0, false, "产品计息天数" )))
							.addNode(new FieldNode("ProtocolName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ProtocolName", 100,0, false, "协议书名称" )))
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
							.addNode(new FieldNode("TAName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TAName", 80,0, true, "TA名称" )))
							.addNode(new FieldNode("RiskName", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskName", 80,0, false, "风险等级名称" )))
							.addNode(new FieldNode("StatusName", new MsgField(ContentEnum.MessageType.STRING.toString(), "StatusName", 80,0, true, "产品状态名称" )))
							.addNode(new FieldNode("PsubUnit", new MsgField(ContentEnum.MessageType.STRING.toString(), "PsubUnit", 20,0, true, "个人最小购买单位" )))
							.addNode(new FieldNode("OsubUnit", new MsgField(ContentEnum.MessageType.STRING.toString(), "OsubUnit", 20,0, true, "机构最小购买单位" )))
							.addNode(new FieldNode("PminConvVol", new MsgField(ContentEnum.MessageType.STRING.toString(), "PminConvVol", 17,0, true, "个人最低基金转换份额" )))
							.addNode(new FieldNode("OminConvVol", new MsgField(ContentEnum.MessageType.STRING.toString(), "OminConvVol", 17,0, true, "机构最低基金转换份额" )))
							.addNode(new FieldNode("PminInvestAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "PminInvestAmt", 17,0, true, "个人最低自动申购金额" )))
							.addNode(new FieldNode("OminInvestAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "OminInvestAmt", 17,0, true, "机构最低自动申购金额" )))
							.addNode(new FieldNode("PminHold", new MsgField(ContentEnum.MessageType.STRING.toString(), "PminHold", 17,0, true, "个人最低持有份额" )))
							.addNode(new FieldNode("OminHold", new MsgField(ContentEnum.MessageType.STRING.toString(), "OminHold", 17,0, true, "机构最低持有份额" )))
							.addNode(new FieldNode("cpxl", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpxl", 20,0, true, "理财产品系列" )))
							.addNode(new FieldNode("cpxlName", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpxlName", 100,0, true, "理财产品系列名称" )))
							.addNode(new FieldNode("PredUnit", new MsgField(ContentEnum.MessageType.STRING.toString(), "PredUnit", 8,0, false, "个人最小赎回单位" )))
							.addNode(new FieldNode("OredUnit", new MsgField(ContentEnum.MessageType.STRING.toString(), "OredUnit", 8,0, false, "机构最小赎回单位" )))
							.addNode(new FieldNode("AlimitEndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "AlimitEndDate", 8,0, true, "封闭到期日" )))
							.addNode(new FieldNode("IpoTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "IpoTime", 8,0, false, "发行时间" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

