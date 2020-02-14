package cn.com.agree.huanan.ap.al.io.service.sbc;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbSbcChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P053000113 理财信息查询.理财产品信息查询 
 * P0530001.13 DS0001
 * 0212 金融互联网服务平台
 * @author XZF
 */
@Component
public class P053000113 extends EsbSbcChannelService {

	private static P053000113_I i = new P053000113_I();
	private static P053000113_O o = new P053000113_O();
	public P053000113() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P053000113_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("prdcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdcode", 20,0, false, "产品代码" )))
					.addNode(new FieldNode("prdname", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdname", 50,0, false, "产品名称" )))
					.addNode(new FieldNode("prdtemplate", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdtemplate", 21,0, false, "产品模板" )))
					.addNode(new FieldNode("querytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "querytype", 2,0, false, "查询类型" )))
					.addNode(new ArrayNode("prdtemplatelist_list",false)
							.addNode(new FieldNode("prdtemplatelist", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdtemplatelist", 6,0, false, "每页记录个数" )))
					).addNode(new ArrayNode("statuslist_list",false)
							.addNode(new FieldNode("statuslist", new MsgField(ContentEnum.MessageType.STRING.toString(), "statuslist", 2,0, false, "每页记录个数" )))
					).addNode(new FieldNode("size", new MsgField(ContentEnum.MessageType.STRING.toString(), "size", 5,0, false, "每页记录个数" )))
					.addNode(new FieldNode("page", new MsgField(ContentEnum.MessageType.STRING.toString(), "page", 5,0, false, "页数" )))
					.addNode(new FieldNode("sort", new MsgField(ContentEnum.MessageType.STRING.toString(), "sort", 5,0, false, "排序" )))
					.addNode(new FieldNode("tacode", new MsgField(ContentEnum.MessageType.STRING.toString(), "tacode", 20,0, false, "ta代码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P053000113_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("total", new MsgField(ContentEnum.MessageType.STRING.toString(), "total", 5,0, false, "总条数" )))
					.addNode(new FieldNode("page", new MsgField(ContentEnum.MessageType.STRING.toString(), "page", 5,0, false, "页码" )))
					.addNode(new FieldNode("size", new MsgField(ContentEnum.MessageType.STRING.toString(), "size", 5,0, false, "页容量" )))
					.addNode(new FieldNode("sort", new MsgField(ContentEnum.MessageType.STRING.toString(), "sort", 5,0, false, "排序字段" )))
					.addNode(new ArrayNode("products_list",false)
							.addNode(new FieldNode("prdcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdcode", 20,0, false, "产品代码" )))
							.addNode(new FieldNode("prdtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdtype", 1,0, false, "产品类别" )))
							.addNode(new FieldNode("tacode", new MsgField(ContentEnum.MessageType.STRING.toString(), "tacode", 20,0, false, "ta代码" )))
							.addNode(new FieldNode("prdname", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdname", 50,0, false, "产品名称" )))
							.addNode(new FieldNode("nav", new MsgField(ContentEnum.MessageType.STRING.toString(), "nav", 21,0, false, "当前净值" )))
							.addNode(new FieldNode("facevalue", new MsgField(ContentEnum.MessageType.STRING.toString(), "facevalue", 21,0, false, "产品面值" )))
							.addNode(new FieldNode("issprice", new MsgField(ContentEnum.MessageType.STRING.toString(), "issprice", 21,0, false, "发行价格" )))
							.addNode(new FieldNode("ipostartdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "ipostartdate", 20,0, false, "产品募集开始日期" )))
							.addNode(new FieldNode("ipoenddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "ipoenddate", 20,0, false, "产品募集结束日期" )))
							.addNode(new FieldNode("estabdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "estabdate", 20,0, false, "产品成立日期" )))
							.addNode(new FieldNode("prdscale", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdscale", 20,0, false, "产品规模" )))
							.addNode(new FieldNode("totvol", new MsgField(ContentEnum.MessageType.STRING.toString(), "totvol", 21,0, false, "产品总份数" )))
							.addNode(new FieldNode("reddays", new MsgField(ContentEnum.MessageType.STRING.toString(), "reddays", 21,0, false, "赎回资金到帐天数" )))
							.addNode(new FieldNode("divdays", new MsgField(ContentEnum.MessageType.STRING.toString(), "divdays", 21,0, false, "分红资金到帐天数" )))
							.addNode(new FieldNode("refunddays", new MsgField(ContentEnum.MessageType.STRING.toString(), "refunddays", 21,0, false, "认申购退款结算天数" )))
							.addNode(new FieldNode("faildays", new MsgField(ContentEnum.MessageType.STRING.toString(), "faildays", 21,0, false, "发行失败资金到帐天数" )))
							.addNode(new FieldNode("pminred", new MsgField(ContentEnum.MessageType.STRING.toString(), "pminred", 21,0, false, "个人单笔最少赎回份额" )))
							.addNode(new FieldNode("ominred", new MsgField(ContentEnum.MessageType.STRING.toString(), "ominred", 21,0, false, "机构单笔最小赎回份额" )))
							.addNode(new FieldNode("pmaxred", new MsgField(ContentEnum.MessageType.STRING.toString(), "pmaxred", 21,0, false, "个人单笔最大赎回份额" )))
							.addNode(new FieldNode("omaxred", new MsgField(ContentEnum.MessageType.STRING.toString(), "omaxred", 21,0, false, "机构单笔最大赎回份额" )))
							.addNode(new FieldNode("pfirstamt", new MsgField(ContentEnum.MessageType.INT.toString(), "pfirstamt", 20,2, false, "个人首次最低投资金额" )))
							.addNode(new FieldNode("ofirstamt", new MsgField(ContentEnum.MessageType.INT.toString(), "ofirstamt", 20,2, false, "机构首次最低投资金额" )))
							.addNode(new FieldNode("pappamt", new MsgField(ContentEnum.MessageType.INT.toString(), "pappamt", 20,2, false, "个人追加最低投资金额" )))
							.addNode(new FieldNode("oappamt", new MsgField(ContentEnum.MessageType.INT.toString(), "oappamt", 20,2, false, "机构追加最低投资金额" )))
							.addNode(new FieldNode("prdsponsor", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdsponsor", 21,0, false, "产品发起人" )))
							.addNode(new FieldNode("prdtrustee", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdtrustee", 21,0, false, "产品托管人" )))
							.addNode(new FieldNode("prdmanager", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdmanager", 21,0, false, "产品管理人" )))
							.addNode(new FieldNode("currtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "currtype", 3,0, false, "币种" )))
							.addNode(new FieldNode("divmodes", new MsgField(ContentEnum.MessageType.STRING.toString(), "divmodes", 2,0, false, "允许的分红方式" )))
							.addNode(new FieldNode("divmode", new MsgField(ContentEnum.MessageType.STRING.toString(), "divmode", 1,0, false, "默认分红方式" )))
							.addNode(new FieldNode("opentime", new MsgField(ContentEnum.MessageType.STRING.toString(), "opentime", 21,0, false, "开市时间" )))
							.addNode(new FieldNode("closetime", new MsgField(ContentEnum.MessageType.STRING.toString(), "closetime", 21,0, false, "闭市时间" )))
							.addNode(new FieldNode("convflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "convflag", 1,0, false, "转换状态" )))
							.addNode(new FieldNode("channels", new MsgField(ContentEnum.MessageType.STRING.toString(), "channels", 32,0, false, "允许渠道组" )))
							.addNode(new FieldNode("prdattr", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdattr", 21,0, false, "产品属性" )))
							.addNode(new FieldNode("risklevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "risklevel", 21,0, false, "风险等级" )))
							.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 7,0, false, "产品状态" )))
							.addNode(new FieldNode("debit_account", new MsgField(ContentEnum.MessageType.STRING.toString(), "debit_account", 40,0, false, "募集帐号" )))
							.addNode(new FieldNode("enabletrans", new MsgField(ContentEnum.MessageType.STRING.toString(), "enabletrans", 21,0, false, "允许交易类型" )))
							.addNode(new FieldNode("prdenddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdenddate", 21,0, false, "产品到期日" )))
							.addNode(new FieldNode("gtypea", new MsgField(ContentEnum.MessageType.STRING.toString(), "gtypea", 21,0, false, "分类a" )))
							.addNode(new FieldNode("gtypeaname", new MsgField(ContentEnum.MessageType.STRING.toString(), "gtypeaname", 100,0, false, "分类a名称" )))
							.addNode(new FieldNode("gtypeb", new MsgField(ContentEnum.MessageType.STRING.toString(), "gtypeb", 21,0, false, "分类b" )))
							.addNode(new FieldNode("gtypebname", new MsgField(ContentEnum.MessageType.STRING.toString(), "gtypebname", 100,0, false, "分类b名称" )))
							.addNode(new FieldNode("gtypec", new MsgField(ContentEnum.MessageType.STRING.toString(), "gtypec", 21,0, false, "分类c" )))
							.addNode(new FieldNode("gtypecname", new MsgField(ContentEnum.MessageType.STRING.toString(), "gtypecname", 100,0, false, "分类c名称" )))
							.addNode(new FieldNode("sellertype", new MsgField(ContentEnum.MessageType.STRING.toString(), "sellertype", 21,0, false, "产品自营标志" )))
							.addNode(new FieldNode("sellertypename", new MsgField(ContentEnum.MessageType.STRING.toString(), "sellertypename", 21,0, false, "产品自营标志名称" )))
							.addNode(new FieldNode("totlimit", new MsgField(ContentEnum.MessageType.STRING.toString(), "totlimit", 21,0, false, "产品可认/申购额度" )))
							.addNode(new FieldNode("totlocal", new MsgField(ContentEnum.MessageType.STRING.toString(), "totlocal", 21,0, false, "本支行分配的销售额度" )))
							.addNode(new FieldNode("totuselimit", new MsgField(ContentEnum.MessageType.STRING.toString(), "totuselimit", 21,0, false, "本支行分配的剩余销售额度" )))
							.addNode(new FieldNode("orguselimit", new MsgField(ContentEnum.MessageType.STRING.toString(), "orguselimit", 21,0, false, "可用机构额度" )))
							.addNode(new FieldNode("personuselimit", new MsgField(ContentEnum.MessageType.STRING.toString(), "personuselimit", 21,0, false, "可用个人额度" )))
							.addNode(new FieldNode("adjustuselimit", new MsgField(ContentEnum.MessageType.STRING.toString(), "adjustuselimit", 21,0, false, "全行公共销售额度" )))
							.addNode(new FieldNode("enddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "enddate", 21,0, false, "分配销售额度的有效日期" )))
							.addNode(new FieldNode("endtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "endtime", 21,0, false, "分配销售额度的有效时间" )))
							.addNode(new FieldNode("totpersonamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "totpersonamt", 21,0, false, "本支行分配的个人销售额度" )))
							.addNode(new FieldNode("totorguseamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "totorguseamt", 21,0, false, "本支行分配的机构销售额度" )))
							.addNode(new FieldNode("totnav", new MsgField(ContentEnum.MessageType.STRING.toString(), "totnav", 21,0, false, "产品累计净值" )))
							.addNode(new FieldNode("cashflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "cashflag", 21,0, false, "钞汇标志" )))
							.addNode(new FieldNode("perallow", new MsgField(ContentEnum.MessageType.STRING.toString(), "perallow", 1,0, false, "对私是否允许" )))
							.addNode(new FieldNode("installow", new MsgField(ContentEnum.MessageType.STRING.toString(), "installow", 1,0, false, "对公是否允许" )))
							.addNode(new FieldNode("shareclass", new MsgField(ContentEnum.MessageType.STRING.toString(), "shareclass", 21,0, false, "收费方式" )))
							.addNode(new FieldNode("dirfreedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "dirfreedate", 21,0, false, "定向预约释放日期" )))
							.addNode(new FieldNode("interestdays", new MsgField(ContentEnum.MessageType.STRING.toString(), "interestdays", 21,0, false, "产品计息天数" )))
							.addNode(new FieldNode("protocolname", new MsgField(ContentEnum.MessageType.STRING.toString(), "protocolname", 250,0, false, "协议书名称" )))
							.addNode(new FieldNode("guestrate", new MsgField(ContentEnum.MessageType.STRING.toString(), "guestrate", 21,0, false, "预期收益率" )))
							.addNode(new FieldNode("incomedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "incomedate", 21,0, false, "产品起息日期" )))
							.addNode(new FieldNode("transway", new MsgField(ContentEnum.MessageType.STRING.toString(), "transway", 21,0, false, "交易方式" )))
							.addNode(new FieldNode("typeno", new MsgField(ContentEnum.MessageType.STRING.toString(), "typeno", 21,0, false, "产品收益分类代码" )))
							.addNode(new FieldNode("typename", new MsgField(ContentEnum.MessageType.STRING.toString(), "typename", 100,0, false, "产品收益分类名称" )))
							.addNode(new FieldNode("salestatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "salestatus", 21,0, false, "销售状态" )))
							.addNode(new FieldNode("prdtemplate", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdtemplate", 21,0, false, "模板代码" )))
							.addNode(new FieldNode("modelcomment", new MsgField(ContentEnum.MessageType.STRING.toString(), "modelcomment", 21,0, false, "预期收益率" )))
							.addNode(new FieldNode("prdminbala", new MsgField(ContentEnum.MessageType.INT.toString(), "prdminbala", 20,2, false, "产品最低募集金额" )))
							.addNode(new FieldNode("prdmaxbala", new MsgField(ContentEnum.MessageType.INT.toString(), "prdmaxbala", 20,2, false, "产品最高募集金额" )))
							.addNode(new FieldNode("incomeenddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "incomeenddate", 21,0, false, "收益到期日" )))
							.addNode(new FieldNode("pmaxaccamt", new MsgField(ContentEnum.MessageType.INT.toString(), "pmaxaccamt", 20,2, false, "个人单户累计最大购买金额" )))
							.addNode(new FieldNode("omaxaccamt", new MsgField(ContentEnum.MessageType.INT.toString(), "omaxaccamt", 20,2, false, "机构单户累计最大购买金额" )))
							.addNode(new FieldNode("pmaxamt", new MsgField(ContentEnum.MessageType.INT.toString(), "pmaxamt", 20,2, false, "个人单笔最大购买金额" )))
							.addNode(new FieldNode("omaxamt", new MsgField(ContentEnum.MessageType.INT.toString(), "omaxamt", 20,2, false, "机构单笔最大购买金额" )))
							.addNode(new FieldNode("iscycleprd", new MsgField(ContentEnum.MessageType.STRING.toString(), "iscycleprd", 21,0, false, "是否周期型产品" )))
							.addNode(new FieldNode("clientgroups", new MsgField(ContentEnum.MessageType.STRING.toString(), "clientgroups", 21,0, false, "允许的客户组别" )))
							.addNode(new FieldNode("controlflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "controlflag", 250,0, false, "控制标字段" )))
							.addNode(new FieldNode("cycledays", new MsgField(ContentEnum.MessageType.STRING.toString(), "cycledays", 21,0, false, "周期天数" )))
							.addNode(new FieldNode("orderdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "orderdate", 21,0, false, "预约开始日期" )))
							.addNode(new FieldNode("taname", new MsgField(ContentEnum.MessageType.STRING.toString(), "taname", 100,0, false, "ta名称" )))
							.addNode(new FieldNode("riskname", new MsgField(ContentEnum.MessageType.STRING.toString(), "riskname", 100,0, false, "风险等级名称" )))
							.addNode(new FieldNode("statusname", new MsgField(ContentEnum.MessageType.STRING.toString(), "statusname", 100,0, false, "产品状态名称" )))
							.addNode(new FieldNode("psubunit", new MsgField(ContentEnum.MessageType.STRING.toString(), "psubunit", 21,0, false, "个人最小购买单位" )))
							.addNode(new FieldNode("osubunit", new MsgField(ContentEnum.MessageType.STRING.toString(), "osubunit", 21,0, false, "机构最小购买单位" )))
							.addNode(new FieldNode("pminconvvol", new MsgField(ContentEnum.MessageType.STRING.toString(), "pminconvvol", 21,0, false, "个人最低基金转换份额" )))
							.addNode(new FieldNode("ominconvvol", new MsgField(ContentEnum.MessageType.STRING.toString(), "ominconvvol", 21,0, false, "机构最低基金转换份额" )))
							.addNode(new FieldNode("pmininvestamt", new MsgField(ContentEnum.MessageType.INT.toString(), "pmininvestamt", 20,2, false, "个人最低自动申购金额" )))
							.addNode(new FieldNode("omininvestamt", new MsgField(ContentEnum.MessageType.INT.toString(), "omininvestamt", 20,2, false, "机构最低自动申购金额" )))
							.addNode(new FieldNode("pminhold", new MsgField(ContentEnum.MessageType.STRING.toString(), "pminhold", 21,0, false, "个人最低持有份额" )))
							.addNode(new FieldNode("ominhold", new MsgField(ContentEnum.MessageType.STRING.toString(), "ominhold", 21,0, false, "机构最低持有份额" )))
							.addNode(new FieldNode("topflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "topflag", 1,0, false, "是否置顶" )))
							.addNode(new FieldNode("filepath", new MsgField(ContentEnum.MessageType.STRING.toString(), "filepath", 100,0, false, "文件路径" )))
							.addNode(new FieldNode("diftime", new MsgField(ContentEnum.MessageType.STRING.toString(), "diftime", 250,0, false, "抢购倒计时" )))
							.addNode(new FieldNode("deadine", new MsgField(ContentEnum.MessageType.STRING.toString(), "deadine", 255,0, false, "期限" )))
							.addNode(new FieldNode("ordertime", new MsgField(ContentEnum.MessageType.STRING.toString(), "ordertime", 20,0, false, "预约购买开始时间" )))
							.addNode(new FieldNode("orderenddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "orderenddate", 20,0, false, "预约购买结束日期" )))
							.addNode(new FieldNode("orderendtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "orderendtime", 20,0, false, "预约购买结束时间" )))
							.addNode(new FieldNode("dirstartdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "dirstartdate", 20,0, false, "定向预约开始日期" )))
							.addNode(new FieldNode("dirstarttime", new MsgField(ContentEnum.MessageType.STRING.toString(), "dirstarttime", 20,0, false, "定向预约开始时间" )))
							.addNode(new FieldNode("dirfreedates", new MsgField(ContentEnum.MessageType.STRING.toString(), "dirfreedates", 20,0, false, "定向预约有效天数" )))
							.addNode(new FieldNode("modelcommenttemp", new MsgField(ContentEnum.MessageType.STRING.toString(), "modelcommenttemp", 250,0, false, "预期收益率，支持5%8%" )))
							.addNode(new FieldNode("prdyield", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdyield", 20,0, false, "七日年化收益率" )))
							.addNode(new FieldNode("cycle_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "cycle_date", 20,0, false, "七日年化收益率" )))
							.addNode(new FieldNode("typerange", new MsgField(ContentEnum.MessageType.STRING.toString(), "typerange", 250,0, false, "七日年化收益率" )))
							.addNode(new FieldNode("internal_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "internal_type", 1,0, false, "产品分类" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

