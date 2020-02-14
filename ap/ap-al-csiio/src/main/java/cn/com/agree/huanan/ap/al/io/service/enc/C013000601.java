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
 * TRDCENTER.C013000601 客户详细信息查询.个人客户详细信息查询 
 * C0130006.01 ECIF104
 * 0337 企业级客户信息管理系统
 * @author XZF
 */
@Component
public class C013000601 extends EsbChannelService {

	private static C013000601_I i = new C013000601_I();
	private static C013000601_O o = new C013000601_O();
	public C013000601() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013000601_I extends MsgBody {
		private MsgSegment  msgSegment = init();
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

	public static class C013000601_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new StructNode("custinfo",false)
							.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, false, "客户号" )))
							.addNode(new FieldNode("custorg", new MsgField(ContentEnum.MessageType.STRING.toString(), "custorg", 12,0, false, "客户认定机构" )))
							.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 256,0, false, "客户名称" )))
							.addNode(new FieldNode("custgrade", new MsgField(ContentEnum.MessageType.STRING.toString(), "custgrade", 2,0, false, "客户级别（客户等级）" )))
							.addNode(new FieldNode("riskgrade", new MsgField(ContentEnum.MessageType.STRING.toString(), "riskgrade", 1,0, false, "风险等级" )))
							.addNode(new FieldNode("identtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "identtype", 3,0, false, "证件类型" )))
							.addNode(new FieldNode("identno", new MsgField(ContentEnum.MessageType.STRING.toString(), "identno", 30,0, false, "证件号码" )))
							.addNode(new FieldNode("certarea", new MsgField(ContentEnum.MessageType.STRING.toString(), "certarea", 3,0, false, "发证国家或地区" )))
							.addNode(new FieldNode("custtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype", 1,0, false, "客户类型" )))
							.addNode(new FieldNode("custstat", new MsgField(ContentEnum.MessageType.STRING.toString(), "custstat", 1,0, false, "客户状态标志" )))
							.addNode(new FieldNode("ennameonly", new MsgField(ContentEnum.MessageType.STRING.toString(), "ennameonly", 1,0, false, "是否仅有英文名称" )))
							.addNode(new FieldNode("enname", new MsgField(ContentEnum.MessageType.STRING.toString(), "enname", 120,0, false, "客户英文名称" )))
							.addNode(new FieldNode("countryorregion", new MsgField(ContentEnum.MessageType.STRING.toString(), "countryorregion", 3,0, false, "国籍或地区" )))
							.addNode(new FieldNode("identcustno", new MsgField(ContentEnum.MessageType.STRING.toString(), "identcustno", 20,0, false, "识别号(客户推荐人)" )))
							.addNode(new FieldNode("specialopenflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "specialopenflag", 1,0, false, "特殊开户标识" )))
							.addNode(new FieldNode("authtellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "authtellerno", 10,0, false, "授权柜员编号" )))
							.addNode(new FieldNode("againidentityresult", new MsgField(ContentEnum.MessageType.STRING.toString(), "againidentityresult", 1,0, false, "重新核实身份结果" )))
							.addNode(new FieldNode("openaccdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "openaccdate", 8,0, false, "开客户日期" )))
							.addNode(new FieldNode("openaccorg", new MsgField(ContentEnum.MessageType.STRING.toString(), "openaccorg", 12,0, false, "开户机构" )))
							.addNode(new FieldNode("openaccteller", new MsgField(ContentEnum.MessageType.STRING.toString(), "openaccteller", 10,0, false, "开客户柜员" )))
							.addNode(new FieldNode("lastupdateuser", new MsgField(ContentEnum.MessageType.STRING.toString(), "lastupdateuser", 10,0, false, "最后修改柜员" )))
							.addNode(new FieldNode("lastupdatetm", new MsgField(ContentEnum.MessageType.STRING.toString(), "lastupdatetm", 40,0, false, "最后修改时间" )))
							).addNode(new StructNode("identinfo",false)
									.addNode(new FieldNode("identeffectivedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "identeffectivedate", 8,0, false, "证件生效日期" )))
									.addNode(new FieldNode("identexpireddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "identexpireddate", 8,0, false, "证件失效日期" )))
									.addNode(new FieldNode("identextexpireddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "identextexpireddate", 8,0, false, "证件绿色通道失效日期" )))
									.addNode(new FieldNode("identorgaddid", new MsgField(ContentEnum.MessageType.STRING.toString(), "identorgaddid", 6,0, false, "发证机关地区代码" )))
									).addNode(new StructNode("perinfo",false)
											.addNode(new FieldNode("custenname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custenname", 120,0, false, "客户英文姓" )))
											.addNode(new FieldNode("custenshortname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custenshortname", 120,0, false, "客户英文名" )))
											.addNode(new FieldNode("sex", new MsgField(ContentEnum.MessageType.STRING.toString(), "sex", 1,0, false, "性别" )))
											.addNode(new FieldNode("nationality", new MsgField(ContentEnum.MessageType.STRING.toString(), "nationality", 2,0, false, "民族" )))
											.addNode(new FieldNode("marriage", new MsgField(ContentEnum.MessageType.STRING.toString(), "marriage", 2,0, false, "婚姻状况" )))
											.addNode(new FieldNode("residence", new MsgField(ContentEnum.MessageType.STRING.toString(), "residence", 1,0, false, "居住状况" )))
											.addNode(new FieldNode("highestedu", new MsgField(ContentEnum.MessageType.STRING.toString(), "highestedu", 20,0, false, "最高学历" )))
											.addNode(new FieldNode("schoolname", new MsgField(ContentEnum.MessageType.STRING.toString(), "schoolname", 256,0, false, "学校名称" )))
											.addNode(new FieldNode("internetinspectflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "internetinspectflag", 2,0, false, "联网核查标识" )))
											.addNode(new FieldNode("noinspectcause", new MsgField(ContentEnum.MessageType.STRING.toString(), "noinspectcause", 1,0, false, "无法核实原因" )))
											.addNode(new FieldNode("residentflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "residentflag", 1,0, false, "居民标志" )))
											.addNode(new FieldNode("careertype", new MsgField(ContentEnum.MessageType.STRING.toString(), "careertype", 10,0, false, "职业类别" )))
											.addNode(new FieldNode("careerexplain", new MsgField(ContentEnum.MessageType.STRING.toString(), "careerexplain", 100,0, false, "职业补充说明" )))
											.addNode(new FieldNode("unitname", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitname", 256,0, false, "单位名称" )))
											.addNode(new FieldNode("unitecontype", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitecontype", 10,0, false, "单位经济类型" )))
											.addNode(new FieldNode("unitindustry", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitindustry", 5,0, false, "单位所属行业" )))
											.addNode(new FieldNode("unittel", new MsgField(ContentEnum.MessageType.STRING.toString(), "unittel", 20,0, false, "单位电话" )))
											.addNode(new FieldNode("hometel", new MsgField(ContentEnum.MessageType.STRING.toString(), "hometel", 20,0, false, "家庭电话" )))
											.addNode(new FieldNode("unitfex", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitfex", 20,0, false, "传真" )))
											.addNode(new FieldNode("mobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobile", 20,0, false, "手机号码" )))
											.addNode(new FieldNode("mobilerealflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobilerealflag", 1,0, false, "移动电话实名制标识" )))
											.addNode(new FieldNode("email", new MsgField(ContentEnum.MessageType.STRING.toString(), "email", 100,0, false, "电子邮件" )))
											.addNode(new FieldNode("samecustflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "samecustflag", 1,0, false, "同号多客户标志" )))
											.addNode(new FieldNode("note", new MsgField(ContentEnum.MessageType.STRING.toString(), "note", 300,0, false, "备注" )))
											.addNode(new FieldNode("ifagent", new MsgField(ContentEnum.MessageType.STRING.toString(), "ifagent", 1,0, false, "是否代办" )))
											.addNode(new FieldNode("taxresidents", new MsgField(ContentEnum.MessageType.STRING.toString(), "taxresidents", 1,0, false, "税收居民身份" )))
											.addNode(new FieldNode("borndate", new MsgField(ContentEnum.MessageType.STRING.toString(), "borndate", 8,0, false, "出生日期" )))
											.addNode(new FieldNode("pertaxnation", new MsgField(ContentEnum.MessageType.STRING.toString(), "pertaxnation", 200,0, false, "税收居民国（地区）" )))
											.addNode(new FieldNode("pernationtaxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "pernationtaxno", 20,0, false, "居民国（地区）纳税人识别号" )))
											.addNode(new FieldNode("noinspecttaxreason", new MsgField(ContentEnum.MessageType.STRING.toString(), "noinspecttaxreason", 1,0, false, "无纳税人识别号原因" )))
											.addNode(new FieldNode("specificcause", new MsgField(ContentEnum.MessageType.STRING.toString(), "specificcause", 200,0, false, "具体原因" )))
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
															.addNode(new FieldNode("addrtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrtype", 3,0, false, "地址类型" )))
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
