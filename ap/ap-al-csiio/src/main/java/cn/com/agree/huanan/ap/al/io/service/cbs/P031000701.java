package cn.com.agree.huanan.ap.al.io.service.cbs;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbCore1ChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P031000701 跨行转账代理。统一支付
 * P0310007.01 T0399L200
 * 0005 新核心系统
 * @author zhuzc
 */
@Component
public class P031000701 extends EsbCore1ChannelService {
	
	private static P031000701_I i = new P031000701_I();
	private static P031000701_O o = new P031000701_O();
	public P031000701() {
		requestFormat.add(i);
		responseFormat.add(o); 
	}

	public static class P031000701_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){ 
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("gtversion", new MsgField(ContentEnum.MessageType.STRING.toString(), "gtversion",3,0,false,"交易接口版本号" )))
					.addNode(new FieldNode("transdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "transdate",8,0,false,"ATMP交易日期" )))
					.addNode(new FieldNode("transtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "transtime",6,0,false,"ATMP交易时间" )))
					.addNode(new FieldNode("transtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "transtype",4,0,false,"交易类型" )))
					.addNode(new FieldNode("revtranstype", new MsgField(ContentEnum.MessageType.STRING.toString(), "revtranstype",4,0,false,"自动冲正时的原交易类型" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno",40,0,false,"交易卡号" )))
					.addNode(new FieldNode("expire", new MsgField(ContentEnum.MessageType.STRING.toString(), "expire",4,0,false,"有效期" )))
					.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranam",13,0,false,"交易金额" )))
					.addNode(new FieldNode("curtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "curtype",3,0,false,"币种" )))
					.addNode(new FieldNode("terminalid", new MsgField(ContentEnum.MessageType.STRING.toString(), "terminalid",8,0,false,"ATM终端号" )))
					.addNode(new FieldNode("merchantid", new MsgField(ContentEnum.MessageType.STRING.toString(), "merchantid",15,0,false,"所号/商户号" )))
					.addNode(new FieldNode("track2", new MsgField(ContentEnum.MessageType.STRING.toString(), "track2",37,0,false,"第二磁道" )))
					.addNode(new FieldNode("track3", new MsgField(ContentEnum.MessageType.STRING.toString(), "track3",104,0,false,"第三磁道" )))
					.addNode(new FieldNode("passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "passwd",16,0,false,"密码" )))
					.addNode(new FieldNode("gtacct2", new MsgField(ContentEnum.MessageType.STRING.toString(), "gtacct2",19,0,false,"转入帐号" )))
					.addNode(new FieldNode("gtfee", new MsgField(ContentEnum.MessageType.STRING.toString(), "gtfee",10,0,false,"手续费" )))
					.addNode(new FieldNode("depno", new MsgField(ContentEnum.MessageType.STRING.toString(), "depno",15,0,false,"设备所属机构号" )))
					.addNode(new FieldNode("trace", new MsgField(ContentEnum.MessageType.STRING.toString(), "trace",12,0,false,"ATMP 交易流水号" )))
					.addNode(new FieldNode("revtrace", new MsgField(ContentEnum.MessageType.STRING.toString(), "revtrace",12,0,false,"ATMP 冲正交易流水号" )))
					.addNode(new FieldNode("gthostls", new MsgField(ContentEnum.MessageType.STRING.toString(), "gthostls",12,0,false,"金卡前置机流水号" )))
					.addNode(new FieldNode("entrymode", new MsgField(ContentEnum.MessageType.STRING.toString(), "entrymode",3,0,false,"持卡人输入方式" )))
					.addNode(new FieldNode("cardseq", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardseq",3,0,false,"卡片序号" )))
					.addNode(new FieldNode("icdata", new MsgField(ContentEnum.MessageType.STRING.toString(), "icdata",600,0,false,"IC卡芯片数据" )))
					.addNode(new FieldNode("capability", new MsgField(ContentEnum.MessageType.STRING.toString(), "capability",1,0,false,"终端处理能力" )))
					.addNode(new FieldNode("concode", new MsgField(ContentEnum.MessageType.STRING.toString(), "concode",1,0,false,"IC卡条件码" )))
					.addNode(new FieldNode("address", new MsgField(ContentEnum.MessageType.STRING.toString(), "address",40,0,false,"受理方地址" )))
					.addNode(new FieldNode("canceltrace", new MsgField(ContentEnum.MessageType.STRING.toString(), "canceltrace",18,0,false,"原交易信息" )))
					.addNode(new FieldNode("taccttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "taccttype",1,0,false,"账户所有人类型" )))
					.addNode(new FieldNode("tbusinesstype", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbusinesstype",2,0,false,"业务类型" )))
					.addNode(new FieldNode("mu", new MsgField(ContentEnum.MessageType.STRING.toString(), "mu",3,0,false,"资金用途" )))
					.addNode(new FieldNode("usrnameout", new MsgField(ContentEnum.MessageType.STRING.toString(), "usrnameout",120,0,false,"输出方单位结算卡户名" )))
					.addNode(new FieldNode("idetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idetype",2,0,false,"证件类型" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno",30,0,false,"证件号码" )))
					.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl",11,0,false,"手机号码" )))
					.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name",30,0,false,"姓名" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P031000701_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("version", new MsgField(ContentEnum.MessageType.STRING.toString(), "version",3,0,false,"交易接口版本号" )))
					.addNode(new FieldNode("transdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "transdate",8,0,false,"交易日期" )))
					.addNode(new FieldNode("transtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "transtime",6,0,false,"交易时间" )))
					.addNode(new FieldNode("transtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "transtype",4,0,false,"交易类型" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno",40,0,false,"交易卡号" )))
					.addNode(new FieldNode("expire", new MsgField(ContentEnum.MessageType.STRING.toString(), "expire",4,0,false,"有效期" )))
					.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranam",20,0,false,"交易金额" )))
					.addNode(new FieldNode("curtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "curtype",3,0,false,"币种" )))
					.addNode(new FieldNode("terminalid", new MsgField(ContentEnum.MessageType.STRING.toString(), "terminalid",8,0,false,"ATM终端号" )))
					.addNode(new FieldNode("merchantid", new MsgField(ContentEnum.MessageType.STRING.toString(), "merchantid",15,0,false,"所号/商户号" )))
					.addNode(new FieldNode("gtacct2", new MsgField(ContentEnum.MessageType.STRING.toString(), "gtacct2",19,0,false,"转入帐号" )))
					.addNode(new FieldNode("fee", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee",10,0,false,"手续费" )))
					.addNode(new FieldNode("depno", new MsgField(ContentEnum.MessageType.STRING.toString(), "depno",15,0,false,"设备所属机构号" )))
					.addNode(new FieldNode("entrymode", new MsgField(ContentEnum.MessageType.STRING.toString(), "entrymode",3,0,false,"持卡人输入方式" )))
					.addNode(new FieldNode("cardseq", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardseq",3,0,false,"卡片序号" )))
					.addNode(new FieldNode("icdata", new MsgField(ContentEnum.MessageType.STRING.toString(), "icdata",600,0,false,"IC卡芯片数据" )))
					.addNode(new FieldNode("capability", new MsgField(ContentEnum.MessageType.STRING.toString(), "capability",1,0,false,"终端处理能力" )))
					.addNode(new FieldNode("concode", new MsgField(ContentEnum.MessageType.STRING.toString(), "concode",1,0,false,"IC卡条件码" )))
					.addNode(new FieldNode("trace", new MsgField(ContentEnum.MessageType.STRING.toString(), "trace",12,0,false,"ATMP交易流水号" )))
					.addNode(new FieldNode("hostls", new MsgField(ContentEnum.MessageType.STRING.toString(), "hostls",12,0,false,"金卡前置机流水号" )))
					.addNode(new FieldNode("retcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "retcode",4,0,false,"返回码" )))
					.addNode(new FieldNode("actcur", new MsgField(ContentEnum.MessageType.STRING.toString(), "actcur",3,0,false,"账户余额的币种" )))
					.addNode(new FieldNode("actbal", new MsgField(ContentEnum.MessageType.STRING.toString(), "actbal",13,0,false,"账户余额" )))
					.addNode(new FieldNode("avlcur", new MsgField(ContentEnum.MessageType.STRING.toString(), "avlcur",3,0,false,"可用余额的币种" )))
					.addNode(new FieldNode("avlbal", new MsgField(ContentEnum.MessageType.STRING.toString(), "avlbal",13,0,false,"可用余额" )))
					.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name",30,0,false,"姓名" )))
					.addNode(new FieldNode("arvalue", new MsgField(ContentEnum.MessageType.STRING.toString(), "arvalue",3,0,false,"返回码附加信息" )))
					.addNode(new FieldNode("usrnamein", new MsgField(ContentEnum.MessageType.STRING.toString(), "usrnamein",120,0,false,"输入方单位结算卡户名" )))
					.addNode(new FieldNode("acctlevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctlevel",1,0,false,"账户等级" )))
					.addNode(new FieldNode("countertype", new MsgField(ContentEnum.MessageType.STRING.toString(), "countertype",1,0,false,"柜面核身" )))
					.addNode(new FieldNode("arcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "arcode",4,0,false,"细化应答码" )))
					.addNode(new FieldNode("ots", new MsgField(ContentEnum.MessageType.STRING.toString(), "ots",1,0,false,"原始交易状态" )))
					.addNode(new FieldNode("retcodeots", new MsgField(ContentEnum.MessageType.STRING.toString(), "retcodeots",2,0,false,"原始交易应答码" )))
					.addNode(new FieldNode("asarots", new MsgField(ContentEnum.MessageType.STRING.toString(), "asarots",3,0,false,"原始交易附加应答消息" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

