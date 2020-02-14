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
 * BASESVC.P013000609 账户信息查询.大额存单账户信息查询 
 * P0130006.09 dp2275
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P013000609 extends EsbCoreChannelService {

	private static P013000609_I i = new P013000609_I();
	private static P013000609_O o = new P013000609_O();
	public P013000609() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013000609_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("open_acct_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_org", 12,0, false, "开户机构" )))
					.addNode(new FieldNode("qry_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_tp", 1,0, false, "查询类型" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("sbcrpn_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrpn_num", 32,0, false, "认购编号" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品编号" )))
					.addNode(new FieldNode("spec_dept_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "spec_dept_ste", 1,0, false, "特殊存款状态" )))
					.addNode(new FieldNode("strt_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_dt_8", 8,0, false, "起始日期" )))
					.addNode(new FieldNode("end_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_dt", 8,0, false, "终止日期" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_cnt_num", 10,0, true, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_cnt_num", 10,0, true, "查询笔数" )))
					.addNode(new FieldNode("dept_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_catg", 3,0, true, "存款种类" )))
					.addNode(new FieldNode("pswd_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_catg", 2,0, false, "密码种类" )))
					.addNode(new FieldNode("qry_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_pswd", 32,0, false, "查询密码" )))
					.addNode(new FieldNode("prod_prd_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_prd_num", 50,0, false, "产品期次编号" )))
					.addNode(new FieldNode("pymt_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cust_acct_num", 40,0, false, "付款客户账号" )))
					.addNode(new FieldNode("pymt_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_sub_acct_serl_num", 8,0, false, "付款子账户序号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013000609_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("lstDesQueryOut_list",false)
							.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
							.addNode(new FieldNode("sbcrpn_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrpn_num", 32,0, false, "认购编号" )))
							.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
							.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
							.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
							.addNode(new FieldNode("pymt_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cust_acct_num", 40,0, false, "付款客户账号" )))
							.addNode(new FieldNode("pymt_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_sub_acct_serl_num", 8,0, false, "付款子账户序号" )))
							.addNode(new FieldNode("pymt_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_num_tp", 1,0, false, "付款账号类型" )))
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品编号" )))
							.addNode(new FieldNode("prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_nm", 750,0, false, "产品名称" )))
							.addNode(new FieldNode("issn_yr", new MsgField(ContentEnum.MessageType.STRING.toString(), "issn_yr", 4,0, false, "发行年度" )))
							.addNode(new FieldNode("issn_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "issn_prd", 4,0, false, "发行期次" )))
							.addNode(new FieldNode("strt_int_caln_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_int_caln_dt", 8,0, false, "起息日期" )))
							.addNode(new FieldNode("matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_dt", 8,0, false, "到期日期" )))
							.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
							.addNode(new FieldNode("dnmn", new MsgField(ContentEnum.MessageType.INT.toString(), "dnmn", 18,2, false, "面额" )))
							.addNode(new FieldNode("sbcrpn_cps", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrpn_cps", 10,0, false, "认购份数" )))
							.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("txn_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_tm", 25,0, false, "交易时间" )))
							.addNode(new FieldNode("open_acct_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_org", 12,0, false, "开户机构" )))
							.addNode(new FieldNode("int_rate_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_code", 20,0, false, "利率代码" )))
							.addNode(new FieldNode("actl_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_int_rate", 12,7, false, "实际利率" )))
							.addNode(new FieldNode("open_acct_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "open_acct_amt", 18,2, false, "开户金额" )))
							.addNode(new FieldNode("acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "acct_bal", 18,2, false, "账户余额" )))
							.addNode(new FieldNode("asmt_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "asmt_cnt", 10,0, false, "转让次数" )))
							.addNode(new FieldNode("acmld_int", new MsgField(ContentEnum.MessageType.INT.toString(), "acmld_int", 18,2, false, "累计利息" )))
							.addNode(new FieldNode("asmt_acmld_svc_fee", new MsgField(ContentEnum.MessageType.INT.toString(), "asmt_acmld_svc_fee", 18,2, false, "转让累计手续费" )))
							.addNode(new FieldNode("wthr_alrdy_pleg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_alrdy_pleg", 1,0, false, "是否已质押" )))
							.addNode(new FieldNode("wthr_alrdy_rdmpn", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_alrdy_rdmpn", 1,0, false, "是否已赎回" )))
							.addNode(new FieldNode("wthr_alrdy_adv_hnr_cheq", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_alrdy_adv_hnr_cheq", 1,0, false, "是否已提前兑付" )))
							.addNode(new FieldNode("frz_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "frz_amt", 18,2, false, "冻结金额" )))
							.addNode(new FieldNode("unfrz_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "unfrz_amt", 18,2, false, "解冻金额" )))
							.addNode(new FieldNode("mntnc_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_dt", 8,0, false, "维护日期" )))
							.addNode(new FieldNode("mntnc_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_tlr", 10,0, false, "维护柜员" )))
							.addNode(new FieldNode("prod_prd_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_prd_num", 50,0, false, "产品期次编号" )))
							.addNode(new FieldNode("min_expcd_rate_ret", new MsgField(ContentEnum.MessageType.INT.toString(), "min_expcd_rate_ret", 12,7, false, "最低预期收益率" )))
							.addNode(new FieldNode("max_expcd_rate_ret", new MsgField(ContentEnum.MessageType.INT.toString(), "max_expcd_rate_ret", 12,7, false, "最高预期收益率" )))
							.addNode(new FieldNode("adv_cncl_acct_rate_ret", new MsgField(ContentEnum.MessageType.INT.toString(), "adv_cncl_acct_rate_ret", 12,7, false, "提前销户收益率" )))
							.addNode(new FieldNode("actl_rate_ret", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_rate_ret", 12,7, false, "实际收益率" )))
							.addNode(new FieldNode("real_tm_btch_hnr_cheq_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "real_tm_btch_hnr_cheq_flg", 1,0, false, "实时批量兑付标志" )))
							.addNode(new FieldNode("prd_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "prd_ste", 1,0, false, "期次状态" )))
							.addNode(new FieldNode("cust_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_nm", 256,0, false, "客户账户名称" )))
							.addNode(new FieldNode("athrzn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "athrzn_tlr", 10,0, false, "授权柜员" )))
							.addNode(new FieldNode("strt_int_caln_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_int_caln_way", 1,0, false, "起息方式" )))
							.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
							.addNode(new FieldNode("due_pay_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "due_pay_num", 40,0, false, "到期兑付账号" )))
							.addNode(new FieldNode("fincl_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "fincl_acct_num", 40,0, false, "期次产品负债账号" )))
							.addNode(new FieldNode("totl_lmt", new MsgField(ContentEnum.MessageType.INT.toString(), "totl_lmt", 18,2, false, "期次总额度" )))
							.addNode(new FieldNode("spec_dept_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "spec_dept_ste", 1,0, false, "特殊存款状态" )))
							.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
							.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm", 256,0, false, "客户中文名称" )))
							.addNode(new FieldNode("raise_beg_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "raise_beg_dt", 8,0, false, "募集开始日期" )))
							.addNode(new FieldNode("raise_end_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "raise_end_dt", 8,0, false, "募集结束日期" )))
							.addNode(new FieldNode("sbcrpn_strtg_pnt_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "sbcrpn_strtg_pnt_amt", 18,2, false, "认购起点金额" )))
							.addNode(new FieldNode("sbcrpn_max_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "sbcrpn_max_amt", 18,2, false, "认购最大金额" )))
							.addNode(new FieldNode("cust_risk_grd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_risk_grd", 2,0, false, "客户风险等级" )))
							.addNode(new FieldNode("wthr_record_and_video_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_record_and_video_flg", 1,0, false, "是否录音录像标志" )))
							.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
							.addNode(new FieldNode("pymt_cust_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cust_acct_nm", 256,0, false, "付款客户账号名称" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

