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
 * S0120027.02 柜员账务平衡检查  交易码：tl5232
 * @author lixq 
 */
@Component
public class S012002702 extends EsbCoreChannelService {

	private static S012002702_I i = new S012002702_I();
	private static S012002702_O o = new S012002702_O();
	public S012002702() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	
	public static class S012002702_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			
			StructNode BODY = new StructNode("APPBody");
			FieldNode tlr_code_num = new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" ));
			FieldNode wthr_cfm_acct_oprn = new FieldNode("wthr_cfm_acct_oprn", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_cfm_acct_oprn", 1,0, false, "是否平账操作" ));

			BODY.addNode(tlr_code_num);
			BODY.addNode(wthr_cfm_acct_oprn);

			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
	
	public static class S012002702_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			StructNode  BODY= new StructNode("APPBody");
			BODY.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号")));
			BODY.addNode(new FieldNode("bal_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "bal_ste", 1,0, false, "平衡状态")));
			BODY.addNode(new FieldNode("mber_qty", new MsgField(ContentEnum.MessageType.STRING.toString(), "mber_qty", 10,0, false, "成员数量")));
	
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
}
