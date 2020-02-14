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
 * BASESVC.P043000503 银行卡综合信息查询.卡层交易时间查询 
 * P0430005.03 cd1096
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P043000503 extends EsbCoreChannelService {

	private static P043000503_I i = new P043000503_I();
	private static P043000503_O o = new P043000503_O();
	public P043000503() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P043000503_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("qry_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_tp", 1,0, true, "查询类型" )))
					.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, true, "卡号" )))
					.addNode(new FieldNode("txn_pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_pswd", 32,0, false, "交易密码" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_cnt_num", 10,0, true, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_cnt_num", 10,0, true, "查询笔数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P043000503_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("totl_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "totl_cnt_num", 10,0, false, "总笔数" )))
					.addNode(new ArrayNode("listnm01_list",false)
							.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, false, "卡号" )))
							.addNode(new FieldNode("detl_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "detl_serl_num", 10,0, false, "明细序号" )))
							.addNode(new FieldNode("func_clasf", new MsgField(ContentEnum.MessageType.STRING.toString(), "func_clasf", 50,0, false, "功能分类" )))
							.addNode(new FieldNode("chnl_clasf", new MsgField(ContentEnum.MessageType.STRING.toString(), "chnl_clasf", 50,0, false, "渠道分类" )))
							.addNode(new FieldNode("rvlmt_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "rvlmt_tp", 1,0, false, "循环类型" )))
							.addNode(new FieldNode("lock_card_strt_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "lock_card_strt_tm", 25,0, false, "锁卡起始时间" )))
							.addNode(new FieldNode("lock_card_end_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "lock_card_end_tm", 25,0, false, "锁卡终止时间" )))
							.addNode(new FieldNode("func_prvg_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "func_prvg_flg", 1,0, false, "功能权限标志" )))
							.addNode(new FieldNode("eff_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "eff_dt", 8,0, false, "生效日期" )))
							.addNode(new FieldNode("invld_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "invld_dt", 8,0, false, "失效日期" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

