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
 * BASESVC BODHST1085   单位账户信息综合查询(列表查询) 
 *  BODHST1085 
 *  旧核心系统
 * @author YFK
 */
@Component
public class BODHST1085 extends EciChannelService{

	private static BODHST1085_I i = new BODHST1085_I();
	private static BODHST1085_O o = new BODHST1085_O();
	public BODHST1085() {
		requestFormat.add(i);
		responseFormat.add(o);		
	}
	
	public static class BODHST1085_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
			.addNode(new FieldNode("Eciorgbuf",new MsgField(ContentEnum.MessageType.STRING.toString(),"Eciorgbuf" ,1024,0, false, "渠道备注信息" )))
			.addNode(new FieldNode("qracno",new MsgField(ContentEnum.MessageType.STRING.toString(),"qracno" ,16,0, false, "账号" )))
			.addNode(new FieldNode("qrcuno",new MsgField(ContentEnum.MessageType.STRING.toString(),"qrcuno" ,3,0, false, "客户号" )))
			.addNode(new FieldNode("qrcuna",new MsgField(ContentEnum.MessageType.STRING.toString(),"qrcuna" ,6,0, false, "客户名称" )))
			.addNode(new FieldNode("qracst",new MsgField(ContentEnum.MessageType.STRING.toString(),"qracst" ,2,0, false, "账户状态" )))
			.addNode(new FieldNode("idtftp",new MsgField(ContentEnum.MessageType.STRING.toString(),"idtftp" ,3,0, false, "证件类型" )))
			.addNode(new FieldNode("idtfno",new MsgField(ContentEnum.MessageType.STRING.toString(),"idtfno" ,30,0, false, "证件号码" )))
			.addNode(new FieldNode("lfflag",new MsgField(ContentEnum.MessageType.STRING.toString(),"lfflag" ,1,0, false, "本外币查询标志" )))
			.addNode(new FieldNode("rcrdnm",new MsgField(ContentEnum.MessageType.STRING.toString(),"rcrdnm" ,21,0, false, "每页个数" )))
			.addNode(new FieldNode("indxno",new MsgField(ContentEnum.MessageType.STRING.toString(),"indxno" ,21,0, false, "页尾序号" )))
			.addNode(new FieldNode("pgqrac",new MsgField(ContentEnum.MessageType.STRING.toString(),"pgqrac" ,20,0, false, "页尾账号" )))
			.addNode(new FieldNode("pgqrsb",new MsgField(ContentEnum.MessageType.STRING.toString(),"pgqrsb" ,20,0, false, "页尾子户号" )))
			);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	

	public static class BODHST1085_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf",new MsgField(ContentEnum.MessageType.STRING.toString(),"Eciorgbuf" ,1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("erorcd",new MsgField(ContentEnum.MessageType.STRING.toString(),"erorcd" ,8,0, false, "错误代码" )))
					.addNode(new FieldNode("pckgsq",new MsgField(ContentEnum.MessageType.STRING.toString(),"pckgsq" ,20,0, false, "包流水" )))
					.addNode(new FieldNode("erortx",new MsgField(ContentEnum.MessageType.STRING.toString(),"erortx" ,100,0, false, "错误信息" )))
					.addNode(new FieldNode("listnm",new MsgField(ContentEnum.MessageType.STRING.toString(),"listnm" ,8,0, false, "本次返回记录数" )))
					.addNode(new StructNode("bodrcd",true)
					.addNode(new FieldNode("custno",new MsgField(ContentEnum.MessageType.STRING.toString(),"custno" ,8,0, false, "客户号" )))
					.addNode(new FieldNode("acctno",new MsgField(ContentEnum.MessageType.STRING.toString(),"acctno" ,20,0, false, "账号" )))
					.addNode(new FieldNode("acctna",new MsgField(ContentEnum.MessageType.STRING.toString(),"acctna" ,25,0, false, "账户名" )))
					.addNode(new FieldNode("dcmttp",new MsgField(ContentEnum.MessageType.STRING.toString(),"dcmttp" ,16,0, false, "凭证类型" )))
					.addNode(new FieldNode("dcmtno",new MsgField(ContentEnum.MessageType.STRING.toString(),"dcmtno" ,3,0, false, "凭证号码" )))
					.addNode(new FieldNode("dtittp",new MsgField(ContentEnum.MessageType.STRING.toString(),"dtittp" ,6,0, false, "业务种类" )))
					.addNode(new FieldNode("crcycd",new MsgField(ContentEnum.MessageType.STRING.toString(),"crcycd" ,34,0, false, "币种" )))
					.addNode(new FieldNode("csextg",new MsgField(ContentEnum.MessageType.STRING.toString(),"csextg" ,100,0, false, "钞汇标志" )))
					.addNode(new FieldNode("termcd",new MsgField(ContentEnum.MessageType.STRING.toString(),"termcd" ,3,0, false, "存期" )))
					.addNode(new FieldNode("onlnbl",new MsgField(ContentEnum.MessageType.STRING.toString(),"onlnbl" ,21,0, false, "联机余额" )))
					.addNode(new FieldNode("acctst",new MsgField(ContentEnum.MessageType.STRING.toString(),"acctst" ,34,0, false, "账户状态" )))
					.addNode(new FieldNode("brchno",new MsgField(ContentEnum.MessageType.STRING.toString(),"brchno" ,100,0, false, "账户机构" )))
					.addNode(new FieldNode("crrldp",new MsgField(ContentEnum.MessageType.STRING.toString(),"crrldp" ,3,0, false, "关联凭证类型" )))
					.addNode(new FieldNode("crrldc",new MsgField(ContentEnum.MessageType.STRING.toString(),"crrldc" ,21,0, false, "关联凭证号码" )))
					.addNode(new FieldNode("indxno",new MsgField(ContentEnum.MessageType.STRING.toString(),"indxno" ,24,0, false, "序号" )))
					.addNode(new FieldNode("custna",new MsgField(ContentEnum.MessageType.STRING.toString(),"custna" ,21,0, false, "客户名称" )))
					.addNode(new FieldNode("nra_ac",new MsgField(ContentEnum.MessageType.STRING.toString(),"nra_ac" ,24,68, false, "NRA账号" )))
					.addNode(new FieldNode("debttp",new MsgField(ContentEnum.MessageType.STRING.toString(),"debttp" ,3,69, false, "储种" )))
					.addNode(new FieldNode("subsac",new MsgField(ContentEnum.MessageType.STRING.toString(),"subsac" ,20,70, false, "子户号" )))
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
}
