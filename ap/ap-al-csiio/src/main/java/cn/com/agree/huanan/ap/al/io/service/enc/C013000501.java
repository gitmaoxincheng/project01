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
 * TRDCENTER.C013000501 客户明细信息查询.通用客户明细信息查询 
 * C0130005.01 ECIF001
 * 0337 企业级客户信息管理系统
 * @author XZF
 */
@Component
public class C013000501 extends EsbChannelService {

	private static C013000501_I i = new C013000501_I();
	private static C013000501_O o = new C013000501_O();
	public C013000501() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013000501_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, false, "客户号" )))
					.addNode(new FieldNode("custtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype", 1,0, false, "客户类型" )))
					.addNode(new FieldNode("identtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "identtype", 3,0, false, "证件类型" )))
					.addNode(new FieldNode("identno", new MsgField(ContentEnum.MessageType.STRING.toString(), "identno", 3,0, false, "证件号码" )))
					.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("certarea", new MsgField(ContentEnum.MessageType.STRING.toString(), "certarea", 3,0, false, "发证国家或地区" )))
					.addNode(new FieldNode("startpage", new MsgField(ContentEnum.MessageType.STRING.toString(), "startpage", 1,0, false, "查询起始页" )))
					.addNode(new FieldNode("pagesize", new MsgField(ContentEnum.MessageType.STRING.toString(), "pagesize", 1,0, false, "每页查询记录数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C013000501_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true).addNode(new FieldNode("contrsize", new MsgField(ContentEnum.MessageType.STRING.toString(), "contrsize", 1,0, false, "返回记录数" )))
					.addNode(new FieldNode("totalcount", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalcount", 1,0, false, "查询结果总记录数" )))
					.addNode(new ArrayNode("custinfo_list",false)
						.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, false, "客户号" )))
						.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 256,0, false, "客户名称" )))
						.addNode(new FieldNode("custtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype", 1,0, false, "客户类型" )))
						.addNode(new FieldNode("identtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "identtype", 3,0, false, "证件类型" )))
						.addNode(new FieldNode("identno", new MsgField(ContentEnum.MessageType.STRING.toString(), "identno", 3,0, false, "证件号码" )))
						.addNode(new FieldNode("certarea", new MsgField(ContentEnum.MessageType.STRING.toString(), "certarea", 3,0, false, "发证国家或地区" )))
						.addNode(new FieldNode("custstat", new MsgField(ContentEnum.MessageType.STRING.toString(), "custstat", 1,0, false, "客户状态标志" )))
						.addNode(new FieldNode("virtualorgflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "virtualorgflag", 1,0, false, "公司特殊客户标识" )))
						.addNode(new FieldNode("againidentityresult", new MsgField(ContentEnum.MessageType.STRING.toString(), "againidentityresult", 1,0, false, "重新核实身份结果" )))
						.addNode(new FieldNode("createdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "createdate", 8,0, false, "创建日期" )))
						.addNode(new FieldNode("createbranch", new MsgField(ContentEnum.MessageType.STRING.toString(), "createbranch", 12,0, false, "创建机构编号" )))
						.addNode(new FieldNode("openaccteller", new MsgField(ContentEnum.MessageType.STRING.toString(), "openaccteller", 1,0, false, "创建柜员编号" )))
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
