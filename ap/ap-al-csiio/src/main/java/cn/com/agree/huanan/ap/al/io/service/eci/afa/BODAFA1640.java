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
 * BASESVC BODAFA1640  开户影像查询
 * BODAFA1640 
 *  综合前置
 * @author ouyang
 */
@Component
public class BODAFA1640 extends EciChannelService{
    private static BODAFA1640_I i = new BODAFA1640_I();
    private static BODAFA1640_O o = new BODAFA1640_O();
    
	public BODAFA1640() {
		super();
		requestFormat.add(i);
		responseFormat.add(o);
	}
	public static class BODAFA1640_I extends MsgBody{
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
	public static class BODAFA1640_O extends MsgBody{
        private static MsgSegment msgSegment = init();
        private static MsgSegment init() {
        	MsgSegment messageNode = new MsgSegment();
        	messageNode.addStructNode(new StructNode("Body", true, "APPBody")
        	.addNode(new FieldNode("contentid", new MsgField(ContentEnum.MessageType.STRING.toString(), "contentid", 255, 0, false, "影像ID")))
        	.addNode(new FieldNode("BUSI_START_DATE", new MsgField(ContentEnum.MessageType.STRING.toString(), "BUSI_START_DATE", 8, 0, false, "业务开始日期")))
        	.addNode(new FieldNode("BUSI_SERIAL_NO", new MsgField(ContentEnum.MessageType.STRING.toString(), "BUSI_SERIAL_NO", 30, 0, false, "业务流水")))
        	.addNode(new FieldNode("MODELCODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "MODELCODE", 10, 0, false, "图片批次号")))
        	.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 10, 0, false, "记录数")))
        	.addNode(new ArrayNode("bodrcd",true,"file_list")
					.addNode(new FieldNode("FILE_ID", new MsgField(ContentEnum.MessageType.STRING.toString(), "FILE_ID", 60,0, false, "文件ID" )))
					));
        	return messageNode;
        }
		@Override
		public ArrayList<Node> listNode() {
			// TODO 自动生成的方法存根
			return msgSegment.getNodeList();
		}
		
	}
}
