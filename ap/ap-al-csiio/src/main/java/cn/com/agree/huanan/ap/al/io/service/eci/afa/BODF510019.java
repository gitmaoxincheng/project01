package cn.com.agree.huanan.ap.al.io.service.eci.afa;

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
 * BASESVC BODF510019  流水列表查询 
 *  BODF510019 regflw
 *  综合前置
 * @author XZF
 */
@Component
public class BODF510019 extends EciChannelService {

	private static BODF510019_I i = new BODF510019_I();
	private static BODF510019_O o = new BODF510019_O();
	public BODF510019() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF510019_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("jyzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyzh", 30,0, false, "交易帐号" )))
					.addNode(new FieldNode("ksrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "ksrq", 8,0, false, "开始日期" )))
					.addNode(new FieldNode("jzrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "jzrq", 8,0, false, "截止日期" )))
					.addNode(new FieldNode("tbrZjlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrZjlx", 1,0, false, "证件类型" )))
					.addNode(new FieldNode("tbrZjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrZjhm", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("Tbrmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tbrmc", 50,0, false, "投保人名称" )))
					.addNode(new FieldNode("gsdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsdm", 6,0, false, "公司代码" )))
					.addNode(new FieldNode("cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpdm", 12,0, false, "产品代码" )))
					.addNode(new FieldNode("bdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bdh", 30,0, false, "保单号" )))
					.addNode(new FieldNode("bdzt", new MsgField(ContentEnum.MessageType.STRING.toString(), "bdzt", 1,0, false, "保单状态" )))
					.addNode(new FieldNode("tbdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbdh", 32,0, false, "投保单号" )))
					.addNode(new FieldNode("bdysh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bdysh", 32,0, false, "保单印刷号" )))
					.addNode(new FieldNode("sjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "sjhm", 32,0, false, "收据号码" )))
					.addNode(new FieldNode("offset", new MsgField(ContentEnum.MessageType.STRING.toString(), "offset", 15,0, false, "定位串" )))
					.addNode(new FieldNode("querynum", new MsgField(ContentEnum.MessageType.STRING.toString(), "querynum", 15,0, false, "查询行数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF510019_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("totnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totnum", 15,0, false, "总行数" )))
					.addNode(new FieldNode("retnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "retnum", 15,0, false, "本次返回行数" )))
					.addNode(new FieldNode("offset", new MsgField(ContentEnum.MessageType.STRING.toString(), "offset", 15,0, false, "定位串" )))
					.addNode(new ArrayNode("bodrcd",true,"bd_list")
							.addNode(new FieldNode("jyrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyrq", 30,0, false, "交易日期" )))
							.addNode(new FieldNode("ptlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptlsh", 24,0, false, "平台流水号" )))
							.addNode(new FieldNode("gsdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsdm", 6,0, false, "公司代码" )))
							.addNode(new FieldNode("cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpdm", 12,0, false, "产品代码" )))
							.addNode(new FieldNode("bdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bdh", 30,0, false, "保单号" )))
							.addNode(new FieldNode("bdzt", new MsgField(ContentEnum.MessageType.STRING.toString(), "bdzt", 1,0, false, "保单状态" )))
							.addNode(new FieldNode("Jyzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "Jyzh", 30,0, false, "交易账" )))
							.addNode(new FieldNode("jyzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyzh", 32,0, false, "交易账号" )))
							.addNode(new FieldNode("tbdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbdh", 32,0, false, "投保单号" )))
							.addNode(new FieldNode("bdysh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bdysh", 32,0, false, "保单印刷号" )))
							.addNode(new FieldNode("jyjg", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyjg", 16,0, false, "交易机构" )))
							.addNode(new FieldNode("jygy", new MsgField(ContentEnum.MessageType.STRING.toString(), "jygy", 8,0, false, "交易柜员" )))
							.addNode(new FieldNode("cpmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpmc", 30,0, false, "产品名称" )))
							.addNode(new FieldNode("gmqd", new MsgField(ContentEnum.MessageType.STRING.toString(), "gmqd", 30,0, false, "购买渠道" )))
							.addNode(new FieldNode("gsmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsmc", 30,0, false, "保险公司名称" )))
							.addNode(new FieldNode("cbrq", new MsgField(ContentEnum.MessageType.INT.toString(), "cbrq", 1024,0, false, "承保日期" )))
							.addNode(new FieldNode("jyzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyzh", 30,0, false, "首期账号" )))
							.addNode(new FieldNode("jfnqlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "jfnqlx", 1,0, false, "缴费年期类型" )))
							.addNode(new FieldNode("jfnq", new MsgField(ContentEnum.MessageType.STRING.toString(), "jfnq", 20,0, false, "缴费年期" )))
							.addNode(new FieldNode("zhjz", new MsgField(ContentEnum.MessageType.STRING.toString(), "zhjz", 20,0, false, "账户价值" )))
							.addNode(new FieldNode("zhjzrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "zhjzrq", 8,0, false, "账户价值日期" )))
							.addNode(new FieldNode("bf", new MsgField(ContentEnum.MessageType.STRING.toString(), "bf", 15,0, false, "保费" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

