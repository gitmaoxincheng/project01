package cn.com.agree.huanan.ap.al.io.service.eci.afa;

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
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;

/**
 * BASESVC BODF510301  当日可撤单流水查询
 * BODF510301 510301 regflw
 *  新核心系统
 * @author STJ
 */
@Component
public class BODF510301 extends EciChannelService {
/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCBODF510301', 'BASESVC', '新核心系统', 'BODF510301', '', 'ECI.AFA', 'ECI-AFA系统', 'BODF510301', '当日可撤单流水查询', '510301', 'regflw', '', '1', '0', '');

*/
	private static BODF510301_I i = new BODF510301_I();
	private static BODF510301_O o = new BODF510301_O();

	public BODF510301() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODF510301_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
.addStructNode(new StructNode("APPBody", true, "Body")
.addNode(new FieldNode("jyzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyzh", 30,0, false, "交易帐号" )))
.addNode(new FieldNode("gsdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsdm", 6,0, false, "公司代码" )))
.addNode(new FieldNode("cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpdm", 12,0, false, "产品代码" )))
.addNode(new FieldNode("ptlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptlsh", 24,0, false, "平台流水号" )))
.addNode(new FieldNode("bdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bdh", 30,0, false, "保单号" )))
.addNode(new FieldNode("pxbz", new MsgField(ContentEnum.MessageType.STRING.toString(), "pxbz", 1,0, false, "排序标志" )))
.addNode(new FieldNode("tbrzjlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrzjlx", 1,0, false, "投保人证件类型" )))
.addNode(new FieldNode("tbrzjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrzjhm", 30,0, false, "投保人证件号码" )))
.addNode(new FieldNode("offset", new MsgField(ContentEnum.MessageType.STRING.toString(), "offset", 15,0, false, "定位串" )))
.addNode(new FieldNode("querynum", new MsgField(ContentEnum.MessageType.STRING.toString(), "querynum", 15,0, false, "查询行数" )))
);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODF510301_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
.addStructNode(new StructNode("Body", true, "APPBody")
.addNode(new FieldNode("totnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totnum", 15,0, false, "总行数" )))
.addNode(new FieldNode("retnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "retnum", 15,0, false, "本次返回行数" )))
.addNode(new FieldNode("offset", new MsgField(ContentEnum.MessageType.STRING.toString(), "offset", 15,0, false, "定位串" )))
.addNode(new ArrayNode("bodrcd", true,"detail_list")
.addNode(new FieldNode("jyrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyrq", 8,0, false, "交易日期" )))
.addNode(new FieldNode("jysj", new MsgField(ContentEnum.MessageType.STRING.toString(), "jysj", 6,0, false, "交易时间" )))
.addNode(new FieldNode("ptlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptlsh", 24,0, false, "平台流水号" )))
.addNode(new FieldNode("jydm", new MsgField(ContentEnum.MessageType.STRING.toString(), "jydm", 6,0, false, "交易码" )))
.addNode(new FieldNode("jymc", new MsgField(ContentEnum.MessageType.STRING.toString(), "jymc", 20,0, false, "交易名称" )))
.addNode(new FieldNode("cpmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpmc", 250,0, false, "产品名称" )))
.addNode(new FieldNode("gsdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsdm", 6,0, false, "公司代码" )))
.addNode(new FieldNode("cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpdm", 12,0, false, "产品代码" )))
.addNode(new FieldNode("bdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bdh", 30,0, false, "保单号" )))
.addNode(new FieldNode("jyzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyzh", 30,0, false, "交易账号" )))
.addNode(new FieldNode("jyje", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyje", 15,0, false, "交易金额" )))
.addNode(new FieldNode("jyzt", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyzt", 1,0, false, "交易状态" )))
.addNode(new FieldNode("jyjg", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyjg", 16,0, false, "交易机构" )))
.addNode(new FieldNode("jygy", new MsgField(ContentEnum.MessageType.STRING.toString(), "jygy", 8,0, false, "交易柜员" )))
.addNode(new FieldNode("jyqd", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyqd", 3,0, false, "交易渠道" )))
.addNode(new FieldNode("tbrxm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrxm", 20,0, false, "投保人姓名" )))
));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
