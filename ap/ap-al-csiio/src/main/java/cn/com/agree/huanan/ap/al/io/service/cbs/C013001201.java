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
 * BASESVC.C013001201 黑名单客户信息查询.黑名单信息查询 
 * C0130012.01 cf4152
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class C013001201 extends EsbCoreChannelService {

	private static C013001201_I i = new C013001201_I();
	private static C013001201_O o = new C013001201_O();
	public C013001201() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013001201_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("black_list_seq_num", new MsgField(ContentEnum.MessageType.INT.toString(), "black_list_seq_num", 10,0, false, "黑名单顺序号" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_tp", 2,0, false, "客户类型" )))
					.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm", 256,0, false, "客户中文名" )))
					.addNode(new FieldNode("list_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "list_tp", 1,0, false, "名单类型" )))
					.addNode(new FieldNode("card_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_tp", 2,0, false, "卡类型" )))
					.addNode(new FieldNode("chnl_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "chnl_code", 7,0, false, "渠道代码" )))
					.addNode(new FieldNode("list_deal_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "list_deal_way", 1,0, false, "名单处理方式" )))
					.addNode(new FieldNode("txn_grp_list", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_grp_list", 1500,0, false, "交易组别列表" )))
					.addNode(new FieldNode("prod_grp", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_grp", 300,0, false, "产品组别" )))
					.addNode(new FieldNode("lgl_rprtv", new MsgField(ContentEnum.MessageType.STRING.toString(), "lgl_rprtv", 256,0, false, "法定代表人" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("intt_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "intt_org", 1,0, false, "发起组织" )))
					.addNode(new FieldNode("nat_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "nat_code", 4,0, false, "国别代码" )))
					.addNode(new FieldNode("forbid_busi", new MsgField(ContentEnum.MessageType.STRING.toString(), "forbid_busi", 1,0, false, "禁止业务" )))
					.addNode(new FieldNode("black_list_keywd", new MsgField(ContentEnum.MessageType.STRING.toString(), "black_list_keywd", 1,0, false, "黑名单关键字" )))
					.addNode(new FieldNode("black_list_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "black_list_ste", 1,0, false, "黑名单状态" )))
					.addNode(new FieldNode("gen_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "gen_dt", 8,0, false, "生成日期" )))
					.addNode(new FieldNode("gen_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gen_tm", 32,0, false, "生成时间" )))
					.addNode(new FieldNode("gen_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "gen_reason", 200,0, false, "生成原因" )))
					.addNode(new FieldNode("black_list_remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "black_list_remks_info", 300,0, false, "黑名单备注信息" )))
					.addNode(new FieldNode("rec_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "rec_ste", 1,0, false, "记录状态" )))
					.addNode(new FieldNode("strt_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_dt_8", 8,0, false, "起始日期" )))
					.addNode(new FieldNode("end_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_dt", 8,0, false, "终止日期" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "strt_cnt_num", 10,0, false, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "qry_cnt_num", 10,0, false, "查询笔数" )))				
					.addNode(new FieldNode("crea_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "crea_org", 12,0, false, "创建机构" )))
					.addNode(new FieldNode("qry_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_scope", 1,0, false, "查询范围" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C013001201_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("listnm_list",false)
							.addNode(new FieldNode("black_list_seq_num", new MsgField(ContentEnum.MessageType.INT.toString(), "black_list_seq_num", 10,0, false, "黑名单顺序号" )))
							.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
							.addNode(new FieldNode("cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_tp", 2,0, false, "客户类型" )))
							.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm", 256,0, false, "客户中文名" )))
							.addNode(new FieldNode("lgl_rprtv", new MsgField(ContentEnum.MessageType.STRING.toString(), "lgl_rprtv", 256,0, false, "法定代表人" )))
							.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
							.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
							.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
							.addNode(new FieldNode("intt_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "intt_org", 1,0, false, "发起组织" )))
							.addNode(new FieldNode("nat_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "nat_code", 4,0, false, "国别代码" )))
							.addNode(new FieldNode("forbid_busi", new MsgField(ContentEnum.MessageType.STRING.toString(), "forbid_busi", 1,0, false, "禁止业务" )))
							.addNode(new FieldNode("black_list_keywd", new MsgField(ContentEnum.MessageType.STRING.toString(), "black_list_keywd", 1,0, false, "黑名单关键字" )))
							.addNode(new FieldNode("black_list_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "black_list_ste", 1,0, false, "黑名单状态" )))
							.addNode(new FieldNode("gen_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "gen_dt", 8,0, false, "生成日期" )))
							.addNode(new FieldNode("gen_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gen_tm", 32,0, false, "生成时间" )))
							.addNode(new FieldNode("gen_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "gen_reason", 200,0, false, "生成原因" )))
							.addNode(new FieldNode("black_list_remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "black_list_remks_info", 300,0, false, "黑名单备注信息" )))
							.addNode(new FieldNode("crea_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "crea_dt", 8,0, false, "创建日期" )))
							.addNode(new FieldNode("crea_tm", new MsgField(ContentEnum.MessageType.INT.toString(), "crea_tm", 10,0, false, "创建时间" )))
							.addNode(new FieldNode("crea_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "crea_org", 12,0, false, "创建机构" )))
							.addNode(new FieldNode("crea_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "crea_tlr", 10,0, false, "创建柜员" )))
							.addNode(new FieldNode("crea_chnl", new MsgField(ContentEnum.MessageType.STRING.toString(), "crea_chnl", 7,0, false, "创建渠道" )))
							.addNode(new FieldNode("crea_athrzn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "crea_athrzn_tlr", 10,0, false, "创建授权柜员" )))
							.addNode(new FieldNode("crea_tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "crea_tlr_rung_num", 32,0, false, "创建柜员流水号" )))
							.addNode(new FieldNode("mntnc_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_tm", 9,0, false, "维护时间" )))
							.addNode(new FieldNode("mntnc_chnl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_chnl", 7,0, false, "维护渠道" )))
							.addNode(new FieldNode("mntnc_athrzn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_athrzn_tlr", 10,0, false, "维护授权柜员" )))
							.addNode(new FieldNode("mntnc_tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_tlr_rung_num", 32,0, false, "维护柜员流水号" )))
							.addNode(new FieldNode("mntnc_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_tlr", 10,0, false, "维护柜员" )))
							.addNode(new FieldNode("mntnc_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_org", 12,0, false, "维护机构" )))
							.addNode(new FieldNode("mntnc_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_dt", 8,0, false, "维护日期" )))
							.addNode(new FieldNode("rec_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "rec_ste", 1,0, false, "记录状态" )))
							.addNode(new FieldNode("list_deal_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "list_deal_way", 1,0, false, "名单处理方式" )))
							.addNode(new FieldNode("list_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "list_tp", 1,0, false, "名单类型" )))
							.addNode(new FieldNode("txn_grp_list", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_grp_list", 1500,0, false, "交易组别列表" )))
							.addNode(new FieldNode("prod_grp", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_grp", 300,0, false, "产品组别" )))
							.addNode(new FieldNode("chnl_set", new MsgField(ContentEnum.MessageType.STRING.toString(), "chnl_set", 1500,0, false, "渠道集合" )))
							.addNode(new FieldNode("txn_tp_list", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_tp_list", 300,0, false, "交易类型列表" )))
							.addNode(new FieldNode("eff_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "eff_tm", 22,0, false, "生效时间" )))
							.addNode(new FieldNode("invld_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "invld_tm", 22,0, false, "失效时间" )))
							.addNode(new FieldNode("cust_risk_lv", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_risk_lv", 2,0, false, "名单风险级别" )))
							.addNode(new FieldNode("black_list_main_body", new MsgField(ContentEnum.MessageType.STRING.toString(), "black_list_main_body", 10,0, false, "黑名单主体" )))
							.addNode(new FieldNode("acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_nm",256,0, false, "账户名称" )))
							.addNode(new FieldNode("spare_fld_200", new MsgField(ContentEnum.MessageType.STRING.toString(), "spare_fld_200",200,0, false, "备用字段" )))

							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

