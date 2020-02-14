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
 * TRDCENTER.S012000401 OCR影像信息识别.银行卡识别 
 * S0120004.01 bc0001
 * 0198 光学字符识别系统
 * @author XZF
 */
@Component
public class S012000401 extends EsbOcrChannelService {

	private static S012000401_I i = new S012000401_I();
	private static S012000401_O o = new S012000401_O();
	public S012000401() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S012000401_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("ReNimg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReNimg", 1,0, false, "是否返回号码区域图片" )))
					.addNode(new FieldNode("ReIssu", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReIssu", 1,0, false, "是否返回发卡机构信息" )))
					.addNode(new FieldNode("ImgBs", new MsgField(ContentEnum.MessageType.STRING.toString(), "ImgBs", 3145728,0, true, "jpg/jpeg格式的待识别图片" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S012000401_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("CardTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "bnkcrdTp", 20,0, false, "银行卡类型" )))
					.addNode(new FieldNode("CardNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "CardNo", 30,0, false, "银行卡号" )))
					.addNode(new FieldNode("CdVlDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "bnkcrdVlDt", 10,0, false, "有效期" )))
					.addNode(new FieldNode("CustNa", new MsgField(ContentEnum.MessageType.STRING.toString(), "bnkcrdNa", 256,0, false, "持卡人" )))
					.addNode(new FieldNode("Issuer", new MsgField(ContentEnum.MessageType.STRING.toString(), "bnkcrdIssuer", 256,0, false, "发卡机构" )))
					.addNode(new FieldNode("Idnimg", new MsgField(ContentEnum.MessageType.STRING.toString(), "bnkcrdIdnimg", 3145728,0, false, "卡号区域截图" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
