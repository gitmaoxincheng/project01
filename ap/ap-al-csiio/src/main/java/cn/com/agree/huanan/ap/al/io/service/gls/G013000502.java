package cn.com.agree.huanan.ap.al.io.service.gls;

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
 * BASESVC.G013000502 交易超时查询.交易超时查询(大总账) 
 * G0130005.02 qresmg
 * 0009 大总帐
 * @author GYL
 */
@Component
public class G013000502 extends EsbCoreChannelService {

	private static G013000502_I i = new G013000502_I();
	private static G013000502_O o = new G013000502_O();
	public G013000502() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class G013000502_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("srdata", new MsgField(ContentEnum.MessageType.STRING.toString(), "srdata", 8,0, true, "请求日期" )))
					.addNode(new FieldNode("reqsno", new MsgField(ContentEnum.MessageType.STRING.toString(), "reqsno", 20,0, true, "请求流水号" )))
					.addNode(new FieldNode("systid", new MsgField(ContentEnum.MessageType.STRING.toString(), "systid", 4,0, true, "系统标识" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class G013000502_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("prcscd", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcscd", 20,0, true, "处理码" )))
					.addNode(new FieldNode("respts", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1,0, true, "处理状态" )))
					.addNode(new FieldNode("erorcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "errorcode", 20,0, true, "返回代码" )))
					.addNode(new FieldNode("errmsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "errormsg", 255,0, true, "返回信息" )))
					.addNode(new FieldNode("ustime", new MsgField(ContentEnum.MessageType.INT.toString(), "ustime", 10,0, true, "处理时间" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}


/*	@Override
	public Map<String, Object> initOutContent(Map<String, Object> sendContext, Map<String, Object> recvContext) {
		super.initOutContent(sendContext, recvContext);
		
			报文头10个A查询成功：
			  respts S-成功;F-失败;I-处理中;N-无记录;
			  erorcd 返回代码
			  errmsg 返回信息
			报文头非10个A查询失败：报错提示		
			
			//根据此规则，则无需做处理
		 
		return recvContext;
	}*/
	  
}

