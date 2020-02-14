package cn.com.agree.huanan.ap.al.io.service.sbc;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbSbcChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.C022000201 企业网银管理.企业网银签约 
 * C0220002.01 CM0101
 * 0212 金融互联网服务平台
 * @author XZF
 */
@Component
public class C022000201 extends EsbSbcChannelService {

	private static C022000201_I i = new C022000201_I();
	private static C022000201_O o = new C022000201_O();
	public C022000201() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C022000201_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("IdtfNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdtfNo", 20,0, true, "证件号码" )))
					.addNode(new FieldNode("IdtfTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdtfTp", 2,0, true, "证件类型" )))
					.addNode(new FieldNode("postAddress", new MsgField(ContentEnum.MessageType.STRING.toString(), "postAddress", 500,0, true, "邮寄地址" )))
					.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 150,0, true, "企业名称" )))
					.addNode(new FieldNode("versionType", new MsgField(ContentEnum.MessageType.STRING.toString(), "versionType", 15,0, true, "开户版本类型" )))
					.addNode(new FieldNode("AcctNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "AcctNo", 20,0, true, "账号" )))
					.addNode(new FieldNode("email", new MsgField(ContentEnum.MessageType.STRING.toString(), "email", 100,0, true, "电子邮件" )))
					.addNode(new FieldNode("firstContact", new MsgField(ContentEnum.MessageType.STRING.toString(), "firstContact", 50,0, true, "联系人姓名" )))
					.addNode(new FieldNode("firstContactPhone", new MsgField(ContentEnum.MessageType.STRING.toString(), "firstContactPhone", 15,0, true, "联系人电话" )))
					.addNode(new FieldNode("incorporatorIdNumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "incorporatorIdNumber", 20,0, true, "法人证件号码" )))
					.addNode(new FieldNode("incorporatorIdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "incorporatorIdType", 10,0, true, "法人证件类型" )))
					.addNode(new FieldNode("incorporatorName", new MsgField(ContentEnum.MessageType.STRING.toString(), "incorporatorName", 50,0, true, "法人姓名" )))
					.addNode(new FieldNode("incorporatorPhoneNumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "incorporatorPhoneNumber", 20,0, true, "法人手机号码" )))
					.addNode(new FieldNode("zipCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "zipCode", 10,0, true, "邮政编码" )))
					.addNode(new FieldNode("CustNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "CustNo", 20,0, true, "客户号" )))
					.addNode(new FieldNode("agentIdNumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentIdNumber", 20,0, true, "经办人证件号码" )))
					.addNode(new FieldNode("agentName", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentName", 50,0, true, "经办人姓名" )))
					.addNode(new FieldNode("agentPhoneNumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentPhoneNumber", 20,0, true, "经办人手机号码" )))
					.addNode(new FieldNode("agentIdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentIdType", 10,0, true, "经办人证件类型" )))
					.addNode(new FieldNode("branchId", new MsgField(ContentEnum.MessageType.STRING.toString(), "branchId", 20,0, true, "经办网点" )))
					.addNode(new FieldNode("isOpenMobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "isOpenMobile", 10,0, true, "是否同步开通企业网银手机版" )))
					.addNode(new FieldNode("saleNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "saleNo", 20,0, false, "营销人员代码" )))
					.addNode(new FieldNode("saleName", new MsgField(ContentEnum.MessageType.STRING.toString(), "saleName", 50,0, false, "营销人员姓名" )))
					.addNode(new FieldNode("stoporOpenOrgan", new MsgField(ContentEnum.MessageType.STRING.toString(), "stoporOpenOrgan", 10,0, true, "网银启停网点" )))
					.addNode(new FieldNode("accountDaily", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "accountDaily", 19,2, true, "账户日累计限额" )))
					.addNode(new FieldNode("accountSingle", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "accountSingle", 19,2, true, "账户单笔限额" )))
					.addNode(new FieldNode("enterpriseDaily", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "enterpriseDaily", 19,2, true, "客户日累计限额" )))
					.addNode(new FieldNode("enterpriseSingle", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "enterpriseSingle", 19,2, true, "客户单笔限额" )))
					.addNode(new FieldNode("billingAccountType", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingAccountType", 15,0, true, "结算费缴费账户选择模式" )))
					.addNode(new FieldNode("billingPeriod", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingPeriod", 10,0, true, "结算费扣费模式" )))
					.addNode(new FieldNode("serviceBillAccount", new MsgField(ContentEnum.MessageType.STRING.toString(), "serviceBillAccount", 30,0, true, "服务费扣收账号" )))
					.addNode(new FieldNode("transactionBillingAccount", new MsgField(ContentEnum.MessageType.STRING.toString(), "transactionBillingAccount", 30,0, true, "结算费扣收账号" )))
					.addNode(new FieldNode("accountKind", new MsgField(ContentEnum.MessageType.STRING.toString(), "accountKind", 15,0, true, "是本企业账户还是授权账户" )))
					.addNode(new FieldNode("accountType", new MsgField(ContentEnum.MessageType.STRING.toString(), "accountType", 15,0, true, "签约账户类型" )))
					.addNode(new FieldNode("accountAlias", new MsgField(ContentEnum.MessageType.STRING.toString(), "accountAlias", 120,0, true, "签约账户别名" )))
					.addNode(new FieldNode("accountName", new MsgField(ContentEnum.MessageType.STRING.toString(), "accountName", 120,0, true, "签约账户名称" )))
					.addNode(new FieldNode("enableQuery", new MsgField(ContentEnum.MessageType.STRING.toString(), "enableQuery", 10,0, true, "是否有查询权限" )))
					.addNode(new FieldNode("enableTransfer", new MsgField(ContentEnum.MessageType.STRING.toString(), "enableTransfer", 10,0, true, "是否有转账权限" )))
					.addNode(new FieldNode("openBank", new MsgField(ContentEnum.MessageType.STRING.toString(), "openBank", 120,0, true, "账号开户行名称" )))
					.addNode(new FieldNode("openBankNumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "openBankNumber", 10,0, true, "账号开户行网点号" )))
					.addNode(new FieldNode("username", new MsgField(ContentEnum.MessageType.STRING.toString(), "username", 50,0, true, "管理员用户名" )))
					.addNode(new FieldNode("userIdNumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "userIdNumber", 30,0, true, "管理员证件号码" )))
					.addNode(new FieldNode("userIdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "userIdType", 10,0, true, "管理员证件类型" )))
					.addNode(new FieldNode("mobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobile", 15,0, true, "管理员手机号码" )))
					.addNode(new FieldNode("realname", new MsgField(ContentEnum.MessageType.STRING.toString(), "realname", 50,0, true, "管理员真实姓名" )))
					.addNode(new FieldNode("serviceAccountType", new MsgField(ContentEnum.MessageType.STRING.toString(), "serviceAccountType", 2,0, true, "服务费扣费模式" )))
					.addNode(new FieldNode("manageType", new MsgField(ContentEnum.MessageType.STRING.toString(), "manageType", 10,0, true, "管理类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C022000201_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("versionType", new MsgField(ContentEnum.MessageType.STRING.toString(), "versionType", 15,0, true, "开户版本类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

