package cn.com.agree.huanan.ap.al.io.service.afa;

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
 * BASESVC.S013001330 柜员机构信息查询.机构未处理事项汇总查询 
 * S0130013.30 qrbrse
 * 0000 前置
 * @author JZF
 */
@Component
public class S013001330 extends EsbChannelService {
	/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCS013001330', 'BASESVC', '前置ECI', 'S013001330', '柜员机构信息查询', 'ESB', 'ESB_afa系统', 'S0130013', '机构未处理事项汇总查询', '30','qrbrse' ,'柜员机构信息查询', '1', '0', '柜员机构信息查询');

	 */
	private static S013001330_I i = new S013001330_I();
	private static S013001330_O o = new S013001330_O();

	public S013001330() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013001330_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("strtradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "strtradedate", 8,0, true, "交易日期" )))
					.addNode(new FieldNode("strtellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "strtellerno", 10,0, true, "查询柜员" )))
					.addNode(new FieldNode("strbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "strbrno", 12,0, true, "查询网点" )))
					.addNode(new FieldNode("strsysid", new MsgField(ContentEnum.MessageType.STRING.toString(), "strsysid", 4,0, true, "所属系统号" )))
					.addNode(new FieldNode("todotype", new MsgField(ContentEnum.MessageType.STRING.toString(), "todotype", 10,0, true, "待办事项类型" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S013001330_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("totalnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalnum", 6,0, false, "总记录数" )))
					.addNode(new FieldNode("returnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "returnum", 6,0, false, "本次返回记录数" )))
					.addNode(new ArrayNode("bodrcd_list",false)
							.addNode(new FieldNode("strsysid", new MsgField(ContentEnum.MessageType.STRING.toString(), "strsysid", 4,0, false, "所属系统编号" )))
							.addNode(new FieldNode("tradeserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradeserno", 4,0, false, "前置流水号" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
