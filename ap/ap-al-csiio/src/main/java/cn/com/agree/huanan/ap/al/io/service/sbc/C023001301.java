package cn.com.agree.huanan.ap.al.io.service.sbc;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.C023001301 渠道交易流水查询.柜面交易流水查询 
 * C0230013.01 GW0102
 * 0212 金融互联网服务平台
 * @author zhonggp
 */
@Component
public class C023001301 extends EsbChannelService {

	/*

	INSERT INTO CSIS_ATOMIC_SERVICE 
	(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
	('BASESVCC023001301', 'BASESVC', '金融互联网服务平台', 'C023001301', '渠道交易流水查询', 'ESB', 'ESB_sbc系统', 'C0230013', '柜面交易流水查询', '01','GW0102' ,'渠道交易流水查询', '1', '0', '渠道交易流水查询');

	*/
	private static C023001301_I i = new C023001301_I();
	private static C023001301_O o = new C023001301_O();

	public C023001301() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C023001301_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("pageNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageNo", 10,0, true, "当前页数" )))
					.addNode(new FieldNode("pageSize", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageSize", 10,0, true, "每页数据条数" )))
					.addNode(new FieldNode("TellerNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "TellerNo", 20,0, false, "柜员号" )))
					.addNode(new FieldNode("branchId", new MsgField(ContentEnum.MessageType.STRING.toString(), "branchId", 30,0, false, "经办机构" )))
					.addNode(new FieldNode("action", new MsgField(ContentEnum.MessageType.STRING.toString(), "action", 20,0, false, "ESB接口服务码" )))
					.addNode(new FieldNode("channelFlowNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelFlowNo", 30,0, false, "交易流水" )))
					.addNode(new FieldNode("startDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "startDate", 8,0, false, "开始日期" )))
					.addNode(new FieldNode("endDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "endDate", 8,0, false, "结束日期" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class C023001301_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("counterActionLogs",false)
							.addNode(new FieldNode("id", new MsgField(ContentEnum.MessageType.STRING.toString(), "id", 20,0, true, "交易id" )))
							.addNode(new FieldNode("transTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "transTime", 30,0, true, "交易时间" )))
							.addNode(new FieldNode("branchId", new MsgField(ContentEnum.MessageType.STRING.toString(), "branchId", 30,0, true, "经办机构" )))
							.addNode(new FieldNode("TellerNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "TellerNo", 20,0, true, "柜员号" )))
							.addNode(new FieldNode("action", new MsgField(ContentEnum.MessageType.STRING.toString(), "action", 20,0, true, "ESB接口服务码" )))
							.addNode(new FieldNode("channelFlowNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelFlowNo", 30,0, true, "交易流水" )))
							.addNode(new FieldNode("ErrorCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ErrorCode", 10,0, true, "交易错误码" )))
							.addNode(new FieldNode("ErrorMsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ErrorMsg", 255,0, false, "交易错误信息" )))
							).addNode(new FieldNode("pageNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageNo", 10,0, true, "当前页数" )))
					.addNode(new FieldNode("pageSize", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageSize", 10,0, true, "每页数据条数" )))
					.addNode(new FieldNode("totalSize", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalSize", 10,0, true, "总记录数" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
