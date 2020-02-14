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
 * BASESVC.A015000101 清分冲正.清分冲正 
 * A0150001.01 skmdcl
 * 0009 大总账
 * @author ZS
 */
@Component 
public class A015000101 extends EsbGlsChannelService {

	private static A015000101_I i = new A015000101_I();
	private static A015000101_O o = new A015000101_O();

	public A015000101() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class A015000101_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("mdcldt", new MsgField(ContentEnum.MessageType.STRING.toString(), "mdcldt", 8,0, true, "汇总日期" )))
					.addNode(new FieldNode("smrytx", new MsgField(ContentEnum.MessageType.STRING.toString(), "smrytx", 256,0, true, "备注" )))
					.addNode(new FieldNode("mdclsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "mdclsq", 30,0, true, "汇总流水" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class A015000101_O extends MsgBody {
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
