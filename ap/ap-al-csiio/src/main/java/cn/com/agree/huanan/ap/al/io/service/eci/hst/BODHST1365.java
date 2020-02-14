package cn.com.agree.huanan.ap.al.io.service.eci.hst;

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
 * BASESVC BODHST1365  电票签约查询
 * BODHST1365 qrchck qrdzdf
 *  旧核心系统
 * @author CZP
 */
@Component
public class BODHST1365 extends EciChannelService {
	
	private static BODHST1365_I i = new BODHST1365_I();
	private static BODHST1365_O o = new BODHST1365_O();

	public BODHST1365() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODHST1365_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("prcsfg", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcsfg", 20,0, false, "子处理码标识" )))
					.addNode(new FieldNode("acctna", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctna", 100,0, false, "户名" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 30,0, false, "账号" )))
					.addNode(new FieldNode("tranbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranbr", 10,0, false, "签约经办部门" )))
					.addNode(new FieldNode("orgnbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgnbr", 20,0, false, "组织机构代码证" )))
					.addNode(new FieldNode("rmtrtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "rmtrtp", 10,0, false, "业务主体类型" )))
					.addNode(new FieldNode("rmtrfg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rmtrfg", 2,0, false, "签约状态" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODHST1365_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("erorcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "erorcd", 8,0, false, "主机返回代码" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 255,0, false, "主机返回信息" )))
					.addNode(new FieldNode("svwktm", new MsgField(ContentEnum.MessageType.STRING.toString(), "svwktm", 6,0, false, "主机返回时间" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 10,0, false, "返回记录数" )))
					.addNode(new FieldNode("totnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totnum", 10,0, false, "总笔数" )))
					.addNode(new ArrayNode("bodrcd", false, "sign_list")
							.addNode(new FieldNode("cmtrdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cmtrdt", 10,0, false, "交易日期" )))
							.addNode(new FieldNode("billdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "billdt", 10,0, false, "交易日期" )))
							.addNode(new FieldNode("billsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "billsq", 20,0, false, "通用交易流水" )))
							.addNode(new FieldNode("orgnbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgnbr", 20,0, false, "组织机构代码证" )))
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 30,0, false, "账号" )))
							.addNode(new FieldNode("acctna", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctna", 200,0, false, "户名" )))
							.addNode(new FieldNode("rmtrtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "rmtrtp", 10,0, false, "业务主体类型" )))
							.addNode(new FieldNode("rmtrfg", new MsgField(ContentEnum.MessageType.STRING.toString(), "rmtrfg", 2,0, false, "签约状态" )))
							.addNode(new FieldNode("tranbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranbr", 10,0, false, "签约经办部门" )))
							.addNode(new FieldNode("tranus", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranus", 10,0, false, "签约经办柜员" )))
							.addNode(new FieldNode("psauus", new MsgField(ContentEnum.MessageType.STRING.toString(), "psauus", 10,0, false, "签约授权柜员" )))
							.addNode(new FieldNode("sttrdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "sttrdt", 10,0, false, "解约日期" )))
							.addNode(new FieldNode("sttrsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "sttrsq", 10,0, false, "解约流水" )))
							.addNode(new FieldNode("stanbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "stanbr", 10,0, false, "解约网点" )))
							.addNode(new FieldNode("stanus", new MsgField(ContentEnum.MessageType.STRING.toString(), "stanus", 10,0, false, "解约经办柜员" )))
							.addNode(new FieldNode("stpaus", new MsgField(ContentEnum.MessageType.STRING.toString(), "stpaus", 10,0, false, "解约授权柜员" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
