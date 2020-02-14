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
 * BASESVC.S012001510 机构管理.机构日终签退 
 * S0120015.10 exitbr
 * 0009 大总账
 * @author XZF
 */
@Component
public class S012001510 extends EsbGlsChannelService {

	private static S012001510_I i = new S012001510_I();
	private static S012001510_O o = new S012001510_O();
	public S012001510() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S012001510_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("tranbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranbr", 12,0, true, "机构代码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S012001510_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("tolnum", new MsgField(ContentEnum.MessageType.INT.toString(), "tolnum", 10,0, true, "总笔数" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.INT.toString(), "listnm", 10,0, true, "返回记录数" )))
					.addNode(new FieldNode("limits", new MsgField(ContentEnum.MessageType.STRING.toString(), "limits", 1,0, true, "限制标识" )))
					.addNode(new ArrayNode("data_list",false)
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

