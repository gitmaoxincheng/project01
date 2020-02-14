package cn.com.agree.huanan.ap.al.io.service.eci.hst;

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
 * BASESVC BODHST1180  委托明细查询 
 *  BODHST1180 
 *  旧核心系统
 * @author XZF
 */
@Component
public class BODHST1180 extends EciChannelService {

	private static BODHST1180_I i = new BODHST1180_I();
	private static BODHST1180_O o = new BODHST1180_O();
	public BODHST1180() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODHST1180_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 2,0, false, "证件类型" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 50,0, false, "证件号" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 40,0, false, "大额专用账号" )))
					.addNode(new FieldNode("certno", new MsgField(ContentEnum.MessageType.STRING.toString(), "certno", 30,0, false, "大额存单产品代码" )))
					.addNode(new FieldNode("rcrdnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcrdnm", 3,0, false, "每页个数" )))
					.addNode(new FieldNode("trandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt", 8,0, false, "交易日期" )))
					.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 24,0, false, "交易流水" )))
					.addNode(new FieldNode("certtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "certtp", 1,0, false, "产品类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODHST1180_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq", 20,0, false, "报文流水" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 300,0, false, "出错信息" )))
					.addNode(new FieldNode("script", new MsgField(ContentEnum.MessageType.STRING.toString(), "script", 1000,0, false, "出错脚本" )))
					.addNode(new ArrayNode("listnm",false)
							).addNode(new StructNode("bodrcd",true)
									.addNode(new FieldNode("trandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt", 8,0, false, "交易日期" )))
									.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 20,0, false, "交易流水" )))
									.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranam", 18,0, false, "认购金额" )))
									.addNode(new FieldNode("buysac", new MsgField(ContentEnum.MessageType.STRING.toString(), "buysac", 40,0, false, "认购账号" )))
									.addNode(new FieldNode("mtreac", new MsgField(ContentEnum.MessageType.STRING.toString(), "mtreac", 40,0, false, "到期兑付账号" )))
									.addNode(new FieldNode("servtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "servtp", 6,0, false, "交易渠道" )))
									));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

