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
 * TRDCENTER.C012000503 客户基本信息维护.个人客户基本信息修改 
 * C0120005.03 ECIF303
 * 0337 企业级客户信息管理系统
 * @author XZF
 */
@Component
public class C012000503 extends EsbChannelService {

	private static C012000503_I i = new C012000503_I();
	private static C012000503_O o = new C012000503_O();
	public C012000503() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C012000503_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("custinfo",false)
							.addNode(new FieldNode("openacctflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "openacctflag", 2,0, true, "是否开账户标志" )))
							.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, true, "客户号" )))
							.addNode(new FieldNode("identorgaddid", new MsgField(ContentEnum.MessageType.STRING.toString(), "identorgaddid", 6,0, false, "发证机关地区代码" )))
							.addNode(new FieldNode("identeffectivedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "identeffectivedate", 8,0, false, "证件生效日期" )))
							.addNode(new FieldNode("identexpireddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "identexpireddate", 8,0, false, "证件失效日期" )))
							.addNode(new FieldNode("countryorregion", new MsgField(ContentEnum.MessageType.STRING.toString(), "countryorregion", 3,0, false, "国籍或地区" )))
							).addNode(new ArrayNode("perinfo",false)
									.addNode(new FieldNode("residentflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "residentflag", 1,0, false, "居民标志" )))
									.addNode(new FieldNode("internetinspectflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "internetinspectflag", 2,0, false, "联网核查标识" )))
									.addNode(new FieldNode("noinspectcause", new MsgField(ContentEnum.MessageType.STRING.toString(), "noinspectcause", 1,0, false, "无法核实原因" )))
									.addNode(new FieldNode("sex", new MsgField(ContentEnum.MessageType.STRING.toString(), "sex", 1,0, false, "性别" )))
									.addNode(new FieldNode("mobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobile", 20,0, false, "手机号码" )))
									.addNode(new FieldNode("nationality", new MsgField(ContentEnum.MessageType.STRING.toString(), "nationality", 2,0, false, "民族" )))
									.addNode(new FieldNode("marriage", new MsgField(ContentEnum.MessageType.STRING.toString(), "marriage", 2,0, false, "婚姻状况" )))
									.addNode(new FieldNode("residence", new MsgField(ContentEnum.MessageType.STRING.toString(), "residence", 1,0, false, "居住状况" )))
									.addNode(new FieldNode("highestedu", new MsgField(ContentEnum.MessageType.STRING.toString(), "highestedu", 20,0, false, "最高学历" )))
									.addNode(new FieldNode("schoolname", new MsgField(ContentEnum.MessageType.STRING.toString(), "schoolname", 256,0, false, "学校名称" )))
									.addNode(new FieldNode("liveaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "liveaddr", 300,0, false, "居住地址" )))
									.addNode(new FieldNode("liveaddrnation", new MsgField(ContentEnum.MessageType.STRING.toString(), "liveaddrnation", 3,0, false, "居住地址-国家" )))
									.addNode(new FieldNode("liveaddrprovince", new MsgField(ContentEnum.MessageType.STRING.toString(), "liveaddrprovince", 6,0, false, "居住地址-省" )))
									.addNode(new FieldNode("liveaddrcity", new MsgField(ContentEnum.MessageType.STRING.toString(), "liveaddrcity", 6,0, false, "居住地址-市" )))
									.addNode(new FieldNode("liveaddrzone", new MsgField(ContentEnum.MessageType.STRING.toString(), "liveaddrzone", 6,0, false, "居住地址-区" )))
									.addNode(new FieldNode("liveaddrdetail", new MsgField(ContentEnum.MessageType.STRING.toString(), "liveaddrdetail", 300,0, false, "居住地址-详细地址" )))
									.addNode(new FieldNode("livezipcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "livezipcode", 10,0, false, "居住地址邮编" )))
									.addNode(new FieldNode("domaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "domaddr", 300,0, false, "户籍地址" )))
									.addNode(new FieldNode("domaddrnation", new MsgField(ContentEnum.MessageType.STRING.toString(), "domaddrnation", 3,0, false, "户籍地址-国家" )))
									.addNode(new FieldNode("domaddrprovince", new MsgField(ContentEnum.MessageType.STRING.toString(), "domaddrprovince", 6,0, false, "户籍地址-省" )))
									.addNode(new FieldNode("domaddrcity", new MsgField(ContentEnum.MessageType.STRING.toString(), "domaddrcity", 6,0, false, "户籍地址-市" )))
									.addNode(new FieldNode("domaddrzone", new MsgField(ContentEnum.MessageType.STRING.toString(), "domaddrzone", 6,0, false, "户籍地址-区" )))
									.addNode(new FieldNode("domaddrdetail", new MsgField(ContentEnum.MessageType.STRING.toString(), "domaddrdetail", 300,0, false, "户籍地址-详细地址" )))
									.addNode(new FieldNode("domzipcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "domzipcode", 10,0, false, "户籍地址邮编" )))
									.addNode(new FieldNode("mobilerealflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobilerealflag", 1,0, false, "移动电话实名制标识" )))
									.addNode(new FieldNode("careertype", new MsgField(ContentEnum.MessageType.STRING.toString(), "careertype", 10,0, false, "职业类别" )))
									.addNode(new FieldNode("careerexplain", new MsgField(ContentEnum.MessageType.STRING.toString(), "careerexplain", 100,0, false, "职业补充说明" )))
									.addNode(new FieldNode("unitname", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitname", 256,0, false, "单位名称" )))
									.addNode(new FieldNode("unitecontype", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitecontype", 10,0, false, "单位经济类型" )))
									.addNode(new FieldNode("unitindustry", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitindustry", 5,0, false, "单位所属行业" )))
									.addNode(new FieldNode("unitaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitaddr", 300,0, false, "单位地址" )))
									.addNode(new FieldNode("unitaddrnation", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitaddrnation", 3,0, false, "单位地址-国家" )))
									.addNode(new FieldNode("unitaddrprovince", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitaddrprovince", 6,0, false, "单位地址-省" )))
									.addNode(new FieldNode("unitaddrcity", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitaddrcity", 6,0, false, "单位地址-市" )))
									.addNode(new FieldNode("unitaddrzone", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitaddrzone", 6,0, false, "单位地址-区" )))
									.addNode(new FieldNode("unitaddrdetail", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitaddrdetail", 300,0, false, "单位地址-详细地址" )))
									.addNode(new FieldNode("unitzipcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitzipcode", 10,0, false, "单位地址邮编" )))
									.addNode(new FieldNode("unittel", new MsgField(ContentEnum.MessageType.STRING.toString(), "unittel", 20,0, false, "单位电话" )))
									.addNode(new FieldNode("hometel", new MsgField(ContentEnum.MessageType.STRING.toString(), "hometel", 20,0, false, "家庭电话" )))
									.addNode(new FieldNode("unitfex", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitfex", 20,0, false, "传真" )))
									.addNode(new FieldNode("email", new MsgField(ContentEnum.MessageType.STRING.toString(), "email", 100,0, false, "电子邮件" )))
									.addNode(new FieldNode("note", new MsgField(ContentEnum.MessageType.STRING.toString(), "note", 300,0, false, "备注" )))
									.addNode(new FieldNode("taxresidents", new MsgField(ContentEnum.MessageType.STRING.toString(), "taxresidents", 1,0, false, "税收居民身份" )))
									.addNode(new FieldNode("familynameen", new MsgField(ContentEnum.MessageType.STRING.toString(), "familynameen", 120,0, false, "客户姓（英文或拼音）" )))
									.addNode(new FieldNode("personalnameen", new MsgField(ContentEnum.MessageType.STRING.toString(), "personalnameen", 120,0, false, "客户名（英文或拼音）" )))
									.addNode(new FieldNode("borndate", new MsgField(ContentEnum.MessageType.STRING.toString(), "borndate", 8,0, false, "出生日期" )))
									.addNode(new FieldNode("bornaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "bornaddr", 300,0, false, "出生地（中文）" )))
									.addNode(new FieldNode("bornaddrnation", new MsgField(ContentEnum.MessageType.STRING.toString(), "bornaddrnation", 3,0, false, "出生地-国家" )))
									.addNode(new FieldNode("bornaddrprov", new MsgField(ContentEnum.MessageType.STRING.toString(), "bornaddrprov", 6,0, false, "出生地-省（中文）" )))
									.addNode(new FieldNode("bornaddrcity", new MsgField(ContentEnum.MessageType.STRING.toString(), "bornaddrcity", 6,0, false, "出生地-市（中文）" )))
									.addNode(new FieldNode("bornaddrzone", new MsgField(ContentEnum.MessageType.STRING.toString(), "bornaddrzone", 6,0, false, "出生地-区（中文）" )))
									.addNode(new FieldNode("bornaddrdetail", new MsgField(ContentEnum.MessageType.STRING.toString(), "bornaddrdetail", 300,0, false, "出生地-详细（中文）" )))
									.addNode(new FieldNode("bornaddren", new MsgField(ContentEnum.MessageType.STRING.toString(), "bornaddren", 120,0, false, "出生地（英文或拼音）" )))
									.addNode(new FieldNode("bornaddrnationen", new MsgField(ContentEnum.MessageType.STRING.toString(), "bornaddrnationen", 120,0, false, "出生地-国家（英文或拼音）" )))
									.addNode(new FieldNode("bornaddrproven", new MsgField(ContentEnum.MessageType.STRING.toString(), "bornaddrproven", 120,0, false, "出生地-省（英文或拼音）" )))
									.addNode(new FieldNode("bornaddrcityen", new MsgField(ContentEnum.MessageType.STRING.toString(), "bornaddrcityen", 120,0, false, "出生地-市（英文或拼音）" )))
									.addNode(new FieldNode("bornaddrzoneen", new MsgField(ContentEnum.MessageType.STRING.toString(), "bornaddrzoneen", 120,0, false, "出生地-区（英文或拼音）" )))
									.addNode(new FieldNode("bornaddrdetailen", new MsgField(ContentEnum.MessageType.STRING.toString(), "bornaddrdetailen", 120,0, false, "出生地-详细（英文或拼音）" )))
									.addNode(new FieldNode("liveaddren", new MsgField(ContentEnum.MessageType.STRING.toString(), "liveaddren", 120,0, false, "居住地址(英文或拼音）" )))
									.addNode(new FieldNode("liveaddrnationen", new MsgField(ContentEnum.MessageType.STRING.toString(), "liveaddrnationen", 120,0, false, "居住地址-国家(英文或拼音）" )))
									.addNode(new FieldNode("liveaddrprovinceen", new MsgField(ContentEnum.MessageType.STRING.toString(), "liveaddrprovinceen", 120,0, false, "居住地址-省(英文或拼音）" )))
									.addNode(new FieldNode("liveaddrcityen", new MsgField(ContentEnum.MessageType.STRING.toString(), "liveaddrcityen", 120,0, false, "居住地址-市(英文或拼音）" )))
									.addNode(new FieldNode("liveaddrzoneen", new MsgField(ContentEnum.MessageType.STRING.toString(), "liveaddrzoneen", 120,0, false, "居住地址-区 (英文或拼音）" )))
									.addNode(new FieldNode("liveaddrdetailen", new MsgField(ContentEnum.MessageType.STRING.toString(), "liveaddrdetailen", 120,0, false, "居住地址-详细地址(英文或拼音）" )))
									.addNode(new FieldNode("pertaxnation", new MsgField(ContentEnum.MessageType.STRING.toString(), "pertaxnation", 200,0, false, "税收居民国（地区）" )))
									.addNode(new FieldNode("pernationtaxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "pernationtaxno", 20,0, false, "居民国（地区）纳税人识别号" )))
									.addNode(new FieldNode("noinspecttaxreason", new MsgField(ContentEnum.MessageType.STRING.toString(), "noinspecttaxreason", 1,0, false, "无纳税人识别号原因" )))
									.addNode(new FieldNode("specificcause", new MsgField(ContentEnum.MessageType.STRING.toString(), "specificcause", 200,0, false, "具体原因" )))
									));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C012000503_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
