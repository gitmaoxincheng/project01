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
 * BASESVC.C012000105 客户信息管理.企业网银客户信息维护 
 * C0120001.05 CM0301
 * 0212 金融互联网服务平台
 * @author XZF
 */
@Component
public class C012000105 extends EsbSbcChannelService {

	private static C012000105_I i = new C012000105_I();
	private static C012000105_O o = new C012000105_O();
	public C012000105() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C012000105_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("branchId", new MsgField(ContentEnum.MessageType.STRING.toString(), "branchId", 20,0, true, "经办网点" )))
					.addNode(new FieldNode("enterpriseId", new MsgField(ContentEnum.MessageType.STRING.toString(), "enterpriseId", 20,0, true, "网银客户id" )))
					.addNode(new FieldNode("enterpriseDaily", new MsgField(ContentEnum.MessageType.INT.toString(), "enterpriseDaily", 19,2, true, "客户日累计限额" )))
					.addNode(new FieldNode("enterpriseSingle", new MsgField(ContentEnum.MessageType.INT.toString(), "enterpriseSingle", 19,2, true, "客户单笔限额" )))
					.addNode(new FieldNode("incorporatorIdNumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "incorporatorIdNumber", 20,0, true, "法人证件号码" )))
					.addNode(new FieldNode("incorporatorIdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "incorporatorIdType", 10,0, true, "法人证件类型" )))
					.addNode(new FieldNode("incorporatorName", new MsgField(ContentEnum.MessageType.STRING.toString(), "incorporatorName", 50,0, true, "法人姓名" )))
					.addNode(new FieldNode("incorporatorPhoneNumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "incorporatorPhoneNumber", 20,0, true, "法人手机号码" )))
					.addNode(new FieldNode("postAddress", new MsgField(ContentEnum.MessageType.STRING.toString(), "postAddress", 500,0, true, "邮寄地址" )))
					.addNode(new FieldNode("zipCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "zipCode", 10,0, true, "邮政编码" )))
					.addNode(new FieldNode("firstContact", new MsgField(ContentEnum.MessageType.STRING.toString(), "firstContact", 50,0, true, "联系人姓名" )))
					.addNode(new FieldNode("firstContactPhone", new MsgField(ContentEnum.MessageType.STRING.toString(), "firstContactPhone", 15,0, true, "联系人电话" )))
					.addNode(new FieldNode("saleNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "saleNo", 20,0, false, "营销人员代码" )))
					.addNode(new FieldNode("saleName", new MsgField(ContentEnum.MessageType.STRING.toString(), "saleName", 50,0, false, "营销人员姓名" )))
					.addNode(new FieldNode("billingPeriod", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingPeriod", 10,0, true, "结算费扣费模式" )))
					.addNode(new FieldNode("transactionBillingAccount", new MsgField(ContentEnum.MessageType.STRING.toString(), "transactionBillingAccount", 30,0, true, "结算费扣收账号" )))
					.addNode(new FieldNode("serviceBillAccount", new MsgField(ContentEnum.MessageType.STRING.toString(), "serviceBillAccount", 30,0, true, "服务费扣收账号" )))
					.addNode(new FieldNode("billingAccountType", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingAccountType", 15,0, true, "结算费缴费账户选择模式" )))
					.addNode(new FieldNode("transactionStart", new MsgField(ContentEnum.MessageType.STRING.toString(), "transactionStart", 8,0, true, "结算费优惠开始日期" )))
					.addNode(new FieldNode("transactionEnd", new MsgField(ContentEnum.MessageType.STRING.toString(), "transactionEnd", 8,0, true, "结算费优惠结束日期" )))
					.addNode(new FieldNode("transactionRate", new MsgField(ContentEnum.MessageType.STRING.toString(), "transactionRate", 3,0, true, "结算费优惠率" )))
					.addNode(new FieldNode("certStart", new MsgField(ContentEnum.MessageType.STRING.toString(), "certStart", 8,0, true, "网银证书费优惠开始日期" )))
					.addNode(new FieldNode("certEnd", new MsgField(ContentEnum.MessageType.STRING.toString(), "certEnd", 8,0, true, "网银证书费优惠结束日期" )))
					.addNode(new FieldNode("certRate", new MsgField(ContentEnum.MessageType.STRING.toString(), "certRate", 3,0, true, "网银证书费优惠率" )))
					.addNode(new FieldNode("serviceStart", new MsgField(ContentEnum.MessageType.STRING.toString(), "serviceStart", 8,0, true, "网银服务费优惠开始日期" )))
					.addNode(new FieldNode("serviceEnd", new MsgField(ContentEnum.MessageType.STRING.toString(), "serviceEnd", 8,0, true, "网银服务费优惠结束日期" )))
					.addNode(new FieldNode("serviceRate", new MsgField(ContentEnum.MessageType.STRING.toString(), "serviceRate", 3,0, true, "网银服务费优惠率" )))
					.addNode(new FieldNode("serviceBillDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "serviceBillDate", 8,0, true, "网银服务费下一收费日期" )))
					.addNode(new FieldNode("serviceAccountType", new MsgField(ContentEnum.MessageType.STRING.toString(), "serviceAccountType", 2,0, true, "服务费扣费模式" )))
					.addNode(new FieldNode("IdtfNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdtfNo", 20,0, true, "证件号码" )))
					.addNode(new FieldNode("IdtfTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdtfTp", 2,0, true, "证件类型" )))
					.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 150,0, true, "企业名称" )))
					.addNode(new FieldNode("manageType", new MsgField(ContentEnum.MessageType.STRING.toString(), "manageType", 10,0, true, "管理类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C012000105_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

