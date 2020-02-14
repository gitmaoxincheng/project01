package cn.com.agree.huanan.ap.al.io.service.cbs;



import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;
/**
 * 
 * @author zhuzc
 * BASESVC P013001002 查询后台账务日期和时间
 * P013001002 ib1654
 * ATM
 */
@Component
public class P013001002 extends EciChannelService{
	private static P013001002_I i = new P013001002_I();
	private static P013001002_O o = new P013001002_O();
	public P013001002() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013001002_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("fgrd_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "fgrd_dt", 8,0, false, "前台日期" )))

					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013001002_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期" )))
					.addNode(new FieldNode("last_txn_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "last_txn_dt", 8,0, false, "上次交易日期" )))
					.addNode(new FieldNode("next_txn_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "next_txn_dt", 8,0, false, "下次交易日期" )))

					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
