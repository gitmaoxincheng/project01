package cn.com.agree.huanan.ap.al.io.service.cbs;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbCoreChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P012000605 账户签约.日日盈月月盈签约管理 
 * P0120006.05 dp2300
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P012000605 extends EsbCoreChannelService {

	private static P012000605_I i = new P012000605_I();
	private static P012000605_O o = new P012000605_O();
	public P012000605() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P012000605_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("sign_mntnc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "sign_mntnc_flg", 1,0, false, "签约维护标志" )))
					.addNode(new FieldNode("cptl_trfr_prod_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptl_trfr_prod_num", 10,0, false, "资金转移产品号" )))
					.addNode(new FieldNode("trfr_out_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_cust_acct_num", 40,0, false, "转出客户账号" )))
					.addNode(new FieldNode("trfr_out_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_sub_acct_serl_num", 8,0, false, "转出子账户序号" )))
					.addNode(new FieldNode("trfr_out_vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_vchr_catg", 4,0, false, "转出凭证种类" )))
					.addNode(new FieldNode("trfr_out_vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_vchr_btch_num", 10,0, false, "转出凭证批号" )))
					.addNode(new FieldNode("trfr_out_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_vchr_serl_num", 32,0, false, "转出凭证序号" )))
					.addNode(new FieldNode("pymt_acct_pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_pymt_cond", 1,0, false, "付款账户支付条件" )))
					.addNode(new FieldNode("trfr_out_acct_txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_acct_txn_pswd", 300,0, false, "转出账户交易密码" )))
					.addNode(new FieldNode("payer_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "payer_docs_catg", 3,0, false, "付款人证件种类" )))
					.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, false, "卡号" )))
					.addNode(new FieldNode("trfr_in_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_acct_nm", 256,0, false, "转入账户名称" )))
					.addNode(new FieldNode("trfr_in_vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_vchr_catg", 4,0, false, "转入凭证种类" )))
					.addNode(new FieldNode("trfr_in_vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_vchr_btch_num", 10,0, false, "转入凭证批号" )))
					.addNode(new FieldNode("trfr_in_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_vchr_serl_num", 32,0, false, "转入凭证序号" )))
					.addNode(new FieldNode("trfr_in_ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_ccy_code_num", 3,0, false, "转入货币代号" )))
					.addNode(new FieldNode("trfr_busi_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_busi_catg", 1,0, false, "转账业务种类" )))
					.addNode(new FieldNode("busi_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_catg", 2,0, false, "业务种类" )))
					.addNode(new FieldNode("trfr_amt_set", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_amt_set", 1,0, false, "转账金额设置" )))
					.addNode(new FieldNode("appo_rtan_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "appo_rtan_amt", 18,2, false, "约定留存金额" )))
					.addNode(new FieldNode("trfr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "trfr_amt", 18,2, false, "转账金额" )))
					.addNode(new FieldNode("trfr_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_way", 1,0, false, "转账方式" )))
					.addNode(new FieldNode("trfr_freq", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_freq", 8,0, false, "转账频率" )))
					.addNode(new ArrayNode("listinfo_list",false)
							.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品代码" )))
							.addNode(new FieldNode("prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_nm", 750,0, false, "产品名称" )))
							.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
							).addNode(new ArrayNode("listnm02_list",false)
									.addNode(new FieldNode("rfer_nm_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_nm_01", 256,0, false, "推荐人名称1" )))
									.addNode(new FieldNode("rfer_job_num_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_job_num_01", 10,0, false, "推荐人工号1" )))
									.addNode(new FieldNode("rfer_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_type", 1,0, false, "推荐人类型" )))
									));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P012000605_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("trfr_out_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_cust_acct_num", 40,0, false, "转出客户账号" )))
					.addNode(new FieldNode("trfr_out_lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_lblty_acct_num", 40,0, false, "转出负债账号" )))
					.addNode(new FieldNode("trfr_out_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_acct_nm", 256,0, false, "转出账户名称" )))
					.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, false, "卡号" )))
					.addNode(new FieldNode("sign_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "sign_ste", 1,0, false, "签约状态" )))
					.addNode(new FieldNode("busi_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_catg", 2,0, false, "业务种类" )))
					.addNode(new FieldNode("trfr_amt_set", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_amt_set", 1,0, false, "转账金额设置" )))
					.addNode(new FieldNode("trfr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "trfr_amt", 18,2, false, "转账金额" )))
					.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号" )))
					.addNode(new FieldNode("trfr_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_way", 1,0, false, "转账方式" )))
					.addNode(new FieldNode("actl_int_occr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_int_occr_amt", 18,2, false, "实际利息发生额" )))
					.addNode(new FieldNode("int_tax_occr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "int_tax_occr_amt", 18,2, false, "利息税发生额" )))
					.addNode(new FieldNode("appo_trfr_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "appo_trfr_dt", 8,0, false, "约定转账日期" )))
					.addNode(new ArrayNode("lstnm01_list",false)
							.addNode(new FieldNode("strt_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_dt_8", 8,0, false, "起始日期" )))
							.addNode(new FieldNode("end_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_dt", 8,0, false, "终止日期" )))
							.addNode(new FieldNode("acmlv_num", new MsgField(ContentEnum.MessageType.INT.toString(), "acmlv_num", 18,2, false, "积数" )))
							.addNode(new FieldNode("exec_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "exec_int_rate", 12,7, false, "执行利率" )))
							.addNode(new FieldNode("acd_int_207", new MsgField(ContentEnum.MessageType.INT.toString(), "acd_int_207", 18,2, false, "应计利息" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

