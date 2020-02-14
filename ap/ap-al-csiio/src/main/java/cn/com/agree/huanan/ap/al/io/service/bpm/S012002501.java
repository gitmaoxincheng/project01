package cn.com.agree.huanan.ap.al.io.service.bpm;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * S0120025.01 操作员注册注销  交易码：sysoper_opst
 * @author lixq 
 */
@Component
public class S012002501 extends EsbChannelService {

	private static S012002501_I i = new S012002501_I();
	private static S012002501_O o = new S012002501_O();
	public S012002501() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	
	public static class S012002501_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			
			StructNode BODY = new StructNode("APPBody");
			FieldNode mybank = new FieldNode("mybank", new MsgField(ContentEnum.MessageType.STRING.toString(), "mybank", 3,0, true, "法人号"));
			FieldNode tellerno = new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno", 10,0, false, "操作员号" ));
			FieldNode sysid = new FieldNode("sysid", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysid", 4,0, true, "系统编号" ));
			FieldNode opertp = new FieldNode("opertp", new MsgField(ContentEnum.MessageType.STRING.toString(), "opertp", 1,0, true, "操作类型" ));
			
			BODY.addNode(mybank);
			BODY.addNode(tellerno);
			BODY.addNode(sysid);
			BODY.addNode(opertp);
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
	
	public static class S012002501_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			StructNode  BODY= new StructNode("APPBody");
			
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
}
