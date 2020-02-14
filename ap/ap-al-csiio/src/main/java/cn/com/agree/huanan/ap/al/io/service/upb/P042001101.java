package cn.com.agree.huanan.ap.al.io.service.upb;

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
 * BASESVC.P042001101 银行卡支付限额管理.借记卡小额免密开关及限额设置 
 * P0420011.01 T0399L021
 * 0399 统一支付平台(银联业务)
 * @author XZF
 */
@Component
public class P042001101 extends EsbChannelService {

	private static P042001101_I i = new P042001101_I();
	private static P042001101_O o = new P042001101_O();
	public P042001101() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P042001101_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)					
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 40,0, true, "卡号" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1,0, true, "借记卡小额免密功能状态" )))
					.addNode(new FieldNode("sgqtam", new MsgField(ContentEnum.MessageType.STRING.toString(), "sgqtam", 18,2, true, "单笔限额金额" )))
					.addNode(new FieldNode("dyqtam", new MsgField(ContentEnum.MessageType.STRING.toString(), "dyqtam", 18,2, true, "日累计限额金额" )))			
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P042001101_O extends MsgBody {
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

