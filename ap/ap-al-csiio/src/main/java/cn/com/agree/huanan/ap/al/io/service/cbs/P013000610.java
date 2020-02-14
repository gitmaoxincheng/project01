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
 * BASESVC.P013000610 账户信息查询.客户主账号-子账号互查 
 * P0130006.10 dp2021
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P013000610 extends EsbCoreChannelService {

	private static P013000610_I i = new P013000610_I();
	private static P013000610_O o = new P013000610_O();
	public P013000610() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013000610_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("qry_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_tp", 1,0, false, "查询类型" )))
					.addNode(new FieldNode("qry_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_scope", 1,0, false, "查询范围" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号" )))
					.addNode(new FieldNode("prod_term_dmd_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_term_dmd_acct_flg", 1,0, false, "产品定活标志" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("dept_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_catg", 3,0, false, "存款种类" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "币种" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("acct_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_ste", 1,0, false, "账户状态" )))
					.addNode(new FieldNode("qry_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_pswd", 32,0, false, "查询密码" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_cnt_num", 10,0, true, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_cnt_num", 10,0, true, "查询笔数" )))
					.addNode(new FieldNode("wthr_prt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_prt_flg", 1,0, false, "打印标志" )))
					.addNode(new FieldNode("org_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "org_code", 12,0, false, "机构代码" )))
					.addNode(new FieldNode("pswd_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_catg", 2,0, false, "密码种类" )))
					.addNode(new FieldNode("wthr_qry_rlvc_acct", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_qry_rlvc_acct", 1,0, false, "是否查询关联账户" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013000610_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_nm", 256,0, false, "客户账户名称" )))
					.addNode(new ArrayNode("lstacctinfo_list",false)
							.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
							.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
							.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号" )))
							.addNode(new FieldNode("prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_nm", 750,0, false, "产品名称" )))
							.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
							.addNode(new FieldNode("acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "acct_bal", 18,2, false, "账户余额" )))
							.addNode(new FieldNode("aval_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "aval_bal", 18,2, false, "可用余额" )))
							.addNode(new FieldNode("cur_acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "cur_acct_bal", 18,2, false, "当前账户余额" )))
							.addNode(new FieldNode("acct_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_ste", 1,0, false, "账户状态" )))
							.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
							.addNode(new FieldNode("strt_int_caln_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_int_caln_dt", 8,0, false, "起息日期" )))
							.addNode(new FieldNode("matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_dt", 8,0, false, "到期日期" )))
							.addNode(new FieldNode("open_acct_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_org", 12,0, false, "账户开户机构" )))
							.addNode(new FieldNode("exec_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "exec_int_rate", 12,7, false, "执行利率" )))
							.addNode(new FieldNode("bal_lately_upd_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "bal_lately_upd_dt", 8,0, false, "余额最近更新日期" )))
							.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品代码" )))
							.addNode(new FieldNode("dept_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_catg", 3,0, false, "存款种类" )))
							.addNode(new FieldNode("rlvc_vchr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rlvc_vchr_flg", 1,0, false, "关联凭证标志" )))
							.addNode(new FieldNode("open_acct_tlr_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_tlr_num", 10,0, false, "开户柜员号" )))
							.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
							.addNode(new FieldNode("bal_genl_ledger_sycrz_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "bal_genl_ledger_sycrz_flg", 1,0, false, "余额与总账同步标志" )))
							.addNode(new FieldNode("open_acct_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_dt", 8,0, false, "开户日期" )))
							.addNode(new FieldNode("aval_lmt", new MsgField(ContentEnum.MessageType.INT.toString(), "aval_lmt", 18,2, false, "可用额度" )))
							.addNode(new FieldNode("open_ver_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_ver_type", 1,0, false, "开户验证方式" )))
							.addNode(new FieldNode("no_anul_fee_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "no_anul_fee_flg", 1,0, false, "免年费标志" )))
							.addNode(new FieldNode("with_wtht_psbk_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "with_wtht_psbk_flg", 10,0, false, "有无折标志" )))
							.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
							.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
							.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 32,0, false, "凭证序号" )))
							.addNode(new FieldNode("std_int_caln_meth", new MsgField(ContentEnum.MessageType.STRING.toString(), "std_int_caln_meth", 2,0, false, "标准计息方法" )))
							.addNode(new FieldNode("trsry_cash_mgmt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trsry_cash_mgmt_num", 60,0, false, "国库现金管理编号" )))
							.addNode(new FieldNode("trsry_cash_mgmt_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "trsry_cash_mgmt_nm", 256,0, false, "国库现金管理名称" )))
							.addNode(new FieldNode("trfr_out_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_acct_num", 40,0, false, "转出账号" )))
							).addNode(new FieldNode("qry_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_scope", 1,0, false, "查询范围" )))
					.addNode(new FieldNode("totl_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "totl_cnt_num", 10,0, false, "总笔数" )))
					.addNode(new FieldNode("rept_route", new MsgField(ContentEnum.MessageType.STRING.toString(), "rept_route", 750,0, false, "报表路径" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

