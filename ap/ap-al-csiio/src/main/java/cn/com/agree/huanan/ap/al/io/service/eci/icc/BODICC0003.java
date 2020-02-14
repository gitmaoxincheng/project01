package cn.com.agree.huanan.ap.al.io.service.eci.icc;

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
 * BASESVC BODICC0003 IC卡圈存 BODICC0003 regflw 渠道整合
 * 
 * @author HYS
 */
@Component
public class BODICC0003 extends EciChannelService {
	/*
	 * 
	 * INSERT INTO CSIS_ATOMIC_SERVICE (AT_SVCID, AT_SVCCODE, AT_SVCNAME,
	 * AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME,
	 * SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES
	 * ('BASESVCBODICC0003', 'BASESVC', '渠道整合', 'BODICC0003', '', 'ECI.AFA',
	 * 'ECI_AFA系统', 'BODICC0003', 'IC卡圈存', 'ic1115','regflw' ,'', '1', '0', '');
	 * 
	 */
	private static BODICC0003_I i = new BODICC0003_I();
	private static BODICC0003_O o = new BODICC0003_O();

	public BODICC0003() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODICC0003_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("Eciorgbuf",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024, 0, false,
									"渠道备注信息")))
					.addNode(new FieldNode("merchId",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "merchId", 1024, 0, false, "商户编号")))
					.addNode(new FieldNode("posId",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "posId", 10, 0, false, "POS终端编号")))
					.addNode(new FieldNode("loadType",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "loadType", 19, 0, false, "圈存类别")))
					.addNode(new FieldNode("areaCode",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "areaCode", 1, 0, false, "地区代码")))
					.addNode(new FieldNode("cardNo",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "cardNo", 16, 0, false, "IC卡卡号")))
					.addNode(new FieldNode("cardBalance",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "cardBalance", 16, 0, false,
									"IC卡内余额")))
					.addNode(new FieldNode("loadAmount",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "loadAmount", 16, 0, false,
									"圈存金额")))
					.addNode(new FieldNode("feeKind",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "feeKind", 74, 0, false, "费率种类")))
					.addNode(new FieldNode("poundage",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "poundage", 10, 0, false,
									"交易手续费金额")))
					.addNode(new FieldNode("outCardNo",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "outCardNo", 2, 0, false, "转出卡号")))
					.addNode(new FieldNode("mainAcctPwd",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "mainAcctPwd", 48, 0, false,
									"卡密码")))
					.addNode(new FieldNode("AID",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "AID", 16, 0, false, "AID")))
					.addNode(new FieldNode("ARQC",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "ARQC", 255, 0, false, "ARQC")))
					.addNode(new FieldNode("ARQCSource",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "ARQCSource",255, 0, false,
									"ARQC生成数据")))
					.addNode(new FieldNode("verifyResult",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "verifyResult", 10, 0, false,
									"终端验证结果")))
					.addNode(new FieldNode("cardSeqNo",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "cardSeqNo", 16, 0, false,
									"卡片序列号")))
					.addNode(new FieldNode("issuerData",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "issuerData", 64, 0, false,
									"应用交易计数器")))
					.addNode(new FieldNode("zpwdfd1",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfd1", 16, 0, false, "加密密码字段")))
					.addNode(new FieldNode("needpwd",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 1, 0, false, "是否验密标志")))
					.addNode(new FieldNode("zmackey",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 30, 0, false, "加密主键名称")))
					.addNode(new FieldNode("zpwdfrm",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 20, 0, false, "密码来源")))
					.addNode(new FieldNode("zacctno1",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "zacctno1", 10, 0, false,
									"加密账号字段")))
					.addNode(new FieldNode("zdcmttp1",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmttp1", 10, 0, false,
									"加密凭证类型字段")))
					.addNode(new FieldNode("zdcmtno1",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmtno1", 10, 0, false,
									"加密凭证号码字段")))
					.addNode(new FieldNode("macmac",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "macmac", 20, 0, false, "MAC校验")))
					.addNode(new FieldNode("mactim",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "mactim", 20, 0, false, "发起时间"))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODICC0003_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("Eciorgbuf",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024, 0, false,
									"渠道备注信息")))
					.addNode(new FieldNode("coreSerialNo",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "coreSerialNo", 12, 0, false,
									"核心主机流水号")))
					.addNode(new FieldNode("coreAccountDate",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "coreAccountDate", 8, 0, false,
									"核心记账日期")))
					.addNode(new FieldNode("writeCardScript",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "writeCardScript", 255, 0, false,
									"写卡脚本")))
					.addNode(new FieldNode("ARPC",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "ARPC", 20, 0, false, "ARPC")))
					.addNode(new FieldNode("poundage",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "poundage", 16, 0, false, "手续费")))
					.addNode(new FieldNode("loadAmount", new MsgField(ContentEnum.MessageType.STRING.toString(),
							"loadAmount", 16, 0, false, "圈存金额"))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

