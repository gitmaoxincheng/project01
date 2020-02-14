package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciF10ChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODF510314  预填单字段信息查询反显/查询列表/修改/删除 
 *  BODF510314 regflw
 *  综合前置
 * @author LSJ
 */
@Component
public class BODF510314 extends EciF10ChannelService {

	private static BODF510314_I i = new BODF510314_I();
	private static BODF510314_O o = new BODF510314_O();
	public BODF510314() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF510314_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("gsdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsdm", 4,0, true, "公司代码" )))
					.addNode(new FieldNode("cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpdm", 10,0, true, "产品代码" )))
					.addNode(new FieldNode("ytdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ytdh", 30,0, true, "预填单号" )))
					.addNode(new FieldNode("ytdhFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ytdhFlag", 1,0, true, "预填单标志" )))
					.addNode(new FieldNode("fieldLabel", new MsgField(ContentEnum.MessageType.STRING.toString(), "fieldLabel", 50,0, false, "字段名称(查询条件)" )))
					.addNode(new FieldNode("modifyLabel", new MsgField(ContentEnum.MessageType.STRING.toString(), "modifyLabel", 50,0, false, "字段名称(更新字段值)" )))
					.addNode(new FieldNode("fieldName", new MsgField(ContentEnum.MessageType.STRING.toString(), "fieldName", 20,0, true, "字段属性" )))
					.addNode(new FieldNode("fieldValue", new MsgField(ContentEnum.MessageType.STRING.toString(), "fieldValue", 250,0, false, "字段值" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 10,0, true, "列表起始值" )))
					.addNode(new FieldNode("QueryNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "QueryNum", 10,0, true, "每页最大行数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF510314_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("ytdhFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ytdhFlag", 1,0, true, "预填单标志" )))
					.addNode(new FieldNode("ytdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ytdh", 30,0, true, "预填单号" )))
					.addNode(new FieldNode("fieldName", new MsgField(ContentEnum.MessageType.STRING.toString(), "fieldName", 20,0, true, "字段属性" )))
					.addNode(new FieldNode("fieldType", new MsgField(ContentEnum.MessageType.STRING.toString(), "fieldType", 20,0, true, "字段类型" )))
					.addNode(new FieldNode("fieldValue", new MsgField(ContentEnum.MessageType.STRING.toString(), "fieldValue", 250,0, true, "字段值" )))
					.addNode(new FieldNode("fieldLabel", new MsgField(ContentEnum.MessageType.STRING.toString(), "fieldLabel", 50,0, true, "字段标签" )))
					.addNode(new FieldNode("jsonstr", new MsgField(ContentEnum.MessageType.STRING.toString(), "jsonstr", 256,0, true, "预填单JSON数据" )))
					.addNode(new FieldNode("fieldNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "fieldNum", 5,0, true, "预填单记录数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

