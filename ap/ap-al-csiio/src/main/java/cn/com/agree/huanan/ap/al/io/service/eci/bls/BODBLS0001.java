package cn.com.agree.huanan.ap.al.io.service.eci.bls;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODBLS0001  黑名单检索请求接口 
 *  BODBLS0001 8811001
 *  黑名单系统
 * @author XZF
 */
@Component
public class BODBLS0001 extends EciChannelService {

	private static BODBLS0001_I i = new BODBLS0001_I();
	private static BODBLS0001_O o = new BODBLS0001_O();
	public BODBLS0001() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODBLS0001_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("chnl_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "chnl_dt", 8,0, true, "请求日期" )))
					.addNode(new FieldNode("chnl_tm", new MsgField(ContentEnum.MessageType.STRING.toString(), "chnl_tm", 6,0, true, "请求时间" )))
					.addNode(new FieldNode("host_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "host_seq", 32,0, true, "检索用户id" )))
					.addNode(new FieldNode("snd_chnl_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "snd_chnl_no", 2,0, true, "来源系统" )))
					.addNode(new FieldNode("bank_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "bank_id", 32,0, false, "检索机构" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 2,0, true, "循环记录数" )))
					.addNode(new StructNode("bodrcd",true)
							.addNode(new FieldNode("reqSeq", new MsgField(ContentEnum.MessageType.STRING.toString(), "reqSeq", 32,0, true, "请求流水号" )))
							.addNode(new FieldNode("bizId", new MsgField(ContentEnum.MessageType.STRING.toString(), "bizId", 32,0, false, "请求业务ID" )))
							.addNode(new FieldNode("ownOrgCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ownOrgCode", 32,0, false, "业务归属机构" )))
							.addNode(new FieldNode("ioFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ioFlag", 2,0, false, "收发标志" )))
							.addNode(new FieldNode("type", new MsgField(ContentEnum.MessageType.STRING.toString(), "type", 7,0, true, "检索类型开关" )))
							.addNode(new FieldNode("dataSources", new MsgField(ContentEnum.MessageType.STRING.toString(), "dataSources", 32,0, false, "指定数据源" )))
							.addNode(new FieldNode("dangerType", new MsgField(ContentEnum.MessageType.STRING.toString(), "dangerType", 32,0, false, "限定要检索的黑名单等级类型" )))
							.addNode(new FieldNode("mixedDesc", new MsgField(ContentEnum.MessageType.STRING.toString(), "mixedDesc", 32,0, false, "分级" )))
							.addNode(new FieldNode("blackDesc1", new MsgField(ContentEnum.MessageType.STRING.toString(), "blackDesc1", 32,0, false, "黑名单一级细分" )))
							.addNode(new FieldNode("blackDesc2", new MsgField(ContentEnum.MessageType.STRING.toString(), "blackDesc2", 32,0, false, "黑名单二级细分" )))
							.addNode(new FieldNode("blackDesc3", new MsgField(ContentEnum.MessageType.STRING.toString(), "blackDesc3", 32,0, false, "黑名单三级细分" )))
							.addNode(new FieldNode("references", new MsgField(ContentEnum.MessageType.STRING.toString(), "references", 128,0, false, "制裁来源" )))
							.addNode(new FieldNode("customerNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "customerNo", 32,0, false, "行内客户号" )))
							.addNode(new FieldNode("bizCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "bizCode", 32,0, false, "交易编号" )))
							.addNode(new FieldNode("bankCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankCode", 32,0, false, "对方行银行代码" )))
							.addNode(new FieldNode("accountNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "accountNo", 32,0, false, "对方行客户的账号" )))
							.addNode(new FieldNode("gender", new MsgField(ContentEnum.MessageType.STRING.toString(), "gender", 2,0, false, "可指定检索的名单性别" )))
							.addNode(new FieldNode("blaType", new MsgField(ContentEnum.MessageType.STRING.toString(), "blaType", 2,0, false, "可指定检索范围为实体机构或个人信息" )))
							.addNode(new FieldNode("bicCodes", new MsgField(ContentEnum.MessageType.STRING.toString(), "bicCodes", 128,0, false, "银行BIC码" )))
							.addNode(new FieldNode("area", new MsgField(ContentEnum.MessageType.STRING.toString(), "area", 32,0, false, "指定检索区域" )))
							.addNode(new FieldNode("content", new MsgField(ContentEnum.MessageType.STRING.toString(), "content", 200,0, false, "检索内容" )))
							.addNode(new FieldNode("nameContent", new MsgField(ContentEnum.MessageType.STRING.toString(), "nameContent", 32,0, false, "名称检索块" )))
							.addNode(new FieldNode("addrContent", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrContent", 128,0, false, "地址检索块" )))
							.addNode(new FieldNode("stateContent", new MsgField(ContentEnum.MessageType.STRING.toString(), "stateContent", 64,0, false, "国家检索块" )))
							.addNode(new FieldNode("selamlchkflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "selamlchkflag", 64,0, false, "反洗钱校验标志" )))
							.addNode(new FieldNode("idTypeContent", new MsgField(ContentEnum.MessageType.STRING.toString(), "idTypeContent", 128,0, false, "证件类型" )))
							.addNode(new FieldNode("idContent", new MsgField(ContentEnum.MessageType.STRING.toString(), "idContent", 128,0, false, "证件检索块" )))
							.addNode(new FieldNode("birthContent", new MsgField(ContentEnum.MessageType.STRING.toString(), "birthContent", 64,0, false, "生日检索块" )))
							.addNode(new FieldNode("otherContent", new MsgField(ContentEnum.MessageType.STRING.toString(), "otherContent", 128,0, false, "其他信息检索块" )))
							.addNode(new FieldNode("messageRef", new MsgField(ContentEnum.MessageType.STRING.toString(), "messageRef", 64,0, false, "业务参考号" )))
							.addNode(new FieldNode("currency", new MsgField(ContentEnum.MessageType.STRING.toString(), "currency", 32,0, true, "业务币种" )))
							.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "amount", 16,0, false, "业务金额" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODBLS0001_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 2,0, true, "循环记录数" )))
					.addNode(new StructNode("bodrcd",true)
							.addNode(new FieldNode("reqseq", new MsgField(ContentEnum.MessageType.STRING.toString(), "reqseq", 32,0, true, "请求流水号" )))
							.addNode(new FieldNode("resultCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "resultCode", 2,0, true, "检索结果代码" )))
							.addNode(new FieldNode("resultInfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "resultInfo", 32,0, true, "检索结果" )))
							.addNode(new FieldNode("levelCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "levelCode", 2,0, false, "侦测等级名称" )))
							.addNode(new FieldNode("recordId", new MsgField(ContentEnum.MessageType.STRING.toString(), "recordId", 32,0, true, "检索结果ID" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

