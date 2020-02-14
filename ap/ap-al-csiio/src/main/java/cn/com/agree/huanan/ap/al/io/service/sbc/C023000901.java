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
 * BASESVC.C023000901 贵金属产品信息查询.查询贵金属产品详细信息 
 * C0230009.01 MT0101
 * 0212 金融互联网服务平台
 * @author XZF
 */
@Component
public class C023000901 extends EsbSbcChannelService {

	private static C023000901_I i = new C023000901_I();
	private static C023000901_O o = new C023000901_O();
	public C023000901() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C023000901_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("pageNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageNo", 10,0, true, "当前页" )))
					.addNode(new FieldNode("pageSize", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageSize", 10,0, true, "每页记录数" )))
					.addNode(new FieldNode("code", new MsgField(ContentEnum.MessageType.STRING.toString(), "code", 20,0, false, "产品编码" )))
					.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 50,0, false, "产品名称" )))
					.addNode(new FieldNode("companyId", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyId", 20,0, false, "公司id" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 2,0, false, "状态" )))
					.addNode(new FieldNode("oprFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprFlag", 1,0, true, "操作标识" )))
					.addNode(new FieldNode("ptType", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptType", 2,0, false, "产品类型" )))
					.addNode(new FieldNode("ptIndex", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptIndex", 10,0, false, "综合排序" )))
					.addNode(new FieldNode("minPrice", new MsgField(ContentEnum.MessageType.STRING.toString(), "minPrice", 10,0, false, "最低价格" )))
					.addNode(new FieldNode("maxPrice", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxPrice", 10,0, false, "最高价格" )))
					.addNode(new FieldNode("sortType", new MsgField(ContentEnum.MessageType.STRING.toString(), "sortType", 1,0, false, "综合排序" )))
					.addNode(new FieldNode("makeType", new MsgField(ContentEnum.MessageType.STRING.toString(), "makeType", 1,0, false, "材质" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C023000901_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("totalSize", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalSize", 10,0, true, "总记录数" )))
					.addNode(new ArrayNode("productList",false)
							.addNode(new FieldNode("id", new MsgField(ContentEnum.MessageType.STRING.toString(), "id", 20,0, true, "产品表ID" )))
							.addNode(new FieldNode("code", new MsgField(ContentEnum.MessageType.STRING.toString(), "code", 20,0, true, "产品编码" )))
							.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 50,0, true, "产品名称" )))
							.addNode(new FieldNode("sortId", new MsgField(ContentEnum.MessageType.STRING.toString(), "sortId", 10,0, true, "产品分类" )))
							.addNode(new FieldNode("type", new MsgField(ContentEnum.MessageType.STRING.toString(), "type", 2,0, true, "产品类型" )))
							.addNode(new FieldNode("companyId", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyId", 20,0, false, "公司标识" )))
							.addNode(new FieldNode("companyNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyNum", 20,0, false, "供应商公司编号" )))
							.addNode(new FieldNode("companyName", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyName", 50,0, false, "供应商公司名称" )))
							.addNode(new FieldNode("createdDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "createdDate", 30,0, false, "创建时间" )))
							.addNode(new FieldNode("creator", new MsgField(ContentEnum.MessageType.STRING.toString(), "creator", 50,0, false, "创建人" )))
							.addNode(new FieldNode("updateTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "updateTime", 50,0, false, "更新时间" )))
							.addNode(new FieldNode("updator", new MsgField(ContentEnum.MessageType.STRING.toString(), "updator", 50,0, false, "更新人" )))
							.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 2,0, false, "产品状态" )))
							.addNode(new FieldNode("files", new MsgField(ContentEnum.MessageType.STRING.toString(), "files", 80,0, false, "产品文件路径" )))
							.addNode(new FieldNode("files1", new MsgField(ContentEnum.MessageType.STRING.toString(), "files1", 80,0, false, "产品照片1路径" )))
							.addNode(new FieldNode("files2", new MsgField(ContentEnum.MessageType.STRING.toString(), "files2", 80,0, false, "产品照片2路径" )))
							.addNode(new FieldNode("files3", new MsgField(ContentEnum.MessageType.STRING.toString(), "files3", 80,0, false, "产品照片3路径" )))
							.addNode(new FieldNode("files4", new MsgField(ContentEnum.MessageType.STRING.toString(), "files4", 80,0, false, "产品照片4路径" )))
							.addNode(new FieldNode("files5", new MsgField(ContentEnum.MessageType.STRING.toString(), "files5", 80,0, false, "产品照片5路径" )))
							.addNode(new FieldNode("files6", new MsgField(ContentEnum.MessageType.STRING.toString(), "files6", 80,0, false, "产品照片6路径" )))
							.addNode(new FieldNode("files7", new MsgField(ContentEnum.MessageType.STRING.toString(), "files7", 80,0, false, "产品照片7路径" )))
							.addNode(new FieldNode("files8", new MsgField(ContentEnum.MessageType.STRING.toString(), "files8", 80,0, false, "产品照片8路径" )))
							.addNode(new FieldNode("files9", new MsgField(ContentEnum.MessageType.STRING.toString(), "files9", 80,0, false, "产品照片8路径" )))
							.addNode(new FieldNode("introdution", new MsgField(ContentEnum.MessageType.STRING.toString(), "introdution", 200,0, false, "产品简介" )))
							.addNode(new FieldNode("price", new MsgField(ContentEnum.MessageType.STRING.toString(), "price", 10,0, false, "单价" )))
							.addNode(new FieldNode("unit", new MsgField(ContentEnum.MessageType.STRING.toString(), "unit", 20,0, false, "价格单位" )))
							.addNode(new FieldNode("startDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "startDate", 20,0, false, "开始日期" )))
							.addNode(new FieldNode("endDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "endDate", 20,0, false, "结束日期" )))
							.addNode(new FieldNode("control", new MsgField(ContentEnum.MessageType.STRING.toString(), "control", 1,0, false, "是否控制库存" )))
							.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "amount", 10,0, false, "发售量" )))
							.addNode(new FieldNode("inComeType", new MsgField(ContentEnum.MessageType.STRING.toString(), "inComeType", 2,0, false, "中收标准" )))
							.addNode(new FieldNode("inCome", new MsgField(ContentEnum.MessageType.STRING.toString(), "inCome", 20,0, false, "中收标准值" )))
							.addNode(new FieldNode("gold", new MsgField(ContentEnum.MessageType.STRING.toString(), "gold", 20,0, false, "材质（金）材料" )))
							.addNode(new FieldNode("silver", new MsgField(ContentEnum.MessageType.STRING.toString(), "silver", 20,0, false, "材质（银）材料" )))
							.addNode(new FieldNode("other", new MsgField(ContentEnum.MessageType.STRING.toString(), "other", 20,0, false, "材质（其他）材料" )))
							.addNode(new FieldNode("index", new MsgField(ContentEnum.MessageType.STRING.toString(), "index", 10,0, false, "排序值" )))
							.addNode(new FieldNode("stock", new MsgField(ContentEnum.MessageType.STRING.toString(), "stock", 20,0, false, "库存" )))
							.addNode(new FieldNode("priceType", new MsgField(ContentEnum.MessageType.STRING.toString(), "priceType", 2,0, false, "价格类型" )))
							.addNode(new FieldNode("platinum", new MsgField(ContentEnum.MessageType.STRING.toString(), "platinum", 20,0, false, "铂金" )))
							.addNode(new FieldNode("kgold", new MsgField(ContentEnum.MessageType.STRING.toString(), "kgold", 20,0, false, "K金" )))
							.addNode(new FieldNode("companyCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyCode", 20,0, false, "公司产品编号" )))
							.addNode(new FieldNode("count", new MsgField(ContentEnum.MessageType.STRING.toString(), "count", 20,0, false, "数量" )))
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 20,0, false, "账号" )))
							.addNode(new FieldNode("yc_sc_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "yc_sc_id", 20,0, false, "购物车id" )))
							.addNode(new FieldNode("yc_cp_number", new MsgField(ContentEnum.MessageType.STRING.toString(), "yc_cp_number", 20,0, false, "公司编号" )))
							.addNode(new FieldNode("pickType", new MsgField(ContentEnum.MessageType.STRING.toString(), "pickType", 2,0, false, "提货方式" )))
							.addNode(new FieldNode("recommend", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommend", 20,0, false, "推荐人编号" )))
							.addNode(new FieldNode("node", new MsgField(ContentEnum.MessageType.STRING.toString(), "node", 20,0, false, "提货网点" )))
							.addNode(new FieldNode("nodeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "nodeName", 50,0, false, "提货网点名称" )))
							.addNode(new FieldNode("pickPhone", new MsgField(ContentEnum.MessageType.STRING.toString(), "pickPhone", 20,0, false, "提货人电话" )))
							.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 10,0, false, "渠道标示" )))
							.addNode(new FieldNode("cstNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstNo", 20,0, false, "用户标示" )))
							.addNode(new FieldNode("receiver1", new MsgField(ContentEnum.MessageType.STRING.toString(), "receiver1", 50,0, false, "网点收货人1" )))
							.addNode(new FieldNode("receiverphone1", new MsgField(ContentEnum.MessageType.STRING.toString(), "receiverphone1", 20,0, false, "网点收货人电话1" )))
							.addNode(new FieldNode("receiver2", new MsgField(ContentEnum.MessageType.STRING.toString(), "receiver2", 50,0, false, "网点收货人2" )))
							.addNode(new FieldNode("receiverphone2", new MsgField(ContentEnum.MessageType.STRING.toString(), "receiverphone2", 20,0, false, "网点收货人电话2" )))
							.addNode(new FieldNode("receiver3", new MsgField(ContentEnum.MessageType.STRING.toString(), "receiver3", 50,0, false, "网点收货人3" )))
							.addNode(new FieldNode("receiverphone3", new MsgField(ContentEnum.MessageType.STRING.toString(), "receiverphone3", 20,0, false, "网点收货人电话3" )))
							.addNode(new FieldNode("payAccount", new MsgField(ContentEnum.MessageType.STRING.toString(), "payAccount", 20,0, false, "付款账号" )))
							.addNode(new FieldNode("payName", new MsgField(ContentEnum.MessageType.STRING.toString(), "payName", 50,0, false, "付款名称" )))
							.addNode(new FieldNode("yc_or_paybatchno", new MsgField(ContentEnum.MessageType.STRING.toString(), "yc_or_paybatchno", 20,0, false, "付款批次号" )))
							.addNode(new FieldNode("yc_or_invoiceid", new MsgField(ContentEnum.MessageType.STRING.toString(), "yc_or_invoiceid", 20,0, false, "发票id" )))
							.addNode(new FieldNode("headType", new MsgField(ContentEnum.MessageType.STRING.toString(), "headType", 1,0, false, "发票抬头类型" )))
							.addNode(new FieldNode("head", new MsgField(ContentEnum.MessageType.STRING.toString(), "head", 50,0, false, "发票抬头" )))
							.addNode(new FieldNode("unitAddress", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitAddress", 100,0, false, "发票单位地址" )))
							.addNode(new FieldNode("openBank", new MsgField(ContentEnum.MessageType.STRING.toString(), "openBank", 50,0, false, "发票开户银行" )))
							.addNode(new FieldNode("invoceType", new MsgField(ContentEnum.MessageType.STRING.toString(), "invoceType", 1,0, false, "发票类型" )))
							.addNode(new FieldNode("taxpayerNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "taxpayerNum", 20,0, false, "发票纳税人识别号" )))
							.addNode(new FieldNode("phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone", 20,0, false, "发票电话号码" )))
							.addNode(new FieldNode("account", new MsgField(ContentEnum.MessageType.STRING.toString(), "account", 20,0, false, "发票银行账号" )))
							.addNode(new FieldNode("prdTypeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "prdTypeName", 50,0, false, "产品类型名称" )))
							.addNode(new FieldNode("sale", new MsgField(ContentEnum.MessageType.STRING.toString(), "sale", 20,0, false, "销售量" )))
							.addNode(new FieldNode("salePrice", new MsgField(ContentEnum.MessageType.STRING.toString(), "salePrice", 20,0, false, "变动售价" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

