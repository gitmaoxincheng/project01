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
 * BASESVC.P043001201 银行卡综合信息查询.卡层交易时间查询 
 * P0430012.01 iccrdi
 * 0005 新核心系统
 * @author ZZC
 */
@Component
public class P043001201 extends EsbCore1ChannelService {

	private static P043001201_I i = new P043001201_I();
	private static P043001201_O o = new P043001201_O();
	public P043001201() {
		requestFormat.add(i);
		responseFormat.add(o);
	}
  
	public static class P043001201_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno",401,0, true, "卡号 ")))
					.addNode(new FieldNode("inpttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "inpttp",31,0, true, "输入类型 ")))
					.addNode(new FieldNode("kaxulieh", new MsgField(ContentEnum.MessageType.STRING.toString(), "kaxulieh",21,0, false, "卡序列号 ")))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P043001201_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(),"cardno",401,0, false, "卡号 ")))
					.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.STRING.toString(),"tranam",181,0, false, "交易金额 ")))
					.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(),"custna",2561,0, false, "户名 ")))
					.addNode(new FieldNode("crcycd", new MsgField(ContentEnum.MessageType.STRING.toString(),"crcycd",31,0, false, "币种 ")))
					.addNode(new FieldNode("acctst", new MsgField(ContentEnum.MessageType.STRING.toString(),"acctst",21,0, false, "电子现金账户状态 ")))
					.addNode(new FieldNode("acctbr", new MsgField(ContentEnum.MessageType.STRING.toString(),"acctbr",21,0, false, "机构号 ")))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(),"idtftp",21,0, false, "证件类型 ")))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(),"idtfno",301,0, false, "证件号码 ")))
					.addNode(new FieldNode("opendt", new MsgField(ContentEnum.MessageType.STRING.toString(),"opendt",81,0, false, "电子现金账户开户日期 ")))
					.addNode(new FieldNode("exprdt", new MsgField(ContentEnum.MessageType.STRING.toString(),"exprdt",81,0, false, "电子现金失效日期 ")))
					.addNode(new FieldNode("ballmt", new MsgField(ContentEnum.MessageType.STRING.toString(),"ballmt",101,0, false, "电子现金余额上限 ")))
					.addNode(new FieldNode("totlam", new MsgField(ContentEnum.MessageType.STRING.toString(),"totlam",101,0, false, "累计圈存金额 ")))
					.addNode(new FieldNode("totuam", new MsgField(ContentEnum.MessageType.STRING.toString(),"totuam",101,0, false, "累计圈提金额 ")))
					.addNode(new FieldNode("ltofdt", new MsgField(ContentEnum.MessageType.STRING.toString(),"ltofdt",81,0, false, "最近脱机交易日期 ")))
					.addNode(new FieldNode("closdt", new MsgField(ContentEnum.MessageType.STRING.toString(),"closdt",81,0, false, "电子现金账户销户日期 ")))
					.addNode(new FieldNode("onlnbl", new MsgField(ContentEnum.MessageType.STRING.toString(),"onlnbl",181,0, false, "账户余额 ")))
					.addNode(new FieldNode("loadbl", new MsgField(ContentEnum.MessageType.STRING.toString(),"loadbl",101,0, false, "补登账户余额 ")))
					.addNode(new FieldNode("txnlmt", new MsgField(ContentEnum.MessageType.STRING.toString(),"txnlmt",101,0, false, "电子现金单笔限额 ")))
							);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

