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
 * BASESVC.P012000611 账户签约.定活莞家签约 
 * P0120006.11 dp2800
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P012000611 extends EsbCoreChannelService {

	private static P012000611_I i = new P012000611_I();
	private static P012000611_O o = new P012000611_O();
	public P012000611() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P012000611_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, false, "卡号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("appo_rtan_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "appo_rtan_amt", 18,2, false, "约定留存金额" )))
					.addNode(new FieldNode("appo_trfr_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "appo_trfr_tp", 1,0, false, "约定转账类型" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 32,0, false, "交易密码" )))
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, false, "支付条件" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("pswd_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_catg", 2,0, false, "密码种类" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P012000611_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("trfr_out_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_acct_num", 40,0, false, "转出账号" )))
					.addNode(new FieldNode("trfr_out_acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "trfr_out_acct_bal", 18,2, false, "转出账户余额" )))
					.addNode(new FieldNode("txn_rung_num_32", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_rung_num_32", 32,0, false, "交易流水号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

