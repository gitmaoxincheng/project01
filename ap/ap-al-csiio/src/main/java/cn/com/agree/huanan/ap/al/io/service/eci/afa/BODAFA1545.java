package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;

/**
 * BASESVC BODAFA1545  成品卡数据明细查询 
 *  BODAFA1545 
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1545 extends EciChannelService {

	private static BODAFA1545_I i = new BODAFA1545_I();
	private static BODAFA1545_O o = new BODAFA1545_O();
	public BODAFA1545() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1545_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("pageflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageflag", 1024,0, false, "翻页标志" )))
					.addNode(new FieldNode("maxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxnum", 1024,0, false, "最大记录数" )))
					.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedate", 1024,0, false, "交易日期" )))
					.addNode(new FieldNode("getdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "getdate", 1024,0, false, "领用日期" )))
					.addNode(new FieldNode("bgcardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "bgcardno", 1024,0, false, "卡号" )))
					.addNode(new FieldNode("endcardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "endcardno", 1024,0, false, "卡号" )))
					.addNode(new FieldNode("sendbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "sendbrno", 1024,0, false, "发送网点" )))
					.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 1024,0, false, "证件号码" )))
					.addNode(new FieldNode("cardname", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardname", 1024,0, false, "姓名" )))
					.addNode(new FieldNode("idxsendbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxsendbrno", 1024,0, false, "后续递送网点" )))
					.addNode(new FieldNode("idxcardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxcardno", 1024,0, false, "卡号" )))
					.addNode(new FieldNode("idxtradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxtradedate", 1024,0, false, "数据日期" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1024,0, false, "状态" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1545_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq", 1024,0, false, "错误码" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 1024,0, false, "错误信息" )))
					.addNode(new FieldNode("totalnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalnum", 1024,0, false, "总数" )))
					.addNode(new FieldNode("returnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "returnum", 1024,0, false, "返回数" )))
					.addNode(new ArrayNode("bodrcd",true,"card_list")
							.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 1024,0, false, "卡号" )))
							.addNode(new FieldNode("cardname", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardname", 1024,0, false, "姓名" )))
							.addNode(new FieldNode("sendbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "sendbrno", 1024,0, false, "递送网点号" )))
							.addNode(new FieldNode("sendway", new MsgField(ContentEnum.MessageType.STRING.toString(), "sendway", 1024,0, false, "下发渠道" )))
							.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1024,0, false, "卡状态" )))
							.addNode(new FieldNode("updatetime", new MsgField(ContentEnum.MessageType.STRING.toString(), "updatetime", 1024,0, false, "最后更新日期" )))
							.addNode(new FieldNode("updatetellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "updatetellerno", 1024,0, false, "最后操作柜员" )))
							.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedate", 1024,0, false, "入库日期" )))
							.addNode(new FieldNode("markbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "markbrno", 1024,0, false, "营销网点" )))
							.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 1024,0, false, "证件类型" )))
							.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 1024,0, false, "证件号码" )))
							.addNode(new FieldNode("reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "reason", 1024,0, false, "发卡原因" )))
							.addNode(new FieldNode("ishurry", new MsgField(ContentEnum.MessageType.STRING.toString(), "ishurry", 1024,0, false, "紧急标识" )))
							.addNode(new FieldNode("produtno", new MsgField(ContentEnum.MessageType.STRING.toString(), "produtno", 1024,0, false, "产品编号" )))
							.addNode(new FieldNode("phonenum", new MsgField(ContentEnum.MessageType.STRING.toString(), "phonenum", 1024,0, false, "手机号码" )))
							.addNode(new FieldNode("cardflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardflag", 1024,0, false, "主卡标志" )))
							.addNode(new FieldNode("maincard", new MsgField(ContentEnum.MessageType.STRING.toString(), "maincard", 1024,0, false, "主卡" )))
							.addNode(new FieldNode("maincardname", new MsgField(ContentEnum.MessageType.STRING.toString(), "maincardname", 1024,0, false, "主卡姓名" )))
							.addNode(new FieldNode("produtname", new MsgField(ContentEnum.MessageType.STRING.toString(), "produtname", 1024,0, false, "卡产品名称" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

