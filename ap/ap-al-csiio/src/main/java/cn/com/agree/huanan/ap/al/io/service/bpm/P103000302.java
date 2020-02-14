package cn.com.agree.huanan.ap.al.io.service.bpm;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P103000302 汇率信息查询.国结汇率查询 
 * P1030003.02 exchangerate_query
 * 0321 参数管理平台
 * @author XZF
 */
@Component
public class P103000302 extends EsbChannelService {

	private static P103000302_I i = new P103000302_I();
	private static P103000302_O o = new P103000302_O();
	public P103000302() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P103000302_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("crcycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "crcycd", 3,0, false, "币种" )))
					.addNode(new FieldNode("querytp", new MsgField(ContentEnum.MessageType.INT.toString(), "querytp", 1,0, false, "查询类型" )))
					.addNode(new FieldNode("exrtst", new MsgField(ContentEnum.MessageType.INT.toString(), "exrtst", 1,0, false, "状态" )))
					.addNode(new FieldNode("stdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "stdate", 8,0, false, "开始日期" )))
					.addNode(new FieldNode("enddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "enddate", 8,0, false, "结束日期" )))
					.addNode(new FieldNode("pagenum", new MsgField(ContentEnum.MessageType.INT.toString(), "pagenum", 6,0, false, "每页返回笔数" )))
					.addNode(new FieldNode("pageindex", new MsgField(ContentEnum.MessageType.INT.toString(), "pageindex", 10,0, false, "翻页索引" )))
					
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class P103000302_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("totalnum", new MsgField(ContentEnum.MessageType.INT.toString(), "totalnum", 10,0, true, "总记录数" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.INT.toString(), "listnm", 6,0, true, "本次返回记录数" )))
					.addNode(new ArrayNode("data_list",false)
							.addNode(new FieldNode("crcycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "crcycd", 3,0, true, "币种" )))
							.addNode(new FieldNode("efctdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "efctdt", 8,0, false, "生效日期" )))
							.addNode(new FieldNode("efctdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "efctdm", 6,0, false, "生效时间" )))
							.addNode(new FieldNode("inefdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "inefdt", 8,0, false, "失效日期" )))
							.addNode(new FieldNode("inefdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "inefdm", 6,0, false, "失效时间" )))
							.addNode(new FieldNode("exrtst", new MsgField(ContentEnum.MessageType.STRING.toString(), "exrtst", 1,0, false, "状态" )))
							.addNode(new FieldNode("crcyna", new MsgField(ContentEnum.MessageType.STRING.toString(), "crcyna", 20,0, false, "中文名称" )))
							.addNode(new FieldNode("crcyen", new MsgField(ContentEnum.MessageType.STRING.toString(), "crcyen", 3,0, false, "英文简称" )))
							.addNode(new FieldNode("exunit", new MsgField(ContentEnum.MessageType.STRING.toString(), "exunit", 20,0, false, "换算单位" )))
							.addNode(new FieldNode("csbypr", new MsgField(ContentEnum.MessageType.INT.toString(), "csbypr", 20,7, false, "钞买价" )))
							.addNode(new FieldNode("csslpr", new MsgField(ContentEnum.MessageType.INT.toString(), "csslpr", 20,7, false, "钞卖价" )))
							.addNode(new FieldNode("exbypr", new MsgField(ContentEnum.MessageType.INT.toString(), "exbypr", 20,7, false, "汇买价" )))
							.addNode(new FieldNode("exslpr", new MsgField(ContentEnum.MessageType.INT.toString(), "exslpr", 20,7, false, "汇卖价" )))
							.addNode(new FieldNode("middpr", new MsgField(ContentEnum.MessageType.INT.toString(), "middpr", 20,7, false, "中间价" )))
							.addNode(new FieldNode("wgmdpr", new MsgField(ContentEnum.MessageType.INT.toString(), "wgmdpr", 20,7, false, "外管中间价" )))
							.addNode(new FieldNode("uniopr", new MsgField(ContentEnum.MessageType.INT.toString(), "uniopr", 20,7, false, "折算价格" )))
							.addNode(new FieldNode("createdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "createdt", 8,0, false, "创建日期" )))
							.addNode(new FieldNode("createdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "createdm", 6,0, false, "创建时间" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
