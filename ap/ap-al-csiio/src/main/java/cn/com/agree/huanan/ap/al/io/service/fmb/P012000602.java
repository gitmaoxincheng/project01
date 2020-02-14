package cn.com.agree.huanan.ap.al.io.service.fmb;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P012000602 账户签约.统一签约申请 
 * P0120006.02 8819703
 * 0339 综合前置(微网点模块)
 * @author XZF
 */
@Component
public class P012000602 extends EsbChannelService {

	private static P012000602_I i = new P012000602_I();
	private static P012000602_O o = new P012000602_O();
	public P012000602() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P012000602_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("PhotoP", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhotoP", 50,0, true, "拍摄人像面" )))
					.addNode(new FieldNode("PhotoG", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhotoG", 50,0, true, "拍摄国徽面" )))
					.addNode(new FieldNode("PhotoC", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhotoC", 50,0, true, "银行卡正面" )))
					.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl", 20,0, true, "手机号码" )))
					.addNode(new FieldNode("PeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PeName", 20,0, true, "姓名" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 2,0, true, "证件类型" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, true, "证件号码" )))
					.addNode(new FieldNode("TranAc", new MsgField(ContentEnum.MessageType.STRING.toString(), "TranAc", 40,0, false, "账号" )))
					.addNode(new FieldNode("PerPNB", new MsgField(ContentEnum.MessageType.STRING.toString(), "PerPNB", 1,0, true, "个人网银" )))
					.addNode(new FieldNode("MobPNB", new MsgField(ContentEnum.MessageType.STRING.toString(), "MobPNB", 1,0, true, "手机银行" )))
					.addNode(new FieldNode("PowYXT", new MsgField(ContentEnum.MessageType.STRING.toString(), "PowYXT", 1,0, true, "银信通" )))
					.addNode(new FieldNode("KeyShe", new MsgField(ContentEnum.MessageType.STRING.toString(), "KeyShe", 1,0, true, "KEY申领/更换" )))
					.addNode(new FieldNode("RryYyy", new MsgField(ContentEnum.MessageType.STRING.toString(), "RryYyy", 1,0, true, "日日盈月月盈" )))
					.addNode(new FieldNode("JjServ", new MsgField(ContentEnum.MessageType.STRING.toString(), "JjServ", 1,0, true, "借记卡自助服务" )))
					.addNode(new FieldNode("PhoNo1", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhoNo1", 20,0, false, "手机号码1" )))
					.addNode(new FieldNode("PhoNo2", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhoNo2", 20,0, false, "手机号码2" )))
					.addNode(new FieldNode("PhoNo3", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhoNo3", 20,0, false, "手机号码3" )))
					.addNode(new FieldNode("PhoNo4", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhoNo4", 20,0, false, "手机号码4" )))
					.addNode(new FieldNode("PhoNo5", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhoNo5", 20,0, false, "手机号码5" )))
					.addNode(new FieldNode("NumYu1", new MsgField(ContentEnum.MessageType.STRING.toString(), "NumYu1", 1,0, false, "手机号码1是否解约" )))
					.addNode(new FieldNode("NumYu2", new MsgField(ContentEnum.MessageType.STRING.toString(), "NumYu2", 1,0, false, "手机号码2是否解约" )))
					.addNode(new FieldNode("NumYu3", new MsgField(ContentEnum.MessageType.STRING.toString(), "NumYu3", 1,0, false, "手机号码3是否解约" )))
					.addNode(new FieldNode("NumYu4", new MsgField(ContentEnum.MessageType.STRING.toString(), "NumYu4", 1,0, false, "手机号码4是否解约" )))
					.addNode(new FieldNode("NumYu5", new MsgField(ContentEnum.MessageType.STRING.toString(), "NumYu5", 1,0, false, "手机号码5是否解约" )))
					.addNode(new FieldNode("UseKey", new MsgField(ContentEnum.MessageType.STRING.toString(), "UseKey", 1,0, false, "是否自备KEY" )))
					.addNode(new FieldNode("UKeyTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "UKeyTp", 1,0, false, "KEY类型" )))
					.addNode(new FieldNode("Keycha", new MsgField(ContentEnum.MessageType.STRING.toString(), "Keycha", 5,0, false, "KEY渠道" )))
					.addNode(new FieldNode("BusiTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "BusiTp", 1,0, false, "业务种类" )))
					.addNode(new FieldNode("Savedt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Savedt", 2,0, false, "存期" )))
					.addNode(new FieldNode("SaveAm", new MsgField(ContentEnum.MessageType.STRING.toString(), "SaveAm", 25,0, false, "保留余额" )))
					.addNode(new FieldNode("IsTRAm", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsTRAm", 1,0, false, "是否设定转账金额" )))
					.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.INT.toString(), "tranam", 18,2, false, "转账金额" )))
					.addNode(new FieldNode("trandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt", 8,0, false, "转账日期" )))
					.addNode(new FieldNode("Tranhn", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tranhn", 1,0, true, "行内转账" )))
					.addNode(new FieldNode("DSumhn", new MsgField(ContentEnum.MessageType.STRING.toString(), "DSumhn", 20,0, false, "行内日累计限额" )))
					.addNode(new FieldNode("Trankh", new MsgField(ContentEnum.MessageType.STRING.toString(), "Trankh", 1,0, true, "跨行转账" )))
					.addNode(new FieldNode("DSumkh", new MsgField(ContentEnum.MessageType.STRING.toString(), "DSumkh", 20,0, false, "跨行日累计限额" )))
					.addNode(new FieldNode("ChDSum", new MsgField(ContentEnum.MessageType.STRING.toString(), "ChDSum", 20,0, false, "境内消费日累计限额" )))
					.addNode(new FieldNode("OvDSum", new MsgField(ContentEnum.MessageType.STRING.toString(), "OvDSum", 20,0, false, "境外消费日累计限额" )))
					.addNode(new FieldNode("IsPubl", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsPubl", 1,0, true, "是否对公业务" )))
					.addNode(new FieldNode("OvCash", new MsgField(ContentEnum.MessageType.STRING.toString(), "OvCash", 1,0, false, "境外取现" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 40,0, false, "银行卡号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P012000602_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("RequNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "RequNo", 50,0, false, "申请编号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

