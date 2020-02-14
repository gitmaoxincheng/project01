package cn.com.agree.huanan.ap.al.io.service.enc;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.C013000801 客户综合信息查询.个人客户综合信息查询 
 * C0130008.01 ECIF510
 * 0337 企业级客户信息管理系统
 * @author JZF
 */
@Component
public class C013000801 extends EsbChannelService {
	/*

INSERT INTO CSIS_ATOMIC_SERVICE 
(AT_SVCID, AT_SVCCODE, AT_SVCNAME, AT_SCNCODE, AT_SCNNAME, SYS_CODE, SYS_NAME, SYS_SVCCODE, SYS_SVCNAME, SYS_SCNCODE,EXT_CODE ,SYS_SCNNAME, IS_ECTIP, STATUS, REMARK) VALUES 
('BASESVCC013000801', 'BASESVC', '企业级客户信息管理系统', 'C013000801', '客户综合信息查询', 'ESB', 'ESB_enc系统', 'C0130008', '个人客户综合信息查询', '01','ECIF510' ,'客户综合信息查询', '1', '0', '客户综合信息查询');

	 */
	private static C013000801_I i = new C013000801_I();
	private static C013000801_O o = new C013000801_O();

	public C013000801() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013000801_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, true, "客户号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class C013000801_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new StructNode("custinfo",false)
							.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, false, "客户编号" )))
							.addNode(new FieldNode("age", new MsgField(ContentEnum.MessageType.STRING.toString(), "age", 20,0, false, "年龄" )))
							.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 256,0, false, "客户名称" )))
							.addNode(new FieldNode("custlevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "custlevel", 2,0, false, "客户等级" )))
							.addNode(new FieldNode("marriage", new MsgField(ContentEnum.MessageType.STRING.toString(), "marriage", 2,0, false, "婚姻状态" )))
							.addNode(new FieldNode("birthday", new MsgField(ContentEnum.MessageType.STRING.toString(), "birthday", 8,0, false, "出生日期" )))
							.addNode(new FieldNode("careertype", new MsgField(ContentEnum.MessageType.STRING.toString(), "careertype", 10,0, false, "职业" )))
							.addNode(new FieldNode("citizenship", new MsgField(ContentEnum.MessageType.STRING.toString(), "citizenship", 3,0, false, "国籍" )))
							.addNode(new FieldNode("hukouplace", new MsgField(ContentEnum.MessageType.STRING.toString(), "hukouplace", 256,0, false, "户口所在地" )))
							.addNode(new FieldNode("openbranch", new MsgField(ContentEnum.MessageType.STRING.toString(), "openbranch", 12,0, false, "开户机构" )))
							.addNode(new FieldNode("openbranchname", new MsgField(ContentEnum.MessageType.STRING.toString(), "openbranchname", 256,0, false, "开户机构名称" )))
							.addNode(new FieldNode("mainmgr", new MsgField(ContentEnum.MessageType.STRING.toString(), "mainmgr", 20,0, false, "主办客户经理" )))
							.addNode(new FieldNode("mainmgrname", new MsgField(ContentEnum.MessageType.STRING.toString(), "mainmgrname", 256,0, false, "主办客户经理名称" )))
							.addNode(new FieldNode("mainorg", new MsgField(ContentEnum.MessageType.STRING.toString(), "mainorg", 12,0, false, "主办机构" )))
							.addNode(new FieldNode("mainorgname", new MsgField(ContentEnum.MessageType.STRING.toString(), "mainorgname", 256,0, false, "主办机构名称" )))
							.addNode(new FieldNode("pfrisklevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "pfrisklevel", 20,0, false, "理财风险等级" )))
							.addNode(new FieldNode("haseccard", new MsgField(ContentEnum.MessageType.STRING.toString(), "haseccard", 1,0, false, "是否持有银联贷记卡" )))
							.addNode(new FieldNode("hasvisacard", new MsgField(ContentEnum.MessageType.STRING.toString(), "hasvisacard", 1,0, false, "是否持有VISA贷记卡" )))
							.addNode(new FieldNode("ispfcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "ispfcust", 1,0, false, "是否理财客户" )))
							.addNode(new FieldNode("isfdcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isfdcust", 1,0, false, "是否基金客户" )))
							.addNode(new FieldNode("isbigdp", new MsgField(ContentEnum.MessageType.STRING.toString(), "isbigdp", 1,0, false, "大额存单" )))
							.addNode(new FieldNode("isdaydp", new MsgField(ContentEnum.MessageType.STRING.toString(), "isdaydp", 1,0, false, "是否日日盈客户" )))
							.addNode(new FieldNode("ismondp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ismondp", 1,0, false, "是否月月盈客户" )))
							.addNode(new FieldNode("isebankcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isebankcust", 1,0, false, "是否网银客户" )))
							.addNode(new FieldNode("ismobilecust", new MsgField(ContentEnum.MessageType.STRING.toString(), "ismobilecust", 1,0, false, "是否手机银行客户" )))
							.addNode(new FieldNode("isyxtcust", new MsgField(ContentEnum.MessageType.STRING.toString(), "isyxtcust", 1,0, false, "是否银信通客户" )))
							.addNode(new FieldNode("isdpdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "isdpdh", 1,0, false, "定活莞家" )))
							).addNode(new ArrayNode("dlauminfo_list",false)
									.addNode(new FieldNode("prodid", new MsgField(ContentEnum.MessageType.STRING.toString(), "prodid", 20,0, false, "产品编号" )))
									.addNode(new FieldNode("prodname", new MsgField(ContentEnum.MessageType.STRING.toString(), "prodname", 200,0, false, "产品名称" )))
									.addNode(new FieldNode("tranamt", new MsgField(ContentEnum.MessageType.INT.toString(), "tranamt", 18,2, false, "交易金额" )))
									.addNode(new FieldNode("trandate", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandate", 8,0, false, "交易日期" )))
									.addNode(new FieldNode("term", new MsgField(ContentEnum.MessageType.STRING.toString(), "term", 10,0, false, "期限" )))
									).addNode(new ArrayNode("dldebinfo_list",false)
											.addNode(new FieldNode("prodid", new MsgField(ContentEnum.MessageType.STRING.toString(), "prodid", 20,0, false, "产品编号" )))
											.addNode(new FieldNode("prodname", new MsgField(ContentEnum.MessageType.STRING.toString(), "prodname", 200,0, false, "产品名称" )))
											.addNode(new FieldNode("tranamt", new MsgField(ContentEnum.MessageType.INT.toString(), "tranamt", 18,2, false, "交易金额" )))
											.addNode(new FieldNode("trandate", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandate", 8,0, false, "交易日期" )))
											.addNode(new FieldNode("term", new MsgField(ContentEnum.MessageType.STRING.toString(), "term", 10,0, false, "期限" )))
											).addNode(new ArrayNode("marketinfo_list",false)
													.addNode(new FieldNode("prodtypeid", new MsgField(ContentEnum.MessageType.STRING.toString(), "prodtypeid", 20,0, false, "产品类别编号" )))
													).addNode(new StructNode("balinfo",false)
															.addNode(new FieldNode("debbal", new MsgField(ContentEnum.MessageType.INT.toString(), "debbal", 18,2, false, "资产余额" )))
															.addNode(new FieldNode("assbal", new MsgField(ContentEnum.MessageType.INT.toString(), "assbal", 18,2, false, "负债" )))
															.addNode(new FieldNode("netassbal", new MsgField(ContentEnum.MessageType.INT.toString(), "netassbal", 18,2, false, "净资产余额" )))
															.addNode(new FieldNode("depbal", new MsgField(ContentEnum.MessageType.INT.toString(), "depbal", 18,2, false, "存款余额" )))
															.addNode(new FieldNode("currdepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "currdepbal", 18,2, false, "活期存款余额" )))
															.addNode(new FieldNode("currassdepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "currassdepbal", 18,2, false, "活期保证金存款余额" )))
															.addNode(new FieldNode("fixeddepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "fixeddepbal", 18,2, false, "定期存款余额" )))
															.addNode(new FieldNode("fixedassdepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "fixedassdepbal", 18,2, false, "定期保证金存款余额" )))
															.addNode(new FieldNode("noticedepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "noticedepbal", 18,2, false, "通知存款余额" )))
															.addNode(new FieldNode("intldepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "intldepbal", 18,2, false, "智能存款余额" )))
															.addNode(new FieldNode("cdsdepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "cdsdepbal", 18,2, false, "大额存单余额" )))
															.addNode(new FieldNode("depagreebal", new MsgField(ContentEnum.MessageType.INT.toString(), "depagreebal", 18,2, false, "协议存款余额" )))
															.addNode(new FieldNode("agreedepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "agreedepbal", 18,2, false, "协定存款余额" )))
															.addNode(new FieldNode("tpdepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "tpdepbal", 18,2, false, "第三方存款余额" )))
															.addNode(new FieldNode("crtdepbal", new MsgField(ContentEnum.MessageType.INT.toString(), "crtdepbal", 18,2, false, "信用卡存款余额" )))
															.addNode(new FieldNode("finbal", new MsgField(ContentEnum.MessageType.INT.toString(), "finbal", 18,2, false, "理财余额" )))
															.addNode(new FieldNode("fundbal", new MsgField(ContentEnum.MessageType.INT.toString(), "fundbal", 18,2, false, "基金余额" )))
															.addNode(new FieldNode("nmloanbal", new MsgField(ContentEnum.MessageType.INT.toString(), "nmloanbal", 18,2, false, "普通贷款余额" )))
															.addNode(new FieldNode("dcloanbal", new MsgField(ContentEnum.MessageType.INT.toString(), "dcloanbal", 18,2, false, "贴现余额" )))
															.addNode(new FieldNode("baloanbal", new MsgField(ContentEnum.MessageType.INT.toString(), "baloanbal", 18,2, false, "承兑余额" )))
															.addNode(new FieldNode("glloanbal", new MsgField(ContentEnum.MessageType.INT.toString(), "glloanbal", 18,2, false, "保函余额" )))
															.addNode(new FieldNode("lcloanbal", new MsgField(ContentEnum.MessageType.INT.toString(), "lcloanbal", 18,2, false, "信用证余额" )))
															.addNode(new FieldNode("crtloanbal", new MsgField(ContentEnum.MessageType.INT.toString(), "crtloanbal", 18,2, false, "信用卡贷款余额" )))
															));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
