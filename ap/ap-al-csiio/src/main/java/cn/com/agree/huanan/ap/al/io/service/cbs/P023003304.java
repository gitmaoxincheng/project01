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
 * BASESVC.P023003304 贷款账户回单打印
 * P023003304 
 * lnd206 新核心系统
 * @author YFK
 */
@Component
public class P023003304 extends EsbCoreChannelService{

	
	private static P023003304_I i = new P023003304_I();
	private static P023003304_O o = new P023003304_O();
	public P023003304() {
		requestFormat.add(i);
		responseFormat.add(o);
	}
	
	public static class P023003304_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("wthr_prt_flg",new MsgField(ContentEnum.MessageType.STRING.toString(),"wthr_prt_flg" ,1,0, false, "打印标志" )))
					.addNode(new ArrayNode("printList_list",false)
					.addNode(new FieldNode("detl_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"detl_num" ,60,0, false, "明细编号" )))
					.addNode(new FieldNode("loan_due_bill_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"loan_due_bill_num" ,30,0, false, "贷款借据号" )))
					.addNode(new FieldNode("prt_cnt",new MsgField(ContentEnum.MessageType.STRING.toString(),"prt_cnt" ,10,0, false, "打印次数" )))
					.addNode(new FieldNode("txn_dt_8",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_dt_8" ,8,0, false, "交易日期" )))
					.addNode(new FieldNode("txn_rung_num_32",new MsgField(ContentEnum.MessageType.STRING.toString(),"txn_rung_num_32" ,32,0, false, "交易流水号" )))
					.addNode(new FieldNode("lgl_pern_code",new MsgField(ContentEnum.MessageType.STRING.toString(),"lgl_pern_code" ,4,0, false, "法人代码" )))
					.addNode(new FieldNode("br_id",new MsgField(ContentEnum.MessageType.STRING.toString(),"br_id" ,4,0, false, "分行标识" )))
					.addNode(new FieldNode("mntnc_tlr",new MsgField(ContentEnum.MessageType.STRING.toString(),"mntnc_tlr" ,10,0, false, "维护柜员" )))
					.addNode(new FieldNode("mntnc_org",new MsgField(ContentEnum.MessageType.STRING.toString(),"mntnc_org" ,12,0, false, "维护机构" )))
					.addNode(new FieldNode("mntnc_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"mntnc_dt" ,8,0, false, "维护日期" )))
					.addNode(new FieldNode("mntnc_tm",new MsgField(ContentEnum.MessageType.STRING.toString(),"mntnc_tm" ,9,0, false, "维护时间" )))
					.addNode(new FieldNode("rec_ste",new MsgField(ContentEnum.MessageType.STRING.toString(),"rec_ste" ,1,0, false, "记录状态" )))
					.addNode(new FieldNode("affr_ste",new MsgField(ContentEnum.MessageType.STRING.toString(),"affr_ste" ,1,0, false, "事务状态" )))
					.addNode(new FieldNode("glbl_affr_rung_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"glbl_affr_rung_num" ,32,0, false, "全局事务流水号" )))
					)
					.addNode(new FieldNode("recpt_prt_tp",new MsgField(ContentEnum.MessageType.STRING.toString(),"recpt_prt_tp" ,1,0, false, "回单打印类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	public static class P023003304_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
}
