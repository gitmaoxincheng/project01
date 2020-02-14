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
 * BASESVC.P011000903 存款产品购买.大额存单撤销认购 
 * P0110009.03 dp2339
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P011000903 extends EsbCoreChannelService {

	private static P011000903_I i = new P011000903_I();
	private static P011000903_O o = new P011000903_O();
	public P011000903() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P011000903_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new ArrayNode("lstnm01_list",false)
							.addNode(new FieldNode("sbcrpn_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrpn_num", 32,0, false, "认购编号" )))
							.addNode(new FieldNode("sbcrpn_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrpn_serl_num", 8,0, false, "特殊存款子认购编号" )))
							.addNode(new FieldNode("tran_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "tran_date", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("txn_rung_num_32", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_rung_num_32", 32,0, false, "交易流水号" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P011000903_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("lstnm02_list",false)
							.addNode(new FieldNode("tran_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "tran_date", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("txn_rung_num_32", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_rung_num_32", 32,0, false, "交易流水号" )))
							.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
							.addNode(new FieldNode("prod_prd_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_prd_num", 50,0, false, "产品期次编号" )))
							.addNode(new FieldNode("sbcrpn_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrpn_num", 32,0, false, "认购编号" )))
							.addNode(new FieldNode("spec_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "spec_sub_acct_serl_num", 8,0, false, "特殊存款子认购编号" )))
							.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

