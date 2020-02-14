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
 * BASESVC BODAFA1663  银企自助对账签约信息查询 
 *  BODAFA1663 88A011
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1663 extends EciChannelService {

	private static BODAFA1663_I i = new BODAFA1663_I();
	private static BODAFA1663_O o = new BODAFA1663_O();
	public BODAFA1663() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1663_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("signtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtype", 20,0, false, "签约类型" )))
					.addNode(new FieldNode("custno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 20,0, false, "客户号" )))
					.addNode(new FieldNode("batchno", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchno", 50,0, false, "签约编号" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 32,0, false, "账号/借据号" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1,0, false, "签约状态" )))
					.addNode(new FieldNode("pageflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageflag", 1,0, false, "翻页标志" )))
					.addNode(new FieldNode("maxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxnum", 6,0, false, "单页最大记录数" )))
					.addNode(new FieldNode("idxacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxacctno", 1024,0, false, "翻页索引" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1663_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq", 20,0, false, "报文流水" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 300,0, false, "出错信息" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 10,0, false, "记录数" )))
					.addNode(new ArrayNode("bodrcd",false,"sign_list")
							.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 3,0, false, "客户证件种类" )))
							.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 50,0, false, "客户证件号码" )))
							.addNode(new FieldNode("cropcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cropcd", 32,0, false, "组织结构代码" )))
							.addNode(new FieldNode("custno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 32,0, false, "客户号" )))
							.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 100,0, false, "客户名称" )))
							.addNode(new FieldNode("accstp", new MsgField(ContentEnum.MessageType.STRING.toString(), "accstp", 1,0, false, "存贷款类型" )))
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 50,0, false, "卡号/账号/借据号" )))
							.addNode(new FieldNode("acctname", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctname", 100,0, false, "账户名称" )))
							.addNode(new FieldNode("currtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "currtype", 3,0, false, "账户币种" )))
							.addNode(new FieldNode("openzone", new MsgField(ContentEnum.MessageType.STRING.toString(), "openzone", 12,0, false, "开户行" )))
							.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1,0, false, "签约状态" )))
							.addNode(new FieldNode("batchno", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchno", 50,0, false, "签约编号" )))
							.addNode(new FieldNode("cactname1", new MsgField(ContentEnum.MessageType.STRING.toString(), "cactname1", 100,0, false, "第一对账联系人" )))
							.addNode(new FieldNode("cactmobile1", new MsgField(ContentEnum.MessageType.STRING.toString(), "cactmobile1", 20,0, false, "第一对账联系人手机号码" )))
							.addNode(new FieldNode("cactname2", new MsgField(ContentEnum.MessageType.STRING.toString(), "cactname2", 100,0, false, "第二对账联系人" )))
							.addNode(new FieldNode("cactmobile2", new MsgField(ContentEnum.MessageType.STRING.toString(), "cactmobile2", 20,0, false, "第二对账联系人手机号码" )))
							)
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

