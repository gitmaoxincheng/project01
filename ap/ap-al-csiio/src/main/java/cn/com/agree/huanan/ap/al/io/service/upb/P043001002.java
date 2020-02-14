package cn.com.agree.huanan.ap.al.io.service.upb;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P043001002 银行卡支付限额信息查询.查询借记卡小额免密支付的状态及限额 
 * P0430010.02 T0399L071
 * 0399 统一支付平台(银联业务)
 * @author XZF
 */
@Component
public class P043001002 extends EsbChannelService {

	private static P043001002_I i = new P043001002_I();
	private static P043001002_O o = new P043001002_O();
	public P043001002() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P043001002_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 40,0, true, "卡号" )))
					.addNode(new FieldNode("pageflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageflag", 2,0, true, "翻页标识" )))
					.addNode(new FieldNode("maxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxnum", 2,0, true, "查询记录数数" )))
					.addNode(new FieldNode("idxcardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxcardno", 40,0, true, "翻页条件字段" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P043001002_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 10,0, false, "行数" )))
					.addNode(new ArrayNode("bodrcd_list",false)
							.addNode(new FieldNode("businm", new MsgField(ContentEnum.MessageType.STRING.toString(), "businm", 64,0, false, "业务名称" )))
							.addNode(new FieldNode("trandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 40,0, false, "卡号" )))
							.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1,0, false, "小额免密功能状态" )))
							.addNode(new FieldNode("sgqtam", new MsgField(ContentEnum.MessageType.STRING.toString(), "sgqtam", 18,0, false, "单笔限额金额" )))
							.addNode(new FieldNode("dyqtam", new MsgField(ContentEnum.MessageType.STRING.toString(), "dyqtam", 18,0, false, "日累计限额金额" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

