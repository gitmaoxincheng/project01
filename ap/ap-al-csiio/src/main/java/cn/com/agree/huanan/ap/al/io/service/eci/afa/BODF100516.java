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
 * BASESVC BODF100516  余额宝快速赎回(余额宝) 
 *  BODF100516 regflw
 *  综合前置
 * @author XZF
 */
@Component
public class BODF100516 extends EciF10ChannelService {
	
	private static BODF100516_I i = new BODF100516_I();
	private static BODF100516_O o = new BODF100516_O();
	public BODF100516() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100516_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("BankAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankAcc", 40,0, true, "银行账号" )))
					.addNode(new FieldNode("Passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "Passwd", 10,0, false, "交易密码" )))
					.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 10,0, true, "产品代码" )))
					.addNode(new FieldNode("Vol", new MsgField(ContentEnum.MessageType.STRING.toString(), "Vol", 10,0, true, "赎回份额" )))
					.addNode(new FieldNode("LargRedFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "LargRedFlag", 10,0, true, "巨额赎回处理标志" )))
					.addNode(new FieldNode("CfmNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "CfmNo", 10,0, false, "原确认流水号" )))
					.addNode(new FieldNode("ClientManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientManager", 30,0, false, "客户经理代码代码" )))
					.addNode(new FieldNode("PrdKind", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdKind", 10,0, false, "产品业务模式" )))
					.addNode(new FieldNode("SellerCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "SellerCode", 10,0, false, "合作商号" )))
					.addNode(new FieldNode("AccType", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccType", 1,0, true, "客户标识类型" )))
					.addNode(new FieldNode("Account", new MsgField(ContentEnum.MessageType.STRING.toString(), "Account", 32,0, true, "客户标识" )))
					.addNode(new FieldNode("IdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 6,0, true, "证件类型" )))
					.addNode(new FieldNode("CashFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "CashFlag", 10,0, false, "钞汇标志" )))
					.addNode(new FieldNode("ClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 10,0, false, "客户类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100516_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("SerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "SerialNo", 50,0, true, "流水号" )))
					.addNode(new FieldNode("ClientNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientNo", 10,0, true, "客户编号" )))
					.addNode(new FieldNode("ClientName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientName", 10,0, true, "客户名称" )))
					.addNode(new FieldNode("TAName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TAName", 50,0, true, "TA名称" )))
					.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 10,0, true, "产品代码" )))
					.addNode(new FieldNode("PrdName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdName", 10,0, true, "产品名称" )))
					.addNode(new FieldNode("CurrType", new MsgField(ContentEnum.MessageType.STRING.toString(), "CurrType", 10,0, true, "币种" )))
					.addNode(new FieldNode("CashFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "CashFlag", 10,0, true, "钞汇标志" )))
					.addNode(new FieldNode("Agio", new MsgField(ContentEnum.MessageType.STRING.toString(), "Agio", 10,0, false, "折扣率" )))
					.addNode(new FieldNode("LargRedFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "LargRedFlag", 10,0, true, "巨额赎回处理标志" )))
					.addNode(new FieldNode("ClientManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientManager", 30,0, false, "客户经理代码代码" )))
					.addNode(new FieldNode("ManagerName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ManagerName", 100,0, false, "客户经理代码名称" )))
					.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 10,0, true, "交易状态" )))
					.addNode(new FieldNode("StatusName", new MsgField(ContentEnum.MessageType.STRING.toString(), "StatusName", 10,0, true, "交易状态名称" )))
					.addNode(new FieldNode("DivMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivMode", 10,0, true, "分红方式" )))
					.addNode(new FieldNode("DivModeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivModeName", 10,0, true, "分红方式名称" )))
					.addNode(new FieldNode("UseVol", new MsgField(ContentEnum.MessageType.STRING.toString(), "UseVol", 10,0, true, "交易后可用份额" )))
					.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 10,0, true, "TA代码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

