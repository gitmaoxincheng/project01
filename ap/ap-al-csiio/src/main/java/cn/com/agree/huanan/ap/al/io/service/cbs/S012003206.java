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
 * BASESVC.S012003206 尾箱操作管理.机构调整尾箱权限捆绑 
 * S0120032.06 tl5444
 * 0005 新核心业务系统
 * @author CZP
 */
@Component
public class S012003206 extends EsbCoreChannelService {

	private static S012003206_I i = new S012003206_I();
	private static S012003206_O o = new S012003206_O();

	public S012003206() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S012003206_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" )))
					.addNode(new FieldNode("tlr_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_nm", 256,0, false, "柜员姓名" )))
					.addNode(new FieldNode("org_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "org_code", 20,0, false, "机构代码" )))
					.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" )))
					.addNode(new FieldNode("boot_oprn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_oprn_flg", 1,0, false, "尾箱操作标志" )))
					.addNode(new FieldNode("boot_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_class", 2,0, false, "尾箱类别" )))
					.addNode(new FieldNode("boot_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_flg", 1,0, false, "尾箱标志" )))
					.addNode(new FieldNode("boot_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_num", 8,0, false, "尾箱号" )))
					.addNode(new FieldNode("off_bal_sheet_boot_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "off_bal_sheet_boot_num", 8,0, false, "表外尾箱号" )))
					.addNode(new FieldNode("cash_tlr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_tlr_flg", 1,0, false, "是否现金岗位" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S012003206_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_rung_num", 64,0, false, "柜员流水号" )))
					.addNode(new FieldNode("org_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "org_code", 20,0, false, "机构代码" )))
					.addNode(new FieldNode("cur_txn_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "cur_txn_dt", 8,0, false, "当前交易日期" )))
					.addNode(new FieldNode("hint_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "hint_info", 300,0, false, "提示信息" )))
					.addNode(new FieldNode("boot_oprn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_oprn_flg", 1,0, false, "尾箱操作标志" )))
					.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" )))
					.addNode(new FieldNode("tlr_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_nm", 256,0, false, "柜员姓名" )))
					.addNode(new FieldNode("boot_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_flg", 1,0, false, "尾箱标志" )))
					.addNode(new FieldNode("boot_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_class", 2,0, false, "尾箱类别" )))
					.addNode(new FieldNode("boot_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_num", 8,0, false, "现金尾箱号" )))
					.addNode(new FieldNode("off_bal_sheet_boot_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "off_bal_sheet_boot_num", 8,0, false, "表外尾箱号" )))
					.addNode(new FieldNode("boot_prvg_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_prvg_ste", 1,0, false, "尾箱权限状态" )))
					.addNode(new FieldNode("ctrl_list_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctrl_list_tp", 1,0, false, "控制列表类型" )))
					.addNode(new FieldNode("ctrl_lists", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctrl_lists", 1500,0, false, "控制列表" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
