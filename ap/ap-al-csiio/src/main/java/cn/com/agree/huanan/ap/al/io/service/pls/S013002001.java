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
 * BASESVC.S013002001 PDF信息查询.合同信息查询 
 * S0130020.01 cfca4001
 * 0221 无纸化电子签名系统
 * @author LW
 */
@Component
public class S013002001 extends EsbChannelService {
/*


*/
	private static S013002001_I i = new S013002001_I();
	private static S013002001_O o = new S013002001_O();
	public S013002001() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class S013002001_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
				.addNode(new FieldNode("BizSerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BizSerialNo", 256,0, false, "交易流水号" )))
				.addNode(new FieldNode("ChannelSerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ChannelSerialNo", 40,0, false, "渠道交易流水号（单据号）" )))
				.addNode(new FieldNode("tellerNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerNo", 10,0, false, "经办人（柜员号）" )))
				.addNode(new FieldNode("subChannelCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "subChannelCode", 3,0, false, "业务渠道代码" )))
				.addNode(new FieldNode("SavePdfMethod", new MsgField(ContentEnum.MessageType.STRING.toString(), "SavePdfMethod", 1,0, false, "单据生成方式" )))
				.addNode(new FieldNode("StartDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "StartDate", 8,0, false, "起始日期" )))
				.addNode(new FieldNode("EndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "EndDate", 8,0, false, "结束日期" )))
				);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S013002001_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
				.addNode(new FieldNode("TotalNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotalNum", 8,0, true, "查询结果数量" )))
				.addNode(new ArrayNode("PdfList",false)
					.addNode(new FieldNode("ContentID", new MsgField(ContentEnum.MessageType.STRING.toString(), "ContentID", 80,0, false, "内容ID" )))
					.addNode(new FieldNode("startdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "startdate", 8,0, false, "上传影像平台时间" )))
					.addNode(new FieldNode("TellerNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "TellerNo", 10,0, false, "柜员号" )))
					.addNode(new FieldNode("OperatorCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "OperatorCode", 10,0, true, "机构编码（机构号）" )))
					.addNode(new FieldNode("bizSerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "bizSerialNo", 80,0, false, "交易流水号" )))
					.addNode(new FieldNode("ChannelSerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ChannelSerialNo", 40,0, false, "渠道交易流水号（单据号）" )))
					.addNode(new FieldNode("SubChanelCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "SubChanelCode", 3,0, true, "业务渠道代码" )))
				));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

