package cn.com.agree.huanan.ap.al.io.service.fmb;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.C013000114 客户信息管理.个人开卡申请信息查询 
 * C0130001.14 8819711
 * 0339 综合前置(微网点模块)
 * @author XZF
 */
@Component
public class C013000114 extends EsbChannelService {

	private static C013000114_I i = new C013000114_I();
	private static C013000114_O o = new C013000114_O();
	public C013000114() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013000114_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 2,0, true, "证件类型" )))
					.addNode(new FieldNode("RequNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "RequNo", 50,0, false, "申请编号" )))
					.addNode(new FieldNode("OldSerialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "OldSerialno", 50,0, false, "原始流水号" )))
					.addNode(new FieldNode("TimeOutFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "TimeOutFlag", 2,0, false, "是否超时查询" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, true, "证件号码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C013000114_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("ApplyInfo",false)
							.addNode(new FieldNode("PhotoP", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhotoP", 50,0, true, "拍摄人像面" )))
							.addNode(new FieldNode("PhotoG", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhotoG", 50,0, true, "拍摄国徽面" )))
							.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 2,0, true, "证件类型" )))
							.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, true, "证件号码" )))
							.addNode(new FieldNode("IsNewc", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsNewc", 1,0, false, "新开账户" )))
							.addNode(new FieldNode("IsYxQy", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsYxQy", 1,0, false, "银信通签约" )))
							.addNode(new FieldNode("KeySli", new MsgField(ContentEnum.MessageType.STRING.toString(), "KeySli", 1,0, false, "KEY申领" )))
							.addNode(new FieldNode("RryYyy", new MsgField(ContentEnum.MessageType.STRING.toString(), "RryYyy", 1,0, false, "日日盈月月盈签约" )))
							.addNode(new FieldNode("JjCard", new MsgField(ContentEnum.MessageType.STRING.toString(), "JjCard", 1,0, false, "借记卡自助服务签约" )))
							.addNode(new FieldNode("OffPho", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffPho", 20,0, true, "办公电话" )))
							.addNode(new FieldNode("OthPho", new MsgField(ContentEnum.MessageType.STRING.toString(), "OthPho", 50,0, true, "家庭电话" )))
							.addNode(new FieldNode("PostNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "PostNo", 50,0, true, "邮政编码" )))
							.addNode(new FieldNode("NowAdd", new MsgField(ContentEnum.MessageType.STRING.toString(), "NowAdd", 256,0, true, "现居住地址" )))
							.addNode(new FieldNode("ProFee", new MsgField(ContentEnum.MessageType.STRING.toString(), "ProFee", 2,0, true, "职业" )))
							.addNode(new FieldNode("OthPro", new MsgField(ContentEnum.MessageType.STRING.toString(), "OthPro", 50,0, false, "其他职业描述" )))
							.addNode(new FieldNode("WorkUn", new MsgField(ContentEnum.MessageType.STRING.toString(), "WorkUn", 100,0, false, "工作单位" )))
							.addNode(new FieldNode("WorkAd", new MsgField(ContentEnum.MessageType.STRING.toString(), "WorkAd", 256,0, false, "工作单位地址" )))
							.addNode(new FieldNode("TaxSta", new MsgField(ContentEnum.MessageType.STRING.toString(), "TaxSta", 2,0, true, "税收居民身份" )))
							.addNode(new FieldNode("ZibKey", new MsgField(ContentEnum.MessageType.STRING.toString(), "ZibKey", 1,0, false, "是否自备KEY" )))
							.addNode(new FieldNode("KkeyTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "KkeyTp", 1,0, false, "KEY类型" )))
							.addNode(new FieldNode("KeyChan", new MsgField(ContentEnum.MessageType.STRING.toString(), "KeyChan", 1,0, false, "KEY渠道" )))
							.addNode(new FieldNode("BusiTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "BusiTp", 1,0, false, "业务种类" )))
							.addNode(new FieldNode("Savedt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Savedt", 2,0, false, "存期" )))
							.addNode(new FieldNode("SaveAm", new MsgField(ContentEnum.MessageType.STRING.toString(), "SaveAm", 25,0, false, "保留余额" )))
							.addNode(new FieldNode("IsTRAm", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsTRAm", 1,0, false, "是否设定转账金额" )))
							.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranam", 20,0, false, "转账金额" )))
							.addNode(new FieldNode("trandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt", 8,0, false, "转账日期" )))
							.addNode(new FieldNode("Tranhn", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tranhn", 1,0, true, "行内转账" )))
							.addNode(new FieldNode("DSumhn", new MsgField(ContentEnum.MessageType.STRING.toString(), "DSumhn", 20,0, false, "日累计限额" )))
							.addNode(new FieldNode("Trankh", new MsgField(ContentEnum.MessageType.STRING.toString(), "Trankh", 1,0, true, "跨行转账" )))
							.addNode(new FieldNode("DSumkh", new MsgField(ContentEnum.MessageType.STRING.toString(), "DSumkh", 20,0, false, "日累计限额(跨行)" )))
							.addNode(new FieldNode("ChDSum", new MsgField(ContentEnum.MessageType.STRING.toString(), "ChDSum", 20,0, false, "境内消费日累计限额" )))
							.addNode(new FieldNode("OvDSum", new MsgField(ContentEnum.MessageType.STRING.toString(), "OvDSum", 20,0, false, "境外消费日累计限额" )))
							.addNode(new FieldNode("OvCash", new MsgField(ContentEnum.MessageType.STRING.toString(), "OvCash", 1,0, false, "境外取现" )))
							.addNode(new FieldNode("EfctDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "EfctDt", 8,0, false, "证件生效期" )))
							.addNode(new FieldNode("IdInst", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdInst", 20,0, true, "发证机关" )))
							.addNode(new FieldNode("InefDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "InefDt", 8,0, false, "证件失效期" )))
							.addNode(new FieldNode("RequNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "RequNo", 50,0, false, "申请编号" )))
							.addNode(new FieldNode("IsPubl", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsPubl", 1,0, true, "是否对公业务" )))
							.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl", 20,0, true, "手机号码" )))
							.addNode(new FieldNode("PeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PeName", 20,0, true, "姓名" )))
							).addNode(new FieldNode("TtlNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TtlNum", 10,0, false, "明细总笔数" )))
					.addNode(new FieldNode("ListNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "ListNum", 10,0, false, "返回记录数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

