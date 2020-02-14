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
 * TRDCENTER.C013000503 客户基本信息维护.公司/同业客户列表查询 
 * C0130005.03 ECIF102
 * 0337 企业级客户信息管理系统
 * @author XZF
 */
@Component
public class C013000503 extends EsbChannelService {

	private static C013000503_I i = new C013000503_I();
	private static C013000503_O o = new C013000503_O();
	public C013000503() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013000503_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, false, "客户号" )))
					.addNode(new FieldNode("identtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "identtype", 3,0, false, "证件类型" )))
					.addNode(new FieldNode("identno", new MsgField(ContentEnum.MessageType.STRING.toString(), "identno", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 256,0, false, "客户名称" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C013000503_O extends MsgBody {
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
							.addNode(new FieldNode("virtualorgflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "virtualorgflag", 1,0, false, "公司特殊客户标识" )))
							.addNode(new FieldNode("custorg", new MsgField(ContentEnum.MessageType.STRING.toString(), "custorg", 12,0, false, "客户认定机构" )))
							.addNode(new FieldNode("riskgrade", new MsgField(ContentEnum.MessageType.STRING.toString(), "riskgrade", 1,0, false, "风险等级" )))
							.addNode(new FieldNode("openaccdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "openaccdate", 8,0, false, "开客户日期" )))
							.addNode(new FieldNode("openaccorg", new MsgField(ContentEnum.MessageType.STRING.toString(), "openaccorg", 12,0, false, "开户机构" )))
							.addNode(new FieldNode("openaccteller", new MsgField(ContentEnum.MessageType.STRING.toString(), "openaccteller", 10,0, false, "开客户柜员" )))
							.addNode(new FieldNode("deptflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "deptflag", 3,0, false, "存款人类别" )))
							.addNode(new FieldNode("unittle", new MsgField(ContentEnum.MessageType.STRING.toString(), "unittle", 20,0, false, "单位电话" )))
							.addNode(new FieldNode("orgtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgtype", 2,0, false, "金融机构分类标准" )))
							.addNode(new FieldNode("orgcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgcode", 30,0, false, "组织机构代码" )))
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
