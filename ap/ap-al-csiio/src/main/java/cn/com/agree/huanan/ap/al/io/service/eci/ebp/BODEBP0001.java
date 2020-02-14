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

/**
 * BASESVC BODEBP0001  发起境外汇出汇款 
 *  BODEBP0001 
 *  国结系统
 * @author XZF
 */
@Component
public class BODEBP0001 extends EciChannelService {

	private static BODEBP0001_I i = new BODEBP0001_I();
	private static BODEBP0001_O o = new BODEBP0001_O();
	public BODEBP0001() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODEBP0001_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("tNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "tNo", 50,0, false, "源系统交易流水" )))
					.addNode(new FieldNode("bizNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "bizNo", 50,0, false, "渠道业务编号" )))
					.addNode(new FieldNode("launchMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "launchMode", 1,0, false, "交易渠道" )))
					.addNode(new FieldNode("orgNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgNo", 4,0, false, "核心机构代码" )))
					.addNode(new FieldNode("phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone", 15,0, false, "客户手机号" )))
					.addNode(new FieldNode("remitCorpEnName", new MsgField(ContentEnum.MessageType.STRING.toString(), "remitCorpEnName", 50,0, false, "汇款人英文名称" )))
					.addNode(new FieldNode("cardNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardNo", 50,0, false, "汇款人证件号码" )))
					.addNode(new FieldNode("remitCur", new MsgField(ContentEnum.MessageType.STRING.toString(), "remitCur", 3,0, false, "汇款币种" )))
					.addNode(new FieldNode("remitAmount", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "remitAmount", 18,2, false, "汇款金额" )))
					.addNode(new FieldNode("jzAcctNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "jzAcctNo", 34,0, false, "汇款人账号" )))
					.addNode(new FieldNode("remitAddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "remitAddr", 100,0, false, "汇款人地址" )))
					.addNode(new FieldNode("reName", new MsgField(ContentEnum.MessageType.STRING.toString(), "reName", 50,0, false, "收款人名称" )))
					.addNode(new FieldNode("reCountry", new MsgField(ContentEnum.MessageType.STRING.toString(), "reCountry", 3,0, false, "收款人国家" )))
					.addNode(new FieldNode("reNumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "reNumber", 50,0, false, "收款人账号" )))
					.addNode(new FieldNode("reAddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "reAddr", 100,0, false, "收款人地址" )))
					.addNode(new FieldNode("recvbkAcctSwiftCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "recvbkAcctSwiftCode", 11,0, false, "收款行SWIFTCODE" )))
					.addNode(new FieldNode("recvbkAcctName", new MsgField(ContentEnum.MessageType.STRING.toString(), "recvbkAcctName", 100,0, false, "收款行全称" )))
					.addNode(new FieldNode("payExpense", new MsgField(ContentEnum.MessageType.STRING.toString(), "payExpense", 3,0, false, "国内外费用承担方式" )))
					.addNode(new FieldNode("paytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "paytype", 100,0, false, "款项性质" )))
					.addNode(new FieldNode("txcodeXXX", new MsgField(ContentEnum.MessageType.STRING.toString(), "txcodeXXX", 10,0, false, "交易编码" )))
					.addNode(new FieldNode("txrem", new MsgField(ContentEnum.MessageType.STRING.toString(), "txrem", 200,0, false, "汇款附言" )))
					.addNode(new FieldNode("reCharge", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "reCharge", 18,2, false, "手续费" )))
					.addNode(new FieldNode("reChargeAcctNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "reChargeAcctNo", 18,0, false, "手续费扣款账户" )))
					.addNode(new FieldNode("smId", new MsgField(ContentEnum.MessageType.STRING.toString(), "smId", 18,0, false, "单据影像ID" )))
					.addNode(new FieldNode("corpNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpNo", 20,0, false, "核心客户号" )))
					.addNode(new FieldNode("cardAcct", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardAcct", 34,0, false, "借记卡卡号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODEBP0001_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("code", new MsgField(ContentEnum.MessageType.STRING.toString(), "code", 2,0, false, "错误标识码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

