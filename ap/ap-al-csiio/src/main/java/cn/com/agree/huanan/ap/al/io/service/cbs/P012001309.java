package cn.com.agree.huanan.ap.al.io.service.cbs;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbCoreChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P012001309 负债业务参数维护.客户自定义限额 
 * P0120013.09 dp2015
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P012001309 extends EsbCoreChannelService {

	private static P012001309_I i = new P012001309_I();
	private static P012001309_O o = new P012001309_O();
	public P012001309() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P012001309_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_limit_sign_oprn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_limit_sign_oprn_flg", 1,0, true, "客户限额签约操作标志" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("intra_trfr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "intra_trfr_flg", 1,0, false, "行内转账" )))
					.addNode(new FieldNode("inter_trfr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "inter_trfr_flg", 1,0, false, "跨行转账" )))
					.addNode(new FieldNode("overseas_cash_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "overseas_cash_flg", 1,0, false, "境外取现" )))
					.addNode(new FieldNode("dly_intra_trfr_acmld", new MsgField(ContentEnum.MessageType.INT.toString(), "dly_intra_trfr_acmld", 18,2, false, "行内转账日累计限额" )))
					.addNode(new FieldNode("dly_inter_trfr_acmld", new MsgField(ContentEnum.MessageType.INT.toString(), "dly_inter_trfr_acmld", 18,2, false, "跨行转账日累计限额" )))
					.addNode(new FieldNode("dly_domestic_acmld", new MsgField(ContentEnum.MessageType.INT.toString(), "dly_domestic_acmld", 18,2, false, "境内消费日累计限额" )))
					.addNode(new FieldNode("dly_overseas_acmld", new MsgField(ContentEnum.MessageType.INT.toString(), "dly_overseas_acmld", 18,2, false, "境外消费日累计限额" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 300,0, false, "交易密码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P012001309_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("intra_trfr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "intra_trfr_flg", 1,0, false, "行内转账" )))
					.addNode(new FieldNode("inter_trfr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "inter_trfr_flg", 1,0, false, "跨行转账" )))
					.addNode(new FieldNode("overseas_cash_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "overseas_cash_flg", 1,0, false, "境外取现" )))
					.addNode(new FieldNode("dly_intra_trfr_acmld", new MsgField(ContentEnum.MessageType.INT.toString(), "dly_intra_trfr_acmld", 18,2, false, "行内转账日累计限额" )))
					.addNode(new FieldNode("dly_inter_trfr_acmld", new MsgField(ContentEnum.MessageType.INT.toString(), "dly_inter_trfr_acmld", 18,2, false, "跨行转账日累计限额" )))
					.addNode(new FieldNode("dly_domestic_acmld", new MsgField(ContentEnum.MessageType.INT.toString(), "dly_domestic_acmld", 18,2, false, "境内消费日累计限额" )))
					.addNode(new FieldNode("dly_overseas_acmld", new MsgField(ContentEnum.MessageType.INT.toString(), "dly_overseas_acmld", 18,2, false, "境外消费日累计限额" )))
					.addNode(new FieldNode("dly_intra_trfr_rsdl", new MsgField(ContentEnum.MessageType.INT.toString(), "dly_intra_trfr_rsdl", 18,2, false, "行内转账日累计剩余限额" )))
					.addNode(new FieldNode("dly_inter_trfr_rsdl", new MsgField(ContentEnum.MessageType.INT.toString(), "dly_inter_trfr_rsdl", 18,2, false, "跨行转账日累计剩余限额" )))
					.addNode(new FieldNode("dly_domestic_rsdl", new MsgField(ContentEnum.MessageType.INT.toString(), "dly_domestic_rsdl", 18,2, false, "境内消费日累计剩余限额" )))
					.addNode(new FieldNode("dly_overseas_rsdl", new MsgField(ContentEnum.MessageType.INT.toString(), "dly_overseas_rsdl", 18,2, false, "境外消费日累计剩余限额" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

