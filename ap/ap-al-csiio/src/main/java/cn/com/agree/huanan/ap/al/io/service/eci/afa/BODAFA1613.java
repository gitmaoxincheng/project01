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
 * BASESVC BODAFA1613  批量代扣明细查询 
 *  BODAFA1613 8819305
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1613 extends EciChannelService {

	private static BODAFA1613_I i = new BODAFA1613_I();
	private static BODAFA1613_O o = new BODAFA1613_O();
	public BODAFA1613() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1613_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("batchdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchdate", 8,0, false, "批次日期" )))
					.addNode(new FieldNode("batchserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchserno", 30,0, false, "批次流水" )))
					.addNode(new FieldNode("startdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "startdate", 8,0, false, "开始日期" )))
					.addNode(new FieldNode("enddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "enddate", 8,0, false, "截至日期" )))
					.addNode(new FieldNode("printnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "printnm", 30,0, false, "打印次数" )))
					.addNode(new FieldNode("maxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxnum", 5,0, false, "查询条数" )))
					.addNode(new FieldNode("bankstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankstatus", 1,0, false, "处理状态" )))
					.addNode(new FieldNode("idxtradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxtradedate", 8,0, false, "翻页交易日期" )))
					.addNode(new FieldNode("idxserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxserialno", 20,0, false, "翻页交易流水" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1613_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("totnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totnum", 10,0, false, "总记录数" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 10,0, false, "返回记录数" )))
					.addNode(new ArrayNode("bodrcd",false)
							.addNode(new FieldNode("strtradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "strtradedate", 8,0, false, "前置日期" )))
							.addNode(new FieldNode("strserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "strserialno", 30,0, false, "前置流水" )))
							.addNode(new FieldNode("batchdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchdate", 8,0, false, "批次日期" )))
							.addNode(new FieldNode("batchserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchserno", 30,0, false, "批次流水" )))
							.addNode(new FieldNode("sernum", new MsgField(ContentEnum.MessageType.STRING.toString(), "sernum", 10,0, false, "文件内序号" )))
							.addNode(new FieldNode("payserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "payserno", 30,0, false, "缴费编号" )))
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 32,0, false, "账号" )))
							.addNode(new FieldNode("acctname", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctname", 256,0, false, "户名" )))
							.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "amount", 17,0, false, "应收金额" )))
							.addNode(new FieldNode("realamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "realamt", 17,0, false, "实收金额" )))
							.addNode(new FieldNode("fee", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee", 17,0, false, "手续费" )))
							.addNode(new FieldNode("bankdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankdate", 8,0, false, "主机日期" )))
							.addNode(new FieldNode("bankserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankserno", 30,0, false, "主机流水" )))
							.addNode(new FieldNode("bankcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankcode", 10,0, false, "主机返回码" )))
							.addNode(new FieldNode("bankmsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankmsg", 512,0, false, "主机返回信息" )))
							.addNode(new FieldNode("bankstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankstatus", 1,0, false, "处理状态" )))
							.addNode(new FieldNode("printnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "printnum", 10,0, false, "打印次数" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

