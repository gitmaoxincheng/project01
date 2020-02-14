package cn.com.agree.huanan.ap.al.io.service.sbc;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbSbcChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P063000501 商户信息查询.易缴通商户查询 
 * P0630005.01 OR3201
 * 0212 金融互联网服务平台
 * @author LW
 */
@Component
public class P063000501 extends EsbSbcChannelService {
	/*


	 */
	private static P063000501_I i = new P063000501_I();
	private static P063000501_O o = new P063000501_O();
	public P063000501() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P063000501_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("pageno", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageno", 5,0, true, "当前页" )))
					.addNode(new FieldNode("pagesize", new MsgField(ContentEnum.MessageType.STRING.toString(), "pagesize", 5,0, true, "每页记录数" )))
					.addNode(new FieldNode("mertype", new MsgField(ContentEnum.MessageType.STRING.toString(), "mertype", 4,0, false, "商户类型" )))
					.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 255,0, false, "商户名称" )))
					.addNode(new FieldNode("mercode", new MsgField(ContentEnum.MessageType.STRING.toString(), "mercode", 255,0, false, "商户编号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P063000501_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("totalsize", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalsize", 10,0, false, "总条数" )))
					.addNode(new ArrayNode("merlist_list",false)
							.addNode(new FieldNode("id", new MsgField(ContentEnum.MessageType.STRING.toString(), "id", 100,0, false, "商户id" )))
							.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 255,0, false, "商户名称" )))
							.addNode(new FieldNode("mertype", new MsgField(ContentEnum.MessageType.STRING.toString(), "mertype", 4,0, false, "商户类型" )))
							.addNode(new FieldNode("mercode", new MsgField(ContentEnum.MessageType.STRING.toString(), "mercode", 255,0, false, "商户编号" )))
							.addNode(new FieldNode("merinneraccountno", new MsgField(ContentEnum.MessageType.STRING.toString(), "merinneraccountno", 40,0, false, "商户内部户" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

