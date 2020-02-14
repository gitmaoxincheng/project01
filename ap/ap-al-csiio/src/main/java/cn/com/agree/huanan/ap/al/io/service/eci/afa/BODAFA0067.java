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
 * BASESVC BODAFA0067  贷记卡账单头查询 
 *  BODAFA0067 881004
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA0067 extends EciChannelService {

	private static BODAFA0067_I i = new BODAFA0067_I();
	private static BODAFA0067_O o = new BODAFA0067_O();
	public BODAFA0067() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0067_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("trantm", new MsgField(ContentEnum.MessageType.STRING.toString(), "trantm", 8,0, false, "查询年月" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 40,0, false, "卡号" )))
					.addNode(new FieldNode("option", new MsgField(ContentEnum.MessageType.STRING.toString(), "option", 1,0, false, "密码选项" )))
					.addNode(new FieldNode("passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "passwd", 20,0, false, "交易密码" )))
					.addNode(new FieldNode("cardnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardnm", 100,0, false, "持卡人姓名" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0067_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("bnknbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "bnknbr", 20,0, false, "银行代号" )))
					.addNode(new FieldNode("source", new MsgField(ContentEnum.MessageType.STRING.toString(), "source", 10,0, false, "交易来源" )))
					.addNode(new FieldNode("brn_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "brn_no", 10,0, false, "网点代号" )))
					.addNode(new FieldNode("ope_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "ope_no", 10,0, false, "操作员号" )))
					.addNode(new FieldNode("seqno", new MsgField(ContentEnum.MessageType.STRING.toString(), "seqno", 20,0, false, "流水号" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 40,0, false, "卡号" )))
					.addNode(new FieldNode("tranymtran_ym", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranymtran_ym", 8,0, false, "帐单年月" )))
					.addNode(new FieldNode("option", new MsgField(ContentEnum.MessageType.STRING.toString(), "option", 1,0, false, "本、外币选项" )))
					.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "amount", 17,0, false, "本期应还款" )))
					.addNode(new FieldNode("openamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "openamt", 17,0, false, "上期帐单金额" )))
					.addNode(new FieldNode("openflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "openflag", 1,0, false, "上期帐单金额符号" )))
					.addNode(new FieldNode("payed", new MsgField(ContentEnum.MessageType.STRING.toString(), "payed", 17,0, false, "已还金额" )))
					.addNode(new FieldNode("stmtamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "stmtamt", 17,0, false, "本期账单金额" )))
					.addNode(new FieldNode("stmtflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "stmtflag", 1,0, false, "本期账单金额符号" )))
					.addNode(new FieldNode("creditinst", new MsgField(ContentEnum.MessageType.STRING.toString(), "creditinst", 17,0, false, "循环利息" )))
					.addNode(new FieldNode("pently", new MsgField(ContentEnum.MessageType.STRING.toString(), "pently", 17,0, false, "罚金" )))
					.addNode(new FieldNode("otherfee", new MsgField(ContentEnum.MessageType.STRING.toString(), "otherfee", 17,0, false, "其他费用" )))
					.addNode(new FieldNode("cashad", new MsgField(ContentEnum.MessageType.STRING.toString(), "cashad", 17,0, false, "预借现金金额" )))
					.addNode(new FieldNode("cashadfee", new MsgField(ContentEnum.MessageType.STRING.toString(), "cashadfee", 17,0, false, "预借现金手续费" )))
					.addNode(new FieldNode("purchamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "purchamt", 17,0, false, "消费金额" )))
					.addNode(new FieldNode("cardfee", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardfee", 17,0, false, "卡片费用" )))
					.addNode(new FieldNode("adjustment", new MsgField(ContentEnum.MessageType.STRING.toString(), "adjustment", 17,0, false, "调整金额" )))
					.addNode(new FieldNode("adjflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "adjflag", 1,0, false, "调整金额符号" )))
					.addNode(new FieldNode("minpay", new MsgField(ContentEnum.MessageType.STRING.toString(), "minpay", 17,0, false, "最小还款额" )))
					.addNode(new FieldNode("duedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "duedate", 8,0, false, "还款截止日期" )))
					.addNode(new FieldNode("stmtdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "stmtdate", 8,0, false, "帐单日期" )))
					.addNode(new FieldNode("accname1", new MsgField(ContentEnum.MessageType.STRING.toString(), "accname1", 100,0, false, "姓名" )))
					.addNode(new FieldNode("bankacct", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankacct", 40,0, false, "自扣还款账号" )))
					.addNode(new FieldNode("payfalg", new MsgField(ContentEnum.MessageType.STRING.toString(), "payfalg", 2,0, false, "自扣还款方式" )))
					.addNode(new FieldNode("points", new MsgField(ContentEnum.MessageType.STRING.toString(), "points", 17,0, false, "帐单积分总额" )))
					.addNode(new FieldNode("ptpt_flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptpt_flag", 1,0, false, "帐单积分总额符号" )))
					.addNode(new FieldNode("pointspoints_last", new MsgField(ContentEnum.MessageType.STRING.toString(), "pointspoints_last", 17,0, false, "上期帐单积分余额" )))
					.addNode(new FieldNode("ptpt_lastflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptpt_lastflag", 1,0, false, "上期帐单积分余额符号" )))
					.addNode(new FieldNode("ptpt_clm", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptpt_clm", 17,0, false, "当期兑换积分" )))
					.addNode(new FieldNode("ptpt_clmflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptpt_clmflag", 1,0, false, "当期兑换积分符号" )))
					.addNode(new FieldNode("ptpt_new", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptpt_new", 17,0, false, "当期新增基础积分" )))
					.addNode(new FieldNode("ptpt_newflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptpt_newflag", 1,0, false, "当期新增基础积分符号" )))
					.addNode(new FieldNode("ptpt_adj", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptpt_adj", 17,0, false, "当期调整积分" )))
					.addNode(new FieldNode("ptpt_adjflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptpt_adjflag", 1,0, false, "当期调整积分的符号" )))
					.addNode(new FieldNode("ptpt_enc", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptpt_enc", 17,0, false, "当期奖励积分" )))
					.addNode(new FieldNode("ptpt_encflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptpt_encflag", 1,0, false, "当期奖励积分符号" )))
					.addNode(new FieldNode("ptpt_imp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptpt_imp", 17,0, false, "当期转入积分" )))
					.addNode(new FieldNode("ptpt_impflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptpt_impflag", 1,0, false, "当期转入积分符号" )))
					.addNode(new FieldNode("ptpt_exp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptpt_exp", 17,0, false, "当期转出积分" )))
					.addNode(new FieldNode("ptpt_expflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptpt_expflag", 1,0, false, "当期转出积分符号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

