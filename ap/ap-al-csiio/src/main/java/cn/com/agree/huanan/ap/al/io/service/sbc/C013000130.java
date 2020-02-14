package cn.com.agree.huanan.ap.al.io.service.sbc;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.C013000130 客户信息查询.STM渠道黑白名单查询 
 * C0130001.30 DS0004
 * 0212 金融互联网服务平台sbc
 * @author zhonggp
 */
@Component
public class C013000130 extends EsbChannelService {
	
	private static C013000130_I i = new C013000130_I();
	private static C013000130_O o = new C013000130_O();

	public C013000130() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013000130_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("prdcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdcode", 35,0, true, "产品代码" )))
					.addNode(new FieldNode("cifno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cifno", 32,0, false, "核心客户号" )))
					.addNode(new FieldNode("accountno", new MsgField(ContentEnum.MessageType.STRING.toString(), "accountno", 40,0, false, "入账账号" )))
					.addNode(new FieldNode("idnumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "idnumber", 30,0, false, "证件号码" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class C013000130_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("prdcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdcode", 35,0, false, "产品代码" )))
					.addNode(new FieldNode("listtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "listtype", 2,0, false, "名单类别" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
