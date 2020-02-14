package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;
import java.util.Map;

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
 * BASESVC BODAFA0039  联机接口ifmsmsg 
 *  BODAFA0039 884401
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA0039 extends EciChannelService {

	private static BODAFA0039_I i = new BODAFA0039_I();
	private static BODAFA0039_O o = new BODAFA0039_O();
	public BODAFA0039() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0039_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 6,0, false, "本次发送记录数" )))
					.addNode(new ArrayNode("bodrcd",true)
							.addNode(new FieldNode("srno", new MsgField(ContentEnum.MessageType.STRING.toString(), "srno", 10,0, false, "序号" )))
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 32,0, false, "交易账号" )))
							.addNode(new FieldNode("phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone", 11,0, false, "手机号码" )))
							.addNode(new FieldNode("msgtxt", new MsgField(ContentEnum.MessageType.STRING.toString(), "msgtxt", 400,0, false, "短信内容" )))
							.addNode(new FieldNode("sendtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "sendtp", 2,0, false, "短信类型" )))
							.addNode(new FieldNode("accttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "accttp", 1,0, false, "账户类型" )))
							.addNode(new FieldNode("acctty", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctty", 1,0, false, "账户种类" )))
							.addNode(new FieldNode("trantp", new MsgField(ContentEnum.MessageType.STRING.toString(), "trantp", 1,0, false, "交易种类" )))
							.addNode(new FieldNode("signtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtp", 1,0, false, "是否签约" )))
							.addNode(new FieldNode("isfree", new MsgField(ContentEnum.MessageType.STRING.toString(), "isfree", 1,0, false, "是否免费" )))
							.addNode(new FieldNode("dcmttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcmttp", 3,0, false, "凭证类型" )))
							.addNode(new FieldNode("gntime", new MsgField(ContentEnum.MessageType.STRING.toString(), "gntime", 19,0, true, "生成时间" )))
							.addNode(new FieldNode("userid", new MsgField(ContentEnum.MessageType.STRING.toString(), "userid", 5,0, false, "操作柜员" )))
							.addNode(new FieldNode("trbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "trbrno", 4,0, false, "交易网点" )))
							.addNode(new FieldNode("febrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "febrno", 4,0, false, "统计网点" )))
							.addNode(new FieldNode("fezone", new MsgField(ContentEnum.MessageType.STRING.toString(), "fezone", 4,0, false, "所属分行号" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}
	@Override
	public void initServieConf() {
		// TODO 自动生成的方法存根
		super.initServieConf();
	}

	@Override
	public void initContent(Map<String, Object> tradeContext) {
		// TODO 自动生成的方法存根
		super.initContent(tradeContext);
		Map<String,Object> appHeader = (Map)tradeContext.get("AppHeader");
		Map<String,Object> csisHeader = (Map)tradeContext.get("CsisHeader");
		appHeader.put("xmlflag", "1");
		appHeader.put("templateCodeName", "dsdfcm");
		appHeader.put("transCode", "884401");
		appHeader.put("sysId", "44");
		appHeader.put("prcscd", "ifmsmsg");
		appHeader.put("subchannelCode", csisHeader.get("SrcCalCod"));
	}

	public static class BODAFA0039_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
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

