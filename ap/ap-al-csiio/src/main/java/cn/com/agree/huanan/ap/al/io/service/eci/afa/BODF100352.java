package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciF10ChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODF100352  评估问卷查询 
 *  BODF100352 
 *  综合前置
 * @author XZF
 */
@Component
public class BODF100352 extends EciF10ChannelService {

	private static BODF100352_I i = new BODF100352_I();
	private static BODF100352_O o = new BODF100352_O();
	public BODF100352() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100352_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("ClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 10,0, true, "客户类型" )))
					.addNode(new FieldNode("ClientGroup", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientGroup", 10,0, true, "客户组别" )))
					.addNode(new FieldNode("PaperType", new MsgField(ContentEnum.MessageType.STRING.toString(), "PaperType", 10,0, true, "问卷类型" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 10,0, true, "定位串" )))
					.addNode(new FieldNode("QueryNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "QueryNum", 10,0, true, "查询行数" )))
					.addNode(new FieldNode("EnableFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "EnableFlag", 10,0, false, "启用标识" )))
					.addNode(new FieldNode("PaperNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "PaperNo", 10,0, false, "问卷编号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100352_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){  
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("TotNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNum", 10,0, true, "总行数" )))
					.addNode(new FieldNode("RetNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "RetNum", 10,0, true, "本次返回行数" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 10,0, true, "定位串" )))
					.addNode(new ArrayNode("bodrcd",true,"qust_list")
							.addNode(new FieldNode("PaperNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "PaperNo", 10,0, true, "试卷编号" )))
							.addNode(new FieldNode("Question", new MsgField(ContentEnum.MessageType.STRING.toString(), "Question", 10,0, true, "问题编号" )))
							.addNode(new FieldNode("RiskOption", new MsgField(ContentEnum.MessageType.STRING.toString(), "RiskOption", 10,0, true, "选择项" )))
							.addNode(new FieldNode("Subject", new MsgField(ContentEnum.MessageType.STRING.toString(), "Subject", 200,0, true, "提示内容" )))
							.addNode(new FieldNode("Score", new MsgField(ContentEnum.MessageType.STRING.toString(), "Score", 10,0, true, "分数" )))
							.addNode(new FieldNode("ClientType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientType", 10,0, true, "客户类型（个人、机构）" )))
							.addNode(new FieldNode("ClientGroup", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientGroup", 10,0, false, "客户组别" )))
							.addNode(new FieldNode("QuestionType", new MsgField(ContentEnum.MessageType.STRING.toString(), "QuestionType", 10,0, false, "是否复选" )))
							.addNode(new FieldNode("PrdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdType", 10,0, true, "业务类型" )))
							.addNode(new FieldNode("EnableFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "EnableFlag", 10,0, true, "启用标识" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

