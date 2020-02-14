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
 * BASESVC.C012000108 客户信息管理.客户信息变更申请 
 * C0120001.08 8819704
 * 0339 综合前置(微网点模块)
 * @author XZF
 */
@Component
public class C012000108 extends EsbChannelService {

	private static C012000108_I i = new C012000108_I();
	private static C012000108_O o = new C012000108_O();
	public C012000108() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C012000108_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("PhotoP", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhotoP", 50,0, true, "拍摄人像面" )))
					.addNode(new FieldNode("PhotoG", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhotoG", 50,0, true, "拍摄国徽面" )))
					.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl", 20,0, true, "手机号码" )))
					.addNode(new FieldNode("PeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PeName", 20,0, true, "姓名" )))
					.addNode(new FieldNode("PhotoC", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhotoC", 50,0, true, "银行卡正面" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 2,0, true, "证件类型" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, true, "证件号码" )))
					.addNode(new FieldNode("tranac", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranac", 40,0, false, "账号" )))
					.addNode(new FieldNode("NowAdd", new MsgField(ContentEnum.MessageType.STRING.toString(), "NowAdd", 256,0, false, "现居住地址" )))
					.addNode(new FieldNode("OffPho", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffPho", 20,0, false, "办公电话" )))
					.addNode(new FieldNode("OthPho", new MsgField(ContentEnum.MessageType.STRING.toString(), "OthPho", 50,0, false, "家庭电话" )))
					.addNode(new FieldNode("PostNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "PostNo", 50,0, false, "邮政编码" )))
					.addNode(new FieldNode("ProFee", new MsgField(ContentEnum.MessageType.STRING.toString(), "ProFee", 2,0, false, "职业" )))
					.addNode(new FieldNode("WorkUn", new MsgField(ContentEnum.MessageType.STRING.toString(), "WorkUn", 100,0, false, "工作单位" )))
					.addNode(new FieldNode("IsPubl", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsPubl", 1,0, true, "是否对公业务" )))
					.addNode(new FieldNode("WorkAd", new MsgField(ContentEnum.MessageType.STRING.toString(), "WorkAd", 256,0, false, "工作单位地址" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C012000108_O extends MsgBody {
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

