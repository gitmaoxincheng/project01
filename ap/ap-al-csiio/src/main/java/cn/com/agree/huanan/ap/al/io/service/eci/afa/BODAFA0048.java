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
 * BASESVC BODAFA0048  查询客户签约 
 *  BODAFA0048 884004
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA0048 extends EciChannelService {

	private static BODAFA0048_I i = new BODAFA0048_I();
	private static BODAFA0048_O o = new BODAFA0048_O();
	public BODAFA0048() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0048_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("qurttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "qurttp", 1,0, false, "查询类型" )))
					.addNode(new FieldNode("qurytx", new MsgField(ContentEnum.MessageType.STRING.toString(), "qurytx", 32,0, false, "查询要素" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1,0, false, "签约状态" )))
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

	public static class BODAFA0048_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("totalnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalnum", 1024,0, false, "总记录数" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.INT.toString(), "listnm", 1024,0, false, "记录数" )))
					.addNode(new ArrayNode("bodrcd",false,"sign_list")
							.addNode(new FieldNode("custregno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custregno", 1024,0, false, "记录id" )))
							.addNode(new FieldNode("custtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype", 1024,0, false, "客户类型" )))
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 1024,0, false, "签约帐号" )))
							.addNode(new FieldNode("acctrl", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctrl", 1024,0, false, "账户账号" )))
							.addNode(new FieldNode("vouhtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "vouhtype", 1024,0, false, "凭证类型" )))
							.addNode(new FieldNode("intram", new MsgField(ContentEnum.MessageType.STRING.toString(), "intram", 1024,0, false, "单笔转入限额" )))
							.addNode(new FieldNode("outram", new MsgField(ContentEnum.MessageType.STRING.toString(), "outram", 1024,0, false, "单笔转出限额" )))
							.addNode(new FieldNode("phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone", 1024,0, false, "用户号" )))
							.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1024,0, false, "签约状态" )))
							.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 1024,0, false, "客户证件种类" )))
							.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 1024,0, false, "客户证件号码" )))
							.addNode(new FieldNode("acctname", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctname", 1024,0, false, "客户姓名" )))
							.addNode(new FieldNode("crtbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "crtbrno", 1024,0, false, "创建网点号" )))
							.addNode(new FieldNode("crttellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "crttellerno", 1024,0, false, "创建柜员号" )))
							.addNode(new FieldNode("crtdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "crtdate", 1024,0, false, "创建日期" )))
							.addNode(new FieldNode("updbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "updbrno", 1024,0, false, "维护网点号" )))
							.addNode(new FieldNode("updtellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "updtellerno", 1024,0, false, "维护柜员号" )))
							.addNode(new FieldNode("upddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "upddate", 1024,0, false, "维护日期" )))
							.addNode(new FieldNode("memotp", new MsgField(ContentEnum.MessageType.STRING.toString(), "memotp", 1,0, false, "余额" )))
							.addNode(new FieldNode("nemotp", new MsgField(ContentEnum.MessageType.STRING.toString(), "nemotp", 4,0, false, "摘要" )))
							.addNode(new FieldNode("dknote", new MsgField(ContentEnum.MessageType.STRING.toString(), "dknote", 2,0, false, "备用标识2" )))
							.addNode(new FieldNode("frbgmn", new MsgField(ContentEnum.MessageType.STRING.toString(), "frbgmn", 4,0, false, "备用标识4" )))
							.addNode(new FieldNode("paysac", new MsgField(ContentEnum.MessageType.STRING.toString(), "paysac", 1,0, false, "备注1" )))
							.addNode(new FieldNode("paysdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "paysdm", 2,0, false, "备注2" )))
							.addNode(new FieldNode("paysna", new MsgField(ContentEnum.MessageType.STRING.toString(), "paysna", 3,0, false, "备注3" )))
							.addNode(new FieldNode("feeamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "feeamt", 5,0, false, "备注5" )))
							.addNode(new FieldNode("feenms", new MsgField(ContentEnum.MessageType.STRING.toString(), "feenms", 6,0, false, "备注6" )))
							.addNode(new FieldNode("chrgtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrgtp", 3,0, false, "备用标识3" )))
							.addNode(new FieldNode("freemn", new MsgField(ContentEnum.MessageType.STRING.toString(), "freemn", 5,0, false, "备用标识5" )))
							.addNode(new FieldNode("paysid", new MsgField(ContentEnum.MessageType.STRING.toString(), "paysid", 1024,0, false, "付款账户凭证号码" )))
							.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 1024,0, false, "客户姓名" )))
							.addNode(new FieldNode("vouhno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vouhno", 1024,0, false, "凭证号码" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

