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
 * BASESVC BODEBP0010  客户信息维护
 * BODEBP0010 addCorp regflw
 *  国结系统
 * @author ouyang
 */
@Component
public class BODEBP0010 extends EciChannelService {

	private static BODEBP0010_I i = new BODEBP0010_I();
	private static BODEBP0010_O o = new BODEBP0010_O();

	public BODEBP0010() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODEBP0010_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
            .addNode(new FieldNode("corpNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpNo", 20,0, false, "核心客户号" )))
            .addNode(new FieldNode("corpTy", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpTy", 2,0, false, "客户类型" )))
            .addNode(new FieldNode("telephone", new MsgField(ContentEnum.MessageType.STRING.toString(), "telephone", 20,0, false, "公司电话" )))
            .addNode(new FieldNode("postcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcode", 6,0, false, "邮政编码" ))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODEBP0010_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
            .addNode(new FieldNode("code", new MsgField(ContentEnum.MessageType.STRING.toString(), "code", 10,0, false, "错误标识码" )))
);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
