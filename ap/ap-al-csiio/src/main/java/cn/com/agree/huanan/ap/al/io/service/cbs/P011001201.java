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
 * BASESVC.P011001201 对私取款.个人现金取款 P0110012.01 ACCT0046 0005 新核心系统
 * 
 * @author HYS
 */
@Component
public class P011001201 extends EsbCoreChannelService {
	/*
	 * 
	 * INSERT INTO CSIS_ATOMIC_SERVICE (AT_SVCID, AT_SVCCODE, AT_SVCNAME,
	 * AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME,
	 * SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES
	 * ('BASESVCP011001201', 'BASESVC', '新核心系统', 'P011001201', '对私取款', 'ESB',
	 * 'ESB_cbs系统', 'P0110012', '个人现金取款', '01','ACCT0046' ,'对私取款', '1', '0',
	 * '对私取款');
	 * 
	 */
	private static P011001201_I i = new P011001201_I();
	private static P011001201_O o = new P011001201_O();

	public P011001201() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P011001201_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true)
					.addNode(new FieldNode("cust_acct_num",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40, 0, true,
									"客户账号")))
					.addNode(new FieldNode("sub_acct_serl_num",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8, 0, true,
									"子账户序号")))
					.addNode(new FieldNode("txn_amt",
							new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "txn_amt", 18, 2, true, "交易金额")))
					.addNode(new FieldNode("txn_pswd",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 32, 0, false, "交易密码")))
					.addNode(new FieldNode("docs_catg",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3, 0, false, "证件种类")))
					.addNode(new FieldNode("docs_num",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30, 0, false, "证件号码")))
					.addNode(new FieldNode("pymt_pswd",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_pswd", 32, 0, false, "支付密码")))
					.addNode(new FieldNode("pymt_vchr_dt",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_vchr_dt", 8, 0, false,
									"支付凭证日期")))
					.addNode(new FieldNode("new_vchr_catg",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "new_vchr_catg", 4, 0, false,
									"新凭证种类")))
					.addNode(new FieldNode("new_vchr_btch_num",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "new_vchr_btch_num", 10, 0, false,
									"新凭证批号")))
					.addNode(new FieldNode("new_vchr_serl_num",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "new_vchr_serl_num", 32, 0, false,
									"新凭证序号")))
					.addNode(new FieldNode("cash_item_code",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_item_code", 12, 0, false,
									"现金项目代码")))
					.addNode(new FieldNode("abst_code",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10, 0, false, "摘要代码")))
					.addNode(new FieldNode("abst_dsc",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225, 0, false, "摘要描述")))
					.addNode(new FieldNode("remks",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "remks", 300, 0, false, "备注")))
					.addNode(new FieldNode("ntnlt_area",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "ntnlt_area", 3, 0, false,
									"国家/地区")))
					.addNode(new FieldNode("main_group_status",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "main_group_status", 3, 0, false,
									"主体分类状态")))
					.addNode(new FieldNode("per_explain_flg",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "per_explain_flg", 1, 0, false,
									"是否是待说明个人")))
					.addNode(new FieldNode("today_dep_amount",
							new MsgField(ContentEnum.MessageType.INT.toString(), "today_dep_amount", 18, 2, false,
									"当日已存入金额（折美元）")))
					.addNode(new FieldNode("tyear_dep_amount",
							new MsgField(ContentEnum.MessageType.INT.toString(), "tyear_dep_amount", 18, 2, false,
									"当年已存入金额（折美元）")))
					.addNode(new FieldNode("add_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(),
							"add_docs_num", 30, 0, false, "补充证件号码"))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P011001201_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode
					.addStructNode(new StructNode("APPBody", true)
							.addNode(new FieldNode("cust_num",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32, 0, false,
											"客户号")))
							.addNode(new FieldNode("cust_acct_num",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40, 0,
											false, "客户账号")))
							.addNode(new FieldNode("cust_acct_num_tp",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1, 0,
											false, "客户账号类型")))
							.addNode(new FieldNode("sub_acct_serl_num",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8, 0,
											false, "子账户序号")))
							.addNode(new FieldNode("ccy_code_num",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3, 0, false,
											"货币代号")))
							.addNode(new FieldNode("acct_cash_rmtc_flg",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1, 0,
											false, "账户钞汇标志")))
							.addNode(new FieldNode("acct_nm",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256, 0, false,
											"账户名称")))
							.addNode(new FieldNode("dept_prd",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6, 0, false,
											"存期")))
							.addNode(new FieldNode("txn_amt",
									new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18, 2, false,
											"交易金额")))
							.addNode(new FieldNode("acct_bal",
									new MsgField(ContentEnum.MessageType.INT.toString(), "acct_bal", 18, 2, false,
											"账户余额")))
							.addNode(new FieldNode("int_rate",
									new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate", 12, 7, false,
											"利率")))
							.addNode(new FieldNode("acrl_int",
									new MsgField(ContentEnum.MessageType.INT.toString(), "acrl_int", 18, 2, false,
											"计提利息")))
							.addNode(new FieldNode("int_tax_rate",
									new MsgField(ContentEnum.MessageType.INT.toString(), "int_tax_rate", 12, 7, false,
											"利息税税率")))
							.addNode(new FieldNode("int_tax",
									new MsgField(ContentEnum.MessageType.INT.toString(), "int_tax", 18, 2, false,
											"利息税")))
							.addNode(new FieldNode("paybl_revnu",
									new MsgField(ContentEnum.MessageType.INT.toString(), "paybl_revnu", 18, 2, false,
											"应缴税金")))
							.addNode(new FieldNode("pnly_int_amt",
									new MsgField(ContentEnum.MessageType.INT.toString(), "pnly_int_amt", 18, 2, false,
											"罚息金额")))
							.addNode(new FieldNode("hnr_cheq_amt",
									new MsgField(ContentEnum.MessageType.INT.toString(), "hnr_cheq_amt", 18, 2, false,
											"兑付金额")))
							.addNode(new FieldNode("txn_exch_rate",
									new MsgField(ContentEnum.MessageType.INT.toString(), "txn_exch_rate", 20, 7, false,
											"交易汇率")))
							.addNode(new FieldNode("mrcht_chrg_amt",
									new MsgField(ContentEnum.MessageType.INT.toString(), "mrcht_chrg_amt", 18, 2, false,
											"商户收费金额")))
							.addNode(new FieldNode("change_amt",
									new MsgField(ContentEnum.MessageType.INT.toString(), "change_amt", 18, 2, false,
											"找零金额")))
							.addNode(new FieldNode("prt_row_num",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "prt_row_num", 10, 0, false,
											"打印行数")))
							.addNode(new FieldNode("lblty_acct_num",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40, 0,
											false, "负债账号")))
							.addNode(new FieldNode("actl_draw_amt",
									new MsgField(ContentEnum.MessageType.INT.toString(), "actl_draw_amt", 18, 2, false,
											"实际支取金额")))
							.addNode(new FieldNode("change_ccy",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "change_ccy", 3, 0, false,
											"找零币种")))
							.addNode(new FieldNode("remks", new MsgField(ContentEnum.MessageType.STRING.toString(),
									"remks", 300, 0, false, "备注"))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
