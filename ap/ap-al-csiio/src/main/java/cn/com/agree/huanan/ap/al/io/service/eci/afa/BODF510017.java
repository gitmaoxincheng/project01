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
 * BASESVC BODF510017  流水列表查询 
 *  BODF510017 regflw
 *  综合前置
 * @author XZF
 */
@Component
public class BODF510017 extends EciChannelService {

	private static BODF510017_I i = new BODF510017_I();
	private static BODF510017_O o = new BODF510017_O();
	public BODF510017() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF510017_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("jyzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyzh", 30,0, false, "交易帐号" )))
					.addNode(new FieldNode("ksrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "ksrq", 8,0, false, "开始日期" )))
					.addNode(new FieldNode("jzrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "jzrq", 8,0, false, "截止日期" )))
					.addNode(new FieldNode("gsdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsdm", 6,0, false, "公司代码" )))
					.addNode(new FieldNode("cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpdm", 12,0, false, "产品代码" )))
					.addNode(new FieldNode("cxjydm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cxjydm", 6,0, false, "查询交易代码" )))
					.addNode(new FieldNode("ptlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptlsh", 24,0, false, "平台流水号" )))
					.addNode(new FieldNode("jyzt", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyzt", 1,0, false, "交易状态" )))
					.addNode(new FieldNode("bdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bdh", 30,0, false, "保单号" )))
					.addNode(new FieldNode("offset", new MsgField(ContentEnum.MessageType.STRING.toString(), "offset", 15,0, false, "定位串" )))
					.addNode(new FieldNode("querynum", new MsgField(ContentEnum.MessageType.STRING.toString(), "querynum", 15,0, false, "查询行数" )))
					.addNode(new FieldNode("queryflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "queryflag", 1,0, false, "是否为柜员流水查询" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF510017_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("totnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totnum", 15,0, false, "总行数" )))
					.addNode(new FieldNode("retnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "retnum", 15,0, false, "本次返回行数" )))
					.addNode(new FieldNode("offset", new MsgField(ContentEnum.MessageType.STRING.toString(), "offset", 15,0, false, "定位串" )))
					.addNode(new ArrayNode("bodrcd",true,"trandtl_list")
							.addNode(new FieldNode("jyrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyrq", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("jysj", new MsgField(ContentEnum.MessageType.STRING.toString(), "jysj", 6,0, false, "交易时间" )))
							.addNode(new FieldNode("ptlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptlsh", 24,0, false, "平台流水号" )))
							.addNode(new FieldNode("jydm", new MsgField(ContentEnum.MessageType.STRING.toString(), "jydm", 6,0, false, "交易码" )))
							.addNode(new FieldNode("cpmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpmc", 250,0, false, "产品名称" )))
							.addNode(new FieldNode("gsdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsdm", 6,0, false, "公司代码" )))
							.addNode(new FieldNode("cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpdm", 12,0, false, "产品代码" )))
							.addNode(new FieldNode("bdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bdh", 30,0, false, "保单号" )))
							.addNode(new FieldNode("Jyzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "Jyzh", 30,0, false, "交易账号" )))
							.addNode(new FieldNode("jyje", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyje", 15,0, false, "交易金额" )))
							.addNode(new FieldNode("jyzt", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyzt", 1,0, false, "交易状态" )))
							.addNode(new FieldNode("jyzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyzh", 32,0, false, "交易账号" )))
							.addNode(new FieldNode("jyjg", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyjg", 16,0, false, "交易机构" )))
							.addNode(new FieldNode("jygy", new MsgField(ContentEnum.MessageType.STRING.toString(), "jygy", 8,0, false, "交易柜员" )))
							.addNode(new FieldNode("sxf", new MsgField(ContentEnum.MessageType.STRING.toString(), "sxf", 20,0, false, "手续费" )))
							.addNode(new FieldNode("cdf", new MsgField(ContentEnum.MessageType.STRING.toString(), "cdf", 20,0, false, "出单费" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

