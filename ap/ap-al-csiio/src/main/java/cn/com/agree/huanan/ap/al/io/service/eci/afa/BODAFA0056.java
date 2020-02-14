package cn.com.agree.huanan.ap.al.io.service.eci.afa;

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
 * BASESVC BODAFA0056  财政非税缴费明细查询 
 *  BODAFA0056 883427
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA0056 extends EciChannelService {

	private static BODAFA0056_I i = new BODAFA0056_I();
	private static BODAFA0056_O o = new BODAFA0056_O();
	public BODAFA0056() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0056_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("recvunitno", new MsgField(ContentEnum.MessageType.STRING.toString(), "recvunitno", 30,0, false, "执收单位编码" )))
					.addNode(new FieldNode("paysno", new MsgField(ContentEnum.MessageType.STRING.toString(), "paysno", 50,0, false, "缴款通知书号码" )))
					.addNode(new FieldNode("paystatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "paystatus", 50,0, false, "缴费状态" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0056_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("recvunitno", new MsgField(ContentEnum.MessageType.STRING.toString(), "recvunitno", 30,0, false, "执收单位编码" )))
					.addNode(new FieldNode("recvunitname", new MsgField(ContentEnum.MessageType.STRING.toString(), "recvunitname", 100,0, false, "执收单位名称" )))
					.addNode(new FieldNode("paysno", new MsgField(ContentEnum.MessageType.STRING.toString(), "paysno", 50,0, false, "外部通知书号码" )))
					.addNode(new FieldNode("rtnpaysno", new MsgField(ContentEnum.MessageType.STRING.toString(), "rtnpaysno", 50,0, false, "内部通知书号码" )))
					.addNode(new FieldNode("paysnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "paysnm", 100,0, false, "缴款人（单位）名称" )))
					.addNode(new FieldNode("payday", new MsgField(ContentEnum.MessageType.STRING.toString(), "payday", 8,0, false, "缴款日期" )))
					.addNode(new FieldNode("total_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "total_amt", 16,0, false, "应收总本金" )))
					.addNode(new FieldNode("total_fee", new MsgField(ContentEnum.MessageType.STRING.toString(), "total_fee", 16,0, false, "应收总滞纳金" )))
					.addNode(new FieldNode("total_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "total_cnt", 1,0, false, "收费项目数" )))
					.addNode(new FieldNode("itemno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "itemno1", 14,0, false, "收费项目编码1" )))
					.addNode(new FieldNode("itemnm1", new MsgField(ContentEnum.MessageType.STRING.toString(), "itemnm1", 100,0, false, "收费项目名称1" )))
					.addNode(new FieldNode("unit01", new MsgField(ContentEnum.MessageType.STRING.toString(), "unit01", 50,0, false, "计费单位1" )))
					.addNode(new FieldNode("paycnt1", new MsgField(ContentEnum.MessageType.STRING.toString(), "paycnt1", 16,0, false, "计费数量1" )))
					.addNode(new FieldNode("change1", new MsgField(ContentEnum.MessageType.STRING.toString(), "change1", 16,0, false, "收费标准1" )))
					.addNode(new FieldNode("payamt1", new MsgField(ContentEnum.MessageType.STRING.toString(), "payamt1", 16,0, false, "应收金额1" )))
					.addNode(new FieldNode("itemno2", new MsgField(ContentEnum.MessageType.STRING.toString(), "itemno2", 14,0, false, "收费项目编码2" )))
					.addNode(new FieldNode("itemnm2", new MsgField(ContentEnum.MessageType.STRING.toString(), "itemnm2", 100,0, false, "收费项目名称2" )))
					.addNode(new FieldNode("unit02", new MsgField(ContentEnum.MessageType.STRING.toString(), "unit02", 50,0, false, "计费单位2" )))
					.addNode(new FieldNode("paycnt2", new MsgField(ContentEnum.MessageType.STRING.toString(), "paycnt2", 16,0, false, "计费数量2" )))
					.addNode(new FieldNode("change2", new MsgField(ContentEnum.MessageType.STRING.toString(), "change2", 16,0, false, "收费标准2" )))
					.addNode(new FieldNode("payamt2", new MsgField(ContentEnum.MessageType.STRING.toString(), "payamt2", 16,0, false, "应收金额2" )))
					.addNode(new FieldNode("itemno3", new MsgField(ContentEnum.MessageType.STRING.toString(), "itemno3", 14,0, false, "收费项目编码3" )))
					.addNode(new FieldNode("itemnm3", new MsgField(ContentEnum.MessageType.STRING.toString(), "itemnm3", 100,0, false, "收费项目名称3" )))
					.addNode(new FieldNode("unit03", new MsgField(ContentEnum.MessageType.STRING.toString(), "unit03", 50,0, false, "计费单位3" )))
					.addNode(new FieldNode("paycnt3", new MsgField(ContentEnum.MessageType.STRING.toString(), "paycnt3", 16,0, false, "计费数量3" )))
					.addNode(new FieldNode("change3", new MsgField(ContentEnum.MessageType.STRING.toString(), "change3", 16,0, false, "收费标准3" )))
					.addNode(new FieldNode("payamt3", new MsgField(ContentEnum.MessageType.STRING.toString(), "payamt3", 16,0, false, "应收金额3" )))
					.addNode(new FieldNode("itemno4", new MsgField(ContentEnum.MessageType.STRING.toString(), "itemno4", 14,0, false, "收费项目编码4" )))
					.addNode(new FieldNode("itemnm4", new MsgField(ContentEnum.MessageType.STRING.toString(), "itemnm4", 100,0, false, "收费项目名称4" )))
					.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark", 500,0, false, "备注" )))
					.addNode(new FieldNode("extnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "extnum", 1,0, false, "额外信息数" )))
					.addNode(new FieldNode("extendinfo1", new MsgField(ContentEnum.MessageType.STRING.toString(), "extendinfo1", 500,0, false, "额外信息1" )))
					.addNode(new FieldNode("extendinfo2", new MsgField(ContentEnum.MessageType.STRING.toString(), "extendinfo2", 500,0, false, "额外信息2" )))
					.addNode(new FieldNode("extendinfo3", new MsgField(ContentEnum.MessageType.STRING.toString(), "extendinfo3", 500,0, false, "额外信息3" )))
					.addNode(new FieldNode("extendinfo4", new MsgField(ContentEnum.MessageType.STRING.toString(), "extendinfo4", 500,0, false, "额外信息4" )))
					.addNode(new FieldNode("chknum", new MsgField(ContentEnum.MessageType.STRING.toString(), "chknum", 5,0, false, "号码校验码" )))
					.addNode(new FieldNode("allnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "allnum", 5,0, false, "全书校验码" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 35,0, false, "缴款账号" )))
					.addNode(new FieldNode("billno", new MsgField(ContentEnum.MessageType.STRING.toString(), "billno", 20,0, false, "票据号码" )))
					.addNode(new FieldNode("serialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "serialno", 10,0, false, "交易流水号" )))
					.addNode(new FieldNode("paystatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "paystatus", 1,0, false, "缴费状态" )))
					.addNode(new FieldNode("paytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "paytype", 1,0, false, "缴费渠道" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

