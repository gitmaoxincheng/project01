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
 * BASESVC.P013000228 交易信息查询.交易明细查询 
 * P0130002.28 ib1695
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P013000228 extends EsbCoreChannelService {

	private static P013000228_I i = new P013000228_I();
	private static P013000228_O o = new P013000228_O();
	public P013000228() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013000228_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("txn_rung_num_32", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_rung_num_32", 32,0, false, "交易流水号" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("acct_num_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_num_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("txn_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_org", 12,0, false, "交易机构" )))
					.addNode(new FieldNode("strt_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_dt_8", 8,0, false, "起始日期" )))
					.addNode(new FieldNode("end_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_dt", 8,0, false, "终止日期" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "strt_cnt_num", 10,0, false, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "qry_cnt_num", 10,0, false, "查询笔数" )))
					.addNode(new FieldNode("db_cr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "db_cr_flg", 1,0, false, "借贷标志" )))
					.addNode(new FieldNode("min_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "min_amt", 18,2, false, "最小金额" )))
					.addNode(new FieldNode("max_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "max_amt", 18,2, false, "最大金额" )))
					.addNode(new FieldNode("sort_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "sort_way", 1,0, false, "排序方式" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013000228_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("acct_num_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_num_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
					.addNode(new FieldNode("open_acct_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_org", 12,0, false, "开户机构" )))
					.addNode(new FieldNode("aval_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "aval_bal", 18,2, false, "可用余额" )))
					.addNode(new FieldNode("last_dy_acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "last_dy_acct_bal", 18,2, false, "上日账户余额" )))
					.addNode(new FieldNode("acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "acct_bal", 18,2, false, "账户余额" )))
					.addNode(new FieldNode("totl_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "totl_cnt_num", 10,0, false, "总笔数" )))
					.addNode(new FieldNode("db_totl_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "db_totl_amt", 18,2, false, "借方总金额" )))
					.addNode(new FieldNode("cr_totl_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "cr_totl_amt", 18,2, false, "贷方总金额" )))
					.addNode(new FieldNode("rspns_file_route", new MsgField(ContentEnum.MessageType.STRING.toString(), "rspns_file_route", 600,0, false, "应答文件路径" )))
					.addNode(new ArrayNode("lstminxi_list",false)
							.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
							.addNode(new FieldNode("acct_num_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_num_serl_num", 8,0, false, "子账户序号" )))
							.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号" )))
							.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("txn_tm", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_tm", 25,0, false, "交易时间" )))
							.addNode(new FieldNode("txn_rung_num_32", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_rung_num_32", 32,0, false, "交易流水号" )))
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
							.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
							.addNode(new FieldNode("chnl_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "chnl_code", 7,0, false, "渠道代码" )))
							.addNode(new FieldNode("db_cr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "db_cr_flg", 1,0, false, "借贷标志" )))
							.addNode(new FieldNode("last_dy_acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "last_dy_acct_bal", 18,2, false, "上日账户余额" )))
							.addNode(new FieldNode("acct_txn_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_txn_tp", 1,0, false, "账户交易类型" )))
							.addNode(new FieldNode("acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "acct_bal", 18,2, false, "账户余额" )))
							.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
							.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
							.addNode(new FieldNode("txn_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_org", 12,0, false, "交易机构" )))
							.addNode(new FieldNode("txn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_tlr", 10,0, false, "交易柜员" )))
							.addNode(new FieldNode("cntpr_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_acct_num", 40,0, false, "对方账号" )))
							.addNode(new FieldNode("cntpr_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_acct_nm", 256,0, false, "对方户名" )))
							.addNode(new FieldNode("cntpr_fincl_org_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_fincl_org_code", 12,0, false, "对方金融机构代码" )))
							.addNode(new FieldNode("cntpr_fincl_org_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_fincl_org_nm", 300,0, false, "对方金融机构名称" )))
							.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
							.addNode(new FieldNode("txn_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_code", 20,0, false, "交易码" )))
							.addNode(new FieldNode("cash_trfr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_trfr_flg", 1,0, false, "现转标志" )))
							.addNode(new FieldNode("detl_serl_num", new MsgField(ContentEnum.MessageType.INT.toString(), "detl_serl_num", 10,0, false, "明细序号" )))
							.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
							.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 32,0, false, "凭证序号" )))
							.addNode(new FieldNode("remks", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks", 300,0, false, "备注" )))
							.addNode(new FieldNode("rvrs_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rvrs_flg", 1,0, false, "冲正标志" )))
							.addNode(new FieldNode("be_rvrsd_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "be_rvrsd_flg", 1,0, false, "被冲正标志" )))
							.addNode(new FieldNode("athrzn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "athrzn_tlr", 10,0, false, "授权柜员" )))
							.addNode(new FieldNode("err_acct_orig_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "err_acct_orig_dt", 8,0, false, "错账原日期" )))
							.addNode(new FieldNode("err_acct_orig_tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "err_acct_orig_tlr_rung_num", 32,0, false, "错账原柜员流水号" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

