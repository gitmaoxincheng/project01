package cn.com.agree.huanan.ap.al.io.service.eci.hst;

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
 * BASESVC BODHST1364  电票解约
 * BODHST1364 dzjydf dzjydf
 *  旧核心系统
 * @author CZP
 */
@Component
public class BODHST1364 extends EciChannelService {

	private static BODHST1364_I i = new BODHST1364_I();
	private static BODHST1364_O o = new BODHST1364_O();

	public BODHST1364() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODHST1364_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("userid", new MsgField(ContentEnum.MessageType.STRING.toString(), "userid", 10,0, false, "操作柜员" )))
					.addNode(new FieldNode("psauus", new MsgField(ContentEnum.MessageType.STRING.toString(), "psauus", 10,0, false, "经办授权柜员" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 8,0, false, "循环记录数" )))
					.addNode(new ArrayNode("bodrcd", true)
							.addNode(new FieldNode("acctbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctbr", 20,0, false, "组织机构代码" )))
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 30,0, false, "账号" )))
							.addNode(new FieldNode("acctna", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctna", 200,0, false, "账号名" )))
							.addNode(new FieldNode("brchno", new MsgField(ContentEnum.MessageType.STRING.toString(), "brchno", 10,0, false, "账号所属部门" )))
							.addNode(new FieldNode("rmtrtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "rmtrtp", 10,0, false, "业务主体类型" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODHST1364_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("erorcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "erorcd", 8,0, false, "主机返回代码" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 255,0, false, "主机返回信息" )))
					.addNode(new FieldNode("svwktm", new MsgField(ContentEnum.MessageType.STRING.toString(), "svwktm", 6,0, false, "主机返回时间" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
