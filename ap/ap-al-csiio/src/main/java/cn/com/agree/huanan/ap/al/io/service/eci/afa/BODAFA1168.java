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
 * BASESVC BODAFA1168  社保IC卡新领卡申请 
 *  BODAFA1168 
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1168 extends EciChannelService {

	private static BODAFA1168_I i = new BODAFA1168_I();
	private static BODAFA1168_O o = new BODAFA1168_O();
	public BODAFA1168() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1168_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("yybz", new MsgField(ContentEnum.MessageType.STRING.toString(), "yybz", 4,0, false, "默认" )))
					.addNode(new FieldNode("sjbbz", new MsgField(ContentEnum.MessageType.STRING.toString(), "sjbbz", 3,0, false, "默认" )))
					.addNode(new FieldNode("fqbz", new MsgField(ContentEnum.MessageType.STRING.toString(), "fqbz", 1,0, false, "操作类型" )))
					.addNode(new FieldNode("ywlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "ywlx", 1,0, false, "操作请求" )))
					.addNode(new FieldNode("yhbh", new MsgField(ContentEnum.MessageType.STRING.toString(), "yhbh", 20,0, false, "发卡银行编号" )))
					.addNode(new FieldNode("yhmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "yhmc", 20,0, false, "发卡银行名称" )))
					.addNode(new FieldNode("yhwdbh", new MsgField(ContentEnum.MessageType.STRING.toString(), "yhwdbh", 30,0, false, "银行网点编号" )))
					.addNode(new FieldNode("zxhzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "zxhzh", 20,0, false, "照相回执号" )))
					.addNode(new FieldNode("ybzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ybzh", 20,0, false, "医保账号" )))
					.addNode(new FieldNode("zjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zjhm", 20,0, false, "证件号码" )))
					.addNode(new FieldNode("xm", new MsgField(ContentEnum.MessageType.STRING.toString(), "xm", 10,0, false, "姓名" )))
					.addNode(new FieldNode("xb", new MsgField(ContentEnum.MessageType.STRING.toString(), "xb", 2,0, false, "性别" )))
					.addNode(new FieldNode("zjlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "zjlx", 5,0, false, "证件类型" )))
					.addNode(new FieldNode("csrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "csrq", 10,0, false, "出生日期" )))
					.addNode(new FieldNode("zy", new MsgField(ContentEnum.MessageType.STRING.toString(), "zy", 10,0, false, "职业" )))
					.addNode(new FieldNode("zymc", new MsgField(ContentEnum.MessageType.STRING.toString(), "zymc", 0,0, false, "职业名称" )))
					.addNode(new FieldNode("mz", new MsgField(ContentEnum.MessageType.STRING.toString(), "mz", 10,0, false, "名族" )))
					.addNode(new FieldNode("mzmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "mzmc", 20,0, false, "名族名称" )))
					.addNode(new FieldNode("jg", new MsgField(ContentEnum.MessageType.STRING.toString(), "jg", 80,0, false, "籍贯" )))
					.addNode(new FieldNode("zjyxq", new MsgField(ContentEnum.MessageType.STRING.toString(), "zjyxq", 10,0, false, "证件有效期" )))
					.addNode(new FieldNode("sjdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "sjdh", 20,0, false, "手机电话" )))
					.addNode(new FieldNode("zzdz", new MsgField(ContentEnum.MessageType.STRING.toString(), "zzdz", 80,0, false, "住宅地址" )))
					.addNode(new FieldNode("hjszd", new MsgField(ContentEnum.MessageType.STRING.toString(), "hjszd", 80,0, false, "户籍所在地" )))
					.addNode(new FieldNode("whcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "whcd", 10,0, false, "文化程度" )))
					.addNode(new FieldNode("whcdmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "whcdmc", 20,0, false, "文化程度名称" )))
					.addNode(new FieldNode("hyzk", new MsgField(ContentEnum.MessageType.STRING.toString(), "hyzk", 5,0, false, "婚姻状况" )))
					.addNode(new FieldNode("hyzkmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "hyzkmc", 20,0, false, "婚姻状况名称" )))
					.addNode(new FieldNode("grjyhltxzt", new MsgField(ContentEnum.MessageType.STRING.toString(), "grjyhltxzt", 5,0, false, "工作状况" )))
					.addNode(new FieldNode("gzzkmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "gzzkmc", 20,0, false, "工作状况名称" )))
					.addNode(new FieldNode("sshy", new MsgField(ContentEnum.MessageType.STRING.toString(), "sshy", 10,0, false, "所属行业" )))
					.addNode(new FieldNode("sshymc", new MsgField(ContentEnum.MessageType.STRING.toString(), "sshymc", 30,0, false, "所属行业名称" )))
					.addNode(new FieldNode("dzjlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "dzjlx", 10,0, false, "监护人证件类型" )))
					.addNode(new FieldNode("dcjsfz", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcjsfz", 20,0, false, "监护人证件号码" )))
					.addNode(new FieldNode("dlrxm", new MsgField(ContentEnum.MessageType.STRING.toString(), "dlrxm", 10,0, false, "监护人姓名" )))
					.addNode(new FieldNode("zdlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdlx", 1,0, false, "发起业务终端类型" )))
					.addNode(new FieldNode("qqlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "qqlsh", 40,0, false, "银行流水号" )))
					.addNode(new FieldNode("ydlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ydlsh", 40,0, false, "社保流水号" )))
					.addNode(new FieldNode("custno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 40,0, false, "客户号" )))
					.addNode(new FieldNode("lkwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "lkwd", 10,0, true, "领卡网点" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1168_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("yybz", new MsgField(ContentEnum.MessageType.STRING.toString(), "yybz", 4,0, false, "默认" )))
					.addNode(new FieldNode("sjbbz", new MsgField(ContentEnum.MessageType.STRING.toString(), "sjbbz", 3,0, false, "默认" )))
					.addNode(new FieldNode("fqbz", new MsgField(ContentEnum.MessageType.STRING.toString(), "fqbz", 1,0, false, "操作类型" )))
					.addNode(new FieldNode("ywlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "ywlx", 1,0, false, "操作请求" )))
					.addNode(new FieldNode("zjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zjhm", 20,0, false, "证件号码" )))
					.addNode(new FieldNode("xm", new MsgField(ContentEnum.MessageType.STRING.toString(), "xm", 10,0, false, "姓名" )))
					.addNode(new FieldNode("grsxh", new MsgField(ContentEnum.MessageType.STRING.toString(), "grsxh", 20,0, false, "个人顺序号" )))
					.addNode(new FieldNode("qqlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "qqlsh", 40,0, false, "银行流水" )))
					.addNode(new FieldNode("ydlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ydlsh", 40,0, false, "社保流水" )))
					.addNode(new FieldNode("cljg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cljg", 1,0, false, "通过标识码" )))
					.addNode(new FieldNode("clxx", new MsgField(ContentEnum.MessageType.STRING.toString(), "clxx", 255,0, false, "错误信息" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

