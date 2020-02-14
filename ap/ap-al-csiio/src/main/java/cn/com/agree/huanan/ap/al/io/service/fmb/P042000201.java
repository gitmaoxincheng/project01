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
 * BASESVC.P042000201 借记卡管理.个人开卡申请 
 * P0420002.01 8819702
 * 0339 综合前置(微网点模块)
 * @author XZF
 */
@Component
public class P042000201 extends EsbChannelService {

	private static P042000201_I i = new P042000201_I();
	private static P042000201_O o = new P042000201_O();
	public P042000201() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P042000201_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("PhotoP", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhotoP", 50,0, true, "拍摄人像面" )))
					.addNode(new FieldNode("PhotoG", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhotoG", 50,0, true, "拍摄国徽面" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 2,0, true, "证件类型" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, true, "证件号码" )))
					.addNode(new FieldNode("IsNewc", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsNewc", 1,0, false, "新开账户" )))
					.addNode(new FieldNode("IsYxQy", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsYxQy", 1,0, false, "银信通签约" )))
					.addNode(new FieldNode("KeySli", new MsgField(ContentEnum.MessageType.STRING.toString(), "KeySli", 1,0, false, "KEY申领" )))
					.addNode(new FieldNode("RryYyy", new MsgField(ContentEnum.MessageType.STRING.toString(), "RryYyy", 1,0, false, "日日盈月月盈签约" )))
					.addNode(new FieldNode("JjCard", new MsgField(ContentEnum.MessageType.STRING.toString(), "JjCard", 1,0, false, "借记卡自助服务签约" )))
					.addNode(new FieldNode("OffPho", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffPho", 20,0, false, "办公电话" )))
					.addNode(new FieldNode("OthPho", new MsgField(ContentEnum.MessageType.STRING.toString(), "OthPho", 50,0, false, "家庭电话" )))
					.addNode(new FieldNode("PostNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "PostNo", 50,0, true, "邮政编码" )))
					.addNode(new FieldNode("NowAdd", new MsgField(ContentEnum.MessageType.STRING.toString(), "NowAdd", 256,0, true, "现居住地址" )))
					.addNode(new FieldNode("ProFee", new MsgField(ContentEnum.MessageType.STRING.toString(), "ProFee", 2,0, true, "职业" )))
					.addNode(new FieldNode("OthPro", new MsgField(ContentEnum.MessageType.STRING.toString(), "OthPro", 50,0, false, "其他职业描述" )))
					.addNode(new FieldNode("WorkUn", new MsgField(ContentEnum.MessageType.STRING.toString(), "WorkUn", 100,0, false, "工作单位" )))
					.addNode(new FieldNode("WorkAd", new MsgField(ContentEnum.MessageType.STRING.toString(), "WorkAd", 256,0, false, "工作单位地址" )))
					.addNode(new FieldNode("TaxSta", new MsgField(ContentEnum.MessageType.STRING.toString(), "TaxSta", 2,0, true, "税收居民身份" )))
					.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl", 20,0, true, "手机号码" )))
					.addNode(new FieldNode("ZibKey", new MsgField(ContentEnum.MessageType.STRING.toString(), "ZibKey", 1,0, false, "是否自备KEY" )))
					.addNode(new FieldNode("KkeyTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "KkeyTp", 1,0, false, "KEY类型" )))
					.addNode(new FieldNode("KeyChan", new MsgField(ContentEnum.MessageType.STRING.toString(), "KeyChan", 5,0, false, "KEY渠道" )))
					.addNode(new FieldNode("BusiTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "BusiTp", 1,0, false, "业务种类" )))
					.addNode(new FieldNode("Savedt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Savedt", 2,0, false, "存期" )))
					.addNode(new FieldNode("SaveAm", new MsgField(ContentEnum.MessageType.STRING.toString(), "SaveAm", 25,0, false, "保留余额" )))
					.addNode(new FieldNode("IsTRAm", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsTRAm", 1,0, false, "是否设定转账金额" )))
					.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.INT.toString(), "tranam", 18,2, false, "转账金额" )))
					.addNode(new FieldNode("trandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt", 8,0, false, "转账日期" )))
					.addNode(new FieldNode("Tranhn", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tranhn", 1,0, false, "行内转账" )))
					.addNode(new FieldNode("DSumhn", new MsgField(ContentEnum.MessageType.STRING.toString(), "DSumhn", 20,0, false, "日累计限额" )))
					.addNode(new FieldNode("Trankh", new MsgField(ContentEnum.MessageType.STRING.toString(), "Trankh", 1,0, false, "跨行转账" )))
					.addNode(new FieldNode("DSumkh", new MsgField(ContentEnum.MessageType.STRING.toString(), "DSumkh", 20,0, false, "日累计限额(跨行)" )))
					.addNode(new FieldNode("ChDSum", new MsgField(ContentEnum.MessageType.STRING.toString(), "ChDSum", 20,0, false, "境内消费日累计限额" )))
					.addNode(new FieldNode("OvDSum", new MsgField(ContentEnum.MessageType.STRING.toString(), "OvDSum", 20,0, false, "境外消费日累计限额" )))
					.addNode(new FieldNode("OvCash", new MsgField(ContentEnum.MessageType.STRING.toString(), "OvCash", 1,0, false, "境外取现" )))
					.addNode(new FieldNode("efctdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "efctdt", 8,0, true, "证件生效日期" )))
					.addNode(new FieldNode("inefdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "inefdt", 8,0, true, "证件失效日期" )))
					.addNode(new FieldNode("IsPubl", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsPubl", 1,0, true, "是否对公业务" )))
					.addNode(new FieldNode("PeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PeName", 20,0, true, "姓名" )))
					.addNode(new FieldNode("IdInst", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdInst", 20,0, true, "发证机关" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P042000201_O extends MsgBody {
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

