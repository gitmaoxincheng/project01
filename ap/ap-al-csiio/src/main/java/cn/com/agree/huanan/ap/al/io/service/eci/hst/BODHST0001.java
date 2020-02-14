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
 * BASESVC BODHST0001  查询客户信息交易 
 *  BODHST0001 regflw
 *  旧核心
 * @author XZF
 */
@Component
public class BODHST0001 extends EciChannelService {

	private static BODHST0001_I i = new BODHST0001_I();
	private static BODHST0001_O o = new BODHST0001_O();
	public BODHST0001() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODHST0001_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("custno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 10,0, false, "客户号" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 40,0, false, "账号" )))
					.addNode(new FieldNode("convtg", new MsgField(ContentEnum.MessageType.STRING.toString(), "convtg", 1,0, false, "是否进行新旧账号转换" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODHST0001_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq", 12,0, false, "报文流水" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 255,0, false, "出错信息" )))
					.addNode(new FieldNode("rtcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "rtcode", 8,0, false, "出错码" )))
					.addNode(new FieldNode("script", new MsgField(ContentEnum.MessageType.STRING.toString(), "script", 500,0, false, "脚本信息" )))
					.addNode(new FieldNode("custno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 10,0, false, "客户号" )))
					.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 80,0, false, "客户名称" )))
					.addNode(new FieldNode("brchno", new MsgField(ContentEnum.MessageType.STRING.toString(), "brchno", 6,0, false, "开户网点" )))
					.addNode(new FieldNode("custtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtp", 1,0, false, "客户类别" )))
					.addNode(new FieldNode("custst", new MsgField(ContentEnum.MessageType.STRING.toString(), "custst", 1,0, false, "客户状态" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 1,0, false, "证件类别" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 40,0, false, "证件号码" )))
					.addNode(new FieldNode("opendt", new MsgField(ContentEnum.MessageType.STRING.toString(), "opendt", 8,0, false, "开户日期" )))
					.addNode(new FieldNode("openus", new MsgField(ContentEnum.MessageType.STRING.toString(), "openus", 10,0, false, "开户用户" )))
					.addNode(new FieldNode("postcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcd", 6,0, false, "邮政编码" )))
					.addNode(new FieldNode("custcl", new MsgField(ContentEnum.MessageType.STRING.toString(), "custcl", 1,0, false, "客户级别" )))
					.addNode(new FieldNode("lawcna", new MsgField(ContentEnum.MessageType.STRING.toString(), "lawcna", 100,0, false, "法人代码名称" )))
					.addNode(new FieldNode("lwidtf", new MsgField(ContentEnum.MessageType.STRING.toString(), "lwidtf", 1,0, false, "法人证件类型" )))
					.addNode(new FieldNode("lwidno", new MsgField(ContentEnum.MessageType.STRING.toString(), "lwidno", 40,0, false, "法人证件号码" )))
					.addNode(new FieldNode("inssex", new MsgField(ContentEnum.MessageType.STRING.toString(), "inssex", 1,0, false, "客户性别" )))
					.addNode(new FieldNode("offctl", new MsgField(ContentEnum.MessageType.STRING.toString(), "offctl", 20,0, false, "办公室电话" )))
					.addNode(new FieldNode("hometl", new MsgField(ContentEnum.MessageType.STRING.toString(), "hometl", 20,0, false, "家庭电话" )))
					.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl", 20,0, false, "手机号码" )))
					.addNode(new FieldNode("custad", new MsgField(ContentEnum.MessageType.STRING.toString(), "custad", 100,0, false, "联系地址" )))
					.addNode(new FieldNode("mobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobile", 20,0, false, "手机号码" )))
					.addNode(new FieldNode("email", new MsgField(ContentEnum.MessageType.STRING.toString(), "email", 20,0, false, "Email" )))
					.addNode(new FieldNode("corppr", new MsgField(ContentEnum.MessageType.STRING.toString(), "corppr", 10,0, false, "所有制形式" )))
					.addNode(new FieldNode("corptp", new MsgField(ContentEnum.MessageType.STRING.toString(), "corptp", 1,0, false, "行业分类" )))
					.addNode(new FieldNode("rlcpcy", new MsgField(ContentEnum.MessageType.STRING.toString(), "rlcpcy", 3,0, false, "实收资本币种" )))
					.addNode(new FieldNode("rlcpam", new MsgField(ContentEnum.MessageType.STRING.toString(), "rlcpam", 20,0, false, "实收资本金额" )))
					.addNode(new FieldNode("regicd", new MsgField(ContentEnum.MessageType.STRING.toString(), "regicd", 10,0, false, "营业执照注册地区代码" )))
					.addNode(new FieldNode("regisz", new MsgField(ContentEnum.MessageType.STRING.toString(), "regisz", 10,0, false, "企业规模代码" )))
					.addNode(new FieldNode("dealsp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dealsp", 100,0, false, "营业执照经营范围" )))
					.addNode(new FieldNode("opcfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "opcfno", 40,0, false, "基本户开户核准号" )))
					.addNode(new FieldNode("natitx", new MsgField(ContentEnum.MessageType.STRING.toString(), "natitx", 20,0, false, "国税登记号" )))
					.addNode(new FieldNode("locatx", new MsgField(ContentEnum.MessageType.STRING.toString(), "locatx", 20,0, false, "地税登记号" )))
					.addNode(new FieldNode("upcrna", new MsgField(ContentEnum.MessageType.STRING.toString(), "upcrna", 100,0, false, "法人或主管单位名称" )))
					.addNode(new FieldNode("uprgcy", new MsgField(ContentEnum.MessageType.STRING.toString(), "uprgcy", 2,0, false, "主管单位注册币种" )))
					.addNode(new FieldNode("uprgam", new MsgField(ContentEnum.MessageType.STRING.toString(), "uprgam", 20,0, false, "主管单位注册金额" )))
					.addNode(new FieldNode("upidtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "upidtp", 1,0, false, "主管单位法定代表人证件类别" )))
					.addNode(new FieldNode("upidno", new MsgField(ContentEnum.MessageType.STRING.toString(), "upidno", 20,0, false, "主管单位法定代表人证件号" )))
					.addNode(new FieldNode("upcrps", new MsgField(ContentEnum.MessageType.STRING.toString(), "upcrps", 10,0, false, "主管单位法定代表人" )))
					.addNode(new FieldNode("addres", new MsgField(ContentEnum.MessageType.STRING.toString(), "addres", 100,0, false, "联系地址" )))
					.addNode(new FieldNode("idcdad", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcdad", 100,0, false, "证件地址" )))
					.addNode(new FieldNode("cropcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cropcd", 20,0, false, "组织机构代码" )))
					.addNode(new FieldNode("mocufg", new MsgField(ContentEnum.MessageType.STRING.toString(), "mocufg", 1,0, false, "同号多客户标志" )))
					.addNode(new FieldNode("depotp", new MsgField(ContentEnum.MessageType.STRING.toString(), "depotp", 3,0, false, "存款类别" )))
					.addNode(new FieldNode("validt", new MsgField(ContentEnum.MessageType.STRING.toString(), "validt", 8,0, false, "证件有效期" )))
					.addNode(new FieldNode("regiam", new MsgField(ContentEnum.MessageType.STRING.toString(), "regiam", 20,0, false, "注册资金" )))
					.addNode(new FieldNode("billad", new MsgField(ContentEnum.MessageType.STRING.toString(), "billad", 100,0, false, "账单地址" )))
					.addNode(new StructNode("bodrcd",true)
							.addNode(new FieldNode("liisau", new MsgField(ContentEnum.MessageType.STRING.toString(), "liisau", 10,0, false, "发证国家或地区" )))
							.addNode(new FieldNode("cutycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cutycd", 10,0, false, "国籍" )))
							.addNode(new FieldNode("compna", new MsgField(ContentEnum.MessageType.STRING.toString(), "compna", 240,0, false, "机构名称" )))
							.addNode(new FieldNode("comptp", new MsgField(ContentEnum.MessageType.STRING.toString(), "comptp", 1,0, false, "机构类别" )))
							.addNode(new FieldNode("cotxna", new MsgField(ContentEnum.MessageType.STRING.toString(), "cotxna", 600,0, false, "机构税收控制人姓名" )))
							.addNode(new FieldNode("kztxtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "kztxtp", 1,0, false, "税收居民身份-控制人" )))
							.addNode(new FieldNode("suname", new MsgField(ContentEnum.MessageType.STRING.toString(), "suname", 600,0, false, "控制人姓（英文或拼音）" )))
							.addNode(new FieldNode("ctname", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctname", 600,0, false, "控制人名（英文或拼音）" )))
							.addNode(new FieldNode("birtdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "birtdt", 8,0, false, "出生日期" )))
							.addNode(new FieldNode("mailad", new MsgField(ContentEnum.MessageType.STRING.toString(), "mailad", 120,0, false, "现居地址（中文）" )))
							.addNode(new FieldNode("presad", new MsgField(ContentEnum.MessageType.STRING.toString(), "presad", 600,0, false, "现居地址（英文或拼音）" )))
							.addNode(new FieldNode("bornad", new MsgField(ContentEnum.MessageType.STRING.toString(), "bornad", 120,0, false, "出生地（中文）" )))
							.addNode(new FieldNode("bornen", new MsgField(ContentEnum.MessageType.STRING.toString(), "bornen", 600,0, false, "出生地（英文或拼音）" )))
							.addNode(new FieldNode("txcoun", new MsgField(ContentEnum.MessageType.STRING.toString(), "txcoun", 200,0, false, "控制人税收居民国（地区）" )))
							.addNode(new FieldNode("cridnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cridnm", 20,0, false, "控制人居民国（地区）纳税人识别号" )))
							.addNode(new FieldNode("kznore", new MsgField(ContentEnum.MessageType.STRING.toString(), "kznore", 200,0, false, "无纳税人识别号原因" )))
							.addNode(new FieldNode("kzspre", new MsgField(ContentEnum.MessageType.STRING.toString(), "kzspre", 200,0, false, "具体原因" )))
							.addNode(new FieldNode("ctcona", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctcona", 600,0, false, "所控制机构名称（英文）" )))
							.addNode(new FieldNode("ctadre", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctadre", 600,0, false, "所控制机构地址（英文或拼音）" )))
							.addNode(new FieldNode("ctarea", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctarea", 200,0, false, "所控制机构税收居民国（地区）" )))
							.addNode(new FieldNode("txidnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "txidnm", 20,0, false, "所控制机构居民国（地区）纳税人识别号" )))
							.addNode(new FieldNode("txcrid", new MsgField(ContentEnum.MessageType.STRING.toString(), "txcrid", 12,0, false, "--控制人编号" )))
							.addNode(new FieldNode("cotxtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cotxtp", 6,0, false, "控制人类型" )))
							.addNode(new FieldNode("cotxcu", new MsgField(ContentEnum.MessageType.STRING.toString(), "cotxcu", 3,0, false, "控制人国籍" )))
							).addNode(new FieldNode("comnam", new MsgField(ContentEnum.MessageType.STRING.toString(), "comnam", 240,0, false, "机构名称" )))
					.addNode(new FieldNode("comtyp", new MsgField(ContentEnum.MessageType.STRING.toString(), "comtyp", 1,0, false, "机构类别" )))
					.addNode(new FieldNode("cpadre", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpadre", 600,0, false, "机构地址（英文或拼音）" )))
					.addNode(new FieldNode("cparea", new MsgField(ContentEnum.MessageType.STRING.toString(), "cparea", 200,0, false, "税收居民国（地区）" )))
					.addNode(new FieldNode("tyidnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tyidnm", 20,0, false, "居民国（地区）纳税人识别号" )))
					.addNode(new FieldNode("notxre", new MsgField(ContentEnum.MessageType.STRING.toString(), "notxre", 200,0, false, "无纳税人识别号原因" )))
					.addNode(new FieldNode("sprean", new MsgField(ContentEnum.MessageType.STRING.toString(), "sprean", 200,0, false, "具体原因" )))
					.addNode(new FieldNode("txretp", new MsgField(ContentEnum.MessageType.STRING.toString(), "txretp", 1,0, false, "税收居民身份" )))
					.addNode(new FieldNode("cuname", new MsgField(ContentEnum.MessageType.STRING.toString(), "cuname", 120,0, false, "客户姓（英文或拼音）" )))
					.addNode(new FieldNode("cename", new MsgField(ContentEnum.MessageType.STRING.toString(), "cename", 120,0, false, "客户名（英文或拼音）" )))
					.addNode(new FieldNode("birthd", new MsgField(ContentEnum.MessageType.STRING.toString(), "birthd", 8,0, false, "出生日期" )))
					.addNode(new FieldNode("prsadr", new MsgField(ContentEnum.MessageType.STRING.toString(), "prsadr", 600,0, false, "现居地址（英文或拼音）" )))
					.addNode(new FieldNode("boradr", new MsgField(ContentEnum.MessageType.STRING.toString(), "boradr", 120,0, false, "出生地（中文）" )))
					.addNode(new FieldNode("borner", new MsgField(ContentEnum.MessageType.STRING.toString(), "borner", 60,0, false, "出生地（英文或拼音）" )))
					.addNode(new FieldNode("custen", new MsgField(ContentEnum.MessageType.STRING.toString(), "custen", 120,0, false, "客户英文名" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 10,0, false, "记录数" )))
					.addNode(new FieldNode("ocptid", new MsgField(ContentEnum.MessageType.STRING.toString(), "ocptid", 1,0, false, "职业类别" )))
					.addNode(new FieldNode("worktx", new MsgField(ContentEnum.MessageType.STRING.toString(), "worktx", 100,0, false, "职业补充" )))
					.addNode(new FieldNode("incrcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "incrcd", 1024,0, false, "机构信用代码证号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

