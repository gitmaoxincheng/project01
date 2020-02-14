package cn.com.agree.huanan.ap.al.io.service.ica;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbIcaChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P042000501 银行卡销卡.个人卡销卡 
 * P0420005.01 cd1026
 * 0050 IC卡系统2.0
 * @author XXX
 */
@Component
public class P042000501 extends EsbIcaChannelService {

	private static P042000501_I i = new P042000501_I();
	private static P042000501_O o = new P042000501_O();
	public P042000501() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P042000501_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cncl_card_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_card_reason", 1,0, true, "销卡原因" )))
					.addNode(new FieldNode("cncl_card_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_card_way", 1,0, true, "销卡方式" )))
					.addNode(new FieldNode("loss_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "loss_num", 60,0, false, "挂失编号" )))
					.addNode(new FieldNode("mstr_card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "mstr_card_num", 40,0, false, "主卡卡号" )))
					.addNode(new FieldNode("mstr_card_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "mstr_card_pswd", 32,0, false, "主卡密码" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, true, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("cptl_drcn", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptl_drcn", 1,0, false, "资金去向" )))
					.addNode(new FieldNode("cntpr_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_acct_num", 40,0, false, "对方账号" )))
					.addNode(new FieldNode("cntpr_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_sub_acct_serl_num", 8,0, false, "对方子账户序号" )))
					.addNode(new FieldNode("cntpr_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_acct_nm", 256,0, false, "对方户名" )))
					.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
					.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
					.addNode(new FieldNode("svc_fee_chrg_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "svc_fee_chrg_flg", 1,0, true, "手续费收费标志" )))
					.addNode(new FieldNode("cncl_card_mode", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_card_mode", 1,0, true, "销卡模式" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P042000501_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("splmty_card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "splmty_card_num", 40,0, false, "附卡卡号" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("mstr_card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "mstr_card_num", 40,0, false, "主卡卡号" )))
					.addNode(new FieldNode("cptl_drcn", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptl_drcn", 1,0, false, "资金去向" )))
					.addNode(new FieldNode("cntpr_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_acct_num", 40,0, false, "对方账号" )))
					.addNode(new FieldNode("wait_write_off_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "wait_write_off_serl_num", 40,0, false, "待销账序号" )))
					.addNode(new FieldNode("svc_fee_chrg_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "svc_fee_chrg_flg", 1,0, false, "手续费收费标志" )))
					.addNode(new FieldNode("rcvbl_fee", new MsgField(ContentEnum.MessageType.INT.toString(), "rcvbl_fee", 18,2, false, "应收费用" )))
					.addNode(new FieldNode("splmty_card_grd", new MsgField(ContentEnum.MessageType.STRING.toString(), "splmty_card_grd", 1,0, false, "附卡等级" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
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
					.addNode(new FieldNode("actl_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_int_rate", 12,7, false, "实际利率" )))
					.addNode(new FieldNode("actl_int_occr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_int_occr_amt", 18,2, false, "实际利息发生额" )))
					.addNode(new FieldNode("int_tax_occr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "int_tax_occr_amt", 18,2, false, "利息税发生额" )))
					.addNode(new FieldNode("actl_draw_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_draw_amt", 18,2, false, "实际支取金额" )))
					.addNode(new FieldNode("smtn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "smtn_amt", 18,2, false, "合计金额" )))
					.addNode(new FieldNode("cash_trfr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_trfr_flg", 1,0, false, "现转标志" )))
					.addNode(new FieldNode("cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cnt_num", 10,0, false, "笔数" )))
					.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
					.addNode(new FieldNode("txn_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_nm", 300,0, false, "交易名称" )))
					.addNode(new FieldNode("int_val", new MsgField(ContentEnum.MessageType.INT.toString(), "int_val", 18,2, false, "利息" )))
					.addNode(new FieldNode("instmt_prcpl", new MsgField(ContentEnum.MessageType.INT.toString(), "instmt_prcpl", 18,2, false, "期供本金" )))
					.addNode(new FieldNode("taxbl_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "taxbl_amt", 18,2, false, "应税金额" )))
					.addNode(new FieldNode("cntpr_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_acct_nm", 256,0, false, "对方户名" )))
					.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
					.addNode(new ArrayNode("listnm01_list",false)
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

