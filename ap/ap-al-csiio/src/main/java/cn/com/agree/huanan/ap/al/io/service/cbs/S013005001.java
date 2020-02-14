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
 * BASESVC.S013005001 现金库存/尾箱信息查询.现金余额信息查询 
 * S0130050.01 br5365
 * 0005 新核心业务系统
 * @author CZP
 */
@Component
public class S013005001 extends EsbCoreChannelService {

	private static S013005001_I i = new S013005001_I();
	private static S013005001_O o = new S013005001_O();

	public S013005001() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013005001_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("qry_prt_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_prt_id", 1,0, true, "查询打印标识" )))
					.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" )))
					.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("tlr_cfm_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_cfm_acct_tp", 2,0, false, "柜员平账类型" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "strt_cnt_num", 10,0, true, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "qry_cnt_num", 10,0, true, "查询笔数" )))
					.addNode(new FieldNode("boot_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_num", 8,0, false, "尾箱号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S013005001_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("lstBr5365out_list",false)
							.addNode(new FieldNode("cash_acct_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_acct_class", 4,0, false, "现金账户类别" )))
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("boot_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_num", 8,0, false, "尾箱号" )))
							.addNode(new FieldNode("cash_db_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "cash_db_cnt_num", 10,0, false, "现金借方笔数" )))
							.addNode(new FieldNode("cash_db_occr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "cash_db_occr_amt", 18,2, false, "现金借方发生额" )))
							.addNode(new FieldNode("cash_cr_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "cash_cr_cnt_num", 10,0, false, "现金贷方笔数" )))
							.addNode(new FieldNode("cash_cr_occr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "cash_cr_occr_amt", 18,2, false, "现金贷方发生额" )))
							.addNode(new FieldNode("invty_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "invty_bal", 18,2, false, "库存余额" )))
							.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" )))
							.addNode(new FieldNode("last_dy_acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "last_dy_acct_bal", 18,2, false, "上日余额" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
