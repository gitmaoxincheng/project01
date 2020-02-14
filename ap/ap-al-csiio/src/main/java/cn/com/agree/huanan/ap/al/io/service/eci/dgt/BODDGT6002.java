package cn.com.agree.huanan.ap.al.io.service.eci.dgt;

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
 * BASESVC BODDGT6002  东莞通预充值圈存查询 
 *  BODDGT6002 8810001
 *  东莞通系统
 * @author XZF
 */
@Component
public class BODDGT6002 extends EciChannelService {

	private static BODDGT6002_I i = new BODDGT6002_I();
	private static BODDGT6002_O o = new BODDGT6002_O();
	public BODDGT6002() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODDGT6002_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Mes_MAC", new MsgField(ContentEnum.MessageType.STRING.toString(), "Mes_MAC", 8,0, false, "通讯押码" )))
					.addNode(new FieldNode("Mes_MessageDateTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "Mes_MessageDateTime", 14,0, true, "报文发送时间" )))
					.addNode(new FieldNode("Tra_Unitid", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Unitid", 8,0, false, "营运单位代码" )))
					.addNode(new FieldNode("Tra_TransType", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TransType", 2,0, true, "业务类型" )))
					.addNode(new FieldNode("Tra_LocalSequence", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_LocalSequence", 10,0, false, "发送方报文流水号" )))
					.addNode(new FieldNode("Tra_Posid", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Posid", 12,0, false, "清算设备代码" )))
					.addNode(new FieldNode("Tra_CardId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardId", 16,0, false, "卡内号" )))
					.addNode(new FieldNode("Tra_Termid", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Termid", 12,0, false, "企业设备代码" )))
					.addNode(new FieldNode("Tra_CityCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CityCode", 4,0, false, "城市代码" )))
					.addNode(new FieldNode("Tra_Deposit", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Deposit", 8,0, false, "押金" )))
					.addNode(new FieldNode("Tra_CardModel", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardModel", 1,0, false, "卡型，1-CPU卡" )))
					.addNode(new FieldNode("Tra_OrigAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_OrigAmt", 8,0, false, "应收金额" )))
					.addNode(new FieldNode("Tra_TxnAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TxnAmt", 8,0, false, "实充金额" )))
					.addNode(new FieldNode("Tra_SrcAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_SrcAmt", 8,0, false, "卡上原额" )))
					.addNode(new FieldNode("Tra_TxnFee", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TxnFee", 8,0, false, "交易手续费" )))
					.addNode(new FieldNode("Tra_CodeType", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CodeType", 2,0, false, "证件类型" )))
					.addNode(new FieldNode("Tra_CodeId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CodeId", 20,0, false, "证件号" )))
					.addNode(new FieldNode("Tra_Name", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Name", 20,0, false, "姓名" )))
					.addNode(new FieldNode("Tra_TradSpecFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TradSpecFlag", 1,0, false, "特有数据类型" )))
					.addNode(new FieldNode("Tra_TradSpec", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TradSpec", 200,0, false, "特有数据" )))
					.addNode(new FieldNode("Tra_OperId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_OperId", 16,0, false, "操作员号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODDGT6002_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("Tra_CenterSettedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CenterSettedate", 8,0, false, "中心结算日期" )))
					.addNode(new FieldNode("Tra_CenterSequence", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CenterSequence", 10,0, false, "中心流水号" )))
					.addNode(new FieldNode("Tra_CardFaceId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardFaceId", 16,0, false, "卡面号" )))
					.addNode(new FieldNode("Tra_CardId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardId", 16,0, false, "卡内号" )))
					.addNode(new FieldNode("Tra_CardMKnd", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardMKnd", 2,0, false, "卡主类型" )))
					.addNode(new FieldNode("Tra_CardSKind", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardSKind", 2,0, false, "卡子类型" )))
					.addNode(new FieldNode("Tra_SaleMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_SaleMode", 2,0, false, "发售方式" )))
					.addNode(new FieldNode("Tra_MaxLimit", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_MaxLimit", 8,0, false, "卡片余额上限 " )))
					.addNode(new FieldNode("Tra_AccBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_AccBal", 8,0, false, "预充值帐户余额 " )))
					.addNode(new FieldNode("Tra_TipFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TipFlag", 2,0, false, "提示标识 " )))
					.addNode(new FieldNode("Tra_OrigAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_OrigAmt", 8,0, false, "应收金额" )))
					.addNode(new FieldNode("Tra_TxnAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TxnAmt", 8,0, false, "实充金额" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

