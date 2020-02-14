package cn.com.agree.huanan.ap.al.io.service.eci.qms;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODQMS02  预约信息查询 
 *  BODQMS02 regflw
 *  排队机
 * @author xuzhen
 */
@Component
public class BODQMS02 extends EciChannelService {
	private static BODQMS02_I i = new BODQMS02_I();
	private static BODQMS02_O o = new BODQMS02_O();
	public BODQMS02() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODQMS02_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
.addStructNode(new StructNode("APPBody",true,"Body")
.addNode(new FieldNode("reserv_begin_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_begin_date", 32,0, true, "预约开始日期" )))
.addNode(new FieldNode("reserv_end_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_end_date", 32,0, false, "预约结束日期" )))
.addNode(new FieldNode("reserv_begin_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_begin_time", 32,0, false, "预约开始时间" )))
.addNode(new FieldNode("reserv_end_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_end_time", 32,0, false, "预约结束时间" )))
.addNode(new FieldNode("reserv_branch", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_branch", 9,0, false, "预约网点机构号" )))
.addNode(new FieldNode("reserv_bs_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_bs_id", 40,0, false, "预约业务ID" )))
.addNode(new FieldNode("custinfo_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "custinfo_type", 2,0, false, "证件类型" )))
.addNode(new FieldNode("custinfo_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "custinfo_num", 30,0, false, "证件号码" )))
.addNode(new FieldNode("reserv_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_id", 13,0, false, "预约编号" )))
.addNode(new FieldNode("phone_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone_no", 13,0, false, "预约人手机号" )))
.addNode(new FieldNode("currentpage", new MsgField(ContentEnum.MessageType.STRING.toString(), "currentpage", 4,0, false, "当前页面码" )))
.addNode(new FieldNode("pageflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageflag", 1,0, false, "分页标识" )))
.addNode(new FieldNode("count", new MsgField(ContentEnum.MessageType.STRING.toString(), "count", 10,0, false, "每页记录数" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}
	@Override
	public void initContent(Map<String, Object> tradeContext) {
		super.initContent(tradeContext);
		Map<String,Object> appHeader = (Map) tradeContext.get("AppHeader");
		Map<String,Object> csisHeader = (Map) tradeContext.get("CsisHeader");
		appHeader.put("xmlflag", "1");
		appHeader.put("templateCodeName", "params");
		appHeader.put("sysId", "96");
		appHeader.put("tradeFlag", "0");
		appHeader.put("checkFlag", "0");
		appHeader.put("vm_zoneno",  csisHeader.get("ZoneNo"));
		appHeader.put("vm_mbrno", csisHeader.get("MbrNo"));
		appHeader.put("vm_brno", csisHeader.get("BrNo"));
		appHeader.put("vm_tellerno", csisHeader.get("TellerNo"));
		appHeader.put("vm_tellertp",  csisHeader.get("TellerTp"));
	}
	
	public static class BODQMS02_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
				.addStructNode(new StructNode("Body",true,"APPBody")
				.addNode(new FieldNode("rcdsumnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcdsumnum", 3,0, false, "总记录数" )))
				.addNode(new FieldNode("totalpage", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalpage", 3,0, false, "总页数" )))
				.addNode(new FieldNode("reservinfosize", new MsgField(ContentEnum.MessageType.STRING.toString(), "reservinfosize", 3,0, false, "预约信息笔数" )))
				.addNode(new StructNode("reservinfo",true)
				.addNode(new FieldNode("work_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "work_date", 32,0, false, "日期" )))
				.addNode(new FieldNode("request_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "request_seq", 48,0, false, "请求序号" )))
				.addNode(new FieldNode("request_channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "request_channel", 32,0, false, "请求渠道" )))
				.addNode(new FieldNode("reserv_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_id", 40,0, false, "预约号" )))
				.addNode(new FieldNode("reserv_bs_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_bs_id", 40,0, false, "预约业务ID" )))
				.addNode(new FieldNode("reserv_record_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_record_date", 32,0, false, "预约登记日期" )))
				.addNode(new FieldNode("reserv_record_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_record_time", 32,0, false, "预约登记时间" )))
				.addNode(new FieldNode("reserv_begin_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_begin_date", 32,0, false, "预约开始日期" )))
				.addNode(new FieldNode("reserv_end_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_end_date", 32,0, false, "预约结束日期" )))
				.addNode(new FieldNode("reserv_begin_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_begin_time", 32,0, false, "预约开始时间" )))
				.addNode(new FieldNode("reserv_end_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_end_time", 32,0, false, "预约结束时间" )))
				.addNode(new FieldNode("reserv_zone", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_zone", 9,0, false, "预约区域" )))
				.addNode(new FieldNode("reserv_branch", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_branch", 36,0, false, "预约机构号" )))
				.addNode(new FieldNode("reserv_status", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_status", 8,0, false, "预约状态" )))
				.addNode(new FieldNode("reserv_modify_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_modify_time", 32,0, false, "修改时间" )))
				.addNode(new FieldNode("reserv_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_seq", 48,0, false, "预约流水" )))
				.addNode(new FieldNode("queue_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "queue_seq", 48,0, false, "排队流水" )))
				.addNode(new FieldNode("service_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "service_seq", 48,0, false, "柜员服务流水" )))
				.addNode(new FieldNode("custinfo_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "custinfo_type", 8,0, false, "证件类型" )))
				.addNode(new FieldNode("custinfo_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "custinfo_num", 120,0, false, "证件号码" )))
				.addNode(new FieldNode("custinfo_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "custinfo_name", 256,0, false, "客户姓名" )))
				.addNode(new FieldNode("account", new MsgField(ContentEnum.MessageType.STRING.toString(), "account", 256,0, false, "账户" )))
				.addNode(new FieldNode("sms_customer", new MsgField(ContentEnum.MessageType.STRING.toString(), "sms_customer", 8,0, false, "是否短信通知客户" )))
				.addNode(new FieldNode("phone_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone_no", 80,0, false, "预约人手机号" )))
				.addNode(new FieldNode("check_reserv_value", new MsgField(ContentEnum.MessageType.STRING.toString(), "check_reserv_value", 4,0, false, "预约编号验证码" )))
				));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

