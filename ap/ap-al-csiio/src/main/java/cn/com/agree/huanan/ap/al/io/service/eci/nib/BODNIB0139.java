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
 * BASESVC BODNIB0139  查询大额存单产品 
 *  BODNIB0139 regflw
 *  新个人网银
 * @author XZF
 */
@Component
public class BODNIB0139 extends EciChannelService {

	private static BODNIB0139_I i = new BODNIB0139_I();
	private static BODNIB0139_O o = new BODNIB0139_O();
	public BODNIB0139() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNIB0139_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("certno", new MsgField(ContentEnum.MessageType.STRING.toString(), "certno", 30,0, false, "产品代码" )))
					.addNode(new FieldNode("hstStatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "hstStatus", 1,0, false, "产品状态" )))
					.addNode(new FieldNode("page", new MsgField(ContentEnum.MessageType.STRING.toString(), "page", 10,0, false, "页码" )))
					.addNode(new FieldNode("pagesize", new MsgField(ContentEnum.MessageType.STRING.toString(), "pagesize", 10,0, false, "每页最多记录数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODNIB0139_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("page", new MsgField(ContentEnum.MessageType.STRING.toString(), "page", 10,0, true, "页码" )))
					.addNode(new FieldNode("size", new MsgField(ContentEnum.MessageType.STRING.toString(), "size", 10,0, true, "页大小" )))
					.addNode(new FieldNode("totalCount", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalCount", 10,0, true, "总条数" )))
					.addNode(new ArrayNode("bodrcd",false,"procd_list")
									.addNode(new FieldNode("certno", new MsgField(ContentEnum.MessageType.STRING.toString(), "certno", 30,0, false, "产品代码" )))
									.addNode(new FieldNode("certna", new MsgField(ContentEnum.MessageType.STRING.toString(), "certna", 60,0, false, "产品名称" )))
									.addNode(new FieldNode("crcycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "crcycd", 3,0, false, "币种" )))
									.addNode(new FieldNode("termcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "termcd", 3,0, false, "存单期限" )))
									.addNode(new FieldNode("statam", new MsgField(ContentEnum.MessageType.STRING.toString(), "statam", 18,0, false, "认购起点金额" )))
									.addNode(new FieldNode("instrt", new MsgField(ContentEnum.MessageType.STRING.toString(), "instrt", 11,0, false, "到期利率" )))
									.addNode(new FieldNode("certbl", new MsgField(ContentEnum.MessageType.STRING.toString(), "certbl", 18,0, false, "剩余额度" )))
									.addNode(new FieldNode("rgtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgtime", 40,0, false, "认购时间" )))
									.addNode(new FieldNode("bgindt", new MsgField(ContentEnum.MessageType.STRING.toString(), "bgindt", 8,0, false, "产品起息日" )))
									.addNode(new FieldNode("matudt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matudt", 8,0, false, "到期日期" )))
									.addNode(new FieldNode("extdam", new MsgField(ContentEnum.MessageType.STRING.toString(), "extdam", 18,0, false, "追加金额" )))
									.addNode(new FieldNode("inrttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "inrttp", 8,0, false, "利率类型" )))
									.addNode(new FieldNode("rcintg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcintg", 2,0, false, "赎回计息方式" )))
									.addNode(new FieldNode("tocebl", new MsgField(ContentEnum.MessageType.STRING.toString(), "tocebl", 18,0, false, "产品总额度" )))
									.addNode(new FieldNode("filePath", new MsgField(ContentEnum.MessageType.STRING.toString(), "filePath", 255,0, false, "路径" )))
									.addNode(new FieldNode("hstStatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "hstStatus", 1,0, false, "产品状态" )))
									.addNode(new FieldNode("incmtm", new MsgField(ContentEnum.MessageType.STRING.toString(), "incmtm", 8,0, false, "付息频率" )))
									.addNode(new FieldNode("pyindt", new MsgField(ContentEnum.MessageType.STRING.toString(), "pyindt", 20,0, false, "付息天数" )))
									.addNode(new FieldNode("nwopac", new MsgField(ContentEnum.MessageType.STRING.toString(), "nwopac", 1,0, false, "即时起息标志" )))
									.addNode(new FieldNode("systdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "systdt", 8,0, false, "核心系统日期" )))
									.addNode(new FieldNode("bgtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "bgtime", 20,0, false, "认购起始日及时间" )))
									.addNode(new FieldNode("edtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "edtime", 20,0, false, "认购结束日及时间" )))
									.addNode(new FieldNode("advdrawratesr", new MsgField(ContentEnum.MessageType.STRING.toString(), "advdrawratesr", 10,0, false, "提前支取利率来源" )))
									.addNode(new FieldNode("advdrawrateway", new MsgField(ContentEnum.MessageType.STRING.toString(), "advdrawrateway", 10,0, false, "提前支取利率方式" )))
									));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

