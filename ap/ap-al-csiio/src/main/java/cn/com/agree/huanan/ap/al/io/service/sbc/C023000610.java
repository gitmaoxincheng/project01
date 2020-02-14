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
 * BASESVC.C023000610 企业网银信息查询.查询是否已开通企业网银 
 * C0230006.10 CM0104
 * 0212 金融互联网服务平台
 * @author XZF
 */
@Component
public class C023000610 extends EsbSbcChannelService {

	private static C023000610_I i = new C023000610_I();
	private static C023000610_O o = new C023000610_O();
	public C023000610() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C023000610_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("IdtfNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdtfNo", 2,0, false, "证件号码" )))
					.addNode(new FieldNode("IdtfTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdtfTp", 2,0, false, "证件类型" )))
					.addNode(new FieldNode("versionType", new MsgField(ContentEnum.MessageType.STRING.toString(), "versionType", 15,0, false, "开户版本类型" )))
					.addNode(new FieldNode("AcctNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "AcctNo", 2,0, false, "账号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C023000610_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "flag", 1,0, true, "是否开通企业网银" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

