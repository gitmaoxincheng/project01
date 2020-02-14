package cn.com.agree.huanan.ap.al.io.service.gls;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbGlsChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.S013001320 柜员机构信息查询.	机构未处理事项查询 
 * S0130013.20 qrbrel
 * 0009 总账
 * @author JZF
 */
@Component
public class S013001320 extends EsbGlsChannelService {
	private static S013001320_I i = new S013001320_I();
	private static S013001320_O o = new S013001320_O();

	public S013001320() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013001320_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("tranbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranbr", 12,0, true, "机构代码" )))
					.addNode(new FieldNode("rowsid", new MsgField(ContentEnum.MessageType.INT.toString(), "rowsid", 10,0, true, "当前页" )))
					.addNode(new FieldNode("rcrdnm", new MsgField(ContentEnum.MessageType.INT.toString(), "rcrdnm", 10,0, true, "每页记录数" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S013001320_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("tolnum", new MsgField(ContentEnum.MessageType.INT.toString(), "tolnum", 10,0, true, "总笔数" )))
					.addNode(new FieldNode("tranus", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranus", 10,0, true, "柜员号" )))
					.addNode(new FieldNode("tranbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranbr", 12,0, true, "机构代码" )))
					.addNode(new FieldNode("infonm", new MsgField(ContentEnum.MessageType.INT.toString(), "infonm", 10,0, true, "提示记录数" )))
					.addNode(new ArrayNode("info_list",false)
							.addNode(new FieldNode("limits", new MsgField(ContentEnum.MessageType.STRING.toString(), "limits", 1,0, true, "限制标识" )))
							.addNode(new FieldNode("systna", new MsgField(ContentEnum.MessageType.STRING.toString(), "systna", 60,0, true, "系统名称" )))
							.addNode(new FieldNode("systid", new MsgField(ContentEnum.MessageType.STRING.toString(), "systid", 4,0, true, "系统标识" )))
							.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 32,0, true, "交易流水" )))
							.addNode(new FieldNode("trandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt", 8,0, true, "交易日期" )))
							.addNode(new FieldNode("trantp", new MsgField(ContentEnum.MessageType.STRING.toString(), "trantp", 1,0, true, "业务类型" )))
							.addNode(new FieldNode("htinfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "htinfo", 1024,0, true, "提示信息" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
