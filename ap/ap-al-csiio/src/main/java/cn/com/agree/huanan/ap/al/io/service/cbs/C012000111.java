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
 * BASESVC.C012000111 客户信息管理.对私客户信息同步 
 * C0120001.11 cf4005
 * 0005 新核心系统
 * @author XZF
 */ 
@Component
public class C012000111 extends EsbCoreChannelService {

	private static C012000111_I i = new C012000111_I();
	private static C012000111_O o = new C012000111_O();
	public C012000111() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C012000111_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm", 256,0, false, "客户中文名" )))
					.addNode(new FieldNode("cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_tp", 2,0, false, "客户类型" )))
					.addNode(new FieldNode("pinyin_lstnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "pinyin_lstnm", 120,0, false, "拼音姓" )))
					.addNode(new FieldNode("pinyin_frstnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "pinyin_frstnm", 120,0, false, "拼音名" )))
					.addNode(new FieldNode("engl_lstnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "engl_lstnm", 120,0, false, "英文姓" )))
					.addNode(new FieldNode("engl_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "engl_nm", 120,0, false, "英文名称" )))
					.addNode(new FieldNode("former_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "former_nm", 256,0, false, "曾用名" )))
					.addNode(new FieldNode("gender", new MsgField(ContentEnum.MessageType.STRING.toString(), "gender", 2,0, false, "性别" )))
					.addNode(new FieldNode("apln_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "apln_flg", 1,0, false, "称谓标志" )))
					.addNode(new FieldNode("apln_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "apln_nm", 256,0, false, "称谓名" )))
					.addNode(new FieldNode("blood_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "blood_tp", 1,0, false, "血型" )))
					.addNode(new FieldNode("rlgn_faith", new MsgField(ContentEnum.MessageType.STRING.toString(), "rlgn_faith", 10,0, false, "宗教信仰" )))
					.addNode(new FieldNode("cust_snthes_evlan_lv", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_snthes_evlan_lv", 2,0, false, "客户综合评估级别" )))
					.addNode(new FieldNode("wthr_dmstc_rsdnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_dmstc_rsdnt", 1,0, false, "是否境内居民" )))
					.addNode(new FieldNode("rsdnt_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "rsdnt_attr", 1,0, false, "居民属性" )))
					.addNode(new FieldNode("wthr_empe_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_empe_flg", 1,0, false, "是否员工标志" )))
					.addNode(new FieldNode("empe_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "empe_num", 60,0, false, "员工编号" )))
					.addNode(new FieldNode("empe_blgd_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "empe_blgd_org", 12,0, false, "员工所属机构" )))
					.addNode(new FieldNode("nat_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "nat_code", 4,0, false, "国别代码" )))
					.addNode(new FieldNode("rgon_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgon_code_num", 20,0, false, "地区代号" )))
					.addNode(new FieldNode("rgon_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgon_nm", 256,0, false, "地区名称" )))
					.addNode(new FieldNode("dmcl_plc_civil_cptmt_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "dmcl_plc_civil_cptmt_code", 12,0, false, "户籍地行政区划代码" )))
					.addNode(new FieldNode("dmcl_lclt_city", new MsgField(ContentEnum.MessageType.STRING.toString(), "dmcl_lclt_city", 8,0, false, "户籍所在城市" )))
					.addNode(new FieldNode("birth_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "birth_dt", 8,0, false, "出生日期" )))
					.addNode(new FieldNode("rsdnc_cptmt_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "rsdnc_cptmt_code", 12,0, false, "居住地行政区划代码" )))
					.addNode(new FieldNode("qry_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_pswd", 32,0, false, "查询密码" )))
					.addNode(new FieldNode("wrkg_corp", new MsgField(ContentEnum.MessageType.STRING.toString(), "wrkg_corp", 256,0, false, "工作单位" )))
					.addNode(new FieldNode("wrkg_dprtmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "wrkg_dprtmt", 80,0, false, "任职部门" )))
					.addNode(new FieldNode("ptcpte_this_corp_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptcpte_this_corp_dt", 8,0, false, "参加本单位日期" )))
					.addNode(new FieldNode("corp_ecnmc_charic", new MsgField(ContentEnum.MessageType.STRING.toString(), "corp_ecnmc_charic", 3,0, false, "单位经济性质" )))
					.addNode(new FieldNode("idsty_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "idsty_class", 4,0, false, "行业类别" )))
					.addNode(new FieldNode("idsty_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "idsty_code", 10,0, false, "行业代码" )))
					.addNode(new FieldNode("corpt_rprtv_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpt_rprtv_class", 1,0, false, "法人代表类别" )))
					.addNode(new FieldNode("lgl_pern_rsdnt_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "lgl_pern_rsdnt_attr", 1,0, false, "法人居民属性" )))
					.addNode(new FieldNode("corpt_rprtv_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpt_rprtv_nm", 256,0, false, "法人代表名称" )))
					.addNode(new FieldNode("corpt_rprtv_tel_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpt_rprtv_tel_num", 40,0, false, "法人代表电话号码" )))
					.addNode(new FieldNode("duty", new MsgField(ContentEnum.MessageType.STRING.toString(), "duty", 10,0, false, "职务" )))
					.addNode(new FieldNode("ocupn", new MsgField(ContentEnum.MessageType.STRING.toString(), "ocupn", 10,0, false, "职业" )))
					.addNode(new FieldNode("job_ttl", new MsgField(ContentEnum.MessageType.STRING.toString(), "job_ttl", 2,0, false, "职称" )))
					.addNode(new FieldNode("moly_incm", new MsgField(ContentEnum.MessageType.INT.toString(), "moly_incm", 18,2, false, "月收入" )))
					.addNode(new FieldNode("anul_saly", new MsgField(ContentEnum.MessageType.INT.toString(), "anul_saly", 18,2, false, "年薪" )))
					.addNode(new FieldNode("race", new MsgField(ContentEnum.MessageType.STRING.toString(), "race", 2,0, false, "民族" )))
					.addNode(new FieldNode("lang", new MsgField(ContentEnum.MessageType.STRING.toString(), "lang", 10,0, false, "语言" )))
					.addNode(new FieldNode("edu_bkgrd", new MsgField(ContentEnum.MessageType.STRING.toString(), "edu_bkgrd", 10,0, false, "学历" )))
					.addNode(new FieldNode("major", new MsgField(ContentEnum.MessageType.STRING.toString(), "major", 32,0, false, "专业" )))
					.addNode(new FieldNode("mrrg_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "mrrg_cond", 2,0, false, "婚姻情况" )))
					.addNode(new FieldNode("child_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "child_cond", 2,0, false, "子女情况" )))
					.addNode(new FieldNode("with_wtht_prvt_car", new MsgField(ContentEnum.MessageType.STRING.toString(), "with_wtht_prvt_car", 1,0, false, "有无私家车" )))
					.addNode(new FieldNode("house_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "house_cond", 1,0, false, "住房情况" )))
					.addNode(new FieldNode("house_area", new MsgField(ContentEnum.MessageType.INT.toString(), "house_area", 18,2, false, "住房面积" )))
					.addNode(new FieldNode("house_propty_assmt", new MsgField(ContentEnum.MessageType.INT.toString(), "house_propty_assmt", 18,2, false, "房产估价" )))
					.addNode(new FieldNode("evlan_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "evlan_dt", 8,0, false, "评估日期" )))
					.addNode(new FieldNode("cust_major_qualf", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_major_qualf", 300,0, false, "客户专业资格" )))
					.addNode(new FieldNode("idvdl_asset_totl_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "idvdl_asset_totl_amt", 18,2, false, "个人资产总额" )))
					.addNode(new FieldNode("idvdl_db_cr_totl_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "idvdl_db_cr_totl_amt", 18,2, false, "个人借贷总额" )))
					.addNode(new FieldNode("brdn_famy_mber_num", new MsgField(ContentEnum.MessageType.INT.toString(), "brdn_famy_mber_num", 10,0, false, "负担家庭成员数目" )))
					.addNode(new FieldNode("famy_anul_incm_totl_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "famy_anul_incm_totl_amt", 18,2, false, "家庭年收入总额" )))
					.addNode(new FieldNode("main_ecnmc_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "main_ecnmc_src", 80,0, false, "主要经济来源" )))
					.addNode(new FieldNode("othr_ecnmc_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "othr_ecnmc_src", 80,0, false, "其它经济来源" )))
					.addNode(new FieldNode("idvdl_tax_pymt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "idvdl_tax_pymt_num", 32,0, false, "个人纳税号" )))
					.addNode(new FieldNode("fta_cust_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fta_cust_flg", 1,0, false, "自贸区客户标志" )))
					.addNode(new FieldNode("tax_payer_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "tax_payer_flg", 1,0, false, "纳税人标志" )))
					.addNode(new FieldNode("idvdl_socy_insu_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "idvdl_socy_insu_num", 32,0, false, "个人社会保险号" )))
					.addNode(new FieldNode("prct_qualf_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "prct_qualf_cond", 32,0, false, "执业资格状况" )))
					.addNode(new FieldNode("ptcpte_wrkg_yr", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptcpte_wrkg_yr", 4,0, false, "参加工作年份" )))
					.addNode(new FieldNode("wthr_shrhdr_cust", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_shrhdr_cust", 1,0, false, "是否股东客户" )))
					.addNode(new FieldNode("shr_holdg_qty", new MsgField(ContentEnum.MessageType.INT.toString(), "shr_holdg_qty", 10,0, false, "持股数" )))
					.addNode(new FieldNode("crea_chnl", new MsgField(ContentEnum.MessageType.STRING.toString(), "crea_chnl", 7,0, false, "创建渠道" )))
					.addNode(new FieldNode("rec_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "rec_ste", 1,0, false, "记录状态" )))
					.addNode(new FieldNode("dvdnd_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "dvdnd_acct_num", 40,0, false, "股金账号" )))
					.addNode(new FieldNode("loan_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "loan_acct_num", 40,0, false, "贷款账号" )))
					.addNode(new FieldNode("val_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "val_info", 300,0, false, "价值信息" )))
					.addNode(new FieldNode("cust_bns_pnts", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_bns_pnts", 12,0, false, "客户积分" )))
					.addNode(new FieldNode("cust_crdbl", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_crdbl", 1,0, false, "客户信用度" )))
					.addNode(new FieldNode("exte_cr_grd", new MsgField(ContentEnum.MessageType.STRING.toString(), "exte_cr_grd", 10,0, false, "外部信用等级" )))
					.addNode(new FieldNode("cust_risk_lv", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_risk_lv", 2,0, false, "客户风险级别" )))
					.addNode(new FieldNode("cust_svc_lv", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_svc_lv", 1,0, false, "客户服务级别" )))
					.addNode(new FieldNode("profit_ctrbn_degr", new MsgField(ContentEnum.MessageType.STRING.toString(), "profit_ctrbn_degr", 10,0, false, "利润贡献度" )))
					.addNode(new FieldNode("wthr_exmpt", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_exmpt", 1,0, false, "是否免税" )))
					.addNode(new FieldNode("tax_rate_nat", new MsgField(ContentEnum.MessageType.STRING.toString(), "tax_rate_nat", 4,0, false, "税率国别" )))
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
					.addNode(new FieldNode("tel_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tel_num", 20,0, false, "电话号码" )))
					.addNode(new ArrayNode("listnm01_list",false)
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
							.addNode(new FieldNode("main_info_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "main_info_flg", 1,0, false, "主信息标志" )))
							.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
							).addNode(new ArrayNode("listnm02_list",false)
									.addNode(new FieldNode("addr_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "addr_tp", 3,0, false, "地址类型" )))
									.addNode(new FieldNode("addr_cntnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "addr_cntnt", 300,0, false, "地址内容" )))
									.addNode(new FieldNode("pstcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "pstcd", 12,0, false, "邮政编码" )))
									.addNode(new FieldNode("rgon_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgon_code_num", 20,0, false, "地区代号" )))
									.addNode(new FieldNode("rgon_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgon_nm", 256,0, false, "地区名称" )))
									.addNode(new FieldNode("civil_cptmt_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "civil_cptmt_code", 12,0, false, "行政区划代码" )))
									.addNode(new FieldNode("cty_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cty_nm", 256,0, false, "国家名称" )))
									.addNode(new FieldNode("prov_city_dist", new MsgField(ContentEnum.MessageType.STRING.toString(), "prov_city_dist", 256,0, false, "省市，区" )))
									.addNode(new FieldNode("city_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "city_nm", 256,0, false, "城市名" )))
									.addNode(new FieldNode("engl_cty", new MsgField(ContentEnum.MessageType.STRING.toString(), "engl_cty", 120,0, false, "英文国家" )))
									.addNode(new FieldNode("engl_city_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "engl_city_nm", 120,0, false, "英文城市名" )))
									.addNode(new FieldNode("engl_addr", new MsgField(ContentEnum.MessageType.STRING.toString(), "engl_addr", 300,0, false, "英文地址" )))
									.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
									).addNode(new ArrayNode("listnm03_list",false)
											.addNode(new FieldNode("cntct_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_info", 2,0, false, "联系方式" )))
											.addNode(new FieldNode("cntct_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_tel", 40,0, false, "联系电话" )))
											.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
											).addNode(new ArrayNode("listnm04_list",false)
													.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
													.addNode(new FieldNode("serl_num_long", new MsgField(ContentEnum.MessageType.INT.toString(), "serl_num_long", 10,0, false, "序号(int)" )))
													.addNode(new FieldNode("cntct_pern_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_tp", 2,0, false, "联系人类型" )))
													.addNode(new FieldNode("cntct_pern_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_nm", 256,0, false, "联系人" )))
													.addNode(new FieldNode("cntct_pern_gender", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_gender", 2,0, false, "联系人性别" )))
													.addNode(new FieldNode("apln_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "apln_flg", 1,0, false, "称谓标志" )))
													.addNode(new FieldNode("apln_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "apln_nm", 256,0, false, "称谓名" )))
													.addNode(new FieldNode("cntct_pern_duty", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_duty", 10,0, false, "联系人职务" )))
													.addNode(new FieldNode("birth_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "birth_dt", 8,0, false, "出生日期" )))
													.addNode(new FieldNode("rsdnt_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "rsdnt_attr", 1,0, false, "居民属性" )))
													.addNode(new FieldNode("rltnp_with_cntct_pern", new MsgField(ContentEnum.MessageType.STRING.toString(), "rltnp_with_cntct_pern", 2,0, false, "与联系人关系" )))
													.addNode(new FieldNode("cntct_pern_cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_cust_num", 32,0, false, "联系人客户号" )))
													.addNode(new FieldNode("cntct_pern_corp_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_corp_nm", 256,0, false, "联系人单位名称" )))
													.addNode(new FieldNode("cntct_pern_offc_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_offc_tel", 40,0, false, "联系人办公电话" )))
													.addNode(new FieldNode("cntct_pern_offc_addr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_offc_addr", 300,0, false, "联系人办公地址" )))
													.addNode(new FieldNode("cntct_pern_corp_pstcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_corp_pstcd", 12,0, false, "联系人单位邮编" )))
													.addNode(new FieldNode("cntct_pern_corp_fax", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_corp_fax", 40,0, false, "联系人单位传真" )))
													.addNode(new FieldNode("web_addr", new MsgField(ContentEnum.MessageType.STRING.toString(), "web_addr", 300,0, false, "网址" )))
													.addNode(new FieldNode("cntct_pern_cntct_addr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_cntct_addr", 300,0, false, "联系人联系地址" )))
													.addNode(new FieldNode("cntct_pern_pstcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_pstcd", 12,0, false, "联系人邮编" )))
													.addNode(new FieldNode("cntct_pern_cntct_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_cntct_tel", 40,0, false, "联系人联系电话" )))
													.addNode(new FieldNode("cntct_pern_fax_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_fax_num", 40,0, false, "联系人传真号码" )))
													.addNode(new FieldNode("cntct_pern_mbph", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_mbph", 40,0, false, "联系人移动电话" )))
													.addNode(new FieldNode("cntct_pern_email", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_email", 300,0, false, "联系人Email邮箱" )))
													.addNode(new FieldNode("cntct_pern_rsdnc_addr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_rsdnc_addr", 300,0, false, "联系人住宅地址" )))
													.addNode(new FieldNode("cntct_pern_rsdnc_pstcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_rsdnc_pstcd", 12,0, false, "联系人住宅邮编" )))
													.addNode(new FieldNode("cntct_pern_rsdnc_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_rsdnc_tel", 40,0, false, "联系人住宅电话" )))
													.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
													.addNode(new FieldNode("cntct_pern_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_pern_docs_num", 30,0, false, "联系人证件号码" )))
													.addNode(new FieldNode("cntct_tm_comt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_tm_comt", 80,0, false, "联系时间说明" )))
													.addNode(new FieldNode("cntct_info_comt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_info_comt", 225,0, false, "联系方式说明" )))
													.addNode(new FieldNode("main_info_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "main_info_flg", 1,0, false, "主信息标志" )))
													.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
													).addNode(new ArrayNode("listnm05_list",false)
															.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
															.addNode(new FieldNode("serl_num_long", new MsgField(ContentEnum.MessageType.INT.toString(), "serl_num_long", 10,0, false, "序号(int)" )))
															.addNode(new FieldNode("guardn_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "guardn_nm", 256,0, false, "监护人名称" )))
															.addNode(new FieldNode("guardn_cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "guardn_cust_num", 32,0, false, "监护人客户号" )))
															.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
															.addNode(new FieldNode("guardn_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "guardn_docs_num", 30,0, false, "监护人证件号" )))
															.addNode(new FieldNode("guardn_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "guardn_tp", 4,0, false, "监护人类型" )))
															.addNode(new FieldNode("corp_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "corp_nm", 256,0, false, "单位名称" )))
															.addNode(new FieldNode("offc_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "offc_tel", 40,0, false, "办公电话" )))
															.addNode(new FieldNode("mbph", new MsgField(ContentEnum.MessageType.STRING.toString(), "mbph", 40,0, false, "移动电话" )))
															.addNode(new FieldNode("cntct_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_tel", 40,0, false, "联系电话" )))
															.addNode(new FieldNode("email_addr", new MsgField(ContentEnum.MessageType.STRING.toString(), "email_addr", 300,0, false, "email地址" )))
															.addNode(new FieldNode("cntct_addr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntct_addr", 300,0, false, "联系地址" )))
															.addNode(new FieldNode("pstcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "pstcd", 12,0, false, "邮政编码" )))
															.addNode(new FieldNode("fax_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "fax_num", 40,0, false, "传真号码" )))
															.addNode(new FieldNode("main_info_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "main_info_flg", 1,0, false, "主信息标志" )))
															.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
															).addNode(new ArrayNode("listnm06_list",false)
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
																	.addNode(new FieldNode("main_info_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "main_info_flg", 1,0, false, "主信息标志" )))
																	.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
																	)
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C012000111_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, true, "客户号" )))
					.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm", 256,0, true, "客户中文名" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

