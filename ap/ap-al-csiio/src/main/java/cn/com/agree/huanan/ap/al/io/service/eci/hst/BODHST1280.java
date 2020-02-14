package cn.com.agree.huanan.ap.al.io.service.eci.hst;

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
@Component
public class BODHST1280 extends EciChannelService {

	private static BODHST1280_I i = new BODHST1280_I();
	private static BODHST1280_O o = new BODHST1280_O();
	public BODHST1280() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODHST1280_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("qrdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "qrdate", 8,0, false, "查询日期" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 40,0, false, "数组条数" )))
					.addNode(new FieldNode("adtpid", new MsgField(ContentEnum.MessageType.STRING.toString(), "adtpid", 80,0, false, "计数代码" )))
					.addNode(new FieldNode("objcid", new MsgField(ContentEnum.MessageType.STRING.toString(), "objcid", 80,0, false, "计数对象" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODHST1280_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 300,0, false, "出错信息" )))
					.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq", 80,0, false, "报文流水" )))
					.addNode(new FieldNode("script", new MsgField(ContentEnum.MessageType.STRING.toString(), "script", 255, 0, false, "出错脚本")))
					.addNode(new FieldNode("rtcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "rtcode", 80,0, false, "出错脚本" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 20, 0, false, "数组条数")))
					.addNode(new FieldNode("adtpid", new MsgField(ContentEnum.MessageType.STRING.toString(), "adtpid", 8,0, false, "已累计金额" )))
					.addNode(new FieldNode("limtam", new MsgField(ContentEnum.MessageType.STRING.toString(), "limtam", 20, 0, false, "限制金额（阀值）")))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}



}

