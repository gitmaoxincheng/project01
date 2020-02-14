package cn.com.agree.huanan.ap.al.io.service.cbs;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbCoreChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.S012003204 尾箱操作管理.凭证尾箱碰库(联动) 
 * S0120032.04 tl5229
 * 0005 新核心业务系统
 * @author YYX
 */
@Component
public class S012003204 extends EsbCoreChannelService {

	private static S012003204_I i = new S012003204_I();
	private static S012003204_O o = new S012003204_O();

	public S012003204() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S012003204_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" )))
					.addNode(new FieldNode("boot_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_class", 2,0, false, "尾箱类别" )))
					.addNode(new FieldNode("boot_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_num", 8,0, false, "尾箱号" )))
					.addNode(new FieldNode("tlr_boot_chk_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_boot_chk_flg", 1,0, false, "柜员碰库状态" )))
					.addNode(new FieldNode("hint_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "hint_info", 300,0, false, "提示信息" )))
					.addNode(new FieldNode("wthr_cfm_acct_oprn", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_cfm_acct_oprn", 1,0, false, "是否平账操作" )))
					.addNode(new FieldNode("mber_qty", new MsgField(ContentEnum.MessageType.INT.toString(), "mber_qty", 10,0, false, "成员数量" )))
					.addNode(new ArrayNode("listnm_list",false)
							.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, false, "凭证种类" )))
							.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" )))
							.addNode(new FieldNode("vchr_acct_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_acct_class", 6,0, false, "凭证账户类别" )))
							.addNode(new FieldNode("invty_bal", new MsgField(ContentEnum.MessageType.INT.toString(), "invty_bal", 18,2, false, "库存余额" )))
							.addNode(new FieldNode("acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_num", 40,0, false, "系统账号" )))
							.addNode(new FieldNode("vchr_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_nm", 750,0, false, "凭证名称" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S012003204_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("hint_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "hint_info", 300,0, false, "提示信息" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
