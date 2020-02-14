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
 * S0130044.01 业务处理情况查询  交易码：tl5235
 * @author lixq 
 */
@Component
public class S013004401 extends EsbCoreChannelService{

	private static S013004401_I i = new S013004401_I();
	private static S013004401_O o = new S013004401_O();
	public S013004401() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	
	public static class S013004401_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			
			StructNode BODY = new StructNode("APPBody");
			FieldNode qry_prt_id = new FieldNode("qry_prt_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_prt_id", 1,0, false, "查询打印标识" ));
			FieldNode oprtg_org = new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" ));
			FieldNode txn_dt_8 = new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期"));					
			FieldNode tlr_code_num = new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" ));
			FieldNode ccy_code_num = new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, true, "货币代号" ));
			FieldNode modu = new FieldNode("modu", new MsgField(ContentEnum.MessageType.STRING.toString(), "modu", 2,0, false, "模块"));
			FieldNode prod_code = new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品代码" ));
			FieldNode tlr_rung_num = new FieldNode("tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_rung_num", 32,0, false, "柜员流水号	" ));
			FieldNode strt_cnt_num = new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_cnt_num", 10,0, true, "起始笔数"));
			FieldNode qry_cnt_num = new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_cnt_num", 10,0, true, "查询笔数" ));


			BODY.addNode(qry_prt_id);
			BODY.addNode(oprtg_org);
			BODY.addNode(txn_dt_8);
			BODY.addNode(tlr_code_num);
			BODY.addNode(ccy_code_num);
			BODY.addNode(modu);
			BODY.addNode(prod_code);
			BODY.addNode(tlr_rung_num);
			BODY.addNode(strt_cnt_num);
			BODY.addNode(qry_cnt_num);
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
	
	public static class S013004401_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			StructNode  BODY= new StructNode("APPBody");
			
			BODY.addNode(new FieldNode("cash_db_occr_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_db_occr_amt", 20,0, false, "现金借方发生额")));
			BODY.addNode(new FieldNode("cash_db_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_db_cnt_num", 10,0, false, "现金借方笔数")));
			BODY.addNode(new FieldNode("cash_cr_occr_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_cr_occr_amt", 20,0, false, "现金贷方发生额")));
			BODY.addNode(new FieldNode("cash_cr_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_cr_cnt_num", 10,0, false, "现金贷方笔数")));
			BODY.addNode(new FieldNode("trfr_db_occr_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_db_occr_amt", 20,0, false, "转账借方发生额")));
			BODY.addNode(new FieldNode("trfr_db_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_db_cnt_num", 10,0, false, "转账借方笔数")));
			BODY.addNode(new FieldNode("trfr_cr_occr_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_cr_occr_amt", 20,0, false, "转账贷方发生额")));
			BODY.addNode(new FieldNode("trfr_cr_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_cr_cnt_num", 10,0, false, "转账贷方笔数")));
			BODY.addNode(new FieldNode("off_bal_sheet_recpt_occr_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "off_bal_sheet_recpt_occr_amt", 20,0, false, "表外收发生额")));
			BODY.addNode(new FieldNode("off_bal_sheet_recpt_totl_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "off_bal_sheet_recpt_totl_cnt", 10,0, false, "表外收总笔数")));
			BODY.addNode(new FieldNode("off_bal_sheet_pymt_occr_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "off_bal_sheet_pymt_occr_amt", 20,0, false, "表外付发生额")));
			BODY.addNode(new FieldNode("off_bal_sheet_pymt_totl_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "off_bal_sheet_pymt_totl_cnt", 10,0, false, "表外付总笔数")));
			BODY.addNode(new FieldNode("mber_qty", new MsgField(ContentEnum.MessageType.STRING.toString(), "mber_qty", 10,0, false, "成员数量")));
			
			ArrayNode arrayNode = new ArrayNode("listnm");
			arrayNode.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期")));
			arrayNode.addNode(new FieldNode("tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_rung_num", 32,0, false, "柜员流水号")));
			arrayNode.addNode(new FieldNode("txn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_tlr", 10,0, false, "交易柜员")));
			arrayNode.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号")));
			arrayNode.addNode(new FieldNode("modu", new MsgField(ContentEnum.MessageType.STRING.toString(), "modu", 2,0, false, "模块")));
			arrayNode.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品代码")));
			arrayNode.addNode(new FieldNode("cash_trfr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_trfr_flg", 1,0, false, "现转标志")));
			arrayNode.addNode(new FieldNode("db_cr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "db_cr_flg", 1,0, false, "借贷标志")));
			arrayNode.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_amt", 20,0, false, "交易金额")));
			arrayNode.addNode(new FieldNode("txn_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_tm", 10,0, false, "交易时间")));
			arrayNode.addNode(new FieldNode("txn_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_code", 20,0, false, "交易码")));
			arrayNode.addNode(new FieldNode("athrzn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "athrzn_tlr", 10,0, false, "授权柜员")));
			arrayNode.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码")));
			arrayNode.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述")));
			arrayNode.addNode(new FieldNode("txn_oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_oprtg_org", 12,0, false, "交易营业机构")));
			arrayNode.addNode(new FieldNode("acct_oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_oprtg_org", 12,0, false, "账户营业机构")));
			BODY.addNode(arrayNode);
			
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
}
