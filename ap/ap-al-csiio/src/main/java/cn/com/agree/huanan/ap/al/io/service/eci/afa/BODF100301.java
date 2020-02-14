package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciF10ChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;

/**
 * BASESVC BODF100301  客户签约银行账号信息查询 
 *  BODF100301 
 *  综合前置
 * @author XZF
 */
@Component
public class BODF100301 extends EciF10ChannelService {

	private static BODF100301_I i = new BODF100301_I();
	private static BODF100301_O o = new BODF100301_O();
	public BODF100301() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF100301_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("AccType", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccType", 1,0, true, "客户标识类型" )))
					.addNode(new FieldNode("Account", new MsgField(ContentEnum.MessageType.STRING.toString(), "Account", 32,0, true, "客户标识" )))
					.addNode(new FieldNode("IdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdType", 1,0, true, "证件类型" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 50,0, true, "定位串" )))
					.addNode(new FieldNode("QueryNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "QueryNum", 10,0, true, "查询行数" )))
					.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 1,0, false, "查询状态" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF100301_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("TotNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotNum", 10,0, true, "总行数" )))
					.addNode(new FieldNode("RetNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "RetNum", 10,0, true, "本次返回行数" )))
					.addNode(new FieldNode("OffSet", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffSet", 50,0, true, "定位串" )))
					.addNode(new ArrayNode("bodrcd",true,"signacct_list")
							.addNode(new FieldNode("ClientNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientNo", 10,0, true, "客户号" )))
							.addNode(new FieldNode("ShortName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ShortName", 100,0, true, "客户简称" )))
							.addNode(new FieldNode("ClientName", new MsgField(ContentEnum.MessageType.STRING.toString(), "ClientName", 100,0, true, "客户名称" )))
							.addNode(new FieldNode("BankAcc", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankAcc", 40,0, true, "理财账号" )))
							.addNode(new FieldNode("OpenBranch", new MsgField(ContentEnum.MessageType.STRING.toString(), "OpenBranch", 20,0, true, "银行账号开户机构" )))
							.addNode(new FieldNode("OpenBranchName", new MsgField(ContentEnum.MessageType.STRING.toString(), "OpenBranchName", 100,0, true, "银行账号开户机构名称" )))
							.addNode(new FieldNode("TransDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransDate", 8,0, true, "登记日期" )))
							.addNode(new FieldNode("Status", new MsgField(ContentEnum.MessageType.STRING.toString(), "Status", 1,0, true, "银行账号签约状态" )))
							.addNode(new FieldNode("StatusName", new MsgField(ContentEnum.MessageType.STRING.toString(), "StatusName", 80,0, true, "账户状态名称" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

