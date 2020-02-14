package cn.com.agree.huanan.ap.al.io.service.eci.hst;

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
 * BODHST0000 回单补印
 * @author YFK
 */
@Component
public class BODHST0000 extends EciChannelService{

	private static BODHST0000_I i = new BODHST0000_I();
	private static BODHST0000_O o = new BODHST0000_O();
	public BODHST0000() {
        requestFormat.add(i);
        responseFormat.add(o);
	}
	
	public static class BODHST0000_I extends MsgBody{

		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("billdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "billdt", 8,0, false, "单据日期" )))
					.addNode(new FieldNode("billsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "billsq", 20,0, false, "单据流水" )))
					.addNode(new FieldNode("billtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "billtp", 1,0, false, "单据类型" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 3,0, false, "记录数" )))
					.addNode(new StructNode("bodrcd",true)
							.addNode(new FieldNode("billdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "billdt", 8,0, false, "单据日期" )))
							.addNode(new FieldNode("billsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "billsq", 20,0, false, "单据流水" )))
							.addNode(new FieldNode("billtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "billtp", 1,0, false, "单据类型" )))
					));
			
			return messageNode;
		}
		
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}		
	}
	
	
	public static class BODHST0000_O extends MsgBody{

		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq" , 20,0, false, "报文流水" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx" , 300,1, false, "出错信息" )))
					.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark" , 024,0, false, "附言" )))
					.addNode(new FieldNode("billtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "billtp" , 12,0, false, "账单类型" )))
					.addNode(new FieldNode("crcycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "crcycd" , 3,0, false, "币种" )))
					.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranam" , 20,0, false, "交易金额" )))
					.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq" , 20,0, false, "原交易流水" )))
					.addNode(new FieldNode("orprcs", new MsgField(ContentEnum.MessageType.STRING.toString(), "orprcs" , 0,0, false, "原交易处理码" )))
					.addNode(new FieldNode("tranbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranbr" , 0,0, false, "原交易机构" )))
					.addNode(new FieldNode("tranac", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranac" , 40,0, false, "原交易账号" )))
					.addNode(new FieldNode("tranan", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranan" , 200,0, false, "原交易账户名" )))
					.addNode(new FieldNode("pcount", new MsgField(ContentEnum.MessageType.STRING.toString(), "pcount" , 3,0, false, "回单补打次数" )))
					.addNode(new FieldNode("smrytx", new MsgField(ContentEnum.MessageType.STRING.toString(), "smrytx" , 024,0, false, "备注" )))
					.addNode(new FieldNode("nra_ac", new MsgField(ContentEnum.MessageType.STRING.toString(), "nra_ac" , 40,0, false, "NRA账号" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno" , 40,0, false, "原交易账号" )))
					.addNode(new FieldNode("acctna", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctna" , 80,0, false, "原交易账户名" )))
					.addNode(new FieldNode("brchna", new MsgField(ContentEnum.MessageType.STRING.toString(), "brchna" , 0,0, false, "原交易机构" )))
					.addNode(new FieldNode("intrac", new MsgField(ContentEnum.MessageType.STRING.toString(), "intrac" , 40,0, false, "利息存入账号" )))
					.addNode(new FieldNode("intrna", new MsgField(ContentEnum.MessageType.STRING.toString(), "intrna" , 200,0, false, "利息存入账户名" )))
					.addNode(new FieldNode("inbrna", new MsgField(ContentEnum.MessageType.STRING.toString(), "inbrna" , 0,0, false, "利息存入账号机构" )))
					.addNode(new FieldNode("stdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "stdate" , 8,0, false, "起始日期" )))
					.addNode(new FieldNode("eddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "eddate" , 8,0, false, "结束日期" )))
					.addNode(new FieldNode("acmlbl", new MsgField(ContentEnum.MessageType.STRING.toString(), "acmlbl" , 21,0, false, "积数" )))
					.addNode(new FieldNode("instrt", new MsgField(ContentEnum.MessageType.STRING.toString(), "instrt" , 21,0, false, "利率" )))
					.addNode(new FieldNode("instam", new MsgField(ContentEnum.MessageType.STRING.toString(), "instam" , 21,0, false, "利息" )))
					.addNode(new FieldNode("trantp", new MsgField(ContentEnum.MessageType.STRING.toString(), "trantp" , 3,0, false, "交易类型/还款类型" )))
					.addNode(new FieldNode("intxam", new MsgField(ContentEnum.MessageType.STRING.toString(), "intxam" , 20,0, false, "利息税" )))
					.addNode(new FieldNode("pyinam", new MsgField(ContentEnum.MessageType.STRING.toString(), "pyinam" , 20,0, false, "实付利息" )))
					.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna" , 200,0, false, "借款人名称" )))
					.addNode(new FieldNode("loancn", new MsgField(ContentEnum.MessageType.STRING.toString(), "loancn" , 40,0, false, "贷款合同号" )))
					.addNode(new FieldNode("acctbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctbr" , 0,0, false, "贷款机构/对方行/账户机构" )))
					.addNode(new FieldNode("lnsbam", new MsgField(ContentEnum.MessageType.STRING.toString(), "lnsbam" , 20,0, false, "借据金额" )))
					.addNode(new FieldNode("loandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "loandt" , 8,0, false, "借款日期" )))
					.addNode(new FieldNode("lncfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "lncfno" , 20,0, false, "借据号" )))
					.addNode(new FieldNode("pyerac", new MsgField(ContentEnum.MessageType.STRING.toString(), "pyerac" , 32,0, false, "还款账号" )))
					.addNode(new FieldNode("pyacna", new MsgField(ContentEnum.MessageType.STRING.toString(), "pyacna" , 200,0, false, "还款人名称" )))
					.addNode(new FieldNode("svcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "svcode" , 8,0, false, "收费代码" )))
					.addNode(new FieldNode("svname", new MsgField(ContentEnum.MessageType.STRING.toString(), "svname" , 200,0, false, "收费项目名称" )))
					.addNode(new FieldNode("trandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt" , 8,0, false, "交易日期" )))
					.addNode(new FieldNode("taxttl", new MsgField(ContentEnum.MessageType.STRING.toString(), "taxttl" , 00,0, false, "" )))
					.addNode(new FieldNode("irtttl", new MsgField(ContentEnum.MessageType.STRING.toString(), "irtttl" , 00,0, false, "" )))
					.addNode(new FieldNode("tranamU", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranamU" , 20,0, false, "交易金额（中文大写）" )))
					.addNode(new FieldNode("instamU", new MsgField(ContentEnum.MessageType.STRING.toString(), "instamU" , 20,0, false, "利息（大写）" )))
					.addNode(new FieldNode("intxamU", new MsgField(ContentEnum.MessageType.STRING.toString(), "intxamU" , 20,0, false, "利息税(大写)" )))
					.addNode(new FieldNode("pyinamU", new MsgField(ContentEnum.MessageType.STRING.toString(), "pyinamU" , 20,0, false, "实付利息(大写)" )))
					.addNode(new FieldNode("lnsbamU", new MsgField(ContentEnum.MessageType.STRING.toString(), "lnsbamU" , 20,0, false, "借据金额（大写）" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm" , 3,0, false, "记录数" )))
					.addNode(new StructNode("bodrcd",true)
							.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark" , 024,0, false, "附言" )))
							.addNode(new FieldNode("billtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "billtp" , 12,0, false, "账单类型" )))
							.addNode(new FieldNode("crcycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "crcycd" , 3,0, false, "币种" )))
							.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranam" , 20,0, false, "交易金额" )))
							.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq" , 20,0, false, "原交易流水" )))
							.addNode(new FieldNode("orprcs", new MsgField(ContentEnum.MessageType.STRING.toString(), "orprcs" , 0,0, false, "原交易处理码" )))
							.addNode(new FieldNode("tranbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranbr" , 0,0, false, "原交易机构" )))
							.addNode(new FieldNode("tranac", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranac" , 40,0, false, "原交易账号" )))
							.addNode(new FieldNode("tranan", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranan" , 200,0, false, "原交易账户名" )))
							.addNode(new FieldNode("pcount", new MsgField(ContentEnum.MessageType.STRING.toString(), "pcount" , 3,0, false, "回单补打次数" )))
							.addNode(new FieldNode("smrytx", new MsgField(ContentEnum.MessageType.STRING.toString(), "smrytx" , 024,0, false, "备注" )))
							.addNode(new FieldNode("nra_ac", new MsgField(ContentEnum.MessageType.STRING.toString(), "nra_ac" , 40,0, false, "NRA账号" )))
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno" , 40,0, false, "原交易账号" )))
							.addNode(new FieldNode("acctna", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctna" , 80,0, false, "原交易账户名" )))
							.addNode(new FieldNode("brchna", new MsgField(ContentEnum.MessageType.STRING.toString(), "brchna" , 0,0, false, "原交易机构" )))
							.addNode(new FieldNode("intrac", new MsgField(ContentEnum.MessageType.STRING.toString(), "intrac" , 40,0, false, "利息存入账号" )))
							.addNode(new FieldNode("intrna", new MsgField(ContentEnum.MessageType.STRING.toString(), "intrna" , 200,0, false, "利息存入账户名" )))
							.addNode(new FieldNode("inbrna", new MsgField(ContentEnum.MessageType.STRING.toString(), "inbrna" , 0,0, false, "利息存入账号机构" )))
							.addNode(new FieldNode("stdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "stdate" , 8,0, false, "起始日期" )))
							.addNode(new FieldNode("eddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "eddate" , 8,0, false, "结束日期" )))
							.addNode(new FieldNode("acmlbl", new MsgField(ContentEnum.MessageType.STRING.toString(), "acmlbl" , 21,0, false, "积数" )))
							.addNode(new FieldNode("instrt", new MsgField(ContentEnum.MessageType.STRING.toString(), "instrt" , 21,0, false, "利率" )))
							.addNode(new FieldNode("instam", new MsgField(ContentEnum.MessageType.STRING.toString(), "instam" , 21,0, false, "利息" )))
							.addNode(new FieldNode("trantp", new MsgField(ContentEnum.MessageType.STRING.toString(), "trantp" , 3,0, false, "交易类型/还款类型" )))
							.addNode(new FieldNode("intxam", new MsgField(ContentEnum.MessageType.STRING.toString(), "intxam" , 20,0, false, "利息税" )))
							.addNode(new FieldNode("pyinam", new MsgField(ContentEnum.MessageType.STRING.toString(), "pyinam" , 20,0, false, "实付利息" )))
							.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna" , 200,0, false, "借款人名称" )))
							.addNode(new FieldNode("loancn", new MsgField(ContentEnum.MessageType.STRING.toString(), "loancn" , 40,0, false, "贷款合同号" )))
							.addNode(new FieldNode("acctbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctbr" , 0,0, false, "贷款机构/对方行/账户机构" )))
							.addNode(new FieldNode("lnsbam", new MsgField(ContentEnum.MessageType.STRING.toString(), "lnsbam" , 20,0, false, "借据金额" )))
							.addNode(new FieldNode("loandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "loandt" , 8,0, false, "借款日期" )))
							.addNode(new FieldNode("lncfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "lncfno" , 20,0, false, "借据号" )))
							.addNode(new FieldNode("pyerac", new MsgField(ContentEnum.MessageType.STRING.toString(), "pyerac" , 32,0, false, "还款账号" )))
							.addNode(new FieldNode("pyacna", new MsgField(ContentEnum.MessageType.STRING.toString(), "pyacna" , 200,0, false, "还款人名称" )))
							.addNode(new FieldNode("svcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "svcode" , 8,0, false, "收费代码" )))
							.addNode(new FieldNode("svname", new MsgField(ContentEnum.MessageType.STRING.toString(), "svname" , 200,0, false, "收费项目名称" )))
							.addNode(new FieldNode("trandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt" , 8,0, false, "交易日期" )))
							.addNode(new FieldNode("taxttl", new MsgField(ContentEnum.MessageType.STRING.toString(), "taxttl" , 00,0, false, "" )))
							.addNode(new FieldNode("irtttl", new MsgField(ContentEnum.MessageType.STRING.toString(), "irtttl" , 00,0, false, "" )))
							.addNode(new FieldNode("tranamU", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranamU" , 20,0, false, "交易金额（中文大写）" )))
							.addNode(new FieldNode("instamU", new MsgField(ContentEnum.MessageType.STRING.toString(), "instamU" , 20,0, false, "利息（大写）" )))
							.addNode(new FieldNode("intxamU", new MsgField(ContentEnum.MessageType.STRING.toString(), "intxamU" , 20,0, false, "利息税(大写)" )))
							.addNode(new FieldNode("pyinamU", new MsgField(ContentEnum.MessageType.STRING.toString(), "pyinamU" , 20,0, false, "实付利息(大写)" )))
							.addNode(new FieldNode("lnsbamU", new MsgField(ContentEnum.MessageType.STRING.toString(), "lnsbamU" , 20,0, false, "借据金额（大写）" )))
							.addNode(new FieldNode("billdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "billdt" , 8,0, false, "单据日期" )))
							.addNode(new FieldNode("billsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "billsq" , 20,0, false, "单据流水" )))

					));
			
			return messageNode;
		}
		
		@Override
		public ArrayList<Node> listNode() {			
			return msgSegment.getNodeList();
		}
		
	}
}
