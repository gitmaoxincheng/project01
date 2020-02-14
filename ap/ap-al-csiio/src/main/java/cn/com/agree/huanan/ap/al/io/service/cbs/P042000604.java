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
 * BASESVC.P042000604 借记卡实时发卡.虚拟卡发卡 
 * P0420006.04 cd1172
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P042000604 extends EsbCoreChannelService {

	private static P042000604_I i = new P042000604_I();
	private static P042000604_O o = new P042000604_O();
	public P042000604() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P042000604_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, true, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, true, "证件号码" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, true, "客户名称" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, true, "客户号" )))
					.addNode(new FieldNode("card_issn_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_issn_org", 12,0, false, "发卡机构" )))
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, true, "产品代码" )))
					.addNode(new FieldNode("prod_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_dsc", 750,0, false, "产品描述" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 32,0, true, "交易密码" )))
					.addNode(new FieldNode("acct_attr_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_attr_code", 3,0, true, "账户属性代码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P042000604_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("vld_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "vld_dt", 8,0, false, "有效日期" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, false, "卡号" )))
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品代码" )))
					.addNode(new FieldNode("prod_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_dsc", 750,0, false, "产品描述" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

