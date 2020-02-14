package cn.com.agree.huanan.ap.al.io.service.pls;

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
 * BASESVC.S014000202 电子签名文件管理.PDF电子签名（场景证书签章） 
 * S0140002.02 cfca2001
 * 0221 无纸化电子签名系统
 * @author YYX
 */
@Component
public class S014000202 extends EsbChannelService {

	private static S014000202_I i = new S014000202_I();
	private static S014000202_O o = new S014000202_O();

	public S014000202() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S014000202_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("OperatorTy", new MsgField(ContentEnum.MessageType.STRING.toString(), "OperatorTy", 1,0, true, "操作类型" )))
					.addNode(new FieldNode("BizSerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BizSerialNo", 256,0, true, "交易流水号" )))
					.addNode(new FieldNode("ChannelSerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ChannelSerialNo", 40,0, false, "单据号" )))
					.addNode(new FieldNode("PdfFile", new MsgField(ContentEnum.MessageType.STRING.toString(), "PdfFile", 500,0, false, "待签章PDF文件" )))
					.addNode(new StructNode("ProofFileList",false)
							.addNode(new ArrayNode("ProofFile",false)
									.addNode(new FieldNode("FilePath", new MsgField(ContentEnum.MessageType.STRING.toString(), "FilePath", 100,0, true, "场景证据文件名字" )))
									.addNode(new FieldNode("Type", new MsgField(ContentEnum.MessageType.STRING.toString(), "Type", 1,0, true, "场景证据文件存放类型" )))
									)).addNode(new StructNode("ProofSealStrategy",false)
											.addNode(new ArrayNode("ProofSeal",false)
													.addNode(new FieldNode("HandwritingImage", new MsgField(ContentEnum.MessageType.STRING.toString(), "HandwritingImage", 100,0, true, "手写签名图片" )))
													.addNode(new FieldNode("IdentificationType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdentificationType", 1,0, true, "证件类型" )))
													.addNode(new FieldNode("IdentificationNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdentificationNo", 30,0, true, "证件号码" )))
													.addNode(new ArrayNode("LocationList",false)
															.addNode(new FieldNode("Keyword", new MsgField(ContentEnum.MessageType.STRING.toString(), "Keyword", 100,0, true, "关键字" )))
															))).addNode(new StructNode("SealStrategy",false)
																	.addNode(new ArrayNode("Seal",false)
																			.addNode(new FieldNode("SealCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "SealCode", 30,0, true, "印章编码" )))
																			.addNode(new FieldNode("SealPassword", new MsgField(ContentEnum.MessageType.STRING.toString(), "SealPassword", 30,0, true, "印章密码" )))
																			.addNode(new ArrayNode("LocationList",false)
																					.addNode(new FieldNode("Keyword", new MsgField(ContentEnum.MessageType.STRING.toString(), "Keyword", 100,0, false, "关键字" )))
																					))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S014000202_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
