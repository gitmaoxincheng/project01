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
 * BASESVC.S013004101 凭证出入库信息查询.凭证出入库明细信息查询 
 * S0130041.01 ce5156
 * 0005 新核心业务系统
 * @author zhonggp
 */
@Component
public class S013004101 extends EsbCoreChannelService {
	
	private static S013004101_I i = new S013004101_I();
	private static S013004101_O o = new S013004101_O();

	public S013004101() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013004101_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" )))
					.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" )))
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
					.addNode(new FieldNode("par_val", new MsgField(ContentEnum.MessageType.INT.toString(), "par_val", 18,2, false, "面值" )))
					.addNode(new FieldNode("vchr_unit", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_unit", 1,0, false, "凭证单位" )))
					.addNode(new FieldNode("strt_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_dt_8", 8,0, true, "起始日期" )))
					.addNode(new FieldNode("end_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_dt", 8,0, true, "终止日期" )))
					.addNode(new FieldNode("inwd_otwd_br_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "inwd_otwd_br_flg", 1,0, false, "出入网点标记" )))
					.addNode(new FieldNode("cntpr_org_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_org_code_num", 12,0, false, "对方机构代号" )))
					.addNode(new FieldNode("cntpr_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_tlr", 10,0, false, "对方柜员" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "strt_cnt_num", 10,0, true, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "qry_cnt_num", 10,0, true, "查询笔数" )))
					.addNode(new FieldNode("qry_prt_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_prt_id", 1,0, true, "查询打印标识" )))
					.addNode(new FieldNode("qry_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_scope", 1,0, false, "查询范围" )))
					.addNode(new FieldNode("glbl_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "glbl_rung_num", 32,0, false, "全局流水号" )))
					.addNode(new FieldNode("vchr_use_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_use_ste", 1,0, false, "凭证使用状态" )))
					.addNode(new FieldNode("vchr_aply_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_aply_num", 30,0, false, "凭证申请编号" )))
					.addNode(new FieldNode("txn_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_code", 20,0, false, "交易码" )))
					.addNode(new FieldNode("vchr_aply_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_aply_ste", 1,0, false, "凭证申请状态" )))
					.addNode(new FieldNode("trfr_rltnp_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "trfr_rltnp_type", 1,0, false, "调拨关系类型" )))
					.addNode(new FieldNode("inwd_otwd_strge_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "inwd_otwd_strge_flg", 1,0, false, "出入库标志" )))
					.addNode(new FieldNode("tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_rung_num", 64,0, false, "柜员流水号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S013004101_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("listnm_list",false)
							.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" )))
							.addNode(new FieldNode("org_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "org_chins_nm", 256,0, false, "机构中文名称" )))
							.addNode(new FieldNode("acctg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctg_org", 12,0, false, "账务机构" )))
							.addNode(new FieldNode("acctg_org_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctg_org_chins_nm", 256,0, false, "账务机构中文名" )))
							.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" )))
							.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
							.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
							.addNode(new FieldNode("par_val", new MsgField(ContentEnum.MessageType.INT.toString(), "par_val", 18,2, false, "面值" )))
							.addNode(new FieldNode("strt_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_vchr_serl_num", 32,0, false, "起始凭证号" )))
							.addNode(new FieldNode("end_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_vchr_serl_num", 32,0, false, "终止凭证序号" )))
							.addNode(new FieldNode("vchr_vol", new MsgField(ContentEnum.MessageType.INT.toString(), "vchr_vol", 10,0, false, "凭证张数" )))
							.addNode(new FieldNode("inwd_otwd_br_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "inwd_otwd_br_flg", 1,0, false, "出入网点标记" )))
							.addNode(new FieldNode("cntpr_org_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_org_code_num", 12,0, false, "对方机构代号" )))
							.addNode(new FieldNode("cntpr_org_chins_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_org_chins_nm", 256,0, false, "对方机构中文名" )))
							.addNode(new FieldNode("cntpr_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_tlr", 10,0, false, "对方柜员" )))
							.addNode(new FieldNode("txn_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_code", 20,0, false, "交易码" )))
							.addNode(new FieldNode("glbl_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "glbl_rung_num", 32,0, false, "全局流水号" )))
							.addNode(new FieldNode("tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_rung_num", 64,0, false, "柜员流水号" )))
							.addNode(new FieldNode("athrzn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "athrzn_tlr", 10,0, false, "授权柜员" )))
							.addNode(new FieldNode("rept_route", new MsgField(ContentEnum.MessageType.STRING.toString(), "rept_route", 750,0, false, "报表路径" )))
							.addNode(new FieldNode("cntpr_tlr_boot_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_tlr_boot_num", 8,0, false, "对方柜员尾箱号" )))
							.addNode(new FieldNode("boot_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_num", 8,0, false, "尾箱号" )))
							.addNode(new FieldNode("vchr_use_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_use_ste", 1,0, false, "凭证使用状态" )))
							.addNode(new FieldNode("vchr_aply_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_aply_num", 30,0, false, "凭证申请编号" )))
							.addNode(new FieldNode("inwd_otwd_strge_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "inwd_otwd_strge_flg", 1,0, false, "出入库标志" )))
							.addNode(new FieldNode("rcvg_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcvg_dt", 8,0, false, "接收日期" )))
							.addNode(new FieldNode("vchr_aply_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_aply_ste", 1,0, false, "凭证申请状态" )))
							.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
