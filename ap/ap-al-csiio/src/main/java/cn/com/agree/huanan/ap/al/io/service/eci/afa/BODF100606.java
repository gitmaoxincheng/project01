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
 * BASESVC BODF100606 客户余额宝交易查询(余额宝) BODF100606 综合前端
 * 
 * @author XZF
 */
@Component
public class BODF100606 extends EciF10ChannelService {

	private static BODF100606_I i = new BODF100606_I();
	private static BODF100606_O o = new BODF100606_O();

	public BODF100606() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100606_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode
					.addStructNode(new StructNode("APPBody", false, "Body")
							.addNode(new FieldNode("AccType",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "AccType", 1, 0, true,
											"客户标识类型")))
							.addNode(new FieldNode("Account",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "Account", 32, 0, true,
											"客户标识")))
							.addNode(new FieldNode("IdType",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 6, 0, false,
											"证件类型")))
							.addNode(new FieldNode("BankAcc",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "BankAcc", 40, 0, false,
											"银行账号")))
							.addNode(new FieldNode("TACode",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 10, 0, false,
											"TA代码")))
							.addNode(new FieldNode("PrdCode",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 10, 0, false,
											"产品代码")))
							.addNode(new FieldNode("TransCodes",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "TransCodes", 10, 0, false,
											"交易代码")))
							.addNode(new FieldNode("Statuss",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "Statuss", 10, 0, false,
											"交易状态")))
							.addNode(new FieldNode("StartDate",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "StartDate", 10, 0, false,
											"开始日期")))
							.addNode(new FieldNode("EndDate",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "EndDate", 10, 0, false,
											"截止日期")))
							.addNode(new FieldNode("Flag",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "Flag", 10, 0, false,
											"查询交易类型")))
							.addNode(new FieldNode("OffSet",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 10, 0, false,
											"定位串")))
							.addNode(new FieldNode("QueryNum", new MsgField(ContentEnum.MessageType.STRING.toString(),
									"QueryNum", 10, 0, false, "查询行数"))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100606_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",false,"APPBody")
					.addNode(new FieldNode("TotNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNum", 10,0, false, "总行数" )))
					.addNode(new FieldNode("RetNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "RetNum", 10,0, false, "本次返回行数" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 10,0, false, "定位串" )))
					
					.addNode(new ArrayNode("bodrcd",true,"tran_list")
						.addNode(new FieldNode("OccurInitDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "OccurInitDate", 10,0, false, "交易物理日期" )))
						.addNode(new FieldNode("TransDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransDate", 10,0, false, "交易日期" )))
						.addNode(new FieldNode("TransTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransTime", 10,0, false, "交易时间" )))
						.addNode(new FieldNode("BankAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankAcc", 40,0, false, "银行账号" )))
						.addNode(new FieldNode("TACode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TACode", 10,0, false, "TA代码" )))
						.addNode(new FieldNode("TAShortName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TAShortName", 10,0, false, "TA简称" )))
						.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 10,0, false, "产品代码" )))
						.addNode(new FieldNode("PrdName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdName", 10,0, false, "产品名称" )))
						.addNode(new FieldNode("CurrType", new MsgField(ContentEnum.MessageType.STRING.toString(), "CurrType", 10,0, false, "币种" )))
						.addNode(new FieldNode("Amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Amt", 10,0, false, "金额" )))
						.addNode(new FieldNode("Vol", new MsgField(ContentEnum.MessageType.STRING.toString(), "Vol", 10,0, false, "份额" )))
						.addNode(new FieldNode("TransCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransCode", 10,0, false, "交易代码" )))
						.addNode(new FieldNode("TransName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransName", 10,0, false, "交易名称" )))
						.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 10,0, false, "交易状态" )))
						.addNode(new FieldNode("StatusName", new MsgField(ContentEnum.MessageType.STRING.toString(), "StatusName", 10,0, false, "交易状态名称" )))
						.addNode(new FieldNode("DealStatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "DealStatus", 10,0, false, "处理状态" )))
						.addNode(new FieldNode("Amt1", new MsgField(ContentEnum.MessageType.STRING.toString(), "Amt1", 10,0, false, "发起金额" )))
						.addNode(new FieldNode("Summary", new MsgField(ContentEnum.MessageType.STRING.toString(), "Summary", 10,0, false, "备注" )))
					));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
