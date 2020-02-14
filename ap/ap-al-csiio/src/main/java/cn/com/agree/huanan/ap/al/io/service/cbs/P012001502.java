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
 * BASESVC.P012001502 存款凭证管理.存折补登 
 * P0120015.02 dp2075
 * 0005 新核心系统
 * @author 
 */
@Component
public class P012001502 extends EsbCoreChannelService {

	private static P012001502_I i = new P012001502_I();
	private static P012001502_O o = new P012001502_O();
	public P012001502() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P012001502_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账号" )))
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 32,0, false, "凭证序号" )))
					.addNode(new FieldNode("qry_prt_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_prt_id", 1,0, false, "查询打印标识" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P012001502_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("next_prt_row_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "next_prt_row_num", 10,0, false, "下一打印行数" )))
					.addNode(new FieldNode("first_half_page_row_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "first_half_page_row_num", 10,0, false, "上半页行数" )))
					.addNode(new FieldNode("sec_half_page_row_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sec_half_page_row_num", 10,0, false, "下半页行数" )))
					.addNode(new FieldNode("wthr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_flg", 1,0, false, "是否标志" )))
					.addNode(new ArrayNode("listnm01_list",false)
							.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("open_acct_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_dt", 8,0, false, "开户日期" )))
							.addNode(new FieldNode("prt_row_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prt_row_num", 10,0, false, "打印行数" )))
							.addNode(new FieldNode("txn_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_org", 12,0, false, "交易机构" )))
							.addNode(new FieldNode("host_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "host_dt", 8,0, false, "主机日期" )))
							.addNode(new FieldNode("txn_tm", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_tm", 10,0, false, "交易时间" )))
							.addNode(new FieldNode("serl_num_long", new MsgField(ContentEnum.MessageType.INT.toString(), "serl_num_long", 10,0, false, "序号" )))
							.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
							.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
							.addNode(new FieldNode("acctg_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(),"acctg_acct_num",40,0,false,"记账账号")))
							.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(),"prod_code",10,0,false,"产品编号")))
							.addNode(new FieldNode("seq_num", new MsgField(ContentEnum.MessageType.INT.toString(),"seq_num",10,0,false,"顺序号")))
							.addNode(new FieldNode("strt_int_caln_dt", new MsgField(ContentEnum.MessageType.STRING.toString(),"strt_int_caln_dt",8,0,false,"起息日期")))
							.addNode(new FieldNode("rdept_dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(),"rdept_dept_prd",6,0,false,"转存期")))
							.addNode(new FieldNode("int_rate", new MsgField(ContentEnum.MessageType.INT.toString(),"int_rate",12,7,false,"利率")))
							.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(),"dept_prd",6,0,false,"存期")))
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(),"abst_code",10,0,false,"摘要代码")))
							.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(),"abst_dsc",225,0,false,"摘要描述")))
							.addNode(new FieldNode("db_cr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "db_cr_flg", 1,0, false, "借贷标志" )))
							.addNode(new FieldNode("cash_trfr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(),"cash_trfr_flg",1,0,false,"现转标志")))
							.addNode(new FieldNode("tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(),"tlr_rung_num",40,0,false,"柜员流水号")))
                            .addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
							.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
							.addNode(new FieldNode("acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "acct_bal", 18,2, false, "账户余额" )))
							.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" )))
							.addNode(new FieldNode("athrzn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "athrzn_tlr", 10,0, false, "授权柜员" )))
							.addNode(new FieldNode("txn_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_code", 20,0, false, "交易码" )))
							.addNode(new FieldNode("busi_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_code_num", 6,0, false, "业务代号" )))
							.addNode(new FieldNode("wthr_prt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_prt_flg", 1,0, false, "打印标志" )))
							.addNode(new FieldNode("dept_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_catg", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "存款种类" )))
							.addNode(new FieldNode("rvrs_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rvrs_flg", 1,0, false, "冲正标志" )))
							.addNode(new FieldNode("be_rvrsd_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "be_rvrsd_flg", 1,0, false, "被冲正标志" )))
							.addNode(new FieldNode("err_acct_orig_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "err_acct_orig_dt",8,0, false, "错账原日期" )))
							.addNode(new FieldNode("err_acct_orig_tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "err_acct_orig_tlr_rung_num", 32,0, false, "错账原柜员流水号" )))
							.addNode(new FieldNode("int_val", new MsgField(ContentEnum.MessageType.INT.toString(), "int_val", 18,2, false, "利息" )))
							.addNode(new FieldNode("int_tax", new MsgField(ContentEnum.MessageType.INT.toString(), "int_tax", 18,2, false, "利息税" )))
							.addNode(new FieldNode("_row_num", new MsgField(ContentEnum.MessageType.INT.toString(), "_row_num", 10,0, false, "打印行数" )))
							.addNode(new FieldNode("lgl_pern_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "lgl_pern_code", 4,0, false, "法人代码" )))
							.addNode(new FieldNode("mntnc_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_tlr", 10,0, false, "维护柜员" )))
							.addNode(new FieldNode("mntnc_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_org", 12,0, false, "维护机构" )))
							.addNode(new FieldNode("mntnc_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_tm", 6,0, false, "维护时间" )))
							.addNode(new FieldNode("tmstp", new MsgField(ContentEnum.MessageType.INT.toString(), "tmstp", 25,0, false, "时间戳" )))
							.addNode(new FieldNode("rec_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "rec_ste", 1,0, false, "记录状态 " )))
							.addNode(new FieldNode("rdept_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_way", 1,0, false, "转存方式" )))
							.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
							.addNode(new FieldNode("prt_pgs", new MsgField(ContentEnum.MessageType.STRING.toString(), "prt_pgs", 10,0, false, "打印页数" )))
							.addNode(new FieldNode("glbl_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "glbl_rung_num", 32,0, false, "全局流水号" )))
							.addNode(new FieldNode("remks", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks", 300,0, false, "备注" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

