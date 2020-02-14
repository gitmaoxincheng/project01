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
 * BASESVC.P012001901 对公账户开户.单位客户账号开号 
 * P0120019.01 dp2110
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P012001901 extends EsbCoreChannelService {

	private static P012001901_I i = new P012001901_I();
	private static P012001901_O o = new P012001901_O();
	public P012001901() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P012001901_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_tp", 2,0, true, "客户类型" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, true, "客户号" )))
					.addNode(new FieldNode("open_acct_quick_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_quick_flg", 1,0, true, "快速开户标志" )))
					.addNode(new FieldNode("aprvl_filg_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "aprvl_filg_flg", 1,0, false, "核准备案标志" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
					.addNode(new FieldNode("prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_nm", 750,0, false, "产品名称" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, true, "货币代号" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, true, "产品编号" )))
					.addNode(new FieldNode("acct_clasf", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf", 4,0, true, "账户分类" )))
					.addNode(new FieldNode("acct_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_attr", 10,0, true, "账户属性" )))
					.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
					.addNode(new FieldNode("strt_int_caln_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_int_caln_dt", 8,0, false, "起息日期" )))
					.addNode(new FieldNode("acct_vld_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_vld_prd", 8,0, false, "账户有效期" )))
					.addNode(new FieldNode("qry_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_pswd", 32,0, false, "查询密码" )))
					.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, true, "支付条件" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 32,0, false, "交易密码" )))
					.addNode(new FieldNode("cptl_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptl_src", 1,0, false, "资金来源" )))
					.addNode(new FieldNode("int_caln_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_caln_way", 1,0, false, "计息方式" )))
					.addNode(new FieldNode("rdept_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_way", 1,0, false, "转存方式" )))
					.addNode(new FieldNode("rdept_dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_dept_prd", 6,0, false, "转存存期" )))
					.addNode(new FieldNode("matu_rdept_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "matu_rdept_amt", 18,2, false, "转存金额" )))
					.addNode(new FieldNode("prcpl_int_in_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcpl_int_in_cust_acct_num", 40,0, false, "本金/利息转入账号" )))
					.addNode(new FieldNode("prcpl_int_trfr_in_sys_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcpl_int_trfr_in_sys_acct_num", 40,0, false, "本金/利息转入系统账号" )))
					.addNode(new FieldNode("aprvl_instru_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "aprvl_instru_num", 60,0, false, "核准件编号" )))
					.addNode(new FieldNode("wthr_fx_rgln_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_fx_rgln_flg", 1,0, false, "是否外汇监管标志" )))
					.addNode(new FieldNode("fx_chk_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fx_chk_flg", 1,0, false, "外汇核查标志" )))
					.addNode(new FieldNode("wthr_self_chc_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_self_chc_num", 1,0, true, "是否自选号码" )))
					.addNode(new FieldNode("actl_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_int_rate", 12,7, false, "实际利率" )))
					.addNode(new FieldNode("acct_matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_matu_dt", 8,0, false, "账户到期日" )))
					.addNode(new FieldNode("int_rate_flt_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_flt_tp", 1,0, false, "利率浮动类型" )))
					.addNode(new FieldNode("flt_val", new MsgField(ContentEnum.MessageType.INT.toString(), "flt_val", 20,7, false, "浮动值" )))
					.addNode(new FieldNode("int_caln_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_caln_flg", 1,0, true, "计息标志" )))
					.addNode(new FieldNode("cash_draw_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_draw_flg", 1,0, false, "现金支取标志" )))
					.addNode(new FieldNode("corp_dmd_acct_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "corp_dmd_acct_attr", 1,0, false, "对公活期户属性" )))
					.addNode(new FieldNode("fx_mgmt_acct_charic", new MsgField(ContentEnum.MessageType.STRING.toString(), "fx_mgmt_acct_charic", 4,0, false, "外管账户性质" )))
					.addNode(new FieldNode("cust_self_chc_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_self_chc_num", 40,0, false, "客户自选号码" )))
					.addNode(new FieldNode("corp_open_acct_bank_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "corp_open_acct_bank_num", 12,0, false, "单位开户行行号" )))
					.addNode(new FieldNode("corp_open_acct_bank_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "corp_open_acct_bank_nm", 256,0, false, "单位开户行行名" )))
					.addNode(new FieldNode("int_rate_defn_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_defn_way", 1,0, false, "利率定义方式" )))
					.addNode(new FieldNode("atht_file_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "atht_file_num", 300,0, false, "证明文件编号" )))
					.addNode(new FieldNode("atht_file_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "atht_file_catg", 2,0, false, "证明文件种类" )))
					.addNode(new FieldNode("basic_acct_open_acct_bank_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "basic_acct_open_acct_bank_num", 12,0, false, "基本户开户行行号" )))
					.addNode(new FieldNode("basic_acct_open_acct_bank_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "basic_acct_open_acct_bank_nm", 300,0, false, "基本户开户行行名" )))
					.addNode(new FieldNode("basic_acct_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "basic_acct_acct_num", 40,0, false, "基本户账号" )))
					.addNode(new FieldNode("basic_acct_open_acct_lics_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "basic_acct_open_acct_lics_num", 30,0, false, "基本账户开户许可证核准号" )))
					.addNode(new FieldNode("temp_spec_acct_lics_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "temp_spec_acct_lics_num", 30,0, false, "临时/专户许可证号" )))
					.addNode(new FieldNode("int_rate_flt_pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate_flt_pcnt", 12,7, false, "利率浮动比例" )))
					.addNode(new FieldNode("pref_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pref_flg", 1,0, false, "优惠标志" )))
					.addNode(new FieldNode("bchmk_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "bchmk_int_rate", 12,7, false, "基准利率" )))
					.addNode(new FieldNode("int_rate_flt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_flt_flg", 1,0, false, "利率浮动标志" )))
					.addNode(new FieldNode("slcit_dept_pernl", new MsgField(ContentEnum.MessageType.STRING.toString(), "slcit_dept_pernl", 256,0, false, "揽存人员" )))
					.addNode(new FieldNode("acct_mgr_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_mgr_nm", 256,0, false, "账户经理名称" )))
					.addNode(new FieldNode("ctrct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctrct_num", 80,0, false, "合同编号" )))
					.addNode(new FieldNode("cr_acmld_alwc", new MsgField(ContentEnum.MessageType.INT.toString(), "cr_acmld_alwc", 18,2, false, "贷方累计限额" )))
					.addNode(new FieldNode("acct_blgd_bank_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_blgd_bank_num", 12,0, false, "账户归属行行号" )))
					.addNode(new FieldNode("acct_engl_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_engl_nm", 120,0, false, "账户英文名称" )))
					.addNode(new FieldNode("acct_engl_shrt_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_engl_shrt_nm", 120,0, false, "账户英文简称" )))
					.addNode(new FieldNode("acct_chins_shrt_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_chins_shrt_nm", 256,0, false, "账户中文简称" )))
					.addNode(new FieldNode("cheq_rcpn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cheq_rcpn_flg", 1,0, false, "领用支票标志" )))
					.addNode(new FieldNode("cr_acmld_alwc_ccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "cr_acmld_alwc_ccy", 3,0, false, "贷方累计限额币种" )))
					.addNode(new FieldNode("rel_busi_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "rel_busi_num", 120,0, false, "相关业务编号" )))
					.addNode(new FieldNode("white_list_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "white_list_flg", 1,0, false, "白名单标志" )))
					.addNode(new FieldNode("prvns_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "prvns_acct_flg", 1,0, false, "备付金账户标志" )))
					.addNode(new FieldNode("cash_mgmt_sign_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_mgmt_sign_flg", 1,0, false, "现金管理签约标志" )))
					.addNode(new FieldNode("cstd_class_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstd_class_acct_flg", 1,0, false, "托管类账户标志" )))
					.addNode(new FieldNode("fta_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fta_acct_flg", 1,0, false, "自贸区账户标志" )))
					.addNode(new FieldNode("trsry_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trsry_acct_flg", 1,0, false, "财政账户标志" )))
					.addNode(new FieldNode("rgln_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgln_acct_tp", 3,0, false, "监管账户类型" )))
					.addNode(new ArrayNode("listnm02_list",false)
							.addNode(new FieldNode("rfer_nm_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_nm_01", 256,0, false, "推荐人名称" )))
							.addNode(new FieldNode("rfer_job_num_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_job_num_01", 10,0, false, "推荐人工号" )))
							.addNode(new FieldNode("rfer_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_type", 1,0, false, "推荐人类型" )))
							).addNode(new FieldNode("rgln_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgln_acct_flg", 1,0, false, "监管账户标志" )))
					.addNode(new FieldNode("prvns_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "prvns_acct_tp", 2,0, false, "备付金账户类型" )))
					.addNode(new FieldNode("itrbnk_strge_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "itrbnk_strge_acct_tp", 2,0, false, "同业存放账户类型" )))
					.addNode(new FieldNode("trsry_dept_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "trsry_dept_acct_tp", 2,0, false, "财政存款账户类型" )))
					.addNode(new FieldNode("cstd_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstd_acct_tp", 2,0, false, "托管账户类型" )))
					.addNode(new FieldNode("fta_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "fta_acct_tp", 1,0, false, "自贸区账户类型" )))
					.addNode(new FieldNode("wthr_set_alwc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_set_alwc_flg", 1,0, false, "是否设置限额标志" )))
					.addNode(new FieldNode("open_acct_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_org", 12,0, false, "开户机构" )))
					.addNode(new FieldNode("cptl_rgln_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptl_rgln_flg", 4,0, false, "资金监管标志" )))
					.addNode(new FieldNode("asgn_drcn", new MsgField(ContentEnum.MessageType.STRING.toString(), "asgn_drcn", 1,0, false, "指定去向" )))
					.addNode(new FieldNode("drcnl_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "drcnl_cust_acct_num", 40,0, false, "定向客户账号" )))
					.addNode(new FieldNode("drcnl_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "drcnl_sub_acct_serl_num", 8,0, false, "定向子账户序号" )))
					.addNode(new FieldNode("cust_acct_num_als", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_als", 256,0, false, "账户别名" )))
					.addNode(new FieldNode("als_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "als_catg", 1,0, false, "别名种类" )))
					.addNode(new FieldNode("quot_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "quot_code", 10,0, false, "限额编码" )))
					.addNode(new FieldNode("quot_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "quot_type", 2,0, false, "最高限额类型" )))
					.addNode(new FieldNode("lmt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmt_num", 32,0, false, "额度编号" )))
					.addNode(new FieldNode("lmt_ctrl_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmt_ctrl_tp", 1,0, false, "额度控制类型" )))
					.addNode(new FieldNode("lmt_ccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmt_ccy", 3,0, false, "额度币种" )))
					.addNode(new FieldNode("acmld_txn_lmt", new MsgField(ContentEnum.MessageType.INT.toString(), "acmld_txn_lmt", 18,2, false, "累计交易额度" )))
					.addNode(new FieldNode("remks", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks", 300,0, false, "备注" )))
					.addNode(new FieldNode("unvsl_cash_wthdg", new MsgField(ContentEnum.MessageType.STRING.toString(), "unvsl_cash_wthdg", 1,0, false, "通存通兑" )))
					.addNode(new FieldNode("acct_prps", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_prps", 5,0, false, "用途信息" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P012001901_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("remks", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks", 300,0, false, "备注" )))
					.addNode(new FieldNode("cust_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_nm", 256,0, false, "客户账户名称" )))
					.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品代码" )))
					.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
					.addNode(new FieldNode("rdept_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_way", 1,0, false, "转存方式" )))
					.addNode(new FieldNode("rnew_dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "rnew_dept_prd", 6,0, false, "续存存期" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("actl_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_int_rate", 12,7, false, "实际利率" )))
					.addNode(new FieldNode("acct_clasf", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf", 4,0, false, "账户分类" )))
					.addNode(new FieldNode("acct_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_attr", 10,0, false, "账户属性" )))
					.addNode(new FieldNode("strt_int_caln_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_int_caln_way", 1,0, false, "起息方式" )))
					.addNode(new FieldNode("unvsl_wthdg_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "unvsl_wthdg_scope", 1,0, false, "通兑范围" )))
					.addNode(new FieldNode("corp_open_acct_bank_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "corp_open_acct_bank_nm", 256,0, false, "单位开户行行名" )))
					.addNode(new FieldNode("basic_acct_open_acct_lics_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "basic_acct_open_acct_lics_num", 30,0, false, "基本账户开户许可证核准号" )))
					.addNode(new FieldNode("fx_mgmt_acct_charic", new MsgField(ContentEnum.MessageType.STRING.toString(), "fx_mgmt_acct_charic", 4,0, false, "外管账户性质" )))
					.addNode(new FieldNode("cr_acmld_alwc", new MsgField(ContentEnum.MessageType.INT.toString(), "cr_acmld_alwc", 18,2, false, "贷方累计限额" )))
					.addNode(new FieldNode("aprvl_instru_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "aprvl_instru_num", 60,0, false, "核准件编号" )))
					.addNode(new FieldNode("frz_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "frz_num", 60,0, false, "冻结编号" )))
					.addNode(new FieldNode("prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_nm", 750,0, false, "产品名称" )))
					.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, false, "支付条件" )))
					.addNode(new FieldNode("slcit_dept_pernl", new MsgField(ContentEnum.MessageType.STRING.toString(), "slcit_dept_pernl", 256,0, false, "揽存人员" )))
					.addNode(new FieldNode("int_rate_flt_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_flt_tp", 1,0, false, "利率浮动类型" )))
					.addNode(new FieldNode("flt_val", new MsgField(ContentEnum.MessageType.INT.toString(), "flt_val", 20,7, false, "浮动值" )))
					.addNode(new FieldNode("int_rate_flt_pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate_flt_pcnt", 12,7, false, "利率浮动比例" )))
					.addNode(new FieldNode("bchmk_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "bchmk_int_rate", 12,7, false, "基准利率" )))
					.addNode(new FieldNode("cheq_rcpn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cheq_rcpn_flg", 1,0, false, "领用支票标志" )))
					.addNode(new FieldNode("billg_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "billg_flg", 1,0, false, "计费标志" )))
					.addNode(new FieldNode("prvns_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "prvns_acct_flg", 1,0, false, "备付金账户标志" )))
					.addNode(new FieldNode("cstd_class_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstd_class_acct_flg", 1,0, false, "托管类账户标志" )))
					.addNode(new FieldNode("fta_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fta_acct_flg", 1,0, false, "自贸区账户标志" )))
					.addNode(new FieldNode("trsry_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trsry_acct_flg", 1,0, false, "财政账户标志" )))
					.addNode(new FieldNode("prvns_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "prvns_acct_tp", 2,0, false, "备付金账户类型" )))
					.addNode(new FieldNode("trsry_dept_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "trsry_dept_acct_tp", 2,0, false, "财政存款账户类型" )))
					.addNode(new FieldNode("cstd_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstd_acct_tp", 2,0, false, "托管账户类型" )))
					.addNode(new FieldNode("matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_dt", 8,0, false, "到期日期" )))
					.addNode(new FieldNode("int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate", 12,7, false, "利率" )))
					.addNode(new FieldNode("fta_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "fta_acct_tp", 1,0, false, "自贸区账户类型" )))
					.addNode(new FieldNode("enabl_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "enabl_dt", 8,0, false, "启用日期" )))
					.addNode(new FieldNode("lmt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmt_num", 32,0, false, "额度编号" )))
					.addNode(new FieldNode("cust_acct_num_als", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_als", 256,0, false, "账户别名" )))
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

