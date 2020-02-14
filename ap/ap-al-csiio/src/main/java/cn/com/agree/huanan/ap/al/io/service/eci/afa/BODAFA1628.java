package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODAFA1628  开户数量检查 
 *  BODAFA1628 8816231
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1628 extends EciChannelService {

	private static BODAFA1628_I i = new BODAFA1628_I();
	private static BODAFA1628_O o = new BODAFA1628_O();
	public BODAFA1628() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1628_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 1,0, true, "证件类型" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 20,0, true, "证件号码" )))
					.addNode(new FieldNode("opentype", new MsgField(ContentEnum.MessageType.STRING.toString(), "opentype", 1,0, false, "开户类型" )))
					.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 80,0, false, "客户姓名" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1628_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("ercode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ercode", 42,0, false, "响应码" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 43,0, false, "响应信息" )))
					.addNode(new FieldNode("count_i", new MsgField(ContentEnum.MessageType.STRING.toString(), "count_i", 10,0, false, "I类账户数" )))
					.addNode(new FieldNode("count_ii", new MsgField(ContentEnum.MessageType.STRING.toString(), "count_ii", 10,0, false, "II类账户数" )))
					.addNode(new FieldNode("count_iii", new MsgField(ContentEnum.MessageType.STRING.toString(), "count_iii", 10,0, false, "III类账户数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	@Override
	public void initContent(Map<String, Object> tradeContext) {
		super.initContent(tradeContext);
		Map<String, Object> appHeader = (Map<String, Object>) tradeContext.get(CommConstant.APP_HEADER);
		appHeader.put("xmlflag", "1");
		appHeader.put("templateCodeName", "dsdfcm");
		appHeader.put("transCode", "8816231");
		appHeader.put("sysId", "162");
		appHeader.put("prcscd", "8816231");
	}
}

