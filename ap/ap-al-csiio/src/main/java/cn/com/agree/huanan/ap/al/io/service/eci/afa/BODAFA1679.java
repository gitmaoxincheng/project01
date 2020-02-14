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
 * BASESVC BODAFA1679  委托扣税签约查询
 * BODAFA1679 ckdlac eft00080
 *  综合前置
 * @author CZP
 */
@Component
public class BODAFA1679 extends EciChannelService {

	private static BODAFA1679_I i = new BODAFA1679_I();
	private static BODAFA1679_O o = new BODAFA1679_O();

	public BODAFA1679() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1679_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("maxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxnum", 1024,0, false, "每页最多记录数" )))
					.addNode(new FieldNode("acctrl", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctrl", 1024,0, false, "付款账号" )))
					.addNode(new FieldNode("acctname", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctname", 1024,0, false, "付款人名称" )))
					.addNode(new FieldNode("userno", new MsgField(ContentEnum.MessageType.STRING.toString(), "userno", 1024,0, false, "纳税编号" )))
					.addNode(new FieldNode("bgdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "bgdate", 1024,0, false, "起始日期" )))
					.addNode(new FieldNode("eddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "eddate", 1024,0, false, "终止日期" )))
					.addNode(new FieldNode("flag3", new MsgField(ContentEnum.MessageType.STRING.toString(), "flag3", 1024,0, false, "起始日期" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1024,0, false, "签约标志" )))
					.addNode(new FieldNode("flag2", new MsgField(ContentEnum.MessageType.STRING.toString(), "flag2", 1024,0, false, "纳税类型" )))
					.addNode(new FieldNode("idxcustregno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxcustregno", 1024,0, false, "注册协议编号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODAFA1679_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("totalnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalnum", 1024,0, false, "总记录数" )))
					.addNode(new FieldNode("returnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "returnum", 1024,0, false, "本次返回记录数" )))
					.addNode(new ArrayNode("bodrcd", true, "sign_list")
							.addNode(new FieldNode("custregno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custregno", 1024,0, false, "注册协议编号" )))
							.addNode(new FieldNode("acctrl", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctrl", 1024,0, false, "付款账号" )))
							.addNode(new FieldNode("acctname", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctname", 1024,0, false, "付款人名称" )))
							.addNode(new FieldNode("origcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "origcode", 1024,0, false, "征收机构" )))
							.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 1024,0, false, "证件类型" )))
							.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 1024,0, false, "证件号码" )))
							.addNode(new FieldNode("flag2", new MsgField(ContentEnum.MessageType.STRING.toString(), "flag2", 1024,0, false, "纳税类型" )))
							.addNode(new FieldNode("userno", new MsgField(ContentEnum.MessageType.STRING.toString(), "userno", 1024,0, false, "纳税编码" )))
							.addNode(new FieldNode("protocolno", new MsgField(ContentEnum.MessageType.STRING.toString(), "protocolno", 1024,0, false, "纳税编码" )))
							.addNode(new FieldNode("cactaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cactaddr", 1024,0, false, "联系地址" )))
							.addNode(new FieldNode("cacttel", new MsgField(ContentEnum.MessageType.STRING.toString(), "cacttel", 1024,0, false, "联系电话" )))
							.addNode(new FieldNode("cactzip", new MsgField(ContentEnum.MessageType.STRING.toString(), "cactzip", 1024,0, false, "邮编" )))
							.addNode(new FieldNode("crtdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "crtdate", 1024,0, false, "签约日期" )))
							.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 1024,0, false, "" )))
							.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1024,0, false, "状态" )))
							.addNode(new FieldNode("upddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "upddate", 1024,0, false, "解约日期" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
