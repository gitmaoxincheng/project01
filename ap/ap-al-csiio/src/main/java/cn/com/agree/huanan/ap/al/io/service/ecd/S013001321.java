package cn.com.agree.huanan.ap.al.io.service.ecd;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.S013001321 柜员机构信息查询.柜员未处理事项查询 
 * S0130013.21 qyusunitm
 * 0227 票据系统
 * @author JZF
 */
@Component
public class S013001321 extends EsbChannelService {
	/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCS013001321', 'BASESVC', '票据系统', 'S013001321', '柜员机构信息查询', 'ESB', 'ESB_ECD系统', 'S0130013', '柜员未处理事项查询', '21','qyusunitm' ,'柜员机构信息查询', '1', '0', '柜员机构信息查询');

	 */
	private static S013001321_I i = new S013001321_I();
	private static S013001321_O o = new S013001321_O();

	public S013001321() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013001321_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("strtellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "strtellerno", 10,0, true, "签退柜员" )))
					.addNode(new FieldNode("strbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "strbrno", 12,0, true, "签退机构" )))
					.addNode(new FieldNode("pagenum", new MsgField(ContentEnum.MessageType.INT.toString(), "pagenum", 10,0, false, "查询页码" )))
					.addNode(new FieldNode("pagesize", new MsgField(ContentEnum.MessageType.INT.toString(), "pagesize", 10,0, false, "查询条数" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S013001321_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("infolistnm", new MsgField(ContentEnum.MessageType.INT.toString(), "infolistnm", 10,0, true, "提示记录数" )))
					.addNode(new ArrayNode("info_list",false)
							.addNode(new FieldNode("hintinfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "hintinfo", 1024,0, true, "未处理事项" )))
							.addNode(new FieldNode("sysid", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysid", 4,0, true, "系统标识" )))
							.addNode(new FieldNode("sysname", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysname", 60,0, true, "系统名称" )))
							.addNode(new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno", 10,0, true, "柜员号" )))
							.addNode(new FieldNode("brno", new MsgField(ContentEnum.MessageType.STRING.toString(), "brno", 12,0, true, "网点号" )))
							.addNode(new FieldNode("islimit", new MsgField(ContentEnum.MessageType.STRING.toString(), "islimit", 1,0, true, "是否限制" )))
							.addNode(new FieldNode("serialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "serialno", 32,0, true, "流水号" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
