package cn.com.agree.huanan.ap.al.io.service.enc;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.C013000802 客户综合信息查询.公司客户综合信息查询 
 * C0130008.02 ECIF518
 * 0337 企业级客户信息管理系统
 * @author JZF
 */
@Component
public class C013000802 extends EsbChannelService {
	/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCC013000802', 'BASESVC', '企业级客户信息管理系统', 'C013000802', '客户综合信息查询', 'ESB', 'ESB_enc系统', 'C0130008', '公司客户综合信息查询', '02','ECIF518' ,'客户综合信息查询', '1', '0', '客户综合信息查询');

	 */
	private static C013000802_I i = new C013000802_I();
	private static C013000802_O o = new C013000802_O();

	public C013000802() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013000802_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, true, "客户号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class C013000802_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("contrsize", new MsgField(ContentEnum.MessageType.STRING.toString(), "contrsize", 10,0, false, "返回记录数" )))
					.addNode(new ArrayNode("custinfo_list",false)
							.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, false, "客户编号" )))
							.addNode(new FieldNode("custtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype", 1,0, false, "客户类型" )))
							.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 256,0, false, "客户名称" )))
							.addNode(new FieldNode("identtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "identtype", 3,0, false, "开户证件类型" )))
							.addNode(new FieldNode("identno", new MsgField(ContentEnum.MessageType.STRING.toString(), "identno", 80,0, false, "开户证件号码" )))
							.addNode(new FieldNode("countryorregion", new MsgField(ContentEnum.MessageType.STRING.toString(), "countryorregion", 3,0, false, "发证国家或地区" )))
							.addNode(new FieldNode("shortname", new MsgField(ContentEnum.MessageType.STRING.toString(), "shortname", 256,0, false, "客户简称" )))
							.addNode(new FieldNode("enname", new MsgField(ContentEnum.MessageType.STRING.toString(), "enname", 120,0, false, "英文名称" )))
							.addNode(new FieldNode("custlevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "custlevel", 2,0, false, "客户级别" )))
							.addNode(new FieldNode("custstat", new MsgField(ContentEnum.MessageType.STRING.toString(), "custstat", 1,0, false, "客户状态" )))
							.addNode(new FieldNode("orgcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgcode", 20,0, false, "组织机构代码" )))
							.addNode(new FieldNode("orgcodevalidt", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgcodevalidt", 8,0, false, "组织机构代码有效期" )))
							.addNode(new FieldNode("busilicno", new MsgField(ContentEnum.MessageType.STRING.toString(), "busilicno", 20,0, false, "营业执照号码" )))
							.addNode(new FieldNode("busilicvalidt", new MsgField(ContentEnum.MessageType.STRING.toString(), "busilicvalidt", 8,0, false, "营业执照到期日期" )))
							.addNode(new FieldNode("nationcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "nationcode", 3,0, false, "国家或地区代码（国别）" )))
							.addNode(new FieldNode("inoutflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "inoutflag", 1,0, false, "境内外标志" )))
							.addNode(new FieldNode("entscale", new MsgField(ContentEnum.MessageType.STRING.toString(), "entscale", 1,0, false, "企业规模" )))
							.addNode(new FieldNode("industry", new MsgField(ContentEnum.MessageType.STRING.toString(), "industry", 20,0, false, "所属行业" )))
							.addNode(new FieldNode("economictype", new MsgField(ContentEnum.MessageType.STRING.toString(), "economictype", 20,0, false, "所有制形式（经济类型）" )))
							.addNode(new FieldNode("specorptype", new MsgField(ContentEnum.MessageType.STRING.toString(), "specorptype", 20,0, false, "特殊经济区内企业类型" )))
							.addNode(new FieldNode("builddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "builddate", 8,0, false, "成立日期" )))
							.addNode(new FieldNode("superdept", new MsgField(ContentEnum.MessageType.STRING.toString(), "superdept", 60,0, false, "上级主管部门" )))
							.addNode(new FieldNode("employeenum", new MsgField(ContentEnum.MessageType.STRING.toString(), "employeenum", 10,0, false, "员工人数" )))
							.addNode(new FieldNode("mainbusiness", new MsgField(ContentEnum.MessageType.STRING.toString(), "mainbusiness", 200,0, false, "主营业务" )))
							.addNode(new FieldNode("minorbusiness", new MsgField(ContentEnum.MessageType.STRING.toString(), "minorbusiness", 200,0, false, "兼营业务" )))
							.addNode(new FieldNode("workfieldarea", new MsgField(ContentEnum.MessageType.STRING.toString(), "workfieldarea", 20,0, false, "经营场地面积" )))
							.addNode(new FieldNode("workfieldower", new MsgField(ContentEnum.MessageType.STRING.toString(), "workfieldower", 20,0, false, "经营场地所有权" )))
							.addNode(new FieldNode("busistat", new MsgField(ContentEnum.MessageType.STRING.toString(), "busistat", 20,0, false, "经营状况" )))
							.addNode(new FieldNode("annualincome", new MsgField(ContentEnum.MessageType.INT.toString(), "annualincome", 18,2, false, "企业年收入" )))
							.addNode(new FieldNode("totalassets", new MsgField(ContentEnum.MessageType.INT.toString(), "totalassets", 18,2, false, "企业资产总额（万元）" )))
							.addNode(new FieldNode("capitalsource", new MsgField(ContentEnum.MessageType.STRING.toString(), "capitalsource", 20,0, false, "企业资本来源" )))
							.addNode(new FieldNode("depotp", new MsgField(ContentEnum.MessageType.STRING.toString(), "depotp", 3,0, false, "存款人类型" )))
							.addNode(new FieldNode("regcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "regcode", 20,0, false, "登记注册号" )))
							.addNode(new FieldNode("regtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "regtype", 20,0, false, "登记注册类型" )))
							.addNode(new FieldNode("regdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "regdate", 8,0, false, "注册日期" )))
							.addNode(new FieldNode("regcapitalcurr", new MsgField(ContentEnum.MessageType.STRING.toString(), "regcapitalcurr", 3,0, false, "注册资本币种" )))
							.addNode(new FieldNode("regcapital", new MsgField(ContentEnum.MessageType.INT.toString(), "regcapital", 18,2, false, "注册资本" )))
							.addNode(new FieldNode("regarea", new MsgField(ContentEnum.MessageType.STRING.toString(), "regarea", 20,0, false, "注册地行政区划" )))
							.addNode(new FieldNode("regaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "regaddr", 256,0, false, "注册地址" )))
							.addNode(new FieldNode("legalname", new MsgField(ContentEnum.MessageType.STRING.toString(), "legalname", 256,0, false, "法人代表名称" )))
							.addNode(new FieldNode("legalidenttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "legalidenttype", 3,0, false, "法人代表证件类型" )))
							.addNode(new FieldNode("legalidentno", new MsgField(ContentEnum.MessageType.STRING.toString(), "legalidentno", 30,0, false, "法人代表证件号码" )))
							.addNode(new FieldNode("realctrlname", new MsgField(ContentEnum.MessageType.STRING.toString(), "realctrlname", 256,0, false, "实际控制人名称" )))
							.addNode(new FieldNode("realctrlidenttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "realctrlidenttype", 3,0, false, "实际控制人证件类型" )))
							.addNode(new FieldNode("realctrlidentno", new MsgField(ContentEnum.MessageType.STRING.toString(), "realctrlidentno", 30,0, false, "实际控制人证件号码" )))
							.addNode(new FieldNode("linkmanname", new MsgField(ContentEnum.MessageType.STRING.toString(), "linkmanname", 256,0, false, "财务主管姓名" )))
							.addNode(new FieldNode("linkmantel", new MsgField(ContentEnum.MessageType.STRING.toString(), "linkmantel", 20,0, false, "联系电话" )))
							.addNode(new FieldNode("corpaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpaddr", 300,0, false, "通讯地址" )))
							.addNode(new FieldNode("zipcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "zipcode", 10,0, false, "邮政编码" )))
							.addNode(new FieldNode("risklevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "risklevel", 1,0, false, "客户洗钱风险等级" )))
							.addNode(new FieldNode("lncreditlevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "lncreditlevel", 20,0, false, "贷款信用等级" )))
							.addNode(new FieldNode("pfrisklevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "pfrisklevel", 20,0, false, "理财风险等级" )))
							.addNode(new FieldNode("isvalid", new MsgField(ContentEnum.MessageType.STRING.toString(), "isvalid", 1,0, false, "是否准入" )))
							.addNode(new FieldNode("mainmgr", new MsgField(ContentEnum.MessageType.STRING.toString(), "mainmgr", 20,0, false, "主办客户经理" )))
							.addNode(new FieldNode("mainmgrname", new MsgField(ContentEnum.MessageType.STRING.toString(), "mainmgrname", 256,0, false, "主办客户经理名称" )))
							.addNode(new FieldNode("mainorg", new MsgField(ContentEnum.MessageType.STRING.toString(), "mainorg", 12,0, false, "主办机构" )))
							.addNode(new FieldNode("mainorgname", new MsgField(ContentEnum.MessageType.STRING.toString(), "mainorgname", 256,0, false, "主办机构名称" )))
							.addNode(new FieldNode("opendate", new MsgField(ContentEnum.MessageType.STRING.toString(), "opendate", 8,0, false, "开户日期" )))
							.addNode(new FieldNode("openbranch", new MsgField(ContentEnum.MessageType.STRING.toString(), "openbranch", 12,0, false, "开户机构" )))
							.addNode(new FieldNode("openbranchname", new MsgField(ContentEnum.MessageType.STRING.toString(), "openbranchname", 256,0, false, "开户机构名称" )))
							.addNode(new FieldNode("openteller", new MsgField(ContentEnum.MessageType.STRING.toString(), "openteller", 10,0, false, "开户柜员" )))
							.addNode(new FieldNode("createdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "createdate", 8,0, false, "创建日期" )))
							.addNode(new FieldNode("createtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "createtime", 40,0, false, "创建时间" )))
							.addNode(new FieldNode("lastupdatesys", new MsgField(ContentEnum.MessageType.STRING.toString(), "lastupdatesys", 20,0, false, "最后更新系统" )))
							.addNode(new FieldNode("lastupdateuser", new MsgField(ContentEnum.MessageType.STRING.toString(), "lastupdateuser", 10,0, false, "最后更新人" )))
							.addNode(new FieldNode("lastupdatetm", new MsgField(ContentEnum.MessageType.STRING.toString(), "lastupdatetm", 40,0, false, "最后更新时间" )))
							.addNode(new FieldNode("txseqno", new MsgField(ContentEnum.MessageType.STRING.toString(), "txseqno", 32,0, false, "交易流水号" )))
							.addNode(new FieldNode("dateid", new MsgField(ContentEnum.MessageType.STRING.toString(), "dateid", 8,0, false, "业务日期" )))
							).addNode(new ArrayNode("keyinfo_list",false)
									.addNode(new FieldNode("iscountrycorp", new MsgField(ContentEnum.MessageType.STRING.toString(), "iscountrycorp", 1,0, false, "是否国家重点企业" )))
									.addNode(new FieldNode("islistedcorp", new MsgField(ContentEnum.MessageType.STRING.toString(), "islistedcorp", 1,0, false, "是否上市企业" )))
									.addNode(new FieldNode("isprivatecorp", new MsgField(ContentEnum.MessageType.STRING.toString(), "isprivatecorp", 1,0, false, "是否民营企业" )))
									.addNode(new FieldNode("hasbadloan", new MsgField(ContentEnum.MessageType.STRING.toString(), "hasbadloan", 1,0, false, "是否存在不良贷款" )))
									.addNode(new FieldNode("isgroupcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isgroupcust", 1,0, false, "是否集团客户" )))
									.addNode(new FieldNode("isruralcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isruralcust", 1,0, false, "是否涉农客户" )))
									.addNode(new FieldNode("iscreditcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "iscreditcust", 1,0, false, "是否授信客户" )))
									.addNode(new FieldNode("groupcreditflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "groupcreditflag", 1,0, false, "集团授信标志" )))
									.addNode(new FieldNode("isebankcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isebankcust", 1,0, false, "是否网银客户" )))
									.addNode(new FieldNode("iscashcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "iscashcust", 1,0, false, "是否现金管理客户" )))
									.addNode(new FieldNode("ismobilecust", new MsgField(ContentEnum.MessageType.STRING.toString(), "ismobilecust", 1,0, false, "是否手机银行客户" )))
									.addNode(new FieldNode("isdfdkcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isdfdkcust", 1,0, false, "是否代发代扣客户" )))
									.addNode(new FieldNode("hasieright", new MsgField(ContentEnum.MessageType.STRING.toString(), "hasieright", 1,0, false, "进出口权标志" )))
									.addNode(new FieldNode("isimportantcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isimportantcust", 1,0, false, "是否是战略客户" )))
									.addNode(new FieldNode("issoe", new MsgField(ContentEnum.MessageType.STRING.toString(), "issoe", 1,0, false, "是否央企国企" )))
									.addNode(new FieldNode("ishmtcorp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ishmtcorp", 1,0, false, "是否港澳台企业" )))
									.addNode(new FieldNode("isthreeonecorp", new MsgField(ContentEnum.MessageType.STRING.toString(), "isthreeonecorp", 1,0, false, "是否三来一补企业" )))
									).addNode(new ArrayNode("balinfo_list",false)
											.addNode(new FieldNode("assbal", new MsgField(ContentEnum.MessageType.INT.toString(), "assbal", 18,2, false, "资产余额" )))
											.addNode(new FieldNode("debbal", new MsgField(ContentEnum.MessageType.INT.toString(), "debbal", 18,2, false, "负债" )))
											.addNode(new FieldNode("netassbal", new MsgField(ContentEnum.MessageType.INT.toString(), "netassbal", 18,2, false, "净资产余额" )))
											.addNode(new FieldNode("depbal", new MsgField(ContentEnum.MessageType.INT.toString(), "depbal", 18,2, false, "存款余额" )))
											.addNode(new FieldNode("currdepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "currdepbal", 18,2, false, "活期存款余额" )))
											.addNode(new FieldNode("currassdepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "currassdepbal", 18,2, false, "活期保证金存款余额" )))
											.addNode(new FieldNode("fixeddepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "fixeddepbal", 18,2, false, "定期存款余额" )))
											.addNode(new FieldNode("fixedassdepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "fixedassdepbal", 18,2, false, "定期保证金存款余额" )))
											.addNode(new FieldNode("noticedepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "noticedepbal", 18,2, false, "通知存款余额" )))
											.addNode(new FieldNode("intldepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "intldepbal", 18,2, false, "智能存款余额" )))
											.addNode(new FieldNode("cdsdepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "cdsdepbal", 18,2, false, "大额存单余额" )))
											.addNode(new FieldNode("depagreebal", new MsgField(ContentEnum.MessageType.INT.toString(), "depagreebal", 18,2, false, "协议存款余额" )))
											.addNode(new FieldNode("agreedepyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "agreedepyearavg", 18,2, false, "协定存款年日均" )))
											.addNode(new FieldNode("tpdepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "tpdepbal", 18,2, false, "第三方存款余额" )))
											.addNode(new FieldNode("crtdepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "crtdepbal", 18,2, false, "信用卡存款余额" )))
											.addNode(new FieldNode("finabal", new MsgField(ContentEnum.MessageType.INT.toString(), "finabal", 18,2, false, "理财余额" )))
											.addNode(new FieldNode("fundbal", new MsgField(ContentEnum.MessageType.INT.toString(), "fundbal", 18,2, false, "基金余额" )))
											.addNode(new FieldNode("nmloanbal", new MsgField(ContentEnum.MessageType.INT.toString(), "nmloanbal", 18,2, false, "普通贷款余额" )))
											.addNode(new FieldNode("dcloanbal", new MsgField(ContentEnum.MessageType.INT.toString(), "dcloanbal", 18,2, false, "贴现余额" )))
											.addNode(new FieldNode("baloanbal", new MsgField(ContentEnum.MessageType.INT.toString(), "baloanbal", 18,2, false, "承兑余额" )))
											.addNode(new FieldNode("glloanbal", new MsgField(ContentEnum.MessageType.INT.toString(), "glloanbal", 18,2, false, "保函余额" )))
											.addNode(new FieldNode("lcloanbal", new MsgField(ContentEnum.MessageType.INT.toString(), "lcloanbal", 18,2, false, "信用证余额" )))
											.addNode(new FieldNode("crtloanbal", new MsgField(ContentEnum.MessageType.INT.toString(), "crtloanbal", 18,2, false, "信用卡贷款余额" )))
											));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
