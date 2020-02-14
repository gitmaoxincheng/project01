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
 * BASESVC.P012001006 账户信息维护.对公优免账户维护 
 * P0120010.06 dp2369
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P012001006 extends EsbCoreChannelService {

	private static P012001006_I i = new P012001006_I();
	private static P012001006_O o = new P012001006_O();
	public P012001006() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P012001006_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("pref_exmpt_svc_fee_oprn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pref_exmpt_svc_fee_oprn_flg", 1,0, true, "优免操作标志" )))
					.addNode(new FieldNode("pref_exmpt_svc_fee_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "pref_exmpt_svc_fee_tp", 1,0, false, "优免类型" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户中文名" )))
					.addNode(new FieldNode("pref_exmpt_svc_fee_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pref_exmpt_svc_fee_flg", 1,0, false, "优免标志" )))
					.addNode(new FieldNode("txn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_tlr", 10,0, false, "交易柜员" )))
					.addNode(new FieldNode("no_anul_fee_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "no_anul_fee_flg", 1,0, false, "免年费标志" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P012001006_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户中文名" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("pref_exmpt_svc_fee_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pref_exmpt_svc_fee_flg", 1,0, false, "优免标志" )))
					.addNode(new FieldNode("no_anul_fee_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "no_anul_fee_flg", 1,0, false, "免年费标志" )))
					.addNode(new FieldNode("pref_exmpt_svc_fee_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "pref_exmpt_svc_fee_reason", 2,0, false, "优免原因" )))
					.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" )))
					.addNode(new FieldNode("remks", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks", 300,0, false, "备注" )))
					.addNode(new FieldNode("rept_route", new MsgField(ContentEnum.MessageType.STRING.toString(), "rept_route", 750,0, false, "报表路径" )))
					.addNode(new ArrayNode("listnm_list",false)
							.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
							.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
							.addNode(new FieldNode("pref_exmpt_svc_fee_rec_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "pref_exmpt_svc_fee_rec_ste", 1,0, false, "优免记录状态" )))
							.addNode(new FieldNode("pref_exmpt_svc_fee_oprn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pref_exmpt_svc_fee_oprn_flg", 1,0, false, "优免操作标志" )))
							.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户中文名" )))
							.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
							.addNode(new FieldNode("open_acct_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_org", 12,0, false, "开户机构" )))
							.addNode(new FieldNode("pref_exmpt_svc_fee_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "pref_exmpt_svc_fee_reason", 2,0, false, "优免原因" )))
							.addNode(new FieldNode("remks", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks", 300,0, false, "备注" )))
							.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" )))
							.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("txn_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_tm", 10,0, false, "交易时间" )))
							.addNode(new FieldNode("txn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_tlr", 10,0, false, "交易柜员" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

