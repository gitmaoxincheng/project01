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
 * BASESVC.P043000501 银行卡综合信息查询.卡层限额查询 
 * P0430005.01 cd1153
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P043000501 extends EsbCoreChannelService {

	private static P043000501_I i = new P043000501_I();
	private static P043000501_O o = new P043000501_O();
	public P043000501() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P043000501_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("qry_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_tp", 1,0, true, "查询类型" )))
					.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, false, "卡号" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 32,0, false, "交易密码" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_cnt_num", 10,0, true, "查询笔数" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_cnt_num", 10,0, true, "起始笔数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P043000501_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("totl_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "totl_cnt_num", 10,0, false, "总笔数" )))
					.addNode(new ArrayNode("listnm01_list",false)
							.addNode(new FieldNode("lmt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmt_num", 32,0, false, "额度编号" )))
							.addNode(new FieldNode("lmt_comt", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmt_comt", 300,0, false, "额度说明" )))
							.addNode(new FieldNode("sngl_alwc", new MsgField(ContentEnum.MessageType.INT.toString(), "sngl_alwc", 18,2, false, "单笔限额" )))
							.addNode(new FieldNode("rvlg_prd_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "rvlg_prd_tp", 1,0, false, "循环周期类型" )))
							.addNode(new FieldNode("dly_acmld_alwc", new MsgField(ContentEnum.MessageType.INT.toString(), "dly_acmld_alwc", 18,2, false, "日累计限额" )))
							.addNode(new FieldNode("dly_acmld_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "dly_acmld_cnt", 10,0, false, "日累计次数" )))
							.addNode(new FieldNode("wkly_acmld_alwc", new MsgField(ContentEnum.MessageType.INT.toString(), "wkly_acmld_alwc", 18,2, false, "周累计限额" )))
							.addNode(new FieldNode("moly_acmld_alwc", new MsgField(ContentEnum.MessageType.INT.toString(), "moly_acmld_alwc", 18,2, false, "月累计限额" )))
							.addNode(new FieldNode("moly_acmld_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "moly_acmld_cnt", 10,0, false, "月累计次数" )))
							.addNode(new FieldNode("qurt_acmld_alwc", new MsgField(ContentEnum.MessageType.INT.toString(), "qurt_acmld_alwc", 18,2, false, "季累计限额" )))
							.addNode(new FieldNode("anul_acmld_alwc", new MsgField(ContentEnum.MessageType.INT.toString(), "anul_acmld_alwc", 18,2, false, "年累计限额" )))
							.addNode(new FieldNode("dy_rsdl_lmt", new MsgField(ContentEnum.MessageType.INT.toString(), "dy_rsdl_lmt", 18,2, false, "日剩余额度" )))
							.addNode(new FieldNode("wk_rsdl_lmt", new MsgField(ContentEnum.MessageType.INT.toString(), "wk_rsdl_lmt", 18,2, false, "周剩余额度" )))
							.addNode(new FieldNode("mo_rsdl_lmt", new MsgField(ContentEnum.MessageType.INT.toString(), "mo_rsdl_lmt", 18,2, false, "月剩余额度" )))
							.addNode(new FieldNode("qurt_rsdl_lmt", new MsgField(ContentEnum.MessageType.INT.toString(), "qurt_rsdl_lmt", 18,2, false, "季剩余额度" )))
							.addNode(new FieldNode("yr_rsdl_lmt", new MsgField(ContentEnum.MessageType.INT.toString(), "yr_rsdl_lmt", 18,2, false, "年剩余额度" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

