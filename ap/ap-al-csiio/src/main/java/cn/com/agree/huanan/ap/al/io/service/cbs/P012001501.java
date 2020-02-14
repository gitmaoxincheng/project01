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
 * BASESVC.P012001501 存款凭证管理.客户凭证挂失 
 * P0120015.01 ce5126
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P012001501 extends EsbCoreChannelService {

	private static P012001501_I i = new P012001501_I();
	private static P012001501_O o = new P012001501_O();
	public P012001501() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P012001501_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("vchr_loss_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_loss_catg", 2,0, true, "凭证挂失种类" )))
					.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm", 256,0, false, "客户中文名" )))
					.addNode(new FieldNode("cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_tp", 2,0, false, "客户类型" )))
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, true, "凭证种类" )))
					.addNode(new FieldNode("br_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "br_code", 4,0, false, "分行代码" )))
					.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
					.addNode(new FieldNode("par_val", new MsgField(ContentEnum.MessageType.INT.toString(), "par_val", 18,2, false, "面值" )))
					.addNode(new FieldNode("vchr_unit", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_unit", 1,0, false, "凭证单位" )))
					.addNode(new FieldNode("qty", new MsgField(ContentEnum.MessageType.INT.toString(), "qty", 10,0, true, "数量" )))
					.addNode(new FieldNode("strt_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_vchr_serl_num", 32,0, false, "起始凭证序号" )))
					.addNode(new FieldNode("end_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_vchr_serl_num", 32,0, true, "终止凭证序号" )))
					.addNode(new FieldNode("vchr_vol", new MsgField(ContentEnum.MessageType.INT.toString(), "vchr_vol", 10,0, true, "凭证张数" )))
					.addNode(new FieldNode("loss_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "loss_num", 60,0, false, "挂失编号" )))
					.addNode(new FieldNode("wthr_concl_sign_loss_matu", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_concl_sign_loss_matu", 1,0, false, "是否签订挂失期限" )))
					.addNode(new FieldNode("loss_concl_sign_cncl_loss_dys", new MsgField(ContentEnum.MessageType.INT.toString(), "loss_concl_sign_cncl_loss_dys", 10,0, false, "挂失签订解挂天数" )))
					.addNode(new FieldNode("loss_sealg_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "loss_sealg_flg", 1,0, false, "挂失封闭标志" )))
					.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, false, "支付条件" )))
					.addNode(new FieldNode("pswd_ciptxt", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_ciptxt", 32,0, false, "密码密文" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, true, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, true, "证件号码" )))
					.addNode(new FieldNode("one_click_loss_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "one_click_loss_flg", 1,0, false, "一键挂失标志" )))
					.addNode(new ArrayNode("listnm_list",false)
							.addNode(new FieldNode("wthr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_flg", 1,0, false, "是否标志" )))
							.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
							.addNode(new FieldNode("par_val", new MsgField(ContentEnum.MessageType.INT.toString(), "par_val", 18,2, false, "面值" )))
							.addNode(new FieldNode("br_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "br_code", 4,0, false, "分行代码" )))
							.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
							.addNode(new FieldNode("vchr_unit", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_unit", 1,0, false, "凭证单位" )))
							.addNode(new FieldNode("qty", new MsgField(ContentEnum.MessageType.INT.toString(), "qty", 10,0, false, "数量" )))
							.addNode(new FieldNode("strt_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_vchr_serl_num", 32,0, false, "起始凭证序号" )))
							.addNode(new FieldNode("end_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_vchr_serl_num", 32,0, false, "终止凭证序号" )))
							.addNode(new FieldNode("vchr_vol", new MsgField(ContentEnum.MessageType.INT.toString(), "vchr_vol", 10,0, false, "凭证张数" )))
							.addNode(new FieldNode("serl_num_long", new MsgField(ContentEnum.MessageType.INT.toString(), "serl_num_long", 10,0, false, "序号(int)" )))
							).addNode(new ArrayNode("lstFEEHD_list",false)
									.addNode(new FieldNode("chrg_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_code", 8,0, false, "收费代码" )))
									.addNode(new FieldNode("chrg_code_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_code_nm", 80,0, false, "收费代码名称" )))
									.addNode(new FieldNode("svc_fee_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "svc_fee_amt", 18,2, false, "手续费金额" )))
									.addNode(new FieldNode("fee_recpt_pymt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_recpt_pymt_flg", 1,0, false, "费用收付标志" )))
									.addNode(new FieldNode("rcvd_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcvd_flg", 1,0, false, "收讫标志" )))
									.addNode(new FieldNode("ars_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "ars_amt", 18,2, false, "欠费金额" )))
									).addNode(new FieldNode("txn_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_nm", 256,0, false, "交易名称" )))
					.addNode(new FieldNode("chrg_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_cust_acct_num", 40,0, false, "收费客户账号" )))
					.addNode(new FieldNode("acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_num", 40,0, false, "账号" )))
					.addNode(new FieldNode("chrg_ccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_ccy", 3,0, false, "收费币种" )))
					.addNode(new FieldNode("fee_recpt_pymt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_recpt_pymt_flg", 1,0, false, "费用收付标志" )))
					.addNode(new FieldNode("smtn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "smtn_amt", 18,2, false, "合计金额" )))
					.addNode(new FieldNode("cash_trfr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_trfr_flg", 1,0, false, "现转标志" )))
					.addNode(new FieldNode("rmrk_clom", new MsgField(ContentEnum.MessageType.STRING.toString(), "rmrk_clom", 300,0, false, "备注信息" )))
					.addNode(new FieldNode("cncl_agnt_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_agnt_docs_catg", 3,0, false, "解挂代理人证件种类" )))
					.addNode(new FieldNode("cncl_agnt_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_agnt_nm", 256,0, false, "解挂代理人名称" )))
					.addNode(new FieldNode("cncl_agnt_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_agnt_docs_num", 30,0, false, "解挂代理人证件号码" )))
					.addNode(new FieldNode("loss_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "loss_reason", 300,0, false, "挂失原因" )))
					.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P012001501_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
					.addNode(new FieldNode("br_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "br_code", 4,0, false, "分行代码" )))
					.addNode(new FieldNode("vchr_loss_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_loss_catg", 2,0, false, "凭证挂失种类" )))
					.addNode(new FieldNode("strt_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_vchr_serl_num", 32,0, false, "起始凭证序号" )))
					.addNode(new FieldNode("end_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_vchr_serl_num", 32,0, false, "终止凭证序号" )))
					.addNode(new FieldNode("vchr_vol", new MsgField(ContentEnum.MessageType.INT.toString(), "vchr_vol", 10,0, false, "凭证张数" )))
					.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm", 256,0, false, "客户中文名" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("wthr_concl_sign_loss_matu", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_concl_sign_loss_matu", 1,0, false, "是否签订挂失期限" )))
					.addNode(new FieldNode("loss_concl_sign_cncl_loss_dys", new MsgField(ContentEnum.MessageType.INT.toString(), "loss_concl_sign_cncl_loss_dys", 10,0, false, "挂失签订解挂天数" )))
					.addNode(new FieldNode("loss_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "loss_num", 60,0, false, "挂失编号" )))
					.addNode(new FieldNode("loss_sealg_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "loss_sealg_flg", 1,0, false, "挂失封闭标志" )))
					.addNode(new FieldNode("frz_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "frz_num", 60,0, false, "冻结编号" )))
					.addNode(new FieldNode("matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_dt", 8,0, false, "到期" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

