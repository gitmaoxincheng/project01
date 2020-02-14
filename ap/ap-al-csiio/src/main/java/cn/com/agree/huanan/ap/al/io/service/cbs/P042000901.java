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
 * BASESVC.P042000901 银行卡状态管理.个人卡激活 
 * P0420009.01 cd1195
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P042000901 extends EsbCoreChannelService {

	private static P042000901_I i = new P042000901_I();
	private static P042000901_O o = new P042000901_O();
	public P042000901() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P042000901_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账号" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, true, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, true, "证件号码" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("new_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "new_pswd", 32,0, true, "新密码" )))
					.addNode(new FieldNode("old_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "old_pswd", 32,0, false, "旧密码" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, true, "客户名称" )))
					.addNode(new FieldNode("actv_resn", new MsgField(ContentEnum.MessageType.STRING.toString(), "actv_resn", 255,0, false, "激活原因" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P042000901_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, false, "卡号" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("cust_max_cdhdg_qty", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_max_cdhdg_qty", 10,0, false, "客户最大持卡量" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

