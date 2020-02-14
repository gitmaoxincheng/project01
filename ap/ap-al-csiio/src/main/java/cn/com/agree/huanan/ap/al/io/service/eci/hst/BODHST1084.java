package cn.com.agree.huanan.ap.al.io.service.eci.hst;

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
 * BASESVC BODHST1084   账户交易明细查询 
 *  BODHST1084 
 *  旧核心系统
 * @author YFK
 */
@Component
public class BODHST1084 extends EciChannelService{
	
	private static BODHST1084_I i = new BODHST1084_I();
	private static BODHST1084_O o = new BODHST1084_O();
	public BODHST1084() {
		requestFormat.add(i);
		responseFormat.add(o);		
	}
	
	public static class BODHST1084_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(),"Eciorgbuf" ,1024,0, false, "渠道备注信息  " )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(),"acctno" ,16,0, false, "卡/账号  " )))
					.addNode(new FieldNode("crcycd", new MsgField(ContentEnum.MessageType.STRING.toString(),"crcycd" ,3,0, false, "币种  " )))
					.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.STRING.toString(),"tranam" ,6,0, false, "金额  " )))
					.addNode(new FieldNode("trantp", new MsgField(ContentEnum.MessageType.STRING.toString(),"trantp" ,2,0, false, "交易类型  " )))
					.addNode(new FieldNode("acctna", new MsgField(ContentEnum.MessageType.STRING.toString(),"acctna" ,21,0, false, "户名  " )))
					.addNode(new FieldNode("acctst", new MsgField(ContentEnum.MessageType.STRING.toString(),"acctst" ,21,0, false, "账户状态  " )))
					.addNode(new FieldNode("bgtsdt", new MsgField(ContentEnum.MessageType.STRING.toString(),"bgtsdt" ,2,0, false, "开始日期  " )))
					.addNode(new FieldNode("edtsdt", new MsgField(ContentEnum.MessageType.STRING.toString(),"edtsdt" ,21,0, false, "结束日期  " )))
					.addNode(new FieldNode("rcrdnm", new MsgField(ContentEnum.MessageType.STRING.toString(),"rcrdnm" ,21,0, false, "每页个数  " )))
					.addNode(new FieldNode("pgtsdt", new MsgField(ContentEnum.MessageType.STRING.toString(),"pgtsdt" ,8,0, false, "页尾交易日期  " )))
					.addNode(new FieldNode("pgblsq", new MsgField(ContentEnum.MessageType.STRING.toString(),"pgblsq" ,30,0, false, "页尾账单流水" )))
					);
			
			return messageNode;			
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	public static class BODHST1084_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf ", new MsgField(ContentEnum.MessageType.STRING.toString(), " Eciorgbuf " , 1024 ,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("erorcd ", new MsgField(ContentEnum.MessageType.STRING.toString(), " erorcd " , 8 ,0, false, "错误代码" )))
					.addNode(new FieldNode("pckgsq ", new MsgField(ContentEnum.MessageType.STRING.toString(), " pckgsq " , 20 ,0, false, "包流水" )))
					.addNode(new FieldNode("erortx ", new MsgField(ContentEnum.MessageType.STRING.toString(), " erortx " , 100 ,0, false, "错误信息" )))
					.addNode(new FieldNode("listnm ", new MsgField(ContentEnum.MessageType.STRING.toString(), " listnm " , 8 ,0, false, "本次返回记录数" )))
					.addNode(new StructNode("bodrcd",true)
								.addNode(new FieldNode("trandt ", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt" , 100,0, false, "交易日期" )))
								.addNode(new FieldNode("transq ", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq" , 100,0, false, "交易流水" )))
								.addNode(new FieldNode("billsq ", new MsgField(ContentEnum.MessageType.STRING.toString(), "billsq" , 21,0, false, "账单流水" )))
								.addNode(new FieldNode("acctno ", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno" , 21,0, false, "账号" )))
								.addNode(new FieldNode("drtsam ", new MsgField(ContentEnum.MessageType.STRING.toString(), "drtsam" , 8,0, false, "借方金额" )))
								.addNode(new FieldNode("crtsam ", new MsgField(ContentEnum.MessageType.STRING.toString(), "crtsam" , 20,0, false, "贷方金额 " )))
								.addNode(new FieldNode("tranbl ", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranbl" , 25,0, false, "余额" )))
								.addNode(new FieldNode("trantp ", new MsgField(ContentEnum.MessageType.STRING.toString(), "trantp" , 16,0, false, "交易类型" )))
								.addNode(new FieldNode("smrycd ", new MsgField(ContentEnum.MessageType.STRING.toString(), "smrycd" , 3,0, false, "备注" )))
								.addNode(new FieldNode("dcmtno ", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcmtno" , 6,0, false, "凭证号" )))
								.addNode(new FieldNode("dcmttp ", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcmttp" , 34,0, false, "凭证类型" )))
								.addNode(new FieldNode("bookus ", new MsgField(ContentEnum.MessageType.STRING.toString(), "bookus" , 20,0, false, "记账柜员" )))
								.addNode(new FieldNode("ckbkus ", new MsgField(ContentEnum.MessageType.STRING.toString(), "ckbkus" , 25,0, false, "复核柜员" )))
								.addNode(new FieldNode("tranbr ", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranbr" , 16,0, false, "交易机构" )))
								.addNode(new FieldNode("toacct ", new MsgField(ContentEnum.MessageType.STRING.toString(), "toacct" , 3,0, false, "对方账号" )))
								.addNode(new FieldNode("toacna ", new MsgField(ContentEnum.MessageType.STRING.toString(), "toacna" , 6,0, false, "对方账户名" )))
								.addNode(new FieldNode("transt ", new MsgField(ContentEnum.MessageType.STRING.toString(), "transt" , 34,0, false, "交易状态" )))
								.addNode(new FieldNode("acctna ", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctna" , 6,0, false, "账户名" )))
								.addNode(new FieldNode("csextg ", new MsgField(ContentEnum.MessageType.STRING.toString(), "csextg" , 34,0, false, "汇钞标志" )))
								.addNode(new FieldNode("dscrtx ", new MsgField(ContentEnum.MessageType.STRING.toString(), "dscrtx" , 100,0, false, "交易信息" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
