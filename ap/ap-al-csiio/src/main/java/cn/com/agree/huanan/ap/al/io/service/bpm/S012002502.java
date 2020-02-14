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
 * S0120025.02 应用系统操作员登陆验证  交易码：sysoper_login
 * @author lixq 
 */
@Component
public class S012002502 extends EsbChannelService {

	private static S012002502_I i = new S012002502_I();
	private static S012002502_O o = new S012002502_O();
	public S012002502() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	
	public static class S012002502_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			
			//StructNode BODY = new StructNode("APPBody");
			//FieldNode tellerno = new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno", 10,0, false, "操作员号" ));
			//FieldNode sysid = new FieldNode("sysid", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysid", 4,0, true, "系统编号" ));
			//FieldNode mybank = new FieldNode("mybank", new MsgField(ContentEnum.MessageType.STRING.toString(), "mybank", 3,0, true, "法人号"));
			messageNode.addStructNode(new StructNode("APPBody",true)
			//FieldNode pwdtp = new FieldNode("pwdtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "pwdtp", 1,0, true, "认证类型" ));
			//FieldNode dctlra = new FieldNode("dctlra", new MsgField(ContentEnum.MessageType.STRING.toString(), "dctlra", 307200,0, false, "认证值" ));
					
			//BODY.addNode(mybank);
			//BODY.addNode(tellerno);
			//BODY.addNode(sysid);
			//BODY.addNode(pwdtp);
			//BODY.addNode(dctlra);
			//messageNode.addStructNode(BODY);
					.addNode(new FieldNode("pwdtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "pwdtp",1,0, false, "认证类型" )))
					.addNode(new FieldNode("dctlra", new MsgField(ContentEnum.MessageType.STRING.toString(), "dctlra",307200,0, false, "认证值" )))
					.addNode(new FieldNode("filedataone", new MsgField(ContentEnum.MessageType.STRING.toString(), "filedataone",204800,0, false, "生物文件1" )))
					.addNode(new FieldNode("fingertp", new MsgField(ContentEnum.MessageType.STRING.toString(), "fingertp",1,0, false, "指纹仪类型" )))
					.addNode(new FieldNode("manfttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "manfttype",1,0, false, "指纹厂商" )))
					.addNode(new FieldNode("sysid", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysid",4,0, false, "登陆系统" )))
					.addNode(new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno",10,0, false, "校验操作员号" )))
					.addNode(new FieldNode("reqip", new MsgField(ContentEnum.MessageType.STRING.toString(), "reqip",23,0, false, "发起IP" )))
					.addNode(new FieldNode("reqmac", new MsgField(ContentEnum.MessageType.STRING.toString(), "reqmac",45,0, false, "发起MAC" )))
					);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
	
	public static class S012002502_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			//StructNode  BODY= new StructNode("APPBody");
			//messageNode.addStructNode(BODY);
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("pwdtype",new MsgField(ContentEnum.MessageType.STRING.toString(), "pwdtype", 1,0, true, "密码类型" )))
					.addNode(new FieldNode("sucmsg",new MsgField(ContentEnum.MessageType.STRING.toString(), "sucmsg", 256,0, false, "成功提信息" )))
					.addNode(new FieldNode("simscore",new MsgField(ContentEnum.MessageType.STRING.toString(), "simscore", 11,0, false, "识别分数" )))
					);
			
			
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
}
