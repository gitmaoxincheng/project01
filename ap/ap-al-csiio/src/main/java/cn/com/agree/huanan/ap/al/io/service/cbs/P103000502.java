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
 * BASESVC.P103000502 存款产品信息查询.存款产品基本信息查询 
 * P1030005.02 dp2282
 * 0005 0005-新核心业务系统
 * @author ZS
 */
@Component
public class P103000502 extends EsbCoreChannelService {
	
	private static P103000502_I i = new P103000502_I();
	private static P103000502_O o = new P103000502_O();

	public P103000502() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P103000502_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品代码" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, true, "币种" )))
					.addNode(new FieldNode("acct_clasf_code_01", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf_code_01", 10,0, false, "账户分类代码1" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class P103000502_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品代码" )))
					.addNode(new FieldNode("prod_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_nm", 750,0, false, "产品名称" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("int_rate_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_num_tp", 1,0, false, "利率编号类型" )))
					.addNode(new FieldNode("dept_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_catg", 3,0, false, "存款种类" )))
					.addNode(new FieldNode("lblty_prod_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "lblty_prod_tp", 1,0, false, "负债产品类型" )))
					.addNode(new FieldNode("prod_blgd_obj", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_blgd_obj", 1,0, false, "产品所属对象" )))
					.addNode(new FieldNode("wthr_form_trfr_defn", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_form_trfr_defn", 1,0, false, "是否形态转移定义" )))
					.addNode(new FieldNode("wthr_rcncl_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_rcncl_flg", 1,0, false, "是否对账标志" )))
					.addNode(new FieldNode("rcncl_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcncl_prd", 8,0, false, "对账周期" )))
					.addNode(new FieldNode("acct_chk_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_chk_flg", 1,0, false, "账户核查标志" )))
					.addNode(new FieldNode("acct_chk_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_chk_prd", 8,0, false, "账户核查周期" )))
					.addNode(new FieldNode("bal_genl_ledger_sycrz_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "bal_genl_ledger_sycrz_flg", 1,0, false, "余额与总账同步标志" )))
					.addNode(new FieldNode("matu", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu", 6,0, false, "期限" )))
					.addNode(new FieldNode("wthr_open_acct_rstct", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_open_acct_rstct", 1,0, false, "是否开户限制" )))
					.addNode(new FieldNode("rlvc_vchr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rlvc_vchr_flg", 1,0, false, "关联凭证标志" )))
					.addNode(new FieldNode("stlmt_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "stlmt_acct_flg", 1,0, false, "结算账户标志" )))
					.addNode(new FieldNode("alw_ovdf_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "alw_ovdf_flg", 1,0, false, "允许透支标志" )))
					.addNode(new FieldNode("bchmk_acrl_int_rate_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "bchmk_acrl_int_rate_num", 20,0, false, "基准计提利率编号" )))
					.addNode(new FieldNode("int_caln_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_caln_flg", 1,0, false, "计息标志" )))
					.addNode(new FieldNode("rstct_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rstct_catg", 2,0, false, "限制种类" )))
					.addNode(new FieldNode("trsry_dept_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "trsry_dept_flg", 1,0, false, "财政存款标志" )))
					.addNode(new FieldNode("mrgn_dept_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "mrgn_dept_flg", 1,0, false, "保证金存款标志" )))
					.addNode(new FieldNode("zero_bal_open_acct_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "zero_bal_open_acct_flg", 1,0, false, "零余额开户标志" )))
					.addNode(new FieldNode("draw_aptmt_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "draw_aptmt_way", 1,0, false, "支取预约方式" )))
					.addNode(new FieldNode("matu_dt_cfrm_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_dt_cfrm_way", 1,0, false, "到期日确定方式" )))
					.addNode(new ArrayNode("listnm01_list",false)
							.addNode(new FieldNode("acct_clasf", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_clasf", 4,0, false, "账户分类" )))
					).addNode(new ArrayNode("listnm02_list",false)
							.addNode(new FieldNode("acct_attr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_attr", 10,0, false, "账户属性" )))
					).addNode(new ArrayNode("listnm03_list",false)
							.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
					).addNode(new ArrayNode("listnm04_list",false)
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					).addNode(new FieldNode("int_rate_dept_prd_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_dept_prd_flg", 1,0, false, "利率存期标志" )))
					.addNode(new FieldNode("int_rate_dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "int_rate_dept_prd", 6,0, false, "利率存期" )))
					.addNode(new FieldNode("adv_int_pymt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "adv_int_pymt_flg", 1,0, false, "预付息标志" )))
					.addNode(new FieldNode("adv_int_pymt_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "adv_int_pymt_code", 10,0, false, "预付息代码" )))
					.addNode(new FieldNode("pnly_int_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pnly_int_flg", 1,0, false, "罚息标志" )))
					.addNode(new FieldNode("pnly_int_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "pnly_int_code", 50,0, false, "罚息代码" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
