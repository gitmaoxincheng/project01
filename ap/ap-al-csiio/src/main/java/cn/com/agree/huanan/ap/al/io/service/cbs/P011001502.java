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
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;

/**
 * BASESVC.P011001502 同名账户互转.卡内转开定期 
 * P0110015.02 dp2134
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P011001502 extends EsbCoreChannelService {

	private static P011001502_I i = new P011001502_I();
	private static P011001502_O o = new P011001502_O();
	public P011001502() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P011001502_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账号" )))
					.addNode(new FieldNode("pswd_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_catg", 2,0, false, "密码种类" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("trfr_out_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_sub_acct_serl_num", 8,0, false, "转出子账户序号" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品代码" )))
					.addNode(new FieldNode("acct_clasf", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf", 4,0, false, "账户分类" )))
					.addNode(new FieldNode("acct_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_attr", 10,0, false, "账户属性" )))
					.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, true, "支付条件" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 32,0, false, "交易密码" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("newly_open_acct_prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "newly_open_acct_prod_code", 60,0, false, "新开账户产品代码" )))
					.addNode(new FieldNode("prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_nm", 750,0, false, "产品名称" )))
					.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, true, "交易金额" )))
					.addNode(new FieldNode("newly_open_acct_dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "newly_open_acct_dept_prd", 6,0, true, "新开账户存期" )))
					.addNode(new FieldNode("rdept_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_way", 1,0, true, "转存方式" )))
					.addNode(new FieldNode("rdept_dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_dept_prd", 6,0, false, "转存存期" )))
					.addNode(new FieldNode("rnew_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "rnew_amt", 18,2, false, "续存金额" )))
					.addNode(new FieldNode("prcpl_int_in_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcpl_int_in_cust_acct_num", 40,0, false, "本金/利息转入账号" )))
					.addNode(new FieldNode("draw_intrv", new MsgField(ContentEnum.MessageType.STRING.toString(), "draw_intrv", 8,0, false, "支取间隔" )))
					.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
					.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
					.addNode(new FieldNode("slbl_prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "slbl_prod_code", 32,0, false, "可售产品代码" )))
					.addNode(new FieldNode("slbl_prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "slbl_prod_nm", 750,0, false, "可售产品名称" )))
					.addNode(new ArrayNode("listnm02_list",false)
							.addNode(new FieldNode("rfer_nm_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_nm_01", 256,0, false, "推荐人名称" )))
							.addNode(new FieldNode("rfer_job_num_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_job_num_01", 10,0, false, "推荐人工号" )))
							.addNode(new FieldNode("rfer_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_type", 1,0, false, "推荐人类型" )))
					)
			);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P011001502_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("acct_clasf", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf", 4,0, false, "账户分类" )))
					.addNode(new FieldNode("acct_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_attr", 10,0, false, "账户属性" )))
					.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
					.addNode(new FieldNode("prcpl_int_in_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcpl_int_in_cust_acct_num", 40,0, false, "本金/利息转入账号" )))
					.addNode(new FieldNode("newly_open_acct_prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "newly_open_acct_prod_code", 60,0, false, "新开账户产品代码" )))
					.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
					.addNode(new FieldNode("rdept_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_way", 1,0, false, "转存方式" )))
					.addNode(new FieldNode("rdept_dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_dept_prd", 6,0, false, "转存存期" )))
					.addNode(new FieldNode("rnew_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "rnew_amt", 18,2, false, "续存金额" )))
					.addNode(new FieldNode("draw_intrv", new MsgField(ContentEnum.MessageType.STRING.toString(), "draw_intrv", 8,0, false, "支取间隔" )))
					.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
					.addNode(new FieldNode("new_prod_comt", new MsgField(ContentEnum.MessageType.STRING.toString(), "new_prod_comt", 300,0, false, "新产品说明" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

