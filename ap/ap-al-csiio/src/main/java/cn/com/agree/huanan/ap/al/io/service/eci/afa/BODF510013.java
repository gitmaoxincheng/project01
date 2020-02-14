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
 * BASESVC BODF510013  保单信息查询 
 *  BODF510013 regflw
 *  综合前置
 * @author XZF
 */
@Component
public class BODF510013 extends EciChannelService {

	private static BODF510013_I i = new BODF510013_I();
	private static BODF510013_O o = new BODF510013_O();
	public BODF510013() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF510013_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("gsdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsdm", 4,0, false, "公司代码" )))
					.addNode(new FieldNode("cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpdm", 10,0, false, "险种代码" )))
					.addNode(new FieldNode("bdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bdh", 30,0, false, "保单号" )))
					.addNode(new FieldNode("bdmm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bdmm", 8,0, false, "保单密码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF510013_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("respcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "respcode", 7,0, false, "响应码" )))
					.addNode(new FieldNode("respmsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "respmsg", 50,0, false, "响应信息" )))
					.addNode(new FieldNode("ptlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptlsh", 24,0, false, "平台流水号" )))
					.addNode(new FieldNode("bdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bdh", 30,0, false, "保单号" )))
					.addNode(new FieldNode("tbdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbdh", 32,0, false, "投保单号" )))
					.addNode(new FieldNode("bdysh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bdysh", 32,0, false, "保单印刷号" )))
					.addNode(new FieldNode("sjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "sjhm", 32,0, false, "收据号码(发票印刷号)" )))
					.addNode(new FieldNode("cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpdm", 12,0, false, "险种代码" )))
					.addNode(new FieldNode("tbrxm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbr_xm", 30,0, false, "投保人姓名" )))
					.addNode(new FieldNode("tbrzjlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbr_zjlx", 2,0, false, "投保人证件类型" )))
					.addNode(new FieldNode("tbrzjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbr_zjhm", 18,0, false, "投保人证件号码" )))
					.addNode(new FieldNode("tbrybbrgx", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbr_ybbrgx", 3,0, false, "与被保人关系" )))
					.addNode(new FieldNode("bbrxm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbr_xm", 30,0, false, "被保人姓名" )))
					.addNode(new FieldNode("bbrzjlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbr_zjlx", 2,0, false, "被保人证件类型" )))
					.addNode(new FieldNode("bbrzjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbr_zjhm", 18,0, false, "被保人证件号码" )))
					.addNode(new FieldNode("jffs", new MsgField(ContentEnum.MessageType.STRING.toString(), "jffs", 2,0, false, "缴费方式" )))
					.addNode(new FieldNode("jfje", new MsgField(ContentEnum.MessageType.STRING.toString(), "jfje", 16,0, false, "缴费金额" )))
					.addNode(new FieldNode("bxje", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxje", 16,0, false, "保额" )))
					.addNode(new FieldNode("tbfs", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbfs", 3,0, false, "投保份数" )))
					.addNode(new FieldNode("tbrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrq", 8,0, false, "投保日期" )))
					.addNode(new FieldNode("jfnx", new MsgField(ContentEnum.MessageType.STRING.toString(), "jfnx", 2,0, false, "缴费年限" )))
					.addNode(new FieldNode("bznx", new MsgField(ContentEnum.MessageType.STRING.toString(), "bznx", 2,0, false, "保障年期" )))
					.addNode(new FieldNode("sxrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "sxrq", 8,0, false, "生效日期" )))
					.addNode(new FieldNode("bdzt", new MsgField(ContentEnum.MessageType.STRING.toString(), "bdzt", 1,0, false, "保单状态" )))
					.addNode(new FieldNode("cpmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpmc", 30,0, false, "产品名称" )))
					.addNode(new FieldNode("gmqd", new MsgField(ContentEnum.MessageType.STRING.toString(), "gmqd", 30,0, false, "购买渠道" )))
					.addNode(new FieldNode("gsmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsmc", 30,0, false, "保险公司名称" )))
					.addNode(new FieldNode("cbrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "cbrq", 8,0, false, "承保日期" )))
					.addNode(new FieldNode("zhjz", new MsgField(ContentEnum.MessageType.STRING.toString(), "zhjz", 30,0, false, "账户价值" )))
					.addNode(new FieldNode("zhjzrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "zhjzrq", 8,0, false, "账户价值日期" )))
					.addNode(new FieldNode("jfnqlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "jfnqlx", 8,0, false, "缴费年期类型" )))
					.addNode(new FieldNode("bznqlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "bznqlx", 8,0, false, "保障年期类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

