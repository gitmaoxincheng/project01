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
 * BASESVC BODAFA1131  个人结购汇查询 
 *  BODAFA1131 8810901
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1131 extends EciChannelService {

	private static BODAFA1131_I i = new BODAFA1131_I();
	private static BODAFA1131_O o = new BODAFA1131_O();
	public BODAFA1131() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1131_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("tradetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradetype", 1,0, false, "结购汇类型" )))
					.addNode(new FieldNode("idtype_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype_code", 2,0, false, "证件类型代码" )))
					.addNode(new FieldNode("jgstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "jgstatus", 1,0, false, "报送状态" )))
					.addNode(new FieldNode("hoststatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "hoststatus", 1,0, false, "记账状态" )))
					.addNode(new FieldNode("hstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "hstatus", 1,0, false, "交易状态" )))
					.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 50,0, false, "证件号码" )))
					.addNode(new FieldNode("strsubchannelCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "strsubchannelCode", 3,0, false, "交易渠道" )))
					.addNode(new FieldNode("bgdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "bgdate", 8,0, true, "开始日期" )))
					.addNode(new FieldNode("eddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "eddate", 8,0, true, "结束日期" )))
					.addNode(new FieldNode("refno", new MsgField(ContentEnum.MessageType.STRING.toString(), "refno", 50,0, false, "业务参号" )))
					.addNode(new FieldNode("jgacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "jgacctno", 50,0, false, "结购汇账号" )))
					.addNode(new FieldNode("pageflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageflag", 1,0, false, "翻页标志" )))
					.addNode(new FieldNode("maxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxnum", 10,0, false, "单页最大记录数" )))
					.addNode(new FieldNode("idxbank_self_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxbank_self_num", 20,0, false, "翻页索引" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1131_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq", 12,0, false, "报文流水" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 255,0, false, "出错信息" )))
					.addNode(new FieldNode("script", new MsgField(ContentEnum.MessageType.STRING.toString(), "script", 8,0, false, "出错脚本" )))
					.addNode(new FieldNode("totalnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalnum", 8,0, false, "总记录数" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 8,0, false, "记录数" )))
					.addNode(new ArrayNode("bodrcd",true, "convt_list")
							.addNode(new FieldNode("serialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "serialno", 20,0, false, "业务流水号" )))
							.addNode(new FieldNode("bank_self_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "bank_self_num", 50,0, false, "银行自身流水号" )))
							.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedate", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("tradetime", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradetime", 6,0, false, "交易时间" )))
							.addNode(new FieldNode("zoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "zoneno", 10,0, false, "分行号" )))
							.addNode(new FieldNode("mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mbrno", 10,0, false, "支行号" )))
							.addNode(new FieldNode("brno", new MsgField(ContentEnum.MessageType.STRING.toString(), "brno", 10,0, false, "网点号" )))
							.addNode(new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno", 10,0, false, "经办柜员号" )))
							.addNode(new FieldNode("authtellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "authtellerno", 10,0, false, "授权柜员号" )))
							.addNode(new FieldNode("channeldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "channeldate", 8,0, false, "渠道日期" )))
							.addNode(new FieldNode("channeltime", new MsgField(ContentEnum.MessageType.STRING.toString(), "channeltime", 6,0, false, "渠道时间" )))
							.addNode(new FieldNode("channelcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelcode", 3,0, false, "渠道分类码" )))
							.addNode(new FieldNode("subchannelcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "subchannelcode", 3,0, false, "渠道代码" )))
							.addNode(new FieldNode("channelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelserno", 40,0, false, "渠道交易流水号" )))
							.addNode(new FieldNode("templatecodename", new MsgField(ContentEnum.MessageType.STRING.toString(), "templatecodename", 20,0, false, "模板代码" )))
							.addNode(new FieldNode("transcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "transcode", 10,0, false, "交易代码" )))
							.addNode(new FieldNode("termid", new MsgField(ContentEnum.MessageType.STRING.toString(), "termid", 20,0, false, "终端号" )))
							.addNode(new FieldNode("userno", new MsgField(ContentEnum.MessageType.STRING.toString(), "userno", 40,0, false, "用户号" )))
							.addNode(new FieldNode("subuserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "subuserno", 40,0, false, "子用户号" )))
							.addNode(new FieldNode("refno", new MsgField(ContentEnum.MessageType.STRING.toString(), "refno", 29,0, false, "业务参号" )))
							.addNode(new FieldNode("biz_type_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "biz_type_code", 2,0, false, "业务类型代码" )))
							.addNode(new FieldNode("idtype_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype_code", 2,0, false, "证件类型代码" )))
							.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 50,0, false, "证件号码" )))
							.addNode(new FieldNode("ctycode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctycode", 3,0, false, "国家/地区代码" )))
							.addNode(new FieldNode("add_idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "add_idcode", 50,0, false, "补充证件号码" )))
							.addNode(new FieldNode("person_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "person_name", 128,0, false, "姓名" )))
							.addNode(new FieldNode("custtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype", 1,0, false, "客户类型" )))
							.addNode(new FieldNode("bus_type_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "bus_type_code", 4,0, false, "结汇/购汇资金属性代码" )))
							.addNode(new FieldNode("txccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "txccy", 3,0, false, "币种" )))
							.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "amount", 18,0, false, "结汇/购汇金额" )))
							.addNode(new FieldNode("purfx_cash_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "purfx_cash_amt", 18,0, false, "购汇提钞金额" )))
							.addNode(new FieldNode("fcy_remit_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "fcy_remit_amt", 18,0, false, "汇出资金（包括外汇票据）金额" )))
							.addNode(new FieldNode("fcy_acct_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "fcy_acct_amt", 18,0, false, "存入个人外汇账户金额" )))
							.addNode(new FieldNode("tchk_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "tchk_amt", 18,0, false, "旅行支票金额" )))
							.addNode(new FieldNode("usa_amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "usa_amount", 18,0, false, "折合美元" )))
							.addNode(new FieldNode("acctno_cny", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno_cny", 32,0, false, "结汇/购汇人民币账户" )))
							.addNode(new FieldNode("salefx_settle_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "salefx_settle_code", 2,0, false, "结汇资金形态代码" )))
							.addNode(new FieldNode("lcy_acct_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "lcy_acct_no", 32,0, false, "个人外汇账户账号" )))
							.addNode(new FieldNode("biz_tx_chnl_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "biz_tx_chnl_code", 2,0, false, "业务办理渠道代码" )))
							.addNode(new FieldNode("biz_tx_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "biz_tx_time", 19,0, true, "业务办理时间" )))
							.addNode(new FieldNode("agent_corp_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "agent_corp_code", 9,0, false, "代理企业组织机构代码" )))
							.addNode(new FieldNode("agent_corp_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "agent_corp_name", 128,0, false, "代理企业名称" )))
							.addNode(new FieldNode("indiv_org_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "indiv_org_code", 9,0, false, "个体工商户组织机构代码" )))
							.addNode(new FieldNode("indiv_org_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "indiv_org_name", 128,0, false, "个体工商户名称" )))
							.addNode(new FieldNode("pay_org_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "pay_org_code", 9,0, false, "支付机构组织机构代码" )))
							.addNode(new FieldNode("capitalno", new MsgField(ContentEnum.MessageType.STRING.toString(), "capitalno", 20,0, false, "外汇局批件号/备案表号/业务编号" )))
							.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark", 256,0, false, "备注" )))
							.addNode(new FieldNode("opt_reason_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "opt_reason_code", 2,0, false, "补录/修改/撤销原因代码" )))
							.addNode(new FieldNode("opt_remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "opt_remark", 128,0, false, "补录/修改/撤销说明" )))
							.addNode(new FieldNode("tradetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradetype", 1,0, false, "交易类型" )))
							.addNode(new FieldNode("sendtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "sendtype", 1,0, false, "报送类型" )))
							.addNode(new FieldNode("sendstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "sendstatus", 1,0, false, "报送状态" )))
							.addNode(new FieldNode("hoststatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "hoststatus", 1,0, false, "记账状态" )))
							.addNode(new FieldNode("canstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "canstatus", 1,0, false, "交易状态" )))
							.addNode(new FieldNode("hostdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "hostdate", 8,0, false, "核心日期" )))
							.addNode(new FieldNode("hostserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "hostserno", 10,0, false, "核心流水号" )))
							.addNode(new FieldNode("salefx_amt_usd", new MsgField(ContentEnum.MessageType.STRING.toString(), "salefx_amt_usd", 18,0, false, "本次结汇金额折美元" )))
							.addNode(new FieldNode("ann_rem_lcyamt_usd", new MsgField(ContentEnum.MessageType.STRING.toString(), "ann_rem_lcyamt_usd", 18,0, false, "本年额度内剩余可结汇金额折美元" )))
							.addNode(new FieldNode("type_status", new MsgField(ContentEnum.MessageType.STRING.toString(), "type_status", 2,0, false, "个人主体分类状态代码" )))
							.addNode(new FieldNode("pub_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "pub_date", 8,0, false, "发布日期" )))
							.addNode(new FieldNode("end_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_date", 8,0, false, "到期日期" )))
							.addNode(new FieldNode("pub_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "pub_reason", 256,0, false, "发布原因" )))
							.addNode(new FieldNode("pub_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "pub_code", 2,0, false, "发布原因代码" )))
							.addNode(new FieldNode("errcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "errcode", 20,0, false, "行内/核心错误代码" )))
							.addNode(new FieldNode("errmsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "errmsg", 512,0, false, "行内/核心错误信息" )))
							.addNode(new FieldNode("corpcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpcode", 6,0, false, "中心回执代码" )))
							.addNode(new FieldNode("corpmsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "corpmsg", 128,0, false, "中心回执详细信息" )))
							.addNode(new FieldNode("excrate", new MsgField(ContentEnum.MessageType.STRING.toString(), "excrate", 30,0, false, "牌价" )))
							.addNode(new FieldNode("totram", new MsgField(ContentEnum.MessageType.STRING.toString(), "totram", 30,0, false, "对手金额" )))
							.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranam", 30,0, false, "人民币金额" )))
							.addNode(new FieldNode("csextg", new MsgField(ContentEnum.MessageType.STRING.toString(), "csextg", 20,0, false, "钞汇标志" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

