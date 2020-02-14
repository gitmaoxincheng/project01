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
 * BASESVC BODF100387  周期方案查询
 * BODF100387 100387 regflw
 *  综合前置
 * @author zhonggp
 */
@Component
public class BODF100387 extends EciF10ChannelService {
	/*


	 */
	private static BODF100387_I i = new BODF100387_I();
	private static BODF100387_O o = new BODF100387_O();

	public BODF100387() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100387_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 20,0, true, "产品代码" )))
					.addNode(new FieldNode("StartDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "StartDate", 10,0, false, "开始日期" )))
					.addNode(new FieldNode("EndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "EndDate", 30,0, false, "结束日期" )))
					.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 1,0, false, "周期处理状态" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 10,0, true, "定位串" )))
					.addNode(new FieldNode("QueryNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "QueryNum", 10,0, true, "查询行数" )))
					.addNode(new FieldNode("OrderDateFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "OrderDateFlag", 1,0, false, "排序日期标志" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODF100387_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("RetNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "RetNum", 10,0, true, "查询行数" )))
					.addNode(new FieldNode("TotNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNum", 10,0, true, "总行数" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 10,0, true, "定位串" )))
					.addNode(new ArrayNode("bodrcd", true,"period_list")
							.addNode(new FieldNode("PrdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdCode", 32,0, true, "产品代码" )))
							.addNode(new FieldNode("PrdName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdName", 8,0, true, "产品名称" )))
							.addNode(new FieldNode("CycleDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "CycleDate", 8,0, true, "周期到期日" )))
							.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 4,0, true, "周期处理状态" )))
							.addNode(new FieldNode("DealDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "DealDate", 9,0, true, "实际处理日" )))
							.addNode(new FieldNode("Reserve1", new MsgField(ContentEnum.MessageType.STRING.toString(), "Reserve1", 50,0, true, "备用字段1" )))
							.addNode(new FieldNode("Reserve2", new MsgField(ContentEnum.MessageType.STRING.toString(), "Reserve2", 1,0, true, "备用字段2" )))
							.addNode(new FieldNode("Reserve3", new MsgField(ContentEnum.MessageType.STRING.toString(), "Reserve3", 30,0, true, "备用字段3" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
