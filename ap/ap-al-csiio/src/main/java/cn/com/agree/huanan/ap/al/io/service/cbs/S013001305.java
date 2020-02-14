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
 * BASESVC.S013001305 柜员机构信息查询.	网点未处理清单查询打印 
 * S0130013.05 br5364
 * 0005 柜员管理
 * @author JZF
 */
@Component
public class S013001305 extends EsbCoreChannelService {
	/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCS013001305', 'BASESVC', '柜员管理', 'S013001305', '柜员机构信息查询', 'ESB', 'ESB_csb系统', 'S0130013', '	网点未处理清单查询打印', '05','br5364' ,'柜员机构信息查询', '1', '0', '柜员机构信息查询');

	 */
	private static S013001305_I i = new S013001305_I();
	private static S013001305_O o = new S013001305_O();

	public S013001305() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013001305_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("qry_prt_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_prt_id", 1,0, false, "查询打印标识" )))
					.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" )))
					.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "strt_cnt_num", 10,0, true, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "qry_cnt_num", 10,0, true, "查询笔数" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S013001305_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("rept_route", new MsgField(ContentEnum.MessageType.STRING.toString(), "rept_route", 750,0, false, "报表路径" )))
					.addNode(new ArrayNode("lstBr5364out_list",false)
							.addNode(new FieldNode("wait_deal_busi_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "wait_deal_busi_num", 225,0, false, "待处理业务号" )))
							.addNode(new FieldNode("wait_deal_busi_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "wait_deal_busi_nm", 60,0, false, "待处理业务名" )))
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
							.addNode(new FieldNode("wait_deal_ste_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "wait_deal_ste_nm", 750,0, false, "待处理状态名" )))
							.addNode(new FieldNode("hint_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "hint_info", 300,0, false, "提示信息" )))
							.addNode(new FieldNode("comt_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "comt_info", 1500,0, false, "说明信息" )))
							.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" )))
							.addNode(new FieldNode("wthr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_flg", 1,0, false, "是否标志" )))
							.addNode(new FieldNode("chins_comt", new MsgField(ContentEnum.MessageType.STRING.toString(), "chins_comt", 750,0, false, "中文说明" )))
							.addNode(new FieldNode("org_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "org_code", 12,0, false, "机构代码" )))
							.addNode(new FieldNode("tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_rung_num", 32,0, false, "柜员流水号" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
