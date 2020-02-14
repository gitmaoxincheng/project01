package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciF10ChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;


/**
 * BASESVC BODF100342  允许撤单流水查询交易 
 *  BODF100342 
 *  综合前端
 * @author XZF
 */
@Component
public class BODF100342 extends EciF10ChannelService {

	private static BODF100342_I i = new BODF100342_I();
	private static BODF100342_O o = new BODF100342_O();
	public BODF100342() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100342_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("AccType", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccType", 1,0, true, "客户标识类型" )))
					.addNode(new FieldNode("Account", new MsgField(ContentEnum.MessageType.STRING.toString(), "Account", 32,0, true, "客户标识" )))
					.addNode(new FieldNode("IdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 1,0, true, "证件类型" )))
					.addNode(new FieldNode("SerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "SerialNo", 30,0, false, "流水号" )))
					.addNode(new FieldNode("OrderFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "OrderFlag", 1,0, false, "排序标志" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 50,0, true, "定位串" )))
					.addNode(new FieldNode("QueryNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "QueryNum", 10,0, true, "查询行数" )))
					.addNode(new FieldNode("ClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 10,0, false, "客户类型" )))
					.addNode(new FieldNode("Flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "Flag", 10,0, false, "特殊查询标志" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100342_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("TotNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNum", 10,0, true, "总行数" )))
					.addNode(new FieldNode("RetNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "RetNum", 10,0, true, "本次返回行数" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 50,0, true, "定位串" )))
					.addNode(new ArrayNode("bodrcd",true,"cancel_list")
							.addNode(new FieldNode("ClientNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientNo", 40,0, true, "客户编号" )))
							.addNode(new FieldNode("TransDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransDate", 8,0, true, "交易日期" )))
							.addNode(new FieldNode("SerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "SerialNo", 30,0, true, "流水号" )))
							.addNode(new FieldNode("TransCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransCode", 10,0, true, "交易代码" )))
							.addNode(new FieldNode("TransName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransName", 80,0, true, "交易名称" )))
							.addNode(new FieldNode("Channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "Channel", 10,0, true, "交易渠道" )))
							.addNode(new FieldNode("TAName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TAName", 80,0, true, "TA名称" )))
							.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 80,0, true, "TA名称" )))
							.addNode(new FieldNode("PrdName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdName", 80,0, true, "产品名称" )))
							.addNode(new FieldNode("BankAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankAcc", 30,0, true, "银行账号" )))
							.addNode(new FieldNode("Vol", new MsgField(ContentEnum.MessageType.STRING.toString(), "Vol", 10,0, false, "份额" )))
							.addNode(new FieldNode("CurrType", new MsgField(ContentEnum.MessageType.STRING.toString(), "CurrType", 10,0, true, "币种" )))
							.addNode(new FieldNode("Amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Amt", 17,0, false, "金额" )))
							.addNode(new FieldNode("Agio", new MsgField(ContentEnum.MessageType.STRING.toString(), "Agio", 10,0, false, "折扣率" )))
							.addNode(new FieldNode("StatusName", new MsgField(ContentEnum.MessageType.STRING.toString(), "StatusName", 80,0, true, "交易状态名称" )))
							.addNode(new FieldNode("TransTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransTime", 16,0, true, "交易时间" )))
							.addNode(new FieldNode("TransType", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransType", 10,0, true, "交易类别" )))
							.addNode(new FieldNode("ManageCharge", new MsgField(ContentEnum.MessageType.STRING.toString(), "ManageCharge", 10,0, true, "外收费手续费" )))
							.addNode(new FieldNode("ClientName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientName", 10,0, false, "客户名称" )))
							.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 10,0, true, "交易状态" )))
							.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 10,0, true, "TA代码" )))
							.addNode(new FieldNode("OperNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "OperNo", 10,0, true, "交易柜员" )))
							.addNode(new FieldNode("AuthOper", new MsgField(ContentEnum.MessageType.STRING.toString(), "AuthOper", 10,0, true, "授权柜员" )))
							.addNode(new FieldNode("HostDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "HostDate", 10,0, true, "主机日期" )))
							.addNode(new FieldNode("HostSerial", new MsgField(ContentEnum.MessageType.STRING.toString(), "HostSerial", 30,0, true, "主机流水" )))
							.addNode(new FieldNode("CashFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "CashFlag", 10,0, false, "钞汇标志" )))
							.addNode(new FieldNode("TransAccountType", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransAccountType", 10,0, false, "交易介质类型" )))
							.addNode(new FieldNode("TransAccount", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransAccount", 10,0, false, "交易介质" )))
							.addNode(new FieldNode("PrdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdType", 10,0, false, "业务类别" )))
							.addNode(new FieldNode("Channels", new MsgField(ContentEnum.MessageType.STRING.toString(), "Channels", 80,0, false, "允许渠道组" )))
							.addNode(new FieldNode("TemplateCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TemplateCode", 10,0, false, "模板代码" )))
							.addNode(new FieldNode("BranchNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BranchNo", 100,0, true, "交易机构" )))
							.addNode(new FieldNode("DivMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivMode", 10,0, true, "分红方式" )))
							));
			messageNode.addStructNode(new StructNode("Head",true,"APPBody")
					.addNode(new FieldNode("FunctionId", new MsgField(ContentEnum.MessageType.STRING.toString(), "FunctionId", 20,0, true, "交易代码" )))
					.addNode(new FieldNode("ExSerial", new MsgField(ContentEnum.MessageType.STRING.toString(), "ExSerial", 30,0, false, "发起方流水号" )))
					.addNode(new FieldNode("ErrorNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ErrorNo", 20,0, true, "错误代码" )))
					.addNode(new FieldNode("ErrorInfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ErrorInfo", 100,0, true, "错误信息" )))
					.addNode(new FieldNode("Reserve", new MsgField(ContentEnum.MessageType.STRING.toString(), "Reserve", 100,0, false, "交易附加信息" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

