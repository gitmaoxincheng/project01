package cn.com.agree.huanan.ap.al.io.service.eci.icc;

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
 * 
 * @author zhuzc
 * BASESVC BODICC0002 IC卡信息查询
 * BODICC0002 ic1107
 * ATM
 */
@Component
public class BODICC0002 extends EciChannelService{
	private static BODICC0002_I i = new BODICC0002_I();
	private static BODICC0002_O o = new BODICC0002_O();
	public BODICC0002() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODICC0002_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("cardNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardNo", 19,0, false, "IC卡卡号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODICC0002_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("icStatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "icStatus", 1,0, false, "IC卡状态" )))
					.addNode(new FieldNode("icUsefulLife", new MsgField(ContentEnum.MessageType.STRING.toString(), "icUsefulLife", 8,0, false, "IC卡有效期" )))
					.addNode(new FieldNode("issuer", new MsgField(ContentEnum.MessageType.STRING.toString(), "issuer", 10,0, false, "开户机构" )))
					.addNode(new FieldNode("certificatesType", new MsgField(ContentEnum.MessageType.STRING.toString(), "certificatesType", 1,0, false, "持卡人证件类型" )))
					.addNode(new FieldNode("certificatesId", new MsgField(ContentEnum.MessageType.STRING.toString(), "certificatesId", 19,0, false, "证件号" )))
					.addNode(new FieldNode("ecashBalance", new MsgField(ContentEnum.MessageType.STRING.toString(), "ecashBalance", 19,0, false, "电子现金账户余额" )))
					.addNode(new FieldNode("supplyBalance", new MsgField(ContentEnum.MessageType.STRING.toString(), "supplyBalance", 16,0, false, "补登账户余额" )))
					.addNode(new FieldNode("settlementBalance", new MsgField(ContentEnum.MessageType.STRING.toString(), "settlementBalance", 16,0, false, "待清算账户余额" )))
					.addNode(new FieldNode("ecashLimit", new MsgField(ContentEnum.MessageType.STRING.toString(), "ecashLimit", 16,0, false, "电子现金额度上限" )))
					.addNode(new FieldNode("singleMaxAmount", new MsgField(ContentEnum.MessageType.STRING.toString(), "singleMaxAmount", 16,0, false, "单笔最高限额" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
