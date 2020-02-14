package cn.com.agree.huanan.ap.al.io.service.pls;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.S013001901 PDF模块交易查询.PDF电子签名（场景证书签章） 
 * S0130019.01 cfca1002
 * 0221 无纸化电子签名系统
 * @author YYX
 */
@Component
public class S013001901 extends EsbChannelService {

	private static S013001901_I i = new S013001901_I();
	private static S013001901_O o = new S013001901_O();
       
	public S013001901() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013001901_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("BizSerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BizSerialNo", 256,0, true, "交易流水号" )))
					.addNode(new FieldNode("ChannelSerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ChannelSerialNo", 40,0, false, "渠道流水号（单据号）" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S013001901_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("RetCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "RetCode", 30,0, true, "合成状态" )))
					.addNode(new FieldNode("RetMsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "RetMsg", 300,0, true, "返回信息" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
