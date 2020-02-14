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
 * BASESVC BODAFA1612  批量代扣批次查询 
 *  BODAFA1612 8819304
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1612 extends EciChannelService {

	private static BODAFA1612_I i = new BODAFA1612_I();
	private static BODAFA1612_O o = new BODAFA1612_O();
	public BODAFA1612() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1612_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("glacctno",new MsgField(ContentEnum.MessageType.STRING.toString(),"glacctno" ,8,0, false, "委托单位账号" )))
					.addNode(new FieldNode("acctno",new MsgField(ContentEnum.MessageType.STRING.toString(),"acctno" ,8,0, false, "账号" )))
					.addNode(new FieldNode("batchdate",new MsgField(ContentEnum.MessageType.STRING.toString(),"batchdate" ,256,0, false, "批次日期" )))
					.addNode(new FieldNode("batchserno",new MsgField(ContentEnum.MessageType.STRING.toString(),"batchserno" ,30,0, false, "批次流水" )))
					.addNode(new FieldNode("orichannelserno",new MsgField(ContentEnum.MessageType.STRING.toString(),"orichannelserno" ,8,0, false, "原前端流水" )))
					.addNode(new FieldNode("subbatchdate",new MsgField(ContentEnum.MessageType.STRING.toString(),"subbatchdate" ,30,0, false, "子批次日期" )))
					.addNode(new FieldNode("subbatchserno",new MsgField(ContentEnum.MessageType.STRING.toString(),"subbatchserno" ,50,0, false, "子批次流水" )))
					.addNode(new FieldNode("batchprjno",new MsgField(ContentEnum.MessageType.STRING.toString(),"batchprjno" ,1,0, false, "项目编号" )))
					.addNode(new FieldNode("batchstatus",new MsgField(ContentEnum.MessageType.STRING.toString(),"batchstatus" ,1,0, false, "批次状态" )))
					.addNode(new FieldNode("batchtype",new MsgField(ContentEnum.MessageType.STRING.toString(),"batchtype" ,8,0, false, "项目性质" )))
					.addNode(new FieldNode("idxtradedate",new MsgField(ContentEnum.MessageType.STRING.toString(),"idxtradedate" ,20,0, false, "翻页交易日期" )))
					.addNode(new FieldNode("idxserialno",new MsgField(ContentEnum.MessageType.STRING.toString(),"idxserialno" ,8,0, false, "翻页交易流水" )))
					.addNode(new FieldNode("startdate",new MsgField(ContentEnum.MessageType.STRING.toString(),"startdate" ,8,0, false, "项目性质" )))
					.addNode(new FieldNode("enddate",new MsgField(ContentEnum.MessageType.STRING.toString(),"enddate" ,32,0, false, "翻页交易日期" )))
					.addNode(new FieldNode("pageflag",new MsgField(ContentEnum.MessageType.STRING.toString(),"pageflag" ,1,0, false, "翻页标志" )))
					.addNode(new FieldNode("maxnum",new MsgField(ContentEnum.MessageType.STRING.toString(),"maxnum" ,3,0, false, "每页条数" )))
					.addNode(new FieldNode("printnm",new MsgField(ContentEnum.MessageType.STRING.toString(),"printnm" ,2,0, false, "打印标志" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1612_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("totnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totnum", 10,0, false, "总记录数" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 10,0, false, "返回记录数" )))
					.addNode(new ArrayNode("bodrcd",false)
							.addNode(new FieldNode("serialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "serialno", 20,0, false, "业务流水号" )))
							.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedate", 8,0, false, "交易日期" )))
							.addNode(new FieldNode("batchdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchdate", 8,0, false, "批次日期" )))
							.addNode(new FieldNode("batchserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchserno", 30,0, false, "批次流水" )))
							.addNode(new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno", 10,0, false, "柜员号" )))
							.addNode(new FieldNode("channelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelserno", 40,0, false, "原渠道流水" )))
							.addNode(new FieldNode("batchtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchtype", 1,0, false, "项目性质" )))
							.addNode(new FieldNode("batchprjno", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchprjno", 50,0, false, "项目编号" )))
							.addNode(new FieldNode("batchprjname", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchprjname", 512,0, false, "项目名称" )))
							.addNode(new FieldNode("glacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "glacctno", 32,0, false, "委托单位账号" )))
							.addNode(new FieldNode("glacctname", new MsgField(ContentEnum.MessageType.STRING.toString(), "glacctname", 256,0, false, "委托单位账户名称" )))
							.addNode(new FieldNode("batchcount", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchcount", 10,0, false, "请求数据总笔数" )))
							.addNode(new FieldNode("batchamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchamt", 17,0, false, "请求数据总金额" )))
							.addNode(new FieldNode("batchfilename", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchfilename", 10,0, false, "请求数据文件名称" )))
							.addNode(new FieldNode("chkcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "chkcode", 30,0, false, "校验码" )))
							.addNode(new FieldNode("batchfilenum", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchfilenum", 10,0, false, "批次文件数量" )))
							.addNode(new FieldNode("voukind", new MsgField(ContentEnum.MessageType.STRING.toString(), "voukind", 10,0, false, "付款凭证与文件数量关系" )))
							.addNode(new FieldNode("succcount", new MsgField(ContentEnum.MessageType.STRING.toString(), "succcount", 10,0, false, "导入成功批次总数量" )))
							.addNode(new FieldNode("succamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "succamt", 17,0, false, "导入成功批次总金额" )))
							.addNode(new FieldNode("failcount", new MsgField(ContentEnum.MessageType.STRING.toString(), "failcount", 10,0, false, "导入失败批次总笔数" )))
							.addNode(new FieldNode("failamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "failamt", 17,0, false, "导入失败批次总金额" )))
							.addNode(new FieldNode("smrycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "smrycd", 6,0, false, "摘要码" )))
							.addNode(new FieldNode("smrytx", new MsgField(ContentEnum.MessageType.STRING.toString(), "smrytx", 100,0, false, "摘要名称" )))
							.addNode(new FieldNode("upddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "upddate", 8,0, false, "更新日期" )))
							.addNode(new FieldNode("updtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "updtime", 6,0, false, "更新时间" )))
							.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark", 1024,0, false, "备注" )))
							.addNode(new FieldNode("subserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "subserialno", 20,0, false, "子批次流水" )))
							.addNode(new FieldNode("subtradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "subtradedate", 8,0, false, "子批次日期" )))
							.addNode(new FieldNode("filesernum", new MsgField(ContentEnum.MessageType.STRING.toString(), "filesernum", 10,0, false, "文件序号" )))
							.addNode(new FieldNode("filename", new MsgField(ContentEnum.MessageType.STRING.toString(), "filename", 256,0, false, "文件名称" )))
							.addNode(new FieldNode("subchkcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "subchkcode", 30,0, false, "文件校验码" )))
							.addNode(new FieldNode("count", new MsgField(ContentEnum.MessageType.STRING.toString(), "count", 10,0, false, "总笔数" )))
							.addNode(new FieldNode("sumamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "sumamt", 17,0, false, "总金额" )))
							.addNode(new FieldNode("batchstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchstatus", 1,0, false, "批次状态" )))
							.addNode(new FieldNode("accttp", new MsgField(ContentEnum.MessageType.STRING.toString(), "accttp", 1,0, false, "账户类型" )))
							.addNode(new FieldNode("readtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "readtp", 1,0, false, "读取方式" )))
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 32,0, false, "账号/卡号" )))
							.addNode(new FieldNode("acctname", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctname", 256,0, false, "户名" )))
							.addNode(new FieldNode("voutp", new MsgField(ContentEnum.MessageType.STRING.toString(), "voutp", 10,0, false, "付款凭证类型" )))
							.addNode(new FieldNode("vouno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vouno", 30,0, false, "付款凭证号码" )))
							.addNode(new FieldNode("billdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "billdate", 8,0, false, "出票日期" )))
							.addNode(new FieldNode("subsucccount", new MsgField(ContentEnum.MessageType.STRING.toString(), "subsucccount", 10,0, false, "成功总笔数" )))
							.addNode(new FieldNode("subsuccamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "subsuccamt", 17,0, false, "成功总金额" )))
							.addNode(new FieldNode("subfailcount", new MsgField(ContentEnum.MessageType.STRING.toString(), "subfailcount", 10,0, false, "失败总笔数" )))
							.addNode(new FieldNode("subfailamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "subfailamt", 17,0, false, "失败总金额" )))
							.addNode(new FieldNode("cancelflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "cancelflag", 1,0, false, "摊销标志" )))
							.addNode(new FieldNode("cancelchannelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cancelchannelserno", 30,0, false, "撤销渠道流水" )))
							.addNode(new FieldNode("canceldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "canceldate", 8,0, false, "撤销日期" )))
							.addNode(new FieldNode("cancelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cancelserno", 30,0, false, "撤销流水" )))
							.addNode(new FieldNode("errorcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "errorcode", 10,0, false, "错误代码" )))
							.addNode(new FieldNode("errormsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "errormsg", 512,0, false, "错误信息" )))
							.addNode(new FieldNode("subsmrytx", new MsgField(ContentEnum.MessageType.STRING.toString(), "subsmrytx", 100,0, false, "摘要信息" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

