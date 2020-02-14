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
 * C013001101 个人客户产品推荐信息查询
 * @author lf
 *
 */
@Component
public class C013001101 extends EsbChannelService{

	private static C013001101_I i = new C013001101_I();
	private static C013001101_O o = new C013001101_O();
	public C013001101() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013001101_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)

		.addNode(new FieldNode("custid",new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, true, "客户号" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C013001101_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("contrsize", new MsgField(ContentEnum.MessageType.STRING.toString(), "contrsize",10,0, false, "返回记录数" )))
					.addNode(new ArrayNode("signinfo_list",false)
							.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid",32,0, false, "客户编号" )))
							.addNode(new FieldNode("marketingid", new MsgField(ContentEnum.MessageType.STRING.toString(), "marketingid",32,0, false, "商机编号" )))
							.addNode(new FieldNode("mainorg", new MsgField(ContentEnum.MessageType.STRING.toString(), "mainorg",12,0, true, "主办机构" )))
							.addNode(new FieldNode("mainmgr", new MsgField(ContentEnum.MessageType.STRING.toString(), "mainmgr",20,0,false,"主办客户经理" )))
							.addNode(new FieldNode("prodtypeid", new MsgField(ContentEnum.MessageType.STRING.toString(), "prodtypeid",32,0,false,"产品类型编号" )))
							.addNode(new FieldNode("marketclue", new MsgField(ContentEnum.MessageType.STRING.toString(), "marketclue",3000,0,false,"营销线索" )))
							.addNode(new FieldNode("marketwords", new MsgField(ContentEnum.MessageType.STRING.toString(),"marketwords",2000,0,false,"营销话术" )))
							.addNode(new FieldNode("createdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "createdate",8,0,false,"生成时间" )))
							.addNode(new FieldNode("lastmarketstate", new MsgField(ContentEnum.MessageType.STRING.toString(), "lastmarketstate",20,0,false,"上次商机状态" )))
							.addNode(new FieldNode("lastfactdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "lastfactdate",8,0,false,"上次反馈时间" )))
							
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}


