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
 * BASESVC.S013001324 柜员机构信息查询.	机构日终签退待办事项查询 
 * S0130013.24 005021
 * 0000 柜员管理
 * @author JZF
 */
@Component
public class S013001324 extends EsbChannelService {
	/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCS013001324', 'BASESVC', '柜员管理', 'S013001324', '柜员机构信息查询', 'ESB', 'ESB_afa系统', 'S0130013', '	机构日终签退待办事项查询', '24','005021' ,'柜员机构信息查询', '1', '0', '柜员机构信息查询');

	 */
	private static S013001324_I i = new S013001324_I();
	private static S013001324_O o = new S013001324_O();

	public S013001324() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013001324_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("strtradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "strtradedate", 8,0, true, "交易日期" )))
					.addNode(new FieldNode("strbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "strbrno", 12,0, true, "查询柜员网点" )))
					.addNode(new FieldNode("strtellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "strtellerno", 10,0, true, "查询柜员" )))
					.addNode(new FieldNode("dutytp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutytp", 10,0, true, "岗位类型" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S013001324_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("totalnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalnum", 6,0, false, "总记录数" )))
					.addNode(new FieldNode("returnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "returnum", 6,0, true, "本次返回记录数" )))
					.addNode(new ArrayNode("bodrcd_list",false)
							.addNode(new FieldNode("strsysid", new MsgField(ContentEnum.MessageType.STRING.toString(), "strsysid", 4,0, false, "所属系统编号" )))
							.addNode(new FieldNode("strsyscname", new MsgField(ContentEnum.MessageType.STRING.toString(), "strsyscname", 80,0, false, "所属系统名称" )))
							.addNode(new FieldNode("todotype", new MsgField(ContentEnum.MessageType.STRING.toString(), "todotype", 10,0, false, "待办事项类型" )))
							.addNode(new FieldNode("strmsginfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "strmsginfo", 500,0, false, "提示信息" )))
							.addNode(new FieldNode("limits", new MsgField(ContentEnum.MessageType.STRING.toString(), "limits", 10,0, false, "限制标识" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
