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
 * BASESVC BODEBP0004  收款行信息查询 
 *  BODEBP0004 
 *  国结系统
 * @author XZF
 */
@Component
public class BODEBP0004 extends EciChannelService {

	private static BODEBP0004_I i = new BODEBP0004_I();
	private static BODEBP0004_O o = new BODEBP0004_O();
	public BODEBP0004() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODEBP0004_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("countryNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "countryNo", 3,0, false, "国家数字代码" )))
					.addNode(new FieldNode("countryName", new MsgField(ContentEnum.MessageType.STRING.toString(), "countryName", 11,0, false, "收款行名称" )))
					.addNode(new FieldNode("pagevl", new MsgField(ContentEnum.MessageType.STRING.toString(), "pagevl", 30,0, false, "翻页字段" )))
					.addNode(new FieldNode("rcrdnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcrdnm", 3,0, false, "最大查询记录数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODEBP0004_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("code", new MsgField(ContentEnum.MessageType.STRING.toString(), "code", 8,0, false, "错误码" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 1024,0, false, "返回记录数" )))
					.addNode(new FieldNode("pages", new MsgField(ContentEnum.MessageType.STRING.toString(), "pages", 1024,0, false, "分页后实际条数" )))
					.addNode(new ArrayNode("bodrcd",false,"SwiftCode_list")
					.addNode(new FieldNode("bankSwiftCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankSwiftCode", 11,0, false, "收款行SWIFTCODE " )))
						.addNode(new FieldNode("enName", new MsgField(ContentEnum.MessageType.STRING.toString(), "enName", 40,0, false, "收款行英文名称" )))
						.addNode(new FieldNode("localName", new MsgField(ContentEnum.MessageType.STRING.toString(), "localName", 100,0, false, "收款行本地名称" )))
						.addNode(new FieldNode("country", new MsgField(ContentEnum.MessageType.STRING.toString(), "country", 50,0, false, "国家名称" )))
						.addNode(new FieldNode("countryNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "countryNo", 3,0, false, "国家名称代码" )))
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

