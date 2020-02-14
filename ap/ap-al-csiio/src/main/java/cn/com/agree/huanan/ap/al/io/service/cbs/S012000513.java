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
 * BASESVC.S012000513 柜员信息管理.柜员信息修改 
 * S0120005.13 tl5211
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class S012000513 extends EsbCoreChannelService {

	private static S012000513_I i = new S012000513_I();
	private static S012000513_O o = new S012000513_O();
	public S012000513() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S012000513_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("dtbs_oprn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dtbs_oprn_flg", 1,0, false, "数据库操作标志" )))
					.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" )))
					.addNode(new FieldNode("tlr_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_attr", 1,0, false, "柜员属性" )))
					.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" )))
					.addNode(new FieldNode("tlr_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_nm", 256,0, false, "柜员姓名" )))
					.addNode(new FieldNode("orig_tlr_role", new MsgField(ContentEnum.MessageType.STRING.toString(), "orig_tlr_role", 6,0, false, "原柜员角色" )))
					.addNode(new FieldNode("tlr_role_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_role_code", 6,0, false, "柜员角色代码" )))
					.addNode(new FieldNode("enabl_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "enabl_dt", 8,0, false, "启用日期" )))
					.addNode(new FieldNode("end_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_dt", 8,0, false, "终止日期" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("tlr_risk_lv", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_risk_lv", 1,0, false, "柜员风险级别" )))
					.addNode(new FieldNode("tlr_medm_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_medm_id", 1,0, false, "柜员介质标识" )))
					.addNode(new FieldNode("athrzn_card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "athrzn_card_num", 40,0, false, "授权卡号" )))
					.addNode(new FieldNode("oprtr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtr_serl_num", 2,0, false, "操作员序号" )))
					.addNode(new FieldNode("tlr_lv", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_lv", 1,0, false, "柜员级别" )))
					.addNode(new FieldNode("dprtmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "dprtmt", 2,0, false, "部门" )))
					.addNode(new FieldNode("tlr_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_tp", 1,0, false, "柜员类型" )))
					.addNode(new FieldNode("pswd_vld_dys", new MsgField(ContentEnum.MessageType.INT.toString(), "pswd_vld_dys", 10,0, false, "密码有效天数" )))
					.addNode(new FieldNode("pswd_cannot_repeat_cnt", new MsgField(ContentEnum.MessageType.INT.toString(), "pswd_cannot_repeat_cnt", 10,0, false, "密码不可重复次数" )))
					.addNode(new FieldNode("pswd_alw_err_cnt", new MsgField(ContentEnum.MessageType.INT.toString(), "pswd_alw_err_cnt", 10,0, false, "密码允许错误次数" )))
					.addNode(new FieldNode("pswd_err_cnt", new MsgField(ContentEnum.MessageType.INT.toString(), "pswd_err_cnt", 10,0, false, "密码错误次数" )))
					.addNode(new FieldNode("ccy_ctrl_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_ctrl_flg", 1,0, false, "币种控制标志" )))
					.addNode(new FieldNode("ccy_sycrz_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_sycrz_flg", 1,0, false, "币种同步标志" )))
					.addNode(new FieldNode("cash_boot_totl_alwc", new MsgField(ContentEnum.MessageType.INT.toString(), "cash_boot_totl_alwc", 18,2, false, "现金尾箱总限额" )))
					.addNode(new FieldNode("wthr_cross_org_role", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_cross_org_role", 1,0, false, "是否跨机构角色" )))
					.addNode(new FieldNode("ctrl_list", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctrl_list", 1500,0, false, "控制列表" )))
					.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
					.addNode(new FieldNode("mber_qty", new MsgField(ContentEnum.MessageType.INT.toString(), "mber_qty", 10,0, false, "成员数量" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new ArrayNode("listTl5211_list",false)
							.addNode(new FieldNode("dtbs_oprn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dtbs_oprn_flg", 1,0, false, "数据库操作标志" )))
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("ccy_ctrl_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_ctrl_flg", 1,0, false, "币种控制标志" )))
							.addNode(new FieldNode("sycrz_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "sycrz_flg", 1,0, false, "同步标志" )))
							.addNode(new FieldNode("rfrc_ccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfrc_ccy", 3,0, false, "参考币种" )))
							.addNode(new FieldNode("cash_boot_alwc", new MsgField(ContentEnum.MessageType.INT.toString(), "cash_boot_alwc", 18,2, false, "现金尾箱限额" )))
							.addNode(new FieldNode("comt_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "comt_info", 300,0, false, "说明信息" )))
							).addNode(new ArrayNode("listTl5211B_list",false)
									.addNode(new FieldNode("dtbs_oprn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dtbs_oprn_flg", 1,0, false, "数据库操作标志" )))
									.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
									.addNode(new FieldNode("ccy_ctrl_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_ctrl_flg", 1,0, false, "币种控制标志" )))
									.addNode(new FieldNode("sycrz_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "sycrz_flg", 1,0, false, "同步标志" )))
									.addNode(new FieldNode("cash_boot_alwc", new MsgField(ContentEnum.MessageType.INT.toString(), "cash_boot_alwc", 18,2, false, "现金尾箱限额" )))
									));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S012000513_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

