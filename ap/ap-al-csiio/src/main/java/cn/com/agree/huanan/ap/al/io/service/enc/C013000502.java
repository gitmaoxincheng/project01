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
 * BASESVC.C013000502 客户明细信息查询.个人客户列表信息查询 
 * C0130005.02 ECIF101
 * 0337 企业级客户信息管理系统
 * @author XZF
 */
@Component
public class C013000502 extends EsbChannelService {

	private static C013000502_I i = new C013000502_I();
	private static C013000502_O o = new C013000502_O();
	public C013000502() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013000502_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, false, "客户号" )))
					.addNode(new FieldNode("identtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "identtype", 3,0, false, "证件类型" )))
					.addNode(new FieldNode("identno", new MsgField(ContentEnum.MessageType.STRING.toString(), "identno", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("certarea", new MsgField(ContentEnum.MessageType.STRING.toString(), "certarea", 3,0, false, "发证国家或地区" )))
					.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("mobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobile", 20,0, false, "手机号码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C013000502_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("custinfo_list",false)
							.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, false, "客户号" )))
							.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 256,0, false, "客户名称" )))
							.addNode(new FieldNode("identtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "identtype", 3,0, false, "证件类型" )))
							.addNode(new FieldNode("identno", new MsgField(ContentEnum.MessageType.STRING.toString(), "identno", 30,0, false, "证件号码" )))
							.addNode(new FieldNode("certarea", new MsgField(ContentEnum.MessageType.STRING.toString(), "certarea", 3,0, false, "发证国家或地区" )))
							.addNode(new FieldNode("custtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype", 1,0, false, "客户类型" )))
							.addNode(new FieldNode("custstat", new MsgField(ContentEnum.MessageType.STRING.toString(), "custstat", 1,0, false, "客户状态标志" )))
							.addNode(new FieldNode("custorg", new MsgField(ContentEnum.MessageType.STRING.toString(), "custorg", 12,0, false, "客户认定机构" )))
							.addNode(new FieldNode("custgrade", new MsgField(ContentEnum.MessageType.STRING.toString(), "custgrade", 2,0, false, "客户级别（客户等级）" )))
							.addNode(new FieldNode("riskgrade", new MsgField(ContentEnum.MessageType.STRING.toString(), "riskgrade", 1,0, false, "风险等级" )))
							.addNode(new FieldNode("ennameonly", new MsgField(ContentEnum.MessageType.STRING.toString(), "ennameonly", 1,0, false, "是否仅有英文名称" )))
							.addNode(new FieldNode("enname", new MsgField(ContentEnum.MessageType.STRING.toString(), "enname", 120,0, false, "客户英文名称" )))
							.addNode(new FieldNode("countryorregion", new MsgField(ContentEnum.MessageType.STRING.toString(), "countryorregion", 3,0, false, "国籍或地区" )))
							.addNode(new FieldNode("specialopenflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "specialopenflag", 1,0, false, "特殊开户标识" )))
							.addNode(new FieldNode("authtellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "authtellerno", 10,0, false, "授权柜员编号" )))
							.addNode(new FieldNode("openaccdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "openaccdate", 8,0, false, "开客户日期" )))
							.addNode(new FieldNode("openaccorg", new MsgField(ContentEnum.MessageType.STRING.toString(), "openaccorg", 12,0, false, "开户机构" )))
							.addNode(new FieldNode("openaccteller", new MsgField(ContentEnum.MessageType.STRING.toString(), "openaccteller", 10,0, false, "开客户柜员" )))
							.addNode(new FieldNode("sex", new MsgField(ContentEnum.MessageType.STRING.toString(), "sex", 1,0, false, "性别" )))
							.addNode(new FieldNode("internetinspectflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "internetinspectflag", 2,0, false, "联网核查标识" )))
							.addNode(new FieldNode("noinspectcause", new MsgField(ContentEnum.MessageType.STRING.toString(), "noinspectcause", 1,0, false, "无法核实原因" )))
							.addNode(new FieldNode("residentflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "residentflag", 1,0, false, "居民标志" )))
							.addNode(new FieldNode("mobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobile", 20,0, false, "手机号码" )))
							.addNode(new FieldNode("samecustflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "samecustflag", 1,0, false, "同号多客户标志" )))
							.addNode(new FieldNode("masterflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "masterflag", 1,0, false, "客户主次标志" )))
							.addNode(new FieldNode("nineelement", new MsgField(ContentEnum.MessageType.STRING.toString(), "nineelement", 1,0, false, "客户9要素是否完整标志" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

