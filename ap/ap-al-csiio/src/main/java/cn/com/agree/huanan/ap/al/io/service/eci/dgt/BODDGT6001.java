package cn.com.agree.huanan.ap.al.io.service.eci.dgt;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODDGT6001  东莞通预充值查询 
 *  BODDGT6001 8810001
 *  东莞通系统
 * @author XZF
 */
@Component
public class BODDGT6001 extends EciChannelService {

	private static BODDGT6001_I i = new BODDGT6001_I();
	private static BODDGT6001_O o = new BODDGT6001_O();
	public BODDGT6001() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODDGT6001_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Mes_MessageDateTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "Mes_MessageDateTime", 14,0, true, "报文发送时间" )))
					.addNode(new FieldNode("Mes_MAC", new MsgField(ContentEnum.MessageType.STRING.toString(), "Mes_MAC", 8,0, false, "通讯押码" )))
					.addNode(new FieldNode("Tra_Unitid", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Unitid", 8,0, false, "营运单位代码" )))
					.addNode(new FieldNode("Tra_TransType", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TransType", 2,0, true, "业务类型" )))
					.addNode(new FieldNode("Tra_LocalSequence", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_LocalSequence", 10,0, false, "发送方报文流水号" )))
					.addNode(new FieldNode("Tra_Posid", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Posid", 12,0, false, "清算设备代码" )))
					.addNode(new FieldNode("Tra_CardId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardId", 16,0, false, "卡内号" )))
					.addNode(new FieldNode("Tra_Termid", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Termid", 12,0, false, "企业设备代码" )))
					.addNode(new FieldNode("Tra_CityCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CityCode", 4,0, false, "城市代码" )))
					.addNode(new FieldNode("Tra_Deposit", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Deposit", 8,0, false, "押金" )))
					.addNode(new FieldNode("Tra_CardModel", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardModel", 1,0, false, "卡型，1-CPU卡" )))
					.addNode(new FieldNode("Tra_OrigAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_OrigAmt", 8,0, false, "应收金额" )))
					.addNode(new FieldNode("Tra_TxnAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TxnAmt", 8,0, false, "实充金额" )))
					.addNode(new FieldNode("Tra_SrcAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_SrcAmt", 8,0, false, "卡上原额" )))
					.addNode(new FieldNode("Tra_TxnFee", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TxnFee", 8,0, false, "交易手续费" )))
					.addNode(new FieldNode("Tra_CodeType", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CodeType", 2,0, false, "证件类型" )))
					.addNode(new FieldNode("Tra_CodeId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CodeId", 20,0, false, "证件号" )))
					.addNode(new FieldNode("Tra_Name", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_Name", 20,0, false, "姓名" )))
					.addNode(new FieldNode("Tra_TradSpecFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TradSpecFlag", 1,0, false, "特有数据类型" )))
					.addNode(new FieldNode("Tra_TradSpec", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TradSpec", 200,0, false, "特有数据" )))
					.addNode(new FieldNode("Tra_OperId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_OperId", 16,0, false, "操作员号" )))
					);
			messageNode.addStructNode(new StructNode("AppHeader",true,"Ctrl")
					.addNode(new FieldNode("GloSeqNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "GloSeqNo", 30,0, true, "全局流水号" )))
					.addNode(new FieldNode("SrcCalCod", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcCalCod", 3,0, true, "源请求方渠道编号" )))
					.addNode(new FieldNode("SrcChannelDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcChannelDate", 8,0, true, "源请求方渠道日期" )))
					.addNode(new FieldNode("SrcChannelSerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcChannelSerno", 30,0, true, "源请求方渠道流水" )))
					.addNode(new FieldNode("eciSeverId", new MsgField(ContentEnum.MessageType.STRING.toString(), "eciSeverId", 10,0, true, "ECI服务接口ID" )))
					.addNode(new FieldNode("xmlflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "xmlflag", 1,0, false, "报文标识" )))	//继续确认
					.addNode(new FieldNode("templateCodeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "templateCodeName", 6,0, false, "模板名称" )))//继续确认
					.addNode(new FieldNode("transCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "transCode", 6,0, false, "交易代码" )))//继续确认
					.addNode(new FieldNode("sysId", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysId", 6,0, false, "系统标识" )))//继续确认
					.addNode(new FieldNode("channelCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelCode", 3,0, false, "渠道分类" )))//继续确认
					.addNode(new FieldNode("subchannelCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "subchannelCode", 3,0, false, "渠道标识" )))//继续确认
					.addNode(new FieldNode("tradeFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradeFlag", 1,0, false, "是否需要勾兑" )))//继续确认
					.addNode(new FieldNode("checkFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "checkFlag", 1,0, false, "是否需要判重" )))//继续确认
					.addNode(new FieldNode("prcscd", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcscd", 20,0, true, "渠道处理码" )))
					.addNode(new FieldNode("channelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelserno", 40,0, true, "渠道分类流水号" )))
					.addNode(new FieldNode("vm_tellerflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_tellerflag", 1,0, false, "柜员使用标志" )))
					.addNode(new FieldNode("vm_sessid", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_sessid", 32,0, false, "虚拟柜员会话标识" )))
					.addNode(new FieldNode("vm_zoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_zoneno", 10,0, false, "虚拟柜员操作分行" )))
					.addNode(new FieldNode("vm_mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_mbrno", 10,0, false, "虚拟柜员操作支行" )))
					.addNode(new FieldNode("vm_brno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_brno", 10,0, false, "虚拟柜员操作网点" )))
					.addNode(new FieldNode("vm_tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_tellerno", 10,0, false, "虚拟柜员" )))
					.addNode(new FieldNode("vm_tellertp", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_tellertp", 1,0, false, "虚拟柜员柜员类别" )))
					.addNode(new FieldNode("vm_csbxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_csbxno", 10,0, false, "虚拟柜员柜员钱箱" )))
					.addNode(new FieldNode("vm_dutytp", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_dutytp", 10,0, false, "虚拟柜员岗位类型" )))
					.addNode(new FieldNode("vm_dutyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_dutyno", 20,0, false, "虚拟柜员岗位编号" )))
					.addNode(new FieldNode("sessid", new MsgField(ContentEnum.MessageType.STRING.toString(), "sessid", 32,0, false, "会话标识" )))
					.addNode(new FieldNode("zoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "zoneno", 10,0, false, "操作分行" )))
					.addNode(new FieldNode("isreauth", new MsgField(ContentEnum.MessageType.STRING.toString(), "isreauth", 10,0, false, "是否" )))
					.addNode(new FieldNode("mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mbrno", 10,0, false, "操作支行" )))
					.addNode(new FieldNode("brno", new MsgField(ContentEnum.MessageType.STRING.toString(), "brno", 10,0, false, "操作网点" )))
					.addNode(new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno", 10,0, false, "操作柜员" )))
					.addNode(new FieldNode("tellertp", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellertp", 1,0, false, "柜员类别" )))
					.addNode(new FieldNode("csbxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "csbxno", 10,0, false, "柜员钱箱号" )))
					.addNode(new FieldNode("dutytp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutytp", 10,0, false, "岗位类型" )))
					.addNode(new FieldNode("dutyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutyno", 20,0, false, "实体岗位编号" )))
					.addNode(new FieldNode("authno", new MsgField(ContentEnum.MessageType.STRING.toString(), "authno", 10,0, false, "授权员" )))
					.addNode(new FieldNode("isreauth", new MsgField(ContentEnum.MessageType.STRING.toString(), "isreauth", 10,0, false, "授权" )))
					.addNode(new FieldNode("authpw", new MsgField(ContentEnum.MessageType.STRING.toString(), "authpw", 64,0, false, "授权员密码" )))
					.addNode(new FieldNode("authmg", new MsgField(ContentEnum.MessageType.STRING.toString(), "authmg", 512,0, false, "授权员指纹" )))
					.addNode(new FieldNode("authce", new MsgField(ContentEnum.MessageType.STRING.toString(), "authce", 4,0, false, "授权员验证类型" )))
					.addNode(new FieldNode("authmanfttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "authmanfttype", 1,0, false, "授权员指纹厂商" )))
					.addNode(new FieldNode("replyquery", new MsgField(ContentEnum.MessageType.STRING.toString(), "replyquery", 20,0, false, "请求应答队列名" )))
					);
					
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODDGT6001_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("Tra_CenterSettedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CenterSettedate", 8,0, false, "中心结算日期" )))
					.addNode(new FieldNode("Tra_CenterSequence", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CenterSequence", 10,0, false, "中心流水号" )))
					.addNode(new FieldNode("Tra_CardFaceId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardFaceId", 16,0, false, "卡面号" )))
					.addNode(new FieldNode("Tra_CardId", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardId", 16,0, false, "卡内号" )))
					.addNode(new FieldNode("Tra_CardMKnd", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardMKnd", 2,0, false, "卡主类型" )))
					.addNode(new FieldNode("Tra_CardSKind", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_CardSKind", 2,0, false, "卡子类型" )))
					.addNode(new FieldNode("Tra_SaleMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_SaleMode", 2,0, false, "发售方式" )))
					.addNode(new FieldNode("Tra_MaxLimit", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_MaxLimit", 8,0, false, "卡片余额上限 " )))
					.addNode(new FieldNode("Tra_AccBal", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_AccBal", 8,0, false, "预充值帐户余额 " )))
					.addNode(new FieldNode("Tra_TipFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TipFlag", 2,0, false, "提示标识 " )))
					.addNode(new FieldNode("Tra_OrigAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_OrigAmt", 8,0, false, "应收金额" )))
					.addNode(new FieldNode("Tra_TxnAmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "Tra_TxnAmt", 8,0, false, "实充金额" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

