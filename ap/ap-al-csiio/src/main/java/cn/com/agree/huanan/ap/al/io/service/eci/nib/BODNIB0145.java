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
 * BASESVC BODNIB0145  随心存产品查询 
 *  BODNIB0145 regflw
 *  新个人网银
 * @author XZF
 */
@Component
public class BODNIB0145 extends EciChannelService {

	private static BODNIB0145_I i = new BODNIB0145_I();
	private static BODNIB0145_O o = new BODNIB0145_O();
	public BODNIB0145() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNIB0145_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("action", new MsgField(ContentEnum.MessageType.STRING.toString(), "action", 1024,0, true, "处理码" )))
					.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 3,0, true, "上送渠道" )))
					.addNode(new FieldNode("ftdpcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "ftdpcd", 30,0, false, "产品代码" )))
					.addNode(new FieldNode("ftdpna", new MsgField(ContentEnum.MessageType.STRING.toString(), "ftdpna", 120,0, false, "产品名称" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1,0, false, "产品状态" )))
					.addNode(new FieldNode("bgdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "bgdate", 21,0, false, "发行起始日" )))
					.addNode(new FieldNode("eddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "eddate", 21,0, false, "发行结束日" )))
					.addNode(new FieldNode("page", new MsgField(ContentEnum.MessageType.STRING.toString(), "page", 21,0, true, "页码" )))
					.addNode(new FieldNode("pagesize", new MsgField(ContentEnum.MessageType.STRING.toString(), "pagesize", 21,0, true, "页大小" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODNIB0145_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("page", new MsgField(ContentEnum.MessageType.STRING.toString(), "page", 21,0, false, "页码" )))
					.addNode(new FieldNode("pagesize", new MsgField(ContentEnum.MessageType.STRING.toString(), "pagesize", 21,0, false, "页大小" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 21,0, false, "本次返回条数" )))
					.addNode(new FieldNode("totalCount", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalCount", 21,0, false, "总条数" )))
					.addNode(new ArrayNode("bodrcd",false,"procd_list")
							.addNode(new FieldNode("ftdpcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "ftdpcd", 30,0, false, "产品代码" )))
							.addNode(new FieldNode("ftdpna", new MsgField(ContentEnum.MessageType.STRING.toString(), "ftdpna", 120,0, false, "产品名称" )))
							.addNode(new FieldNode("crcycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "crcycd", 3,0, false, "产品币种" )))
							.addNode(new FieldNode("ftdpam", new MsgField(ContentEnum.MessageType.STRING.toString(), "ftdpam", 21,0, false, "产品额度" )))
							.addNode(new FieldNode("ftdpbl", new MsgField(ContentEnum.MessageType.STRING.toString(), "ftdpbl", 21,0, false, "剩余额度" )))
							.addNode(new FieldNode("termav", new MsgField(ContentEnum.MessageType.STRING.toString(), "termav", 100,0, false, "允许存期" )))
							.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 3,0, false, "渠道" )))
							.addNode(new FieldNode("filepath", new MsgField(ContentEnum.MessageType.STRING.toString(), "filepath", 100,0, false, "文件路径" )))
							.addNode(new FieldNode("bgdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "bgdate", 21,0, false, "发行起始日" )))
							.addNode(new FieldNode("bgtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "bgtime", 21,0, false, "发行时间" )))
							.addNode(new FieldNode("eddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "eddate", 21,0, false, "发行截止日" )))
							.addNode(new FieldNode("edtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "edtime", 21,0, false, "截止时间" )))
							.addNode(new FieldNode("loweam", new MsgField(ContentEnum.MessageType.STRING.toString(), "loweam", 21,0, false, "起存金额" )))
							.addNode(new FieldNode("incram", new MsgField(ContentEnum.MessageType.STRING.toString(), "incram", 21,0, false, "递增金额" )))
							.addNode(new FieldNode("inatfg", new MsgField(ContentEnum.MessageType.STRING.toString(), "inatfg", 1,0, false, "利息账户选" )))
							.addNode(new FieldNode("cratfg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cratfg", 1,0, false, "兑付账户选择" )))
							.addNode(new FieldNode("autdtg", new MsgField(ContentEnum.MessageType.STRING.toString(), "autdtg", 10,0, false, "自动转存方式" )))
							.addNode(new FieldNode("incmtm", new MsgField(ContentEnum.MessageType.STRING.toString(), "incmtm", 50,0, false, "付息频率" )))
							.addNode(new FieldNode("dcmtav", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcmtav", 1000,0, false, "允许凭证类型" )))
							.addNode(new FieldNode("salebr", new MsgField(ContentEnum.MessageType.STRING.toString(), "salebr", 60,0, false, "销售机构" )))
							.addNode(new FieldNode("ctepfg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctepfg", 1,0, false, "允许客群标签代码" )))
							.addNode(new FieldNode("ctepav", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctepav", 100,0, false, "客群标签" )))
							.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1,0, false, "产品状态" )))
							.addNode(new FieldNode("trandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt", 10,0, false, "新增日期" )))
							.addNode(new FieldNode("tranbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranbr", 10,0, false, "新增网点" )))
							.addNode(new FieldNode("tranus", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranus", 10,0, false, "新增柜员" )))
							.addNode(new FieldNode("avsvtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "avsvtp", 500,0, false, "可认购渠道" )))
							.addNode(new FieldNode("lvnumb", new MsgField(ContentEnum.MessageType.STRING.toString(), "lvnumb", 21,0, false, "档次数量" )))
							.addNode(new FieldNode("isavad", new MsgField(ContentEnum.MessageType.STRING.toString(), "isavad", 1,0, false, "是否允许收益增值" )))
							.addNode(new FieldNode("floart", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "floart", 7,6, false, "基准上浮比例" )))
							.addNode(new FieldNode("detailCount", new MsgField(ContentEnum.MessageType.STRING.toString(), "detailCount", 21,0, false, "产品详细条数" )))
							.addNode(new FieldNode("rateCount", new MsgField(ContentEnum.MessageType.STRING.toString(), "rateCount", 21,0, false, "产品详细条数" )))
							.addNode(new ArrayNode("bodrcd2",false,"detail1_list") 
									.addNode(new FieldNode("ftdpcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "ftdpcd", 30,0, false, "产品代码" )))
									.addNode(new FieldNode("rtsort", new MsgField(ContentEnum.MessageType.STRING.toString(), "rtsort", 21,0, false, "档次序号" )))
									.addNode(new FieldNode("termtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "termtp", 2,0, false, "存期类型" )))
									.addNode(new FieldNode("termpd", new MsgField(ContentEnum.MessageType.STRING.toString(), "termpd", 21,0, false, "存期" )))
									.addNode(new FieldNode("termcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "termcd", 3,0, false, "期限代码" )))
									.addNode(new FieldNode("termck", new MsgField(ContentEnum.MessageType.STRING.toString(), "termck", 3,0, false, "参考利率期限" )))
									.addNode(new FieldNode("inrttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "inrttp", 8,0, false, "参考利率类别" )))
									.addNode(new FieldNode("floart", new MsgField(ContentEnum.MessageType.STRING.toString(), "floart", 8,0, false, "上浮比例" )))
									.addNode(new FieldNode("inrate", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "inrate", 7,6, false, "利率" ))))
							.addNode(new ArrayNode("bodrcd3",false,"detail2_list")
									.addNode(new FieldNode("ftdpcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "ftdpcd", 30,0, false, "产品代码" )))
									.addNode(new FieldNode("termcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "termcd", 3,0, false, "存期" )))
									.addNode(new FieldNode("adrate", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "adrate", 7,6, false, "利率" )))
									)));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

