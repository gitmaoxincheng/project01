package cn.com.agree.huanan.ap.al.io.service.afa;

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
 * BASESVC.S012000505 柜员信息管理.柜员签退 
 * S0120005.05 005011
 * 0000 柜员管理
 * @author XXX
 */
@Component
public class S012000505 extends EsbChannelService {

	private static S012000505_I i = new S012000505_I();
	private static S012000505_O o = new S012000505_O();
	public S012000505() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S012000505_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("prcscd", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcscd", 6,0, true, "处理码" )))
					.addNode(new FieldNode("strtellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "strtellerno", 10,0, true, "柜员号" )))
					.addNode(new FieldNode("strsysid", new MsgField(ContentEnum.MessageType.STRING.toString(), "strsysid", 6,0, true, "系统标识" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S012000505_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("zoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "zoneno", 10,0, false, "分行号" )))
					.addNode(new FieldNode("zonenoname", new MsgField(ContentEnum.MessageType.STRING.toString(), "zonenoname", 60,0, false, "分行名称" )))
					.addNode(new FieldNode("mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mbrno", 10,0, false, "支行号" )))
					.addNode(new FieldNode("mbrnoname", new MsgField(ContentEnum.MessageType.STRING.toString(), "mbrnoname", 60,0, false, "支行名称" )))
					.addNode(new FieldNode("brno", new MsgField(ContentEnum.MessageType.STRING.toString(), "brno", 10,0, false, "网点号" )))
					.addNode(new FieldNode("brnoname", new MsgField(ContentEnum.MessageType.STRING.toString(), "brnoname", 60,0, false, "网点名称" )))
					.addNode(new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno", 10,0, false, "柜员号" )))
					.addNode(new FieldNode("tellernoname", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellernoname", 60,0, false, "柜员名称" )))
					.addNode(new FieldNode("csbxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "csbxno", 10,0, false, "柜员钱箱号" )))
					.addNode(new FieldNode("csbxtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "csbxtp", 60,0, false, "尾箱类型" )))
					.addNode(new FieldNode("dutytp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutytp", 10,0, false, "岗位类型" )))
					.addNode(new FieldNode("dutytpname", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutytpname", 60,0, false, "岗位名称" )))
					.addNode(new FieldNode("dutyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutyno", 20,0, false, "实体岗位编号" )))
					.addNode(new FieldNode("dutynoname", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutynoname", 60,0, false, "实体岗位名称" )))
					.addNode(new FieldNode("sessid", new MsgField(ContentEnum.MessageType.STRING.toString(), "sessid", 32,0, false, "会话标识" )))
					.addNode(new FieldNode("sysworkdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysworkdate", 8,0, false, "主机日期" )))
					.addNode(new FieldNode("glsworkdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "glsworkdate", 8,0, false, "会计日期" )))
					.addNode(new FieldNode("info", new MsgField(ContentEnum.MessageType.STRING.toString(), "info", 100,0, false, "公告信息" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

