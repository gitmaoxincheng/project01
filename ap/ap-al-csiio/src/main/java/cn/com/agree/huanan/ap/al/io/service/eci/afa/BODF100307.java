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
 * BASESVC BODF100307  客户当前委托查询交易 
 *  BODF100307 
 *  综合前端
 * @author XZF
 */
@Component
public class BODF100307 extends EciF10ChannelService {

	private static BODF100307_I i = new BODF100307_I();
	private static BODF100307_O o = new BODF100307_O();
	public BODF100307() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100307_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("AccType", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccType", 1,0, true, "客户标识类型" )))
					.addNode(new FieldNode("Account", new MsgField(ContentEnum.MessageType.STRING.toString(), "Account", 32,0, true, "客户标识" )))
					.addNode(new FieldNode("IdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 1,0, true, "证件类型" )))
					.addNode(new FieldNode("SerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "SerialNo", 30,0, false, "流水号" )))
					.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 20,0, false, "TA代码" )))
					.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 20,0, false, "产品代码" )))
					.addNode(new FieldNode("TransCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransCode", 20,0, false, "交易代码" )))
					.addNode(new FieldNode("OrderFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "OrderFlag", 1,0, false, "排序标志" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 50,0, true, "定位串" )))
					.addNode(new FieldNode("QueryNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "QueryNum", 10,0, true, "查询行数" )))
					.addNode(new FieldNode("ClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 1,0, false, "客户类型" )))
					.addNode(new FieldNode("TransCodes", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransCodes", 10,0, false, "交易码组合" )))
					.addNode(new FieldNode("Statuss", new MsgField(ContentEnum.MessageType.STRING.toString(), "Statuss", 10,0, false, "交易状态组合" )))
					.addNode(new FieldNode("AssoSerial", new MsgField(ContentEnum.MessageType.STRING.toString(), "AssoSerial", 40,0, false, "关联流水号" )))
					.addNode(new FieldNode("OriExSerial", new MsgField(ContentEnum.MessageType.STRING.toString(), "OriExSerial", 40,0, false, "原发起方流水号" )))
					.addNode(new FieldNode("OriChannel", new MsgField(ContentEnum.MessageType.STRING.toString(), "OriChannel", 10,0, false, "原渠道号" )))
					.addNode(new FieldNode("Flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "Flag", 1,0, true, "快速赎回使用标志" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100307_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("TotNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNum", 10,0, true, "总行数" )))
					.addNode(new FieldNode("RetNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "RetNum", 10,0, true, "本次返回行数" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 50,0, true, "定位串" )))
					.addNode(new ArrayNode("bodrcd",true,"tran_list")
							.addNode(new FieldNode("ClientNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientNo", 40,0, true, "客户编号" )))
							.addNode(new FieldNode("TransDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransDate", 8,0, true, "交易日期" )))
							.addNode(new FieldNode("SerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "SerialNo", 30,0, true, "流水号" )))
							.addNode(new FieldNode("TransCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransCode", 10,0, true, "交易代码" )))
							.addNode(new FieldNode("TransName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransName", 80,0, true, "交易名称" )))
							.addNode(new FieldNode("Channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "Channel", 10,0, true, "交易渠道" )))
							.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 20,0, true, "TA代码" )))
							.addNode(new FieldNode("TAName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TAName", 80,0, true, "TA名称" )))
							.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 80,0, true, "TA名称" )))
							.addNode(new FieldNode("PrdName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdName", 80,0, true, "产品名称" )))
							.addNode(new FieldNode("BankAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankAcc", 30,0, true, "银行账号" )))
							.addNode(new FieldNode("AssetAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "AssetAcc", 30,0, true, "理财账号" )))
							.addNode(new FieldNode("Vol", new MsgField(ContentEnum.MessageType.STRING.toString(), "Vol", 10,0, true, "份额" )))
							.addNode(new FieldNode("CurrType", new MsgField(ContentEnum.MessageType.STRING.toString(), "CurrType", 10,0, true, "币种" )))
							.addNode(new FieldNode("Amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Amt", 17,0, true, "金额" )))
							.addNode(new FieldNode("Agio", new MsgField(ContentEnum.MessageType.STRING.toString(), "Agio", 10,0, true, "折扣率" )))
							.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 1,0, true, "账户状态" )))
							.addNode(new FieldNode("Summary", new MsgField(ContentEnum.MessageType.STRING.toString(), "Summary", 100,0, true, "摘要" )))
							.addNode(new FieldNode("ErrCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ErrCode", 20,0, true, "错误代码" )))
							.addNode(new FieldNode("ErrMsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ErrMsg", 100,0, true, "错误信息" )))
							.addNode(new FieldNode("Reserve", new MsgField(ContentEnum.MessageType.STRING.toString(), "Reserve", 100,0, true, "附加信息" )))
							.addNode(new FieldNode("FrozenCause", new MsgField(ContentEnum.MessageType.STRING.toString(), "FrozenCause", 100,0, true, "冻结原因" )))
							.addNode(new FieldNode("LargRedFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "LargRedFlag", 1,0, true, "巨额赎回标志" )))
							.addNode(new FieldNode("DivMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivMode", 10,0, true, "分红方式" )))
							.addNode(new FieldNode("DivModName", new MsgField(ContentEnum.MessageType.STRING.toString(), "DivModName", 100,0, true, "分红方式名称" )))
							.addNode(new FieldNode("StatusName", new MsgField(ContentEnum.MessageType.STRING.toString(), "StatusName", 100,0, true, "交易状态名称" )))
							.addNode(new FieldNode("TransTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransTime", 16,0, true, "交易时间" )))
							.addNode(new FieldNode("TransAccountType", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransAccountType", 1,0, true, "交易介质类型" )))
							.addNode(new FieldNode("TransAccount", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransAccount", 30,0, true, "交易介质" )))
							.addNode(new FieldNode("ClientRisk", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientRisk", 10,0, true, "客户风险等级" )))
							.addNode(new FieldNode("ProductRisk", new MsgField(ContentEnum.MessageType.STRING.toString(), "ProductRisk", 10,0, true, "产品风险等级" )))
							.addNode(new FieldNode("ContractNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ContractNo", 50,0, true, "合约编号" )))
							.addNode(new FieldNode("ManageCharge", new MsgField(ContentEnum.MessageType.STRING.toString(), "ManageCharge", 10,0, true, "外收手续费" )))
							.addNode(new FieldNode("ClientName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientName", 100,0, true, "客户名称" )))
							.addNode(new FieldNode("AssoDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "AssoDate", 8,0, true, "关联日期" )))
							.addNode(new FieldNode("CashFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "CashFlag", 1,0, false, "钞汇标志" )))
							.addNode(new FieldNode("ManageCharge2", new MsgField(ContentEnum.MessageType.STRING.toString(), "ManageCharge2", 10,0, false, "撤单外收费手续费" )))
							.addNode(new FieldNode("LiquStatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "LiquStatus", 1,0, false, "帐务状态" )))
							.addNode(new FieldNode("LiquStatusName", new MsgField(ContentEnum.MessageType.STRING.toString(), "LiquStatusName", 100,0, false, "帐务状态名称" )))
							.addNode(new FieldNode("TargPrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TargPrdCode", 10,0, false, "转入产品代码" )))
							.addNode(new FieldNode("TargSellerCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TargSellerCode", 10,0, false, "对方销售商代码" )))
							.addNode(new FieldNode("TargAssetAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "TargAssetAcc", 40,0, false, "对方理财账号" )))
							.addNode(new FieldNode("TargBankAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "TargBankAcc", 40,0, false, "目标银行帐号" )))
							.addNode(new FieldNode("OperNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "OperNo", 10,0, true, "交易柜员" )))
							.addNode(new FieldNode("BranchNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BranchNo", 10,0, true, "交易机构" )))
							.addNode(new FieldNode("OpenBranch", new MsgField(ContentEnum.MessageType.STRING.toString(), "OpenBranch", 10,0, true, "交易所属机构" )))
							.addNode(new FieldNode("ClientManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientManager", 30,0, false, "客户经理" )))
							.addNode(new FieldNode("AssoSerial", new MsgField(ContentEnum.MessageType.STRING.toString(), "AssoSerial", 40,0, false, "关联流水号" )))
							.addNode(new FieldNode("TargPrdName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TargPrdName", 100,0, false, "目标产品名称" )))
							.addNode(new FieldNode("OccurInitDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "OccurInitDate", 8,0, true, "交易发生的物理时间" )))
							.addNode(new FieldNode("OriExSerial", new MsgField(ContentEnum.MessageType.STRING.toString(), "OriExSerial", 40,0, true, "原发起方流水号" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

