package cn.com.agree.huanan.ap.al.io.service.eci.hst;

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
 * BASESVC BODHST1105  借记卡自助服务签约 
 *  BODHST1105 
 *  旧核心系统
 * @author XZF
 */
@Component
public class BODHST1105 extends EciChannelService {

	private static BODHST1105_I i = new BODHST1105_I();
	private static BODHST1105_O o = new BODHST1105_O();
	public BODHST1105() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODHST1105_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("userid", new MsgField(ContentEnum.MessageType.STRING.toString(), "userid", 10,0, false, "柜员号" )))
					.addNode(new FieldNode("dispno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dispno", 40,0, false, "卡/账号" )))
					.addNode(new FieldNode("tranpw", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranpw", 20,0, false, "密码" )))
					.addNode(new FieldNode("lmttp1", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmttp1", 1,0, false, "行内转账开通标志" )))
					.addNode(new FieldNode("lmtam1", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmtam1", 18,2, false, "行内转账日累计限额" )))
					.addNode(new FieldNode("lmttp2", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmttp2", 1,0, false, "跨行转账开通标志" )))
					.addNode(new FieldNode("lmtam2", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmtam2", 18,2, false, "跨行转账日累计" )))
					.addNode(new FieldNode("lmttp3", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmttp3", 1,0, false, "境内消费开通标志" )))
					.addNode(new FieldNode("lmtam3", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmtam3", 18,2, false, "境内消费日累计" )))
					.addNode(new FieldNode("lmttp4", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmttp4", 1,0, false, "境外消费开通标志" )))
					.addNode(new FieldNode("lmtam4", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmtam4", 18,2, false, "境外消费日累计" )))
					.addNode(new FieldNode("lmttp5", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmttp5", 1,0, false, "境外取现开通标志" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 1,0, true, "是否需要密码转换" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 30,0, false, "密钥序号" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 20,0, false, "密码来源" )))
					.addNode(new FieldNode("zacctno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zacctno1", 20,0, false, "密码所涉及的账号字段名" )))
					.addNode(new FieldNode("zpwdfd1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfd1", 20,0, false, "密码所在字段名" )))
					.addNode(new FieldNode("zdcmttp1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmttp1", 20,0, false, "凭证字段名" )))
					.addNode(new FieldNode("zdcmtno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmtno1", 20,0, false, "凭证号字段名" )))
					.addNode(new FieldNode("pwdflg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pwdflg", 1,0, false, "是否验密标志" )))
					.addNode(new FieldNode("promno", new MsgField(ContentEnum.MessageType.STRING.toString(), "promno", 6,0, false, "推荐人代码" )))
					.addNode(new FieldNode("promna", new MsgField(ContentEnum.MessageType.STRING.toString(), "promna", 200,0, false, "推荐人名称" )))
					.addNode(new FieldNode("saleno", new MsgField(ContentEnum.MessageType.STRING.toString(), "saleno", 6,0, false, "营销人员代码" )))
					.addNode(new FieldNode("salena", new MsgField(ContentEnum.MessageType.STRING.toString(), "salena", 200,0, false, "营销人员名称" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODHST1105_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("trandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt", 8,0, false, "交易日期" )))
					.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 20,0, false, "交易流水" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

