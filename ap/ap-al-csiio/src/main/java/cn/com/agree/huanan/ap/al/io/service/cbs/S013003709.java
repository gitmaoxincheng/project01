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
 * BASESVC.S013003709 凭证库存/尾箱信息查询.凭证上日余额查询 
 * S0130037.09 ce6001
 * 0005 新核心业务系统
 * @author CZP
 */
@Component
public class S013003709 extends EsbCoreChannelService {

	private static S013003709_I i = new S013003709_I();
	private static S013003709_O o = new S013003709_O();

	public S013003709() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013003709_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("last_dy_acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "last_dy_acct_bal", 18,2, false, "上日账户余额" )))
					.addNode(new FieldNode("txn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_tlr", 10,0, false, "交易柜员" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "strt_cnt_num", 10,0, true, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "qry_cnt_num", 10,0, true, "查询笔数" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S013003709_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("listnm_list",false)
							.addNode(new FieldNode("acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_num", 40,0, false, "账号" )))
							.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" )))
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
							.addNode(new FieldNode("boot_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_class", 2,0, false, "尾箱类别" )))
							.addNode(new FieldNode("invty_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "invty_bal", 18,2, false, "库存余额" )))
							.addNode(new FieldNode("last_dy_acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "last_dy_acct_bal", 18,2, false, "上日账户余额" )))
							.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm", 256,0, false, "账户名称" )))
							.addNode(new FieldNode("txn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_tlr", 10,0, false, "交易柜员" )))
							.addNode(new FieldNode("off_bal_sheet_boot", new MsgField(ContentEnum.MessageType.STRING.toString(), "off_bal_sheet_boot", 8,0, false, "表外尾箱" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
