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
 * TRDCENTER.S012000403 OCR影像信息识别.身份证识别 
 * S0120004.03 ic0001
 * 0198 光学字符识别系统
 * @author XZF
 */
@Component
public class S012000403 extends EsbOcrChannelService {

	private static S012000403_I i = new S012000403_I();
	private static S012000403_O o = new S012000403_O();
	public S012000403() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S012000403_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("ReHead", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReHead", 1,0, false, "是否返回头像图片" )))
					.addNode(new FieldNode("ReCimg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReCimg", 1,0, false, "是否返回切边图" )))
					.addNode(new FieldNode("ReIimg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReIimg", 1,0, false, "是否返回身份证号码区域截图" )))
					.addNode(new FieldNode("DoMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "DoMode", 1,0, false, "识别模式" )))
					.addNode(new FieldNode("ImgBs", new MsgField(ContentEnum.MessageType.STRING.toString(), "ImgBs", 3145728,0, true, "jpg/jpeg格式的待识别图片" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S012000403_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("CustNa", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtcardNa", 256,0, false, "姓名" )))
					.addNode(new FieldNode("IdtfNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtcardNo", 30,0, false, "身份证号" )))
					.addNode(new FieldNode("BornDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "BornDt", 20,0, false, "出生日期" )))
					.addNode(new FieldNode("Gender", new MsgField(ContentEnum.MessageType.STRING.toString(), "Gender", 2,0, false, "性别" )))
					.addNode(new FieldNode("CutyCd", new MsgField(ContentEnum.MessageType.STRING.toString(), "CutyCd", 256,0, false, "民族" )))
					.addNode(new FieldNode("Addres", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtcardAddres", 256,0, false, "住址" )))
					.addNode(new FieldNode("Issuer", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtcardIssuer", 256,0, false, "签发机关" )))
					.addNode(new FieldNode("CdVlDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtcardVlDt", 23,0, false, "有效期" )))
					.addNode(new FieldNode("IdCimg", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdCimg", 2097152,0, false, "身份证切边图片" )))
					.addNode(new FieldNode("IdNimg", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdNimg", 512000,0, false, "身份证号码截图" )))
					.addNode(new FieldNode("IdHinfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdHinfo", 512000,0, false, "身份证正面头像信息" )))
					.addNode(new FieldNode("IdHimg", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdHimg", 512000,0, false, "身份证正面头像截图" )))
					.addNode(new FieldNode("CardTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "CardTp", 20,0, false, "类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
