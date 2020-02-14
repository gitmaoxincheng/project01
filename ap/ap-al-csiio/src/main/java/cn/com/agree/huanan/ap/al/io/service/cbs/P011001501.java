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
 * BASESVC.P011001501 同名账户互转.同名客户存款账户转账 
 * P0110015.01 dp2123
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P011001501 extends EsbCoreChannelService {

	private static P011001501_I i = new P011001501_I();
	private static P011001501_O o = new P011001501_O();
	public P011001501() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P011001501_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cptl_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptl_src", 1,0, true, "资金来源" )))
					.addNode(new FieldNode("pswd_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_catg", 2,0, false, "密码种类" )))
					.addNode(new FieldNode("wait_write_off_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "wait_write_off_serl_num", 40,0, false, "待销账序号" )))
					.addNode(new FieldNode("wait_write_off_src_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "wait_write_off_src_acct_num", 40,0, false, "待销账来源账号" )))
					.addNode(new FieldNode("wait_write_off_src_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "wait_write_off_src_acct_nm", 256,0, false, "待销账来源户名" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "txn_amt", 18,2, true, "交易金额" )))
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 32,0, false, "凭证序号" )))
					.addNode(new FieldNode("new_vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "new_vchr_catg", 4,0, false, "新凭证种类" )))
					.addNode(new FieldNode("new_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "new_vchr_serl_num", 32,0, false, "新凭证序号" )))
					.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, false, "支付条件" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 300,0, false, "交易密码" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("pymt_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_pswd", 300,0, false, "支付密码" )))
					.addNode(new FieldNode("pymt_vchr_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_vchr_dt", 8,0, false, "支付凭证日期" )))
					.addNode(new FieldNode("cptl_drcn", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptl_drcn", 1,0, true, "资金去向" )))
					.addNode(new FieldNode("rcev_mny_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcev_mny_cust_acct_num", 40,0, false, "收款客户账号" )))
					.addNode(new FieldNode("paye_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "paye_sub_acct_serl_num", 8,0, false, "收款人子账户序号" )))
					.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
					.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
					.addNode(new FieldNode("remks", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks", 300,0, false, "备注" )))
					.addNode(new FieldNode("open_acct_pern_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_pern_nm", 256,0, false, "开户人姓名" )))
					.addNode(new FieldNode("open_acct_pern_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_pern_docs_catg", 3,0, false, "开户人证件种类" )))
					.addNode(new FieldNode("open_acct_pern_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_pern_docs_num", 30,0, false, "开户人证件号码" )))
					.addNode(new FieldNode("chrg_amt_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_amt_src", 1,0, false, "收费金额来源" )))
					.addNode(new FieldNode("cntpr_fincl_org_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_fincl_org_code", 12,0, false, "对方金融机构代码" )))
					.addNode(new FieldNode("cntpr_fincl_org_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_fincl_org_nm", 256,0, false, "对方金融机构名称" )))
					//.addNode(new FieldNode("main_group_status", new MsgField(ContentEnum.MessageType.STRING.toString(), "main_group_status", 3,0, false, "主体分类状态" )))
					.addNode(new FieldNode("per_explain_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "per_explain_flg", 1,0, false, "是否是待说明个人" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P011001501_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cptl_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptl_src", 1,0, false, "资金来源" )))
					.addNode(new FieldNode("orig_write_off_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "orig_write_off_serl_num", 40,0, false, "原销账序号" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品编号" )))
					.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
					.addNode(new FieldNode("int_val", new MsgField(ContentEnum.MessageType.INT.toString(), "int_val", 18,2, false, "利息" )))
					.addNode(new FieldNode("int_tax", new MsgField(ContentEnum.MessageType.INT.toString(), "int_tax", 18,2, false, "利息税" )))
					.addNode(new FieldNode("cptl_drcn", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptl_drcn", 1,0, false, "资金去向" )))
					.addNode(new FieldNode("wait_write_off_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "wait_write_off_serl_num", 40,0, false, "待销账序号" )))
					.addNode(new FieldNode("trfr_in_acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "trfr_in_acct_bal", 18,2, false, "转入账户余额" )))
					.addNode(new FieldNode("trfr_out_acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "trfr_out_acct_bal", 18,2, false, "转出账户余额" )))
					.addNode(new FieldNode("rcev_mny_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcev_mny_cust_acct_num", 40,0, false, "收款客户账号" )))
					.addNode(new FieldNode("paye_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "paye_acct_nm", 256,0, false, "收款人户名" )))
					.addNode(new FieldNode("paye_ccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "paye_ccy", 3,0, false, "收款人币种" )))
					.addNode(new FieldNode("rcev_mny_acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcev_mny_acct_cash_rmtc_flg", 1,0, false, "收款账户钞汇标志" )))
					.addNode(new FieldNode("trfr_in_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "trfr_in_amt", 18,2, false, "转入金额" )))
					.addNode(new FieldNode("hint_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "hint_info", 300,0, false, "提示信息" )))
					.addNode(new FieldNode("pnly_int_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "pnly_int_amt", 18,2, false, "罚息金额" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

