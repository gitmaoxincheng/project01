package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciF10ChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODF100353  客户风险问卷 
 *  BODF100353 
 *  综合前置
 * @author XZF
 */
@Component
public class BODF100353 extends EciF10ChannelService {

	private static BODF100353_I i = new BODF100353_I();
	private static BODF100353_O o = new BODF100353_O();
	public BODF100353() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100353_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("AccType", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccType", 1,0, false, "客户标识类型" )))
					.addNode(new FieldNode("Account", new MsgField(ContentEnum.MessageType.STRING.toString(), "Account", 32,0, false, "客户标志" )))
					.addNode(new FieldNode("IdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 6,0, true, "证件类型" )))
					.addNode(new FieldNode("ClientNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientNo", 10,0, true, "客户号" )))
					.addNode(new FieldNode("BankAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankAcc", 40,0, false, "银行账号" )))
					.addNode(new FieldNode("ClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 10,0, true, "客户类型" )))
					.addNode(new FieldNode("ClientGroup", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientGroup", 10,0, true, "客户组别" )))
					.addNode(new FieldNode("PaperType", new MsgField(ContentEnum.MessageType.STRING.toString(), "PaperType", 10,0, true, "问卷类型" )))
					.addNode(new FieldNode("PaperNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "PaperNo", 10,0, true, "试卷编号" )))
					.addNode(new FieldNode("QuestionList",new MsgField(ContentEnum.MessageType.STRING.toString(), "QuestionList", 32,0, true, "选中题干题目号列表" )))
					.addNode(new FieldNode("ScoreList", new MsgField(ContentEnum.MessageType.STRING.toString(), "ScoreList", 32,0, false, "每个题目被选择项的分数" )))
					.addNode(new FieldNode("OptionList", new MsgField(ContentEnum.MessageType.STRING.toString(), "OptionList", 32,0, true, "每个题目被选择的项" )))
					.addNode(new FieldNode("IdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdCode", 10,0, false, "证件号码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100353_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("SerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "SerialNo", 10,0, false, "系统流水号" )))
					.addNode(new FieldNode("LastScore", new MsgField(ContentEnum.MessageType.STRING.toString(), "LastScore", 10,0, true, "客户风险登级评价分数" )))
					.addNode(new FieldNode("RiskLevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskLevel", 10,0, true, "风险等级" )))
					.addNode(new FieldNode("RiskName", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskName", 10,0, true, "风险等级名称" )))
					.addNode(new FieldNode("RiskMonths", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskMonths", 10,0, true, "风险有效期月数" )))
					.addNode(new FieldNode("RiskDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskDate", 10,0, true, "风险有效期截止日" )))
					.addNode(new FieldNode("IsExperience", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsExperience", 10,0, false, "是否具备投资经验" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

