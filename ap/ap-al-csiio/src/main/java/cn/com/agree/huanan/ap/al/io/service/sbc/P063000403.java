package cn.com.agree.huanan.ap.al.io.service.sbc;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbSbcChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P063000403 缴费信息查询.易缴通缴费信息查询 
 * P0630004.03 OR3202
 * 0212 金融互联网服务平台
 * @author LW
 */
@Component
public class P063000403 extends EsbSbcChannelService {
	/*


	 */
	private static P063000403_I i = new P063000403_I();
	private static P063000403_O o = new P063000403_O();
	public P063000403() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P063000403_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cstnumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstnumber", 50,0, true, "缴费人标识" )))
					.addNode(new FieldNode("merid", new MsgField(ContentEnum.MessageType.STRING.toString(), "merid", 100,0, true, "商户id" )))
					.addNode(new FieldNode("billingitemid", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingitemid", 100,0, true, "项目id" )))
					.addNode(new FieldNode("starttime", new MsgField(ContentEnum.MessageType.STRING.toString(), "starttime", 10,0, false, "缴费开始时间校验" )))
					.addNode(new FieldNode("endtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "endtime", 10,0, false, "缴费结束时间校验" )))
					.addNode(new ArrayNode("orderstatuslist_list",false)
							.addNode(new FieldNode("orderstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "orderstatus", 4,0, true, "缴费状态" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P063000403_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("billingstatistics_list",false)
							.addNode(new FieldNode("billingitemid", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingitemid", 100,0, false, "项目id" )))
							.addNode(new FieldNode("billingitemname", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingitemname", 255,0, false, "项目名称" )))
							.addNode(new FieldNode("billingdetailid", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingdetailid", 100,0, false, "费用id" )))
							.addNode(new FieldNode("orderstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "orderstatus", 4,0, false, "订单状态" )))
							.addNode(new FieldNode("must", new MsgField(ContentEnum.MessageType.STRING.toString(), "must", 4,0, false, "是否必缴" )))
							.addNode(new FieldNode("billingdetailname", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingdetailname", 255,0, false, "费用名称" )))
							.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.INT.toString(), "amount", 19,2, false, "金额" )))
							.addNode(new FieldNode("ordid", new MsgField(ContentEnum.MessageType.STRING.toString(), "ordid", 100,0, false, "订单id" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

