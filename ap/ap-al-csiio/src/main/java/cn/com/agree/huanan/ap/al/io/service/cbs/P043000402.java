package cn.com.agree.huanan.ap.al.io.service.cbs;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbCoreChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P043000402 银行卡凭证信息查询.卡凭证对照信息查询 
 * P0430004.02 cd1067
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class P043000402 extends EsbCoreChannelService {

	private static P043000402_I i = new P043000402_I();
	private static P043000402_O o = new P043000402_O();
	public P043000402() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P043000402_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, true, "卡号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P043000402_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("card_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_num", 40,0, false, "卡号" )))
					.addNode(new FieldNode("card_sers_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_sers_num", 8,0, false, "卡序列号" )))
					.addNode(new FieldNode("prod_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_code", 10,0, false, "产品代码" )))
					.addNode(new FieldNode("card_medm", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_medm", 1,0, false, "卡介质" )))
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, false, "凭证批号" )))
					.addNode(new FieldNode("vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_serl_num", 32,0, false, "凭证序号" )))
					.addNode(new FieldNode("card_aply_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_aply_dt", 8,0, false, "卡申请日期" )))
					.addNode(new FieldNode("vchr_use_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_use_flg", 1,0, false, "凭证使用标志" )))
					.addNode(new FieldNode("vld_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "vld_dt", 8,0, false, "有效日期" )))
					.addNode(new FieldNode("card_aply_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_aply_org", 12,0, false, "卡申请机构" )))
					.addNode(new FieldNode("make_card_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "make_card_ste", 1,0, false, "制卡状态" )))
					.addNode(new FieldNode("make_card_blgd", new MsgField(ContentEnum.MessageType.STRING.toString(), "make_card_blgd", 2,0, false, "制卡归属" )))
					.addNode(new FieldNode("prod_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_dsc", 750,0, false, "产品描述" )))
					.addNode(new FieldNode("card_vchr_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_vchr_class", 80,0, false, "卡凭证类别" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

