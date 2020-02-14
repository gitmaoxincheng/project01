package cn.com.agree.huanan.ap.al.io.service.sds;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbSdsChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P081000202 票据业务交易.支票转账 
 * P0810002.02 ChequeTr
 * 0209 集中业务处理平台
 * @author STJ
 */
@Component
public class P081000202 extends EsbSdsChannelService {
/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCP081000202', 'BASESVC', '集中业务处理平台', 'P081000202', '票据业务交易', 'SDS', 'ESB_sds系统', 'P0810002', '支票转账', '02','ChequeTr' ,'票据业务交易', '1', '0', '票据业务交易');

*/
	private static P081000202_I i = new P081000202_I();
	private static P081000202_O o = new P081000202_O();

	public P081000202() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class P081000202_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
.addNode(new FieldNode("TRADECODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "TRADECODE", 4,0, true, "交易类型" )))
.addNode(new FieldNode("PRODUCTID", new MsgField(ContentEnum.MessageType.STRING.toString(), "PRODUCTID", 4,0, true, "产品码" )))
.addNode(new FieldNode("payeracc", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeracc", 40,0, false, "付款人账号" )))
.addNode(new FieldNode("payername", new MsgField(ContentEnum.MessageType.STRING.toString(), "payername", 256,0, false, "付款人名称" )))
.addNode(new FieldNode("payeraddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeraddr", 120,0, false, "付款人地址" )))
.addNode(new FieldNode("currtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "currtype", 3,0, false, "币种" )))
.addNode(new FieldNode("payeeacc", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeeacc", 40,0, false, "收款人账号" )))
.addNode(new FieldNode("payeename", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeename", 256,0, false, "收款人姓名" )))
.addNode(new FieldNode("payeeaccbank", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeeaccbank", 14,0, false, "收款人开户行" )))
.addNode(new FieldNode("payeeaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeeaddr", 120,0, false, "收款人地址" )))
.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "amount", 18,2, false, "交易金额" )))
.addNode(new FieldNode("priority", new MsgField(ContentEnum.MessageType.STRING.toString(), "priority", 1,0, false, "优先级" )))
.addNode(new FieldNode("chrgfg", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrgfg", 1,0, false, "是否收手续费标志" )))
.addNode(new FieldNode("chargeamount", new MsgField(ContentEnum.MessageType.INT.toString(), "chargeamount", 18,2, false, "手续费金额" )))
.addNode(new FieldNode("chargeacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "chargeacctno", 40,0, false, "手续费账号" )))
.addNode(new FieldNode("reqpostscript", new MsgField(ContentEnum.MessageType.STRING.toString(), "reqpostscript", 120,0, false, "附言" )))
.addNode(new FieldNode("smrycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "smrycd", 10,0, false, "摘要码" )))
.addNode(new FieldNode("dscrtx", new MsgField(ContentEnum.MessageType.STRING.toString(), "dscrtx", 225,0, false, "交易摘要" )))
.addNode(new FieldNode("payervouchtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "payervouchtype", 8,0, false, "凭证类型" )))
.addNode(new FieldNode("payervouchno", new MsgField(ContentEnum.MessageType.STRING.toString(), "payervouchno", 35,0, false, "凭证号码" )))
.addNode(new FieldNode("payervouchdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "payervouchdate", 8,0, false, "凭证日期" )))
.addNode(new FieldNode("mptrsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "mptrsq", 60,0, false, "综合前置流水" )))
.addNode(new FieldNode("mptrdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "mptrdt", 60,0, false, "综合前置日期" )))
.addNode(new FieldNode("svdptg", new MsgField(ContentEnum.MessageType.STRING.toString(), "svdptg", 2,0, false, "对公对私(付款账户)" )))
.addNode(new FieldNode("printtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "printtype", 1,0, false, "验印类型" )))
.addNode(new FieldNode("printt", new MsgField(ContentEnum.MessageType.STRING.toString(), "printt", 1,0, false, "验印取信标示" )))
.addNode(new FieldNode("tradetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradetype", 1,0, false, "验印交易类型" )))
.addNode(new FieldNode("transflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "transflag", 2,0, false, "行内外转账标志" )))
.addNode(new FieldNode("mobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobile", 20,0, false, "通知手机号码" )))
);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class P081000202_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
.addNode(new FieldNode("TRADECODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "TRADECODE", 4,0, true, "交易类型" )))
.addNode(new FieldNode("PRODUCTID", new MsgField(ContentEnum.MessageType.STRING.toString(), "PRODUCTID", 4,0, true, "产品码" )))
.addNode(new FieldNode("payeracc", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeracc", 40,0, false, "付款人账号" )))
.addNode(new FieldNode("payername", new MsgField(ContentEnum.MessageType.STRING.toString(), "payername", 256,0, false, "付款人名称" )))
.addNode(new FieldNode("payeraddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeraddr", 120,0, false, "付款人地址" )))
.addNode(new FieldNode("currtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "currtype", 3,0, false, "币种" )))
.addNode(new FieldNode("payeeacc", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeeacc", 40,0, false, "收款人账号" )))
.addNode(new FieldNode("payeename", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeename", 256,0, false, "收款人姓名" )))
.addNode(new FieldNode("payeeaccbank", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeeaccbank", 14,0, false, "收款人开户行" )))
.addNode(new FieldNode("payeeaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeeaddr", 120,0, false, "收款人地址" )))
.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.INT.toString(), "amount", 18,2, false, "交易金额" )))
.addNode(new FieldNode("priority", new MsgField(ContentEnum.MessageType.STRING.toString(), "priority", 1,0, false, "优先级" )))
.addNode(new FieldNode("chrgfg", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrgfg", 1,0, false, "是否收手续费标志" )))
.addNode(new FieldNode("chargeamount", new MsgField(ContentEnum.MessageType.INT.toString(), "chargeamount", 18,2, false, "手续费金额" )))
.addNode(new FieldNode("chargeacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "chargeacctno", 40,0, false, "手续费账号" )))
.addNode(new FieldNode("reqpostscript", new MsgField(ContentEnum.MessageType.STRING.toString(), "reqpostscript", 120,0, false, "附言" )))
.addNode(new FieldNode("smrycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "smrycd", 10,0, false, "摘要码" )))
.addNode(new FieldNode("dscrtx", new MsgField(ContentEnum.MessageType.STRING.toString(), "dscrtx", 225,0, false, "交易摘要" )))
.addNode(new FieldNode("payervouchtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "payervouchtype", 8,0, false, "凭证类型" )))
.addNode(new FieldNode("payervouchno", new MsgField(ContentEnum.MessageType.STRING.toString(), "payervouchno", 35,0, false, "凭证号码" )))
.addNode(new FieldNode("payervouchdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "payervouchdate", 8,0, false, "凭证日期" )))
.addNode(new FieldNode("mptrsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "mptrsq", 60,0, false, "综合前置流水" )))
.addNode(new FieldNode("mptrdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "mptrdt", 60,0, false, "综合前置日期" )))
.addNode(new FieldNode("svdptg", new MsgField(ContentEnum.MessageType.STRING.toString(), "svdptg", 2,0, false, "对公对私(付款账户)" )))
.addNode(new FieldNode("printtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "printtype", 1,0, false, "验印类型" )))
.addNode(new FieldNode("printt", new MsgField(ContentEnum.MessageType.STRING.toString(), "printt", 1,0, false, "验印取信标示" )))
.addNode(new FieldNode("tradetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradetype", 1,0, false, "验印交易类型" )))
.addNode(new FieldNode("transflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "transflag", 2,0, false, "行内外转账标志" )))
);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
