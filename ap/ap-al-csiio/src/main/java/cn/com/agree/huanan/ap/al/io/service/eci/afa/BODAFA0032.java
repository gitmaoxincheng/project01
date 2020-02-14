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
 * 
 * @author zhuzc
 * BASESVC BODAFA0032 贷记卡卡号查询卡信息
 * BODAFA0032 cd020
 * ATM
 */
@Component
public class BODAFA0032 extends EciChannelService{
	private static BODAFA0032_I i = new BODAFA0032_I();
	private static BODAFA0032_O o = new BODAFA0032_O();
	public BODAFA0032() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0032_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 19,0, false, "卡号" )))
					.addNode(new FieldNode("pin_flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pin_flag", 1,0, false, "检查标识" )))
					.addNode(new FieldNode("passwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "passwd", 300,0, false, "密码" )))
					.addNode(new FieldNode("needpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "needpwd", 1,0, false, "是否需求转密" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 25,0, false, "密码序号" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 25,0, false, "密码序号" )))

					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0032_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 19,0, false, "卡号" )))
					.addNode(new FieldNode("keytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "keytype", 2,0, false, "证件类型" )))
					.addNode(new FieldNode("custid", new MsgField(ContentEnum.MessageType.STRING.toString(), "custid", 18,0, false, "证件号码" )))
					.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 30,0, false, "持卡人姓名" )))
					.addNode(new FieldNode("embname", new MsgField(ContentEnum.MessageType.STRING.toString(), "embname", 26,0, false, "凸字姓名" )))
					.addNode(new FieldNode("issdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "issdate", 8,0, false, "发卡日期" )))
					.addNode(new FieldNode("opendate", new MsgField(ContentEnum.MessageType.STRING.toString(), "opendate", 8,0, false, "开卡日期" )))
					.addNode(new FieldNode("pexdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "pexdate", 8,0, false, "上次续卡日期" )))
					.addNode(new FieldNode("crdlimt", new MsgField(ContentEnum.MessageType.STRING.toString(), "crdlimt", 12,0, false, "信用额度" )))
					.addNode(new FieldNode("avlimt", new MsgField(ContentEnum.MessageType.STRING.toString(), "avlimt", 12,0, false, "可用额度" )))
					.addNode(new FieldNode("mpcredit", new MsgField(ContentEnum.MessageType.STRING.toString(), "mpcredit", 12,0, false, "分期付款信用额度" )))
					.addNode(new FieldNode("mpavbile", new MsgField(ContentEnum.MessageType.STRING.toString(), "mpavbile", 12,0, false, "分期付款可用额度" )))
					.addNode(new FieldNode("cashcredit", new MsgField(ContentEnum.MessageType.STRING.toString(), "cashcredit", 12,0, false, "预借现金信用额度" )))
					.addNode(new FieldNode("cashavbile", new MsgField(ContentEnum.MessageType.STRING.toString(), "cashavbile", 12,0, false, "预借现金可用额度" )))
					.addNode(new FieldNode("xcredlimit", new MsgField(ContentEnum.MessageType.STRING.toString(), "xcredlimit", 12,0, false, "第二币种信用额度" )))
					.addNode(new FieldNode("xavlimt", new MsgField(ContentEnum.MessageType.STRING.toString(), "xavlimt", 12,0, false, "第二币种可用额度" )))
					.addNode(new FieldNode("cardstat", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardstat", 2,0, false, "卡片状态" )))
					.addNode(new FieldNode("maflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "maflag", 1,0, false, "主附卡标志" )))
					.addNode(new FieldNode("lmt_opt", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmt_opt", 1,0, false, "附卡额度设置方式" )))
					.addNode(new FieldNode("lossdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "lossdt", 8,0, false, "挂失日期" )))
					.addNode(new FieldNode("expire", new MsgField(ContentEnum.MessageType.STRING.toString(), "expire", 8,0, false, "卡片有效期" )))
					.addNode(new FieldNode("prod_desc", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_desc", 30,0, false, "卡片种类描述" )))
					.addNode(new FieldNode("pinchk", new MsgField(ContentEnum.MessageType.STRING.toString(), "pinchk", 1,0, false, "消费是否使用密码" )))
					.addNode(new FieldNode("withdrw", new MsgField(ContentEnum.MessageType.STRING.toString(), "withdrw", 1,0, false, "是否开通取现功能" )))
					.addNode(new FieldNode("pbflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "pbflag", 1,0, false, "个人卡标志" )))
					.addNode(new FieldNode("fee_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_code", 2,0, false, "年费代码" )))
					.addNode(new FieldNode("pin_faild", new MsgField(ContentEnum.MessageType.STRING.toString(), "pin_faild", 1,0, false, "当日密码错误次数" )))
					.addNode(new FieldNode("pin_failt", new MsgField(ContentEnum.MessageType.STRING.toString(), "pin_failt", 2,0, false, "累计密码错误次数" )))
					.addNode(new FieldNode("pin_sts", new MsgField(ContentEnum.MessageType.STRING.toString(), "pin_sts", 1,0, false, "卡锁定状态" )))
					.addNode(new FieldNode("pin_failday", new MsgField(ContentEnum.MessageType.STRING.toString(), "pin_failday", 8,0, false, "密码上次使用日期" )))
					.addNode(new FieldNode("pinsetno", new MsgField(ContentEnum.MessageType.STRING.toString(), "pinsetno", 2,0, false, "密码函重置次数" )))
					.addNode(new FieldNode("pinsetday", new MsgField(ContentEnum.MessageType.STRING.toString(), "pinsetday", 8,0, false, "密码函上次重置日期" )))
					.addNode(new FieldNode("app_sourc", new MsgField(ContentEnum.MessageType.STRING.toString(), "app_sourc", 10,0, false, "卡片专案代码" )))
					.addNode(new FieldNode("lmp_limit", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmp_limit", 12,0, false, "大额分期付款可用额度" )))
					.addNode(new FieldNode("lmp_avail", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmp_avail", 12,0, false, "大额分期付款可取额度" )))
					.addNode(new FieldNode("cdfrm1", new MsgField(ContentEnum.MessageType.STRING.toString(), "cdfrm1", 4,0, false, "卡片版面" )))
					.addNode(new FieldNode("activday", new MsgField(ContentEnum.MessageType.STRING.toString(), "activday", 8,0, false, "卡片激活日期" )))
					.addNode(new FieldNode("cancl_day", new MsgField(ContentEnum.MessageType.STRING.toString(), "cancl_day", 8,0, false, "上次修改卡片状态的日期" )))
					.addNode(new FieldNode("issue_nbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "issue_nbr", 3,0, false, "换卡次数" )))
					.addNode(new FieldNode("fee_month", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_month", 4,0, false, "下次年费收取月份" )))
					.addNode(new FieldNode("ori_activday", new MsgField(ContentEnum.MessageType.STRING.toString(), "ori_activday", 8,0, false, "卡片原始激活日期" )))
					.addNode(new FieldNode("cancl_reas", new MsgField(ContentEnum.MessageType.STRING.toString(), "cancl_reas", 2,0, false, "销卡原因代码" )))
					.addNode(new FieldNode("product", new MsgField(ContentEnum.MessageType.STRING.toString(), "product", 4,0, false, "产品编号" )))
					.addNode(new FieldNode("category", new MsgField(ContentEnum.MessageType.STRING.toString(), "category", 4,0, false, "账户类别" )))
					.addNode(new FieldNode("curr_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "curr_num", 3,0, false, "第一币种" )))
					.addNode(new FieldNode("curr_num2", new MsgField(ContentEnum.MessageType.STRING.toString(), "curr_num2", 3,0, false, "第二币种" )))
					.addNode(new FieldNode("add_rel", new MsgField(ContentEnum.MessageType.STRING.toString(), "add_rel", 1,0, false, "附卡与主卡持卡人关系" )))
					.addNode(new FieldNode("pin_set", new MsgField(ContentEnum.MessageType.STRING.toString(), "pin_set", 1,0, false, "是否设置消费密码" )))
					.addNode(new FieldNode("issue_sts", new MsgField(ContentEnum.MessageType.STRING.toString(), "issue_sts", 1,0, false, "卡片状态" )))
					.addNode(new FieldNode("issue_reas", new MsgField(ContentEnum.MessageType.STRING.toString(), "issue_reas", 1,0, false, "发卡原因" )))
					.addNode(new FieldNode("cc_yn", new MsgField(ContentEnum.MessageType.STRING.toString(), "cc_yn", 1,0, false, "本币网上交易开关" )))
					.addNode(new FieldNode("ec_yn", new MsgField(ContentEnum.MessageType.STRING.toString(), "ec_yn", 1,0, false, "外币网上交易开关" )))
					.addNode(new FieldNode("aecamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "aecamt", 9,0, false, "外币网上交易限额" )))
					.addNode(new FieldNode("accamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "accamt", 9,0, false, "本币网上交易限额" )))
					.addNode(new FieldNode("aecamt_tdy", new MsgField(ContentEnum.MessageType.STRING.toString(), "aecamt_tdy", 11,0, false, "外币网上交易已用限额" )))
					.addNode(new FieldNode("accamt_tdy", new MsgField(ContentEnum.MessageType.STRING.toString(), "accamt_tdy", 1,0, false, "本币网上交易已用限额" )))
					.addNode(new FieldNode("activech", new MsgField(ContentEnum.MessageType.STRING.toString(), "activech", 2,0, false, "激活渠道" )))
					.addNode(new FieldNode("emboss_cpy", new MsgField(ContentEnum.MessageType.STRING.toString(), "emboss_cpy", 26,0, false, "凸字公司名" )))
					.addNode(new FieldNode("prod_level", new MsgField(ContentEnum.MessageType.STRING.toString(), "prod_level", 2,0, false, "卡种级别" )))
					.addNode(new FieldNode("brn_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "brn_code", 10,0, false, "外部分行号" )))
					.addNode(new FieldNode("ab_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "ab_code", 6,0, false, "卡片推广机构" )))
					.addNode(new FieldNode("vfcrlmtset", new MsgField(ContentEnum.MessageType.STRING.toString(), "vfcrlmtset", 1,0, false, "附卡使用限额设置方式" )))
					.addNode(new FieldNode("amt_crelmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "amt_crelmt", 10,0, false, "附卡限额" )))
					.addNode(new FieldNode("avl_crdlmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "avl_crdlmt", 12,0, false, "附卡可用限额" )))
					.addNode(new FieldNode("card_to", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_to", 1,0, false, "卡片寄送地址类型" )))
					.addNode(new FieldNode("repcard", new MsgField(ContentEnum.MessageType.STRING.toString(), "repcard", 1,0, false, "已换卡标志" )))
					.addNode(new FieldNode("newcard", new MsgField(ContentEnum.MessageType.STRING.toString(), "newcard", 19,0, false, "换卡后新卡卡号" )))
					.addNode(new FieldNode("pboc_yn", new MsgField(ContentEnum.MessageType.STRING.toString(), "pboc_yn", 2,0, false, "IC卡？" )))
					.addNode(new FieldNode("active_fst", new MsgField(ContentEnum.MessageType.STRING.toString(), "active_fst", 8,0, false, "首次激活日期" )))
					.addNode(new FieldNode("cv2_fails", new MsgField(ContentEnum.MessageType.STRING.toString(), "cv2_fails", 2,0, false, "CVV2总累计连续错误次数" )))
					.addNode(new FieldNode("cv2_faildl", new MsgField(ContentEnum.MessageType.STRING.toString(), "cv2_faildl", 2,0, false, "CVV2当日累计连续错误次数" )))
					.addNode(new FieldNode("orissusdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "orissusdt", 8,0, false, "原始发卡日期" )))
					.addNode(new FieldNode("vcn_sts", new MsgField(ContentEnum.MessageType.STRING.toString(), "vcn_sts", 1,0, false, "虚拟卡状态" )))
					.addNode(new FieldNode("iss_mod", new MsgField(ContentEnum.MessageType.STRING.toString(), "iss_mod", 2,0, false, "发卡模式" )))
					.addNode(new FieldNode("microfilm", new MsgField(ContentEnum.MessageType.STRING.toString(), "microfilm", 16,0, false, "申请书条形码" )))
					.addNode(new FieldNode("third_party", new MsgField(ContentEnum.MessageType.STRING.toString(), "third_party", 1,0, false, "第三方支付开关" )))
					.addNode(new FieldNode("acti_fails", new MsgField(ContentEnum.MessageType.STRING.toString(), "acti_fails", 3,0, false, "联机激活连续失败次数" )))
					.addNode(new FieldNode("rmbbill", new MsgField(ContentEnum.MessageType.STRING.toString(), "rmbbill", 1,0, false, "外卡交易第一币种入账" )))
					.addNode(new FieldNode("oldcard", new MsgField(ContentEnum.MessageType.STRING.toString(), "oldcard", 19,0, false, "换卡前旧卡卡号" )))
					.addNode(new FieldNode("sign_chk", new MsgField(ContentEnum.MessageType.STRING.toString(), "sign_chk", 8,0, false, "申请人签名确认" )))
					.addNode(new FieldNode("actrel_fst", new MsgField(ContentEnum.MessageType.STRING.toString(), "actrel_fst", 8,0, false, "实体卡首次激活日期" )))
					.addNode(new FieldNode("despatch", new MsgField(ContentEnum.MessageType.STRING.toString(), "despatch", 4,0, false, "预定递送方式或递送方式" )))
					.addNode(new FieldNode("dspch_locn", new MsgField(ContentEnum.MessageType.STRING.toString(), "dspch_locn", 4,0, false, "预定递送分行" )))
					.addNode(new FieldNode("prev_canc", new MsgField(ContentEnum.MessageType.STRING.toString(), "prev_canc", 2,0, false, "上次销卡代码" )))
					.addNode(new FieldNode("prev_day", new MsgField(ContentEnum.MessageType.STRING.toString(), "prev_day", 8,0, false, "上次销卡日期" )))
					.addNode(new FieldNode("emboss_sul", new MsgField(ContentEnum.MessageType.STRING.toString(), "emboss_sul", 2,0, false, "凸字左分隔符位置" )))
					.addNode(new FieldNode("emboss_sur", new MsgField(ContentEnum.MessageType.STRING.toString(), "emboss_sur", 2,0, false, "凸字右分隔符前字符长度" )))
					.addNode(new FieldNode("billamt", new MsgField(ContentEnum.MessageType.STRING.toString(), "billamt", 12,0, false, "卡片版面费用" )))
					.addNode(new FieldNode("fee_group", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_group", 4,0, false, "费用组代码" )))
					.addNode(new FieldNode("sign_flag", new MsgField(ContentEnum.MessageType.STRING.toString(), "sign_flag", 1,0, false, "卡片亲见亲签标志" )))
					.addNode(new FieldNode("branch", new MsgField(ContentEnum.MessageType.STRING.toString(), "branch", 4,0, false, "分行编号" )))
					.addNode(new FieldNode("no_chgexp", new MsgField(ContentEnum.MessageType.STRING.toString(), "no_chgexp", 1,0, false, "不更改卡片有效期？" )))
					.addNode(new FieldNode("mast_card", new MsgField(ContentEnum.MessageType.STRING.toString(), "mast_card", 19,0, false, "附卡对应的主卡卡号" )))
					.addNode(new FieldNode("vrf_fails", new MsgField(ContentEnum.MessageType.STRING.toString(), "vrf_fails", 2,0, false, "身份验证总累计错误次数" )))
					.addNode(new FieldNode("vrf_faildl", new MsgField(ContentEnum.MessageType.STRING.toString(), "vrf_faildl", 2,0, false, "身份验证当日累计连续错误次数" )))
					.addNode(new FieldNode("outcsh_yn", new MsgField(ContentEnum.MessageType.STRING.toString(), "outcsh_yn", 1,0, false, "境外取现开关" )))
					.addNode(new FieldNode("outcsh_beg", new MsgField(ContentEnum.MessageType.STRING.toString(), "outcsh_beg", 8,0, false, "境外取现开关生效日期" )))
					.addNode(new FieldNode("outcsh_end", new MsgField(ContentEnum.MessageType.STRING.toString(), "outcsh_end", 8,0, false, "境外取现开关截止日期" )))
					.addNode(new FieldNode("contr_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "contr_type", 1,0, false, "合约类型" )))
					.addNode(new FieldNode("contra_lmt", new MsgField(ContentEnum.MessageType.STRING.toString(), "contra_lmt", 10,0, false, "合约限额" )))
					.addNode(new FieldNode("bill_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "bill_type", 1,0, false, "开票类型" )))
					.addNode(new FieldNode("reserved", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserved", 30,0, false, "保留域" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
