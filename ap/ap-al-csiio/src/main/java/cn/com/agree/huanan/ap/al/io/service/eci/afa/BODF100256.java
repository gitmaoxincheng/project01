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
 * BASESVC BODF100256  定向购买
 * BODF100256 100256 regflw
 *  综合前置
 * @author Maoxc
 */
@Component
public class BODF100256 extends EciF10ChannelService {

	private static BODF100256_I i = new BODF100256_I();
	private static BODF100256_O o = new BODF100256_O();

	public BODF100256() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100256_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("FunctionId", new MsgField(ContentEnum.MessageType.STRING.toString(), "FunctionId", 20,0, false, "交易代码" )))
					.addNode(new FieldNode("ExSerial", new MsgField(ContentEnum.MessageType.STRING.toString(), "ExSerial", 20,0,false, "发起方流水号" )))
					.addNode(new FieldNode("BankNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankNo", 30,0,false, "银行编号" )))
					.addNode(new FieldNode("BranchNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BranchNo", 20,0,false, "交易机构" )))
					.addNode(new FieldNode("Channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "Channel", 100,0,false, "交易渠道" )))
					.addNode(new FieldNode("TermNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "TermNo", 10,0,false, "终端代码" )))
					.addNode(new FieldNode("OperNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "OperNo", 30,0,false, "交易柜员" )))
					.addNode(new FieldNode("AuthOper", new MsgField(ContentEnum.MessageType.STRING.toString(), "AuthOper", 10,0,false, "授权柜员" )))
					.addNode(new FieldNode("AuthPwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "AuthPwd", 10,0,false, "授权密码" )))
					.addNode(new FieldNode("TransDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransDate", 20,0,false, "交易日期" )))
					.addNode(new FieldNode("TransTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransTime", 8,0,false, "交易时间" )))
					.addNode(new FieldNode("PrdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdType", 16,0,false, "产品类别" )))
					.addNode(new FieldNode("Reserve", new MsgField(ContentEnum.MessageType.STRING.toString(), "Reserve", 10,0,false, "交易附加信息" )))
					.addNode(new FieldNode("Reserve1", new MsgField(ContentEnum.MessageType.STRING.toString(), "Reserve1", 100,0,false, "附加信息1" )))
					.addNode(new FieldNode("Reserve2", new MsgField(ContentEnum.MessageType.STRING.toString(), "Reserve2", 100,0,false, "附加信息2" )))
					.addNode(new FieldNode("OpenBranch", new MsgField(ContentEnum.MessageType.STRING.toString(), "OpenBranch", 100,0,false, "银行账号开户机构" )))
					.addNode(new FieldNode("BankAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankAcc", 10,0,false, "银行账号" )))
					.addNode(new FieldNode("Passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "Passwd", 6,0,false, "交易密码" )))
					.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 10,0,false, "产品代码" )))
					.addNode(new FieldNode("Amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Amt", 10,0,false, "金额" )))
					.addNode(new FieldNode("Vol", new MsgField(ContentEnum.MessageType.STRING.toString(), "Vol", 10,0,false, "份额" )))
					.addNode(new FieldNode("ClientManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientManager", 30,0,false, "客户经理代码代码" )))
					.addNode(new FieldNode("PrdKind", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdKind", 10,0,false, "产品业务模式" )))
					.addNode(new FieldNode("SellerCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "SellerCode", 10,0,false, "合作商号" )))
					.addNode(new FieldNode("AccType", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccType", 1,0,false, "客户标识类型" )))
					.addNode(new FieldNode("Account", new MsgField(ContentEnum.MessageType.STRING.toString(), "Account", 32,0,false, "客户标识" )))
					.addNode(new FieldNode("IdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 6,0,false, "证件类型" )))
					.addNode(new FieldNode("ClientGroup", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientGroup", 10,0,false, "客户分组" )))
					.addNode(new FieldNode("CashFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "CashFlag", 1,0,false, "钞汇标志" )))
					.addNode(new FieldNode("ClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 1,0,false, "客户类型" )))
					//.addNode(new FieldNode("OpenBranch", new MsgField(ContentEnum.MessageType.STRING.toString(), "OpenBranch", 10,0,false, "开卡机构" )))
					.addNode(new FieldNode("DivMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivMode", 1,0,false, "分红方式" )))
					.addNode(new FieldNode("RecordeSeqNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "RecordeSeqNo", 30,0,false, "录音录像流水" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODF100256_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("FunctionId", new MsgField(ContentEnum.MessageType.STRING.toString(), "FunctionId", 20,0, false, "交易代码" )))
					.addNode(new FieldNode("ExSerial", new MsgField(ContentEnum.MessageType.STRING.toString(), "ExSerial", 30,0,false, "发起方流水号" )))
					.addNode(new FieldNode("ErrorNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ErrorNo", 20,0,false, "错误代码" )))
					.addNode(new FieldNode("ErrorInfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ErrorInfo", 100,0,false, "错误信息" )))
					.addNode(new FieldNode("Reserve", new MsgField(ContentEnum.MessageType.STRING.toString(), "Reserve", 100,0,false, "交易附加信息" )))
					.addNode(new FieldNode("SerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "SerialNo", 40,0,false, "系统流水号" )))
					.addNode(new FieldNode("ClientNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientNo", 10,0,false, "客户编号" )))
					.addNode(new FieldNode("ClientName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientName", 100,0,false, "客户名称" )))
					.addNode(new FieldNode("TAName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TAName", 100,0,false, "TA名称" )))
					.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 10,0,false, "产品代码" )))
					.addNode(new FieldNode("PrdName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdName", 100,0,false, "产品名称" )))
					.addNode(new FieldNode("CurrType", new MsgField(ContentEnum.MessageType.STRING.toString(), "CurrType", 1,0,false, "币种" )))
					.addNode(new FieldNode("CashFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "CashFlag", 1,0,false, "钞汇标志" )))
					.addNode(new FieldNode("Amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Amt", 10,0,false, "金额" )))
					.addNode(new FieldNode("Vol", new MsgField(ContentEnum.MessageType.STRING.toString(), "Vol", 10,0,false, "份额" )))
					.addNode(new FieldNode("Agio", new MsgField(ContentEnum.MessageType.STRING.toString(), "Agio", 10,0,false, "折扣率" )))
					.addNode(new FieldNode("ClientManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientManager", 30,0,false, "客户经理代码" )))
					.addNode(new FieldNode("ManagerName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ManagerName", 100,0,false, "客户经理名称" )))
					.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 1,0,false, "交易状态" )))
					.addNode(new FieldNode("StatusName", new MsgField(ContentEnum.MessageType.STRING.toString(), "StatusName", 100,0,false, "交易状态名称" )))
					.addNode(new FieldNode("Summary", new MsgField(ContentEnum.MessageType.STRING.toString(), "Summary", 100,0,false, "备注" )))
					.addNode(new FieldNode("HostSerial", new MsgField(ContentEnum.MessageType.STRING.toString(), "HostSerial", 40,0,false, "主机流水号" )))
					.addNode(new FieldNode("TransName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransName", 100,0,false, "交易名称" )))
					.addNode(new FieldNode("FirstFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "FirstFlag", 1,0,false, "首次购买标识" )))
					.addNode(new FieldNode("DivMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivMode", 1,0,false, "分红方式" )))
					.addNode(new FieldNode("DivModeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivModeName", 100,0,false, "分红方式名称" )))
					.addNode(new FieldNode("ManageCharge", new MsgField(ContentEnum.MessageType.STRING.toString(), "ManageCharge", 10,0,false, "外收费手续费" )))
					.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 10,0,false, "TA代码" )))
					.addNode(new FieldNode("AutoOpenAccFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "AutoOpenAccFlag", 1,0,false, "自动开理财账户标识" )))
					.addNode(new FieldNode("AutoOpenAccInfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "AutoOpenAccInfo", 100,0,false, "自动开理财账户提示信息" )))
					.addNode(new FieldNode("MonitorFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "MonitorFlag", 1,0,false, "风险等级不匹配提示信息" )))
					.addNode(new FieldNode("ReprName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReprName", 100,0,false, "法人代表" )))
					.addNode(new FieldNode("EstabDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "EstabDate", 8,0,false, "产品成立日" )))
					.addNode(new FieldNode("EndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "EndDate", 8,1,false, "产品到期日" )))
					.addNode(new FieldNode("GuestRate", new MsgField(ContentEnum.MessageType.STRING.toString(), "GuestRate", 10,2,false, "预期收益率" )))

					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
