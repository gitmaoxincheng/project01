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
 * BASESVC.P012002301 专用账户开户.大额存单专用账户开户 
 * P0120023.01 dp2332
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P012002301 extends EsbCoreChannelService {

	private static P012002301_I i = new P012002301_I();
	private static P012002301_O o = new P012002301_O();
	public P012002301() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P012002301_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("open_acct_tp_whlsl", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_tp_whlsl", 1,0, false, "大额存单开户类型" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_tp", 2,0, false, "客户类型" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_tp", 1,0, false, "账户类型" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, false, "支付条件" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 300,0, false, "交易密码" )))
					.addNode(new FieldNode("main_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "main_cust_acct_num", 40,0, false, "主客户账号" )))
					.addNode(new FieldNode("one_acct_unvsl_acct_charic", new MsgField(ContentEnum.MessageType.STRING.toString(), "one_acct_unvsl_acct_charic", 1,0, false, "一户通账户性质" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P012002301_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_tp", 2,0, false, "客户类型" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_tp", 1,0, false, "账户类型" )))
					.addNode(new FieldNode("dept_recpt_ddct_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_recpt_ddct_acct_num", 40,0, false, "存单专用账号" )))
					.addNode(new FieldNode("dept_recpt_ddct_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_recpt_ddct_acct_nm", 256,0, false, "存单专用账户名" )))
					.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

