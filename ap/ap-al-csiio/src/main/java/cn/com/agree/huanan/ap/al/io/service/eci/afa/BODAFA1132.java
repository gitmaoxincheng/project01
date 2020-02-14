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
 * BASESVC BODAFA1132  个人结汇/购汇额度和分类查询
 * BODAFA1132 pmisedfl 8810907
 *  综合前置
 * @author CZP
 */
@Component
public class BODAFA1132 extends EciChannelService {

	private static BODAFA1132_I i = new BODAFA1132_I();
	private static BODAFA1132_O o = new BODAFA1132_O();

	public BODAFA1132() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1132_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("tradetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradetype", 1,0, false, "结购汇类型" )))
					.addNode(new FieldNode("idtype_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype_code", 2,0, false, "证件类型代码" )))
					.addNode(new FieldNode("ctycode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctycode", 3,0, false, "国家/地区代码" )))
					.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 50,0, false, "证件号码" )))
					.addNode(new FieldNode("opbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "opbrno", 10,0, false, "外汇账户开户行号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODAFA1132_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq", 12,0, false, "报文流水" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 255,0, false, "出错信息" )))
					.addNode(new FieldNode("script", new MsgField(ContentEnum.MessageType.STRING.toString(), "script", 8,0, false, "出错脚本" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 8,0, false, "记录数" )))
					.addNode(new ArrayNode("bodrcd", false, "amt_list")
							.addNode(new FieldNode("idxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxnum", 50,0, false, "翻页索引" )))
							.addNode(new FieldNode("ann_lcyamt_usd", new MsgField(ContentEnum.MessageType.STRING.toString(), "ann_lcyamt_usd", 20,0, false, "本年额度内已结/购汇金额折美元" )))
							.addNode(new FieldNode("ann_rem_lcyamt_usd", new MsgField(ContentEnum.MessageType.STRING.toString(), "ann_rem_lcyamt_usd", 20,0, false, "本年额度内剩余可结/购汇金额折美元" )))
							.addNode(new FieldNode("today_cash_usd", new MsgField(ContentEnum.MessageType.STRING.toString(), "today_cash_usd", 20,0, false, "当日已发生的现钞结/购汇金额折美元" )))
							.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 128,0, false, "交易主体姓名" )))
							.addNode(new FieldNode("custtype_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype_code", 2,0, false, "交易主体类型代码" )))
							.addNode(new FieldNode("type_status", new MsgField(ContentEnum.MessageType.STRING.toString(), "type_status", 2,0, false, "个人主体分类状态代码" )))
							.addNode(new FieldNode("pub_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "pub_date", 10,0, false, "发布日期" )))
							.addNode(new FieldNode("end_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_date", 10,0, false, "到期日期" )))
							.addNode(new FieldNode("pub_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "pub_reason", 256,0, false, "发布原因" )))
							.addNode(new FieldNode("pub_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "pub_code", 2,0, false, "发布原因代码" )))
							.addNode(new FieldNode("sign_status", new MsgField(ContentEnum.MessageType.STRING.toString(), "sign_status", 1,0, false, "风险提示函/告知书告知状态" )))
							.addNode(new FieldNode("is_check", new MsgField(ContentEnum.MessageType.STRING.toString(), "is_check", 1,0, true, "是否是待说明个人" )))
							.addNode(new FieldNode("is_notice", new MsgField(ContentEnum.MessageType.STRING.toString(), "is_notice", 1,0, true, "待说明个人是否已告知" )))
							.addNode(new FieldNode("check_pub_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "check_pub_date", 10,0, true, "待说明个人发布日期" )))
							.addNode(new FieldNode("check_end_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "check_end_date", 10,0, true, "待说明个人到期日期" )))
							.addNode(new FieldNode("check_pub_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "check_pub_reason", 256,0, false, "待说明个人发布原因" )))
							.addNode(new FieldNode("check_pub_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "check_pub_code", 2,0, false, "待说明个人发布原因代码" )))
							.addNode(new FieldNode("check_pub_branch", new MsgField(ContentEnum.MessageType.STRING.toString(), "check_pub_branch", 256,0, false, "待说明个人发布机构" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
