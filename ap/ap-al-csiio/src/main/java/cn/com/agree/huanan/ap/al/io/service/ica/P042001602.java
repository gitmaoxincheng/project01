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
 * BASESVC.P042001602 IC卡综合管理.非柜面渠道脚本通知 
 * P0420016.02 icasar
 * 0050 企业信息联网核查模块
 * @author XXX
 */
@Component
public class P042001602 extends EsbChannelService {

	private static P042001602_I i = new P042001602_I();
	private static P042001602_O o = new P042001602_O();
	public P042001602() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P042001602_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("fd0000", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0000", 4,0, false, "消息类型" )))
					.addNode(new FieldNode("fd0002", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0002", 19,0, true, "交易卡号" )))
					.addNode(new FieldNode("fd0003", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0003", 6,0, false, "处理码" )))
					.addNode(new FieldNode("fd0004", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0004", 12,0, false, "交易金额" )))
					.addNode(new FieldNode("fd0007", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0007", 10,0, false, "交易传输时间" )))
					.addNode(new FieldNode("fd0011", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0011", 6,0, false, "系统跟踪号" )))
					.addNode(new FieldNode("fd0012", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0012", 6,0, false, "受卡方所在地时间" )))
					.addNode(new FieldNode("fd0013", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0013", 4,0, false, "受卡方所在地日期" )))
					.addNode(new FieldNode("fd0015", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0015", 8,0, false, "清算日期" )))
					.addNode(new FieldNode("fd0018", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0018", 4,0, false, "商户类型" )))
					.addNode(new FieldNode("fd0023", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0023", 3,0, true, "卡序列号" )))
					.addNode(new FieldNode("fd0025", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0025", 2,0, false, "服务点条件码" )))
					.addNode(new FieldNode("fd0032", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0032", 11,0, false, "受理机构" )))
					.addNode(new FieldNode("fd0033", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0033", 11,0, false, "发送机构" )))
					.addNode(new FieldNode("fd0037", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0037", 12,0, false, "检索参考号" )))
					.addNode(new FieldNode("fd0041", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0041", 8,0, false, "终端号" )))
					.addNode(new FieldNode("fd0042", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0042", 42,0, false, "商户ID" )))
					.addNode(new FieldNode("fd0043", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0043", 43,0, false, "商户名称" )))
					.addNode(new FieldNode("fd0049", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0049", 3,0, false, "交易货币" )))
					.addNode(new FieldNode("fd0055", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0055", 510,0, false, "IC卡数据域" )))
					.addNode(new FieldNode("fd0060", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0060", 100,0, false, "自定义域" )))
					.addNode(new FieldNode("fd0090", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0090", 42,0, false, "原始数据元" )))
					.addNode(new FieldNode("fd0100", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0100", 11,0, false, "接收机构标识码" )))
					.addNode(new FieldNode("f55yxinx", new MsgField(ContentEnum.MessageType.STRING.toString(), "f55yxinx", 512,0, true, "55域" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P042001602_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",false)
					.addNode(new FieldNode("fd0039", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0039", 2,0, false, "响应码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

