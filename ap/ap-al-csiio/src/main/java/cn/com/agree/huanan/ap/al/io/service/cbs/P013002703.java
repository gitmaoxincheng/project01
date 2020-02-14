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
 * BASESVC.P013002703 存款产品认购信息查询.随心存认购信息查询 
 * P0130027.03 dp2397
 * 0005 新核心系统
 * @author LW
 */
@Component
public class P013002703 extends EsbCoreChannelService {
/*

*/
	private static P013002703_I i = new P013002703_I();
	private static P013002703_O o = new P013002703_O();
	public P013002703() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class P013002703_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
				.addNode(new FieldNode("pymt_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cust_acct_num", 40,0, false, "付款客户账号" )))
				.addNode(new FieldNode("pymt_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_sub_acct_serl_num", 8,0, false, "付款子账户序号" )))
				.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_cnt_num", 10,0, false, "起始笔数" )))
				.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_cnt_num", 10,0, false, "查询笔数" )))
				.addNode(new FieldNode("int_trfr_in_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_trfr_in_acct_num", 40,0, false, "利息转入账号" )))
				.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
				.addNode(new FieldNode("prod_prd_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_prd_num", 50,0, false, "产品期次编号" )))
				);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013002703_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
				.addNode(new ArrayNode("listnm_list",false)
				.addNode(new FieldNode("sbcrpn_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrpn_num", 64,0, false, "认购编号" )))
				.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
				.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
				.addNode(new FieldNode("first_dept_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "first_dept_dt", 8,0, false, "首次存入日期" )))
				.addNode(new FieldNode("prod_prd_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_prd_num", 50,0, false, "产品期次编号" )))
				.addNode(new FieldNode("prod_prd_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_prd_nm", 300,0, false, "产品期次名称" )))
				.addNode(new FieldNode("cur_acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "cur_acct_bal", 18,2, false, "当前账户余额" )))
				.addNode(new FieldNode("trfr_in_acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "trfr_in_acct_bal", 18,2, false, "转入账户余额" )))
				.addNode(new FieldNode("cash_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_cust_acct_num", 40,0, false, "兑付账号" )))
				.addNode(new FieldNode("int_pymt_freq", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_pymt_freq", 8,0, false, "付息频率" )))
				.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
				.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号" )))
				.addNode(new FieldNode("pymt_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cust_acct_num", 40,0, false, "付款客户账号" )))
				.addNode(new FieldNode("rdept_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_way", 1,0, false, "转存方式" )))
				.addNode(new FieldNode("matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_dt", 8,0, false, "到期日期" )))
				.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
				.addNode(new FieldNode("income_add_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "income_add_flg", 1,0, false, "是否允许收益增值" )))
				.addNode(new FieldNode("txn_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_org", 12,0, false, "交易机构" )))
				.addNode(new FieldNode("hndg_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "hndg_tlr", 10,0, false, "经办柜员" )))
				.addNode(new FieldNode("int_trfr_in_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_trfr_in_acct_num", 40,0, false, "利息转入账号" )))
				.addNode(new FieldNode("open_acct_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "open_acct_amt", 18,2, false, "开户金额" )))
				.addNode(new FieldNode("exec_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "exec_int_rate", 12,7, false, "执行利率" )))
				));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

