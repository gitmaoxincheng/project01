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
 * BODHST1247 密码转密/密钥获取
 * @author HWW 
 */
@Component
public class BODHST1247 extends EciChannelService{

	private static BODHST1247_I i = new BODHST1247_I();
	private static BODHST1247_O o = new BODHST1247_O();
	public BODHST1247() {
        requestFormat.add(i);
        responseFormat.add(o);
	}
	
	public static class BODHST1247_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
			.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
				.addNode(new FieldNode("ylncmd", new MsgField(ContentEnum.MessageType.STRING.toString(), "ylncmd", 3,0, false, "操作类型" )))
				.addNode(new FieldNode("pwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "pwdfrm", 20,0, false, "密码来源" )))
				.addNode(new FieldNode("tranto", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranto", 20,0, false, "目标系统" )))
				.addNode(new FieldNode("passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "passwd", 512,0, false, "原密码" )))
				.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 50,0, false, "账户号" )))
				.addNode(new FieldNode("chkval", new MsgField(ContentEnum.MessageType.STRING.toString(), "chkval", 80,0, false, "校验值" )))
				.addNode(new FieldNode("atmno", new MsgField(ContentEnum.MessageType.STRING.toString(), "atmno", 80,0, false, "终端号" )))
				.addNode(new FieldNode("dcmttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcmttp", 3,0, false, "凭证种类" )))
				.addNode(new FieldNode("dcmtno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcmtno", 20,0, false, "凭证号码" )))
				.addNode(new FieldNode("mactim", new MsgField(ContentEnum.MessageType.STRING.toString(), "mactim", 20,0, false, "时间" )))
				.addNode(new FieldNode("winame", new MsgField(ContentEnum.MessageType.STRING.toString(), "winame", 80,0, false, "窗口名" )))
				.addNode(new FieldNode("borndt", new MsgField(ContentEnum.MessageType.STRING.toString(), "borndt", 10,0, false, "出生日期" )))
				.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl", 20,0, false, "客户的联系电话" )))
				.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 2,0, false, "客户证件类型" )))
				.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 40,0, false, "客户的证件号码号码" )))
			);
			
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
	
	public static class BODHST1247_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
			.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq", 20,0, false, "报文流水" )))
			.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 200,0, false, "出错信息" )))
			.addNode(new FieldNode("ylcomd", new MsgField(ContentEnum.MessageType.STRING.toString(), "ylcomd", 100,0, false, "密码/密钥值" )))
			);
			return messageNode;
		}  
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
}
