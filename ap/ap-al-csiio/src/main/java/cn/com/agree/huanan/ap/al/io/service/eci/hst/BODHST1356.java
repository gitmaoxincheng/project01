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
 * BASESVC BODHST1356  随心存产品认购交易 
 *  BODHST1356 
 *  旧核心系统
 * @author XZF
 */
@Component
public class BODHST1356 extends EciChannelService {

	private static BODHST1356_I i = new BODHST1356_I();
	private static BODHST1356_O o = new BODHST1356_O();
	public BODHST1356() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODHST1356_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("signat", new MsgField(ContentEnum.MessageType.STRING.toString(), "signat", 20,0, false, "认购账号" )))
					.addNode(new FieldNode("ftdpcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "ftdpcd", 30,0, false, "产品代码" )))
					.addNode(new FieldNode("termcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "termcd", 3,0, false, "存期" )))
					.addNode(new FieldNode("inacct", new MsgField(ContentEnum.MessageType.STRING.toString(), "inacct", 20,0, false, "利息转入账号" )))
					.addNode(new FieldNode("inidtf", new MsgField(ContentEnum.MessageType.STRING.toString(), "inidtf", 50,0, false, "利息转入客户身份证件号码" )))
					.addNode(new FieldNode("cracct", new MsgField(ContentEnum.MessageType.STRING.toString(), "cracct", 20,0, false, "兑付账号" )))
					.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "tranam", 18,2, false, "认购金额" )))
					.addNode(new FieldNode("tranpw", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranpw", 20,0, false, "交易密码" )))
					.addNode(new FieldNode("agnttg", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnttg", 1,0, false, "是否代办" )))
					.addNode(new FieldNode("agidtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "agidtp", 2,0, false, "代理人证件类型" )))
					.addNode(new FieldNode("agcuna", new MsgField(ContentEnum.MessageType.STRING.toString(), "agcuna", 40,0, false, "代理人姓名" )))
					.addNode(new FieldNode("agidno", new MsgField(ContentEnum.MessageType.STRING.toString(), "agidno", 50,0, false, "代理人证件号码" )))
					.addNode(new FieldNode("promno", new MsgField(ContentEnum.MessageType.STRING.toString(), "promno", 20,0, false, "推荐人编号" )))
					.addNode(new FieldNode("promna", new MsgField(ContentEnum.MessageType.STRING.toString(), "promna", 40,0, false, "推荐人名称" )))
					.addNode(new FieldNode("autdtg", new MsgField(ContentEnum.MessageType.STRING.toString(), "autdtg", 1,0, false, "转存标志" )))
					.addNode(new FieldNode("incmtm", new MsgField(ContentEnum.MessageType.STRING.toString(), "incmtm", 50,0, true, "付息频率" )))
					.addNode(new FieldNode("isadde", new MsgField(ContentEnum.MessageType.STRING.toString(), "isadde", 1,0, false, "是否受益增值" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 1,0, true, "是否需要转密" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 50,0, false, "密钥序号" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 50,0, false, "密码的来源" )))
					.addNode(new FieldNode("zacctno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zacctno1", 50,0, false, "第一个密码所涉及的账号指针" )))
					.addNode(new FieldNode("zpwdfd1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfd1", 50,0, false, "第一个密码密文指针" )))
					.addNode(new FieldNode("zdcmttp1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmttp1", 50,0, false, "第一个密码涉及账号的凭证类型指针" )))
					.addNode(new FieldNode("zdcmtno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmtno1", 50,0, false, "第一个密码涉及账号的凭证号码指针" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODHST1356_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq", 1024,0, false, "报文流水" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 300,0, false, "出错信息" )))
					.addNode(new FieldNode("rtcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "rtcode", 1024,0, false, "出错码" )))
					.addNode(new FieldNode("trandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt", 8,0, false, "交易日期" )))
					.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 20,0, false, "交易流水" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 240,0, false, "随心存账号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

