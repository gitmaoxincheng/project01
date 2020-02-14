package cn.com.agree.huanan.ap.al.io.service.fmb;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.C013000115 客户信息管理.客户信息变更申请信息查询 
 * C0130001.15 8819713
 * 0339 综合前置(微网点模块)
 * @author XZF
 */
@Component
public class C013000115 extends EsbChannelService {

	private static C013000115_I i = new C013000115_I();
	private static C013000115_O o = new C013000115_O();
	public C013000115() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013000115_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 2,0, true, "证件类型" )))
					.addNode(new FieldNode("OldSerialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldSerialno", 50,0, false, "原始流水号" )))
					.addNode(new FieldNode("TimeOutFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "TimeOutFlag", 2,0, false, "是否超时查询" )))
					.addNode(new FieldNode("RequNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "RequNo", 50,0, false, "申请编号" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, true, "证件号码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C013000115_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("ApplyInfo",false)
							.addNode(new FieldNode("PhotoP", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhotoP", 50,0, true, "拍摄人像面" )))
							.addNode(new FieldNode("PhotoG", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhotoG", 50,0, true, "拍摄国徽面" )))
							.addNode(new FieldNode("PhotoC", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhotoC", 50,0, true, "银行卡正面" )))
							.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 2,0, true, "证件类型" )))
							.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, true, "证件号码" )))
							.addNode(new FieldNode("tranac", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranac", 40,0, false, "账号" )))
							.addNode(new FieldNode("NowAdd", new MsgField(ContentEnum.MessageType.STRING.toString(), "NowAdd", 256,0, true, "现居住地址" )))
							.addNode(new FieldNode("OffPho", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffPho", 20,0, true, "办公电话" )))
							.addNode(new FieldNode("OthPho", new MsgField(ContentEnum.MessageType.STRING.toString(), "OthPho", 50,0, true, "家庭电话" )))
							.addNode(new FieldNode("PostNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "PostNo", 50,0, true, "邮政编码" )))
							.addNode(new FieldNode("ProFee", new MsgField(ContentEnum.MessageType.STRING.toString(), "ProFee", 2,0, true, "职业" )))
							.addNode(new FieldNode("WorkUn", new MsgField(ContentEnum.MessageType.STRING.toString(), "WorkUn", 100,0, false, "工作单位" )))
							.addNode(new FieldNode("WorkAd", new MsgField(ContentEnum.MessageType.STRING.toString(), "WorkAd", 256,0, false, "工作单位地址" )))
							.addNode(new FieldNode("RequNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "RequNo", 50,0, false, "申请编号" )))
							.addNode(new FieldNode("IsPubl", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsPubl", 1,0, true, "是否对公业务" )))
							.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl", 20,0, true, "手机号码" )))
							.addNode(new FieldNode("PeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PeName", 20,0, true, "姓名" )))
							).addNode(new FieldNode("TtlNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TtlNum", 10,0, false, "明细总笔数" )))
					.addNode(new FieldNode("ListNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "ListNum", 10,0, false, "返回记录数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

