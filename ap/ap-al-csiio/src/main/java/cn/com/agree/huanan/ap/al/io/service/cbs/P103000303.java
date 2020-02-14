package cn.com.agree.huanan.ap.al.io.service.cbs;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
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
 * BASESVC.P103000303 汇率信息查询.系统汇率查询 
 * P1030003.03 fx1522
 * 0005 新核心业务系统
 * @author CZP
 */
@Component
public class P103000303 extends EsbCoreChannelService {

	private static P103000303_I i = new P103000303_I();
	private static P103000303_O o = new P103000303_O();

	public P103000303() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P103000303_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
					.addNode(new FieldNode("hist_qry_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "hist_qry_flg", 1,0, false, "历史查询标志" )))
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
	

	public static class P103000303_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("lstfxpsys_list",false)
							.addNode(new FieldNode("eff_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "eff_dt", 8,0, false, "生效日期" )))
							.addNode(new FieldNode("eff_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "eff_tm", 22,0, false, "生效时间" )))
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("qtprc_unit", new MsgField(ContentEnum.MessageType.INT.toString(), "qtprc_unit", 20,7, false, "牌价单位" )))
							.addNode(new FieldNode("ccy_symbol", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_symbol", 3,0, false, "货币符号" )))
							.addNode(new FieldNode("buy_prc", new MsgField(ContentEnum.MessageType.INT.toString(), "buy_prc", 18,2, false, "买入价" )))
							.addNode(new FieldNode("sell_prc", new MsgField(ContentEnum.MessageType.INT.toString(), "sell_prc", 18,2, false, "卖出价" )))
							.addNode(new FieldNode("mid_prc", new MsgField(ContentEnum.MessageType.INT.toString(), "mid_prc", 18,2, false, "中间价" )))
							.addNode(new FieldNode("cash_buyg_prc", new MsgField(ContentEnum.MessageType.INT.toString(), "cash_buyg_prc", 18,2, false, "钞买价" )))
							.addNode(new FieldNode("cash_sellg_prc", new MsgField(ContentEnum.MessageType.INT.toString(), "cash_sellg_prc", 18,2, false, "钞卖价" )))
							.addNode(new FieldNode("sqr_posi_buy_prc", new MsgField(ContentEnum.MessageType.INT.toString(), "sqr_posi_buy_prc", 18,2, false, "平盘买入价" )))
							.addNode(new FieldNode("sqr_posi_sell_prc", new MsgField(ContentEnum.MessageType.INT.toString(), "sqr_posi_sell_prc", 18,2, false, "平盘卖出价" )))
							.addNode(new FieldNode("remks", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks", 300,0, false, "备注" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
