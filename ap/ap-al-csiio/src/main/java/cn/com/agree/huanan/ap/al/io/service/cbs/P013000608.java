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
 * BASESVC.P013000608 账户信息查询.子账户明细信息查询 
 * P0130006.08 dp2280
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P013000608 extends EsbCoreChannelService {

	private static P013000608_I i = new P013000608_I();
	private static P013000608_O o = new P013000608_O();
	public P013000608() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013000608_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("acct_serl_num_is_null_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_serl_num_is_null_flg", 1,0, false, "账户序号为空标志" )))
					.addNode(new FieldNode("wthr_qry_virt_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_qry_virt_acct_flg", 1,0, false, "是否查询虚账户标志" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_cnt_num", 10,0, false, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_cnt_num", 10,0, false, "查询笔数" )))
					.addNode(new FieldNode("qry_cncl_acct_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_cncl_acct_acct_flg", 1,0, false, "是否查询销户账户标志" )))
					.addNode(new FieldNode("wthr_qry_rlvc_acct", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_qry_rlvc_acct", 1,0, false, "是否查询关联账户" )))
					.addNode(new FieldNode("dept_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_catg", 3,0, false, "存款种类" )))
					.addNode(new FieldNode("prod_term_dmd_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_term_dmd_acct_flg", 1,0, false, "产品定活标志" )))
					.addNode(new FieldNode("wthr_qry_fincl_acct", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_qry_fincl_acct", 1,0, false, "是否查询理财户" )))
					.addNode(new FieldNode("wthr_qry_subsd_int_acct", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_qry_subsd_int_acct", 1,0, false, "是否查询贴息户" )))
					.addNode(new FieldNode("wthr_qry_ovdf_acct", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_qry_ovdf_acct", 1,0, false, "是否查询透支户" )))
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

	public static class P013000608_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("listnm_list",false)
							.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
							.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
							.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号" )))
							.addNode(new FieldNode("acct_charic", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_charic", 4,0, false, "账户性质" )))
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
							.addNode(new FieldNode("detl_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "detl_serl_num", 10,0, false, "明细序号" )))
							.addNode(new FieldNode("acct_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_ste", 1,0, false, "账户状态" )))
							.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
							.addNode(new FieldNode("matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_dt", 8,0, false, "到期日期" )))
							.addNode(new FieldNode("open_acct_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_org", 12,0, false, "开户机构" )))
							.addNode(new FieldNode("cur_acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "cur_acct_bal", 18,2, false, "当前账户余额" )))
							.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
							.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品代码" )))
							.addNode(new FieldNode("prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_nm", 750,0, false, "产品名称" )))
							.addNode(new FieldNode("prod_blgd_obj", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_blgd_obj", 1,0, false, "产品所属对象" )))
							.addNode(new FieldNode("acct_clasf_code_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf_code_01", 10,0, false, "账户分类代码1" )))
							.addNode(new FieldNode("acct_clasf_code_02", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf_code_02", 10,0, false, "账户分类代码2" )))
							.addNode(new FieldNode("acct_clasf_code_03", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf_code_03", 10,0, false, "账户分类代码3" )))
							.addNode(new FieldNode("int_rate_bal_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_bal_flg", 1,0, false, "利率余额标志" )))
							.addNode(new FieldNode("int_caln_bal_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_caln_bal_flg", 1,0, false, "计息余额标志" )))
							.addNode(new FieldNode("lblty_prod_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_prod_tp", 1,0, false, "负债产品类型" )))
							.addNode(new FieldNode("bal_genl_ledger_sycrz_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "bal_genl_ledger_sycrz_flg", 1,0, false, "余额与总账同步标志" )))
							.addNode(new FieldNode("cpstn_prod_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpstn_prod_num", 10,0, false, "组合产品号" )))
							.addNode(new FieldNode("rfer_nm_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_nm_01", 256,0, false, "推荐人名称1" )))
							.addNode(new FieldNode("rfer_nm_02", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_nm_02", 256,0, false, "推荐人名称2" )))
							.addNode(new FieldNode("rfer_nm_03", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_nm_03", 256,0, false, "推荐人名称3" )))
							.addNode(new FieldNode("rfer_nm_04", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_nm_04", 256,0, false, "推荐人名称4" )))
							.addNode(new FieldNode("rfer_nm_05", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_nm_05", 256,0, false, "推荐人名称5" )))
							.addNode(new FieldNode("rfer_job_num_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_job_num_01", 10,0, false, "推荐人工号1" )))
							.addNode(new FieldNode("rfer_job_num_02", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_job_num_02", 10,0, false, "推荐人工号2" )))
							.addNode(new FieldNode("rfer_job_num_03", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_job_num_03", 10,0, false, "推荐人工号3" )))
							.addNode(new FieldNode("rfer_job_num_04", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_job_num_04", 10,0, false, "推荐人工号4" )))
							.addNode(new FieldNode("rfer_job_num_05", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_job_num_05", 10,0, false, "推荐人工号5" )))
							.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
							.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
							.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 32,0, false, "凭证序号" )))
							.addNode(new FieldNode("open_acct_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_dt", 8,0, false, "开户日期" )))
							.addNode(new FieldNode("dept_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_catg", 3,0, false, "存款种类" )))
							).addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_nm", 256,0, false, "客户账户名称" )))
					.addNode(new FieldNode("cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_tp", 2,0, false, "客户类型" )))
					.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, false, "支付条件" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("unvsl_wthdg_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "unvsl_wthdg_scope", 1,0, false, "通兑范围" )))
					.addNode(new FieldNode("rlvc_vchr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rlvc_vchr_flg", 1,0, false, "关联凭证标志" )))
					.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm", 256,0, false, "客户中文名" )))
					.addNode(new FieldNode("cust_engl_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_engl_nm", 120,0, false, "客户英文名" )))
					.addNode(new FieldNode("cust_acct_rlvc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_rlvc_flg", 1,0, false, "客户账户关联标志" )))
					.addNode(new FieldNode("secry_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "secry_flg", 1,0, false, "保密标志" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

