package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODIBIS007  查询客户图片 
 *  BODIBIS007 params
 *  综合前置
 * @author XZF
 */
@Component
public class BODIBIS007 extends EciChannelService {

	private static BODIBIS007_I i = new BODIBIS007_I();
	private static BODIBIS007_O o = new BODIBIS007_O();
	public BODIBIS007() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODIBIS007_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("methodName", new MsgField(ContentEnum.MessageType.STRING.toString(), "methodName", 32,0, false, "方法名" )))
					.addNode(new FieldNode("cType", new MsgField(ContentEnum.MessageType.STRING.toString(), "cType", 16,0, false, "证件类型" )))
					.addNode(new FieldNode("cId", new MsgField(ContentEnum.MessageType.STRING.toString(), "cId", 20,0, false, "证件号码" )))
					.addNode(new FieldNode("cName", new MsgField(ContentEnum.MessageType.STRING.toString(), "cName", 16,0, false, "证件姓名" )))
					.addNode(new FieldNode("imgFlowNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "imgFlowNo", 32,0, true, "人脸识别平台流水号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODIBIS007_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("code", new MsgField(ContentEnum.MessageType.STRING.toString(), "code", 16,0, false, "处理状态" )))
					.addNode(new FieldNode("message", new MsgField(ContentEnum.MessageType.STRING.toString(), "message", 127,0, false, "返回信息" )))
					.addNode(new FieldNode("custImg", new MsgField(ContentEnum.MessageType.STRING.toString(), "custImg", 1024,0, false, "客户图片" )))
					.addNode(new FieldNode("img1", new MsgField(ContentEnum.MessageType.STRING.toString(), "img1", 1024,0, false, "现场照" )))
					.addNode(new FieldNode("img2", new MsgField(ContentEnum.MessageType.STRING.toString(), "img2", 1024,0, false, "联网核查照或人脸底库照" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

