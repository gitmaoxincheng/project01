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
 * BASESVC BODAFA1664  银企自助对账签约信息维护 
 *  BODAFA1664 88A011
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1664 extends EciChannelService {

	private static BODAFA1664_I i = new BODAFA1664_I();
	private static BODAFA1664_O o = new BODAFA1664_O();
	public BODAFA1664() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1664_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("userType", new MsgField(ContentEnum.MessageType.STRING.toString(), "userType", 2,0, false, "用户类型" )))
					.addNode(new FieldNode("compNumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "compNumber", 20,0, false, "公司证件号码" )))
					.addNode(new FieldNode("compIdtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "compIdtype", 3,0, false, "公司证件类型" )))
					.addNode(new FieldNode("passwordType", new MsgField(ContentEnum.MessageType.STRING.toString(), "passwordType", 1,0, false, "密码类型" )))
					.addNode(new FieldNode("password", new MsgField(ContentEnum.MessageType.STRING.toString(), "password", 300,0, false, "密码" )))
					.addNode(new FieldNode("passwordCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "passwordCode", 1024,0, false, "加密因子" )))
					.addNode(new FieldNode("phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone", 20,0, false, "手机号" )))
					.addNode(new FieldNode("olduserName", new MsgField(ContentEnum.MessageType.STRING.toString(), "olduserName", 32,0, false, "原第一联系人名称" )))
					.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 32,0, false, "用户登录名" )))
					.addNode(new FieldNode("userPhone", new MsgField(ContentEnum.MessageType.STRING.toString(), "userPhone", 32,0, false, "第一联系人电话" )))
					.addNode(new FieldNode("userName", new MsgField(ContentEnum.MessageType.STRING.toString(), "userName", 32,0, false, "第一联系人名称" )))
					.addNode(new FieldNode("secondPhone", new MsgField(ContentEnum.MessageType.STRING.toString(), "secondPhone", 32,0, false, "第二对账联系人电话" )))
					.addNode(new FieldNode("secondName", new MsgField(ContentEnum.MessageType.STRING.toString(), "secondName", 32,0, false, "第二联系人名称" )))
					.addNode(new FieldNode("cifno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cifno", 32,0, false, "核心客户号" )))
					.addNode(new FieldNode("batchno", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchno", 50,0, false, "签约编号" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 1024,0, false, "终端号" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 20,0, false, "密码来源" )))
					.addNode(new FieldNode("rcrdnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcrdnm", 10,0, false, "勾选账号总记录" )))
					.addNode(new ArrayNode("bodrcd",true)
							.addNode(new FieldNode("accountNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "accountNo", 32,0, false, "账号/借据号" )))
							.addNode(new FieldNode("accstp", new MsgField(ContentEnum.MessageType.STRING.toString(), "accstp", 1,0, false, "存贷款类型" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1664_O extends MsgBody {
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

