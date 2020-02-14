package cn.com.agree.huanan.ap.al.io.service.sbc;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbSbcChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.C022000702 验证码管理.USBKEY领用 
 * C0220007.02 CM0102
 * 0212 金融互联网服务平台
 * @author XZF
 */
@Component
public class C022000702 extends EsbSbcChannelService {

	private static C022000702_I i = new C022000702_I();
	private static C022000702_O o = new C022000702_O();
	public C022000702() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C022000702_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("branchId", new MsgField(ContentEnum.MessageType.STRING.toString(), "branchId", 20,0, true, "经办网点" )))
					.addNode(new FieldNode("TellerNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "TellerNo", 15,0, true, "柜员号" )))
					.addNode(new FieldNode("IdtfNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdtfNo", 20,0, true, "证件号码" )))
					.addNode(new FieldNode("IdtfTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdtfTp", 20,0, true, "证件类型" )))
					.addNode(new FieldNode("dcmtnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcmtnm", 10,0, true, "使用凭证数量" )))
					.addNode(new FieldNode("initno", new MsgField(ContentEnum.MessageType.STRING.toString(), "initno", 15,0, true, "凭证开始号码" )))
					.addNode(new FieldNode("finlno", new MsgField(ContentEnum.MessageType.STRING.toString(), "finlno", 15,0, true, "凭证结束号码" )))
					.addNode(new FieldNode("mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mbrno", 10,0, true, "操作支行" )))
					.addNode(new FieldNode("zoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "zoneno", 10,0, true, "操作分行" )))
					.addNode(new FieldNode("authTellerNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "authTellerNo", 15,0, true, "授权柜员编号" )))
					.addNode(new FieldNode("csbxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "csbxno", 20,0, true, "柜员钱箱号" )))
					.addNode(new FieldNode("chrgfg", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrgfg", 1,0, true, "是否收费" )))
					.addNode(new FieldNode("chrgam", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrgam", 19,2, true, "收费金额" )))
					.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 50,0, true, "领用人姓名" )))
					.addNode(new FieldNode("authTellerName", new MsgField(ContentEnum.MessageType.STRING.toString(), "authTellerName", 50,0, true, "授权柜员姓名" )))
					.addNode(new FieldNode("tellerName", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerName", 50,0, true, "经办柜员姓名" )))
					.addNode(new FieldNode("AcctNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "AcctNo", 20,0, true, "账号" )))
					.addNode(new FieldNode("ukeyType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ukeyType", 10,0, true, "ukey类型" )))
					.addNode(new FieldNode("channelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelserno", 20,0, true, "渠道流水号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C022000702_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("channelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelserno", 20,0, true, "渠道流水号" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 10,0, true, "USBKEY状态" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

