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
 * BASESVC.P013000605 账户信息查询.存款账户信息查询 
 * P0130006.05 ib1691
 * 0005 新核心业务系统
 * @author XZ
 */
@Component
public class P013000605 extends EsbCoreChannelService {
	
	private static P013000605_I i = new P013000605_I();
	private static P013000605_O o = new P013000605_O();
	public P013000605() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class P013000605_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
				.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账号" )))
				.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
				.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
				.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013000605_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
				.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
				.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
				.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
				.addNode(new FieldNode("acct_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_ste", 4,0, false, "账户状态" )))
				.addNode(new FieldNode("open_acct_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_org", 12,0, false, "开户机构" )))
				.addNode(new FieldNode("aval_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "aval_bal", 18,2, false, "可用余额" )))
				.addNode(new FieldNode("acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "acct_bal", 18,2, false, "账户余额" )))
				.addNode(new FieldNode("mbph", new MsgField(ContentEnum.MessageType.STRING.toString(), "mbph", 40,0, false, "移动电话" )))
				.addNode(new FieldNode("vchr_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_ste", 1,0, false, "凭证状态" )))
				.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, false, "支付条件" )))
				.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
				.addNode(new FieldNode("unvsl_wthdg_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "unvsl_wthdg_scope", 1,0, false, "通兑范围" )))
				.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
				.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
				.addNode(new FieldNode("sub_acct_qty", new MsgField(ContentEnum.MessageType.INT.toString(), "sub_acct_qty", 10,0, false, "子户数量" )))
				.addNode(new FieldNode("acct_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_class", 1,0, false, "账户类别" )))
				.addNode(new FieldNode("wthr_trsry_agnc_pyrl_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_trsry_agnc_pyrl_acct_flg", 1,0, false, "是否财政代发户标志" )))
				.addNode(new FieldNode("prod_blgd_obj", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_blgd_obj", 1,0, false, "产品所属对象" )))
				.addNode(new FieldNode("org_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "org_chins_nm", 300,0, false, "机构中文名称" )))
				.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
				.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
				.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 8,0, false, "凭证序号" )))
				.addNode(new FieldNode("acct_ctrl_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_ctrl_ste", 1,0, false, "账户控制状态" )))
				.addNode(new FieldNode("open_acct_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_dt", 8,0, false, "开户日期" )))
				.addNode(new FieldNode("open_acct_tlr_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_tlr_num", 10,0, false, "开户柜员号" )))
				.addNode(new FieldNode("cncl_acct_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_acct_org", 12,0, false, "销户机构" )))
				.addNode(new FieldNode("cncl_acct_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_acct_dt", 8,0, false, "销户日期" )))
				.addNode(new FieldNode("cncl_acct_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_acct_tlr", 10,0, false, "销户柜员" )))
				.addNode(new FieldNode("rstct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "rstct_tp", 1,0, false, "限制类型" )))
				.addNode(new FieldNode("acct_amt_frz_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_amt_frz_flg", 1,0, false, "账户金额冻结标志" )))
				.addNode(new FieldNode("acct_sealg_frz_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_sealg_frz_flg", 1,0, false, "账户封闭冻结标志" )))
				.addNode(new FieldNode("acct_recpt_only_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_recpt_only_flg", 1,0, false, "账户只收不付标志" )))
				.addNode(new FieldNode("acct_pymt_only_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_pymt_only_flg", 1,0, false, "账户只付不收标志" )))
				.addNode(new FieldNode("cur_acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "cur_acct_bal", 18,2, false, "当前账户余额" )))
				.addNode(new FieldNode("acct_clasf_code_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf_code_01", 10,0, false, "账户分类代码1" )))
				.addNode(new FieldNode("acct_clasf_code_02", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf_code_02", 10,0, false, "账户分类代码2" )))
				.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
				.addNode(new FieldNode("final_one_psbk_upd_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "final_one_psbk_upd_amt", 18,2, false, "最后一笔登折金额" )))
				.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
				.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
				.addNode(new FieldNode("open_acct_org_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_org_nm", 300,0, false, "开户机构名称" )))
				.addNode(new FieldNode("strt_int_caln_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_int_caln_dt", 8,0, false, "起息日期" )))
				.addNode(new FieldNode("matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_dt", 8,0, false, "到期日期" )))
				.addNode(new FieldNode("rdept_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_way", 1,0, false, "转存方式" )))
				.addNode(new FieldNode("open_acct_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "open_acct_amt", 18,2, false, "开户金额" )))
				.addNode(new FieldNode("min_rtan_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "min_rtan_bal", 18,2, false, "最小留存余额" )))
				.addNode(new FieldNode("int_caln_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_caln_flg", 1,0, false, "计息标志" )))
				.addNode(new FieldNode("frz_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "frz_amt", 18,2, false, "冻结金额" )))
				.addNode(new FieldNode("ctrl_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "ctrl_amt", 18,2, false, "控制金额" )))
				.addNode(new FieldNode("classi_acct_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "classi_acct_cust_acct_num", 40,0, false, "I类账户客户账号" )))
				.addNode(new FieldNode("wthr_intra_bank_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_intra_bank_acct_num", 1,0, false, "是否行内账号" )))
				.addNode(new FieldNode("rgln_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgln_acct_flg", 1,0, false, "监管账户标志" )))
				.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号" )))
				.addNode(new FieldNode("open_acct_chnl", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_chnl", 7,0, false, "开户渠道" )))
				.addNode(new FieldNode("cust_snthes_evlan_lv", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_snthes_evlan_lv", 2,0, false, "客户综合评估级别" )))
				.addNode(new FieldNode("cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_tp", 2,0, false, "客户类型" )))
				.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
				.addNode(new FieldNode("last_busi_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "last_busi_dt", 8,0, false, "上次业务日期" )))
				.addNode(new FieldNode("docs_vld_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_vld_prd", 8,0, false, "证件有效期" )))
				.addNode(new FieldNode("fx_mgmt_acct_charic", new MsgField(ContentEnum.MessageType.STRING.toString(), "fx_mgmt_acct_charic", 4,0, false, "外管账户性质" )))
				.addNode(new FieldNode("next_int_stlmt_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "next_int_stlmt_dt", 8,0, false, "下次结息日" )))
				.addNode(new FieldNode("bal_drcn", new MsgField(ContentEnum.MessageType.STRING.toString(), "bal_drcn", 1,0, false, "余额方向" )))
				.addNode(new FieldNode("dept_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_catg", 3,0, false, "存款种类" )))
				.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
				.addNode(new FieldNode("last_dy_acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "last_dy_acct_bal", 18,2, false, "上日账户余额" )))
				.addNode(new FieldNode("int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate", 12,7, false, "利率" )))
				.addNode(new FieldNode("int_trfr_in_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_trfr_in_acct_num", 40,0, false, "利息转入账号" )))
				.addNode(new FieldNode("int_trfr_in_acct_num_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_trfr_in_acct_num_flg", 1,0, false, "利息转入账号标志" )))
				.addNode(new FieldNode("this_tm_anul_inspct_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "this_tm_anul_inspct_dt", 8,0, false, "本次年检日期" )))
				.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, false, "卡号" )))
				.addNode(new FieldNode("busi_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_code", 32,0, false, "业务编码" )))
				.addNode(new FieldNode("anul_inspct_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "anul_inspct_ste", 1,0, false, "年检状态(账户年检信息标志)" )))
				.addNode(new FieldNode("acct_busi_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_busi_catg", 2,0, false, "账户业务种类" )))
				.addNode(new FieldNode("wthr_settle_non_pay_acct", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_settle_non_pay_acct", 1,0, false, "是否结汇待支付账户" )))
				.addNode(new FieldNode("lblty_prod_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_prod_tp", 1,0, false, "负债产品类型" )))
				.addNode(new FieldNode("card_grd", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_grd", 1,0, false, "卡等级" )))
				.addNode(new FieldNode("unvsl_cash_wthdg", new MsgField(ContentEnum.MessageType.STRING.toString(), "unvsl_cash_wthdg", 1,0, false, "通存通兑" )))
				.addNode(new FieldNode("stlmt_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "stlmt_acct_flg", 1,0, false, "结算账户标志" )))
				.addNode(new FieldNode("first_dept_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "first_dept_dt", 8,0, false, "首次存入日期" )))
				
				.addNode(new FieldNode("corpt_rprtv_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpt_rprtv_docs_catg", 3,0, false, "法人代表证件种类" )))
				.addNode(new FieldNode("corpt_rprtv_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpt_rprtv_docs_num", 30,0, false, "法人代表证件号码" )))
				.addNode(new FieldNode("dept_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_type", 3,0, false, "储种" )))
				.addNode(new FieldNode("cust_acct_rlvc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_rlvc_flg", 1,0, false, "客户账户关联标志" )))
				.addNode(new FieldNode("crdhd_cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "crdhd_cust_nm", 256,0, false, "持卡人客户名称" )))
				.addNode(new FieldNode("termn_suspd_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "termn_suspd_flg", 1,0, false, "中止暂停标志" )))

				.addNode(new FieldNode("card_catg_charic", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_catg_charic", 1,0,  false, "卡种性质" )))
				.addNode(new FieldNode("card_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_catg", 1,0, false, "卡种类" )))
				.addNode(new FieldNode("card_medm", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_medm", 1,0, false, "卡介质" )))
				.addNode(new FieldNode("card_obj", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_obj", 1,0, false, "卡对象" )))
				.addNode(new FieldNode("vip_nrl_card_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vip_nrl_card_flg", 1,0, false, "VIP/普卡标志" )))
				.addNode(new FieldNode("socl_scry_card_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "socl_scry_card_flg", 1,0, false, "社保卡标志" )))
				.addNode(new FieldNode("crdhd_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "crdhd_docs_catg", 3,0, false, "持卡人证件种类" )))
				.addNode(new FieldNode("crdhd_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "crdhd_docs_num", 30,0, false, "持卡人证件号码" )))
				.addNode(new FieldNode("vld_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "vld_dt", 8,0, false, "有效日期" )))
				.addNode(new FieldNode("pswd_lock_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_lock_flg", 1,0, false, "密码锁定标志" )))
				.addNode(new FieldNode("pay_methon_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "pay_methon_ste", 2,0, false, "支取方式状态" )))				
			);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

