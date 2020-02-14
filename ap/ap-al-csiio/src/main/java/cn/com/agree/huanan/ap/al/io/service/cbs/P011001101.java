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
 * 
 * @author zhuzc
 * BASESVC P011001101 本行卡存款确认
 * P011001101 dp2120
 * ATM
 */
@Component
public class P011001101 extends EsbCoreChannelService{
	private static P011001101_I i = new P011001101_I();
	private static P011001101_O o = new P011001101_O();
	public P011001101() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P011001101_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
			.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
			.addNode(new FieldNode("pswd_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_catg", 2,0, false, "密码种类" )))
			.addNode(new FieldNode("txn_ccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_ccy", 3,0, false, "交易币种" )))
			.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_amt", 18,0, false, "交易金额" )))
			.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
			.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
			.addNode(new FieldNode("remks", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks", 300,0, false, "备注" )))
			.addNode(new FieldNode("main_group_status", new MsgField(ContentEnum.MessageType.STRING.toString(), "main_group_status", 3,0, false, "主体分类状态" )))
			.addNode(new FieldNode("per_explain_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "per_explain_flg", 1,0, false, "是否是待说明个人" )))
			.addNode(new FieldNode("today_dep_amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "today_dep_amount", 18,0, false, "当日已存入金额（折美元）" )))
			.addNode(new FieldNode("tyear_dep_amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "tyear_dep_amount", 18,0, false, "当年已存入金额（折美元）" )))
			.addNode(new FieldNode("cash_item_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_item_code", 12,0, false, "现金项目代码" )))
			.addNode(new FieldNode("add_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(),"add_docs_num", 30,0, false, "补充证件号码" )))

					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P011001101_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号 " )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
					.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
					.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
					.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_amt", 18,0, false, "交易金额" )))
					.addNode(new FieldNode("actl_dept_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "actl_dept_amt", 18,0, false, "实际存入" )))
					.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号 " )))
					.addNode(new FieldNode("next_prt_row_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "next_prt_row_num", 10,0, false, "下一打印行数" )))
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品编号" )))
					.addNode(new FieldNode("acct_bal", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_bal", 18,0, false, "账户余额" )))
					.addNode(new FieldNode("prt_row_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prt_row_num", 10,0, false, "打印行数" )))
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
