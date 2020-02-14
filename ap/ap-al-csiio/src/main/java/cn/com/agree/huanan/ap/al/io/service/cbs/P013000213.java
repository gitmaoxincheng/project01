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
 * BASESVC.P0130002 账户付息历史明细查询
 * P0130002.13 
 * dp2033 新核心系统
 * @author YFK
 */
@Component
public class P013000213 extends EsbCoreChannelService{

	
	private static P013000213_I i = new P013000213_I();
	private static P013000213_O o = new P013000213_O();
	public P013000213() {
		requestFormat.add(i);
		responseFormat.add(o);
	}
	
	public static class P013000213_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"cust_acct_num" ,40,0, false, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"sub_acct_serl_num" ,8,0, false, "子账户序号" )))
					.addNode(new FieldNode("acct_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"acct_nm" ,256,0, false, "账户名称" )))
					.addNode(new FieldNode("strt_dt_8",new MsgField(ContentEnum.MessageType.STRING.toString(),"strt_dt_8" ,8,0, false, "起始日期" )))
					.addNode(new FieldNode("end_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"end_dt" ,8,0, false, "终止日期" )))
					.addNode(new FieldNode("strt_cnt_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"strt_cnt_num" ,10,0, false, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"qry_cnt_num" ,10,0, false, "查询笔数" )))
					.addNode(new FieldNode("wthr_prt_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"wthr_prt_flg" ,1,0, false, "打印标志" )))
					.addNode(new ArrayNode("print01_list",false)
							.addNode(new FieldNode("grp_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"grp_serl_num" ,10,0, false, "组序号" )))
							.addNode(new FieldNode("serl_num_long",new MsgField(ContentEnum.MessageType.STRING.toString(),"serl_num_long" ,10,0, false, "序号" )))
							.addNode(new FieldNode("int_tp",new MsgField(ContentEnum.MessageType.STRING.toString(),"int_tp" ,8,0, false, "利息类型" )))
							.addNode(new FieldNode("txn_dt_8",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_dt_8" ,8,0, false, "交易日期" )))
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	
	public static class P013000213_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("smtn_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"smtn_amt" ,18,0, false, "合计金额" )))
					.addNode(new ArrayNode("listnm01_list",false)
					.addNode(new FieldNode("txn_ccy",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_ccy" ,3,0, false, "交易币种" )))
					.addNode(new FieldNode("int_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"int_amt" ,18,0, false, "利息金额" )))
					.addNode(new FieldNode("actl_int_occr_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"actl_int_occr_amt" ,18,0, false, "实际利息发生额" )))
					.addNode(new FieldNode("int_tax",new MsgField(ContentEnum.MessageType.STRING.toString(),"int_tax" ,18,0, false, "利息税" )))
					.addNode(new FieldNode("int_aft_tax",new MsgField(ContentEnum.MessageType.STRING.toString(),"int_aft_tax" ,18,0, false, "税后利息" )))
					.addNode(new FieldNode("int_trfr_in_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"int_trfr_in_acct_num" ,40,0, false, "利息转入账号" )))
					.addNode(new FieldNode("int_trfr_in_acct_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"int_trfr_in_acct_nm" ,256,0, false, "利息转入账户名称" )))
					.addNode(new FieldNode("txn_dt_8",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_dt_8" ,8,0, false, "交易日期" )))
					.addNode(new FieldNode("int_rate",new MsgField(ContentEnum.MessageType.STRING.toString(),"int_rate" ,12,0, false, "利率" )))
					.addNode(new FieldNode("int_tax_rate",new MsgField(ContentEnum.MessageType.STRING.toString(),"int_tax_rate" ,8,0, false, "利息税税率" )))
					.addNode(new FieldNode("int_stlmt_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"int_stlmt_dt" ,8,0, false, "结息日期" )))
					.addNode(new FieldNode("strt_int_caln_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"strt_int_caln_dt" ,8,0, false, "起息日期" )))
					.addNode(new FieldNode("stop_int_caln_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"stop_int_caln_dt" ,8,0, false, "止息日期" )))
					.addNode(new FieldNode("txn_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_amt" ,18,0, false, "交易金额" )))
					.addNode(new FieldNode("draw_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"draw_amt" ,18,0, false, "支取金额" )))
					.addNode(new FieldNode("abst_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"abst_code" ,10,0, false, "摘要代码" )))
					.addNode(new FieldNode("abst_dsc",new MsgField(ContentEnum.MessageType.STRING.toString(),"abst_dsc" ,225,0, false, "摘要描述" )))
					.addNode(new FieldNode("dept_prd",new MsgField(ContentEnum.MessageType.STRING.toString(),"dept_prd" ,6,0, false, "存期" )))
					.addNode(new FieldNode("tlr_rung_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"tlr_rung_num" ,32,0, false, "柜员流水号" )))
					.addNode(new FieldNode("grp_serl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"grp_serl_num" ,10,0, false, "组序号" )))
					.addNode(new FieldNode("serl_num_long",new MsgField(ContentEnum.MessageType.STRING.toString(),"serl_num_long" ,10,0, false, "序号" )))
					.addNode(new FieldNode("int_tp",new MsgField(ContentEnum.MessageType.STRING.toString(),"int_tp" ,8,0, false, "利息类型" )))
					.addNode(new FieldNode("prt_cnt",new MsgField(ContentEnum.MessageType.STRING.toString(),"prt_cnt" ,10,0, false, "打印次数" )))
					.addNode(new FieldNode("acmlv_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"acmlv_num" ,18,0, false, "积数" )))
					.addNode(new FieldNode("open_acct_org",new MsgField(ContentEnum.MessageType.STRING.toString(),"open_acct_org" ,12,0, false, "开户机构" )))
					.addNode(new FieldNode("open_acct_org_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"open_acct_org_nm" ,300,0, false, "开户机构名称" )))
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	
}
