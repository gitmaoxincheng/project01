package cn.com.agree.huanan.ap.al.io.service.eci.nib;

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
 * BASESVC BODNIB0136  缴费支付 
 *  BODNIB0136 regflw
 *  新个人网银
 * @author XZF
 */
@Component
public class BODNIB0136 extends EciChannelService {

	private static BODNIB0136_I i = new BODNIB0136_I();
	private static BODNIB0136_O o = new BODNIB0136_O();
	public BODNIB0136() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNIB0136_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("billingno", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingno", 1024,0, true, "缴费编号" )))
					.addNode(new FieldNode("ruleamount", new MsgField(ContentEnum.MessageType.STRING.toString(), "ruleamount", 1024,0, true, "缴费金额" )))
					.addNode(new FieldNode("payaccno", new MsgField(ContentEnum.MessageType.STRING.toString(), "payaccno", 1024,0, true, "付款账号" )))
					.addNode(new FieldNode("payaccname", new MsgField(ContentEnum.MessageType.STRING.toString(), "payaccname", 1024,0, true, "付款账号户名" )))
					.addNode(new FieldNode("paybankno", new MsgField(ContentEnum.MessageType.STRING.toString(), "paybankno", 1024,0, true, "付款账号网点" )))
					.addNode(new FieldNode("paychannel", new MsgField(ContentEnum.MessageType.STRING.toString(), "paychannel", 1024,0, true, "缴费渠道" )))
					.addNode(new FieldNode("zoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "zoneno", 1024,0, true, "操作分行" )))
					.addNode(new FieldNode("mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mbrno", 1024,0, true, "操作支行" )))
					.addNode(new FieldNode("csbxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "csbxno", 1024,0, true, "柜员钱箱号" )))
					.addNode(new FieldNode("tellertp", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellertp", 1024,0, true, "柜员类别" )))
					.addNode(new FieldNode("dutytp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutytp", 1024,0, true, "岗位类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODNIB0136_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("payaccno", new MsgField(ContentEnum.MessageType.STRING.toString(), "payaccno", 1024,0, true, "付款方账号" )))
					.addNode(new FieldNode("payaccname", new MsgField(ContentEnum.MessageType.STRING.toString(), "payaccname", 1024,0, true, "付款方账户名称" )))
					.addNode(new FieldNode("recaccno", new MsgField(ContentEnum.MessageType.STRING.toString(), "recaccno", 1024,0, true, "收款方账号" )))
					.addNode(new FieldNode("recaccname", new MsgField(ContentEnum.MessageType.STRING.toString(), "recaccname", 1024,0, true, "收款方账户名称" )))
					.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "amount", 1024,0, true, "交易金额" )))
					.addNode(new FieldNode("hosterror", new MsgField(ContentEnum.MessageType.STRING.toString(), "hosterror", 1024,0, true, "主机返回码" )))
					.addNode(new FieldNode("hosterrormsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "hosterrormsg", 1024,0, true, "主机返回错误信息" )))
					.addNode(new FieldNode("hostflowno", new MsgField(ContentEnum.MessageType.STRING.toString(), "hostflowno", 1024,0, true, "主机交易流水号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

