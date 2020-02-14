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
 * BASESVC.P013000802 凭证信息查询.凭证挂失信息查询 
 * P0130008.02 ce5153
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P013000802 extends EsbCoreChannelService {

	private static P013000802_I i = new P013000802_I();
	private static P013000802_O o = new P013000802_O();
	public P013000802() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013000802_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("qry_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_scope", 1,0, false, "查询范围" )))
					.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" )))
					.addNode(new FieldNode("acctg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctg_org", 12,0, false, "账务机构" )))
					.addNode(new FieldNode("loss_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "loss_num", 60,0, false, "挂失编号" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("losr_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "losr_docs_catg", 3,0, false, "挂失人证件种类" )))
					.addNode(new FieldNode("losr_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "losr_docs_num", 30,0, false, "挂失人证件号码" )))
					.addNode(new FieldNode("br_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "br_code", 4,0, false, "分行代码" )))
					.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
					.addNode(new FieldNode("strt_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_vchr_serl_num", 32,0, false, "起始凭证序号" )))
					.addNode(new FieldNode("end_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_vchr_serl_num", 32,0, false, "终止凭证序号" )))
					.addNode(new FieldNode("vchr_vol", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_vol", 10,0, false, "凭证张数" )))
					.addNode(new FieldNode("pswd_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_catg", 2,0, false, "密码种类" )))
					.addNode(new FieldNode("strt_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_dt_8", 8,0, false, "起始日期" )))
					.addNode(new FieldNode("end_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_dt", 8,0, false, "终止日期" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_cnt_num", 10,0, true, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_cnt_num", 10,0, true, "查询笔数" )))
					.addNode(new FieldNode("qry_prt_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_prt_id", 1,0, false, "查询打印标识" )))
					.addNode(new FieldNode("wthr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_flg", 1,0, false, "是否标志" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("loss_cncl_loss_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "loss_cncl_loss_flg", 2,0, false, "挂失解挂标志" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013000802_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("pstOut_list",false)
							.addNode(new FieldNode("loss_cncl_loss_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "loss_cncl_loss_flg", 2,0, false, "挂失解挂标志" )))
							.addNode(new FieldNode("txn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_tlr", 10,0, false, "交易柜员" )))
							.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述1" )))
							.addNode(new FieldNode("chnl_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "chnl_code", 7,0, false, "渠道代码" )))
							.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
							.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm", 256,0, false, "客户中文名" )))
							.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
							.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
							.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
							.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
							.addNode(new FieldNode("strt_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_vchr_serl_num", 32,0, false, "起始凭证序号" )))
							.addNode(new FieldNode("end_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_vchr_serl_num", 32,0, false, "终止凭证序号" )))
							.addNode(new FieldNode("losr_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "losr_docs_catg", 3,0, false, "挂失人证件种类" )))
							.addNode(new FieldNode("losr_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "losr_docs_num", 30,0, false, "挂失人证件号码" )))
							.addNode(new FieldNode("agnt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_flg", 1,0, false, "代理人标志" )))
							.addNode(new FieldNode("agnt_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_nm", 256,0, false, "代理人名称" )))
							.addNode(new FieldNode("agnt_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_docs_catg", 3,0, false, "代理人证件种类" )))
							.addNode(new FieldNode("agnt_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_docs_num", 30,0, false, "代理人证件号码" )))
							.addNode(new FieldNode("loss_tlr_jrnl", new MsgField(ContentEnum.MessageType.STRING.toString(), "loss_tlr_jrnl", 32,0, false, "挂失交易柜流水号" )))
							.addNode(new FieldNode("athrzn_intt_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "athrzn_intt_tlr", 10,0, false, "授权发起柜员" )))
							.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, false, "支付条件" )))
							.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" )))
							.addNode(new FieldNode("trn_oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "trn_oprtg_org", 12,0, false, "挂失机构" )))
							.addNode(new FieldNode("loss_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "loss_dt", 8,0, false, "挂失日期" )))
							.addNode(new FieldNode("vchr_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_num", 32,0, false, "凭证号码" )))
							.addNode(new FieldNode("loss_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "loss_tm", 6,0, false, "挂失时间" )))
							.addNode(new FieldNode("busi_scope_val", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_scope_val", 225,0, false, "摘要描述3" )))
							.addNode(new FieldNode("cncl_loss_tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_loss_tlr_rung_num", 32,0, false, "解挂柜员流水号" )))
							.addNode(new FieldNode("athrzn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "athrzn_tlr", 10,0, false, "授权柜员" )))
							.addNode(new FieldNode("cncl_loss_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_loss_dt", 8,0, false, "解挂日期" )))
							.addNode(new FieldNode("cncl_loss_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_loss_tm", 22,0, false, "解挂时间" )))
							.addNode(new FieldNode("acctg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctg_org", 12,0, false, "账务机构" )))
							.addNode(new FieldNode("vchr_use_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_use_ste", 1,0, false, "凭证使用状态" )))
							.addNode(new FieldNode("sprr_corp_lgl_pern_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sprr_corp_lgl_pern_docs_num", 80,0, false, "摘要描述4" )))
							.addNode(new FieldNode("mntnc_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_tlr", 10,0, false, "维护柜员" )))
							.addNode(new FieldNode("loss_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "loss_num", 60,0, false, "挂失编号" )))
							.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
							.addNode(new FieldNode("pswd_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_catg", 2,0, false, "密码种类" )))
							.addNode(new FieldNode("wthr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_flg", 1,0, false, "是否标志" )))
							.addNode(new FieldNode("loss_concl_sign_cncl_loss_dys", new MsgField(ContentEnum.MessageType.STRING.toString(), "loss_concl_sign_cncl_loss_dys", 10,0, false, "挂失签订解挂天数" )))
							.addNode(new FieldNode("wthr_concl_sign_loss_matu", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_concl_sign_loss_matu", 1,0, false, "是否签订挂失期限" )))
							.addNode(new FieldNode("cncl_agnt_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_agnt_docs_catg", 3,0, false, "解挂代理人证件种类" )))
							.addNode(new FieldNode("cncl_agnt_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_agnt_nm", 256,0, false, "解挂代理人名称" )))
							.addNode(new FieldNode("cncl_agnt_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_agnt_docs_num", 30,0, false, "解挂代理人证件号码" )))
							.addNode(new FieldNode("matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_dt", 8,0, false, "到期" )))
							.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
							.addNode(new FieldNode("loss_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "loss_reason", 300,0, false, "挂失原因" )))
							.addNode(new FieldNode("matu_auto_cncl_loss", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_auto_cncl_loss", 1,0, false, "到期自动解挂" )))
							).addNode(new FieldNode("qty", new MsgField(ContentEnum.MessageType.STRING.toString(), "qty", 10,0, false, "数量" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

