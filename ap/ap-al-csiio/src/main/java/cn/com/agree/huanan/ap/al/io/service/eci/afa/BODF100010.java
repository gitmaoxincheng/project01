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
 * BASESVC BODF100010  风险等级修改交易 
 *  BODF100010 
 *  综合前置
 * @author XZF
 */
@Component
public class BODF100010 extends EciF10ChannelService {

	private static BODF100010_I i = new BODF100010_I();
	private static BODF100010_O o = new BODF100010_O();
	public BODF100010() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100010_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("BankAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankAcc", 40,0, false, "银行账号" )))
					.addNode(new FieldNode("Passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "Passwd", 10,0, false, "密码" )))
					.addNode(new FieldNode("RiskLevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskLevel", 1,0, true, "风险等级" )))
					.addNode(new FieldNode("RiskMonths", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskMonths", 10,0, false, "风险有效期月数" )))
					.addNode(new FieldNode("AccType", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccType", 1,0, true, "客户标识类型" )))
					.addNode(new FieldNode("Account", new MsgField(ContentEnum.MessageType.STRING.toString(), "Account", 32,0, true, "客户标识" )))
					.addNode(new FieldNode("IdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 6,0, true, "证件类型" )))
					.addNode(new FieldNode("ClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 1,0, false, "客户类型" )))
					.addNode(new FieldNode("ChannelAbleFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ChannelAbleFlag", 1,0, false, "高风险产品柜台以外渠道允许购买标志" )))
					.addNode(new FieldNode("PrdManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdManager", 100,0, false, "产品管理人" )))
					.addNode(new FieldNode("LastScore", new MsgField(ContentEnum.MessageType.STRING.toString(), "LastScore", 6,0, false, "风险评估总分" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100010_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("SerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "SerialNo", 30,0, true, "系统流水号" )))
					.addNode(new FieldNode("ClientNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientNo", 40,0, true, "客户编号" )))
					.addNode(new FieldNode("ClientName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientName", 80,0, true, "客户名称" )))
					.addNode(new FieldNode("RiskDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskDate", 8,0, false, "风险有效期截止日" )))
					.addNode(new FieldNode("LastScore", new MsgField(ContentEnum.MessageType.STRING.toString(), "LastScore", 6,0, false, "风险评估总分" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

