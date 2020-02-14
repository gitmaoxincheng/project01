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
 * BASESVC BODHST1100   对公账户账单查询
 *  BODHST1100 
 *  旧核心系统
 * @author YFK
 */
@Component
public class BODHST1100 extends EciChannelService{

	private static BODHST1100_I i = new BODHST1100_I();
	private static BODHST1100_O o = new BODHST1100_O();
	public BODHST1100() {
		requestFormat.add(i);
		responseFormat.add(o);		
	}
	
	public static class BODHST1100_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf",  new MsgField(ContentEnum.MessageType.STRING.toString(),"Eciorgbuf",  1024,0, false, "渠道备注信息 " )))
					.addNode(new FieldNode("rcrdnm",  new MsgField(ContentEnum.MessageType.STRING.toString(),"rcrdnm",  16,0, false, "返回结果记录数 " )))
					.addNode(new FieldNode("acctno",  new MsgField(ContentEnum.MessageType.STRING.toString(),"acctno",  3,0, false, "账号" )))
					.addNode(new FieldNode("bgtsdt",  new MsgField(ContentEnum.MessageType.STRING.toString(),"bgtsdt",  6,0, false, "起始交易日期 " )))
					.addNode(new FieldNode("edtsdt",  new MsgField(ContentEnum.MessageType.STRING.toString(),"edtsdt",  2,0, false, "结束交易日期 " )))
					.addNode(new FieldNode("bgtram",  new MsgField(ContentEnum.MessageType.STRING.toString(),"bgtram",  21,0, false, "起始金额 " )))
					.addNode(new FieldNode("edtram",  new MsgField(ContentEnum.MessageType.STRING.toString(),"edtram",  21,0, false, "结束金额 " )))
					.addNode(new FieldNode("occurs",  new MsgField(ContentEnum.MessageType.STRING.toString(),"occurs",  2,0, false, "交易方向 " )))
					.addNode(new FieldNode("toacct",  new MsgField(ContentEnum.MessageType.STRING.toString(),"toacct",  21,0, false, "对方账号" )))
					.addNode(new FieldNode("pgtsdt",  new MsgField(ContentEnum.MessageType.STRING.toString(),"pgtsdt",  21,0, false, "翻页日期" )))
					.addNode(new FieldNode("pgblsq",  new MsgField(ContentEnum.MessageType.STRING.toString(),"pgblsq",  8,0, false, "翻页账单号" )))
					);
			
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	public static class BODHST1100_O extends MsgBody{
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf",new MsgField(ContentEnum.MessageType.STRING.toString(),"Eciorgbuf" ,1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("erorcd",new MsgField(ContentEnum.MessageType.STRING.toString(),"erorcd" ,8,0, false, "错误代码" )))
					.addNode(new FieldNode("pckgsq",new MsgField(ContentEnum.MessageType.STRING.toString(),"pckgsq" ,20,0, false, "包流水" )))
					.addNode(new FieldNode("erortx",new MsgField(ContentEnum.MessageType.STRING.toString(),"erortx" ,100,0, false, "错误信息" )))
					.addNode(new FieldNode("listnm",new MsgField(ContentEnum.MessageType.STRING.toString(),"listnm" ,8,0, false, "本次返回记录数" )))
					.addNode(new FieldNode("totnum",new MsgField(ContentEnum.MessageType.STRING.toString(),"totnum" ,8,0, false, "记录总数" )))
					.addNode(new FieldNode("onlnbl",new MsgField(ContentEnum.MessageType.STRING.toString(),"onlnbl" ,8,0, false, "最后余额" )))
					.addNode(new StructNode("bodrcd",true)
					.addNode(new FieldNode("trandt",new MsgField(ContentEnum.MessageType.STRING.toString(),"trandt" ,100,0, false, "交易日期" )))
					.addNode(new FieldNode("tranti",new MsgField(ContentEnum.MessageType.STRING.toString(),"tranti" ,100,0, false, "交易时间" )))
					.addNode(new FieldNode("transq",new MsgField(ContentEnum.MessageType.STRING.toString(),"transq" ,100,0, false, "交易流水号" )))
					.addNode(new FieldNode("billsq",new MsgField(ContentEnum.MessageType.STRING.toString(),"billsq" ,21,0, false, "账单流水号" )))
					.addNode(new FieldNode("smrycd",new MsgField(ContentEnum.MessageType.STRING.toString(),"smrycd" ,21,0, false, "摘要" )))
					.addNode(new FieldNode("trantp",new MsgField(ContentEnum.MessageType.STRING.toString(),"trantp" ,8,0, false, "交易类型" )))
					.addNode(new FieldNode("occurs",new MsgField(ContentEnum.MessageType.STRING.toString(),"occurs" ,20,0, false, "借贷方向" )))
					.addNode(new FieldNode("tranam",new MsgField(ContentEnum.MessageType.STRING.toString(),"tranam" ,25,0, false, "发生额" )))
					.addNode(new FieldNode("tranbl",new MsgField(ContentEnum.MessageType.STRING.toString(),"tranbl" ,16,0, false, "余额" )))
					.addNode(new FieldNode("dcmttp",new MsgField(ContentEnum.MessageType.STRING.toString(),"dcmttp" ,3,0, false, "凭证种类" )))
					.addNode(new FieldNode("dcmtno",new MsgField(ContentEnum.MessageType.STRING.toString(),"dcmtno" ,6,0, false, "凭证号码" )))
					.addNode(new FieldNode("toacct",new MsgField(ContentEnum.MessageType.STRING.toString(),"toacct" ,34,0, false, "对方账号" )))
					.addNode(new FieldNode("toacna",new MsgField(ContentEnum.MessageType.STRING.toString(),"toacna" ,20,0, false, "对方户名" )))
					.addNode(new FieldNode("transt",new MsgField(ContentEnum.MessageType.STRING.toString(),"transt" ,25,0, false, "交易状态" )))					
					));
			
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
}
