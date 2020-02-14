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
 * BASESVC.P012001001 账户信息维护.账户升/降级设置 
 * P0120010.01 dp2230
 * 0005 新核心业务系统
 * @author liyong
 */
@Component
public class P012001001 extends EsbCoreChannelService {

	private static P012001001_I i = new P012001001_I();
	private static P012001001_O o = new P012001001_O();

	public P012001001() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P012001001_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("upgrd_degrd_oprn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "upgrd_degrd_oprn_flg", 1,0, true, "升降级操作标志" )))
					.addNode(new FieldNode("upgrd_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "upgrd_tp", 1,0, false, "升级类型" )))
					.addNode(new FieldNode("degrd_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "degrd_tp", 1,0, false, "降级类型" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("acct_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_attr", 10,0, false, "账户属性" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 512,0, false, "交易密码" )))
					.addNode(new FieldNode("new_card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "new_card_num", 40,0, false, "新卡号" )))
					.addNode(new FieldNode("new_prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "new_prod_code", 10,0, false, "新产品代码" )))
					.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品编号" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_clasf", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf", 4,0, false, "账户分类" )))
					.addNode(new FieldNode("actvt_card_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "actvt_card_flg", 1,0, false, "开卡标志" )))
					.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 32,0, false, "凭证序号" )))
					.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, true, "支付条件" )))
					.addNode(new FieldNode("rsrv_num_change_card_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rsrv_num_change_card_flg", 1,0, false, "保号换卡标志" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class P012001001_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("orig_acct_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "orig_acct_attr", 10,0, false, "原账户属性" )))
					.addNode(new FieldNode("acct_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_attr", 10,0, false, "账户属性" )))
					.addNode(new FieldNode("remks", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks", 300,0, false, "备注" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
