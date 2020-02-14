package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;  

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;




/**
 * BASESVC BODAFA1559  税单批量打印 
 * @author YFK
 */
@Component
public class BODAFA1559 extends EciChannelService {

	private static BODAFA1559_I i = new BODAFA1559_I();
	private static BODAFA1559_O o = new BODAFA1559_O();
	public BODAFA1559() {
		requestFormat.add(i);
		responseFormat.add(o);
	}
	
	public static class BODAFA1559_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 3,0, false, "记录数" )))
					.addNode(new ArrayNode("bodrcd",true)
							.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedate", 8,0, false, "前置日期" )))
							.addNode(new FieldNode("serialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "serialno", 30,0, false, "前置流水" )))
					));
			
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	public static class BODAFA1559_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("pckgsq",new MsgField(ContentEnum.MessageType.STRING.toString(),"pckgsq" ,20,0, false, "报文流水" )))
					.addNode(new FieldNode("erortx",new MsgField(ContentEnum.MessageType.STRING.toString(),"erortx" ,300,0, false, "出错信息" )))
					.addNode(new FieldNode("listnm",new MsgField(ContentEnum.MessageType.STRING.toString(),"listnm" ,3,0, false, "记录数" )))
					.addNode(new ArrayNode("bodrcd",true)
							.addNode(new FieldNode("auptradedate",new MsgField(ContentEnum.MessageType.STRING.toString(),"auptradedate" ,8,0, false, "前置日期" )))
							.addNode(new FieldNode("aupserialno",new MsgField(ContentEnum.MessageType.STRING.toString(),"aupserialno" ,30,0, false, "前置流水" )))
							.addNode(new FieldNode("sysid",new MsgField(ContentEnum.MessageType.STRING.toString(),"sysid" ,10,0, false, "系统标识" )))
							.addNode(new FieldNode("difflag",new MsgField(ContentEnum.MessageType.STRING.toString(),"difflag" ,10,0, false, "应用标识" )))
							.addNode(new FieldNode("userno",new MsgField(ContentEnum.MessageType.STRING.toString(),"userno" ,30,0, false, "纳税人识别号" )))
							.addNode(new FieldNode("username",new MsgField(ContentEnum.MessageType.STRING.toString(),"username" ,200,0, false, "纳税人全称" )))
							.addNode(new FieldNode("payername",new MsgField(ContentEnum.MessageType.STRING.toString(),"payername" ,200,0, false, "付款人全称" )))
							.addNode(new FieldNode("payeracc",new MsgField(ContentEnum.MessageType.STRING.toString(),"payeracc" ,32,0, false, "付款人账号" )))
							.addNode(new FieldNode("payerbank",new MsgField(ContentEnum.MessageType.STRING.toString(),"payerbank" ,200,0, false, "付款人开户银行" )))
							.addNode(new FieldNode("sender",new MsgField(ContentEnum.MessageType.STRING.toString(),"sender" ,20,0, false, "征收机关名称" )))
							.addNode(new FieldNode("sendbankname",new MsgField(ContentEnum.MessageType.STRING.toString(),"sendbankname" ,200,0, false, "收款国库（银行）名称" )))
							.addNode(new FieldNode("amount",new MsgField(ContentEnum.MessageType.STRING.toString(),"amount" ,17,0, false, "金额" )))
							.addNode(new FieldNode("vouchno",new MsgField(ContentEnum.MessageType.STRING.toString(),"vouchno" ,20,0, false, "税票号码" )))
							.addNode(new FieldNode("printdate",new MsgField(ContentEnum.MessageType.STRING.toString(),"printdate" ,8,0, false, "打印日期" )))
							.addNode(new FieldNode("printtime",new MsgField(ContentEnum.MessageType.STRING.toString(),"printtime" ,6,0, false, "打印时间" )))
							.addNode(new FieldNode("prtnum",new MsgField(ContentEnum.MessageType.STRING.toString(),"prtnum" ,10,0, false, "打印次数" )))
							.addNode(new FieldNode("sublistnm",new MsgField(ContentEnum.MessageType.STRING.toString(),"sublistnm" ,10,0, false, "返回税种记录数" )))
							.addNode(new FieldNode("taxtype",new MsgField(ContentEnum.MessageType.STRING.toString(),"taxtype" ,200,0, false, "税（费）种名称" )))
							.addNode(new FieldNode("taxlve",new MsgField(ContentEnum.MessageType.STRING.toString(),"taxlve" ,20,0, false, "预算科目代码，预算级次" )))
							.addNode(new FieldNode("taxstartdate",new MsgField(ContentEnum.MessageType.STRING.toString(),"taxstartdate" ,8,0, false, "所属时期起" )))
							.addNode(new FieldNode("taxamt",new MsgField(ContentEnum.MessageType.STRING.toString(),"taxamt" ,17,0, false, "实缴金额" )))
							.addNode(new FieldNode("tranamU",new MsgField(ContentEnum.MessageType.STRING.toString(),"tranamU" ,20,0, false, "交易金额（中文大写）" )))
							.addNode(new FieldNode("entrustdate",new MsgField(ContentEnum.MessageType.STRING.toString(),"entrustdate" ,8,0, false, "委托日期" )))
							.addNode(new FieldNode("entrustmsgid",new MsgField(ContentEnum.MessageType.STRING.toString(),"entrustmsgid" ,20,0, false, "报文流水" )))
							.addNode(new FieldNode("taxenddate",new MsgField(ContentEnum.MessageType.STRING.toString(),"taxenddate" ,8,0, false, "所属时期止" )))
					));
			
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
}
