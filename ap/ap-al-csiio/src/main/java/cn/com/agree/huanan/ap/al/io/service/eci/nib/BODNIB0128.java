package cn.com.agree.huanan.ap.al.io.service.eci.nib;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODNIB0128  银保产品代码查询
 * BODNIB0128 gryb02 regflw
 *  新核心系统
 * @author STJ
 */
@Component
public class BODNIB0128 extends EciChannelService {
/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCBODNIB0128', 'BASESVC', '新核心系统', 'BODNIB0128', '', 'ECI.NIB', 'ECI-NIB系统', 'BODNIB0128', '银保产品代码查询', 'gryb02', 'regflw', '', '1', '0', '');

*/
	private static BODNIB0128_I i = new BODNIB0128_I();
	private static BODNIB0128_O o = new BODNIB0128_O();

	public BODNIB0128() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODNIB0128_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
.addStructNode(new StructNode("APPBody", true, "Body")
.addNode(new FieldNode("action", new MsgField(ContentEnum.MessageType.STRING.toString(), "action", 1024,0, true, "处理码" )))
.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 1024,0, true, "上送渠道" )))
.addNode(new FieldNode("companyCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyCode", 1024,0, false, "保险公司产品代码" )))
);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODNIB0128_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
			.addNode(new ArrayNode("bodrcd", true,"prod_list")
					.addNode(new FieldNode("prdcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdcode", 1024,0, true, "产品代码" )))
					.addNode(new FieldNode("prdname", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdname", 1024,0, true, "产品名称" )))
					)
			.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 1024,0, true, "返回条数" )))
			);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
