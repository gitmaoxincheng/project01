package cn.com.agree.huanan.ap.al.io.service.bpm;

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
 * BASESVC.S013003404 系统操作员信息查询.应用系统操作员认证方式查询 
 * S0130034.04 sysoper_lgconf_query
 * 0321 参数管理平台
 * @author CZP
 */
@Component
public class S013003404 extends EsbChannelService {

	private static S013003404_I i = new S013003404_I();
	private static S013003404_O o = new S013003404_O();

	public S013003404() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013003404_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("sysid", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysid", 4,0, true, "系统编号" )))
					.addNode(new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno", 10,0, true, "操作员号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S013003404_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("pwdtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "pwdtp", 10,0, true, "认证类型" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
