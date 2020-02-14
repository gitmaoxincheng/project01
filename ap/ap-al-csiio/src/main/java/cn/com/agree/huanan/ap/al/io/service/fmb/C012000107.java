package cn.com.agree.huanan.ap.al.io.service.fmb;

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
 * BASESVC.C012000107 客户信息管理.批量开户个人信息采集 
 * C0120001.07 8819701
 * 0339 综合前置(微网点模块)
 * @author GYL
 */
@Component
public class C012000107 extends EsbChannelService {

	private static C012000107_I i = new C012000107_I();
	private static C012000107_O o = new C012000107_O();
	public C012000107() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class C012000107_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
.addNode(new FieldNode("PhotoP", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhotoP", 100,0, false, "拍摄人像面" )))
.addNode(new FieldNode("PhotoG", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhotoG", 100,0, false, "拍摄国徽面" )))
.addNode(new FieldNode("PhotoF", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhotoF", 100,0, false, "拍摄人脸" )))
.addNode(new FieldNode("PeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "PeName", 20,0, true, "姓名" )))
.addNode(new FieldNode("idtftp", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtftp", 2,0, true, "证件类型" )))
.addNode(new FieldNode("idtfno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtfno", 30,0, true, "证件号码" )))
.addNode(new FieldNode("Gender", new MsgField(ContentEnum.MessageType.STRING.toString(), "Gender", 1,0, true, "性别" )))
.addNode(new FieldNode("IdAddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdAddr", 256,0, true, "户籍地址" )))
.addNode(new FieldNode("inefdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "inefdt", 8,0, true, "证件失效日期" )))
.addNode(new FieldNode("efctdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "efctdt", 8,0, true, "证件生效日期" )))
.addNode(new FieldNode("cutycd", new MsgField(ContentEnum.MessageType.STRING.toString(), "cutycd", 3,0, true, "国籍" )))
.addNode(new FieldNode("mobitl", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobitl", 20,0, true, "手机号码" )))
.addNode(new FieldNode("ProFee", new MsgField(ContentEnum.MessageType.STRING.toString(), "ProFee", 5,0, true, "职业" )))
.addNode(new FieldNode("OthPro", new MsgField(ContentEnum.MessageType.STRING.toString(), "OthPro", 50,0, false, "其他职业描述" )))
.addNode(new FieldNode("IsPubl", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsPubl", 1,0, true, "是否对公业务" )))
.addNode(new FieldNode("TaxSta", new MsgField(ContentEnum.MessageType.STRING.toString(), "TaxSta", 2,0, true, "税收居民身份" )))
.addNode(new FieldNode("addres", new MsgField(ContentEnum.MessageType.STRING.toString(), "addres", 256,0, true, "通讯地址" )))
.addNode(new FieldNode("ComName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ComName", 256,0, true, "企业名称" )))
.addNode(new FieldNode("contentno", new MsgField(ContentEnum.MessageType.STRING.toString(), "contentno", 256,0, true, "文件批次号" )))
.addNode(new FieldNode("modelno", new MsgField(ContentEnum.MessageType.STRING.toString(), "modelno", 20,0, false, "模板名称" )))
.addNode(new FieldNode("busistartdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "busistartdate", 20,0, true, "影像上传时间" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C012000107_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
.addNode(new FieldNode("RequNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "RequNo", 50,0, false, "申请编号" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

