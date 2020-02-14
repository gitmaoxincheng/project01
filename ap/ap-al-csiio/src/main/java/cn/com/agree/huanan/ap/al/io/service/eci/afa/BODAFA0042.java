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
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;

/**
 * BASESVC BODAFA0042  贷记卡多账户信息查询
 * BODAFA0042 cd047 881004
 *  综合前置
 * @author zhonggp
 */
@Component
public class BODAFA0042 extends EciChannelService {

	private static BODAFA0042_I i = new BODAFA0042_I();
	private static BODAFA0042_O o = new BODAFA0042_O();

	public BODAFA0042() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0042_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 19,0, false, "卡号" )))
					.addNode(new FieldNode("keytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "keytype", 10,0, false, "证件类型" )))
					.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 40,0, false, "证件号码" )))
					.addNode(new FieldNode("insflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "insflag", 1,0, false, "查询方式" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODAFA0042_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 20,0, false, "流水号" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 10,0, false, "记录数" )))
					.addNode(new ArrayNode("bodrcd", true,"card_list")
							.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 10,0, false, "卡号" )))
							.addNode(new FieldNode("product", new MsgField(ContentEnum.MessageType.STRING.toString(), "product", 10,0, false, "卡片产品" )))
							.addNode(new FieldNode("prod_level", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_level", 40,0, false, "卡片级别" )))
							.addNode(new FieldNode("category", new MsgField(ContentEnum.MessageType.STRING.toString(), "category", 30,0, false, "账户类别" )))
							.addNode(new FieldNode("categoryname", new MsgField(ContentEnum.MessageType.STRING.toString(), "categoryname", 30,0, false, "账户类别名称" )))
							.addNode(new FieldNode("expire", new MsgField(ContentEnum.MessageType.STRING.toString(), "expire", 10,0, false, "有效期" )))
							.addNode(new FieldNode("maflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "maflag", 10,0, false, "主附卡标志" )))
							.addNode(new FieldNode("opendate", new MsgField(ContentEnum.MessageType.STRING.toString(), "opendate", 20,0, false, "发卡日期" )))
							.addNode(new FieldNode("pbflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pbflag", 40,0, false, "个人卡标志" )))
							.addNode(new FieldNode("busi_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_name", 20,0, false, "公司名称" )))
							.addNode(new FieldNode("cardstat", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardstat", 60,0, false, "卡片状态" )))
							.addNode(new FieldNode("feetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "feetype", 10,0, false, "年费代码" )))
							.addNode(new FieldNode("custr_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "custr_name", 10,0, false, "持卡人姓名" )))
							.addNode(new FieldNode("activday", new MsgField(ContentEnum.MessageType.STRING.toString(), "activday", 8,0, false, "卡片激活日期" )))
							.addNode(new FieldNode("app_souce", new MsgField(ContentEnum.MessageType.STRING.toString(), "app_souce", 8,0, false, "专案代码" )))
							.addNode(new FieldNode("mast_card", new MsgField(ContentEnum.MessageType.STRING.toString(), "mast_card", 8,0, false, "附卡对应的主卡卡号" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
