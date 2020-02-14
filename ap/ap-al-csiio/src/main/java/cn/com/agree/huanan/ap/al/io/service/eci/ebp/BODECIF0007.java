package cn.com.agree.huanan.ap.al.io.service.eci.ebp;

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
@Component
public class BODECIF0007 extends EciChannelService{
	private static BODECIF0007_I i = new BODECIF0007_I();
	private static BODECIF0007_O o = new BODECIF0007_O();
	public BODECIF0007() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODECIF0007_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("txCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "txCode",32,0, false, "交易码" )))
					.addNode(new FieldNode("custId", new MsgField(ContentEnum.MessageType.STRING.toString(), "custId", 20,0, false, "客户号" )))
	
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODECIF0007_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf",	1024	,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("contrSize", new MsgField(ContentEnum.MessageType.STRING.toString(), "contrSize",	10	,0, false, "商机产品编号记录数" )))
					.addNode(new FieldNode("custId", new MsgField(ContentEnum.MessageType.STRING.toString(), "custId",	20	,0, false, "客户编号" )))
					.addNode(new FieldNode("mainOrg", new MsgField(ContentEnum.MessageType.STRING.toString(), "mainOrg",	20	,0, false, "主办机构" )))
					.addNode(new FieldNode("mainMgr", new MsgField(ContentEnum.MessageType.STRING.toString(), "mainMgr",	20	,0, false, "主办客户经理" )))
					.addNode(new FieldNode("prodTypeId", new MsgField(ContentEnum.MessageType.STRING.toString(), "prodTypeId",	30	,0, false, "产品类型编号" )))
					.addNode(new FieldNode("marketClue", new MsgField(ContentEnum.MessageType.STRING.toString(), "marketClue",	3000	,0, false, "营销线索" )))
					.addNode(new FieldNode("marketWords", new MsgField(ContentEnum.MessageType.STRING.toString(), "marketWords",	2000	,0, false, "营销话术" )))
					.addNode(new FieldNode("createDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "createDate",	8	,0, false, "生成时间" )))
					.addNode(new FieldNode("FaultString", new MsgField(ContentEnum.MessageType.STRING.toString(), "FaultString",	20	,0, false, "上次商机状态" )))
					.addNode(new FieldNode("lastFactDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "lastFactDate",	8	,0, false, "上次反馈时间" )))
					.addNode(new FieldNode("FaultCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "FaultCode",	6	,0, false, "返回码" )))
					.addNode(new FieldNode("lastMarketState", new MsgField(ContentEnum.MessageType.STRING.toString(), "lastMarketState",	20	,0, false, "错误描述" )))
					.addNode(new FieldNode("TxnStat", new MsgField(ContentEnum.MessageType.STRING.toString(), "TxnStat",	7	,0, false, "交易状态" )))

					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

