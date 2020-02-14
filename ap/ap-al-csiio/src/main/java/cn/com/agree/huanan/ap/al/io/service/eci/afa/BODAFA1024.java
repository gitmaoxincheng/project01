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

/**
 * BASESVC BODAFA1024  ATM吞吐卡短信发送 
 *  BODAFA1024 884414
 *  渠道整合
 * @author HYS
 */
@Component
public class BODAFA1024 extends EciChannelService {
/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCBODAFA1024', 'BASESVC', '渠道整合', 'BODAFA1024', '', 'ECI.AFA', 'ECI_AFA系统', 'BODAFA1024', 'ATM吞吐卡短信发送', '884414','884414' ,'', '1', '0', '');

*/
	private static BODAFA1024_I i = new BODAFA1024_I();
	private static BODAFA1024_O o = new BODAFA1024_O();
	public BODAFA1024() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODAFA1024_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Ctrl",true)
.addNode(new FieldNode("eciSeverId", new MsgField(ContentEnum.MessageType.STRING.toString(), "eciSeverId", 10,0, false, "ECI服务接口ID" )))
.addNode(new FieldNode("xmlflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "xmlflag", 1,0, false, "报文标识" )))
.addNode(new FieldNode("templateCodeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "templateCodeName", 6,0, false, "模板名称" )))
.addNode(new FieldNode("transCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "transCode", 6,0, false, "交易代码" )))
.addNode(new FieldNode("sysId", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysId", 6,0, false, "系统标识" )))
.addNode(new FieldNode("channelCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelCode", 3,0, false, "渠道分类" )))
.addNode(new FieldNode("subchannelCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "subchannelCode", 3,0, false, "渠道标识" )))
.addNode(new FieldNode("tradeFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradeFlag", 1,0, false, "是否需要勾兑" )))
.addNode(new FieldNode("checkFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "checkFlag", 1,0, false, "是否需要判重" )))
.addNode(new FieldNode("prcscd", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcscd", 10,0, false, "渠道处理码" )))
.addNode(new FieldNode("channelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelserno", 40,0, false, "渠道分类流水号" )))
.addNode(new FieldNode("vm_tellerflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_tellerflag", 1,0, false, "柜员使用标志" )))
.addNode(new FieldNode("vm_sessid", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_sessid", 32,0, false, "虚拟柜员会话标识" )))
.addNode(new FieldNode("vm_zoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_zoneno", 10,0, false, "虚拟柜员操作分行" )))
.addNode(new FieldNode("vm_mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_mbrno", 10,0, false, "虚拟柜员操作支行" )))
.addNode(new FieldNode("vm_brno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_brno", 10,0, false, "虚拟柜员操作网点" )))
.addNode(new FieldNode("vm_tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_tellerno", 10,0, false, "虚拟柜员" )))
.addNode(new FieldNode("vm_tellertp", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_tellertp", 1,0, false, "虚拟柜员柜员类别" )))
.addNode(new FieldNode("vm_csbxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_csbxno", 10,0, false, "虚拟柜员柜员钱箱" )))
.addNode(new FieldNode("vm_dutytp", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_dutytp", 10,0, false, "虚拟柜员岗位类型" )))
.addNode(new FieldNode("vm_dutyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_dutyno", 20,0, false, "虚拟柜员岗位编号" )))
.addNode(new FieldNode("sessid", new MsgField(ContentEnum.MessageType.STRING.toString(), "sessid", 32,0, false, "会话标识" )))
.addNode(new FieldNode("zoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "zoneno", 10,0, false, "操作分行" )))
.addNode(new FieldNode("mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mbrno", 10,0, false, "操作支行" )))
.addNode(new FieldNode("brno", new MsgField(ContentEnum.MessageType.STRING.toString(), "brno", 10,0, false, "操作网点" )))
.addNode(new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno", 10,0, false, "操作柜员" )))
.addNode(new FieldNode("tellertp", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellertp", 1,0, false, "柜员类别" )))
.addNode(new FieldNode("csbxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "csbxno", 10,0, false, "柜员钱箱号" )))
.addNode(new FieldNode("dutytp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutytp", 10,0, false, "岗位类型" )))
.addNode(new FieldNode("dutyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutyno", 20,0, false, "实体岗位编号" )))
.addNode(new FieldNode("authno", new MsgField(ContentEnum.MessageType.STRING.toString(), "authno", 10,0, false, "授权员" )))
.addNode(new FieldNode("authpw", new MsgField(ContentEnum.MessageType.STRING.toString(), "authpw", 64,0, false, "授权员密码" )))
.addNode(new FieldNode("authmg", new MsgField(ContentEnum.MessageType.STRING.toString(), "authmg", 512,0, false, "授权员指纹" )))
.addNode(new FieldNode("authce", new MsgField(ContentEnum.MessageType.STRING.toString(), "authce", 4,0, false, "授权员验证类型" )))
.addNode(new FieldNode("authmanfttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "authmanfttype", 1,0, false, "授权员指纹厂商" )))
.addNode(new FieldNode("replyquery", new MsgField(ContentEnum.MessageType.STRING.toString(), "replyquery", 20,0, false, "请求应答队列名" )))
)
.addStructNode(new StructNode("APPBody",true,"Body")
.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 32,0, false, "账号" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1024_O extends MsgBody {
		private MsgSegment  msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode
					.addStructNode(new StructNode("Ctrl", true)
							.addNode(new FieldNode("errorCode",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "errorCode", 8, 0, false,
											"返回代码")))
							.addNode(new FieldNode("errorMsg",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "errorMsg", 255, 0, false,
											"返回信息")))
							.addNode(new FieldNode("workdate",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "workdate", 8, 0, false,
											"综合前置日期")))
							.addNode(new FieldNode("worktime",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "worktime", 6, 0, false,
											"综合前置时间")))
							.addNode(new FieldNode("serialno",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "serialno", 10, 0, false,
											"综合前置流水")))
							.addNode(new FieldNode("sverretcod",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "sverretcod", 8, 0, false,
											"后台服务返回代码")))
							.addNode(new FieldNode("sverretmsg",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "sverretmsg", 255, 0, false,
											"后台服务返回信息")))
							.addNode(new FieldNode("sverworkdate",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "sverworkdate", 8, 0, false,
											"后台服务返回日期")))
							.addNode(new FieldNode("sverworktime",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "sverworktime", 6, 0, false,
											"后台服务返回时间")))
							.addNode(new FieldNode("sverserialno",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "sverserialno", 20, 0,
											false, "后台服务返回流水")))
							.addNode(new FieldNode("channelserno",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "channelserno", 40, 0,
											false, "渠道分类流水号"))))
					.addStructNode(new StructNode("Body", true, "APPBody")
							.addNode(new FieldNode("Eciorgbuf",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024, 0, false,
											"渠道备注信息")))
							.addNode(new FieldNode("mobilephone", new MsgField(
									ContentEnum.MessageType.STRING.toString(), "mobilephone", 32, 0, false, "手机号码"))));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

