package cn.com.agree.huanan.ap.al.io.service.oprcnter;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.csis.CsisIOService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * OPRCNTER.CHLN0005 用户中心.渠道信息变更审批查询
 * @author HCP
 */
//@Component 
public class CHLN0005  extends CsisIOService {

	private static CHLN0005_I i = new CHLN0005_I();
	private static CHLN0005_O o = new CHLN0005_O();
	public CHLN0005() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class CHLN0005_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("pageflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pageflag", 10,0, true, "页码" )))
					.addNode(new FieldNode("maxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxnum", 10,0, true, "每页最多记录数" )))
					.addNode(new FieldNode("chnlcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "chnlcode", 10,0, false, "渠道代码" )))
					.addNode(new FieldNode("begindate", new MsgField(ContentEnum.MessageType.STRING.toString(), "begindate", 8,0, true, "起始日期" )))
					.addNode(new FieldNode("enddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "enddate", 8,0, true, "截止日期" )))
					.addNode(new FieldNode("opttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "opttype", 1,0, false, "操作类型" )))
					.addNode(new FieldNode("audstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "audstatus", 1,0, false, "审批状态" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class CHLN0005_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("rowcnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "rowcnt", 10,0, true, "总笔数" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 10,0, true, "返回记录数" )))
					.addNode(new ArrayNode("bodrcd",false)
							.addNode(new FieldNode("serino", new MsgField(ContentEnum.MessageType.STRING.toString(), "serino", 32,0, false, "流水号" )))
							.addNode(new FieldNode("opttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "opttype", 1,0, false, "操作类型" )))
							.addNode(new FieldNode("chn_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "chn_code", 10,0, false, "渠道代码" )))
							.addNode(new FieldNode("SrcSysId", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcSysId", 4,0, true, "系统标识" )))
							.addNode(new FieldNode("chnlname", new MsgField(ContentEnum.MessageType.STRING.toString(), "chnlname", 60,0, false, "渠道名称" )))
							.addNode(new FieldNode("chnlstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "chnlstatus", 2,0, false, "渠道状态" )))
							.addNode(new FieldNode("chkflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "chkflag", 1,0, true, "渠道设备检查标识" )))
							.addNode(new FieldNode("crtdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "crtdate", 8,0, false, "操作日期" )))
							.addNode(new FieldNode("crttime", new MsgField(ContentEnum.MessageType.STRING.toString(), "crttime", 6,0, false, "操作时间" )))
							.addNode(new FieldNode("crtbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "crtbrno", 10,0, false, "操作行所" )))
							.addNode(new FieldNode("crttlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "crttlr", 10,0, false, "操作柜员" )))
							.addNode(new FieldNode("auddate", new MsgField(ContentEnum.MessageType.STRING.toString(), "auddate", 8,0, false, "审批日期" )))
							.addNode(new FieldNode("audtime", new MsgField(ContentEnum.MessageType.STRING.toString(), "audtime", 6,0, false, "审批时间" )))
							.addNode(new FieldNode("audbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "audbrno", 10,0, false, "审批行所" )))
							.addNode(new FieldNode("audtlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "audtlr", 10,0, false, "审批柜员" )))
							.addNode(new FieldNode("audstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "audstatus", 1,0, false, "审批状态" )))
							.addNode(new FieldNode("audremarks", new MsgField(ContentEnum.MessageType.STRING.toString(), "audremarks", 255,0, false, "审批意见" )))
							));
							return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static void main(String[] args) {
		
	}
}
