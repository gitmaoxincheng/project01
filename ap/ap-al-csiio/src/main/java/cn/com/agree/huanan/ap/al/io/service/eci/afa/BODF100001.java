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
 * BASESVC BODF100001  客户签约和行内理财签约 
 *  BODF100001 
 *  综合前置
 * @author XZF
 */
@Component
public class BODF100001 extends EciF10ChannelService {

	private static BODF100001_I i = new BODF100001_I();
	private static BODF100001_O o = new BODF100001_O();
	public BODF100001() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100001_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("ClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 1,0, true, "客户类型" )))
					.addNode(new FieldNode("BankAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankAcc", 32,0, false, "银行账号" )))
					.addNode(new FieldNode("OpenBranch", new MsgField(ContentEnum.MessageType.STRING.toString(), "OpenBranch", 10,0, true, "开卡机构" )))
					.addNode(new FieldNode("ClientNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientNo", 30,0, false, "客户编号" )))
					.addNode(new FieldNode("Passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "Passwd", 10,0, true, "交易密码" )))
					.addNode(new FieldNode("ShortName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ShortName", 80,0, false, "客户简称" )))
					.addNode(new FieldNode("ClientName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientName", 80,0, true, "客户名称" )))
					.addNode(new FieldNode("IdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 6,0, true, "证件类型" )))
					.addNode(new FieldNode("IdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdCode", 40,0, true, "证件号码" )))
					.addNode(new FieldNode("Address", new MsgField(ContentEnum.MessageType.STRING.toString(), "Address", 100,0, true, "通讯地址" )))
					.addNode(new FieldNode("PostCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PostCode", 10,0, true, "邮政编码" )))
					.addNode(new FieldNode("Tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tel", 11,0, false, "电话号码" )))
					.addNode(new FieldNode("Fax", new MsgField(ContentEnum.MessageType.STRING.toString(), "Fax", 11,0, false, "传真号码" )))
					.addNode(new FieldNode("Mobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "Mobile", 11,0, false, "手机号码" )))
					.addNode(new FieldNode("Email", new MsgField(ContentEnum.MessageType.STRING.toString(), "Email", 60,0, false, "EMAIL地址" )))
					.addNode(new FieldNode("ClientManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientManager", 10,0, false, "客户经理代码代码" )))
					.addNode(new FieldNode("SendFreq", new MsgField(ContentEnum.MessageType.STRING.toString(), "SendFreq", 20,0, false, "对账单发送频率" )))
					.addNode(new FieldNode("SendMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "SendMode", 20,0, false, "对账单寄送方式" )))
					.addNode(new FieldNode("Sex", new MsgField(ContentEnum.MessageType.STRING.toString(), "Sex", 6,0, false, "性别" )))
					.addNode(new FieldNode("InstType", new MsgField(ContentEnum.MessageType.STRING.toString(), "InstType", 1,0, false, "机构投资人类型" )))
					.addNode(new FieldNode("ReprName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprName", 80,0, false, "法人代表姓名" )))
					.addNode(new FieldNode("ReprIdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprIdType", 6,0, false, "法人代表证件类型" )))
					.addNode(new FieldNode("ReprIdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprIdCode", 40,0, false, "法人代表证件号码" )))
					.addNode(new FieldNode("ActorName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorName", 80,0, false, "经办人姓名" )))
					.addNode(new FieldNode("ActorIdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorIdType", 6,0, false, "经办人证件类型" )))
					.addNode(new FieldNode("ActorIdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ActorIdCode", 40,0, false, "经办人证件号码" )))
					.addNode(new FieldNode("LinkName", new MsgField(ContentEnum.MessageType.STRING.toString(), "LinkName", 80,0, false, "联系人姓名" )))
					.addNode(new FieldNode("LinkIdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "LinkIdType", 6,0, false, "联系人证件类型" )))
					.addNode(new FieldNode("LinkIdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "LinkIdCode", 40,0, false, "联系人证件号码" )))
					.addNode(new FieldNode("RiskLevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskLevel", 1,0, false, "风险等级" )))
					.addNode(new FieldNode("ClientGroup", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientGroup", 20,0, false, "客户分组" )))
					.addNode(new FieldNode("Birthday", new MsgField(ContentEnum.MessageType.STRING.toString(), "Birthday", 8,0, false, "出生日期" )))
					.addNode(new FieldNode("RiskMonths", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskMonths", 6,0, false, "风险有效期月数" )))
					.addNode(new FieldNode("AccType", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccType", 1,0, true, "客户标识类型" )))
					.addNode(new FieldNode("Account", new MsgField(ContentEnum.MessageType.STRING.toString(), "Account", 32,0, true, "客户标识" )))
					.addNode(new FieldNode("ClientOpenBranch", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientOpenBranch", 10,0, false, "客户所属机构" )))
					.addNode(new FieldNode("Channels", new MsgField(ContentEnum.MessageType.STRING.toString(), "Channels", 80,0, false, "客户开通渠道" )))
					.addNode(new FieldNode("ChannelAbleFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ChannelAbleFlag", 1,0, false, "高风险产品柜台以外渠道允许购买标志" )))
					.addNode(new FieldNode("Reserve2", new MsgField(ContentEnum.MessageType.STRING.toString(), "Reserve2", 100,0, false, "附加信息1" )))
					.addNode(new FieldNode("HostClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "HostClientType", 1,0, false, "主机客户类型" )))
					.addNode(new FieldNode("LastScore", new MsgField(ContentEnum.MessageType.STRING.toString(), "LastScore", 6,0, false, "风险评估总分" )))
					.addNode(new FieldNode("promno", new MsgField(ContentEnum.MessageType.STRING.toString(), "promno", 6,0, false, "推荐人代码" )))
					.addNode(new FieldNode("promna", new MsgField(ContentEnum.MessageType.STRING.toString(), "promna", 200,0, false, "推荐人名称" )))
					.addNode(new FieldNode("saleno", new MsgField(ContentEnum.MessageType.STRING.toString(), "saleno", 6,0, false, "营销人员代码" )))
					.addNode(new FieldNode("salena", new MsgField(ContentEnum.MessageType.STRING.toString(), "salena", 200,0, false, "营销人员名称" )))
					.addNode(new FieldNode("InstDocuValid", new MsgField(ContentEnum.MessageType.STRING.toString(), "InstDocuValid", 8,0, false, "机构证件有效期" )))
					.addNode(new FieldNode("OfficeAddress", new MsgField(ContentEnum.MessageType.STRING.toString(), "OfficeAddress", 250,0, false, "办公地址" )))
					.addNode(new FieldNode("BusiScope", new MsgField(ContentEnum.MessageType.STRING.toString(), "BusiScope", 2,0, false, "经营范围" )))
					.addNode(new FieldNode("RegAddress", new MsgField(ContentEnum.MessageType.STRING.toString(), "RegAddress", 250,0, false, "注册地址" )))
					.addNode(new FieldNode("InvestorType", new MsgField(ContentEnum.MessageType.STRING.toString(), "InvestorType", 1,0, false, "投资者类型" )))
					.addNode(new FieldNode("ShareHolder", new MsgField(ContentEnum.MessageType.STRING.toString(), "ShareHolder", 250,0, false, "控股股东或实际控制人" )))
					.addNode(new FieldNode("RegistCapital", new MsgField(ContentEnum.MessageType.STRING.toString(), "RegistCapital", 18,0, false, "注册资本" )))
					.addNode(new FieldNode("IsBenefit", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsBenefit", 250,0, true, "交易的实际受益人" )))
					.addNode(new FieldNode("BenefitExplain", new MsgField(ContentEnum.MessageType.STRING.toString(), "BenefitExplain", 250,0, false, "交易的实际收益人说明" )))
					.addNode(new FieldNode("IsControl", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsControl", 1,0, true, "是否存在实际控制关系" )))
					.addNode(new FieldNode("ControlExplain", new MsgField(ContentEnum.MessageType.STRING.toString(), "ControlExplain", 250,0, false, "实际控制关系说明" )))
					.addNode(new FieldNode("IsBadRecord", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsBadRecord", 1,0, true, "是否有不良诚信记录" )))
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

	public static class BODF100001_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("SerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "SerialNo", 30,0, true, "系统流水号" )))
					.addNode(new FieldNode("ClientNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientNo", 40,0, true, "客户编号" )))
					.addNode(new FieldNode("ClientName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientName", 80,0, true, "客户名称" )))
					.addNode(new FieldNode("SendFreq", new MsgField(ContentEnum.MessageType.STRING.toString(), "SendFreq", 20,0, false, "对账单发送频率" )))
					.addNode(new FieldNode("SendMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "SendMode", 10,0, false, "对账单寄送方式" )))
					.addNode(new FieldNode("SendModeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "SendModeName", 100,0, false, "对账单寄送方式名称" )))
					.addNode(new FieldNode("RiskDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskDate", 8,0, false, "风险有效期截止日" )))
					.addNode(new FieldNode("ClientManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientManager", 30,0, false, "客户经理代码代码" )))
					.addNode(new FieldNode("ManagerName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ManagerName", 100,0, false, "客户经理代码名称" )))
					.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 1,0, true, "交易状态" )))
					.addNode(new FieldNode("StatusName", new MsgField(ContentEnum.MessageType.STRING.toString(), "StatusName", 100,0, true, "交易状态名称" )))
					.addNode(new FieldNode("Channels", new MsgField(ContentEnum.MessageType.STRING.toString(), "Channels", 80,0, false, "客户开通渠道" )))
					.addNode(new FieldNode("Channels1", new MsgField(ContentEnum.MessageType.STRING.toString(), "Channels1", 80,0, false, "系统自动开通渠道组" )))
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

