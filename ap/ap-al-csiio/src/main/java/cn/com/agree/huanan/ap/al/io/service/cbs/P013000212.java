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
 * BASESVC.P013000212 交易信息查询.通用账户交易信息查询 
 * P0130002.12 dp2023
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P013000212 extends EsbCoreChannelService {

	private static P013000212_I i = new P013000212_I();
	private static P013000212_O o = new P013000212_O();
	public P013000212() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013000212_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账号" )))
					.addNode(new FieldNode("qry_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_tp", 1,0, false, "查询类型" )))
					.addNode(new FieldNode("prod_term_dmd_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_term_dmd_acct_flg", 1,0, false, "产品定活标志" )))
					//.addNode(new FieldNode("org_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "org_code", 12,0, false, "机构代码" )))
					//.addNode(new FieldNode("pswd_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_catg", 2,0, false, "密码种类" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("strt_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_dt_8", 8,0, true, "起始日期" )))
					.addNode(new FieldNode("end_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_dt", 8,0, true, "终止日期" )))
					//.addNode(new FieldNode("qry_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_pswd", 32,0, false, "查询密码" )))
					//.addNode(new FieldNode("chrg_amt_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_amt_src", 1,0, false, "是否收费金额来源" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_cnt_num", 10,0, true, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_cnt_num", 10,0, true, "查询笔数" )))
					.addNode(new FieldNode("tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_rung_num", 32,0, false, "柜员流水号" )))
					.addNode(new FieldNode("db_cr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "db_cr_flg", 1,0, false, "借贷标志" )))
					.addNode(new FieldNode("min_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "min_amt", 18,2, false, "最小金额" )))
					.addNode(new FieldNode("max_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "max_amt", 18,2, false, "最大金额" )))
					.addNode(new FieldNode("strt_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_tm", 25,0, false, "起始时间" )))
					.addNode(new FieldNode("fnis_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "fnis_tm", 25,0, false, "终止时间" )))
					.addNode(new FieldNode("chnl_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "chnl_code", 7,0, false, "渠道代码" )))
					.addNode(new FieldNode("wthr_qry_rlvc_acct", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_qry_rlvc_acct", 1,0, true, "是否查询关联账户" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013000212_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
				   	.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("totl_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "totl_cnt_num", 10,0, false, "总笔数" )))
					.addNode(new ArrayNode("listnm_list",false)
							.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
							.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
							.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("db_occr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "db_occr_amt", 18,2, false, "借方发生额" )))
							.addNode(new FieldNode("cr_occr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "cr_occr_amt", 18,2, false, "贷方发生额" )))
							.addNode(new FieldNode("acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "acct_bal", 18,2, false, "账户余额" )))
							.addNode(new FieldNode("db_cr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "db_cr_flg", 1,0, false, "借贷标志" )))
							.addNode(new FieldNode("rvrs_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rvrs_flg", 1,0, false, "冲正标志" )))
							.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
							.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
							.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 32,0, false, "凭证序号" )))
							.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
							.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
							.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号" )))
							.addNode(new FieldNode("prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_nm", 750,0, false, "产品名称" )))
							.addNode(new FieldNode("cntpr_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_cust_acct_num", 40,0, false, "对方客户账号" )))
							.addNode(new FieldNode("cntpr_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_acct_nm", 256,0, false, "对方户名" )))
							.addNode(new FieldNode("txn_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_code", 20,0, false, "交易码" )))
							.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" )))
							.addNode(new FieldNode("tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_rung_num", 32,0, false, "柜员流水号" )))
							.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" )))
							.addNode(new FieldNode("txn_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_tm", 10,0, false, "交易时间" )))
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
							.addNode(new FieldNode("athrzn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "athrzn_tlr", 10,0, false, "授权柜员" )))
							.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品代码" )))
							.addNode(new FieldNode("dept_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_catg", 3,0, false, "存款种类" )))
							.addNode(new FieldNode("remks", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks", 300,0, false, "备注" )))
							.addNode(new FieldNode("agnt_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_nm", 256,0, false, "代理人名称" )))
							.addNode(new FieldNode("agnt_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_docs_catg", 3,0, false, "代理人证件种类" )))
							.addNode(new FieldNode("agnt_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_docs_num", 30,0, false, "代理人证件号码" )))
							.addNode(new FieldNode("bal_fld_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bal_fld_nm", 256,0, false, "余额字段名称" )))
							.addNode(new FieldNode("bal_genl_ledger_sycrz_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "bal_genl_ledger_sycrz_flg", 1,0, false, "余额与总账同步标志" )))
							.addNode(new FieldNode("txn_tm_str", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_tm_str", 16,0, false, "交易时间字符串" )))
							.addNode(new FieldNode("cntpr_fincl_org_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_fincl_org_code", 12,0, false, "对方金融机构代码" )))
							.addNode(new FieldNode("cntpr_fincl_org_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_fincl_org_nm", 256,0, false, "对方金融机构名称" )))
							.addNode(new FieldNode("cash_trfr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_trfr_flg", 1,0, false, "现转标志" )))
							.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
							.addNode(new FieldNode("detl_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "detl_serl_num", 10,0, false, "明细序号" )))
							.addNode(new FieldNode("be_rvrsd_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "be_rvrsd_flg", 1,0, false, "被冲正标志" )))
							.addNode(new FieldNode("actl_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "actl_sub_acct_serl_num", 8,0, false, "实际子账户序号" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

