package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciF10ChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODF510313  预填单基础信息查询 
 *  BODF510313 regflw
 *  综合前置
 * @author LSJ
 */
@Component
public class BODF510313 extends EciF10ChannelService {

	private static BODF510313_I i = new BODF510313_I();
	private static BODF510313_O o = new BODF510313_O();
	public BODF510313() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF510313_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("gsdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsdm", 4,0, true, "公司代码" )))
					.addNode(new FieldNode("cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpdm", 10,0, true, "产品代码" )))
					.addNode(new FieldNode("tbrzjlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrzjlx", 1,0, false, "投保人证件类型" )))
					.addNode(new FieldNode("tbrzjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrzjhm", 32,0, false, "投保人证件号码" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 10,0, true, "列表起始值" )))
					.addNode(new FieldNode("QueryNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "QueryNum", 10,0, true, "每页最大行数" )))
					.addNode(new FieldNode("cxqd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cxqd", 10,0, false, "查询渠道(多个渠道用“,”分割)" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF510313_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("retNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "RetNum", 10,0, true, "查询行数" )))
					.addNode(new FieldNode("totNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNum", 10,0, true, "总行数" )))
					.addNode(new FieldNode("offSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 10,0, true, "定位串" )))
					.addNode(new ArrayNode("bodrcd",true,"detail_list")
							.addNode(new FieldNode("ytdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ytdh", 32,0, true, "预填单号" )))
							.addNode(new FieldNode("jyrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyrq", 8,0, true, "预填日期" )))
							.addNode(new FieldNode("jysj", new MsgField(ContentEnum.MessageType.STRING.toString(), "jysj", 8,0, true, "预填时间" )))
							.addNode(new FieldNode("gsdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsdm", 4,0, true, "公司代码" )))
							.addNode(new FieldNode("cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpdm", 9,0, true, "产品代码" )))
							.addNode(new FieldNode("tbrxm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrxm", 50,0, true, "投保人姓名" )))
							.addNode(new FieldNode("tbrzjlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrzjlx", 1,0, true, "投保人证件类型" )))
							.addNode(new FieldNode("tbrzjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrzjhm", 30,0, true, "投保人证件号码" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

