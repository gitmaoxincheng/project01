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
 * BASESVC BODHST1363  电票签约
 * BODHST1363 dzqydf dzqydf
 *  旧核心系统
 * @author CZP
 */
@Component
public class BODHST1363 extends EciChannelService {

	private static BODHST1363_I i = new BODHST1363_I();
	private static BODHST1363_O o = new BODHST1363_O();

	public BODHST1363() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODHST1363_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("userid", new MsgField(ContentEnum.MessageType.STRING.toString(), "userid", 10,0, false, "操作柜员" )))
					.addNode(new FieldNode("ckbkus", new MsgField(ContentEnum.MessageType.STRING.toString(), "ckbkus", 10,0, false, "经办授权柜员" )))
					.addNode(new FieldNode("signpl", new MsgField(ContentEnum.MessageType.STRING.toString(), "signpl", 1,0, false, "签约票据池标志" )))
					.addNode(new FieldNode("poolin", new MsgField(ContentEnum.MessageType.STRING.toString(), "poolin", 1,0, false, "自动溢出标志" )))
					.addNode(new FieldNode("atmout", new MsgField(ContentEnum.MessageType.STRING.toString(), "atmout", 1,0, false, "自动入池标志" )))
					.addNode(new FieldNode("tranna", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranna", 100,0, false, "经办人姓名" )))
					.addNode(new FieldNode("tridtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "tridtp", 1,0, false, "经办人证件类型" )))
					.addNode(new FieldNode("tridno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tridno", 30,0, false, "经办人证件号码" )))
					.addNode(new FieldNode("trivdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trivdt", 8,0, false, "经办人证件有效期" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 8,0, false, "循环记录数" )))
					.addNode(new FieldNode("strdutytp", new MsgField(ContentEnum.MessageType.STRING.toString(), "strdutytp", 10,0, false, "岗位编号" )))
					.addNode(new FieldNode("abaufg", new MsgField(ContentEnum.MessageType.STRING.toString(), "abaufg", 1,0, false, "授权编号" )))
					.addNode(new ArrayNode("bodrcd", true)
							.addNode(new FieldNode("acctbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctbr", 20,0, false, "组织机构代码" )))
							.addNode(new FieldNode("custno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 16,0, false, "客户号" )))
							.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 100,0, false, "客户名称" )))
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 30,0, false, "账号" )))
							.addNode(new FieldNode("acctna", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctna", 200,0, false, "账号名" )))
							.addNode(new FieldNode("acctbk", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctbk", 12,0, false, "账号开户行" )))
							.addNode(new FieldNode("brchno", new MsgField(ContentEnum.MessageType.STRING.toString(), "brchno", 10,0, false, "账号所属部门" )))
							.addNode(new FieldNode("certty", new MsgField(ContentEnum.MessageType.STRING.toString(), "certty", 30,0, false, "开户证件类型" )))
							.addNode(new FieldNode("certno", new MsgField(ContentEnum.MessageType.STRING.toString(), "certno", 3,0, false, "开户证件号" )))
							.addNode(new FieldNode("rmtrtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "rmtrtp", 10,0, false, "业务主体类型" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODHST1363_O extends MsgBody {
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
