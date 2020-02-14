package cn.com.agree.huanan.ap.al.io.service.eci.hst;

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
 * BASESVC BODHST1275  医保账户交易明细查询 
 *  BODHST1275 regflw
 *  旧核心
 * @author XZF
 */
@Component
public class BODHST1275 extends EciChannelService {

	private static BODHST1275_I i = new BODHST1275_I();
	private static BODHST1275_O o = new BODHST1275_O();
	public BODHST1275() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODHST1275_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 1024,0, false, "卡号" )))
					.addNode(new FieldNode("bgindt", new MsgField(ContentEnum.MessageType.STRING.toString(), "bgindt", 1024,0, false, "起始日期" )))
					.addNode(new FieldNode("endsdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "endsdt", 1024,0, false, "结束日期" )))
					.addNode(new FieldNode("pgdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "pgdate", 1024,0, false, "翻页日期" )))
					.addNode(new FieldNode("billsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "billsq", 1024,0, false, "翻页账单流水" )))
					.addNode(new FieldNode("rcrdnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcrdnm", 1024,0, false, "每页条数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODHST1275_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq", 1024,0, false, "报文流水" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 300,0, false, "出错信息" )))
					.addNode(new FieldNode("rtcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "rtcode", 1024,0, false, "出错码" )))
					.addNode(new FieldNode("script", new MsgField(ContentEnum.MessageType.STRING.toString(), "script", 255,0, false, "出错脚本" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 1024,0, false, "记录数" )))
					.addNode(new StructNode("bodrcd",true)
							.addNode(new FieldNode("trandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("billsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "billsq", 220,0, false, "账单流水" )))
							.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 220,0, false, "交易流水" )))
							.addNode(new FieldNode("tranti", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranti", 225,0, false, "交易时间" )))
							.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 220,0, false, "卡号" )))
							.addNode(new FieldNode("smrycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "smrycd", 1024,0, false, "摘要码" )))
							.addNode(new FieldNode("amntcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "amntcd", 1,0, false, "记账方向" )))
							.addNode(new FieldNode("crcycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "crcycd", 2,0, false, "币种" )))
							.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "tranam", 18,2, false, "交易金额" )))
							.addNode(new FieldNode("tranbl", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "tranbl", 18,2, false, "医保账户余额" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

