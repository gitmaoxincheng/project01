package cn.com.agree.huanan.ap.al.io.service.bls;

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
 * TRDCENTER.C013001901 名单信息.名单信息查询 
 * C0130019.01 bls1001
 * 0110 黑名单系统
 * @author XZF
 */
@Component
public class C013001901 extends EsbChannelService {

	private static C013001901_I i = new C013001901_I();
	private static C013001901_O o = new C013001901_O();
	public C013001901() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C013001901_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("request_list",false)
					.addNode(new FieldNode("biztypecode", new MsgField(ContentEnum.MessageType.STRING.toString(), "biztypecode", 8,0, true, "业务类型编码" )))
					.addNode(new FieldNode("searchway", new MsgField(ContentEnum.MessageType.STRING.toString(), "searchway", 8,0, true, "检索方式及维度开关" )))
					.addNode(new FieldNode("blatype", new MsgField(ContentEnum.MessageType.STRING.toString(), "blatype", 1,0, false, "名单客户类型" )))
					.addNode(new FieldNode("content", new MsgField(ContentEnum.MessageType.STRING.toString(), "content", 500,0, false, "待检索内容" )))
					.addNode(new FieldNode("namecontent", new MsgField(ContentEnum.MessageType.STRING.toString(), "namecontent", 200,0, false, "名称内容" )))
					.addNode(new FieldNode("addrcontent", new MsgField(ContentEnum.MessageType.STRING.toString(), "addrcontent", 300,0, false, "地址内容" )))
					.addNode(new FieldNode("idcontent", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcontent", 32,0, false, "证件内容" )))
					.addNode(new FieldNode("countrycontent", new MsgField(ContentEnum.MessageType.STRING.toString(), "countrycontent", 32,0, false, "国家内容" )))
					.addNode(new FieldNode("cptysaccno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptysaccno", 32,0, false, "交易对手账号" )))
					.addNode(new FieldNode("cptysname", new MsgField(ContentEnum.MessageType.STRING.toString(), "cptysname", 32,0, false, "交易对手行名称" )))
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C013001901_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
				.addNode(new FieldNode("respcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "respcode", 5,0, true, "检索结果" )))
				.addNode(new FieldNode("respmsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "respmsg", 200,0, true, "检索信息" )))
				.addNode(new ArrayNode("response_list",false)
						.addNode(new FieldNode("oribiztypecode", new MsgField(ContentEnum.MessageType.STRING.toString(), "oribiztypecode", 8,0, true, "原业务类型编码" )))
						.addNode(new ArrayNode("listtypeinfo_list",false)
								.addNode(new FieldNode("listtypecode", new MsgField(ContentEnum.MessageType.STRING.toString(), "listtypecode", 4,0, false, "名单类型编码" )))
								.addNode(new FieldNode("listtypename", new MsgField(ContentEnum.MessageType.STRING.toString(), "listtypename", 32,0, false, "名单类型名称" )))
								.addNode(new FieldNode("risklevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "risklevel", 2,0, false, "该名单类型匹配结果" )))
						).addNode(new FieldNode("maxrisklevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxrisklevel", 1,0, false, "最高风险等级" )))
						.addNode(new FieldNode("recordid", new MsgField(ContentEnum.MessageType.STRING.toString(), "recordid", 32,0, false, "检索结果ID" )))
						.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark", 80,0, false, "备注" )))
						).addNode(new ArrayNode("listtypeinfo_list",false)
								.addNode(new FieldNode("listtypecode", new MsgField(ContentEnum.MessageType.STRING.toString(), "listtypecode", 4,0, false, "名单类型编码" )))
								.addNode(new FieldNode("listtypename", new MsgField(ContentEnum.MessageType.STRING.toString(), "listtypename", 32,0, false, "名单类型名称" )))
								.addNode(new FieldNode("risklevel", new MsgField(ContentEnum.MessageType.STRING.toString(), "risklevel", 2,0, false, "该名单类型匹配结果" )))
						));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}