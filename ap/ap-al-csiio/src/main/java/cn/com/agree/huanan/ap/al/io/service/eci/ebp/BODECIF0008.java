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
public class BODECIF0008 extends EciChannelService{
	private static BODECIF0008_I i = new BODECIF0008_I();
	private static BODECIF0008_O o = new BODECIF0008_O();
	public BODECIF0008() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODECIF0008_I extends MsgBody {
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

	public static class BODECIF0008_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf",	1024	,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("contrSize", new MsgField(ContentEnum.MessageType.STRING.toString(), "contrSize",	10	,0, false, "商机产品编号记录数" )))
					.addNode(new FieldNode("prodTypeId", new MsgField(ContentEnum.MessageType.STRING.toString(), "prodTypeId",	32	,0, false, "产品类型编号" )))
					.addNode(new FieldNode("assYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "assYearAvg",	30	,0, false, "资产年日均" )))
					.addNode(new FieldNode("isLoanCust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isLoanCust",	1	,0, false, "是否有本行贷款" )))
					.addNode(new FieldNode("hasFundsLoan", new MsgField(ContentEnum.MessageType.STRING.toString(), "hasFundsLoan	",	1	,0, false, "是否有公积金贷款" )))
					.addNode(new FieldNode("hasSfcg", new MsgField(ContentEnum.MessageType.STRING.toString(), "hasSfcg",	1	,0, false, "是否有三方存管" )))
					.addNode(new FieldNode("hasEccard", new MsgField(ContentEnum.MessageType.STRING.toString(), "hasEccard",	1	,0, false, "是否持有银联贷记卡" )))
					.addNode(new FieldNode("hasVisacard", new MsgField(ContentEnum.MessageType.STRING.toString(), "hasVisacard",	1	,0, false, "是否持有VISA贷记卡" )))
					.addNode(new FieldNode("isEbankCust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isEbankCust",	1	,0, false, "是否网银客户" )))
					.addNode(new FieldNode("isMobileCust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isMobileCust",	1	,0, false, "是否手机银行客户" )))
					.addNode(new FieldNode("isWbankCust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isWbankCust",	1	,0, false, "是否微信银行客户" )))
					.addNode(new FieldNode("isPfCust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isPfCust",	1	,0, false, "是否理财客户" )))
					.addNode(new FieldNode("isFdCust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isFdCust",	1,0, false, "是否基金客户" )))
					.addNode(new FieldNode("isGdCust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isGdCust",	1	,0, false, "是否黄金客户" )))
					.addNode(new FieldNode("isYxtCust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isYxtCust",	1	,0, false, "是否银信通客户" )))
					.addNode(new FieldNode("isCartStag", new MsgField(ContentEnum.MessageType.STRING.toString(), "isCartStag",	1	,0, false, "贷记卡分期" )))
					.addNode(new FieldNode("isBigDp	", new MsgField(ContentEnum.MessageType.STRING.toString(), "isBigDp",	1	,0, false, "大额存单" )))
					.addNode(new FieldNode("isIcCart", new MsgField(ContentEnum.MessageType.STRING.toString(), "isIcCart",	1	,0, false, "借记IC卡" )))
					.addNode(new FieldNode("isPhoneState", new MsgField(ContentEnum.MessageType.STRING.toString(), "isPhoneState",	1	,0, false, "手机状态" )))
					.addNode(new FieldNode("isMpVaild", new MsgField(ContentEnum.MessageType.STRING.toString(), "isMpVaild",	1	,0, false, "手机有效户	" )))
					.addNode(new FieldNode("hasHouseLoan", new MsgField(ContentEnum.MessageType.STRING.toString(), "hasHouseLoan",	1	,0, false, "是否有房贷" )))
					.addNode(new FieldNode("custId", new MsgField(ContentEnum.MessageType.STRING.toString(), "custId",	20	,0, false, "客户编号" )))
					.addNode(new FieldNode("custType", new MsgField(ContentEnum.MessageType.STRING.toString(), "custType",	20	,0, false, "客户类型" )))
					.addNode(new FieldNode("custName", new MsgField(ContentEnum.MessageType.STRING.toString(), "custName",	80	,0, false, "客户名称" )))
					.addNode(new FieldNode("custLevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "custLevel",	1	,0, false, "客户等级" )))
					.addNode(new FieldNode("FaultCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "FaultCode",	6	,0, false, "返回码" )))
					.addNode(new FieldNode("FaultString	", new MsgField(ContentEnum.MessageType.STRING.toString(), "FaultString",	20	,0, false, "错误描述" )))
					.addNode(new FieldNode("TxnStat	", new MsgField(ContentEnum.MessageType.STRING.toString(), "TxnStat",	7	,0, false, "交易状态" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}


