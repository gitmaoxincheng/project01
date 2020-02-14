package cn.com.agree.huanan.ap.al.io.service.eci.afa;

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
 * BASESVC BODAFA1094  理财平台产品协议查询 
 *  BODAFA1094 884004
 *  旧核心
 * @author XZF
 */
@Component
public class BODAFA1094 extends EciChannelService {

	private static BODAFA1094_I i = new BODAFA1094_I();
	private static BODAFA1094_O o = new BODAFA1094_O();
	public BODAFA1094() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1094_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("pageflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageflag", 1,0, false, "翻页标识" )))
					.addNode(new FieldNode("maxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxnum", 2,0, false, "查询最大记录数" )))
					.addNode(new FieldNode("bankacc", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankacc", 40,0, true, "银行账号" )))
					.addNode(new FieldNode("userno", new MsgField(ContentEnum.MessageType.STRING.toString(), "userno", 20,0, false, "产品代码" )))
					.addNode(new FieldNode("origcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "origcode", 20,0, false, "TA代码" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1,0, false, "协议状态" )))
					.addNode(new FieldNode("idxcustregno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxcustregno", 30,0, false, "翻页字段" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1094_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("retnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "retnum", 10,0, false, "当前记录数" )))
					.addNode(new ArrayNode("bodrcd",true)
							.addNode(new FieldNode("custregno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custregno", 30,0, false, "协议编号" )))
							.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1,0, false, "协议状态" )))
							.addNode(new FieldNode("bankacc", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankacc", 40,0, false, "银行账号" )))
							.addNode(new FieldNode("userno", new MsgField(ContentEnum.MessageType.STRING.toString(), "userno", 20,0, false, "产品代码" )))
							.addNode(new FieldNode("origcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "origcode", 20,0, false, "TA代码" )))
							.addNode(new FieldNode("managerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "managerno", 10,0, false, "客户经理编码" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

