package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODAFA1570  柜员指定岗位信息查询 
 *  BODAFA1570 003010
 *  综合前置
 * @author xuzhen
 */
@Component
public class BODAFA1570 extends EciChannelService {
	private static BODAFA1570_I i = new BODAFA1570_I();
	private static BODAFA1570_O o = new BODAFA1570_O();
	public BODAFA1570() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODAFA1570_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
				.addStructNode(new StructNode("APPBody",true,"Body")
				.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
				.addNode(new FieldNode("strbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "strbrno", 10,0, true, "网点号" )))
				.addNode(new FieldNode("dutyFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutyFlag", 1,0, true, "岗位类型标识" )))
				.addNode(new FieldNode("dutyString", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutyString", 1024,0, false, "岗位类型编码" )))
				.addNode(new FieldNode("pageflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageflag", 1,0, false, "翻页标识" )))
				.addNode(new FieldNode("maxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxnum", 6,0, false, "每页最多记录数" )))
				.addNode(new FieldNode("idxstrtellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxstrtellerno", 1024,0, false, "翻页字段" )))
				.addNode(new FieldNode("idxstrdutyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxstrdutyno", 1024,0, false, "翻页字段" )))
				.addNode(new FieldNode("idxtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxtype", 1024,0, false, "翻页字段" )))
				.addNode(new FieldNode("idxstrdutyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxstrdutyno", 1024,0, false, "翻页字段" )))
				);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1570_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
				.addStructNode(new StructNode("Body",true,"APPBody")
				.addNode(new FieldNode("totalnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalnum", 6,0, false, "总记录数" )))
				.addNode(new FieldNode("returnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "returnum", 6,0, false, "本次返回记录数" )))
				.addNode(new ArrayNode("bodrcd",true)
				.addNode(new FieldNode("strtellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "strtellerno", 10,0, false, "行员号" )))
				.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 60,0, false, "行员姓名" )))
				.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 3,0, false, "证件类型" )))
				.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 30,0, false, "证件号码" )))
				.addNode(new FieldNode("sex", new MsgField(ContentEnum.MessageType.STRING.toString(), "sex", 1,0, false, "性别" )))
				.addNode(new FieldNode("tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "tel", 20,0, false, "电话号码" )))
				.addNode(new FieldNode("email", new MsgField(ContentEnum.MessageType.STRING.toString(), "email", 40,0, false, "电子邮箱" )))
				.addNode(new FieldNode("address", new MsgField(ContentEnum.MessageType.STRING.toString(), "address", 100,0, false, "住址" )))
				.addNode(new FieldNode("registdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "registdate", 8,0, false, "注册时间" )))
				.addNode(new FieldNode("canceldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "canceldate", 8,0, false, "注销时间" )))
				.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1,0, false, "注册状态" )))
				.addNode(new FieldNode("idno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idno", 10,0, false, "人事编号" )))
				.addNode(new FieldNode("type", new MsgField(ContentEnum.MessageType.STRING.toString(), "type", 1,0, false, "主辅标识" )))
				.addNode(new FieldNode("realflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "realflag", 1,0, false, "是否实体行员" )))
				.addNode(new FieldNode("strcsbxtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "strcsbxtp", 1,0, false, "钱箱类型" )))
				.addNode(new FieldNode("strcsbxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "strcsbxno", 1,0, false, "钱箱号" )))
				.addNode(new FieldNode("strzoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "strzoneno", 1,0, false, "上岗分行号" )))
				.addNode(new FieldNode("strmbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "strmbrno", 1,0, false, "上岗支行号" )))
				.addNode(new FieldNode("strbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "strbrno", 1,0, false, "上岗网点号" )))
				.addNode(new FieldNode("strdutyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "strdutyno", 1,0, false, "岗位编号" )))
				.addNode(new FieldNode("dutyname", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutyname", 1,0, false, "岗位名称" )))
				.addNode(new FieldNode("propty", new MsgField(ContentEnum.MessageType.STRING.toString(), "propty", 1,0, false, "岗位类型属性" )))
				.addNode(new FieldNode("dutylevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutylevel", 1,0, false, "岗位类型级别" )))
				.addNode(new FieldNode("updutyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "updutyno", 1,0, false, "上级岗位" )))
				.addNode(new FieldNode("branchtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "branchtype", 1,0, false, "机构类型" )))
				));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	@Override
	public void initContent(Map<String, Object> tradeContext) {
		Map<String, Object> appHeader = (Map<String, Object>) tradeContext.get(CommConstant.APP_HEADER);
		Map<String, Object> csisHeader = (Map<String, Object>) tradeContext.get(CommConstant.CSIS_HEADER);
		appHeader.put("xmlflag", "1");
		appHeader.put("templateCodeName", "teller");
		appHeader.put("transCode", "003010");
		appHeader.put("sysId", "00");
		appHeader.put("channelCode", "011");
		appHeader.put("tradeFlag", "0");
		appHeader.put("checkFlag", "0");
		appHeader.put("prcscd", "003010");
		appHeader.put("subchannelCode", csisHeader.get("SrcCalCod"));
		super.initContent(tradeContext);
	}
}

