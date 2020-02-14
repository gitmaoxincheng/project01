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
 * BASESVC.C013000901  个人客户财务信息查询
 * C0130009.01 	ECIF503
 * 0005 新核心系统
 * @author LF
 */
@Component
public class C013000901 extends EsbChannelService {

	private static C013000901_I i = new C013000901_I();
	private static C013000901_O o = new C013000901_O();
	public C013000901() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class C013000901_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, true, "客户号" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C013000901_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
.addNode(new FieldNode("contrsize", new MsgField(ContentEnum.MessageType.STRING.toString(), "contrsize", 10,0, false, "返回记录数" )))
.addNode(new ArrayNode("signinfo_list",false)
.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, false, "客户编号" )))
.addNode(new FieldNode("dateid", new MsgField(ContentEnum.MessageType.STRING.toString(), "dateid", 8,0, false, "业务日期" )))
.addNode(new FieldNode("currcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "currcode", 3,0, false, "币种" )))
.addNode(new FieldNode("assbal", new MsgField(ContentEnum.MessageType.INT.toString(), "assbal", 18,2, false, "资产余额" )))
.addNode(new FieldNode("assmonavg", new MsgField(ContentEnum.MessageType.INT.toString(), "assmonavg", 18,2, false, "资产月日均" )))
.addNode(new FieldNode("assquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "assquaravg", 18,2, false, "资产季日均" )))
.addNode(new FieldNode("assrquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "assrquaravg", 18,2, false, "资产滚动季日均" )))
.addNode(new FieldNode("assyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "assyearavg", 18,2, false, "资产年日均" )))
.addNode(new FieldNode("debbal", new MsgField(ContentEnum.MessageType.INT.toString(), "debbal", 18,2, false, "负债" )))
.addNode(new FieldNode("debmonavg", new MsgField(ContentEnum.MessageType.INT.toString(), "debmonavg", 18,2, false, "负债月日均" )))
.addNode(new FieldNode("debquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "debquaravg", 18,2, false, "负债季日均" )))
.addNode(new FieldNode("debrquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "debrquaravg", 18,2, false, "负债滚动季日均" )))
.addNode(new FieldNode("debyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "debyearavg", 18,2, false, "负债年日均" )))
.addNode(new FieldNode("netassbal", new MsgField(ContentEnum.MessageType.INT.toString(), "netassbal", 18,2, false, "净资产余额" )))
.addNode(new FieldNode("netassmonavg", new MsgField(ContentEnum.MessageType.INT.toString(), "netassmonavg", 18,2, false, "净资产月日均" )))
.addNode(new FieldNode("netassquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "netassquaravg", 18,2, false, "净资产季日均" )))
.addNode(new FieldNode("netassrquardavg", new MsgField(ContentEnum.MessageType.INT.toString(), "netassrquardavg", 18,2, false, "净资产滚动季日均" )))
.addNode(new FieldNode("netassyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "netassyearavg", 18,2, false, "净资产年日均" )))
.addNode(new FieldNode("depbal", new MsgField(ContentEnum.MessageType.INT.toString(), "depbal", 18,2, false, "存款余额" )))
.addNode(new FieldNode("depquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "depquaravg", 18,2, false, "存款季日均" )))
.addNode(new FieldNode("deprquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "deprquaravg", 18,2, false, "存款滚动季日均" )))
.addNode(new FieldNode("depyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "depyearavg", 18,2, false, "存款年日均" )))
.addNode(new FieldNode("currdepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "currdepbal", 18,2, false, "活期存款余额" )))
.addNode(new FieldNode("currdepquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "currdepquaravg", 18,2, false, "活期存款季日均" )))
.addNode(new FieldNode("currdeprquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "currdeprquaravg", 18,2, false, "活期存款滚动季日均" )))
.addNode(new FieldNode("currdepyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "currdepyearavg", 18,2, false, "活期存款年日均" )))
.addNode(new FieldNode("currassdepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "currassdepbal", 18,2, false, "活期保证金存款余额" )))
.addNode(new FieldNode("currassdepquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "currassdepquaravg", 18,2, false, "活期保证金存款季日均" )))
.addNode(new FieldNode("currassdeprquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "currassdeprquaravg", 18,2, false, "活期保证金存款滚动季日均" )))
.addNode(new FieldNode("currassdepyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "currassdepyearavg", 18,2, false, "活期保证金存款年日均" )))
.addNode(new FieldNode("fixeddepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "fixeddepbal", 18,2, false, "定期存款余额" )))
.addNode(new FieldNode("fixeddepquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "fixeddepquaravg", 18,2, false, "定期存款季日均" )))
.addNode(new FieldNode("fixeddeprquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "fixeddeprquaravg", 18,2, false, "定期存款滚动季日均" )))
.addNode(new FieldNode("fixeddepyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "fixeddepyearavg", 18,2, false, "定期存款年日均" )))
.addNode(new FieldNode("fixedassdepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "fixedassdepbal", 18,2, false, "定期保证金存款余额" )))
.addNode(new FieldNode("fixedassdepquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "fixedassdepquaravg", 18,2, false, "定期保证金存款季日均" )))
.addNode(new FieldNode("fixedassdeprquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "fixedassdeprquaravg", 18,2, false, "定期保证金存款滚动季日均" )))
.addNode(new FieldNode("fixedassdepyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "fixedassdepyearavg", 18,2, false, "定期保证金存款年日均" )))
.addNode(new FieldNode("noticedepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "noticedepbal", 18,2, false, "通知存款余额" )))
.addNode(new FieldNode("noticedepquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "noticedepquaravg", 18,2, false, "通知存款季日均" )))
.addNode(new FieldNode("noticedeprquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "noticedeprquaravg", 18,2, false, "通知存款滚动季日均" )))
.addNode(new FieldNode("noticedepyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "noticedepyearavg", 18,2, false, "通知存款年日均" )))
.addNode(new FieldNode("intldepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "intldepbal", 18,2, false, "智能存款余额" )))
.addNode(new FieldNode("intldepquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "intldepquaravg", 18,2, false, "智能存款季日均" )))
.addNode(new FieldNode("intldeprquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "intldeprquaravg", 18,2, false, "智能存款滚动季日均" )))
.addNode(new FieldNode("intldepyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "intldepyearavg", 18,2, false, "智能存款年日均" )))
.addNode(new FieldNode("cdsdepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "cdsdepbal", 18,2, false, "大额存单余额" )))
.addNode(new FieldNode("cdsdepquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "cdsdepquaravg", 18,2, false, "大额存单季日均" )))
.addNode(new FieldNode("cdsdeprquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "cdsdeprquaravg", 18,2, false, "大额存单滚动季日均" )))
.addNode(new FieldNode("cdsdepyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "cdsdepyearavg", 18,2, false, "大额存单年日均" )))
.addNode(new FieldNode("depagreebal", new MsgField(ContentEnum.MessageType.INT.toString(), "depagreebal", 18,2, false, "协议存款余额" )))
.addNode(new FieldNode("depagreequaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "depagreequaravg", 18,2, false, "协议存款季日均" )))
.addNode(new FieldNode("depagreerquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "depagreerquaravg", 18,2, false, "协议存款滚动季日均" )))
.addNode(new FieldNode("depagreeyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "depagreeyearavg", 18,2, false, "协议存款年日均" )))
.addNode(new FieldNode("agreedepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "agreedepbal", 18,2, false, "协定存款余额" )))
.addNode(new FieldNode("agreedepquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "agreedepquaravg", 18,2, false, "协定存款季日均" )))
.addNode(new FieldNode("agreedeprquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "agreedeprquaravg", 18,2, false, "协定存款滚动季日均" )))
.addNode(new FieldNode("agreedepyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "agreedepyearavg", 18,2, false, "协定存款年日均" )))
.addNode(new FieldNode("tpdepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "tpdepbal", 18,2, false, "第三方存款余额" )))
.addNode(new FieldNode("tpdepquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "tpdepquaravg", 18,2, false, "第三方存款季日均" )))
.addNode(new FieldNode("tpdeprquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "tpdeprquaravg", 18,2, false, "第三方存款滚动季日均" )))
.addNode(new FieldNode("tpdepyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "tpdepyearavg", 18,2, false, "第三方存款年日均" )))
.addNode(new FieldNode("crtdepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "crtdepbal", 18,2, false, "信用卡存款余额" )))
.addNode(new FieldNode("crtdepquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "crtdepquaravg", 18,2, false, "信用卡存款季日均" )))
.addNode(new FieldNode("crtdeprquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "crtdeprquaravg", 18,2, false, "信用卡存款滚动季日均" )))
.addNode(new FieldNode("crtdepyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "crtdepyearavg", 18,2, false, "信用卡存款年日均" )))
.addNode(new FieldNode("finabal", new MsgField(ContentEnum.MessageType.INT.toString(), "finabal", 18,2, false, "理财余额" )))
.addNode(new FieldNode("finaquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "finaquaravg", 18,2, false, "理财季日均" )))
.addNode(new FieldNode("finarquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "finarquaravg", 18,2, false, "理财滚动季日均" )))
.addNode(new FieldNode("finayearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "finayearavg", 18,2, false, "理财年日均" )))
.addNode(new FieldNode("fundbal", new MsgField(ContentEnum.MessageType.INT.toString(), "fundbal", 18,2, false, "基金余额" )))
.addNode(new FieldNode("fundquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "fundquaravg", 18,2, false, "基金季日均" )))
.addNode(new FieldNode("fundrquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "fundrquaravg", 18,2, false, "基金滚动季日均" )))
.addNode(new FieldNode("fundyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "fundyearavg", 18,2, false, "基金年日均" )))
.addNode(new FieldNode("nmloanbal", new MsgField(ContentEnum.MessageType.INT.toString(), "nmloanbal", 18,2, false, "普通贷款余额" )))
.addNode(new FieldNode("nmloanquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "nmloanquaravg", 18,2, false, "普通贷款季日均" )))
.addNode(new FieldNode("nmloanrquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "nmloanrquaravg", 18,2, false, "普通贷款滚动季日均" )))
.addNode(new FieldNode("nmloanyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "nmloanyearavg", 18,2, false, "普通贷款年日均" )))
.addNode(new FieldNode("dcloanbal", new MsgField(ContentEnum.MessageType.INT.toString(), "dcloanbal", 18,2, false, "贴现余额" )))
.addNode(new FieldNode("dcloanquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "dcloanquaravg", 18,2, false, "贴现季日均" )))
.addNode(new FieldNode("dcloanrquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "dcloanrquaravg", 18,2, false, "贴现滚动季日均" )))
.addNode(new FieldNode("dcloanyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "dcloanyearavg", 18,2, false, "贴现年日均" )))
.addNode(new FieldNode("baloanbal", new MsgField(ContentEnum.MessageType.INT.toString(), "baloanbal", 18,2, false, "承兑余额" )))
.addNode(new FieldNode("baloanquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "baloanquaravg", 18,2, false, "承兑季日均" )))
.addNode(new FieldNode("baloanrquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "baloanrquaravg", 18,2, false, "承兑滚动季日均" )))
.addNode(new FieldNode("baloanyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "baloanyearavg", 18,2, false, "承兑年日均" )))
.addNode(new FieldNode("glloanbal", new MsgField(ContentEnum.MessageType.INT.toString(), "glloanbal", 18,2, false, "保函余额" )))
.addNode(new FieldNode("glloanquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "glloanquaravg", 18,2, false, "保函季日均" )))
.addNode(new FieldNode("glloanrquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "glloanrquaravg", 18,2, false, "保函滚动季日均" )))
.addNode(new FieldNode("glloanyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "glloanyearavg", 18,2, false, "保函年日均" )))
.addNode(new FieldNode("lcloanbal", new MsgField(ContentEnum.MessageType.INT.toString(), "lcloanbal", 18,2, false, "信用证余额" )))
.addNode(new FieldNode("lcloanquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "lcloanquaravg", 18,2, false, "信用证季日均" )))
.addNode(new FieldNode("lcloanrquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "lcloanrquaravg", 18,2, false, "信用证滚动季日均" )))
.addNode(new FieldNode("lcloanyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "lcloanyearavg", 18,2, false, "信用证年日均" )))
.addNode(new FieldNode("crtloanbal", new MsgField(ContentEnum.MessageType.INT.toString(), "crtloanbal", 18,2, false, "信用卡贷款余额" )))
.addNode(new FieldNode("crtloanquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "crtloanquaravg", 18,2, false, "信用卡贷款季日均" )))
.addNode(new FieldNode("crtloanrquaravg", new MsgField(ContentEnum.MessageType.INT.toString(), "crtloanrquaravg", 18,2, false, "信用卡贷款滚动季日均" )))
.addNode(new FieldNode("crtloanyearavg", new MsgField(ContentEnum.MessageType.INT.toString(), "crtloanyearavg", 18,2, false, "信用卡贷款年日均" )))
.addNode(new FieldNode("creditbal", new MsgField(ContentEnum.MessageType.INT.toString(), "creditbal", 18,2, false, "授信额度" )))
.addNode(new FieldNode("profitmonbal", new MsgField(ContentEnum.MessageType.INT.toString(), "profitmonbal", 18,2, false, "本月利润贡献度" )))
.addNode(new FieldNode("profityearbal", new MsgField(ContentEnum.MessageType.INT.toString(), "profityearbal", 18,2, false, "本年利润贡献度" )))
.addNode(new FieldNode("scalemonbal", new MsgField(ContentEnum.MessageType.INT.toString(), "scalemonbal", 18,2, false, "本月规模贡献度" )))
.addNode(new FieldNode("scaleyearbal", new MsgField(ContentEnum.MessageType.INT.toString(), "scaleyearbal", 18,2, false, "本年规模贡献度" )))
));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

