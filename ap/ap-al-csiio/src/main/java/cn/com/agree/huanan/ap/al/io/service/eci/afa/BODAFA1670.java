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
 * BASESVC BODAFA1670  三方协议解约预查询
 * BODAFA1670 tips1004 581001
 *  综合前置
 * @author CZP
 */
@Component
public class BODAFA1670 extends EciChannelService {

	private static BODAFA1670_I i = new BODAFA1670_I();
	private static BODAFA1670_O o = new BODAFA1670_O();

	public BODAFA1670() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1670_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("protocolno", new MsgField(ContentEnum.MessageType.STRING.toString(), "protocolno", 1024,0, false, "协议书号" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 1024,0, false, "付款账号" )))
					.addNode(new FieldNode("origcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "origcode", 1024,0, false, "征收机关代码" )))
					.addNode(new FieldNode("userno", new MsgField(ContentEnum.MessageType.STRING.toString(), "userno", 1024,0, false, "纳税人/缴款人编码" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1024,0, false, "协议状态" )))
					.addNode(new FieldNode("idxprotocolno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxprotocolno", 1024,0, false, "后续协议书号" )))
					.addNode(new FieldNode("idxorigcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxorigcode", 1024,0, false, "后续征收机关号" )))
					.addNode(new FieldNode("strtranscode", new MsgField(ContentEnum.MessageType.STRING.toString(), "strtranscode", 1024,0, false, "验证发起方" )))
					.addNode(new FieldNode("pageflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageflag", 1024,0, false, "翻页标识" )))
					.addNode(new FieldNode("maxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxnum", 1024,0, false, "查询最大记录数" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODAFA1670_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("totalnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalnum", 1024,0, false, "总记录数" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 1024,0, false, "当前记录数" )))
					.addNode(new ArrayNode("bodrcd", true, "sign_list")
							.addNode(new FieldNode("protocolno", new MsgField(ContentEnum.MessageType.STRING.toString(), "protocolno", 1024,0, false, "协议书号" )))
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 1024,0, false, "付款账号" )))
							.addNode(new FieldNode("acctname", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctname", 1024,0, false, "付款户名" )))
							.addNode(new FieldNode("origcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "origcode", 1024,0, false, "征收机关代码" )))
							.addNode(new FieldNode("userno", new MsgField(ContentEnum.MessageType.STRING.toString(), "userno", 1024,0, false, "纳税人/缴款人编码" )))
							.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 1024,0, false, "纳税人/缴款人名称" )))
							.addNode(new FieldNode("startdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "startdate", 1024,0, false, "签约日期" )))
							.addNode(new FieldNode("crtserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "crtserialno", 1024,0, false, "签约流水" )))
							.addNode(new FieldNode("stopdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "stopdate", 1024,0, false, "解约日期" )))
							.addNode(new FieldNode("updserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "updserialno", 1024,0, false, "解约流水" )))
							.addNode(new FieldNode("crttellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "crttellerno", 1024,0, false, "签约柜员" )))
							.addNode(new FieldNode("updtellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "updtellerno", 1024,0, false, "解约柜员" )))
							.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1024,0, false, "协议状态" )))
							.addNode(new FieldNode("note5", new MsgField(ContentEnum.MessageType.STRING.toString(), "note5", 1024,0, false, "征收机关名称" )))
							.addNode(new FieldNode("strtranscode", new MsgField(ContentEnum.MessageType.STRING.toString(), "strtranscode", 1024,0, false, "验证发起方" )))
							));
			return messageNode;
		}
		

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
