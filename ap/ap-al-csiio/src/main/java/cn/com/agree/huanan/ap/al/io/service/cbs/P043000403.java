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
 * BASESVC.P043000403 银行卡凭证信息查询.单位结算卡凭证查询 
 * P0430004.03 cd1081
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P043000403 extends EsbCoreChannelService {

	private static P043000403_I i = new P043000403_I();
	private static P043000403_O o = new P043000403_O();
	public P043000403() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P043000403_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, true, "卡号" )))
					.addNode(new FieldNode("card_vchr_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_vchr_ste", 1,0, false, "卡凭证状态" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_cnt_num", 10,0, true, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_cnt_num", 10,0, true, "查询笔数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P043000403_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("listnm01_list",false)
							.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, false, "卡号" )))
							.addNode(new FieldNode("crdhd_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "crdhd_docs_catg", 3,0, false, "持卡人证件种类" )))
							.addNode(new FieldNode("crdhd_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "crdhd_docs_num", 30,0, false, "持卡人证件号码" )))
							.addNode(new FieldNode("crdhd_cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "crdhd_cust_nm", 256,0, false, "持卡人客户名称" )))
							.addNode(new FieldNode("crdhd_cntct_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "crdhd_cntct_tel", 20,0, false, "持卡人联系电话" )))
							.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
							.addNode(new FieldNode("card_issn_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_issn_org", 12,0, false, "发卡机构" )))
							.addNode(new FieldNode("card_issn_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_issn_dt", 8,0, false, "发卡日期" )))
							.addNode(new FieldNode("card_issn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_issn_tlr", 10,0, false, "发卡柜员" )))
							.addNode(new FieldNode("card_issn_chnl", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_issn_chnl", 7,0, false, "发卡渠道" )))
							.addNode(new FieldNode("vld_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "vld_dt", 8,0, false, "有效日期" )))
							.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
							.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 32,0, false, "凭证序号" )))
							.addNode(new FieldNode("card_vchr_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_vchr_ste", 1,0, false, "卡凭证状态" )))
							.addNode(new FieldNode("card_lock_src", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_lock_src", 1,0, false, "卡锁定来源" )))
							.addNode(new FieldNode("next_chrg_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "next_chrg_dt", 8,0, false, "下次收费日期" )))
							.addNode(new FieldNode("pref_pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "pref_pcnt", 18,2, false, "优惠比例(%)" )))
							.addNode(new FieldNode("invld_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "invld_dt", 8,0, false, "失效日期" )))
							.addNode(new FieldNode("mvbl_acct_ntc_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "mvbl_acct_ntc_flg", 1,0, false, "动账通知标志" )))
							.addNode(new FieldNode("change_card_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "change_card_dt", 8,0, false, "换卡日期" )))
							.addNode(new FieldNode("change_card_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "change_card_org", 12,0, false, "换卡机构" )))
							.addNode(new FieldNode("old_card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "old_card_num", 40,0, false, "老卡号" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

