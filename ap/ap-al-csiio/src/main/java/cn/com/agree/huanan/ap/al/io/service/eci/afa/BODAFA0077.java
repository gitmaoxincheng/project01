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
 * BASESVC BODAFA0077  信用卡补卡申请 
 *  BODAFA0077 881004
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA0077 extends EciChannelService {

	private static BODAFA0077_I i = new BODAFA0077_I();
	private static BODAFA0077_O o = new BODAFA0077_O();
	public BODAFA0077() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0077_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 19,0, false, "卡号" )))
					.addNode(new FieldNode("iss_rsn", new MsgField(ContentEnum.MessageType.STRING.toString(), "iss_rsn", 1,0, false, "换卡原因" )))
					.addNode(new FieldNode("emb_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "emb_name", 26,0, false, "凸字姓名" )))
					.addNode(new FieldNode("exp_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "exp_date", 4,0, false, "到期日" )))
					.addNode(new FieldNode("dspch_cd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dspch_cd", 4,0, false, "递卡方式" )))
					.addNode(new FieldNode("dspch_lcn", new MsgField(ContentEnum.MessageType.STRING.toString(), "dspch_lcn", 4,0, false, "领卡分支行" )))
					.addNode(new FieldNode("rep_fee", new MsgField(ContentEnum.MessageType.STRING.toString(), "rep_fee", 1,0, false, "换卡费用代码" )))
					.addNode(new FieldNode("cour_fee", new MsgField(ContentEnum.MessageType.STRING.toString(), "cour_fee", 1,0, false, "递送费用代码" )))
					.addNode(new FieldNode("cdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cdfrm", 4,0, false, "卡片版面" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 2,0, false, "证件种类" )))
					.addNode(new FieldNode("idno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idno", 18,0, false, "证件号码" )))
					.addNode(new FieldNode("pinreqd", new MsgField(ContentEnum.MessageType.STRING.toString(), "pinreqd", 1,0, false, "是否产生PIN" )))
					.addNode(new FieldNode("keep_yn", new MsgField(ContentEnum.MessageType.STRING.toString(), "keep_yn", 1,0, false, "换卡保留卡号选项" )))
					.addNode(new FieldNode("cardnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardnm", 60,0, false, "持卡人姓名" )))
					.addNode(new FieldNode("retain", new MsgField(ContentEnum.MessageType.STRING.toString(), "retain", 60,0, false, "保留字段" )))
					.addNode(new FieldNode("card_to", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_to", 2,0, false, "卡片递送地址类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0077_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 30,0, false, "交易流水" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 19,0, false, "卡号" )))
					.addNode(new FieldNode("cardno-new", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardnonew", 19,0, false, "新卡号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

