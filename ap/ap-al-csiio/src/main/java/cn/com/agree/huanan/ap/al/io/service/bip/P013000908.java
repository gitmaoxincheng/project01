package cn.com.agree.huanan.ap.al.io.service.bip;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P013000908 电子回单查询打印.存款账户电子回单打印(批量账户) 
 * P0130009.08 BIPC009
 * 0301 业务组合平台
 * @author XZF
 */
@Component
public class P013000908 extends EsbChannelService {

	private static P013000908_I i = new P013000908_I();
	private static P013000908_O o = new P013000908_O();
	public P013000908() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013000908_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("listIn_list",false)
							.addNode(new FieldNode("acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_num", 40,0, false, "账号" )))
							.addNode(new FieldNode("txn_serl_num", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_serl_num", 10,0, false, "交易序号" )))
							).addNode(new FieldNode("strt_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_dt_8", 8,0, false, "起始日期" )))
					.addNode(new FieldNode("end_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_dt", 8,0, false, "终止日期" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013000908_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("listnm_list",false)
							.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("txn_tm", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_tm", 10,0, false, "交易时间" )))
							.addNode(new FieldNode("txn_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_org", 10,0, false, "交易机构" )))
							.addNode(new FieldNode("txn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_tlr", 9,0, false, "交易柜员" )))
							.addNode(new FieldNode("tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_rung_num", 32,0, false, "柜员流水号" )))
							.addNode(new FieldNode("txn_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_code", 20,0, false, "交易码" )))
							.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 16,0, false, "客户号" )))
							.addNode(new FieldNode("acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_num", 40,0, false, "系统账号" )))
							.addNode(new FieldNode("open_acct_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_org", 10,0, false, "开户机构" )))
							.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 750,0, false, "账户名称" )))
							.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
							.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 35,0, false, "客户账号" )))
							.addNode(new FieldNode("acct_num_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_num_serl_num", 8,0, false, "账号序号" )))
							.addNode(new FieldNode("txn_serl_num", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_serl_num", 10,0, false, "交易序号" )))
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_rmtc_flg", 1,0, false, "钞汇标志" )))
							.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 17,2, false, "交易金额" )))
							.addNode(new FieldNode("acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "acct_bal", 21,2, false, "账户余额" )))
							.addNode(new FieldNode("cntpr_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_cust_acct_num", 35,0, false, "对方客户账号" )))
							.addNode(new FieldNode("cntpr_lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_lblty_acct_num", 40,0, false, "对方负债账号" )))
							.addNode(new FieldNode("cntpr_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_acct_nm", 750,0, false, "对方户名" )))
							.addNode(new FieldNode("cntpr_fincl_org_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_fincl_org_tp", 2,0, false, "对方金融机构类型" )))
							.addNode(new FieldNode("cntpr_fincl_org_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_fincl_org_code", 20,0, false, "对方金融机构代码" )))
							.addNode(new FieldNode("cntpr_fincl_org_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_fincl_org_nm", 300,0, false, "对方机构名称" )))
							.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
							.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
							.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 1500,0, false, "备注信息" )))
							.addNode(new FieldNode("recpt_ttl", new MsgField(ContentEnum.MessageType.STRING.toString(), "recpt_ttl", 300,0, false, "回单台头" )))
							.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品代码" )))
							.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
							.addNode(new FieldNode("prt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "prt_flg", 1,0, false, "打印标志" )))
							.addNode(new FieldNode("prt_cnt", new MsgField(ContentEnum.MessageType.INT.toString(), "prt_cnt", 10,0, false, "打印次数" )))
							.addNode(new FieldNode("chnl_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "chnl_code", 7,0, false, "渠道代码" )))
							.addNode(new FieldNode("doc_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "doc_type", 1,0, false, "单据类型" )))
							.addNode(new FieldNode("db_cr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "db_cr_flg", 1,0, false, "借贷标志" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

