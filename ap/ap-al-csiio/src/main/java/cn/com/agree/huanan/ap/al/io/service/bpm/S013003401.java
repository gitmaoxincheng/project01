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
 * BASESVC.S013003401 系统操作员信息查询.操作员信息查询 
 * S0130034.01 oper_query
 * 0321 参数管理平台
 * @author CZP
 */
@Component
public class S013003401 extends EsbChannelService {

	private static S013003401_I i = new S013003401_I();
	private static S013003401_O o = new S013003401_O();

	public S013003401() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013003401_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("mybank", new MsgField(ContentEnum.MessageType.STRING.toString(), "mybank", 3,0, true, "法人号" )))
					.addNode(new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno", 10,0, false, "操作员号" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 3,0, false, "操作员证件类型" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, false, "操作员证件号" )))
					.addNode(new FieldNode("telst", new MsgField(ContentEnum.MessageType.STRING.toString(), "telst", 1,0, false, "操作员状态" )))
					.addNode(new FieldNode("teltp", new MsgField(ContentEnum.MessageType.STRING.toString(), "teltp", 2,0, false, "操作员类型" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S013003401_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno", 10,0, false, "操作员号" )))
					.addNode(new FieldNode("oidno", new MsgField(ContentEnum.MessageType.STRING.toString(), "oidno", 30,0, false, "旧人事编号" )))
					.addNode(new FieldNode("otellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "otellerno", 200,0, false, "旧操作员号" )))
					.addNode(new FieldNode("telna", new MsgField(ContentEnum.MessageType.STRING.toString(), "telna", 256,0, false, "操作员姓名" )))
					.addNode(new FieldNode("teltp", new MsgField(ContentEnum.MessageType.STRING.toString(), "teltp", 2,0, false, "操作员类型" )))
					.addNode(new FieldNode("telst", new MsgField(ContentEnum.MessageType.STRING.toString(), "telst", 1,0, false, "操作员状态" )))
					.addNode(new FieldNode("mybank", new MsgField(ContentEnum.MessageType.STRING.toString(), "mybank", 3,0, false, "法人号" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 3,0, false, "证件类型" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("isps", new MsgField(ContentEnum.MessageType.STRING.toString(), "isps", 40,0, false, "内网邮箱" )))
					.addNode(new FieldNode("otps", new MsgField(ContentEnum.MessageType.STRING.toString(), "otps", 40,0, false, "外网邮箱" )))
					.addNode(new FieldNode("phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone", 20,0, false, "手机号码" )))
					.addNode(new FieldNode("phoneext", new MsgField(ContentEnum.MessageType.STRING.toString(), "phoneext", 20,0, false, "手机短号" )))
					.addNode(new FieldNode("teleno", new MsgField(ContentEnum.MessageType.STRING.toString(), "teleno", 20,0, false, "座机号码" )))
					.addNode(new FieldNode("teleext", new MsgField(ContentEnum.MessageType.STRING.toString(), "teleext", 10,0, false, "座机短号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
