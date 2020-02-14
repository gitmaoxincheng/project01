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
 * BASESVC BODAFA1678  广州ETS/省ETS签约
 * BODAFA1678 ckdlac eft00079
 *  综合前置
 * @author CZP
 */
@Component
public class BODAFA1678 extends EciChannelService {

	private static BODAFA1678_I i = new BODAFA1678_I();
	private static BODAFA1678_O o = new BODAFA1678_O();

	public BODAFA1678() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1678_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("custtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype", 1024,0, false, "客户类型" )))
					.addNode(new FieldNode("tranpw", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranpw", 1024,0, false, "账号密码" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 1024,0, false, "是否需要密码转换。值为“Y”时为是" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 1024,0, false, "密钥序号" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 1024,0, false, "密码的来源" )))
					.addNode(new FieldNode("zacctno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zacctno1", 1024,0, false, "第一个密码所涉及的账号" )))
					.addNode(new FieldNode("zpwdfd1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfd1", 1024,0, false, "第一个密码" )))
					.addNode(new FieldNode("zdcmttp1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmttp1", 1024,0, false, "第一个密码涉及账号的凭证类型" )))
					.addNode(new FieldNode("zdcmtno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmtno1", 1024,0, false, "第一个密码涉及账号的凭证号码" )))
					.addNode(new FieldNode("zacctno2", new MsgField(ContentEnum.MessageType.STRING.toString(), "zacctno2", 1024,0, false, "第二个密码所涉及的账号" )))
					.addNode(new FieldNode("mgntcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "mgntcd", 1024,0, false, "是否刷磁" )))
					.addNode(new FieldNode("zpwdfd2", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfd2", 1024,0, false, "第二个密码" )))
					.addNode(new FieldNode("zdcmttp2", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmttp2", 1024,0, false, "第二个密码涉及账号的凭证类型" )))
					.addNode(new FieldNode("zdcmtno2", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmtno2", 1024,0, false, "第二个密码涉及账号的凭证号码" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 1024,0, false, "签约账号" )))
					.addNode(new FieldNode("o_acna", new MsgField(ContentEnum.MessageType.STRING.toString(), "o_acna", 1024,0, false, "付款人名称" )))
					.addNode(new FieldNode("dcmttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcmttp", 1024,0, false, "凭证类型" )))
					.addNode(new FieldNode("dcmtno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcmtno", 1024,0, false, "凭证号码" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 1024,0, false, "证件类型" )))
					.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 1024,0, false, "证件号码" )))
					.addNode(new FieldNode("flag3", new MsgField(ContentEnum.MessageType.STRING.toString(), "flag3", 1024,0, false, "省市ETS标志" )))
					.addNode(new FieldNode("origcode1", new MsgField(ContentEnum.MessageType.STRING.toString(), "origcode1", 1024,0, false, "纳税编号" )))
					.addNode(new FieldNode("origcode2", new MsgField(ContentEnum.MessageType.STRING.toString(), "origcode2", 1024,0, false, "纳税编号" )))
					.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 1024,0, false, "用户名称" )))
					.addNode(new FieldNode("cactaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cactaddr", 1024,0, false, "联系地址" )))
					.addNode(new FieldNode("cacttel", new MsgField(ContentEnum.MessageType.STRING.toString(), "cacttel", 1024,0, false, "联系电话" )))
					.addNode(new FieldNode("cactzip", new MsgField(ContentEnum.MessageType.STRING.toString(), "cactzip", 1024,0, false, "邮编" )))
					.addNode(new FieldNode("txrgno", new MsgField(ContentEnum.MessageType.STRING.toString(), "txrgno", 1024,0, false, "财务登记号" )))
					.addNode(new FieldNode("txpysb", new MsgField(ContentEnum.MessageType.STRING.toString(), "txpysb", 1024,0, false, "社保号" )))
					.addNode(new FieldNode("txpycl", new MsgField(ContentEnum.MessageType.STRING.toString(), "txpycl", 1024,0, false, "残联号" )))
					.addNode(new FieldNode("taxcod", new MsgField(ContentEnum.MessageType.STRING.toString(), "taxcod", 1024,0, false, "纳税人编号" )))
					.addNode(new FieldNode("taxcod_jj", new MsgField(ContentEnum.MessageType.STRING.toString(), "taxcod_jj", 1024,0, false, "纳税人编号-基金编码" )))
					.addNode(new FieldNode("protocolno", new MsgField(ContentEnum.MessageType.STRING.toString(), "protocolno", 1024,0, false, "协议书号" )))
					.addNode(new FieldNode("txpytp", new MsgField(ContentEnum.MessageType.STRING.toString(), "txpytp", 1024,0, false, "判断标志" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	

	public static class BODAFA1678_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("sendbank", new MsgField(ContentEnum.MessageType.STRING.toString(), "sendbank", 1024,0, false, "签约行号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
