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
 * BASESVC BODF100008  风险匹配校验交易 
 *  BODF100008 
 *  综合前置
 * @author XZF
 */
@Component
public class BODF100008 extends EciF10ChannelService {

	private static BODF100008_I i = new BODF100008_I();
	private static BODF100008_O o = new BODF100008_O();
	public BODF100008() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100008_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("BankAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankAcc", 40,0, false, "银行账号" )))
					.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 20,0, true, "产品代码" )))
					.addNode(new FieldNode("AccType", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccType", 1,0, true, "客户标识类型" )))
					.addNode(new FieldNode("Account", new MsgField(ContentEnum.MessageType.STRING.toString(), "Account", 32,0, true, "客户标识" )))
					.addNode(new FieldNode("IdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 6,0, false, "证件类型" )))
					.addNode(new FieldNode("Passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "Passwd", 10,0, false, "交易密码" )))
					.addNode(new FieldNode("ClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 1,0, false, "客户类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100008_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "Flag", 1,0, false, "（产品不需要适合度匹配，表示通过）" )))
					.addNode(new FieldNode("RiskFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskFlag", 1,0, false, "风险不匹配" )))
					.addNode(new FieldNode("RiskEndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskEndDate", 8,0, false, "风险截至日期" )))
					.addNode(new FieldNode("FitFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "FitFlag", 1,0, true, "产品适合度匹配标志" )))
					.addNode(new FieldNode("FitEndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "FitEndDate", 8,0, false, "适合度有效期截至日期" )))
					.addNode(new FieldNode("ProductRisk", new MsgField(ContentEnum.MessageType.STRING.toString(), "ProductRisk", 10,0, false, "产品风险等级" )))
					.addNode(new FieldNode("ClientRisk", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientRisk", 10,0, false, "客户风险等级" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

