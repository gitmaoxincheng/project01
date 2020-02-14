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
 * BASESVC.C012000112 客户信息管理.对公客户信息同步 
 * C0120001.12 cf4015
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class C012000112 extends EsbCoreChannelService {

	private static C012000112_I i = new C012000112_I();
	private static C012000112_O o = new C012000112_O();
	public C012000112() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C012000112_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("cr_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "cr_code", 32,0, false, "信用代码" )))
					.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm", 256,0, false, "客户中文名" )))
					.addNode(new FieldNode("engl_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "engl_nm", 120,0, false, "英文名称" )))
					.addNode(new FieldNode("cust_brvt_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_brvt_nm", 120,0, false, "客户简名" )))
					.addNode(new FieldNode("cust_brvt_pinyin", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_brvt_pinyin", 120,0, false, "客户简拼" )))
					.addNode(new FieldNode("former_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "former_nm", 256,0, false, "曾用名" )))
					.addNode(new FieldNode("corp_cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "corp_cust_tp", 2,0, false, "对公客户类型" )))
					.addNode(new FieldNode("estb_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "estb_dt", 8,0, false, "成立日期" )))
					.addNode(new FieldNode("aprv_estb_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "aprv_estb_org", 300,0, false, "批准成立机构" )))
					.addNode(new FieldNode("cust_snthes_evlan_lv", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_snthes_evlan_lv", 2,0, false, "客户综合评估级别" )))
					.addNode(new FieldNode("wthr_intra_bank_cust", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_intra_bank_cust", 1,0, false, "是否行内客户" )))
					.addNode(new FieldNode("intrl_org_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "intrl_org_num", 12,0, false, "内部机构号" )))
					.addNode(new FieldNode("intrl_dprtmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "intrl_dprtmt", 2,0, false, "内部部门号" )))
					.addNode(new FieldNode("nat_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "nat_code", 10,0, false, "国别代码" )))
					.addNode(new FieldNode("rgon_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgon_code_num", 20,0, false, "地区代号" )))
					.addNode(new FieldNode("rgon_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgon_nm", 256,0, false, "地区名称" )))
					.addNode(new FieldNode("civil_cptmt_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "civil_cptmt_code", 12,0, false, "行政区划代码" )))
					.addNode(new FieldNode("corp_cust_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "corp_cust_class", 1,0, false, "对公客户类别" )))
					.addNode(new FieldNode("ecnmc_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ecnmc_tp", 3,0, false, "经济类型" )))
					.addNode(new FieldNode("oprn_org_form", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprn_org_form", 3,0, false, "经营组织形式" )))
					.addNode(new FieldNode("idsty_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "idsty_class", 4,0, false, "行业类别" )))
					.addNode(new FieldNode("idsty_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "idsty_code", 10,0, false, "行业代码" )))
					.addNode(new FieldNode("cust_idsty_splmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_idsty_splmt", 2,0, false, "客户行业补充" )))
					.addNode(new FieldNode("finc_spvsr", new MsgField(ContentEnum.MessageType.STRING.toString(), "finc_spvsr", 256,0, false, "财务主管" )))
					.addNode(new FieldNode("holdg_shrhdr_actl_ctrlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "holdg_shrhdr_actl_ctrlr", 256,0, false, "控股股东或实际控制人" )))
					.addNode(new FieldNode("corpt_rprtv_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpt_rprtv_class", 1,0, false, "法人代表类别" )))
					.addNode(new FieldNode("corpt_rprtv_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpt_rprtv_nm", 256,0, false, "法人代表名称" )))
					.addNode(new FieldNode("lgl_pern_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "lgl_pern_attr", 1,0, false, "法人属性" )))
					.addNode(new FieldNode("corpt_rprtv_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpt_rprtv_docs_catg", 3,0, false, "法人代表证件种类" )))
					.addNode(new FieldNode("corpt_rprtv_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpt_rprtv_docs_num", 30,0, false, "法人代表证件号码" )))
					.addNode(new FieldNode("lgl_pern_docs_vld_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "lgl_pern_docs_vld_dt", 8,0, false, "法人证件有效日期" )))
					.addNode(new FieldNode("lgl_pern_docs_issug_offc", new MsgField(ContentEnum.MessageType.STRING.toString(), "lgl_pern_docs_issug_offc", 300,0, false, "法人证件发证机关" )))
					.addNode(new FieldNode("corpt_rprtv_tel_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpt_rprtv_tel_num", 40,0, false, "法人代表电话号码" )))
					.addNode(new FieldNode("corpt_rprtv_cntct_addr", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpt_rprtv_cntct_addr", 300,0, false, "法人代表联系地址" )))
					.addNode(new FieldNode("corpt_rprtv_addr_pstcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpt_rprtv_addr_pstcd", 8,0, false, "法人代表联系地址邮编" )))
					.addNode(new FieldNode("sprr_spvsr_corp_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "sprr_spvsr_corp_nm", 300,0, false, "上级主管单位名称" )))
					.addNode(new FieldNode("sprr_spvsr_corp_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "sprr_spvsr_corp_tp", 1,0, false, "上级主管单位类型" )))
					.addNode(new FieldNode("sprr_corp_org_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "sprr_corp_org_code", 12,0, false, "上级单位组织机构代码" )))
					.addNode(new FieldNode("sprr_corp_lgl_pern_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "sprr_corp_lgl_pern_nm", 256,0, false, "上级单位法人名称" )))
					.addNode(new FieldNode("sprr_corp_lgl_pern_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "sprr_corp_lgl_pern_attr", 1,0, false, "上级单位法人属性" )))
					.addNode(new FieldNode("sprr_corp_lgl_pern_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "sprr_corp_lgl_pern_docs_catg", 3,0, false, "上级单位法人证件种类" )))
					.addNode(new FieldNode("sprr_corp_lgl_pern_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sprr_corp_lgl_pern_docs_num", 30,0, false, "上级单位法人证件号码" )))
					.addNode(new FieldNode("sprr_corp_lgl_pern_tel_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sprr_corp_lgl_pern_tel_num", 40,0, false, "上级单位法人电话号码" )))
					.addNode(new FieldNode("exte_ecnmc_trd_oprn_right", new MsgField(ContentEnum.MessageType.STRING.toString(), "exte_ecnmc_trd_oprn_right", 1,0, false, "对外经济贸易经营权" )))
					.addNode(new FieldNode("entp_fx_mgmt_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "entp_fx_mgmt_code", 12,0, false, "企业外管代码" )))
					.addNode(new FieldNode("spec_ecnmc_dist_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "spec_ecnmc_dist_tp", 10,0, false, "特殊经济区类型" )))
					.addNode(new FieldNode("entp_attr_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "entp_attr_code", 3,0, false, "企业属性代码" )))
					.addNode(new FieldNode("ctzn_ecnmc_dprtmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctzn_ecnmc_dprtmt", 4,0, false, "国民经济部门" )))
					.addNode(new FieldNode("rgstn_cptl_ccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgstn_cptl_ccy", 3,0, false, "注册资金币种" )))
					.addNode(new FieldNode("rgstn_cptl", new MsgField(ContentEnum.MessageType.INT.toString(), "rgstn_cptl", 18,2, false, "注册资金" )))
					.addNode(new FieldNode("actly_rcvd_cptl", new MsgField(ContentEnum.MessageType.INT.toString(), "actly_rcvd_cptl", 18,2, false, "实收资本" )))
					.addNode(new FieldNode("oprn_site_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprn_site_cond", 1,0, false, "经营场所状况" )))
					.addNode(new FieldNode("entp_scale", new MsgField(ContentEnum.MessageType.STRING.toString(), "entp_scale", 2,0, false, "企业规模" )))
					.addNode(new FieldNode("asset_scale", new MsgField(ContentEnum.MessageType.STRING.toString(), "asset_scale", 1,0, false, "资产规模" )))
					.addNode(new FieldNode("empe_scale", new MsgField(ContentEnum.MessageType.STRING.toString(), "empe_scale", 1,0, false, "员工规模" )))
					.addNode(new FieldNode("impr_scale", new MsgField(ContentEnum.MessageType.STRING.toString(), "impr_scale", 1,0, false, "进口规模" )))
					.addNode(new FieldNode("expr_scale", new MsgField(ContentEnum.MessageType.STRING.toString(), "expr_scale", 1,0, false, "出口规模" )))
					.addNode(new FieldNode("anul_sale_scale", new MsgField(ContentEnum.MessageType.STRING.toString(), "anul_sale_scale", 1,0, false, "销售规模" )))
					.addNode(new FieldNode("sale_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "sale_amt", 18,2, false, "销售额" )))
					.addNode(new FieldNode("ipo_co_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ipo_co_flg", 1,0, false, "上市公司标志" )))
					.addNode(new FieldNode("oprn_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprn_scope", 1500,0, false, "经营范围" )))
					.addNode(new FieldNode("wthr_pass_iso9000_atht", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_pass_iso9000_atht", 1,0, false, "是否通过ISO9000认证" )))
					.addNode(new FieldNode("wthr_pass_iso14000_atht", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_pass_iso14000_atht", 1,0, false, "是否通过ISO14000认证" )))
					.addNode(new FieldNode("tech_lv", new MsgField(ContentEnum.MessageType.STRING.toString(), "tech_lv", 1,0, false, "技术水平" )))
					.addNode(new FieldNode("oprn_plc_civil_cptmt_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprn_plc_civil_cptmt_code", 12,0, false, "经营地行政区划代码" )))
					.addNode(new FieldNode("loan_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "loan_acct_num", 40,0, false, "贷款账号" )))
					.addNode(new FieldNode("wthr_shrhdr_cust", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_shrhdr_cust", 1,0, false, "是否股东客户" )))
					.addNode(new FieldNode("shr_holdg_qty", new MsgField(ContentEnum.MessageType.STRING.toString(), "shr_holdg_qty", 10,0, false, "持股数" )))
					.addNode(new FieldNode("dvdnd_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "dvdnd_acct_num", 40,0, false, "股金账号" )))
					.addNode(new FieldNode("wthr_be_rlvc_corp", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_be_rlvc_corp", 1,0, false, "是否为关联单位" )))
					.addNode(new FieldNode("rltnp_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "rltnp_id", 1,0, false, "关系标识" )))
					.addNode(new FieldNode("val_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "val_info", 300,0, false, "价值信息" )))
					.addNode(new FieldNode("qry_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_pswd", 32,0, false, "查询密码" )))
					.addNode(new FieldNode("cust_bns_pnts", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_bns_pnts", 12,0, false, "客户积分" )))
					.addNode(new FieldNode("cust_crdbl", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_crdbl", 1,0, false, "客户信用度" )))
					.addNode(new FieldNode("exte_cr_grd", new MsgField(ContentEnum.MessageType.STRING.toString(), "exte_cr_grd", 10,0, false, "外部信用等级" )))
					.addNode(new FieldNode("cust_risk_lv", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_risk_lv", 2,0, false, "客户风险级别" )))
					.addNode(new FieldNode("cust_svc_lv", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_svc_lv", 1,0, false, "客户服务级别" )))
					.addNode(new FieldNode("profit_ctrbn_degr", new MsgField(ContentEnum.MessageType.STRING.toString(), "profit_ctrbn_degr", 10,0, false, "利润贡献度" )))
					.addNode(new FieldNode("wthr_exmpt", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_exmpt", 1,0, false, "是否免税" )))
					.addNode(new FieldNode("tax_rate_nat", new MsgField(ContentEnum.MessageType.STRING.toString(), "tax_rate_nat", 10,0, false, "税率国别" )))
					.addNode(new FieldNode("wthr_drmt_cust_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_drmt_cust_flg", 1,0, false, "是否睡眠客户标志" )))
					.addNode(new FieldNode("wthr_frz_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_frz_flg", 1,0, false, "是否冻结标志" )))
					.addNode(new FieldNode("wthr_death_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_death_flg", 1,0, false, "是否死亡标志" )))
					.addNode(new FieldNode("id_chk_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "id_chk_flg", 2,0, false, "身份核查标志" )))
					.addNode(new FieldNode("cust_dupct", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_dupct", 1,0, false, "客户复印件" )))
					.addNode(new FieldNode("wthr_lock", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_lock", 1,0, false, "是否锁定" )))
					.addNode(new FieldNode("wthr_clr", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_clr", 1,0, false, "是否清除" )))
					.addNode(new FieldNode("cust_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_ste", 1,0, false, "客户状态" )))
					.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
					.addNode(new FieldNode("eff_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "eff_dt", 8,0, false, "生效日期" )))
					.addNode(new FieldNode("cust_info_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_info_src", 1,0, false, "客户信息来源" )))
					.addNode(new FieldNode("prphr_sys_open_busi_set", new MsgField(ContentEnum.MessageType.STRING.toString(), "prphr_sys_open_busi_set", 120,0, false, "外围系统开通业务集" )))
					.addNode(new FieldNode("blgd_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "blgd_org", 12,0, false, "归属机构" )))
					.addNode(new FieldNode("wthr_ptcpte_mktg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_ptcpte_mktg", 1,0, false, "是否参与营销" )))
					.addNode(new FieldNode("salman_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "salman_num", 10,0, false, "营销人编号" )))
					.addNode(new FieldNode("salman_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "salman_nm", 256,0, false, "营销人名称" )))
					.addNode(new FieldNode("mktg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "mktg_org", 12,0, false, "营销机构" )))
					.addNode(new FieldNode("crea_chnl", new MsgField(ContentEnum.MessageType.STRING.toString(), "crea_chnl", 7,0, false, "创建渠道" )))
					.addNode(new FieldNode("lgl_pern_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "lgl_pern_code", 4,0, false, "法人代码" )))
					.addNode(new FieldNode("rec_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "rec_ste", 1,0, false, "记录状态" )))
					.addNode(new FieldNode("cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_tp", 2,0, false, "客户类型" )))
					.addNode(new FieldNode("docs_invld_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_invld_dt", 8,0, false, "证件失效日期" )))
					.addNode(new FieldNode("rsdnt_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "rsdnt_attr", 1,0, false, "居民属性" )))
					.addNode(new FieldNode("finc_spvsr_tel_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "finc_spvsr_tel_num", 20,0, false, "财务负责人电话号码" )))
					.addNode(new ArrayNode("listnm_list",false)
							.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
							.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
							.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
							.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm", 256,0, false, "客户中文名" )))
							.addNode(new FieldNode("docs_issue_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_issue_dt", 8,0, false, "证件签发日期" )))
							.addNode(new FieldNode("docs_invld_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_invld_dt", 8,0, false, "证件失效日期" )))
							.addNode(new FieldNode("rgon_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgon_code_num", 20,0, false, "地区代号" )))
							.addNode(new FieldNode("rgon_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgon_nm", 256,0, false, "地区名称" )))
							.addNode(new FieldNode("civil_cptmt_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "civil_cptmt_code", 12,0, false, "行政区划代码" )))
							.addNode(new FieldNode("issug_offc_cty", new MsgField(ContentEnum.MessageType.STRING.toString(), "issug_offc_cty", 80,0, false, "发证机关国家" )))
							.addNode(new FieldNode("issug_offc", new MsgField(ContentEnum.MessageType.STRING.toString(), "issug_offc", 300,0, false, "发证机关" )))
							.addNode(new FieldNode("docs_rgstn_addr", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_rgstn_addr", 300,0, false, "证件登记地址" )))
							.addNode(new FieldNode("engl_addr", new MsgField(ContentEnum.MessageType.STRING.toString(), "engl_addr", 300,0, false, "英文地址" )))
							.addNode(new FieldNode("splmty_info_comt_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "splmty_info_comt_01", 80,0, false, "补充信息说明1" )))
							.addNode(new FieldNode("splmty_info_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "splmty_info_01", 80,0, false, "补充信息1" )))
							.addNode(new FieldNode("splmty_info_comt_02", new MsgField(ContentEnum.MessageType.STRING.toString(), "splmty_info_comt_02", 80,0, false, "补充信息说明2" )))
							.addNode(new FieldNode("splmty_info_02", new MsgField(ContentEnum.MessageType.STRING.toString(), "splmty_info_02", 80,0, false, "补充信息2" )))
							.addNode(new FieldNode("splmty_info_comt_03", new MsgField(ContentEnum.MessageType.STRING.toString(), "splmty_info_comt_03", 80,0, false, "补充信息说明3" )))
							.addNode(new FieldNode("splmty_info_03", new MsgField(ContentEnum.MessageType.STRING.toString(), "splmty_info_03", 80,0, false, "补充信息3" )))
							.addNode(new FieldNode("main_info_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "main_info_flg", 1,0, false, "主信息标志" )))
							.addNode(new FieldNode("comt_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "comt_info", 1500,0, false, "说明信息" )))
							).addNode(new ArrayNode("listnm01_list",false)
									.addNode(new FieldNode("addr_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "addr_tp", 3,0, false, "地址类型" )))
									.addNode(new FieldNode("addr_cntnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "addr_cntnt", 300,0, false, "地址内容" )))
									.addNode(new FieldNode("pstcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "pstcd", 12,0, false, "邮政编码" )))
									.addNode(new FieldNode("cty_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cty_nm", 256,0, false, "国家名称" )))
									.addNode(new FieldNode("prov_city_dist", new MsgField(ContentEnum.MessageType.STRING.toString(), "prov_city_dist", 256,0, false, "省市，区" )))
									.addNode(new FieldNode("city_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "city_nm", 256,0, false, "城市名" )))
									.addNode(new FieldNode("engl_cty", new MsgField(ContentEnum.MessageType.STRING.toString(), "engl_cty", 300,0, false, "英文国家" )))
									.addNode(new FieldNode("engl_city_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "engl_city_nm", 300,0, false, "英文城市名" )))
									.addNode(new FieldNode("engl_addr", new MsgField(ContentEnum.MessageType.STRING.toString(), "engl_addr", 300,0, false, "英文地址" )))
									.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
									).addNode(new ArrayNode("listnm02_list",false)
											.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
											.addNode(new FieldNode("cntct_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_info", 2,0, false, "联系方式" )))
											.addNode(new FieldNode("cntct_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_tel", 20,0, false, "联系电话" )))
											.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
											).addNode(new ArrayNode("listnm03_list",false)
													.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
													.addNode(new FieldNode("serl_num_long", new MsgField(ContentEnum.MessageType.STRING.toString(), "serl_num_long", 10,0, false, "序号" )))
													.addNode(new FieldNode("cntct_pern_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_tp", 2,0, false, "联系人类型" )))
													.addNode(new FieldNode("cntct_pern_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_nm", 256,0, false, "联系人" )))
													.addNode(new FieldNode("cntct_pern_gender", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_gender", 2,0, false, "联系人性别" )))
													.addNode(new FieldNode("apln_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "apln_flg", 1,0, false, "称谓标志" )))
													.addNode(new FieldNode("apln_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "apln_nm", 750,0, false, "称谓名" )))
													.addNode(new FieldNode("cntct_pern_duty", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_duty", 10,0, false, "联系人职务" )))
													.addNode(new FieldNode("birth_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "birth_dt", 8,0, false, "出生日期" )))
													.addNode(new FieldNode("rsdnt_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "rsdnt_attr", 1,0, false, "居民属性" )))
													.addNode(new FieldNode("rltnp_with_cntct_pern", new MsgField(ContentEnum.MessageType.STRING.toString(), "rltnp_with_cntct_pern", 2,0, false, "与联系人关系" )))
													.addNode(new FieldNode("cntct_pern_cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_cust_num", 32,0, false, "联系人客户号" )))
													.addNode(new FieldNode("cntct_pern_corp_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_corp_nm", 256,0, false, "联系人单位名称" )))
													.addNode(new FieldNode("cntct_pern_offc_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_offc_tel", 20,0, false, "联系人办公电话" )))
													.addNode(new FieldNode("cntct_pern_offc_addr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_offc_addr", 300,0, false, "联系人办公地址" )))
													.addNode(new FieldNode("cntct_pern_corp_pstcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_corp_pstcd", 12,0, false, "联系人单位邮编" )))
													.addNode(new FieldNode("cntct_pern_corp_fax", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_corp_fax", 40,0, false, "联系人单位传真" )))
													.addNode(new FieldNode("web_addr", new MsgField(ContentEnum.MessageType.STRING.toString(), "web_addr", 300,0, false, "网址" )))
													.addNode(new FieldNode("cntct_pern_cntct_addr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_cntct_addr", 300,0, false, "联系人联系地址" )))
													.addNode(new FieldNode("cntct_pern_pstcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_pstcd", 12,0, false, "联系人邮编" )))
													.addNode(new FieldNode("cntct_pern_cntct_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_cntct_tel", 20,0, false, "联系人联系电话" )))
													.addNode(new FieldNode("cntct_pern_fax_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_fax_num", 20,0, false, "联系人传真号码" )))
													.addNode(new FieldNode("cntct_pern_mbph", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_mbph", 20,0, false, "联系人移动电话" )))
													.addNode(new FieldNode("cntct_pern_email", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_email", 300,0, false, "联系人Email邮箱" )))
													.addNode(new FieldNode("cntct_pern_rsdnc_addr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_rsdnc_addr", 300,0, false, "联系人住宅地址" )))
													.addNode(new FieldNode("cntct_pern_rsdnc_pstcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_rsdnc_pstcd", 12,0, false, "联系人住宅邮编" )))
													.addNode(new FieldNode("cntct_pern_rsdnc_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_rsdnc_tel", 20,0, false, "联系人住宅电话" )))
													.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
													.addNode(new FieldNode("cntct_pern_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_docs_num", 30,0, false, "联系人证件号码" )))
													.addNode(new FieldNode("cntct_tm_comt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_tm_comt", 80,0, false, "联系时间说明" )))
													.addNode(new FieldNode("cntct_info_comt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_info_comt", 225,0, false, "联系方式说明" )))
													.addNode(new FieldNode("main_info_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "main_info_flg", 1,0, false, "主信息标志" )))
													.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
													));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C012000112_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm", 256,0, false, "客户中文名" )))
					.addNode(new FieldNode("engl_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "engl_nm", 120,0, false, "英文名称" )))
					.addNode(new FieldNode("aprv_estb_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "aprv_estb_org", 300,0, false, "批准成立机构" )))
					.addNode(new FieldNode("rgon_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgon_code_num", 20,0, false, "地区代号" )))
					.addNode(new FieldNode("rgon_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgon_nm", 256,0, false, "地区名称" )))
					.addNode(new FieldNode("civil_cptmt_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "civil_cptmt_code", 12,0, false, "行政区划代码" )))
					.addNode(new FieldNode("corpt_rprtv_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpt_rprtv_nm", 256,0, false, "法人代表名称" )))
					.addNode(new FieldNode("corpt_rprtv_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpt_rprtv_docs_catg", 3,0, false, "法人代表证件种类" )))
					.addNode(new FieldNode("corpt_rprtv_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpt_rprtv_docs_num", 30,0, false, "法人代表证件号码" )))
					.addNode(new FieldNode("rgstn_cptl", new MsgField(ContentEnum.MessageType.INT.toString(), "rgstn_cptl", 18,2, false, "注册资金" )))
					.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
					.addNode(new FieldNode("mntnc_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_dt", 8,0, false, "维护日期" )))
					.addNode(new FieldNode("mntnc_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_tm", 9,0, false, "维护时间" )))
					.addNode(new FieldNode("mntnc_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_org", 12,0, false, "维护机构" )))
					.addNode(new FieldNode("mntnc_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_tlr", 10,0, false, "维护柜员" )))
					.addNode(new FieldNode("mntnc_tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_tlr_rung_num", 32,0, false, "维护柜员流水号" )))
					.addNode(new FieldNode("mntnc_athrzn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_athrzn_tlr", 10,0, false, "维护授权柜员" )))
					.addNode(new FieldNode("cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_tp", 2,0, false, "客户类型" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("cr_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "cr_code", 32,0, false, "信用代码" )))
					.addNode(new FieldNode("invld_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "invld_dt", 8,0, false, "失效日期" )))
					.addNode(new FieldNode("issug_offc", new MsgField(ContentEnum.MessageType.STRING.toString(), "issug_offc", 300,0, false, "发证机关" )))
					.addNode(new FieldNode("docs_rgstn_addr", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_rgstn_addr", 300,0, false, "证件登记地址" )))
					.addNode(new FieldNode("civil_cptmt_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "civil_cptmt_nm", 256,0, false, "行政区划名称" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

