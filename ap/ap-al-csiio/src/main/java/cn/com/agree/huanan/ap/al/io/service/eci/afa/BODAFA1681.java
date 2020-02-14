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
 * BASESVC BODAFA1681  回单机管理信息维护 
 *  BODAFA1681 8815706
 *  综合前置
 * @author XXX
 */
@Component
public class BODAFA1681 extends EciChannelService {

	private static BODAFA1681_I i = new BODAFA1681_I();
	private static BODAFA1681_O o = new BODAFA1681_O();
	public BODAFA1681() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1681_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 1024,0, false, "账号" )))
					.addNode(new FieldNode("dealmode", new MsgField(ContentEnum.MessageType.STRING.toString(), "dealmode", 1024,0, false, "扣款方式" )))
					.addNode(new FieldNode("dealacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dealacctno", 1024,0, false, "缴费账号" )))
					.addNode(new FieldNode("operator", new MsgField(ContentEnum.MessageType.STRING.toString(), "operator", 1024,0, false, "经办人" )))
					.addNode(new FieldNode("operatoridtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatoridtype", 1024,0, false, "经办人证件类型" )))
					.addNode(new FieldNode("operatorid", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatorid", 1024,0, false, "经办人证件号码" )))
					.addNode(new FieldNode("operatorphone", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatorphone", 1024,0, false, "经办人手机" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1681_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("clientserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "clientserialno", 1024,0, false, "前端流水" )))
					.addNode(new FieldNode("hostserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "hostserialno", 1024,0, false, "核心流水" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

