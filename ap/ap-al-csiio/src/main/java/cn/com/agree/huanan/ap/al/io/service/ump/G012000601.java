package cn.com.agree.huanan.ap.al.io.service.ump;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbUmpChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.G012000601 消息下发.消息下发 
 * G0120006.01 post_msg
 * 0332 统一消息管理平台
 * @author maow
 */
@Component
public class G012000601 extends EsbUmpChannelService {

	private static G012000601_I i = new G012000601_I();
	private static G012000601_O o = new G012000601_O();
	public G012000601() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class G012000601_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("templateno", new MsgField(ContentEnum.MessageType.STRING.toString(), "templateno", 10,0, true, "模版编号" )))
					.addNode(new FieldNode("scheduletime", new MsgField(ContentEnum.MessageType.STRING.toString(), "scheduletime", 14,0, false, "定时时间" )))
					.addNode(new FieldNode("deadline", new MsgField(ContentEnum.MessageType.STRING.toString(), "deadline", 14,0, false, "最后发送时间" )))
					.addNode(new ArrayNode("msg_list",false)
						.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 40,0, false, "交易账号" )))
						.addNode(new FieldNode("phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone", 30,0, false, "手机号码" )))
						.addNode(new FieldNode("email", new MsgField(ContentEnum.MessageType.STRING.toString(), "email", 50,0, false, "邮箱地址" )))
						.addNode(new FieldNode("content", new MsgField(ContentEnum.MessageType.STRING.toString(), "content", 5000,0, false, "消息内容" )))
						.addNode(new FieldNode("custommsgid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custommsgid", 50,0, false, "自定义消息ID" )))
						.addNode(new FieldNode("userno", new MsgField(ContentEnum.MessageType.INT.toString(), "userno", 256,0, false, "验证码关键字符串" )))
						.addNode(new FieldNode("isdigitret", new MsgField(ContentEnum.MessageType.STRING.toString(), "isdigitret", 1,0, false, "验证码是否为纯数字" )))
						.addNode(new FieldNode("vercodeefftime", new MsgField(ContentEnum.MessageType.STRING.toString(), "vercodeefftime", 50,0, false, "验证码有效时间" )))
						.addNode(new FieldNode("time", new MsgField(ContentEnum.MessageType.STRING.toString(), "time", 50,0, false, "时间" )))
						.addNode(new FieldNode("acctna", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctna", 200,0, false, "账户名称(姓名)" )))
						.addNode(new FieldNode("tranacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranacctno", 40,0, false, "转账账号" )))
						.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 20,0, false, "客户名称" )))
						.addNode(new FieldNode("acctno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno1", 4,0, false, "账户后4位" )))
						.addNode(new FieldNode("tlrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlrno", 10,0, false, "受理柜员" )))
						.addNode(new FieldNode("tlrname", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlrname", 50,0, false, "受理柜员名称" )))
						.addNode(new FieldNode("feeamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "feeamt", 20,0, false, "手续费金额" )))
						.addNode(new FieldNode("devno", new MsgField(ContentEnum.MessageType.STRING.toString(), "devno", 30,0, false, "设备号" )))
						.addNode(new FieldNode("authcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "authcode", 20,0, false, "认证码" )))
						.addNode(new FieldNode("creamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "creamt", 20,0, false, "交易金额" )))
						.addNode(new FieldNode("appnumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "appnumber", 50,0, false, "申请编号" )))
						.addNode(new FieldNode("prodno", new MsgField(ContentEnum.MessageType.STRING.toString(), "prodno", 50,0, false, "产品号码" )))
						.addNode(new FieldNode("prodna", new MsgField(ContentEnum.MessageType.STRING.toString(), "prodna", 50,0, false, "产品名称" )))
						.addNode(new FieldNode("datedur", new MsgField(ContentEnum.MessageType.STRING.toString(), "datedur", 50,0, false, "日期期限" )))
						.addNode(new FieldNode("orgna", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgna", 50,0, false, "机构名称" )))
						.addNode(new FieldNode("orgcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgcode", 12,0, false, "机构号" )))
						.addNode(new FieldNode("dynamicpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dynamicpwd", 50,0, false, "动态密码" )))
						.addNode(new FieldNode("acctbal", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctbal", 50,0, false, "账户余额" )))
						.addNode(new FieldNode("amountmat", new MsgField(ContentEnum.MessageType.STRING.toString(), "amountmat", 50,0, false, "设置金额" )))
						.addNode(new FieldNode("lendrate", new MsgField(ContentEnum.MessageType.STRING.toString(), "lendrate", 50,0, false, "贷款利率" )))
						.addNode(new FieldNode("amountpay", new MsgField(ContentEnum.MessageType.STRING.toString(), "amountpay", 50,0, false, "还款金额" )))
						.addNode(new FieldNode("abroadsign", new MsgField(ContentEnum.MessageType.STRING.toString(), "abroadsign", 50,0, false, "境内外标志" )))
						.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 256,0, false, "渠道" )))
						.addNode(new FieldNode("tran", new MsgField(ContentEnum.MessageType.STRING.toString(), "tran", 50,0, false, "交易简称" )))
						.addNode(new FieldNode("nickname", new MsgField(ContentEnum.MessageType.STRING.toString(), "nickname", 50,0, false, "签约短信服务的昵称" )))
						.addNode(new FieldNode("field1", new MsgField(ContentEnum.MessageType.STRING.toString(), "field1", 50,0, false, "保留字段" )))
						.addNode(new FieldNode("field2", new MsgField(ContentEnum.MessageType.STRING.toString(), "field2", 50,0, false, "保留字段" )))
						.addNode(new FieldNode("field3", new MsgField(ContentEnum.MessageType.STRING.toString(), "field3", 50,0, false, "保留字段" )))
						.addNode(new FieldNode("field4", new MsgField(ContentEnum.MessageType.STRING.toString(), "field4", 50,0, false, "保留字段" )))
						.addNode(new FieldNode("field5", new MsgField(ContentEnum.MessageType.STRING.toString(), "field5", 50,0, false, "保留字段" )))
						//微网点
						.addNode(new FieldNode("queuenum", new MsgField(ContentEnum.MessageType.STRING.toString(), "queuenum", 50,0, false, "排队号" )))
						.addNode(new FieldNode("waitnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "waitnum", 50,0, false, "排队人数" )))
						.addNode(new FieldNode("brna", new MsgField(ContentEnum.MessageType.STRING.toString(), "brna", 50,0, false, "网点名称" )))
						.addNode(new FieldNode("cardtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardtype", 50,0, false, "卡种" )))
						.addNode(new FieldNode("exptime", new MsgField(ContentEnum.MessageType.STRING.toString(), "exptime", 50,0, false, "有效时间" )))
						.addNode(new FieldNode("webaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "webaddr", 50,0, false, "网址" )))
						.addNode(new FieldNode("comname", new MsgField(ContentEnum.MessageType.STRING.toString(), "comname", 50,0, false, "公司名称" )))
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class G012000601_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
.addNode(new FieldNode("uuid", new MsgField(ContentEnum.MessageType.STRING.toString(), "uuid", 50,0, true, "响应消息ID" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

