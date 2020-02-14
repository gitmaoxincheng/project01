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
 * BASESVC BODCAP0018  网申接口-申请信息接入 
 *  BODCAP0018 ar4109
 *  信审系统
 * @author xuzhen
 */
@Component
public class BODCAP0018 extends EciChannelService {

	private static BODCAP0018_I i = new BODCAP0018_I();
	private static BODCAP0018_O o = new BODCAP0018_O();
	public BODCAP0018() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODCAP0018_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
				.addStructNode(new StructNode("APPBody",true,"Body")
				.addNode(new FieldNode("trxn_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "trxn_seq", 40,0, false, "交易流水" )))
				.addNode(new FieldNode("busi_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_seq", 40,0, false, "业务流水" )))
				.addNode(new FieldNode("sponsor_system", new MsgField(ContentEnum.MessageType.STRING.toString(), "sponsor_system", 40,0, false, "发起方系统编号" )))
				.addNode(new FieldNode("caller_system", new MsgField(ContentEnum.MessageType.STRING.toString(), "caller_system", 40,0, false, "调用方系统编号" )))
				.addNode(new FieldNode("busi_org_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_org_id", 10,0, false, "业务法人" )))
				.addNode(new FieldNode("channel_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel_id", 40,0, true, "渠道" )))
				.addNode(new FieldNode("caller_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "caller_date", 8,0, true, "调用方日期" )))
				.addNode(new FieldNode("busi_teller_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_teller_id", 32,0, false, "交易柜员" )))
				.addNode(new FieldNode("busi_branch_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_branch_id", 10,0, false, "业务机构ID" )))
				.addNode(new FieldNode("page_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "page_no", 19,0, false, "分页页码" )))
				.addNode(new FieldNode("page_size", new MsgField(ContentEnum.MessageType.STRING.toString(), "page_size", 19,0, false, "每页返回数量" )))
				.addNode(new FieldNode("appl_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_no", 40,0, false, "申请编号" )))
				.addNode(new FieldNode("product_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "product_code", 4,0, false, "卡产品代码" )))
				.addNode(new FieldNode("supp_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "supp_ind", 1,0, false, "主附卡标识" )))
				.addNode(new FieldNode("feetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "feetype", 2,0, false, "年费" )))
				.addNode(new FieldNode("appl_brch_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_brch_id", 4,0, false, "申请分行" )))
				.addNode(new FieldNode("card_face_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_face_id", 4,0, false, "卡版面" )))
				.addNode(new FieldNode("id_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "id_type", 2,0, false, "证件类型" )))
				.addNode(new FieldNode("id_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "id_no", 19,0, false, "证件号码" )))
				.addNode(new FieldNode("id_expired_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "id_expired_date", 8,0, false, "证件有效期" )))
				.addNode(new FieldNode("full_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "full_name", 30,0, false, "主卡申请人中文名" )))
				.addNode(new FieldNode("emboss_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "emboss_name", 30,0, false, "主卡申请人英文姓名" )))
				.addNode(new FieldNode("sex", new MsgField(ContentEnum.MessageType.STRING.toString(), "sex", 1,0, false, "性别" )))
				.addNode(new FieldNode("birth_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "birth_date", 8,0, false, "出生日期" )))
				.addNode(new FieldNode("mobile_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobile_no", 12,0, false, "手机号码" )))
				.addNode(new FieldNode("registed_country", new MsgField(ContentEnum.MessageType.STRING.toString(), "registed_country", 1,0, false, "国籍" )))
				.addNode(new FieldNode("country_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "country_code", 3,0, false, "国籍代码" )))
				.addNode(new FieldNode("id_issue_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "id_issue_org", 6,0, false, "发证机关" )))
				.addNode(new FieldNode("marital_status", new MsgField(ContentEnum.MessageType.STRING.toString(), "marital_status", 1,0, false, "婚姻状况" )))
				.addNode(new FieldNode("education_level", new MsgField(ContentEnum.MessageType.STRING.toString(), "education_level", 1,0, false, "教育程度" )))
				.addNode(new FieldNode("home_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_type", 1,0, false, "住宅类型" )))
				.addNode(new FieldNode("home_addr_state", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_addr_state", 30,0, false, "住宅地址（省）" )))
				.addNode(new FieldNode("home_addr_city", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_addr_city", 30,0, false, "住宅地址（市）" )))
				.addNode(new FieldNode("home_addr_address", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_addr_address", 60,0, false, "住宅地址（详细地址）" )))
				.addNode(new FieldNode("home_tele_area", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_tele_area", 4,0, false, "住宅电话区号" )))
				.addNode(new FieldNode("home_tele_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_tele_no", 17,0, false, "住宅电话" )))
				.addNode(new FieldNode("home_lived_years", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_lived_years", 2,0, false, "住宅年数" )))
				.addNode(new FieldNode("registered_addr_state", new MsgField(ContentEnum.MessageType.STRING.toString(), "registered_addr_state", 30,0, false, "户籍地址（省）" )))
				.addNode(new FieldNode("registered_addr_city", new MsgField(ContentEnum.MessageType.STRING.toString(), "registered_addr_city", 30,0, false, "户籍地址（省）" )))
				.addNode(new FieldNode("registered_address", new MsgField(ContentEnum.MessageType.STRING.toString(), "registered_address", 60,0, false, "户籍地址（详细地址）" )))
				.addNode(new FieldNode("email", new MsgField(ContentEnum.MessageType.STRING.toString(), "email", 40,0, false, "电子邮件" )))
				.addNode(new FieldNode("wechat", new MsgField(ContentEnum.MessageType.STRING.toString(), "wechat", 30,0, false, "微信号" )))
				.addNode(new FieldNode("qq", new MsgField(ContentEnum.MessageType.STRING.toString(), "qq", 20,0, false, "QQ号" )))
				.addNode(new FieldNode("car_brand", new MsgField(ContentEnum.MessageType.STRING.toString(), "car_brand", 16,0, false, "车牌品牌" )))
				.addNode(new FieldNode("car_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "car_no", 10,0, false, "车牌号" )))
				.addNode(new FieldNode("regular_cust_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "regular_cust_type", 1024,0, false, "我行客户关系" )))
				.addNode(new FieldNode("company_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_name", 100,0, false, "单位名称" )))
				.addNode(new FieldNode("company_dept", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_dept", 20,0, false, "公司部门" )))
				.addNode(new FieldNode("company_position", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_position", 20,0, false, "公司职务" )))
				.addNode(new FieldNode("company_serv_year", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_serv_year", 2,0, false, "本单位工作年限" )))
				.addNode(new FieldNode("company_income", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "company_income", 5,1, false, "年薪（万）" )))
				.addNode(new FieldNode("company_industry", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_industry", 4,0, false, "公司行业类别码" )))
				.addNode(new FieldNode("company_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_type", 2,0, false, "单位性质" )))
				.addNode(new FieldNode("company_addr_state", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_addr_state", 30,0, false, "单位地址1" )))
				.addNode(new FieldNode("company_addr_city", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_addr_city", 30,0, false, "单位地址2" )))
				.addNode(new FieldNode("company_addr_address", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_addr_address", 60,0, false, "单位地址3" )))
				.addNode(new FieldNode("company_tele_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_tele_no", 17,0, false, "单位固定电话" )))
				.addNode(new FieldNode("company_tele_ext", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_tele_ext", 6,0, false, "单位固定电话分机号" )))
				.addNode(new FieldNode("company_post_level", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_post_level", 2,0, false, "申请人职称" )))
				.addNode(new FieldNode("company_post_cert_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_post_cert_ind", 1,0, false, "是否有专业证书" )))
				.addNode(new FieldNode("company_employee_scale", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_employee_scale", 1,0, false, "员工人数" )))
				.addNode(new FieldNode("cont_1_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_name", 30,0, false, "直系亲属姓名" )))
				.addNode(new FieldNode("cont_1_relation", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_relation", 4,0, false, "与直系亲属关系" )))
				.addNode(new FieldNode("cont_1_mobile_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_mobile_no", 12,0, false, "直系亲属手机号码" )))
				.addNode(new FieldNode("cont_1_home_tele_area", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_home_tele_area", 4,0, false, "直系亲属电话区号" )))
				.addNode(new FieldNode("cont_1_home_tele_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_1_home_tele_no", 17,0, false, "直系亲属电话号码" )))
				.addNode(new FieldNode("cont_2_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_name", 30,0, false, "紧急联系人姓名" )))
				.addNode(new FieldNode("cont_2_relation", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_relation", 4,0, false, "与紧急联系人关系" )))
				.addNode(new FieldNode("cont_2_mobile_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_mobile_no", 12,0, false, "紧急联系人手机号码" )))
				.addNode(new FieldNode("cont_2_home_tele_area", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_home_tele_area", 4,0, false, "紧急联系人电话区号" )))
				.addNode(new FieldNode("cont_2_home_tele_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "cont_2_home_tele_no", 17,0, false, "紧急联系人电话号码" )))
				.addNode(new FieldNode("receipt_addr_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "receipt_addr_type", 4,0, false, "卡片递送方式" )))
				.addNode(new FieldNode("bill_media", new MsgField(ContentEnum.MessageType.STRING.toString(), "bill_media", 2,0, false, "账单类型" )))
				.addNode(new FieldNode("bill_addr_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "bill_addr_type", 1,0, false, "账单地址类型" )))
				.addNode(new FieldNode("urgent_issue_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "urgent_issue_type", 1,0, false, "加急办卡" )))
				.addNode(new FieldNode("autopay_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "autopay_type", 1,0, false, "自动还款类型" )))
				.addNode(new FieldNode("autopay_acct_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "autopay_acct_no", 20,0, false, "自动还款账号" )))
				.addNode(new FieldNode("fms_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "fms_ind", 1,0, false, "银信通服务" )))
				.addNode(new FieldNode("other_loancard_bank_count", new MsgField(ContentEnum.MessageType.STRING.toString(), "other_loancard_bank_count", 5,0, false, "有几家他行信用卡" )))
				.addNode(new FieldNode("other_loancard_total_limit", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "other_loancard_total_limit", 21,2, false, "总额度是多少" )))
				.addNode(new FieldNode("recommand_id_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommand_id_no", 32,0, false, "推荐人证件号" )))
				.addNode(new FieldNode("recommand_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommand_name", 120,0, false, "推荐人姓名" )))
				.addNode(new FieldNode("recommand_card_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommand_card_no", 120,0, false, "推荐人信用卡卡号" )))
				.addNode(new FieldNode("cust_manager_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_manager_id", 32,0, false, "客户经理ID" )))
				.addNode(new FieldNode("cust_manager_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_manager_name", 200,0, false, "客户经理名称" )))
				.addNode(new FieldNode("appl_type_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_type_id", 40,0, false, "申请类型" )))
				.addNode(new FieldNode("issigned", new MsgField(ContentEnum.MessageType.STRING.toString(), "issigned", 1,0, false, "申请表是否有客户签名" )))
				.addNode(new FieldNode("ishad_appl_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "ishad_appl_date", 1,0, false, "申请表是否写申请时间" )))
				.addNode(new FieldNode("home_addr_postcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_addr_postcd", 6,0, false, "住宅邮编" )))
				.addNode(new FieldNode("pass_check_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "pass_check_ind", 1,0, false, "刷卡设置" )))
				.addNode(new FieldNode("appl_brch_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_brch_no", 10,0, false, "网点号" )))
				.addNode(new FieldNode("cust_group_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_group_id", 20,0, false, "客群代码" )))
				.addNode(new FieldNode("gift_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "gift_id", 20,0, false, "礼品代码" )))
				.addNode(new FieldNode("company_addr_postcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_addr_postcd", 6,0, false, "公司邮编" )))
				.addNode(new FieldNode("receipt_addr_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "receipt_addr_type", 1,0, false, "卡片邮寄地址" )))
				.addNode(new FieldNode("autopay_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "autopay_ind", 1,0, false, "自动还款标识" )))
				.addNode(new FieldNode("msg_free", new MsgField(ContentEnum.MessageType.STRING.toString(), "msg_free", 1,0, false, "免收银信通服务费" )))
				.addNode(new FieldNode("cust_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_id", 35,0, false, "客户号" )))
				.addNode(new FieldNode("appl_channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_channel", 5,0, false, "渠道代码" )))
				.addNode(new FieldNode("project_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "project_code", 40,0, false, "项目代码" )))
				.addNode(new FieldNode("project_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "project_name", 500,0, false, "项目名称" )))
				.addNode(new FieldNode("company_tele_area", new MsgField(ContentEnum.MessageType.STRING.toString(), "company_tele_area", 4,0, false, "区号" )))
				.addNode(new FieldNode("web_receipt_brch", new MsgField(ContentEnum.MessageType.STRING.toString(), "web_receipt_brch", 10,0, false, "领卡网点" )))
				.addNode(new FieldNode("recommand_mobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommand_mobile", 12,0, false, "推荐人手机号" )))
				.addNode(new FieldNode("recommand_staff_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommand_staff_id", 32,0, false, "推荐员工ID" )))
				.addNode(new FieldNode("resident_permit_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "resident_permit_no", 32,0, false, "居住证号码" )))
				.addNode(new FieldNode("ad_resident_permit_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_resident_permit_no", 32,0, false, "附卡居住证号码" )))
				);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODCAP0018_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
				.addStructNode(new StructNode("Body",true,"APPBody")
				.addNode(new FieldNode("result_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "result_code", 4,0, false, "结果代码" )))
				.addNode(new FieldNode("result_desc", new MsgField(ContentEnum.MessageType.STRING.toString(), "result_desc", 500,0, false, "结果描述" )))
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
		appHeader.put("transCode", "ar4109");
		appHeader.put("sysId", "121");
		appHeader.put("tradeFlag", "0");
		appHeader.put("checkFlag", "0");
		appHeader.put("prcscd", "ar4109");

		Map<String, Object> appBody = (Map<String, Object>) tradeContext.get(CommConstant.APP_BODY);
		Map<String, Object> csisHeader = (Map<String, Object>) tradeContext.get(CommConstant.CSIS_HEADER);
		appBody.put("trxn_seq", csisHeader.get("GloSeqNo"));
		appBody.put("busi_seq", csisHeader.get("ReqNo"));
		appBody.put("sponsor_system", "0464");
		appBody.put("caller_system", "901");
		appBody.put("busi_org_id", csisHeader.get("MyBank"));
		appBody.put("channel_id", "NMP");
		appBody.put("caller_date", csisHeader.get("SrcDate"));
		appBody.put("busi_teller_id", csisHeader.get("TellerNo"));
		appBody.put("busi_branch_id", csisHeader.get("BrNo"));
		super.initContent(tradeContext);
	}
}

