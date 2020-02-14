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
 * BASESVC.P012000105 对私账户开户.个人存款开户 
 * P0120001.05 dp2101
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P012000105 extends EsbCoreChannelService {

	private static P012000105_I i = new P012000105_I();
	private static P012000105_O o = new P012000105_O();
	public P012000105() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P012000105_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, true, "产品编号" )))
					.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, true, "货币代号" )))
					.addNode(new FieldNode("dept_freq", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_freq", 8,0, false, "存入频率" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("acct_clasf", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf", 4,0, true, "账户分类" )))
					.addNode(new FieldNode("acct_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_attr", 10,0, true, "账户属性" )))
					.addNode(new FieldNode("strt_int_caln_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_int_caln_dt", 8,0, false, "起息日期" )))
					.addNode(new FieldNode("matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_dt", 8,0, false, "到期日期" )))
					.addNode(new FieldNode("int_rate_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_code", 20,0, false, "利率代码" )))
					.addNode(new FieldNode("open_acct_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "open_acct_int_rate", 12,7, false, "开户利率" )))
					.addNode(new FieldNode("int_rate_flt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_flt_flg", 1,0, false, "利率浮动标志" )))
					.addNode(new FieldNode("int_rate_flt_pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate_flt_pcnt", 12,7, false, "利率浮动比例" )))
					.addNode(new FieldNode("flt_val", new MsgField(ContentEnum.MessageType.INT.toString(), "flt_val", 20,7, false, "浮动值" )))
					.addNode(new FieldNode("pref_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pref_flg", 1,0, false, "优惠标志" )))
					.addNode(new FieldNode("actl_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_int_rate", 12,7, false, "实际利率" )))
					.addNode(new FieldNode("wthr_fx_rgln_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_fx_rgln_flg", 1,0, false, "是否外汇监管标志" )))
					.addNode(new FieldNode("newly_open_cust_acct_num_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "newly_open_cust_acct_num_flg", 1,0, true, "是否需要新开客户账号" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("cptl_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptl_src", 1,0, false, "资金来源" )))
					.addNode(new FieldNode("open_acct_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "open_acct_amt", 18,2, false, "开户金额" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, true, "客户号" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
					.addNode(new FieldNode("rdept_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_way", 1,0, false, "转存方式" )))
					.addNode(new FieldNode("rdept_dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_dept_prd", 6,0, false, "转存存期" )))
					.addNode(new FieldNode("prcpl_int_in_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcpl_int_in_cust_acct_num", 40,0, false, "本金/利息转入账号" )))
					.addNode(new FieldNode("prcpl_int_trfr_in_sys_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcpl_int_trfr_in_sys_acct_num", 40,0, false, "本金/利息转入系统账号" )))
					.addNode(new FieldNode("matu_rdept_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "matu_rdept_amt", 18,2, false, "转存金额" )))
					.addNode(new FieldNode("draw_intrv", new MsgField(ContentEnum.MessageType.STRING.toString(), "draw_intrv", 8,0, false, "支取间隔" )))
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
					.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 32,0, false, "凭证序号" )))
					//.addNode(new FieldNode("unvsl_wthdg_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "unvsl_wthdg_scope", 1,0, false, "通兑范围" )))
					.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, false, "支付条件" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 32,0, false, "交易密码" )))
					.addNode(new FieldNode("pymt_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cust_acct_num", 40,0, false, "付款客户账号" )))
					.addNode(new FieldNode("trfr_in_ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_ccy_code_num", 3,0, false, "转入货币代号" )))
					.addNode(new FieldNode("trfr_in_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_cash_rmtc_flg", 1,0, false, "转入钞汇标志" )))
					.addNode(new FieldNode("pymt_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_sub_acct_serl_num", 8,0, false, "付款子账户序号" )))
					.addNode(new FieldNode("pymt_acct_vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_vchr_catg", 4,0, false, "付款账户凭证种类" )))
					.addNode(new FieldNode("pymt_acct_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_vchr_serl_num", 32,0, false, "付款账户凭证序号" )))
					.addNode(new FieldNode("pymt_acct_txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_txn_pswd", 32,0, false, "付款账户交易密码" )))
					.addNode(new FieldNode("id_chk_rslt", new MsgField(ContentEnum.MessageType.STRING.toString(), "id_chk_rslt", 2,0, false, "存款人身份核查结果" )))
					.addNode(new FieldNode("unabl_vrfcn_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "unabl_vrfcn_reason", 2,0, false, "存款人无法核实原因" )))
					.addNode(new FieldNode("comt_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "comt_reason", 300,0, false, "说明原因" )))
					.addNode(new FieldNode("slcit_dept_pernl", new MsgField(ContentEnum.MessageType.STRING.toString(), "slcit_dept_pernl", 256,0, false, "揽存人员" )))
					.addNode(new FieldNode("cust_self_chc_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_self_chc_num", 40,0, false, "客户自选号码" )))
					.addNode(new FieldNode("wthr_self_chc_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_self_chc_num", 1,0, false, "是否自选号码" )))
					.addNode(new FieldNode("asgn_drcn", new MsgField(ContentEnum.MessageType.STRING.toString(), "asgn_drcn", 1,0, false, "指定去向" )))
					.addNode(new FieldNode("drcnl_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "drcnl_ste", 1,0, false, "定向状态" )))
					.addNode(new FieldNode("drcn_rmov_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "drcn_rmov_way", 1,0, false, "去向解除方式" )))
					.addNode(new FieldNode("drcnl_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "drcnl_cust_acct_num", 40,0, false, "定向客户账号" )))
					.addNode(new FieldNode("drcnl_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "drcnl_sub_acct_serl_num", 8,0, false, "定向子账户序号" )))
					.addNode(new FieldNode("int_rate_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_num_tp", 1,0, false, "利率编号类型" )))
					.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
					.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
					.addNode(new FieldNode("acct_mgr_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_mgr_nm", 256,0, false, "账户经理名称" )))
					.addNode(new FieldNode("auto_ddc_mny_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "auto_ddc_mny_flg", 1,0, false, "自动扣款标志" )))
					.addNode(new FieldNode("ddc_mny_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ddc_mny_cust_acct_num", 40,0, false, "扣款客户账号" )))
					.addNode(new FieldNode("trfr_out_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_acct_nm", 256,0, false, "转出账户名称" )))
					.addNode(new FieldNode("trfr_out_vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_vchr_btch_num", 10,0, false, "转出凭证批号" )))
					.addNode(new FieldNode("trfr_out_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_vchr_serl_num", 32,0, false, "转出凭证序号" )))
					.addNode(new FieldNode("trfr_out_vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_vchr_catg", 4,0, false, "转出凭证种类" )))
					.addNode(new FieldNode("trfr_out_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_sub_acct_serl_num", 8,0, false, "转出子账户序号" )))
					.addNode(new FieldNode("ddc_mny_acct_txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "ddc_mny_acct_txn_pswd", 32,0, false, "扣款账户交易密码" )))
					.addNode(new FieldNode("ddc_mny_acct_pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "ddc_mny_acct_pymt_cond", 1,0, false, "扣款账户支付条件" )))
					.addNode(new FieldNode("ddc_mny_pern_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ddc_mny_pern_docs_num", 30,0, false, "扣款人证件号码" )))
					.addNode(new FieldNode("ddc_mny_pern_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ddc_mny_pern_docs_catg", 3,0, false, "扣款人证件种类" )))
					.addNode(new FieldNode("open_acct_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_org", 12,0, false, "开户机构" )))
					.addNode(new FieldNode("int_pymt_freq", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_pymt_freq", 8,0, false, "付息频率" )))
					.addNode(new FieldNode("int_trfr_in_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_trfr_in_acct_num", 40,0, false, "利息转入账号" )))
					.addNode(new FieldNode("bal_genl_ledger_sycrz_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "bal_genl_ledger_sycrz_flg", 1,0, false, "余额总账同步标志" )))
					.addNode(new FieldNode("int_trfr_in_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_trfr_in_cust_acct_num", 40,0, false, "利息转入客户账号" )))
					.addNode(new FieldNode("int_trfr_in_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_trfr_in_sub_acct_serl_num", 8,0, false, "利息转入子账户序号" )))
					.addNode(new ArrayNode("listnm02_list",false)
							.addNode(new FieldNode("rfer_nm_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_nm_01", 256,0, false, "推荐人名称" )))
							.addNode(new FieldNode("rfer_job_num_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_job_num_01", 10,0, false, "推荐人工号" )))
							.addNode(new FieldNode("rfer_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_type", 1,0, false, "推荐人类型" )))
							).addNode(new FieldNode("pnly_int_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "pnly_int_code", 50,0, false, "罚息代码" )))
					.addNode(new FieldNode("adv_int_pymt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "adv_int_pymt_flg", 1,0, false, "预付息标志" )))
					.addNode(new FieldNode("adv_int_pymt_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "adv_int_pymt_code", 10,0, false, "预付息代码" )))
					.addNode(new FieldNode("int_pymt_dt_cfrm_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_pymt_dt_cfrm_way", 1,0, false, "付息日期确定方式" )))
					.addNode(new FieldNode("adv_int_pymt_int_pymt_freq", new MsgField(ContentEnum.MessageType.STRING.toString(), "adv_int_pymt_int_pymt_freq", 8,0, false, "预付息付息频率" )))
					.addNode(new FieldNode("asgn_strt_int_pymt_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "asgn_strt_int_pymt_dt", 8,0, false, "指定起始付息日期" )))
					.addNode(new FieldNode("int_alocn_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_alocn_way", 1,0, false, "利息分配方式" )))
					.addNode(new FieldNode("int_alocn_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_alocn_cnt", 10,0, false, "利息分配次数" )))
					.addNode(new FieldNode("adv_int_pymt_cptl_drcn", new MsgField(ContentEnum.MessageType.STRING.toString(), "adv_int_pymt_cptl_drcn", 1,0, false, "预付息资金去向" )))
					.addNode(new ArrayNode("listinfo_list",false)
							.addNode(new FieldNode("pymt_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_prd", 10,0, false, "支付期次" )))
							.addNode(new FieldNode("adv_int_pymt_pymt_pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "adv_int_pymt_pymt_pcnt", 18,2, false, "预付息支付比例" )))
							.addNode(new FieldNode("asgn_int_pymt_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "asgn_int_pymt_dt", 8,0, false, "指定付息日期" )))
							).addNode(new FieldNode("pnly_int_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pnly_int_flg", 1,0, false, "罚息标志" )))
					.addNode(new FieldNode("cust_acct_num_als", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_als", 256,0, false, "账户别名" )))
					.addNode(new FieldNode("als_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "als_catg", 1,0, false, "别名种类" )))
					.addNode(new FieldNode("pymt_acct_vchr_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_vchr_dt", 8,0, false, "转出凭证出票日期" )))
					.addNode(new FieldNode("main_group_status", new MsgField(ContentEnum.MessageType.STRING.toString(), "main_group_status", 3,0, false, "主体分类状态" )))
					.addNode(new FieldNode("per_explain_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "per_explain_flg", 1,0, false, "是否是待说明个人" )))
					.addNode(new FieldNode("add_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "add_docs_num", 30,0, false, "补充证件号码" )))
					.addNode(new FieldNode("acct_prps", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_prps", 100,0, false, "账户用途" )))
					.addNode(new FieldNode("cust_cntry", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_cntry", 256,0, false, "国家/地区" )))
					.addNode(new FieldNode("int_caln_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_caln_way", 1,0, false, "计息标记" )))
					.addNode(new FieldNode("rmrk_clom", new MsgField(ContentEnum.MessageType.STRING.toString(), "rmrk_clom", 300,0, false, "备注" )))
					.addNode(new FieldNode("pymt_acct_pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_pymt_cond", 1,0, false, "付款账户支付条件" )))
					.addNode(new FieldNode("payer_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "payer_docs_catg", 3,0, false, "付款人证件种类" )))
					.addNode(new FieldNode("payer_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "payer_docs_num", 30,0, false, "付款人证件号码" )))
					.addNode(new FieldNode("bill_rdrd_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "bill_rdrd_dt", 8,0, false, "出票日期" )))
					.addNode(new FieldNode("int_caln_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_caln_flg", 1,0, false, "计息标志" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P012000105_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("org_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "org_chins_nm", 300,0, false, "机构中文名称" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号" )))
					.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "acct_bal", 18,2, false, "账户余额" )))
					.addNode(new FieldNode("unvsl_wthdg_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "unvsl_wthdg_scope", 1,0, false, "通兑范围" )))
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品编号" )))
					.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
					.addNode(new FieldNode("acct_clasf", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf", 4,0, false, "账户分类" )))
					.addNode(new FieldNode("acct_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_attr", 10,0, false, "账户属性" )))
					.addNode(new FieldNode("strt_int_caln_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_int_caln_dt", 8,0, false, "起息日期" )))
					.addNode(new FieldNode("matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_dt", 8,0, false, "到期日期" )))
					.addNode(new FieldNode("rdept_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_way", 1,0, false, "转存方式" )))
					.addNode(new FieldNode("matu_rdept_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "matu_rdept_amt", 18,2, false, "转存金额" )))
					.addNode(new FieldNode("exec_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "exec_int_rate", 12,7, false, "执行利率" )))
					.addNode(new FieldNode("draw_intrv", new MsgField(ContentEnum.MessageType.STRING.toString(), "draw_intrv", 8,0, false, "支取间隔" )))
					.addNode(new FieldNode("evry_term_wthdl_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "evry_term_wthdl_amt", 18,2, false, "每期取款金额" )))
					.addNode(new FieldNode("rdept_dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_dept_prd", 6,0, false, "转存存期" )))
					.addNode(new FieldNode("prcpl_int_in_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcpl_int_in_cust_acct_num", 40,0, false, "本金/利息转入账号" )))
					.addNode(new FieldNode("prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_nm", 750,0, false, "产品名称" )))
					.addNode(new FieldNode("trfr_in_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_acct_nm", 256,0, false, "转入账户名称" )))
					.addNode(new FieldNode("track2_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "track2_info", 60,0, false, "二磁道信息" )))
					.addNode(new FieldNode("matu_int", new MsgField(ContentEnum.MessageType.INT.toString(), "matu_int", 18,2, false, "到期利息" )))
					.addNode(new FieldNode("prcpl_int_smtn", new MsgField(ContentEnum.MessageType.INT.toString(), "prcpl_int_smtn", 18,2, false, "本息合计" )))
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
					.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 32,0, false, "凭证序号" )))
					.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, false, "支付条件" )))
					.addNode(new FieldNode("totl_int", new MsgField(ContentEnum.MessageType.INT.toString(), "totl_int", 18,2, false, "总利息" )))
					.addNode(new FieldNode("this_tm_pymt_int", new MsgField(ContentEnum.MessageType.INT.toString(), "this_tm_pymt_int", 18,2, false, "本次支付利息" )))
					.addNode(new FieldNode("wait_write_off_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "wait_write_off_serl_num", 40,0, false, "待销账序号" )))
					.addNode(new ArrayNode("listnm_list",false)
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
							.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
							.addNode(new FieldNode("acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "acct_bal", 18,2, false, "账户余额" )))
							.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
							.addNode(new FieldNode("db_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "db_amt", 18,2, false, "借方金额" )))
							.addNode(new FieldNode("cr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "cr_amt", 18,2, false, "贷方金额" )))
							.addNode(new FieldNode("strt_int_caln_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_int_caln_dt", 8,0, false, "起息日期" )))
							.addNode(new FieldNode("matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_dt", 8,0, false, "到期日期" )))
							.addNode(new FieldNode("int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate", 12,7, false, "利率" )))
							.addNode(new FieldNode("ccy_ltr_abrvt", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_ltr_abrvt", 3,0, false, "货币字母缩写" )))
							.addNode(new FieldNode("dept_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_catg", 3,0, false, "存款种类" )))
							.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
							.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("athrzn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "athrzn_tlr", 10,0, false, "授权柜员" )))
							.addNode(new FieldNode("txn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_tlr", 10,0, false, "交易柜员" )))
							.addNode(new FieldNode("wthr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_flg", 1,0, false, "是否标志" )))
							.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" )))
							.addNode(new FieldNode("txn_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_org", 12,0, false, "交易机构" )))
							.addNode(new FieldNode("seq_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "seq_num", 10,0, false, "顺序号" )))
							.addNode(new FieldNode("next_prt_row_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "next_prt_row_num", 10,0, false, "下一打印行数" )))
							.addNode(new FieldNode("prt_pgs", new MsgField(ContentEnum.MessageType.STRING.toString(), "prt_pgs", 10,0, false, "打印页数" )))
							.addNode(new FieldNode("prt_row_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prt_row_num", 10,0, false, "打印行数" )))
							.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
							.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
							).addNode(new FieldNode("cust_acct_num_als", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_als", 256,0, false, "账户别名" )))
					.addNode(new FieldNode("als_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "als_catg", 1,0, false, "别名种类" )))
					.addNode(new FieldNode("als_sign_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "als_sign_ste", 1,0, false, "别名签约状态" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

