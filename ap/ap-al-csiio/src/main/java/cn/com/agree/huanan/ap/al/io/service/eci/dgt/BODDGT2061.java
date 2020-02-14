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
 * BASESVC BODDGT2061  东莞通卡操作请求 
 *  BODDGT2061 8810001
 *  东莞通系统
 * @author XZF
 */
@Component
public class BODDGT2061 extends EciChannelService {

	private static BODDGT2061_I i = new BODDGT2061_I();
	private static BODDGT2061_O o = new BODDGT2061_O();
	public BODDGT2061() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODDGT2061_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Mes_MAC", new MsgField(ContentEnum.MessageType.STRING.toString(), "Mes_MAC", 8,0, false, "通讯押码" )))
					.addNode(new FieldNode("Mes_MessageDateTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "Mes_MessageDateTime", 14,0, true, "报文发送时间" )))
					.addNode(new FieldNode("Tra_Unitid", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Unitid", 8,0, false, "营运单位代码" )))
					.addNode(new FieldNode("Tra_Posid", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Posid", 12,0, false, "清算设备代码" )))
					.addNode(new FieldNode("Tra_SamId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_SamId", 16,0, false, "Sam卡卡号" )))
					.addNode(new FieldNode("Tra_PosSequence", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_PosSequence", 9,0, false, "POS机流水号" )))
					.addNode(new FieldNode("Tra_Termid", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Termid", 12,0, false, "企业设备代码" )))
					.addNode(new FieldNode("Tra_EDCardId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_EDCardId", 16,0, false, "操作主卡卡号" )))
					.addNode(new FieldNode("Tra_CardOprType", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardOprType", 4,0, false, "卡操作交易类型" )))
					.addNode(new FieldNode("Tra_CityCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CityCode", 4,0, false, "城市代码" )))
					.addNode(new FieldNode("Tra_CardId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardId", 16,0, false, "卡内号" )))
					.addNode(new FieldNode("Tra_CardMKnd", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardMKnd", 2,0, false, "主卡类型" )))
					.addNode(new FieldNode("Tra_CardSKnd", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardSKnd", 2,0, false, "子卡类型" )))
					.addNode(new FieldNode("Tra_CardModel", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardModel", 1,0, false, "卡型，1-CPU卡" )))
					.addNode(new FieldNode("Tra_TransType", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TransType", 2,0, false, "业务类型" )))
					.addNode(new FieldNode("Tra_CardCSN", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardCSN", 16,0, false, "卡物理标示编号" )))
					.addNode(new FieldNode("Tra_CardMac", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardMac", 8,0, false, "卡校验码（MF1）" )))
					.addNode(new FieldNode("Tra_KeyCnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_KeyCnt", 2,0, false, "下发key的数量（M1）" )))
					.addNode(new FieldNode("Tra_SectorID", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_SectorID", 4,0, false, "密钥扇区指示表" )))
					.addNode(new FieldNode("Tra_KeySet", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_KeySet", 64,0, false, "密钥（KeyB）（M1）" )))
					.addNode(new FieldNode("Tra_TACKeySet", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TACKeySet", 32,0, false, "TAC密钥" )))
					.addNode(new FieldNode("Tra_Deposit", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Deposit", 8,0, false, "押金" )))
					.addNode(new FieldNode("Tra_OrigAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_OrigAmt", 8,0, false, "应收金额" )))
					.addNode(new FieldNode("Tra_ReloadBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_ReloadBal", 8,0, false, "交易金额" )))
					.addNode(new FieldNode("Tra_CardValDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardValDate", 8,0, false, "卡有效期" )))
					.addNode(new FieldNode("Tra_MAC2", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_MAC2", 8,0, false, "钱包加值需要的MAC2" )))
					.addNode(new FieldNode("Tra_SrcBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_SrcBal", 8,0, false, "卡片原额" )))
					.addNode(new FieldNode("Tra_CardSeq", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardSeq", 6,0, false, "卡片交易流水" )))
					.addNode(new FieldNode("Tra_KeyVer", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_KeyVer", 2,0, false, "卡片密钥版本" )))
					.addNode(new FieldNode("Tra_AigInd", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_AigInd", 2,0, false, "卡片算法标识" )))
					.addNode(new FieldNode("Tra_CardRand", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardRand", 8,0, false, "卡片随机数" )))
					.addNode(new FieldNode("Tra_MAC1", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_MAC1", 8,0, false, "充资返回信息MAC1" )))
					.addNode(new FieldNode("Tra_DivData", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_DivData", 18,0, false, "分散因子" )))
					.addNode(new FieldNode("Tra_OperId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_OperId", 16,0, false, "操作员号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODDGT2061_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("Tra_SamId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_SamId", 16,0, false, "Sam卡卡号" )))
					.addNode(new FieldNode("Tra_EDCardId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_EDCardId", 16,0, false, "操作主卡卡号" )))
					.addNode(new FieldNode("Tra_CardCSN", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardCSN", 16,0, false, "卡物理标示编号" )))
					.addNode(new FieldNode("Tra_CardMac", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardMac", 8,0, false, "卡校验码（MF1）" )))
					.addNode(new FieldNode("Tra_SysDatetime", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_SysDatetime", 24,0, false, "中心时间" )))
					.addNode(new FieldNode("Tra_KeyCnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_KeyCnt", 2,0, false, "下发key的数量（M1）" )))
					.addNode(new FieldNode("Tra_SectorID", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_SectorID", 4,0, false, "密钥扇区指示表" )))
					.addNode(new FieldNode("Tra_KeySet", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_KeySet", 64,0, false, "密钥（KeyB）（M1）" )))
					.addNode(new FieldNode("Tra_TACKeySet", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TACKeySet", 32,0, false, "TAC密钥" )))
					.addNode(new FieldNode("Tra_MAC2", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_MAC2", 8,0, false, "钱包加值需要的MAC2" )))
					.addNode(new FieldNode("Tra_CommandLen", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CommandLen", 3,0, false, "APDU指令长度（CPU）" )))
					.addNode(new FieldNode("Tra_Command", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Command", 256,0, false, "APDU指令（CPU）" )))
					.addNode(new FieldNode("Tra_DicMAC", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_DicMAC", 16,0, false, "指令MAC（CPU）" )))
					.addNode(new FieldNode("Tra_SettDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_SettDate", 8,0, false, "结算日期" )))
					.addNode(new FieldNode("Tra_AuthSeq", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_AuthSeq", 10,0, false, "密钥授权流水号" )))
					.addNode(new FieldNode("Tra_LimitedAuthSeql", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_LimitedAuthSeql", 10,0, false, "额度授权流水号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

