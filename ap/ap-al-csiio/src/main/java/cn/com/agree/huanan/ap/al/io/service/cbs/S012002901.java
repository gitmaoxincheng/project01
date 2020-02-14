package cn.com.agree.huanan.ap.al.io.service.cbs;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbCoreChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.S012002901 印鉴卡信息管理.印鉴卡建档 
 * S0120029.01 ce5431
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class S012002901 extends EsbCoreChannelService {

	private static S012002901_I i = new S012002901_I();
	private static S012002901_O o = new S012002901_O();
	public S012002901() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S012002901_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("enabl_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "enabl_dt", 8,0, false, "启用日期" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("signtr_card_cps", new MsgField(ContentEnum.MessageType.INT.toString(), "signtr_card_cps", 10,0, false, "印鉴卡份数" )))
					.addNode(new FieldNode("signtr_card_num_1", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtr_card_num_1", 10,0, false, "印鉴卡号码1" )))
					.addNode(new FieldNode("signtr_card_num_2", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtr_card_num_2", 10,0, false, "印鉴卡号码2" )))
					.addNode(new FieldNode("signtr_card_num_3", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtr_card_num_3", 10,0, false, "印鉴卡号码3" )))
					.addNode(new FieldNode("signtr_card_num_4", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtr_card_num_4", 10,0, false, "印鉴卡号码4" )))
					.addNode(new FieldNode("signtr_card_num_5", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtr_card_num_5", 10,0, false, "印鉴卡号码5" )))
					.addNode(new FieldNode("signtr_card_num_6", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtr_card_num_6", 10,0, false, "印鉴卡号码6" )))
					.addNode(new FieldNode("signtr_card_num_7", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtr_card_num_7", 10,0, false, "印鉴卡号码7" )))
					.addNode(new FieldNode("signtr_card_num_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtr_card_num_8", 10,0, false, "印鉴卡号码8" )))
					.addNode(new FieldNode("signtr_card_num_9", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtr_card_num_9", 10,0, false, "印鉴卡号码9" )))
					.addNode(new FieldNode("signtr_card_num_10", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtr_card_num_10", 10,0, false, "印鉴卡号码10" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S012002901_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_rung_num", 32,0, false, "柜员流水号" )))
					.addNode(new FieldNode("cur_txn_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cur_txn_dt", 8,0, false, "当前交易日期" )))
					.addNode(new FieldNode("signtr_card_cps", new MsgField(ContentEnum.MessageType.INT.toString(), "signtr_card_cps", 10,0, false, "印鉴卡份数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

