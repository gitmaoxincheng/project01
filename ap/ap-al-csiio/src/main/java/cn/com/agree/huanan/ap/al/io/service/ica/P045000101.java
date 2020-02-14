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
 * BASESVC.P045000101 IC卡冲正管理.银联/ATM指定账户圈存冲正 
 * P0450001.01 cpsust
 * 0050 IC卡系统2.0
 * @author XZF
 */
@Component
public class P045000101 extends EsbChannelService {

	private static P045000101_I i = new P045000101_I();
	private static P045000101_O o = new P045000101_O();
	public P045000101() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P045000101_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("fd0000", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0000", 4,0, false, "消息类型" )))
					.addNode(new FieldNode("fd0002", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0002", 19,0, false, "交易卡号" )))
					.addNode(new FieldNode("fd0003", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0003", 6,0, false, "处理码" )))
					.addNode(new FieldNode("fd0004", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0004", 12,0, false, "交易金额" )))
					.addNode(new FieldNode("fd0005", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0005", 12,0, false, "清算金额" )))
					.addNode(new FieldNode("fd0006", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0006", 12,0, false, "持卡人扣款金额" )))
					.addNode(new FieldNode("fd0007", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0007", 10,0, false, "交易传输时间" )))
					.addNode(new FieldNode("fd0009", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0009", 8,0, false, "清算汇率" )))
					.addNode(new FieldNode("fd0010", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0010", 8,0, false, "持卡人扣款汇率" )))
					.addNode(new FieldNode("fd0011", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0011", 6,0, false, "系统跟踪号" )))
					.addNode(new FieldNode("fd0012", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0012", 6,0, false, "受卡方所在地时间" )))
					.addNode(new FieldNode("fd0013", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0013", 4,0, false, "受卡方所在地日期" )))
					.addNode(new FieldNode("fd0015", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0015", 8,0, false, "清算日期" )))
					.addNode(new FieldNode("fd0016", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0016", 4,0, false, "兑换日期" )))
					.addNode(new FieldNode("fd0018", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0018", 4,0, false, "商户类型" )))
					.addNode(new FieldNode("fd0019", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0019", 3,0, false, "商户国家代码" )))
					.addNode(new FieldNode("fd0022", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0022", 3,0, false, "服务点输入方式码" )))
					.addNode(new FieldNode("fd0023", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0023", 3,0, false, "卡序列号" )))
					.addNode(new FieldNode("fd0025", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0025", 2,0, false, "服务点条件码" )))
					.addNode(new FieldNode("fd0032", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0032", 11,0, false, "受理机构" )))
					.addNode(new FieldNode("fd0033", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0033", 11,0, false, "发送机构" )))
					.addNode(new FieldNode("fd0037", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0037", 12,0, false, "检索参考号" )))
					.addNode(new FieldNode("fd0038", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0038", 6,0, false, "授权码" )))
					.addNode(new FieldNode("fd0041", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0041", 8,0, false, "终端号" )))
					.addNode(new FieldNode("fd0042", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0042", 42,0, false, "商户ID" )))
					.addNode(new FieldNode("fd0043", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0043", 43,0, false, "商户名称" )))
					.addNode(new FieldNode("fd0044", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0044", 25,0, false, "附加响应数据" )))
					.addNode(new FieldNode("fd0048", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0048", 512,0, false, "附加数据私有" )))
					.addNode(new FieldNode("fd0049", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0049", 3,0, false, "交易货币" )))
					.addNode(new FieldNode("fd0050", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0050", 3,0, false, "清算货币" )))
					.addNode(new FieldNode("fd0051", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0051", 3,0, false, "持卡人账户货币" )))
					.addNode(new FieldNode("fd0055", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0055", 510,0, false, "IC卡数据域" )))
					.addNode(new FieldNode("fd0060", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0060", 100,0, false, "自定义域" )))
					.addNode(new FieldNode("fd0090", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0090", 42,0, false, "原始数据元" )))
					.addNode(new FieldNode("fd0100", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0100", 11,0, false, "接收机构标识码" )))
					.addNode(new FieldNode("fd0121", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0121", 100,0, false, "CUPS保留" )))
					.addNode(new FieldNode("fd0122", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0122", 100,0, false, "受理方保留" )))
					.addNode(new FieldNode("fd0123", new MsgField(ContentEnum.MessageType.STRING.toString(), "fd0123", 100,0, false, "发卡方保留" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P045000101_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
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

