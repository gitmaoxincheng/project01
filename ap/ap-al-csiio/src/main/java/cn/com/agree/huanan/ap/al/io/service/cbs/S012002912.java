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
 * BASESVC.S012002912 印鉴卡信息管理.开户时印鉴卡快捷领用建档 
 * S0120029.12 ce5454
 * 0005 新核心系统
 * @author XZF
 */
@Component
public class S012002912 extends EsbCoreChannelService {

	private static S012002912_I i = new S012002912_I();
	private static S012002912_O o = new S012002912_O();
	public S012002912() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S012002912_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
					.addNode(new FieldNode("cust_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_nm", 256,0, false, "客户名称" )))
					.addNode(new FieldNode("docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_catg", 3,0, false, "证件种类" )))
					.addNode(new FieldNode("docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "docs_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("corp_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "corp_nm", 256,0, false, "单位名称" )))
					.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
					.addNode(new FieldNode("cust_acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_num", 40,0, false, "客户账号" )))
					.addNode(new FieldNode("cust_acct_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_acct_nm", 256,0, false, "客户账户名称" )))
					.addNode(new FieldNode("signtr_card_cps", new MsgField(ContentEnum.MessageType.INT.toString(), "signtr_card_cps", 10,0, false, "印鉴卡份数" )))
					.addNode(new FieldNode("signtr_card_strt", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtr_card_strt", 10,0, false, "印鉴卡起始号码" )))
					.addNode(new FieldNode("signtr_card_end", new MsgField(ContentEnum.MessageType.STRING.toString(), "signtr_card_end", 10,0, false, "印鉴卡结束号码" )))
					.addNode(new FieldNode("enabl_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "enabl_dt", 8,0, false, "启用日期" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S012002912_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("signtr_card_cps", new MsgField(ContentEnum.MessageType.INT.toString(), "signtr_card_cps", 10,0, false, "印鉴卡份数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

