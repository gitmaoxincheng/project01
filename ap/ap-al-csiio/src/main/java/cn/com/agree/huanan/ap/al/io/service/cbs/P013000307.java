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
 * BASESVC.P013000307 账户签约信息查询.定活莞家签约信息查询 
 * P0130003.07 dp2804
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P013000307 extends EsbCoreChannelService {

	private static P013000307_I i = new P013000307_I();
	private static P013000307_O o = new P013000307_O();
	public P013000307() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013000307_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013000307_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("appo_rtan_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "appo_rtan_amt", 18,2, false, "约定留存金额" )))
					.addNode(new FieldNode("appo_trfr_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "appo_trfr_tp", 1,0, false, "约定转账类型" )))
					.addNode(new FieldNode("trfr_out_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_cust_acct_num", 40,0, false, "转出客户账号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

