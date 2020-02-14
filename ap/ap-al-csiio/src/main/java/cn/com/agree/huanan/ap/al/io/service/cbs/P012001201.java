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
@Component
public class P012001201 extends EsbCoreChannelService {

	private static P012001201_I i = new P012001201_I();
	private static P012001201_O o = new P012001201_O();
	public P012001201() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P012001201_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("new_old_acct_num_cvrsn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "new_old_acct_num_cvrsn_flg", 1,0, true, "新老账号转换标志" )))
					.addNode(new FieldNode("chk_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "chk_cond", 32,0, true, "检查条件" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
					.addNode(new FieldNode("chk_pswd_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "chk_pswd_flg", 256,0, false, "校验密码标志" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
					.addNode(new FieldNode("pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd", 32,0, false, "密码" )))
					);
					
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P012001201_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账号" )))
					.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, true, "卡号" )))
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("vchr_num", new MsgField(ContentEnum.MessageType.INT.toString(), "vchr_num", 32,0, false, "凭证号码" )))
					.addNode(new FieldNode("dept_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_catg", 3,0, false, "存款种类" )))
					.addNode(new FieldNode("prod_blgd_obj", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_blgd_obj", 1,0, false, "产品所属对象" )))
					.addNode(new FieldNode("lblty_prod_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_prod_tp", 1,0, false, "负债产品类型" )))
					.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
					.addNode(new FieldNode("open_acct_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_org", 20,0, false, "开户机构" )))
					.addNode(new FieldNode("acct_clasf_code_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf_code_01", 10,0, false, "账户分类代码1" )))
					.addNode(new FieldNode("acct_clasf_code_02", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf_code_02", 10,0, false, "账户分类代码2" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}


