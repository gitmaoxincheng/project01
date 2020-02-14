package cn.com.agree.huanan.ap.al.io.service.ext;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbExtChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;

/**
 * BASESVC.S013000802 东莞公积金数据查询.公积金个人账号信息查询 
 * S0130008.02 afgrxx
 * 0182 外部数据管理平台系统
 * @author XZF
 */
@Component
public class S013000802 extends EsbExtChannelService {

	private static S013000802_I i = new S013000802_I();
	private static S013000802_O o = new S013000802_O();
	public S013000802() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013000802_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("ReqDataType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReqDataType", 10,0, true, "查询类型" )))
					.addNode(new FieldNode("value", new MsgField(ContentEnum.MessageType.STRING.toString(), "value", 50,0, true, "被查询者公积金账号或身份证" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S013000802_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("reportid", new MsgField(ContentEnum.MessageType.STRING.toString(), "reportid", 50,0, false, "报告编号" )))
					.addNode(new FieldNode("HtmlFilePath", new MsgField(ContentEnum.MessageType.STRING.toString(), "HtmlFilePath", 100,0, false, "存储路径" )))
					.addNode(new FieldNode("dataQueryType", new MsgField(ContentEnum.MessageType.STRING.toString(), "dataQueryType", 100,0, false, "报文返回类型" )))
					.addNode(new ArrayNode("GJJGRXX",false)
							.addNode(new ArrayNode("data",false)
									.addNode(new FieldNode("personname", new MsgField(ContentEnum.MessageType.STRING.toString(), "personname", 40,0, false, "姓名" )))
									.addNode(new FieldNode("cardtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardtype", 10,0, false, "证件类型" )))
									.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 50,0, false, "证件号码" )))
									.addNode(new FieldNode("birthdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "birthdate", 50,0, false, "出生日期" )))
									.addNode(new FieldNode("grgjjaccountno", new MsgField(ContentEnum.MessageType.STRING.toString(), "grgjjaccountno", 50,0, false, "个人公积金账号" )))
									.addNode(new FieldNode("graccountopendate", new MsgField(ContentEnum.MessageType.STRING.toString(), "graccountopendate", 50,0, false, "个人账户开户日期" )))
									.addNode(new FieldNode("graccountbalance", new MsgField(ContentEnum.MessageType.STRING.toString(), "graccountbalance", 50,0, false, "当前个人账户余额" )))
									.addNode(new FieldNode("payofmonth", new MsgField(ContentEnum.MessageType.STRING.toString(), "payofmonth", 50,0, false, "月缴存额" )))
									.addNode(new FieldNode("personpay", new MsgField(ContentEnum.MessageType.STRING.toString(), "personpay", 50,0, false, "个人缴存额" )))
									.addNode(new FieldNode("companypay", new MsgField(ContentEnum.MessageType.STRING.toString(), "companypay", 50,0, false, "单位缴存额" )))
									.addNode(new FieldNode("personpayrate", new MsgField(ContentEnum.MessageType.STRING.toString(), "personpayrate", 50,0, false, "当前个人缴存比例" )))
									.addNode(new FieldNode("companypayrate", new MsgField(ContentEnum.MessageType.STRING.toString(), "companypayrate", 50,0, false, "当前单位缴存比例" )))
									.addNode(new FieldNode("paytodate", new MsgField(ContentEnum.MessageType.STRING.toString(), "paytodate", 50,0, false, "缴至年月" )))
									.addNode(new FieldNode("personaccountstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "personaccountstatus", 50,0, false, "个人账户状态" )))
									.addNode(new FieldNode("dataplacezoreno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dataplacezoreno", 50,0, false, "数据发生地行政区域代码" )))
									.addNode(new FieldNode("dataplacegjjunitno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dataplacegjjunitno", 50,0, false, "数据发生机构代码" )))
									.addNode(new FieldNode("paymentbase", new MsgField(ContentEnum.MessageType.STRING.toString(), "paymentbase", 50,0, false, "缴存基数" )))
									.addNode(new FieldNode("homephone", new MsgField(ContentEnum.MessageType.STRING.toString(), "homephone", 50,0, false, "家庭电话" )))
									.addNode(new FieldNode("mobilephone", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobilephone", 50,0, false, "移动电话" )))
									.addNode(new FieldNode("homeaddress", new MsgField(ContentEnum.MessageType.STRING.toString(), "homeaddress", 50,0, false, "联系地址(家庭）" )))
									.addNode(new FieldNode("companyname", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyname", 50,0, false, "现缴存单位名称" )))
									.addNode(new FieldNode("companyaccountno", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyaccountno", 50,0, false, "现缴存单位账号" )))
									.addNode(new FieldNode("companybankno", new MsgField(ContentEnum.MessageType.STRING.toString(), "companybankno", 50,0, false, "单位开户银行网点编号" )))
									.addNode(new FieldNode("companybankname", new MsgField(ContentEnum.MessageType.STRING.toString(), "companybankname", 50,0, false, "单位开户银行网点名称" )))
									.addNode(new FieldNode("companyaccountopendate", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyaccountopendate", 50,0, false, "单位开户时间" )))
									.addNode(new FieldNode("companyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyno", 50,0, false, "单位组织机构代码号" )))
									.addNode(new FieldNode("companytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "companytype", 50,0, false, "经济类型" )))
									.addNode(new FieldNode("companyproperty", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyproperty", 50,0, false, "单位性质" )))
									.addNode(new FieldNode("companyaddress", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyaddress", 300,0, false, "单位地址" )))
									.addNode(new FieldNode("companyaccountstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyaccountstatus", 50,0, false, "单位账户状态" )))
									.addNode(new FieldNode("companylegalperson", new MsgField(ContentEnum.MessageType.STRING.toString(), "companylegalperson", 50,0, false, "法人代表" )))
									.addNode(new FieldNode("companyphone", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyphone", 50,0, false, "单位联系电话" )))
									.addNode(new FieldNode("paydate", new MsgField(ContentEnum.MessageType.STRING.toString(), "paydate", 50,0, false, "发薪日期" )))
									.addNode(new FieldNode("whetherdeferment", new MsgField(ContentEnum.MessageType.STRING.toString(), "whetherdeferment", 50,0, false, "单位是否申请缓缴" )))
									.addNode(new FieldNode("defermentdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "defermentdate", 50,0, false, "最近申请缓缴时间" )))
									.addNode(new FieldNode("defermentreason", new MsgField(ContentEnum.MessageType.STRING.toString(), "defermentreason", 200,0, false, "申请缓缴原因" )))
									.addNode(new FieldNode("nowfirstbizdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "nowfirstbizdate", 50,0, false, "现所在缴存单位个人首次缴存日期" )))
									.addNode(new FieldNode("befornomalbiznum", new MsgField(ContentEnum.MessageType.STRING.toString(), "befornomalbiznum", 50,0, false, "历年汇缴次数" )))
									.addNode(new FieldNode("beforrepbiznum", new MsgField(ContentEnum.MessageType.STRING.toString(), "beforrepbiznum", 50,0, false, "历年补缴次数" )))
									.addNode(new FieldNode("beforwdlnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "beforwdlnum", 50,0, false, "历年支取次数" )))
									.addNode(new FieldNode("nownomalbiznum", new MsgField(ContentEnum.MessageType.STRING.toString(), "nownomalbiznum", 50,0, false, "本年汇缴次数" )))
									.addNode(new FieldNode("nowrepbiznum", new MsgField(ContentEnum.MessageType.STRING.toString(), "nowrepbiznum", 50,0, false, "本年补缴次数" )))
									.addNode(new FieldNode("nowwdlnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "nowwdlnum", 50,0, false, "本年支取次数" )))
									.addNode(new FieldNode("lastwdlnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "lastwdlnum", 50,0, false, "最后支取日期" )))
									.addNode(new FieldNode("errorinfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "errorinfo", 200,0, false, "错误信息" )))
									)));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

