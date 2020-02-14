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
 * BASESVC.P023003301 客户回单查询
 * P023003301 
 * ln3121 新核心系统
 * @author YFK
 */
@Component
public class P023003301 extends EsbCoreChannelService{

	
	private static P023003301_I i = new P023003301_I();
	private static P023003301_O o = new P023003301_O();
	public P023003301() {
		requestFormat.add(i);
		responseFormat.add(o);
	}
	public static class P023003301_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("loan_due_bill_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"loan_due_bill_num" ,30,0, false, "贷款借据号" )))
					.addNode(new FieldNode("rpymt_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"rpymt_acct_num" ,40,0, false, "还款账号" )))
					.addNode(new FieldNode("txn_dt_8",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_dt_8" ,8,0, false, "交易日期" )))
					.addNode(new FieldNode("txn_rung_num_32",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_rung_num_32" ,32,0, false, "交易流水号" )))
					.addNode(new FieldNode("strt_cnt_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"strt_cnt_num" ,10,0, false, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"qry_cnt_num" ,10,0, false, "查询笔数" )))
					.addNode(new FieldNode("prt_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"prt_flg" ,1,0, false, "打印标志" )))
					.addNode(new FieldNode("rpymt_totl_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"rpymt_totl_amt" ,18,0, false, "还款总额" )))
					.addNode(new FieldNode("strt_dt_8",new MsgField(ContentEnum.MessageType.STRING.toString(),"strt_dt_8" ,8,0, false, "起始日期" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	public static class P023003301_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("lnCustRpymtDetl_list",false)
							.addNode(new FieldNode("detl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"detl_num" ,60,0, false, "明细编号" )))
							.addNode(new FieldNode("loan_due_bill_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"loan_due_bill_num" ,30,0, false, "贷款借据号" )))
							.addNode(new FieldNode("ccy_code_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"ccy_code_num" ,3,0, false, "货币代号" )))
							.addNode(new FieldNode("oprtg_org",new MsgField(ContentEnum.MessageType.STRING.toString(),"oprtg_org" ,12,0, false, "营业机构" )))
							.addNode(new FieldNode("txn_dt_8",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_dt_8" ,8,0, false, "交易日期" )))
							.addNode(new FieldNode("loan_pstg_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"loan_pstg_acct_num" ,40,0, false, "贷款入账账号" )))
							.addNode(new FieldNode("lendg_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"lendg_amt" ,18,0, false, "放款金额" )))
							.addNode(new FieldNode("lendg_cptl_deal_way",new MsgField(ContentEnum.MessageType.STRING.toString(),"lendg_cptl_deal_way" ,1,0, false, "放款资金处理方式" )))
							.addNode(new FieldNode("wait_write_off_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"wait_write_off_serl_num" ,40,0, false, "待销账序号" )))
							.addNode(new FieldNode("frz_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"frz_num" ,60,0, false, "冻结编号" )))
							.addNode(new FieldNode("nrl_prcpl",new MsgField(ContentEnum.MessageType.STRING.toString(),"nrl_prcpl" ,18,0, false, "正常本金" )))
							.addNode(new FieldNode("ovdue_prcpl",new MsgField(ContentEnum.MessageType.STRING.toString(),"ovdue_prcpl" ,18,0, false, "逾期本金" )))
							.addNode(new FieldNode("stgnt_prcpl",new MsgField(ContentEnum.MessageType.STRING.toString(),"stgnt_prcpl" ,18,0, false, "呆滞本金" )))
							.addNode(new FieldNode("ucoltb_prcpl",new MsgField(ContentEnum.MessageType.STRING.toString(),"ucoltb_prcpl" ,18,0, false, "呆账本金" )))
							.addNode(new FieldNode("cptl_src",new MsgField(ContentEnum.MessageType.STRING.toString(),"cptl_src" ,1,0, false, "资金来源" )))
							.addNode(new FieldNode("rpymt_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"rpymt_acct_num" ,40,0, false, "还款账号" )))
							.addNode(new FieldNode("aval_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"aval_amt" ,18,0, false, "可用金额" )))
							.addNode(new FieldNode("rpymt_totl_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"rpymt_totl_amt" ,18,0, false, "还款总额" )))
							.addNode(new FieldNode("rpymt_ste",new MsgField(ContentEnum.MessageType.STRING.toString(),"rpymt_ste" ,1,0, false, "还款状态" )))
							.addNode(new FieldNode("ret_prcpl",new MsgField(ContentEnum.MessageType.STRING.toString(),"ret_prcpl" ,18,0, false, "归还本金" )))
							.addNode(new FieldNode("ret_rcvbl_acd_int",new MsgField(ContentEnum.MessageType.STRING.toString(),"ret_rcvbl_acd_int" ,18,0, false, "归还应收应计利息" )))
							.addNode(new FieldNode("ret_urge_collt_acd_int",new MsgField(ContentEnum.MessageType.STRING.toString(),"ret_urge_collt_acd_int" ,18,0, false, "归还催收应计利息" )))
							.addNode(new FieldNode("ret_rcvbl_db_int",new MsgField(ContentEnum.MessageType.STRING.toString(),"ret_rcvbl_db_int" ,18,0, false, "归还应收欠息" )))
							.addNode(new FieldNode("ret_urge_collt_db_int",new MsgField(ContentEnum.MessageType.STRING.toString(),"ret_urge_collt_db_int" ,18,0, false, "归还催收欠息" )))
							.addNode(new FieldNode("ret_rcvbl_acd_pnly_int",new MsgField(ContentEnum.MessageType.STRING.toString(),"ret_rcvbl_acd_pnly_int" ,18,0, false, "归还应收应计罚息" )))
							.addNode(new FieldNode("ret_urge_collt_acd_pnly_int",new MsgField(ContentEnum.MessageType.STRING.toString(),"ret_urge_collt_acd_pnly_int" ,18,0, false, "归还催收应计罚息" )))
							.addNode(new FieldNode("ret_rcvbl_pnly_int",new MsgField(ContentEnum.MessageType.STRING.toString(),"ret_rcvbl_pnly_int" ,18,0, false, "归还应收罚息" )))
							.addNode(new FieldNode("ret_urge_collt_pnly_int",new MsgField(ContentEnum.MessageType.STRING.toString(),"ret_urge_collt_pnly_int" ,18,0, false, "归还催收罚息" )))
							.addNode(new FieldNode("ret_acd_cmpd_int",new MsgField(ContentEnum.MessageType.STRING.toString(),"ret_acd_cmpd_int" ,18,0, false, "归还应计复息" )))
							.addNode(new FieldNode("ret_cmpd_int",new MsgField(ContentEnum.MessageType.STRING.toString(),"ret_cmpd_int" ,18,0, false, "归还复息" )))
							.addNode(new FieldNode("ret_fine",new MsgField(ContentEnum.MessageType.STRING.toString(),"ret_fine" ,18,0, false, "归还罚金" )))
							.addNode(new FieldNode("ret_fee",new MsgField(ContentEnum.MessageType.STRING.toString(),"ret_fee" ,18,0, false, "归还费用" )))
							.addNode(new FieldNode("txn_org",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_org" ,12,0, false, "交易机构" )))
							.addNode(new FieldNode("txn_tlr",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_tlr" ,10,0, false, "交易柜员" )))
							.addNode(new FieldNode("txn_rung_num_32",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_rung_num_32" ,32,0, false, "交易流水号" )))
							.addNode(new FieldNode("txn_evt",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_evt" ,10,0, false, "交易事件" )))
							.addNode(new FieldNode("evt_comt",new MsgField(ContentEnum.MessageType.STRING.toString(),"evt_comt" ,80,0, false, "事件说明" )))
							.addNode(new FieldNode("txn_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_code" ,20,0, false, "交易码" )))
							.addNode(new FieldNode("abst_dsc",new MsgField(ContentEnum.MessageType.STRING.toString(),"abst_dsc" ,225,0, false, "摘要描述" )))
							.addNode(new FieldNode("cust_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"cust_nm" ,256,0, false, "客户名称" )))
							.addNode(new FieldNode("open_acct_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"open_acct_dt" ,8,0, false, "开户日期" )))
							.addNode(new FieldNode("matu_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"matu_dt" ,8,0, false, "到期日期" )))
							.addNode(new FieldNode("rpymt_acct_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"rpymt_acct_nm" ,256,0, false, "还款账户名称" )))
							.addNode(new FieldNode("prt_cnt",new MsgField(ContentEnum.MessageType.STRING.toString(),"prt_cnt" ,10,0, false, "打印次数" )))
							.addNode(new FieldNode("txn_org_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_org_nm" ,300,0, false, "交易机构名称" )))
							.addNode(new FieldNode("txn_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_nm" ,1500,0, false, "交易名称" )))
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
}
