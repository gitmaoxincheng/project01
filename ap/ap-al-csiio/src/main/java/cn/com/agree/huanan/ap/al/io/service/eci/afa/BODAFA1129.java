package cn.com.agree.huanan.ap.al.io.service.eci.afa;

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

/**
 * BASESVC BODAFA1129  个人结汇信息录入 
 *  BODAFA1129 8810915
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1129 extends EciChannelService {

	private static BODAFA1129_I i = new BODAFA1129_I();
	private static BODAFA1129_O o = new BODAFA1129_O();
	public BODAFA1129() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1129_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("biz_type_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "biz_type_code", 2,0, false, "业务类型代码" )))
					.addNode(new FieldNode("tradetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradetype", 1,0, false, "结购汇类型" )))
					.addNode(new FieldNode("idtype_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype_code", 2,0, false, "证件类型代码" )))
					.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 50,0, false, "证件号码" )))
					.addNode(new FieldNode("add_idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "add_idcode", 50,0, false, "补充证件号码" )))
					.addNode(new FieldNode("ctycode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctycode", 3,0, false, "国家/地区代码" )))
					.addNode(new FieldNode("person_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "person_name", 128,0, false, "姓名" )))
					.addNode(new FieldNode("salefx_tx_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "salefx_tx_code", 3,0, false, "结汇资金属性代码" )))
					.addNode(new FieldNode("txccy", new MsgField(ContentEnum.MessageType.STRING.toString(), "txccy", 3,0, false, "币种" )))
					.addNode(new FieldNode("salefx_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "salefx_amt", 20,0, false, "结汇金额" )))
					.addNode(new FieldNode("lcy_acctno_cny", new MsgField(ContentEnum.MessageType.STRING.toString(), "lcy_acctno_cny", 32,0, false, "结汇人民币账户" )))
					.addNode(new FieldNode("salefx_settle_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "salefx_settle_code", 2,0, false, "结汇资金形态" )))
					.addNode(new FieldNode("lcy_acct_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "lcy_acct_no", 32,0, false, "个人外汇账户账号" )))
					.addNode(new FieldNode("agent_corp_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "agent_corp_code", 9,0, false, "代理企业组织机构代码" )))
					.addNode(new FieldNode("agent_corp_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "agent_corp_name", 128,0, false, "代理企业名称" )))
					.addNode(new FieldNode("indiv_org_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "indiv_org_code", 9,0, false, "个体工商户组织机构代码" )))
					.addNode(new FieldNode("indiv_org_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "indiv_org_name", 128,0, false, "个体工商户名称" )))
					.addNode(new FieldNode("pay_org_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "pay_org_code", 9,0, false, "支付机构组织机构代码" )))
					.addNode(new FieldNode("capitalno", new MsgField(ContentEnum.MessageType.STRING.toString(), "capitalno", 20,0, false, "外汇局批件号/备案表号/业务编号" )))
					.addNode(new FieldNode("biz_tx_chnl_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "biz_tx_chnl_code", 2,0, false, "业务办理渠道代码" )))
					.addNode(new FieldNode("biz_tx_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "biz_tx_time", 20,0, true, "业务办理时间" )))
					.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark", 256,0, false, "备注" )))
					.addNode(new FieldNode("custtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype", 1,0, false, "客户类型" )))
					.addNode(new FieldNode("type_status", new MsgField(ContentEnum.MessageType.STRING.toString(), "type_status", 2,0, false, "个人主体分类状态代码" )))
					.addNode(new FieldNode("zsl_trexrt", new MsgField(ContentEnum.MessageType.STRING.toString(), "zsl_trexrt", 20,0, false, "核心折算美元金额" )))
					.addNode(new FieldNode("trantp", new MsgField(ContentEnum.MessageType.STRING.toString(), "trantp", 2,0, false, "转出类型" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 50,0, false, "转入账号" )))
					.addNode(new FieldNode("csextg", new MsgField(ContentEnum.MessageType.STRING.toString(), "csextg", 1,0, false, "买入汇抄标识" )))
					.addNode(new FieldNode("readst", new MsgField(ContentEnum.MessageType.STRING.toString(), "readst", 1,0, false, "读取方式" )))
					.addNode(new FieldNode("dcmttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcmttp", 32,0, false, "凭证类型" )))
					.addNode(new FieldNode("dcmtno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcmtno", 32,0, false, "凭证号码" )))
					.addNode(new FieldNode("drawfs", new MsgField(ContentEnum.MessageType.STRING.toString(), "drawfs", 32,0, false, "支取方式" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 32,0, false, "证件类型" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 32,0, false, "证件号码" )))
					.addNode(new FieldNode("totrtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "totrtp", 32,0, false, "转入类型" )))
					.addNode(new FieldNode("trexrt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trexrt", 30,0, false, "成交价" )))
					.addNode(new FieldNode("toacct", new MsgField(ContentEnum.MessageType.STRING.toString(), "toacct", 50,0, false, "转入账号" )))
					.addNode(new FieldNode("totram", new MsgField(ContentEnum.MessageType.STRING.toString(), "totram", 20,0, false, "转入金额" )))
					.addNode(new FieldNode("toacna", new MsgField(ContentEnum.MessageType.STRING.toString(), "toacna", 200,0, false, "转入户名" )))
					.addNode(new FieldNode("tocrcy", new MsgField(ContentEnum.MessageType.STRING.toString(), "tocrcy", 5,0, false, "转入币种" )))
					.addNode(new FieldNode("bjtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "bjtime", 20,0, false, "报价时间" )))
					.addNode(new FieldNode("opbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "opbrno", 10,0, false, "外汇账户开户行号" )))
					.addNode(new FieldNode("yjghtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "yjghtime", 200,0, false, "预计用汇时间" )))
					.addNode(new FieldNode("tocsex", new MsgField(ContentEnum.MessageType.STRING.toString(), "tocsex", 1,0, false, "卖出汇抄标识" )))
					.addNode(new FieldNode("sqr_posi_buy_prc", new MsgField(ContentEnum.MessageType.STRING.toString(), "sqr_posi_buy_prc", 18,0, false, "平盘买入价" )))
					.addNode(new FieldNode("sqr_posi_sell_prc", new MsgField(ContentEnum.MessageType.STRING.toString(), "sqr_posi_sell_prc", 18,0, false, "平盘卖出价" )))
					.addNode(new FieldNode("sell_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "sell_sub_acct_serl_num", 8,0, false, "卖出账号子账户序号" )))
					.addNode(new FieldNode("buy_acct_num_sub_acct_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "buy_acct_num_sub_acct_serl_num", 8,0, false, "买入账号子账户序号" )))
					.addNode(new FieldNode("tranpw", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranpw", 300,0, false, "交易密码" )))
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, false, "客户号" )))
					.addNode(new FieldNode("crcycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "crcycd", 3,0, false, "币种" )))
					.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranam", 20,0, false, "买入金额" )))
					.addNode(new FieldNode("chk_pswd_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "chk_pswd_flg", 2,0, false, "是否验密标志" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1129_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq", 12,0, false, "报文流水" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 255,0, false, "出错信息" )))
					.addNode(new FieldNode("script", new MsgField(ContentEnum.MessageType.STRING.toString(), "script", 8,0, false, "出错脚本" )))
					.addNode(new FieldNode("refno", new MsgField(ContentEnum.MessageType.STRING.toString(), "refno", 29,0, false, "业务参号" )))
					.addNode(new FieldNode("bank_self_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "bank_self_num", 50,0, false, "银行自身流水号" )))
					.addNode(new FieldNode("salefx_amt_usd", new MsgField(ContentEnum.MessageType.STRING.toString(), "salefx_amt_usd", 20,0, false, "本次结汇金额折美元" )))
					.addNode(new FieldNode("ann_rem_lcyamt_usd", new MsgField(ContentEnum.MessageType.STRING.toString(), "ann_rem_lcyamt_usd", 20,0, false, "本年额度内剩余可结汇金额折美元" )))
					.addNode(new FieldNode("type_status", new MsgField(ContentEnum.MessageType.STRING.toString(), "type_status", 2,0, false, "个人主体分类状态代码" )))
					.addNode(new FieldNode("pub_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "pub_date", 10,0, true, "发布日期" )))
					.addNode(new FieldNode("end_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_date", 10,0, true, "到期日期" )))
					.addNode(new FieldNode("pub_reason", new MsgField(ContentEnum.MessageType.STRING.toString(), "pub_reason", 256,0, false, "发布原因" )))
					.addNode(new FieldNode("pub_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "pub_code", 2,0, false, "发布原因代码" )))
					.addNode(new FieldNode("buy_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "buy_amt", 20,0, false, "买入金额" )))
					.addNode(new FieldNode("sell_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "sell_amt", 20,0, false, "卖出金额" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

