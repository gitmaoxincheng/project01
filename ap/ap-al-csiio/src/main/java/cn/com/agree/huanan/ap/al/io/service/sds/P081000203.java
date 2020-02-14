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
 * BASESVC.P081000203 票据业务交易.支票托收 
 * P0810002.03 ChequeCo
 * 0209 集中业务处理平台
 * @author LSJ
 */
@Component
public class P081000203 extends EsbSdsChannelService {

	private static P081000203_I i = new P081000203_I();
	private static P081000203_O o = new P081000203_O();
	public P081000203() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P081000203_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("TRADECODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "TRADECODE", 4,0, true, "交易类型" )))
					.addNode(new FieldNode("PRODUCTID", new MsgField(ContentEnum.MessageType.STRING.toString(), "PRODUCTID", 4,0, false, "产品码" )))
					.addNode(new FieldNode("TxTpCd", new MsgField(ContentEnum.MessageType.STRING.toString(), "TxTpCd", 4,0, false, "业务类型" )))
					.addNode(new FieldNode("CrcyCd", new MsgField(ContentEnum.MessageType.STRING.toString(), "CrcyCd", 3,0, false, "币种" )))
					.addNode(new FieldNode("TranAm", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "TranAm", 18,2, false, "交易金额" )))
					.addNode(new FieldNode("TxCd", new MsgField(ContentEnum.MessageType.STRING.toString(), "TxCd", 5,0, false, "业务编号" )))
					.addNode(new FieldNode("DbtrId", new MsgField(ContentEnum.MessageType.STRING.toString(), "DbtrId", 14,0, false, "付款行行号" )))
					.addNode(new FieldNode("CdtrId", new MsgField(ContentEnum.MessageType.STRING.toString(), "CdtrId", 14,0, false, "收款行行号" )))
					.addNode(new FieldNode("Dbtr_Issr", new MsgField(ContentEnum.MessageType.STRING.toString(), "Dbtr_Issr", 14,0, false, "付款人开户行行号" )))
					.addNode(new FieldNode("Dbtr_Id", new MsgField(ContentEnum.MessageType.STRING.toString(), "Dbtr_Id", 32,0, false, "付款人账号" )))
					.addNode(new FieldNode("Dbtr_Nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "Dbtr_Nm", 60,0, false, "付款人名称" )))
					.addNode(new FieldNode("Dbtr_Adr", new MsgField(ContentEnum.MessageType.STRING.toString(), "Dbtr_Adr", 70,0, false, "付款人地址" )))
					.addNode(new FieldNode("Cdtr_Issr", new MsgField(ContentEnum.MessageType.STRING.toString(), "Cdtr_Issr", 14,0, false, "收款人开户行行号" )))
					.addNode(new FieldNode("Cdtr_Id", new MsgField(ContentEnum.MessageType.STRING.toString(), "Cdtr_Id", 32,0, false, "收款人账号" )))
					.addNode(new FieldNode("Cdtr_Nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "Cdtr_Nm", 60,0, false, "收款人名称" )))
					.addNode(new FieldNode("Cdtr_Adr", new MsgField(ContentEnum.MessageType.STRING.toString(), "Cdtr_Adr", 70,0, false, "收款人地址" )))
					.addNode(new FieldNode("Rmk", new MsgField(ContentEnum.MessageType.STRING.toString(), "Rmk", 256,0, false, "备注/附言" )))
					.addNode(new FieldNode("BllTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "BllTp", 8,0, false, "票据类型" )))
					.addNode(new FieldNode("IncfNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "IncfNo", 32,0, false, "票据号" )))
					.addNode(new FieldNode("IsseDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsseDt", 8,0, false, "出票日期" )))
					.addNode(new FieldNode("PayDT", new MsgField(ContentEnum.MessageType.STRING.toString(), "PayDT", 8,0, false, "提示付款日期" )))
					.addNode(new FieldNode("Purp", new MsgField(ContentEnum.MessageType.STRING.toString(), "Purp", 60,0, false, "用途" )))
					.addNode(new FieldNode("PmtPswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "PmtPswd", 512,0, false, "支付密码" )))
					.addNode(new FieldNode("NbOfEndrsr", new MsgField(ContentEnum.MessageType.STRING.toString(), "NbOfEndrsr", 2,0, false, "被背书人数" )))
					.addNode(new FieldNode("Nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "Nm", 1200,0, false, "被背书人名称" )))
					.addNode(new FieldNode("ImgTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ImgTp", 10,0, false, "票据图像类型" )))
					.addNode(new FieldNode("ImgFrntLen", new MsgField(ContentEnum.MessageType.STRING.toString(), "ImgFrntLen", 8,0, false, "票据正面图像长度" )))
					.addNode(new FieldNode("FrntFileName", new MsgField(ContentEnum.MessageType.STRING.toString(), "FrntFileName", 60,0, false, "票据正面图像文件名" )))
					.addNode(new FieldNode("ImgBckLen", new MsgField(ContentEnum.MessageType.STRING.toString(), "ImgBckLen", 8,0, false, "票背面据图像长度" )))
					.addNode(new FieldNode("BckFileName", new MsgField(ContentEnum.MessageType.STRING.toString(), "BckFileName", 60,0, false, "票据背面图像文件名" )))
					.addNode(new FieldNode("BUSI_START_DATE", new MsgField(ContentEnum.MessageType.STRING.toString(), "BUSI_START_DATE", 20,0, true, "业务开始时间" )))
					.addNode(new FieldNode("BUSI_SERIAL_NO", new MsgField(ContentEnum.MessageType.STRING.toString(), "BUSI_SERIAL_NO", 200,0, true, "业务流水号" )))
					.addNode(new FieldNode("CONTENT_ID", new MsgField(ContentEnum.MessageType.STRING.toString(), "CONTENT_ID", 64,0, true, "内容编号CONTENTID" )))
					.addNode(new FieldNode("front_FILE_ID", new MsgField(ContentEnum.MessageType.STRING.toString(), "front_FILE_ID", 200,0, true, "正面文件ID" )))
					.addNode(new FieldNode("back_FILE_ID", new MsgField(ContentEnum.MessageType.STRING.toString(), "back_FILE_ID", 200,0, true, "背面文件ID" )))
					.addNode(new FieldNode("PmtPswdFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "PmtPswdFlag", 4,0, true, "支付密码标示" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P081000203_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("RETCODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "RETCODE", 10,0, false, "处理结果码" )))
					.addNode(new FieldNode("RETREASON", new MsgField(ContentEnum.MessageType.STRING.toString(), "RETREASON", 150,0, false, "处理结果信息" )))
					.addNode(new FieldNode("TRADECODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "TRADECODE", 4,0, true, "交易类型" )))
					.addNode(new FieldNode("PRODUCTID", new MsgField(ContentEnum.MessageType.STRING.toString(), "PRODUCTID", 4,0, false, "产品码" )))
					.addNode(new FieldNode("TxTpCd", new MsgField(ContentEnum.MessageType.STRING.toString(), "TxTpCd", 4,0, false, "业务类型" )))
					.addNode(new FieldNode("CrcyCd", new MsgField(ContentEnum.MessageType.STRING.toString(), "CrcyCd", 3,0, false, "币种" )))
					.addNode(new FieldNode("TranAm", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "TranAm", 18,2, false, "交易金额" )))
					.addNode(new FieldNode("TxCd", new MsgField(ContentEnum.MessageType.STRING.toString(), "TxCd", 5,0, false, "业务编号" )))
					.addNode(new FieldNode("DbtrId", new MsgField(ContentEnum.MessageType.STRING.toString(), "DbtrId", 14,0, false, "付款行行号" )))
					.addNode(new FieldNode("CdtrId", new MsgField(ContentEnum.MessageType.STRING.toString(), "CdtrId", 14,0, false, "收款行行号" )))
					.addNode(new FieldNode("Dbtr_Issr", new MsgField(ContentEnum.MessageType.STRING.toString(), "Dbtr_Issr", 14,0, false, "付款人开户行行号" )))
					.addNode(new FieldNode("Dbtr_Id", new MsgField(ContentEnum.MessageType.STRING.toString(), "Dbtr_Id", 32,0, false, "付款人账号" )))
					.addNode(new FieldNode("Dbtr_Nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "Dbtr_Nm", 60,0, false, "付款人名称" )))
					.addNode(new FieldNode("Dbtr_Adr", new MsgField(ContentEnum.MessageType.STRING.toString(), "Dbtr_Adr", 70,0, false, "付款人地址" )))
					.addNode(new FieldNode("Cdtr_Issr", new MsgField(ContentEnum.MessageType.STRING.toString(), "Cdtr_Issr", 14,0, false, "收款人开户行行号" )))
					.addNode(new FieldNode("Cdtr_Id", new MsgField(ContentEnum.MessageType.STRING.toString(), "Cdtr_Id", 32,0, false, "收款人账号" )))
					.addNode(new FieldNode("Cdtr_Nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "Cdtr_Nm", 60,0, false, "收款人名称" )))
					.addNode(new FieldNode("Cdtr_Adr", new MsgField(ContentEnum.MessageType.STRING.toString(), "Cdtr_Adr", 70,0, false, "收款人地址" )))
					.addNode(new FieldNode("Rmk", new MsgField(ContentEnum.MessageType.STRING.toString(), "Rmk", 256,0, false, "备注/附言" )))
					.addNode(new FieldNode("BllTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "BllTp", 8,0, false, "票据类型" )))
					.addNode(new FieldNode("IncfNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "IncfNo", 32,0, false, "票据号" )))
					.addNode(new FieldNode("IsseDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsseDt", 8,0, false, "出票日期" )))
					.addNode(new FieldNode("PayDT", new MsgField(ContentEnum.MessageType.STRING.toString(), "PayDT", 8,0, false, "提示付款日期" )))
					.addNode(new FieldNode("Purp", new MsgField(ContentEnum.MessageType.STRING.toString(), "Purp", 60,0, false, "用途" )))
					.addNode(new FieldNode("PmtPswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "PmtPswd", 512,0, false, "支付密码" )))
					.addNode(new FieldNode("NbOfEndrsr", new MsgField(ContentEnum.MessageType.STRING.toString(), "NbOfEndrsr", 2,0, false, "被背书人数" )))
					.addNode(new FieldNode("Nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "Nm", 1200,0, false, "被背书人名称" )))
					.addNode(new FieldNode("ImgTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ImgTp", 10,0, false, "票据图像类型" )))
					.addNode(new FieldNode("ImgFrntLen", new MsgField(ContentEnum.MessageType.STRING.toString(), "ImgFrntLen", 8,0, false, "票据正面图像长度" )))
					.addNode(new FieldNode("FrntFileName", new MsgField(ContentEnum.MessageType.STRING.toString(), "FrntFileName", 60,0, false, "票据正面图像文件名" )))
					.addNode(new FieldNode("ImgBckLen", new MsgField(ContentEnum.MessageType.STRING.toString(), "ImgBckLen", 8,0, false, "票背面据图像长度" )))
					.addNode(new FieldNode("BckFileName", new MsgField(ContentEnum.MessageType.STRING.toString(), "BckFileName", 60,0, false, "票据背面图像文件名" )))
					.addNode(new FieldNode("CONTENT_ID", new MsgField(ContentEnum.MessageType.STRING.toString(), "CONTENT_ID", 64,0, true, "内容编号CONTENTID" )))
					.addNode(new FieldNode("front_FILE_ID", new MsgField(ContentEnum.MessageType.STRING.toString(), "front_FILE_ID", 200,0, true, "正面文件ID" )))
					.addNode(new FieldNode("back_FILE_ID", new MsgField(ContentEnum.MessageType.STRING.toString(), "back_FILE_ID", 200,0, true, "背面文件ID" )))
					.addNode(new FieldNode("BUSI_START_DATE", new MsgField(ContentEnum.MessageType.STRING.toString(), "BUSI_START_DATE", 20,0, true, "业务开始时间" )))
					.addNode(new FieldNode("BUSI_SERIAL_NO", new MsgField(ContentEnum.MessageType.STRING.toString(), "BUSI_SERIAL_NO", 200,0, true, "业务流水号" )))
					.addNode(new FieldNode("PmtPswdFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "PmtPswdFlag", 4,0, true, "支付密码标示" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

