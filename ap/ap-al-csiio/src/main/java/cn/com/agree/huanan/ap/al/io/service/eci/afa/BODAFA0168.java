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
 * BASESVC BODAFA0168  批量代收客户签约查询 
 *  BODAFA0168 
 *  综合前端
 * @author XZF
 */
@Component
public class BODAFA0168 extends EciChannelService {

	private static BODAFA0168_I i = new BODAFA0168_I();
	private static BODAFA0168_O o = new BODAFA0168_O();
	public BODAFA0168() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0168_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("bgdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "bgdate", 8,0, false, "起始日期" )))
					.addNode(new FieldNode("eddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "eddate", 8,0, false, "结束日期" )))
					.addNode(new FieldNode("custno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 10,0, false, "客户号" )))
					.addNode(new FieldNode("protocolno", new MsgField(ContentEnum.MessageType.STRING.toString(), "protocolno", 20,0, false, "项目编号" )))
					.addNode(new FieldNode("trantype", new MsgField(ContentEnum.MessageType.STRING.toString(), "trantype", 2,0, false, "业务类型" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 32,0, false, "签约卡号/凭证号" )))
					.addNode(new FieldNode("userno", new MsgField(ContentEnum.MessageType.STRING.toString(), "userno", 60,0, false, "缴款编号" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1,0, false, "签约状态" )))
					.addNode(new FieldNode("crtbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "crtbrno", 10,0, false, "签约网点" )))
					.addNode(new FieldNode("pageflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageflag", 1,0, false, "翻页标识" )))
					.addNode(new FieldNode("maxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxnum", 6,0, false, "每页最多记录数" )))
					.addNode(new FieldNode("idxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxnum", 20,0, false, "记录id" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0168_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("totalnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalnum", 6,0, false, "总记录数" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 6,0, false, "记录数" )))
					.addNode(new ArrayNode("bodrcd",true,"sign_list")
							.addNode(new FieldNode("idxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxnum", 20,0, false, "记录id" )))
							.addNode(new FieldNode("protocolno", new MsgField(ContentEnum.MessageType.STRING.toString(), "protocolno", 20,0, false, "项目编号" )))
							.addNode(new FieldNode("appcisname", new MsgField(ContentEnum.MessageType.STRING.toString(), "appcisname", 80,0, false, "项目编号名称" )))
							.addNode(new FieldNode("trantype", new MsgField(ContentEnum.MessageType.STRING.toString(), "trantype", 2,0, false, "业务类型" )))
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 20,0, false, "签约卡号/凭证号" )))
							.addNode(new FieldNode("acctrl", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctrl", 20,0, false, "账户账号" )))
							.addNode(new FieldNode("glacctname", new MsgField(ContentEnum.MessageType.STRING.toString(), "glacctname", 100,0, false, "客户账户名" )))
							.addNode(new FieldNode("userno", new MsgField(ContentEnum.MessageType.STRING.toString(), "userno", 40,0, false, "缴款编号" )))
							.addNode(new FieldNode("crtdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "crtdate", 8,0, false, "创建日期" )))
							.addNode(new FieldNode("crtbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "crtbrno", 10,0, false, "创建网点号" )))
							.addNode(new FieldNode("crttellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "crttellerno", 10,0, false, "创建柜员号" )))
							.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1,0, false, "签约状态" )))
							.addNode(new FieldNode("cactname", new MsgField(ContentEnum.MessageType.STRING.toString(), "cactname", 100,0, false, "联系人名称" )))
							.addNode(new FieldNode("cactmobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "cactmobile", 30,0, false, "联系电话" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

