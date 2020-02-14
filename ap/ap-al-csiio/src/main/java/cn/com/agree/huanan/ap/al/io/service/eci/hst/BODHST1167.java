package cn.com.agree.huanan.ap.al.io.service.eci.hst;

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
 * BASESVC BODHST1167  产品编号查询大额存单产品 
 *  BODHST1167 
 *  旧核心系统
 * @author XZF
 */
@Component
public class BODHST1167 extends EciChannelService {

	private static BODHST1167_I i = new BODHST1167_I();
	private static BODHST1167_O o = new BODHST1167_O();
	public BODHST1167() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODHST1167_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("certno", new MsgField(ContentEnum.MessageType.STRING.toString(), "certno", 30,0, true, "产品代码" )))
					.addNode(new FieldNode("certna", new MsgField(ContentEnum.MessageType.STRING.toString(), "certna", 60,0, true, "产品名称" )))
					.addNode(new FieldNode("pgnwfg", new MsgField(ContentEnum.MessageType.STRING.toString(), "pgnwfg", 1024,0, false, "起息方式" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODHST1167_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq", 20,0, false, "报文流水" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 300,0, false, "出错信息" )))
					.addNode(new FieldNode("systdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "systdt", 10,0, false, "核心系统日期" )))
					.addNode(new FieldNode("script", new MsgField(ContentEnum.MessageType.STRING.toString(), "script", 1000,0, false, "出错脚本" )))
					.addNode(new ArrayNode("listnm",false)
							).addNode(new StructNode("bodrcd",true)
									.addNode(new FieldNode("certno", new MsgField(ContentEnum.MessageType.STRING.toString(), "certno", 30,0, false, "产品代码" )))
									.addNode(new FieldNode("certna", new MsgField(ContentEnum.MessageType.STRING.toString(), "certna", 60,0, false, "产品名称" )))
									.addNode(new FieldNode("crcycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "crcycd", 3,0, false, "币种" )))
									.addNode(new FieldNode("termcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "termcd", 3,0, false, "存单期限" )))
									.addNode(new FieldNode("statam", new MsgField(ContentEnum.MessageType.STRING.toString(), "statam", 18,0, false, "认购起点金额" )))
									.addNode(new FieldNode("instrt", new MsgField(ContentEnum.MessageType.STRING.toString(), "instrt", 11,0, false, "到期利率" )))
									.addNode(new FieldNode("certbl", new MsgField(ContentEnum.MessageType.STRING.toString(), "certbl", 18,0, false, "剩余额度" )))
									.addNode(new FieldNode("rgtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "rgtime", 40,0, false, "认购时间" )))
									.addNode(new FieldNode("bgindt", new MsgField(ContentEnum.MessageType.STRING.toString(), "bgindt", 8,0, false, "产品起息日" )))
									.addNode(new FieldNode("matudt", new MsgField(ContentEnum.MessageType.STRING.toString(), "matudt", 8,0, false, "产品到期日" )))
									.addNode(new FieldNode("extdam", new MsgField(ContentEnum.MessageType.STRING.toString(), "extdam", 18,0, false, "追加金额" )))
									.addNode(new FieldNode("inrttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "inrttp", 8,0, false, "利率类型" )))
									.addNode(new FieldNode("rcintg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcintg", 2,0, false, "赎回计息方式" )))
									.addNode(new FieldNode("tocebl", new MsgField(ContentEnum.MessageType.STRING.toString(), "tocebl", 18,0, false, "产品总额度" )))
									.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1,0, false, "产品状态" )))
									.addNode(new FieldNode("trandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt", 8,0, false, "流水日期" )))
									.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 20,0, false, "流水号" )))
									.addNode(new FieldNode("incmtm", new MsgField(ContentEnum.MessageType.STRING.toString(), "incmtm", 1024,0, false, "付息频率" )))
									.addNode(new FieldNode("pyindt", new MsgField(ContentEnum.MessageType.STRING.toString(), "pyindt", 1024,0, false, "付息天数" )))
									.addNode(new FieldNode("nwopac", new MsgField(ContentEnum.MessageType.STRING.toString(), "nwopac", 1,0, false, "即时起息标志" )))
									));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

