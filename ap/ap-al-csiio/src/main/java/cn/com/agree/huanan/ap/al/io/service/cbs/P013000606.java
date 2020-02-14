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
 * BASESVC.P013000606 账户信息查询.存款账户列表查询 
 * P0130006.06 ib1245
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P013000606 extends EsbCoreChannelService {

	private static P013000606_I i = new P013000606_I();
	private static P013000606_O o = new P013000606_O();
	public P013000606() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013000606_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("acct_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_ste", 4,0, false, "账户状态" )))
					.addNode(new FieldNode("dept_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_catg", 3,0, false, "存款种类" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "strt_cnt_num", 10,0, true, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "qry_cnt_num", 10,0, true, "查询笔数" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
					.addNode(new FieldNode("prod_term_dmd_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_term_dmd_acct_flg", 1,0, false, "产品定活标志" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013000606_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("totl_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "totl_cnt_num", 12,0, false, "总数" )))
					.addNode(new ArrayNode("wwzhxinx_list",false)
							.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
							.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
							.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
							.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号" )))
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("acct_cash_rmtc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_cash_rmtc_flg", 1,0, false, "账户钞汇标志" )))
							.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm", 256,0, false, "客户中文名" )))
							.addNode(new FieldNode("open_acct_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_org", 12,0, false, "账户开户机构" )))
							.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
							.addNode(new FieldNode("acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "acct_bal", 18,2, false, "账户余额" )))
							.addNode(new FieldNode("acct_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_ste", 4,0, false, "账户状态" )))
							.addNode(new FieldNode("acct_clasf", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf", 4,0, false, "账户分类" )))
							.addNode(new FieldNode("acct_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_attr", 10,0, false, "账户属性" )))
							.addNode(new FieldNode("dept_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_catg", 3,0, false, "存款种类" )))
							.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
							.addNode(new FieldNode("open_acct_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_dt", 8,0, false, "开户日期" )))
							.addNode(new FieldNode("matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_dt", 8,0, false, "到期日期" )))
							.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
							.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 8,0, false, "凭证序号" )))
							.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
							.addNode(new FieldNode("aval_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "aval_bal", 18,2, false, "可用余额" )))
							.addNode(new FieldNode("int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate", 12,7, false, "利率" )))
							.addNode(new FieldNode("actl_draw_cnt", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_draw_cnt", 1,0, false, "实际支取次数" )))
							.addNode(new FieldNode("rdept_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "rdept_way", 1,0, false, "转存方式" )))
							.addNode(new FieldNode("strt_int_caln_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_int_caln_dt", 8,0, false, "起息日期" )))
							.addNode(new FieldNode("open_acct_chnl", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_chnl", 7,0, false, "开户渠道" )))
							.addNode(new FieldNode("one_acct_unvsl", new MsgField(ContentEnum.MessageType.STRING.toString(), "one_acct_unvsl", 1,0, false, "一户通标志" )))
							.addNode(new FieldNode("acct_sealg_frz_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_sealg_frz_flg", 1,0, false, "账户封闭冻结标志" )))
							.addNode(new FieldNode("acct_amt_frz_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_amt_frz_flg", 1,0, false, "账户金额冻结标志" )))
							.addNode(new FieldNode("acct_recpt_only_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_recpt_only_flg", 1,0, false, "账户只收不付标志" )))
							.addNode(new FieldNode("acct_pymt_only_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_pymt_only_flg", 1,0, false, "账户只付不收标志" )))
							.addNode(new FieldNode("cust_acct_rlvc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_rlvc_flg", 1,0, false, "客户账户关联标志" )))

							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

