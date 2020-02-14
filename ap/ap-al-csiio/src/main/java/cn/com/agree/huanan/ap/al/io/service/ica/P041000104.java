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
 * BASESVC.P041000104 IC卡圈提管理.圈存圈提调账 
 * P0410001.04 iccrdj
 * 0050 企业信息联网核查模块
 * @author XXX
 */
@Component
public class P041000104 extends EsbChannelService {

	private static P041000104_I i = new P041000104_I();
	private static P041000104_O o = new P041000104_O();
	public P041000104() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P041000104_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("adjstp", new MsgField(ContentEnum.MessageType.STRING.toString(), "adjstp", 2,0, true, "调账方式" )))
					.addNode(new FieldNode("oldtdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "oldtdt", 8,0, true, "原交易日期" )))
					.addNode(new FieldNode("oldtsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "oldtsq", 25,0, true, "原交易流水" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 40,0, true, "卡号" )))
					.addNode(new FieldNode("amntcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "amntcd", 2,0, false, "调账方向" )))
					.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.INT.toString(), "tranam", 18,2, true, "交易金额" )))
					.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark", 200,0, false, "备注信息" )))
					.addNode(new FieldNode("adsysm", new MsgField(ContentEnum.MessageType.STRING.toString(), "adsysm", 2,0, false, "调整系统" )))
					.addNode(new FieldNode("kaxulieh", new MsgField(ContentEnum.MessageType.STRING.toString(), "kaxulieh", 2,0, false, "卡序列号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P041000104_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("oldtdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "oldtdt", 8,0, false, "原交易日期" )))
					.addNode(new FieldNode("oldtsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "oldtsq", 25,0, false, "原交易流水" )))
					.addNode(new FieldNode("typeid", new MsgField(ContentEnum.MessageType.STRING.toString(), "typeid", 10,0, false, "类型ID" )))
					.addNode(new FieldNode("typenm", new MsgField(ContentEnum.MessageType.STRING.toString(), "typenm", 40,0, false, "类型名称" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 40,0, true, "卡号" )))
					.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 256,0, true, "户名" )))
					.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.INT.toString(), "tranam", 18,2, false, "交易金额" )))
					.addNode(new FieldNode("amntcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "amntcd", 2,0, false, "调账方向" )))
					.addNode(new FieldNode("coredt", new MsgField(ContentEnum.MessageType.STRING.toString(), "coredt", 14,0, false, "核心日期" )))
					.addNode(new FieldNode("coresq", new MsgField(ContentEnum.MessageType.STRING.toString(), "coresq", 40,0, false, "核心流水" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

