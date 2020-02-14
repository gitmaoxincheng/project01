package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODAFA1694 录音录像前台登记 录音录像前台登记
 * BODAFA1694 205008 params
 * 20 前置AFA
 * @author JZF
 */
@Component
public class BODAFA1694 extends EciChannelService {
	/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCBODAFA1694', 'BASESVC', '前置AFA', 'BODAFA1694', '录音录像前台登记', 'ECI.AFA', 'ECI-AFA系统', 'BODAFA1694', '录音录像前台登记', '205008', 'params', '录音录像前台登记', '1', '0', '录音录像前台登记');

	 */
	private static BODAFA1694_I i = new BODAFA1694_I();
	private static BODAFA1694_O o = new BODAFA1694_O();

	public BODAFA1694() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1694_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("batchno", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchno", 14,0, false, "汇总流水" )))
					.addNode(new FieldNode("channelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelserno", 25,0, false, "前端流水号" )))
					.addNode(new FieldNode("videoid", new MsgField(ContentEnum.MessageType.STRING.toString(), "videoid", 20,0, false, "录制编号" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 40,0, false, "卡号帐号" )))
					.addNode(new FieldNode("editflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "editflag", 20,0, false, "修改标志" )))
					.addNode(new FieldNode("clientname", new MsgField(ContentEnum.MessageType.STRING.toString(), "clientname", 80,0, false, "客户名称" )))
					.addNode(new FieldNode("clienttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "clienttype", 2,0, false, "客户类别" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 2,0, false, "客户证件类型" )))
					.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 30,0, false, "客户证件号码" )))
					.addNode(new FieldNode("prdtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdtype", 2,0, false, "产品类型" )))
					.addNode(new FieldNode("prdcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdcode", 6,0, false, "产品代码" )))
					.addNode(new FieldNode("prdname", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdname", 20,0, false, "产品名称" )))
					.addNode(new FieldNode("enddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "enddate", 8,0, false, "产品到期日" )))
					.addNode(new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno", 10,0, false, "柜员号" )))
					.addNode(new FieldNode("zoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "zoneno", 10,0, false, "分行号" )))
					.addNode(new FieldNode("mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mbrno", 10,0, false, "支行号" )))
					.addNode(new FieldNode("brno", new MsgField(ContentEnum.MessageType.STRING.toString(), "brno", 10,0, false, "网点号" )))
					.addNode(new FieldNode("tellername", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellername", 20,0, false, "柜员名" )))
					.addNode(new FieldNode("videolcpath", new MsgField(ContentEnum.MessageType.STRING.toString(), "videolcpath", 200,0, false, "录音录像本地文件路径" )))
					.addNode(new FieldNode("videoabpath", new MsgField(ContentEnum.MessageType.STRING.toString(), "videoabpath", 200,0, false, "录音录像AB端文件路径" )))
					.addNode(new FieldNode("vstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "vstatus", 2,0, false, "录像状态" )))
					.addNode(new FieldNode("astatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "astatus", 2,0, false, "审核状态" )))
					.addNode(new FieldNode("gstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "gstatus", 2,0, false, "购买状态" )))
					.addNode(new FieldNode("bakfield1", new MsgField(ContentEnum.MessageType.STRING.toString(), "bakfield1", 64,0, false, "备用字段1" )))
					.addNode(new FieldNode("bakfield2", new MsgField(ContentEnum.MessageType.STRING.toString(), "bakfield2", 64,0, false, "备用字段2" )))
					.addNode(new FieldNode("vauthno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vauthno", 10,0, false, "复核柜员号" )))
					.addNode(new FieldNode("vauthna", new MsgField(ContentEnum.MessageType.STRING.toString(), "vauthna", 20,0, false, "复核柜员名称" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODAFA1694_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
