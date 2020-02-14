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
 * BASESVC BODAFA0041  贷记卡客户信息查询 
 *  BODAFA0041 881004
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA0041 extends EciChannelService {

	private static BODAFA0041_I i = new BODAFA0041_I();
	private static BODAFA0041_O o = new BODAFA0041_O();
	public BODAFA0041() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0041_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 19,0, false, "卡号" )))
					.addNode(new FieldNode("qrtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "qrtype", 1,0, false, "查询方式" )))
					.addNode(new FieldNode("keytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "keytype", 2,0, false, "证件类型" )))
					.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 18,0, false, "证件号码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0041_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 10,0, false, "记录数" )))
					.addNode(new ArrayNode("bodrcd",true,"bodrcd")
							.addNode(new FieldNode("trxtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "trxtype", 6,0, false, "交易代码" )))
							.addNode(new FieldNode("retcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "retcode", 10,0, false, "响应码" )))
							.addNode(new FieldNode("bnknbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "bnknbr", 40,0, false, "银行代号" )))
							.addNode(new FieldNode("source", new MsgField(ContentEnum.MessageType.STRING.toString(), "source", 100,0, false, "交易来源" )))
							.addNode(new FieldNode("brchno", new MsgField(ContentEnum.MessageType.STRING.toString(), "brchno", 10,0, false, "网点代号" )))
							.addNode(new FieldNode("userid", new MsgField(ContentEnum.MessageType.STRING.toString(), "userid", 10,0, false, "操作员号" )))
							.addNode(new FieldNode("seqno", new MsgField(ContentEnum.MessageType.STRING.toString(), "seqno", 20,0, false, "流水号" )))
							.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 40,0, false, "卡号" )))
							.addNode(new FieldNode("option", new MsgField(ContentEnum.MessageType.STRING.toString(), "option", 1,0, false, "选项" )))
							.addNode(new FieldNode("keytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "keytype", 10,0, false, "证件类型" )))
							.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 40,0, false, "证件号码" )))
							.addNode(new FieldNode("cnname", new MsgField(ContentEnum.MessageType.STRING.toString(), "cnname", 100,0, false, "中文姓名" )))
							.addNode(new FieldNode("enname", new MsgField(ContentEnum.MessageType.STRING.toString(), "enname", 100,0, false, "英文姓名" )))
							.addNode(new FieldNode("gender", new MsgField(ContentEnum.MessageType.STRING.toString(), "gender", 6,0, false, "性别" )))
							.addNode(new FieldNode("nation", new MsgField(ContentEnum.MessageType.STRING.toString(), "nation", 20,0, false, "国籍" )))
							.addNode(new FieldNode("married", new MsgField(ContentEnum.MessageType.STRING.toString(), "married", 10,0, false, "婚姻状况" )))
							.addNode(new FieldNode("education", new MsgField(ContentEnum.MessageType.STRING.toString(), "education", 40,0, false, "教育程度" )))
							.addNode(new FieldNode("jobposit", new MsgField(ContentEnum.MessageType.STRING.toString(), "jobposit", 30,0, false, "职务分类" )))
							.addNode(new FieldNode("homephone", new MsgField(ContentEnum.MessageType.STRING.toString(), "homephone", 100,0, false, "家庭电话" )))
							.addNode(new FieldNode("busiphone", new MsgField(ContentEnum.MessageType.STRING.toString(), "busiphone", 20,0, false, "公司电话" )))
							.addNode(new FieldNode("busiext", new MsgField(ContentEnum.MessageType.STRING.toString(), "busiext", 20,0, false, "公司电话分机" )))
							.addNode(new FieldNode("mobilephone", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobilephone", 20,0, false, "手机号码" )))
							.addNode(new FieldNode("email", new MsgField(ContentEnum.MessageType.STRING.toString(), "email", 100,0, false, "E-mail地址" )))
							.addNode(new FieldNode("faxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "faxno", 30,0, false, "传真机号码" )))
							.addNode(new FieldNode("resideyes", new MsgField(ContentEnum.MessageType.STRING.toString(), "resideyes", 10,0, false, "居住年数" )))
							.addNode(new FieldNode("residests", new MsgField(ContentEnum.MessageType.STRING.toString(), "residests", 100,0, false, "住房情况" )))
							.addNode(new FieldNode("businame", new MsgField(ContentEnum.MessageType.STRING.toString(), "businame", 100,0, false, "单位名称" )))
							.addNode(new FieldNode("dept", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept", 30,0, false, "部门" )))
							.addNode(new FieldNode("job", new MsgField(ContentEnum.MessageType.STRING.toString(), "job", 10,0, false, "职务" )))
							.addNode(new FieldNode("trade", new MsgField(ContentEnum.MessageType.STRING.toString(), "trade", 40,0, false, "行业类别代码" )))
							.addNode(new FieldNode("busitype", new MsgField(ContentEnum.MessageType.STRING.toString(), "busitype", 100,0, false, "行业性质" )))
							.addNode(new FieldNode("jobyes", new MsgField(ContentEnum.MessageType.STRING.toString(), "jobyes", 100,0, false, "公司服务年数" )))
							.addNode(new FieldNode("earning", new MsgField(ContentEnum.MessageType.STRING.toString(), "earning", 10,0, false, "年收入" )))
							.addNode(new FieldNode("spousern", new MsgField(ContentEnum.MessageType.STRING.toString(), "spousern", 10,0, false, "配偶年收入" )))
							.addNode(new FieldNode("reserve1", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserve1", 100,0, false, "客户预留问题" )))
							.addNode(new FieldNode("reserve2", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserve2", 100,0, false, "客户预留答案" )))
							.addNode(new FieldNode("cusrt_cred", new MsgField(ContentEnum.MessageType.STRING.toString(), "cusrt_cred", 17,0, false, "客户信用额度" )))
							.addNode(new FieldNode("custr_credx", new MsgField(ContentEnum.MessageType.STRING.toString(), "custr_credx", 17,0, false, "客户美元额度" )))
							.addNode(new FieldNode("mp_cred", new MsgField(ContentEnum.MessageType.STRING.toString(), "mp_cred", 17,0, false, "客户分期付款额度" )))
							.addNode(new FieldNode("cred_aval", new MsgField(ContentEnum.MessageType.STRING.toString(), "cred_aval", 17,0, false, "客户可用额度" )))
							.addNode(new FieldNode("cash_aval", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_aval", 17,0, false, "客户预借现金额度" )))
							.addNode(new FieldNode("Khcode1", new MsgField(ContentEnum.MessageType.STRING.toString(), "Khcode1", 10,0, false, "客户层分层代码1" )))
							.addNode(new FieldNode("Khcode2", new MsgField(ContentEnum.MessageType.STRING.toString(), "Khcode2", 10,0, false, "客户层分层代码2" )))
							.addNode(new FieldNode("forecomp", new MsgField(ContentEnum.MessageType.STRING.toString(), "forecomp", 100,0, false, "原工作单位" )))
							.addNode(new FieldNode("fjobtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "fjobtime", 14,0, false, "首次参加工作时间" )))
							.addNode(new FieldNode("birthday", new MsgField(ContentEnum.MessageType.STRING.toString(), "birthday", 8,0, false, "出生日期" )))
							.addNode(new FieldNode("pin_set", new MsgField(ContentEnum.MessageType.STRING.toString(), "pin_set", 1,0, false, "是否设置客户级查询密码" )))
							.addNode(new FieldNode("custr_ref", new MsgField(ContentEnum.MessageType.STRING.toString(), "custr_ref", 20,0, false, "客户参考资料编码" )))
							.addNode(new FieldNode("crell", new MsgField(ContentEnum.MessageType.STRING.toString(), "crell", 17,0, false, "客户预借现金可用额度" )))
							.addNode(new FieldNode("htel_area", new MsgField(ContentEnum.MessageType.STRING.toString(), "htel_area", 20,0, false, "家庭电话区号" )))
							.addNode(new FieldNode("revs", new MsgField(ContentEnum.MessageType.STRING.toString(), "revs", 100,0, false, "保留字段" )))
							.addNode(new FieldNode("con_name1", new MsgField(ContentEnum.MessageType.STRING.toString(), "con_name1", 100,0, false, "联系人姓名1" )))
							.addNode(new FieldNode("con_tel1", new MsgField(ContentEnum.MessageType.STRING.toString(), "con_tel1", 20,0, false, "联系人电话1" )))
							.addNode(new FieldNode("con_name2", new MsgField(ContentEnum.MessageType.STRING.toString(), "con_name2", 100,0, false, "联系人姓名2" )))
							.addNode(new FieldNode("con_tel2", new MsgField(ContentEnum.MessageType.STRING.toString(), "con_tel2", 20,0, false, "联系人电话2" )))
							.addNode(new FieldNode("maflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "maflag", 60,0, false, "与主卡关系" )))
							.addNode(new FieldNode("idno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idno", 40,0, false, "证件号" )))
							.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 100,0, false, "姓名" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

