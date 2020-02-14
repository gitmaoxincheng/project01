package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODAFA0066  贷记卡账户信息查询 
 *  BODAFA0066 881004
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA0066 extends EciChannelService {

	private static BODAFA0066_I i = new BODAFA0066_I();
	private static BODAFA0066_O o = new BODAFA0066_O();
	public BODAFA0066() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0066_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 19,0, false, "贷记卡号" )))
					.addNode(new FieldNode("finavai_yn", new MsgField(ContentEnum.MessageType.STRING.toString(), "finavai_yn", 1,0, false, "显示最终可用额度" )))
					.addNode(new FieldNode("passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "passwd", 8,0, false, "交易密码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0066_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 19,0, false, "贷记卡号" )))
					.addNode(new FieldNode("cardnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardnm", 100,0, false, "持卡人姓名" )))
					.addNode(new FieldNode("busi_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_name", 100,0, false, "公司名称" )))
					.addNode(new FieldNode("open_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_date", 8,0, false, "开户日期" )))
					.addNode(new FieldNode("credit_limit", new MsgField(ContentEnum.MessageType.STRING.toString(), "credit_limit", 17,0, false, "信用额度" )))
					.addNode(new FieldNode("avlimt", new MsgField(ContentEnum.MessageType.STRING.toString(), "avlimt", 17,0, false, "可用额度" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 10,0, false, "证件类型" )))
					.addNode(new FieldNode("idno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idno", 40,0, false, "证件号码" )))
					.addNode(new FieldNode("cardst", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardst", 1,0, false, "账户状态" )))
					.addNode(new FieldNode("datamore", new MsgField(ContentEnum.MessageType.STRING.toString(), "datamore", 10,0, false, "后续记录" )))
					.addNode(new FieldNode("datacount", new MsgField(ContentEnum.MessageType.STRING.toString(), "datacount", 10,0, false, "记录数" )))
					.addNode(new FieldNode("returnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "returnum", 17,0, false, "记录数" )))
					.addNode(new ArrayNode("bodrcd",true,"card_list")
							.addNode(new FieldNode("trxtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "trxtype", 10,0, false, "交易代码" )))
							.addNode(new FieldNode("retcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "retcode", 10,0, false, "响应码" )))
							.addNode(new FieldNode("bnknbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "bnknbr", 10,0, false, "银行代号" )))
							.addNode(new FieldNode("source", new MsgField(ContentEnum.MessageType.STRING.toString(), "source", 10,0, false, "交易来源" )))
							.addNode(new FieldNode("brn_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "brn_no", 10,0, false, "网点代号" )))
							.addNode(new FieldNode("ope_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "ope_no", 10,0, false, "操作员号" )))
							.addNode(new FieldNode("seqno", new MsgField(ContentEnum.MessageType.STRING.toString(), "seqno", 20,0, false, "流水号" )))
							.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 40,0, false, "卡号" )))
							.addNode(new FieldNode("cardnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardnm", 100,0, false, "持卡人姓名" )))
							.addNode(new FieldNode("prod_desc", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_desc", 100,0, false, "最高产品描述" )))
							.addNode(new FieldNode("branch", new MsgField(ContentEnum.MessageType.STRING.toString(), "branch", 100,0, false, "开户行" )))
							.addNode(new FieldNode("reserv", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv", 100,0, false, "保留字段" )))
							.addNode(new FieldNode("busi_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_name", 100,0, false, "公司名称" )))
							.addNode(new FieldNode("open_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_date", 8,0, false, "开户日期" )))
							.addNode(new FieldNode("credit_limit", new MsgField(ContentEnum.MessageType.STRING.toString(), "credit_limit", 17,0, false, "信用额度" )))
							.addNode(new FieldNode("authamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "authamt", 17,0, false, "未请款金额" )))
							.addNode(new FieldNode("avlimt", new MsgField(ContentEnum.MessageType.STRING.toString(), "avlimt", 17,0, false, "可用额度" )))
							.addNode(new FieldNode("xcredlimit", new MsgField(ContentEnum.MessageType.STRING.toString(), "xcredlimit", 17,0, false, "信用额度2" )))
							.addNode(new FieldNode("xavlimt", new MsgField(ContentEnum.MessageType.STRING.toString(), "xavlimt", 17,0, false, "可用额度2" )))
							.addNode(new FieldNode("due_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "due_date", 8,0, false, "还款截止日期" )))
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 40,0, false, "自扣还款账号" )))
							.addNode(new FieldNode("paytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "paytype", 1,0, false, "自扣还款方式" )))
							.addNode(new FieldNode("last_pay_day", new MsgField(ContentEnum.MessageType.STRING.toString(), "last_pay_day", 8,0, false, "上次还款日期" )))
							.addNode(new FieldNode("last_pay_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "last_pay_amt", 8,0, false, "已还款金额" )))
							.addNode(new FieldNode("age_amt_b", new MsgField(ContentEnum.MessageType.STRING.toString(), "age_amt_b", 17,0, false, "逾期金额" )))
							.addNode(new FieldNode("age_days_b", new MsgField(ContentEnum.MessageType.STRING.toString(), "age_days_b", 10,0, false, "本币逾期期数" )))
							.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 10,0, false, "证件类型" )))
							.addNode(new FieldNode("idno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idno", 40,0, false, "证件号码" )))
							.addNode(new FieldNode("query_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "query_amt", 17,0, false, "争议金额" )))
							.addNode(new FieldNode("adj_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "adj_amt", 17,0, false, "调整金额" )))
							.addNode(new FieldNode("adj_flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "adj_flag", 10,0, false, "调整金额符号" )))
							.addNode(new FieldNode("cardst", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardst", 1,0, false, "账户状态" )))
							.addNode(new FieldNode("acct_chg_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_chg_date", 8,0, false, "账户状态日期" )))
							.addNode(new FieldNode("pur_cred", new MsgField(ContentEnum.MessageType.STRING.toString(), "pur_cred", 17,0, false, "消费净额" )))
							.addNode(new FieldNode("sign", new MsgField(ContentEnum.MessageType.STRING.toString(), "sign", 10,0, false, "消费净额符号" )))
							.addNode(new FieldNode("calimit", new MsgField(ContentEnum.MessageType.STRING.toString(), "calimit", 17,0, false, "预借现金信用额度" )))
							.addNode(new FieldNode("calimitavb", new MsgField(ContentEnum.MessageType.STRING.toString(), "calimitavb", 17,0, false, "预借现金可用额度" )))
							.addNode(new FieldNode("mpcredit", new MsgField(ContentEnum.MessageType.STRING.toString(), "mpcredit", 17,0, false, "分期付款信用额度" )))
							.addNode(new FieldNode("mpavble", new MsgField(ContentEnum.MessageType.STRING.toString(), "mpavble", 17,0, false, "分期付款可用额度" )))
							.addNode(new FieldNode("rmb_balnce", new MsgField(ContentEnum.MessageType.STRING.toString(), "rmb_balnce", 17,0, false, "帐面金额" )))
							.addNode(new FieldNode("rmb_balnceflg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rmb_balnceflg", 10,0, false, "帐面金额符号" )))
							.addNode(new FieldNode("usd_balnce", new MsgField(ContentEnum.MessageType.STRING.toString(), "usd_balnce", 17,0, false, "帐面余额" )))
							.addNode(new FieldNode("usd_balnceflg", new MsgField(ContentEnum.MessageType.STRING.toString(), "usd_balnceflg", 10,0, false, "帐面余额符号" )))
							.addNode(new FieldNode("age_amt_w", new MsgField(ContentEnum.MessageType.STRING.toString(), "age_amt_w", 17,0, false, "外币逾期金额" )))
							.addNode(new FieldNode("age_days_w", new MsgField(ContentEnum.MessageType.STRING.toString(), "age_days_w", 10,0, false, "外币逾期期数" )))
							.addNode(new FieldNode("temp_limit", new MsgField(ContentEnum.MessageType.STRING.toString(), "temp_limit", 17,0, false, "临时调整额度" )))
							.addNode(new FieldNode("tlmt_beg", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlmt_beg", 8,0, false, "临时额度生效日期" )))
							.addNode(new FieldNode("tlmt_end", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlmt_end", 8,0, false, "临时额度失效日期" )))
							.addNode(new FieldNode("busi_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_no", 20,0, false, "公司编号" )))
							.addNode(new FieldNode("prod_level", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_level", 10,0, false, "最高产品级别" )))
							.addNode(new FieldNode("srv_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "srv_info", 100,0, false, "附加信息" )))
							.addNode(new FieldNode("authamx", new MsgField(ContentEnum.MessageType.STRING.toString(), "authamx", 17,0, false, "外币授权未请款金额" )))
							.addNode(new FieldNode("bp_flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "bp_flag", 1,0, false, "个人卡公司卡标志" )))
							.addNode(new FieldNode("orig_limit", new MsgField(ContentEnum.MessageType.STRING.toString(), "orig_limit", 17,0, false, "原始额度" )))
							.addNode(new FieldNode("cred_chgday", new MsgField(ContentEnum.MessageType.STRING.toString(), "cred_chgday", 8,0, false, "上次额度调整日期" )))
							.addNode(new FieldNode("cred_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "cred_reason", 100,0, false, "上次额度调整原因" )))
							.addNode(new FieldNode("lmp_limit", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmp_limit", 17,0, false, "大额分期付款额度" )))
							.addNode(new FieldNode("lmp_avail", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmp_avail", 17,0, false, "大额分期付款可用额度" )))
							.addNode(new FieldNode("overamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "overamt", 1,0, false, "是否开通超限功能" )))
							.addNode(new FieldNode("acctnoCode1", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctnoCode1", 20,0, false, "帐户分层代码1" )))
							.addNode(new FieldNode("acctnoCode2", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctnoCode2", 20,0, false, "帐户分层代码2" )))
							.addNode(new FieldNode("purchases", new MsgField(ContentEnum.MessageType.STRING.toString(), "purchases", 17,0, false, "当期消费累计(人民币)" )))
							.addNode(new FieldNode("nbr_purch", new MsgField(ContentEnum.MessageType.STRING.toString(), "nbr_purch", 17,0, false, "当期消费笔数(人民币)" )))
							.addNode(new FieldNode("purchasesx", new MsgField(ContentEnum.MessageType.STRING.toString(), "purchasesx", 17,0, false, "当期消费累计(外币)" )))
							.addNode(new FieldNode("nbr_purchx", new MsgField(ContentEnum.MessageType.STRING.toString(), "nbr_purchx", 17,0, false, "当期消费笔数(外币)" )))
							.addNode(new FieldNode("adv_fee", new MsgField(ContentEnum.MessageType.STRING.toString(), "adv_fee", 17,0, false, "本期的预借现金手续费总额(人民币)" )))
							.addNode(new FieldNode("adv_feex", new MsgField(ContentEnum.MessageType.STRING.toString(), "adv_feex", 17,0, false, "本期的预借现金手续费总额(外币)" )))
							.addNode(new FieldNode("stmt_dte", new MsgField(ContentEnum.MessageType.STRING.toString(), "stmt_dte", 8,0, false, "上次帐单日" )))
							.addNode(new FieldNode("close_bal", new MsgField(ContentEnum.MessageType.STRING.toString(), "close_bal", 17,0, false, "本币帐单余额" )))
							.addNode(new FieldNode("close_cha", new MsgField(ContentEnum.MessageType.STRING.toString(), "close_cha", 10,0, false, "本币帐单余额方向" )))
							.addNode(new FieldNode("close_bax", new MsgField(ContentEnum.MessageType.STRING.toString(), "close_bax", 17,0, false, "外币帐单余额" )))
							.addNode(new FieldNode("close_chx", new MsgField(ContentEnum.MessageType.STRING.toString(), "close_chx", 10,0, false, "外币帐单余额方向" )))
							.addNode(new FieldNode("min_due", new MsgField(ContentEnum.MessageType.STRING.toString(), "min_due", 17,0, false, "最低应缴款" )))
							.addNode(new FieldNode("min_duex", new MsgField(ContentEnum.MessageType.STRING.toString(), "min_duex", 17,0, false, "外币最低应缴款" )))
							.addNode(new FieldNode("cash_adv", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_adv", 17,0, false, "当期预借现金" )))
							.addNode(new FieldNode("cash_advx", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_advx", 17,0, false, "外币当期预借现金" )))
							.addNode(new FieldNode("fee_duty", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_duty", 17,0, false, "帐户费用和税收" )))
							.addNode(new FieldNode("fee_dutyx", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_dutyx", 17,0, false, "外币帐户费用和税收" )))
							.addNode(new FieldNode("int_chg", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_chg", 17,0, false, "应收利息" )))
							.addNode(new FieldNode("int_chgx", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_chgx", 17,0, false, "外币应收利息" )))
							.addNode(new FieldNode("pymt_clud", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_clud", 17,0, false, "已结算付款额" )))
							.addNode(new FieldNode("pymt_cludx", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cludx", 17,0, false, "外币已结算付款额" )))
							.addNode(new FieldNode("stmt_sts", new MsgField(ContentEnum.MessageType.STRING.toString(), "stmt_sts", 1,0, false, "帐户帐单状态" )))
							.addNode(new FieldNode("penchg", new MsgField(ContentEnum.MessageType.STRING.toString(), "penchg", 17,0, false, "本币应收未收滞纳金" )))
							.addNode(new FieldNode("penchgx", new MsgField(ContentEnum.MessageType.STRING.toString(), "penchgx", 17,0, false, "外币应收未收滞纳金" )))
							.addNode(new FieldNode("revs", new MsgField(ContentEnum.MessageType.STRING.toString(), "revs", 100,0, false, "保留字段" )))
							.addNode(new FieldNode("cycl_nbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cycl_nbr", 2,0, false, "账户账单日" )))
							.addNode(new FieldNode("cate", new MsgField(ContentEnum.MessageType.STRING.toString(), "cate", 4,0, false, "账户类别" )))
							.addNode(new FieldNode("cate_desc", new MsgField(ContentEnum.MessageType.STRING.toString(), "cate_desc", 20,0, false, "账户类别描述" )))
							.addNode(new FieldNode("curr_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "curr_code", 3,0, false, "外币币种" )))
							.addNode(new FieldNode("new_bal", new MsgField(ContentEnum.MessageType.STRING.toString(), "new_bal", 12,0, false, "未出账单金额" )))
							.addNode(new FieldNode("newbalfg", new MsgField(ContentEnum.MessageType.STRING.toString(), "newbalfg", 1,0, false, "未出账单金额符号" )))
							.addNode(new FieldNode("new_balx", new MsgField(ContentEnum.MessageType.STRING.toString(), "new_balx", 12,0, false, "外币未出账单金额" )))
							.addNode(new FieldNode("newbalfgx", new MsgField(ContentEnum.MessageType.STRING.toString(), "newbalfgx", 1,0, false, "外币未出账单金额符符号" )))
							.addNode(new FieldNode("cash_aval", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_aval", 12,0, false, "外币预借现金信用额度" )))
							.addNode(new FieldNode("cash_avalx", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_avalx", 12,0, false, "外币预借现金可用额度" )))
							.addNode(new FieldNode("close_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "close_reason", 1,0, false, "止付原因" )))
							.addNode(new FieldNode("close_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "close_src", 2,0, false, "止付渠道" )))
							.addNode(new FieldNode("cycl_chdy", new MsgField(ContentEnum.MessageType.STRING.toString(), "cycl_chdy", 8,0, true, "上次账单日更改日期" )))
							.addNode(new FieldNode("cycl_prv", new MsgField(ContentEnum.MessageType.STRING.toString(), "cycl_prv", 2,0, false, "修改前账单日" )))
							.addNode(new FieldNode("points", new MsgField(ContentEnum.MessageType.STRING.toString(), "points", 10,0, false, "账户累计总积分" )))
							.addNode(new FieldNode("point_s", new MsgField(ContentEnum.MessageType.STRING.toString(), "point_s", 1,0, false, "账户累计总积分符号" )))
							.addNode(new FieldNode("point1", new MsgField(ContentEnum.MessageType.STRING.toString(), "point1", 10,0, false, "账户可兑换积分" )))
							.addNode(new FieldNode("point1_s", new MsgField(ContentEnum.MessageType.STRING.toString(), "point1_s", 1,0, false, "账户可兑换积分符号" )))
							.addNode(new FieldNode("shadow_int", new MsgField(ContentEnum.MessageType.STRING.toString(), "shadow_int", 12,0, false, "本币停计利息" )))
							.addNode(new FieldNode("shadow_pen", new MsgField(ContentEnum.MessageType.STRING.toString(), "shadow_pen", 12,0, false, "本币停计滞纳金" )))
							.addNode(new FieldNode("shadow_intx", new MsgField(ContentEnum.MessageType.STRING.toString(), "shadow_intx", 12,0, false, "外币停计利息" )))
							.addNode(new FieldNode("shadow_penx", new MsgField(ContentEnum.MessageType.STRING.toString(), "shadow_penx", 12,0, false, "外币停计滞纳金" )))
							.addNode(new FieldNode("cal_limit", new MsgField(ContentEnum.MessageType.STRING.toString(), "cal_limit", 10,0, false, "现金贷款额度" )))
							.addNode(new FieldNode("cal_aval", new MsgField(ContentEnum.MessageType.STRING.toString(), "cal_aval", 12,0, false, "现金贷款可用额度" )))
							.addNode(new FieldNode("chgd_fee", new MsgField(ContentEnum.MessageType.STRING.toString(), "chgd_fee", 12,0, false, "应收费用" )))
							.addNode(new FieldNode("chgd_feex", new MsgField(ContentEnum.MessageType.STRING.toString(), "chgd_feex", 12,0, false, "外币应收费用" )))
							.addNode(new FieldNode("sms_yn", new MsgField(ContentEnum.MessageType.STRING.toString(), "sms_yn", 1,0, false, "开通短信" )))
							.addNode(new FieldNode("intear_yn", new MsgField(ContentEnum.MessageType.STRING.toString(), "intear_yn", 1,0, false, "存款计息标志" )))
							.addNode(new FieldNode("mp_rem_bal", new MsgField(ContentEnum.MessageType.STRING.toString(), "mp_rem_bal", 11,0, false, "分期付款剩余本金" )))
							.addNode(new FieldNode("mp_rem_intfee", new MsgField(ContentEnum.MessageType.STRING.toString(), "mp_rem_intfee", 11,0, false, "分期付款剩余费用和" )))
							.addNode(new FieldNode("free_limit", new MsgField(ContentEnum.MessageType.STRING.toString(), "free_limit", 10,0, false, "消费免息额度" )))
							.addNode(new FieldNode("cred_adj", new MsgField(ContentEnum.MessageType.STRING.toString(), "cred_adj", 11,0, false, "本币贷记调整金额" )))
							.addNode(new FieldNode("cradj_s", new MsgField(ContentEnum.MessageType.STRING.toString(), "cradj_s", 1,0, false, "本币贷记调整金额符号" )))
							.addNode(new FieldNode("cred_adx", new MsgField(ContentEnum.MessageType.STRING.toString(), "cred_adx", 11,0, false, "外币贷记调整金额" )))
							.addNode(new FieldNode("cradx_s", new MsgField(ContentEnum.MessageType.STRING.toString(), "cradx_s", 1,0, false, "外币贷记调整金额符号" )))
							.addNode(new FieldNode("mp_bal", new MsgField(ContentEnum.MessageType.STRING.toString(), "mp_bal", 11,0, false, "本币分期未分摊部分的本金及手续费" )))
							.addNode(new FieldNode("mp_bal_s", new MsgField(ContentEnum.MessageType.STRING.toString(), "mp_bal_s", 1,0, false, "本币分期未分摊部分的本金及手续费符号" )))
							.addNode(new FieldNode("mp_bax", new MsgField(ContentEnum.MessageType.STRING.toString(), "mp_bax", 11,0, false, "外币分期未分摊部分的本金及手续费" )))
							.addNode(new FieldNode("mp_bax_s", new MsgField(ContentEnum.MessageType.STRING.toString(), "mp_bax_s", 1,0, false, "外币分期未分摊部分的本金及手续费符号" )))
							.addNode(new FieldNode("mcntrl_yn", new MsgField(ContentEnum.MessageType.STRING.toString(), "mcntrl_yn", 1,0, false, "交易限制选项" )))
							.addNode(new FieldNode("olflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "olflag", 1,0, false, "账户超限标识（本币）" )))
							.addNode(new FieldNode("olflagx", new MsgField(ContentEnum.MessageType.STRING.toString(), "olflagx", 1,0, false, "账户超限标识（外币）" )))
							.addNode(new FieldNode("cred_lmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cred_lmt", 10,0, false, "账户综合授信额度" )))
							.addNode(new FieldNode("free_lmavl", new MsgField(ContentEnum.MessageType.STRING.toString(), "free_lmavl", 12,0, false, "消费免息可用额度" )))
							.addNode(new FieldNode("revs1", new MsgField(ContentEnum.MessageType.STRING.toString(), "revs1", 4,0, false, "保留域" )))
							.addNode(new FieldNode("mp_rem_ppx", new MsgField(ContentEnum.MessageType.STRING.toString(), "mp_rem_ppx", 11,0, false, "外币分期未分摊本金" )))
							.addNode(new FieldNode("bsc_cred", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsc_cred", 10,0, false, "账户基本额度" )))
							.addNode(new FieldNode("ir_purch", new MsgField(ContentEnum.MessageType.STRING.toString(), "ir_purch", 6,0, false, "本币消费利率" )))
							.addNode(new FieldNode("ir_cash", new MsgField(ContentEnum.MessageType.STRING.toString(), "ir_cash", 6,0, false, "本币取现利率" )))
							.addNode(new FieldNode("ir_purchx", new MsgField(ContentEnum.MessageType.STRING.toString(), "ir_purchx", 6,0, false, "外币消费利率" )))
							.addNode(new FieldNode("ir_cashx", new MsgField(ContentEnum.MessageType.STRING.toString(), "ir_cashx", 6,0, false, "外币取现利率" )))
							.addNode(new FieldNode("mpavl_acct", new MsgField(ContentEnum.MessageType.STRING.toString(), "mpavl_acct", 11,0, false, "账户不含临额分期可用额度" )))
							.addNode(new FieldNode("mpavl_cust", new MsgField(ContentEnum.MessageType.STRING.toString(), "mpavl_cust", 11,0, false, "客户不含临额分期可用额度" )))
							.addNode(new FieldNode("mpacctx", new MsgField(ContentEnum.MessageType.STRING.toString(), "mpacctx", 11,0, false, "账户级不含临额分期外币可用额度" )))
							.addNode(new FieldNode("mpcustx", new MsgField(ContentEnum.MessageType.STRING.toString(), "mpcustx", 11,0, false, "客户级不含临额分期外币可用额度" )))
							.addNode(new FieldNode("brn_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "brn_code", 10,0, false, "外部分行号" )))
							.addNode(new FieldNode("due_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "due_amt", 11,0, false, "上期应还款额未还金额" )))
							.addNode(new FieldNode("tr_chg_pct", new MsgField(ContentEnum.MessageType.STRING.toString(), "tr_chg_pct", 10,0, false, "临时额度最大调整比例" )))
							.addNode(new FieldNode("tr_chg_max", new MsgField(ContentEnum.MessageType.STRING.toString(), "tr_chg_max", 12,0, false, "临时额度最大调整上限" )))
							.addNode(new FieldNode("cugry_yn", new MsgField(ContentEnum.MessageType.STRING.toString(), "cugry_yn", 1,0, false, "持卡人在客户灰名单中？" )))
							.addNode(new FieldNode("shadow_fee", new MsgField(ContentEnum.MessageType.STRING.toString(), "shadow_fee", 12,0, false, "本币停计按日手续费" )))
							.addNode(new FieldNode("shadow_feex", new MsgField(ContentEnum.MessageType.STRING.toString(), "shadow_feex", 12,0, false, "外币停计按日手续费" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

