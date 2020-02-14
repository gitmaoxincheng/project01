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
 * BASESVC.P011000902 存款产品购买.结构性存款认购 
 * P0110009.02 dp2253
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P011000902 extends EsbCoreChannelService {

	private static P011000902_I i = new P011000902_I();
	private static P011000902_O o = new P011000902_O();
	public P011000902() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P011000902_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("sbcrpn_oprn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrpn_oprn_flg", 1,0, true, "认购操作标志" )))
					.addNode(new FieldNode("aptmt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "aptmt_num", 60,0, false, "预约编号" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, true, "客户号" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("prod_prd_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_prd_num", 50,0, true, "产品期次编号" )))
					.addNode(new FieldNode("prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_nm", 750,0, false, "产品名称" )))
					.addNode(new FieldNode("sbcrpn_totl_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "sbcrpn_totl_amt", 18,2, true, "认购总金额" )))
					.addNode(new FieldNode("rsdl_lmt", new MsgField(ContentEnum.MessageType.INT.toString(), "rsdl_lmt", 18,2, false, "剩余额度" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
					.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, false, "支付条件" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 300,0, false, "交易密码" )))
					.addNode(new FieldNode("unvsl_wthdg_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "unvsl_wthdg_scope", 1,0, false, "通兑范围" )))
					.addNode(new FieldNode("strt_int_caln_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_int_caln_dt", 8,0, false, "起息日期" )))
					.addNode(new FieldNode("matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_dt", 8,0, false, "到期日期" )))
					.addNode(new FieldNode("int_rate_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_code", 20,0, false, "利率代码" )))
					.addNode(new FieldNode("actl_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_int_rate", 12,7, false, "实际利率" )))
					.addNode(new FieldNode("pymt_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cust_acct_num", 40,0, true, "付款客户账号" )))
					.addNode(new FieldNode("pymt_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_sub_acct_serl_num", 8,0, false, "付款子账户序号" )))
					.addNode(new FieldNode("pymt_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_num_tp", 1,0, false, "付款账号类型" )))
					.addNode(new FieldNode("pymt_acct_pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_pymt_cond", 1,0, false, "付款账户支付条件" )))
					.addNode(new FieldNode("pymt_acct_txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_txn_pswd", 32,0, false, "付款账户交易密码" )))
					.addNode(new FieldNode("acct_clasf", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf", 4,0, false, "账户分类" )))
					.addNode(new FieldNode("acct_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_attr", 10,0, false, "账户属性" )))
					.addNode(new FieldNode("pymt_acct_vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_vchr_catg", 4,0, false, "付款账户凭证种类" )))
					.addNode(new FieldNode("pymt_acct_vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_vchr_btch_num", 10,0, false, "付款账户凭证批号" )))
					.addNode(new FieldNode("pymt_acct_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_vchr_serl_num", 32,0, false, "付款账户凭证序号" )))
					.addNode(new FieldNode("btch_real_tm_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "btch_real_tm_flg", 1,0, true, "批量实时标志" )))
					.addNode(new FieldNode("cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_tp", 2,0, false, "客户类型" )))
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 50,0, false, "产品代码" )))
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
					.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 32,0, false, "凭证序号" )))
					.addNode(new FieldNode("pymt_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_pswd", 300,0, false, "支付密码" )))
					.addNode(new FieldNode("docs_issue_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_issue_dt", 8,0, false, "证件签发日期" )))
					.addNode(new FieldNode("pymt_acct_vchr_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_vchr_dt", 8,0, false, "转出凭证出票日期" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P011000902_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("sbcrpn_oprn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrpn_oprn_flg", 1,0, false, "认购操作标志" )))
					.addNode(new FieldNode("sbcrpn_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrpn_num", 32,0, false, "认购编号" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("cust_risk_grd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_risk_grd", 2,0, false, "客户风险等级" )))
					.addNode(new FieldNode("aptmt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "aptmt_num", 60,0, false, "预约编号" )))
					.addNode(new FieldNode("prod_prd_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_prd_num", 50,0, false, "产品期次编号" )))
					.addNode(new FieldNode("prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_nm", 750,0, false, "产品名称" )))
					.addNode(new FieldNode("sbcrpn_cps", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrpn_cps", 10,0, false, "认购份数" )))
					.addNode(new FieldNode("sbcrpn_totl_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "sbcrpn_totl_amt", 18,2, false, "认购总金额" )))
					.addNode(new FieldNode("pymt_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cust_acct_num", 40,0, false, "付款客户账号" )))
					.addNode(new FieldNode("actl_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_int_rate", 12,7, false, "实际利率" )))
					.addNode(new FieldNode("pymt_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_sub_acct_serl_num", 8,0, false, "付款子账户序号" )))
					.addNode(new FieldNode("txn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_tlr", 10,0, false, "交易柜员" )))
					.addNode(new FieldNode("txn_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_org", 12,0, false, "交易机构" )))
					.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期" )))
					.addNode(new FieldNode("txn_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_tm", 10,0, false, "交易时间" )))
					.addNode(new FieldNode("tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_rung_num", 32,0, false, "柜员流水号" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("min_expcd_rate_ret", new MsgField(ContentEnum.MessageType.INT.toString(), "min_expcd_rate_ret", 12,7, false, "最低预期收益率" )))
					.addNode(new FieldNode("max_expcd_rate_ret", new MsgField(ContentEnum.MessageType.INT.toString(), "max_expcd_rate_ret", 12,7, false, "最高预期收益率" )))
					.addNode(new FieldNode("strt_int_caln_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_int_caln_dt", 8,0, false, "起息日期" )))
					.addNode(new FieldNode("matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_dt", 8,0, false, "到期日期" )))
					.addNode(new FieldNode("real_tm_btch_hnr_cheq_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "real_tm_btch_hnr_cheq_flg", 1,0, false, "实时批量兑付标志" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

