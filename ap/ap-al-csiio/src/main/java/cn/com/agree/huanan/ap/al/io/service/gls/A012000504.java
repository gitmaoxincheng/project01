package cn.com.agree.huanan.ap.al.io.service.gls;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbGlsChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.A012000504 清分管理.清分复核 
 * A0120005.04 ckmdcl
 * 0009 大总账
 * @author ZS
 */
@Component 
public class A012000504 extends EsbGlsChannelService {
	
	private static A012000504_I i = new A012000504_I();
	private static A012000504_O o = new A012000504_O();

	public A012000504() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class A012000504_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("mdcldt", new MsgField(ContentEnum.MessageType.STRING.toString(), "mdcldt", 8,0, true, "汇总日期" )))
					.addNode(new FieldNode("mdclsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "mdclsq", 30,0, true, "汇总流水" )))
					.addNode(new FieldNode("tranus", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranus", 10,0, true, "柜员号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class A012000504_O extends MsgBody {
		private MsgSegment msgSegment = init();

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
