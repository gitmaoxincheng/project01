package cn.com.agree.huanan.ap.al.io.service.eci.cap;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODCAP0041  PAD申请发卡/发卡加分期
 * BODCAP0041 ar1000 ar1000
 *  信审平台
 * @author WYJ
 */
@Component
public class BODCAP0041 extends EciChannelService {

	private static BODCAP0041_I i = new BODCAP0041_I();
	private static BODCAP0041_O o = new BODCAP0041_O();

	public BODCAP0041() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODCAP0041_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("trxn_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "trxn_seq", 40,0, false, "交易流水" )))
					.addNode(new FieldNode("busi_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_seq", 40,0, false, "业务流水" )))
					.addNode(new FieldNode("sponsor_system", new MsgField(ContentEnum.MessageType.STRING.toString(), "sponsor_system", 40,0, false, "发起方系统编号" )))
					.addNode(new FieldNode("caller_system", new MsgField(ContentEnum.MessageType.STRING.toString(), "caller_system", 40,0, false, "调用方系统编号" )))
					.addNode(new FieldNode("busi_org_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_org_id", 10,0, false, "业务法人" )))
					.addNode(new FieldNode("channel_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel_id", 40,0, false, "渠道" )))
					.addNode(new FieldNode("caller_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "caller_date", 8,0, false, "调用方日期" )))
					.addNode(new FieldNode("busi_teller_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_teller_id", 32,0, false, "交易柜员" )))
					.addNode(new FieldNode("busi_branch_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_branch_id", 10,0, false, "业务机构ID" )))
					.addNode(new FieldNode("page_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "page_no", 19,0, false, "分页页码" )))
					.addNode(new FieldNode("page_size", new MsgField(ContentEnum.MessageType.STRING.toString(), "page_size", 19,0, false, "每页返回数量" )))
					.addNode(new FieldNode("full_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "full_name", 120,0, false, "申请人姓名" )))
					.addNode(new FieldNode("mobile_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobile_no", 11,0, false, "手机号码" )))
					.addNode(new FieldNode("cust_manager_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_manager_id", 32,0, false, "客户经理ID" )))
					.addNode(new FieldNode("cust_manager_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_manager_name", 120,0, false, "客户经理名称" )))
					.addNode(new FieldNode("appl_type_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_type_id", 40,0, false, "申请类型ID" )))
					.addNode(new FieldNode("memo", new MsgField(ContentEnum.MessageType.STRING.toString(), "memo", 200,0, false, "网点意见" )))
					.addNode(new FieldNode("reg_black_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "reg_black_ind", 1,0, false, "登记黑名单标识" )))
					.addNode(new FieldNode("brch_belong", new MsgField(ContentEnum.MessageType.STRING.toString(), "brch_belong", 10,0, false, "所属机构" )))
					.addNode(new FieldNode("product_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "product_code", 20,0, false, "产品代码" )))
					.addNode(new FieldNode("member_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "member_id", 200,0, false, "会员号" )))
					.addNode(new FieldNode("card_face_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_face_id", 20,0, false, "卡面ID" )))
					.addNode(new FieldNode("accept_updown_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "accept_updown_ind", 1,0, false, "接受卡片升降级指示" )))
					.addNode(new FieldNode("supp_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "supp_ind", 1,0, false, "主附卡标识" )))
					.addNode(new FieldNode("crm_level", new MsgField(ContentEnum.MessageType.STRING.toString(), "crm_level", 2,0, false, "CRM评级" )))
					.addNode(new FieldNode("id_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "id_type", 2,0, false, "证件类型" )))
					.addNode(new FieldNode("id_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "id_no", 32,0, false, "证件号码" )))
					.addNode(new FieldNode("id_expired_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "id_expired_date", 8,0, false, "证件到期日" )))
					.addNode(new FieldNode("id_issue_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "id_issue_org", 200,0, false, "发证机关" )))
					.addNode(new FieldNode("registed_country", new MsgField(ContentEnum.MessageType.STRING.toString(), "registed_country", 1,0, false, "国籍" )))
					.addNode(new FieldNode("registered_address", new MsgField(ContentEnum.MessageType.STRING.toString(), "registered_address", 87,0, false, "户籍地址" )))
					.addNode(new FieldNode("registered_addr_state", new MsgField(ContentEnum.MessageType.STRING.toString(), "registered_addr_state", 60,0, false, "户籍地址-省" )))
					.addNode(new FieldNode("registered_addr_city", new MsgField(ContentEnum.MessageType.STRING.toString(), "registered_addr_city", 60,0, false, "户籍地址-市" )))
					.addNode(new FieldNode("registered_addr_district", new MsgField(ContentEnum.MessageType.STRING.toString(), "registered_addr_district", 60,0, false, "户籍地址-区" )))
					.addNode(new FieldNode("other_loancard_bank_count", new MsgField(ContentEnum.MessageType.INT.toString(), "other_loancard_bank_count", 19,0, false, "他行信用卡-银行数" )))
					.addNode(new FieldNode("other_loancard_total_limit", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "other_loancard_total_limit", 21,2, false, "他行信用卡-总授信" )))
					.addNode(new FieldNode("country_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "country_code", 3,0, false, "国别代码" )))
					.addNode(new FieldNode("country_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "country_name", 100,0, false, "国家名称" )))
					.addNode(new FieldNode("emboss_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "emboss_name", 120,0, false, "凸印名" )))
					.addNode(new FieldNode("sex", new MsgField(ContentEnum.MessageType.STRING.toString(), "sex", 1,0, false, "性别" )))
					.addNode(new FieldNode("title", new MsgField(ContentEnum.MessageType.STRING.toString(), "title", 100,0, false, "职称" )))
					.addNode(new FieldNode("nation_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "nation_code", 3,0, false, "民族" )))
					.addNode(new FieldNode("native_place_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "native_place_ind", 1,0, false, "本地户口标识" )))
					.addNode(new FieldNode("marital_status", new MsgField(ContentEnum.MessageType.STRING.toString(), "marital_status", 1,0, false, "婚姻状态" )))
					.addNode(new FieldNode("children_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "children_ind", 1,0, false, "有无子女标识" )))
					.addNode(new FieldNode("family_count", new MsgField(ContentEnum.MessageType.INT.toString(), "family_count", 19,0, false, "家庭人数" )))
					.addNode(new FieldNode("family_income", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "family_income", 21,2, false, "家庭年收入" )))
					.addNode(new FieldNode("education_level", new MsgField(ContentEnum.MessageType.STRING.toString(), "education_level", 1,0, false, "受教育水平" )))
					.addNode(new FieldNode("qq", new MsgField(ContentEnum.MessageType.STRING.toString(), "qq", 120,0, false, "QQ号" )))
					.addNode(new FieldNode("wechat", new MsgField(ContentEnum.MessageType.STRING.toString(), "wechat", 120,0, false, "微信号" )))
					.addNode(new FieldNode("email", new MsgField(ContentEnum.MessageType.STRING.toString(), "email", 120,0, false, "Email地址" )))
					.addNode(new FieldNode("birth_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "birth_date", 8,0, false, "出生日期" )))
					.addNode(new FieldNode("staff_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "staff_ind", 1,0, false, "员工标识" )))
					.addNode(new FieldNode("vip_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "vip_ind", 1,0, false, "VIP标识" )))
					.addNode(new FieldNode("regular_cust_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "regular_cust_type", 20,0, false, "存量客户类型" )))
					.addNode(new FieldNode("home_addr_country", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_addr_country", 3,0, false, "家庭地址-国家" )))
					.addNode(new FieldNode("home_addr_state", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_addr_state", 60,0, false, "家庭地址-省" )))
					.addNode(new FieldNode("home_addr_city", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_addr_city", 60,0, false, "家庭地址-市" )))
					.addNode(new FieldNode("home_addr_district", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_addr_district", 60,0, false, "家庭地址-区" )))
					.addNode(new FieldNode("home_addr_address", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_addr_address", 87,0, false, "家庭地址-地址" )))
					.addNode(new FieldNode("home_addr_postcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_addr_postcd", 6,0, false, "家庭地址-邮编" )))
					.addNode(new FieldNode("home_tele_area", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_tele_area", 4,0, false, "家庭电话区号" )))
					.addNode(new FieldNode("home_tele_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_tele_no", 20,0, false, "家庭电话号码" )))
					.addNode(new FieldNode("home_fax_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_fax_no", 20,0, false, "家庭传真" )))
					.addNode(new FieldNode("home_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_type", 1,0, false, "住宅类型" )))
					.addNode(new FieldNode("home_type_other", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_type_other", 100,0, false, "住宅类型其它" )))
					.addNode(new FieldNode("home_lived_years", new MsgField(ContentEnum.MessageType.INT.toString(), "home_lived_years", 19,0, false, "居住年限" )))
					.addNode(new FieldNode("first_work_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "first_work_date", 8,0, false, "参加工作日期" )))
					.addNode(new FieldNode("company_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_id", 40,0, false, "单位ID" )))
					.addNode(new FieldNode("company_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_name", 300,0, false, "单位名称" )))
					.addNode(new FieldNode("company_dept", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_dept", 100,0, false, "单位任职部门" )))
					.addNode(new FieldNode("company_tele_area", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_tele_area", 4,0, false, "单位电话区号" )))
					.addNode(new FieldNode("company_tele_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_tele_no", 20,0, false, "单位电话号码" )))
					.addNode(new FieldNode("company_tele_ext", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_tele_ext", 6,0, false, "单位电话分机" )))
					.addNode(new FieldNode("company_position", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_position", 100,0, false, "单位职位" )))
					.addNode(new FieldNode("company_post_level", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_post_level", 2,0, false, "单位职位级别" )))
					.addNode(new FieldNode("company_post_cert_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_post_cert_ind", 1,0, false, "职称证书标识" )))
					.addNode(new FieldNode("company_serv_year", new MsgField(ContentEnum.MessageType.INT.toString(), "company_serv_year", 19,0, false, "单位工龄" )))
					.addNode(new FieldNode("company_income", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "company_income", 21,2, false, "单位年收入" )))
					.addNode(new FieldNode("company_employee_scale", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_employee_scale", 1,0, false, "单位职工数" )))
					.addNode(new FieldNode("company_addr_state", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_addr_state", 60,0, false, "单位地址-省" )))
					.addNode(new FieldNode("company_addr_city", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_addr_city", 60,0, false, "单位地址-市" )))
					.addNode(new FieldNode("company_addr_district", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_addr_district", 60,0, false, "单位地址-区" )))
					.addNode(new FieldNode("company_addr_address", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_addr_address", 87,0, false, "单位地址-地址" )))
					.addNode(new FieldNode("company_addr_postcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_addr_postcd", 6,0, false, "单位地址-邮编" )))
					.addNode(new FieldNode("company_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_type", 2,0, false, "单位类别" )))
					.addNode(new FieldNode("company_industry", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_industry", 4,0, false, "单位行业类别" )))
					.addNode(new FieldNode("prev_company_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "prev_company_id", 40,0, false, "前单位ID" )))
					.addNode(new FieldNode("prev_company_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "prev_company_name", 300,0, false, "前单位名称" )))
					.addNode(new FieldNode("prev_company_serv_year", new MsgField(ContentEnum.MessageType.INT.toString(), "prev_company_serv_year", 19,0, false, "前单位工龄" )))
					.addNode(new FieldNode("cont_1_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_name", 120,0, false, "第一联系人姓名" )))
					.addNode(new FieldNode("cont_1_relation", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_relation", 1,0, false, "第一联系人关系" )))
					.addNode(new FieldNode("cont_1_sex", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_sex", 1,0, false, "第一联系人性别" )))
					.addNode(new FieldNode("cont_1_mobile_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_mobile_no", 12,0, false, "第一联系人手机号" )))
					.addNode(new FieldNode("cont_1_home_tele_area", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_home_tele_area", 4,0, false, "第一联系人电话区号" )))
					.addNode(new FieldNode("cont_1_home_tele_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_home_tele_no", 20,0, false, "第一联系人电话号码" )))
					.addNode(new FieldNode("cont_1_addr_state", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_addr_state", 60,0, false, "第一联系人家庭地址-省" )))
					.addNode(new FieldNode("cont_1_addr_city", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_addr_city", 60,0, false, "第一联系人家庭地址-市" )))
					.addNode(new FieldNode("cont_1_addr_district", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_addr_district", 60,0, false, "第一联系人家庭地址-区" )))
					.addNode(new FieldNode("cont_1_addr_address", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_addr_address", 100,0, false, "第一联系人家庭地址-地址" )))
					.addNode(new FieldNode("cont_1_id_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_id_type", 2,0, false, "第一联系人证件类型" )))
					.addNode(new FieldNode("cont_1_id_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_id_no", 32,0, false, "第一联系人证件号码" )))
					.addNode(new FieldNode("cont_1_qq", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_qq", 120,0, false, "第一联系人QQ号" )))
					.addNode(new FieldNode("cont_1_wechat", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_wechat", 120,0, false, "第一联系人微信号" )))
					.addNode(new FieldNode("cont_1_email", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_email", 120,0, false, "第一联系人电子邮箱" )))
					.addNode(new FieldNode("cont_1_company_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_company_id", 40,0, false, "第一联系人单位ID" )))
					.addNode(new FieldNode("cont_1_company_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_company_name", 300,0, false, "第一联系人工作单位" )))
					.addNode(new FieldNode("cont_1_com_tele_area", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_com_tele_area", 4,0, false, "第一联系人单位电话-区号" )))
					.addNode(new FieldNode("cont_1_com_tele_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_com_tele_no", 20,0, false, "第一联系人单位电话-号码" )))
					.addNode(new FieldNode("cont_1_com_tele_ext", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_com_tele_ext", 6,0, false, "第一联系人单位电话-分机" )))
					.addNode(new FieldNode("cont_2_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_name", 120,0, false, "第二联系人姓名" )))
					.addNode(new FieldNode("cont_2_relation", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_relation", 1,0, false, "第二联系人关系" )))
					.addNode(new FieldNode("cont_2_sex", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_sex", 1,0, false, "第二联系人性别" )))
					.addNode(new FieldNode("cont_2_mobile_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_mobile_no", 12,0, false, "第二联系人手机号" )))
					.addNode(new FieldNode("cont_2_home_tele_area", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_home_tele_area", 4,0, false, "第二联系人电话区号" )))
					.addNode(new FieldNode("cont_2_home_tele_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_home_tele_no", 20,0, false, "第二联系人电话号码" )))
					.addNode(new FieldNode("cont_2_addr_state", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_addr_state", 60,0, false, "第二联系人家庭地址-省" )))
					.addNode(new FieldNode("cont_2_addr_city", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_addr_city", 60,0, false, "第二联系人家庭地址-市" )))
					.addNode(new FieldNode("cont_2_addr_district", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_addr_district", 60,0, false, "第二联系人家庭地址-区" )))
					.addNode(new FieldNode("cont_2_addr_address", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_addr_address", 100,0, false, "第二联系人家庭地址-地址" )))
					.addNode(new FieldNode("cont_2_id_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_id_type", 2,0, false, "第二联系人证件类型" )))
					.addNode(new FieldNode("cont_2_id_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_id_no", 32,0, false, "第二联系人证件号码" )))
					.addNode(new FieldNode("cont_2_qq", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_qq", 120,0, false, "第二联系人QQ号" )))
					.addNode(new FieldNode("cont_2_wechat", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_wechat", 120,0, false, "第二联系人微信号" )))
					.addNode(new FieldNode("cont_2_email", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_email", 120,0, false, "第二联系人电子邮箱" )))
					.addNode(new FieldNode("cont_2_company_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_company_id", 40,0, false, "第二联系人单位ID" )))
					.addNode(new FieldNode("cont_2_company_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_company_name", 300,0, false, "第二联系人工作单位" )))
					.addNode(new FieldNode("cont_2_com_tele_area", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_com_tele_area", 4,0, false, "第二联系人单位电话-区号" )))
					.addNode(new FieldNode("cont_2_com_tele_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_com_tele_no", 20,0, false, "第二联系人单位电话-号码" )))
					.addNode(new FieldNode("cont_2_com_tele_ext", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_com_tele_ext", 6,0, false, "第二联系人单位电话-分机" )))
					.addNode(new FieldNode("max_lmt_card_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "max_lmt_card_no", 120,0, false, "持有最高额信用卡-卡号" )))
					.addNode(new FieldNode("max_lmt_amount", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "max_lmt_amount", 21,2, false, "持有最高额信用卡-额度" )))
					.addNode(new FieldNode("max_lmt_issue_bank", new MsgField(ContentEnum.MessageType.STRING.toString(), "max_lmt_issue_bank", 100,0, false, "持有最高额信用卡-发卡行" )))
					.addNode(new FieldNode("car_brand", new MsgField(ContentEnum.MessageType.STRING.toString(), "car_brand", 40,0, false, "车辆品牌" )))
					.addNode(new FieldNode("car_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "car_no", 20,0, false, "车牌号" )))
					.addNode(new FieldNode("car_purchase_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "car_purchase_date", 6,0, false, "车辆购买年月" )))
					.addNode(new FieldNode("basic_card_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "basic_card_no", 35,0, false, "主卡号" )))
					.addNode(new FieldNode("ad_limit_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_limit_type", 1,0, false, "附卡-额度类型" )))
					.addNode(new FieldNode("ad_limit_percent", new MsgField(ContentEnum.MessageType.INT.toString(), "ad_limit_percent", 19,0, false, "附卡-额度比率" )))
					.addNode(new FieldNode("ad_limit_amount", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "ad_limit_amount", 21,2, false, "附卡-额度" )))
					.addNode(new FieldNode("ad_fullname", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_fullname", 120,0, false, "附卡-姓名" )))
					.addNode(new FieldNode("ad_emboss_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_emboss_name", 120,0, false, "附卡-凸印名" )))
					.addNode(new FieldNode("ad_relation", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_relation", 1,0, false, "附卡-与主卡人关系" )))
					.addNode(new FieldNode("ad_sex", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_sex", 1,0, false, "附卡-性别" )))
					.addNode(new FieldNode("ad_mobile_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_mobile_no", 12,0, false, "附卡-手机号" )))
					.addNode(new FieldNode("ad_home_tele_area", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_home_tele_area", 4,0, false, "附卡-电话区号" )))
					.addNode(new FieldNode("ad_home_tele_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_home_tele_no", 20,0, false, "附卡-电话号码" )))
					.addNode(new FieldNode("ad_addr_state", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_addr_state", 60,0, false, "附卡-家庭地址-省" )))
					.addNode(new FieldNode("ad_addr_city", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_addr_city", 60,0, false, "附卡-家庭地址-市" )))
					.addNode(new FieldNode("ad_addr_district", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_addr_district", 60,0, false, "附卡-家庭地址-区" )))
					.addNode(new FieldNode("ad_addr_address", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_addr_address", 100,0, false, "附卡-家庭地址-地址" )))
					.addNode(new FieldNode("ad_id_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_id_type", 2,0, false, "附卡-证件类型" )))
					.addNode(new FieldNode("ad_id_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_id_no", 32,0, false, "附卡-证件号码" )))
					.addNode(new FieldNode("ad_id_expired_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_id_expired_date", 8,0, false, "附卡-证件到期日" )))
					.addNode(new FieldNode("ad_id_issue_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_id_issue_org", 200,0, false, "附卡-发证机关" )))
					.addNode(new FieldNode("ad_birth_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_birth_date", 8,0, false, "附卡-出生日期" )))
					.addNode(new FieldNode("ad_registed_country", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_registed_country", 1,0, false, "附卡-国籍" )))
					.addNode(new FieldNode("ad_registered_address", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_registered_address", 87,0, false, "附卡-户籍地址" )))
					.addNode(new FieldNode("ad_marital_status", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_marital_status", 1,0, false, "附卡-婚姻状态" )))
					.addNode(new FieldNode("ad_qq", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_qq", 120,0, false, "附卡-QQ号" )))
					.addNode(new FieldNode("ad_wechat", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_wechat", 120,0, false, "附卡-微信号" )))
					.addNode(new FieldNode("ad_email", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_email", 120,0, false, "附卡-电子邮箱" )))
					.addNode(new FieldNode("ad_company_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_company_id", 40,0, false, "附卡-单位ID" )))
					.addNode(new FieldNode("ad_company_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_company_name", 300,0, false, "附卡-单位名称" )))
					.addNode(new FieldNode("ad_com_tele_area", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_com_tele_area", 4,0, false, "附卡-单位电话-区号" )))
					.addNode(new FieldNode("ad_com_tele_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_com_tele_no", 20,0, false, "附卡-单位电话-号码" )))
					.addNode(new FieldNode("ad_pass_check_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_pass_check_ind", 1,0, false, "附卡-刷卡验密指示" )))
					.addNode(new FieldNode("urgent_issue_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "urgent_issue_type", 1,0, false, "加急办卡类型" )))
					.addNode(new FieldNode("srv_txrn_alert_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "srv_txrn_alert_ind", 5,0, false, "交易提醒指示" )))
					.addNode(new FieldNode("billcycle_no", new MsgField(ContentEnum.MessageType.INT.toString(), "billcycle_no", 19,0, false, "账单周期" )))
					.addNode(new FieldNode("bill_media", new MsgField(ContentEnum.MessageType.STRING.toString(), "bill_media", 2,0, false, "账单类型" )))
					.addNode(new FieldNode("bill_addr_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "bill_addr_type", 1,0, false, "账单地址类型" )))
					.addNode(new FieldNode("receipt_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "receipt_type", 1,0, false, "领卡方式" )))
					.addNode(new FieldNode("receipt_addr_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "receipt_addr_type", 1,0, false, "领卡-邮寄-地址类型" )))
					.addNode(new FieldNode("receipt_brch_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "receipt_brch_no", 10,0, false, "领卡-柜面-机构号" )))
					.addNode(new FieldNode("autopay_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "autopay_ind", 1,0, false, "自动还款标识" )))
					.addNode(new FieldNode("autopay_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "autopay_type", 1,0, false, "自动还款-最小还款指示" )))
					.addNode(new FieldNode("autopay_acct_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "autopay_acct_no", 35,0, false, "自动还款-账号" )))
					.addNode(new FieldNode("pass_check_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "pass_check_ind", 1,0, false, "刷卡验密指示" )))
					.addNode(new FieldNode("fms_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "fms_ind", 1,0, false, "银信通开通指示" )))
					.addNode(new FieldNode("msg_free", new MsgField(ContentEnum.MessageType.STRING.toString(), "msg_free", 1,0, false, "收取短信费标识" )))
					.addNode(new FieldNode("cust_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_id", 35,0, false, "客户号" )))
					.addNode(new FieldNode("project_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "project_code", 120,0, false, "项目代码" )))
					.addNode(new FieldNode("project_status", new MsgField(ContentEnum.MessageType.STRING.toString(), "project_status", 1,0, false, "项目状态" )))
					.addNode(new FieldNode("gift_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "gift_id", 20,0, false, "礼品代码" )))
					.addNode(new FieldNode("cust_group_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_group_id", 20,0, false, "客群代码" )))
					.addNode(new FieldNode("appl_brch_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_brch_no", 10,0, false, "申请机构号" )))
					.addNode(new FieldNode("serv_brch_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "serv_brch_no", 10,0, false, "服务机构号" )))
					.addNode(new FieldNode("collect_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "collect_ind", 1,0, false, "团办标识" )))
					.addNode(new FieldNode("acct_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_ind", 1,0, false, "建账标识" )))
					.addNode(new FieldNode("custmgr_recom_amount", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "custmgr_recom_amount", 21,2, false, "客户经理建议额度" )))
					.addNode(new FieldNode("brch_recom_amount", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "brch_recom_amount", 21,2, false, "支行建议额度" )))
					.addNode(new FieldNode("score_recom_amount", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "score_recom_amount", 21,2, false, "评分建议额度" )))
					.addNode(new FieldNode("approve_crd_amount", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "approve_crd_amount", 21,2, false, "核准卡级额度" )))
					.addNode(new FieldNode("approve_cst_amount", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "approve_cst_amount", 21,2, false, "核准客户级额度" )))
					.addNode(new FieldNode("recommand_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommand_type", 1,0, false, "推荐类型" )))
					.addNode(new FieldNode("recommand_staff_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommand_staff_id", 32,0, false, "推荐员工ID" )))
					.addNode(new FieldNode("recommand_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommand_name", 120,0, false, "推荐人姓名" )))
					.addNode(new FieldNode("recommand_id_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommand_id_type", 2,0, false, "推荐人证件号码" )))
					.addNode(new FieldNode("recommand_id_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommand_id_no", 32,0, false, "推荐人证件号码" )))
					.addNode(new FieldNode("recommand_mobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommand_mobile", 12,0, false, "推荐人手机号" )))
					.addNode(new FieldNode("recommand_card_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommand_card_no", 120,0, false, "推荐人卡号" )))
					.addNode(new FieldNode("recommand_relation", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommand_relation", 1,0, false, "推荐人与申请人关系" )))
					.addNode(new FieldNode("feetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "feetype", 100,0, false, "年费代码" )))
					.addNode(new FieldNode("ad_title", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_title", 100,0, false, "职称/附卡称谓" )))
					.addNode(new FieldNode("issigned", new MsgField(ContentEnum.MessageType.STRING.toString(), "issigned", 1,0, false, "申请表是否有客户签名" )))
					.addNode(new FieldNode("ishad_appl_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "ishad_appl_date", 1,0, false, "申请表是否已写申请时间" )))
					.addNode(new FieldNode("resident_permit_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "resident_permit_no", 32,0, false, "居住证号码" )))
					.addNode(new FieldNode("ad_resident_permit_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_resident_permit_no", 32,0, false, "附卡居住证号码" )))
					.addNode(new FieldNode("supp_feetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "supp_feetype", 100,0, false, "附卡年费代码" )))
					.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark", 500,0, false, "备注" )))
					.addNode(new FieldNode("ipp_product_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "ipp_product_code", 5,0, false, "分期产品代码" )))
					.addNode(new FieldNode("request_ipp_amount", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "request_ipp_amount", 21,2, false, "申请分期额度" )))
					.addNode(new FieldNode("period_id", new MsgField(ContentEnum.MessageType.INT.toString(), "period_id", 19,0, false, "期数ID" )))
					.addNode(new FieldNode("ipp_fee_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "ipp_fee_id", 11,0, false, "分期费率ID" )))
					.addNode(new FieldNode("fee_rate", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_rate", 4,0, false, "手续费率" )))
					.addNode(new FieldNode("fee_charge_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_charge_type", 1,0, false, "手续费收取方式" )))
					.addNode(new FieldNode("payee_bank_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "payee_bank_id", 16,0, false, "收款行ID" )))
					.addNode(new FieldNode("payee_bank_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "payee_bank_name", 120,0, false, "收款行名称" )))
					.addNode(new FieldNode("payee_acct_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "payee_acct_no", 1024,0, false, "收款账号" )))
					.addNode(new FieldNode("payee_acct_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "payee_acct_name", 120,0, false, "收款户名" )))
					.addNode(new FieldNode("payto_method", new MsgField(ContentEnum.MessageType.STRING.toString(), "payto_method", 1,0, false, "资金支付方式" )))
					.addNode(new FieldNode("ipp_project_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "ipp_project_id", 20,0, false, "分期项目ID（已弃用）" )))
					.addNode(new FieldNode("ipp_purpose", new MsgField(ContentEnum.MessageType.STRING.toString(), "ipp_purpose", 512,0, false, "分期用途" )))
					.addNode(new FieldNode("ipp_purpose_other", new MsgField(ContentEnum.MessageType.STRING.toString(), "ipp_purpose_other", 100,0, false, "分期用途其他" )))
					.addNode(new FieldNode("appl_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_date", 8,0, false, "申请日期" )))
					.addNode(new FieldNode("accept_brch_ids", new MsgField(ContentEnum.MessageType.STRING.toString(), "accept_brch_ids", 4000,0, false, "受理网点" )))
					.addNode(new FieldNode("entrust_acct", new MsgField(ContentEnum.MessageType.STRING.toString(), "entrust_acct", 35,0, false, "委托支付方账号" )))
					.addNode(new FieldNode("entrust_acct_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "entrust_acct_name", 120,0, false, "委托支付方收款账户名" )))
					.addNode(new FieldNode("entrust_bank_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "entrust_bank_id", 16,0, false, "委托支付方开户行行号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODCAP0041_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("result_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "result_code", 64,0, false, "执行结果" )))
					.addNode(new FieldNode("long_desc", new MsgField(ContentEnum.MessageType.STRING.toString(), "long_desc", 1024,0, false, "描述" )))
					.addNode(new FieldNode("appl_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_no", 40,0, false, "申请编号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	@Override
	public void initContent(Map<String, Object> tradeContext) {
		Map<String, Object> appHeader = (Map<String, Object>) tradeContext.get(CommConstant.APP_HEADER);
		appHeader.put("xmlflag", "1");
		appHeader.put("templateCodeName", "params");
		appHeader.put("transCode", "ar1000");
		appHeader.put("sysId", "121");
		appHeader.put("tradeFlag", "0");
		appHeader.put("checkFlag", "0");
		appHeader.put("prcscd", "ar1000");

		Map<String, Object> appBody = (Map<String, Object>) tradeContext.get(CommConstant.APP_BODY);
		Map<String, Object> csisHeader = (Map<String, Object>) tradeContext.get(CommConstant.CSIS_HEADER);
		appBody.put("trxn_seq", csisHeader.get("GloSeqNo"));
		appBody.put("busi_seq", csisHeader.get("ReqNo"));
		appBody.put("sponsor_system", "0104");
		appBody.put("caller_system", "901");
		appBody.put("busi_org_id", csisHeader.get("MyBank"));
		appBody.put("channel_id", "MMP");
		appBody.put("caller_date", csisHeader.get("SrcDate"));
		appBody.put("busi_teller_id", csisHeader.get("TellerNo"));
		appBody.put("busi_branch_id", csisHeader.get("BrNo"));
		super.initContent(tradeContext);
	}
}
