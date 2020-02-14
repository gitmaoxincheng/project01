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
 * BASESVC BODAFA1662  银企自助对账签约 
 *  BODAFA1662 88A011
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1662 extends EciChannelService {

	private static BODAFA1662_I i = new BODAFA1662_I();
	private static BODAFA1662_O o = new BODAFA1662_O();
	public BODAFA1662() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1662_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("signtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtype", 1,0, false, "签约类型" )))
					.addNode(new FieldNode("userType", new MsgField(ContentEnum.MessageType.STRING.toString(), "userType", 2,0, false, "用户类型" )))
					.addNode(new FieldNode("passwordType", new MsgField(ContentEnum.MessageType.STRING.toString(), "passwordType", 1024,0, false, "密码类型" )))
					.addNode(new FieldNode("password", new MsgField(ContentEnum.MessageType.STRING.toString(), "password", 300,0, false, "密码" )))
					.addNode(new FieldNode("passwordCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "passwordCode", 1024,0, false, "加密因子" )))
					.addNode(new FieldNode("firstPhone", new MsgField(ContentEnum.MessageType.STRING.toString(), "firstPhone", 32,0, false, "第一对账联系人电话" )))
					.addNode(new FieldNode("firstName", new MsgField(ContentEnum.MessageType.STRING.toString(), "firstName", 1024,0, false, "第一对账联系人名称" )))
					.addNode(new FieldNode("secondPhone", new MsgField(ContentEnum.MessageType.STRING.toString(), "secondPhone", 32,0, false, "第二对账联系人电话" )))
					.addNode(new FieldNode("secondName", new MsgField(ContentEnum.MessageType.STRING.toString(), "secondName", 1024,0, false, "第二对账联系人名称" )))
					.addNode(new FieldNode("signStatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "signStatus", 1,0, false, "(手机号)是否签约" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 20,0, false, "密码来源" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 30,0, false, "密钥序号" )))
					.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 20,0, false, "客户名称" )))
					.addNode(new FieldNode("currtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "currtype", 4,0, false, "币种" )))
					.addNode(new FieldNode("openzone", new MsgField(ContentEnum.MessageType.STRING.toString(), "openzone", 1024,0, false, "开户行" )))
					.addNode(new FieldNode("acctname", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctname", 80,0, false, "账户名称" )))
					.addNode(new FieldNode("svdptgOpenFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "svdptgOpenFlag", 1024,0, false, "09026对公账号快捷服务" )))
					.addNode(new FieldNode("signAllFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "signAllFlag", 1,0, false, "是否全部签约标志" )))
					.addNode(new FieldNode("rcrdnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcrdnm", 10,0, false, "勾选账号总记录" )))
					.addNode(new ArrayNode("bodrcd",true)
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 32,0, false, "账号/借据号" )))
							.addNode(new FieldNode("accstp", new MsgField(ContentEnum.MessageType.STRING.toString(), "accstp", 1,0, false, "存贷款类型" )))
							.addNode(new FieldNode("compNumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "compNumber", 20,0, false, "公司证件号码" )))
							.addNode(new FieldNode("compIdtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "compIdtype", 3,0, false, "公司证件类型" )))
							.addNode(new FieldNode("cifno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cifno", 1024,0, false, "核心客户号" )))
							.addNode(new FieldNode("cropcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cropcd", 21,0, false, "组织机构代码" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1662_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedate", 32,0, false, "交易日期" )))
					.addNode(new FieldNode("serialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "serialno", 32,0, false, "流水号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

