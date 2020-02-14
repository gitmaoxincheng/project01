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
 * BASESVC.P012001101 密码管理.密码重置 
 * P0120011.01 ce5125
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P012001101 extends EsbCoreChannelService {

	private static P012001101_I i = new P012001101_I();
	private static P012001101_O o = new P012001101_O();
	public P012001101() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P012001101_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账号" )))
					.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm", 256,0, false, "客户中文名" )))
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("br_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "br_code", 4,0, false, "分行代码" )))
					.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
					.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 32,0, false, "凭证序号" )))
					.addNode(new FieldNode("strt_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_vchr_serl_num", 32,0, false, "起始凭证序号" )))
					.addNode(new FieldNode("end_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_vchr_serl_num", 32,0, false, "终止凭证序号" )))
					.addNode(new FieldNode("par_val", new MsgField(ContentEnum.MessageType.INT.toString(), "par_val", 18,2, false, "面值" )))
					.addNode(new FieldNode("pswd_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_catg", 2,0, true, "密码种类" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("loss_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "loss_num", 60,0, false, "挂失编号" )))
					//.addNode(new FieldNode("pswd_mgmt_set_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_mgmt_set_num", 30,0, false, "密码管理集编号" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, true, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, true, "证件号码" )))
					.addNode(new FieldNode("pswd_ciptxt", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_ciptxt", 32,0, false, "密码密文" )))
					.addNode(new FieldNode("new_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "new_pswd", 300,0, true, "新密码" )))
					.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
					.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
					.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
					.addNode(new FieldNode("pswd_reset_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_reset_type", 2,0, false, "密码重置类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P012001101_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
					.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 32,0, false, "凭证序号" )))
					.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm", 256,0, false, "客户中文名" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("pswd_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_catg", 2,0, false, "密码种类" )))
					.addNode(new FieldNode("pswd_mgmt_set_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_mgmt_set_num", 30,0, false, "密码管理集编号" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
