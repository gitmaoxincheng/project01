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
 * BASESVC.P012001307 负债业务参数维护.定活莞家维护 
 * P0120013.07 dp2802
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P012001307 extends EsbCoreChannelService {

	private static P012001307_I i = new P012001307_I();
	private static P012001307_O o = new P012001307_O();
	public P012001307() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P012001307_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, false, "卡号" )))
					.addNode(new FieldNode("fincl_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "fincl_acct_num", 40,0, false, "理财账号" )))
					.addNode(new FieldNode("appo_trfr_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "appo_trfr_tp", 1,0, false, "约定转账类型" )))
					.addNode(new FieldNode("appo_rtan_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "appo_rtan_amt", 18,2, false, "约定留存金额" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P012001307_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

