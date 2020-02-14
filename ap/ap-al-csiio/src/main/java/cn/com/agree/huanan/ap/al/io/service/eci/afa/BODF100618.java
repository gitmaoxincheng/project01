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
 * BASESVC BODF100618 客户经理信息查询 客户经理信息查询
 * BODF100618 100618 regflw
 *  渠道整合
 * @author JZF
 */
@Component
public class BODF100618 extends EciF10ChannelService {

	private static BODF100618_I i = new BODF100618_I();
	private static BODF100618_O o = new BODF100618_O();

	public BODF100618() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100618_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("ClientManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientManager", 5,0, false, "客户经理编号" )))
					.addNode(new FieldNode("OriBranchNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "OriBranchNo", 8,0, false, "客户经理所属机构" )))
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

	public static class BODF100618_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("RetNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "RetNum", 10,0, true, "查询行数" )))
					.addNode(new FieldNode("TotNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNum", 10,0, true, "总行数" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 10,0, true, "定位串" )))
					.addNode(new ArrayNode("bodrcd", true,"mng_list")
							.addNode(new FieldNode("ClientManager", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientManager", 32,0, true, "客户经理编号" )))
							.addNode(new FieldNode("ManagerName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ManagerName", 8,0, true, "客户经理姓名" )))
							.addNode(new FieldNode("OriBranchNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "OriBranchNo", 8,0, true, "所属机构" )))
							.addNode(new FieldNode("PrdTypes", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdTypes", 4,0, true, "允许的业务类型" )))
							.addNode(new FieldNode("Mobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "Mobile", 9,0, true, "手机号码" )))
							.addNode(new FieldNode("Tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tel", 50,0, true, "电话号码" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
