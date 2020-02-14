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
 * BASESVC BODAFA1660  回单机追加签约 
 *  BODAFA1660 8815703
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1660 extends EciChannelService {

	private static BODAFA1660_I i = new BODAFA1660_I();
	private static BODAFA1660_O o = new BODAFA1660_O();
	public BODAFA1660() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1660_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("acctnoidtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctnoidtype", 3,0, false, "证件类型" )))
					.addNode(new FieldNode("acctnoid", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctnoid", 3,0, false, "证件号码" )))
					.addNode(new FieldNode("count", new MsgField(ContentEnum.MessageType.STRING.toString(), "count", 10,0, false, "账号数量" )))
					.addNode(new StructNode("acctnolist",true)
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 1024,0, false, "账号" )))
							.addNode(new FieldNode("dealmodelist", new MsgField(ContentEnum.MessageType.STRING.toString(), "dealmodelist", 1024,0, false, "缴费方式" )))
							.addNode(new FieldNode("dealacctnolist", new MsgField(ContentEnum.MessageType.STRING.toString(), "dealacctnolist", 1024,0, false, "缴费账号" )))
							.addNode(new FieldNode("dealacctnonamelist", new MsgField(ContentEnum.MessageType.STRING.toString(), "dealacctnonamelist", 1024,0, false, "缴费账号名称" )))
							).addNode(new FieldNode("operator", new MsgField(ContentEnum.MessageType.STRING.toString(), "operator", 220,0, false, "经办人" )))
					.addNode(new FieldNode("operatoridtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatoridtype", 3,0, false, "经办人证件类型" )))
					.addNode(new FieldNode("operatorid", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatorid", 32,0, false, "经办人证件号码" )))
					.addNode(new FieldNode("operatorphone", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatorphone", 32,0, false, "经办人手机" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1660_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

