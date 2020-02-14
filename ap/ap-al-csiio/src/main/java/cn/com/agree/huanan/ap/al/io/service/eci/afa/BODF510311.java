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
 * BASESVC BODF510311  保险公司信息查询 
 *  BODF510311 regflw
 *  综合前置
 * @author XZF
 */
@Component
public class BODF510311 extends EciChannelService {

	private static BODF510311_I i = new BODF510311_I();
	private static BODF510311_O o = new BODF510311_O();
	public BODF510311() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF510311_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("gsdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsdm", 9,0, false, "公司代码" )))
					.addNode(new FieldNode("cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpdm", 12,0, false, "产品代码" )))
					.addNode(new FieldNode("fjxdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "fjxdm", 20,0, false, "附加险代码" )))
					.addNode(new FieldNode("cplx", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplx", 20,0, false, "产品类型" )))
					.addNode(new FieldNode("offset", new MsgField(ContentEnum.MessageType.STRING.toString(), "offset", 15,0, false, "定位串" )))
					.addNode(new FieldNode("querynum", new MsgField(ContentEnum.MessageType.STRING.toString(), "querynum", 15,0, false, "查询行数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF510311_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("totnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totnum", 15,0, false, "总行数" )))
					.addNode(new FieldNode("retnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "retnum", 15,0, false, "本次返回行数" )))
					.addNode(new FieldNode("offset", new MsgField(ContentEnum.MessageType.STRING.toString(), "offset", 15,0, false, "定位串" )))
					.addNode(new ArrayNode("bodrcd",true,"fjx_list")
							.addNode(new FieldNode("gsdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsdm", 6,0, false, "公司代码" )))
							.addNode(new FieldNode("gsmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsmc", 60,0, false, "公司名称" )))
							.addNode(new FieldNode("cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpdm", 20,0, false, "产品代码" )))
							.addNode(new FieldNode("cpmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpmc", 250,0, false, "产品名称" )))
							.addNode(new FieldNode("cplx", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplx", 1,0, false, "产品类型" )))
							.addNode(new FieldNode("fjxdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "fjxdm", 20,0, false, "附加险代码" )))
							.addNode(new FieldNode("fjxmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "fjxmc", 50,0, false, "附加险名称" )))
							.addNode(new FieldNode("gsfjxdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsfjxdm", 32,0, false, "保险公司附加险代码" )))
							.addNode(new FieldNode("jsfs", new MsgField(ContentEnum.MessageType.STRING.toString(), "jsfs", 1,0, false, "保费计算方式" )))
							.addNode(new FieldNode("sffj", new MsgField(ContentEnum.MessageType.STRING.toString(), "sffj", 1,0, false, "是否必须附加" )))
							.addNode(new FieldNode("jfnqlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "jfnqlx", 1,0, false, "缴费年期类型" )))
							.addNode(new FieldNode("jfnq", new MsgField(ContentEnum.MessageType.STRING.toString(), "jfnq", 20,0, false, "缴费年期" )))
							.addNode(new FieldNode("bznqlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "bznqlx", 1,0, false, "保障年期类型" )))
							.addNode(new FieldNode("bznq", new MsgField(ContentEnum.MessageType.STRING.toString(), "bznq", 20,0, false, "保障年期" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

