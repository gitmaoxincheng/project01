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
 * BASESVC BODNFC0021 申请二维码 BODNFC0021 regflw 渠道整合
 * 
 * @author HYS
 */
@Component
public class BODNFC0021 extends EciChannelService {
	/*
	 * 
	 * INSERT INTO CSIS_ATOMIC_SERVICE (AT_SVCID, AT_SVCCODE, AT_SVCNAME,
	 * AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME,
	 * SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES
	 * ('BASESVCBODNFC0021', 'BASESVC', '渠道整合', 'BODNFC0021', '', 'ECI.NFC',
	 * 'ECI_NFC系统', 'BODNFC0021', '申请二维码', 'Q101','regflw' ,'', '1', '0', '');
	 * 
	 */
	private static BODNFC0021_I i = new BODNFC0021_I();
	private static BODNFC0021_O o = new BODNFC0021_O();

	public BODNFC0021() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNFC0021_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode
					.addStructNode(new StructNode("APPBody", true, "Body")
							.addNode(new FieldNode("tran_no",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "tran_no", 30, 0, true,
											"交易编码")))
							.addNode(new FieldNode("tran_type",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "tran_type", 10, 0, true,
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
							.addNode(new FieldNode("order_type",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "order_type", 2, 0, false,
											"订单类型")))
							.addNode(new FieldNode("qr_code_type",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "qr_code_type", 1, 0, false,
											"二维码类型")))
							.addNode(new FieldNode("pay_code_name",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "pay_code_name", 100, 0,
											false, "名称")))
							.addNode(new FieldNode("pay_code",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "pay_code", 20, 0, false,
											"标识")))
							.addNode(new FieldNode("sub_cat_code",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_cat_code", 20, 0,
											false, "二级代码")))
							.addNode(new FieldNode("sub_cat_name",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_cat_name", 100, 0,
											false, "二级名称")))
							.addNode(new FieldNode("txn_max_amt",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_max_amt", 12, 0, false,
											"金额")))
							.addNode(new FieldNode("ccy",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy", 3, 0, false,
											"交易币种")))
							.addNode(new FieldNode("ori_channel_ws_id",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "ori_channel_ws_id", 1024,
											0, false, "渠道终端号")))
							.addNode(new FieldNode("support_flag",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "support_flag", 1, 0, false,
											"发票支持标识")))
							.addNode(new FieldNode("notice_url_address",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "notice_url_address", 200,
											0, false, "通知URL地址")))
							.addNode(new FieldNode("postscript",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "postscript", 500, 0, false,
											"收款方附言")))
							.addNode(new FieldNode("eff_time",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "eff_time", 9, 0, false,
											"有效时间")))
							.addNode(new FieldNode("spec_fee_info",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "spec_fee_info", 3, 0,
											false, "特殊计费类型")))
							.addNode(new FieldNode("limit_count",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "limit_count", 1, 0, false,
											"支付次数")))
							.addNode(new FieldNode("ex_region_value",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "ex_region_value", 500, 0,
											false, "扩展域值")))
							.addNode(new FieldNode("large_amountin",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "large_amountin", 1, 0,
											false, "大额支付标识")))
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

	public static class BODNFC0021_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("ret_code",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "ret_code", 30, 0, false,
									"交易返回代码")))
					.addNode(new FieldNode("ret_msg",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "ret_msg", 512, 0, false,
									"交易返回信息")))
					.addNode(new FieldNode("qr_code",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "qr_code", 200, 0, false, "二维码")))
					.addNode(new FieldNode("eff_time",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "eff_time", 9, 0, false, "有效时间")))
					.addNode(new FieldNode("limit_count",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "limit_count", 1, 0, false,
									"支付次数")))
					.addNode(new FieldNode("order_no",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "order_no", 40, 0, false, "订单号")))
					.addNode(new FieldNode("order_time",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "order_time", 14, 0, false,
									"订单时间")))
					.addNode(new FieldNode("txn_date",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_date", 8, 0, false,
									"TSMP系统日期")))
					.addNode(new FieldNode("txn_time",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_time", 6, 0, false, "柜台交易时间")))
					.addNode(new FieldNode("txn_ssn",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_ssn", 33, 0, false,
									"TSMP流水号")))
					.addNode(new FieldNode("reserv_field1",
							new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_field1", 64, 0, false,
									"保留字段1")))
					.addNode(new FieldNode("reserv_field2", new MsgField(ContentEnum.MessageType.STRING.toString(),
							"reserv_field2", 64, 0, false, "保留字段2"))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
