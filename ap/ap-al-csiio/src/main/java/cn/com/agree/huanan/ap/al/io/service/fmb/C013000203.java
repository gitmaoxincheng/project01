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
 * BASESVC.C013000203 影像信息查询.微网点申请信息查询 
 * C0130002.03 8819714
 * 0339 综合前置(微网点模块)
 * @author XZF
 */
@Component
public class C013000203 extends EsbChannelService {

	private static C013000203_I i = new C013000203_I();
	private static C013000203_O o = new C013000203_O();
	public C013000203() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013000203_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("RequNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "RequNo", 50,0, false, "申请编号" )))
					.addNode(new FieldNode("ApplyStDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "ApplyStDt", 8,0, false, "起始申请日期" )))
					.addNode(new FieldNode("ApplyEnDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "ApplyEnDt", 8,0, false, "截止申请日期" )))
					.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 256,0, false, "姓名" )))
					.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl", 20,0, false, "手机号码" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("pageFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageFlag", 1,0, true, "翻页标志" )))
					.addNode(new FieldNode("serialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "serialno", 8,0, true, "前置流水号" )))
					.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedate", 8,0, true, "前置日期" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C013000203_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("ApplyInfo",false)
							.addNode(new FieldNode("RequNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "RequNo", 50,0, false, "申请编号" )))
							.addNode(new FieldNode("ApplyDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "ApplyDt", 8,0, false, "申请日期" )))
							.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 256,0, false, "姓名" )))
							.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl", 20,0, false, "手机号码" )))
							.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, false, "证件号码" )))
							.addNode(new FieldNode("BusiType", new MsgField(ContentEnum.MessageType.STRING.toString(), "BusiType", 2,0, false, "业务类型" )))
							.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 2,0, false, "申请状态" )))
							.addNode(new FieldNode("serialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "serialno", 8,0, false, "前置流水号" )))
							.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedate", 8,0, false, "前置日期" )))
							.addNode(new FieldNode("ContentId", new MsgField(ContentEnum.MessageType.STRING.toString(), "ContentId", 256,0, false, "图片批次号" )))
							.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 40,0, false, "银行卡号" )))
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

