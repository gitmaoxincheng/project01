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
 * BASESVC BODAFA0051  财政非税查询缴费 
 *  BODAFA0051 
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA0051 extends EciChannelService {

	private static BODAFA0051_I i = new BODAFA0051_I();
	private static BODAFA0051_O o = new BODAFA0051_O();
	public BODAFA0051() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0051_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("paytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "paytype", 1,0, false, "缴款标识" )))
					.addNode(new FieldNode("recvunitno", new MsgField(ContentEnum.MessageType.STRING.toString(), "recvunitno", 30,0, false, "执收单位编码" )))
					.addNode(new FieldNode("paysno", new MsgField(ContentEnum.MessageType.STRING.toString(), "paysno", 50,0, false, "缴款通知书号码" )))
					.addNode(new FieldNode("chknum", new MsgField(ContentEnum.MessageType.STRING.toString(), "chknum", 5,0, false, "号码校验码" )))
					.addNode(new FieldNode("allnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "allnum", 5,0, false, "全书校验码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0051_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("unitno", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitno", 30,0, false, "执收单位代码" )))
					.addNode(new FieldNode("unitnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitnm", 100,0, false, "执收单位名称" )))
					.addNode(new FieldNode("paysno", new MsgField(ContentEnum.MessageType.STRING.toString(), "paysno", 50,0, false, "缴款通知书号码" )))
					.addNode(new FieldNode("paysnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "paysnm", 100,0, false, "缴款人（单位）名称" )))
					.addNode(new FieldNode("total_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "total_amt", 16,0, false, "应收总金额" )))
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
					.addNode(new FieldNode("unit04", new MsgField(ContentEnum.MessageType.STRING.toString(), "unit04", 50,0, false, "计费单位4" )))
					.addNode(new FieldNode("paycnt4", new MsgField(ContentEnum.MessageType.STRING.toString(), "paycnt4", 16,0, false, "计费数量4" )))
					.addNode(new FieldNode("change4", new MsgField(ContentEnum.MessageType.STRING.toString(), "change4", 16,0, false, "收费标准4" )))
					.addNode(new FieldNode("payamt4", new MsgField(ContentEnum.MessageType.STRING.toString(), "payamt4", 16,0, false, "应收金额4" )))
					.addNode(new FieldNode("paymemo", new MsgField(ContentEnum.MessageType.STRING.toString(), "paymemo", 500,0, false, "备注" )))
					.addNode(new FieldNode("extnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "extnum", 1,0, false, "额外信息数" )))
					.addNode(new FieldNode("extmemo2", new MsgField(ContentEnum.MessageType.STRING.toString(), "extmemo2", 500,0, false, "额外信息1" )))
					.addNode(new FieldNode("extmemo2", new MsgField(ContentEnum.MessageType.STRING.toString(), "extmemo2", 500,0, false, "额外信息2" )))
					.addNode(new FieldNode("extmemo3", new MsgField(ContentEnum.MessageType.STRING.toString(), "extmemo3", 500,0, false, "额外信息3" )))
					.addNode(new FieldNode("extmemo4", new MsgField(ContentEnum.MessageType.STRING.toString(), "extmemo4", 500,0, false, "额外信息4" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

