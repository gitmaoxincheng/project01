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
 * BASESVC.P013000624 账户信息查询.大额存单专用账户查询 
 * P0130006.24 dp2336
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P013000624 extends EsbCoreChannelService {

	private static P013000624_I i = new P013000624_I();
	private static P013000624_O o = new P013000624_O();
	public P013000624() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013000624_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("pymt_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cust_acct_num", 40,0, false, "付款客户账号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013000624_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("dept_recpt_ddct_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_recpt_ddct_acct_num", 40,0, false, "存单专用账号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

