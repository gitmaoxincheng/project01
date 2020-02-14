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
 * BASESVC BODAFA1617  批量代扣批次下载次数更新 
 *  BODAFA1617 
 *  综合前置
 * @author YFK
 */
@Component
public class BODAFA1617 extends EciChannelService{

	
	private static BODAFA1617_I i = new BODAFA1617_I();
	private static BODAFA1617_O o = new BODAFA1617_O();
	public BODAFA1617() {
		requestFormat.add(i);
		responseFormat.add(o);
	}
	
	public static class BODAFA1617_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("subtradedate",new MsgField(ContentEnum.MessageType.STRING.toString(),"subtradedate" ,8,0, false, "子批次日期" )))
					.addNode(new FieldNode("subserialno",new MsgField(ContentEnum.MessageType.STRING.toString(),"subserialno" ,10,0, false, "子批次流水" )))					
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	
	public static class BODAFA1617_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
}
