package cn.com.agree.huanan.ap.al.io.service.eci.nib;

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
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;

/**
 * BASESVC BODNIB0146  结构性产品查询 
 *  BODNIB0146 regflw
 *  新个人网银
 * @author XZF
 */
@Component
public class BODNIB0146 extends EciChannelService {

	private static BODNIB0146_I i = new BODNIB0146_I();
	private static BODNIB0146_O o = new BODNIB0146_O();
	public BODNIB0146() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNIB0146_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("action", new MsgField(ContentEnum.MessageType.STRING.toString(), "action", 1024,0, false, "处理码" )))
					.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 3,0, false, "上送渠道" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 3,0, false, "产品状态" )))
					.addNode(new FieldNode("bgtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "bgtime", 30,0, false, "认购起始日及时间" )))
					.addNode(new FieldNode("edtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "edtime", 30,0, false, "认购结束日及时间" )))
					.addNode(new FieldNode("page", new MsgField(ContentEnum.MessageType.STRING.toString(), "page", 3,0, true, "当前页数" )))
					.addNode(new FieldNode("pagesize", new MsgField(ContentEnum.MessageType.STRING.toString(), "pagesize", 3,0, true, "当前页数要查询的条数" )))
					.addNode(new FieldNode("prodno", new MsgField(ContentEnum.MessageType.STRING.toString(), "prodno", 30,0, false, "产品代码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODNIB0146_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 21,0, false, "本次返回条数" )))
					.addNode(new FieldNode("total", new MsgField(ContentEnum.MessageType.STRING.toString(), "total", 20,0, false, "总条数" )))
					.addNode(new ArrayNode("bodrcd",false,"procd_list")
							.addNode(new FieldNode("prodno", new MsgField(ContentEnum.MessageType.STRING.toString(), "prodno", 30,0, false, "产品代码" )))
							.addNode(new FieldNode("prodna", new MsgField(ContentEnum.MessageType.STRING.toString(), "prodna", 60,0, false, "产品名称" )))
							.addNode(new FieldNode("crcycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "crcycd", 2,0, false, "币种" )))
							.addNode(new FieldNode("flwlir", new MsgField(ContentEnum.MessageType.STRING.toString(), "flwlir", 20,0, false, "保底利率" )))
							.addNode(new FieldNode("instrt", new MsgField(ContentEnum.MessageType.STRING.toString(), "instrt", 20,0, false, "预期收益利率" )))
							.addNode(new FieldNode("cvrtmd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cvrtmd", 20,0, false, "日利率折算值" )))
							.addNode(new FieldNode("statam", new MsgField(ContentEnum.MessageType.STRING.toString(), "statam", 30,0, false, "起存金额" )))
							.addNode(new FieldNode("extdam", new MsgField(ContentEnum.MessageType.STRING.toString(), "extdam", 30,0, false, "递增金额" )))
							.addNode(new FieldNode("prodam", new MsgField(ContentEnum.MessageType.STRING.toString(), "prodam", 30,0, false, "产品规模" )))
							.addNode(new FieldNode("bgtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "bgtime", 20,0, false, "认购起始日及时间" )))
							.addNode(new FieldNode("edtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "edtime", 20,0, false, "认购结束日及时间" )))
							.addNode(new FieldNode("bgindt", new MsgField(ContentEnum.MessageType.STRING.toString(), "bgindt", 20,0, false, "起息日" )))
							.addNode(new FieldNode("matudt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matudt", 20,0, false, "到期日" )))
							.addNode(new FieldNode("servtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "servtp", 60,0, false, "有效渠道串" )))
							.addNode(new FieldNode("lastbl", new MsgField(ContentEnum.MessageType.STRING.toString(), "lastbl", 20,0, false, "剩余额度" )))
							.addNode(new FieldNode("culmam", new MsgField(ContentEnum.MessageType.STRING.toString(), "culmam", 20,0, false, "单客户控制金额" )))
							.addNode(new FieldNode("cdlmam", new MsgField(ContentEnum.MessageType.STRING.toString(), "cdlmam", 20,0, false, "单卡控制金额" )))
							.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 10,0, false, "渠道" )))
							.addNode(new FieldNode("risklv", new MsgField(ContentEnum.MessageType.STRING.toString(), "risklv", 10,0, false, "风险等级" )))
							.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 2,0, false, "产品状态" )))
							.addNode(new FieldNode("inptdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "inptdt", 20,0, false, "录入日期" )))
							.addNode(new FieldNode("inptsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "inptsq", 30,0, false, "录入流水" )))
							.addNode(new FieldNode("inptus", new MsgField(ContentEnum.MessageType.STRING.toString(), "inptus", 20,0, false, "录入柜员" )))
							.addNode(new FieldNode("inptbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "inptbr", 20,0, false, "录入机构" )))
							.addNode(new FieldNode("inptck", new MsgField(ContentEnum.MessageType.STRING.toString(), "inptck", 20,0, false, "录入授权柜员" )))
							.addNode(new FieldNode("termcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "termcd", 20,0, false, "存期" )))
							.addNode(new FieldNode("smbyam", new MsgField(ContentEnum.MessageType.STRING.toString(), "smbyam", 20,0, false, "总认购金额" )))
							.addNode(new FieldNode("filepath", new MsgField(ContentEnum.MessageType.STRING.toString(), "filepath", 200,0, false, "产品说明书路径" )))
							.addNode(new FieldNode("content", new MsgField(ContentEnum.MessageType.INT.toString(), "content", 7,0, false, "循环 结束" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

