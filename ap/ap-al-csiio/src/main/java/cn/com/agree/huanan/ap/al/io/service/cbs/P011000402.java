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
 * BASESVC.P011000402 银行卡状态管理.个人定期转活期 
 * P0110004.02 ib1630
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P011000402 extends EsbCoreChannelService {

	private static P011000402_I i = new P011000402_I();
	private static P011000402_O o = new P011000402_O();
	public P011000402() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P011000402_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 32,0, false, "凭证序号" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 300,0, false, "交易密码" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("cptl_drcn", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptl_drcn", 1,0, true, "资金去向" )))
					.addNode(new FieldNode("trfr_in_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_cust_acct_num", 40,0, true, "转入客户账号" )))
					.addNode(new FieldNode("trfr_in_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_acct_nm", 256,0, false, "转入账户名称" )))
					.addNode(new FieldNode("trfr_in_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_sub_acct_serl_num", 8,0, false, "转入子账户序号" )))
					.addNode(new FieldNode("trfr_in_ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_ccy_code_num", 3,0, false, "转入货币代号" )))
					.addNode(new FieldNode("trfr_in_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_cash_rmtc_flg", 1,0, false, "转入钞汇标志" )))
					.addNode(new FieldNode("trfr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "trfr_amt", 18,2, false, "转账金额" )))
					.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
					.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P011000402_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
					.addNode(new FieldNode("actl_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_int_rate", 12,7, false, "实际利率" )))
					.addNode(new FieldNode("actl_int_occr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_int_occr_amt", 18,2, false, "实际利息发生额" )))
					.addNode(new FieldNode("int_tax_occr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "int_tax_occr_amt", 18,2, false, "利息税发生额" )))
					.addNode(new FieldNode("cncl_acct_cptl_drcn", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_acct_cptl_drcn", 1,0, false, "销户资金去向" )))
					.addNode(new FieldNode("trfr_in_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_acct_nm", 256,0, false, "转入账户名称" )))
					.addNode(new FieldNode("trfr_in_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_cust_acct_num", 40,0, false, "转入客户账号" )))
					.addNode(new FieldNode("actl_draw_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_draw_amt", 18,2, false, "实际支取金额" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

