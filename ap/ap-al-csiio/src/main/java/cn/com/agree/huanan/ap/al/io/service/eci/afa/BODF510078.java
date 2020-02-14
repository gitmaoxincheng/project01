package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciF10ChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODF510078  预填单新增 
 *  BODF510078 regflw
 *  综合前置
 * @author XZF
 */
@Component
public class BODF510078 extends EciF10ChannelService {

	private static BODF510078_I i = new BODF510078_I();
	private static BODF510078_O o = new BODF510078_O();
	public BODF510078() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF510078_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("gsdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsdm", 4,0, true, "公司代码" )))
					.addNode(new FieldNode("cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpdm", 10,0, true, "产品代码" )))
					.addNode(new FieldNode("ytdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ytdh", 30,0, true, "预填单号" )))
					.addNode(new FieldNode("jsonstr", new MsgField(ContentEnum.MessageType.STRING.toString(), "jsonstr", Integer.MAX_VALUE,0, true, "预填单JSON字符串" )))
					.addNode(new FieldNode("tbrxm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrxm", 50,0, true, "投保人姓名" )))
					.addNode(new FieldNode("tbrzjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrzjhm", 30,0, true, "投保人证件号码" )))
					.addNode(new FieldNode("tbrzjlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrzjlx", 5,0, true, "投保人证件类型" )))
					.addNode(new FieldNode("bbrxm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrxm", 50,0, true, "被保人姓名" )))
					.addNode(new FieldNode("bbrzjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrzjhm", 30,0, true, "被保人证件号码" )))
					.addNode(new FieldNode("bbrzjlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrzjlx", 5,0, true, "被保人证件类型" )))
					.addNode(new FieldNode("vaildDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "vaildDate", 8,0, true, "预填单有效日期" )))
					.addNode(new FieldNode("modifyFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "modifyFlag", 8,0, false, "修改标志" )))
					.addNode(new FieldNode("bxxxsyrgs", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxsyrgs", 2,0, true, "收益人个数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF510078_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

