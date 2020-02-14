package cn.com.agree.huanan.ap.al.io.service.bep;

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
 * BASESVC.P082000105 支票影像处理.支票影像票据提出登记 
 * P0820001.05 620421
 * 0062 小额支付系统二代
 * @author LSJ
 */
@Component
public class P082000105 extends EsbChannelService {

	private static P082000105_I i = new P082000105_I();
	private static P082000105_O o = new P082000105_O();
	public P082000105() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class P082000105_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
				.addNode(new FieldNode("prcscd", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcscd", 6,0, true, "处理码" )))
				.addNode(new FieldNode("agenttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "agenttype", 10,0, true, "业务类型" )))
				.addNode(new FieldNode("currtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "currtype", 3,0, true, "币种" )))
				.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "amount", 17,0, true, "交易金额" )))
				.addNode(new FieldNode("agentcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentcode", 12,0, false, "业务编号" )))
				.addNode(new FieldNode("payeebank", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeebank", 12,0, false, "收款行行号" )))
				.addNode(new FieldNode("payerbank", new MsgField(ContentEnum.MessageType.STRING.toString(), "payerbank", 12,0, true, "付款行行号" )))
				.addNode(new FieldNode("payeraccbank", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeraccbank", 12,0, false, "付款人开户行行号" )))
				.addNode(new FieldNode("payeracc", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeracc", 32,0, false, "付款人账号103 和305业务可以为空" )))
				.addNode(new FieldNode("payername", new MsgField(ContentEnum.MessageType.STRING.toString(), "payername", 140,0, false, "付款人名称允许中文" )))
				.addNode(new FieldNode("payeraddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeraddr", 140,0, false, "付款人地址允许中文" )))
				.addNode(new FieldNode("payeeaccbank", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeeaccbank", 12,0, false, "收款人开户行行号" )))
				.addNode(new FieldNode("payeeacc", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeeacc", 32,0, false, "收款人账号104业务可以为空" )))
				.addNode(new FieldNode("payeename", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeename", 140,0, false, "收款人名称允许中文" )))
				.addNode(new FieldNode("payeeaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeeaddr", 140,0, false, "收款人地址允许中文" )))
				.addNode(new FieldNode("reqpostscript", new MsgField(ContentEnum.MessageType.STRING.toString(), "reqpostscript", 512,0, false, "备注/附言允许中文" )))
				.addNode(new FieldNode("payervouchtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "payervouchtype", 8,0, false, "票据种类参见概述分册" )))
				.addNode(new FieldNode("payervouchno", new MsgField(ContentEnum.MessageType.STRING.toString(), "payervouchno", 32,0, false, "票据号码" )))
				.addNode(new FieldNode("payervouchdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "payervouchdate", 10,0, false, "出票日期" )))
				.addNode(new FieldNode("PayDT", new MsgField(ContentEnum.MessageType.STRING.toString(), "PayDT", 10,0, false, "提示付款日期" )))
				.addNode(new FieldNode("Purp", new MsgField(ContentEnum.MessageType.STRING.toString(), "Purp", 60,0, false, "用途" )))
				.addNode(new FieldNode("PmtPswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "PmtPswd", 512,0, false, "支付密码" )))
				.addNode(new FieldNode("NbOfEndrsr", new MsgField(ContentEnum.MessageType.STRING.toString(), "NbOfEndrsr", 2,0, false, "背背书人数" )))
				.addNode(new FieldNode("Nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "Nm", 1200,0, false, "背背书人清单背背书人名称允许中文" )))
				.addNode(new FieldNode("ImgTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ImgTp", 10,0, false, "票据图像类型填写票据正背面图像的类型（图片文件后缀名），比如jpg、bmp等，类型根据实际情况填写" )))
				.addNode(new FieldNode("ImgFrntLen", new MsgField(ContentEnum.MessageType.STRING.toString(), "ImgFrntLen", 8,0, false, "票据正面图像长度原图片经过BASE64转码后的数据长度" )))
				.addNode(new FieldNode("FrntFileName", new MsgField(ContentEnum.MessageType.STRING.toString(), "FrntFileName", 120,0, false, "票据正面图像文件名" )))
				.addNode(new FieldNode("ImgBckLen", new MsgField(ContentEnum.MessageType.STRING.toString(), "ImgBckLen", 8,0, false, "票背面据图像长度" )))
				.addNode(new FieldNode("BckFileName", new MsgField(ContentEnum.MessageType.STRING.toString(), "BckFileName", 120,0, false, "票据背面图像文件名" )))
				.addNode(new FieldNode("BUSI_START_DATE", new MsgField(ContentEnum.MessageType.STRING.toString(), "BUSI_START_DATE", 20,0, true, "业务开始时间" )))
				.addNode(new FieldNode("BUSI_SERIAL_NO", new MsgField(ContentEnum.MessageType.STRING.toString(), "BUSI_SERIAL_NO", 48,0, true, "业务流水号" )))
				.addNode(new FieldNode("CONTENT_ID", new MsgField(ContentEnum.MessageType.STRING.toString(), "CONTENT_ID", 64,0, true, "内容编号CONTENTID" )))
				.addNode(new FieldNode("front_FILE_ID", new MsgField(ContentEnum.MessageType.STRING.toString(), "front_FILE_ID", 64,0, true, "正面文件ID" )))
				.addNode(new FieldNode("back_FILE_ID", new MsgField(ContentEnum.MessageType.STRING.toString(), "back_FILE_ID", 64,0, true, "背面文件ID" )))
				.addNode(new FieldNode("taskno", new MsgField(ContentEnum.MessageType.STRING.toString(), "taskno", 30,0, false, "任务号" )))
				.addNode(new FieldNode("taskstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "taskstatus", 10,0, false, "任务状态" )))
				);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P082000105_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
				.addNode(new FieldNode("entrustdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "entrustdate", 10,0, false, "委托日期" )))
				.addNode(new FieldNode("entrustmsgid", new MsgField(ContentEnum.MessageType.STRING.toString(), "entrustmsgid", 40,0, false, "支付交易号" )))
				.addNode(new FieldNode("sendstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "sendstatus", 20,0, false, "发送状态" )))
				);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

