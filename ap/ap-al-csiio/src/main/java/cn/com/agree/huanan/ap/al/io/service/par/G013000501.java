package cn.com.agree.huanan.ap.al.io.service.par;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.G013000501 交易超时查询.外围渠道超时交易状态查询 
 * G0130005.01 203041
 * 0020 中间业务平台(参数管理模块)
 * @author GYL
 */
@Component
public class G013000501 extends EsbChannelService {
/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCG013000501', 'BASESVC', '中间业务平台(参数管理模块)', 'G013000501', '交易超时查询', 'ESB', 'ESB_par系统', 'G0130005', '外围渠道超时交易状态查询', '01','203041' ,'交易超时查询', '1', '0', '交易超时查询');

*/
	private static G013000501_I i = new G013000501_I();
	private static G013000501_O o = new G013000501_O();
	public G013000501() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class G013000501_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
.addNode(new FieldNode("origchannelcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "origchannelcode", 4,0, false, "原渠道分类" )))
.addNode(new FieldNode("origsubchannelcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "origsubchannelcode", 3,0, false, "原渠道码" )))
.addNode(new FieldNode("origtradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "origtradedate", 8,0, false, "原渠道日期" )))
.addNode(new FieldNode("origchannelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "origchannelserno", 40,0, false, "原渠道流水" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class G013000501_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
.addNode(new FieldNode("serverworkdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "serverworkdate", 8,0, false, "服务端交易日期" )))
.addNode(new FieldNode("serverserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "serverserialno", 40,0, false, "服务端交易流水号" )))
.addNode(new FieldNode("servererrorcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "servererrorcode", 8,0, false, "服务端交易返回错误代码" )))
.addNode(new FieldNode("servererrormsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "servererrormsg", 300,0, false, "服务端交易返回信息" )))
.addNode(new FieldNode("endstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "endstatus", 1,0, false, "交易状态" )))
.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedate", 8,0, false, "前置日期" )))
.addNode(new FieldNode("tradeseno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradeseno", 8,0, false, "前置流水" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

