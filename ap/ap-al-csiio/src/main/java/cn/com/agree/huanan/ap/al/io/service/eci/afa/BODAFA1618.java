package cn.com.agree.huanan.ap.al.io.service.eci.afa;

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
 * BASESVC BODAFA1618  财政非税贷记卡缴费 
 *  BODAFA1618 
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1618 extends EciChannelService {

	private static BODAFA1618_I i = new BODAFA1618_I();
	private static BODAFA1618_O o = new BODAFA1618_O();
	public BODAFA1618() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1618_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("unitno", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitno", 30,0, false, "执收单位编码" )))
					.addNode(new FieldNode("unitnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "unitnm", 100,0, false, "执收单位名称" )))
					.addNode(new FieldNode("paysno", new MsgField(ContentEnum.MessageType.STRING.toString(), "paysno", 50,0, false, "缴款通知书号码" )))
					.addNode(new FieldNode("rtnpaysno", new MsgField(ContentEnum.MessageType.STRING.toString(), "rtnpaysno", 50,0, false, "查询缴费返回的缴款通知书号码" )))
					.addNode(new FieldNode("paysnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "paysnm", 100,0, false, "缴款人(单位)名称" )))
					.addNode(new FieldNode("payday", new MsgField(ContentEnum.MessageType.STRING.toString(), "payday", 8,0, false, "缴款日期" )))
					.addNode(new FieldNode("total_amt", new MsgField(ContentEnum.MessageType.STRING.toString(), "total_amt", 16,0, false, "应收总本金" )))
					.addNode(new FieldNode("total_fee", new MsgField(ContentEnum.MessageType.STRING.toString(), "total_fee", 16,0, false, "应收总滞纳金" )))
					.addNode(new FieldNode("total_cnt", new MsgField(ContentEnum.MessageType.STRING.toString(), "total_cnt", 1,0, false, "收费项目数" )))
					.addNode(new FieldNode("itemno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "itemno1", 14,0, false, "收费项目编码1" )))
					.addNode(new FieldNode("itemnm1", new MsgField(ContentEnum.MessageType.STRING.toString(), "itemnm1", 100,0, false, "收费项目名称1" )))
					.addNode(new FieldNode("unit01", new MsgField(ContentEnum.MessageType.STRING.toString(), "unit01", 50,0, false, "计费单位1" )))
					.addNode(new FieldNode("paycnt1", new MsgField(ContentEnum.MessageType.STRING.toString(), "paycnt1", 16,0, false, "计费数量1" )))
					.addNode(new FieldNode("change1", new MsgField(ContentEnum.MessageType.STRING.toString(), "change1", 16,0, false, "收费标准1" )))
					.addNode(new FieldNode("payamt1", new MsgField(ContentEnum.MessageType.STRING.toString(), "payamt1", 16,0, false, "应收金额1" )))
					.addNode(new FieldNode("itemno2", new MsgField(ContentEnum.MessageType.STRING.toString(), "itemno2", 14,0, false, "收费项目编码2" )))
					.addNode(new FieldNode("itemnm2", new MsgField(ContentEnum.MessageType.STRING.toString(), "itemnm2", 100,0, false, "收费项目名称2" )))
					.addNode(new FieldNode("unit02", new MsgField(ContentEnum.MessageType.STRING.toString(), "unit02", 50,0, false, "计费单位2" )))
					.addNode(new FieldNode("paycnt2", new MsgField(ContentEnum.MessageType.STRING.toString(), "paycnt2", 16,0, false, "计费数量2" )))
					.addNode(new FieldNode("change2", new MsgField(ContentEnum.MessageType.STRING.toString(), "change2", 16,0, false, "收费标准2" )))
					.addNode(new FieldNode("payamt2", new MsgField(ContentEnum.MessageType.STRING.toString(), "payamt2", 16,0, false, "应收金额2" )))
					.addNode(new FieldNode("itemno3", new MsgField(ContentEnum.MessageType.STRING.toString(), "itemno3", 14,0, false, "收费项目编码3" )))
					.addNode(new FieldNode("itemnm3", new MsgField(ContentEnum.MessageType.STRING.toString(), "itemnm3", 100,0, false, "收费项目名称3" )))
					.addNode(new FieldNode("unit03", new MsgField(ContentEnum.MessageType.STRING.toString(), "unit03", 50,0, false, "计费单位3" )))
					.addNode(new FieldNode("paycnt3", new MsgField(ContentEnum.MessageType.STRING.toString(), "paycnt3", 16,0, false, "计费数量3" )))
					.addNode(new FieldNode("change3", new MsgField(ContentEnum.MessageType.STRING.toString(), "change3", 16,0, false, "收费标准3" )))
					.addNode(new FieldNode("payamt3", new MsgField(ContentEnum.MessageType.STRING.toString(), "payamt3", 16,0, false, "应收金额3" )))
					.addNode(new FieldNode("itemno4", new MsgField(ContentEnum.MessageType.STRING.toString(), "itemno4", 14,0, false, "收费项目编码4" )))
					.addNode(new FieldNode("itemnm4", new MsgField(ContentEnum.MessageType.STRING.toString(), "itemnm4", 100,0, false, "收费项目名称4" )))
					.addNode(new FieldNode("unit04", new MsgField(ContentEnum.MessageType.STRING.toString(), "unit04", 50,0, false, "计费单位4" )))
					.addNode(new FieldNode("paycnt4", new MsgField(ContentEnum.MessageType.STRING.toString(), "paycnt4", 16,0, false, "计费数量4" )))
					.addNode(new FieldNode("change4", new MsgField(ContentEnum.MessageType.STRING.toString(), "change4", 16,0, false, "收费标准4" )))
					.addNode(new FieldNode("payamt4", new MsgField(ContentEnum.MessageType.STRING.toString(), "payamt4", 16,0, false, "应收金额4" )))
					.addNode(new FieldNode("paymemo", new MsgField(ContentEnum.MessageType.STRING.toString(), "paymemo", 500,0, false, "备注" )))
					.addNode(new FieldNode("extnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "extnum", 1,0, false, "额外信息数" )))
					.addNode(new FieldNode("extmemo1", new MsgField(ContentEnum.MessageType.STRING.toString(), "extmemo1", 500,0, false, "额外信息1" )))
					.addNode(new FieldNode("extmemo2", new MsgField(ContentEnum.MessageType.STRING.toString(), "extmemo2", 500,0, false, "额外信息2" )))
					.addNode(new FieldNode("extmemo3", new MsgField(ContentEnum.MessageType.STRING.toString(), "extmemo3", 500,0, false, "额外信息3" )))
					.addNode(new FieldNode("extmemo4", new MsgField(ContentEnum.MessageType.STRING.toString(), "extmemo4", 500,0, false, "额外信息4" )))
					.addNode(new FieldNode("chknum", new MsgField(ContentEnum.MessageType.STRING.toString(), "chknum", 5,0, false, "号码校验码" )))
					.addNode(new FieldNode("allnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "allnum", 5,0, false, "全书校验码" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 20,0, false, "证件类型" )))
					.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 20,0, false, "证件号码" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 35,0, false, "缴款账号" )))
					.addNode(new FieldNode("acctname", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctname", 100,0, false, "缴款户名" )))
					.addNode(new FieldNode("chkpwdflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "chkpwdflag", 1,0, false, "是否需要校验密码标志" )))
					.addNode(new FieldNode("pswd", new MsgField(ContentEnum.MessageType.STRING.toString(), "pswd", 350,0, false, "卡密码" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 1,0, true, "是否需要密码转换" )))
					.addNode(new FieldNode("track2", new MsgField(ContentEnum.MessageType.STRING.toString(), "track2", 32,0, false, "磁道2" )))
					.addNode(new FieldNode("track3", new MsgField(ContentEnum.MessageType.STRING.toString(), "track3", 32,0, false, "磁道3" )))
					.addNode(new FieldNode("mrtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "mrtype", 4,0, false, "商户类型" )))
					.addNode(new FieldNode("pintype", new MsgField(ContentEnum.MessageType.STRING.toString(), "pintype", 3,0, false, "输入方式" )))
					.addNode(new FieldNode("cardsno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardsno", 3,0, false, "卡片序列号" )))
					.addNode(new FieldNode("p_serv", new MsgField(ContentEnum.MessageType.STRING.toString(), "p_serv", 2,0, false, "服务条件码" )))
					.addNode(new FieldNode("p_pintype", new MsgField(ContentEnum.MessageType.STRING.toString(), "p_pintype", 2,0, false, "PIN长度" )))
					.addNode(new FieldNode("ICC_data", new MsgField(ContentEnum.MessageType.STRING.toString(), "ICC_data", 300,0, false, "IC卡数据域" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 20,0, false, "密钥序号" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 10,0, false, "密码来源" )))
					.addNode(new FieldNode("zacctno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zacctno1", 20,0, false, "原密码所涉及的账号字段名" )))
					.addNode(new FieldNode("zpwdfd1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfd1", 20,0, false, "原密码所在字段" )))
					.addNode(new FieldNode("zdcmttp1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmttp1", 20,0, false, "原密码所涉及的账号的凭证字段名" )))
					.addNode(new FieldNode("zdcmtno1", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmtno1", 20,0, false, "原密码所涉及的账号的凭证号字段名" )))
					.addNode(new FieldNode("zacctno2", new MsgField(ContentEnum.MessageType.STRING.toString(), "zacctno2", 20,0, false, "新密码所涉及的账号字段名" )))
					.addNode(new FieldNode("zpwdfd2", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfd2", 20,0, false, "新密码所在字段" )))
					.addNode(new FieldNode("zdcmttp2", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmttp2", 20,0, false, "新密码所涉及的账号的凭证字段名" )))
					.addNode(new FieldNode("zdcmtno2", new MsgField(ContentEnum.MessageType.STRING.toString(), "zdcmtno2", 20,0, false, "新密码所涉及的账号的凭证号字段名" )))
					.addNode(new FieldNode("sellerid", new MsgField(ContentEnum.MessageType.STRING.toString(), "sellerid", 20,0, false, "商户编号" )))
					.addNode(new FieldNode("taxjkcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "taxjkcode", 1,0, false, "缴款方式" )))
					.addNode(new FieldNode("citycode", new MsgField(ContentEnum.MessageType.STRING.toString(), "citycode", 6,0, false, "城市代码" )))
					.addNode(new FieldNode("paymenttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "paymenttype", 1,0, false, "缴款类型" )))
					.addNode(new FieldNode("optFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "optFlag", 1,0, false, "是否首次交易" )))
					.addNode(new FieldNode("termid", new MsgField(ContentEnum.MessageType.STRING.toString(), "termid", 30,0, false, "终端号" )))
					.addNode(new FieldNode("isaccounted", new MsgField(ContentEnum.MessageType.STRING.toString(), "isaccounted", 1,0, true, "是否渠道已记账标识" )))
					.addNode(new FieldNode("msgflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "msgflag", 1,0, false, "收费方式" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1618_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("billno", new MsgField(ContentEnum.MessageType.STRING.toString(), "billno", 20,0, false, "票据号码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

