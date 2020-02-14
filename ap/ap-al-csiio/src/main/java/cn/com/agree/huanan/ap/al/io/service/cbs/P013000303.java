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
 * BASESVC.P013000303 账户签约信息查询.日日盈月月盈签约信息查询 
 * P0130003.03 dp2301
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P013000303 extends EsbCoreChannelService {

	private static P013000303_I i = new P013000303_I();
	private static P013000303_O o = new P013000303_O();
	public P013000303() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013000303_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("trfr_out_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_cust_acct_num", 40,0, false, "转出客户账号" )))
					.addNode(new FieldNode("trfr_out_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_sub_acct_serl_num", 8,0, false, "转出子账户序号" )))
					.addNode(new FieldNode("sign_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "sign_ste", 1,0, false, "签约状态" )))
					.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, false, "卡号" )))
					.addNode(new FieldNode("trfr_in_ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_in_ccy_code_num", 3,0, false, "转入货币代号" )))
					.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
					.addNode(new FieldNode("busi_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_catg", 2,0, false, "业务种类" )))
					.addNode(new FieldNode("hndg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "hndg_org", 12,0, false, "经办机构" )))
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

	public static class P013000303_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("listnm_list",false)
							.addNode(new FieldNode("trfr_out_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_out_cust_acct_num", 40,0, false, "转出客户账号" )))
							.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, false, "卡号" )))
							.addNode(new FieldNode("lblty_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_acct_num", 40,0, false, "负债账号" )))
							.addNode(new FieldNode("dept_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_catg", 3,0, false, "存款种类" )))
							.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
							.addNode(new FieldNode("cptl_trfr_trfr_out_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptl_trfr_trfr_out_way", 1,0, false, "资金转移转出方式" )))
							.addNode(new FieldNode("trfr_amt", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "trfr_amt", 18,2, false, "转账金额" )))
							.addNode(new FieldNode("trfr_freq", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_freq", 8,0, false, "转账频率" )))
							.addNode(new FieldNode("sign_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "sign_ste", 1,0, false, "签约状态" )))
							.addNode(new FieldNode("trsc_br", new MsgField(ContentEnum.MessageType.STRING.toString(), "trsc_br", 12,0, false, "办理网点" )))
							.addNode(new FieldNode("sign_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "sign_tlr", 10,0, false, "签约柜员" )))
							.addNode(new FieldNode("sign_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "sign_dt", 8,0, false, "签约日期" )))
							.addNode(new FieldNode("cncl_cvnt_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_cvnt_tlr", 10,0, false, "解约柜员" )))
							.addNode(new FieldNode("cncl_cvnt_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cncl_cvnt_dt", 8,0, false, "解约日期" )))
							.addNode(new FieldNode("appo_rtan_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "appo_rtan_amt", 18,2, false, "约定留存金额" )))
							.addNode(new FieldNode("trfr_amt_set", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_amt_set", 1,0, false, "转账金额设置" )))
							.addNode(new FieldNode("mntnc_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_org", 12,0, false, "维护机构" )))
							.addNode(new FieldNode("mntnc_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_tm", 9,0, false, "维护时间" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

