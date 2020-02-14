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
 * BASESVC BODNIB0130 银保保险产品说明书查询 银保保险产品说明书查询
 * BODNIB0130 gryb04 regflw
 *  渠道整合
 * @author JZF
 */
@Component
public class BODNIB0130 extends EciChannelService {


	private static BODNIB0130_I i = new BODNIB0130_I();
	private static BODNIB0130_O o = new BODNIB0130_O();

	public BODNIB0130() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNIB0130_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("action", new MsgField(ContentEnum.MessageType.STRING.toString(), "action", 1024,0, true, "处理码" )))
					.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 1024,0, true, "上送渠道" )))
					.addNode(new FieldNode("prdcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdcode", 1024,0, true, "产品代码（主险代码）" )))
					.addNode(new FieldNode("itemflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "itemflag", 1024,0, true, "是否是产品条款" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODNIB0130_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new ArrayNode("bodrcd", true,"instructions_list")
							.addNode(new FieldNode("prdcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdcode", 1024,0, true, "产品代码" )))
							.addNode(new FieldNode("filename", new MsgField(ContentEnum.MessageType.STRING.toString(), "filename", 1024,0, true, "文件名字" )))
							.addNode(new FieldNode("introduction", new MsgField(ContentEnum.MessageType.STRING.toString(), "introduction", 1024,0, true, "保险产品简介" )))
							.addNode(new FieldNode("filepath", new MsgField(ContentEnum.MessageType.STRING.toString(), "filepath", 1024,0, true, "路径地址" )))
							.addNode(new FieldNode("itemflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "itemflag", 1024,0, true, "是否是说明书类型文件" )))
							).addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 1024,0, true, "返回条数" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
