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
 * BASESVC.P063000404 缴费信息查询.易缴通缴费项目查询 
 * P0630004.04 OR3206
 * 0212 金融互联网服务平台
 * @author LW
 */
@Component
public class P063000404 extends EsbSbcChannelService {
	/*


	 */
	private static P063000404_I i = new P063000404_I();
	private static P063000404_O o = new P063000404_O();
	public P063000404() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P063000404_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cstnumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstnumber", 50,0, false, "缴费人标识" )))
					.addNode(new FieldNode("merid", new MsgField(ContentEnum.MessageType.STRING.toString(), "merid", 100,0, false, "商户id" )))
					.addNode(new FieldNode("pageno", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageno", 5,0, true, "当前页" )))
					.addNode(new FieldNode("pagesize", new MsgField(ContentEnum.MessageType.STRING.toString(), "pagesize", 5,0, true, "每页记录数" )))
					.addNode(new FieldNode("now", new MsgField(ContentEnum.MessageType.STRING.toString(), "now", 20,0, false, "当前时间" )))
					.addNode(new FieldNode("billingitemname", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingitemname", 255,0, false, "项目名称" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P063000404_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("totalsize", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalsize", 10,0, false, "总条数" )))
					.addNode(new ArrayNode("billingitemlist_list",false)
							.addNode(new FieldNode("billingitemid", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingitemid", 100,0, false, "项目id" )))
							.addNode(new FieldNode("billingitemname", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingitemname", 255,0, false, "项目名称" )))
							.addNode(new FieldNode("payamount", new MsgField(ContentEnum.MessageType.INT.toString(), "payamount", 19,2, false, "已缴金额" )))
							.addNode(new FieldNode("mustamount", new MsgField(ContentEnum.MessageType.INT.toString(), "mustamount", 19,2, false, "必缴未缴金额" )))
							.addNode(new FieldNode("nomustamount", new MsgField(ContentEnum.MessageType.INT.toString(), "nomustamount", 19,2, false, "非必缴未缴金额" )))
							.addNode(new FieldNode("endtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "endtime", 20,0, false, "缴费结束时间" )))
							.addNode(new FieldNode("fullname", new MsgField(ContentEnum.MessageType.STRING.toString(), "fullname", 100,0, false, "完整机构名称" )))
							.addNode(new FieldNode("payername", new MsgField(ContentEnum.MessageType.STRING.toString(), "payername", 100,0, false, "缴费人姓名" )))
							.addNode(new FieldNode("phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone", 100,0, false, "手机号" )))
							.addNode(new FieldNode("cstnumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstnumber", 50,0, false, "缴费人标识" )))
							.addNode(new FieldNode("starttime", new MsgField(ContentEnum.MessageType.STRING.toString(), "starttime", 10,0, false, "缴费开始时间" )))
							.addNode(new FieldNode("orderstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "orderstatus", 4,0, false, "缴费状态" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

