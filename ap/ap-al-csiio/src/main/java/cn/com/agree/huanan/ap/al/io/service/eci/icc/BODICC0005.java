package cn.com.agree.huanan.ap.al.io.service.eci.icc;

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
 * 
 * @author zhuzc
 * BASESVC BODICC0005 IC卡圈存冲正
 * BODICC0005 ic1108
 * ATM
 */
@Component
public class BODICC0005 extends EciChannelService{
	private static BODICC0005_I i = new BODICC0005_I();
	private static BODICC0005_O o = new BODICC0005_O();
	public BODICC0005() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODICC0005_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf",1080,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("resultCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "resultCode",50,0, false, "脚本执行结果" )))
					.addNode(new FieldNode("origFrontSerialDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "origFrontSerialDate",40,0, false, "功能号" )))
					.addNode(new FieldNode("chelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "chelserno",16,0, false, "原IC卡平台交易流水号" )))
					.addNode(new FieldNode("queryflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "queryflag",1,0, false, "查询流水条件" )))

					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODICC0005_O extends MsgBody {
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
