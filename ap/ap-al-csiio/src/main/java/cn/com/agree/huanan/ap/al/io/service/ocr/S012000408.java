package cn.com.agree.huanan.ap.al.io.service.ocr;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbOcrChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * TRDCENTER.S012000408 OCR影像信息识别.营业执照识别 
 * S0120004.08 bl0001
 * 0198 光学字符识别系统
 * @author XZF
 */
@Component
public class S012000408 extends EsbOcrChannelService {

	private static S012000408_I i = new S012000408_I();
	private static S012000408_O o = new S012000408_O();
	public S012000408() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S012000408_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true).addNode(new FieldNode("ImgBs", new MsgField(ContentEnum.MessageType.STRING.toString(), "ImgBs", 1843200,0, true, "jpg/jpeg格式的待识别图片" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S012000408_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("IdtfTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsnliceTp", 120,0, false, "公司证照类型" )))
					.addNode(new FieldNode("CompNa", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsnliceCompNa", 256,0, false, "名称" )))
					.addNode(new FieldNode("CompTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsnliceCompTp", 120,0, false, "公司类型" )))
					.addNode(new FieldNode("Addres", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsnliceAddres", 256,0, false, "住所" )))
					.addNode(new FieldNode("RgCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsnliceRgCode", 32,0, false, "注册号" )))
					.addNode(new FieldNode("IdtfNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsnliceNo", 32,0, false, "证照编号" )))
					.addNode(new FieldNode("CustNa", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsnliceCustNa", 120,0, false, "法定代表人姓名" )))
					.addNode(new FieldNode("RegAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsnliceRegAmt", 120,0, false, "注册资本" )))
					.addNode(new FieldNode("ReaAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsnliceReaAmt", 120,0, false, "实收资本" )))
					.addNode(new FieldNode("BScope", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsnlicecope", 512,0, false, "经营范围" )))
					.addNode(new FieldNode("EfctDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsnliceEfctDt", 20,0, false, "成立日期" )))
					.addNode(new FieldNode("CdVlDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsnliceCdVlDt", 40,0, false, "营业期限" )))
					.addNode(new FieldNode("CdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsnliceCdCode", 32,0, false, "统一社会信用代码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
