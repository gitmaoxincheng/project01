package cn.com.agree.huanan.ap.al.io.service.usrcnter.telr;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbCoreChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * USRCNTER.TELR0007 用户中心.柜员岗位调动
 * @author HCP 
 */
@Component
public class Telr0007 extends EsbCoreChannelService {

	private static Telr0007_I i = new Telr0007_I();
	private static Telr0007_O o = new Telr0007_O();
	public Telr0007() {
        requestFormat.add(i);
        responseFormat.add(o);
	}
	
	public static class Telr0007_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			
			StructNode BODY = new StructNode("APPBody");
			BODY.addNode(new FieldNode("strtellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "strtellerno", 10,0, true, "调动柜员" )))
				.addNode(new FieldNode("operflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "operflag", 1,0, true, "操作类型" )))
				.addNode(new FieldNode("entdutyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "entdutyno", 10,0, true, "实体岗编号")));
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
	
	public static class Telr0007_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			StructNode  BODY= new StructNode("APPBody");
			messageNode.addStructNode(BODY);
			return messageNode;
		}  
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
}

