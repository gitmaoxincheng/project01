package cn.com.agree.huanan.ap.al.io.service.sbc;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbSbcChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.C013000108 客户信息查询.企业网银客户信息查询 
 * C0130001.08 CM0302
 * 0212 金融互联网服务平台
 * @author XZF
 */
@Component
public class C013000108 extends EsbSbcChannelService {

	private static C013000108_I i = new C013000108_I();
	private static C013000108_O o = new C013000108_O();
	public C013000108() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013000108_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "AcctNo", 20,0, false, "账号" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdtfNo", 20,0, false, "证件号码" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdtfTp", 2,0, false, "证件类型" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 10,0, false, "网银客户状态" )))
					.addNode(new FieldNode("oprflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprFlag", 10,0, true, "操作标识" )))
					.addNode(new FieldNode("pageno", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageNo", 10,0, true, "账号列表当前页码" )))
					.addNode(new FieldNode("pagesize", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageSize", 10,0, true, "账号列表每页记录数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C013000108_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("incorporatorIdNumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "incorporatoridnumber", 20,0, true, "法人证件号码" )))
					.addNode(new FieldNode("incorporatorIdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "incorporatoridtype", 10,0, true, "法人证件类型" )))
					.addNode(new FieldNode("incorporatorName", new MsgField(ContentEnum.MessageType.STRING.toString(), "incorporatorname", 50,0, true, "法人姓名" )))
					.addNode(new FieldNode("incorporatorPhoneNumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "incorporatorphonenumber", 20,0, true, "法人手机号码" )))
					.addNode(new FieldNode("firstContact", new MsgField(ContentEnum.MessageType.STRING.toString(), "firstcontact", 50,0, true, "联系人姓名" )))
					.addNode(new FieldNode("firstContactPhone", new MsgField(ContentEnum.MessageType.STRING.toString(), "firstcontactphone", 15,0, true, "联系人电话" )))
					.addNode(new FieldNode("enterpriseId", new MsgField(ContentEnum.MessageType.STRING.toString(), "enterpriseid", 20,0, true, "网银客户id" )))
					.addNode(new FieldNode("versionType", new MsgField(ContentEnum.MessageType.STRING.toString(), "versiontype", 15,0, true, "开户版本类型" )))
					.addNode(new FieldNode("CustNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 20,0, true, "核心客户号" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 10,0, true, "网银客户状态" )))
					.addNode(new FieldNode("postAddress", new MsgField(ContentEnum.MessageType.STRING.toString(), "postaddress", 500,0, true, "邮寄地址" )))
					.addNode(new FieldNode("zipCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "zipcode", 10,0, true, "邮政编码" )))
					.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 150,0, true, "企业名称" )))
					.addNode(new FieldNode("manageType", new MsgField(ContentEnum.MessageType.STRING.toString(), "managetype", 10,0, true, "管理类型" )))
					.addNode(new FieldNode("createDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "createdate", 14,0, true, "网银签约时间" )))
					.addNode(new FieldNode("enterDaily", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "enterdaily", 19,2, true, "客户日累计限额" )))
					.addNode(new FieldNode("enterSingle", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "entersingle", 19,2, true, "客户单笔限额" )))
					.addNode(new FieldNode("organ", new MsgField(ContentEnum.MessageType.STRING.toString(), "organ", 20,0, true, "签约机构" )))
					.addNode(new FieldNode("billingAccountType", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingaccounttype", 15,0, true, "结算费缴费账户选择模式" )))
					.addNode(new FieldNode("billingPeriod", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingperiod", 10,0, true, "结算费扣费模式" )))
					.addNode(new FieldNode("serviceBillAccount", new MsgField(ContentEnum.MessageType.STRING.toString(), "servicebillaccount", 30,0, true, "服务费扣收账号" )))
					.addNode(new FieldNode("transactionBillingAccount", new MsgField(ContentEnum.MessageType.STRING.toString(), "transactionbillingaccount", 30,0, true, "结算费扣收账号" )))
					.addNode(new FieldNode("serviceBillDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "servicebilldate", 8,0, true, "网银服务费下一收费日期" )))
					.addNode(new FieldNode("initAccountDaily", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "initaccountdaily", 19,2, true, "账户系统日累计限额" )))
					.addNode(new FieldNode("initAccountSingle", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "initaccountsingle", 19,2, true, "账户系统单笔限额" )))
					.addNode(new FieldNode("initEnterpriseDaily", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "initenterprisedaily", 19,2, true, "客户系统日累计限额" )))
					.addNode(new FieldNode("initEnterpriseSingle", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "initenterprisesingle", 19,2, true, "客户系统单笔限额" )))
					.addNode(new FieldNode("transactionStart", new MsgField(ContentEnum.MessageType.STRING.toString(), "transactionstart", 8,0, true, "结算费优惠开始日期" )))
					.addNode(new FieldNode("transactionEnd", new MsgField(ContentEnum.MessageType.STRING.toString(), "transactionend", 8,0, true, "结算费优惠结束日期" )))
					.addNode(new FieldNode("transactionRate", new MsgField(ContentEnum.MessageType.STRING.toString(), "transactionrate", 3,0, true, "结算费优惠率" )))
					.addNode(new FieldNode("certStart", new MsgField(ContentEnum.MessageType.STRING.toString(), "certstart", 8,0, true, "网银证书费优惠开始日期" )))
					.addNode(new FieldNode("certEnd", new MsgField(ContentEnum.MessageType.STRING.toString(), "certend", 8,0, true, "网银证书费优惠结束日期" )))
					.addNode(new FieldNode("certRate", new MsgField(ContentEnum.MessageType.STRING.toString(), "certrate", 3,0, true, "网银证书费优惠率" )))
					.addNode(new FieldNode("serviceStart", new MsgField(ContentEnum.MessageType.STRING.toString(), "servicestart", 8,0, true, "网银服务费优惠开始日期" )))
					.addNode(new FieldNode("serviceEnd", new MsgField(ContentEnum.MessageType.STRING.toString(), "serviceend", 8,0, true, "网银服务费优惠结束日期" )))
					.addNode(new FieldNode("serviceRate", new MsgField(ContentEnum.MessageType.STRING.toString(), "servicerate", 3,0, true, "网银服务费优惠率" )))
					.addNode(new FieldNode("totalSize", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalsize", 10,0, true, "账号信息列表总记录数" )))
					.addNode(new FieldNode("enableTransferToPerson", new MsgField(ContentEnum.MessageType.STRING.toString(), "enabletransfertoperson", 20,0, true, "是否开通对私转账" )))
					.addNode(new ArrayNode("enterAccInfoList",false,"enteraccinfolist")
							.addNode(new FieldNode("accId", new MsgField(ContentEnum.MessageType.INT.toString(), "accid", 19,0, true, "账号表id" )))
							.addNode(new FieldNode("AcctNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 20,0, true, "账号" )))
							.addNode(new FieldNode("accountType", new MsgField(ContentEnum.MessageType.STRING.toString(), "accounttype", 20,0, true, "网银账户类型" )))
							.addNode(new FieldNode("AcctTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "accttp", 10,0, true, "账户类型" )))
							.addNode(new FieldNode("AcctNa", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctna", 120,0, true, "账户名称" )))
							.addNode(new FieldNode("accountAlias", new MsgField(ContentEnum.MessageType.STRING.toString(), "accountalias", 120,0, true, "账户别名" )))
							.addNode(new FieldNode("accountNature", new MsgField(ContentEnum.MessageType.STRING.toString(), "accountnature", 20,0, false, "账户性质" )))
							.addNode(new FieldNode("accountKind", new MsgField(ContentEnum.MessageType.STRING.toString(), "accountkind", 20,0, true, "是否授权账户" )))
							.addNode(new FieldNode("enableQuery", new MsgField(ContentEnum.MessageType.STRING.toString(), "enablequery", 10,0, true, "是否有查询权限" )))
							.addNode(new FieldNode("enableTransfer", new MsgField(ContentEnum.MessageType.STRING.toString(), "enabletransfer", 10,0, true, "是否有转账权限" )))
							.addNode(new FieldNode("accSingle", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "accsingle", 19,2, true, "单笔限额" )))
							.addNode(new FieldNode("accDaily", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "accdaily", 19,2, true, "每日限额" )))
							).addNode(new FieldNode("nickName", new MsgField(ContentEnum.MessageType.STRING.toString(), "nickname", 20,0, true, "管理员昵称" )))
					.addNode(new FieldNode("userStatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "userstatus", 20,0, true, "用户状态" )))
					.addNode(new FieldNode("username", new MsgField(ContentEnum.MessageType.STRING.toString(), "username", 50,0, true, "管理员用户名" )))
					.addNode(new FieldNode("userIdNumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "useridnumber", 30,0, true, "管理员证件号码" )))
					.addNode(new FieldNode("userIdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "useridtype", 10,0, true, "管理员证件类型" )))
					.addNode(new FieldNode("mobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobile", 15,0, true, "管理员手机号码" )))
					.addNode(new FieldNode("realname", new MsgField(ContentEnum.MessageType.STRING.toString(), "realname", 50,0, true, "管理员真实姓名" )))
					.addNode(new FieldNode("IdtfNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 20,0, true, "证件号码" )))
					.addNode(new FieldNode("IdtfTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 2,0, true, "证件类型" )))
					.addNode(new FieldNode("stopOrOpenOrgan", new MsgField(ContentEnum.MessageType.STRING.toString(), "stoporopenorgan", 20,0, true, "企业启停网点" )))
					.addNode(new FieldNode("pauseStartDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "pausestartdate", 14,0, true, "企业停用时间" )))
					.addNode(new FieldNode("pauseEndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "pauseenddate", 14,0, true, "企业启用时间" )))
					.addNode(new FieldNode("saleNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "saleno", 20,0, true, "营销人员代码" )))
					.addNode(new FieldNode("saleName", new MsgField(ContentEnum.MessageType.STRING.toString(), "salename", 50,0, true, "营销人员姓名" )))
					.addNode(new FieldNode("serviceAccountType", new MsgField(ContentEnum.MessageType.STRING.toString(), "serviceaccounttype", 2,0, true, "服务费扣费模式" )))
					.addNode(new FieldNode("userId", new MsgField(ContentEnum.MessageType.STRING.toString(), "userid", 15,0, true, "管理员id" )))
					.addNode(new ArrayNode("ukeyNumberList",false,"ukeynumberlist")
							.addNode(new FieldNode("number", new MsgField(ContentEnum.MessageType.STRING.toString(), "number", 10,0, true, "ukey编号" )))
							).addNode(new FieldNode("transOpenOrClose", new MsgField(ContentEnum.MessageType.STRING.toString(), "transopenorclose", 1,0, true, "企业转账停启用状态" )))
					.addNode(new FieldNode("signAccNumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "signaccnumber", 30,0, true, "签约时银行账号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

