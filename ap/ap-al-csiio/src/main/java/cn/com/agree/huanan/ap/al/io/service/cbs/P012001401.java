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
 * BASESVC.P012001401 账户结构管理.一类账户绑定 
 * P0120014.01 dp2234
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P012001401 extends EsbCoreChannelService {

	private static P012001401_I i = new P012001401_I();
	private static P012001401_O o = new P012001401_O();
	public P012001401() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P012001401_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, true, "子账户序号" )))
					.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("oprn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprn_flg", 1,0, false, "操作标志" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new ArrayNode("listnm_list",false)
							.addNode(new FieldNode("classi_acct_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "classi_acct_cust_acct_num", 40,0, false, "I类账户客户账号" )))
							.addNode(new FieldNode("classi_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "classi_sub_acct_serl_num", 8,0, false, "I类账户子账户序号" )))
							.addNode(new FieldNode("wthr_intra_bank_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_intra_bank_acct_num", 1,0, false, "是否行内账号" )))
							.addNode(new FieldNode("classi_open_acct_bank_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "classi_open_acct_bank_code", 12,0, false, "I类开户行代码" )))
							.addNode(new FieldNode("classi_open_acct_bank_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "classi_open_acct_bank_nm", 256,0, false, "I类开户行名称" )))
							.addNode(new FieldNode("wthr_vrfcn_pass", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_vrfcn_pass", 1,0, false, "是否验证通过" )))
							.addNode(new FieldNode("wthr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_flg", 1,0, false, "是否标志" )))
							.addNode(new FieldNode("classi_acct_cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "classi_acct_cust_nm", 256,0, false, "I类账户客户名称" )))
							.addNode(new FieldNode("bind_acct_clasf", new MsgField(ContentEnum.MessageType.STRING.toString(), "bind_acct_clasf", 1,0, false, "绑定账户分类" )))
							.addNode(new FieldNode("id_vrfcn_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "id_vrfcn_way", 1,0, false, "身份核验方式" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P012001401_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("remks", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks", 300,0, false, "备注信息" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

