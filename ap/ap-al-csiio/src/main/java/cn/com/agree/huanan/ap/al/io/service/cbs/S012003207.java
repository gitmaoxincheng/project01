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
 * S0120032.07 尾箱领用/上缴  交易码：tl5216
 * @author heww 
 */
@Component
public class S012003207 extends EsbCoreChannelService {

	private static S012003207_I i = new S012003207_I();
	private static S012003207_O o = new S012003207_O();
	public S012003207() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	
	public static class S012003207_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			
			StructNode BODY = new StructNode("APPBody");
			BODY.addNode(new FieldNode("boot_oprn_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_oprn_flg", 1,0, true, "尾箱操作标志" )));
			BODY.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 9,0, true, "柜员代号" )));
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
	
	public static class S012003207_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			StructNode  BODY= new StructNode("APPBody");
			
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
}

