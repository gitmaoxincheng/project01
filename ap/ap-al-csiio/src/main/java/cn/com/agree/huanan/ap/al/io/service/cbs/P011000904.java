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
 * BASESVC.P011000904 存款产品购买.随心存认购 
 * P0110009.04 dp2398
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P011000904 extends EsbCoreChannelService {

	private static P011000904_I i = new P011000904_I();
	private static P011000904_O o = new P011000904_O();
	public P011000904() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P011000904_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cptl_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptl_src", 1,0, true, "资金来源" )))
					.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, true, "存期" )))
					.addNode(new FieldNode("newly_open_cust_acct_num_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "newly_open_cust_acct_num_flg", 1,0, false, "新开客户账号标志" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, true, "客户号" )))
					.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, true, "账户名称" )))
					.addNode(new FieldNode("prod_prd_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_prd_num", 50,0, false, "产品期次编号" )))
					.addNode(new FieldNode("prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_nm", 256,0, false, "产品名称" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, true, "账户钞汇标志" )))
					.addNode(new FieldNode("sbcrpn_totl_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "sbcrpn_totl_amt", 18,2, false, "认购总金额" )))
					.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, false, "支付条件" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 300,0, false, "交易密码" )))
					.addNode(new FieldNode("unvsl_wthdg_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "unvsl_wthdg_scope", 1,0, true, "通兑范围" )))
					.addNode(new FieldNode("strt_int_caln_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_int_caln_dt", 8,0, false, "起息日期" )))
					.addNode(new FieldNode("actl_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_int_rate", 12,7, false, "实际利率" )))
					.addNode(new FieldNode("pymt_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cust_acct_num", 40,0, false, "付款客户账号" )))
					.addNode(new FieldNode("pymt_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_sub_acct_serl_num", 8,0, false, "付款子账户序号" )))
					.addNode(new FieldNode("pymt_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_nm", 256,0, false, "付款账户名称" )))
					.addNode(new FieldNode("pymt_acct_pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_pymt_cond", 1,0, false, "付款账户支付条件" )))
					.addNode(new FieldNode("pymt_acct_txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_txn_pswd", 32,0, false, "付款账户交易密码" )))
					.addNode(new FieldNode("pymt_acct_vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_vchr_catg", 4,0, false, "付款账户凭证种类" )))
					.addNode(new FieldNode("pymt_acct_vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_vchr_btch_num", 10,0, false, "付款账户凭证批号" )))
					.addNode(new FieldNode("pymt_acct_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_vchr_serl_num", 32,0, false, "付款账户凭证序号" )))
					.addNode(new FieldNode("pymt_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_pswd", 300,0, false, "支付密码" )))
					.addNode(new FieldNode("docs_issue_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_issue_dt", 8,0, false, "证件签发日期" )))
					.addNode(new FieldNode("acct_clasf", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf", 4,0, false, "账户分类" )))
					.addNode(new FieldNode("acct_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_attr", 10,0, false, "账户属性" )))
					.addNode(new FieldNode("int_rate_flt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_flt_flg", 1,0, false, "利率浮动标志" )))
					.addNode(new FieldNode("int_rate_flt_pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate_flt_pcnt", 12,7, false, "利率浮动比例" )))
					.addNode(new FieldNode("flt_val", new MsgField(ContentEnum.MessageType.INT.toString(), "flt_val", 20,7, false, "浮动值" )))
					.addNode(new FieldNode("pref_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pref_flg", 1,0, false, "优惠标志" )))
					.addNode(new FieldNode("pref_val", new MsgField(ContentEnum.MessageType.INT.toString(), "pref_val", 12,7, false, "优惠值" )))
					.addNode(new FieldNode("bchmk_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "bchmk_int_rate", 12,7, false, "基准利率" )))
					.addNode(new FieldNode("cash_trfr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_trfr_flg", 1,0, false, "现转标志" )))
					.addNode(new FieldNode("chrg_ccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_ccy", 3,0, false, "收费币种" )))
					.addNode(new FieldNode("chrg_amt_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_amt_src", 1,0, false, "收费金额来源" )))
					.addNode(new FieldNode("change_ccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "change_ccy", 3,0, false, "找零币种" )))
					.addNode(new FieldNode("adv_draw_int_rate_sr", new MsgField(ContentEnum.MessageType.STRING.toString(), "adv_draw_int_rate_sr", 1,0, false, "提前支取利率来源" )))
					.addNode(new FieldNode("adv_draw_int_rate_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "adv_draw_int_rate_way", 1,0, false, "提前支取利率方式" )))
					.addNode(new FieldNode("adv_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "adv_int_rate", 12,7, false, "提前支取利率" )))
					.addNode(new FieldNode("adv_draw_int_flt_pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "adv_draw_int_flt_pcnt", 12,7, false, "提前支取利率浮动比例" )))
					.addNode(new FieldNode("adv_draw_int_flt_pnts", new MsgField(ContentEnum.MessageType.INT.toString(), "adv_draw_int_flt_pnts", 12,7, false, "提前支取利率浮动点数" )))
					.addNode(new ArrayNode("listnm02_list",false)
							.addNode(new FieldNode("rfer_nm_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_nm_01", 256,0, false, "推荐人名称" )))
							.addNode(new FieldNode("rfer_job_num_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_job_num_01", 30,0, false, "推荐人工号" )))
							.addNode(new FieldNode("rfer_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_type", 1,0, false, "推荐人类型" ))))
					.addNode(new ArrayNode("listnm03_list",false)
							.addNode(new FieldNode("hier_int_rate_dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "hier_int_rate_dept_prd", 6,0, false, "层次利率存期" )))
							.addNode(new FieldNode("exec_int_rate", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "exec_int_rate", 12,7, true, "执行利率" ))))
					.addNode(new FieldNode("adv_int_pymt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "adv_int_pymt_flg", 1,0, false, "预付息标志" )))
					.addNode(new FieldNode("asgn_dys", new MsgField(ContentEnum.MessageType.STRING.toString(), "asgn_dys", 10,0, false, "指定天数" )))
					.addNode(new FieldNode("int_pay_freq", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_pay_freq", 10,0, false, "随心存付息频率" )))
					.addNode(new FieldNode("matu_rnew_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_rnew_way", 1,0, false, "到期续存方式" )))
					.addNode(new FieldNode("cash_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_cust_acct_num", 40,0, false, "兑付账号" )))
					.addNode(new FieldNode("trfr_in_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_sub_acct_serl_num", 8,0, false, "转入子账户序号" )))
					.addNode(new FieldNode("int_trfr_in_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_trfr_in_acct_num", 40,0, false, "利息转入账号" )))
					.addNode(new FieldNode("int_trfr_in_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_trfr_in_sub_acct_serl_num", 8,0, false, "利息转入子账户序号" )))
					.addNode(new FieldNode("income_add_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "income_add_flg", 1,0, false, "是否允许收益增值" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P011000904_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("sbcrpn_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrpn_num", 64,0, false, "认购编号" )))
					.addNode(new FieldNode("cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_tp", 2,0, false, "客户类型" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
					.addNode(new FieldNode("issn_yr", new MsgField(ContentEnum.MessageType.STRING.toString(), "issn_yr", 4,0, false, "发行年度" )))
					.addNode(new FieldNode("issn_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "issn_prd", 4,0, false, "发行期次" )))
					.addNode(new FieldNode("prod_prd_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_prd_num", 50,0, false, "产品期次编号" )))
					.addNode(new FieldNode("prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_nm", 256,0, false, "产品名称" )))
					.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
					.addNode(new FieldNode("issn_prc", new MsgField(ContentEnum.MessageType.INT.toString(), "issn_prc", 18,2, false, "发行价格" )))
					.addNode(new FieldNode("sbcrpn_cps", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrpn_cps", 10,0, false, "认购份数" )))
					.addNode(new FieldNode("dnmn", new MsgField(ContentEnum.MessageType.INT.toString(), "dnmn", 18,2, false, "面额" )))
					.addNode(new FieldNode("sbcrpn_totl_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "sbcrpn_totl_amt", 18,2, false, "认购总金额" )))
					.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, false, "支付条件" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("acct_clasf", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf", 4,0, false, "账户分类" )))
					.addNode(new FieldNode("acct_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_attr", 10,0, false, "账户属性" )))
					.addNode(new FieldNode("unvsl_wthdg_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "unvsl_wthdg_scope", 1,0, false, "通兑范围" )))
					.addNode(new FieldNode("strt_int_caln_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_int_caln_dt", 8,0, false, "起息日期" )))
					.addNode(new FieldNode("matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_dt", 8,0, false, "到期日期" )))
					.addNode(new FieldNode("int_rate_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_code", 20,0, false, "利率代码" )))
					.addNode(new FieldNode("exec_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "exec_int_rate", 12,7, false, "执行利率" )))
					.addNode(new FieldNode("pymt_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cust_acct_num", 40,0, false, "付款客户账号" )))
					.addNode(new FieldNode("pymt_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_sub_acct_serl_num", 8,0, false, "付款子账户序号" )))
					.addNode(new FieldNode("pymt_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_nm", 256,0, false, "付款账户名称" )))
					.addNode(new FieldNode("pymt_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_num_tp", 1,0, false, "付款账号类型" )))
					.addNode(new FieldNode("pymt_acct_vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_vchr_catg", 4,0, false, "付款账户凭证种类" )))
					.addNode(new FieldNode("pymt_acct_vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_vchr_btch_num", 10,0, false, "付款账户凭证批号" )))
					.addNode(new FieldNode("pymt_acct_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_vchr_serl_num", 32,0, false, "付款账户凭证序号" )))
					.addNode(new FieldNode("docs_issue_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_issue_dt", 8,0, false, "证件签发日期" )))
					.addNode(new FieldNode("cntpr_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_cust_acct_num", 40,0, false, "对方客户账号" )))
					.addNode(new FieldNode("main_lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "main_lblty_acct_num", 40,0, false, "主负债账号" )))
					.addNode(new FieldNode("wait_write_off_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "wait_write_off_serl_num", 40,0, false, "待销账序号" )))
					.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

