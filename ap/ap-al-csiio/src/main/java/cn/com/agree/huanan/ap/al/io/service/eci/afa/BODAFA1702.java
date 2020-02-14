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
 * BASESVC BODAFA1702  录音录像柜面查询交易
 * BODAFA1702 205007 205013
 *  综合前置
 * @author zhonggp
 */
@Component
public class BODAFA1702 extends EciChannelService {
	
	private static BODAFA1702_I i = new BODAFA1702_I();
	private static BODAFA1702_O o = new BODAFA1702_O();

	public BODAFA1702() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1702_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("videoid", new MsgField(ContentEnum.MessageType.STRING.toString(), "videoid", 20,0, false, "录制编号" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 2,0, false, "客户证件类型" )))
					.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 30,0, false, "客户证件号码" )))
					.addNode(new FieldNode("prdtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdtype", 2,0, false, "产品类型" )))
					.addNode(new FieldNode("prdcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdcode", 6,0, false, "产品代码" )))
					.addNode(new FieldNode("prdname", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdname", 20,0, false, "产品名称" )))
					.addNode(new FieldNode("enddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "enddate", 8,0, false, "产品到期日" )))
					.addNode(new FieldNode("v_tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "v_tellerno", 10,0, false, "柜员号" )))
					.addNode(new FieldNode("v_brno", new MsgField(ContentEnum.MessageType.STRING.toString(), "v_brno", 10,0, false, "网点号" )))
					.addNode(new FieldNode("v_mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "v_mbrno", 10,0, false, "支行号" )))
					.addNode(new FieldNode("v_zoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "v_zoneno", 10,0, false, "分行号" )))
					.addNode(new FieldNode("tradedatefrom", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedatefrom", 8,0, false, "开始日期(创建日期)" )))
					.addNode(new FieldNode("tradedateto", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedateto", 8,0, false, "结束日期(创建日期)" )))
					.addNode(new FieldNode("astatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "astatus", 2,0, false, "审核状态" )))
					.addNode(new FieldNode("gstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "gstatus", 2,0, false, "购买状态" )))
					.addNode(new FieldNode("vstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "vstatus", 64,0, false, "录像状态" )))
					.addNode(new FieldNode("pageflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageflag", 2,0, false, "翻页标识" )))
					.addNode(new FieldNode("maxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxnum", 1024,0, false, "每页最多记录数" )))
					.addNode(new FieldNode("idxvideoid", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxvideoid", 2,0, false, "翻页索引" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODAFA1702_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("totalnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalnum", 10,0, false, "总记录数" )))
					.addNode(new FieldNode("returnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "returnum", 10,0, false, "本次返回记录数" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 10,0, false, "记录数" )))
					.addNode(new ArrayNode("bodrcd", true,"video_list")
							.addNode(new FieldNode("channelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelserno", 25,0, false, "渠道流水号" )))
							.addNode(new FieldNode("videoid", new MsgField(ContentEnum.MessageType.STRING.toString(), "videoid", 20,0, false, "录制编号" )))
							.addNode(new FieldNode("clientname", new MsgField(ContentEnum.MessageType.STRING.toString(), "clientname", 80,0, false, "客户名称" )))
							.addNode(new FieldNode("clienttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "clienttype", 2,0, false, "客户类别" )))
							.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 2,0, false, "客户证件类型" )))
							.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 50,0, false, "客户证件号码" )))
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 40,0, false, "卡号、帐号" )))
							.addNode(new FieldNode("prdtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdtype", 2,0, false, "产品类型" )))
							.addNode(new FieldNode("prdcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdcode", 40,0, false, "产品代码" )))
							.addNode(new FieldNode("prdname", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdname", 250,0, false, "产品名称" )))
							.addNode(new FieldNode("enddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "enddate", 8,0, false, "产品到期日" )))
							.addNode(new FieldNode("editflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "editflag", 20,0, false, "修改标识" )))
							.addNode(new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno", 10,0, false, "柜员号" )))
							.addNode(new FieldNode("brno", new MsgField(ContentEnum.MessageType.STRING.toString(), "brno", 10,0, false, "网点号" )))
							.addNode(new FieldNode("tellername", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellername", 20,0, false, "柜员名" )))
							.addNode(new FieldNode("videolcpath", new MsgField(ContentEnum.MessageType.STRING.toString(), "videolcpath", 200,0, false, "录音录像本地文件路径" )))
							.addNode(new FieldNode("videoabpath", new MsgField(ContentEnum.MessageType.STRING.toString(), "videoabpath", 200,0, false, "录音录像AB端文件路径" )))
							.addNode(new FieldNode("vstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "vstatus", 2,0, false, "录像状态" )))
							.addNode(new FieldNode("createdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "createdate", 8,0, false, "创建日期" )))
							.addNode(new FieldNode("createtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "createtime", 6,0, false, "创建时间" )))
							.addNode(new FieldNode("udpatedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "udpatedate", 8,0, false, "更新日期" )))
							.addNode(new FieldNode("udpatetime", new MsgField(ContentEnum.MessageType.STRING.toString(), "udpatetime", 6,0, false, "更新时间" )))
							.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark", 300,0, false, "备注" )))
							.addNode(new FieldNode("contentid", new MsgField(ContentEnum.MessageType.STRING.toString(), "contentid", 64,0, false, "影像平台的批次ID" )))
							.addNode(new FieldNode("y_start_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "y_start_time", 64,0, false, "影像平台的批次时间" )))
							.addNode(new FieldNode("y_start_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "y_start_date", 64,0, false, "影像平台的批次日期" )))
							.addNode(new FieldNode("bakfield1", new MsgField(ContentEnum.MessageType.STRING.toString(), "bakfield1", 64,0, false, "备用字段1" )))
							.addNode(new FieldNode("bakfield2", new MsgField(ContentEnum.MessageType.STRING.toString(), "bakfield2", 64,0, false, "备用字段2" )))
							.addNode(new FieldNode("vauthno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vauthno", 10,0, false, "复核柜员号" )))
							.addNode(new FieldNode("vauthna", new MsgField(ContentEnum.MessageType.STRING.toString(), "vauthna", 20,0, false, "复核柜员名称" )))
							.addNode(new FieldNode("astatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "astatus", 2,0, false, "审核状态" )))
							.addNode(new FieldNode("gstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "gstatus", 2,0, false, "购买状态" )))
							.addNode(new FieldNode("blvideoid", new MsgField(ContentEnum.MessageType.STRING.toString(), "blvideoid", 20,0, false, "补录的录制编号" )))
							.addNode(new FieldNode("vauthdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "vauthdate", 8,0, false, "审核日期" )))
							.addNode(new FieldNode("vauthtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "vauthtime", 6,0, false, "审核时间" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
