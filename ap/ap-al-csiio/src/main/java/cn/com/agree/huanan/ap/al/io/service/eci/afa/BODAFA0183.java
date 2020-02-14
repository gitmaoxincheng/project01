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
 * BASESVC BODAFA0183 贷记卡客户资料地址查询及更新 贷记卡客户资料地址查询及更新
 * BODAFA0183 881004 dsdfcm
 * cd020a 渠道整合
 * @author JZF
 */
@Component
public class BODAFA0183 extends EciChannelService {
	private static BODAFA0183_I i = new BODAFA0183_I();
	private static BODAFA0183_O o = new BODAFA0183_O();

	public BODAFA0183() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0183_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 19,0, false, "卡号" )))
					.addNode(new FieldNode("passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "passwd", 8,0, false, "密码" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 2,0, false, "密钥序号" )))
					.addNode(new FieldNode("qurty", new MsgField(ContentEnum.MessageType.STRING.toString(), "qurty", 1,0, false, "查询方式" )))
					.addNode(new FieldNode("option", new MsgField(ContentEnum.MessageType.STRING.toString(), "option", 1,0, false, "选项" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 1,0, true, "是否需要密码" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 20,0, false, "密码的来源" )))
					.addNode(new FieldNode("keytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "keytype", 2,0, false, "证件类型" )))
					.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 18,0, false, "证件号码" )))
					.addNode(new FieldNode("pin_flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pin_flag", 1,0, false, "是否检查密码标志" )))
					.addNode(new FieldNode("stsmail", new MsgField(ContentEnum.MessageType.STRING.toString(), "stsmail", 1,0, false, "账单地址标志" )))
					.addNode(new FieldNode("add1_1", new MsgField(ContentEnum.MessageType.STRING.toString(), "add1_1", 30,0, false, "地址1区段1" )))
					.addNode(new FieldNode("add1_2", new MsgField(ContentEnum.MessageType.STRING.toString(), "add1_2", 30,0, false, "地址1区段2" )))
					.addNode(new FieldNode("add1_3", new MsgField(ContentEnum.MessageType.STRING.toString(), "add1_3", 30,0, false, "地址1区段3" )))
					.addNode(new FieldNode("add1_4", new MsgField(ContentEnum.MessageType.STRING.toString(), "add1_4", 30,0, false, "地址1区段4" )))
					.addNode(new FieldNode("add1_5", new MsgField(ContentEnum.MessageType.STRING.toString(), "add1_5", 30,0, false, "地址1区段5" )))
					.addNode(new FieldNode("postcode1", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcode1", 6,0, false, "地址1邮政编码" )))
					.addNode(new FieldNode("addrjc1", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrjc1", 2,0, false, "地址1省市简称" )))
					.addNode(new FieldNode("addrfg1", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrfg1", 1,0, false, "地址1国内/国外标志" )))
					.addNode(new FieldNode("add1_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "add1_type", 1,0, false, "地址1类型" )))
					.addNode(new FieldNode("add2_1", new MsgField(ContentEnum.MessageType.STRING.toString(), "add2_1", 30,0, false, "地址2区段1" )))
					.addNode(new FieldNode("add2_2", new MsgField(ContentEnum.MessageType.STRING.toString(), "add2_2", 30,0, false, "地址2区段2" )))
					.addNode(new FieldNode("add2_3", new MsgField(ContentEnum.MessageType.STRING.toString(), "add2_3", 30,0, false, "地址2区段3" )))
					.addNode(new FieldNode("add2_4", new MsgField(ContentEnum.MessageType.STRING.toString(), "add2_4", 30,0, false, "地址2区段4" )))
					.addNode(new FieldNode("add2_5", new MsgField(ContentEnum.MessageType.STRING.toString(), "add2_5", 30,0, false, "地址2区段5" )))
					.addNode(new FieldNode("postcode2", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcode2", 6,0, false, "地址2邮政编码" )))
					.addNode(new FieldNode("addrjc2", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrjc2", 2,0, false, "地址2省市简称" )))
					.addNode(new FieldNode("addrfg2", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrfg2", 1,0, false, "地址2国内/国外标志" )))
					.addNode(new FieldNode("add2_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "add2_type", 1,0, false, "地址2类型" )))
					.addNode(new FieldNode("add3_1", new MsgField(ContentEnum.MessageType.STRING.toString(), "add3_1", 30,0, false, "地址3区段1" )))
					.addNode(new FieldNode("add3_2", new MsgField(ContentEnum.MessageType.STRING.toString(), "add3_2", 30,0, false, "地址3区段2" )))
					.addNode(new FieldNode("add3_3", new MsgField(ContentEnum.MessageType.STRING.toString(), "add3_3", 30,0, false, "地址3区段3" )))
					.addNode(new FieldNode("add3_4", new MsgField(ContentEnum.MessageType.STRING.toString(), "add3_4", 30,0, false, "地址3区段4" )))
					.addNode(new FieldNode("add3_5", new MsgField(ContentEnum.MessageType.STRING.toString(), "add3_5", 30,0, false, "地址3区段5" )))
					.addNode(new FieldNode("postcode3", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcode3", 6,0, false, "地址3邮政编码" )))
					.addNode(new FieldNode("addrjc3", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrjc3", 2,0, false, "地址3省市简称" )))
					.addNode(new FieldNode("addrfg3", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrfg3", 1,0, false, "地址3国内/国外标志" )))
					.addNode(new FieldNode("add3_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "add3_type", 1,0, false, "地址3类型" )))
					.addNode(new FieldNode("add4_1", new MsgField(ContentEnum.MessageType.STRING.toString(), "add4_1", 30,0, false, "地址4区段1" )))
					.addNode(new FieldNode("add4_2", new MsgField(ContentEnum.MessageType.STRING.toString(), "add4_2", 30,0, false, "地址4区段2" )))
					.addNode(new FieldNode("add4_3", new MsgField(ContentEnum.MessageType.STRING.toString(), "add4_3", 30,0, false, "地址4区段3" )))
					.addNode(new FieldNode("add4_4", new MsgField(ContentEnum.MessageType.STRING.toString(), "add4_4", 30,0, false, "地址4区段4" )))
					.addNode(new FieldNode("add4_5", new MsgField(ContentEnum.MessageType.STRING.toString(), "add4_5", 30,0, false, "地址4区段5" )))
					.addNode(new FieldNode("postcode4", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcode4", 6,0, false, "地址4邮政编码" )))
					.addNode(new FieldNode("addrjc4", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrjc4", 2,0, false, "地址4省市简称" )))
					.addNode(new FieldNode("addrfg4", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrfg4", 1,0, false, "地址4国内/国外标志" )))
					.addNode(new FieldNode("add4_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "add4_type", 1,0, false, "地址4类型" )))
					.addNode(new FieldNode("add5_1", new MsgField(ContentEnum.MessageType.STRING.toString(), "add5_1", 30,0, false, "地址5区段1" )))
					.addNode(new FieldNode("add5_2", new MsgField(ContentEnum.MessageType.STRING.toString(), "add5_2", 30,0, false, "地址5区段2" )))
					.addNode(new FieldNode("add5_3", new MsgField(ContentEnum.MessageType.STRING.toString(), "add5_3", 30,0, false, "地址5区段3" )))
					.addNode(new FieldNode("add5_4", new MsgField(ContentEnum.MessageType.STRING.toString(), "add5_4", 30,0, false, "地址5区段4" )))
					.addNode(new FieldNode("add5_5", new MsgField(ContentEnum.MessageType.STRING.toString(), "add5_5", 30,0, false, "地址5区段5" )))
					.addNode(new FieldNode("postcode5", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcode5", 6,0, false, "地址5邮政编码" )))
					.addNode(new FieldNode("addrjc5", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrjc5", 2,0, false, "地址5省市简称" )))
					.addNode(new FieldNode("addrfg5", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrfg5", 1,0, false, "地址5国内/国外标志" )))
					.addNode(new FieldNode("add5_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "add5_type", 1,0, false, "地址5类型" )))
					.addNode(new FieldNode("add6_1", new MsgField(ContentEnum.MessageType.STRING.toString(), "add6_1", 30,0, false, "地址6区段1" )))
					.addNode(new FieldNode("add6_2", new MsgField(ContentEnum.MessageType.STRING.toString(), "add6_2", 30,0, false, "地址6区段2" )))
					.addNode(new FieldNode("add6_3", new MsgField(ContentEnum.MessageType.STRING.toString(), "add6_3", 30,0, false, "地址6区段3" )))
					.addNode(new FieldNode("add6_4", new MsgField(ContentEnum.MessageType.STRING.toString(), "add6_4", 30,0, false, "地址6区段4" )))
					.addNode(new FieldNode("add6_5", new MsgField(ContentEnum.MessageType.STRING.toString(), "add6_5", 30,0, false, "地址6区段5" )))
					.addNode(new FieldNode("postcode6", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcode6", 6,0, false, "地址6邮政编码" )))
					.addNode(new FieldNode("addrjc6", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrjc6", 2,0, false, "地址6省市简称" )))
					.addNode(new FieldNode("addrfg6", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrfg6", 1,0, false, "地址6国内/国外标志" )))
					.addNode(new FieldNode("add6_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "add6_type", 1,0, false, "地址6类型" )))
					.addNode(new FieldNode("add7_1", new MsgField(ContentEnum.MessageType.STRING.toString(), "add7_1", 30,0, false, "地址7区段1" )))
					.addNode(new FieldNode("add7_2", new MsgField(ContentEnum.MessageType.STRING.toString(), "add7_2", 30,0, false, "地址7区段2" )))
					.addNode(new FieldNode("add7_3", new MsgField(ContentEnum.MessageType.STRING.toString(), "add7_3", 30,0, false, "地址7区段3" )))
					.addNode(new FieldNode("add7_4", new MsgField(ContentEnum.MessageType.STRING.toString(), "add7_4", 30,0, false, "地址7区段4" )))
					.addNode(new FieldNode("add7_5", new MsgField(ContentEnum.MessageType.STRING.toString(), "add7_5", 30,0, false, "地址7区段5" )))
					.addNode(new FieldNode("postcode7", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcode7", 6,0, false, "地址7邮政编码" )))
					.addNode(new FieldNode("addrjc7", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrjc7", 2,0, false, "地址7省市简称" )))
					.addNode(new FieldNode("addrfg7", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrfg7", 1,0, false, "地址7国内/国外标志" )))
					.addNode(new FieldNode("add7_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "add7_type", 1,0, false, "地址7类型" )))
					.addNode(new FieldNode("source", new MsgField(ContentEnum.MessageType.STRING.toString(), "source", 2,0, false, "交易来源" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODAFA0183_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 22,0, false, "流水号" )))
					.addNode(new FieldNode("cardnbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardnbr", 19,0, false, "卡号" )))
					.addNode(new FieldNode("keytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "keytype", 2,0, false, "证件类型" )))
					.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 18,0, false, "证件号码" )))
					.addNode(new FieldNode("stsmail", new MsgField(ContentEnum.MessageType.STRING.toString(), "stsmail", 1,0, false, "账单地址标志" )))
					.addNode(new FieldNode("homephone", new MsgField(ContentEnum.MessageType.STRING.toString(), "homephone", 17,0, false, "家庭电话" )))
					.addNode(new FieldNode("busiphone", new MsgField(ContentEnum.MessageType.STRING.toString(), "busiphone", 17,0, false, "公司电话" )))
					.addNode(new FieldNode("busiexp", new MsgField(ContentEnum.MessageType.STRING.toString(), "busiexp", 6,0, false, "公司电话分机" )))
					.addNode(new FieldNode("add1_1", new MsgField(ContentEnum.MessageType.STRING.toString(), "add1_1", 30,0, false, "地址1区段1" )))
					.addNode(new FieldNode("add1_2", new MsgField(ContentEnum.MessageType.STRING.toString(), "add1_2", 30,0, false, "地址1区段2" )))
					.addNode(new FieldNode("add1_3", new MsgField(ContentEnum.MessageType.STRING.toString(), "add1_3", 30,0, false, "地址1区段3" )))
					.addNode(new FieldNode("add1_4", new MsgField(ContentEnum.MessageType.STRING.toString(), "add1_4", 30,0, false, "地址1区段4" )))
					.addNode(new FieldNode("add1_5", new MsgField(ContentEnum.MessageType.STRING.toString(), "add1_5", 30,0, false, "地址1区段5" )))
					.addNode(new FieldNode("postcode1", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcode1", 6,0, false, "地址1邮政编码" )))
					.addNode(new FieldNode("addrjc1", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrjc1", 2,0, false, "地址1省市简称" )))
					.addNode(new FieldNode("addrfg1", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrfg1", 1,0, false, "地址1国内/国外标志" )))
					.addNode(new FieldNode("add1_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "add1_type", 1,0, false, "地址1类型" )))
					.addNode(new FieldNode("add2_1", new MsgField(ContentEnum.MessageType.STRING.toString(), "add2_1", 30,0, false, "地址2区段1" )))
					.addNode(new FieldNode("add2_2", new MsgField(ContentEnum.MessageType.STRING.toString(), "add2_2", 30,0, false, "地址2区段2" )))
					.addNode(new FieldNode("add2_3", new MsgField(ContentEnum.MessageType.STRING.toString(), "add2_3", 30,0, false, "地址2区段3" )))
					.addNode(new FieldNode("add2_4", new MsgField(ContentEnum.MessageType.STRING.toString(), "add2_4", 30,0, false, "地址2区段4" )))
					.addNode(new FieldNode("add2_5", new MsgField(ContentEnum.MessageType.STRING.toString(), "add2_5", 30,0, false, "地址2区段5" )))
					.addNode(new FieldNode("postcode2", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcode2", 6,0, false, "地址2邮政编码" )))
					.addNode(new FieldNode("addrjc2", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrjc2", 2,0, false, "地址2省市简称" )))
					.addNode(new FieldNode("addrfg2", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrfg2", 1,0, false, "地址2国内/国外标志" )))
					.addNode(new FieldNode("add2_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "add2_type", 1,0, false, "地址2类型" )))
					.addNode(new FieldNode("add3_1", new MsgField(ContentEnum.MessageType.STRING.toString(), "add3_1", 30,0, false, "地址3区段1" )))
					.addNode(new FieldNode("add3_2", new MsgField(ContentEnum.MessageType.STRING.toString(), "add3_2", 30,0, false, "地址3区段2" )))
					.addNode(new FieldNode("add3_3", new MsgField(ContentEnum.MessageType.STRING.toString(), "add3_3", 30,0, false, "地址3区段3" )))
					.addNode(new FieldNode("add3_4", new MsgField(ContentEnum.MessageType.STRING.toString(), "add3_4", 30,0, false, "地址3区段4" )))
					.addNode(new FieldNode("add3_5", new MsgField(ContentEnum.MessageType.STRING.toString(), "add3_5", 30,0, false, "地址3区段5" )))
					.addNode(new FieldNode("postcode3", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcode3", 6,0, false, "地址3邮政编码" )))
					.addNode(new FieldNode("addrjc3", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrjc3", 2,0, false, "地址3省市简称" )))
					.addNode(new FieldNode("addrfg3", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrfg3", 1,0, false, "地址3国内/国外标志" )))
					.addNode(new FieldNode("add3_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "add3_type", 1,0, false, "地址3类型" )))
					.addNode(new FieldNode("add4_1", new MsgField(ContentEnum.MessageType.STRING.toString(), "add4_1", 30,0, false, "地址4区段1" )))
					.addNode(new FieldNode("add4_2", new MsgField(ContentEnum.MessageType.STRING.toString(), "add4_2", 30,0, false, "地址4区段2" )))
					.addNode(new FieldNode("add4_3", new MsgField(ContentEnum.MessageType.STRING.toString(), "add4_3", 30,0, false, "地址4区段3" )))
					.addNode(new FieldNode("add4_4", new MsgField(ContentEnum.MessageType.STRING.toString(), "add4_4", 30,0, false, "地址4区段4" )))
					.addNode(new FieldNode("add4_5", new MsgField(ContentEnum.MessageType.STRING.toString(), "add4_5", 30,0, false, "地址4区段5" )))
					.addNode(new FieldNode("postcode4", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcode4", 6,0, false, "地址4邮政编码" )))
					.addNode(new FieldNode("addrjc4", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrjc4", 2,0, false, "地址4省市简称" )))
					.addNode(new FieldNode("addrfg4", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrfg4", 1,0, false, "地址4国内/国外标志" )))
					.addNode(new FieldNode("add4_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "add4_type", 1,0, false, "地址4类型" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
