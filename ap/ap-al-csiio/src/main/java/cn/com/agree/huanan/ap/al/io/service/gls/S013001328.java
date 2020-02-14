package cn.com.agree.huanan.ap.al.io.service.gls;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbGlsChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.S013001328 柜员机构信息查询.柜员未处理事项汇总查询 
 * S0130013.28 qrusse
 * 0009 大总账
 * @author JZF
 */
@Component
public class S013001328 extends EsbGlsChannelService {
	/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCS013001328', 'BASESVC', '大总账', 'S013001328', '柜员机构信息查询', 'ESB', 'ESB_gls系统', 'S0130013', '柜员未处理事项汇总查询', '28','qrusse' ,'柜员机构信息查询', '1', '0', '柜员机构信息查询');

	 */
	private static S013001328_I i = new S013001328_I();
	private static S013001328_O o = new S013001328_O();

	public S013001328() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013001328_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("tranus", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranus", 10,0, true, "柜员号" )))
					.addNode(new FieldNode("tranbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranbr", 12,0, true, "机构代码" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S013001328_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("tolnum", new MsgField(ContentEnum.MessageType.INT.toString(), "tolnum", 10,0, true, "总笔数" )))
					.addNode(new FieldNode("systid", new MsgField(ContentEnum.MessageType.STRING.toString(), "systid", 4,0, true, "系统标识" )))
					.addNode(new FieldNode("htinfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "htinfo", 1024,0, true, "提示信息" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
