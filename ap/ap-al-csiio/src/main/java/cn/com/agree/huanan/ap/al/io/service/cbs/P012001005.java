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
 * BASESVC.P012001005 账户信息维护.单位账户日常信息维护 
 * P0120010.05 dp2157
 * 0005 新核心系统
 * @author LSJ
 */
@Component
public class P012001005 extends EsbCoreChannelService {

	private static P012001005_I i = new P012001005_I();
	private static P012001005_O o = new P012001005_O();
	public P012001005() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class P012001005_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
				.addNode(new FieldNode("qry_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_tp", 1,0, false, "查询类型" )))
				.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账号" )))
				.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, true, "子账户序号" )))
				.addNode(new FieldNode("cust_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_nm", 256,0, false, "客户账户名称" )))
				.addNode(new FieldNode("cheq_rcpn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cheq_rcpn_flg", 1,0, false, "领用支票标志" )))
				.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
				.addNode(new FieldNode("anul_inspct_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "anul_inspct_ste", 1,0, false, "年检状态" )))
				.addNode(new FieldNode("qry_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_pswd", 32,0, false, "查询密码" )))
				.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
				.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
				.addNode(new FieldNode("int_pymt_freq", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_pymt_freq", 8,0, false, "付息频率" )))
				.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品代码" )))
				.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
				.addNode(new FieldNode("acct_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_ste", 1,0, false, "账户状态" )))
				.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
				.addNode(new FieldNode("rdept_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_way", 1,0, false, "转存方式" )))
				.addNode(new FieldNode("rdept_dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_dept_prd", 6,0, false, "转存存期" )))
				.addNode(new FieldNode("corp_dmd_acct_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "corp_dmd_acct_attr", 1,0, false, "对公活期户属性" )))
				.addNode(new FieldNode("acct_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_attr", 10,0, false, "账户属性" )))
				.addNode(new FieldNode("strt_int_caln_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_int_caln_way", 1,0, false, "起息方式" )))
				.addNode(new FieldNode("alw_mod_cash_wthdl_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "alw_mod_cash_wthdl_flg", 1,0, false, "控制取现标志修改" )))
				.addNode(new FieldNode("cash_wthdl_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_wthdl_flg", 1,0, false, "取现标志" )))
				.addNode(new FieldNode("alw_mod_enabl_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "alw_mod_enabl_dt", 1,0, false, "控制启用日期修改" )))
				.addNode(new FieldNode("enabl_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "enabl_dt", 8,0, false, "启用日期" )))
				.addNode(new FieldNode("form_trfr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "form_trfr_flg", 1,0, false, "形态转移标志" )))
				.addNode(new FieldNode("basic_acct_open_acct_bank_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "basic_acct_open_acct_bank_num", 12,0, false, "基本户开户行行号" )))
				.addNode(new FieldNode("basic_acct_open_acct_bank_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "basic_acct_open_acct_bank_nm", 300,0, false, "基本户开户行行名" )))
				.addNode(new FieldNode("basic_acct_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "basic_acct_acct_num", 40,0, false, "基本户账号" )))
				.addNode(new FieldNode("temp_spec_acct_lics_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "temp_spec_acct_lics_num", 30,0, false, "临时/专户许可证号" )))
				.addNode(new FieldNode("open_basic_acct_lics_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_basic_acct_lics_num", 120,0, false, "基本户开户许可证号" )))
				.addNode(new FieldNode("wthr_fx_rgln_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_fx_rgln_flg", 1,0, false, "是否外汇监管标志" )))
				.addNode(new FieldNode("fx_chk_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fx_chk_flg", 1,0, false, "外汇核查标志" )))
				.addNode(new FieldNode("fx_cr_acmld_alwc", new MsgField(ContentEnum.MessageType.INT.toString(), "fx_cr_acmld_alwc", 18,2, false, "外汇贷方累计限额" )))
				.addNode(new FieldNode("aprvl_instru_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "aprvl_instru_num", 60,0, false, "核准件编号" )))
				.addNode(new FieldNode("fx_mgmt_acct_charic", new MsgField(ContentEnum.MessageType.STRING.toString(), "fx_mgmt_acct_charic", 4,0, false, "外管账户性质" )))
				.addNode(new FieldNode("sngl_prchbl_cheq_qty", new MsgField(ContentEnum.MessageType.STRING.toString(), "sngl_prchbl_cheq_qty", 10,0, false, "单次可购支票数量" )))
				.addNode(new FieldNode("pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "pcnt", 6,3, false, "比例(%)" )))
				.addNode(new FieldNode("acct_blgd_bank_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_blgd_bank_num", 12,0, false, "账户归属行行号" )))
				.addNode(new FieldNode("acct_chk_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_chk_flg", 1,0, false, "账户核查标志" )))
				.addNode(new FieldNode("wthr_rcncl_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_rcncl_flg", 1,0, false, "是否对账标志" )))
				.addNode(new FieldNode("rcncl_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcncl_scope", 1,0, false, "对账范围" )))
				.addNode(new FieldNode("lately_rcncl_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "lately_rcncl_dt", 8,0, false, "最近对账日期" )))
				.addNode(new FieldNode("int_rate_dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_dept_prd", 6,0, false, "利率存期" )))
				.addNode(new FieldNode("int_rate_upd_freq", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_upd_freq", 8,0, false, "利率更新频率" )))
				.addNode(new FieldNode("asgn_drcn", new MsgField(ContentEnum.MessageType.STRING.toString(), "asgn_drcn", 1,0, false, "指定去向" )))
				.addNode(new FieldNode("drcnl_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "drcnl_cust_acct_num", 40,0, false, "定向客户账号" )))
				.addNode(new FieldNode("drcnl_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "drcnl_sub_acct_serl_num", 8,0, false, "定向子账户序号" )))
				.addNode(new FieldNode("drcnl_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "drcnl_ste", 1,0, false, "定向状态" )))
				.addNode(new FieldNode("drcn_rmov_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "drcn_rmov_way", 1,0, false, "去向解除方式" )))
				.addNode(new FieldNode("prcpl_int_in_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcpl_int_in_cust_acct_num", 40,0, false, "本/息转入账号" )))
				.addNode(new FieldNode("prcpl_int_in_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcpl_int_in_sub_acct_serl_num", 40,0, false, "本/息入子账序号" )))
				.addNode(new FieldNode("last_anul_inspct_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "last_anul_inspct_dt", 8,0, false, "上次年检日期" )))
				.addNode(new ArrayNode("listinfo_list",false)
					.addNode(new FieldNode("fee_plan_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_plan_nm", 10,0, false, "费用计划名" )))
					.addNode(new FieldNode("rate_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "rate_nm", 750,0, false, "费率名称" )))
					.addNode(new FieldNode("alw_mod_cash_wthdl_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "alw_mod_cash_wthdl_flg", 1,0, false, "控制取现标志修改" )))
					)
				.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号" )))
				.addNode(new FieldNode("acct_clasf", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf", 4,0, false, "账户分类" )))
				.addNode(new FieldNode("matu_rdept_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "matu_rdept_amt", 18,2, false, "转存金额" )))
				.addNode(new FieldNode("prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_nm", 750,0, false, "产品名称" )))
				.addNode(new FieldNode("cash_dept_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_dept_flg", 1,0, false, "现金存入标志" )))
				.addNode(new FieldNode("trfr_dept_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_dept_flg", 1,0, false, "转账存入标志" )))
				.addNode(new FieldNode("dept_ctrl_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_ctrl_way", 1,0, false, "存入控制方式" )))
				.addNode(new FieldNode("dept_ctrl_meth", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_ctrl_meth", 1,0, false, "存入控制方法" )))
				.addNode(new FieldNode("dept_amt_ctrl_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_amt_ctrl_way", 1,0, false, "存入金额控制方式" )))
				.addNode(new FieldNode("sngl_dept_min_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "sngl_dept_min_amt", 18,2, false, "单次存入最小金额" )))
				.addNode(new FieldNode("sngl_dept_max_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "sngl_dept_max_amt", 18,2, false, "单次存入最大金额" )))
				.addNode(new FieldNode("dept_cnt_ctrl_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_cnt_ctrl_way", 1,0, false, "存入次数控制方式" )))
				.addNode(new FieldNode("min_dept_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "min_dept_cnt", 10,0, false, "最小存入次数" )))
				.addNode(new FieldNode("max_dept_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "max_dept_cnt", 10,0, false, "最大存入次数" )))
				.addNode(new FieldNode("dept_deal_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_deal_seq", 32,0, false, "存入处理顺序" )))
				.addNode(new FieldNode("acct_rtan_max_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "acct_rtan_max_bal", 18,2, false, "账户留存最大余额" )))
				.addNode(new FieldNode("cash_draw_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_draw_flg", 1,0, false, "现金支取标志" )))
				.addNode(new FieldNode("trfr_draw_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_draw_flg", 1,0, false, "转账支取标志" )))
				.addNode(new FieldNode("draw_ctrl_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "draw_ctrl_way", 1,0, false, "支取控制方式" )))
				.addNode(new FieldNode("draw_ctrl_meth", new MsgField(ContentEnum.MessageType.STRING.toString(), "draw_ctrl_meth", 1,0, false, "支取控制方法" )))
				.addNode(new FieldNode("draw_user_defn_ctrl", new MsgField(ContentEnum.MessageType.STRING.toString(), "draw_user_defn_ctrl", 4,0, false, "支取自定义控制" )))
				.addNode(new FieldNode("draw_aptmt_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "draw_aptmt_way", 1,0, false, "支取预约方式" )))
				.addNode(new FieldNode("draw_amt_ctrl_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "draw_amt_ctrl_way", 1,0, false, "支取金额控制方式" )))
				.addNode(new FieldNode("sngl_draw_min_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "sngl_draw_min_amt", 18,2, false, "单次支取最小金额" )))
				.addNode(new FieldNode("sngl_draw_max_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "sngl_draw_max_amt", 18,2, false, "单次支取最大金额" )))
				.addNode(new FieldNode("draw_cnt_ctrl_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "draw_cnt_ctrl_way", 1,0, false, "支取次数控制方式" )))
				.addNode(new FieldNode("min_draw_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "min_draw_cnt", 10,0, false, "最小支取次数" )))
				.addNode(new FieldNode("max_draw_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "max_draw_cnt", 10,0, false, "最大支取次数" )))
				.addNode(new FieldNode("draw_dflt_std", new MsgField(ContentEnum.MessageType.STRING.toString(), "draw_dflt_std", 1,0, false, "支取违约标准" )))
				.addNode(new FieldNode("draw_dflt_deal_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "draw_dflt_deal_way", 1,0, false, "支取违约处理方式" )))
				.addNode(new FieldNode("prot_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "prot_way", 1,0, false, "保护性质" )))
				.addNode(new FieldNode("draw_prot_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "draw_prot_seq", 32,0, false, "支取保护顺序" )))
				.addNode(new FieldNode("acct_rtan_min_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "acct_rtan_min_bal", 18,2, false, "账户留存最小余额" )))
				.addNode(new FieldNode("svc_fee_chrg_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "svc_fee_chrg_way", 1,0, false, "联机费用批量后收标志" )))
				.addNode(new FieldNode("chrg_freq", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_freq", 8,0, false, "收费频率" )))
				.addNode(new FieldNode("slcit_dept_pernl", new MsgField(ContentEnum.MessageType.STRING.toString(), "slcit_dept_pernl", 256,0, false, "揽存人员" )))
				.addNode(new FieldNode("acct_mgr_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_mgr_nm", 256,0, false, "账户经理名称" )))
				.addNode(new FieldNode("pswd_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_catg", 2,0, false, "密码种类" )))
				.addNode(new FieldNode("acct_chins_shrt_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_chins_shrt_nm", 256,0, false, "账户中文简称" )))
				.addNode(new FieldNode("acct_engl_shrt_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_engl_shrt_nm", 120,0, false, "账户英文简称" )))
				.addNode(new FieldNode("acct_engl_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_engl_nm", 120,0, false, "账户英文名称" )))
				.addNode(new FieldNode("white_list_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "white_list_flg", 1,0, false, "白名单标志" )))
				.addNode(new FieldNode("prvns_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "prvns_acct_flg", 1,0, false, "备付金账户标志" )))
				.addNode(new FieldNode("prvns_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "prvns_acct_tp", 2,0, false, "备付金账户类型" )))
				.addNode(new FieldNode("cstd_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstd_acct_tp", 2,0, false, "托管账户类型" )))
				.addNode(new FieldNode("cstd_class_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstd_class_acct_flg", 1,0, false, "托管类账户标志" )))
				.addNode(new FieldNode("trsry_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trsry_acct_flg", 1,0, false, "财政账户标志" )))
				.addNode(new FieldNode("trsry_dept_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "trsry_dept_acct_tp", 2,0, false, "财政存款账户类型" )))
				.addNode(new FieldNode("fta_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fta_acct_flg", 1,0, false, "自贸区账户标志" )))
				.addNode(new FieldNode("fta_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "fta_acct_tp", 1,0, false, "自贸区账户类型" )))
				.addNode(new FieldNode("cash_mgmt_sign_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_mgmt_sign_flg", 1,0, false, "现金管理签约标志" )))
				.addNode(new FieldNode("itrbnk_strge_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "itrbnk_strge_acct_tp", 2,0, false, "同业存放账户类型" )))
				.addNode(new FieldNode("rgln_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgln_acct_flg", 1,0, false, "监管账户标志" )))
				.addNode(new FieldNode("rgln_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgln_acct_tp", 3,0, false, "监管账户类型" )))
				.addNode(new FieldNode("billg_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "billg_flg", 1,0, false, "计费标志" )))
				.addNode(new FieldNode("int_caln_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_caln_flg", 1,0, false, "计息标志" )))
				.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, false, "支付条件" )))
				.addNode(new FieldNode("aprvl_filg_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "aprvl_filg_flg", 1,0, false, "核准备案标志" )))
				.addNode(new FieldNode("rel_busi_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "rel_busi_num", 120,0, false, "相关业务编号" )))
				.addNode(new FieldNode("cptl_rgln_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptl_rgln_flg", 4,0, false, "资金监管标志" )))
				.addNode(new FieldNode("acct_vld_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_vld_prd", 8,0, false, "账户有效期" )))
				.addNode(new FieldNode("ctrct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctrct_num", 80,0, false, "合同编号" )))
				.addNode(new FieldNode("secry_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "secry_flg", 1,0, false, "保密标志" )))
				.addNode(new FieldNode("pnly_int_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "pnly_int_code", 50,0, false, "罚息代码" )))
				.addNode(new FieldNode("pnly_int_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pnly_int_flg", 1,0, false, "罚息标志" )))
				.addNode(new FieldNode("out_org_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "out_org_type", 3,0, false, "境外机构类别" )))
				.addNode(new FieldNode("basic_acct_info_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "basic_acct_info_num", 120,0, false, "基本账户编号" )))
				.addNode(new FieldNode("max_limit_cry", new MsgField(ContentEnum.MessageType.STRING.toString(), "max_limit_cry", 3,0, false, "最高限额币种" )))
				.addNode(new FieldNode("draw_appro_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "draw_appro_num", 120,0, false, "提现批文号" )))
				.addNode(new FieldNode("remks", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks", 300,0, false, "备注" )))
				.addNode(new FieldNode("unvsl_cash_wthdg", new MsgField(ContentEnum.MessageType.STRING.toString(), "unvsl_cash_wthdg", 1,0, false, "通存通兑" )))
				.addNode(new FieldNode("agnt_cntct_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_cntct_tel", 20,0, false, "代理人联系电话" )))
				.addNode(new FieldNode("agnt_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_docs_catg", 3,0, false, "代理人证件种类" )))
				.addNode(new FieldNode("agnt_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_docs_num", 30,0, false, "代理人证件号码" )))
				.addNode(new FieldNode("agnt_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_nm", 256,0, false, "代理人名称" )))
				.addNode(new FieldNode("agnt_docs_vld_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_docs_vld_prd", 8,0, false, "代理人证件有效期" )))
				.addNode(new FieldNode("acct_prps", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_prps", 5,0, false, "用途信息" )))
				);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P012001005_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
				.addNode(new FieldNode("acct_clasf", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf", 4,0, false, "账户分类" )))
				.addNode(new FieldNode("prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_nm", 750,0, false, "产品名称" )))
				.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
				.addNode(new FieldNode("cust_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_nm", 256,0, false, "客户账户名称" )))
				.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
				.addNode(new FieldNode("deal_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "deal_info", 300,0, false, "处理信息" )))
				);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

