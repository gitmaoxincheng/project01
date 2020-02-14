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
 * BASESVC.P103000201 利率信息查询.利率试算 
 * P1030002.01 it5700
 * 0005 新核心业务系统
 * @author MAOW 
 */
@Component
public class P103000201 extends EsbCoreChannelService {
/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCP103000201', 'BASESVC', '新核心业务系统', 'P103000201', '利率信息查询', 'CBS', 'ESB_cbs系统', 'P1030002', '利率试算', '01','it5700' ,'利率信息查询', '1', '0', '利率信息查询');

*/
	private static P103000201_I i = new P103000201_I();
	private static P103000201_O o = new P103000201_O();
	public P103000201() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class P103000201_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, true, "定价日期" )))
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品代码" )))
					.addNode(new FieldNode("int_rate_code_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_code_tp", 1,0, false, "利率代码类型" )))
					.addNode(new FieldNode("int_rate_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_code", 20,0, true, "利率代码" )))
					.addNode(new FieldNode("wthr_int_rate_flt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_int_rate_flt_flg", 1,0, false, "利率浮动标志" )))
					.addNode(new FieldNode("int_rate_flt_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_flt_tp", 1,0, false, "利率浮动类型" )))
					.addNode(new FieldNode("flt_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "flt_prd", 8,0, false, "浮动周期" )))
					.addNode(new FieldNode("int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate", 12,7, false, "利率" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, true, "货币代号" )))
					.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
					.addNode(new FieldNode("int_rate_amt_lv", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate_amt_lv", 17,2, false, "利率档次" )))
					.addNode(new FieldNode("strt_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_dt_8", 8,0, false, "起始日期" )))
					.addNode(new FieldNode("end_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_dt", 8,0, false, "终止日期" )))
					.addNode(new FieldNode("org_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "org_code", 12,0, false, "机构代码" )))
					.addNode(new FieldNode("open_acct_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "open_acct_amt", 18,2, true, "开户金额" )))
					.addNode(new FieldNode("wthr_alw_pref", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_alw_pref", 1,0, false, "是否允许优惠" )))
					.addNode(new FieldNode("br_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "br_code", 4,0, false, "分行代码" )))
					.addNode(new FieldNode("prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "prd", 50,0, false, "期次" )))
					.addNode(new FieldNode("chnl_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "chnl_code", 5,0, false, "渠道代码类型" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_snthes_evlan_lv", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_snthes_evlan_lv", 2,0, false, "客户综合评估级别" )))
					.addNode(new FieldNode("cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_tp", 2,0, false, "客户类型" )))
					.addNode(new FieldNode("wthr_empe_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_empe_flg", 1,0, false, "是否员工标志" )))
					.addNode(new FieldNode("chrg_cust_acct_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_cust_acct_tp", 1,0, false, "收费客户账户类型" )))
					.addNode(new FieldNode("card_prod_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_prod_num", 10,0, false, "卡产品编号" )))
					.addNode(new FieldNode("acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_num", 40,0, false, "账号" )))
					.addNode(new FieldNode("wthr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_flg", 1,0, false, "是否登记利率明细" )))
					.addNode(new FieldNode("int_rate_flt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_flt_flg", 1,0, false, "利率浮动标志" )))
					.addNode(new FieldNode("int_rate_flt_pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate_flt_pcnt", 12,7, false, "利率浮动比例" )))
					.addNode(new FieldNode("flt_val", new MsgField(ContentEnum.MessageType.INT.toString(), "flt_val", 20,7, false, "浮动值" )))
					.addNode(new FieldNode("int_rate_afld_lv_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_afld_lv_way", 1,0, false, "利率靠档方式" )))
					.addNode(new FieldNode("int_rate_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_num_tp", 1,0, false, "利率编号类型" )))
					.addNode(new FieldNode("amt_tp_expd_dmsnl", new MsgField(ContentEnum.MessageType.INT.toString(), "amt_tp_expd_dmsnl", 18,2, false, "金额类型扩展维度" )))
					.addNode(new FieldNode("charc_tp_expd_dmsnl", new MsgField(ContentEnum.MessageType.STRING.toString(), "charc_tp_expd_dmsnl", 750,0, false, "字符类型扩展维度" )))
					.addNode(new FieldNode("dept_prd_tp_expd_dmsnl", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd_tp_expd_dmsnl", 750,0, false, "存期类型扩展维度" )))
					.addNode(new FieldNode("rgon_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgon_code_num", 20,0, false, "地区代号" )))
					.addNode(new FieldNode("exte_cr_grd", new MsgField(ContentEnum.MessageType.STRING.toString(), "exte_cr_grd", 10,0, false, "外部信用等级" )))
					.addNode(new FieldNode("int_pymt_freq", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_pymt_freq", 8,0, false, "付息频率" )))
					.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
					.addNode(new FieldNode("ctrct_prod_grp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctrct_prod_grp", 1,0, false, "合约产品组" )))
					.addNode(new FieldNode("ctrct_int_rate_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctrct_int_rate_tp", 1,0, false, "合约利率类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P103000201_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("int_rate_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_code", 20,0, false, "利率代码" )))
					.addNode(new FieldNode("actl_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_int_rate", 12,7, false, "实际利率" )))
					.addNode(new FieldNode("int_rate_flt_pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate_flt_pcnt", 12,7, false, "利率浮动比例" )))
					.addNode(new FieldNode("int_rate_flt_pnts", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate_flt_pnts", 12,7, false, "利率浮动点数" )))
					.addNode(new FieldNode("pref_flt_pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "pref_flt_pcnt", 18,2, false, "优惠浮动比例" )))
					.addNode(new FieldNode("pref_flt_pnts", new MsgField(ContentEnum.MessageType.INT.toString(), "pref_flt_pnts", 12,7, false, "利率优惠点数" )))
					.addNode(new FieldNode("int_rate_befr_pref", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate_befr_pref", 12,7, false, "优惠前利率" )))
					.addNode(new FieldNode("exec_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "exec_int_rate", 12,7, false, "执行利率" )))
					.addNode(new FieldNode("actl_int_rate_pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_int_rate_pcnt", 12,7, false, "实际利率百分比" )))
					.addNode(new FieldNode("actl_int_rate_pnts", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_int_rate_pnts", 12,7, false, "实际利率点数" )))
					.addNode(new FieldNode("rgstn_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgstn_dt", 8,0, false, "登记日期" )))
					.addNode(new FieldNode("tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_rung_num", 32,0, false, "柜员流水号" )))
					.addNode(new ArrayNode("listnm01_list",false)
					.addNode(new FieldNode("actl_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_int_rate", 12,7, false, "实际利率" )))
					.addNode(new FieldNode("lv_amt_lwr_lmt", new MsgField(ContentEnum.MessageType.INT.toString(), "lv_amt_lwr_lmt", 18,2, false, "档次金额下限" )))
					.addNode(new FieldNode("dept_prd_lv", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd_lv", 6,0, false, "分层/靠档存期" )))
					.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "本层次存期天数" )))
					.addNode(new FieldNode("rfrc_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "rfrc_int_rate", 12,7, false, "参考利率" )))
					.addNode(new FieldNode("rfrc_int_rate_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfrc_int_rate_code", 20,0, false, "参考利率代码" )))
					.addNode(new FieldNode("int_rate_flt_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_flt_tp", 1,0, false, "利率浮动类型" )))
					.addNode(new FieldNode("int_rate_flt_pnts", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate_flt_pnts", 12,7, false, "利率浮动点数" )))
					.addNode(new FieldNode("int_rate_befr_pref", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate_befr_pref", 12,7, false, "优惠前利率" )))
					.addNode(new FieldNode("wthr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_flg", 1,0, false, "是否优惠" )))
					.addNode(new FieldNode("int_rate_flt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_flt_flg", 1,0, false, "利率浮动标志" )))
					.addNode(new FieldNode("pref_flt_pnts", new MsgField(ContentEnum.MessageType.INT.toString(), "pref_flt_pnts", 12,7, false, "优惠点数" )))
					.addNode(new FieldNode("pref_flt_pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "pref_flt_pcnt", 18,2, false, "优惠浮动比例" )))
					.addNode(new FieldNode("actl_flt_pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_flt_pcnt", 12,7, false, "实际浮动比例" )))
					.addNode(new FieldNode("actl_flt_pnts", new MsgField(ContentEnum.MessageType.INT.toString(), "actl_flt_pnts", 12,7, false, "实际浮动点数" )))
					.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
					.addNode(new FieldNode("actl_dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "actl_dept_prd", 6,0, false, "实际存期" )))
					.addNode(new FieldNode("int_rate_flt_pcnt", new MsgField(ContentEnum.MessageType.INT.toString(), "int_rate_flt_pcnt", 12,7, false, "利率浮动比例" )))
					).addNode(new FieldNode("rfrc_int_rate_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "rfrc_int_rate_code", 20,0, false, "编号利率代码" )))
					.addNode(new FieldNode("max_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "max_int_rate", 12,7, false, "最大利率" )))
					.addNode(new FieldNode("min_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "min_int_rate", 12,7, false, "最低利率" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

