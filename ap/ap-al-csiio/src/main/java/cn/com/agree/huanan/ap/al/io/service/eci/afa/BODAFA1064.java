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
 * BASESVC BODAFA1064  联网核查身份证 
 *  BODAFA1064 
 *  综合前端
 * @author XZF
 */
@Component
public class BODAFA1064 extends EciChannelService {

	private static BODAFA1064_I i = new BODAFA1064_I();
	private static BODAFA1064_O o = new BODAFA1064_O();
	public BODAFA1064() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1064_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 40,0, false, "身份证号" )))
					.addNode(new FieldNode("custnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "custnm", 60,0, false, "姓名" )))
					.addNode(new FieldNode("isforce", new MsgField(ContentEnum.MessageType.STRING.toString(), "isforce", 1,0, true, "是否强制向人行查询" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1064_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("queryresult", new MsgField(ContentEnum.MessageType.STRING.toString(), "queryresult", 2,0, false, "单笔核对结果" )))
					.addNode(new FieldNode("issueoffice", new MsgField(ContentEnum.MessageType.STRING.toString(), "issueoffice", 100,0, false, "签发机关" )))
					.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 60,0, false, "身份证号码" )))
					.addNode(new FieldNode("custnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "custnm", 40,0, false, "姓名" )))
					.addNode(new FieldNode("photo", new MsgField(ContentEnum.MessageType.STRING.toString(), "photo", 1024,0, false, "照片" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

