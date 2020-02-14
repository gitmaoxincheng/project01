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
 * BASESVC.P013001708 负债业务参数信息查询.全账户限额信息查询 
 * P0130017.08 dp2013
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P013001708 extends EsbCoreChannelService {

	private static P013001708_I i = new P013001708_I();
	private static P013001708_O o = new P013001708_O();
	public P013001708() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013001708_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("lmt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmt_num", 32,0, false, "额度编号" )))
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

	public static class P013001708_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("listnm01_list",false)
							.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
							.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
							.addNode(new FieldNode("lmt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmt_num", 32,0, false, "额度编号" )))
							.addNode(new FieldNode("lmt_comt", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmt_comt", 300,0, false, "额度说明" )))
							.addNode(new FieldNode("lmt_ccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmt_ccy", 3,0, false, "额度币种" )))
							.addNode(new FieldNode("lmt_hier_keywd", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmt_hier_keywd", 40,0, false, "额度层次关键字" )))
							.addNode(new FieldNode("lmt_eff_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmt_eff_dt", 8,0, false, "额度生效日期" )))
							.addNode(new FieldNode("lmt_matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmt_matu_dt", 8,0, false, "额度到期日期" )))
							.addNode(new FieldNode("txn_cnt_ctrl", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_cnt_ctrl", 10,0, false, "交易次数控制" )))
							.addNode(new FieldNode("sngl_txn_lmt", new MsgField(ContentEnum.MessageType.INT.toString(), "sngl_txn_lmt", 18,2, false, "单次交易额度" )))
							.addNode(new FieldNode("acmld_txn_lmt", new MsgField(ContentEnum.MessageType.INT.toString(), "acmld_txn_lmt", 18,2, false, "累计交易额度" )))
							.addNode(new FieldNode("amt_lmt", new MsgField(ContentEnum.MessageType.INT.toString(), "amt_lmt", 18,2, false, "金额额度" )))
							.addNode(new FieldNode("rsdl_amt_lmt", new MsgField(ContentEnum.MessageType.INT.toString(), "rsdl_amt_lmt", 18,2, false, "剩余金额额度" )))
							.addNode(new FieldNode("cnt", new MsgField(ContentEnum.MessageType.INT.toString(), "cnt", 10,0, false, "次数" )))
							.addNode(new FieldNode("rsdl_cnt_lmt", new MsgField(ContentEnum.MessageType.INT.toString(), "rsdl_cnt_lmt", 10,0, false, "剩余次数额度" )))
							.addNode(new FieldNode("prd_strt_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "prd_strt_dt", 8,0, false, "周期起始日期" )))
							.addNode(new FieldNode("prd_end_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "prd_end_dt", 8,0, false, "周期终止日期" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

