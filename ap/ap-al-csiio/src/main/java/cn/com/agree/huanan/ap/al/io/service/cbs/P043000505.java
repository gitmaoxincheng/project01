package cn.com.agree.huanan.ap.al.io.service.cbs;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.al.io.system.esb.EsbCoreChannelService;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;

/**
 * BASESVC.P043000505 银行卡综合信息查询.客户所持卡信息查询 
 * P0430005.05 cd1060
 * 0005 0005-新核心业务系统
 * @author ZS
 */
@Component
public class P043000505 extends EsbCoreChannelService {

	private static P043000505_I i = new P043000505_I();
	private static P043000505_O o = new P043000505_O();

	public P043000505() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P043000505_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("cust_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_num", 32,0, true, "客户号" )))
					.addNode(new FieldNode("socl_scry_card_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "socl_scry_card_flg", 1,0, false, "社保卡标志" )))
					.addNode(new FieldNode("card_vchr_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_vchr_ste", 1,0, false, "卡凭证状态" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_cnt_num", 10,0, false, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_cnt_num", 10,0, false, "查询笔数" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class P043000505_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new ArrayNode("listnm00_list",false)
							.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, false, "卡号" )))
							.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品代码" )))
							.addNode(new FieldNode("prod_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_dsc", 512,0, false, "产品描述" )))
							.addNode(new FieldNode("card_grd", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_grd", 1,0, false, "卡等级" )))
							.addNode(new FieldNode("card_obj", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_obj", 1,0, false, "卡对象" )))
							.addNode(new FieldNode("card_vchr_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_vchr_ste", 1,0, false, "卡凭证状态" )))
							.addNode(new FieldNode("vip_nrl_card_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vip_nrl_card_flg", 1,0, false, "VIP/普卡标志" )))
							.addNode(new FieldNode("card_issn_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_issn_org", 12,0, false, "发卡机构" )))
							.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
							.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 32,0, false, "凭证序号" )))
							.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
							.addNode(new FieldNode("socl_scry_card_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "socl_scry_card_flg", 1,0, false, "社保卡标志" )))
							.addNode(new FieldNode("hier_int_rate_dept_prd", new MsgField(ContentEnum.MessageType.STRING.toString(), "hier_int_rate_dept_prd", 6,0, false, "层次利率存期" )))
							.addNode(new FieldNode("exec_int_rate", new MsgField(ContentEnum.MessageType.INT.toString(), "exec_int_rate", 12,7, false, "执行利率" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
