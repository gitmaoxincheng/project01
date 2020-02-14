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
 * BASESVC.S013004102 凭证出入库信息查询.凭证出入库查询 
 * S0130041.02 ce5167
 * 0005 新核心业务系统
 * @author CZP
 */
@Component
public class S013004102 extends EsbCoreChannelService {

	private static S013004102_I i = new S013004102_I();
	private static S013004102_O o = new S013004102_O();

	public S013004102() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013004102_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_rung_num", 32,0, false, "柜员流水号" )))
					.addNode(new FieldNode("vchr_aply_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_aply_num", 30,0, false, "凭证申请编号" )))
					.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "strt_cnt_num", 10,0, false, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "qry_cnt_num", 10,0, false, "查询笔数" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S013004102_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("qrylist_list",false)
							.addNode(new FieldNode("strt_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_vchr_serl_num", 32,0, false, "起始凭证序号" )))
							.addNode(new FieldNode("end_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_vchr_serl_num", 32,0, false, "终止凭证序号" )))
							.addNode(new FieldNode("vchr_aply_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_aply_num", 30,0, false, "凭证申请编号" )))
							.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("host_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "host_dt", 8,0, false, "主机日期" )))
							.addNode(new FieldNode("txn_serl_num", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_serl_num", 10,0, false, "交易序号" )))
							.addNode(new FieldNode("acctg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctg_org", 12,0, false, "账务机构" )))
							.addNode(new FieldNode("acct_org_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_org_chins_nm", 300,0, false, "账务机构中文名" )))
							.addNode(new FieldNode("txn_tm", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_tm", 10,0, false, "交易时间" )))
							.addNode(new FieldNode("fgrd_txn_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "fgrd_txn_code", 20,0, false, "前台交易码" )))
							.addNode(new FieldNode("txn_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_code", 20,0, false, "交易码" )))
							.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" )))
							.addNode(new FieldNode("org_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "org_chins_nm", 300,0, false, "机构中文名称" )))
							.addNode(new FieldNode("txn_acctg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_acctg_org", 12,0, false, "交易账务机构" )))
							.addNode(new FieldNode("inwd_otwd_br_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "inwd_otwd_br_flg", 1,0, false, "出入网点标记" )))
							.addNode(new FieldNode("txn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_tlr", 10,0, false, "交易柜员" )))
							.addNode(new FieldNode("off_bal_sheet_boot", new MsgField(ContentEnum.MessageType.STRING.toString(), "off_bal_sheet_boot", 8,0, false, "表外尾箱" )))
							.addNode(new FieldNode("boot_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_class", 2,0, false, "尾箱类别" )))
							.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
							.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
							.addNode(new FieldNode("vchr_vol", new MsgField(ContentEnum.MessageType.INT.toString(), "vchr_vol", 10,0, false, "凭证张数" )))
							.addNode(new FieldNode("vchr_unit", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_unit", 1,0, false, "凭证单位" )))
							.addNode(new FieldNode("qty", new MsgField(ContentEnum.MessageType.INT.toString(), "qty", 10,0, false, "数量" )))
							.addNode(new FieldNode("par_val", new MsgField(ContentEnum.MessageType.INT.toString(), "par_val", 18,2, false, "面值" )))
							.addNode(new FieldNode("acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_num", 40,0, false, "系统账号" )))
							.addNode(new FieldNode("cntpr_org_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_org_code_num", 12,0, false, "对方机构代号" )))
							.addNode(new FieldNode("cntpr_org_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_org_chins_nm", 300,0, false, "对方机构中文名" )))
							.addNode(new FieldNode("cntpr_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_tlr", 10,0, false, "对方柜员" )))
							.addNode(new FieldNode("cntpr_tlr_boot_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_tlr_boot_num", 8,0, false, "对方柜员尾箱号" )))
							.addNode(new FieldNode("cntpr_tlr_boot_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_tlr_boot_class", 2,0, false, "对方柜员尾箱类别" )))
							.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
							.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
							.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
							.addNode(new FieldNode("vchr_use_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_use_ste", 1,0, false, "凭证使用状态" )))
							.addNode(new FieldNode("athrzn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "athrzn_tlr", 10,0, false, "授权柜员" )))
							.addNode(new FieldNode("tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_rung_num", 32,0, false, "柜员流水号" )))
							.addNode(new FieldNode("chnl_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "chnl_code", 5,0, false, "渠道代码" )))
							.addNode(new FieldNode("lgl_pern_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "lgl_pern_code", 4,0, false, "法人代码" )))
							.addNode(new FieldNode("mntnc_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_tlr", 10,0, false, "维护柜员" )))
							.addNode(new FieldNode("mntnc_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_org", 12,0, false, "维护机构" )))
							.addNode(new FieldNode("mntnc_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_dt", 8,0, false, "维护日期" )))
							.addNode(new FieldNode("tmstp", new MsgField(ContentEnum.MessageType.INT.toString(), "tmstp", 10,0, false, "时间戳" )))
							.addNode(new FieldNode("rec_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "rec_ste", 1,0, false, "记录状态" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
