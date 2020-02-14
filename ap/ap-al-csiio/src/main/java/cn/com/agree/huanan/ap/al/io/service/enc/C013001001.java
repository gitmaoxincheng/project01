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
 * BASESVC.C013001001  个人客户标志信息查询
 * C0130010.01    ECIF502
 * @author lf
 *
 */
@Component
public class C013001001 extends EsbChannelService {

	private static C013001001_I i = new C013001001_I();
	private static C013001001_O o = new C013001001_O();
	public C013001001() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013001001_I extends MsgBody {
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

	public static class C013001001_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("contrsize", new MsgField(ContentEnum.MessageType.STRING.toString(), "contrsize",10,0, false, "返回记录数" )))
					.addNode(new ArrayNode("signinfo_list",false)
							.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid",32,0, false, "客户编号" )))
							.addNode(new FieldNode("isbankemp", new MsgField(ContentEnum.MessageType.STRING.toString(), "isbankemp",1,0, false, "是否本行职工" )))
							.addNode(new FieldNode("isdfgzcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isdfgzcust",1,0, true, "是否代发工资客户" )))
							.addNode(new FieldNode("isteacher", new MsgField(ContentEnum.MessageType.STRING.toString(), "isteacher",1,0, false, "是否教师" )))
							.addNode(new FieldNode("issecycust", new MsgField(ContentEnum.MessageType.STRING.toString(), "issecycust",1,0, false, "是否有社保" )))
							.addNode(new FieldNode("isfwcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isfwcust",1,0, false, "是否有房维" )))
							.addNode(new FieldNode("isloancust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isloancust",	1,0, true, "是否有本行贷款" )))
							.addNode(new FieldNode("hasfundsloan", new MsgField(ContentEnum.MessageType.STRING.toString(), "hasfundsloan",	1,0, false, "是否有公积金贷款" )))
							.addNode(new FieldNode("hashouseloan", new MsgField(ContentEnum.MessageType.STRING.toString(), "hashouseloan",1	,0, false, "是否有房贷" )))
							.addNode(new FieldNode("hasbadloan", new MsgField(ContentEnum.MessageType.STRING.toString(), "hasbadloan",1	,0, false, "是否存在不良贷款" )))
							.addNode(new FieldNode("isdwdbcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isdwdbcust",1,0, true, "是否对外提供担保" )))
							.addNode(new FieldNode("isshop", new MsgField(ContentEnum.MessageType.STRING.toString(), "isshop",1	,0, false, "是否商户" )))
							.addNode(new FieldNode("hassfcg", new MsgField(ContentEnum.MessageType.STRING.toString(), "hassfcg",1,0, false, "是否有三方存管" )))
							.addNode(new FieldNode("haseccard", new MsgField(ContentEnum.MessageType.STRING.toString(), "haseccard	",	1,0, false, "是否持有银联贷记卡" )))
							.addNode(new FieldNode("hasvisacard", new MsgField(ContentEnum.MessageType.STRING.toString(), "hasvisacard	",1,0, true, "是否持有VISA贷记卡" )))
							.addNode(new FieldNode("isebankcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isebankcust",1,0, false, "是否网银客户" )))
							.addNode(new FieldNode("ismobilecust", new MsgField(ContentEnum.MessageType.STRING.toString(), "ismobilecust",1	,0, false, "是否手机银行客户" )))
							.addNode(new FieldNode("iswbankcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "iswbankcust",1,0, false, "是否微信银行客户	" )))
							.addNode(new FieldNode("ispfcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "ispfcust",1,0, true, "是否理财客户" )))
							.addNode(new FieldNode("isfdcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isfdcust",	1,0, false,"是否基金客户" )))
							.addNode(new FieldNode("isgdcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isgdcust",	1,0, false,"是否黄金客户" )))
							.addNode(new FieldNode("isyxtcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isyxtcust",	1,0, false, "是否银信通客户" )))
							.addNode(new FieldNode("iskhdsfcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "iskhdsfcust",1,0, true, "是否跨行代收付客户" )))
							.addNode(new FieldNode("isdaydp", new MsgField(ContentEnum.MessageType.STRING.toString(), "isdaydp",1,0, false, "是否日日盈客户" )))
							.addNode(new FieldNode("ismondp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ismondp",1,0, false, "是否月月盈客户" )))
							.addNode(new FieldNode("hassfzf", new MsgField(ContentEnum.MessageType.STRING.toString(), "hassfzf	",	1,0, false, "是否签约第三方支付" )))
							.addNode(new FieldNode("hascar", new MsgField(ContentEnum.MessageType.STRING.toString(), "hascar",1,0, true, "是否拥有车辆" )))
							.addNode(new FieldNode("lastupdatesys", new MsgField(ContentEnum.MessageType.STRING.toString(), "lastupdatesys",20,0, false, "最后更新系统" )))
							.addNode(new FieldNode("lastupdateuser", new MsgField(ContentEnum.MessageType.STRING.toString(), "lastupdateuser",10,0, false, "最后更新人" )))
							.addNode(new FieldNode("lastupdatetm", new MsgField(ContentEnum.MessageType.STRING.toString(), "lastupdatetm",40,0, false, "最后更新时间" )))
							.addNode(new FieldNode("txseqno", new MsgField(ContentEnum.MessageType.STRING.toString(), "txseqno",32,0, false, "交易流水号" )))	
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}



