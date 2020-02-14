package cn.com.agree.huanan.ap.al.io.service.eci.nib;

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
 * BASESVC BODNIB0135  缴费信息查询 
 *  BODNIB0135 regflw
 *  新个人网银
 * @author XZF
 */
@Component
public class BODNIB0135 extends EciChannelService {

	private static BODNIB0135_I i = new BODNIB0135_I();
	private static BODNIB0135_O o = new BODNIB0135_O();
	public BODNIB0135() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNIB0135_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("page", new MsgField(ContentEnum.MessageType.STRING.toString(), "page", 1024,0, true, "当前页数" )))
					.addNode(new FieldNode("sizes", new MsgField(ContentEnum.MessageType.STRING.toString(), "sizes", 1024,0, true, "每页记录数" )))
					.addNode(new FieldNode("stunumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "stunumber", 1024,0, true, "学生学号" )))
					.addNode(new FieldNode("merid", new MsgField(ContentEnum.MessageType.STRING.toString(), "merid", 1024,0, true, "学校id" )))
					.addNode(new FieldNode("checktype", new MsgField(ContentEnum.MessageType.STRING.toString(), "checktype", 1024,0, true, "是否检查缴费截止/开始日期" )))
					.addNode(new FieldNode("billstate", new MsgField(ContentEnum.MessageType.STRING.toString(), "billstate", 1024,0, true, "缴费状态" )))
					.addNode(new FieldNode("billruletype", new MsgField(ContentEnum.MessageType.STRING.toString(), "billruletype", 1024,0, true, "缴费档次类型" )))
					.addNode(new FieldNode("billingitemid", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingitemid", 1024,0, true, "项目id" )))
					.addNode(new FieldNode("billtypeid", new MsgField(ContentEnum.MessageType.STRING.toString(), "billtypeid", 1024,0, true, "费用id" )))
					.addNode(new FieldNode("stuclass", new MsgField(ContentEnum.MessageType.STRING.toString(), "stuclass", 1024,0, true, "班级" )))
					.addNode(new FieldNode("stugrade", new MsgField(ContentEnum.MessageType.STRING.toString(), "stugrade", 1024,0, true, "年级" )))
					.addNode(new FieldNode("billeddatestart", new MsgField(ContentEnum.MessageType.STRING.toString(), "billeddatestart", 1024,0, true, "交易开始日期" )))
					.addNode(new FieldNode("billeddateend", new MsgField(ContentEnum.MessageType.STRING.toString(), "billeddateend", 1024,0, true, "交易结束日期" )))
					.addNode(new FieldNode("stuname", new MsgField(ContentEnum.MessageType.STRING.toString(), "stuname", 1024,0, true, "学生姓名" )))
					.addNode(new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno", 1024,0, true, "原操作柜员号" )))
					.addNode(new FieldNode("hostflowno", new MsgField(ContentEnum.MessageType.STRING.toString(), "hostflowno", 1024,0, true, "原前置流水号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODNIB0135_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("cichannelserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cichannelserialno", 1024,0, false, "渠道流水号" )))
					.addNode(new FieldNode("returnmessage", new MsgField(ContentEnum.MessageType.STRING.toString(), "returnmessage", 1024,0, false, "响应消息" )))
					.addNode(new FieldNode("returncode", new MsgField(ContentEnum.MessageType.STRING.toString(), "returncode", 1024,0, false, "响应码" )))
					.addNode(new FieldNode("totalelements", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalelements", 1024,0, false, "总条数" )))
					.addNode(new FieldNode("sizes", new MsgField(ContentEnum.MessageType.STRING.toString(), "sizes", 1024,0, false, "每页记录数" )))
					.addNode(new FieldNode("number", new MsgField(ContentEnum.MessageType.STRING.toString(), "number", 1024,0, false, "当前页数" )))
					.addNode(new FieldNode("totalpages", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalpages", 1024,0, false, "总页数" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 1024,0, false, "当前页记录数" )))
					.addNode(new FieldNode("firstpage", new MsgField(ContentEnum.MessageType.STRING.toString(), "firstpage", 1024,0, false, "是否返回第一页" )))
					.addNode(new FieldNode("lastpage", new MsgField(ContentEnum.MessageType.STRING.toString(), "lastpage", 1024,0, false, "是否返回最后一页" )))
					.addNode(new ArrayNode("bodrcd",false)
							.addNode(new FieldNode("mername", new MsgField(ContentEnum.MessageType.STRING.toString(), "mername", 1024,0, true, "学校名称" )))
							.addNode(new FieldNode("merid", new MsgField(ContentEnum.MessageType.STRING.toString(), "merid", 1024,0, true, "学校id" )))
							.addNode(new FieldNode("stunumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "stunumber", 1024,0, true, "学校学号" )))
							.addNode(new FieldNode("stuname", new MsgField(ContentEnum.MessageType.STRING.toString(), "stuname", 1024,0, true, "学生姓名" )))
							.addNode(new FieldNode("stuclass", new MsgField(ContentEnum.MessageType.STRING.toString(), "stuclass", 1024,0, true, "班级" )))
							.addNode(new FieldNode("stugrade", new MsgField(ContentEnum.MessageType.STRING.toString(), "stugrade", 1024,0, true, "年级" )))
							.addNode(new FieldNode("mobileno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobileno", 1024,0, true, "手机号" )))
							.addNode(new FieldNode("bilingitemname", new MsgField(ContentEnum.MessageType.STRING.toString(), "bilingitemname", 1024,0, true, "项目名称" )))
							.addNode(new FieldNode("bilingitemid", new MsgField(ContentEnum.MessageType.STRING.toString(), "bilingitemid", 1024,0, true, "项目id" )))
							.addNode(new FieldNode("billingtypename", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingtypename", 1024,0, true, "费用名称" )))
							.addNode(new FieldNode("billingtypeid", new MsgField(ContentEnum.MessageType.STRING.toString(), "billingtypeid", 1024,0, true, "费用id" )))
							.addNode(new FieldNode("ruleamount", new MsgField(ContentEnum.MessageType.STRING.toString(), "ruleamount", 1024,0, true, "缴费金额" )))
							.addNode(new FieldNode("billruletype", new MsgField(ContentEnum.MessageType.STRING.toString(), "billruletype", 1024,0, true, "缴费档次类型" )))
							.addNode(new FieldNode("enddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "enddate", 1024,0, true, "缴费截止日期" )))
							.addNode(new FieldNode("startdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "startdate", 1024,0, true, "缴费开始日期" )))
							.addNode(new FieldNode("flowno", new MsgField(ContentEnum.MessageType.STRING.toString(), "flowno", 1024,0, true, "缴费批次" )))
							.addNode(new FieldNode("batchno", new MsgField(ContentEnum.MessageType.STRING.toString(), "batchno", 1024,0, true, "批次号" )))
							.addNode(new FieldNode("billstate", new MsgField(ContentEnum.MessageType.STRING.toString(), "billstate", 1024,0, true, "缴费状态" )))
							.addNode(new FieldNode("payaccountno", new MsgField(ContentEnum.MessageType.STRING.toString(), "payaccountno", 1024,0, true, "付款方账号" )))
							.addNode(new FieldNode("payaccountname", new MsgField(ContentEnum.MessageType.STRING.toString(), "payaccountname", 1024,0, true, "付款人姓名" )))
							.addNode(new FieldNode("payaccountnode", new MsgField(ContentEnum.MessageType.STRING.toString(), "payaccountnode", 1024,0, true, "付款方账号网点" )))
							.addNode(new FieldNode("recaccno", new MsgField(ContentEnum.MessageType.STRING.toString(), "recaccno", 1024,0, true, "收款方账号" )))
							.addNode(new FieldNode("recaccname", new MsgField(ContentEnum.MessageType.STRING.toString(), "recaccname", 1024,0, true, "收款人姓名" )))
							.addNode(new FieldNode("recmobileno", new MsgField(ContentEnum.MessageType.STRING.toString(), "recmobileno", 1024,0, true, "收款人手机号" )))
							.addNode(new FieldNode("recbankno", new MsgField(ContentEnum.MessageType.STRING.toString(), "recbankno", 1024,0, true, "收款方联行号/行内账号网点" )))
							.addNode(new FieldNode("recbankname", new MsgField(ContentEnum.MessageType.STRING.toString(), "recbankname", 1024,0, true, "收款方开户网点名称" )))
							.addNode(new FieldNode("errorcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "errorcode", 1024,0, true, "主机返回码" )))
							.addNode(new FieldNode("errormessage", new MsgField(ContentEnum.MessageType.STRING.toString(), "errormessage", 1024,0, true, "主机返回错误信息" )))
							.addNode(new FieldNode("hostflowno", new MsgField(ContentEnum.MessageType.STRING.toString(), "hostflowno", 1024,0, true, "主机交易流水号" )))
							.addNode(new FieldNode("ifphosttime", new MsgField(ContentEnum.MessageType.STRING.toString(), "ifphosttime", 1024,0, true, "缴费时间" )))
							.addNode(new FieldNode("billchannel", new MsgField(ContentEnum.MessageType.STRING.toString(), "billchannel", 1024,0, true, "缴费渠道" )))
							.addNode(new FieldNode("rulecount", new MsgField(ContentEnum.MessageType.STRING.toString(), "rulecount", 1024,0, true, "规则数" )))
							.addNode(new FieldNode("billuser", new MsgField(ContentEnum.MessageType.STRING.toString(), "billuser", 1024,0, true, "原操作柜员编号" )))
							.addNode(new FieldNode("sverserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "sverserialno", 1024,0, true, "核心流水号" )))
							.addNode(new ArrayNode("rulelist",true)
									.addNode(new FieldNode("rulename", new MsgField(ContentEnum.MessageType.STRING.toString(), "rulename", 1024,0, true, "规则名称" )))
									.addNode(new FieldNode("ruleamount", new MsgField(ContentEnum.MessageType.STRING.toString(), "ruleamount", 1024,0, true, "规则金额" )))
									)));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

