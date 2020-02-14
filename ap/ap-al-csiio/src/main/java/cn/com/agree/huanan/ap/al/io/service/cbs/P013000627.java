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
 * BASESVC.P013000627 账户信息查询.社保卡账户信息查询 
 * P0130006.27 cd1104
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P013000627 extends EsbCoreChannelService {

	private static P013000627_I i = new P013000627_I();
	private static P013000627_O o = new P013000627_O();
	public P013000627() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013000627_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, true, "卡号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013000627_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("cust_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_nm", 256,0, false, "客户账户名称" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号" )))
					.addNode(new FieldNode("acct_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_ste", 4,0, false, "账户状态" )))
					.addNode(new FieldNode("card_vchr_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_vchr_ste", 1,0, false, "卡凭证状态" )))
					.addNode(new FieldNode("open_acct_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_org", 12,0, false, "开户机构" )))
					.addNode(new FieldNode("acct_bal", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "acct_bal", 18,2, false, "账户余额" )))
					.addNode(new FieldNode("scry_card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "scry_card_num", 40,0, false, "社保卡号" )))
					.addNode(new FieldNode("scry_acct_bal", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "scry_acct_bal", 18,2, false, "社保账户余额" )))
					.addNode(new FieldNode("scry_acct_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "scry_acct_ste", 4,0, false, "社保账户状态" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

