package cn.com.agree.huanan.ap.al.io.service.eci.nib;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODNIB0134  费用名称查询 
 *  BODNIB0134 regflw
 *  新个人网银
 * @author XZF
 */
@Component
public class BODNIB0134 extends EciChannelService {

	private static BODNIB0134_I i = new BODNIB0134_I();
	private static BODNIB0134_O o = new BODNIB0134_O();
	public BODNIB0134() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNIB0134_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("page", new MsgField(ContentEnum.MessageType.STRING.toString(), "page", 1024,0, true, "当前页数" )))
					.addNode(new FieldNode("sizes", new MsgField(ContentEnum.MessageType.STRING.toString(), "sizes", 1024,0, true, "每页记录数" )))
					.addNode(new FieldNode("billingname", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingname", 1024,0, true, "费用名称" )))
					.addNode(new FieldNode("schcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "schcode", 1024,0, true, "学校id" )))
					.addNode(new FieldNode("billitemid", new MsgField(ContentEnum.MessageType.STRING.toString(), "billitemid", 1024,0, true, "项目id" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODNIB0134_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("cichannelserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cichannelserialno", 1024,0, true, "渠道流水号" )))
					.addNode(new FieldNode("returnmessage", new MsgField(ContentEnum.MessageType.STRING.toString(), "returnmessage", 1024,0, true, "响应消息" )))
					.addNode(new FieldNode("returncode", new MsgField(ContentEnum.MessageType.STRING.toString(), "returncode", 1024,0, true, "响应码" )))
					.addNode(new FieldNode("totalelements", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalelements", 1024,0, true, "总条数" )))
					.addNode(new FieldNode("sizes", new MsgField(ContentEnum.MessageType.STRING.toString(), "sizes", 1024,0, true, "每页记录数" )))
					.addNode(new FieldNode("number", new MsgField(ContentEnum.MessageType.STRING.toString(), "number", 1024,0, true, "当前页数" )))
					.addNode(new FieldNode("totalpages", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalpages", 1024,0, true, "总页数" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 1024,0, true, "当前页记录数" )))
					.addNode(new FieldNode("firstpage", new MsgField(ContentEnum.MessageType.STRING.toString(), "firstpage", 1024,0, true, "是否返回第一页" )))
					.addNode(new FieldNode("lastpage", new MsgField(ContentEnum.MessageType.STRING.toString(), "lastpage", 1024,0, true, "是否返回最后一页" )))
					.addNode(new ArrayNode("bodrcd",true)
							.addNode(new FieldNode("billingname", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingname", 1024,0, true, "费用名称" )))
							.addNode(new FieldNode("billingtypeid", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingtypeid", 1024,0, true, "费用id" )))
							.addNode(new FieldNode("billruletype", new MsgField(ContentEnum.MessageType.STRING.toString(), "billruletype", 1024,0, true, "缴费档次类型" )))
							.addNode(new FieldNode("enddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "enddate", 1024,0, true, "缴费截止日期" )))
							.addNode(new FieldNode("startdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "startdate", 1024,0, true, "缴费开始日期" )))
							.addNode(new FieldNode("remarkGrade", new MsgField(ContentEnum.MessageType.STRING.toString(), "remarkGrade", 1024,0, true, "金额档次备注" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

