package cn.com.agree.huanan.ap.al.io.service.cbs;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbCoreChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P013000603 账户信息查询.查询账户信息 
 * P0130006.03 mpqrac
 * 0001 核心业务系统
 * @author XZ
 */
@Component
public class P013000603 extends EsbCoreChannelService {

	private static P013000603_I i = new P013000603_I();
	private static P013000603_O o = new P013000603_O();
	public P013000603() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class P013000603_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
.addNode(new FieldNode("prcscd", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcscd", 6,0, true, "处理码" )))
.addNode(new FieldNode("AcctNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "AcctNo", 40,0, true, "账号" )))
.addNode(new FieldNode("infotg", new MsgField(ContentEnum.MessageType.STRING.toString(), "infotg", 1,0, false, "查询类型" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013000603_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
.addNode(new FieldNode("AcctNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "AcctNo", 40,0, false, "账号" )))
.addNode(new FieldNode("AcctNa", new MsgField(ContentEnum.MessageType.STRING.toString(), "AcctNa", 256,0, false, "账户名" )))
.addNode(new FieldNode("OnlnBl", new MsgField(ContentEnum.MessageType.INT.toString(), "OnlnBl", 18,2, false, "余额" )))
.addNode(new FieldNode("CrcyCd", new MsgField(ContentEnum.MessageType.STRING.toString(), "CrcyCd", 2,0, false, "币种" )))
.addNode(new FieldNode("CsexTg", new MsgField(ContentEnum.MessageType.STRING.toString(), "CsexTg", 1,0, false, "钞汇" )))
.addNode(new FieldNode("avblam", new MsgField(ContentEnum.MessageType.STRING.toString(), "avblam", 30,0, false, "可用余额" )))
.addNode(new FieldNode("daabtg", new MsgField(ContentEnum.MessageType.STRING.toString(), "daabtg", 1,0, false, "通存通兑" )))
.addNode(new FieldNode("DrawFs", new MsgField(ContentEnum.MessageType.STRING.toString(), "DrawFs", 1,0, false, "支取方式" )))
.addNode(new FieldNode("AcctSt", new MsgField(ContentEnum.MessageType.STRING.toString(), "AcctSt", 1,0, false, "账户状态" )))
.addNode(new FieldNode("DcmtTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "DcmtTp", 3,0, false, "凭证类型" )))
.addNode(new FieldNode("DcmtNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "DcmtNo", 20,0, false, "凭证号码" )))
.addNode(new FieldNode("dcmtst", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcmtst", 10,0, false, "凭证状态" )))
.addNode(new FieldNode("acctbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctbr", 10,0, false, "账户部门" )))
.addNode(new FieldNode("DebtTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "DebtTp", 2,0, false, "储蓄种类" )))
.addNode(new FieldNode("svdptg", new MsgField(ContentEnum.MessageType.STRING.toString(), "svdptg", 1,0, false, "对公对私" )))
.addNode(new FieldNode("CustNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "CustNo", 10,0, false, "客户号" )))
.addNode(new FieldNode("AcctTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "AcctTp", 1,0, false, "账户类型" )))
.addNode(new FieldNode("IdtfTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdtfTp", 1,0, false, "证件类型" )))
.addNode(new FieldNode("IdtfNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdtfNo", 40,0, false, "证件号码" )))
.addNode(new FieldNode("debtcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "debtcd", 4,0, false, "存款种类" )))
.addNode(new FieldNode("suspst", new MsgField(ContentEnum.MessageType.STRING.toString(), "suspst", 1,0, false, "止付标志" )))
.addNode(new FieldNode("sleptg", new MsgField(ContentEnum.MessageType.STRING.toString(), "sleptg", 1,0, false, "不动户标志" )))
.addNode(new FieldNode("CustLv", new MsgField(ContentEnum.MessageType.STRING.toString(), "CustLv", 2,0, false, "客户级别" )))
.addNode(new FieldNode("spvstg", new MsgField(ContentEnum.MessageType.STRING.toString(), "spvstg", 1,0, false, "监管账户标志" )))
.addNode(new FieldNode("frozam", new MsgField(ContentEnum.MessageType.STRING.toString(), "frozam", 30,0, false, "冻结金额" )))
.addNode(new FieldNode("refram", new MsgField(ContentEnum.MessageType.STRING.toString(), "refram", 30,0, false, "止付金额" )))
.addNode(new FieldNode("cutype", new MsgField(ContentEnum.MessageType.STRING.toString(), "cutype", 1,0, false, "是否设置了主次客户号" )))
.addNode(new FieldNode("matudt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matudt", 8,0, false, "对公账户到期日" )))
.addNode(new FieldNode("inspmd", new MsgField(ContentEnum.MessageType.STRING.toString(), "inspmd", 8,0, false, "年审到期日" )))
.addNode(new FieldNode("lwided", new MsgField(ContentEnum.MessageType.STRING.toString(), "lwided", 8,0, false, "法人身份证有效期" )))
.addNode(new FieldNode("dferdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "dferdt", 8,0, false, "账户延期有效期" )))
.addNode(new FieldNode("efctdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "efctdt", 8,0, false, "证明文件有效期" )))
.addNode(new FieldNode("cropdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cropdt", 8,0, false, "组织机构代码证有效期" )))
.addNode(new FieldNode("insptg", new MsgField(ContentEnum.MessageType.STRING.toString(), "insptg", 1,0, false, "账户年检标志" )))
.addNode(new FieldNode("dispno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dispno", 10,0, false, "显示号" )))
.addNode(new FieldNode("fractg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fractg", 1,0, false, "结汇待支付账户标志" )))
.addNode(new FieldNode("fractp", new MsgField(ContentEnum.MessageType.STRING.toString(), "fractp", 4,0, false, "外币账户性质" )))
.addNode(new FieldNode("affist", new MsgField(ContentEnum.MessageType.STRING.toString(), "affist", 1,0, false, "支付方式状态" )))
.addNode(new FieldNode("exdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "exdate", 8,0, false, "制卡表到期日" )))
.addNode(new FieldNode("OpenDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "OpenDt", 8,0, false, "开户日期" )))
.addNode(new FieldNode("trsmsm", new MsgField(ContentEnum.MessageType.STRING.toString(), "trsmsm", 30,0, false, "非柜面渠道转账可用限额" )))
.addNode(new FieldNode("trddsm", new MsgField(ContentEnum.MessageType.STRING.toString(), "trddsm", 30,0, false, "非柜面转账日累计可用限额" )))
.addNode(new FieldNode("tryysm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tryysm", 30,0, false, "非柜面转账年累计可用限额" )))
.addNode(new FieldNode("trddct", new MsgField(ContentEnum.MessageType.STRING.toString(), "trddct", 10,0, false, "非柜面转账日累计可用次数" )))
.addNode(new FieldNode("mocufg", new MsgField(ContentEnum.MessageType.STRING.toString(), "mocufg", 1,0, false, "同号多客户标志" )))
.addNode(new FieldNode("dtitcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dtitcd", 30,0, false, "业务代码" )))
.addNode(new FieldNode("aclvtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "aclvtp", 1,0, false, "账户分类类别" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

