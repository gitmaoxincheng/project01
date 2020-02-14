package cn.com.agree.huanan.ap.al.io.service.eci.afa;

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
 * BASESVC BODAFA1021  综合签约查询 
 *  BODAFA1021 
 *  综合前端
 * @author XZF
 */
@Component
public class BODAFA1021 extends EciChannelService {

	private static BODAFA1021_I i = new BODAFA1021_I();
	private static BODAFA1021_O o = new BODAFA1021_O();
	public BODAFA1021() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1021_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("custno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 3,0, false, "客户号" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 6,0, false, "签约状态" )))
					.addNode(new FieldNode("acctnolist", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctnolist", 6,0, false, "多笔标识" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 1024,0, false, "卡号/账号" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 6,0, false, "查询账号记录数" )))
					.addNode(new StructNode("acctno_list",true,"bodrcd")
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 10,0, false, "卡号/账号" )))
						));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1021_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 1024,0, false, "返回记录数" )))
					.addNode(new StructNode("bodrcd",true,"signst_list")
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 8,0, false, "结算帐号" )))
							.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 8,0, false, "户名" )))
							.addNode(new FieldNode("custno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 8,0, false, "客户号" )))
							.addNode(new FieldNode("signst_44", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_44", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_49", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_49", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_a01", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_a01", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_b01", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_b01", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_51", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_51", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_d01", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_d01", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_c01", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_c01", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_11", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_11", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_25", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_25", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_55", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_55", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_33", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_33", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_e01", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_e01", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_32", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_32", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_31", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_31", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_f01", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_f01", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_g01", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_g01", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_h01", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_h01", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_30", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_30", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_72", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_72", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_84A", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_84A", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_84B", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_84B", 8,0, false, "签约状态" )))
							.addNode(new FieldNode("signst_84C", new MsgField(ContentEnum.MessageType.STRING.toString(), "signst_84C", 8,0, false, "签约状态" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

