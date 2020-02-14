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
 * S0120032.02  尾箱账号维护   交易码：tl5215
 * @author zhuzc
 */
@Component
public class S012003202 extends EsbCoreChannelService {

	private static S012003202_I i = new S012003202_I();
	private static S012003202_O o = new S012003202_O();
	public S012003202() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	
	public static class S012003202_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			
			StructNode BODY = new StructNode("APPBody");
			BODY.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, true, "营业机构" )));
			BODY.addNode(new FieldNode("boot_oprn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_oprn_flg", 1,0, true, "尾箱操作标志" )));
			BODY.addNode(new FieldNode("boot_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_class", 2,0, true, "尾箱类别")));
			BODY.addNode(new FieldNode("boot_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_flg", 1,0, true, "尾箱标志" )));
			BODY.addNode(new FieldNode("boot_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_num", 8,0, false, "现金尾箱号" )));
			BODY.addNode(new FieldNode("off_bal_sheet_boot_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "off_bal_sheet_boot_num", 8,0, false, "表外尾箱号" )));
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
	
	public static class S012003202_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			StructNode  BODY= new StructNode("APPBody");
			BODY.addNode(new FieldNode("boot_oprn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_oprn_flg", 1,0, false, "尾箱操作标志")));
			BODY.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构")));
			BODY.addNode(new FieldNode("boot_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_num", 8,0, false, "尾箱号")));
			BODY.addNode(new FieldNode("off_bal_sheet_boot_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "off_bal_sheet_boot_num", 8,0, false, "表外尾箱号")));
			BODY.addNode(new FieldNode("boot_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_flg", 1,0, false, "尾箱标志")));
			BODY.addNode(new FieldNode("boot_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_class", 2,0, false, "尾箱类别")));
			BODY.addNode(new FieldNode("boot_prvg_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_prvg_ste", 1,0, false, "尾箱权限状态")));
			BODY.addNode(new FieldNode("ctrl_list_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctrl_list_tp", 1,0, false, "控制列表类型")));
			//BODY.addNode(new FieldNode("ctrl_lists", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctrl_lists", 1500,0, false, "控制列表")));
  
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
}
