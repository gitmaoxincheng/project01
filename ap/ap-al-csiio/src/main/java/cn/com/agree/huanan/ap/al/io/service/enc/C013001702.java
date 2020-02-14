package cn.com.agree.huanan.ap.al.io.service.enc;

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
 * BASESVC.C013001702 客户证件期限信息查询.个人客户证件过期日期信息查询 
 * C0130017.02 ECIF117
 * 0337 企业级客户信息管理系统
 * @author XZF
 */
@Component
public class C013001702 extends EsbChannelService {

	private static C013001702_I i = new C013001702_I();
	private static C013001702_O o = new C013001702_O();
	public C013001702() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013001702_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, true, "客户号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C013001702_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("identexpireddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "identexpireddate", 8,0, false, "证件失效日期" )))
					.addNode(new FieldNode("busirestrictdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "busirestrictdate", 8,0, false, "非柜面业务限制日期" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

