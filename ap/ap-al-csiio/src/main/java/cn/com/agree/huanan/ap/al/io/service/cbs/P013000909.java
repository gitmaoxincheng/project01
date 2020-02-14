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
 * BASESVC.P013000909 收费回单打印
 * P013000909
 * cg5822 新核心系统
 * @author YFK
 */
@Component
public class P013000909 extends EsbCoreChannelService{

	private static P013000909_I i = new P013000909_I();
	private static P013000909_O o = new P013000909_O();
	public P013000909() {
		requestFormat.add(i);
		responseFormat.add(o);
	}
	
	public static class P013000909_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("lstChrgIn_list",false)
					.addNode(new FieldNode("txn_dt_8",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_dt_8" ,8,0, false, "交易日期" )))
					.addNode(new FieldNode("tlr_rung_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"tlr_rung_num" ,64,0, false, "柜员流水号" )))
					.addNode(new FieldNode("evt_rgstn_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"evt_rgstn_serl_num" ,10,0, false, "事件登记序号" )))
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	public static class P013000909_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("listnm_list",false)
					.addNode(new FieldNode("txn_dt_8",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_dt_8" ,8,0, false, "交易日期" )))
					.addNode(new FieldNode("tlr_rung_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"tlr_rung_num" ,64,0, false, "柜员流水号" )))
					.addNode(new FieldNode("evt_rgstn_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"evt_rgstn_serl_num" ,10,0, false, "事件登记序号" )))
					.addNode(new FieldNode("txn_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_code" ,20,0, false, "交易码" )))
					.addNode(new FieldNode("third_party_txn_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"third_party_txn_code" ,20,0, false, "第三方交易码" )))
					.addNode(new FieldNode("txn_chnl",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_chnl" ,7,0, false, "交易渠道" )))
					.addNode(new FieldNode("chrg_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_code" ,8,0, false, "收费代码" )))
					.addNode(new FieldNode("chrg_code_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_code_nm" ,80,0, false, "收费代码名称" )))
					.addNode(new FieldNode("fee_tp",new MsgField(ContentEnum.MessageType.STRING.toString(),"fee_tp" ,1,0, false, "费用类型" )))
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
					.addNode(new FieldNode("actly_rcvd_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"actly_rcvd_amt" ,18,0, false, "实收金额" )))
					.addNode(new FieldNode("ars_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"ars_amt" ,18,0, false, "欠费金额" )))
					.addNode(new FieldNode("fee_dert_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"fee_dert_amt" ,18,0, false, "费用减免金额" )))
					.addNode(new FieldNode("billg_exch_rto",new MsgField(ContentEnum.MessageType.STRING.toString(),"billg_exch_rto" ,21,0, false, "计费兑换比" )))
					.addNode(new FieldNode("chrg_exch_rto",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_exch_rto" ,21,0, false, "收费兑换比" )))
					.addNode(new FieldNode("busi_acctg_busi_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"busi_acctg_busi_num" ,60,0, false, "收费核算业务编号" )))
					.addNode(new FieldNode("tax_rate_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"tax_rate_code" ,20,0, false, "税率代码" )))
					.addNode(new FieldNode("amrtn_busi_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"amrtn_busi_num" ,60,0, false, "摊销业务编号" )))
					.addNode(new FieldNode("amrtn_sub_acct_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"amrtn_sub_acct_serl_num" ,8,0, false, "摊销子账户序号" )))
					.addNode(new FieldNode("fee_susps_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"fee_susps_acct_num" ,40,0, false, "费用挂账账号 " )))
					.addNode(new FieldNode("fee_susps_sub_acct_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"fee_susps_sub_acct_serl_num" ,8,0, false, "费用挂账子账户序号" )))
					.addNode(new FieldNode("cash_trfr_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"cash_trfr_flg" ,1,0, false, "现转标志" )))
					.addNode(new FieldNode("rcvd_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"rcvd_flg" ,1,0, false, "收讫标志" )))
					.addNode(new FieldNode("cust_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"cust_num" ,32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_acct_num_tp",new MsgField(ContentEnum.MessageType.STRING.toString(),"cust_acct_num_tp" ,1,0, false, "客户账号类型" )))
					.addNode(new FieldNode("cust_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"cust_acct_num" ,40,0, false, "客户账号" )))
					.addNode(new FieldNode("cash_rmtc_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"cash_rmtc_flg" ,1,0, false, "钞汇标志" )))
					.addNode(new FieldNode("sub_acct_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"sub_acct_serl_num" ,8,0, false, "子账户序号" )))
					.addNode(new FieldNode("acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"acct_num" ,40,0, false, "系统账号" )))
					.addNode(new FieldNode("acct_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"acct_nm" ,256,0, false, "账户名称" )))
					.addNode(new FieldNode("chrg_cust_acct_tp",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_cust_acct_tp" ,1,0, false, "收费客户账户类型" )))
					.addNode(new FieldNode("chrg_cust_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_cust_acct_num" ,40,0, false, "收费客户账号" )))
					.addNode(new FieldNode("chrg_acct_ccy",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_acct_ccy" ,3,0, false, "收费账户币种" )))
					.addNode(new FieldNode("chrg_cash_rmtc_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_cash_rmtc_flg" ,1,0, false, "收费钞汇标志" )))
					.addNode(new FieldNode("chrg_lblty_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_lblty_acct_num" ,40,0, false, "收费系统帐号" )))
					.addNode(new FieldNode("chrg_sub_acct_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_sub_acct_serl_num" ,8,0, false, "收费子账户序号" )))
					.addNode(new FieldNode("pref_plan_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"pref_plan_code" ,8,0, false, "优惠优惠计划代码 " )))
					.addNode(new FieldNode("pref_code_list",new MsgField(ContentEnum.MessageType.STRING.toString(),"pref_code_list" ,750,0, false, "优惠代码列表" )))
					.addNode(new FieldNode("chrg_prd",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_prd" ,8,0, false, "收费周期" )))
					.addNode(new FieldNode("chrg_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"chrg_dt" ,8,0, false, "收费日期" )))
					.addNode(new FieldNode("acctg_org",new MsgField(ContentEnum.MessageType.STRING.toString(),"acctg_org" ,12,0, false, "记账机构" )))
					.addNode(new FieldNode("fee_acctg_ccy",new MsgField(ContentEnum.MessageType.STRING.toString(),"fee_acctg_ccy" ,3,0, false, "费用记账币种" )))
					.addNode(new FieldNode("fee_pstg_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"fee_pstg_amt" ,18,0, false, "费用入账金额" )))
					.addNode(new FieldNode("comt_reason",new MsgField(ContentEnum.MessageType.STRING.toString(),"comt_reason" ,300,0, false, "欠费原因" )))
					.addNode(new FieldNode("txn_tlr",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_tlr" ,10,0, false, "交易柜员" )))
					.addNode(new FieldNode("wthr_amrtn_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"wthr_amrtn_flg" ,1,0, false, "是否摊销标志" )))
					.addNode(new FieldNode("vat_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"vat_amt" ,18,0, false, "增值税金额" )))
					.addNode(new FieldNode("tax_rate",new MsgField(ContentEnum.MessageType.STRING.toString(),"tax_rate" ,12,0, false, "税率" )))
					.addNode(new FieldNode("prt_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"prt_flg" ,1,0, false, "打印标志" )))
					.addNode(new FieldNode("prt_cnt",new MsgField(ContentEnum.MessageType.STRING.toString(),"prt_cnt" ,10,0, false, "打印次数" )))
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
}
