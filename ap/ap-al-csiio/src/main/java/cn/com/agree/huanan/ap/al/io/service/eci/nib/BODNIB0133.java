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
 * BASESVC BODNIB0133  项目查询 
 *  BODNIB0133 
 *  新个人网银
 * @author XZF
 */
@Component
public class BODNIB0133 extends EciChannelService {

	private static BODNIB0133_I i = new BODNIB0133_I();
	private static BODNIB0133_O o = new BODNIB0133_O();
	public BODNIB0133() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNIB0133_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("page", new MsgField(ContentEnum.MessageType.STRING.toString(), "page", 1024,0, true, "当前页数" )))
					.addNode(new FieldNode("sizes", new MsgField(ContentEnum.MessageType.STRING.toString(), "sizes", 1024,0, true, "项目名称" )))
					.addNode(new FieldNode("billitemname", new MsgField(ContentEnum.MessageType.STRING.toString(), "billitemname", 1024,0, true, "产品代码（主险代码）" )))
					.addNode(new FieldNode("schcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "schcode", 1024,0, true, "学校id" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODNIB0133_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
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
					.addNode(new ArrayNode("bodrcd",false)
							.addNode(new FieldNode("billitemid", new MsgField(ContentEnum.MessageType.STRING.toString(), "billitemid", 1024,0, true, "项目id" )))
							.addNode(new FieldNode("billitemname", new MsgField(ContentEnum.MessageType.STRING.toString(), "billitemname", 1024,0, true, "项目名称" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

