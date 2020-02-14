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
 * BASESVC.C023001702 收费登记簿查询 
 * C023001702 
 * cg5842 新核心系统
 * @author YFK
 */
@Component
public class C023001702 extends EsbCoreChannelService{

	private static C023001702_I i = new C023001702_I();
	private static C023001702_O o = new C023001702_O();
	public C023001702() {
		requestFormat.add(i);
		responseFormat.add(o);
	}
	
	public static class C023001702_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("qry_prt_id",new MsgField(ContentEnum.MessageType.STRING.toString(),"qry_prt_id",1,0,false,"查询打印标识")))
					.addNode(new FieldNode("strt_dt_8",new MsgField(ContentEnum.MessageType.STRING.toString(),"strt_dt_8",8,0,false,"起始日期")))
					.addNode(new FieldNode("end_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"end_dt",8,0,false,"终止日期")))
					.addNode(new FieldNode("cust_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"cust_num",32,0,false,"客户号")))
					.addNode(new FieldNode("cust_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"cust_acct_num",40,0,false,"客户账号")))
					.addNode(new FieldNode("tlr_rung_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"tlr_rung_num",32,0,false,"柜员流水号")))
					.addNode(new FieldNode("chrg_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_code",8,0,false,"收费代码")))
					.addNode(new FieldNode("chrg_code_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_code_nm",80,0,false,"收费代码名称")))
					.addNode(new FieldNode("rcvd_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"rcvd_flg",1,0,false,"收讫标志")))
					.addNode(new FieldNode("prt_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"prt_flg",1,0,false,"打印标志")))
					.addNode(new FieldNode("txn_bank_org_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_bank_org_num",12,0,false,"交易行机构号")))
					.addNode(new FieldNode("pref_plan_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"pref_plan_code",8,0,false,"优惠计划代码")))
					.addNode(new FieldNode("strt_cnt_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"strt_cnt_num",10,0,false,"起始笔数")))
					.addNode(new FieldNode("qry_cnt_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"qry_cnt_num",10,0,false,"查询笔数")))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	public static class C023001702_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("std_chrg_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"std_chrg_amt" ,18,0, false, "标准收费金额" )))
					.addNode(new FieldNode("rcvbl_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"rcvbl_amt" ,18,0, false, "应收金额" )))
					.addNode(new FieldNode("ars_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"ars_amt" ,18,0, false, "欠费金额" )))
					.addNode(new FieldNode("pref_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"pref_amt" ,18,0, false, "优惠金额" )))
					.addNode(new FieldNode("cmisn_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"cmisn_amt" ,18,0, false, "分成金额" )))
					.addNode(new FieldNode("actly_rcvd_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"actly_rcvd_amt" ,18,0, false, "实收金额" )))
					.addNode(new ArrayNode("listnm_list",false)					
					.addNode(new FieldNode("txn_dt_8",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_dt_8" ,8,0, false, "交易日期" )))
					.addNode(new FieldNode("tlr_rung_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"tlr_rung_num" ,32,0, false, "柜员流水号" )))
					.addNode(new FieldNode("evt_rgstn_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"evt_rgstn_serl_num" ,10,0, false, "事件登记序号" )))
					.addNode(new FieldNode("txn_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_code" ,20,0, false, "交易码" )))
					.addNode(new FieldNode("third_party_txn_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"third_party_txn_code" ,20,0, false, "第三方交易码" )))
					.addNode(new FieldNode("txn_chnl",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_chnl" ,7,0, false, "交易渠道" )))
					.addNode(new FieldNode("chrg_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_code" ,8,0, false, "收费代码" )))
					.addNode(new FieldNode("chrg_code_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_code_nm" ,80,0, false, "收费代码名称" )))
					.addNode(new FieldNode("fee_recpt_pymt_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"fee_recpt_pymt_flg" ,1,0, false, "费用收付标志" )))
					.addNode(new FieldNode("txn_ccy",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_ccy" ,3,0, false, "交易币种" )))
					.addNode(new FieldNode("txn_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_amt" ,18,0, false, "交易金额" )))
					.addNode(new FieldNode("qty",new MsgField(ContentEnum.MessageType.STRING.toString(),"qty" ,10,0, false, "数量" )))
					.addNode(new FieldNode("asgn_chrg_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"asgn_chrg_amt" ,18,0, false, "指定收费金额" )))
					.addNode(new FieldNode("chrg_amt_src",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_amt_src" ,1,0, false, "收费金额来源" )))
					.addNode(new FieldNode("billg_ccy",new MsgField(ContentEnum.MessageType.STRING.toString(),"billg_ccy" ,3,0, false, "计费币种" )))
					.addNode(new FieldNode("std_chrg_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"std_chrg_amt" ,18,0, false, "标准收费金额" )))
					.addNode(new FieldNode("ultmt_pref_pcnt",new MsgField(ContentEnum.MessageType.STRING.toString(),"ultmt_pref_pcnt" ,12,0, false, "优惠比率" )))
					.addNode(new FieldNode("rcvbl_amt_aft_pref",new MsgField(ContentEnum.MessageType.STRING.toString(),"rcvbl_amt_aft_pref" ,18,0, false, "优惠后应收金额" )))
					.addNode(new FieldNode("chrg_ccy",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_ccy" ,3,0, false, "收费币种" )))
					.addNode(new FieldNode("rcvbl_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"rcvbl_amt" ,18,0, false, "应收费用金额" )))
					.addNode(new FieldNode("actly_rcvd_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"actly_rcvd_amt" ,18,0, false, "实收费用金额" )))
					.addNode(new FieldNode("ars_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"ars_amt" ,18,0, false, "欠费金额" )))
					.addNode(new FieldNode("fee_dert_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"fee_dert_amt" ,18,0, false, "费用减免金额" )))
					.addNode(new FieldNode("cmisn_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"cmisn_amt" ,18,0, false, "收费分成金额" )))
					.addNode(new FieldNode("trfr_in_bank_cmisn_rto",new MsgField(ContentEnum.MessageType.STRING.toString(),"trfr_in_bank_cmisn_rto" ,12,0, false, "转入行分成比率" )))
					.addNode(new FieldNode("trfr_out_bank_cmisn_pcnt",new MsgField(ContentEnum.MessageType.STRING.toString(),"trfr_out_bank_cmisn_pcnt" ,12,0, false, "转出行分成比率" )))
					.addNode(new FieldNode("txn_bank_cmisn_rto",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_bank_cmisn_rto" ,12,0, false, "交易行分成比率" )))
					.addNode(new FieldNode("billg_exch_rto",new MsgField(ContentEnum.MessageType.STRING.toString(),"billg_exch_rto" ,18,0, false, "计费兑换比" )))
					.addNode(new FieldNode("chrg_exch_rto",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_exch_rto" ,18,0, false, "收费兑换比" )))
					.addNode(new FieldNode("busi_acctg_busi_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"busi_acctg_busi_num" ,60,0, false, "收费核算业务编号" )))
					.addNode(new FieldNode("susps_acct_busi_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"susps_acct_busi_num" ,60,0, false, "收费挂账业务编号" )))
					.addNode(new FieldNode("fee_susps_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"fee_susps_acct_num" ,40,0, false, "费用挂账账号 " )))
					.addNode(new FieldNode("fee_susps_sub_acct_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"fee_susps_sub_acct_serl_num" ,8,0, false, "费用挂账子账户序号" )))
					.addNode(new FieldNode("cash_trfr_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"cash_trfr_flg" ,1,0, false, "现转标志" )))
					.addNode(new FieldNode("rcvd_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"rcvd_flg" ,1,0, false, "收讫标志" )))
					.addNode(new FieldNode("prt_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"prt_flg" ,1,0, false, "打印标志" )))
					.addNode(new FieldNode("prt_cnt",new MsgField(ContentEnum.MessageType.STRING.toString(),"prt_cnt" ,10,0, false, "打印次数" )))
					.addNode(new FieldNode("cust_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"cust_num" ,32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_acct_num_tp",new MsgField(ContentEnum.MessageType.STRING.toString(),"cust_acct_num_tp" ,1,0, false, "客户账号类型" )))
					.addNode(new FieldNode("cust_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"cust_acct_num" ,40,0, false, "客户账号" )))
					.addNode(new FieldNode("cash_rmtc_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"cash_rmtc_flg" ,1,0, false, "钞汇标志" )))
					.addNode(new FieldNode("sub_acct_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"sub_acct_serl_num" ,8,0, false, "子账户序号" )))
					.addNode(new FieldNode("acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"acct_num" ,40,0, false, "系统账号" )))
					.addNode(new FieldNode("acct_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"acct_nm" ,256,0, false, "账户名称" )))
					.addNode(new FieldNode("rpymt_acct_aval_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"rpymt_acct_aval_amt" ,18,0, false, "账户可用金额" )))
					.addNode(new FieldNode("prod_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"prod_code" ,10,0, false, "产品代码" )))
					.addNode(new FieldNode("blgd_prod_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"blgd_prod_code" ,10,0, false, "归属产品号" )))
					.addNode(new FieldNode("orig_txn_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"orig_txn_dt" ,8,0, false, "原始业务日期" )))
					.addNode(new FieldNode("orig_tlr_rung_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"orig_tlr_rung_num" ,32,0, false, "原始业务流水号" )))
					.addNode(new FieldNode("chrg_cust_acct_tp",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_cust_acct_tp" ,1,0, false, "收费客户账户类型" )))
					.addNode(new FieldNode("chrg_cust_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_cust_acct_num" ,40,0, false, "收费客户账号" )))
					.addNode(new FieldNode("chrg_acct_ccy",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_acct_ccy" ,3,0, false, "收费账户币种" )))
					.addNode(new FieldNode("chrg_cash_rmtc_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_cash_rmtc_flg" ,1,0, false, "收费钞汇标志" )))
					.addNode(new FieldNode("chrg_lblty_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_lblty_acct_num" ,40,0, false, "收费系统帐号" )))
					.addNode(new FieldNode("chrg_sub_acct_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_sub_acct_serl_num" ,8,0, false, "收费子账户序号" )))
					.addNode(new FieldNode("pref_code_list",new MsgField(ContentEnum.MessageType.STRING.toString(),"pref_code_list" ,750,0, false, "优惠代码列表" )))
					.addNode(new FieldNode("chrg_prd",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_prd" ,8,0, false, "收费周期" )))
					.addNode(new FieldNode("chrg_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_dt" ,8,0, false, "收费日期" )))
					.addNode(new FieldNode("acctg_org",new MsgField(ContentEnum.MessageType.STRING.toString(),"acctg_org" ,12,0, false, "记账机构" )))
					.addNode(new FieldNode("trfr_out_bank_org_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"trfr_out_bank_org_num" ,12,0, false, "转出行机构号" )))
					.addNode(new FieldNode("trfr_in_bank_org_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"trfr_in_bank_org_num" ,12,0, false, "转入行机构号" )))
					.addNode(new FieldNode("txn_bank_org_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_bank_org_num" ,12,0, false, "交易行机构号" )))
					.addNode(new FieldNode("chrg_detl_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_detl_serl_num" ,10,0, false, "收费明细序号" )))
					.addNode(new FieldNode("ddc_fee_fail_cnt",new MsgField(ContentEnum.MessageType.STRING.toString(),"ddc_fee_fail_cnt" ,10,0, false, "扣费失败次数" )))
					.addNode(new FieldNode("comt_reason",new MsgField(ContentEnum.MessageType.STRING.toString(),"comt_reason" ,300,0, false, "欠费原因" )))
					.addNode(new FieldNode("last_txn_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"last_txn_dt" ,8,0, false, "上次批扣日期" )))
					.addNode(new FieldNode("abst_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"abst_code" ,10,0, false, "摘要代码" )))
					.addNode(new FieldNode("abst_dsc",new MsgField(ContentEnum.MessageType.STRING.toString(),"abst_dsc" ,225,0, false, "摘要描述" )))
					.addNode(new FieldNode("remks_info",new MsgField(ContentEnum.MessageType.STRING.toString(),"remks_info" ,300,0, false, "备注信息" )))
					.addNode(new FieldNode("tax_rate_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"tax_rate_code" ,20,0, false, "税率代码" )))
					.addNode(new FieldNode("vat_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"vat_amt" ,18,0, false, "增值税金额" )))
					.addNode(new FieldNode("tax_rate",new MsgField(ContentEnum.MessageType.STRING.toString(),"tax_rate" ,12,0, false, "税率" )))
					.addNode(new FieldNode("tax_caln_busi_acctg_busi_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"tax_caln_busi_acctg_busi_num" ,60,0, false, "计税核算业务编号" )))
					.addNode(new FieldNode("tax_caln_acctg_busi_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"tax_caln_acctg_busi_serl_num" ,60,0, false, "计税核算业务序号" )))
					.addNode(new FieldNode("prvn_revnu_busi_acctg_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"prvn_revnu_busi_acctg_code" ,60,0, false, "预提税金核算代码" )))
					.addNode(new FieldNode("prvn_revnu_busi_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"prvn_revnu_busi_serl_num" ,60,0, false, "预提税金业务序号" )))
					.addNode(new FieldNode("strk_bal_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"strk_bal_amt" ,18,0, false, "冲账金额" )))
					.addNode(new FieldNode("fee_acctg_ccy",new MsgField(ContentEnum.MessageType.STRING.toString(),"fee_acctg_ccy" ,3,0, false, "费用记账币种" )))
					.addNode(new FieldNode("fee_pstg_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"fee_pstg_amt" ,18,0, false, "费用入账金额" )))
					.addNode(new FieldNode("wthr_prvn",new MsgField(ContentEnum.MessageType.STRING.toString(),"wthr_prvn" ,1,0, false, "是否预提" )))
					.addNode(new FieldNode("wthr_amrtn_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"wthr_amrtn_flg" ,1,0, false, "是否摊销标志" )))
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
}
