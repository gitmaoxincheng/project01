package cn.com.agree.huanan.ap.al.io.service.eci.ebp;

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
@Component
public class BODECIF0003 extends EciChannelService{
	private static BODECIF0003_I i = new BODECIF0003_I();
	private static BODECIF0003_O o = new BODECIF0003_O();
	public BODECIF0003() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODECIF0003_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("txCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "txCode",32,0, false, "交易码" )))
					.addNode(new FieldNode("custId", new MsgField(ContentEnum.MessageType.STRING.toString(), "custId", 20,0, false, "客户号" )))
	
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODECIF0003_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf",	1024	,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("contrSize", new MsgField(ContentEnum.MessageType.STRING.toString(), "contrSize",	10	,0, false, "商机产品编号记录数" )))
					.addNode(new FieldNode("custId", new MsgField(ContentEnum.MessageType.STRING.toString(), "custId",	20	,0, false, "客户编号" )))
					.addNode(new FieldNode("dateId", new MsgField(ContentEnum.MessageType.STRING.toString(), "dateId",	8	,0, false, "业务日期" )))
					.addNode(new FieldNode("currCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "currCode",	20	,0, false, "币种" )))
					.addNode(new FieldNode("assBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "assBal",	25	,0, false, "资产余额" )))
					.addNode(new FieldNode("assMonAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "assMonAvg",	25	,0, false, "资产月日均" )))
					.addNode(new FieldNode("assQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "assQuarAvg",	25	,0, false, "资产季日均" )))
					.addNode(new FieldNode("assRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "assRquarAvg",	25	,0, false, "资产滚动季日均" )))
					.addNode(new FieldNode("assYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "assYearAvg",	25	,0, false, "资产年日均" )))
					.addNode(new FieldNode("debBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "debBal",	25	,0, false, "负债" )))
					.addNode(new FieldNode("debMonAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "debMonAvg", 25	,0, false, "负债月日均" )))
					.addNode(new FieldNode("debQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "debQuarAvg",	25	,0, false, "负债季日均" )))
					.addNode(new FieldNode("debRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "debRquarAvg", 25	,0, false, "负债滚动季日均" )))
					.addNode(new FieldNode("debYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "debYearAvg",	25	,0, false, "负债年日均" )))
					.addNode(new FieldNode("netassBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "netassBal",	25	,0, false, "净资产余额" )))
					.addNode(new FieldNode("netassMonAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "netassMonAvg",	25	,0, false, "净资产月日均" )))
					.addNode(new FieldNode("netassQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "netassQuarAvg", 25	,0, false, "净资产季日均" )))
					.addNode(new FieldNode("netassRquarDavg", new MsgField(ContentEnum.MessageType.STRING.toString(), "netassRquarDavg", 25	,0, false, "净资产滚动季日均" )))
					.addNode(new FieldNode("netassYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "netassYearAvg",	25	,0, false, "净资产年日均" )))
					.addNode(new FieldNode("depBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "depBal",	25	,0, false, "存款余额" )))
					.addNode(new FieldNode("depQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "depQuarAvg",	25	,0, false, "存款季日均" )))
					.addNode(new FieldNode("depRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "depRquarAvg", 25	,0, false, "存款滚动季日均" )))
					.addNode(new FieldNode("depYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "depYearAvg",	25	,0, false, "存款年日均" )))
					.addNode(new FieldNode("currDepBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "currDepBal",	25	,0, false, "活期存款余额" )))
					.addNode(new FieldNode("currDepQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "currDepQuarAvg",	25	,0, false, "活期存款季日均" )))
					.addNode(new FieldNode("currDepRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "currDepRquarAvg", 25	,0, false, "活期存款滚动季日均" )))
					.addNode(new FieldNode("currDepYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "currDepYearAvg",	25	,0, false, "活期存款年日均" )))
					.addNode(new FieldNode("currAssdepBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "currAssdepBal",	25	,0, false, "活期保证金存款余额" )))
					.addNode(new FieldNode("currAssdepQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "currAssdepQuarAvg", 25	,0, false, "活期保证金存款季日均" )))
					.addNode(new FieldNode("currAssdepRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "currAssdepRquarAvg", 25	,0, false, "活期保证金存款滚动季日均" )))
					.addNode(new FieldNode("currAssdepYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "currAssdepYearAvg",	25	,0, false, "活期保证金存款年日均" )))
					.addNode(new FieldNode("fixedDepBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "fixedDepBal", 25	,0, false, "定期存款余额" )))
					.addNode(new FieldNode("fixedDepQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fixedDepQuarAvg", 25	,0, false, "定期存款季日均" )))
					.addNode(new FieldNode("fixedDepRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fixedDepRquarAvg",	25	,0, false, "定期存款滚动季日均" )))
					.addNode(new FieldNode("fixedDepYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fixedDepYearAvg",	25	,0, false, "定期存款年日均" )))
					.addNode(new FieldNode("fixedAssdepBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "fixedAssdepBal",	25	,0, false, "定期保证金存款余额" )))
					.addNode(new FieldNode("fixedAssdepQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fixedAssdepQuarAvg",	25	,0, false, "定期保证金存款季日均" )))
					.addNode(new FieldNode("fixedAssdepRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fixedAssdepRquarAvg",	25	,0, false, "定期保证金存款滚动季日均" )))
					.addNode(new FieldNode("fixedAssdepYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fixedAssdepYearAvg",	25	,0, false, "定期保证金存款年日均" )))
					.addNode(new FieldNode("noticeDepBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "noticeDepBal",	25,0, false, "通知存款余额" )))
					.addNode(new FieldNode("noticeDepQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "noticeDepQuarAvg",	25	,0, false, "通知存款季日均" )))
					.addNode(new FieldNode("noticeDepRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "noticeDepRquarAvg", 25	,0, false, "通知存款滚动季日均" )))
					.addNode(new FieldNode("noticeDepYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "noticeDepYearAvg",	25	,0, false, "通知存款年日均" )))
					.addNode(new FieldNode("intlDepBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "intlDepBal",	25	,0, false, "智能存款余额" )))
					.addNode(new FieldNode("intlDepQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "intlDepQuarAvg",	25	,0, false, "智能存款季日均" )))
					.addNode(new FieldNode("intlDepRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "intlDepRquarAvg", 25	,0, false, "智能存款滚动季日均" )))
					.addNode(new FieldNode("intlDepYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "intlDepYearAvg",	25	,0, false, "智能存款年日均" )))
					.addNode(new FieldNode("cdsDepBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "cdsDepBal",	25	,0, false, "大额存单余额" )))
					.addNode(new FieldNode("cdsDepQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cdsDepQuarAvg",	25	,0, false, "大额存单季日均" )))
					.addNode(new FieldNode("cdsDepRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cdsDepRquarAvg",	25	,0, false, "大额存单滚动季日均" )))
					.addNode(new FieldNode("cdsDepYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cdsDepYearAvg",	25	,0, false, "大额存单年日均" )))
					.addNode(new FieldNode("depAgreeBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "depAgreeBal", 25	,0, false, "协议存款余额" )))
					.addNode(new FieldNode("depAgreeQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "depAgreeQuarAvg", 25	,0, false, "协议存款季日均" )))
					.addNode(new FieldNode("depAgreeRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "depAgreeRquarAvg",	25	,0, false, "协议存款滚动季日均" )))
					.addNode(new FieldNode("depAgreeYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "depAgreeYearAvg",	25	,0, false, "协议存款年日均" )))
					.addNode(new FieldNode("agreeDepBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "agreeDepBal",	25	,0, false, "协定存款余额" )))
					.addNode(new FieldNode("agreeDepQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "agreeDepQuarAvg", 25	,0, false, "协定存款季日均" )))
					.addNode(new FieldNode("agreeDepRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "agreeDepRquarAvg",	25	,0, false, "协定存款滚动季日均" )))
					.addNode(new FieldNode("agreeDepYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "agreeDepYearAvg",	25	,0, false, "协定存款年日均" )))
					.addNode(new FieldNode("tpDepBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "tpDepBal",	25	,0, false, "第三方存款余额" )))
					.addNode(new FieldNode("tpDepQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "tpDepQuarAvg",	25	,0, false, "第三方存款季日均" )))
					.addNode(new FieldNode("tpDepRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "tpDepRquarAvg", 25	,0, false, "第三方存款滚动季日均" )))
					.addNode(new FieldNode("tpDepYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "tpDepYearAvg",	25	,0, false, "第三方存款年日均" )))
					.addNode(new FieldNode("crtDepBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "crtDepBal",	25	,0, false, "信用卡存款余额" )))
					.addNode(new FieldNode("crtDepQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "crtDepQuarAvg",	25	,0, false, "信用卡存款季日均" )))
					.addNode(new FieldNode("crtDepRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "crtDepRquarAvg",	25	,0, false, "信用卡存款滚动季日均" )))
					.addNode(new FieldNode("crtDepYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "crtDepYearAvg",	25	,0, false, "信用卡存款年日均" )))
					.addNode(new FieldNode("finaBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "finaBal",	25	,0, false, "理财余额" )))
					.addNode(new FieldNode("finaQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "finaQuarAvg",	25	,0, false, "理财季日均" )))
					.addNode(new FieldNode("finaRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "finaRquarAvg",	25	,0, false, "理财滚动季日均" )))
					.addNode(new FieldNode("finaYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "finaYearAvg",	25	,0, false, "理财年日均" )))
					.addNode(new FieldNode("fundBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "fundBal",	25	,0, false, "基金余额" )))
					.addNode(new FieldNode("fundQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fundQuarAvg",	25	,0, false, "基金季日均" )))
					.addNode(new FieldNode("fundRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fundRquarAvg",	25	,0, false, "基金滚动季日均" )))
					.addNode(new FieldNode("fundYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fundYearAvg",	25	,0, false, "基金年日均" )))
					.addNode(new FieldNode("nmLoanBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "nmLoanBal",	25	,0, false, "普通贷款余额" )))
					.addNode(new FieldNode("nmLoanQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "nmLoanQuarAvg",	25	,0, false, "普通贷款季日均" )))
					.addNode(new FieldNode("nmLoanRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "nmLoanRquarAvg",	25	,0, false, "普通贷款滚动季日均" )))
					.addNode(new FieldNode("nmLoanYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "nmLoanYearAvg",	25	,0, false, "普通贷款年日均" )))
					.addNode(new FieldNode("dcLoanBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcLoanBal",	25	,0, false, "贴现余额" )))
					.addNode(new FieldNode("dcLoanQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcLoanQuarAvg",	25	,0, false, "贴现季日均" )))
					.addNode(new FieldNode("dcLoanRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcLoanRquarAvg",	25	,0, false, "贴现滚动季日均" )))
					.addNode(new FieldNode("dcLoanYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dcLoanYearAvg",	25	,0, false, "贴现年日均" )))
					.addNode(new FieldNode("baLoanBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "baLoanBal",	25	,0, false, "承兑余额" )))
					.addNode(new FieldNode("baLoanQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "baLoanQuarAvg",	25	,0, false, "承兑季日均" )))
					.addNode(new FieldNode("baLoanRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "baLoanRquarAvg",	25	,0, false, "承兑滚动季日均" )))
					.addNode(new FieldNode("baLoanYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "baLoanYearAvg",	25	,0, false, "承兑年日均" )))
					.addNode(new FieldNode("glLoanBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "glLoanBal",	25	,0, false, "保函余额" )))
					.addNode(new FieldNode("glLoanQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "glLoanQuarAvg",	25	,0, false, "保函季日均" )))
					.addNode(new FieldNode("glLoanRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "glLoanRquarAvg", 25	,0, false, "保函滚动季日均" )))
					.addNode(new FieldNode("glLoanYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "glLoanYearAvg",	25	,0, false, "保函年日均" )))
					.addNode(new FieldNode("lcLoanBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "lcLoanBal",	25	,0, false, "信用证余额" )))
					.addNode(new FieldNode("lcLoanQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "lcLoanQuarAvg",	25	,0, false, "信用证季日均" )))
					.addNode(new FieldNode("lcLoanRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "lcLoanRquarAvg",	25	,0, false, "信用证滚动季日均" )))
					.addNode(new FieldNode("lcLoanYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "lcLoanYearAvg",	25	,0, false, "信用证年日均" )))
					.addNode(new FieldNode("crtLoanBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "crtLoanBal",	25	,0, false, "信用卡贷款余额" )))
					.addNode(new FieldNode("crtLoanQuarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "crtLoanQuarAvg",	25	,0, false, "信用卡贷款季日均" )))
					.addNode(new FieldNode("crtLoanRquarAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "crtLoanRquarAvg",	25	,0, false, "信用卡贷款滚动季日均" )))
					.addNode(new FieldNode("crtLoanYearAvg", new MsgField(ContentEnum.MessageType.STRING.toString(), "crtLoanYearAvg",	25	,0, false, "信用卡贷款年日均" )))
					.addNode(new FieldNode("creditBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "creditBal",	25	,0, false, "授信额度" )))
					.addNode(new FieldNode("profitMonBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "profitMonBal",	25	,0, false, "本月利润贡献度" )))
					.addNode(new FieldNode("profitYearBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "profitYearBal",	25	,0, false, "本年利润贡献度" )))
					.addNode(new FieldNode("scaleMonBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "scaleMonBal",	25	,0, false, "本月规模贡献度" )))
					.addNode(new FieldNode("scaleYearBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "scaleYearBal",	25	,0, false, "本年规模贡献度" )))
					.addNode(new FieldNode("FaultCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "FaultCode",	6	,0, false, "返回码" )))
					.addNode(new FieldNode("FaultString", new MsgField(ContentEnum.MessageType.STRING.toString(), "FaultString",	20	,0, false, "错误描述" )))
					.addNode(new FieldNode("TxnStat", new MsgField(ContentEnum.MessageType.STRING.toString(), "TxnStat",	7	,0, false, "交易状态" )))

					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
