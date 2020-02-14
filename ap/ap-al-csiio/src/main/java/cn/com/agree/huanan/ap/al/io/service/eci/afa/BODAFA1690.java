package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODAFA1690  柜员间贷记卡调剂明细查询 
 *  BODAFA1690 883748
 *  综合前置
 * @author LSJ
 */
@Component
public class BODAFA1690 extends EciChannelService {
 
	private static BODAFA1690_I i = new BODAFA1690_I();
	private static BODAFA1690_O o = new BODAFA1690_O();
	public BODAFA1690() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODAFA1690_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
				.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
				.addNode(new FieldNode("opdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "opdate", 8,0, false, "日期" )))
				.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 32,0, false, "批次号" )))
				.addNode(new FieldNode("regutp", new MsgField(ContentEnum.MessageType.STRING.toString(), "regutp", 1,0, false, "调剂类型 0-批量开户,1-调出，2-调入" )))
				.addNode(new FieldNode("teller", new MsgField(ContentEnum.MessageType.STRING.toString(), "teller", 10,0, false, "柜员号" )))
				.addNode(new FieldNode("maxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxnum", 10,0, false, "每页最大记录数" )))
				.addNode(new FieldNode("pageflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageflag", 1,0, false, "翻页标识" )))
				.addNode(new FieldNode("idxtradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxtradedate", 8,0, false, "翻页交易日期" )))
				.addNode(new FieldNode("idxserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxserialno", 32,0, false, "翻页交易流水" )))
				.addNode(new FieldNode("sendtl", new MsgField(ContentEnum.MessageType.STRING.toString(), "sendtl", 10,0, false, "调出柜员号" )))
				.addNode(new FieldNode("recvtl", new MsgField(ContentEnum.MessageType.STRING.toString(), "recvtl", 10,0, false, "调入柜员号" )))
				.addNode(new FieldNode("note1", new MsgField(ContentEnum.MessageType.STRING.toString(), "note1", 1,0, false, "调入调出标志 1-已调出 2-已调入" )))
				);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1690_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
				//.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
				.addNode(new FieldNode("totnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totnum", 10,0, false, "总记录数" )))
				.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 10,0, false, "返回记录数" )))
				.addNode(new ArrayNode("bodrcd",false,"detail_list")
					.addNode(new FieldNode("strtradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "strtradedate", 8,0, false, "前置日期" )))
					.addNode(new FieldNode("strserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "strserialno", 32,0, false, "前置流水" )))
					.addNode(new FieldNode("opdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "opdate", 8,0, false, "日期" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 32,0, false, "批次号" )))
					.addNode(new FieldNode("cardtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardtp", 32,0, false, "批次号" )))
					.addNode(new FieldNode("regutp", new MsgField(ContentEnum.MessageType.STRING.toString(), "regutp", 1,0, false, "调剂类型" )))
					.addNode(new FieldNode("recvtl", new MsgField(ContentEnum.MessageType.STRING.toString(), "recvtl", 10,0, false, "调入柜员" )))
					.addNode(new FieldNode("recvtn", new MsgField(ContentEnum.MessageType.STRING.toString(), "recvtn", 60,0, false, "调入柜员名称" )))
					.addNode(new FieldNode("sendtl", new MsgField(ContentEnum.MessageType.STRING.toString(), "sendtl", 10,0, false, "调出柜员" )))
					.addNode(new FieldNode("sendtn", new MsgField(ContentEnum.MessageType.STRING.toString(), "sendtn", 60,0, false, "调出柜员名称" )))
					.addNode(new FieldNode("catedesc", new MsgField(ContentEnum.MessageType.STRING.toString(), "catedesc", 60,0, false, "卡类型名称" )))
				));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

