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
 * 
 * @author ZS
 * BASESVC P013002702 期次产品认购列表信息查询
 * P013002702 dp2907
 * 0005 新核心系统
 */
@Component
public class P013002702 extends EsbCoreChannelService {

	private static P013002702_I i = new P013002702_I();
	private static P013002702_O o = new P013002702_O();
	public P013002702() {
		requestFormat.add(i);
		responseFormat.add(o);
	}
	
	public static class P013002702_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("prod_prd_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_prd_num", 50,0, true, "产品期次编号" )))
					.addNode(new FieldNode("sbcrp_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrp_org", 12,0, false, "认购机构" )))
					.addNode(new FieldNode("sbcrp_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrp_ste", 1,0, true, "认购状态" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, true, "客户号" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_cnt_num", 10,0, false, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_cnt_num", 10,0, false, "查询笔数" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账号" )))
					.addNode(new FieldNode("pymt_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cust_acct_num", 40,0, true, "付款客户账号" )))
					.addNode(new FieldNode("spec_dept_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "spec_dept_ste", 1,0, true, "特殊存款状态" )))
					.addNode(new FieldNode("dept_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_catg", 3,0, false, "存款种类" )))
					);
			return messageNode;
		}
		
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	
	public static class P013002702_O extends MsgBody {
		
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("listnm_list",false)
							.addNode(new FieldNode("sbcrpn_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrpn_serl_num", 32,0, false, "认购序号" )))
							.addNode(new FieldNode("sbcrpn_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrpn_num", 32,0, false, "认购编号" )))
							.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
							.addNode(new FieldNode("dept_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_catg", 3,0, false, "存款种类" )))
							.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
							.addNode(new FieldNode("pymt_cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cust_acct_num", 40,0, false, "付款客户账号" )))
							.addNode(new FieldNode("pymt_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_acct_nm", 256,0, false, "付款账户名称" )))
							.addNode(new FieldNode("sbcrpn_cps", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrpn_cps", 10,0, false, "认购份数" )))
							.addNode(new FieldNode("sbcrpn_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrpn_amt", 18,2, false, "认购金额" )))
							.addNode(new FieldNode("prod_prd_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_prd_num", 50,0, false, "产品期次编号" )))
							.addNode(new FieldNode("sbcrp_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrp_org", 12,0, false, "认购机构" )))
							.addNode(new FieldNode("sbcrp_chnl", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrp_chnl", 7,0, false, "认购渠道" )))
							.addNode(new FieldNode("sbcrp_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrp_ste", 1,0, false, "认购状态" )))
							.addNode(new FieldNode("sbcrp_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbcrp_date", 8,0, false, "认购日期" )))
							.addNode(new FieldNode("hndg_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "hndg_tlr", 10,0, false, "经办柜员" )))
							.addNode(new FieldNode("prod_prd_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_prd_nm", 300,0, false, "产品期次名称" )))
							.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
							.addNode(new FieldNode("athrzn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "athrzn_tlr", 10,0, false, "授权柜员" )))
							.addNode(new FieldNode("btch_real_tm_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "btch_real_tm_flg", 1,0, false, "批量实时标志" )))
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("adv_draw_int_rate_way", new MsgField(ContentEnum.MessageType.STRING.toString(), "adv_draw_int_rate_way", 1,0, false, "提前支取利率方式" )))
							.addNode(new FieldNode("dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_prd", 6,0, false, "存期" )))
							.addNode(new FieldNode("open_acct_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "open_acct_dt", 8,0, false, "开户日期" )))
							.addNode(new FieldNode("matu_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matu_dt", 8,0, false, "到期日期" )))
							.addNode(new FieldNode("dept_int_rate_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dept_int_rate_tp", 4,0, false, "存款利率类型" )))
							)

					);
			return messageNode;
		}
			
			@Override
			public ArrayList<Node> listNode() {
				return msgSegment.getNodeList();
			}
		}
		
}	
	
	
	
	
