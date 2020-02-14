package cn.com.agree.huanan.ap.al.io.service.sds;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbSdsChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.S013000906 集中作业查询.集中作业-平台关闭查询 
 * S0130009.06 PlaClose
 * 0209 集中业务处理平台
 * @author XZF
 */
@Component
public class S013000906 extends EsbSdsChannelService {
	
	private static S013000906_I i = new S013000906_I();
	private static S013000906_O o = new S013000906_O();
	public S013000906() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013000906_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("closeBrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "closeBrno", 20,0, false, "网点号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S013000906_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("RETCODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "RETCODE", 10,0, false, "处理结果码" )))
					.addNode(new FieldNode("RETREASON", new MsgField(ContentEnum.MessageType.STRING.toString(), "RETREASON", 150,0, false, "处理结果信息" )))
					.addNode(new FieldNode("OPEN_FLAG", new MsgField(ContentEnum.MessageType.STRING.toString(), "OPEN_FLAG", 10,0, false, "平台关闭标志" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

