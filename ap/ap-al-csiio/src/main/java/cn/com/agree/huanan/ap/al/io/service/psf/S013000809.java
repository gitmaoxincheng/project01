package cn.com.agree.huanan.ap.al.io.service.psf;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.S013000809 东莞公积金数据查询.东莞公积金中心查询账户基本信息 
 * S0130008.09 getPsnInfo
 * 0122 公积金资金结算系统
 * @author LSJ
 */
@Component
public class S013000809 extends EsbChannelService {

	private static S013000809_I i = new S013000809_I();
	private static S013000809_O o = new S013000809_O();
	public S013000809() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013000809_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("IdtfNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdtfNo", 30,0, true, "身份证件号码" )))
					.addNode(new FieldNode("BsnTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "BsnTp", 5,0, true, "业务办理类型" )))
					.addNode(new FieldNode("OrgTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "OrgTp", 100,0, false, "发证机关" )))
					.addNode(new FieldNode("ChkNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ChkNo", 40,0, true, "机构身份识别码（入参）" )))
					.addNode(new FieldNode("OffId", new MsgField(ContentEnum.MessageType.STRING.toString(), "OffId", 20,0, true, "网点编号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S013000809_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("AcctNa", new MsgField(ContentEnum.MessageType.STRING.toString(), "AcctNa", 80,0, true, "公积金账户名称" )))
					.addNode(new FieldNode("AcctNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "AcctNo", 40,0, true, "公积金账号" )))
					.addNode(new FieldNode("AcctSt", new MsgField(ContentEnum.MessageType.STRING.toString(), "AcctSt", 1,0, true, "账户状态" )))
					.addNode(new FieldNode("IsSelf", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsSelf", 3,0, true, "自助服务开通状态" )))
					.addNode(new FieldNode("IsScan", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsScan", 3,0, true, "是否需扫描照片" )))
					.addNode(new FieldNode("OnlnBl", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "OnlnBl", 18,2, true, "公积金账户余额" )))
					.addNode(new FieldNode("ToacNa", new MsgField(ContentEnum.MessageType.STRING.toString(), "ToacNa", 80,0, false, "绑定卡户名" )))
					.addNode(new FieldNode("ToAcct", new MsgField(ContentEnum.MessageType.STRING.toString(), "ToAcct", 40,0, false, "绑定卡账号" )))
					.addNode(new FieldNode("TranAc", new MsgField(ContentEnum.MessageType.STRING.toString(), "TranAc", 40,0, false, "社保卡账号" )))
					.addNode(new FieldNode("BankNa", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankNa", 100,0, false, "行别" )))
					.addNode(new FieldNode("AccRge", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccRge", 100,0, false, "受理范围" )))
					.addNode(new FieldNode("MobiTl", new MsgField(ContentEnum.MessageType.STRING.toString(), "MobiTl", 20,0, false, "手机号码" )))
					.addNode(new FieldNode("MarrSt", new MsgField(ContentEnum.MessageType.STRING.toString(), "MarrSt", 3,0, false, "婚姻状况" )))
					.addNode(new FieldNode("AvaBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "AvaBal", 15,0, true, "本次最大可提取额" )))
					.addNode(new FieldNode("TokeId", new MsgField(ContentEnum.MessageType.STRING.toString(), "TokeId", 36,0, true, "Token id" )))
					.addNode(new FieldNode("ListNm", new MsgField(ContentEnum.MessageType.STRING.toString(), "ListNm", 10,0, false, "家庭成员记录数" )))
					.addNode(new ArrayNode("Family_list",false)
							.addNode(new FieldNode("IdtfTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdtfTp", 2,0, false, "证件类型" )))
							.addNode(new FieldNode("IdtfNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdtfNo", 30,0, false, "证件号码" )))
							.addNode(new FieldNode("CustNa", new MsgField(ContentEnum.MessageType.STRING.toString(), "CustNa", 256,0, false, "姓名" )))
							.addNode(new FieldNode("Gender", new MsgField(ContentEnum.MessageType.STRING.toString(), "Gender", 1,0, false, "性别" )))
							.addNode(new FieldNode("BornDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "BornDt", 8,0, false, "出生日期" )))
							.addNode(new FieldNode("Relats", new MsgField(ContentEnum.MessageType.STRING.toString(), "Relats", 3,0, false, "与申请人关系" )))
							).addNode(new FieldNode("AmtobjNm", new MsgField(ContentEnum.MessageType.STRING.toString(), "AmtobjNm", 10,0, false, "提取方案记录数" )))
					.addNode(new ArrayNode("Amtobj_list",false)
							.addNode(new FieldNode("CtbYM", new MsgField(ContentEnum.MessageType.STRING.toString(), "CtbYM", 7,0, false, "缴存年月" )))
							.addNode(new FieldNode("PfTIME", new MsgField(ContentEnum.MessageType.STRING.toString(), "PfTIME", 10,0, false, "缴存日期" )))
							.addNode(new FieldNode("BzfPAY", new MsgField(ContentEnum.MessageType.STRING.toString(), "BzfPAY", 40,0, false, "保障房月租金" )))
							.addNode(new FieldNode("CtbPAY", new MsgField(ContentEnum.MessageType.STRING.toString(), "CtbPAY", 10,0, false, "缴存金额" )))
							.addNode(new FieldNode("AmtN", new MsgField(ContentEnum.MessageType.STRING.toString(), "AmtN", 10,0, false, "按月缴存比例计算金额" )))
							.addNode(new FieldNode("AmtO", new MsgField(ContentEnum.MessageType.STRING.toString(), "AmtO", 10,0, false, "按保障性住房计算多管" )))
							)
					.addNode(new FieldNode("AvaBalBzf", new MsgField(ContentEnum.MessageType.STRING.toString(), "AvaBalBzf", 15,0, false, "本次最大可提取额(按保障房计算)" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

