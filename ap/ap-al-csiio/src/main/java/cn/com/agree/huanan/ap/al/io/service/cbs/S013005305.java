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
 * BASESVC.S013005305 印鉴卡信息查询.印鉴卡卡号账号互查 
 * S0130053.05 ce5451
 * 0005 新核心业务系统
 * @author STJ
 */
@Component
public class S013005305 extends EsbCoreChannelService {
	/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCS013005305', 'BASESVC', '新核心业务系统', 'S013005305', '印鉴卡信息查询', 'CBS', 'ESB_cbs系统', 'S0130053', '印鉴卡卡号账号互查', '05','ce5451' ,'印鉴卡信息查询', '1', '0', '印鉴卡信息查询');

	 */
	private static S013005305_I i = new S013005305_I();
	private static S013005305_O o = new S013005305_O();

	public S013005305() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013005305_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("signtr_card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtr_card_num", 10,0, false, "印鉴卡号码" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S013005305_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
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
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("cust_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_nm", 256,0, false, "客户账户名称" )))
					.addNode(new FieldNode("signtr_card_cps", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtr_card_cps", 10,0, false, "印鉴卡份数" )))
					.addNode(new FieldNode("enabl_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "enabl_dt", 8,0, false, "启用日期" )))
					.addNode(new FieldNode("qty", new MsgField(ContentEnum.MessageType.STRING.toString(), "qty", 10,0, false, "数量" )))
					.addNode(new FieldNode("crea_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "crea_dt", 8,0, false, "建档日期" )))
					.addNode(new FieldNode("signtr_card_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtr_card_ste", 1,0, false, "印鉴卡状态" )))
					.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
