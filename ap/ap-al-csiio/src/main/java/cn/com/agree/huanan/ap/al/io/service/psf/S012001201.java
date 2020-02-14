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
 * BASESVC.S012001201 东莞公积金管理.公积金提取申请 
 * S0120012.01 transCommit
 * 0122 公积金资金结算系统
 * @author LSJ
 */
@Component
public class S012001201 extends EsbChannelService {

	private static S012001201_I i = new S012001201_I();
	private static S012001201_O o = new S012001201_O();
	public S012001201() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S012001201_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("TokeId", new MsgField(ContentEnum.MessageType.STRING.toString(), "TokeId", 36,0, true, "Token id" )))
					.addNode(new FieldNode("ScenPh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ScenPh", 819200,0, true, "现场照片" )))
					.addNode(new FieldNode("IdenPh", new MsgField(ContentEnum.MessageType.STRING.toString(), "IdenPh", 819200,0, false, "业务照片" )))
					.addNode(new FieldNode("MarrMF", new MsgField(ContentEnum.MessageType.STRING.toString(), "MarrMF", 3,0, true, "婚姻状况变更标识" )))
					.addNode(new FieldNode("MarrSt", new MsgField(ContentEnum.MessageType.STRING.toString(), "MarrSt", 3,0, false, "婚姻状况" )))
					.addNode(new FieldNode("FamiMF", new MsgField(ContentEnum.MessageType.STRING.toString(), "FamiMF", 3,0, true, "家庭成员变更标识" )))
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
					.addNode(new FieldNode("WidrlType", new MsgField(ContentEnum.MessageType.STRING.toString(), "WidrlType", 3,0, false, "提取方案类型" )))
					.addNode(new FieldNode("PhonMf", new MsgField(ContentEnum.MessageType.STRING.toString(), "PhonMf", 3,0, true, "手机号码变更标识" )))
					.addNode(new FieldNode("MobiTl", new MsgField(ContentEnum.MessageType.STRING.toString(), "MobiTl", 20,0, false, "新手机号码" )))
					.addNode(new FieldNode("CardMF", new MsgField(ContentEnum.MessageType.STRING.toString(), "CardMF", 3,0, true, "新的绑定卡变更标识" )))
					.addNode(new FieldNode("ToAcct", new MsgField(ContentEnum.MessageType.STRING.toString(), "ToAcct", 40,0, false, "新的绑定卡账号" )))
					.addNode(new FieldNode("BankNa", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankNa", 100,0, false, "行别" )))
					.addNode(new FieldNode("AccRge", new MsgField(ContentEnum.MessageType.STRING.toString(), "AccRge", 100,0, false, "受理范围" )))
					.addNode(new FieldNode("TranPw", new MsgField(ContentEnum.MessageType.STRING.toString(), "TranPw", 512,0, false, "自助服务开通密码" )))
					.addNode(new FieldNode("ChkNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ChkNo", 40,0, true, "机构身份识别码（入参）" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S012001201_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("ReqId", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReqId", 20,0, false, "业务编号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

