package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODAFA0204  微信消息通知联机接口 
 *  BODAFA0204 884401
 *  综合前置
 * @author xuzhen
 */
@Component
public class BODAFA0204 extends EciChannelService {

	private static BODAFA0204_I i = new BODAFA0204_I();
	private static BODAFA0204_O o = new BODAFA0204_O();
	public BODAFA0204() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODAFA0204_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
				.addStructNode(new StructNode("APPBody",true,"Body")
				.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
				.addNode(new FieldNode("channeltype", new MsgField(ContentEnum.MessageType.STRING.toString(), "channeltype", 2,0, false, "发送消息类型" )))
				.addNode(new FieldNode("msgtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "msgtype", 2,0, false, "通知类型" )))
				.addNode(new FieldNode("wxsrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "wxsrno", 10,0, false, "微信序号" )))
				.addNode(new FieldNode("dxsrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dxsrno", 10,0, false, "短信序号" )))
				.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 32,0, false, "交易账号" )))
				.addNode(new FieldNode("phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone", 11,0, false, "手机号码" )))
				.addNode(new FieldNode("sendtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "sendtp", 2,0, false, "短信类型" )))
				.addNode(new FieldNode("gntime", new MsgField(ContentEnum.MessageType.STRING.toString(), "gntime", 19,0, true, "生成时间" )))
				.addNode(new FieldNode("userid", new MsgField(ContentEnum.MessageType.STRING.toString(), "userid", 5,0, false, "操作柜员" )))
				.addNode(new FieldNode("trbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "trbrno", 4,0, false, "交易网点" )))
				.addNode(new FieldNode("febrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "febrno", 4,0, false, "统计网点" )))
				.addNode(new FieldNode("fezone", new MsgField(ContentEnum.MessageType.STRING.toString(), "fezone", 4,0, false, "所属分行号" )))
				.addNode(new FieldNode("sdacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "sdacctno", 40,0,false,"银行账号")))
				.addNode(new FieldNode("dcmttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcmttp", 20,0,false,"凭证类型")))
				.addNode(new FieldNode("trdamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trdamt", 20,0,false,"交易金额")))
				.addNode(new FieldNode("msgtxt", new MsgField(ContentEnum.MessageType.STRING.toString(), "msgtxt", 400,0,false,"交易类型")))
				.addNode(new FieldNode("amntcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "amntcd", 1,0,false,"支出收入标识")))
				.addNode(new FieldNode("title", new MsgField(ContentEnum.MessageType.STRING.toString(), "title", 100,0,false,"标题")))
				.addNode(new FieldNode("tradeaddress", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradeaddress", 140,0,false,"交易地址")))
				.addNode(new FieldNode("tradecontent", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradecontent", 512,0,false,"交易内容")))
				.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark", 140,0,false,"备注信息")))
				.addNode(new FieldNode("userId", new MsgField(ContentEnum.MessageType.STRING.toString(), "userId", 20,0,false,"唯一客户号（核心客户号）")))
				.addNode(new FieldNode("billamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "billamt", 20,0,false,"人民币交易金额")))
				.addNode(new FieldNode("nbrmths", new MsgField(ContentEnum.MessageType.STRING.toString(), "nbrmths", 10,0,false,"分期期数")))
				.addNode(new FieldNode("instalamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "instalamt", 20,0,false,"每期本金")))
				.addNode(new FieldNode("feeinstl", new MsgField(ContentEnum.MessageType.STRING.toString(), "feeinstl", 20,0,false,"每期手续费")))
				.addNode(new FieldNode("result", new MsgField(ContentEnum.MessageType.STRING.toString(), "result", 10,0,false,"办理结果")))
				.addNode(new FieldNode("servicename", new MsgField(ContentEnum.MessageType.STRING.toString(), "servicename", 50,0,false,"业务名称")))
				.addNode(new FieldNode("firstname", new MsgField(ContentEnum.MessageType.STRING.toString(), "firstname", 20,0,false,"客户姓氏")))
				.addNode(new FieldNode("customersex", new MsgField(ContentEnum.MessageType.STRING.toString(), "customersex", 10,0,false,"客户性别")))
				.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark", 200,0,false,"remark")))
				.addNode(new FieldNode("cstno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstno", 20,0,false,"客户号")))
				.addNode(new FieldNode("busintx", new MsgField(ContentEnum.MessageType.STRING.toString(), "busintx", 10,0,false,"业务类型")))
				.addNode(new FieldNode("attendst", new MsgField(ContentEnum.MessageType.STRING.toString(), "attendst", 10,0,false,"办理状态")))
				.addNode(new FieldNode("attenddt", new MsgField(ContentEnum.MessageType.STRING.toString(), "attenddt", 20,0,false,"办理时间")))
				.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark", 200,0,false,"备注")))
				.addNode(new FieldNode("title", new MsgField(ContentEnum.MessageType.STRING.toString(), "title", 100,0,false,"首条标语")))
				.addNode(new FieldNode("busintx", new MsgField(ContentEnum.MessageType.STRING.toString(), "busintx", 100,0,false,"业务类型")))
				.addNode(new FieldNode("signrlt", new MsgField(ContentEnum.MessageType.STRING.toString(), "signrlt", 100,0,false,"签约结果")))
				.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark", 200,0,false,"备注")))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0204_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
.addStructNode(new StructNode("Body",true,"APPBody")
.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	@Override
	public void initContent(Map<String, Object> tradeContext) {
		Map<String, Object> appHeader = (Map<String, Object>) tradeContext.get(CommConstant.APP_HEADER);
		Map<String, Object> csisHeader = (Map<String, Object>) tradeContext.get(CommConstant.CSIS_HEADER);
		appHeader.put("xmlflag", "1");
		appHeader.put("templateCodeName", "dsdfcm");
		appHeader.put("transCode", "884401");
		appHeader.put("sysId", "44");
		appHeader.put("channelCode", "011");
		appHeader.put("tradeFlag", "0");
		appHeader.put("checkFlag", "0");
		appHeader.put("prcscd", "wxmbmsg");
		appHeader.put("subchannelCode", csisHeader.get("SrcCalCod"));
		super.initContent(tradeContext);
	}
}

