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
 * BASESVC BODAFA1564  信用卡激活 
 *  BODAFA1564 
 *  综合前端
 * @author XZF
 */
@Component
public class BODAFA1564 extends EciChannelService {

	private static BODAFA1564_I i = new BODAFA1564_I();
	private static BODAFA1564_O o = new BODAFA1564_O();
	public BODAFA1564() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1564_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 19,0, true, "卡号" )))
					.addNode(new FieldNode("option", new MsgField(ContentEnum.MessageType.STRING.toString(), "option", 15,0, true, "检查项目选择" )))
					.addNode(new FieldNode("idno_6", new MsgField(ContentEnum.MessageType.STRING.toString(), "idno_6", 6,0, true, "证件号码的后6位" )))
					.addNode(new FieldNode("home_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "home_tel", 17,0, true, "家庭电话" )))
					.addNode(new FieldNode("birthday", new MsgField(ContentEnum.MessageType.STRING.toString(), "birthday", 8,0, true, "出生年月日" )))
					.addNode(new FieldNode("mbphone", new MsgField(ContentEnum.MessageType.STRING.toString(), "mbphone", 12,0, true, "手机号码" )))
					.addNode(new FieldNode("reserve", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserve", 20,0, true, "客户预留答案" )))
					.addNode(new FieldNode("telno", new MsgField(ContentEnum.MessageType.STRING.toString(), "telno", 17,0, false, "来电号码" )))
					.addNode(new FieldNode("cvv2", new MsgField(ContentEnum.MessageType.STRING.toString(), "cvv2", 3,0, true, "卡片CVV2" )))
					.addNode(new FieldNode("expiry_dte", new MsgField(ContentEnum.MessageType.STRING.toString(), "expiry_dte", 4,0, true, "卡片有效期" )))
					.addNode(new FieldNode("keytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "keytype", 2,0, true, "证件类型" )))
					.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 18,0, true, "证件号码" )))
					.addNode(new FieldNode("uckacf_yn", new MsgField(ContentEnum.MessageType.STRING.toString(), "uckacf_yn", 1,0, true, "不检查联机激活连续失败次数标志" )))
					.addNode(new FieldNode("revs", new MsgField(ContentEnum.MessageType.STRING.toString(), "revs", 99,0, false, "保留字段" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1564_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq", 20,0, false, "错误码" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 200,0, false, "错误信息" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 19,0, false, "卡号" )))
					.addNode(new FieldNode("pin_set", new MsgField(ContentEnum.MessageType.STRING.toString(), "pin_set", 1,0, false, "是否设置查询密码" )))
					.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 30,0, false, "持卡人姓名" )))
					.addNode(new FieldNode("product", new MsgField(ContentEnum.MessageType.STRING.toString(), "product", 4,0, false, "产品编号" )))
					.addNode(new FieldNode("fee_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_code", 2,0, false, "年费代码" )))
					.addNode(new FieldNode("feev", new MsgField(ContentEnum.MessageType.STRING.toString(), "feev", 8,0, false, "年费" )))
					.addNode(new FieldNode("feedaly", new MsgField(ContentEnum.MessageType.STRING.toString(), "feedaly", 2,0, false, "首次收费宽限期" )))
					.addNode(new FieldNode("fstactdy", new MsgField(ContentEnum.MessageType.STRING.toString(), "fstactdy", 8,0, true, "首次激活日期" )))
					.addNode(new FieldNode("set_pinoff", new MsgField(ContentEnum.MessageType.STRING.toString(), "set_pinoff", 1,0, false, "已设置交易密码" )))
					.addNode(new FieldNode("revs", new MsgField(ContentEnum.MessageType.STRING.toString(), "revs", 9,0, false, "保留字段" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

