package cn.com.agree.huanan.ap.al.io.service.sbc;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbSbcChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P061000101 缴费管理.易缴通缴费 
 * P0610001.01 TS1001
 * 0212 金融互联网服务平台
 * @author LW
 */
@Component
public class P061000101 extends EsbSbcChannelService {
	/*


	*/
	private static P061000101_I i = new P061000101_I();
	private static P061000101_O o = new P061000101_O();
	public P061000101() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P061000101_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cstnumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstnumber", 50,0, false, "缴费人标识" )))
					.addNode(new FieldNode("merid", new MsgField(ContentEnum.MessageType.STRING.toString(), "merid", 100,0, false, "商户id" )))
					.addNode(new FieldNode("paychannel", new MsgField(ContentEnum.MessageType.STRING.toString(), "paychannel", 4,0, false, "缴费渠道" )))
					.addNode(new FieldNode("payer", new MsgField(ContentEnum.MessageType.STRING.toString(), "payer", 255,0, false, "缴费人" )))
					.addNode(new FieldNode("phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone", 20,0, false, "手机号" )))
					.addNode(new FieldNode("payaccountno", new MsgField(ContentEnum.MessageType.STRING.toString(), "payaccountno", 40,0, false, "付款账户" )))
					.addNode(new FieldNode("payaccountname", new MsgField(ContentEnum.MessageType.STRING.toString(), "payaccountname", 256,0, false, "付款账户名" )))
					.addNode(new FieldNode("payaccounttnode", new MsgField(ContentEnum.MessageType.STRING.toString(), "payaccounttnode", 12,0, false, "付款账户所属网点" )))
					.addNode(new FieldNode("operator", new MsgField(ContentEnum.MessageType.STRING.toString(), "operator", 255,0, false, "操作人员" )))
					.addNode(new ArrayNode("paylist_list",false)
							.addNode(new FieldNode("ordid", new MsgField(ContentEnum.MessageType.STRING.toString(), "ordid", 100,0, false, "订单id" )))
							)
					.addNode(new FieldNode("vm_tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_tellerno", 10,0, false, "虚拟柜员" )))
					.addNode(new FieldNode("vm_brno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_brno", 12,0, false, "虚拟柜员操作网点" )))
					.addNode(new FieldNode("vm_csbxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_csbxno", 20,0, false, "虚拟柜员钱箱" )))
					.addNode(new FieldNode("vm_zoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_zoneno", 20,0, false, "虚拟柜员操作分行" )))
					.addNode(new FieldNode("vm_mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_mbrno", 12,0, false, "虚拟柜员操作支行" )))
					.addNode(new FieldNode("vm_dutytp", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_dutytp", 20,0, false, "虚拟柜员岗位类型" )))
					.addNode(new FieldNode("vm_tellertp", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_tellertp", 10,0, false, "虚拟柜员柜员类别" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P061000101_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

