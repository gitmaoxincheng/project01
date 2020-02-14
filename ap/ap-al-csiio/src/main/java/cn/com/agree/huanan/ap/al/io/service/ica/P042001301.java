package cn.com.agree.huanan.ap.al.io.service.ica;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P042001301 IC卡电子账户管理.电子现金有卡销户 
 * P0420013.01 iccrdc
 * 0050 IC卡系统2.0
 * @author CZP
 */
@Component
public class P042001301 extends EsbChannelService {

	private static P042001301_I i = new P042001301_I();
	private static P042001301_O o = new P042001301_O();

	public P042001301() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P042001301_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 40,0, true, "卡号" )))
					.addNode(new FieldNode("tranpw", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranpw", 512,0, true, "密码" )))
					.addNode(new FieldNode("crcycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "crcycd", 3,0, true, "币种" )))
					.addNode(new FieldNode("onlnbl", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "onlnbl", 18,2, true, "电子现金芯片实际余额" )))
					.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "tranam", 18,2, false, "交易金额" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 2,0, true, "证件类型" )))
					.addNode(new FieldNode("icvern", new MsgField(ContentEnum.MessageType.STRING.toString(), "icvern", 4,0, false, "应用版本号" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, true, "证件号码" )))
					.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 256,0, true, "户名" )))
					.addNode(new FieldNode("kaxulieh", new MsgField(ContentEnum.MessageType.STRING.toString(), "kaxulieh", 2,0, false, "卡序列号" )))
					.addNode(new FieldNode("f55yxinx", new MsgField(ContentEnum.MessageType.STRING.toString(), "f55yxinx", 512,0, false, "55域" )))
					.addNode(new FieldNode("agtcnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "agtcnm", 100,0, false, "代理人姓名" )))
					.addNode(new FieldNode("agtidt", new MsgField(ContentEnum.MessageType.STRING.toString(), "agtidt", 10,0, false, "代理人证件类型" )))
					.addNode(new FieldNode("agtidn", new MsgField(ContentEnum.MessageType.STRING.toString(), "agtidn", 80,0, false, "代理人证件号码" )))
					.addNode(new FieldNode("key_source", new MsgField(ContentEnum.MessageType.STRING.toString(), "key_source", 20,0, false, "密钥来源" )))
					.addNode(new FieldNode("device_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "device_num", 20,0, false, "终端设备号" )))
					.addNode(new FieldNode("ecrpt_seed", new MsgField(ContentEnum.MessageType.STRING.toString(), "ecrpt_seed", 30,0, false, "加密因子" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class P042001301_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 40,0, true, "卡号" )))
					.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "tranam", 18,2, false, "交易金额" )))
					.addNode(new FieldNode("f55yxinx", new MsgField(ContentEnum.MessageType.STRING.toString(), "f55yxinx", 512,0, true, "55域" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
