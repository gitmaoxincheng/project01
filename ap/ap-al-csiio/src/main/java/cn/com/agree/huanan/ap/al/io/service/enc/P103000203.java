package cn.com.agree.huanan.ap.al.io.service.enc;

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
 * BASESVC.P103000203 利率信息查询.存款基准利率查询 
 * P1030002.03 ckjzll_query
 * 0321 参数管理平台
 * @author XZF
 */
@Component
public class P103000203 extends EsbChannelService {

	private static P103000203_I i = new P103000203_I();
	private static P103000203_O o = new P103000203_O();
	public P103000203() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P103000203_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("crcycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "crcycd", 3,0, false, "币种" )))
					.addNode(new FieldNode("inrttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "inrttp", 4,0, false, "利率类别" )))
					.addNode(new FieldNode("termcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "termcd", 3,0, false, "存期" )))
					.addNode(new FieldNode("inrtst", new MsgField(ContentEnum.MessageType.STRING.toString(), "inrtst", 1,0, false, "状态" )))
					.addNode(new FieldNode("efctdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "efctdt", 8,0, false, "生效日期" )))
					.addNode(new FieldNode("inefdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "inefdt", 8,0, false, "失效日期" )))
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

	public static class P103000203_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("totalnum", new MsgField(ContentEnum.MessageType.INT.toString(), "totalnum", 10,0, true, "总记录数" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.INT.toString(), "listnm", 6,0, true, "本次返回记录数" )))
					.addNode(new ArrayNode("data_list",false)
							.addNode(new FieldNode("crcycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "crcycd", 3,0, true, "币种" )))
							.addNode(new FieldNode("inrttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "inrttp", 4,0, false, "利率类别" )))
							.addNode(new FieldNode("termcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "termcd", 3,0, false, "存期" )))
							.addNode(new FieldNode("inrtst", new MsgField(ContentEnum.MessageType.STRING.toString(), "inrtst", 1,0, false, "状态" )))
							.addNode(new FieldNode("floafs", new MsgField(ContentEnum.MessageType.STRING.toString(), "floafs", 3,0, false, "浮动方式" )))
							.addNode(new FieldNode("floart", new MsgField(ContentEnum.MessageType.INT.toString(), "floart", 20,7, false, "浮动比例" )))
							.addNode(new FieldNode("flulir", new MsgField(ContentEnum.MessageType.INT.toString(), "flulir", 20,7, false, "浮动上限" )))
							.addNode(new FieldNode("flwlir", new MsgField(ContentEnum.MessageType.INT.toString(), "flwlir", 20,7, false, "浮动下限" )))
							.addNode(new FieldNode("instrt", new MsgField(ContentEnum.MessageType.INT.toString(), "instrt", 20,7, false, "基准利率" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

