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
 * BASESVC.P013000611 账户信息查询.负债账户详细信息查询 
 * P0130006.11 dp2022
 * 0005 新核心系统
 * @author LW
 */
@Component
public class P013000611 extends EsbCoreChannelService {
	/*

	 */
	private static P013000611_I i = new P013000611_I();
	private static P013000611_O o = new P013000611_O();
	public P013000611() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013000611_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("qry_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_tp", 1,0, false, "查询类型" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("org_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "org_code", 12,0, false, "机构代码" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("qry_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_pswd", 512,0, false, "查询密码" )))
					.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号" )))
					.addNode(new FieldNode("pswd_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_catg", 2,0, false, "密码种类" )))
					.addNode(new FieldNode("wthr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_flg", 1,0, false, "是否标志" )))
					.addNode(new FieldNode("qry_oprn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_oprn_flg", 1,0, false, "查询操作标志" )))
					.addNode(new FieldNode("hint_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "hint_flg", 1,0, false, "提示标志" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013000611_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
					.addNode(new FieldNode("open_acct_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_org", 12,0, false, "开户机构" )))
					.addNode(new FieldNode("open_acct_org_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_org_nm", 256,0, false, "开户机构名称" )))
					.addNode(new FieldNode("signtr_card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtr_card_num", 10,0, false, "印鉴卡号码" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("anul_inspct_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "anul_inspct_ste", 1,0, false, "年检状态" )))
					.addNode(new FieldNode("last_dy_acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "last_dy_acct_bal", 18,2, false, "上日账户余额" )))
					.addNode(new FieldNode("ctrct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctrct_num", 80,0, false, "合同编号" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品代码" )))
					.addNode(new FieldNode("prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_nm", 750,0, false, "产品名称" )))
					.addNode(new FieldNode("acct_clasf", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf", 4,0, false, "账户分类" )))
					.addNode(new FieldNode("acct_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_attr", 10,0, false, "账户属性" )))
					.addNode(new FieldNode("dept_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_catg", 3,0, false, "存款种类" )))
					.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
					.addNode(new FieldNode("open_acct_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_dt", 8,0, false, "开户日期" )))
					.addNode(new FieldNode("cncl_acct_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_acct_dt", 8,0, false, "销户日期" )))
					.addNode(new FieldNode("acct_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_ste", 1,0, false, "账户状态" )))
					.addNode(new FieldNode("acct_vld_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_vld_prd", 8,0, false, "账户有效期" )))
					.addNode(new FieldNode("acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "acct_bal", 18,2, false, "账户余额" )))
					.addNode(new FieldNode("aval_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "aval_bal", 18,2, false, "可用余额" )))
					.addNode(new FieldNode("acct_amt_frz_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_amt_frz_flg", 1,0, false, "账户金额冻结标志" )))
					.addNode(new FieldNode("acct_sealg_frz_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_sealg_frz_flg", 1,0, false, "账户封闭冻结标志" )))
					.addNode(new FieldNode("acct_pymt_only_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_pymt_only_flg", 1,0, false, "账户只付不收标志" )))
					.addNode(new FieldNode("acct_recpt_only_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_recpt_only_flg", 1,0, false, "账户只收不付标志" )))
					.addNode(new FieldNode("stlmt_acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "stlmt_acct_bal", 18,2, false, "结算户余额" )))
					.addNode(new FieldNode("frz_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "frz_ste", 1,0, false, "冻结状态" )))
					.addNode(new FieldNode("frz_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "frz_amt", 18,2, false, "冻结金额" )))
					.addNode(new FieldNode("ctrl_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctrl_ste", 1,0, false, "控制状态" )))
					.addNode(new FieldNode("ctrl_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "ctrl_amt", 18,2, false, "控制金额" )))
					.addNode(new FieldNode("can_frz_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "can_frz_bal", 18,2, false, "可冻余额" )))
					.addNode(new FieldNode("cash_wthdl_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_wthdl_flg", 1,0, false, "取现标志" )))
					.addNode(new FieldNode("draw_intrv", new MsgField(ContentEnum.MessageType.STRING.toString(), "draw_intrv", 8,0, false, "支取间隔" )))
					.addNode(new FieldNode("wthr_simp_int_caln", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_simp_int_caln", 1,0, false, "是否简单计息" )))
					.addNode(new FieldNode("strt_int_caln_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_int_caln_way", 1,0, false, "起息方式" )))
					.addNode(new FieldNode("strt_int_caln_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_int_caln_dt", 8,0, false, "起息日期" )))
					.addNode(new FieldNode("matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_dt", 8,0, false, "到期日期" )))
					.addNode(new FieldNode("exec_int_rate_within_dept_prd", new MsgField(ContentEnum.MessageType.INT.toString(), "exec_int_rate_within_dept_prd", 12,7, false, "期内执行利率" )))
					.addNode(new FieldNode("flt_val", new MsgField(ContentEnum.MessageType.INT.toString(), "flt_val", 20,7, false, "浮动值" )))
					.addNode(new FieldNode("int_rate_flt_pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate_flt_pcnt", 12,7, false, "利率浮动比例" )))
					.addNode(new FieldNode("rdept_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_way", 1,0, false, "转存方式" )))
					.addNode(new FieldNode("rdept_dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_dept_prd", 6,0, false, "转存存期" )))
					.addNode(new FieldNode("matu_rdept_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "matu_rdept_amt", 18,2, false, "转存金额" )))
					.addNode(new FieldNode("prcpl_int_in_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcpl_int_in_cust_acct_num", 40,0, false, "本金/利息转入账号" )))
					.addNode(new FieldNode("bal_genl_ledger_sycrz_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "bal_genl_ledger_sycrz_flg", 1,0, false, "余额与总账同步标志" )))
					.addNode(new FieldNode("wthr_rcncl_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_rcncl_flg", 1,0, false, "是否对账标志" )))
					.addNode(new FieldNode("rcncl_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcncl_scope", 1,0, false, "对账范围" )))
					.addNode(new FieldNode("lately_rcncl_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "lately_rcncl_dt", 8,0, false, "最近对账日期" )))
					.addNode(new FieldNode("wthr_need_anul_inspct", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_need_anul_inspct", 1,0, false, "是否需要年检" )))
					.addNode(new FieldNode("cpstn_prod_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpstn_prod_num", 10,0, false, "组合产品号" )))
					.addNode(new FieldNode("cpstn_prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpstn_prod_nm", 750,0, false, "组合产品名称" )))
					.addNode(new FieldNode("main_acct_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "main_acct_acct_num", 40,0, false, "主户账号" )))
					.addNode(new FieldNode("rgstn_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgstn_dt", 8,0, false, "登记日期" )))
					.addNode(new FieldNode("tel_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tel_num", 20,0, false, "电话号码" )))
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
					.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 32,0, false, "凭证序号" )))
					.addNode(new FieldNode("vchr_use_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_use_ste", 1,0, false, "凭证状态" )))
					.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, false, "支付条件" )))
					.addNode(new FieldNode("unvsl_wthdg_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "unvsl_wthdg_scope", 1,0, false, "通兑范围" )))
					.addNode(new FieldNode("cash_unvsl_wthdg_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_unvsl_wthdg_flg", 1,0, false, "现金通兑标志" )))
					.addNode(new FieldNode("trfr_unvsl_wthdg_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_unvsl_wthdg_flg", 1,0, false, "转账通兑标志" )))
					.addNode(new FieldNode("final_one_busi_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "final_one_busi_dt", 8,0, false, "最后一次业务日期" )))
					.addNode(new FieldNode("vchr_enabl_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_enabl_dt", 8,0, false, "凭证启用日期" )))
					.addNode(new FieldNode("wtht_psbk_upd_qty", new MsgField(ContentEnum.MessageType.STRING.toString(), "wtht_psbk_upd_qty", 10,0, false, "未登折数" )))
					.addNode(new FieldNode("cur_row_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cur_row_num", 10,0, false, "当前行数" )))
					.addNode(new FieldNode("prchbl_cheq_qty", new MsgField(ContentEnum.MessageType.STRING.toString(), "prchbl_cheq_qty", 10,0, false, "可购买支票量" )))
					.addNode(new FieldNode("pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "pcnt", 6,3, false, "比例(%)" )))
					.addNode(new FieldNode("cr_rltnp_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cr_rltnp_flg", 1,0, false, "信贷关系标志" )))
					.addNode(new FieldNode("loan_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "loan_acct_num", 40,0, false, "贷款账号" )))
					.addNode(new FieldNode("fx_mgmt_acct_charic", new MsgField(ContentEnum.MessageType.STRING.toString(), "fx_mgmt_acct_charic", 4,0, false, "外管账户性质" )))
					.addNode(new FieldNode("aprvl_instru_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "aprvl_instru_num", 60,0, false, "核准件编号" )))
					.addNode(new FieldNode("cr_acmld_alwc", new MsgField(ContentEnum.MessageType.INT.toString(), "cr_acmld_alwc", 18,2, false, "贷方累计限额" )))
					.addNode(new FieldNode("sprr_org_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sprr_org_num", 12,0, false, "上级机构号" )))
					.addNode(new FieldNode("src_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "src_acct_num", 40,0, false, "来源账号" )))
					.addNode(new FieldNode("src_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "src_acct_nm", 256,0, false, "来源账户名称" )))
					.addNode(new FieldNode("src_acct_bank_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "src_acct_bank_num", 2,0, false, "来源账户行号" )))
					.addNode(new FieldNode("src_acct_bank_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "src_acct_bank_nm", 300,0, false, "来源账户行名" )))
					.addNode(new FieldNode("basic_acct_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "basic_acct_acct_num", 40,0, false, "基本户账号" )))
					.addNode(new FieldNode("basic_acct_open_acct_bank_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "basic_acct_open_acct_bank_num", 12,0, false, "基本户开户行行号" )))
					.addNode(new FieldNode("basic_acct_open_acct_bank_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "basic_acct_open_acct_bank_nm", 300,0, false, "基本户开户行行名" )))
					.addNode(new FieldNode("open_basic_acct_lics_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_basic_acct_lics_num", 120,0, false, "基本户开户许可证号" )))
					.addNode(new FieldNode("temp_spec_acct_lics_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "temp_spec_acct_lics_num", 30,0, false, "临时/专户许可证号" )))
					.addNode(new FieldNode("exec_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "exec_int_rate", 12,7, false, "执行利率" )))
					.addNode(new FieldNode("evry_term_wthdl_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "evry_term_wthdl_amt", 18,2, false, "每期取款金额" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
					.addNode(new FieldNode("rlvc_vchr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rlvc_vchr_flg", 1,0, false, "关联凭证标志" )))
					.addNode(new FieldNode("omit_dept_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "omit_dept_cnt", 10,0, false, "漏存次数" )))
					.addNode(new FieldNode("slcit_dept_pernl", new MsgField(ContentEnum.MessageType.STRING.toString(), "slcit_dept_pernl", 256,0, false, "揽存人员" )))
					.addNode(new FieldNode("acct_mgr_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_mgr_nm", 256,0, false, "账户经理名称" )))
					.addNode(new FieldNode("acct_blgd_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_blgd_org", 12,0, false, "账户所属机构" )))
					.addNode(new FieldNode("fx_chk_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fx_chk_flg", 1,0, false, "外汇核查标志" )))
					.addNode(new FieldNode("wait_draw_int", new MsgField(ContentEnum.MessageType.INT.toString(), "wait_draw_int", 18,2, false, "待支取利息" )))
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
					.addNode(new FieldNode("actl_draw_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "actl_draw_cnt", 10,0, false, "实际支取次数" )))
					.addNode(new FieldNode("actl_dept_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "actl_dept_cnt", 10,0, false, "实际存入次数" )))
					.addNode(new FieldNode("cust_acct_num_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_01", 40,0, false, "付款客户账号" )))
					.addNode(new FieldNode("pymt_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_sub_acct_serl_num", 8,0, false, "付款子账户序号" )))
					.addNode(new FieldNode("pymt_acct_ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_ccy_code_num", 3,0, false, "付款账户货币代号" )))
					.addNode(new FieldNode("pymt_acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_cash_rmtc_flg", 1,0, false, "付款账户钞汇标志" )))
					.addNode(new FieldNode("fta_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "fta_acct_tp", 1,0, false, "自贸区账户类型" )))
					.addNode(new FieldNode("open_acct_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "open_acct_amt", 18,2, false, "开户金额" )))
					.addNode(new FieldNode("int_pymt_freq", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_pymt_freq", 8,0, false, "付息频率" )))
					.addNode(new FieldNode("acct_chins_shrt_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_chins_shrt_nm", 256,0, false, "账户中文简称" )))
					.addNode(new FieldNode("acct_engl_shrt_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_engl_shrt_nm", 120,0, false, "账户英文简称" )))
					.addNode(new FieldNode("acct_engl_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_engl_nm", 120,0, false, "账户英文名称" )))
					.addNode(new FieldNode("cheq_rcpn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cheq_rcpn_flg", 1,0, false, "领用支票标志" )))
					.addNode(new FieldNode("white_list_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "white_list_flg", 1,0, false, "白名单标志" )))
					.addNode(new FieldNode("prvns_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "prvns_acct_flg", 1,0, false, "备付金账户标志" )))
					.addNode(new FieldNode("cash_mgmt_sign_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_mgmt_sign_flg", 1,0, false, "现金管理签约标志" )))
					.addNode(new FieldNode("cstd_class_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstd_class_acct_flg", 1,0, false, "托管类账户标志" )))
					.addNode(new FieldNode("fta_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fta_acct_flg", 1,0, false, "自贸区账户标志" )))
					.addNode(new FieldNode("remks", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks", 300,0, false, "备注" )))
					.addNode(new FieldNode("trsry_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trsry_acct_flg", 1,0, false, "财政账户标志" )))
					.addNode(new FieldNode("rgln_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgln_acct_tp", 3,0, false, "监管账户类型" )))
					.addNode(new FieldNode("rgln_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgln_acct_flg", 1,0, false, "监管账户标志" )))
					.addNode(new FieldNode("prvns_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "prvns_acct_tp", 2,0, false, "备付金账户类型" )))
					.addNode(new FieldNode("cstd_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstd_acct_tp", 2,0, false, "托管账户类型" )))
					.addNode(new FieldNode("itrbnk_strge_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "itrbnk_strge_acct_tp", 2,0, false, "同业存放账户类型" )))
					.addNode(new FieldNode("trsry_dept_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "trsry_dept_acct_tp", 2,0, false, "财政存款账户类型" )))
					.addNode(new FieldNode("aval_lmt", new MsgField(ContentEnum.MessageType.INT.toString(), "aval_lmt", 18,2, false, "可用额度" )))
					.addNode(new FieldNode("cpstn_acct_tplt_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpstn_acct_tplt_code", 10,0, false, "组合账户模板代码" )))
					.addNode(new FieldNode("cpstn_acct_tplt_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpstn_acct_tplt_nm", 300,0, false, "组合账户模板名称" )))
					.addNode(new FieldNode("billg_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "billg_flg", 1,0, false, "计费标志" )))
					.addNode(new FieldNode("int_caln_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_caln_flg", 1,0, false, "计息标志" )))
					.addNode(new FieldNode("aprvl_filg_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "aprvl_filg_flg", 1,0, false, "核准备案标志" )))
					.addNode(new FieldNode("rel_busi_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "rel_busi_num", 120,0, false, "相关业务编号" )))
					.addNode(new FieldNode("cptl_rgln_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptl_rgln_flg", 4,0, false, "资金监管标志" )))
					.addNode(new FieldNode("fx_rgln_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fx_rgln_flg", 1,0, false, "外汇监管标志" )))
					.addNode(new FieldNode("asgn_drcn", new MsgField(ContentEnum.MessageType.STRING.toString(), "asgn_drcn", 1,0, false, "指定去向" )))
					.addNode(new FieldNode("drcnl_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "drcnl_cust_acct_num", 40,0, false, "定向客户账号" )))
					.addNode(new FieldNode("drcnl_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "drcnl_sub_acct_serl_num", 8,0, false, "定向子账户序号" )))
					.addNode(new FieldNode("drcn_rmov_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "drcn_rmov_way", 1,0, false, "去向解除方式" )))
					.addNode(new FieldNode("pnly_int_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pnly_int_flg", 1,0, false, "罚息标志" )))
					.addNode(new FieldNode("pnly_int_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "pnly_int_code", 50,0, false, "罚息代码" )))
					.addNode(new FieldNode("docs_vld_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_vld_prd", 8,0, false, "证件有效期" )))
					.addNode(new FieldNode("org_code_docs_vld_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "org_code_docs_vld_prd", 8,0, false, "组织机构代码证有效期" )))
					.addNode(new FieldNode("atht_file_vld_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "atht_file_vld_prd", 8,0, false, "证明文件有效期" )))
					.addNode(new FieldNode("mo", new MsgField(ContentEnum.MessageType.STRING.toString(), "mo", 8,0, false, "月份" )))
					.addNode(new FieldNode("anul_inspct_matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "anul_inspct_matu_dt", 8,0, false, "年检到期日期" )))
					.addNode(new FieldNode("modu", new MsgField(ContentEnum.MessageType.STRING.toString(), "modu", 2,0, false, "模块" )))
					.addNode(new FieldNode("vrfcn_in_pern_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vrfcn_in_pern_flg", 1,0, false, "当面核实标志" )))
					.addNode(new FieldNode("prod_blgd_obj", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_blgd_obj", 1,0, false, "产品所属对象" )))
					.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号" )))
					.addNode(new FieldNode("stlmt_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "stlmt_acct_flg", 1,0, false, "结算账户标志" )))
					.addNode(new FieldNode("agnt_cntct_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_cntct_tel", 20,0, false, "代理人联系电话" )))
					.addNode(new FieldNode("agnt_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_docs_catg", 3,0, false, "代理人证件种类" )))
					.addNode(new FieldNode("agnt_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_docs_num", 30,0, false, "代理人证件号码" )))
					.addNode(new FieldNode("agnt_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_nm", 256,0, false, "代理人名称" )))
					.addNode(new FieldNode("agnt_docs_vld_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_docs_vld_prd", 8,0, false, "代理人证件有效期" )))
					.addNode(new FieldNode("agnt_ntnlt", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_ntnlt", 3,0, false, "代理人国籍" )))
					.addNode(new FieldNode("unvsl_cash_wthdg", new MsgField(ContentEnum.MessageType.STRING.toString(), "unvsl_cash_wthdg", 1,0, false, "通存通兑" )))
					.addNode(new FieldNode("int_rate_code_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_code_tp", 1,0, false, "利率代码类型" )))
					.addNode(new FieldNode("int_caln_acmld_acmlv_num", new MsgField(ContentEnum.MessageType.INT.toString(), "int_caln_acmld_acmlv_num", 18,2, false, "计息累计积数" )))
					.addNode(new FieldNode("cust_snthes_evlan_lv", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_snthes_evlan_lv", 2,0, false, "客户综合评估级别" )))
					.addNode(new FieldNode("prod_term_dmd_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_term_dmd_acct_flg", 1,0, false, "产品定活标志" )))
					.addNode(new FieldNode("cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_tp", 2,0, false, "客户类型" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("rstct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "rstct_tp", 1,0, false, "限制类型" )))
					.addNode(new FieldNode("spare_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "spare_amt", 18,2, false, "备用金额" )))
					.addNode(new FieldNode("anul_inspct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "anul_inspct_flg", 1,0, false, "年检标志" )))
					.addNode(new FieldNode("acct_pstp_vld_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_pstp_vld_dt", 8,0, false, "账户延期有效日期" )))
					.addNode(new FieldNode("lmt_ctrl_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmt_ctrl_tp", 1,0, false, "额度控制类型" )))
					.addNode(new FieldNode("lmt_ccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmt_ccy", 3,0, false, "额度币种" )))
					.addNode(new FieldNode("amt_lmt", new MsgField(ContentEnum.MessageType.INT.toString(), "amt_lmt", 18,2, false, "金额额度" )))
					.addNode(new FieldNode("rsdl_amt_lmt", new MsgField(ContentEnum.MessageType.INT.toString(), "rsdl_amt_lmt", 18,2, false, "剩余金额额度" )))
					.addNode(new FieldNode("lmt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmt_num", 32,0, false, "额度编号" )))
					.addNode(new FieldNode("agrmt_rtan_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "agrmt_rtan_amt", 18,2, false, "协定留存金额" )))
					.addNode(new FieldNode("wthr_empe_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_empe_flg", 1,0, false, "是否员工标志" )))
					.addNode(new FieldNode("one_acct_unvsl", new MsgField(ContentEnum.MessageType.STRING.toString(), "one_acct_unvsl", 1,0, false, "一户通标志" )))
					.addNode(new FieldNode("trfr_in_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_way", 1,0, false, "入息方式" )))
					.addNode(new FieldNode("form_trfr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "form_trfr_flg", 1,0, false, "形态转移标志" )))
					.addNode(new FieldNode("acct_clasf_code_02", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf_code_02", 10,0, false, "账户分类代码2" )))
					.addNode(new FieldNode("acct_prps", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_prps", 5,0, false, "用途信息" )))
					.addNode(new FieldNode("open_acct_tlr_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_tlr_num", 10,0, false, "开户柜员号" )))
					.addNode(new FieldNode("out_org_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "out_org_type", 1,0, false, "境外机构类别" )))
					.addNode(new FieldNode("draw_appro_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "draw_appro_num", 18,0, false, "提现批文号" )))
					.addNode(new FieldNode("bchmk_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "bchmk_int_rate", 12,7, false, "基准利率" )))
					.addNode(new FieldNode("agrmt_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "agrmt_int_rate", 12,7, false, "协定利率" )))
					.addNode(new FieldNode("int_rate_flt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_flt_flg", 1,0, false, "利率浮动标志" )))
					.addNode(new FieldNode("int_rate_flt_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_flt_tp", 1,0, false, "利率浮动类型" )))
					.addNode(new FieldNode("int_rate_flt_pnts", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate_flt_pnts", 12,7, false, "利率浮动点数" )))
					.addNode(new FieldNode("dmd_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "dmd_int_rate", 12,7, false, "活期利率" )))
					.addNode(new FieldNode("rlvc_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "rlvc_vchr_serl_num", 10,0, false, "关联凭证号" )))
					.addNode(new FieldNode("assc_vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "assc_vchr_catg", 4,0, false, "关联凭证种类" )))
					.addNode(new FieldNode("ctrl_frze_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctrl_frze_flg", 1,0, false, "冻结止付状态" )))
					.addNode(new FieldNode("pay_methon_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "pay_methon_ste", 2,0, false, "支取方式状态" )))
					.addNode(new FieldNode("acct_clasf_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf_info", 64,0, false, "账户分类信息" )))
					.addNode(new FieldNode("org_shrt_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "org_shrt_nm", 120,0, false, "机构简称" )))
					.addNode(new FieldNode("card_anul_fee", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_anul_fee", 1,0, false, "卡年费收取标志" )))
					.addNode(new FieldNode("acct_mgmt_fee", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_mgmt_fee", 1,0, false, "账户管理费收取标志" )))
					.addNode(new FieldNode("termn_suspd_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "termn_suspd_flg", 1,0, false, "中止暂停标志" )))
					.addNode(new FieldNode("card_fee", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_fee", 1,0, false, "收费标志" )))
					.addNode(new FieldNode("actvn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "actvn_flg", 1,0, false, "激活标志" )))
					.addNode(new FieldNode("int_pymt_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_pymt_way", 1,0, false, "利息支付方式" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

