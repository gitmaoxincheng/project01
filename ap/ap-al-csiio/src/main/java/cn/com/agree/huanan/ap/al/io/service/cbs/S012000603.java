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
 * BASESVC.S012000603 凭证管理.柜员重要凭证出售 
 * S0120006.03 ce5121
 * 0005 新核心业务系统
 * @author STJ
 */
@Component
public class S012000603 extends EsbCoreChannelService {
/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCS012000603', 'BASESVC', '新核心业务系统', 'S012000603', '凭证管理', 'CBS', 'ESB_cbs系统', 'S0120006', '柜员重要凭证出售', '03','ce5121' ,'凭证管理', '1', '0', '凭证管理');

*/
	private static S012000603_I i = new S012000603_I();
	private static S012000603_O o = new S012000603_O();

	public S012000603() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class S012000603_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
.addNode(new FieldNode("cust_acct_num_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num_tp", 1,0, false, "客户账号类型" )))
.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, true, "客户账户" )))
.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
.addNode(new FieldNode("cust_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_tp", 2,0, false, "客户类型" )))
.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm", 256,0, false, "客户中文名" )))
.addNode(new FieldNode("pymt_cond", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_cond", 1,0, true, "支付条件" )))
.addNode(new FieldNode("pswd_ciptxt", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd_ciptxt", 32,0, false, "密码密文" )))
.addNode(new FieldNode("pymt_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "pymt_pswd", 32,0, false, "支付密码" )))
.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
.addNode(new FieldNode("sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sub_acct_serl_num", 8,0, false, "子账户序号" )))
.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
.addNode(new ArrayNode("listnm_list",false)
.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
.addNode(new FieldNode("par_val", new MsgField(ContentEnum.MessageType.INT.toString(), "par_val", 18,2, false, "面值" )))
.addNode(new FieldNode("br_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "br_code", 4,0, false, "分行代码" )))
.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
.addNode(new FieldNode("vchr_unit", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_unit", 1,0, false, "凭证单位" )))
.addNode(new FieldNode("qty", new MsgField(ContentEnum.MessageType.INT.toString(), "qty", 10,0, false, "数量" )))
.addNode(new FieldNode("strt_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_vchr_serl_num", 32,0, false, "起始凭证序号" )))
.addNode(new FieldNode("end_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_vchr_serl_num", 32,0, false, "终止凭证序号" )))
.addNode(new FieldNode("vchr_vol", new MsgField(ContentEnum.MessageType.INT.toString(), "vchr_vol", 10,0, false, "凭证张数" )))
).addNode(new ArrayNode("listnm04_list",false)
.addNode(new FieldNode("chrg_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_code", 8,0, false, "收费代码" )))
.addNode(new FieldNode("chrg_code_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_code_nm", 80,0, false, "收费代码名称" )))
.addNode(new FieldNode("svc_fee_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "svc_fee_amt", 18,2, false, "手续费金额" )))
.addNode(new FieldNode("fee_recpt_pymt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_recpt_pymt_flg", 1,0, false, "费用收付标志" )))
.addNode(new FieldNode("rcvd_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcvd_flg", 1,0, false, "收讫标志" )))
.addNode(new FieldNode("ars_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "ars_amt", 18,2, false, "欠费金额" )))
).addNode(new FieldNode("txn_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_nm", 256,0, false, "交易名称" )))
.addNode(new FieldNode("smtn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "smtn_amt", 18,2, false, "合计金额" )))
.addNode(new FieldNode("cash_trfr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_trfr_flg", 1,0, false, "现转标志" )))
.addNode(new FieldNode("fee_recpt_pymt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_recpt_pymt_flg", 1,0, false, "费用收付标志" )))
.addNode(new FieldNode("acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_num", 40,0, false, "账号" )))
.addNode(new FieldNode("chrg_ccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_ccy", 3,0, false, "收费币种" )))
.addNode(new FieldNode("taskid", new MsgField(ContentEnum.MessageType.STRING.toString(), "taskid", 30,0, false, "任务号" )))
.addNode(new FieldNode("rcvname", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcvname", 80,0, false, "领用人名称" )))
.addNode(new FieldNode("rcvcerttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcvcerttype", 3,0, false, "领用人证件类型" )))
.addNode(new FieldNode("rcvcertno", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcvcertno", 50,0, false, "领用人证件号码" )))
);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S012000603_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
.addNode(new FieldNode("cust_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_chins_nm", 256,0, false, "客户中文名" )))
.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
.addNode(new ArrayNode("listnm01_list",false)
.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
.addNode(new FieldNode("par_val", new MsgField(ContentEnum.MessageType.INT.toString(), "par_val", 18,2, false, "面值" )))
.addNode(new FieldNode("br_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "br_code", 4,0, false, "分行代码" )))
.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
.addNode(new FieldNode("vchr_unit", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_unit", 1,0, false, "凭证单位" )))
.addNode(new FieldNode("qty", new MsgField(ContentEnum.MessageType.INT.toString(), "qty", 10,0, false, "数量" )))
.addNode(new FieldNode("strt_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_vchr_serl_num", 32,0, false, "起始凭证序号" )))
.addNode(new FieldNode("end_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_vchr_serl_num", 32,0, false, "终止凭证序号" )))
.addNode(new FieldNode("vchr_vol", new MsgField(ContentEnum.MessageType.INT.toString(), "vchr_vol", 10,0, false, "凭证张数" )))
.addNode(new FieldNode("acct_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "acct_bal", 18,2, false, "账户余额" )))
));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
