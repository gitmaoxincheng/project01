package cn.com.agree.huanan.ap.al.io.service.eci.ebp;

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

/**
 * BASESVC.BODEBP0003 .国别查询 
 * .BODEBP0003 
 *  国结系统
 * @author XZF
 */
@Component
public class BODEBP0003 extends EciChannelService {

//	private static BODEBP0003_I i = new BODEBP0003_I();
	private static BODEBP0003_O o = new BODEBP0003_O();
	public BODEBP0003() {
//		requestFormat.add(i);
		responseFormat.add(o);
	}

/*	public static class BODEBP0003_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body"));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
*/
	public static class BODEBP0003_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 1024,0, false, "返回记录数" )))
					.addNode(new FieldNode("pages", new MsgField(ContentEnum.MessageType.STRING.toString(), "pages", 1024,0, false, "分页后实际条数" )))
					.addNode(new ArrayNode("bodrcd",false,"cninfo_list")
						.addNode(new FieldNode("countryNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "countryNo", 3,0, false, "数字代码" )))
						.addNode(new FieldNode("cnName", new MsgField(ContentEnum.MessageType.STRING.toString(), "cnName", 40,0, false, "国家名称" )))
						.addNode(new FieldNode("safeCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "safeCode", 32,0, false, "国家地区代码" )))
						));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
