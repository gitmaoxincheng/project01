package cn.com.agree.huanan.ap.al.io.service.cbs;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbCoreChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P013000208 交易信息查询.交易成功性查询 
 * P0130002.08 ib1693
 * 0005 新核心业务系统
 * @author GYL
 */
@Component
public class P013000208 extends EsbCoreChannelService {

	private static P013000208_I i = new P013000208_I();
	private static P013000208_O o = new P013000208_O();
	public P013000208() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013000208_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "orig_pfxn_sys_dt", 8,0, true, "原前置日期" )))
					.addNode(new FieldNode("serialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "orig_pfxn_sys_rung_num", 32,0, true, "原前置流水" )))
					.addNode(new FieldNode("sysid", new MsgField(ContentEnum.MessageType.STRING.toString(), "orig_rqst_sys_id", 4,0, false, "原请求系统标识" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013000208_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("orig_pfxn_sys_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedate", 8,0, false, "原前置日期" )))
					.addNode(new FieldNode("orig_pfxn_sys_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "serialno", 32,0, false, "原前置流水" )))
					.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "backsysdate", 8,0, false, "交易日期" )))
					.addNode(new FieldNode("txn_rung_num_32", new MsgField(ContentEnum.MessageType.STRING.toString(), "backsysno", 32,0, false, "交易流水号" )))
					.addNode(new FieldNode("be_rvrsd_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1,0, false, "被冲正标志" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}



	@Override
	public Map<String, Object> initOutContent(Map<String, Object> sendContext, Map<String, Object> recvContext) {
		super.initOutContent(sendContext, recvContext);
		/* 超时映射规则:
			 报文头10个A查询成功：
			  交易日期
			  交易流水号
			  被冲正标志0-无关：成功，1-被冲正：被冲正
			报文头非10个A查询失败: 暂时当交易结果为失败。
		 */
		if (CommConstant.SUCCSTATUS.equals(isTradeSuccess(recvContext))) {
			//  被冲正标志0-无关：成功，1-被冲正：被冲正 //目前核心查询到则为成功，交易状态设为S ,   20200103
			Map<String, Object> body = (Map<String, Object>) recvContext.get(CommConstant.APP_BODY);
			body.put("status", "S");
		}
		/*else if (CommConstant.FAILCODE.equals(isTradeSuccess(recvContext)) && "0005E01106".equals(getErrorCode(recvContext))) {
			//0005E01106为核心查询无数据，默认为失败
			Map<String, Object> body = (Map<String, Object>) recvContext.get(CommConstant.APP_BODY);
			body.put("status", "F");
			Map<String, Object> esbHeader = (Map<String, Object>) recvContext.get(CommConstant.ESB_HEADER);
			esbHeader.put(CommConstant.STATUS, "S");
		}*/
		return recvContext;
	}
}

