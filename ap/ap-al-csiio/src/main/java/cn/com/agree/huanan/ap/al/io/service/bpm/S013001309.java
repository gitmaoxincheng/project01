package cn.com.agree.huanan.ap.al.io.service.bpm;

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
 * S0130013.09 机构信息查询  交易码：branch_query
 * @author lixq 
 */
@Component
public class S013001309 extends EsbChannelService {

	private static S013001309_I i = new S013001309_I();
	private static S013001309_O o = new S013001309_O();
	public S013001309() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	
	public static class S013001309_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			
			StructNode BODY = new StructNode("APPBody");
			FieldNode brno = new FieldNode("brno", new MsgField(ContentEnum.MessageType.STRING.toString(), "brno", 10,0, true, "机构号"));
			FieldNode mybank = new FieldNode("mybank", new MsgField(ContentEnum.MessageType.STRING.toString(), "mybank", 3,0, true, "法人号" ));
			BODY.addNode(brno);
			BODY.addNode(mybank);
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
	
	public static class S013001309_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			StructNode  BODY= new StructNode("APPBody");
			BODY.addNode(new FieldNode("mybank", new MsgField(ContentEnum.MessageType.STRING.toString(), "mybank", 3,0, false, "法人号")));
			BODY.addNode(new FieldNode("brno", new MsgField(ContentEnum.MessageType.STRING.toString(), "brno", 10,0, false, "机构号")));
			BODY.addNode(new FieldNode("obrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "obrno", 10,0, false, "旧机构号")));
			BODY.addNode(new FieldNode("brnas", new MsgField(ContentEnum.MessageType.STRING.toString(), "brnas", 200,0, false, "机构简称")));
			BODY.addNode(new FieldNode("brsta", new MsgField(ContentEnum.MessageType.STRING.toString(), "brsta", 1,0, false, "机构状态")));
			BODY.addNode(new FieldNode("brna", new MsgField(ContentEnum.MessageType.STRING.toString(), "brna", 200,0, false, "机构全称")));
			BODY.addNode(new FieldNode("enbrna", new MsgField(ContentEnum.MessageType.STRING.toString(), "enbrna", 200,0, false, "机构英文全称")));
			BODY.addNode(new FieldNode("brgp", new MsgField(ContentEnum.MessageType.STRING.toString(), "brgp", 1,0, false, "机构分类")));
			BODY.addNode(new FieldNode("brpry", new MsgField(ContentEnum.MessageType.STRING.toString(), "brpry", 1,0, false, "机构性质")));
			BODY.addNode(new FieldNode("brtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "brtp", 1,0, false, "机构类型-社区小微")));
			BODY.addNode(new FieldNode("braddrpro", new MsgField(ContentEnum.MessageType.STRING.toString(), "braddrpro", 6,0, false, "机构地址所在省")));
			BODY.addNode(new FieldNode("braddrcy", new MsgField(ContentEnum.MessageType.STRING.toString(), "braddrcy", 10,0, false, "机构地址所在市")));
			BODY.addNode(new FieldNode("braddrar", new MsgField(ContentEnum.MessageType.STRING.toString(), "braddrar", 6,0, false, "机构地址所在区/镇")));
			BODY.addNode(new FieldNode("brallowc", new MsgField(ContentEnum.MessageType.STRING.toString(), "brallowc", 30,0, false, "金融机构许可证")));
			BODY.addNode(new FieldNode("brcodc", new MsgField(ContentEnum.MessageType.STRING.toString(), "brcodc", 30,0, false, "金融机构代码证")));
			BODY.addNode(new FieldNode("batcodc", new MsgField(ContentEnum.MessageType.STRING.toString(), "batcodc", 30,0, false, "统一信用代码证")));
			BODY.addNode(new FieldNode("busta", new MsgField(ContentEnum.MessageType.STRING.toString(), "busta", 2,0, false, "营业状态")));
			BODY.addNode(new FieldNode("long", new MsgField(ContentEnum.MessageType.STRING.toString(), "long", 60,0, false, "机构经度")));
			BODY.addNode(new FieldNode("lang", new MsgField(ContentEnum.MessageType.STRING.toString(), "lang", 60,0, false, "机构纬度")));
			
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
}
