package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODAFA1167  社保IC卡办卡情况查询 
 *  BODAFA1167 886433
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1167 extends EciChannelService {

	private static BODAFA1167_I i = new BODAFA1167_I();
	private static BODAFA1167_O o = new BODAFA1167_O();
	public BODAFA1167() {
		requestFormat.add(i);
		responseFormat.add(o);
	}  

	public static class BODAFA1167_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("yybz", new MsgField(ContentEnum.MessageType.STRING.toString(), "yybz", 4,0, false, "默认" )))
					.addNode(new FieldNode("sjbbz", new MsgField(ContentEnum.MessageType.STRING.toString(), "sjbbz", 3,0, false, "默认" )))
					.addNode(new FieldNode("fqbz", new MsgField(ContentEnum.MessageType.STRING.toString(), "fqbz", 1,0, false, "操作类型" )))
					.addNode(new FieldNode("ywlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "ywlx", 1,0, false, "操作请求" )))
					.addNode(new FieldNode("yhbh", new MsgField(ContentEnum.MessageType.STRING.toString(), "yhbh", 20,0, false, "发卡银行编号" )))
					.addNode(new FieldNode("yhwdbh", new MsgField(ContentEnum.MessageType.STRING.toString(), "yhwdbh", 30,0, false, "银行网点编号" )))
					.addNode(new FieldNode("yhwdmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "yhwdmc", 20,0, false, "银行网点名称" )))
					.addNode(new FieldNode("zxhzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "zxhzh", 20,0, true, "相片回执号" )))
					.addNode(new FieldNode("zjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zjhm", 20,0, true, "证件号码" )))
					.addNode(new FieldNode("sjdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "sjdh", 20,0, true, "手机号码" )))
					.addNode(new FieldNode("xm", new MsgField(ContentEnum.MessageType.STRING.toString(), "xm", 50,0, true, "姓名" )))
					.addNode(new FieldNode("qqlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "qqlsh", 40,0, false, "银行流水号" )))
					.addNode(new FieldNode("ydlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ydlsh", 40,0, false, "社保流水号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1167_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("yybz", new MsgField(ContentEnum.MessageType.STRING.toString(), "yybz", 4,0, false, "默认" )))
					.addNode(new FieldNode("sjbbz", new MsgField(ContentEnum.MessageType.STRING.toString(), "sjbbz", 3,0, false, "默认" )))
					.addNode(new FieldNode("fqbz", new MsgField(ContentEnum.MessageType.STRING.toString(), "fqbz", 1,0, false, "操作类型" )))
					.addNode(new FieldNode("ywlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "ywlx", 1,0, false, "操作请求" )))
					.addNode(new FieldNode("zjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zjhm", 20,0, false, "证件号码" )))
					.addNode(new FieldNode("grsxh", new MsgField(ContentEnum.MessageType.STRING.toString(), "grsxh", 20,0, false, "个人顺序号" )))
					.addNode(new FieldNode("zxhzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "zxhzh", 20,0, false, "相片回执号" )))
					.addNode(new FieldNode("ywzpsj", new MsgField(ContentEnum.MessageType.STRING.toString(), "ywzpsj", 20,0, false, "base64字符串" )))
					.addNode(new FieldNode("dwdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "dwdm", 20,0, false, "单位编号" )))
					.addNode(new FieldNode("dwmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "dwmc", 20,0, false, "单位名称" )))				
					.addNode(new FieldNode("sbjgh", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbjgh", 20,0, false, "社保机构号" )))
					.addNode(new FieldNode("qqlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "qqlsh", 40,0, false, "银行流水" )))
					.addNode(new FieldNode("ydlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ydlsh", 40,0, false, "社保流水" )))
					.addNode(new FieldNode("cljg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cljg", 40,0, false, "通过标识码" )))
					.addNode(new FieldNode("clxx", new MsgField(ContentEnum.MessageType.STRING.toString(), "clxx", 40,0, false, "错误信息" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

