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
 * BODAFA1558 财税库税单查询
 * @author YFK 
 */
@Component
public class BODAFA1558 extends EciChannelService{

	private static BODAFA1558_I i = new BODAFA1558_I();
	private static BODAFA1558_O o = new BODAFA1558_O();
	public BODAFA1558() {
        requestFormat.add(i);
        responseFormat.add(o);
	}
	
	//i
	public static class BODAFA1558_I extends MsgBody{

		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
					messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("startdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "startdate", 8,0, false, "开始日期" )))
					.addNode(new FieldNode("enddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "enddate", 8,0, false, "结束日期" )))
					.addNode(new FieldNode("payeracc", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeracc", 32,0, false, "付款人账号" )))
					.addNode(new FieldNode("printflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "printflag", 1,0, false, "打印标志" )))
					.addNode(new FieldNode("pageflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageflag", 1,0, false, "翻页标识" )))
					.addNode(new FieldNode("maxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxnum", 10,0, false, "查询记录数" )))
					.addNode(new FieldNode("idxauptradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxauptradedate", 8,0, false, "后续前置日期" )))
					.addNode(new FieldNode("idxaupserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxaupserialno", 30,0, false, "翻页记录流水号" )))
					);
						
			return messageNode;
		}
		
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
	
	
	//o
	public static class BODAFA1558_O extends MsgBody{

		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
							.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 10,0, false, "返回记录数" )))
							.addNode(new ArrayNode("bodrcd",false)
									.addNode(new FieldNode("auptradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "auptradedate", 8,0, false, "前置日期" )))
									.addNode(new FieldNode("aupserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "aupserialno", 30,0, false, "前置流水" )))
									.addNode(new FieldNode("sysid", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysid", 10,0, false, "系统流水" )))
				    				.addNode(new FieldNode("difflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "difflag", 10,0, false, "应用标识" )))
				    				.addNode(new FieldNode("userno", new MsgField(ContentEnum.MessageType.STRING.toString(), "userno", 30,0, false, "纳税人识别号" )))
				    				.addNode(new FieldNode("username", new MsgField(ContentEnum.MessageType.STRING.toString(), "username", 200,0, false, "纳税人全称" )))
				    				.addNode(new FieldNode("payername", new MsgField(ContentEnum.MessageType.STRING.toString(), "payername", 200,0, false, "付款人全称" )))
				    				.addNode(new FieldNode("payeracc", new MsgField(ContentEnum.MessageType.STRING.toString(), "payeracc", 32,0, false, "付款人账号" )))
				    				.addNode(new FieldNode("payerbank", new MsgField(ContentEnum.MessageType.STRING.toString(), "payerbank", 20,0, false, "付款人开户银行" )))
				    				.addNode(new FieldNode("sender", new MsgField(ContentEnum.MessageType.STRING.toString(), "sender", 20,0, false, "征收机关名称" )))
				    				.addNode(new FieldNode("sendbankname", new MsgField(ContentEnum.MessageType.STRING.toString(), "sendbankname", 200,0, false, "收款国库（银行）名称" )))
				    				.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "amount", 17,0, false, "金额" )))
				    				.addNode(new FieldNode("vouchno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vouchno", 20,0, false, "税票号码" )))
				    				.addNode(new FieldNode("prtnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "prtnum", 10,0, false, "打印次数" )))
				    				));
					
			return messageNode;
		}
		
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
	
}
