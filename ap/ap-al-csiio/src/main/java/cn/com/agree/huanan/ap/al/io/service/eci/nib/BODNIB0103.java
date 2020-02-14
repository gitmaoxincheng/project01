package cn.com.agree.huanan.ap.al.io.service.eci.nib;

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
 * BASESVC BODNIB0103  客户信息查询 
 *  BODNIB0103 regflw
 *  新个人网银
 * @author XZF
 */
@Component
public class BODNIB0103 extends EciChannelService {

	private static BODNIB0103_I i = new BODNIB0103_I();
	private static BODNIB0103_O o = new BODNIB0103_O();
	public BODNIB0103() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNIB0103_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 1024,0, false, "证件类型" )))
					.addNode(new FieldNode("idnumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "idnumber", 1024,0, false, "证件号" )))
					.addNode(new FieldNode("cifno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cifno", 1024,0, false, "核心客户号" )))
					.addNode(new FieldNode("mobileno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobileno", 1024,0, false, "手机号码" )))
					.addNode(new FieldNode("logonalias", new MsgField(ContentEnum.MessageType.STRING.toString(), "logonalias", 1024,0, false, "登录别名" )))
					.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 1024,0, true, "操作渠道" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODNIB0103_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("cifno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cifno", 1024,0, true, "核心客户号" )))
					.addNode(new FieldNode("cstno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstno", 1024,0, true, "网银客户号" )))
					.addNode(new FieldNode("personid", new MsgField(ContentEnum.MessageType.STRING.toString(), "personid", 1024,0, true, "网银客户号(主键)" )))
					.addNode(new FieldNode("logonalias", new MsgField(ContentEnum.MessageType.STRING.toString(), "logonalias", 1024,0, false, "登录别名" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 1024,0, true, "证件类型" )))
					.addNode(new FieldNode("idnumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "idnumber", 1024,0, true, "证件号码" )))
					.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 1024,0, true, "客户姓名" )))
					.addNode(new FieldNode("sex", new MsgField(ContentEnum.MessageType.STRING.toString(), "sex", 1024,0, false, "客户性别" )))
					.addNode(new FieldNode("mobileno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobileno", 1024,0, true, "手机号码" )))
					.addNode(new FieldNode("phoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "phoneno", 1024,0, false, "电话号码" )))
					.addNode(new FieldNode("address", new MsgField(ContentEnum.MessageType.STRING.toString(), "address", 1024,0, false, "联系地址" )))
					.addNode(new FieldNode("zipcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "zipcode", 1024,0, false, "邮政编码" )))
					.addNode(new FieldNode("email", new MsgField(ContentEnum.MessageType.STRING.toString(), "email", 1024,0, false, "电子邮箱" )))
					.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 1024,0, true, "签约/注册渠道" )))
					.addNode(new FieldNode("registertype", new MsgField(ContentEnum.MessageType.STRING.toString(), "registertype", 1024,0, true, "签约类型" )))
					.addNode(new FieldNode("custmsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "custmsg", 1024,0, false, "预留信息" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1024,0, true, "网银状态" )))
					.addNode(new FieldNode("branchid", new MsgField(ContentEnum.MessageType.STRING.toString(), "branchid", 1024,0, true, "签约网点" )))
					.addNode(new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno", 1024,0, true, "柜员编号" )))
					.addNode(new FieldNode("authtellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "authtellerno", 1024,0, true, "授权主管编号" )))
					.addNode(new FieldNode("registerdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "registerdate", 1024,0, true, "签约/注册日期" )))
					.addNode(new FieldNode("saleno", new MsgField(ContentEnum.MessageType.STRING.toString(), "saleno", 1024,0, false, "营销人员代码" )))
					.addNode(new FieldNode("salename", new MsgField(ContentEnum.MessageType.STRING.toString(), "salename", 1024,0, false, "营销人员姓名" )))
					.addNode(new FieldNode("transactionrate", new MsgField(ContentEnum.MessageType.STRING.toString(), "transactionrate", 1024,0, false, "结算费优惠率" )))
					.addNode(new FieldNode("transactionstart", new MsgField(ContentEnum.MessageType.STRING.toString(), "transactionstart", 1024,0, false, "结算费优惠开始日期" )))
					.addNode(new FieldNode("transactiontime", new MsgField(ContentEnum.MessageType.STRING.toString(), "transactiontime", 1024,0, false, "结算费优惠时间段" )))
					.addNode(new FieldNode("transactionend", new MsgField(ContentEnum.MessageType.STRING.toString(), "transactionend", 1024,0, false, "结算费优惠结束日期" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 1024,0, true, "循环记录数" )))
					.addNode(new FieldNode("numberofelements", new MsgField(ContentEnum.MessageType.STRING.toString(), "numberofelements", 1024,0, true, "账号总记录数" )))
					.addNode(new FieldNode("certdn", new MsgField(ContentEnum.MessageType.STRING.toString(), "certdn", 1024,0, true, "证书DN" )))
					.addNode(new FieldNode("orid_keytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "orid_keytype", 1024,0, true, "Key类型" )))
					.addNode(new FieldNode("usbkey", new MsgField(ContentEnum.MessageType.STRING.toString(), "usbkey", 1024,0, true, "KEY编号" )))
					.addNode(new FieldNode("candefaultregist", new MsgField(ContentEnum.MessageType.STRING.toString(), "candefaultregist", 1024,0, true, "是否允许自动激活" )))
					.addNode(new ArrayNode("bodrcd",false,"acct_list")
							.addNode(new FieldNode("accountno", new MsgField(ContentEnum.MessageType.STRING.toString(), "accountno", 1024,0, true, "卡号/账号" )))
							.addNode(new FieldNode("accountname", new MsgField(ContentEnum.MessageType.STRING.toString(), "accountname", 1024,0, true, "账户名称" )))
							.addNode(new FieldNode("accounttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "accounttype", 1024,0, true, "账户类型" )))
							.addNode(new FieldNode("registeraccflg", new MsgField(ContentEnum.MessageType.STRING.toString(), "registeraccflg", 1024,0, true, "是否是签约账户" )))
							.addNode(new FieldNode("opennode", new MsgField(ContentEnum.MessageType.STRING.toString(), "opennode", 1024,0, true, "开户网点" )))
							.addNode(new FieldNode("opennodename", new MsgField(ContentEnum.MessageType.STRING.toString(), "opennodename", 1024,0, false, "开户网点名称" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

