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
 * BASESVC.P011000701  通用收费
 * 	P0110007.01
 * @author lf
 *
 */
@Component
public class P011000701 extends EsbCoreChannelService {

	private static P011000701_I i = new P011000701_I();
	private static P011000701_O o = new P011000701_O();
	public P011000701() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P011000701_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("fee_acctg_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_acctg_flg",1,0, false, "费用记账标志" )))
					.addNode(new FieldNode("wthr_alrdy_prc_tax_seprtn", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_alrdy_prc_tax_seprtn",1,0, false, "是否已价税分离" )))
					.addNode(new FieldNode("wthr_acmld_ddcn", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_acmld_ddcn",1,0, false, "是否累计扣收" )))
					.addNode(new FieldNode("wthr_agrgtd_acctg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_agrgtd_acctg",1,0, false, "是否汇总记账" )))
					.addNode(new FieldNode("cash_trfr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_trfr_flg",1,0, false, "现转标志" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num",32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm",256,0, false, "客户中文名" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num",3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_num",40,0, false, "账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num",8,0, false, "子账户序号" )))
					.addNode(new FieldNode("ddc_fee_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ddc_fee_cash_rmtc_flg",1,0, false, "扣费钞汇标志" )))
					.addNode(new FieldNode("cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_rmtc_flg",1,0, false, "钞汇标志" )))
					.addNode(new FieldNode("ddc_fee_ccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "ddc_fee_ccy",3,0, false, "实际扣费币种" )))
					.addNode(new FieldNode("ddc_fee_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ddc_fee_acct_num",40,0, false, "实际扣费账号" )))
					.addNode(new FieldNode("cntpr_cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_cust_num",32,0, false, "对方客户号" )))
					.addNode(new FieldNode("acct_nm	", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm",256,0, false, "账户名称" )))
					.addNode(new FieldNode("ddc_fee_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ddc_fee_sub_acct_serl_num",8,0, false, "扣费子账户序号" )))
					.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code",10,0, false, "摘要代码" )))
					.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc",225,0, false, "摘要描述" )))
					.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info",300,0, false, "备注信息" )))
					.addNode(new FieldNode("cash_item_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_item_code",12,0, false, "现金项目代码" )))
					.addNode(new FieldNode("trfr_out_bank_org_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_bank_org_num",12,0, false, "转出行机构号" )))
					.addNode(new FieldNode("trfr_in_bank_org_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_bank_org_num",12,0, false, "转入行机构号" )))
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code",10,0, false, "产品代码" )))
        .addNode(new  ArrayNode("listnm_list",false)
        		.addNode(new FieldNode("chrg_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_code",8,0, false, "收费代码" )))
        		.addNode(new FieldNode("chrg_code_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_code_nm",80,0, false, "收费代码的中文名" )))
        		.addNode(new FieldNode("scen_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "scen_code",30,0, false, "收费所对应的场景代码，场景收费时才展示" )))
        		.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt",18,2, false, "交易金额" )))
        		.addNode(new FieldNode("qty", new MsgField(ContentEnum.MessageType.STRING.toString(), "qty",10,0, false, "交易数量" )))
        		.addNode(new FieldNode("asgn_chrg_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "asgn_chrg_amt",18,2	,false, "指定收费金额" )))
        		.addNode(new FieldNode("cmisn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "cmisn_amt",18,2,false,"收费所进行分成的金额" )))
        		.addNode(new FieldNode("wthr_amrtn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_amrtn_flg",1,0, false, "E_WTHR_AMRTN_FLG" )))
        		.addNode(new FieldNode("wthr_prvn", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_prvn",1,0, false, "E_WTHR_FLG" )))
        		.addNode(new FieldNode("chrg_freq", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_freq",8,0, false, "批量后收费频率" )))
        		.addNode(new FieldNode("busi_rfrc_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_rfrc_num",32,0, false, "登记外部传入收费的业务标记	" )))
        		.addNode(new FieldNode("strt_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_dt_8",8,0, false, "摊销的起始日期" )))
        		.addNode(new FieldNode("end_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_dt",8,0, false, "摊销的终止日期" )))
        		.addNode(new FieldNode("amrtn_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "amrtn_prd",8,0, false, "摊销的周期数" )))																	
        		));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P011000701_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("listnm01_list",false)
							.addNode(new FieldNode("chrg_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_code",	8,0,false,"收费代码" )))
							.addNode(new FieldNode("chrg_code_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_code_nm",80,0,false,"收费代码名称" )))
							.addNode(new FieldNode("rcvbl_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "rcvbl_amt",18,2,false,"应收费用金额" )))
							.addNode(new FieldNode("actly_rcvd_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "actly_rcvd_amt",18,2,false,"实收金额" )))
							.addNode(new FieldNode("ars_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "ars_amt",18,2,false,"欠费金额" )))
							.addNode(new FieldNode("billg_ccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "billg_ccy",3,0,false,"计费币种" )))
							.addNode(new FieldNode("std_chrg_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "std_chrg_amt",18,2,false,"标准收费金额" )))
							.addNode(new FieldNode("fee_rcvbl_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "fee_rcvbl_amt",18,2,false,"费用应收金额" )))
							.addNode(new FieldNode("ultmt_pref_pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "ultmt_pref_pcnt",12,7,false,"最终优惠比例" )))
							.addNode(new FieldNode("pref_code_list", new MsgField(ContentEnum.MessageType.STRING.toString(), "pref_code_list",750,0,false,"优惠代码列表" )))
							.addNode(new FieldNode("fee_recpt_pymt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_recpt_pymt_flg",1,0,false,"费用收付标志" )))
							.addNode(new FieldNode("chrg_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_prd",	8,0,false,"	收费周期" )))
							.addNode(new FieldNode("asgn_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "asgn_dt",8,0,false,"指定日期" )))
							.addNode(new FieldNode("rcvd_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcvd_flg",1,0,false,"收讫标志" )))
							.addNode(new FieldNode("wthr_amrtn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_amrtn_flg",1	,0,false,"是否摊销标志" )))
							.addNode(new FieldNode("wthr_prvn", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_prvn",1,0,false,"是否预提" )))
							.addNode(new FieldNode("busi_acctg_busi_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_acctg_busi_num",60,0,false,"收费核算业务编号" )))
							.addNode(new FieldNode("susps_acct_busi_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "susps_acct_busi_num",60,0,false,"收费挂账业务编号" )))
							.addNode(new FieldNode("glbl_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "glbl_rung_num",32,0,false,"全局流水号" )))
							.addNode(new FieldNode("txn_rung_num_32", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_rung_num_32",32,0,false,"柜员流水号" )))
							.addNode(new FieldNode("evt_rgstn_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "evt_rgstn_serl_num",10,0,false,"事件登记序号" )))
							.addNode(new FieldNode("acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_num",40,0,false,"系统账号" )))
							)
					.addNode(new FieldNode("rcvbl_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "rcvbl_amt",18,2,false,"应收费用金额" )))
					.addNode(new FieldNode("paybl_fee_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "paybl_fee_amt",18,2,false,"应付费用金额" )))
					.addNode(new FieldNode("actly_rcvd_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "actly_rcvd_amt",18,2,false,"实收金额" )))
					.addNode(new FieldNode("actly_paid_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "actly_paid_amt",18,2,false,"实付金额" )))
					.addNode(new FieldNode("smtn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "smtn_amt",18,2,false,"合计金额" )))
					.addNode(new FieldNode("fee_recpt_pymt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_recpt_pymt_flg",1	,0,false,"费用收付标志" )))
					.addNode(new FieldNode("chrg_ccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_ccy",3,0,false,"收费币种" )))
			
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
