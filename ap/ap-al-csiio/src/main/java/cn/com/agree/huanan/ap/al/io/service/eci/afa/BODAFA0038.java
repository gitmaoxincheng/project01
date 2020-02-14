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
 * BASESVC BODAFA0038  贷记卡未出账单查询 
 *  BODAFA0038 
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA0038 extends EciChannelService {

	private static BODAFA0038_I i = new BODAFA0038_I();
	private static BODAFA0038_O o = new BODAFA0038_O();
	public BODAFA0038() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0038_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 22,0, true, "卡号" )))
					.addNode(new FieldNode("passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "passwd", 300,0, true, "交易密码" )))
					.addNode(new FieldNode("pin_flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pin_flag", 1,0, true, "检查密码标志" )))
					.addNode(new FieldNode("enq_flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "enq_flag", 1,0, true, "查询方式" )))
					.addNode(new FieldNode("option", new MsgField(ContentEnum.MessageType.STRING.toString(), "option", 1,0, true, "币种" )))
					.addNode(new FieldNode("cardnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardnm", 30,0, true, "持卡人姓名" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 18,0, false, "密码序号" )))
					.addNode(new FieldNode("filemode", new MsgField(ContentEnum.MessageType.STRING.toString(), "filemode", 8,0, false, "文件模式" )))
					.addNode(new FieldNode("rtn_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "rtn_ind", 8,0, false, "翻页标志" )))
					.addNode(new FieldNode("val_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "val_date", 8,0, false, "入帐日期" )))
					.addNode(new FieldNode("pur_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "pur_date", 8,0, false, "记录日期" )))
					.addNode(new FieldNode("pur_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "pur_time", 8,0, false, "消费时间" )))
					.addNode(new FieldNode("tranno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranno", 8,0, false, "交易流水号" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 1,0, true, "是否需要密码" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 20,0, false, "密码的来源" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0038_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 2,0, false, "本次返回交易条数" )))
					.addNode(new FieldNode("rtn_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "rtn_ind", 1,0, false, "翻页标志" )))
					.addNode(new ArrayNode("bodrcd",true,"bodrcd")
							.addNode(new FieldNode("val_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "val_date", 8,0, false, "入帐日期" )))
							.addNode(new FieldNode("pur_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "pur_date", 8,0, false, "记录日期" )))
							.addNode(new FieldNode("pur_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "pur_time", 8,0, false, "消费时间" )))
							.addNode(new FieldNode("tranno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranno", 6,0, false, "交易流水号" )))
							.addNode(new FieldNode("month_nbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "month_nbr", 3,0, false, "月份序号" )))
							.addNode(new FieldNode("trantype", new MsgField(ContentEnum.MessageType.STRING.toString(), "trantype", 4,0, false, "交易类型" )))
							.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "amount", 12,0, false, "交易金额" )))
							.addNode(new FieldNode("amt_flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "amt_flag", 1,0, false, "交易金额符号" )))
							.addNode(new FieldNode("authcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "authcode", 6,0, false, "授权代码" )))
							.addNode(new FieldNode("desline1", new MsgField(ContentEnum.MessageType.STRING.toString(), "desline1", 42,0, false, "交易描述1" )))
							.addNode(new FieldNode("desline2", new MsgField(ContentEnum.MessageType.STRING.toString(), "desline2", 25,0, false, "交易描述2" )))
							.addNode(new FieldNode("cardend", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardend", 4,0, false, "卡号后四位" )))
							.addNode(new FieldNode("curr_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "curr_num", 3,0, false, "货币代码" )))
							.addNode(new FieldNode("mp_flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "mp_flag", 1,0, false, "分期付款标志" )))
							.addNode(new FieldNode("purx_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "purx_date", 4,0, false, "消费日期" )))
							.addNode(new FieldNode("rev_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "rev_ind", 1,0, false, "撤销冲正标志" )))
							.addNode(new FieldNode("revs", new MsgField(ContentEnum.MessageType.STRING.toString(), "revs", 5,0, false, "保留" )))
							)
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

