package cn.com.agree.huanan.ap.al.io.service.sbc;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbSbcChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.C023001201 网点机构查询.网点机构信息查询 
 * C0230012.01 MT0203
 * 0212 金融互联网服务平台
 * @author XZF
 */
@Component
public class C023001201 extends EsbSbcChannelService {

	private static C023001201_I i = new C023001201_I();
	private static C023001201_O o = new C023001201_O();
	public C023001201() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C023001201_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("level", new MsgField(ContentEnum.MessageType.STRING.toString(), "level", 10,0, false, "机构类型" )))
					.addNode(new FieldNode("parentId", new MsgField(ContentEnum.MessageType.STRING.toString(), "parentId", 50,0, false, "父类id" )))
					.addNode(new FieldNode("flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "flag", 50,0, true, "操作标示" )))
					.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 50,0, false, "机构名" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C023001201_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("organizationList",false)
							.addNode(new FieldNode("branchNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "branchNo", 10,0, true, "机构号" )))
							.addNode(new FieldNode("type", new MsgField(ContentEnum.MessageType.STRING.toString(), "type", 10,0, true, "机构类型" )))
							.addNode(new FieldNode("propty", new MsgField(ContentEnum.MessageType.STRING.toString(), "propty", 10,0, true, "机构属性" )))
							.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 10,0, true, "机构状态" )))
							.addNode(new FieldNode("upbranchNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "upbranchNo", 10,0, true, "管辖机构号" )))
							.addNode(new FieldNode("branchNames", new MsgField(ContentEnum.MessageType.STRING.toString(), "branchNames", 20,0, true, "机构名称简称" )))
							.addNode(new FieldNode("branchName", new MsgField(ContentEnum.MessageType.STRING.toString(), "branchName", 50,0, true, "机构名称全称" )))
							.addNode(new FieldNode("telPhone", new MsgField(ContentEnum.MessageType.STRING.toString(), "telPhone", 20,0, true, "机构电话" )))
							.addNode(new FieldNode("address", new MsgField(ContentEnum.MessageType.STRING.toString(), "address", 100,0, true, "机构地址" )))
							.addNode(new FieldNode("branchType", new MsgField(ContentEnum.MessageType.STRING.toString(), "branchType", 10,0, true, "机构类型2" )))
							.addNode(new FieldNode("busiStatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "busiStatus", 10,0, true, "营业状态" )))
							.addNode(new FieldNode("branchKind", new MsgField(ContentEnum.MessageType.STRING.toString(), "branchKind", 10,0, true, "机构性质" )))
							.addNode(new FieldNode("startDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "startDate", 50,0, true, "机构工作开始时间" )))
							.addNode(new FieldNode("endDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "endDate", 50,0, true, "机构工作终止时间" )))
							.addNode(new FieldNode("dutyName", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutyName", 20,0, true, "负责人姓名" )))
							.addNode(new FieldNode("dutyPhone", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutyPhone", 20,0, true, "负责人联系电话" )))
							.addNode(new FieldNode("branchJd", new MsgField(ContentEnum.MessageType.STRING.toString(), "branchJd", 50,0, true, "机构经度" )))
							.addNode(new FieldNode("branchWd", new MsgField(ContentEnum.MessageType.STRING.toString(), "branchWd", 50,0, true, "机构纬度" )))
							.addNode(new FieldNode("satStartDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "satStartDate", 50,0, true, "星期六营业开始时间" )))
							.addNode(new FieldNode("satEndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "satEndDate", 50,0, true, "星期六营业终止时间" )))
							.addNode(new FieldNode("sunStartDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "sunStartDate", 50,0, true, "星期天营业开始时间" )))
							.addNode(new FieldNode("sunEndDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "sunEndDate", 50,0, true, "星期天营业终止时间" )))
							.addNode(new FieldNode("cityCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "cityCode", 10,0, true, "城市代码" )))
							.addNode(new FieldNode("cityName", new MsgField(ContentEnum.MessageType.STRING.toString(), "cityName", 20,0, true, "城市名" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

