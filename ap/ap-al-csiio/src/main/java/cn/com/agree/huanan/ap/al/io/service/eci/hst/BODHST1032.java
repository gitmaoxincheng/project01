package cn.com.agree.huanan.ap.al.io.service.eci.hst;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODHST1032  查询医保账户信息 
 *  BODHST1032 regflw
 *  旧核心
 * @author XZF
 */
@Component
public class BODHST1032 extends EciChannelService {

	private static BODHST1032_I i = new BODHST1032_I();
	private static BODHST1032_O o = new BODHST1032_O();
	public BODHST1032() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODHST1032_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("dispno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dispno", 30,0, false, "金融账户的卡号" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 4,0, false, "证件类型" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("cityno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cityno", 30,0, false, "社保所属市" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODHST1032_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("erorcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "erorcd", 8,0, false, "错误代码" )))
					.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq", 20,0, false, "包流水" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 100,0, false, "错误信息" )))
					.addNode(new FieldNode("rtcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "rtcode", 2,0, false, "返回码" )))
					.addNode(new FieldNode("acctna", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctna", 60,0, false, "账户名称" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 4,0, false, "证件类型" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 32,0, false, "证件号码" )))
					.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 60,0, false, "客户名称" )))
					.addNode(new FieldNode("openbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "openbr", 6,0, false, "开户机构" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 32,0, false, "社保系统卡号(开户文件中)" )))
					.addNode(new FieldNode("dcmtst", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcmtst", 1,0, false, "社保卡状态" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 32,0, false, "金融账号" )))
					.addNode(new FieldNode("dispno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dispno", 32,0, false, "金融卡号" )))
					.addNode(new FieldNode("onlnbl", new MsgField(ContentEnum.MessageType.STRING.toString(), "onlnbl", 21,0, false, "金融账户余额" )))
					.addNode(new FieldNode("acctst", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctst", 3,0, false, "金融账户状态" )))
					.addNode(new FieldNode("acctst_new", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctst_new", 3,0, false, "金融账户状态(新)" )))
					.addNode(new FieldNode("miacst", new MsgField(ContentEnum.MessageType.STRING.toString(), "miacst", 2,0, false, "医保账户状态" )))
					.addNode(new FieldNode("micdno", new MsgField(ContentEnum.MessageType.STRING.toString(), "micdno", 21,0, false, "医保账户" )))
					.addNode(new FieldNode("miacbl", new MsgField(ContentEnum.MessageType.STRING.toString(), "miacbl", 20,0, false, "医保账户余额" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

