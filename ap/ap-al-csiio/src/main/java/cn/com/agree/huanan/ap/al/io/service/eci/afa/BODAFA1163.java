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
 * BASESVC BODAFA1163  社保IC卡重置密码 
 *  BODAFA1163 
 *  综合前端
 * @author XZF
 */
@Component
public class BODAFA1163 extends EciChannelService {

	private static BODAFA1163_I i = new BODAFA1163_I();
	private static BODAFA1163_O o = new BODAFA1163_O();
	public BODAFA1163() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1163_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("sbkh", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbkh", 30,0, false, "社保卡号" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 30,0, false, "金融账户卡号" )))
					.addNode(new FieldNode("zjlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "zjlx", 2,0, false, "证件类型" )))
					.addNode(new FieldNode("zjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zjhm", 50,0, false, "证件号码" )))
					.addNode(new FieldNode("xm", new MsgField(ContentEnum.MessageType.STRING.toString(), "xm", 200,0, false, "姓名" )))
					.addNode(new FieldNode("yhbh", new MsgField(ContentEnum.MessageType.STRING.toString(), "yhbh", 2,0, false, "发卡银行编号" )))
					.addNode(new FieldNode("yhwdbh", new MsgField(ContentEnum.MessageType.STRING.toString(), "yhwdbh", 10,0, false, "银行网点编号" )))
					.addNode(new FieldNode("yhwdmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "yhwdmc", 200,0, false, "银行网点名称" )))
					.addNode(new FieldNode("ywlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "ywlx", 1,0, false, "操作请求" )))
					.addNode(new FieldNode("qqzfc", new MsgField(ContentEnum.MessageType.STRING.toString(), "qqzfc", 100,0, true, "请求字符串" )))
					.addNode(new FieldNode("tranpw", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranpw", 300,0, true, "新账号密码" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 50,0, true, "密钥序号" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 20,0, true, "密码来源" )))
					.addNode(new FieldNode("zacctno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zacctno1", 20,0, true, "密码所涉及的账号字段名" )))
					.addNode(new FieldNode("zpwdfd1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfd1", 20,0, true, "密码所在字段名" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 20,0, true, "是否需要密码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1163_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("qqlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "qqlsh", 40,0, false, "银行流水" )))
					.addNode(new FieldNode("ydlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ydlsh", 40,0, false, "社保流水" )))
					.addNode(new FieldNode("ydzfc", new MsgField(ContentEnum.MessageType.STRING.toString(), "ydzfc", 100,0, true, "应答字符串" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

