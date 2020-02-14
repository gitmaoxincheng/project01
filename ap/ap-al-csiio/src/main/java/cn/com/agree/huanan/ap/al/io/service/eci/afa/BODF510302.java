package cn.com.agree.huanan.ap.al.io.service.eci.afa;

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
 * BASESVC BODF510302  保险公司信息查询 
 *  BODF510302 regflw
 *  综合前置
 * @author XZF
 */
@Component
public class BODF510302 extends EciChannelService {

	private static BODF510302_I i = new BODF510302_I();
	private static BODF510302_O o = new BODF510302_O();
	public BODF510302() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF510302_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("gsdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsdm", 9,0, false, "公司代码" )))
					.addNode(new FieldNode("offset", new MsgField(ContentEnum.MessageType.STRING.toString(), "offset", 15,0, false, "定位串" )))
					.addNode(new FieldNode("querynum", new MsgField(ContentEnum.MessageType.STRING.toString(), "querynum", 15,0, false, "查询行数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF510302_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("totnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totnum", 15,0, false, "总行数" )))
					.addNode(new FieldNode("retnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "retnum", 15,0, false, "本次返回行数" )))
					.addNode(new FieldNode("offset", new MsgField(ContentEnum.MessageType.STRING.toString(), "offset", 15,0, false, "定位串" )))
					.addNode(new ArrayNode("bodrcd",true,"gs_list")
							.addNode(new FieldNode("gsdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsdm", 9,0, false, "公司代码" )))
							.addNode(new FieldNode("gsmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsmc", 60,0, false, "公司名称" )))
							.addNode(new FieldNode("gsjc", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsjc", 20,0, false, "公司简称" )))
							.addNode(new FieldNode("gslb", new MsgField(ContentEnum.MessageType.STRING.toString(), "gslb", 2,0, false, "公司类别" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

