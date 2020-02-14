package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciF10ChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODF100104  客户信息变更交易 
 *  BODF100104 regflw
 *  综合前置
 * @author XZF
 */
@Component
public class BODF100104 extends EciF10ChannelService {

	private static BODF100104_I i = new BODF100104_I();
	private static BODF100104_O o = new BODF100104_O();
	public BODF100104() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100104_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("BankAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankAcc", 40,0, false, "银行账号" )))
					.addNode(new FieldNode("Passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "Passwd", 10,0, false, "交易密码" )))
					.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 10,0, false, "TA代码" )))
					.addNode(new FieldNode("IdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 6,0, false, "证件类型" )))
					.addNode(new FieldNode("IdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdCode", 40,0, false, "证件号码" )))
					.addNode(new FieldNode("ClientName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientName", 100,0, false, "客户名称" )))
					.addNode(new FieldNode("Sex", new MsgField(ContentEnum.MessageType.STRING.toString(), "Sex", 6,0, false, "性别" )))
					.addNode(new FieldNode("Address", new MsgField(ContentEnum.MessageType.STRING.toString(), "Address", 100,0, false, "通讯地址" )))
					.addNode(new FieldNode("PostCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PostCode", 10,0, false, "邮政编码" )))
					.addNode(new FieldNode("Tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tel", 11,0, false, "电话号码" )))
					.addNode(new FieldNode("Fax", new MsgField(ContentEnum.MessageType.STRING.toString(), "Fax", 11,0, false, "传真号码" )))
					.addNode(new FieldNode("Mobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "Mobile", 11,0, false, "手机号码" )))
					.addNode(new FieldNode("Email", new MsgField(ContentEnum.MessageType.STRING.toString(), "Email", 60,0, false, "EMAIL地址" )))
					.addNode(new FieldNode("ClientManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientManager", 10,0, false, "客户经理代码号" )))
					.addNode(new FieldNode("InstType", new MsgField(ContentEnum.MessageType.STRING.toString(), "InstType", 1,0, false, "机构投资人类型" )))
					.addNode(new FieldNode("ReprName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprName", 80,0, false, "法人代表姓名" )))
					.addNode(new FieldNode("ReprIdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprIdType", 1,0, false, "法人代表证件类型" )))
					.addNode(new FieldNode("ReprIdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprIdCode", 40,0, false, "法人代表证件号码" )))
					.addNode(new FieldNode("ActorName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorName", 100,0, false, "经办人姓名" )))
					.addNode(new FieldNode("ActorIdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorIdType", 6,0, false, "经办人证件类型" )))
					.addNode(new FieldNode("ActorIdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorIdCode", 40,0, false, "经办人证件号码" )))
					.addNode(new FieldNode("ContactName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ContactName", 100,0, false, "联系人姓名（对公）" )))
					.addNode(new FieldNode("ContactIdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ContactIdType", 1,0, false, "联系人证件类型（对公）" )))
					.addNode(new FieldNode("ContactIdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ContactIdCode", 40,0, false, "联系人证件号码（对公）" )))
					.addNode(new FieldNode("SendFreq", new MsgField(ContentEnum.MessageType.STRING.toString(), "SendFreq", 10,0, false, "对账单发送频率" )))
					.addNode(new FieldNode("SendMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "SendMode", 10,0, false, "对账单寄送方式" )))
					.addNode(new FieldNode("RiskLevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskLevel", 1,0, false, "风险等级" )))
					.addNode(new FieldNode("ClientGroup", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientGroup", 10,0, false, "客户分组" )))
					.addNode(new FieldNode("Birthday", new MsgField(ContentEnum.MessageType.STRING.toString(), "Birthday", 8,0, false, "出生日期" )))
					.addNode(new FieldNode("AccType", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccType", 1,0, true, "客户标识类型" )))
					.addNode(new FieldNode("Account", new MsgField(ContentEnum.MessageType.STRING.toString(), "Account", 32,0, true, "客户标识" )))
					.addNode(new FieldNode("ClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 1,0, false, "客户类型" )))
					.addNode(new FieldNode("Reserve2", new MsgField(ContentEnum.MessageType.STRING.toString(), "Reserve2", 100,0, false, "附加信息1" )))
					.addNode(new FieldNode("InstDocuValid", new MsgField(ContentEnum.MessageType.STRING.toString(), "InstDocuValid", 8,0, false, "机构证件有效期" )))
					.addNode(new FieldNode("OfficeAddress", new MsgField(ContentEnum.MessageType.STRING.toString(), "OfficeAddress", 250,0, false, "办公地址" )))
					.addNode(new FieldNode("BusiScope", new MsgField(ContentEnum.MessageType.STRING.toString(), "BusiScope", 2,0, false, "经营范围" )))
					.addNode(new FieldNode("RegAddress", new MsgField(ContentEnum.MessageType.STRING.toString(), "RegAddress", 250,0, false, "注册地址" )))
					.addNode(new FieldNode("InvestorType", new MsgField(ContentEnum.MessageType.STRING.toString(), "InvestorType", 1,0, false, "投资者类型" )))
					.addNode(new FieldNode("ShareHolder", new MsgField(ContentEnum.MessageType.STRING.toString(), "ShareHolder", 250,0, false, "控股股东或实际控制人" )))
					.addNode(new FieldNode("RegistCapital", new MsgField(ContentEnum.MessageType.STRING.toString(), "RegistCapital", 18,0, false, "注册资本" )))
					.addNode(new FieldNode("IsBenefit", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsBenefit", 250,0, false, "交易的实际受益人" )))
					.addNode(new FieldNode("BenefitExplain", new MsgField(ContentEnum.MessageType.STRING.toString(), "BenefitExplain", 250,0, false, "交易的实际收益人说明" )))
					.addNode(new FieldNode("IsControl", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsControl", 1,0, false, "是否存在实际控制关系" )))
					.addNode(new FieldNode("ControlExplain", new MsgField(ContentEnum.MessageType.STRING.toString(), "ControlExplain", 250,0, false, "实际控制关系说明" )))
					.addNode(new FieldNode("IsBadRecord", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsBadRecord", 1,0, false, "是否有不良诚信记录" )))
					.addNode(new FieldNode("BadRecordExplain", new MsgField(ContentEnum.MessageType.STRING.toString(), "BadRecordExplain", 250,0, false, "是否有不良诚信记录说明" )))
					.addNode(new FieldNode("QualificationType", new MsgField(ContentEnum.MessageType.STRING.toString(), "QualificationType", 2,0, false, "机构资质证明类型" )))
					.addNode(new FieldNode("QualificationCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "QualificationCode", 80,0, false, "资质证书编号" )))
					.addNode(new FieldNode("ReprSex", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprSex", 1,0, false, "法人代表性别" )))
					.addNode(new FieldNode("ReprBirthday", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprBirthday", 8,0, false, "法人代表出生日期" )))
					.addNode(new FieldNode("ReprEmail", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprEmail", 40,0, false, "法人代表电子邮箱" )))
					.addNode(new FieldNode("ReprDocuValid", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprDocuValid", 8,0, false, "法人代表证件有效期" )))
					.addNode(new FieldNode("ReprTel", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprTel", 24,0, false, "法人代表座机" )))
					.addNode(new FieldNode("ReprMobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprMobile", 24,0, false, "法人代表移动电话" )))
					.addNode(new FieldNode("ReprPostCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprPostCode", 6,0, false, "法人代表办公邮编" )))
					.addNode(new FieldNode("ReprWorkAddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprWorkAddr", 250,0, false, "法人代表办公地址" )))
					.addNode(new FieldNode("ActorSex", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorSex", 1,0, false, "经办人性别" )))
					.addNode(new FieldNode("ActorBirthday", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorBirthday", 8,0, false, "经办人出生日期" )))
					.addNode(new FieldNode("ActorEmail", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorEmail", 40,0, false, "经办人电子邮箱" )))
					.addNode(new FieldNode("ActorDocuValid", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorDocuValid", 8,0, false, "经办人证件有效期" )))
					.addNode(new FieldNode("ActorTel", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorTel", 24,0, false, "经办人座机" )))
					.addNode(new FieldNode("ActorMobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorMobile", 24,0, false, "经办人移动电话" )))
					.addNode(new FieldNode("ActorPostCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorPostCode", 6,0, false, "经办人办公邮编" )))
					.addNode(new FieldNode("ActorWorkAddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorWorkAddr", 250,0, false, "经办人办公地址" )))
					.addNode(new FieldNode("ActorAndInstRe", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorAndInstRe", 250,0, false, "经办人与该机构关系" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100104_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("SerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "SerialNo", 30,0, true, "系统流水号" )))
					.addNode(new FieldNode("ClientNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientNo", 100,0, true, "客户号" )))
					.addNode(new FieldNode("ClientName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientName", 100,0, true, "客户名称" )))
					.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 1,0, true, "交易状态" )))
					.addNode(new FieldNode("StatusName", new MsgField(ContentEnum.MessageType.STRING.toString(), "StatusName", 100,0, true, "交易状态名称" )))
					.addNode(new FieldNode("SendModeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "SendModeName", 100,0, false, "对账单寄送方式名称" )))
					.addNode(new FieldNode("ClientManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientManager", 30,0, false, "客户经理代码代码" )))
					.addNode(new FieldNode("ManagerName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ManagerName", 100,0, false, "客户经理代码名称" )))
					.addNode(new FieldNode("OldIdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldIdType", 6,0, false, "原证件类型" )))
					.addNode(new FieldNode("OldIdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldIdCode", 40,0, false, "原证件号码" )))
					.addNode(new FieldNode("OldClientName", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldClientName", 100,0, false, "原客户名称" )))
					.addNode(new FieldNode("OldSex", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldSex", 2,0, false, "原性别" )))
					.addNode(new FieldNode("OldAddress", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldAddress", 100,0, false, "原通讯地址" )))
					.addNode(new FieldNode("OldPostCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldPostCode", 10,0, false, "原邮政编码" )))
					.addNode(new FieldNode("OldTel", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldTel", 20,0, false, "原电话号码" )))
					.addNode(new FieldNode("OldFax", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldFax", 20,0, false, "原传真号码" )))
					.addNode(new FieldNode("OldMobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldMobile", 20,0, false, "原手机号码" )))
					.addNode(new FieldNode("OldEmail", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldEmail", 40,0, false, "原EMAIL地址" )))
					.addNode(new FieldNode("OldInstType", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldInstType", 1,0, false, "原机构投资人类型" )))
					.addNode(new FieldNode("OldReprName", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldReprName", 100,0, false, "原法人代表姓名" )))
					.addNode(new FieldNode("OldReprIdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldReprIdType", 6,0, false, "原法人代表证件类型" )))
					.addNode(new FieldNode("OldReprIdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldReprIdCode", 40,0, false, "原法人代表证件号码" )))
					.addNode(new FieldNode("OldActorName", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldActorName", 100,0, false, "原经办人姓名" )))
					.addNode(new FieldNode("OldActorIdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldActorIdType", 6,0, false, "原经办人证件类型" )))
					.addNode(new FieldNode("OldActorIdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldActorIdCode", 40,0, false, "原经办人证件号码" )))
					.addNode(new FieldNode("OldContactName", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldContactName", 100,0, false, "原联系人姓名(对公)" )))
					.addNode(new FieldNode("OldContactIdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldContactIdType", 6,0, false, "原联系人证件类型(对公)" )))
					.addNode(new FieldNode("OldContactIdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldContactIdCode", 40,0, false, "原联系人证件号码(对公)" )))
					.addNode(new FieldNode("OldSendFreq", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldSendFreq", 10,0, false, "原对账单发送频率" )))
					.addNode(new FieldNode("OldSendMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldSendMode", 1,0, false, "原对账单寄送方式" )))
					.addNode(new FieldNode("OldRiskLevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldRiskLevel", 10,0, false, "原风险等级" )))
					.addNode(new FieldNode("OldClientGroup", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldClientGroup", 10,0, false, "原客户分组" )))
					.addNode(new FieldNode("OldBirthday", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldBirthday", 8,0, false, "原出生日期" )))
					.addNode(new FieldNode("ChangeMsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ChangeMsg", 100,0, false, "变更内容" )))
					.addNode(new FieldNode("ChangeMsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ChangeMsg", 100,0, false, "变更信息" )))
					.addNode(new FieldNode("InstDocuValid", new MsgField(ContentEnum.MessageType.STRING.toString(), "InstDocuValid", 8,0, false, "机构证件有效期" )))
					.addNode(new FieldNode("OfficeAddress", new MsgField(ContentEnum.MessageType.STRING.toString(), "OfficeAddress", 250,0, false, "办公地址" )))
					.addNode(new FieldNode("BusiScope", new MsgField(ContentEnum.MessageType.STRING.toString(), "BusiScope", 2,0, false, "经营范围" )))
					.addNode(new FieldNode("RegAddress", new MsgField(ContentEnum.MessageType.STRING.toString(), "RegAddress", 250,0, false, "注册地址" )))
					.addNode(new FieldNode("InvestorType", new MsgField(ContentEnum.MessageType.STRING.toString(), "InvestorType", 1,0, false, "投资者类型" )))
					.addNode(new FieldNode("ShareHolder", new MsgField(ContentEnum.MessageType.STRING.toString(), "ShareHolder", 250,0, false, "控股股东或实际控制人" )))
					.addNode(new FieldNode("RegistCapital", new MsgField(ContentEnum.MessageType.STRING.toString(), "RegistCapital", 18,0, false, "注册资本" )))
					.addNode(new FieldNode("IsBenefit", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsBenefit", 250,0, false, "交易的实际受益人" )))
					.addNode(new FieldNode("BenefitExplain", new MsgField(ContentEnum.MessageType.STRING.toString(), "BenefitExplain", 250,0, false, "交易的实际收益人说明" )))
					.addNode(new FieldNode("IsControl", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsControl", 1,0, false, "是否存在实际控制关系" )))
					.addNode(new FieldNode("ControlExplain", new MsgField(ContentEnum.MessageType.STRING.toString(), "ControlExplain", 250,0, false, "实际控制关系说明" )))
					.addNode(new FieldNode("IsBadRecord", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsBadRecord", 1,0, false, "是否有不良诚信记录" )))
					.addNode(new FieldNode("BadRecordExplain", new MsgField(ContentEnum.MessageType.STRING.toString(), "BadRecordExplain", 250,0, false, "是否有不良诚信记录说明" )))
					.addNode(new FieldNode("QualificationType", new MsgField(ContentEnum.MessageType.STRING.toString(), "QualificationType", 2,0, false, "机构资质证明类型" )))
					.addNode(new FieldNode("QualificationCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "QualificationCode", 80,0, false, "资质证书编号" )))
					.addNode(new FieldNode("ReprSex", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprSex", 1,0, false, "法人代表性别" )))
					.addNode(new FieldNode("ReprBirthday", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprBirthday", 8,0, false, "法人代表出生日期" )))
					.addNode(new FieldNode("ReprEmail", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprEmail", 40,0, false, "法人代表电子邮箱" )))
					.addNode(new FieldNode("ReprDocuValid", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprDocuValid", 8,0, false, "法人代表证件有效期" )))
					.addNode(new FieldNode("ReprTel", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprTel", 24,0, false, "法人代表座机" )))
					.addNode(new FieldNode("ReprMobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprMobile", 24,0, false, "法人代表移动电话" )))
					.addNode(new FieldNode("ReprPostCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprPostCode", 6,0, false, "法人代表办公邮编" )))
					.addNode(new FieldNode("ReprWorkAddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprWorkAddr", 250,0, false, "法人代表办公地址" )))
					.addNode(new FieldNode("ActorSex", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorSex", 1,0, false, "经办人性别" )))
					.addNode(new FieldNode("ActorBirthday", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorBirthday", 8,0, false, "经办人出生日期" )))
					.addNode(new FieldNode("ActorEmail", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorEmail", 40,0, false, "经办人电子邮箱" )))
					.addNode(new FieldNode("ActorDocuValid", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorDocuValid", 8,0, false, "经办人证件有效期" )))
					.addNode(new FieldNode("ActorTel", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorTel", 24,0, false, "经办人座机" )))
					.addNode(new FieldNode("ActorMobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorMobile", 24,0, false, "经办人移动电话" )))
					.addNode(new FieldNode("ActorPostCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorPostCode", 6,0, false, "经办人办公邮编" )))
					.addNode(new FieldNode("ActorWorkAddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorWorkAddr", 250,0, false, "经办人办公地址" )))
					.addNode(new FieldNode("ActorAndInstRe", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorAndInstRe", 250,0, false, "经办人与该机构关系" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

