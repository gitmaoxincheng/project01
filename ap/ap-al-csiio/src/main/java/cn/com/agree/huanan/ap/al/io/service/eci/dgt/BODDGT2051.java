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
 * BASESVC BODDGT2051  东莞通签到 
 *  BODDGT2051 8810001
 *  东莞通系统
 * @author XZF
 */
@Component
public class BODDGT2051 extends EciChannelService {

	private static BODDGT2051_I i = new BODDGT2051_I();
	private static BODDGT2051_O o = new BODDGT2051_O();
	public BODDGT2051() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODDGT2051_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Mes_MAC", new MsgField(ContentEnum.MessageType.STRING.toString(), "Mes_MAC", 8,0, false, "通讯押码" )))
					.addNode(new FieldNode("Mes_MessageDateTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "Mes_MessageDateTime", 14,0, true, "报文发送时间" )))
					.addNode(new FieldNode("Tra_Unitid", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Unitid", 8,0, false, "营运单位代码" )))
					.addNode(new FieldNode("Tra_TxnMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TxnMode", 2,0, false, "交易方式" )))
					.addNode(new FieldNode("Tra_Posid", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Posid", 12,0, false, "清算设备代码" )))
					.addNode(new FieldNode("Tra_Termid", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Termid", 12,0, false, "企业设备代码" )))
					.addNode(new FieldNode("Tra_OperId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_OperId", 16,0, false, "操作员号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODDGT2051_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("Tra_SAMID", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_SAMID", 16,0, false, "SAM卡号" )))
					.addNode(new FieldNode("Tra_SAMAuthInfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_SAMAuthInfo", 16,0, false, "SAM卡授权信息" )))
					.addNode(new FieldNode("Tra_EDAuthInfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_EDAuthInfo", 16,0, false, "ED卡授权信息" )))
					.addNode(new FieldNode("Tra_EDCardId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_EDCardId", 16,0, false, "操作主卡卡号" )))
					.addNode(new FieldNode("Tra_SettDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_SettDate", 6,0, false, "结算日期" )))
					.addNode(new FieldNode("Tra_BatchNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_BatchNo", 6,0, false, "批次号" )))
					.addNode(new FieldNode("Tra_SysDatetime", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_SysDatetime", 24,0, false, "中心时间" )))
					.addNode(new FieldNode("Tra_Authcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Authcode", 24,0, false, "授权认证码（M1）" )))
					.addNode(new FieldNode("Tra_ParamBit", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_ParamBit", 32,0, false, "参数更新标志位" )))
					.addNode(new FieldNode("Tra_KeySet", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_KeySet", 32,0, false, "密钥" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

