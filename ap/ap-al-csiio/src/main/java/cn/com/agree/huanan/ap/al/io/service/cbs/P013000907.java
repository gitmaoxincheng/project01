package cn.com.agree.huanan.ap.al.io.service.cbs;

import java.util.ArrayList;   

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbCore1ChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;



/**
 * BASESVC.P013000907 客户电子回单查询（核心+历史库）
 * P0130009.07 
 * 0005 新核心系统
 * @author YFK
 */
@Component
public class P013000907 extends EsbCore1ChannelService {

	private static P013000907_I i = new P013000907_I();
	private static P013000907_O o = new P013000907_O();
	public P013000907() {
		requestFormat.add(i);
		responseFormat.add(o);
	}
	
	public static class P013000907_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("qry_tp",new MsgField(ContentEnum.MessageType.STRING.toString(),"qry_tp" ,1,0, false, "查询类型" )))
					.addNode(new FieldNode("strt_dt_8",new MsgField(ContentEnum.MessageType.STRING.toString(),"strt_dt_8" ,8,0, false, "起始日期" )))
					.addNode(new FieldNode("end_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"end_dt" ,8,0, false, "终止日期" )))
					.addNode(new FieldNode("cust_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"cust_acct_num" ,35,0, false, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"sub_acct_serl_num" ,8,0, false, "子账户序号" )))
					.addNode(new FieldNode("acct_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"acct_nm" ,750,0, false, "账户名称" )))
					.addNode(new FieldNode("tlr_rung_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"tlr_rung_num" ,32,0, false, "柜员流水号号" )))
					.addNode(new FieldNode("cntpr_cust_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"cntpr_cust_acct_num" ,35,0, false, "交易对手账号" )))
					.addNode(new FieldNode("cntpr_acct_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"cntpr_acct_nm" ,750,0, false, "对方户名" )))
					.addNode(new FieldNode("ccy_code_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"ccy_code_num" ,3,0, false, "货币代号" )))
					.addNode(new FieldNode("cash_rmtc_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"cash_rmtc_flg" ,1,0, false, "钞汇标志" )))
					.addNode(new FieldNode("txn_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_amt" ,18,0, false, "交易金额" )))
					.addNode(new FieldNode("oprtg_org",new MsgField(ContentEnum.MessageType.STRING.toString(),"oprtg_org" ,12,0, false, "营业机构" )))
					.addNode(new FieldNode("chnl_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"chnl_code" ,7,0, false, "渠道代码" )))
					.addNode(new FieldNode("prt_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"prt_flg" ,1,0, false, "打印标志" )))
					.addNode(new FieldNode("old_pswd",new MsgField(ContentEnum.MessageType.STRING.toString(),"old_pswd" ,32,0, false, "交易密码" )))
					.addNode(new FieldNode("acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"acct_num" ,40,0, false, "账号" )))
					.addNode(new FieldNode("txn_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_serl_num" ,10,0, false, "起始交易序号" )))
					.addNode(new FieldNode("end_txn_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"end_txn_serl_num" ,10,0, false, "终止交易序号" )))
					.addNode(new FieldNode("strt_cnt_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"strt_cnt_num" ,10,0, false, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"qry_cnt_num" ,10,0, false, "查询笔数" )))
					.addNode(new FieldNode("doc_type",new MsgField(ContentEnum.MessageType.STRING.toString(),"doc_type" ,1,0, false, "单据类型" )))
					.addNode(new FieldNode("db_cr_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"db_cr_flg" ,1,0, false, "借贷标志" )))
					);			
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	public static class P013000907_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("strt_dt_8",new MsgField(ContentEnum.MessageType.STRING.toString(),"strt_dt_8" ,8,0, false, "起始日期" )))
					.addNode(new FieldNode("end_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"end_dt" ,8,0, false, "终止日期" )))
					.addNode(new FieldNode("cnt_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"cnt_num" ,10,0, false, "笔数" )))
					.addNode(new FieldNode("cust_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"cust_acct_num" ,35,0, false, "客户账号" )))
					.addNode(new FieldNode("acct_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"acct_nm" ,750,0, false, "账户名称" )))
					.addNode(new FieldNode("mber_qty",new MsgField(ContentEnum.MessageType.STRING.toString(),"mber_qty" ,10,0, false, "成员数量" )))
					.addNode(new ArrayNode("listnm_list",false)
					.addNode(new FieldNode("txn_dt_8",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_dt_8" ,8,0, false, "交易日期" )))
					.addNode(new FieldNode("txn_tm",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_tm" ,10,0, false, "交易时间" )))
					.addNode(new FieldNode("oprtg_org",new MsgField(ContentEnum.MessageType.STRING.toString(),"oprtg_org" ,12,0, false, "营业机构" )))
					.addNode(new FieldNode("txn_tlr",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_tlr" ,8,0, false, "交易柜员" )))
					.addNode(new FieldNode("tlr_rung_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"tlr_rung_num" ,32,0, false, "柜员流水号号" )))
					.addNode(new FieldNode("txn_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_code" ,20,0, false, "交易码" )))
					.addNode(new FieldNode("txn_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_nm" ,1500,0, false, "交易名称" )))
					.addNode(new FieldNode("cust_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"cust_num" ,16,0, false, "客户号" )))
					.addNode(new FieldNode("open_acct_org",new MsgField(ContentEnum.MessageType.STRING.toString(),"open_acct_org" ,12,0, false, "账户开户机构" )))
					.addNode(new FieldNode("org_chins_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"org_chins_nm" ,256,0, false, "开户行名" )))
					.addNode(new FieldNode("sub_acct_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"sub_acct_serl_num" ,8,0, false, "组合子帐户序号" )))
					.addNode(new FieldNode("acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"acct_num" ,40,0, false, "账号" )))
					.addNode(new FieldNode("txn_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_amt" ,18,0, false, "交易金额" )))
					.addNode(new FieldNode("acct_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"acct_nm" ,750,0, false, "账户名称" )))
					.addNode(new FieldNode("cust_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"cust_acct_num" ,35,0, false, "客户账号" )))
					.addNode(new FieldNode("txn_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_serl_num" ,10,0, false, "交易序号" )))
					.addNode(new FieldNode("ccy_code_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"ccy_code_num" ,3,0, false, "货币代号" )))
					.addNode(new FieldNode("cash_rmtc_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"cash_rmtc_flg" ,1,0, false, "钞汇标志" )))
					.addNode(new FieldNode("db_cr_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"db_cr_flg" ,1,0, false, "借贷标志" )))
					.addNode(new FieldNode("acct_bal",new MsgField(ContentEnum.MessageType.STRING.toString(),"acct_bal" ,21,0, false, "账户余额" )))
					.addNode(new FieldNode("cntpr_cust_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"cntpr_cust_acct_num" ,35,0, false, "交易对手账号" )))
					.addNode(new FieldNode("cntpr_lblty_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"cntpr_lblty_acct_num" ,40,0, false, "对方账号" )))
					.addNode(new FieldNode("cntpr_acct_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"cntpr_acct_nm" ,750,0, false, "对方户名" )))
					.addNode(new FieldNode("cntpr_fincl_org_tp",new MsgField(ContentEnum.MessageType.STRING.toString(),"cntpr_fincl_org_tp" ,2,0, false, "对方金融机构网点类型" )))
					.addNode(new FieldNode("cntpr_fincl_org_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"cntpr_fincl_org_code" ,20,0, false, "对方金融机构网点代码" )))
					.addNode(new FieldNode("cntpr_fincl_org_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"cntpr_fincl_org_nm" ,300,0, false, "对方金融机构网点名称" )))
					.addNode(new FieldNode("abst_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"abst_code" ,10,0, false, "摘要代码" )))
					.addNode(new FieldNode("abst_dsc",new MsgField(ContentEnum.MessageType.STRING.toString(),"abst_dsc" ,225,0, false, "摘要描述" )))
					.addNode(new FieldNode("chnl_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"chnl_code" ,7,0, false, "渠道代码" )))
					.addNode(new FieldNode("remks_info",new MsgField(ContentEnum.MessageType.STRING.toString(),"remks_info" ,1500,0, false, "备注信息" )))
					.addNode(new FieldNode("prt_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"prt_flg" ,1,0, false, "打印标志" )))
					.addNode(new FieldNode("prt_cnt",new MsgField(ContentEnum.MessageType.STRING.toString(),"prt_cnt" ,10,0, false, "打印次数" )))
					.addNode(new FieldNode("doc_type",new MsgField(ContentEnum.MessageType.STRING.toString(),"doc_type" ,1,0, false, "单据类型" )))
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	
}
