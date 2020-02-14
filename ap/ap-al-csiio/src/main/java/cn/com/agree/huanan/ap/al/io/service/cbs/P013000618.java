package cn.com.agree.huanan.ap.al.io.service.cbs;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbCoreChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P013000618 账户信息查询.大额存单专用账户查询 
 * P0130006.18 dp2333
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P013000618 extends EsbCoreChannelService {

	private static P013000618_I i = new P013000618_I();
	private static P013000618_O o = new P013000618_O();
	public P013000618() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013000618_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_cnt_num", 10,0, false, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_cnt_num", 10,0, false, "查询笔数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013000618_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("lstDdctAcct_list",false)
							.addNode(new FieldNode("dept_recpt_ddct_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_recpt_ddct_acct_num", 40,0, false, "存单专用账号" )))
							.addNode(new FieldNode("dept_recpt_ddct_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_recpt_ddct_acct_nm", 256,0, false, "存单专用账户名" )))
							.addNode(new FieldNode("acct_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_ste", 4,0, false, "账户状态" )))
							.addNode(new FieldNode("open_acct_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_dt", 8,0, false, "开户日期" )))
							.addNode(new FieldNode("cncl_acct_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_acct_dt", 8,0, false, "销户日期" )))
							.addNode(new FieldNode("open_acct_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_org", 12,0, false, "开户机构" )))
							.addNode(new FieldNode("txn_chnl", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_chnl", 7,0, false, "交易渠道" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

