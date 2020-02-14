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
public class BODAFA1151 extends EciChannelService {

	private static BODAFA1151_I i = new BODAFA1151_I();
	private static BODAFA1151_O o = new BODAFA1151_O();
	public BODAFA1151() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1151_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("chlbusseq", new MsgField(ContentEnum.MessageType.STRING.toString(), "chlbusseq", 40,0, false, "原渠道业务流水号" )))
					
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1151_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("chlbusseq", new MsgField(ContentEnum.MessageType.STRING.toString(), "chlbusseq", 40,0, false, "渠道业务流水号" )))
					.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 80,0, false, "客户姓名" )))
					.addNode(new FieldNode("custsex", new MsgField(ContentEnum.MessageType.STRING.toString(), "custsex", 2, 0, false, "客户性别")))
					.addNode(new FieldNode("custage", new MsgField(ContentEnum.MessageType.STRING.toString(), "custage", 3, 0, false, "客户年龄")))
					.addNode(new FieldNode("custidtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "custidtype", 1, 0, false, "证件类型")))
					.addNode(new FieldNode("custidno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custidno", 40, 0, false, "证件号码")))
					.addNode(new FieldNode("custiddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "custiddate", 8, 0, false, "证件有效期")))
					.addNode(new FieldNode("facepipei", new MsgField(ContentEnum.MessageType.STRING.toString(), "facepipei", 50, 0, false, "人脸识别匹配值")))
					.addNode(new FieldNode("facemark", new MsgField(ContentEnum.MessageType.STRING.toString(), "facemark", 200, 0, false, "人脸识别备注")))
					.addNode(new FieldNode("imagenum", new MsgField(ContentEnum.MessageType.STRING.toString(), "imagenum", 2, 0, false, "图像数量")))
					.addNode(new FieldNode("imagefile", new MsgField(ContentEnum.MessageType.STRING.toString(), "imagefile", 80, 0, false, "图像文件名称")))
					.addNode(new FieldNode("authbusnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "authbusnum", 10, 0, false, "需授权业务明细数")))
					.addNode(new ArrayNode("bodrcd",true)
					.addNode(new FieldNode("busdtlno", new MsgField(ContentEnum.MessageType.STRING.toString(), "busdtlno", 40,0, false, "业务明细序号" )))
					.addNode(new FieldNode("busname", new MsgField(ContentEnum.MessageType.STRING.toString(), "busname", 80, 0, false, "业务明细名称")))
					.addNode(new FieldNode("busitems1", new MsgField(ContentEnum.MessageType.STRING.toString(), "busitems1", 1024, 0, false, "业务要素串1")))
					.addNode(new FieldNode("busitems2", new MsgField(ContentEnum.MessageType.STRING.toString(), "busitems2", 1024, 0, false, "业务要素串2")))
					.addNode(new FieldNode("busstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "busstatus", 1, 0, false, "业务授权状态")))
					
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}



}

