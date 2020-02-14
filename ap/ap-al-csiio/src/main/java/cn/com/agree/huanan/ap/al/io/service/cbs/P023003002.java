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
 * BASESVC.P0230030 贷款信息查询
 * P0230030.02 
 * ln3100 新核心系统
 * @author YFK
 */
@Component
public class P023003002 extends EsbCoreChannelService{

	
	private static P023003002_I i = new P023003002_I();
	private static P023003002_O o = new P023003002_O();
	public P023003002() {
		requestFormat.add(i);
		responseFormat.add(o);
	}
	
	
	public static class P023003002_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("loan_due_bill_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"loan_due_bill_num" ,30,0, false, "贷款借据号" )))
					.addNode(new FieldNode("strt_cnt_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"strt_cnt_num" ,10,0, false, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"qry_cnt_num" ,10,0, false, "查询笔数" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	
	
	public static class P023003002_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("loan_due_bill_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"loan_due_bill_num" ,30,0, false, "贷款借据号" )))
					.addNode(new FieldNode("ctrct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"ctrct_num" ,80,0, false, "合同编号" )))
					.addNode(new FieldNode("cust_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"cust_num" ,32,0, false, "客户号" )))
					.addNode(new FieldNode("cust_nm",new MsgField(ContentEnum.MessageType.STRING.toString(),"cust_nm" ,256,0, false, "客户名称" )))
					.addNode(new FieldNode("open_acct_dt",new MsgField(ContentEnum.MessageType.STRING.toString(),"open_acct_dt" ,8,0, false, "开户日期" )))
					.addNode(new FieldNode("open_acct_org",new MsgField(ContentEnum.MessageType.STRING.toString(),"open_acct_org" ,12,0, false, "开户机构" )))
					.addNode(new FieldNode("due_bill_amt",new MsgField(ContentEnum.MessageType.STRING.toString(),"due_bill_amt" ,18,0, false, "借据金额" )))
					.addNode(new FieldNode("rpymt_way",new MsgField(ContentEnum.MessageType.STRING.toString(),"rpymt_way" ,1,0, false, "还款方式" )))
					.addNode(new FieldNode("rpymt_acct_num",new MsgField(ContentEnum.MessageType.STRING.toString(),"rpymt_acct_num" ,40,0, false, "还款账号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	
}
