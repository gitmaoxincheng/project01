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
 * BASESVC.C023001101 贵金属订单查询.贵金属订单信息查询 
 * C0230011.01 MT0202
 * 0212 金融互联网服务平台
 * @author XZF
 */
@Component
public class C023001101 extends EsbSbcChannelService {

	private static C023001101_I i = new C023001101_I();
	private static C023001101_O o = new C023001101_O();
	public C023001101() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C023001101_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("pageNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageNo", 10,0, true, "当前页" )))
					.addNode(new FieldNode("pageSize", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageSize", 10,0, true, "每页记录数" )))
					.addNode(new FieldNode("cstNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstNo", 20,0, false, "客户号" )))
					.addNode(new FieldNode("cifNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "cifNo", 50,0, true, "核心客户号" )))
					.addNode(new FieldNode("oprFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprFlag", 10,0, true, "操作标示" )))
					.addNode(new ArrayNode("ordStatusList",false)
							.addNode(new FieldNode("ordStatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "ordStatus", 10,0, false, "订单流转状态" )))
							)
					.addNode(new ArrayNode("payStatusList",false)
							.addNode(new FieldNode("payStatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "payStatus", 10,0, false, "订单支付状态" )))
							)
					.addNode(new ArrayNode("orderNumList",false)
							.addNode(new FieldNode("orderNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "orderNum", 50,0, false, "订单号" )))
							)
					.addNode(new FieldNode("startDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "startDate", 50,0, false, "开始时间" )))
					.addNode(new FieldNode("endDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "endDate", 50,0, false, "结束时间" )))
					.addNode(new FieldNode("condition", new MsgField(ContentEnum.MessageType.STRING.toString(), "condition", 50,0, false, "查询条件" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C023001101_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("totalSize", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalSize", 10,0, true, "总记录数" )))
					.addNode(new ArrayNode("orderList",false)
							.addNode(new FieldNode("id", new MsgField(ContentEnum.MessageType.STRING.toString(), "id", 50,0, true, "订单表ID" )))
							.addNode(new FieldNode("orderNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "orderNo", 50,0, true, "订单编号" )))
							.addNode(new FieldNode("createDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "createDate", 50,0, true, "订单日期" )))
							.addNode(new FieldNode("companyId", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyId", 50,0, true, "公司ID" )))
							.addNode(new FieldNode("cstNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstNo", 20,0, true, "客户号" )))
							.addNode(new FieldNode("code", new MsgField(ContentEnum.MessageType.STRING.toString(), "code", 20,0, true, "产品编号" )))
							.addNode(new FieldNode("companyName", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyName", 50,0, true, "供应商公司名称" )))
							.addNode(new FieldNode("companyCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "companyCode", 20,0, true, "公司编号" )))
							.addNode(new FieldNode("productId", new MsgField(ContentEnum.MessageType.STRING.toString(), "productId", 50,0, true, "产品ID" )))
							.addNode(new FieldNode("productName", new MsgField(ContentEnum.MessageType.STRING.toString(), "productName", 50,0, true, "产品名称" )))
							.addNode(new FieldNode("count", new MsgField(ContentEnum.MessageType.STRING.toString(), "count", 10,0, true, "购买数量" )))
							.addNode(new FieldNode("price", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "price", 19,2, true, "产品单价" )))
							.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "amount", 19,2, true, "购买总价" )))
							.addNode(new FieldNode("recommend", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommend", 20,0, true, "推荐人编号" )))
							.addNode(new FieldNode("pickType", new MsgField(ContentEnum.MessageType.STRING.toString(), "pickType", 10,0, true, "提货类型" )))
							.addNode(new FieldNode("pickPhone", new MsgField(ContentEnum.MessageType.STRING.toString(), "pickPhone", 20,0, true, "提货人电话" )))
							.addNode(new FieldNode("node", new MsgField(ContentEnum.MessageType.STRING.toString(), "node", 10,0, true, "提货网点" )))
							.addNode(new FieldNode("nodeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "nodeName", 50,0, true, "提货网点名称" )))
							.addNode(new FieldNode("recever1", new MsgField(ContentEnum.MessageType.STRING.toString(), "recever1", 20,0, true, "网点收货人1" )))
							.addNode(new FieldNode("receverPhone1", new MsgField(ContentEnum.MessageType.STRING.toString(), "receverPhone1", 20,0, true, "网点收货人电话1" )))
							.addNode(new FieldNode("recever2", new MsgField(ContentEnum.MessageType.STRING.toString(), "recever2", 20,0, true, "网点收货人2" )))
							.addNode(new FieldNode("receverPhone2", new MsgField(ContentEnum.MessageType.STRING.toString(), "receverPhone2", 20,0, true, "网点收货人电话2" )))
							.addNode(new FieldNode("ordStatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "ordStatus", 10,0, true, "订单流转状态" )))
							.addNode(new FieldNode("payStatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "payStatus", 10,0, true, "订单付款状态" )))
							.addNode(new FieldNode("trackNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "trackNum", 20,0, true, "快递编号" )))
							.addNode(new FieldNode("headType", new MsgField(ContentEnum.MessageType.STRING.toString(), "headType", 20,0, true, "抬头类型" )))
							.addNode(new FieldNode("type", new MsgField(ContentEnum.MessageType.STRING.toString(), "type", 20,0, true, "发票类型" )))
							.addNode(new FieldNode("head", new MsgField(ContentEnum.MessageType.STRING.toString(), "head", 20,0, true, "抬头" )))
							.addNode(new FieldNode("taxPayernum", new MsgField(ContentEnum.MessageType.STRING.toString(), "taxPayernum", 20,0, true, "纳税人识别号" )))
							.addNode(new FieldNode("unitAddress", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitAddress", 100,0, true, "单位地址" )))
							.addNode(new FieldNode("phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone", 20,0, true, "电话号码" )))
							.addNode(new FieldNode("openBank", new MsgField(ContentEnum.MessageType.STRING.toString(), "openBank", 20,0, true, "开户银行" )))
							.addNode(new FieldNode("account", new MsgField(ContentEnum.MessageType.STRING.toString(), "account", 20,0, true, "银行账号" )))
							.addNode(new FieldNode("productTypeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "productTypeName", 20,0, true, "产品类型名称" )))
							.addNode(new FieldNode("gold", new MsgField(ContentEnum.MessageType.STRING.toString(), "gold", 10,0, true, "材质（金）材料" )))
							.addNode(new FieldNode("silver", new MsgField(ContentEnum.MessageType.STRING.toString(), "silver", 10,0, true, "材质（银）材料" )))
							.addNode(new FieldNode("platinum", new MsgField(ContentEnum.MessageType.STRING.toString(), "platinum", 10,0, true, "铂金" )))
							.addNode(new FieldNode("kgold", new MsgField(ContentEnum.MessageType.STRING.toString(), "kgold", 10,0, true, "K金" )))
							.addNode(new FieldNode("other", new MsgField(ContentEnum.MessageType.STRING.toString(), "other", 10,0, true, "材质（其他）材料" )))
							.addNode(new FieldNode("stock", new MsgField(ContentEnum.MessageType.STRING.toString(), "stock", 20,0, true, "库存" )))
							.addNode(new FieldNode("control", new MsgField(ContentEnum.MessageType.STRING.toString(), "control", 20,0, true, "是否控制库存" )))
							.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 100,0, true, "图片URL" )))
							).addNode(new FieldNode("errorCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "errorCode", 50,0, true, "错误码" )))
					.addNode(new FieldNode("errorMsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "errorMsg", 100,0, true, "错误信息" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

