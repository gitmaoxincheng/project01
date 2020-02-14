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
 * BASESVC BODAFA0154  用户缴款 
 *  BODAFA0154 
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA0154 extends EciChannelService {

	private static BODAFA0154_I i = new BODAFA0154_I();
	private static BODAFA0154_O o = new BODAFA0154_O();
	public BODAFA0154() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0154_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("userno", new MsgField(ContentEnum.MessageType.STRING.toString(), "userno", 20,0, false, "用电客户编号" )))
					.addNode(new FieldNode("userno_t", new MsgField(ContentEnum.MessageType.STRING.toString(), "userno_t", 20,0, false, "结算户编号" )))
					.addNode(new FieldNode("dfny", new MsgField(ContentEnum.MessageType.STRING.toString(), "dfny", 6,0, false, "电费年月" )))
					.addNode(new FieldNode("acctname", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctname", 64,0, false, "用电客户名称" )))
					.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "amount", 12,0, false, "欠费总金额" )))
					.addNode(new FieldNode("corpcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpcode", 12,0, false, "企业代码" )))
					.addNode(new FieldNode("fxcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "fxcode", 12,0, false, "费项代码" )))
					.addNode(new FieldNode("owc", new MsgField(ContentEnum.MessageType.STRING.toString(), "owc", 12,0, false, "原企业代码" )))
					.addNode(new FieldNode("odt", new MsgField(ContentEnum.MessageType.STRING.toString(), "odt", 8,0, false, "原委托日期" )))
					.addNode(new FieldNode("olz", new MsgField(ContentEnum.MessageType.STRING.toString(), "olz", 32,0, false, "原业务流水" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 32,0, false, "付款账号" )))
					.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 80,0, false, "付款账号名称" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 2,0, false, "证件类型" )))
					.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 25,0, false, "证件号码" )))
					.addNode(new FieldNode("tranpw", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranpw", 20,0, false, "付款账号密码" )))
					.addNode(new FieldNode("zwlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "zwlsh", 16,0, false, "账务流水号" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 1,0, true, "是否需要密码" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 20,0, false, "密钥序号" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 20,0, false, "密码的来源" )))
					.addNode(new FieldNode("zacctno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zacctno1", 20,0, false, "第一个密码所涉及的账号" )))
					.addNode(new FieldNode("zpwdfd1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfd1", 20,0, false, "第一个密码" )))
					.addNode(new FieldNode("zdcmttp1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmttp1", 20,0, false, "第一个密码涉及账号的凭证类型" )))
					.addNode(new FieldNode("zdcmtno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmtno1", 20,0, false, "第一个密码涉及账号的凭证号码" )))
					.addNode(new FieldNode("zacctno2", new MsgField(ContentEnum.MessageType.STRING.toString(), "zacctno2", 20,0, false, "第二个密码所涉及的账号" )))
					.addNode(new FieldNode("zpwdfd2", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfd2", 20,0, false, "第二个密码" )))
					.addNode(new FieldNode("zdcmttp2", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmttp2", 20,0, false, "第二个密码涉及账号的凭证类型" )))
					.addNode(new FieldNode("zdcmtno2", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmtno2", 20,0, false, "第二个密码涉及账号的凭证号码" )))
					.addNode(new FieldNode("fxinfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "fxinfo", 50,0, false, "分局信息" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 6,0, false, "明细总笔数" )))
					.addNode(new ArrayNode("fee_list",true,"bodrcd")
							.addNode(new FieldNode("qfxh", new MsgField(ContentEnum.MessageType.STRING.toString(), "qfxh", 2,0, false, "欠费项序号" )))
							.addNode(new FieldNode("qfxqfnr", new MsgField(ContentEnum.MessageType.STRING.toString(), "qfxqfnr", 255,0, false, "欠费项欠费内容" )))
							.addNode(new FieldNode("khmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "khmc", 80,0, false, "客户名称" )))
							.addNode(new FieldNode("jldh", new MsgField(ContentEnum.MessageType.STRING.toString(), "jldh", 5,0, false, "计量点号" )))
							.addNode(new FieldNode("yspzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "yspzh", 16,0, false, "应收凭证号" )))
							.addNode(new FieldNode("dj", new MsgField(ContentEnum.MessageType.STRING.toString(), "dj", 8,0, false, "电价" )))
							.addNode(new FieldNode("tbdl", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbdl", 8,0, false, "退补电量" )))
							.addNode(new FieldNode("syhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "syhm", 10,0, false, "上月行码" )))
							.addNode(new FieldNode("byhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "byhm", 10,0, false, "本月行码" )))
							.addNode(new FieldNode("dbzcbh", new MsgField(ContentEnum.MessageType.STRING.toString(), "dbzcbh", 16,0, false, "电表资产编号" )))
							.addNode(new FieldNode("dbcch", new MsgField(ContentEnum.MessageType.STRING.toString(), "dbcch", 16,0, false, "电表出厂编号" )))
							.addNode(new FieldNode("cbrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "cbrq", 8,0, false, "抄表日期" )))
							.addNode(new FieldNode("qfxqfje", new MsgField(ContentEnum.MessageType.STRING.toString(), "qfxqfje", 12,0, false, "欠费项欠费金额" )))
							.addNode(new FieldNode("cs", new MsgField(ContentEnum.MessageType.STRING.toString(), "cs", 2,0, false, "次数" )))
							.addNode(new FieldNode("yf", new MsgField(ContentEnum.MessageType.STRING.toString(), "yf", 6,0, false, "月份" )))
							.addNode(new FieldNode("wyj", new MsgField(ContentEnum.MessageType.STRING.toString(), "wyj", 12,0, false, "违约金" )))
							.addNode(new FieldNode("bj", new MsgField(ContentEnum.MessageType.STRING.toString(), "bj", 12,0, false, "本金" )))
							.addNode(new FieldNode("dl", new MsgField(ContentEnum.MessageType.STRING.toString(), "dl", 8,0, false, "电量" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0154_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("fmisno", new MsgField(ContentEnum.MessageType.STRING.toString(), "fmisno", 20,0, false, "缴费流水号" )))
					.addNode(new FieldNode("bankserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankserno", 20,0, false, "主机流水号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

