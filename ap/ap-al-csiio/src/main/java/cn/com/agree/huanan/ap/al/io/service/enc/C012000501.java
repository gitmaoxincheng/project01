package cn.com.agree.huanan.ap.al.io.service.enc;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.C012000501 客户基本信息维护.个人客户开户证件信息修改 
 * C0120005.01 ECIF301
 * 0337 企业级客户信息管理系统
 * @author XZF
 */
@Component
public class C012000501 extends EsbChannelService {

	private static C012000501_I i = new C012000501_I();
	private static C012000501_O o = new C012000501_O();
	public C012000501() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C012000501_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",false)
					.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, false, "客户号" )))
					.addNode(new FieldNode("ennameonly", new MsgField(ContentEnum.MessageType.STRING.toString(), "ennameonly", 1,0, false, "是否仅有英文名称" )))
					.addNode(new FieldNode("enname", new MsgField(ContentEnum.MessageType.STRING.toString(), "enname", 120,0, false, "客户英文名称" )))
					.addNode(new FieldNode("custenname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custenname", 120,0, false, "客户英文姓" )))
					.addNode(new FieldNode("custenshortname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custenshortname", 120,0, false, "客户英文名" )))
					.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 256,0,false , "客户名称" )))
					.addNode(new FieldNode("identtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "identtype", 3,0, false, "证件类型" )))
					.addNode(new FieldNode("identno", new MsgField(ContentEnum.MessageType.STRING.toString(), "identno", 30,0, false, "证件码号" )))
					.addNode(new FieldNode("countryorarea", new MsgField(ContentEnum.MessageType.STRING.toString(), "countryorarea", 3,0, false, "发证国家或地区" )))
					.addNode(new FieldNode("identorg", new MsgField(ContentEnum.MessageType.STRING.toString(), "identorg", 6,0, false, "发证机关地区代码" )))
					.addNode(new FieldNode("identexpdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "identexpdate", 8,0, false, "证件有效期" )))
					.addNode(new FieldNode("sex", new MsgField(ContentEnum.MessageType.STRING.toString(), "sex", 1,0, false, "性别" )))
					.addNode(new FieldNode("countryorregion", new MsgField(ContentEnum.MessageType.STRING.toString(), "countryorregion", 3,0, false, "国籍或地区" )))
					.addNode(new FieldNode("residentflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "residentflag", 1,0, false, "居民标志" )))
					.addNode(new FieldNode("oldcusname", new MsgField(ContentEnum.MessageType.STRING.toString(), "oldcusname", 256,0, false, "原客户名称" )))
					.addNode(new FieldNode("oldidenttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "oldidenttype", 3,0, false, "原证件类型" )))
					.addNode(new FieldNode("oldidentno", new MsgField(ContentEnum.MessageType.STRING.toString(), "oldidentno", 30,0, false, "原证件码号" )))
					.addNode(new FieldNode("oldcountryorarea", new MsgField(ContentEnum.MessageType.STRING.toString(), "oldcountryorarea", 3,0, false, "原发证国家或地区" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C012000501_O extends MsgBody {
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

