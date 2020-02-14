package cn.com.agree.huanan.ap.al.io.service.sds;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbSdsChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.C022000604 企业开户信息管理.企业预开户审批 
 * C0220006.04 AccadEnt
 * 0209 集中业务处理平台
 * @author XZ
 */
@Component
public class C022000604 extends EsbSdsChannelService {
	private static C022000604_I i = new C022000604_I();
	private static C022000604_O o = new C022000604_O();
	public C022000604() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class C022000604_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
				.addNode(new FieldNode("TRADECODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "TRADECODE", 10,0, true, "交易码" )))
				.addNode(new FieldNode("PRODUCTID", new MsgField(ContentEnum.MessageType.STRING.toString(), "PRODUCTID", 10,0, true, "产品码" )))
				.addNode(new FieldNode("opermantype", new MsgField(ContentEnum.MessageType.STRING.toString(), "opermantype", 1,0, true, "开户经办人类型" )))
				.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl", 11,0, true, "经办人手机号" )))
				.addNode(new FieldNode("transt", new MsgField(ContentEnum.MessageType.STRING.toString(), "transt", 1,0, true, "状态" )))
				.addNode(new FieldNode("accttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "accttp", 1,0, true, "账户性质" )))
				.addNode(new FieldNode("openbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "openbr", 10,0, true, "开户网点" )))
				.addNode(new FieldNode("openbrname", new MsgField(ContentEnum.MessageType.STRING.toString(), "openbrname", 100,0, true, "开户网点名称" )))
				.addNode(new FieldNode("openmbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "openmbr", 50,0, true, "开户支行" )))
				.addNode(new FieldNode("openzone", new MsgField(ContentEnum.MessageType.STRING.toString(), "openzone", 10,0, true, "开户分行" )))
				.addNode(new FieldNode("usccode", new MsgField(ContentEnum.MessageType.STRING.toString(), "usccode", 100,0, false, "社会信用代码" )))
				.addNode(new FieldNode("orgcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgcode", 100,0, false, "组织机构代码" )))
				.addNode(new FieldNode("compname", new MsgField(ContentEnum.MessageType.STRING.toString(), "compname", 300,0, false, "企业名称" )))
				.addNode(new FieldNode("comptelephone", new MsgField(ContentEnum.MessageType.STRING.toString(), "comptelephone", 20,0, false, "企业电话" )))
				.addNode(new FieldNode("compofficeaddrtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "compofficeaddrtype", 1,0, false, "企业办工/邮寄地址类型" )))
				.addNode(new FieldNode("compofficeaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "compofficeaddr", 500,0, false, "企业办工/邮寄地址" )))
				.addNode(new FieldNode("compaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "compaddr", 500,0, false, "企业详细地址" )))
				.addNode(new FieldNode("accusagetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "accusagetype", 1,0, false, "用途类型" )))
				.addNode(new FieldNode("accusage", new MsgField(ContentEnum.MessageType.STRING.toString(), "accusage", 500,0, false, "其他用途" )))
				.addNode(new FieldNode("corpname", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpname", 200,0, false, "授权人/代理人人姓名" )))
				.addNode(new FieldNode("corpIdtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpIdtftp", 2,0, true, "授权人/代理人证件类型" )))
				.addNode(new FieldNode("corpIdtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpIdtfno", 30,0, true, "授权人/代理人证件号码" )))
				.addNode(new FieldNode("corpidvaldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpidvaldate", 8,0, false, "授权人/代理人证件有效期" )))
				.addNode(new FieldNode("corpmobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpmobitl", 11,0, false, "授权人/代理人证件手机号" )))
				.addNode(new FieldNode("finaname", new MsgField(ContentEnum.MessageType.STRING.toString(), "finaname", 200,0, false, "财务负责人姓名" )))
				.addNode(new FieldNode("finaIdtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "finaIdtftp", 2,0, true, "财务负责人证件类型" )))
				.addNode(new FieldNode("finaIdtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "finaIdtfno", 30,0, true, "财务负责人证件号码" )))
				.addNode(new FieldNode("finaidvaldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "finaidvaldate", 8,0, false, "财务负责人证件有效期" )))
				.addNode(new FieldNode("finamobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "finamobitl", 11,0, false, "财务负责人手机号" )))
				.addNode(new FieldNode("opername", new MsgField(ContentEnum.MessageType.STRING.toString(), "opername", 200,0, false, "经办人姓名" )))
				.addNode(new FieldNode("operIdtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "operIdtftp", 10,0, false, "经办人证件类型" )))
				.addNode(new FieldNode("operIdtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "operIdtfno", 100,0, false, "经办人证件号码" )))
				.addNode(new FieldNode("operidvaldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "operidvaldate", 8,0, false, "经办人证件有效期" )))
				.addNode(new FieldNode("authvaldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "authvaldate", 8,0, false, "授权有效期" )))
				.addNode(new FieldNode("taxtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "taxtype", 1,0, false, "税收居民机构类型" )))
				.addNode(new FieldNode("taxinfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "taxinfo", 1,0, false, "税收居民身份信息" )))
				.addNode(new FieldNode("issbm", new MsgField(ContentEnum.MessageType.STRING.toString(), "issbm", 1,0, false, "是否开通回单机" )))
				.addNode(new FieldNode("isncb", new MsgField(ContentEnum.MessageType.STRING.toString(), "isncb", 1,0, false, "是否开通企业网银" )))
				.addNode(new FieldNode("isict", new MsgField(ContentEnum.MessageType.STRING.toString(), "isict", 1,0, false, "是否开通银信通" )))
				.addNode(new FieldNode("isubc", new MsgField(ContentEnum.MessageType.STRING.toString(), "isubc", 1,0, false, "是否开通单位结算卡" )))
				.addNode(new FieldNode("isebd", new MsgField(ContentEnum.MessageType.STRING.toString(), "isebd", 1,0, false, "是否开通电子商业汇票签约" )))
				.addNode(new FieldNode("istaxsb", new MsgField(ContentEnum.MessageType.STRING.toString(), "istaxsb", 1,0, false, "是否开通扣税/社保服务" )))
				.addNode(new FieldNode("isonecert", new MsgField(ContentEnum.MessageType.STRING.toString(), "isonecert", 1,0, false, "是否三证合一" )))
				.addNode(new FieldNode("iselec", new MsgField(ContentEnum.MessageType.STRING.toString(), "iselec", 1,0, false, "是否开通电子对账" )))
				.addNode(new FieldNode("elecname1", new MsgField(ContentEnum.MessageType.STRING.toString(), "elecname1", 100,0, false, "电子对账第一联系人名称" )))
				.addNode(new FieldNode("electelephone1", new MsgField(ContentEnum.MessageType.STRING.toString(), "electelephone1", 11,0, false, "电子对账第一联系人手机号码" )))
				.addNode(new FieldNode("elecname2", new MsgField(ContentEnum.MessageType.STRING.toString(), "elecname2", 100,0, false, "电子对账第二联系人名称" )))
				.addNode(new FieldNode("electelephone2", new MsgField(ContentEnum.MessageType.STRING.toString(), "electelephone2", 11,0, false, "电子对账第二联系人手机号码" )))
				.addNode(new FieldNode("busino", new MsgField(ContentEnum.MessageType.STRING.toString(), "busino", 200,0, false, "营业执照号码" )))
				.addNode(new FieldNode("appnumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "appnumber", 100,0, false, "申请编号" )))
				.addNode(new FieldNode("appvaldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "appvaldate", 8,0, false, "申请有效截止日期" )))
				.addNode(new FieldNode("appisval", new MsgField(ContentEnum.MessageType.STRING.toString(), "appisval", 1,0, false, "申请有效性标识" )))
				.addNode(new FieldNode("contname", new MsgField(ContentEnum.MessageType.STRING.toString(), "contname", 200,0, false, "控股股东或实际控制人名称" )))
				.addNode(new FieldNode("contIdtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "contIdtftp", 2,0, true, "控股股东或实际控制人证件类型" )))
				.addNode(new FieldNode("contIdtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "contIdtfno", 30,0, true, "控股股东或实际控制人证件号码" )))
				.addNode(new FieldNode("contidvaldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "contidvaldate", 100,0, false, "控股股东或实际控制人证件有效期" )))
				.addNode(new FieldNode("contsuperior", new MsgField(ContentEnum.MessageType.STRING.toString(), "contsuperior", 100,0, false, "控股股东或实际控制人上级法人或主管单位名称" )))
				.addNode(new FieldNode("contseal", new MsgField(ContentEnum.MessageType.STRING.toString(), "contseal", 1,0, false, "控股股东或实际控制人预留印鉴" )))
				.addNode(new FieldNode("trusteesealname", new MsgField(ContentEnum.MessageType.STRING.toString(), "trusteesealname", 200,0, false, "受托人印鉴名称" )))
				.addNode(new FieldNode("trusteeidtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "trusteeidtfno", 100,0, false, "受托人证件号码" )))
				.addNode(new FieldNode("sealacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "sealacctno", 100,0, false, "印鉴账号" )))
				.addNode(new FieldNode("sealcardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "sealcardno", 100,0, false, "印鉴卡号" )))
				.addNode(new FieldNode("ncbmantype", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbmantype", 1,0, false, "企业网银管理员类型" )))
				.addNode(new FieldNode("ncbname", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbname", 200,0, false, "企业网银管理员姓名" )))
				.addNode(new FieldNode("ncbidtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbidtftp", 2,0, true, "企业网银管理员证件类型" )))
				.addNode(new FieldNode("ncbidtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbidtfno", 30,0, true, "企业网银管理员证件号码" )))
				.addNode(new FieldNode("ncbmobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbmobitl", 11,0, false, "企业网银管理员手机号码" )))
				.addNode(new FieldNode("ncbcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbcode", 100,0, false, "企业网银管理员代码" )))
				.addNode(new FieldNode("ncbusbkeynum", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbusbkeynum", 10,0, false, "企业网银购买USBKEY数量" )))
				.addNode(new FieldNode("ncbonelim", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbonelim", 20,0, false, "企业网银非柜面渠道账户单笔限额" )))
				.addNode(new FieldNode("ncbdaylim", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbdaylim", 20,0, false, "企业网银非柜面渠道账户日累计限额" )))
				.addNode(new FieldNode("ictmobitl1", new MsgField(ContentEnum.MessageType.STRING.toString(), "ictmobitl1", 11,0, false, "银信通接收手机号1" )))
				.addNode(new FieldNode("ictmobitl2", new MsgField(ContentEnum.MessageType.STRING.toString(), "ictmobitl2", 11,0, false, "银信通接收手机号2" )))
				.addNode(new FieldNode("ictmobitl3", new MsgField(ContentEnum.MessageType.STRING.toString(), "ictmobitl3", 11,0, false, "银信通接收手机号3" )))
				.addNode(new FieldNode("ictmobitl4", new MsgField(ContentEnum.MessageType.STRING.toString(), "ictmobitl4", 11,0, false, "银信通接收手机号4" )))
				.addNode(new FieldNode("ictmobitl5", new MsgField(ContentEnum.MessageType.STRING.toString(), "ictmobitl5", 11,0, false, "银信通接收手机号5" )))
				.addNode(new FieldNode("ubcmantype", new MsgField(ContentEnum.MessageType.STRING.toString(), "ubcmantype", 1,0, false, "单位结算卡持卡人信息类型" )))
				.addNode(new FieldNode("ubcname", new MsgField(ContentEnum.MessageType.STRING.toString(), "ubcname", 200,0, false, "单位结算卡持卡人姓名" )))
				.addNode(new FieldNode("ubcIdtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ubcIdtftp", 2,0, true, "单位结算卡持卡人证件类型" )))
				.addNode(new FieldNode("ubcIdtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "ubcIdtfno", 30,0, true, "单位结算卡持卡人证件号码" )))
				.addNode(new FieldNode("ubcidvaldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "ubcidvaldate", 8,0, false, "单位结算卡持卡人证件有效期" )))
				.addNode(new FieldNode("ubcmobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "ubcmobitl", 11,0, false, "单位结算卡持卡人手机号码" )))
				.addNode(new FieldNode("checknote", new MsgField(ContentEnum.MessageType.STRING.toString(), "checknote", 500,0, false, "审核记录要素" )))
				.addNode(new FieldNode("telphone", new MsgField(ContentEnum.MessageType.STRING.toString(), "telphone", 100,0, false, "机构电话" )))
				.addNode(new FieldNode("address", new MsgField(ContentEnum.MessageType.STRING.toString(), "address", 500,0, false, "机构地址" )))
				.addNode(new FieldNode("startdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "startdate", 100,0, false, "机构工作开始时间" )))
				.addNode(new FieldNode("enddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "enddate", 100,0, false, "机构工作终止时间" )))
				.addNode(new FieldNode("satstartdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "satstartdate", 100,0, false, "星期六营业开始时间" )))
				.addNode(new FieldNode("satenddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "satenddate", 100,0, false, "星期六营业终止时间" )))
				.addNode(new FieldNode("sunstartdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "sunstartdate", 100,0, false, "星期天营业开始时间" )))
				.addNode(new FieldNode("sunenddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "sunenddate", 100,0, false, "星期天营业终止时间" )))
				.addNode(new FieldNode("postcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcode", 6,0, false, "邮编" )))
				.addNode(new FieldNode("cutonelim", new MsgField(ContentEnum.MessageType.STRING.toString(), "cutonelim", 30,0, false, "客户单笔限额" )))
				.addNode(new FieldNode("cutdaylim", new MsgField(ContentEnum.MessageType.STRING.toString(), "cutdaylim", 30,0, false, "客户日累计限额" )))
				.addNode(new FieldNode("ncbtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbtype", 1,0, false, "企业网银签约类型" )))
				.addNode(new FieldNode("ncbukeytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbukeytype", 1,0, false, "UKEY类型" )))
				.addNode(new FieldNode("depotp", new MsgField(ContentEnum.MessageType.STRING.toString(), "depotp", 2,0, false, "存款人类别" )))
				);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C022000604_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
				.addNode(new FieldNode("TRADECODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "TRADECODE", 10,0, true, "交易码" )))
				.addNode(new FieldNode("PRODUCTID", new MsgField(ContentEnum.MessageType.STRING.toString(), "PRODUCTID", 10,0, true, "产品码" )))
				.addNode(new FieldNode("opermantype", new MsgField(ContentEnum.MessageType.STRING.toString(), "opermantype", 1,0, true, "开户经办人类型" )))
				.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl", 11,0, true, "经办人手机号" )))
				.addNode(new FieldNode("transt", new MsgField(ContentEnum.MessageType.STRING.toString(), "transt", 1,0, true, "状态" )))
				.addNode(new FieldNode("accttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "accttp", 1,0, true, "账户性质" )))
				.addNode(new FieldNode("openbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "openbr", 10,0, true, "开户网点" )))
				.addNode(new FieldNode("openbrname", new MsgField(ContentEnum.MessageType.STRING.toString(), "openbrname", 100,0, true, "开户网点名称" )))
				.addNode(new FieldNode("openmbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "openmbr", 50,0, true, "开户支行" )))
				.addNode(new FieldNode("openzone", new MsgField(ContentEnum.MessageType.STRING.toString(), "openzone", 10,0, true, "开户分行" )))
				.addNode(new FieldNode("usccode", new MsgField(ContentEnum.MessageType.STRING.toString(), "usccode", 100,0, false, "社会信用代码" )))
				.addNode(new FieldNode("orgcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgcode", 100,0, false, "组织机构代码" )))
				.addNode(new FieldNode("compname", new MsgField(ContentEnum.MessageType.STRING.toString(), "compname", 300,0, false, "企业名称" )))
				.addNode(new FieldNode("comptelephone", new MsgField(ContentEnum.MessageType.STRING.toString(), "comptelephone", 20,0, false, "企业电话" )))
				.addNode(new FieldNode("compofficeaddrtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "compofficeaddrtype", 1,0, false, "企业办工/邮寄地址类型" )))
				.addNode(new FieldNode("compofficeaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "compofficeaddr", 500,0, false, "企业办工/邮寄地址" )))
				.addNode(new FieldNode("compaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "compaddr", 500,0, false, "企业详细地址" )))
				.addNode(new FieldNode("accusagetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "accusagetype", 1,0, false, "用途类型" )))
				.addNode(new FieldNode("accusage", new MsgField(ContentEnum.MessageType.STRING.toString(), "accusage", 500,0, false, "其他用途" )))
				.addNode(new FieldNode("corpname", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpname", 200,0, false, "授权人/代理人人姓名" )))
				.addNode(new FieldNode("corpIdtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpIdtftp", 2,0, true, "授权人/代理人证件类型" )))
				.addNode(new FieldNode("corpIdtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpIdtfno", 30,0, true, "授权人/代理人证件号码" )))
				.addNode(new FieldNode("corpidvaldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpidvaldate", 8,0, false, "授权人/代理人证件有效期" )))
				.addNode(new FieldNode("corpmobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpmobitl", 11,0, false, "授权人/代理人证件手机号" )))
				.addNode(new FieldNode("finaname", new MsgField(ContentEnum.MessageType.STRING.toString(), "finaname", 200,0, false, "财务负责人姓名" )))
				.addNode(new FieldNode("finaIdtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "finaIdtftp", 2,0, true, "财务负责人证件类型" )))
				.addNode(new FieldNode("finaIdtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "finaIdtfno", 30,0, true, "财务负责人证件号码" )))
				.addNode(new FieldNode("finaidvaldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "finaidvaldate", 8,0, false, "财务负责人证件有效期" )))
				.addNode(new FieldNode("finamobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "finamobitl", 11,0, false, "财务负责人手机号" )))
				.addNode(new FieldNode("opername", new MsgField(ContentEnum.MessageType.STRING.toString(), "opername", 200,0, false, "经办人姓名" )))
				.addNode(new FieldNode("operIdtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "operIdtftp", 10,0, false, "经办人证件类型" )))
				.addNode(new FieldNode("operIdtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "operIdtfno", 100,0, false, "经办人证件号码" )))
				.addNode(new FieldNode("operidvaldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "operidvaldate", 8,0, false, "经办人证件有效期" )))
				.addNode(new FieldNode("authvaldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "authvaldate", 8,0, false, "授权有效期" )))
				.addNode(new FieldNode("taxtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "taxtype", 1,0, false, "税收居民机构类型" )))
				.addNode(new FieldNode("taxinfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "taxinfo", 1,0, false, "税收居民身份信息" )))
				.addNode(new FieldNode("issbm", new MsgField(ContentEnum.MessageType.STRING.toString(), "issbm", 1,0, false, "是否开通回单机" )))
				.addNode(new FieldNode("isncb", new MsgField(ContentEnum.MessageType.STRING.toString(), "isncb", 1,0, false, "是否开通企业网银" )))
				.addNode(new FieldNode("isict", new MsgField(ContentEnum.MessageType.STRING.toString(), "isict", 1,0, false, "是否开通银信通" )))
				.addNode(new FieldNode("isubc", new MsgField(ContentEnum.MessageType.STRING.toString(), "isubc", 1,0, false, "是否开通单位结算卡" )))
				.addNode(new FieldNode("isebd", new MsgField(ContentEnum.MessageType.STRING.toString(), "isebd", 1,0, false, "是否开通电子商业汇票签约" )))
				.addNode(new FieldNode("istaxsb", new MsgField(ContentEnum.MessageType.STRING.toString(), "istaxsb", 1,0, false, "是否开通扣税/社保服务" )))
				.addNode(new FieldNode("isonecert", new MsgField(ContentEnum.MessageType.STRING.toString(), "isonecert", 1,0, false, "是否三证合一" )))
				.addNode(new FieldNode("iselec", new MsgField(ContentEnum.MessageType.STRING.toString(), "iselec", 1,0, false, "是否开通电子对账" )))
				.addNode(new FieldNode("elecname1", new MsgField(ContentEnum.MessageType.STRING.toString(), "elecname1", 100,0, false, "电子对账第一联系人名称" )))
				.addNode(new FieldNode("electelephone1", new MsgField(ContentEnum.MessageType.STRING.toString(), "electelephone1", 11,0, false, "电子对账第一联系人手机号码" )))
				.addNode(new FieldNode("elecname2", new MsgField(ContentEnum.MessageType.STRING.toString(), "elecname2", 100,0, false, "电子对账第二联系人名称" )))
				.addNode(new FieldNode("electelephone2", new MsgField(ContentEnum.MessageType.STRING.toString(), "electelephone2", 11,0, false, "电子对账第二联系人手机号码" )))
				.addNode(new FieldNode("busino", new MsgField(ContentEnum.MessageType.STRING.toString(), "busino", 200,0, false, "营业执照号码" )))
				.addNode(new FieldNode("appnumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "appnumber", 100,0, false, "申请编号" )))
				.addNode(new FieldNode("appvaldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "appvaldate", 8,0, false, "申请有效截止日期" )))
				.addNode(new FieldNode("appisval", new MsgField(ContentEnum.MessageType.STRING.toString(), "appisval", 1,0, false, "申请有效性标识" )))
				.addNode(new FieldNode("contname", new MsgField(ContentEnum.MessageType.STRING.toString(), "contname", 200,0, false, "控股股东或实际控制人名称" )))
				.addNode(new FieldNode("contIdtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "contIdtftp", 2,0, true, "控股股东或实际控制人证件类型" )))
				.addNode(new FieldNode("contIdtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "contIdtfno", 30,0, true, "控股股东或实际控制人证件号码" )))
				.addNode(new FieldNode("contidvaldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "contidvaldate", 100,0, false, "控股股东或实际控制人证件有效期" )))
				.addNode(new FieldNode("contsuperior", new MsgField(ContentEnum.MessageType.STRING.toString(), "contsuperior", 100,0, false, "控股股东或实际控制人上级法人或主管单位名称" )))
				.addNode(new FieldNode("contseal", new MsgField(ContentEnum.MessageType.STRING.toString(), "contseal", 1,0, false, "控股股东或实际控制人预留印鉴" )))
				.addNode(new FieldNode("trusteesealname", new MsgField(ContentEnum.MessageType.STRING.toString(), "trusteesealname", 200,0, false, "受托人印鉴名称" )))
				.addNode(new FieldNode("trusteeidtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "trusteeidtfno", 100,0, false, "受托人证件号码" )))
				.addNode(new FieldNode("sealacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "sealacctno", 100,0, false, "印鉴账号" )))
				.addNode(new FieldNode("sealcardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "sealcardno", 100,0, false, "印鉴卡号" )))
				.addNode(new FieldNode("ncbmantype", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbmantype", 1,0, false, "企业网银管理员类型" )))
				.addNode(new FieldNode("ncbname", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbname", 200,0, false, "企业网银管理员姓名" )))
				.addNode(new FieldNode("ncbidtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbidtftp", 2,0, true, "企业网银管理员证件类型" )))
				.addNode(new FieldNode("ncbidtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbidtfno", 30,0, true, "企业网银管理员证件号码" )))
				.addNode(new FieldNode("ncbmobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbmobitl", 11,0, false, "企业网银管理员手机号码" )))
				.addNode(new FieldNode("ncbcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbcode", 100,0, false, "企业网银管理员代码" )))
				.addNode(new FieldNode("ncbusbkeynum", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbusbkeynum", 10,0, false, "企业网银购买USBKEY数量" )))
				.addNode(new FieldNode("ncbonelim", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbonelim", 20,0, false, "企业网银非柜面渠道账户单笔限额" )))
				.addNode(new FieldNode("ncbdaylim", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbdaylim", 20,0, false, "企业网银非柜面渠道账户日累计限额" )))
				.addNode(new FieldNode("ictmobitl1", new MsgField(ContentEnum.MessageType.STRING.toString(), "ictmobitl1", 11,0, false, "银信通接收手机号1" )))
				.addNode(new FieldNode("ictmobitl2", new MsgField(ContentEnum.MessageType.STRING.toString(), "ictmobitl2", 11,0, false, "银信通接收手机号2" )))
				.addNode(new FieldNode("ictmobitl3", new MsgField(ContentEnum.MessageType.STRING.toString(), "ictmobitl3", 11,0, false, "银信通接收手机号3" )))
				.addNode(new FieldNode("ictmobitl4", new MsgField(ContentEnum.MessageType.STRING.toString(), "ictmobitl4", 11,0, false, "银信通接收手机号4" )))
				.addNode(new FieldNode("ictmobitl5", new MsgField(ContentEnum.MessageType.STRING.toString(), "ictmobitl5", 11,0, false, "银信通接收手机号5" )))
				.addNode(new FieldNode("ubcmantype", new MsgField(ContentEnum.MessageType.STRING.toString(), "ubcmantype", 1,0, false, "单位结算卡持卡人信息类型" )))
				.addNode(new FieldNode("ubcname", new MsgField(ContentEnum.MessageType.STRING.toString(), "ubcname", 200,0, false, "单位结算卡持卡人姓名" )))
				.addNode(new FieldNode("ubcIdtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ubcIdtftp", 2,0, true, "单位结算卡持卡人证件类型" )))
				.addNode(new FieldNode("ubcIdtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "ubcIdtfno", 30,0, true, "单位结算卡持卡人证件号码" )))
				.addNode(new FieldNode("ubcidvaldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "ubcidvaldate", 8,0, false, "单位结算卡持卡人证件有效期" )))
				.addNode(new FieldNode("ubcmobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "ubcmobitl", 11,0, false, "单位结算卡持卡人手机号码" )))
				.addNode(new FieldNode("checknote", new MsgField(ContentEnum.MessageType.STRING.toString(), "checknote", 500,0, false, "审核记录要素" )))
				.addNode(new FieldNode("telphone", new MsgField(ContentEnum.MessageType.STRING.toString(), "telphone", 100,0, false, "机构电话" )))
				.addNode(new FieldNode("address", new MsgField(ContentEnum.MessageType.STRING.toString(), "address", 500,0, false, "机构地址" )))
				.addNode(new FieldNode("startdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "startdate", 100,0, false, "机构工作开始时间" )))
				.addNode(new FieldNode("enddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "enddate", 100,0, false, "机构工作终止时间" )))
				.addNode(new FieldNode("satstartdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "satstartdate", 100,0, false, "星期六营业开始时间" )))
				.addNode(new FieldNode("satenddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "satenddate", 100,0, false, "星期六营业终止时间" )))
				.addNode(new FieldNode("sunstartdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "sunstartdate", 100,0, false, "星期天营业开始时间" )))
				.addNode(new FieldNode("sunenddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "sunenddate", 100,0, false, "星期天营业终止时间" )))
				.addNode(new FieldNode("postcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcode", 6,0, false, "邮编" )))
				.addNode(new FieldNode("cutonelim", new MsgField(ContentEnum.MessageType.STRING.toString(), "cutonelim", 30,0, false, "客户单笔限额" )))
				.addNode(new FieldNode("cutdaylim", new MsgField(ContentEnum.MessageType.STRING.toString(), "cutdaylim", 30,0, false, "客户日累计限额" )))
				.addNode(new FieldNode("ncbtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbtype", 1,0, false, "企业网银签约类型" )))
				.addNode(new FieldNode("ncbukeytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "ncbukeytype", 1,0, false, "UKEY类型" )))
				.addNode(new FieldNode("depotp", new MsgField(ContentEnum.MessageType.STRING.toString(), "depotp", 2,0, false, "存款人类别" )))
				);	
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

