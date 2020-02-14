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
 * BASESVC.P042000401 银行卡换卡.实时/预约单张卡换卡 
 * P0420004.01 cd1025
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P042000401 extends EsbCoreChannelService {

	private static P042000401_I i = new P042000401_I();
	private static P042000401_O o = new P042000401_O();
	public P042000401() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P042000401_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("change_card_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "change_card_reason", 1,0, true, "换卡原因" )))
					.addNode(new FieldNode("loss_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "loss_num", 60,0, false, "挂失编号" )))
					.addNode(new FieldNode("old_card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "old_card_num", 40,0, true, "老卡号" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 300,0, false, "交易密码" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, true, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, true, "证件号码" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, true, "客户名称" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("cntct_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_tel", 20,0, false, "联系电话" )))
					.addNode(new FieldNode("card_issn_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_issn_way", 1,0, true, "发卡方式" )))
					.addNode(new FieldNode("rsrv_num_change_card_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rsrv_num_change_card_flg", 1,0, false, "保号换卡标志" )))
					.addNode(new FieldNode("prepd_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "prepd_way", 1,0, false, "预留方式" )))
					.addNode(new FieldNode("new_prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "new_prod_code", 10,0, false, "新产品代码" )))
					.addNode(new FieldNode("new_card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "new_card_num", 40,0, true, "新卡号" )))
					.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
					.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
					.addNode(new FieldNode("dlvg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "dlvg_org", 12,0, false, "递送机构" )))
					.addNode(new FieldNode("keywd", new MsgField(ContentEnum.MessageType.STRING.toString(), "keywd", 1500,0, false, "序号/关键字" )))
					.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
					.addNode(new FieldNode("ic_card_tplt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ic_card_tplt_num", 10,0, false, "IC卡模板编号" )))
					.addNode(new FieldNode("svc_fee_chrg_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "svc_fee_chrg_flg", 1,0, true, "手续费收费标志" )))
					.addNode(new FieldNode("chrg_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_code", 8,0, false, "收费代码" )))
					.addNode(new FieldNode("chrg_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_dt", 8,0, false, "收费日期" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P042000401_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("prepd_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "prepd_way", 1,0, false, "预留方式" )))
					.addNode(new FieldNode("rsrv_num_change_card_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rsrv_num_change_card_flg", 1,0, false, "保号换卡标志" )))
					.addNode(new FieldNode("change_card_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "change_card_reason", 1,0, false, "换卡原因" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("card_issn_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_issn_way", 1,0, false, "发卡方式" )))
					.addNode(new FieldNode("old_card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "old_card_num", 40,0, false, "老卡号" )))
					.addNode(new FieldNode("card_anul_fee", new MsgField(ContentEnum.MessageType.INT.toString(), "card_anul_fee", 18,2, false, "卡年费" )))
					.addNode(new FieldNode("new_card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "new_card_num", 40,0, false, "新卡号" )))
					.addNode(new FieldNode("acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "acct_bal", 18,2, false, "账户余额" )))
					.addNode(new FieldNode("acptd_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acptd_num", 35,0, false, "受理编号" )))
					.addNode(new FieldNode("svc_fee_chrg_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "svc_fee_chrg_flg", 1,0, false, "手续费收费标志" )))
					.addNode(new FieldNode("rcvbl_fee", new MsgField(ContentEnum.MessageType.INT.toString(), "rcvbl_fee", 18,2, false, "应收费用" )))
					.addNode(new FieldNode("splmty_card_prod_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "splmty_card_prod_dsc", 300,0, false, "附卡产品描述" )))
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
					.addNode(new FieldNode("txn_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_nm", 300,0, false, "交易名称" )))
					.addNode(new FieldNode("unld_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "unld_amt", 18,2, false, "圈提金额" )))
					.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

