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
 * BASESVC.P012000107 对私账户开户.电子现金开户 
 * P0120001.07 iccrda
 * 0050 IC卡系统2.0
 * @author XZF
 */
@Component
public class P012000107 extends EsbChannelService {

	private static P012000107_I i = new P012000107_I();
	private static P012000107_O o = new P012000107_O();
	public P012000107() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P012000107_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 40,0, true, "卡号" )))
					.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 256,0, true, "户名" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 2,0, true, "证件类型" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, true, "证件号码" )))
					.addNode(new FieldNode("ballmt", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "ballmt", 10,2, true, "电子现金余额上限" )))
					.addNode(new FieldNode("txnlmt", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "txnlmt", 10,2, true, "电子现金单笔限额" )))
					.addNode(new FieldNode("agtcnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "agtcnm", 100,0, false, "代理人姓名" )))
					.addNode(new FieldNode("agtidt", new MsgField(ContentEnum.MessageType.STRING.toString(), "agtidt", 10,0, false, "代理人证件类型" )))
					.addNode(new FieldNode("agtidn", new MsgField(ContentEnum.MessageType.STRING.toString(), "agtidn", 80,0, false, "代理人证件号码" )))
					.addNode(new FieldNode("inpttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "inpttp", 2,0, false, "输入类型" )))
					.addNode(new FieldNode("oldcrd", new MsgField(ContentEnum.MessageType.STRING.toString(), "oldcrd", 40,0, false, "老卡卡号" )))
					.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark", 200,0, false, "备注信息" )))
					.addNode(new FieldNode("icvern", new MsgField(ContentEnum.MessageType.STRING.toString(), "icvern", 4,0, true, "应用版本号" )))
					.addNode(new FieldNode("exdata", new MsgField(ContentEnum.MessageType.STRING.toString(), "exdata", 8,0, true, "有效期" )))
					.addNode(new FieldNode("kaxulieh", new MsgField(ContentEnum.MessageType.STRING.toString(), "kaxulieh", 2,0, true, "卡序列号" )))
					.addNode(new FieldNode("f55yxinx", new MsgField(ContentEnum.MessageType.STRING.toString(), "f55yxinx", 512,0, true, "55域" )))
					.addNode(new FieldNode("key_source", new MsgField(ContentEnum.MessageType.STRING.toString(), "key_source", 20,0, true, "密钥来源" )))
					.addNode(new FieldNode("device_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "device_num", 20,0, true, "终端设备号" )))
					.addNode(new FieldNode("ecrpt_seed", new MsgField(ContentEnum.MessageType.STRING.toString(), "ecrpt_seed", 30,0, true, "加密因子" )))
					.addNode(new FieldNode("tranpw", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranpw", 512,0, true, "密码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P012000107_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

