package cn.com.agree.huanan.ap.al.io.service.cbs;

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
 * BASESVC.P015000101 通用冲正.外围自动冲正 
 * P0150001.01 ib1241
 * 0005 新核心系统
 * @author   XZF
 */
@Component
public class P015000101 extends EsbCoreChannelService {
 
//	private static P01500010122_I i = new P01500010122_I();
//	private static P015000101_O o = new P015000101_O();
	public P015000101() {
//		requestFormat.add(i);
//		responseFormat.add(o);
	}

	public static class P01500010122_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("orig_pfxn_sys_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "orig_pfxn_sys_dt", 8,0, true, "原前置日期" )))
					.addNode(new FieldNode("orig_pfxn_sys_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "orig_pfxn_sys_rung_num", 32,0, true, "原前置流水" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P015000101_O extends MsgBody {
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
}

