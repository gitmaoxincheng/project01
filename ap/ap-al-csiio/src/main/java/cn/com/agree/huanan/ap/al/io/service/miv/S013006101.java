package cn.com.agree.huanan.ap.al.io.service.miv;

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
 * BASESVC.S013006101 联网核查企业信息查询.工商登记联网核查 
 * S0130061.01 043708
 * 0437 企业信息联网核查模块
 * @author XZF
 */
@Component
public class S013006101 extends EsbChannelService {

	private static S013006101_I i = new S013006101_I();
	private static S013006101_O o = new S013006101_O();
	public S013006101() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013006101_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("entitype", new MsgField(ContentEnum.MessageType.STRING.toString(), "entitype", 1,0, true, "单位类型" )))
					.addNode(new FieldNode("entityname", new MsgField(ContentEnum.MessageType.STRING.toString(), "entityname", 100,0, false, "字号名称" )))
					.addNode(new FieldNode("unisoccdtcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "unisoccdtcd", 18,0, true, "统一社会信用代码" )))
					.addNode(new FieldNode("lawcna", new MsgField(ContentEnum.MessageType.STRING.toString(), "lawcna", 140,0, true, "经营者姓名" )))
					.addNode(new FieldNode("lwidno", new MsgField(ContentEnum.MessageType.STRING.toString(), "lwidno", 30,0, true, "经营者证件号" )))
					.addNode(new FieldNode("agcuna", new MsgField(ContentEnum.MessageType.STRING.toString(), "agcuna", 140,0, false, "代理人姓名" )))
					.addNode(new FieldNode("agidno", new MsgField(ContentEnum.MessageType.STRING.toString(), "agidno", 30,0, false, "代理人证件号码" )))
					.addNode(new FieldNode("operatorna", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatorna", 140,0, true, "操作员姓名" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S013006101_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("transt", new MsgField(ContentEnum.MessageType.STRING.toString(), "transt", 1,0, true, "受理状态" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

