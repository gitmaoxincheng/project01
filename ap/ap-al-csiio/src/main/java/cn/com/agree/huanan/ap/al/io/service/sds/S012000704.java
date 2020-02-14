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
 * BASESVC.S012000704 集中作业管理.任务撤销 
 * S0120007.04 RelaTask
 * 0209 集中业务处理平台
 * @author XZF
 */
@Component
public class S012000704 extends EsbSdsChannelService {

	private static S012000704_I i = new S012000704_I();
	private static S012000704_O o = new S012000704_O();
	public S012000704() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S012000704_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("TASKID", new MsgField(ContentEnum.MessageType.STRING.toString(), "TASKID", 50,0, false, "任务号" )))
					.addNode(new FieldNode("RELATASKTYPE", new MsgField(ContentEnum.MessageType.STRING.toString(), "RELATASKTYPE", 10,0, false, "撤销类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S012000704_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("RETCODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "RETCODE", 10,0, false, "处理结果码" )))
					.addNode(new FieldNode("RETREASON", new MsgField(ContentEnum.MessageType.STRING.toString(), "RETREASON", 150,0, false, "处理结果信息" )))
					.addNode(new FieldNode("TASKMESSAGE", new MsgField(ContentEnum.MessageType.STRING.toString(), "TASKMESSAGE", 2097152,0, false, "返回报文" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

