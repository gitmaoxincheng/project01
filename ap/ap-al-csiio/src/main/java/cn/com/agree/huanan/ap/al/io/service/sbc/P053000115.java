package cn.com.agree.huanan.ap.al.io.service.sbc;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbCoreChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P053000115 基金公司信息查询 
 * P053000115 DS0003
 * 0005 新核心系统
 * @author Maoxc
 */ 
@Component
public class P053000115 extends EsbCoreChannelService {
	private static P053000115_I i = new P053000115_I();
	private static P053000115_O o = new P053000115_O();
	public P053000115() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class P053000115_I extends MsgBody {
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

	public static class P053000115_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)						
				.addNode(new FieldNode("count", new MsgField(ContentEnum.MessageType.STRING.toString(), "count", 5,0, false, "总条数" )))
				.addNode(new ArrayNode("tainfo_list",false)
						.addNode(new FieldNode("tacode", new MsgField(ContentEnum.MessageType.STRING.toString(), "tacode", 20,0, false, "TA代码" )))
						.addNode(new FieldNode("taname", new MsgField(ContentEnum.MessageType.STRING.toString(), "taname", 100,0, false, "TA名称" )))
						)
				);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

