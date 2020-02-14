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
 * 
 * @author zhuzc
 * BASESVC BODAFA0031 贷记卡余额查询
 * BODAFA0031 881004
 * ATM
 */
@Component
public class BODAFA0031 extends EciChannelService{
	private static BODAFA0031_I i = new BODAFA0031_I();
	private static BODAFA0031_O o = new BODAFA0031_O();
	public BODAFA0031() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0031_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno",2,0, false, "卡号" )))
					.addNode(new FieldNode("currtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "currtype", 2,0, false, "币种" )))
					.addNode(new FieldNode("passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "passwd", 16,0, false, "交易密码" )))
					.addNode(new FieldNode("track2", new MsgField(ContentEnum.MessageType.STRING.toString(), "track2", 40,0, false, "二磁道" )))
					.addNode(new FieldNode("iccardseq", new MsgField(ContentEnum.MessageType.STRING.toString(), "iccardseq", 3,0, false, "IC卡序列号" )))
					.addNode(new FieldNode("icdata", new MsgField(ContentEnum.MessageType.STRING.toString(), "icdata", 300,0, false, "IC卡数据" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 1,0, false, "是否需要密码" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 20,0, false, "密钥序号" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 20,0, false, "密码的来源" )))
					.addNode(new FieldNode("fridcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "fridcode", 20,0, false, "转发机构代码" )))
					.addNode(new FieldNode("acidcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "acidcode", 20,0, false, "代理行机构代码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0031_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 22,0, false, "卡号" )))
					.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "amount", 21,0, false, "账面余额" )))
					.addNode(new FieldNode("aamount", new MsgField(ContentEnum.MessageType.STRING.toString(), "aamount", 21,0, false, "帐户当日可用余额" )))
					.addNode(new FieldNode("damount", new MsgField(ContentEnum.MessageType.STRING.toString(), "damount", 21,0, false, "ATM取款当日可取余额" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
