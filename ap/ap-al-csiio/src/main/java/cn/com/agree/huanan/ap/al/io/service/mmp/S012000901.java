package cn.com.agree.huanan.ap.al.io.service.mmp;

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
 * BASESVC.S012000901 设备管理.设备信息保存 
 * S0120009.01 savefi
 * 0104 移动营销系统
 * @author XZF
 */
@Component
public class S012000901 extends EsbChannelService {

	private static S012000901_I i = new S012000901_I();
	private static S012000901_O o = new S012000901_O();
	public S012000901() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S012000901_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("EQUIPMENT_TYPE", new MsgField(ContentEnum.MessageType.STRING.toString(), "EQUIPMENT_TYPE", 20,0, true, "自助设备类型" )))
					.addNode(new FieldNode("EQUIPMENT_NO", new MsgField(ContentEnum.MessageType.STRING.toString(), "EQUIPMENT_NO", 20,0, true, "设备编号" )))
					.addNode(new FieldNode("TranBr", new MsgField(ContentEnum.MessageType.STRING.toString(), "TranBr", 8,0, true, "交易机构" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S012000901_O extends MsgBody {
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

