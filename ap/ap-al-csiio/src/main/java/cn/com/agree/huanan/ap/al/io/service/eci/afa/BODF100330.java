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
 * BASESVC BODF100330  理财产品信息及额度查询 
 *  BODF100330 
 *  综合前置
 * @author XZF
 */
@Component
public class BODF100330 extends EciF10ChannelService {

	private static BODF100330_I i = new BODF100330_I();
	private static BODF100330_O o = new BODF100330_O();
	public BODF100330() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100330_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 20,0, false, "TA代码" )))
					.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 20,0, false, "产品代码" )))
					.addNode(new FieldNode("StartDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "StartDate", 8,0, false, "开始日期" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 40,0, true, "定位串" )))
					.addNode(new FieldNode("QueryNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "QueryNum", 10,0, true, "查询行数" )))
					.addNode(new FieldNode("EndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "EndDate", 8,0, false, "结束日期" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100330_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("TotNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNum", 3,0, true, "总行数" )))
					.addNode(new FieldNode("RetNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "RetNum", 3,0, true, "本次返回行数" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 40,0, true, "定位串" )))
					.addNode(new StructNode("bodrcd",true,"market_list")
							.addNode(new FieldNode("IssDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "IssDate", 8,0, true, "发布日期" )))
							.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 20,0, true, "产品代码" )))
							.addNode(new FieldNode("PrdName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdName", 40,0, true, "产品名称" )))
							.addNode(new FieldNode("CurrType", new MsgField(ContentEnum.MessageType.STRING.toString(), "CurrType", 3,0, true, "币种" )))
							.addNode(new FieldNode("NAV", new MsgField(ContentEnum.MessageType.STRING.toString(), "NAV", 30,0, true, "产品净值" )))
							.addNode(new FieldNode("Income", new MsgField(ContentEnum.MessageType.STRING.toString(), "Income", 30,0, false, "产品收益" )))
							.addNode(new FieldNode("IncomeUnit", new MsgField(ContentEnum.MessageType.STRING.toString(), "IncomeUnit", 80,0, false, "万份产品单位收益" )))
							.addNode(new FieldNode("IncomeRate", new MsgField(ContentEnum.MessageType.STRING.toString(), "IncomeRate", 20,0, false, "产品收益率" )))
							.addNode(new FieldNode("TotNav", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNav", 10,0, false, "产品累计净值" )))
							.addNode(new FieldNode("Yield", new MsgField(ContentEnum.MessageType.STRING.toString(), "Yield", 10,0, false, "七日年化收益率" )))
							.addNode(new FieldNode("YeldFag", new MsgField(ContentEnum.MessageType.STRING.toString(), "YeldFag", 10,0, false, "七日年化收益率正负" )))
							.addNode(new FieldNode("MonthincomeRate", new MsgField(ContentEnum.MessageType.STRING.toString(), "MonthincomeRate", 10,0, false, "月年化收益率" )))
							.addNode(new FieldNode("MonthincomeFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "MonthincomeFlag", 10,0, false, "月年化收益率正负" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

