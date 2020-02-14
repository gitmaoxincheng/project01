package cn.com.agree.huanan.ap.al.io.service.svs;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.svs.SvsChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * @author HCP
 * 0003 Svs 验印系统请求报文
 * 批量验印服務
 */
@Component
public class SvsScn0001 extends SvsChannelService {

	private static SvsScn0001_I i = new SvsScn0001_I();
	private static SvsScn0001_O o = new SvsScn0001_O();
	public SvsScn0001() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class SvsScn0001_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"RequestBody")
//					.addNode(new FieldNode("PackID", new MsgField(ContentEnum.MessageType.STRING.toString(), "PackID", 32,0, false, "任务包ID" ))) //发起方为空
					.addNode(new FieldNode("Count", new MsgField(ContentEnum.MessageType.STRING.toString(), "Count", 5,0, true, "验印明细笔数" )))
					.addNode(new FieldNode("TaskPriority", new MsgField(ContentEnum.MessageType.STRING.toString(), "TaskPriority", 1,0, false, "优先级" )))
					.addNode(new FieldNode("TaskInfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "TaskInfo", 128,0, false, "发起方保留信息" )))
					.addNode(new StructNode("Print_list",true,"Task") // 任务
							.addNode(new FieldNode("TaskId", new MsgField(ContentEnum.MessageType.STRING.toString(), "TaskId", 32,0, true, "任务ID" )))
							.addNode(new FieldNode("AccNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccNo", 32,0, true, "印鉴账号" )))
							.addNode(new FieldNode("CheckType", new MsgField(ContentEnum.MessageType.STRING.toString(), "CheckType", 1,0, false, "类型号" )))
							.addNode(new FieldNode("VouCherTypeId", new MsgField(ContentEnum.MessageType.STRING.toString(), "VouCherTypeId", 8,0, true, "凭证类型号" )))
							.addNode(new FieldNode("VouCherNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "VouCherNo", 32,0, false, "凭证编号" )))
							.addNode(new FieldNode("VouCherDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "VouCherDate", 10,0, true, "出票日期" )))
							.addNode(new FieldNode("Credit", new MsgField(ContentEnum.MessageType.STRING.toString(), "Credit", 12,0, true, "金额" )))
							.addNode(new FieldNode("DocId", new MsgField(ContentEnum.MessageType.STRING.toString(), "DocId", 32,0, false, "待验印业务流水号" )))
							.addNode(new FieldNode("UsageId", new MsgField(ContentEnum.MessageType.STRING.toString(), "UsageId", 8,0, true, "用途号" )))
							.addNode(new FieldNode("Payee", new MsgField(ContentEnum.MessageType.STRING.toString(), "Payee", 32,0, false, "收款人账号" )))
							.addNode(new FieldNode("TradeTypeId", new MsgField(ContentEnum.MessageType.STRING.toString(), "TradeTypeId", 8,0, true, "交易类型号" )))
							.addNode(new FieldNode("PointNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "PointNo", 20,0, true, "机构号" )))
							.addNode(new FieldNode("SealRuleId", new MsgField(ContentEnum.MessageType.STRING.toString(), "SealRuleId", 8,0, true, "验印规则号" )))
							.addNode(new FieldNode("ImageId", new MsgField(ContentEnum.MessageType.STRING.toString(), "ImageId", 100,0, false, "影像ID" )))
							.addNode(new FieldNode("ImageURL", new MsgField(ContentEnum.MessageType.STRING.toString(), "ImageURL", 2024,0, true, "影像路径" )))
							.addNode(new FieldNode("TaskDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "TaskDate", 10,0, true, "工作日期" )))
							.addNode(new FieldNode("BranchNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BranchNo", 16,0, false, "交换行号" )))
							.addNode(new FieldNode("UserNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "UserNo", 16,0, true, "操作柜员" )))
							.addNode(new FieldNode("SealCnt", new MsgField(ContentEnum.MessageType.INT.toString(), "SealCnt", 5,0, false, "验印普通印鉴枚数" )))
							.addNode(new FieldNode("PubSealCnt", new MsgField(ContentEnum.MessageType.INT.toString(), "PubSealCnt", 5,0, false, "验印公章枚数" )))
							.addNode(new FieldNode("ExtendInfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ExtendInfo", 512,0, false, "扩展信息" )))
							)
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class SvsScn0001_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("ResponseBody",true,"APPBody")
					.addNode(new FieldNode("PackID", new MsgField(ContentEnum.MessageType.STRING.toString(), "PackID", 32,0, false, "任务包ID" )))
					.addNode(new FieldNode("Count", new MsgField(ContentEnum.MessageType.INT.toString(), "Count", 5,0, false, "验印明细笔数" )))
					.addNode(new FieldNode("FaultCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "FaultCode", 5,0, false, "错误码" )))
					.addNode(new FieldNode("FaultString", new MsgField(ContentEnum.MessageType.STRING.toString(), "FaultString", 2097152,0, false, "错误信息" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

