package cn.com.agree.huanan.ap.al.io.service.eci.ebp;

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
 * BASESVC BODEBP0002  境外汇款记录查询 
 *  BODEBP0002 
 *  国结系统
 * @author XZF
 */
@Component
public class BODEBP0002 extends EciChannelService {

	private static BODEBP0002_I i = new BODEBP0002_I();
	private static BODEBP0002_O o = new BODEBP0002_O();
	public BODEBP0002() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODEBP0002_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("launchMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "launchMode", 1,0, false, "交易渠道" )))
					.addNode(new FieldNode("finDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "finDate", 10,0, false, "受理时间开始时间" )))
					.addNode(new FieldNode("endDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "endDate", 10,0, false, "受理时间结束时间" )))
					.addNode(new FieldNode("acctNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctNo", 50,0, false, "客户账号" )))
					.addNode(new FieldNode("tradeState", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradeState", 2,0, false, "交易状态" )))
					.addNode(new FieldNode("cardType", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardType", 2,0, false, "证件类型" )))
					.addNode(new FieldNode("cardNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardNo", 32,0, false, "证件号码" )))
					.addNode(new FieldNode("pagevl", new MsgField(ContentEnum.MessageType.STRING.toString(), "pagevl", 30,0, false, "翻页字段" )))
					.addNode(new FieldNode("rcrdnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcrdnm", 3,0, false, "最大查询记录数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODEBP0002_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 1024,0, false, "返回记录数" )))
					.addNode(new FieldNode("pages", new MsgField(ContentEnum.MessageType.STRING.toString(), "pages", 1024,0, false, "分页后实际条数" )))
					.addNode(new ArrayNode("bodrcd",false,"remit_list")
						.addNode(new FieldNode("launchMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "launchMode", 1,0, false, "交易渠道" )))
						.addNode(new FieldNode("bizNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "bizNo", 50,0, false, "渠道业务编号" )))
						.addNode(new FieldNode("tradeState", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradeState", 2,0, false, "交易状态" )))
						.addNode(new FieldNode("tradeDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradeDate", 10,0, false, "受理时间" )))
						.addNode(new FieldNode("remitCorpEnName", new MsgField(ContentEnum.MessageType.STRING.toString(), "remitCorpEnName", 50,0, false, "汇款人英文名称" )))
						.addNode(new FieldNode("cardNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardNo", 50,0, false, "汇款人证件号码" )))
						.addNode(new FieldNode("remitCur", new MsgField(ContentEnum.MessageType.STRING.toString(), "remitCur", 3,0, false, "汇款币种" )))
						.addNode(new FieldNode("remitAmount", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "remitAmount", 18,2, false, "汇款金额" )))
						.addNode(new FieldNode("jzAcctNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "jzAcctNo", 18,0, false, "汇款人账号" )))
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
						.addNode(new FieldNode("txrem", new MsgField(ContentEnum.MessageType.STRING.toString(), "txrem", 80,0, false, "汇款附言" )))
						.addNode(new FieldNode("reCharge", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "reCharge", 18,2, false, "手续费" )))
						.addNode(new FieldNode("reChargeAcctNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "reChargeAcctNo", 18,0, false, "手续费扣款账户" )))
						.addNode(new FieldNode("isHaved", new MsgField(ContentEnum.MessageType.STRING.toString(), "isHaved", 3,0, false, "是否填写过购汇申请书" )))
						.addNode(new ArrayNode("Charges",false,"Charges_list")
								.addNode(new FieldNode("chargeAmt", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "chargeAmt", 18,2, false, "实际手续费" )))
								.addNode(new FieldNode("chargeAct", new MsgField(ContentEnum.MessageType.STRING.toString(), "chargeAct", 18,0, false, "实际手续费扣款账户" )))
					)));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

