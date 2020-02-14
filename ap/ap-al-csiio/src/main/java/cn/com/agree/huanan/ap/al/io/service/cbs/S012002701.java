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
 * S0120027.01 柜员日终平账  交易码：tl5231
 * @author lixq 
 */
@Component
public class S012002701 extends EsbCoreChannelService {

	private static S012002701_I i = new S012002701_I();
	private static S012002701_O o = new S012002701_O();
	public S012002701() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	
	public static class S012002701_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			
			StructNode BODY = new StructNode("APPBody");
			FieldNode tlr_code_num = new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, true, "柜员代号" ));
			FieldNode wthr_cfm_acct_oprn = new FieldNode("wthr_cfm_acct_oprn", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_cfm_acct_oprn", 1,0, true, "是否平账操作" ));
			FieldNode txn_code = new FieldNode("txn_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_code", 20,0, false, "交易码"));
						
			BODY.addNode(tlr_code_num);
			BODY.addNode(wthr_cfm_acct_oprn);
			BODY.addNode(txn_code);
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
	
	public static class S012002701_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			StructNode  BODY= new StructNode("APPBody");
			
			BODY.addNode(new FieldNode("mber_qty", new MsgField(ContentEnum.MessageType.STRING.toString(), "mber_qty", 10,0, false, "成员数量")));
			
			ArrayNode arrayNode = new ArrayNode("listnm_list");
			arrayNode.addNode(new FieldNode("fgrd_txn_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "fgrd_txn_code", 20,0, false, "前台交易码")));
			arrayNode.addNode(new FieldNode("txn_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_code", 20,0, false, "交易码")));
			arrayNode.addNode(new FieldNode("next_txn_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "fgrd_txn_code", 20,0, false, "下一交易码")));
			arrayNode.addNode(new FieldNode("lkg_mode", new MsgField(ContentEnum.MessageType.STRING.toString(), "lkg_mode", 1,0, false, "联动模式")));
			BODY.addNode(arrayNode);
			
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
}
