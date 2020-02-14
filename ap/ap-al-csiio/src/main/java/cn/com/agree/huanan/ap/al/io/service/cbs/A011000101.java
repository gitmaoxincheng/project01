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
@Component
public class A011000101 extends EsbCoreChannelService {

	private static A011000101_I i = new A011000101_I();
	private static A011000101_O o = new A011000101_O();
	public A011000101() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class A011000101_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("txn_ctrl_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_ctrl_flg", 35,0, true, "交易控制标志" )))
					.addNode(new FieldNode("trfr_out_acct_num_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_acct_num_src", 1,0, true, "转出账号来源" )))
					.addNode(new FieldNode("wait_write_off_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "wait_write_off_serl_num", 40,0, false, "待销账序号" )))
					.addNode(new FieldNode("trfr_out_acct_num_org_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_acct_num_org_src", 1,0, false, "转出账号机构来源" )))
					.addNode(new FieldNode("trfr_out_acct_num_org_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_acct_num_org_num", 12,0, false, "转出账号机构号" )))
					.addNode(new FieldNode("trfr_out_busi_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_busi_code", 30,0, false, "转出业务编码" )))
					.addNode(new FieldNode("trfr_out_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_acct_num_tp", 1,0, false, "转出账号类型" )))
					.addNode(new FieldNode("trfr_out_cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_cust_tp", 2,0, false, "转出客户类型" )))
					.addNode(new FieldNode("trfr_out_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_cust_acct_num", 40,0, false, "转出客户账号" )))
					.addNode(new FieldNode("trfr_out_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_sub_acct_serl_num",8,0, false, "转出子账户序号" )))
					.addNode(new FieldNode("trfr_out_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_acct_nm", 256,0, false, "转出账户名称" )))
					.addNode(new FieldNode("trfr_out_party_fincl_org_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_party_fincl_org_tp", 2,0, false, "面转出方金融机构类型" )))
					.addNode(new FieldNode("trfr_out_party_fincl_org_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_party_fincl_org_code", 12,0, false, "转出方金融机构代码" )))
					.addNode(new FieldNode("trfr_out_party_fincl_org_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_party_fincl_org_nm", 300,0, false, "转出方金融机构名称" )))
					.addNode(new FieldNode("trfr_in_acct_num_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_acct_num_src", 1,0, true, "转入账号来源" )))
					.addNode(new FieldNode("trfr_in_acct_num_org_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_acct_num_org_src", 1,0, false, "转入账号机构来源" )))
					.addNode(new FieldNode("trfr_in_acct_num_org_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_acct_num_org_num", 30,0, false, "转入账号机构号" )))
					.addNode(new FieldNode("trfr_in_busi_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_busi_code", 30,0, false, "转入业务编码" )))
					.addNode(new FieldNode("trfr_in_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_acct_num_tp", 1,0, false, "转入账号类型" )))
					.addNode(new FieldNode("trfr_in_cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_cust_tp", 2,0, false, "转入客户类型" )))
					.addNode(new FieldNode("trfr_in_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_cust_acct_num", 40,0, false, "转入客户账号" )))
					.addNode(new FieldNode("trfr_in_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_sub_acct_serl_num", 8,0, false, "转入子账户序号" )))
					.addNode(new FieldNode("trfr_in_acct_cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_acct_cust_num", 32,0, false, "转入账户客户号" )))
					.addNode(new FieldNode("trfr_in_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_acct_nm", 256,0, false, "转入账户名称" )))
					.addNode(new FieldNode("trfr_in_party_fincl_org_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_party_fincl_org_tp", 2,0, false, "转入方金融机构类型" )))
					.addNode(new FieldNode("trfr_in_cntpr_fincl_org_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_cntpr_fincl_org_code", 12,0, false, "转入对方金融机构代码" )))
					.addNode(new FieldNode("trfr_in_party_fincl_org_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_party_fincl_org_nm", 300,0, false, "转入方金融机构名称" )))
					.addNode(new FieldNode("pswd_vrfy_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_vrfy_way", 1,0, false, "密码校验方式" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 512,0, false, "交易密码" )))
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("vchr_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_num", 32,0, false, "凭证号码" )))
					.addNode(new FieldNode("bill_rdrd_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "bill_rdrd_dt", 8,0, false, "出票日期" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, true, "货币代号" )))
					.addNode(new FieldNode("cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_rmtc_flg", 1,0, false, "钞汇标志" )))
					.addNode(new FieldNode("txn_amt",  new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "txn_amt", 18,2, true, "交易金额" )))
					//.addNode(new FieldNode("spare_amt", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "spare_amt", 18,2, false, "备用金额" )))
					.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
					.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
					.addNode(new FieldNode("ctrl_dectrl_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctrl_dectrl_flg", 1,0, false, "控制解控标志" )))
					.addNode(new FieldNode("ctrl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctrl_num", 32,0, false, "控制编号" )))
					.addNode(new FieldNode("ctrl_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctrl_catg", 2,0, false, "控制种类" )))
					.addNode(new FieldNode("frz_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "frz_scope", 1,0, false, "冻结范围" )))
					.addNode(new FieldNode("need_ctrl_dectrl_amt", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "need_ctrl_dectrl_amt", 18,2, false, "需控制/解控金额" )))
					.addNode(new FieldNode("ctrl_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctrl_reason", 300,0, false, "控制原因" )))
					.addNode(new FieldNode("auto_dectrl_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "auto_dectrl_dt", 8,0, false, "自动解控日期" )))
					.addNode(new FieldNode("cash_item_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_item_code", 12,0, false, "现金项目代码" )))
					.addNode(new FieldNode("chrg_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_serl_num", 40,0, false, "收费序号" )))
					.addNode(new ArrayNode("lstFeeIn_list",false)
							.addNode(new FieldNode("fee_ctrl_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_ctrl_flg",	35	,0,false, "费用控制标志")))
							.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num",40,0,false, "客户账号")))
							.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num",8,	0,false	, "子账户序号")))
							.addNode(new FieldNode("chrg_ccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_ccy",	3,0,false, "收费币种")))
							.addNode(new FieldNode("chrg_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_code",	8,0,false, "收费代码")))
							.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "txn_amt", 18,2,false,  "交易金额")))
							.addNode(new FieldNode("rcvbl_fee", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "rcvbl_fee",18,2,false, "应收费用")))
							.addNode(new FieldNode("fee_acctg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_acctg_org",12,	0,false	,"费用记账机构")))
							.addNode(new FieldNode("busi_rfrc_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_rfrc_num",32,0,false, "业务参考号	")))
							.addNode(new FieldNode("amrtn_strt_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "amrtn_strt_dt",8,0,false,"摊销起始日期")))
							.addNode(new FieldNode("amrtn_end_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "amrtn_end_dt",8	,0,	false,  "摊销终止日期")))
							.addNode(new FieldNode("amrtn_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "amrtn_prd",8,0,false, "摊销周期")))
							.addNode(new FieldNode("amrtn_totl_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "amrtn_totl_amt",18,2,false, "摊销总金额")))
							.addNode(new FieldNode("amrtn_prds", new MsgField(ContentEnum.MessageType.STRING.toString(), "amrtn_prds",10,0,	false,  "摊销期数")))
							.addNode(new FieldNode("fee_pstg_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_pstg_acct_num",40,0,false, "费用入账账号")))
							.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code",10,	0,false	, "摘要代码")))
							.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc",225,0,false,"摘要描述")))
							.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg",1	,0,	false,  "账户钞汇标志")))
							.addNode(new FieldNode("wthr_alrdy_acctg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_alrdy_acctg",1	,0,	false,  "是否已记账	")))
							.addNode(new FieldNode("chrg_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_serl_num",40,	0,false	,  "收费序号")))
							.addNode(new FieldNode("vrfy_chrg_info_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vrfy_chrg_info_flg",1	,0,	false,"校验收费信息标志")))
							.addNode(new FieldNode("cash_item_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_item_code",12,0,	false,"现金项目代码")))			
									)
					.addNode(new FieldNode("trfr_out_party_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_party_cust_acct_num",35,0,	false, "转出方客户账号")))
					.addNode(new FieldNode("trfr_out_party_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_party_acct_nm",750,0,	false, "转出方账户名称")))
					.addNode(new FieldNode("trfr_in_party_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_party_cust_acct_num",	35,0,	false	, "	转入方客户账号")))
					.addNode(new FieldNode("trfr_in_party_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_party_acct_nm",750,0,	false,"转入方账户名称")))
					.addNode(new FieldNode("corp_to_rtl", new MsgField(ContentEnum.MessageType.STRING.toString(), "corp_to_rtl",1,0,false,"公转私标志")))
					.addNode(new FieldNode("remks", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks",300,0,false,"备注")))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class A011000101_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("ctrl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctrl_num",32,0,	false,"控制编号")))
					.addNode(new FieldNode("pymt_lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_lblty_acct_num",40,0,	false, "付款负债账号")))
					.addNode(new FieldNode("trfr_out_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_sub_acct_serl_num",8,0,false, "转出子账户序号")))
					.addNode(new FieldNode("pymt_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_nm",256,0,false,"付款账户名称")))
					.addNode(new FieldNode("pymt_acct_num_open_acct_bank", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_num_open_acct_bank",12,0,	false, "付款账号开户行")))
					.addNode(new FieldNode("pymt_acct_bal", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_bal",18,2,false,"付款账户余额")))
					.addNode(new FieldNode("rcev_mny_acct_num_bal", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcev_mny_acct_num_bal",18,2,false,"收款账号余额")))
					.addNode(new FieldNode("rcev_mny_lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcev_mny_lblty_acct_num",40,	0,false	,"收款负债账号")))
					.addNode(new FieldNode("trfr_in_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_sub_acct_serl_num",8,0,false, "转入子账户序号")))
					.addNode(new FieldNode("paye_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "paye_acct_nm",256,0,false, "收款人户名 ")))
					.addNode(new FieldNode("rcev_mny_acct_open_acct_bank", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcev_mny_acct_open_acct_bank",12,0,	false,"收款账号开户行")))
					.addNode(new FieldNode("wait_write_off_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "wait_write_off_serl_num",40,0,	false, "待销账序号")))
					.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_amt",18,2,false, "交易金额")))
					//.addNode(new FieldNode("spare_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "spare_amt",18,2,false	,"备用金额")))
					.addNode(new FieldNode("remks", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks",300	,0,	false, "备注")))
					.addNode(new ArrayNode("lstFeeIn_list",false)
							.addNode(new FieldNode("chrg_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_code",8,0,false,"收费代码")))
							.addNode(new FieldNode("chrg_code_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_code_nm",30,0,false,"收费代码名称")))
							.addNode(new FieldNode("rcvbl_fee", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcvbl_fee",18,2,false,"应收费用")))
							.addNode(new FieldNode("actly_paid_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "actly_paid_amt",18,2,false,"实付金额")))
							.addNode(new FieldNode("rcvd_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcvd_flg",1,0,false	,"收讫标志")))
							.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num",40,	0,false	,"客户账号")))
							.addNode(new FieldNode("acct_num_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_num_serl_num",8,0,false,"账号序号")))
							.addNode(new FieldNode("amrtn_busi_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "amrtn_busi_num",30,0,	false,"摊销业务编号 ")))
							)
					
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

