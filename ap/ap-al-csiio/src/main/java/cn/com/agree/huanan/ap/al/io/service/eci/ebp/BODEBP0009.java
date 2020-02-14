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
 * BASESVC BODEBP0009  查询客户是否在国结系统存在
 * BODEBP0009 quCerp regflw
 *  国结系统
 * @author ouyang
 */
@Component
public class BODEBP0009 extends EciChannelService {

	private static BODEBP0009_I i = new BODEBP0009_I();
	private static BODEBP0009_O o = new BODEBP0009_O();

	public BODEBP0009() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODEBP0009_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
            .addNode(new FieldNode("corpNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpNo", 20,0, false, "核心客户号" ))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODEBP0009_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
            .addNode(new FieldNode("code", new MsgField(ContentEnum.MessageType.STRING.toString(), "code", 10,0, false, "错误标识码" ))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
