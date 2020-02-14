package cn.com.agree.huanan.ap.al.io.service.enc;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * TRDCENTER.C012000701 客户信息核查.同手机号多客户号核查 
 * C0120007.01 ECIF010
 * 0337 企业级客户信息管理系统
 * @author XZF
 */
@Component
public class C012000701 extends EsbChannelService {

	private static C012000701_I i = new C012000701_I();
	private static C012000701_O o = new C012000701_O();
	public C012000701() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C012000701_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("custinfo",false)
							.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, true, "客户号" )))
							.addNode(new FieldNode("mobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobile", 20,0, true, "手机号码" )))
							.addNode(new FieldNode("samecustflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "samecustflag", 1,0, true, "同号多客户标志" )))
							.addNode(new FieldNode("samecustres", new MsgField(ContentEnum.MessageType.STRING.toString(), "samecustres", 200,0, true, "同号多客户原因" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C012000701_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("samecustinfo",false)
							.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, false, "客户号" )))
							.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 256,0, false, "客户名称" )))
							.addNode(new FieldNode("identtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "identtype", 3,0, false, "证件类型" )))
							.addNode(new FieldNode("identno", new MsgField(ContentEnum.MessageType.STRING.toString(), "identno", 30,0, false, "证件号码" )))
							.addNode(new FieldNode("mobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobile", 20,0, false, "手机号码" )))
							.addNode(new FieldNode("sameflagbf", new MsgField(ContentEnum.MessageType.STRING.toString(), "sameflagbf", 1,0, false, "同号多客户标志（修改前）" )))
							.addNode(new FieldNode("sameflagaf", new MsgField(ContentEnum.MessageType.STRING.toString(), "sameflagaf", 1,0, false, "同号多客户标志（修改后）" )))
							.addNode(new FieldNode("samecustres", new MsgField(ContentEnum.MessageType.STRING.toString(), "samecustres", 200,0, false, "同号多客户原因" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
