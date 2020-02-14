package cn.com.agree.huanan.ap.al.io.service.eci.hst;

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
 * BASESVC BODHST1357  随心存产品提前支取 
 *  BODHST1357 
 *  旧核心系统
 * @author XZF
 */
@Component
public class BODHST1357 extends EciChannelService {

	private static BODHST1357_I i = new BODHST1357_I();
	private static BODHST1357_O o = new BODHST1357_O();
	public BODHST1357() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODHST1357_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 20,0, false, "随心存账号" )))
					.addNode(new FieldNode("subsac", new MsgField(ContentEnum.MessageType.STRING.toString(), "subsac", 6,0, false, "子账户号" )))
					.addNode(new FieldNode("signat", new MsgField(ContentEnum.MessageType.STRING.toString(), "signat", 3,0, false, "认购账户" )))
					.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "tranam", 18,2, false, "交易金额" )))
					.addNode(new FieldNode("drawfs", new MsgField(ContentEnum.MessageType.STRING.toString(), "drawfs", 1,0, false, "支取方式" )))
					.addNode(new FieldNode("tranpw", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranpw", 20,0, false, "交易密码" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 1,0, true, "是否需要转密" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 50,0, false, "密钥序号" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 50,0, false, "密码的来源" )))
					.addNode(new FieldNode("zacctno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zacctno1", 50,0, false, "第一个密码所涉及的账号指针" )))
					.addNode(new FieldNode("zpwdfd1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfd1", 50,0, false, "第一个密码密文指针" )))
					.addNode(new FieldNode("zdcmttp1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmttp1", 50,0, false, "第一个密码涉及账号的凭证类型指针" )))
					.addNode(new FieldNode("zdcmtno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmtno1", 50,0, false, "第一个密码涉及账号的凭证号码指针" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODHST1357_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("trandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt", 8,0, false, "交易日期" )))
					.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 20,0, false, "交易流水" )))
					.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq", 20,0, false, "报文流水" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 300,0, false, "出错信息" )))
					.addNode(new FieldNode("script", new MsgField(ContentEnum.MessageType.STRING.toString(), "script", 1000,0, false, "出错脚本" )))
					.addNode(new ArrayNode("listnm",false)
							).addNode(new StructNode("bodrcd",true)
									.addNode(new FieldNode("instam", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "instam", 18,2, false, "结息金额" )))
									.addNode(new FieldNode("instrt", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "instrt", 11,7, false, "利率" )))
									.addNode(new FieldNode("stdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "stdate", 8,0, false, "起息日" )))
									.addNode(new FieldNode("eddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "eddate", 1024,0, false, "到期日" )))
									.addNode(new FieldNode("acmlbl", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "acmlbl", 18,2, false, "积数" )))
									));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

