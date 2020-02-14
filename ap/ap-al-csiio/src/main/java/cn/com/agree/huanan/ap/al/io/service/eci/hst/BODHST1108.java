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
 * BASESVC BODHST1108  增加个人客户基本信息 
 *  BODHST1108 regflw
 *  旧核心
 * @author XZF
 */
@Component
public class BODHST1108 extends EciChannelService {

	private static BODHST1108_I i = new BODHST1108_I();
	private static BODHST1108_O o = new BODHST1108_O();
	public BODHST1108() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODHST1108_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("custno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 1024,0, false, "客户号" )))
					.addNode(new FieldNode("custst", new MsgField(ContentEnum.MessageType.STRING.toString(), "custst", 1024,0, false, "客户状态" )))
					.addNode(new FieldNode("lndelv", new MsgField(ContentEnum.MessageType.STRING.toString(), "lndelv", 1024,0, true, "洗钱风险等级" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 1024,0, false, "证件类型" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 1024,0, false, "证件号" )))
					.addNode(new FieldNode("efctdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "efctdt", 1024,0, false, "客户证件有效期" )))
					.addNode(new FieldNode("psrntg", new MsgField(ContentEnum.MessageType.STRING.toString(), "psrntg", 1,0, false, "居民标志" )))
					.addNode(new FieldNode("cutycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cutycd", 3,0, false, "国籍代码" )))
					.addNode(new FieldNode("liisau", new MsgField(ContentEnum.MessageType.STRING.toString(), "liisau", 10,0, true, "发证国家地区" )))
					.addNode(new FieldNode("idcdad", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcdad", 1024,0, false, "户籍地址" )))
					.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 1024,0, false, "客户姓名" )))
					.addNode(new FieldNode("enname", new MsgField(ContentEnum.MessageType.STRING.toString(), "enname", 1024,0, false, "英文姓名" )))
					.addNode(new FieldNode("gender", new MsgField(ContentEnum.MessageType.STRING.toString(), "gender", 1,0, false, "性别" )))
					.addNode(new FieldNode("renatg", new MsgField(ContentEnum.MessageType.STRING.toString(), "renatg", 1,0, false, "实名标志" )))
					.addNode(new FieldNode("custcl", new MsgField(ContentEnum.MessageType.STRING.toString(), "custcl", 1,0, false, "客户级别" )))
					.addNode(new FieldNode("offctl", new MsgField(ContentEnum.MessageType.STRING.toString(), "offctl", 1024,0, false, "办公电话" )))
					.addNode(new FieldNode("hometl", new MsgField(ContentEnum.MessageType.STRING.toString(), "hometl", 1024,0, false, "家庭电话" )))
					.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl", 1024,0, false, "移动电话" )))
					.addNode(new FieldNode("faxitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "faxitl", 1024,0, false, "传真" )))
					.addNode(new FieldNode("postcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcd", 1024,0, false, "邮编" )))
					.addNode(new FieldNode("mailad", new MsgField(ContentEnum.MessageType.STRING.toString(), "mailad", 1024,0, false, "通讯地址" )))
					.addNode(new FieldNode("e_mail", new MsgField(ContentEnum.MessageType.STRING.toString(), "e_mail", 1024,0, false, "电子邮件" )))
					.addNode(new FieldNode("orgnna", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgnna", 1024,0, false, "发证机关(存款人)" )))
					.addNode(new FieldNode("orgncd", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgncd", 1024,0, false, "发证机关地区代码" )))
					.addNode(new FieldNode("agnttg", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnttg", 1024,0, false, "是否代办" )))
					.addNode(new FieldNode("agntna", new MsgField(ContentEnum.MessageType.STRING.toString(), "agntna", 1024,0, false, "代理人姓名" )))
					.addNode(new FieldNode("agcuty", new MsgField(ContentEnum.MessageType.STRING.toString(), "agcuty", 1024,0, false, "代理人国籍" )))
					.addNode(new FieldNode("agntgd", new MsgField(ContentEnum.MessageType.STRING.toString(), "agntgd", 1024,0, false, "代理人性别" )))
					.addNode(new FieldNode("agidtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "agidtp", 1024,0, false, "代理人证件类别" )))
					.addNode(new FieldNode("agidno", new MsgField(ContentEnum.MessageType.STRING.toString(), "agidno", 1024,0, false, "代理人证件号码" )))
					.addNode(new FieldNode("agivdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "agivdt", 1024,0, false, "代理人证件有效期" )))
					.addNode(new FieldNode("agnttl", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnttl", 1024,0, false, "代理人联系方式" )))
					.addNode(new FieldNode("agntrl", new MsgField(ContentEnum.MessageType.STRING.toString(), "agntrl", 1024,0, false, "代理人与申请人关系" )))
					.addNode(new FieldNode("ocptid", new MsgField(ContentEnum.MessageType.STRING.toString(), "ocptid", 1024,0, false, "职业类别" )))
					.addNode(new FieldNode("worktx", new MsgField(ContentEnum.MessageType.STRING.toString(), "worktx", 1024,0, false, "职业" )))
					.addNode(new FieldNode("wkutna", new MsgField(ContentEnum.MessageType.STRING.toString(), "wkutna", 1024,0, false, "工作单位" )))
					.addNode(new FieldNode("wkutad", new MsgField(ContentEnum.MessageType.STRING.toString(), "wkutad", 1024,0, false, "单位地址" )))
					.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark", 100,0, false, "备注" )))
					.addNode(new FieldNode("mocufg", new MsgField(ContentEnum.MessageType.STRING.toString(), "mocufg", 1,0, false, "同号多客户标志" )))
					.addNode(new FieldNode("mocurs", new MsgField(ContentEnum.MessageType.STRING.toString(), "mocurs", 20,0, false, "同号多客户原因" )))
					.addNode(new FieldNode("txretp", new MsgField(ContentEnum.MessageType.STRING.toString(), "txretp", 1,0, false, "税收居民身份-控制人" )))
					.addNode(new FieldNode("suname", new MsgField(ContentEnum.MessageType.STRING.toString(), "suname", 120,0, false, "姓（英文或拼音）" )))
					.addNode(new FieldNode("ctname", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctname", 120,0, false, "名（英文或拼音）" )))
					.addNode(new FieldNode("birtdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "birtdt", 8,0, false, "出生日期" )))
					.addNode(new FieldNode("presad", new MsgField(ContentEnum.MessageType.STRING.toString(), "presad", 600,0, false, "现居地址（英文或拼音）" )))
					.addNode(new FieldNode("bornad", new MsgField(ContentEnum.MessageType.STRING.toString(), "bornad", 120,0, false, "出生地（中文）" )))
					.addNode(new FieldNode("bornen", new MsgField(ContentEnum.MessageType.STRING.toString(), "bornen", 600,0, false, "出生地（英文或拼音）" )))
					.addNode(new FieldNode("txcoun", new MsgField(ContentEnum.MessageType.STRING.toString(), "txcoun", 200,0, false, "税收居民国（地区）" )))
					.addNode(new FieldNode("cridnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cridnm", 20,0, false, "居民国（地区）纳税人识别号" )))
					.addNode(new FieldNode("notxre", new MsgField(ContentEnum.MessageType.STRING.toString(), "notxre", 200,0, false, "无纳税人识别号原因" )))
					.addNode(new FieldNode("sprean", new MsgField(ContentEnum.MessageType.STRING.toString(), "sprean", 200,0, false, "具体原因" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODHST1108_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("prcscd", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcscd", 1024,0, false, "处理码" )))
					.addNode(new FieldNode("custno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 1024,0, false, "客户号" )))
					.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 1024,0, false, "客户名称" )))
					.addNode(new FieldNode("custtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtp", 1,0, false, "客户类别" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 1024,0, false, "证件类别" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 1024,0, false, "证件号码" )))
					.addNode(new FieldNode("opendt", new MsgField(ContentEnum.MessageType.STRING.toString(), "opendt", 8,0, false, "开户日期" )))
					.addNode(new FieldNode("brchno", new MsgField(ContentEnum.MessageType.STRING.toString(), "brchno", 1024,0, false, "部门号" )))
					.addNode(new FieldNode("brchna", new MsgField(ContentEnum.MessageType.STRING.toString(), "brchna", 1024,0, false, "部门名称" )))
					.addNode(new FieldNode("ckbkus", new MsgField(ContentEnum.MessageType.STRING.toString(), "ckbkus", 1024,0, false, "复核柜员" )))
					.addNode(new FieldNode("custcl", new MsgField(ContentEnum.MessageType.STRING.toString(), "custcl", 1,0, false, "客户级别" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

