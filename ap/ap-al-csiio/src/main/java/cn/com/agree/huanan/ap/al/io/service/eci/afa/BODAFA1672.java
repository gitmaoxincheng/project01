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
 * BASESVC BODAFA1672  回单机签约信息查询 
 *  BODAFA1672 8815705
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1672 extends EciChannelService {

	private static BODAFA1672_I i = new BODAFA1672_I();
	private static BODAFA1672_O o = new BODAFA1672_O();
	public BODAFA1672() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1672_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 1024,0, false, "账号" )))
					.addNode(new FieldNode("dealmode", new MsgField(ContentEnum.MessageType.STRING.toString(), "dealmode", 1024,0, false, "扣款方式" )))
					.addNode(new FieldNode("dealacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dealacctno", 1024,0, false, "缴费账号" )))
					.addNode(new FieldNode("operator", new MsgField(ContentEnum.MessageType.STRING.toString(), "operator", 1024,0, false, "经办人" )))
					.addNode(new FieldNode("operatoridtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatoridtype", 1024,0, false, "经办人证件类型" )))
					.addNode(new FieldNode("operatorid", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatorid", 1024,0, false, "经办人证件号码" )))
					.addNode(new FieldNode("operatorphone", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatorphone", 1024,0, false, "经办人手机" )))
					.addNode(new FieldNode("password", new MsgField(ContentEnum.MessageType.STRING.toString(), "password", 1024,0, false, "回单机密码" )))
					.addNode(new FieldNode("requeststartdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "requeststartdate", 1024,0, false, "签约日期" )))
					.addNode(new FieldNode("acctnoidtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctnoidtype", 1024,0, false, "证件类型" )))
					.addNode(new FieldNode("acctnoid", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctnoid", 1024,0, false, "证件号码" )))
					.addNode(new FieldNode("custno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 1024,0, false, "客户号" )))
					.addNode(new FieldNode("operatortellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatortellerno", 1024,0, false, "经办柜员" )))
					.addNode(new FieldNode("maxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxnum", 1024,0, false, "条数" )))
					.addNode(new FieldNode("idxworkdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxworkdate", 1024,0, false, "日期" )))
					.addNode(new FieldNode("idxagentserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxagentserialno", 1024,0, false, "流水" )))
					.addNode(new FieldNode("idxacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxacctno", 1024,0, false, "账号" )))
					.addNode(new FieldNode("idxstate", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxstate", 1024,0, false, "" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1024,0, false, "签约状态" )))
					.addNode(new FieldNode("acctnoopenbank", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctnoopenbank", 1024,0, false, "开户网点" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1672_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 1024,0, false, "返回记录数" )))
					.addNode(new ArrayNode("bodrcd",false, "sign_list")
							.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1024,0, false, "签约状态" )))
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 1024,0, false, "签约账号" )))
							.addNode(new FieldNode("custno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custno", 1024,0, false, "客户号" )))
							.addNode(new FieldNode("acctnoidtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctnoidtype", 1024,0, false, "开户证件类型" )))
							.addNode(new FieldNode("acctnoid", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctnoid", 1024,0, false, "开户证件号码" )))
							.addNode(new FieldNode("dealmode", new MsgField(ContentEnum.MessageType.STRING.toString(), "dealmode", 1024,0, false, "扣款方式" )))
							.addNode(new FieldNode("dealacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dealacctno", 1024,0, false, "缴费账号" )))
							.addNode(new FieldNode("dealacctnoname", new MsgField(ContentEnum.MessageType.STRING.toString(), "dealacctnoname", 1024,0, false, "缴费账号名称" )))
							.addNode(new FieldNode("operator", new MsgField(ContentEnum.MessageType.STRING.toString(), "operator", 1024,0, false, "经办人" )))
							.addNode(new FieldNode("operatoridtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatoridtype", 1024,0, false, "经办人证件类型" )))
							.addNode(new FieldNode("operatorid", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatorid", 1024,0, false, "经办人证件号码" )))
							.addNode(new FieldNode("operatorphone", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatorphone", 1024,0, false, "经办人手机" )))
							.addNode(new FieldNode("clientserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "clientserialno", 1024,0, false, "前端流水号" )))
							.addNode(new FieldNode("operatortellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatortellerno", 1024,0, false, "经办柜员" )))
							.addNode(new FieldNode("hostserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "hostserialno", 1024,0, false, "核心流水" )))
							.addNode(new FieldNode("operatorbank", new MsgField(ContentEnum.MessageType.STRING.toString(), "operatorbank", 1024,0, false, "经办网点" )))
							.addNode(new FieldNode("acctnoname", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctnoname", 1024,0, false, "签约户名" )))
							.addNode(new FieldNode("acctnoopenbank", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctnoopenbank", 1024,0, false, "开户网点" )))
							.addNode(new FieldNode("corporationname", new MsgField(ContentEnum.MessageType.STRING.toString(), "corporationname", 1024,0, false, "法人名称" )))
							.addNode(new FieldNode("corporationidtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "corporationidtype", 1024,0, false, "法人证件类型" )))
							.addNode(new FieldNode("corporationid", new MsgField(ContentEnum.MessageType.STRING.toString(), "corporationid", 1024,0, false, "法人证件号码" )))
							.addNode(new FieldNode("workdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "workdate", 1024,0, false, "日期" )))
							.addNode(new FieldNode("signbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "signbrno", 1024,0, false, "签约网点" )))
							.addNode(new FieldNode("signtellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtellerno", 1024,0, false, "签约柜员" )))
							.addNode(new FieldNode("stoptellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "stoptellerno", 1024,0, false, "解约柜员" )))
							.addNode(new FieldNode("stopbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "stopbrno", 1024,0, false, "解约网点" )))
							.addNode(new FieldNode("stopdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "stopdate", 1024,0, false, "解约日期" )))
							.addNode(new FieldNode("pwdstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "pwdstatus", 1024,0, false, "密码状态" )))
							.addNode(new FieldNode("startdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "startdate", 1024,0, false, "签约日期" )))
							.addNode(new FieldNode("sumbillamount", new MsgField(ContentEnum.MessageType.STRING.toString(), "sumbillamount", 1024,0, false, "欠费金额" )))
							.addNode(new FieldNode("billdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "billdate", 1024,0, false, "欠费日期" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

