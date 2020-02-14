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
 * BASESVC.P042000601 借记卡实时发卡.实时单张发个人卡主卡 
 * P0420006.01 cd1010
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P042000601 extends EsbCoreChannelService {
       
	private static P042000601_I i = new P042000601_I();
	private static P042000601_O o = new P042000601_O();
	public P042000601() {
		requestFormat.add(i);
		responseFormat.add(o);
	}   

	public static class P042000601_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, true, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, true, "证件号码" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, true, "客户名称" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, true, "客户号" )))
					.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, true, "卡号" )))
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, true, "产品代码" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 32,0, false, "交易密码" )))
					.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, true, "交易金额" )))
					.addNode(new FieldNode("cptl_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptl_src", 1,0, false, "资金来源" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("cnptr_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cnptr_acct_nm", 256,0, false, "对方户名" )))
					.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
					.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
					.addNode(new FieldNode("acct_attr_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_attr_code", 3,0, true, "账户属性代码" )))
					.addNode(new FieldNode("rfer_nm_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_nm_01", 256,0, false, "推荐人名称" )))
					.addNode(new FieldNode("rfer_job_num_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfer_job_num_01", 10,0, false, "推荐人工号" )))
					.addNode(new FieldNode("salman_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "salman_num", 750,0, false, "营销人编号" )))
					.addNode(new FieldNode("salman_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "salman_nm", 10,0, false, "推荐人工号" )))
					.addNode(new FieldNode("svc_fee_chrg_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "svc_fee_chrg_flg", 1,0, true, "手续费收费标志" )))
					.addNode(new FieldNode("actvt_card_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "actvt_card_reason", 255,0, false, "开卡原因" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P042000601_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, false, "卡号" )))
					.addNode(new FieldNode("vld_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "vld_dt", 8,0, false, "有效日期" )))
					.addNode(new FieldNode("acptd_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acptd_num", 35,0, false, "受理编号" )))
					.addNode(new FieldNode("svc_fee_chrg_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "svc_fee_chrg_flg", 1,0, false, "手续费收费标志" )))
					.addNode(new FieldNode("rcvbl_fee", new MsgField(ContentEnum.MessageType.INT.toString(), "rcvbl_fee", 18,2, false, "应收费用" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("prod_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_dsc", 750,0, false, "产品描述" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new ArrayNode("lstFEEHD_list",false)
							.addNode(new FieldNode("chrg_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_code", 8,0, false, "收费代码" )))
							.addNode(new FieldNode("chrg_code_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_code_nm", 80,0, false, "收费代码名称" )))
							.addNode(new FieldNode("svc_fee_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "svc_fee_amt", 18,2, false, "手续费金额" )))
							.addNode(new FieldNode("fee_recpt_pymt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_recpt_pymt_flg", 1,0, false, "费用收付标志" )))
							.addNode(new FieldNode("rcvd_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcvd_flg", 1,0, false, "收讫标志" )))
							.addNode(new FieldNode("ars_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "ars_amt", 18,2, false, "欠费金额" )))
							).addNode(new FieldNode("chrg_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_cust_acct_num", 40,0, false, "收费客户账号" )))
					.addNode(new FieldNode("acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_num", 40,0, false, "账号" )))
					.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm", 256,0, false, "客户中文名" )))
					.addNode(new FieldNode("chrg_ccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_ccy", 3,0, false, "收费币种" )))
					.addNode(new FieldNode("fee_recpt_pymt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_recpt_pymt_flg", 1,0, false, "费用收付标志" )))
					.addNode(new FieldNode("smtn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "smtn_amt", 18,2, false, "合计金额" )))
					.addNode(new FieldNode("cash_trfr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_trfr_flg", 1,0, false, "现转标志" )))
					.addNode(new FieldNode("cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cnt_num", 10,0, false, "笔数" )))
					.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
					.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
					.addNode(new FieldNode("txn_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_nm", 300,0, false, "交易名称" )))
					.addNode(new FieldNode("card_issn_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_issn_org", 12,0, false, "发卡机构" )))
					.addNode(new FieldNode("acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "acct_bal", 18,2, false, "账户余额" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

