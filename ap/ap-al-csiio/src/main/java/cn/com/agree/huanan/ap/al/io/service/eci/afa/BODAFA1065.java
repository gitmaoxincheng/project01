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
 * BASESVC BODAFA1065  录音录像查询交易 
 *  BODAFA1065 205006
 *  综合前置
 * @author LSJ
 */
@Component
public class BODAFA1065 extends EciChannelService {

	private static BODAFA1065_I i = new BODAFA1065_I();
	private static BODAFA1065_O o = new BODAFA1065_O();
	public BODAFA1065() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1065_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 40,0, false, "卡号或帐号" )))
					.addNode(new FieldNode("editflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "editflag", 20,0, false, "修改标志" )))
					.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedate", 8,0, false, "交易日期" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 3,0, false, "证件类型" )))
					.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("prdtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdtype", 2,0, false, "产品类型" )))
					.addNode(new FieldNode("prdcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdcode", 6,0, false, "产品代码" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 2,0, false, "状态" )))
					.addNode(new FieldNode("wmvserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "wmvserno", 20,0, false, "录制编号" )))
					.addNode(new FieldNode("pageflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageflag", 1,0, false, "翻页标识" )))
					.addNode(new FieldNode("maxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxnum", 10,0, false, "每页最多记录数" )))
					.addNode(new FieldNode("idxtradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxtradedate", 8,0, false, "翻页索引1" )))
					.addNode(new FieldNode("idxwmvserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxwmvserno", 20,0, false, "翻页索引2" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1065_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					//.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("totalnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalnum", 8,0, false, "总记录数" )))
					.addNode(new FieldNode("returnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "returnum", 2,0, false, "本次返回记录数" )))
					.addNode(new ArrayNode("bodrcd",false,"video_list")
							.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedate", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 40,0, false, "卡号帐号" )))
							.addNode(new FieldNode("editflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "editflag", 20,0, false, "修改标志" )))
							.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 2,0, false, "证件类型" )))
							.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 30,0, false, "证件号码" )))
							.addNode(new FieldNode("prdtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdtype", 2,0, false, "产品类型" )))
							.addNode(new FieldNode("prdcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdcode", 6,0, false, "产品代码" )))
							.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 2,0, false, "状态" )))
							.addNode(new FieldNode("wmvserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "wmvserno", 20,0, false, "录制编号" )))
							.addNode(new FieldNode("authno", new MsgField(ContentEnum.MessageType.STRING.toString(), "authno", 10,0, false, "复核柜员号" )))
							.addNode(new FieldNode("authna", new MsgField(ContentEnum.MessageType.STRING.toString(), "authna", 20,0, false, "复核柜员名称" )))
							)
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

