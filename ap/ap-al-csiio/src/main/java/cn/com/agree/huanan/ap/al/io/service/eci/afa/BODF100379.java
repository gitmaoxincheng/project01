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
 * BASESVC BODF100379  约定书查询 
 *  BODF100379 regflw
 *  综合前置
 * @author XZF
 */
@Component
public class BODF100379 extends EciF10ChannelService {

	private static BODF100379_I i = new BODF100379_I();
	private static BODF100379_O o = new BODF100379_O();
	public BODF100379() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100379_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("AccType", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccType", 1,0, true, "客户标识类型" )))
					.addNode(new FieldNode("Account", new MsgField(ContentEnum.MessageType.STRING.toString(), "Account", 32,0, true, "客户标识" )))
					.addNode(new FieldNode("IdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 6,0, true, "证件类型" )))
					.addNode(new FieldNode("PrdManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdManager", 40,0, false, "产品管理人" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 10,0, true, "定位串" )))
					.addNode(new FieldNode("QueryNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "QueryNum", 10,0, true, "查询行数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100379_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("TotNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNum", 10,0, false, "总行数" )))
					.addNode(new FieldNode("RetNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "RetNum", 10,0, false, "本次返回行数" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 10,0, false, "定位串" )))
					.addNode(new StructNode("bodrcd",true)
							.addNode(new FieldNode("SerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "SerialNo", 30,0, false, "系统流水号" )))
							.addNode(new FieldNode("InClientNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "InClientNo", 10,0, false, "客户编号" )))
							.addNode(new FieldNode("ClientName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientName", 100,0, false, "客户名称" )))
							.addNode(new FieldNode("PrdManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdManager", 40,0, false, "产品管理人代码" )))
							.addNode(new FieldNode("PrdManagerName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdManagerName", 40,0, false, "管理人名称" )))
							.addNode(new FieldNode("TransDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransDate", 8,0, false, "签署日期" )))
							.addNode(new FieldNode("TransTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransTime", 6,0, false, "签署时间" )))
							.addNode(new FieldNode("OperNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "OperNo", 10,0, false, "柜员号" )))
							.addNode(new FieldNode("Channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "Channel", 3,0, false, "交易渠道" )))
							.addNode(new FieldNode("BranchNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BranchNo", 10,0, false, "交易机构" )))
							.addNode(new FieldNode("CloseDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "CloseDate", 8,0, false, "取消日期" )))
							.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 2,0, false, "合同状态" )))
							.addNode(new FieldNode("StatusName", new MsgField(ContentEnum.MessageType.STRING.toString(), "StatusName", 100,0, false, "状态名称" )))
							.addNode(new FieldNode("IdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 6,0, false, "证件类型" )))
							.addNode(new FieldNode("IdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdCode", 18,0, false, "证件号码" )))
							.addNode(new FieldNode("AgreeType", new MsgField(ContentEnum.MessageType.STRING.toString(), "AgreeType", 10,0, false, "协议类型" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

