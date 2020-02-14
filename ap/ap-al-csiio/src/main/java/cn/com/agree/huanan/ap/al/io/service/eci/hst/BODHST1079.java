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
 * BASESVC BODHST1079  个人客户基本信息综合查询(明细查询) 
 *  BODHST1079 regflw
 *  旧核心系统
 * @author guyulong
 */
@Component
public class BODHST1079 extends EciChannelService {
/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCBODHST1079', 'BASESVC', '旧核心系统', 'BODHST1079', '', 'ECI.HST', 'ECI_HST系统', 'BODHST1079', '个人客户基本信息综合查询(明细查询)', 'qrcudt','regflw' ,'', '1', '0', '');

*/
	private static BODHST1079_I i = new BODHST1079_I();
	private static BODHST1079_O o = new BODHST1079_O();
	public BODHST1079() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODHST1079_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
.addStructNode(new StructNode("APPBody",true,"Body")
.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
.addNode(new FieldNode("custno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 16,0, false, "客户号" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODHST1079_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
.addStructNode(new StructNode("Body",true,"APPBody")
.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
.addNode(new FieldNode("erorcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "erorcd", 8,0, false, "错误代码" )))
.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq", 20,0, false, "包流水" )))
.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 100,0, false, "错误信息" )))
.addNode(new FieldNode("openbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "openbr", 1024,0, false, "开户部门" )))
.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 100,0, false, "客户名" )))
.addNode(new FieldNode("custtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtp", 100,0, false, "客户类型" )))
.addNode(new FieldNode("custst", new MsgField(ContentEnum.MessageType.STRING.toString(), "custst", 21,0, false, "客户状态" )))
.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 21,0, false, "证件类型" )))
.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 8,0, false, "证件号码" )))
.addNode(new FieldNode("opendt", new MsgField(ContentEnum.MessageType.STRING.toString(), "opendt", 20,0, false, "开户日期" )))
.addNode(new FieldNode("openus", new MsgField(ContentEnum.MessageType.STRING.toString(), "openus", 25,0, false, "开户用户" )))
.addNode(new FieldNode("sthdtg", new MsgField(ContentEnum.MessageType.STRING.toString(), "sthdtg", 16,0, false, "是否股东" )))
.addNode(new FieldNode("postcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcd", 3,0, false, "邮政编码" )))
.addNode(new FieldNode("idcdad", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcdad", 6,0, false, "证件地区名称 (户籍地址)" )))
.addNode(new FieldNode("mailad", new MsgField(ContentEnum.MessageType.STRING.toString(), "mailad", 34,0, false, "邮件地址" )))
.addNode(new FieldNode("hometl", new MsgField(ContentEnum.MessageType.STRING.toString(), "hometl", 100,0, false, "家庭电话" )))
.addNode(new FieldNode("offctl", new MsgField(ContentEnum.MessageType.STRING.toString(), "offctl", 3,0, false, "办公电话" )))
.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl", 21,0, false, "手机号码" )))
.addNode(new FieldNode("faxitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "faxitl", 34,0, false, "传真" )))
.addNode(new FieldNode("birndt", new MsgField(ContentEnum.MessageType.STRING.toString(), "birndt", 100,0, false, "出生日期" )))
.addNode(new FieldNode("wkutna", new MsgField(ContentEnum.MessageType.STRING.toString(), "wkutna", 3,0, false, "工作单位名称" )))
.addNode(new FieldNode("occupt", new MsgField(ContentEnum.MessageType.STRING.toString(), "occupt", 21,0, false, "职业" )))
.addNode(new FieldNode("ocptid", new MsgField(ContentEnum.MessageType.STRING.toString(), "ocptid", 1,0, false, "职业类别选项" )))
.addNode(new FieldNode("gender", new MsgField(ContentEnum.MessageType.STRING.toString(), "gender", 24,0, false, "性别" )))
.addNode(new FieldNode("renatg", new MsgField(ContentEnum.MessageType.STRING.toString(), "renatg", 34,0, false, "实名标志" )))
.addNode(new FieldNode("psrntg", new MsgField(ContentEnum.MessageType.STRING.toString(), "psrntg", 100,0, false, "居民标志" )))
.addNode(new FieldNode("idt2tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idt2tp", 3,0, false, "证件类别2" )))
.addNode(new FieldNode("idt2no", new MsgField(ContentEnum.MessageType.STRING.toString(), "idt2no", 21,0, false, "证件号码2" )))
.addNode(new FieldNode("cntatl", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntatl", 34,0, false, "联系电话2" )))
.addNode(new FieldNode("custad", new MsgField(ContentEnum.MessageType.STRING.toString(), "custad", 100,0, false, "联系地址2" )))
.addNode(new FieldNode("depotp", new MsgField(ContentEnum.MessageType.STRING.toString(), "depotp", 3,0, false, "存款人类别" )))
.addNode(new FieldNode("cropcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cropcd", 21,0, false, "组织机构代码" )))
.addNode(new FieldNode("lawcna", new MsgField(ContentEnum.MessageType.STRING.toString(), "lawcna", 24,0, false, "法人代表姓名" )))
.addNode(new FieldNode("lwidtf", new MsgField(ContentEnum.MessageType.STRING.toString(), "lwidtf", 34,0, false, "法人证件类别" )))
.addNode(new FieldNode("lwidno", new MsgField(ContentEnum.MessageType.STRING.toString(), "lwidno", 100,0, false, "法人证件号码" )))
.addNode(new FieldNode("lwided", new MsgField(ContentEnum.MessageType.STRING.toString(), "lwided", 3,0, false, "身份证件有效期" )))
.addNode(new FieldNode("corppr", new MsgField(ContentEnum.MessageType.STRING.toString(), "corppr", 21,0, false, "所有制类" )))
.addNode(new FieldNode("corptp", new MsgField(ContentEnum.MessageType.STRING.toString(), "corptp", 34,0, false, "行业分类" )))
.addNode(new FieldNode("regiam", new MsgField(ContentEnum.MessageType.STRING.toString(), "regiam", 100,0, false, "注册金额" )))
.addNode(new FieldNode("regicd", new MsgField(ContentEnum.MessageType.STRING.toString(), "regicd", 3,0, false, "注册地区代码" )))
.addNode(new FieldNode("regisz", new MsgField(ContentEnum.MessageType.STRING.toString(), "regisz", 21,0, false, "企业规模" )))
.addNode(new FieldNode("dealsp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dealsp", 24,0, false, "经营范围" )))
.addNode(new FieldNode("natitx", new MsgField(ContentEnum.MessageType.STRING.toString(), "natitx", 34,0, false, "国税登记号" )))
.addNode(new FieldNode("locatx", new MsgField(ContentEnum.MessageType.STRING.toString(), "locatx", 100,0, false, "地税登记号" )))
.addNode(new FieldNode("opcfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "opcfno", 3,0, false, "开户证号" )))
.addNode(new FieldNode("upbsac", new MsgField(ContentEnum.MessageType.STRING.toString(), "upbsac", 21,0, false, "基本帐户核准号" )))
.addNode(new FieldNode("upcrcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "upcrcd", 34,0, false, "组织机构代码" )))
.addNode(new FieldNode("upcrna", new MsgField(ContentEnum.MessageType.STRING.toString(), "upcrna", 100,0, false, "法人或主管单位名称" )))
.addNode(new FieldNode("upcrps", new MsgField(ContentEnum.MessageType.STRING.toString(), "upcrps", 3,0, false, "法定代表人" )))
.addNode(new FieldNode("upidtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "upidtp", 21,0, false, "代表人证件类别" )))
.addNode(new FieldNode("upidno", new MsgField(ContentEnum.MessageType.STRING.toString(), "upidno", 24,0, false, "代表人证件号" )))
.addNode(new FieldNode("bsbkna", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsbkna", 34,0, false, "开户银行名称" )))
.addNode(new FieldNode("bsbkno", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsbkno", 100,0, false, "开户银行代码" )))
.addNode(new FieldNode("bsacct", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsacct", 3,0, false, "账号" )))
.addNode(new FieldNode("bsopdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsopdt", 21,0, false, "开户日期" )))
.addNode(new FieldNode("e_mail", new MsgField(ContentEnum.MessageType.STRING.toString(), "e_mail", 34,0, false, "电邮" )))
.addNode(new FieldNode("cutycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cutycd", 100,0, false, "国别代码" )))
.addNode(new FieldNode("custcl", new MsgField(ContentEnum.MessageType.STRING.toString(), "custcl", 3,0, false, "客户级别" )))
.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark", 21,0, false, "备注" )))
.addNode(new FieldNode("contna", new MsgField(ContentEnum.MessageType.STRING.toString(), "contna", 24,0, false, "联系人" )))
.addNode(new FieldNode("regicy", new MsgField(ContentEnum.MessageType.STRING.toString(), "regicy", 34,0, false, "注册地区代码" )))
.addNode(new FieldNode("uprgcy", new MsgField(ContentEnum.MessageType.STRING.toString(), "uprgcy", 100,0, false, "注册币种" )))
.addNode(new FieldNode("uprgam", new MsgField(ContentEnum.MessageType.STRING.toString(), "uprgam", 3,0, false, "法人注册金额" )))
.addNode(new FieldNode("lsmtdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "lsmtdt", 21,0, false, "最后维护日期" )))
.addNode(new FieldNode("netctg", new MsgField(ContentEnum.MessageType.STRING.toString(), "netctg", 34,0, false, "联网核查标识" )))
.addNode(new FieldNode("cropdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cropdt", 100,0, false, "组织机构代码代码证有效期" )))
.addNode(new FieldNode("validt", new MsgField(ContentEnum.MessageType.STRING.toString(), "validt", 3,0, false, "证明文件有效期" )))
.addNode(new FieldNode("others", new MsgField(ContentEnum.MessageType.STRING.toString(), "others", 21,0, false, "证件其他信息" )))
.addNode(new FieldNode("lndfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "lndfno", 24,0, false, "基本户开户许可证" )))
.addNode(new FieldNode("custen", new MsgField(ContentEnum.MessageType.STRING.toString(), "custen", 24,0, false, "客户英文名称" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

