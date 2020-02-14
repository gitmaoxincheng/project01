package cn.com.agree.huanan.ap.al.io.service.ump;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbUmpChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.G013000303 短信验证码校验.验证码校验 
 * G0130003.03 check_vercode
 * 0332 统一消息管理平台
 * @author maow
 */
@Component
public class G013000303 extends EsbUmpChannelService {

	private static G013000303_I i = new G013000303_I();
	private static G013000303_O o = new G013000303_O();
	public G013000303() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class G013000303_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("userno", new MsgField(ContentEnum.MessageType.INT.toString(), "userno", 256,0, true, "关键字符串的md5" )))
					.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl", 100,0, true, "用户标识" )))
					.addNode(new FieldNode("ylcomd", new MsgField(ContentEnum.MessageType.STRING.toString(), "ylcomd", 6,0, true, "MAC验证码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class G013000303_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

