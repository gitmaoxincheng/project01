package cn.com.agree.huanan.ap.al.io.service.cbs;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.al.io.system.esb.EsbCoreChannelService;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.S011000210 ATM离行在途/在途核销.现金尾箱管理 
 * S0110002.10 ca5078
 * 0005 企业级客户信息管理系统
 * @author JZF
 */
@Component
public class S011000210 extends EsbCoreChannelService {
	/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCS011000210', 'BASESVC', '企业级客户信息管理系统', 'S011000210', 'ATM离行在途/在途核销', 'ESB', 'ESB_cbs系统', 'S0110002', '现金尾箱管理', '10','ca5078' ,'ATM离行在途/在途核销', '1', '0', 'ATM离行在途/在途核销');

	 */
	private static S011000210_I i = new S011000210_I();
	private static S011000210_O o = new S011000210_O();

	public S011000210() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S011000210_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("atm_oprn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "atm_oprn_flg", 1,0, false, "ATM操作标志" )))
					.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期" )))
					.addNode(new FieldNode("tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_rung_num", 32,0, false, "柜员流水号" )))
					.addNode(new FieldNode("tkt_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "tkt_catg", 1,0, false, "券种" )))
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
					.addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
					.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
					.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
					.addNode(new FieldNode("cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "cnt_num", 10,0, false, "笔数" )))
					.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" )))
					.addNode(new FieldNode("cntpr_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_tlr", 10,0, false, "对方柜员" )))
					.addNode(new ArrayNode("listnm_list",false)
							.addNode(new FieldNode("par_val", new MsgField(ContentEnum.MessageType.INT.toString(), "par_val", 18,2, false, "面值" )))
							.addNode(new FieldNode("cash_unit", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_unit", 1,0, false, "现金单位" )))
							.addNode(new FieldNode("qty", new MsgField(ContentEnum.MessageType.INT.toString(), "qty", 10,0, false, "数量" )))
							.addNode(new FieldNode("totl_vol", new MsgField(ContentEnum.MessageType.INT.toString(), "totl_vol", 10,0, false, "总张数" )))
							.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S011000210_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("txn_amt", new MsgField(ContentEnum.MessageType.INT.toString(), "txn_amt", 18,2, false, "交易金额" )))
					.addNode(new FieldNode("cash_ovrg_shtg_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_ovrg_shtg_serl_num", 30,0, false, "长短款序号" )))
					.addNode(new FieldNode("wait_write_off_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "wait_write_off_serl_num", 40,0, false, "待销账序号" )))
					.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, false, "交易日期" )))
					.addNode(new FieldNode("tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_rung_num", 32,0, false, "柜员流水号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
