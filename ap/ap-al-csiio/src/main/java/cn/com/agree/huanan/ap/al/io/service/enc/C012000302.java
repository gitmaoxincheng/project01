package cn.com.agree.huanan.ap.al.io.service.enc;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.C012000302 客户号开立.对公客户客户号开立 
 * C0120003.02 ECIF004
 * 0337 企业级客户信息管理系统
 * @author XZF
 */
@Component
public class C012000302 extends EsbChannelService {

	private static C012000302_I i = new C012000302_I();
	private static C012000302_O o = new C012000302_O();
	public C012000302() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C012000302_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("custinfo",false)
							.addNode(new FieldNode("openacctflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "openacctflag", 1,0, true, "是否开账户标志" )))
							.addNode(new FieldNode("custtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype", 1,0, true, "客户类型" )))
							.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 256,0, false, "客户名称" )))
							.addNode(new FieldNode("enname", new MsgField(ContentEnum.MessageType.STRING.toString(), "enname", 120,0, false, "客户英文名称" )))
							.addNode(new FieldNode("identtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "identtype", 3,0, true, "证件类型" )))
							.addNode(new FieldNode("identno", new MsgField(ContentEnum.MessageType.STRING.toString(), "identno", 30,0, true, "证件号码" )))
							.addNode(new FieldNode("certarea", new MsgField(ContentEnum.MessageType.STRING.toString(), "certarea", 3,0, false, "发证国家或地区" )))
							.addNode(new FieldNode("identorgaddid", new MsgField(ContentEnum.MessageType.STRING.toString(), "identorgaddid", 6,0, false, "发证机关地区代码" )))
							.addNode(new FieldNode("identeffectivedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "identeffectivedate", 8,0, false, "证件生效日期" )))
							.addNode(new FieldNode("identexpireddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "identexpireddate", 8,0, false, "证件失效日期" )))
							.addNode(new FieldNode("identcustno", new MsgField(ContentEnum.MessageType.STRING.toString(), "identcustno", 20,0, false, "识别号(客户推荐人)" )))
							.addNode(new FieldNode("ennameonly", new MsgField(ContentEnum.MessageType.STRING.toString(), "ennameonly", 1,0, false, "是否仅有英文名称" )))
							.addNode(new FieldNode("countryorregion", new MsgField(ContentEnum.MessageType.STRING.toString(), "countryorregion", 3,0, false, "国籍或地区" )))
							).addNode(new ArrayNode("copinfo",false)
									.addNode(new FieldNode("inoutflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "inoutflag", 1,0, true, "境内外标识" )))
									.addNode(new FieldNode("outsideorgtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "outsideorgtype", 1,0, false, "境外机构类别" )))
									.addNode(new FieldNode("finaorgtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "finaorgtype", 2,0, false, "金融机构分类标准" )))
									.addNode(new FieldNode("industry", new MsgField(ContentEnum.MessageType.STRING.toString(), "industry", 5,0, true, "行业分类" )))
									.addNode(new FieldNode("organtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "organtype", 10,0, false, "组织机构类型" )))
									.addNode(new FieldNode("basicopenno", new MsgField(ContentEnum.MessageType.STRING.toString(), "basicopenno", 14,0, false, "基本户开户核准号" )))
									.addNode(new FieldNode("basicaccseq", new MsgField(ContentEnum.MessageType.STRING.toString(), "basicaccseq", 20,0, false, "基本账户编号" )))
									.addNode(new FieldNode("basicacctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "basicacctno", 40,0, false, "基本户账号" )))
									.addNode(new FieldNode("basicbankcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "basicbankcode", 12,0, false, "基本户开户银行代码" )))
									.addNode(new FieldNode("basicbankname", new MsgField(ContentEnum.MessageType.STRING.toString(), "basicbankname", 256,0, false, "基本户开户银行名称" )))
									.addNode(new FieldNode("basicbankdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "basicbankdate", 8,0, false, "基本户开户日期" )))
									.addNode(new FieldNode("orgcreditno", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgcreditno", 20,0, false, "机构信用代码证号" )))
									.addNode(new FieldNode("orgcreditdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgcreditdate", 8,0, false, "机构信用代码证有效期" )))
									.addNode(new FieldNode("enterscale", new MsgField(ContentEnum.MessageType.STRING.toString(), "enterscale", 2,0, false, "企业规模（企业规模代码）" )))
									.addNode(new FieldNode("enterscalecapital", new MsgField(ContentEnum.MessageType.STRING.toString(), "enterscalecapital", 2,0, false, "企业规模（按注册资本）" )))
									.addNode(new FieldNode("localtaxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "localtaxno", 20,0, false, "地税登记号" )))
									.addNode(new FieldNode("nationtaxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "nationtaxno", 20,0, false, "国税登记号" )))
									.addNode(new FieldNode("buslicscope", new MsgField(ContentEnum.MessageType.STRING.toString(), "buslicscope", 200,0, false, "营业执照经营范围" )))
									.addNode(new FieldNode("ownerform", new MsgField(ContentEnum.MessageType.STRING.toString(), "ownerform", 20,0, false, "所有制形式" )))
									.addNode(new FieldNode("frorgregcert", new MsgField(ContentEnum.MessageType.STRING.toString(), "frorgregcert", 50,0, false, "境外公司注册证书代码" )))
									.addNode(new FieldNode("frorgregcertexpdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "frorgregcertexpdate", 8,0, false, "境外公司注册证书有效期" )))
									.addNode(new FieldNode("ieflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ieflag", 1,0, false, "进出口权标志" )))
									.addNode(new FieldNode("custflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "custflag", 2,0, false, "所属客群标识" )))
									.addNode(new FieldNode("deptflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "deptflag", 3,0, false, "存款人类别" )))
									.addNode(new FieldNode("notprove", new MsgField(ContentEnum.MessageType.STRING.toString(), "notprove", 200,0, false, "无需办理税务登记证明的文件或税务机关出具的证明" )))
									.addNode(new FieldNode("registercny", new MsgField(ContentEnum.MessageType.STRING.toString(), "registercny", 3,0, false, "注册币种" )))
									.addNode(new FieldNode("registeramount", new MsgField(ContentEnum.MessageType.INT.toString(), "registeramount", 18,2, false, "注册金额" )))
									.addNode(new FieldNode("registerregioncode", new MsgField(ContentEnum.MessageType.STRING.toString(), "registerregioncode", 50,0, false, "注册地区代码" )))
									.addNode(new FieldNode("regdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "regdate", 8,0, false, "注册日期" )))
									.addNode(new FieldNode("regaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "regaddr", 300,0, false, "注册地址" )))
									.addNode(new FieldNode("regaddrnation", new MsgField(ContentEnum.MessageType.STRING.toString(), "regaddrnation", 3,0, false, "注册地址-国家" )))
									.addNode(new FieldNode("regaddrprovince", new MsgField(ContentEnum.MessageType.STRING.toString(), "regaddrprovince", 6,0, false, "注册地址-省" )))
									.addNode(new FieldNode("regaddrcity", new MsgField(ContentEnum.MessageType.STRING.toString(), "regaddrcity", 6,0, false, "注册地址-市" )))
									.addNode(new FieldNode("regaddrzone", new MsgField(ContentEnum.MessageType.STRING.toString(), "regaddrzone", 6,0, false, "注册地址-区" )))
									.addNode(new FieldNode("regaddrdetail", new MsgField(ContentEnum.MessageType.STRING.toString(), "regaddrdetail", 300,0, false, "注册地址-详细地址" )))
									.addNode(new FieldNode("regzipcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "regzipcode", 10,0, false, "注册地址邮编" )))
									.addNode(new FieldNode("entsetdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "entsetdate", 8,0, false, "企业成立日期" )))
									.addNode(new FieldNode("listedplace", new MsgField(ContentEnum.MessageType.STRING.toString(), "listedplace", 2,0, false, "上市地点" )))
									.addNode(new FieldNode("stockcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "stockcode", 60,0, false, "股票代码" )))
									.addNode(new FieldNode("orgregisterdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgregisterdate", 8,0, false, "组织机构登记日期" )))
									.addNode(new FieldNode("unittle", new MsgField(ContentEnum.MessageType.STRING.toString(), "unittle", 20,0, false, "单位电话" )))
									.addNode(new FieldNode("unitaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitaddr", 300,0, false, "单位地址" )))
									.addNode(new FieldNode("unitaddrnation", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitaddrnation", 3,0, false, "单位地址-国家" )))
									.addNode(new FieldNode("unitaddrprovince", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitaddrprovince", 6,0, false, "单位地址-省" )))
									.addNode(new FieldNode("unitaddrcity", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitaddrcity", 6,0, false, "单位地址-市" )))
									.addNode(new FieldNode("unitaddrzone", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitaddrzone", 6,0, false, "单位地址-区" )))
									.addNode(new FieldNode("unitaddrdetail", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitaddrdetail", 300,0, false, "单位地址-详细地址" )))
									.addNode(new FieldNode("unitzipcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitzipcode", 10,0, false, "单位地址邮编" )))
									.addNode(new FieldNode("billaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "billaddr", 300,0, false, "账单地址" )))
									.addNode(new FieldNode("billaddrnation", new MsgField(ContentEnum.MessageType.STRING.toString(), "billaddrnation", 3,0, false, "账单地址-国家" )))
									.addNode(new FieldNode("billaddrprovince", new MsgField(ContentEnum.MessageType.STRING.toString(), "billaddrprovince", 6,0, false, "账单地址-省" )))
									.addNode(new FieldNode("billaddrcity", new MsgField(ContentEnum.MessageType.STRING.toString(), "billaddrcity", 6,0, false, "账单地址-市" )))
									.addNode(new FieldNode("billaddrzone", new MsgField(ContentEnum.MessageType.STRING.toString(), "billaddrzone", 6,0, false, "账单地址-区" )))
									.addNode(new FieldNode("billaddrdetail", new MsgField(ContentEnum.MessageType.STRING.toString(), "billaddrdetail", 300,0, false, "账单地址-详细地址" )))
									.addNode(new FieldNode("billzipcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "billzipcode", 10,0, false, "账单地址邮编" )))
									.addNode(new FieldNode("contact", new MsgField(ContentEnum.MessageType.STRING.toString(), "contact", 256,0, false, "联系人" )))
									.addNode(new FieldNode("unitfex", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitfex", 20,0, false, "传真" )))
									.addNode(new FieldNode("email", new MsgField(ContentEnum.MessageType.STRING.toString(), "email", 100,0, false, "电子邮件" )))
									.addNode(new FieldNode("finapers", new MsgField(ContentEnum.MessageType.STRING.toString(), "finapers", 256,0, false, "财务负责人" )))
									.addNode(new FieldNode("finapersmobnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "finapersmobnum", 20,0, false, "财务负责人手机号码" )))
									.addNode(new FieldNode("finaidenttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "finaidenttype", 3,0, false, "财务负责人证件类型" )))
									.addNode(new FieldNode("finaidentno", new MsgField(ContentEnum.MessageType.STRING.toString(), "finaidentno", 30,0, false, "财务负责人证件号码" )))
									.addNode(new FieldNode("finaidentdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "finaidentdate", 8,0, false, "财务负责人证件有效期" )))
									.addNode(new FieldNode("direunitname", new MsgField(ContentEnum.MessageType.STRING.toString(), "direunitname", 256,0, false, "主管单位名称" )))
									.addNode(new FieldNode("direunitcny", new MsgField(ContentEnum.MessageType.STRING.toString(), "direunitcny", 3,0, false, "主管单位注册币种" )))
									.addNode(new FieldNode("direunitamount", new MsgField(ContentEnum.MessageType.INT.toString(), "direunitamount", 18,2, false, "主管单位注册金额" )))
									.addNode(new FieldNode("direunitrepre", new MsgField(ContentEnum.MessageType.STRING.toString(), "direunitrepre", 256,0, false, "主管单位法定代表人" )))
									.addNode(new FieldNode("direrepreidenttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "direrepreidenttype", 3,0, false, "主管单位法定代表人证件类别" )))
									.addNode(new FieldNode("direrepreidentno", new MsgField(ContentEnum.MessageType.STRING.toString(), "direrepreidentno", 30,0, false, "主管单位法定代表人证件号" )))
									.addNode(new FieldNode("direunitopenno", new MsgField(ContentEnum.MessageType.STRING.toString(), "direunitopenno", 20,0, false, "主管单位基本户开户许可证号" )))
									.addNode(new FieldNode("direbasicaccseq", new MsgField(ContentEnum.MessageType.STRING.toString(), "direbasicaccseq", 20,0, false, "主管单位基本账户编号" )))
									.addNode(new FieldNode("direunitid", new MsgField(ContentEnum.MessageType.STRING.toString(), "direunitid", 20,0, false, "主管单位组织机构代码" )))
									.addNode(new FieldNode("selfclaim", new MsgField(ContentEnum.MessageType.STRING.toString(), "selfclaim", 1,0, false, "税收居民身份" )))
									.addNode(new FieldNode("orgtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgtype", 1,0, false, "机构类别" )))
									.addNode(new FieldNode("orgenaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgenaddr", 120,0, false, "单位地址（英文或拼音）" )))
									.addNode(new FieldNode("orgenaddrna", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgenaddrna", 3,0, false, "单位地址-国家（英文或拼音）" )))
									.addNode(new FieldNode("orgenaddrpr", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgenaddrpr", 6,0, false, "单位地址-省（英文或拼音）" )))
									.addNode(new FieldNode("orgenaddrct", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgenaddrct", 6,0, false, "单位地址-市（英文或拼音）" )))
									.addNode(new FieldNode("orgenaddrzn", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgenaddrzn", 6,0, false, "单位地址-区（英文或拼音）" )))
									.addNode(new FieldNode("orgenaddrdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgenaddrdt", 120,0, false, "单位地址-详细地址（英文或拼音）" )))
									.addNode(new FieldNode("taxnation", new MsgField(ContentEnum.MessageType.STRING.toString(), "taxnation", 200,0, false, "税收居民国（地区）" )))
									.addNode(new FieldNode("taxpayerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "taxpayerno", 20,0, false, "居民国（地区)纳税人识别号" )))
									.addNode(new FieldNode("notaxpayerreason", new MsgField(ContentEnum.MessageType.STRING.toString(), "notaxpayerreason", 1,0, false, "无纳税人识别号原因" )))
									.addNode(new FieldNode("specificcause", new MsgField(ContentEnum.MessageType.STRING.toString(), "specificcause", 200,0, false, "具体原因" )))
									).addNode(new ArrayNode("legalinfo",false)
											.addNode(new FieldNode("legalname", new MsgField(ContentEnum.MessageType.STRING.toString(), "legalname", 256,0, false, "法定代表人客户名称" )))
											.addNode(new FieldNode("identtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "identtype", 3,0, false, "法定代表人证件类型" )))
											.addNode(new FieldNode("identno", new MsgField(ContentEnum.MessageType.STRING.toString(), "identno", 30,0, false, "法定代表人证件号码" )))
											.addNode(new FieldNode("certarea", new MsgField(ContentEnum.MessageType.STRING.toString(), "certarea", 3,0, false, "法定代表人发证国家或地区" )))
											.addNode(new FieldNode("countryorregion", new MsgField(ContentEnum.MessageType.STRING.toString(), "countryorregion", 3,0, false, "法定代表人国籍或地区" )))
											.addNode(new FieldNode("identexpiredate", new MsgField(ContentEnum.MessageType.STRING.toString(), "identexpiredate", 8,0, false, "法定代表人证件到期日(有效期）" )))
											.addNode(new FieldNode("mobilenum", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobilenum", 20,0, false, "法定代表人手机号码（短信通知）" )))
											).addNode(new ArrayNode("agentinfo",false)
													.addNode(new FieldNode("agentname", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentname", 256,0, false, "代理人姓名" )))
													.addNode(new FieldNode("agentsex", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentsex", 1,0, false, "代理人性别" )))
													.addNode(new FieldNode("agentidenttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentidenttype", 3,0, false, "代理人证件类型" )))
													.addNode(new FieldNode("agentidentno", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentidentno", 30,0, false, "代理人证件号码" )))
													.addNode(new FieldNode("agentexpireddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentexpireddate", 8,0, false, "代理人证件有效期" )))
													.addNode(new FieldNode("applicantrelations", new MsgField(ContentEnum.MessageType.STRING.toString(), "applicantrelations", 20,0, false, "与申请人关系" )))
													.addNode(new FieldNode("agenttel", new MsgField(ContentEnum.MessageType.STRING.toString(), "agenttel", 20,0, false, "代理人联系方式" )))
													.addNode(new FieldNode("agentnation", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentnation", 3,0, false, "代理人国籍" )))
													));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C012000302_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, false, "客户号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

