package cn.com.agree.huanan.ap.al.io.service.ocr;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.service.ocr.S012000411.S012000411_I;
import cn.com.agree.huanan.ap.al.io.service.ocr.S012000411.S012000411_O;
import cn.com.agree.huanan.ap.al.io.system.esb.EsbOcrChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * TRDCENTER.S012000412 OCR影像信息识别.税务登记证识别 
 * S0120004-12:tz0003
 * 0198 光学字符识别系统
 * @author chents
 */
@Component
public class S012000412 extends EsbOcrChannelService{

	private static S012000411_I i = new S012000411_I();
	private static S012000411_O o = new S012000411_O();
	public S012000412() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S012000411_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("ImgBs", new MsgField(ContentEnum.MessageType.STRING.toString(), "ImgBs", 1843200,0, true, "jpg/jpeg格式的待识别图片" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S012000411_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("IdtfTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdtfTp", 64,0, false, "公司证照类型" )))
					.addNode(new FieldNode("CompNa", new MsgField(ContentEnum.MessageType.STRING.toString(), "CompNa", 256,0, false, "名称" )))
					.addNode(new FieldNode("CustNa", new MsgField(ContentEnum.MessageType.STRING.toString(), "CustNa", 256,0, false, "法定代表人" )))
					.addNode(new FieldNode("CompTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "CompTp", 120,0, false, "类型" )))
					.addNode(new FieldNode("Addres", new MsgField(ContentEnum.MessageType.STRING.toString(), "Addres", 256,0, false, "住所" )))
					.addNode(new FieldNode("BScope", new MsgField(ContentEnum.MessageType.STRING.toString(), "BScope", 256,0, false, "经营范围" )))
					.addNode(new FieldNode("RgCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "RgCode", 32,0, false, "注册号" )))
					.addNode(new FieldNode("IdtfNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdtfNo", 32,0, false, "证照编号" )))
					.addNode(new FieldNode("RegAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "RegAmt", 120,0, false, "注册资本" )))
					.addNode(new FieldNode("ReaAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReaAmt", 120,0, false, "实收资本" )))
					.addNode(new FieldNode("OrgiNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "OrgiNo", 32,0, false, "组织机构代码证号" )))
					.addNode(new FieldNode("BtaxNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BtaxNo", 32,0, false, "税务登记证号" )))
					.addNode(new FieldNode("EfctDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "EfctDt", 20,0, false, "营业期限自" )))
					.addNode(new FieldNode("InefDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "InefDt", 20,0, false, "营业期限至" )))
					.addNode(new FieldNode("EfInDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "EfInDt", 40,0, false, "营业期限" )))
					.addNode(new FieldNode("RgIssu", new MsgField(ContentEnum.MessageType.STRING.toString(), "RgIssu", 256,0, false, "登记机关" )))
					.addNode(new FieldNode("RgDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "RgDate", 20,0, false, "核准日期" )))
					.addNode(new FieldNode("CretDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "CretDt", 20,0, false, "成立日期" )))
					.addNode(new FieldNode("BStatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "BStatus", 20,0, false, "登记状态" )))
					.addNode(new FieldNode("BuDuty", new MsgField(ContentEnum.MessageType.STRING.toString(), "BuDuty", 32,0, false, "扣缴义务" )))
					.addNode(new FieldNode("TPpNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TPpNum", 32,0, false, "纳税人编码" )))
					.addNode(new FieldNode("TNaNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TNaNum", 32,0, false, "国税纳税编码" )))
					.addNode(new FieldNode("TLoNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TLoNum", 32,0, false, "地税纳税编码" )))
					.addNode(new FieldNode("DocNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "DocNum", 32,0, false, "档案号" )))
					.addNode(new FieldNode("CdVlDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "CdVlDt", 20,0, false, "有效期" )))
					.addNode(new FieldNode("Issuer", new MsgField(ContentEnum.MessageType.STRING.toString(), "Issuer", 256,0, false, "颁发单位" )))
					.addNode(new FieldNode("CdCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "CdCode", 32,0, false, "统一社会信用代码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}


}





























