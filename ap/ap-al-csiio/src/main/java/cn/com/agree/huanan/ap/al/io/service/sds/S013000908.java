package cn.com.agree.huanan.ap.al.io.service.sds;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbSdsChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.S013000908 集中作业查询.移动营销查询 
 * S0130009.08 AutoQuer
 * 0209 集中业务处理平台
 * @author XZF
 */
@Component
public class S013000908 extends EsbSdsChannelService {

	private static S013000908_I i = new S013000908_I();
	private static S013000908_O o = new S013000908_O();
	public S013000908() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013000908_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("taskid", new MsgField(ContentEnum.MessageType.STRING.toString(), "taskid", 22,0, false, "任务号" )))
					.addNode(new FieldNode("autodate", new MsgField(ContentEnum.MessageType.STRING.toString(), "autodate", 8,0, false, "审核授权日期" )))
					.addNode(new FieldNode("autototal", new MsgField(ContentEnum.MessageType.INT.toString(), "autototal", 2,0, false, "审核授权笔数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S013000908_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("taskid", new MsgField(ContentEnum.MessageType.STRING.toString(), "taskid", 22,0, false, "任务号" )))
					.addNode(new FieldNode("autodate", new MsgField(ContentEnum.MessageType.STRING.toString(), "autodate", 8,0, false, "审核授权日期" )))
					.addNode(new FieldNode("taskresult", new MsgField(ContentEnum.MessageType.STRING.toString(), "taskresult", 1,0, false, "任务完成状态" )))
					.addNode(new FieldNode("autototal", new MsgField(ContentEnum.MessageType.INT.toString(), "autototal", 2,0, false, "审核授权笔数" )))
					.addNode(new ArrayNode("autolist",false)
							.addNode(new FieldNode("autoxuhao", new MsgField(ContentEnum.MessageType.STRING.toString(), "autoxuhao", 30,0, false, "序号" )))
							.addNode(new FieldNode("autoresult", new MsgField(ContentEnum.MessageType.STRING.toString(), "autoresult", 1,0, false, "授权结果" )))
							.addNode(new FieldNode("autonopassmsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "autonopassmsg", 80,0, false, "授权不通过原因" )))
							.addNode(new FieldNode("tradename", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradename", 80,0, true, "交易名称" )))
							.addNode(new FieldNode("detailmessage", new MsgField(ContentEnum.MessageType.STRING.toString(), "detailmessage", 1024,0, true, "详细信息" )))
							.addNode(new FieldNode("autouserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "autouserno", 10,0, false, "审核授权柜员" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

