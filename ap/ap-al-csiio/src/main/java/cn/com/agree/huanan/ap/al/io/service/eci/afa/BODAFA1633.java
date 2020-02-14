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
 * BASESVC BODAFA1633  手机银行活体标志查询
 * BODAFA1633  
 *  综合前置
 * @author ouyang
 */
@Component
public class BODAFA1633 extends EciChannelService{
	private static BODAFA1633_I i = new BODAFA1633_I();
	private static BODAFA1633_O o = new BODAFA1633_O();
	
	
	public BODAFA1633() {
		super();
		requestFormat.add(i);
		responseFormat.add(o);
	}
	public static class BODAFA1633_I extends MsgBody{
		private static MsgSegment msgSegment = init();
		private static MsgSegment init() {
    	   MsgSegment messageNode = new MsgSegment();
    	   messageNode.addStructNode(new StructNode("APPBody", true, "Body")
    			   .addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 50, 0, false, "姓名")))
    			   .addNode(new FieldNode("idcode",new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 40, 0, false, "证件号码")))
    	           .addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 1, 0, false, "证件类型"))));
           return messageNode;
       }
		
		@Override
		public ArrayList<Node> listNode() {
			// TODO 自动生成的方法存根
			return msgSegment.getNodeList();
		}
		
	}
	public static class BODAFA1633_O extends MsgBody{
		private static MsgSegment msgSegment = init();
		private static MsgSegment init() {
			MsgSegment msgSegment = new MsgSegment();
			msgSegment.addStructNode(new StructNode("Body", true, "APPBody")
			.addNode(new FieldNode("htflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "htflag", 1, 0, false, "活体标志")))
			.addNode(new FieldNode("mobilephone", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobilephone", 20, 0, false, "手机号码"))));
		    return msgSegment;
		}

		@Override
		public ArrayList<Node> listNode() {
			// TODO 自动生成的方法存根
			return msgSegment.getNodeList();
		}
		
	}

}
