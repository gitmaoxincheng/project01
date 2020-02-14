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
 * BASESVC.C013000708 客户基本信息查询.排号机排号客户信息查询 
 * C0130007.08 ECIF505
 * 0337 企业级客户信息管理系统
 * @author XZF
 */
@Component
public class C013000708 extends EsbChannelService {

	private static C013000708_I i = new C013000708_I();
	private static C013000708_O o = new C013000708_O();
	public C013000708() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013000708_I extends MsgBody {
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

	public static class C013000708_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("contrsize", new MsgField(ContentEnum.MessageType.STRING.toString(), "contrsize", 10,0, false, "产品编号记录数" )))
					.addNode(new ArrayNode("signinfo_list",false)
							.addNode(new FieldNode("prodtypeid", new MsgField(ContentEnum.MessageType.STRING.toString(), "prodtypeid", 32,0, false, "产品类型编号" )))
					).addNode(new ArrayNode("blinfo_list",false)
							.addNode(new FieldNode("assyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "assyearavg", 18,2, false, "资产年日均" )))
					).addNode(new ArrayNode("custinfo_list",false)
							.addNode(new FieldNode("isloancust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isloancust", 1,0, false, "是否有本行贷款" )))
							.addNode(new FieldNode("hasfundsloan", new MsgField(ContentEnum.MessageType.STRING.toString(), "hasfundsloan", 1,0, false, "是否有公积金贷款" )))
							.addNode(new FieldNode("hassfcg", new MsgField(ContentEnum.MessageType.STRING.toString(), "hassfcg", 1,0, false, "是否有三方存管" )))
							.addNode(new FieldNode("haseccard", new MsgField(ContentEnum.MessageType.STRING.toString(), "haseccard", 1,0, false, "是否持有银联贷记卡" )))
							.addNode(new FieldNode("hasvisacard", new MsgField(ContentEnum.MessageType.STRING.toString(), "hasvisacard", 1,0, false, "是否持有VISA贷记卡" )))
							.addNode(new FieldNode("isebankcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isebankcust", 1,0, false, "是否网银客户" )))
							.addNode(new FieldNode("ismobilecust", new MsgField(ContentEnum.MessageType.STRING.toString(), "ismobilecust", 1,0, false, "是否手机银行客户" )))
							.addNode(new FieldNode("iswbankcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "iswbankcust", 1,0, false, "是否微信银行客户" )))
							.addNode(new FieldNode("ispfcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "ispfcust", 1,0, false, "是否理财客户" )))
							.addNode(new FieldNode("isfdcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isfdcust", 1,0, false, "是否基金客户" )))
							.addNode(new FieldNode("isgdcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isgdcust", 1,0, false, "是否黄金客户" )))
							.addNode(new FieldNode("isyxtcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isyxtcust", 1,0, false, "是否银信通客户" )))
							.addNode(new FieldNode("iscartstag", new MsgField(ContentEnum.MessageType.STRING.toString(), "iscartstag", 1,0, false, "贷记卡分期" )))
							.addNode(new FieldNode("isbigdp", new MsgField(ContentEnum.MessageType.STRING.toString(), "isbigdp", 1,0, false, "大额存单" )))
							.addNode(new FieldNode("isiccart", new MsgField(ContentEnum.MessageType.STRING.toString(), "isiccart", 1,0, false, "借记IC卡" )))
							.addNode(new FieldNode("isphonestate", new MsgField(ContentEnum.MessageType.STRING.toString(), "isphonestate", 1,0, false, "手机状态" )))
							.addNode(new FieldNode("ismpvaild", new MsgField(ContentEnum.MessageType.STRING.toString(), "ismpvaild", 1,0, false, "手机有效户" )))
							.addNode(new FieldNode("hashouseloan", new MsgField(ContentEnum.MessageType.STRING.toString(), "hashouseloan", 1,0, false, "是否有房贷" )))
							.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, false, "客户编号" )))
							.addNode(new FieldNode("custtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype", 1,0, false, "客户类型" )))
							.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 256,0, false, "客户名称" )))
							.addNode(new FieldNode("custlevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "custlevel", 1,0, false, "客户等级" )))
											));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

