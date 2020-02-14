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
 * BASESVC.S012001507 机构管理.网点账务平衡检查 
 * S0120015.07 br5334
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class S012001507 extends EsbCoreChannelService {

	private static S012001507_I i = new S012001507_I();
	private static S012001507_O o = new S012001507_O();
	public S012001507() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S012001507_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, true, "营业机构" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S012001507_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("txn_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_org", 12,0, false, "交易机构" )))
					.addNode(new FieldNode("bal_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "bal_ste", 1,0, false, "平衡状态" )))
					.addNode(new FieldNode("mber_qty", new MsgField(ContentEnum.MessageType.INT.toString(), "mber_qty", 10,0, false, "成员数量" )))
					.addNode(new ArrayNode("listnm_list",false)
							.addNode(new FieldNode("in_bal_off_bal_sheet_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "in_bal_off_bal_sheet_flg", 1,0, false, "表内表外标志" )))
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("bal_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "bal_ste", 1,0, false, "平衡状态" )))
							.addNode(new FieldNode("db_occr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "db_occr_amt", 18,2, false, "借方发生额" )))
							.addNode(new FieldNode("cr_occr_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "cr_occr_amt", 18,2, false, "贷方发生额" )))
							.addNode(new FieldNode("offset_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "offset_bal", 18,2, false, "轧差" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

