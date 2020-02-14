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
 * BASESVC BODAFA1180  回单机密码修改
 *  BODAFA1180 8815717
 *  综合前置
 * @author YFK
 */
@Component
public class BODAFA1180 extends EciChannelService{

	private static BODAFA1180_I i = new BODAFA1180_I();
	private static BODAFA1180_O o = new BODAFA1180_O();
	public BODAFA1180() {
		requestFormat.add(i);
		responseFormat.add(o);
	}
	
	public static class BODAFA1180_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("acctno",new MsgField(ContentEnum.MessageType.STRING.toString(),"acctno" ,32,0, false, "账号" )))
					.addNode(new FieldNode("loginflag",new MsgField(ContentEnum.MessageType.STRING.toString(),"loginflag" ,3,0, false, "登陆方式" )))
					.addNode(new FieldNode("password",new MsgField(ContentEnum.MessageType.STRING.toString(),"password" ,32,0, false, "密码" )))
					.addNode(new FieldNode("newpassword",new MsgField(ContentEnum.MessageType.STRING.toString(),"newpassword" ,32,0, false, "新密码" )))
					.addNode(new FieldNode("needpwd",new MsgField(ContentEnum.MessageType.STRING.toString(),"needpwd" ,1,0, false, "是否需要密码转换。值为“Y”时为是" )))
					.addNode(new FieldNode("zmackey",new MsgField(ContentEnum.MessageType.STRING.toString(),"zmackey" ,30,0, false, "密钥序号" )))
					.addNode(new FieldNode("zpwdfrm",new MsgField(ContentEnum.MessageType.STRING.toString(),"zpwdfrm" ,10,0, false, "密码的来源" )))
					.addNode(new FieldNode("zacctno1",new MsgField(ContentEnum.MessageType.STRING.toString(),"zacctno1" ,32,0, false, "密码所涉及的账号字段" )))
					.addNode(new FieldNode("zpwdfd1",new MsgField(ContentEnum.MessageType.STRING.toString(),"zpwdfd1" ,16,0, false, "密码字段" )))
					.addNode(new FieldNode("zdcmttp1",new MsgField(ContentEnum.MessageType.STRING.toString(),"zdcmttp1" ,30,0, false, "密码涉及账号的凭证类型字段" )))
					.addNode(new FieldNode("zdcmtno1",new MsgField(ContentEnum.MessageType.STRING.toString(),"zdcmtno1" ,30,0, false, "密码涉及账号的凭证号码字段" )))
					.addNode(new FieldNode("zacctno2",new MsgField(ContentEnum.MessageType.STRING.toString(),"zacctno2" ,32,0, false, "第二个密码所涉及的账号字段" )))
					.addNode(new FieldNode("zpwdfd2",new MsgField(ContentEnum.MessageType.STRING.toString(),"zpwdfd2" ,16,0, false, "第二个密码字段" )))
					.addNode(new FieldNode("zdcmttp2",new MsgField(ContentEnum.MessageType.STRING.toString(),"zdcmttp2" ,30,0, false, "第二个密码涉及账号的凭证类型字段" )))
					.addNode(new FieldNode("zdcmtno2",new MsgField(ContentEnum.MessageType.STRING.toString(),"zdcmtno2" ,30,0, false, "第二个密码涉及账号的凭证号码字段" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	
	public static class BODAFA1180_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("clientserialno",new MsgField(ContentEnum.MessageType.STRING.toString(),"clientserialno" ,32,0, false, "前端流水号" )))
					.addNode(new FieldNode("hostserialno",new MsgField(ContentEnum.MessageType.STRING.toString(),"hostserialno" ,32,0, false, "银行流水号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
}
