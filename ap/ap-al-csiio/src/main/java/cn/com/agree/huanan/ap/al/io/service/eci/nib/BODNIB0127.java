package cn.com.agree.huanan.ap.al.io.service.eci.nib;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODNIB0127  银保产品信息查询 
 *  BODNIB0127 regflw
 *  新个人网银
 * @author XZF
 */
@Component
public class BODNIB0127 extends EciChannelService {

	private static BODNIB0127_I i = new BODNIB0127_I();
	private static BODNIB0127_O o = new BODNIB0127_O();
	public BODNIB0127() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNIB0127_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("action", new MsgField(ContentEnum.MessageType.STRING.toString(), "action", 1024,0, true, "处理码" )))
					.addNode(new FieldNode("prdcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdcode", 1024,0, false, "产品代码" )))
					.addNode(new FieldNode("companyCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyCode", 1024,0, false, "公司代码" )))
					.addNode(new FieldNode("prdChildtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdChildtype", 1024,0, false, "产品类型" )))
					.addNode(new FieldNode("prdname", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdname", 1024,0, false, "产品名称" )))
					.addNode(new FieldNode("page", new MsgField(ContentEnum.MessageType.INT.toString(), "page", 1024,0, false, "页数" )))
					.addNode(new FieldNode("psize", new MsgField(ContentEnum.MessageType.INT.toString(), "psize", 1024,0, false, "每页记录个数" )))
					.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 1024,0, true, "上送渠道" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODNIB0127_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new ArrayNode("bodrcd",false,"procd_list")
							.addNode(new FieldNode("admitStatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "admitStatus", 1024,0, false, "准入状态" )))
							.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 1024,0, false, "渠道" )))
							.addNode(new FieldNode("checkWay", new MsgField(ContentEnum.MessageType.STRING.toString(), "checkWay", 1024,0, false, "checkWay" )))
							.addNode(new FieldNode("companyCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyCode", 1024,0, false, "保险公司代码" )))
							.addNode(new FieldNode("endDay", new MsgField(ContentEnum.MessageType.STRING.toString(), "endDay", 1024,0, false, "endDay" )))
							.addNode(new FieldNode("granPeriod", new MsgField(ContentEnum.MessageType.STRING.toString(), "granPeriod", 1024,0, false, "granPeriod" )))
							.addNode(new FieldNode("granPeriodType", new MsgField(ContentEnum.MessageType.STRING.toString(), "granPeriodType", 1024,0, false, "granPeriodType" )))
							.addNode(new FieldNode("hesitationDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "hesitationDate", 1024,0, false, "犹豫期时间" )))
							.addNode(new FieldNode("investDay", new MsgField(ContentEnum.MessageType.STRING.toString(), "investDay", 1024,0, false, "investDay" )))
							.addNode(new FieldNode("isHaveAddRisk", new MsgField(ContentEnum.MessageType.STRING.toString(), "isHaveAddRisk", 1024,0, false, "是否有附加险" )))
							.addNode(new FieldNode("maxPremium", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxPremium", 1024,0, false, "maxPremium" )))
							.addNode(new FieldNode("minPremium", new MsgField(ContentEnum.MessageType.STRING.toString(), "minPremium", 1024,0, false, "minPremium" )))
							.addNode(new FieldNode("payFrequency", new MsgField(ContentEnum.MessageType.STRING.toString(), "payFrequency", 1024,0, false, "payFrequency" )))
							.addNode(new FieldNode("payPeriod", new MsgField(ContentEnum.MessageType.STRING.toString(), "payPeriod", 1024,0, false, "payPeriod" )))
							.addNode(new FieldNode("payPeriodType", new MsgField(ContentEnum.MessageType.STRING.toString(), "payPeriodType", 1024,0, false, "payPeriodType" )))
							.addNode(new FieldNode("prdAlias", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdAlias", 1024,0, false, "prdAlias" )))
							.addNode(new FieldNode("prdChildtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdChildtype", 1024,0, false, "prdChildtype" )))
							.addNode(new FieldNode("prdcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdcode", 1024,0, false, "产品代码" )))
							.addNode(new FieldNode("prdcodeOfCompany", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdcodeOfCompany", 1024,0, false, "保险公司产品代码" )))
							.addNode(new FieldNode("prdname", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdname", 1024,0, false, "产品名称" )))
							.addNode(new FieldNode("prdtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdtype", 1024,0, false, "产品类型" )))
							.addNode(new FieldNode("rate", new MsgField(ContentEnum.MessageType.STRING.toString(), "rate", 1024,0, false, "rate" )))
							.addNode(new FieldNode("topflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "topflag", 1024,0, false, "是否置顶" )))
							.addNode(new FieldNode("toplimit", new MsgField(ContentEnum.MessageType.STRING.toString(), "toplimit", 1024,0, false, "toplimit" )))
							.addNode(new FieldNode("unit", new MsgField(ContentEnum.MessageType.STRING.toString(), "unit", 1024,0, false, "unit" )))
							.addNode(new FieldNode("valueDay", new MsgField(ContentEnum.MessageType.STRING.toString(), "valueDay", 1024,0, false, "valueDay" )))
							.addNode(new FieldNode("introduction", new MsgField(ContentEnum.MessageType.STRING.toString(), "introduction", 1024,0, false, "产品介绍" )))
							.addNode(new FieldNode("cpzlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpzlx", 1024,0, false, "产品子类型" )))
							.addNode(new FieldNode("cpzlx2", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpzlx2", 1024,0, false, "产品子类型2" )))
							.addNode(new FieldNode("cpzlx3", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpzlx3", 1024,0, false, "产品子类型3" )))
							.addNode(new FieldNode("cpfxdj", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpfxdj", 1024,0, false, "风险等级" )))
							).addNode(new FieldNode("numberOfElements", new MsgField(ContentEnum.MessageType.INT.toString(), "numberOfElements", 1024,0, false, "当前页返回记录数" )))
					.addNode(new FieldNode("number", new MsgField(ContentEnum.MessageType.INT.toString(), "number", 1024,0, false, "当前页数" )))
					.addNode(new FieldNode("totalElements", new MsgField(ContentEnum.MessageType.INT.toString(), "totalElements", 1024,0, false, "返回总记录数" )))
					.addNode(new FieldNode("totalPages", new MsgField(ContentEnum.MessageType.INT.toString(), "totalPages", 1024,0, false, "总页数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

