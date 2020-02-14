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
 * BASESVC.P015000103 转账冲正
 * P0150001.03 
 * ap0010 新核心系统
 * @author ZZC
 */
@Component
public class P015000103 extends EsbCoreChannelService{

	private static P015000103_I i = new P015000103_I();
	private static P015000103_O o = new P015000103_O();
	public P015000103() {
		requestFormat.add(i);
		responseFormat.add(o);
	}
	
	public static class P015000103_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("orig_tlr_rung_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"orig_tlr_rung_num" ,32,0, false, "原柜员流水号" )))
					.addNode(new FieldNode("orig_txn_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"orig_txn_dt" ,8,0, false, "原交易日期" )))
					.addNode(new FieldNode("orig_pfxn_sys_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"orig_pfxn_sys_dt" ,8,0, false, "原前置日期" )))
					.addNode(new FieldNode("orig_pfxn_sys_rung_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"orig_pfxn_sys_rung_num" ,32,0, false, "原前置流水" )))

					);			
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	public static class P015000103_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("remks_info",new MsgField(ContentEnum.MessageType.STRING.toString(),"remks_info" ,300,0, false, "备注信息" )))
					.addNode(new FieldNode("txn_dt_8",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_dt_8" ,8,0, false, "交易日期" )))
					.addNode(new FieldNode("txn_rung_num_32",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_rung_num_32" ,32,0, false, "交易流水号" )))
					.addNode(new FieldNode("txn_tlr",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_tlr" ,10,0, false, "交易柜员" )))
					.addNode(new FieldNode("txn_org",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_org" ,12,0, false, "交易机构" )))
					.addNode(new FieldNode("orig_txn_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"orig_txn_code" ,20,0, false, "原交易码" )))
					.addNode(new FieldNode("orig_txn_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"orig_txn_nm" ,300,0, false, "原交易名称" )))
					.addNode(new FieldNode("txn_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_code" ,20,0, false, "交易码" )))
					.addNode(new FieldNode("txn_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_nm" ,300,0, false, "交易名称" )))
					.addNode(new FieldNode("tlr_rung_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"tlr_rung_num" ,32,0, false, "柜员流水号" )))

					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	
}
