package cn.com.agree.huanan.ap.al.io.service.eci.nfc;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODNFC0018 ATM取现 BODNFC0018 regflw 渠道整合
 * 
 * @author HYS
 */
@Component
public class BODNFC0018 extends EciChannelService {
	/*
	 * 
	 * INSERT INTO CSIS_ATOMIC_SERVICE (AT_SVCID, AT_SVCCODE, AT_SVCNAME,
	 * AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME,
	 * SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES
	 * ('BASESVCBODNFC0018', 'BASESVC', '渠道整合', 'BODNFC0018', '', 'ECI.NFC',
	 * 'ECI_NFC系统', 'BODNFC0018', 'ATM取现', 'Q104','regflw' ,'', '1', '0', '');
	 * 
	 */
	private static BODNFC0018_I i = new BODNFC0018_I();
	private static BODNFC0018_O o = new BODNFC0018_O();

	public BODNFC0018() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNFC0018_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode
					.addStructNode(new StructNode("APPBody", true, "Body")
							.addNode(new FieldNode("tran_no",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "tran_no", 30, 0, false,
											"交易编码")))
							.addNode(new FieldNode("tran_type",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "tran_type", 10, 0, false,
											"交易类型")))
							.addNode(new FieldNode("accept_branch_id",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "accept_branch_id", 8, 0,
											false, "受理机构代码")))
							.addNode(new FieldNode("order_no",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "order_no", 40, 0, false,
											"订单号")))
							.addNode(new FieldNode("order_time",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "order_time", 14, 0, false,
											"订单时间")))
							.addNode(new FieldNode("pin",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "pin", 100, 0, false,
											"支付密码")))
							.addNode(new FieldNode("tran_amt_string",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "tran_amt_string", 12, 0,
											false, "交易金额")))
							.addNode(new FieldNode("ccy",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy", 3, 0, false,
											"交易币种")))
							.addNode(new FieldNode("reserv_field1",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_field1", 64, 0,
											false, "保留字段1")))
							.addNode(new FieldNode("reserv_field2",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_field2", 64, 0,
											false, "保留字段2"))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODNFC0018_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode
					.addStructNode(new StructNode("Body", true, "APPBody")
							.addNode(new FieldNode("tran_no",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "tran_no", 30, 0, false,
											"交易编码")))
							.addNode(new FieldNode("tran_type",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "tran_type", 512, 0, false,
											"交易类型")))
							.addNode(new FieldNode("accept_branch_id",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "accept_branch_id", 200, 0,
											false, "受理机构代码")))
							.addNode(new FieldNode("pay_cert_no",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "pay_cert_no", 20, 0, false,
											"付款凭证号")))
							.addNode(new FieldNode("settle_field_name",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "settle_field_name", 30, 0,
											false, "清算主键")))
							.addNode(new FieldNode("clear_date",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "clear_date", 4, 0, false,
											"清算日期")))
							.addNode(new FieldNode("message_type_id",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "message_type_id", 4, 0,
											false, "报文类型标识符")))
							.addNode(new FieldNode("handle_code",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "handle_code", 6, 0, false,
											"处理码")))
							.addNode(new FieldNode("pos_cond_code",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "pos_cond_code", 2, 0,
											false, "服务点条件码")))
							.addNode(new FieldNode("tran_index_no",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "tran_index_no", 12, 0,
											false, "交易检索号")))
							.addNode(new FieldNode("ex_region_value",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "ex_region_value", 120, 0,
											false, "扩展域值")))
							.addNode(new FieldNode("reserv_field1",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_field1", 64, 0,
											false, "保留字段1")))
							.addNode(new FieldNode("reserv_field2",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_field2", 64, 0,
											false, "保留字段2"))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
