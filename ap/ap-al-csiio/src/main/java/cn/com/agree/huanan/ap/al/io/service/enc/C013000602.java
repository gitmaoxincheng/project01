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
 * TRDCENTER.C013000602 客户详细信息查询.公司/同业客户详细信息查询 
 * C0130006.02 ECIF105
 * 0337 企业级客户信息管理系统
 * @author XZF
 */
@Component
public class C013000602 extends EsbChannelService {

	private static C013000602_I i = new C013000602_I();
	private static C013000602_O o = new C013000602_O();
	public C013000602() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013000602_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, true, "客户号" )))
					.addNode(new FieldNode("custtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype", 1,0, false, "客户类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C013000602_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new StructNode("custinfo",false)
							.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, false, "客户号" )))
							.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 256,0, false, "客户名称" )))
							.addNode(new FieldNode("enname", new MsgField(ContentEnum.MessageType.STRING.toString(), "enname", 120,0, false, "客户英文名称" )))
							.addNode(new FieldNode("countryorregion", new MsgField(ContentEnum.MessageType.STRING.toString(), "countryorregion", 3,0, false, "国籍或地区" )))
							.addNode(new FieldNode("identtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "identtype", 3,0, false, "证件类型" )))
							.addNode(new FieldNode("identno", new MsgField(ContentEnum.MessageType.STRING.toString(), "identno", 30,0, false, "证件号码" )))
							.addNode(new FieldNode("certarea", new MsgField(ContentEnum.MessageType.STRING.toString(), "certarea", 3,0, false, "发证国家或地区" )))
							.addNode(new FieldNode("custtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype", 1,0, false, "客户类型" )))
							.addNode(new FieldNode("custstat", new MsgField(ContentEnum.MessageType.STRING.toString(), "custstat", 1,0, false, "客户状态标志" )))
							.addNode(new FieldNode("virtualflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "virtualflag", 1,0, false, "特殊客户标志" )))
							.addNode(new FieldNode("identcustno", new MsgField(ContentEnum.MessageType.STRING.toString(), "identcustno", 20,0, false, "识别号(客户推荐人)" )))
							.addNode(new FieldNode("custorg", new MsgField(ContentEnum.MessageType.STRING.toString(), "custorg", 12,0, false, "客户认定机构" )))
							.addNode(new FieldNode("custgrade", new MsgField(ContentEnum.MessageType.STRING.toString(), "custgrade", 2,0, false, "客户级别（客户等级）" )))
							.addNode(new FieldNode("riskgrade", new MsgField(ContentEnum.MessageType.STRING.toString(), "riskgrade", 1,0, false, "风险等级" )))
							.addNode(new FieldNode("againidentityresult", new MsgField(ContentEnum.MessageType.STRING.toString(), "againidentityresult", 1,0, false, "重新核实身份结果" )))
							.addNode(new FieldNode("openaccdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "openaccdate", 8,0, false, "开客户日期" )))
							.addNode(new FieldNode("openaccorg", new MsgField(ContentEnum.MessageType.STRING.toString(), "openaccorg", 12,0, false, "开户机构" )))
							.addNode(new FieldNode("openaccteller", new MsgField(ContentEnum.MessageType.STRING.toString(), "openaccteller", 10,0, false, "开客户柜员" )))
							.addNode(new FieldNode("lastupdateuser", new MsgField(ContentEnum.MessageType.STRING.toString(), "lastupdateuser", 10,0, false, "最后修改柜员" )))
							.addNode(new FieldNode("lastupdatetm", new MsgField(ContentEnum.MessageType.STRING.toString(), "lastupdatetm", 40,0, false, "最后修改时间" )))
							).addNode(new StructNode("identinfo",false)
									.addNode(new FieldNode("identeffectivedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "identeffectivedate", 8,0, false, "证件生效日期" )))
									.addNode(new FieldNode("identexpireddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "identexpireddate", 8,0, false, "证件失效日期" )))
									.addNode(new FieldNode("identorgaddid", new MsgField(ContentEnum.MessageType.STRING.toString(), "identorgaddid", 6,0, false, "发证机关地区代码" )))
									).addNode(new StructNode("copinfo",false)
											.addNode(new FieldNode("inoutflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "inoutflag", 1,0, false, "境内外标识" )))
											.addNode(new FieldNode("outsideorgtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "outsideorgtype", 1,0, false, "境外机构类别" )))
											.addNode(new FieldNode("organtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "organtype", 10,0, false, "组织机构类型" )))
											.addNode(new FieldNode("industry", new MsgField(ContentEnum.MessageType.STRING.toString(), "industry", 5,0, false, "行业分类" )))
											.addNode(new FieldNode("finaorgtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "finaorgtype", 2,0, false, "金融机构分类标准" )))
											.addNode(new FieldNode("basicopenno", new MsgField(ContentEnum.MessageType.STRING.toString(), "basicopenno", 14,0, false, "基本户开户核准号" )))
											.addNode(new FieldNode("basicaccno", new MsgField(ContentEnum.MessageType.STRING.toString(), "basicaccno", 40,0, false, "基本户账号" )))
											.addNode(new FieldNode("basicaccseq", new MsgField(ContentEnum.MessageType.STRING.toString(), "basicaccseq", 20,0, false, "基本账户编号" )))
											.addNode(new FieldNode("basicbankcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "basicbankcode", 12,0, false, "基本户开户银行代码" )))
											.addNode(new FieldNode("basicbankname", new MsgField(ContentEnum.MessageType.STRING.toString(), "basicbankname", 256,0, false, "基本户开户银行名称" )))
											.addNode(new FieldNode("basicbankdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "basicbankdate", 8,0, false, "基本户开户日期" )))
											.addNode(new FieldNode("orgcreditno", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgcreditno", 20,0, false, "机构信用代码证号" )))
											.addNode(new FieldNode("orgcreditdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgcreditdate", 8,0, false, "机构信用代码证有效期" )))
											.addNode(new FieldNode("enterscale", new MsgField(ContentEnum.MessageType.STRING.toString(), "enterscale", 1,0, false, "企业规模（企业规模代码）" )))
											.addNode(new FieldNode("localtaxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "localtaxno", 20,0, false, "地税登记号" )))
											.addNode(new FieldNode("nationtaxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "nationtaxno", 20,0, false, "国税登记号" )))
											.addNode(new FieldNode("buslicscope", new MsgField(ContentEnum.MessageType.STRING.toString(), "buslicscope", 200,0, false, "营业执照经营范围" )))
											.addNode(new FieldNode("ownerform", new MsgField(ContentEnum.MessageType.STRING.toString(), "ownerform", 20,0, false, "所有制形式" )))
											.addNode(new FieldNode("ieflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ieflag", 1,0, false, "进出口权标志" )))
											.addNode(new FieldNode("custflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "custflag", 2,0, false, "所属客群标识" )))
											.addNode(new FieldNode("deptflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "deptflag", 3,0, false, "存款人类别" )))
											.addNode(new FieldNode("notprove", new MsgField(ContentEnum.MessageType.STRING.toString(), "notprove", 200,0, false, "无需办理税务登记证明的文件或税务机关出具的证明" )))
											.addNode(new FieldNode("registercny", new MsgField(ContentEnum.MessageType.STRING.toString(), "registercny", 3,0, false, "注册币种" )))
											.addNode(new FieldNode("registeramount", new MsgField(ContentEnum.MessageType.INT.toString(), "registeramount", 18,2, false, "注册金额" )))
											.addNode(new FieldNode("registerregioncode", new MsgField(ContentEnum.MessageType.STRING.toString(), "registerregioncode", 50,0, false, "注册地区代码" )))
											.addNode(new FieldNode("regdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "regdate", 8,0, false, "注册日期" )))
											.addNode(new FieldNode("entsetdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "entsetdate", 8,0, false, "企业成立日期" )))
											.addNode(new FieldNode("listedplace", new MsgField(ContentEnum.MessageType.STRING.toString(), "listedplace", 2,0, false, "上市地点" )))
											.addNode(new FieldNode("stockcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "stockcode", 60,0, false, "股票代码" )))
											.addNode(new FieldNode("orgregisterdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgregisterdate", 8,0, false, "组织机构登记日期" )))
											.addNode(new FieldNode("unittle", new MsgField(ContentEnum.MessageType.STRING.toString(), "unittle", 20,0, false, "单位电话" )))
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
											.addNode(new FieldNode("direunitopenno", new MsgField(ContentEnum.MessageType.STRING.toString(), "direunitopenno", 50,0, false, "主管单位基本户开户许可证号" )))
											.addNode(new FieldNode("direbasicaccseq", new MsgField(ContentEnum.MessageType.STRING.toString(), "direbasicaccseq", 20,0, false, "主管单位基本账户编号" )))
											.addNode(new FieldNode("direunitid", new MsgField(ContentEnum.MessageType.STRING.toString(), "direunitid", 20,0, false, "主管单位组织机构代码" )))
											.addNode(new FieldNode("selfclaim", new MsgField(ContentEnum.MessageType.STRING.toString(), "selfclaim", 1,0, false, "税收居民身份" )))
											.addNode(new FieldNode("orgtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgtype", 1,0, false, "机构类别" )))
											.addNode(new FieldNode("taxnation", new MsgField(ContentEnum.MessageType.STRING.toString(), "taxnation", 200,0, false, "税收居民国（地区）" )))
											.addNode(new FieldNode("taxpayerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "taxpayerno", 20,0, false, "居民国（地区)纳税人识别号" )))
											.addNode(new FieldNode("notaxpayerreason", new MsgField(ContentEnum.MessageType.STRING.toString(), "notaxpayerreason", 1,0, false, "无纳税人识别号原因" )))
											.addNode(new FieldNode("specificcause", new MsgField(ContentEnum.MessageType.STRING.toString(), "specificcause", 200,0, false, "具体原因" )))
											).addNode(new StructNode("legalinfo",false)
													.addNode(new FieldNode("legalname", new MsgField(ContentEnum.MessageType.STRING.toString(), "legalname", 256,0, false, "法定代表人客户名称" )))
													.addNode(new FieldNode("identtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "identtype", 3,0, false, "法定代表人证件类型" )))
													.addNode(new FieldNode("identno", new MsgField(ContentEnum.MessageType.STRING.toString(), "identno", 30,0, false, "法定代表人证件号码" )))
													.addNode(new FieldNode("identdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "identdate", 8,0, false, "法定代表人证件到期日(有效期）" )))
													.addNode(new FieldNode("certarea", new MsgField(ContentEnum.MessageType.STRING.toString(), "certarea", 3,0, false, "法定代表人发证国家或地区" )))
													.addNode(new FieldNode("countryorregion", new MsgField(ContentEnum.MessageType.STRING.toString(), "countryorregion", 3,0, false, "法定代表人国籍或地区" )))
													.addNode(new FieldNode("mobilenum", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobilenum", 20,0, false, "法定代表人手机号码（短信通知）" )))
													).addNode(new StructNode("agentinfo",false)
															.addNode(new FieldNode("agentname", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentname", 256,0, false, "代理人姓名" )))
															.addNode(new FieldNode("agentsex", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentsex", 1,0, false, "代理人性别" )))
															.addNode(new FieldNode("agentidenttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentidenttype", 3,0, false, "代理人证件类型" )))
															.addNode(new FieldNode("agentidentno", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentidentno", 30,0, false, "代理人证件号码" )))
															.addNode(new FieldNode("agentexpireddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentexpireddate", 8,0, false, "代理人证件有效期" )))
															.addNode(new FieldNode("applicantrelations", new MsgField(ContentEnum.MessageType.STRING.toString(), "applicantrelations", 20,0, false, "与申请人关系" )))
															.addNode(new FieldNode("agenttel", new MsgField(ContentEnum.MessageType.STRING.toString(), "agenttel", 20,0, false, "代理人联系方式" )))
															.addNode(new FieldNode("agentnation", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentnation", 3,0, false, "代理人国籍" )))
															).addNode(new ArrayNode("addrinfo_list",false)
																	.addNode(new FieldNode("addrtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrtype", 1,0, false, "地址类型" )))
																	.addNode(new FieldNode("addrenflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrenflag", 1,0, false, "中英文地址标识" )))
																	.addNode(new FieldNode("addr", new MsgField(ContentEnum.MessageType.STRING.toString(), "addr", 300,0, false, "地址" )))
																	.addNode(new FieldNode("enaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "enaddr", 120,0, false, "英文地址" )))
																	.addNode(new FieldNode("countryorregion", new MsgField(ContentEnum.MessageType.STRING.toString(), "countryorregion", 3,0, false, "国家或地区代码" )))
																	.addNode(new FieldNode("provincecode", new MsgField(ContentEnum.MessageType.STRING.toString(), "provincecode", 6,0, false, "省直辖市自治区代码" )))
																	.addNode(new FieldNode("citycode", new MsgField(ContentEnum.MessageType.STRING.toString(), "citycode", 6,0, false, "市地区州盟代码" )))
																	.addNode(new FieldNode("countcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "countcode", 6,0, false, "县区代码" )))
																	.addNode(new FieldNode("addrdetail", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrdetail", 300,0, false, "详细地址" )))
																	.addNode(new FieldNode("zipcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "zipcode", 10,0, false, "邮政编码" )))
																	.addNode(new FieldNode("countryorregionen", new MsgField(ContentEnum.MessageType.STRING.toString(), "countryorregionen", 3,0, false, "国家或地区代码（英文或拼音）" )))
																	.addNode(new FieldNode("provincenameen", new MsgField(ContentEnum.MessageType.STRING.toString(), "provincenameen", 120,0, false, "省直辖市自治区名称（英文或拼音）" )))
																	.addNode(new FieldNode("citynameen", new MsgField(ContentEnum.MessageType.STRING.toString(), "citynameen", 120,0, false, "市地区州盟名称（英文或拼音）" )))
																	.addNode(new FieldNode("countnameen", new MsgField(ContentEnum.MessageType.STRING.toString(), "countnameen", 120,0, false, "县区名称（英文或拼音）" )))
																	.addNode(new FieldNode("addrdetailen", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrdetailen", 120,0, false, "详细地址（英文或拼音）" )))
																	));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
