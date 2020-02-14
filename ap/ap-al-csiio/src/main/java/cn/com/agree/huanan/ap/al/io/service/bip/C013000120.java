package cn.com.agree.huanan.ap.al.io.service.bip;

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
 * BASESVC.C013000120 客户信息查询.个人客户关键要素信息广播 
 * C0130001.20 BIPT002004
 * 0301 业务组合平台
 * @author XZF
 */
//@Component  
public class C013000120 extends EsbChannelService {

	private static C013000120_I i = new C013000120_I();
	private static C013000120_O o = new C013000120_O();
	public C013000120() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013000120_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("srcsysno", new MsgField(ContentEnum.MessageType.STRING.toString(), "srcsysno", 10,0, true, "源系统编号" )))
					.addNode(new ArrayNode("custinfo",false)
							.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 32,0, true, "客户号" )))
							.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 256,0, false, "客户名称" )))
							.addNode(new FieldNode("custstat", new MsgField(ContentEnum.MessageType.STRING.toString(), "custstat", 1,0, false, "客户状态标志" )))
							.addNode(new FieldNode("countryorregion", new MsgField(ContentEnum.MessageType.STRING.toString(), "countryorregion", 3,0, false, "国籍或地区" )))
							.addNode(new FieldNode("identtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "identtype", 3,0, false, "证件类型" )))
							.addNode(new FieldNode("identno", new MsgField(ContentEnum.MessageType.STRING.toString(), "identno", 30,0, false, "证件号码" )))
							.addNode(new FieldNode("identexpdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "identexpdate", 8,0, false, "证件有效期" )))
							.addNode(new FieldNode("identextexpireddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "identextexpireddate", 8,0, false, "证件绿色通道失效日期" )))
							.addNode(new FieldNode("identorg", new MsgField(ContentEnum.MessageType.STRING.toString(), "identorg", 6,0, false, "发证机关地区代码" )))
							.addNode(new FieldNode("countryorarea", new MsgField(ContentEnum.MessageType.STRING.toString(), "countryorarea", 3,0, false, "发证国家或地区" )))
							).addNode(new ArrayNode("relident",false)
									.addNode(new FieldNode("relidenttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "relidenttype", 3,0, false, "关联证件类型" )))
									.addNode(new FieldNode("relidentno", new MsgField(ContentEnum.MessageType.STRING.toString(), "relidentno", 30,0, false, "关联证件号码" )))
									.addNode(new FieldNode("relflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "relflag", 1,0, false, "关联标志" )))
									).addNode(new ArrayNode("perinfo",false)
											.addNode(new FieldNode("residentflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "residentflag", 1,0, false, "居民标志" )))
											.addNode(new FieldNode("internetinspectflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "internetinspectflag", 2,0, false, "联网核查标识" )))
											.addNode(new FieldNode("sex", new MsgField(ContentEnum.MessageType.STRING.toString(), "sex", 1,0, false, "性别" )))
											.addNode(new FieldNode("mobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobile", 20,0, false, "手机号码" )))
											.addNode(new FieldNode("custenname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custenname", 120,0, false, "客户英文姓" )))
											.addNode(new FieldNode("custenshortname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custenshortname", 120,0, false, "客户英文名" )))
											.addNode(new FieldNode("liveaddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "liveaddr", 300,0, false, "居住地址" )))
											.addNode(new FieldNode("liveaddrnation", new MsgField(ContentEnum.MessageType.STRING.toString(), "liveaddrnation", 3,0, false, "居住地址-国家" )))
											.addNode(new FieldNode("liveaddrprovince", new MsgField(ContentEnum.MessageType.STRING.toString(), "liveaddrprovince", 6,0, false, "居住地址-省" )))
											.addNode(new FieldNode("liveaddrcity", new MsgField(ContentEnum.MessageType.STRING.toString(), "liveaddrcity", 6,0, false, "居住地址-市" )))
											.addNode(new FieldNode("liveaddrzone", new MsgField(ContentEnum.MessageType.STRING.toString(), "liveaddrzone", 6,0, false, "居住地址-区" )))
											.addNode(new FieldNode("liveaddrdetail", new MsgField(ContentEnum.MessageType.STRING.toString(), "liveaddrdetail", 300,0, false, "居住地址-详细地址" )))
											.addNode(new FieldNode("livezipcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "livezipcode", 10,0, false, "居住地址邮编" )))
											.addNode(new FieldNode("careertype", new MsgField(ContentEnum.MessageType.STRING.toString(), "careertype", 10,0, false, "职业类别" )))
											.addNode(new FieldNode("careerexplain", new MsgField(ContentEnum.MessageType.STRING.toString(), "careerexplain", 100,0, false, "职业补充说明" )))
											.addNode(new FieldNode("unittel", new MsgField(ContentEnum.MessageType.STRING.toString(), "unittel", 20,0, false, "单位电话" )))
											.addNode(new FieldNode("hometel", new MsgField(ContentEnum.MessageType.STRING.toString(), "hometel", 20,0, false, "家庭电话" )))
											));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C013000120_O extends MsgBody {
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

