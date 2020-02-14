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
 * BASESVC.P0230033 贷款结息回单查询
 * P0230033.07 
 * ln3148 新核心系统
 * @author YFK
 */
@Component
public class P023003307 extends EsbCoreChannelService{

	
	private static P023003307_I i = new P023003307_I();
	private static P023003307_O o = new P023003307_O();
	public P023003307() {
		requestFormat.add(i);
		responseFormat.add(o);
	}
	
	public static class P023003307_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("loan_due_bill_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"loan_due_bill_num" ,30,0, false, "贷款借据号" )))
					.addNode(new FieldNode("rpymt_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"rpymt_acct_num" ,40,0, false, "还款账号" )))
					.addNode(new FieldNode("db_int_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"db_int_amt" ,18,0, false, "欠息金额" )))
					.addNode(new FieldNode("strt_dt_8",new MsgField(ContentEnum.MessageType.STRING.toString(),"strt_dt_8" ,8,0, false, "起始日期" )))
					.addNode(new FieldNode("end_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"end_dt" ,8,0, false, "终止日期" )))
					.addNode(new FieldNode("strt_cnt_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"strt_cnt_num" ,10,0, false, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"qry_cnt_num" ,10,0, false, "查询笔数" )))
					.addNode(new FieldNode("prt_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"prt_flg" ,1,0, false, "打印标志" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	public static class P023003307_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("lst_klnl_int_stlmt_sche_list",false)
							.addNode(new FieldNode("detl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"detl_num" ,60,0, false, "明细编号  " )))
							.addNode(new FieldNode("loan_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"loan_acct_num" ,40,0, false, "贷款账号  " )))
							.addNode(new FieldNode("loan_due_bill_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"loan_due_bill_num" ,30,0, false, "贷款借据号  " )))
							.addNode(new FieldNode("ctrct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"ctrct_num" ,80,0, false, "合同编号  " )))
							.addNode(new FieldNode("cust_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"cust_num" ,32,0, false, "客户号  " )))
							.addNode(new FieldNode("cust_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"cust_nm" ,256,0, false, "客户名称  " )))
							.addNode(new FieldNode("oprtg_org",new MsgField(ContentEnum.MessageType.STRING.toString(),"oprtg_org" ,12,0, false, "营业机构  " )))
							.addNode(new FieldNode("ccy_code_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"ccy_code_num" ,3,0, false, "货币代号  " )))
							.addNode(new FieldNode("due_bill_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"due_bill_amt" ,18,0, false, "借据金额  " )))
							.addNode(new FieldNode("lendg_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"lendg_dt" ,8,0, false, "放款日期  " )))
							.addNode(new FieldNode("nrl_int_rate",new MsgField(ContentEnum.MessageType.STRING.toString(),"nrl_int_rate" ,12,0, false, "正常利率  " )))
							.addNode(new FieldNode("ovdue_int_rate",new MsgField(ContentEnum.MessageType.STRING.toString(),"ovdue_int_rate" ,12,0, false, "逾期利率  " )))
							.addNode(new FieldNode("cmpd_int_rate",new MsgField(ContentEnum.MessageType.STRING.toString(),"cmpd_int_rate" ,12,0, false, "复利利率  " )))
							.addNode(new FieldNode("nrl_prcpl",new MsgField(ContentEnum.MessageType.STRING.toString(),"nrl_prcpl" ,18,0, false, "正常本金  " )))
							.addNode(new FieldNode("ovdue_prcpl",new MsgField(ContentEnum.MessageType.STRING.toString(),"ovdue_prcpl" ,18,0, false, "逾期本金  " )))
							.addNode(new FieldNode("stgnt_prcpl",new MsgField(ContentEnum.MessageType.STRING.toString(),"stgnt_prcpl" ,18,0, false, "呆滞本金  " )))
							.addNode(new FieldNode("ucoltb_prcpl",new MsgField(ContentEnum.MessageType.STRING.toString(),"ucoltb_prcpl" ,18,0, false, "呆账本金  " )))
							.addNode(new FieldNode("rcvbl_acd_int",new MsgField(ContentEnum.MessageType.STRING.toString(),"rcvbl_acd_int" ,18,0, false, "应收应计利息  " )))
							.addNode(new FieldNode("urge_collt_acd_int",new MsgField(ContentEnum.MessageType.STRING.toString(),"urge_collt_acd_int" ,18,0, false, "催收应计利息  " )))
							.addNode(new FieldNode("rcvbl_acd_pnly_int",new MsgField(ContentEnum.MessageType.STRING.toString(),"rcvbl_acd_pnly_int" ,18,0, false, "应收应计罚息  " )))
							.addNode(new FieldNode("urge_collt_acd_pnly_int",new MsgField(ContentEnum.MessageType.STRING.toString(),"urge_collt_acd_pnly_int" ,18,0, false, "催收应计罚息  " )))
							.addNode(new FieldNode("acd_cmpd_int",new MsgField(ContentEnum.MessageType.STRING.toString(),"acd_cmpd_int" ,18,0, false, "应计复息  " )))
							.addNode(new FieldNode("acd_subsd_int",new MsgField(ContentEnum.MessageType.STRING.toString(),"acd_subsd_int" ,18,0, false, "应计贴息  " )))
							.addNode(new FieldNode("alrdy_chk_write_off_prcpl_int",new MsgField(ContentEnum.MessageType.STRING.toString(),"alrdy_chk_write_off_prcpl_int" ,18,0, false, "已核销本金利息  " )))
							.addNode(new FieldNode("int_caln_beg_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"int_caln_beg_dt" ,8,0, false, "计息开始日  " )))
							.addNode(new FieldNode("int_caln_exp_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"int_caln_exp_dt" ,8,0, false, "计息截止日  " )))
							.addNode(new FieldNode("txn_dt_8",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_dt_8" ,8,0, false, "交易日期  " )))
							.addNode(new FieldNode("txn_rung_num_32",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_rung_num_32" ,32,0, false, "交易流水号" )))
							.addNode(new FieldNode("prt_cnt",new MsgField(ContentEnum.MessageType.STRING.toString(),"prt_cnt" ,10,0, false, "打印次数" )))
							.addNode(new FieldNode("acctg_org_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"acctg_org_nm" ,300,0, false, "账务机构名称" )))
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			// TODO 自动生成的方法存根
			return msgSegment.getNodeList();
		}
	}
	
	
}
