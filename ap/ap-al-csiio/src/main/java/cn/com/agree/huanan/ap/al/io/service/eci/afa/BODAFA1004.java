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
@Component
public class BODAFA1004 extends EciChannelService {

	private static BODAFA1004_I i = new BODAFA1004_I();
	private static BODAFA1004_O o = new BODAFA1004_O();
	public BODAFA1004 () {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1004_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("bgdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "bgdate", 10,0, false, "报文开始日期" )))
					.addNode(new FieldNode("eddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "eddate", 10,0, false, "报文结束日期" )))
					.addNode(new FieldNode("pageflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageflag", 01,0, false, "翻页标识" )))
					.addNode(new FieldNode("maxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxnum", 06,0, false, "每页最多记录数" )))
					.addNode(new FieldNode("banknotp", new MsgField(ContentEnum.MessageType.STRING.toString(), "banknotp", 3,0, false, "类别" )))
					.addNode(new FieldNode("bankstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankstatus", 1,0, false, "状态" )))
					.addNode(new FieldNode("banktp", new MsgField(ContentEnum.MessageType.STRING.toString(), "banktp", 3,0, false, "行别代码" )))
					.addNode(new FieldNode("bankno", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankno", 10,0, false, "行号" )))
					.addNode(new FieldNode("bankname", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankname", 40,0, false, "行名" )))
					.addNode(new FieldNode("idxbankno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxbankno", 512,0, false, "行号索引" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 3,0, false, "记录数" )))
					.addNode(new StructNode("bodrcd",true)
					.addNode(new FieldNode("addrcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrcode", 40,0, false, "地区号" )))
					));
			return messageNode;
		}  
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1004_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("totnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totnum", 8,0, false, "总记录数" )))
					.addNode(new FieldNode("returnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "returnum", 8,0, false, "当前记录数" )))
					.addNode(new ArrayNode("bodrcd",false)
					.addNode(new FieldNode("bankno", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankno", 15,0, false, "行号" )))
					.addNode(new FieldNode("bankname", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankname", 120,0, false, "行名" )))
					.addNode(new FieldNode("telephone", new MsgField(ContentEnum.MessageType.STRING.toString(), "telephone", 15,0, false, "电话" )))
					.addNode(new FieldNode("address", new MsgField(ContentEnum.MessageType.STRING.toString(), "address", 8,0, false, "地址" )))
					.addNode(new FieldNode("postcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcode", 10,0, false, "邮编" )))
					.addNode(new FieldNode("bankstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankstatus", 10,0, false, "状态" )))
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
