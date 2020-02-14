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
 * BASESVC BODAFA0046  批量项目查询交易 
 *  BODAFA0046 
 *  综合前端
 * @author XZF
 */
@Component
public class BODAFA0046 extends EciChannelService {

	private static BODAFA0046_I i = new BODAFA0046_I();
	private static BODAFA0046_O o = new BODAFA0046_O();
	public BODAFA0046() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0046_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("projno", new MsgField(ContentEnum.MessageType.STRING.toString(), "projno", 50,0, false, "项目代码" )))
					.addNode(new FieldNode("appcisname", new MsgField(ContentEnum.MessageType.STRING.toString(), "appcisname", 60,0, false, "项目名称" )))
					.addNode(new FieldNode("drcrflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "drcrflag", 1,0, false, "项目性质" )))
					.addNode(new FieldNode("isnbank", new MsgField(ContentEnum.MessageType.STRING.toString(), "isnbank", 1,0, false, "是否网银标识" )))
					.addNode(new FieldNode("compcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "compcd", 20,0, true, "单位组织代码" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 30,0, false, "客户帐号" )))
					.addNode(new FieldNode("startdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "startdate", 8,0, false, "签约开始日期" )))
					.addNode(new FieldNode("enddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "enddate", 8,0, false, "签约结束日期" )))
					.addNode(new FieldNode("agenttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "agenttype", 1,0, true, "代理性质" )))
					.addNode(new FieldNode("bustype", new MsgField(ContentEnum.MessageType.STRING.toString(), "bustype", 1,0, true, "业务种类" )))
					.addNode(new FieldNode("signtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtype", 1,0, true, "签约类型" )))
					.addNode(new FieldNode("branch", new MsgField(ContentEnum.MessageType.STRING.toString(), "branch", 5,0, false, "主办网点" )))
					.addNode(new FieldNode("mainflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "mainflag", 1,0, false, "查询标志" )))
					.addNode(new FieldNode("startno", new MsgField(ContentEnum.MessageType.STRING.toString(), "startno", 10,0, false, "后续分页" )))
					.addNode(new FieldNode("rcrdnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "rcrdnm", 6,0, false, "本页记录" )))
					.addNode(new FieldNode("flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "flag", 1,0, false, "项目状态" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0046_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("totalnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalnum", 6,0, false, "总记录数" )))
					.addNode(new FieldNode("ismore", new MsgField(ContentEnum.MessageType.STRING.toString(), "ismore", 1,0, false, "是否存在后续记录" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 6,0, false, "本次返回记录数" )))
					.addNode(new ArrayNode("bodrcd",false,"project_list")
							.addNode(new FieldNode("idnx", new MsgField(ContentEnum.MessageType.STRING.toString(), "idnx", 10,0, false, "后续分页" )))
							.addNode(new FieldNode("projno", new MsgField(ContentEnum.MessageType.STRING.toString(), "projno", 20,0, false, "项目编号" )))
							.addNode(new FieldNode("projname", new MsgField(ContentEnum.MessageType.STRING.toString(), "projname", 60,0, false, "项目名称" )))
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 30,0, false, "委托帐号" )))
							.addNode(new FieldNode("acctname", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctname", 60,0, false, "委托帐号名称" )))
							.addNode(new FieldNode("glacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "glacctno", 30,0, false, "归集帐号" )))
							.addNode(new FieldNode("glacctnam", new MsgField(ContentEnum.MessageType.STRING.toString(), "glacctnam", 60,0, false, "归集帐号名称" )))
							.addNode(new FieldNode("bstype", new MsgField(ContentEnum.MessageType.STRING.toString(), "bstype", 1,0, true, "业务类型" )))
							.addNode(new FieldNode("agtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "agtype", 1,0, true, "代理性质" )))
							.addNode(new FieldNode("wdtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "wdtype", 1,0, false, "扣款方式" )))
							.addNode(new FieldNode("trtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "trtype", 1,0, true, "入账方式" )))
							.addNode(new FieldNode("sgtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "sgtype", 1,0, true, "签约方式" )))
							.addNode(new FieldNode("nttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "nttype", 1,0, true, "联网方式" )))
							.addNode(new FieldNode("agtall", new MsgField(ContentEnum.MessageType.STRING.toString(), "agtall", 1,0, false, "是否全网点代收" )))
							.addNode(new FieldNode("branch", new MsgField(ContentEnum.MessageType.STRING.toString(), "branch", 4,0, false, "主办网点号" )))
							.addNode(new FieldNode("mmtext", new MsgField(ContentEnum.MessageType.STRING.toString(), "mmtext", 50,0, false, "备注信息" )))
							.addNode(new FieldNode("isnbank", new MsgField(ContentEnum.MessageType.STRING.toString(), "isnbank", 1,0, false, "是否网银代收付" )))
							.addNode(new FieldNode("compcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "compcode", 20,0, false, "单位组织代码" )))
							.addNode(new FieldNode("dracctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dracctno", 30,0, false, "扣收帐号" )))
							.addNode(new FieldNode("dracctna", new MsgField(ContentEnum.MessageType.STRING.toString(), "dracctna", 60,0, false, "扣收帐号名称" )))
							.addNode(new FieldNode("yhbl", new MsgField(ContentEnum.MessageType.STRING.toString(), "yhbl", 10,0, false, "优惠利率" )))
							.addNode(new FieldNode("yhenddt", new MsgField(ContentEnum.MessageType.STRING.toString(), "yhenddt", 8,0, false, "优惠截至日期" )))
							.addNode(new FieldNode("drcrflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "drcrflag", 1,0, false, "项目性质" )))
							.addNode(new FieldNode("chrgtg", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrgtg", 1,0, false, "收费标志" )))
							.addNode(new FieldNode("feeamount", new MsgField(ContentEnum.MessageType.STRING.toString(), "feeamount", 8,0, false, "收费比率" )))
							.addNode(new FieldNode("lwstam", new MsgField(ContentEnum.MessageType.STRING.toString(), "lwstam", 10,0, false, "收费限额" )))
							.addNode(new FieldNode("pybkno", new MsgField(ContentEnum.MessageType.STRING.toString(), "pybkno", 8,0, false, "收费机构" )))
							.addNode(new FieldNode("mpsvcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "mpsvcd", 8,0, false, "收费类型" )))
							.addNode(new FieldNode("crcycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "crcycd", 2,0, false, "币种" )))
							.addNode(new FieldNode("smrycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "smrycd", 4,0, false, "摘要" )))
							.addNode(new FieldNode("flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "flag", 1,0, false, "项目状态" )))
							.addNode(new FieldNode("bsname", new MsgField(ContentEnum.MessageType.STRING.toString(), "bsname", 100,0, true, "业务类型名称" )))
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

