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
 * BASESVC BODF100375  客户风险等级查询 
 *  BODF100375 
 *  综合前置
 * @author XZF
 */
@Component
public class BODF100375 extends EciF10ChannelService {

	private static BODF100375_I i = new BODF100375_I();
	private static BODF100375_O o = new BODF100375_O();
	public BODF100375() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100375_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("AccType", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccType", 1,0, true, "客户标识类型" )))
					.addNode(new FieldNode("Account", new MsgField(ContentEnum.MessageType.STRING.toString(), "Account", 32,0, true, "客户标识" )))
					.addNode(new FieldNode("IdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 6,0, true, "证件类型" )))
					.addNode(new FieldNode("ClientGroup", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientGroup", 10,0, false, "客户分组" )))
					.addNode(new FieldNode("ClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 10,0, false, "客户类型" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 10,0, true, "定位串" )))
					.addNode(new FieldNode("QueryNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "QueryNum", 10,0, true, "查询行数" )))
					.addNode(new FieldNode("PrdManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdManager", 10,0, false, "PrdManager" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100375_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("ClientNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientNo", 10,0, false, "客户编号" )))
					.addNode(new FieldNode("ClientName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientName", 10,0, false, "客户名称" )))
					.addNode(new FieldNode("RiskDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskDate", 10,0, false, "风险有效期截止日" )))
					.addNode(new FieldNode("RiskLevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskLevel", 10,0, false, "风险等级" )))
					.addNode(new FieldNode("ChannelAbleFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ChannelAbleFlag", 10,0, false, "高风险产品柜台以外渠道允许购买签约标志" )))
					.addNode(new FieldNode("CounterRiskFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "CounterRiskFlag", 10,0, false, "是否在柜台渠道评估过标志" )))
					.addNode(new FieldNode("PrdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdType", 10,0, false, "业务类型" )))
					.addNode(new FieldNode("LastInvestDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "LastInvestDate", 10,0, false, "最近评估日期" )))
					.addNode(new FieldNode("RiskMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskMode", 10,0, false, "风险评估模式" )))
					.addNode(new FieldNode("LastScore", new MsgField(ContentEnum.MessageType.STRING.toString(), "LastScore", 10,0, false, "风险评估总分" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

