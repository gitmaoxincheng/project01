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
 * S0130034.03 操作员注册信息查询  交易码：opersys_regquery
 * @author lixq 
 */
@Component
public class S013003403 extends EsbChannelService {

	private static S013003403_I i = new S013003403_I();
	private static S013003403_O o = new S013003403_O();
	public S013003403() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	
	public static class S013003403_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			
			StructNode BODY = new StructNode("APPBody");
			FieldNode mybank = new FieldNode("mybank", new MsgField(ContentEnum.MessageType.STRING.toString(), "mybank", 3,0, true, "法人号"));
			FieldNode tellerno = new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno", 10,0, false, "操作员号" ));
			FieldNode sysid = new FieldNode("sysid", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysid", 4,0, true, "系统编号" ));

			BODY.addNode(mybank);
			BODY.addNode(tellerno);
			BODY.addNode(sysid);
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
	
	public static class S013003403_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			StructNode  BODY= new StructNode("APPBody");
			BODY.addNode(new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno", 10,0, false, "操作员号")));
			BODY.addNode(new FieldNode("oidno", new MsgField(ContentEnum.MessageType.STRING.toString(), "oidno", 30,0, false, "旧人事编号")));
			BODY.addNode(new FieldNode("otellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "otellerno", 200,0, false, "旧操作员号")));
			BODY.addNode(new FieldNode("telna", new MsgField(ContentEnum.MessageType.STRING.toString(), "telna", 60,0, false, "操作员姓名")));
			BODY.addNode(new FieldNode("teltp", new MsgField(ContentEnum.MessageType.STRING.toString(), "teltp", 2,0, false, "操作员类型")));
			BODY.addNode(new FieldNode("telst", new MsgField(ContentEnum.MessageType.STRING.toString(), "telst", 2,0, false, "操作员状态")));
			BODY.addNode(new FieldNode("mybank", new MsgField(ContentEnum.MessageType.STRING.toString(), "mybank", 3,0, false, "法人号")));
			BODY.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 2,0, false, "证件类型")));
			BODY.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, false, "证件号码")));
			BODY.addNode(new FieldNode("isps", new MsgField(ContentEnum.MessageType.STRING.toString(), "isps", 40,0, false, "内网邮箱")));
			BODY.addNode(new FieldNode("otps", new MsgField(ContentEnum.MessageType.STRING.toString(), "otps", 40,0, false, "外网邮箱")));
			BODY.addNode(new FieldNode("phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone", 30,0, false, "手机号码")));
			BODY.addNode(new FieldNode("teleno", new MsgField(ContentEnum.MessageType.STRING.toString(), "teleno", 20,0, false, "座机号码")));
			BODY.addNode(new FieldNode("teleext", new MsgField(ContentEnum.MessageType.STRING.toString(), "teleext", 10,0, false, "座机短号")));
			
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
}
