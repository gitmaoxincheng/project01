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
 * BASESVC.S012001101 验印管理.公共验印 
 * S0120011.01 PubInspe
 * 0209 集中业务处理平台
 * @author XZF
 */
@Component
public class S012001101 extends EsbSdsChannelService {

	private static S012001101_I i = new S012001101_I();
	private static S012001101_O o = new S012001101_O();
	public S012001101() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S012001101_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("TRADECODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "TRADECODE", 4,0, false, "交易类型" )))
					.addNode(new FieldNode("PRODUCTID", new MsgField(ContentEnum.MessageType.STRING.toString(), "PRODUCTID", 4,0, false, "产品码" )))
					.addNode(new FieldNode("TxTpCd", new MsgField(ContentEnum.MessageType.STRING.toString(), "TxTpCd", 4,0, false, "业务类型" )))
					.addNode(new FieldNode("CrcyCd", new MsgField(ContentEnum.MessageType.STRING.toString(), "CrcyCd", 5,0, false, "币种" )))
					.addNode(new FieldNode("TranAm", new MsgField(ContentEnum.MessageType.STRING.toString(), "TranAm", 16,0, false, "交易金额" )))
					.addNode(new FieldNode("DbtrId", new MsgField(ContentEnum.MessageType.STRING.toString(), "DbtrId", 14,0, false, "付款行行号" )))
					.addNode(new FieldNode("CdtrId", new MsgField(ContentEnum.MessageType.STRING.toString(), "CdtrId", 14,0, false, "收款行行号" )))
					.addNode(new FieldNode("Dbtr_Issr", new MsgField(ContentEnum.MessageType.STRING.toString(), "Dbtr_Issr", 14,0, false, "付款人开户行行号" )))
					.addNode(new FieldNode("Dbtr_Id", new MsgField(ContentEnum.MessageType.STRING.toString(), "Dbtr_Id", 32,0, false, "付款人账号" )))
					.addNode(new FieldNode("Dbtr_Nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "Dbtr_Nm", 60,0, false, "付款人名称" )))
					.addNode(new FieldNode("Cdtr_Issr", new MsgField(ContentEnum.MessageType.STRING.toString(), "Cdtr_Issr", 14,0, false, "收款人开户行行号" )))
					.addNode(new FieldNode("Cdtr_Id", new MsgField(ContentEnum.MessageType.STRING.toString(), "Cdtr_Id", 32,0, false, "收款人账号" )))
					.addNode(new FieldNode("Cdtr_Nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "Cdtr_Nm", 60,0, false, "收款人名称" )))
					.addNode(new FieldNode("DbtrIdRmk", new MsgField(ContentEnum.MessageType.STRING.toString(), "DbtrIdRmk", 512,0, false, "付款账号备注" )))
					.addNode(new FieldNode("Cdtr_IdRmk", new MsgField(ContentEnum.MessageType.STRING.toString(), "Cdtr_IdRmk", 512,0, false, "收款账号备注" )))
					.addNode(new FieldNode("Rmk", new MsgField(ContentEnum.MessageType.STRING.toString(), "Rmk", 512,0, false, "备注/附言" )))
					.addNode(new FieldNode("BllTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "BllTp", 8,0, false, "票据类型" )))
					.addNode(new FieldNode("IncfNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "IncfNo", 32,0, false, "票据号" )))
					.addNode(new FieldNode("IsseDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsseDt", 8,0, false, "出票日期" )))
					.addNode(new FieldNode("PayDT", new MsgField(ContentEnum.MessageType.STRING.toString(), "PayDT", 8,0, false, "提示付款日期" )))
					.addNode(new FieldNode("BusinessType", new MsgField(ContentEnum.MessageType.STRING.toString(), "BusinessType", 10,0, false, "业务类型" )))
					.addNode(new FieldNode("Purp", new MsgField(ContentEnum.MessageType.STRING.toString(), "Purp", 60,0, false, "用途" )))
					.addNode(new FieldNode("PrintType", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrintType", 10,0, false, "验印类型" )))
					.addNode(new FieldNode("IsSmallCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsSmallCode", 60,0, false, "是否小码章" )))
					.addNode(new FieldNode("PrintBrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrintBrno", 60,0, false, "验印网点" )))
					.addNode(new FieldNode("PrintUser1", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrintUser1", 60,0, false, "验印柜员1" )))
					.addNode(new FieldNode("PrintUser2", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrintUser2", 60,0, false, "验印柜员2" )))
					.addNode(new FieldNode("PrintNopass1", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrintNopass1", 512,0, false, "验印不通过原因1" )))
					.addNode(new FieldNode("PrintNopass2", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrintNopass2", 512,0, false, "验印不通过原因2" )))
					.addNode(new FieldNode("tradetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradetype", 60,0, false, "验印交易类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S012001101_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("TRADECODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "TRADECODE", 4,0, true, "交易类型" )))
					.addNode(new FieldNode("PRODUCTID", new MsgField(ContentEnum.MessageType.STRING.toString(), "PRODUCTID", 4,0, false, "产品码" )))
					.addNode(new FieldNode("TxTpCd", new MsgField(ContentEnum.MessageType.STRING.toString(), "TxTpCd", 4,0, false, "业务类型" )))
					.addNode(new FieldNode("CrcyCd", new MsgField(ContentEnum.MessageType.STRING.toString(), "CrcyCd", 5,0, false, "币种" )))
					.addNode(new FieldNode("TranAm", new MsgField(ContentEnum.MessageType.STRING.toString(), "TranAm", 16,0, false, "交易金额" )))
					.addNode(new FieldNode("DbtrId", new MsgField(ContentEnum.MessageType.STRING.toString(), "DbtrId", 14,0, false, "付款行行号" )))
					.addNode(new FieldNode("CdtrId", new MsgField(ContentEnum.MessageType.STRING.toString(), "CdtrId", 14,0, false, "收款行行号" )))
					.addNode(new FieldNode("Dbtr_Issr", new MsgField(ContentEnum.MessageType.STRING.toString(), "Dbtr_Issr", 14,0, false, "付款人开户行行号" )))
					.addNode(new FieldNode("Dbtr_Id", new MsgField(ContentEnum.MessageType.STRING.toString(), "Dbtr_Id", 32,0, false, "付款人账号" )))
					.addNode(new FieldNode("Dbtr_Nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "Dbtr_Nm", 60,0, false, "付款人名称" )))
					.addNode(new FieldNode("Cdtr_Issr", new MsgField(ContentEnum.MessageType.STRING.toString(), "Cdtr_Issr", 14,0, false, "收款人开户行行号" )))
					.addNode(new FieldNode("Cdtr_Id", new MsgField(ContentEnum.MessageType.STRING.toString(), "Cdtr_Id", 32,0, false, "收款人账号" )))
					.addNode(new FieldNode("Cdtr_Nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "Cdtr_Nm", 60,0, false, "收款人名称" )))
					.addNode(new FieldNode("DbtrIdRmk", new MsgField(ContentEnum.MessageType.STRING.toString(), "DbtrIdRmk", 512,0, false, "付款账号备注" )))
					.addNode(new FieldNode("Cdtr_IdRmk", new MsgField(ContentEnum.MessageType.STRING.toString(), "Cdtr_IdRmk", 512,0, false, "收款账号备注" )))
					.addNode(new FieldNode("Rmk", new MsgField(ContentEnum.MessageType.STRING.toString(), "Rmk", 512,0, false, "备注/附言" )))
					.addNode(new FieldNode("BllTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "BllTp", 8,0, false, "票据类型" )))
					.addNode(new FieldNode("IncfNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "IncfNo", 32,0, false, "票据号" )))
					.addNode(new FieldNode("IsseDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsseDt", 8,0, false, "出票日期" )))
					.addNode(new FieldNode("PayDT", new MsgField(ContentEnum.MessageType.STRING.toString(), "PayDT", 8,0, false, "提示付款日期" )))
					.addNode(new FieldNode("BusinessType", new MsgField(ContentEnum.MessageType.STRING.toString(), "BusinessType", 10,0, false, "业务类型" )))
					.addNode(new FieldNode("Purp", new MsgField(ContentEnum.MessageType.STRING.toString(), "Purp", 60,0, false, "用途" )))
					.addNode(new FieldNode("PrintType", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrintType", 10,0, false, "验印类型" )))
					.addNode(new FieldNode("AutoPrintResult", new MsgField(ContentEnum.MessageType.STRING.toString(), "AutoPrintResult", 60,0, false, "自动验印结果" )))
					.addNode(new FieldNode("ManulPrintResult", new MsgField(ContentEnum.MessageType.STRING.toString(), "ManulPrintResult", 60,0, false, "人工验印结果" )))
					.addNode(new FieldNode("IsSmallCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsSmallCode", 60,0, false, "是否小码章" )))
					.addNode(new FieldNode("PrintBrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrintBrno", 60,0, false, "验印网点" )))
					.addNode(new FieldNode("PrintUser1", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrintUser1", 60,0, false, "验印柜员1" )))
					.addNode(new FieldNode("PrintUser2", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrintUser2", 60,0, false, "验印柜员2" )))
					.addNode(new FieldNode("PrintNopass1", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrintNopass1", 512,0, false, "验印不通过原因1" )))
					.addNode(new FieldNode("PrintNopass2", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrintNopass2", 512,0, false, "验印不通过原因2" )))
					.addNode(new FieldNode("tradetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradetype", 60,0, false, "验印交易类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

