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
 * BASESVC.P043000401 银行卡凭证信息查询.卡凭证详细信息查询 
 * P0430004.01 cd1061
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P043000401 extends EsbCoreChannelService {

	private static P043000401_I i = new P043000401_I();
	private static P043000401_O o = new P043000401_O();
	public P043000401() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P043000401_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("qry_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_tp", 1,0, true, "查询类型" )))
					.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, true, "卡号" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 32,0, false, "交易密码" )))
					.addNode(new FieldNode("qry_prt_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_prt_id", 1,0, false, "查询打印标识" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P043000401_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品代码" )))
					.addNode(new FieldNode("card_catg_charic", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_catg_charic", 1,0, false, "卡种性质" )))
					.addNode(new FieldNode("card_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_catg", 1,0, false, "卡种类" )))
					.addNode(new FieldNode("card_medm", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_medm", 1,0, false, "卡介质" )))
					.addNode(new FieldNode("card_obj", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_obj", 1,0, false, "卡对象" )))
					.addNode(new FieldNode("crdhd_cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "crdhd_cust_nm", 256,0, false, "持卡人客户名称" )))
					.addNode(new FieldNode("crdhd_nm_pinyin", new MsgField(ContentEnum.MessageType.STRING.toString(), "crdhd_nm_pinyin", 120,0, false, "持卡人姓名拼音" )))
					.addNode(new FieldNode("crdhd_cntct_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "crdhd_cntct_tel", 20,0, false, "持卡人联系电话" )))
					.addNode(new FieldNode("card_grd", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_grd", 1,0, false, "卡等级" )))
					.addNode(new FieldNode("card_sers_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_sers_num", 8,0, false, "卡序列号" )))
					.addNode(new FieldNode("mstr_card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "mstr_card_num", 40,0, false, "主卡卡号" )))
					.addNode(new FieldNode("with_wtht_psbk_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "with_wtht_psbk_flg", 10,0, false, "有无折标志" )))
					.addNode(new FieldNode("card_aply_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_aply_org", 12,0, false, "卡申请机构" )))
					.addNode(new FieldNode("card_aply_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_aply_dt", 8,0, false, "卡申请日期" )))
					.addNode(new FieldNode("card_issn_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_issn_org", 12,0, false, "发卡机构" )))
					.addNode(new FieldNode("card_issn_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_issn_dt", 8,0, false, "发卡日期" )))
					.addNode(new FieldNode("card_issn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_issn_tlr", 10,0, false, "发卡柜员" )))
					.addNode(new FieldNode("card_issn_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_issn_way", 1,0, false, "发卡方式" )))
					.addNode(new FieldNode("cncl_card_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_card_org", 12,0, false, "销卡机构" )))
					.addNode(new FieldNode("cncl_card_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_card_dt", 8,0, false, "销卡日期" )))
					.addNode(new FieldNode("cncl_card_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_card_tlr", 10,0, false, "销卡柜员" )))
					.addNode(new FieldNode("new_old_pswd_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "new_old_pswd_flg", 1,0, false, "新老密码标志" )))
					.addNode(new FieldNode("vld_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "vld_dt", 8,0, false, "有效日期" )))
					.addNode(new FieldNode("card_vchr_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_vchr_ste", 1,0, false, "卡凭证状态、卡凭证库存状态" )))
					.addNode(new FieldNode("need_seal_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "need_seal_flg", 1,0, false, "需要密码封标志" )))
					.addNode(new FieldNode("card_issn_chnl", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_issn_chnl", 7,0, false, "发卡渠道" )))
					.addNode(new FieldNode("card_issn_cntct_pern", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_issn_cntct_pern", 256,0, false, "发卡联系人" )))
					.addNode(new FieldNode("chk_cvn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "chk_cvn_flg", 1,0, false, "检查CVN标志" )))
					.addNode(new FieldNode("chnl_func_ctrl_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "chnl_func_ctrl_flg", 1,0, false, "功能控制标志" )))
					.addNode(new FieldNode("pre_cncl_acct_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "pre_cncl_acct_dt", 8,0, false, "预销户日期" )))
					.addNode(new FieldNode("vip_nrl_card_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vip_nrl_card_flg", 1,0, false, "VIP/普卡标志" )))
					.addNode(new FieldNode("empe_card_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "empe_card_flg", 1,0, false, "员工卡标志" )))
					.addNode(new FieldNode("gen_stmt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "gen_stmt_flg", 1,0, false, "产生对账单标志" )))
					.addNode(new FieldNode("itnl_card_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "itnl_card_flg", 1,0, false, "国际卡标志" )))
					.addNode(new FieldNode("one_card_link_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "one_card_link_flg", 1,0, false, "一卡通标志" )))
					.addNode(new FieldNode("new_old_card_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "new_old_card_flg", 1,0, false, "新老卡标志" )))
					.addNode(new FieldNode("socl_scry_card_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "socl_scry_card_flg", 1,0, false, "社保卡标志" )))
					.addNode(new FieldNode("saly_card_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "saly_card_flg", 1,0, false, "工资卡标志" )))
					.addNode(new FieldNode("cvn_vrfy_err_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cvn_vrfy_err_cnt", 10,0, false, "CVN校验错误次数" )))
					.addNode(new FieldNode("change_card_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "change_card_org", 12,0, false, "换卡机构" )))
					.addNode(new FieldNode("change_card_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "change_card_cnt", 10,0, false, "换卡次数" )))
					.addNode(new FieldNode("cnsp_bns_pnts", new MsgField(ContentEnum.MessageType.INT.toString(), "cnsp_bns_pnts", 18,2, false, "消费积分" )))
					.addNode(new FieldNode("anul_acmld_swpg_card_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "anul_acmld_swpg_card_cnt", 10,0, false, "年累计刷卡次数" )))
					.addNode(new FieldNode("anul_acmld_swpg_card_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "anul_acmld_swpg_card_amt", 18,2, false, "年累计刷卡金额" )))
					.addNode(new FieldNode("cnsp_frz_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cnsp_frz_flg", 1,0, false, "消费冻结标志" )))
					.addNode(new FieldNode("cnsp_frz_matu", new MsgField(ContentEnum.MessageType.STRING.toString(), "cnsp_frz_matu", 6,0, false, "消费冻结期限" )))
					.addNode(new FieldNode("card_moly_cnsp_ovdf_acmld_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "card_moly_cnsp_ovdf_acmld_amt", 18,2, false, "卡月消费透支累计金额" )))
					.addNode(new FieldNode("cur_mo_cross_bank_wthdl_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cur_mo_cross_bank_wthdl_cnt", 10,0, false, "当月跨行取款次数" )))
					.addNode(new FieldNode("prepd_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "prepd_flg", 10,0, false, "预留标志" )))
					.addNode(new FieldNode("acptd_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acptd_num", 35,0, false, "受理编号" )))
					.addNode(new FieldNode("proj_symbol", new MsgField(ContentEnum.MessageType.STRING.toString(), "proj_symbol", 35,0, false, "项目符号" )))
					.addNode(new FieldNode("next_chrg_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "next_chrg_dt", 8,0, false, "下次收费日期" )))
					.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
					.addNode(new FieldNode("prod_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_dsc", 750,0, false, "产品描述" )))
					.addNode(new FieldNode("card_num_code_rule", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num_code_rule", 10,0, false, "卡号编码规则" )))
					.addNode(new FieldNode("crdhd_cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "crdhd_cust_tp", 2,0, false, "持卡人客户类型" )))
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
					.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 32,0, false, "凭证序号" )))
					.addNode(new FieldNode("cust_max_cdhdg_qty", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_max_cdhdg_qty", 10,0, false, "客户最大持卡量" )))
					.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, false, "卡号" )))
					.addNode(new FieldNode("corp_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "corp_nm", 256,0, false, "单位名称" )))
					.addNode(new FieldNode("corp_cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "corp_cust_num", 32,0, false, "对公客户号" )))
					.addNode(new FieldNode("open_acct_bank_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_bank_nm", 300,0, false, "开户行名" )))
					.addNode(new FieldNode("corp_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "corp_cust_acct_num", 40,0, false, "对公客户账号" )))
					.addNode(new FieldNode("card_lock_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_lock_src", 1,0, false, "卡锁定来源" )))
					.addNode(new FieldNode("card_vchr_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_vchr_class", 80,0, false, "卡凭证类别" )))
					.addNode(new FieldNode("hdlr_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "hdlr_docs_catg", 3,0, false, "经办人证件种类" )))
					.addNode(new FieldNode("hdlr_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "hdlr_docs_num", 30,0, false, "经办人证件号码" )))
					.addNode(new FieldNode("hdlr_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "hdlr_nm", 256,0, false, "经办人名称" )))
					.addNode(new FieldNode("hdlr_cntct_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "hdlr_cntct_tel", 20,0, false, "经办人联系电话" )))
					.addNode(new FieldNode("ctzn_card_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctzn_card_flg", 1,0, false, "市民卡标志" )))
					.addNode(new FieldNode("lmt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmt_num", 32,0, false, "额度编号" )))
					.addNode(new FieldNode("cust_cdhdg_qty", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_cdhdg_qty", 10,0, false, "客户持卡量" )))
					.addNode(new FieldNode("new_card_vchr_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "new_card_vchr_ste", 1,0, false, "新卡凭证状态" )))
					.addNode(new FieldNode("card_rcpn_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_rcpn_tp", 1,0, false, "领卡类型" )))
					.addNode(new FieldNode("old_card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "old_card_num", 40,0, false, "老卡号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

