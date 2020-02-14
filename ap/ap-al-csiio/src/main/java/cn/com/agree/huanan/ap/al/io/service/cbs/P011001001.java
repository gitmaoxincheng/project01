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
 * BASESVC.P011001001 存款产品赎回.大额存单兑付 
 * P0110010.01 dp2266
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P011001001 extends EsbCoreChannelService {

	private static P011001001_I i = new P011001001_I();
	private static P011001001_O o = new P011001001_O();
	public P011001001() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P011001001_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, true, "子账户序号" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, true, "交易金额" )))
					.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, true, "支付条件" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 32,0, false, "交易密码" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("cptl_drcn", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptl_drcn", 1,0, true, "资金去向" )))
					.addNode(new FieldNode("sbcrpn_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrpn_num", 32,0, false, "认购编号" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
					.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
					.addNode(new FieldNode("rcev_mny_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcev_mny_cust_acct_num", 40,0, false, "收款客户账号" )))
					.addNode(new FieldNode("paye_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "paye_sub_acct_serl_num", 8,0, false, "收款人子账户序号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P011001001_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
					.addNode(new FieldNode("hnr_cheq_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "hnr_cheq_tp", 1,0, false, "兑付类型" )))
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品编号" )))
					.addNode(new FieldNode("hnr_cheq_svc_fee", new MsgField(ContentEnum.MessageType.INT.toString(), "hnr_cheq_svc_fee", 18,2, false, "兑付手续费" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "acct_bal", 18,2, false, "账户余额" )))
					.addNode(new FieldNode("wait_write_off_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "wait_write_off_serl_num", 40,0, false, "待销账序号" )))
					.addNode(new FieldNode("actl_draw_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_draw_amt", 18,2, false, "实际支取金额" )))
					.addNode(new FieldNode("rcev_mny_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcev_mny_cust_acct_num", 40,0, false, "收款客户账号" )))
					.addNode(new FieldNode("hnr_cheq_int", new MsgField(ContentEnum.MessageType.INT.toString(), "hnr_cheq_int", 18,2, false, "兑付利息" )))
					.addNode(new FieldNode("hnr_cheq_int_tax", new MsgField(ContentEnum.MessageType.INT.toString(), "hnr_cheq_int_tax", 18,2, false, "兑付利息税" )))
					.addNode(new FieldNode("paye_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "paye_nm", 256,0, false, "收款人名称" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
					.addNode(new FieldNode("prod_prd_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_prd_num", 50,0, false, "产品期次编号" )))
					.addNode(new FieldNode("prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_nm", 750,0, false, "产品名称" )))
					.addNode(new FieldNode("issn_yr", new MsgField(ContentEnum.MessageType.STRING.toString(), "issn_yr", 4,0, false, "发行年度" )))
					.addNode(new FieldNode("issn_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "issn_prd", 4,0, false, "发行期次" )))
					.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
					.addNode(new FieldNode("int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate", 12,7, false, "利率" )))
					.addNode(new FieldNode("trfr_in_party_fincl_org_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_party_fincl_org_nm", 256,0, false, "转入方金融机构名称" )))
					.addNode(new ArrayNode("lstnm01_list",false)
					.addNode(new FieldNode("strt_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_dt_8", 8,0, false, "起始日期" )))
					.addNode(new FieldNode("end_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_dt", 8,0, false, "终止日期" )))
					.addNode(new FieldNode("flt_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "flt_tp", 1,0, false, "浮动类型" )))
					.addNode(new FieldNode("int_rate_flt_pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate_flt_pcnt", 12,7, false, "利率浮动比例" )))
					.addNode(new FieldNode("int_rate_flt_pnts", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate_flt_pnts", 12,7, false, "利率浮动点数" )))
					.addNode(new FieldNode("bchmk_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "bchmk_int_rate", 12,7, false, "基准利率" )))
					.addNode(new FieldNode("exec_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "exec_int_rate", 12,7, false, "执行利率" )))
					.addNode(new FieldNode("acd_int_207", new MsgField(ContentEnum.MessageType.INT.toString(), "acd_int_207", 18,2, false, "应计利息" )))
					.addNode(new FieldNode("actl_int_occr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_int_occr_amt", 18,2, false, "实际利息发生额" )))
					.addNode(new FieldNode("acmlv_num", new MsgField(ContentEnum.MessageType.INT.toString(), "acmlv_num", 18,2, false, "积数" )))
					.addNode(new FieldNode("acrl_tax_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "acrl_tax_rate", 8,6, false, "计提税率" )))
					.addNode(new FieldNode("int_tax_occr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "int_tax_occr_amt", 18,2, false, "利息税发生额" )))
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

