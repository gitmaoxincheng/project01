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
 * BASESVC.S013003701 凭证库存/尾箱信息查询.凭证余额清单打印 
 * S0130037.01 br5366
 * 0005 新核心业务系统
 * @author CZP
 */
@Component
public class S013003701 extends EsbCoreChannelService {

	private static S013003701_I i = new S013003701_I();
	private static S013003701_O o = new S013003701_O();

	public S013003701() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013003701_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("qry_prt_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_prt_id", 1,0, true, "查询打印标识" )))
					.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" )))
					.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" )))
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("tlr_cfm_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_cfm_acct_tp", 2,0, false, "柜员平账类型" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "strt_cnt_num", 10,0, true, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "qry_cnt_num", 10,0, true, "查询笔数" )))
					.addNode(new FieldNode("db_cr_flg_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "db_cr_flg_01", 1,0, false, "借贷标志1" )))
					.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期" )))
					.addNode(new FieldNode("txn_rung_num_32", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_rung_num_32", 32,0, false, "交易流水号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S013003701_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("lstBr5366out_list",false)
							.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("vchr_acct_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_acct_class", 6,0, false, "凭证账户类别" )))
							.addNode(new FieldNode("off_bal_sheet_boot", new MsgField(ContentEnum.MessageType.STRING.toString(), "off_bal_sheet_boot", 8,0, false, "表外尾箱" )))
							.addNode(new FieldNode("off_bal_sheet_recpt_totl_cnt", new MsgField(ContentEnum.MessageType.INT.toString(), "off_bal_sheet_recpt_totl_cnt", 10,0, false, "表外收总笔数" )))
							.addNode(new FieldNode("off_bal_sheet_recpt_occr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "off_bal_sheet_recpt_occr_amt", 18,2, false, "表外收发生额" )))
							.addNode(new FieldNode("off_bal_sheet_pymt_totl_cnt", new MsgField(ContentEnum.MessageType.INT.toString(), "off_bal_sheet_pymt_totl_cnt", 10,0, false, "表外付总笔数" )))
							.addNode(new FieldNode("off_bal_sheet_pymt_occr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "off_bal_sheet_pymt_occr_amt", 18,2, false, "表外付发生额" )))
							.addNode(new FieldNode("invty_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "invty_bal", 18,2, false, "库存余额" )))
							.addNode(new FieldNode("strt_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_vchr_serl_num", 32,0, false, "起始凭证序号" )))
							.addNode(new FieldNode("end_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_vchr_serl_num", 32,0, false, "终止凭证序号" )))
							.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("txn_rung_num_32", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_rung_num_32", 32,0, false, "交易流水号" )))
							.addNode(new FieldNode("db_cr_flg_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "db_cr_flg_01", 1,0, false, "借贷标志1" )))
							.addNode(new FieldNode("acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_num", 40,0, false, "账号" )))
							.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" )))
							.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
