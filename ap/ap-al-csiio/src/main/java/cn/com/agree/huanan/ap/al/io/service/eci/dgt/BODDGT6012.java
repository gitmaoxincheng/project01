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
 * BASESVC BODDGT6012  东莞通预充值圈存完成 
 *  BODDGT6012 8810002
 *  东莞通系统
 * @author XZF
 */
@Component
public class BODDGT6012 extends EciChannelService {

	private static BODDGT6012_I i = new BODDGT6012_I();
	private static BODDGT6012_O o = new BODDGT6012_O();
	public BODDGT6012() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODDGT6012_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Mes_MAC", new MsgField(ContentEnum.MessageType.STRING.toString(), "Mes_MAC", 8,0, false, "通讯押码" )))
					.addNode(new FieldNode("Mes_MessageDateTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "Mes_MessageDateTime", 14,0, true, "报文发送时间" )))
					.addNode(new FieldNode("Tra_Unitid", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Unitid", 8,0, false, "营运单位代码" )))
					.addNode(new FieldNode("Tra_TransType", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TransType", 2,0, false, "业务类型" )))
					.addNode(new FieldNode("Tra_LocalSequence", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_LocalSequence", 10,0, false, "发送方报文流水号" )))
					.addNode(new FieldNode("Tra_Posid", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Posid", 12,0, false, "清算设备代码" )))
					.addNode(new FieldNode("Tra_Termid", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Termid", 12,0, false, "企业设备代码" )))
					.addNode(new FieldNode("Tra_CardId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardId", 16,0, false, "卡号" )))
					.addNode(new FieldNode("Tra_CityCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CityCode", 4,0, false, "城市代码" )))
					.addNode(new FieldNode("Tra_Deposit", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Deposit", 8,0, false, "押金" )))
					.addNode(new FieldNode("Tra_CardModel", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardModel", 1,0, false, "卡型，1-CPU卡" )))
					.addNode(new FieldNode("Tra_CardCnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardCnt", 6,0, false, "卡计数器" )))
					.addNode(new FieldNode("Tra_BefBalance", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_BefBalance", 8,0, false, "交易前钱包剩余额" )))
					.addNode(new FieldNode("Tra_OrigAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_OrigAmt", 8,0, false, "应收金额" )))
					.addNode(new FieldNode("Tra_TxnAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TxnAmt", 8,0, false, "实充金额" )))
					.addNode(new FieldNode("Tra_HandingCharge", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_HandingCharge", 8,0, false, "手续费" )))
					.addNode(new FieldNode("Tra_CardValDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardValDate", 8,0, false, "卡有效期" )))
					.addNode(new FieldNode("Tra_CardVerNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardVerNo", 2,0, false, "卡内版本号" )))
					.addNode(new FieldNode("Tra_AuthSeq", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_AuthSeq", 18,0, false, "工作密钥授权流水" )))
					.addNode(new FieldNode("Tra_LimitedAuthSeql", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_LimitedAuthSeql", 10,0, false, "额度授权流水号 " )))
					.addNode(new FieldNode("LastPosSvSeq", new MsgField(ContentEnum.MessageType.STRING.toString(), "LastPosSvSeq", 9,0, false, "POS终端上笔充值流水号" )))
					.addNode(new FieldNode("Tra_TAC", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TAC", 8,0, false, "交易押码" )))
					.addNode(new FieldNode("Tra_QueryPreSeq", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_QueryPreSeq", 18,0, false, "查询预充值余额时的中心流水号" )))
					.addNode(new FieldNode("Tra_TradSpecFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TradSpecFlag", 1,0, false, "特有数据类型" )))
					.addNode(new FieldNode("Tra_TradSpec", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TradSpec", 200,0, false, "特有数据" )))
					.addNode(new FieldNode("Tra_TxnResponse", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TxnResponse", 5,0, false, "交易应答码 " )))
					.addNode(new FieldNode("Tra_OperId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_OperId", 16,0, false, "操作员号" )))
					.addNode(new FieldNode("Tra_TxnDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TxnDate", 8,0, false, "交易日期" )))
					.addNode(new FieldNode("Tra_TxnTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TxnTime", 6,0, false, "交易时间" )))
					.addNode(new FieldNode("Tra_ResponseCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_ResponseCode", 5,0, false, "交易应答码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODDGT6012_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("Tra_CenterSettedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CenterSettedate", 8,0, false, "中心结算日期" )))
					.addNode(new FieldNode("Tra_CenterSequence", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CenterSequence", 10,0, false, "中心流水号" )))
					.addNode(new FieldNode("Tra_Termid", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Termid", 12,0, false, "企业设备代码" )))
					.addNode(new FieldNode("Tra_CardId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardId", 16,0, false, "卡内号" )))
					.addNode(new FieldNode("Tra_CardMKnd", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardMKnd", 2,0, false, "卡主类型" )))
					.addNode(new FieldNode("Tra_CardSKind", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardSKind", 2,0, false, "卡子类型" )))
					.addNode(new FieldNode("Tra_SaleMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_SaleMode", 2,0, false, "发售方式" )))
					.addNode(new FieldNode("Tra_SettDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_SettDate", 8,0, false, "结算日期" )))
					.addNode(new FieldNode("Tra_LastTxnType", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_LastTxnType", 4,0, false, "上笔交易类型" )))
					.addNode(new FieldNode("Tra_LastPosId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_LastPosId", 12,0, false, "上笔交易终端号" )))
					.addNode(new FieldNode("Tra_LastTxnAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_LastTxnAmt", 8,0, false, "上笔交易金额" )))
					.addNode(new FieldNode("Tra_LastCrdCnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_LastCrdCnt", 6,0, false, "上笔交易卡计数器" )))
					.addNode(new FieldNode("Tra_LastTxnTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_LastTxnTime", 14,0, false, "上笔交易时间" )))
					.addNode(new FieldNode("Tra_Lastaftamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Lastaftamt", 8,0, false, "上笔交易交易前金" )))
					.addNode(new FieldNode("Tra_Lasttac", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Lasttac", 8,0, false, "上笔交易TAC" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

