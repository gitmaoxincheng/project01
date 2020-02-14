package cn.com.agree.huanan.ap.al.io.service.ecd;

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
 * BASESVC.P083000501 票据交易信息查询.票据交易结果查询 
 * P0830005.01 pltranqy
 * 0227 票据系统
 * @author GYL
 */
@Component
public class P083000501 extends EsbCoreChannelService {

	private static P083000501_I i = new P083000501_I();
	private static P083000501_O o = new P083000501_O();
	public P083000501() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P083000501_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("serialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "reqno", 60,0, true, "上送流水号" )))
					.addNode(new FieldNode("sysid", new MsgField(ContentEnum.MessageType.STRING.toString(), "address", 10,0, true, "请求方系统标识" )))
					.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "srcdate", 10,0, true, "请求日期" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P083000501_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 2,0, true, "交易状态" )))
					.addNode(new FieldNode("erromg", new MsgField(ContentEnum.MessageType.STRING.toString(), "errormsg", 200,0, true, "结果说明" )))
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
		/*  超时映射规则
			报文头10个A查询成功：
			  status 交易状态 00-处理失败;01-处理中;02-处理成功;03-无记录
			  erromg 结果说明 
			报文头非10个A查询失败：报错提示		 
		 */
		
		if (CommConstant.SUCCSTATUS.equals(isTradeSuccess(recvContext))) {
			//    status 交易状态 00-处理失败;01-处理中;02-处理成功;03-无记录   //状态待进一步确定，03状态暂定为待处理，待处理XXX
			Map<String, Object> body = (Map<String, Object>)recvContext.get(CommConstant.APP_BODY);
			String status = (String) body.get("status");
			switch ( status) {
			case "00":
				body.put("status", "F");break;
			case "01":
				body.put("status", "I");break;
			case "02":
				body.put("status", "S");break;				
			case "03":
				body.put("status", "N");break;
			default:
				body.put("status", "N");break;
			}
		}
		return recvContext;
	}
	
}

