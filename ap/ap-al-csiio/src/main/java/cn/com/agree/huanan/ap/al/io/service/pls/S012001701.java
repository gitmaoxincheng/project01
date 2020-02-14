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
 * BASESVC.S012001701 影像合成.PDF模板业务数据合成 
 * S0120017.01 cfca1001
 * 0221 无纸化电子签名系统
 * @author YYX
 */
@Component
public class S012001701 extends EsbChannelService {

	private static S012001701_I i = new S012001701_I();
	private static S012001701_O o = new S012001701_O();

	public S012001701() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S012001701_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("operatorCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatorCode", 12,0, true, "机构编码（机构号）" )))
					.addNode(new FieldNode("tellerNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerNo", 10,0, true, "经办人（柜员号）" )))
					.addNode(new FieldNode("BizSerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BizSerialNo", 256,0, true, "交易流水号" )))
					.addNode(new FieldNode("ChannelSerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ChannelSerialNo", 40,0, true, "渠道流水号（单据号）" )))
					.addNode(new FieldNode("TemplateCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TemplateCode", 500,0, true, "模板号" )))
					.addNode(new FieldNode("SavePdfMethod", new MsgField(ContentEnum.MessageType.STRING.toString(), "SavePdfMethod", 1,0, true, "生成pdf方式" )))
					.addNode(new FieldNode("PicAmount", new MsgField(ContentEnum.MessageType.STRING.toString(), "PicAmount", 5,0, true, "上传图片数量" )))
					.addNode(new StructNode("ImageList",false)
							.addNode(new ArrayNode("Image",false)
									.addNode(new FieldNode("ImagePath", new MsgField(ContentEnum.MessageType.STRING.toString(), "ImagePath", 300,0, false, "图片文件" )))
									.addNode(new FieldNode("ImageWidth", new MsgField(ContentEnum.MessageType.STRING.toString(), "ImageWidth", 5,0, false, "图片宽度" )))
									.addNode(new FieldNode("ImageHeight", new MsgField(ContentEnum.MessageType.STRING.toString(), "ImageHeight", 5,0, false, "图片高度" )))
									.addNode(new FieldNode("type", new MsgField(ContentEnum.MessageType.STRING.toString(), "type", 1,0, false, "合成图片的方式" )))
									.addNode(new FieldNode("PageNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "PageNo", 3,0, false, "页码" )))
									.addNode(new FieldNode("LX", new MsgField(ContentEnum.MessageType.STRING.toString(), "LX", 5,0, false, "X坐标" )))
									.addNode(new FieldNode("LY", new MsgField(ContentEnum.MessageType.STRING.toString(), "LY", 5,0, false, "Y坐标" )))
									.addNode(new FieldNode("offsetX", new MsgField(ContentEnum.MessageType.STRING.toString(), "offsetX", 5,0, false, "X轴偏移量" )))
									.addNode(new FieldNode("offsetY", new MsgField(ContentEnum.MessageType.STRING.toString(), "offsetY", 5,0, false, "Y轴偏移量" )))
									.addNode(new FieldNode("locationStyle", new MsgField(ContentEnum.MessageType.STRING.toString(), "locationStyle", 1,0, false, "关键字风格" )))
									.addNode(new FieldNode("Keyword", new MsgField(ContentEnum.MessageType.STRING.toString(), "Keyword", 100,0, false, "关键字" )))
									.addNode(new FieldNode("TemplateIndex", new MsgField(ContentEnum.MessageType.STRING.toString(), "TemplateIndex", 2,0, false, "PDF模板索引" )))
									)).addNode(new StructNode("FieldList",false)
											.addNode(new ArrayNode("Field",false)
													.addNode(new FieldNode("FieldId", new MsgField(ContentEnum.MessageType.STRING.toString(), "FieldId", 50,0, false, "文本域名称" )))
													.addNode(new FieldNode("FieldValue", new MsgField(ContentEnum.MessageType.STRING.toString(), "FieldValue", 1000,0, false, "文本域填充值" )))
													.addNode(new FieldNode("FieldType", new MsgField(ContentEnum.MessageType.STRING.toString(), "FieldType", 10,0, false, "文本域类型" )))
													.addNode(new FieldNode("TemplateIndex", new MsgField(ContentEnum.MessageType.STRING.toString(), "TemplateIndex", 2,0, false, "PDF模板索引" )))
													)).addNode(new StructNode("textList",false)
															.addNode(new ArrayNode("text",false)
																	.addNode(new FieldNode("textFontSize", new MsgField(ContentEnum.MessageType.STRING.toString(), "textFontSize", 3,0, false, "文本内容字体大小" )))
																	.addNode(new FieldNode("textValue", new MsgField(ContentEnum.MessageType.STRING.toString(), "textValue",1000,0, false, "需要合成的文本内容" )))
																	.addNode(new FieldNode("pageNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageNo", 3,0, false, "页码" )))
																	.addNode(new FieldNode("textColor", new MsgField(ContentEnum.MessageType.STRING.toString(), "textColor", 20,0, false, "文本内容字体颜色" )))
																	.addNode(new FieldNode("type", new MsgField(ContentEnum.MessageType.STRING.toString(), "type", 1,0, false, "合成文本数据的方式" )))
																	.addNode(new FieldNode("lx", new MsgField(ContentEnum.MessageType.STRING.toString(), "lx", 5,0, false, "X坐标" )))
																	.addNode(new FieldNode("ly", new MsgField(ContentEnum.MessageType.STRING.toString(), "ly", 5,0, false, "Y坐标" )))
																	.addNode(new FieldNode("spacingHeight", new MsgField(ContentEnum.MessageType.STRING.toString(), "spacingHeight", 5,0, false, "文本内容行间距" )))
																	.addNode(new FieldNode("templateIndex", new MsgField(ContentEnum.MessageType.STRING.toString(), "templateIndex", 2,0, false, "PDF模板索引" )))
																	)));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S012001701_O extends MsgBody {
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
