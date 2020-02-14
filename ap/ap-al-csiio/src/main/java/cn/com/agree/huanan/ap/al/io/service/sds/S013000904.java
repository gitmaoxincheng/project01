package cn.com.agree.huanan.ap.al.io.service.sds;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbSdsChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.S013000904 集中作业查询.集中作业-任务汇总查询 
 * S0130009.04 TaskSumm
 * 0209 集中业务处理平台
 * @author XZ
 */
@Component
public class S013000904 extends EsbSdsChannelService {
	private static S013000904_I i = new S013000904_I();
	private static S013000904_O o = new S013000904_O();
	public S013000904() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class S013000904_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
				.addNode(new FieldNode("TASKID", new MsgField(ContentEnum.MessageType.STRING.toString(), "TASKID", 50,0, false, "任务号" )))
				.addNode(new FieldNode("STARTAMOUNT", new MsgField(ContentEnum.MessageType.STRING.toString(), "STARTAMOUNT", 20,0, false, "开始金额" )))
				.addNode(new FieldNode("ENDAMOUNT", new MsgField(ContentEnum.MessageType.STRING.toString(), "ENDAMOUNT", 22,0, false, "结束金额" )))
				.addNode(new FieldNode("PAYACCOUNT", new MsgField(ContentEnum.MessageType.STRING.toString(), "PAYACCOUNT", 30,0, false, "付款账号" )))
				.addNode(new FieldNode("RECACCOUNT", new MsgField(ContentEnum.MessageType.STRING.toString(), "RECACCOUNT", 30,0, false, "收款账号" )))
				.addNode(new FieldNode("TASKSTATE", new MsgField(ContentEnum.MessageType.STRING.toString(), "TASKSTATE", 6,0, false, "任务状态" )))
				.addNode(new FieldNode("TRANSCODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "TRANSCODE", 22,0, false, "交易种类" )))
				.addNode(new FieldNode("VOUCHER_KIND", new MsgField(ContentEnum.MessageType.STRING.toString(), "VOUCHER_KIND", 30,0, false, "凭证种类" )))
				.addNode(new FieldNode("VOUCHER_CODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "VOUCHER_CODE", 30,0, false, "凭证号码" )))
				.addNode(new FieldNode("STARTDATE", new MsgField(ContentEnum.MessageType.STRING.toString(), "STARTDATE", 30,0, false, "开始时间" )))
				.addNode(new FieldNode("ENDDATE", new MsgField(ContentEnum.MessageType.STRING.toString(), "ENDDATE", 50,0, false, "结束时间" )))
				.addNode(new FieldNode("USERNO", new MsgField(ContentEnum.MessageType.STRING.toString(), "USERNO", 50,0, false, "业务发起柜员号" )))
				.addNode(new FieldNode("BRNO", new MsgField(ContentEnum.MessageType.STRING.toString(), "BRNO", 50,0, false, "机构号" )))
				.addNode(new FieldNode("LIMIT", new MsgField(ContentEnum.MessageType.STRING.toString(), "LIMIT", 3,0, false, "单页条数" )))
				.addNode(new FieldNode("START", new MsgField(ContentEnum.MessageType.STRING.toString(), "START", 30,0, false, "页码" )))
				);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S013000904_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
				.addNode(new FieldNode("RETCODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "RETCODE", 10,0, false, "处理结果码" )))
				.addNode(new FieldNode("RETREASON", new MsgField(ContentEnum.MessageType.STRING.toString(), "RETREASON", 150,0, false, "处理结果信息" )))
				.addNode(new FieldNode("TOTAL", new MsgField(ContentEnum.MessageType.STRING.toString(), "TOTAL", 3,0, false, "总条数" )))
				.addNode(new FieldNode("ROWNUM", new MsgField(ContentEnum.MessageType.STRING.toString(), "ROWNUM", 3,0, false, "任务条数" )))
				.addNode(new FieldNode("ZD_TOTAL", new MsgField(ContentEnum.MessageType.STRING.toString(), "ZD_TOTAL", 6,0, false, "置顶条数" )))
				.addNode(new ArrayNode("ROWS",false)
				.addNode(new FieldNode("TELLERTRDNO", new MsgField(ContentEnum.MessageType.STRING.toString(), "TELLERTRDNO", 2,0, false, "-主机记账流水号" )))
				.addNode(new FieldNode("TranDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "TranDt", 6,0, false, "-交易日期" )))
				.addNode(new FieldNode("TELNO", new MsgField(ContentEnum.MessageType.STRING.toString(), "TELNO", 6,0, false, "-记账柜员号" )))
				.addNode(new FieldNode("USERNO", new MsgField(ContentEnum.MessageType.STRING.toString(), "USERNO", 8,0, false, "-发起柜员" )))
				.addNode(new FieldNode("TranAm", new MsgField(ContentEnum.MessageType.STRING.toString(), "TranAm", 3,0, false, "-交易金额" )))
				.addNode(new FieldNode("TASKID", new MsgField(ContentEnum.MessageType.STRING.toString(), "TASKID", 22,0, false, "-任务号" )))
				.addNode(new FieldNode("DOCID", new MsgField(ContentEnum.MessageType.STRING.toString(), "DOCID", 3,0, false, "-影像ID" )))
				.addNode(new FieldNode("SCANDATE", new MsgField(ContentEnum.MessageType.STRING.toString(), "SCANDATE", 22,0, false, "-扫描日期" )))
				.addNode(new FieldNode("TRADECODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "TRADECODE", 12,0, false, "-交易码" )))
				.addNode(new FieldNode("OPERFLAG", new MsgField(ContentEnum.MessageType.STRING.toString(), "OPERFLAG", 30,0, false, "-任务状态" )))
				.addNode(new FieldNode("DCFLAG", new MsgField(ContentEnum.MessageType.STRING.toString(), "DCFLAG", 10,0, false, "-借贷记标识" )))
				.addNode(new FieldNode("ACCOUNTDATE", new MsgField(ContentEnum.MessageType.STRING.toString(), "ACCOUNTDATE", 30,0, false, "-记账日期" )))
				.addNode(new FieldNode("PAYACCOUNT", new MsgField(ContentEnum.MessageType.STRING.toString(), "PAYACCOUNT", 30,0, false, "-付款账号" )))
				.addNode(new FieldNode("PAYNAME", new MsgField(ContentEnum.MessageType.STRING.toString(), "PAYNAME", 200,0, false, "-付款户名" )))
				.addNode(new FieldNode("RECVACCOUNT", new MsgField(ContentEnum.MessageType.STRING.toString(), "RECVACCOUNT", 30,0, false, "-收款账号" )))
				.addNode(new FieldNode("PAYEENAME", new MsgField(ContentEnum.MessageType.STRING.toString(), "PAYEENAME", 200,0, false, "-收款户名" )))
				.addNode(new FieldNode("FLOWID", new MsgField(ContentEnum.MessageType.STRING.toString(), "FLOWID", 100,0, false, "-工作流任务号" )))
				.addNode(new FieldNode("ROWNO", new MsgField(ContentEnum.MessageType.STRING.toString(), "ROWNO", 100,0, false, "-序号" )))
				.addNode(new FieldNode("SOURCE_TYPE", new MsgField(ContentEnum.MessageType.STRING.toString(), "SOURCE_TYPE", 5,0, false, "-是否置顶标志" )))
				.addNode(new FieldNode("HOLD_TRANSNO", new MsgField(ContentEnum.MessageType.STRING.toString(), "HOLD_TRANSNO", 100,0, false, "-流程id" )))
				.addNode(new FieldNode("BEGIN_ORGNO", new MsgField(ContentEnum.MessageType.STRING.toString(), "BEGIN_ORGNO", 100,0, false, "-发起行所号" )))
				.addNode(new FieldNode("DTSAKID", new MsgField(ContentEnum.MessageType.STRING.toString(), "DTSAKID", 100,0, false, "-下一任务号" )))
				.addNode(new FieldNode("UTSAKID", new MsgField(ContentEnum.MessageType.STRING.toString(), "UTSAKID", 100,0, false, "-上一任务号" )))
				.addNode(new FieldNode("ISGREEN", new MsgField(ContentEnum.MessageType.STRING.toString(), "ISGREEN", 5,0, false, "-是否加急" )))
				.addNode(new FieldNode("ZONENO", new MsgField(ContentEnum.MessageType.STRING.toString(), "ZONENO", 50,0, false, "-发起任务行所号" )))
				.addNode(new FieldNode("VOUCHER_CODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "VOUCHER_CODE", 100,0, false, "-凭证代码" )))
				));	
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

