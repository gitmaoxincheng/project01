package cn.com.agree.huanan.ap.al.io.service.sds;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbSdsChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.S012000705 集中作业管理.移动营销集中授权 
 * S0120007.05 CentAuto
 * 0209 集中业务处理平台
 * @author XZF
 */
@Component
public class S012000705 extends EsbSdsChannelService {

	private static S012000705_I i = new S012000705_I();
	private static S012000705_O o = new S012000705_O();
	public S012000705() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S012000705_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("TRADECODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "TRADECODE", 10,0, true, "交易码" )))
					.addNode(new FieldNode("PRODUCTID", new MsgField(ContentEnum.MessageType.STRING.toString(), "PRODUCTID", 10,0, true, "产品码" )))
					.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 256,0, true, "客户姓名" )))
					.addNode(new FieldNode("gender", new MsgField(ContentEnum.MessageType.STRING.toString(), "gender", 1,0, true, "性别" )))
					.addNode(new FieldNode("age", new MsgField(ContentEnum.MessageType.STRING.toString(), "age", 10,0, true, "年龄" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 2,0, true, "证件类型" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, true, "证件号码" )))
					.addNode(new FieldNode("inefdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "inefdt", 8,0, true, "证件有效期" )))
					.addNode(new FieldNode("facerecovalue", new MsgField(ContentEnum.MessageType.STRING.toString(), "facerecovalue", 256,0, true, "人脸识别匹配值" )))
					.addNode(new FieldNode("facerecoremark", new MsgField(ContentEnum.MessageType.STRING.toString(), "facerecoremark", 512,0, false, "人脸识别备注" )))
					.addNode(new ArrayNode("autolist",false)
							.addNode(new FieldNode("autoxuhao", new MsgField(ContentEnum.MessageType.STRING.toString(), "autoxuhao", 30,0, false, "序号" )))
							.addNode(new FieldNode("autoresult", new MsgField(ContentEnum.MessageType.STRING.toString(), "autoresult", 1,0, false, "授权结果" )))
							.addNode(new FieldNode("autonopassmsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "autonopassmsg", 512,0, false, "授权不通过原因" )))
							.addNode(new FieldNode("tradename", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradename", 80,0, true, "交易名称" )))
							.addNode(new FieldNode("detailmessage", new MsgField(ContentEnum.MessageType.STRING.toString(), "detailmessage", 1024,0, true, "详细信息" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S012000705_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("TRADECODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "TRADECODE", 10,0, true, "交易码" )))
					.addNode(new FieldNode("PRODUCTID", new MsgField(ContentEnum.MessageType.STRING.toString(), "PRODUCTID", 10,0, true, "产品码" )))
					.addNode(new FieldNode("custna", new MsgField(ContentEnum.MessageType.STRING.toString(), "custna", 256,0, true, "客户姓名" )))
					.addNode(new FieldNode("gender", new MsgField(ContentEnum.MessageType.STRING.toString(), "gender", 1,0, true, "性别" )))
					.addNode(new FieldNode("age", new MsgField(ContentEnum.MessageType.STRING.toString(), "age", 10,0, true, "年龄" )))
					.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 2,0, true, "证件类型" )))
					.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, true, "证件号码" )))
					.addNode(new FieldNode("inefdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "inefdt", 8,0, true, "证件有效期" )))
					.addNode(new FieldNode("facerecovalue", new MsgField(ContentEnum.MessageType.STRING.toString(), "facerecovalue", 256,0, true, "人脸识别匹配值" )))
					.addNode(new FieldNode("facerecoremark", new MsgField(ContentEnum.MessageType.STRING.toString(), "facerecoremark", 512,0, false, "人脸识别备注" )))
					.addNode(new ArrayNode("autolist",false)
							.addNode(new FieldNode("autoxuhao", new MsgField(ContentEnum.MessageType.STRING.toString(), "autoxuhao", 30,0, false, "序号" )))
							.addNode(new FieldNode("autoresult", new MsgField(ContentEnum.MessageType.STRING.toString(), "autoresult", 1,0, false, "授权结果" )))
							.addNode(new FieldNode("autonopassmsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "autonopassmsg", 512,0, false, "授权不通过原因" )))
							.addNode(new FieldNode("tradename", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradename", 80,0, true, "交易名称" )))
							.addNode(new FieldNode("detailmessage", new MsgField(ContentEnum.MessageType.STRING.toString(), "detailmessage", 1024,0, true, "详细信息" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

