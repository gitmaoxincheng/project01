package cn.com.agree.huanan.ap.al.io.service.bpm;

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
 * BASESVC.S012002503 系统操作员信息管理.系统操作员密码修改 
 * S0120025.03 sysoper_modify
 * 0321 参数管理平台
 * @author STJ
 */
@Component
public class S012002503 extends EsbChannelService {
/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCS012002503', 'BASESVC', '参数管理平台', 'S012002503', '系统操作员信息管理', 'BPM', 'ESB_bpm系统', 'S0120025', '系统操作员密码修改', '03','sysoper_modify' ,'系统操作员信息管理', '1', '0', '系统操作员信息管理');

*/
	private static S012002503_I i = new S012002503_I();
	private static S012002503_O o = new S012002503_O();

	public S012002503() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class S012002503_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
			.addNode(new FieldNode("opwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "opwd", 10240,0, true, "旧密码" )))
			.addNode(new FieldNode("npwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "npwd", 10240,0, true, "新密码" )))
			.addNode(new FieldNode("reqip", new MsgField(ContentEnum.MessageType.STRING.toString(), "reqip", 23,0, false, "发起IP" )))
			.addNode(new FieldNode("reqmac", new MsgField(ContentEnum.MessageType.STRING.toString(), "reqmac", 45,0, false, "发起MAC" )))
			.addNode(new FieldNode("sysid", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysid", 4,0, false, "修改方系统编号" )))
			);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S012002503_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
