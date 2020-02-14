package cn.com.agree.huanan.ap.al.io.service.csi;

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
 * BASESVC.P042000202 借记卡管理.修改个人开卡 
 * P0420002.02 MNTW0006
 * 0310 线下渠道整合平台
 * @author XZF
 */
@Component
public class P042000202 extends EsbChannelService {

	private static P042000202_I i = new P042000202_I();
	private static P042000202_O o = new P042000202_O();
	public P042000202() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P042000202_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("photop", new MsgField(ContentEnum.MessageType.STRING.toString(), "photop", 256,0, true, "拍摄人像面" )))
					.addNode(new FieldNode("photog", new MsgField(ContentEnum.MessageType.STRING.toString(), "photog", 256,0, true, "拍摄国徽面" )))
					.addNode(new FieldNode("photor", new MsgField(ContentEnum.MessageType.STRING.toString(), "photor", 256,0, true, "微网点申请单影像" )))
					.addNode(new FieldNode("contentno", new MsgField(ContentEnum.MessageType.STRING.toString(), "contentno", 100,0, false, "影像批次号" )))
					.addNode(new FieldNode("modelno", new MsgField(ContentEnum.MessageType.STRING.toString(), "modelno", 100,0, false, "影像模型号" )))
					.addNode(new FieldNode("cutycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cutycd", 3,0, true, "国籍" )))
					.addNode(new FieldNode("isnewc", new MsgField(ContentEnum.MessageType.STRING.toString(), "isnewc", 1,0, false, "新开账户" )))
					.addNode(new FieldNode("custno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 32,0, false, "客户号" )))
					.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 256,0, true, "姓名" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 3,0, true, "证件类型" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, true, "证件号码" )))
					.addNode(new FieldNode("gender", new MsgField(ContentEnum.MessageType.STRING.toString(), "gender", 1,0, true, "性别" )))
					.addNode(new FieldNode("office_phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "office_phone", 20,0, false, "办公电话" )))
					.addNode(new FieldNode("family_phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "family_phone", 20,0, false, "家庭电话" )))
					.addNode(new FieldNode("pres_address", new MsgField(ContentEnum.MessageType.STRING.toString(), "pres_address", 100,0, true, "现居住地址" )))
					.addNode(new FieldNode("postcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "postcode", 6,0, true, "邮政编码" )))
					.addNode(new FieldNode("wkduty", new MsgField(ContentEnum.MessageType.STRING.toString(), "wkduty", 2,0, true, "职业" )))
					.addNode(new FieldNode("othpro", new MsgField(ContentEnum.MessageType.STRING.toString(), "othpro", 120,0, true, "其他职业描述" )))
					.addNode(new FieldNode("unitna", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitna", 100,0, false, "工作单位" )))
					.addNode(new FieldNode("unitaddrss", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitaddrss", 200,0, false, "工作单位地址" )))
					.addNode(new FieldNode("revenue", new MsgField(ContentEnum.MessageType.STRING.toString(), "revenue", 1,0, true, "税收居民身份" )))
					.addNode(new FieldNode("phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone", 30,0, true, "手机号" )))
					.addNode(new FieldNode("yxtsigned", new MsgField(ContentEnum.MessageType.STRING.toString(), "yxtsigned", 1,0, false, "银信通签约" )))
					.addNode(new FieldNode("yxtphone1", new MsgField(ContentEnum.MessageType.STRING.toString(), "yxtphone1", 30,0, false, "银信通手机号码" )))
					.addNode(new FieldNode("keyapply", new MsgField(ContentEnum.MessageType.STRING.toString(), "keyapply", 1,0, false, "KEY申领" )))
					.addNode(new FieldNode("owned_key", new MsgField(ContentEnum.MessageType.STRING.toString(), "owned_key", 1,0, false, "是否自备KEY" )))
					.addNode(new FieldNode("keytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "keytype", 1,0, false, "KEY类型" )))
					.addNode(new FieldNode("keychannel", new MsgField(ContentEnum.MessageType.STRING.toString(), "keychannel", 3,0, false, "KEY渠道" )))
					.addNode(new FieldNode("rry", new MsgField(ContentEnum.MessageType.STRING.toString(), "rry", 1,0, false, "日日盈月月盈签约" )))
					.addNode(new FieldNode("busitype", new MsgField(ContentEnum.MessageType.STRING.toString(), "busitype", 2,0, false, "业务种类" )))
					.addNode(new FieldNode("depositterm", new MsgField(ContentEnum.MessageType.STRING.toString(), "depositterm", 3,0, false, "存期" )))
					.addNode(new FieldNode("rese_amount", new MsgField(ContentEnum.MessageType.INT.toString(), "rese_amount", 22,2, false, "保留金额" )))
					.addNode(new FieldNode("settransfer", new MsgField(ContentEnum.MessageType.STRING.toString(), "settransfer", 1,0, false, "是否设定转账金额" )))
					.addNode(new FieldNode("tran_amount", new MsgField(ContentEnum.MessageType.INT.toString(), "tran_amount", 22,2, false, "转账金额" )))
					.addNode(new FieldNode("transfer_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "transfer_date", 8,0, false, "转账日期" )))
					.addNode(new FieldNode("debit_self", new MsgField(ContentEnum.MessageType.STRING.toString(), "debit_self", 1,0, false, "借记卡自助服务" )))
					.addNode(new FieldNode("hn_transfer", new MsgField(ContentEnum.MessageType.STRING.toString(), "hn_transfer", 1,0, false, "行内转账" )))
					.addNode(new FieldNode("hn_tran_quota", new MsgField(ContentEnum.MessageType.INT.toString(), "hn_tran_quota", 22,2, false, "行内转账日累计限额" )))
					.addNode(new FieldNode("kh_transfer", new MsgField(ContentEnum.MessageType.STRING.toString(), "kh_transfer", 1,0, false, "跨行转账" )))
					.addNode(new FieldNode("kh_tran_quota", new MsgField(ContentEnum.MessageType.INT.toString(), "kh_tran_quota", 22,2, false, "跨行转账日累计限额" )))
					.addNode(new FieldNode("territory_quota", new MsgField(ContentEnum.MessageType.INT.toString(), "territory_quota", 22,2, false, "境内消费日累计限额" )))
					.addNode(new FieldNode("overseas_quota", new MsgField(ContentEnum.MessageType.INT.toString(), "overseas_quota", 22,2, false, "境外消费日累计限额" )))
					.addNode(new FieldNode("overseas_ench", new MsgField(ContentEnum.MessageType.STRING.toString(), "overseas_ench", 1,0, false, "境外取现" )))
					.addNode(new FieldNode("isinb", new MsgField(ContentEnum.MessageType.STRING.toString(), "isinb", 1,0, false, "个人网银" )))
					.addNode(new FieldNode("wpphone", new MsgField(ContentEnum.MessageType.STRING.toString(), "wpphone", 1,0, false, "手机银行" )))
					.addNode(new FieldNode("idinst", new MsgField(ContentEnum.MessageType.STRING.toString(), "idinst", 50,0, true, "发证机关" )))
					.addNode(new FieldNode("validt", new MsgField(ContentEnum.MessageType.STRING.toString(), "validt", 20,0, true, "证件有效日期" )))
					.addNode(new FieldNode("idcdad", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcdad", 200,0, true, "户籍地址" )))
					.addNode(new FieldNode("appid", new MsgField(ContentEnum.MessageType.STRING.toString(), "appid", 50,0, true, "申请编号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P042000202_O extends MsgBody {
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

