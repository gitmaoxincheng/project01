package cn.com.agree.huanan.ap.al.io.service.ica;

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
 * BASESVC.P013003201 交易通讯日志查询.电子现金交易日志查询 
 * P0130032.01 iclgqy
 * 0050 IC卡系统2.0
 * @author GYL
 */
@Component
public class P013003201 extends EsbCoreChannelService {

	private static P013003201_I i = new P013003201_I();
	private static P013003201_O o = new P013003201_O();
	public P013003201() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013003201_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("serialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 25,0, true, "交易流水" )))
					.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt", 8,0, true, "交易日期" )))
					.addNode(new FieldNode("sysid", new MsgField(ContentEnum.MessageType.STRING.toString(), "spsyst", 4,0, true, "发起方系统编号" )))
					.addNode(new FieldNode("trancd", new MsgField(ContentEnum.MessageType.STRING.toString(), "trancd", 8,0, false, "交易码" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 40,0, false, "卡号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013003201_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("busisq", new MsgField(ContentEnum.MessageType.STRING.toString(), "busisq", 25,0, false, "全局流水" )))
					.addNode(new FieldNode("appseq", new MsgField(ContentEnum.MessageType.STRING.toString(), "appseq", 25,0, false, "IC卡系统流水" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 40,0, false, "卡号" )))
					.addNode(new FieldNode("cardsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardsq", 40,0, false, "卡序号" )))
					.addNode(new FieldNode("trancd", new MsgField(ContentEnum.MessageType.STRING.toString(), "trancd", 8,0, false, "交易码" )))
					.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.INT.toString(), "tranam", 18,2, false, "交易金额" )))
					.addNode(new FieldNode("typeid", new MsgField(ContentEnum.MessageType.STRING.toString(), "typeid", 10,0, false, "交易类型ID" )))
					.addNode(new FieldNode("transt", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 10,0, false, "交易状态" )))
					.addNode(new FieldNode("respcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "errorcode", 20,0, false, "响应码" )))
					.addNode(new FieldNode("respmg", new MsgField(ContentEnum.MessageType.STRING.toString(), "errormsg", 200,0, false, "响应信息" )))
					.addNode(new FieldNode("userid", new MsgField(ContentEnum.MessageType.STRING.toString(), "userid", 10,0, false, "交易柜员" )))
					.addNode(new FieldNode("brchno", new MsgField(ContentEnum.MessageType.STRING.toString(), "brchno", 10,0, false, "交易机构" )))
					.addNode(new FieldNode("tranti", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranti", 20,0, false, "交易登记时间" )))
					.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark", 200,0, false, "备注" )))
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
		/*
			报文头10个A查询成功：
			    transt 交易状态：00:成功;01:失败;02:处理中
			    respcd 响应码 
			    respmg 响应信息
			报文头非10个A查询失败：
			    0050E10202-查询无记录
			    其它错误码视为查询失败：报错提示 
		 */
		if (CommConstant.SUCCSTATUS.equals(isTradeSuccess(recvContext))) {
			Map<String, Object> body = (Map<String, Object>)recvContext.get(CommConstant.APP_BODY);
			String status = (String) body.get("status");
			switch ( status) {
			case "00":
				body.put("status", "S");break;
			case "01":
				body.put("status", "F");break;
			case "02":
				body.put("status", "I");break;				
			default:
				body.put("status", "N");break;
			}
		}
		
		return recvContext;
	}
	
}

