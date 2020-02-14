package cn.com.agree.huanan.ap.al.io.service.eci.afa;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciFINChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODF510015  新单试算
 * BODF510015 510015 regflw
 *  渠道整合
 * @author JZF
 */
@Component
public class BODF510015 extends EciFINChannelService {

	private static BODF510015_I i = new BODF510015_I();
	private static BODF510015_O o = new BODF510015_O();

	public BODF510015() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF510015_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("gsdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsdm", 4,0, false, "保险公司代码" )))
					.addNode(new FieldNode("ptlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptlsh", 30,0, false, "银行流水号" )))
					.addNode(new FieldNode("bankcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankcode", 10,0, false, "银行总行代码" )))
					.addNode(new FieldNode("zoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "zoneno", 10,0, false, "地区代码" )))
					.addNode(new FieldNode("branch", new MsgField(ContentEnum.MessageType.STRING.toString(), "branch", 16,0, false, "银行网点代码" )))
					.addNode(new FieldNode("bxgslsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxgslsh", 30,0, false, "保险公司的交易流水号" )))
					.addNode(new FieldNode("bxgsjydm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxgsjydm", 10,0, false, "保险公司交易代码" )))
					.addNode(new FieldNode("rbjgdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "rbjgdm", 10,0, false, "人保机构代码" )))
					.addNode(new FieldNode("jyms", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyms", 10,0, false, "交易模式" )))
					.addNode(new FieldNode("jgmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "jgmc", 30,0, false, "银行出单网点名称" )))
					.addNode(new FieldNode("pzxxtbdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "pzxxtbdh", 30,0, false, "投保单号" )))
					.addNode(new FieldNode("bxxxtbrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxtbrq", 8,0, false, "投保日期" )))
					.addNode(new FieldNode("jyzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyzh", 30,0, false, "银行账户" )))
					.addNode(new FieldNode("jzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "jzh", 30,0, false, "介质号" )))
					.addNode(new FieldNode("zhmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "zhmc", 30,0, false, "账户名称" )))
					.addNode(new FieldNode("bxxxkhjl", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxkhjl", 20,0, false, "营销员号" )))
					.addNode(new FieldNode("bxxxkhjlmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxkhjlmc", 20,0, false, "营销柜员名称" )))
					.addNode(new FieldNode("acctype", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctype", 1,0, true, "客户标识类型" )))
					.addNode(new FieldNode("account", new MsgField(ContentEnum.MessageType.STRING.toString(), "account", 20,0, true, "客户标识" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 1,0, true, "证件类型" )))
					.addNode(new FieldNode("tbrxm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrxm", 50,0, false, "投保人姓名" )))
					.addNode(new FieldNode("tbrxb", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrxb", 1,0, false, "投保人性别" )))
					.addNode(new FieldNode("tbrcsrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrcsrq", 8,0, false, "投保人出生日期" )))
					.addNode(new FieldNode("tbrzjlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrzjlx", 1,0, false, "投保人证件类别" )))
					.addNode(new FieldNode("tbrzjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrzjhm", 20,0, false, "投保人证件号码" )))
					.addNode(new FieldNode("tbrzjyxzq", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrzjyxzq", 8,0, false, "投保人证件有效期" )))
					.addNode(new FieldNode("tbrzjyxq", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrzjyxq", 8,0, false, "投保人证件有效期" )))
					.addNode(new FieldNode("tbrgj", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrgj", 5,0, false, "投保人国籍" )))
					.addNode(new FieldNode("tbrjtlxdz", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrjtlxdz", 50,0, false, "投保人地址" )))
					.addNode(new FieldNode("tbrdz", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrdz", 50,0, false, "投保人地址" )))
					.addNode(new FieldNode("tbrjtlxyb", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrjtlxyb", 6,0, false, "投保人邮编" )))
					.addNode(new FieldNode("tbryb", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbryb", 6,0, false, "投保人邮编" )))
					.addNode(new FieldNode("tbrjtlxdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrjtlxdh", 20,0, false, "投保人电话" )))
					.addNode(new FieldNode("tbrdhhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrdhhm", 20,0, false, "投保人电话号码" )))
					.addNode(new FieldNode("tbrsjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrsjhm", 11,0, false, "投保人手机号" )))
					.addNode(new FieldNode("tbremail", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbremail", 50,0, false, "投保人电子邮件" )))
					.addNode(new FieldNode("tbrssqy", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrssqy", 1,0, false, "投保人所属区域" )))
					.addNode(new FieldNode("tbrzydm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrzydm", 30,0, false, "投保人职业代码/工种" )))
					.addNode(new FieldNode("tbrzymc", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrzymc", 30,0, false, "投保人职业名称" )))
					.addNode(new FieldNode("tbrkhlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrkhlx", 1,0, false, "投保人客户类型" )))
					.addNode(new FieldNode("tbrtbrnsr", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrtbrnsr", 15,0, false, "投保人年收入（单位：元）" )))
					.addNode(new FieldNode("tbrnsr", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrnsr", 15,0, false, "投保人年收入" )))
					.addNode(new FieldNode("tbrtbrjtnsr", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrtbrjtnsr", 15,0, false, "投保人家庭年收入（单位：元）" )))
					.addNode(new FieldNode("tbrjtnsr", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrjtnsr", 15,0, false, "投保人家庭收入" )))
					.addNode(new FieldNode("tbrybbrgx", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrybbrgx", 1,0, false, "投保人、被保人关系" )))
					.addNode(new FieldNode("tbrsssx", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrsssx", 5,0, false, "投保人所属市县" )))
					.addNode(new FieldNode("tbrsb", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrsb", 5,0, false, "投保人省别" )))
					.addNode(new FieldNode("bxxxsffdsyr", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxsffdsyr", 1,0, false, "是否法定受益人（YN）" )))
					.addNode(new FieldNode("tbrjmlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrjmlx", 1,0, false, "投保人居民类型" )))
					.addNode(new FieldNode("tbrdwmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrdwmc", 200,0, true, "投保人工作单位" )))
					.addNode(new FieldNode("tbrzgssjm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrzgssjm", 200,0, true, "投保人个人税收居民身份" )))
					.addNode(new FieldNode("tbrwcnrsgbe", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrwcnrsgbe", 200,0, true, "投保人未成年人身故保额" )))
					.addNode(new FieldNode("tbrsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrsg", 15,0, false, "投保人身高" )))
					.addNode(new FieldNode("tbrtz", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrtz", 15,0, false, "投保人体重" )))
					.addNode(new FieldNode("bbrxm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrxm", 50,0, false, "被保人姓名" )))
					.addNode(new FieldNode("bxxxbbrgs", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxbbrgs", 50,0, false, "被保人个数" )))
					.addNode(new FieldNode("bbrbh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrbh", 50,0, false, "被保人编号" )))
					.addNode(new FieldNode("bbrxb", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrxb", 1,0, false, "被保人个数" )))
					.addNode(new FieldNode("bbrsfyzj", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrsfyzj", 1,0, false, "被保人是否有重疾(YN)" )))
					.addNode(new FieldNode("bbrsfcswxzy", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrsfcswxzy", 1,0, false, "被保人是否从事危险职业(YN)" )))
					.addNode(new FieldNode("bbrcsrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrcsrq", 8,0, false, "被保人出生日期" )))
					.addNode(new FieldNode("bbrzjlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrzjlx", 1,0, false, "被保人证件类型" )))
					.addNode(new FieldNode("bbrzjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrzjhm", 20,0, false, "被保人证件号码" )))
					.addNode(new FieldNode("bbrzjyxzq", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrzjyxzq", 8,0, false, "被保人证件有效期" )))
					.addNode(new FieldNode("bbrzjyxq", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrzjyxq", 8,0, false, "被保人证件有效期" )))
					.addNode(new FieldNode("bbrlxdz", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrlxdz", 50,0, false, "被保人地址" )))
					.addNode(new FieldNode("bbrdz", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrdz", 50,0, false, "被保人地址" )))
					.addNode(new FieldNode("bbrlxyb", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrlxyb", 6,0, false, "被保人邮编" )))
					.addNode(new FieldNode("bbryb", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbryb", 6,0, false, "被保人邮编" )))
					.addNode(new FieldNode("bbrlxdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrlxdh", 20,0, false, "被保人电话" )))
					.addNode(new FieldNode("bbrdhhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrdhhm", 20,0, false, "被保人电话" )))
					.addNode(new FieldNode("bbrsjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrsjhm", 11,0, false, "被保人手机号" )))
					.addNode(new FieldNode("bbremail", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbremail", 50,0, false, "被保人电子邮件" )))
					.addNode(new FieldNode("bbrssqy", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrssqy", 1,0, false, "被保人所属区域" )))
					.addNode(new FieldNode("bbrzydm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrzydm", 10,0, false, "被保人职业工种" )))
					.addNode(new FieldNode("bbrzymc", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrzymc", 50,0, false, "被保人职业名称" )))
					.addNode(new FieldNode("bbrnsr", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrnsr", 15,0, false, "被保人收入" )))
					.addNode(new FieldNode("bbrgj", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrgj", 4,0, false, "被保人国籍" )))
					.addNode(new FieldNode("bbrsb", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrsb", 10,0, false, "被保人省别" )))
					.addNode(new FieldNode("bbrsssx", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrsssx", 10,0, false, "被保人所属市县" )))
					.addNode(new FieldNode("bbrxl", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrxl", 50,0, false, "被保人学历" )))
					.addNode(new FieldNode("bbrdwmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrdwmc", 200,0, true, "被保人工作单位" )))
					.addNode(new FieldNode("bbrzgssjm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrzgssjm", 200,0, true, "被保人个人税收居民身份" )))
					.addNode(new FieldNode("bbrsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrsg", 15,0, false, "被保人身高" )))
					.addNode(new FieldNode("bbrtz", new MsgField(ContentEnum.MessageType.STRING.toString(), "bbrtz", 15,0, false, "被保人体重" )))
					.addNode(new FieldNode("syrsl", new MsgField(ContentEnum.MessageType.STRING.toString(), "syrsl", 10,0, false, "受益人数量" )))
					.addNode(new StructNode("syr", false,"syr_list")
							.addNode(new FieldNode("syr_syrlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "syr_syrlx", 1,0, false, "受益人类型" )))
							.addNode(new FieldNode("syr_sysx", new MsgField(ContentEnum.MessageType.STRING.toString(), "syr_sysx", 5,0, false, "受益人受益顺序" )))
							.addNode(new FieldNode("syr_xm", new MsgField(ContentEnum.MessageType.STRING.toString(), "syr_xm", 50,0, false, "受益人姓名" )))
							.addNode(new FieldNode("syr_xb", new MsgField(ContentEnum.MessageType.STRING.toString(), "syr_xb", 1,0, false, "受益人性别" )))
							.addNode(new FieldNode("syr_csrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "syr_csrq", 8,0, false, "受益人出生日期" )))
							.addNode(new FieldNode("syr_zjlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "syr_zjlx", 5,0, false, "受益人证件类型" )))
							.addNode(new FieldNode("syr_zjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "syr_zjhm", 20,0, false, "受益人证件号码" )))
							.addNode(new FieldNode("syr_zjyxzq", new MsgField(ContentEnum.MessageType.STRING.toString(), "syr_zjyxzq", 8,0, false, "受益人证件有效期" )))
							.addNode(new FieldNode("syr_xzdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "syr_xzdm", 20,0, false, "受益人险种代码" )))
							.addNode(new FieldNode("syr_ybbrgx", new MsgField(ContentEnum.MessageType.STRING.toString(), "syr_ybbrgx", 1,0, false, "受益人、被保人关系" )))
							.addNode(new FieldNode("syr_sybl", new MsgField(ContentEnum.MessageType.STRING.toString(), "syr_sybl", 3,0, false, "受益人受益比例" )))
							.addNode(new FieldNode("syr_lxdz", new MsgField(ContentEnum.MessageType.STRING.toString(), "syr_lxdz", 50,0, false, "受益人地址" )))
							.addNode(new FieldNode("syr_lxdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "syr_lxdh", 20,0, false, "受益人电话" )))
							.addNode(new FieldNode("syr_sjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "syr_sjhm", 11,0, false, "受益人手机号码" )))
							.addNode(new FieldNode("syr_ssqy", new MsgField(ContentEnum.MessageType.STRING.toString(), "syr_ssqy", 1,0, false, "受益人所属区域" )))
							.addNode(new FieldNode("syr_gj", new MsgField(ContentEnum.MessageType.STRING.toString(), "syr_gj", 4,0, false, "受益人国籍" )))
							).addNode(new FieldNode("cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpdm", 10,0, false, "主险险种代码" )))
					.addNode(new FieldNode("zfxbz", new MsgField(ContentEnum.MessageType.STRING.toString(), "zfxbz", 1,0, false, "主附险标志" )))
					.addNode(new FieldNode("bxxxxzgs", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxxzgs", 2,0, false, "险种个数" )))
					.addNode(new ArrayNode("xz_list",false,"xz")
							.addNode(new FieldNode("bxxxcpid", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxcpid", 10,0, false, "险种编号" )))
							).addNode(new FieldNode("bxxxtbfs", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxtbfs", 10,0, false, "主险份数" )))
					.addNode(new FieldNode("bxxxzxbf", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxzxbf", 15,0, false, "主险保费" )))
					.addNode(new FieldNode("bxxxzxbe", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxzxbe", 15,0, false, "主险保额" )))
					.addNode(new FieldNode("bxxxbddsfs", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxbddsfs", 1,0, false, "保单递送方式" )))
					.addNode(new FieldNode("bxxxsqjfxs", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxsqjfxs", 1,0, false, "首期交费形式" )))
					.addNode(new FieldNode("bxxxxqjfxs", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxxqjfxs", 1,0, false, "续期交费形式" )))
					.addNode(new FieldNode("bxxxxqzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxxqzh", 20,0, false, "期缴代扣账号" )))
					.addNode(new FieldNode("bxxxjffs", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxjffs", 1,0, false, "缴费方式" )))
					.addNode(new FieldNode("bxxxhllqfs", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxhllqfs", 10,0, false, "红利领取方式" )))
					.addNode(new FieldNode("bxxxjfnx", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxjfnx", 10,0, false, "缴费年期" )))
					.addNode(new FieldNode("bxxxjfnqlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxjfnqlx", 1,0, false, "缴费年期类型" )))
					.addNode(new FieldNode("bxxxlqnq", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxlqnq", 10,0, false, "领取年期" )))
					.addNode(new FieldNode("bxxxlqnqlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxlqnqlx", 1,0, false, "领取方式" )))
					.addNode(new FieldNode("bxxxbznqlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxbznqlx", 1,0, false, "保险年期类型" )))
					.addNode(new FieldNode("bxxxbznq", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxbznq", 10,0, false, "保险年期" )))
					.addNode(new FieldNode("bxxxkhyhzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxkhyhzh", 20,0, false, "客户银行账号" )))
					.addNode(new FieldNode("bxxxbdsddz", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxbdsddz", 30,0, false, "保单送达地址" )))
					.addNode(new FieldNode("bxxxsffdsyr", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxsffdsyr", 1,0, false, "是否法定受益人" )))
					.addNode(new FieldNode("bxxxjejqbz", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxjejqbz", 1,0, false, "自动垫交标识" )))
					.addNode(new FieldNode("bxxxrqbz", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxrqbz", 1,0, false, "投资日期标识" )))
					.addNode(new FieldNode("bxxxtjrbh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxtjrbh", 10,0, false, "推荐人编号" )))
					.addNode(new FieldNode("bxxxscjlqms", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxscjlqms", 10,0, false, "年金/生存金领取方式" )))
					.addNode(new FieldNode("bxxxtzzhgs", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxtzzhgs", 2,0, false, "投资账户个数" )))
					.addNode(new ArrayNode("tzzh_list",false,"tzzh")
							.addNode(new FieldNode("tzzhzhdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "tzzhzhdm", 10,0, false, "投资账户编码" )))
							.addNode(new FieldNode("tzzhzhbl", new MsgField(ContentEnum.MessageType.STRING.toString(), "tzzhzhbl", 6,0, false, "投资庄户比例" )))
							).addNode(new FieldNode("cplb_cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplb_cpdm", 10,0, false, "险种代码" )))
					.addNode(new FieldNode("cplb_hllqfs", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplb_hllqfs", 2,0, false, "红利领取方式" )))
					.addNode(new FieldNode("cplb_tbfs", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplb_tbfs", 10,0, false, "险种份数" )))
					.addNode(new FieldNode("cplb_jfnqlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplb_jfnqlx", 2,0, false, "缴费年期类型" )))
					.addNode(new FieldNode("cplb_jfnx", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplb_jfnx", 4,0, false, "缴费年期" )))
					.addNode(new FieldNode("cplb_bznqlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplb_bznqlx", 2,0, false, "保障年期类型" )))
					.addNode(new FieldNode("cplb_bznq", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplb_bznq", 4,0, false, "保障年期" )))
					.addNode(new FieldNode("cplb_bxje", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplb_bxje", 15,0, false, "保额" )))
					.addNode(new FieldNode("cplb_zxbf", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplb_zxbf", 15,0, false, "保费" )))
					.addNode(new FieldNode("cplb_lqnqlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplb_lqnqlx", 4,0, false, "领取年期类型" )))
					.addNode(new FieldNode("cplb_qsnl", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplb_qsnl", 4,0, false, "领取起始年龄" )))
					.addNode(new FieldNode("cplb_jsnl", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplb_jsnl", 4,0, false, "领取结束年龄" )))
					.addNode(new FieldNode("cplb_bxsxsj", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplb_bxsxsj", 30,0, false, "保险生效时间(小额信贷)" )))
					.addNode(new FieldNode("cplb_bxjssj", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplb_bxjssj", 30,0, false, "保险结束时间(小额信贷)" )))
					.addNode(new FieldNode("cplb_dkhtbh", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplb_dkhtbh", 15,0, false, "贷款合同编号(小额信贷)" )))
					.addNode(new FieldNode("cplb_dkje", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplb_dkje", 15,0, false, "贷款金额(小额信贷)" )))
					.addNode(new FieldNode("cplb_dkqsrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplb_dkqsrq", 30,0, false, "贷款起始日期(小额信贷)" )))
					.addNode(new FieldNode("cplb_dkjsrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "cplb_dkjsrq", 30,0, false, "贷款结束日期(小额信贷)" )))
					.addNode(new FieldNode("fjxsl", new MsgField(ContentEnum.MessageType.STRING.toString(), "fjxsl", 10,0, false, "附加险数量" )))
					.addNode(new StructNode("fjxlb_list", false,"fjxlb")
							.addNode(new FieldNode("fjxlb_fjxbz", new MsgField(ContentEnum.MessageType.STRING.toString(), "fjxlb_fjxbz", 1,0, false, "附加险标志" )))
							.addNode(new FieldNode("fjxlb_cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "fjxlb_cpdm", 10,0, false, "附加险代码" )))
							.addNode(new FieldNode("fjxlb_tbfs", new MsgField(ContentEnum.MessageType.STRING.toString(), "fjxlb_tbfs", 10,0, false, "附加险份数" )))
							.addNode(new FieldNode("fjxlb_qjbf", new MsgField(ContentEnum.MessageType.STRING.toString(), "fjxlb_qjbf", 15,0, false, "附加险保费" )))
							.addNode(new FieldNode("fjxlb_bxje", new MsgField(ContentEnum.MessageType.STRING.toString(), "fjxlb_bxje", 15,0, false, "附加险保额" )))
							.addNode(new FieldNode("fjxlb_bznq", new MsgField(ContentEnum.MessageType.STRING.toString(), "fjxlb_bznq", 1,0, false, "附加险保障年期" )))
							.addNode(new FieldNode("fjxlb_jfnx", new MsgField(ContentEnum.MessageType.STRING.toString(), "fjxlb_jfnx", 10,0, false, "附加险缴费年期" )))
							.addNode(new FieldNode("fjxlb_jfnqlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "fjxlb_jfnqlx", 1,0, false, "附加险缴费年期类型" )))
							.addNode(new FieldNode("fjxlb_bznqlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "fjxlb_bznqlx", 1,0, false, "附加险保障年期类型" )))
							.addNode(new FieldNode("fjxlb_jffs", new MsgField(ContentEnum.MessageType.STRING.toString(), "fjxlb_jffs", 1,0, false, "附加险缴费方式" )))
							.addNode(new FieldNode("fjxlb_lqnqlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "fjxlb_lqnqlx", 1,0, false, "附加险领取方式" )))
							.addNode(new FieldNode("fjxlb_lqnl", new MsgField(ContentEnum.MessageType.STRING.toString(), "fjxlb_lqnl", 10,0, false, "附加险领取年龄" )))
							.addNode(new FieldNode("fjxlb_hllqfs", new MsgField(ContentEnum.MessageType.STRING.toString(), "fjxlb_hllqfs", 1,0, false, "附加险红利领取方式" )))
							).addNode(new FieldNode("qtxxjkgz", new MsgField(ContentEnum.MessageType.STRING.toString(), "qtxxjkgz", 1,0, false, "健康告知标志" )))
					.addNode(new FieldNode("qtxxcwgzbz", new MsgField(ContentEnum.MessageType.STRING.toString(), "qtxxcwgzbz", 1,0, false, "财务告知标识" )))
					.addNode(new FieldNode("qtxxzygzbz", new MsgField(ContentEnum.MessageType.STRING.toString(), "qtxxzygzbz", 1,0, false, "职业告知标识" )))
					.addNode(new FieldNode("jyxx_khlb", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyxx_khlb", 3,0, false, "客户类别" )))
					.addNode(new FieldNode("jyxx_jyzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyxx_jyzh", 32,0, false, "交易帐号" )))
					.addNode(new FieldNode("bxxxcpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxcpdm", 30,0, false, "产品代码" )))
					.addNode(new FieldNode("tbrbfys", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbrbfys", 15,0, false, "投保人保费预算" )))
					.addNode(new FieldNode("dkxxdkhth", new MsgField(ContentEnum.MessageType.STRING.toString(), "dkxxdkhth", 250,0, false, "贷款合同号" )))
					.addNode(new FieldNode("dkxxdkpzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "dkxxdkpzh", 250,0, false, "贷款凭证号" )))
					.addNode(new FieldNode("dkxxdkje", new MsgField(ContentEnum.MessageType.STRING.toString(), "dkxxdkje", 6,0, false, "贷款金额" )))
					.addNode(new FieldNode("dkxxdkqq", new MsgField(ContentEnum.MessageType.STRING.toString(), "dkxxdkqq", 8,0, false, "贷款起期" )))
					.addNode(new FieldNode("dkxxdkzq", new MsgField(ContentEnum.MessageType.STRING.toString(), "dkxxdkzq", 8,0, false, "贷款止期" )))
					.addNode(new FieldNode("dkxxbxsxrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "dkxxbxsxrq", 8,0, false, "保险生效日期" )))
					.addNode(new FieldNode("dkxxbxhtzq", new MsgField(ContentEnum.MessageType.STRING.toString(), "dkxxbxhtzq", 8,0, false, "保险合同止期" )))
					.addNode(new FieldNode("dkxxdkpz", new MsgField(ContentEnum.MessageType.STRING.toString(), "dkxxdkpz", 1,0, false, "贷款品种" )))
					.addNode(new FieldNode("dkxxdkjg", new MsgField(ContentEnum.MessageType.STRING.toString(), "dkxxdkjg", 20,0, false, "贷款机构" )))
					.addNode(new FieldNode("dkxxdklx", new MsgField(ContentEnum.MessageType.STRING.toString(), "dkxxdklx", 1,0, false, "贷款类型" )))
					.addNode(new FieldNode("dkxxdkzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "dkxxdkzh", 50,0, false, "贷款账号" )))
					.addNode(new FieldNode("dkxxdkyhmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "dkxxdkyhmc", 50,0, false, "贷款银行名称" )))
					.addNode(new FieldNode("dkxxdkyhlxdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "dkxxdkyhlxdh", 20,0, false, "贷款银行联系电话" )))
					.addNode(new FieldNode("fwxxfwdz", new MsgField(ContentEnum.MessageType.STRING.toString(), "fwxxfwdz", 100,0, false, "投保房屋详细地址" )))
					.addNode(new FieldNode("qyxxqyxz", new MsgField(ContentEnum.MessageType.STRING.toString(), "qyxxqyxz", 10,0, false, "企业性质" )))
					.addNode(new FieldNode("qyxxyyxzdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "qyxxyyxzdm", 250,0, false, "营业性质代码" )))
					.addNode(new FieldNode("qyxxyyxzmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "qyxxyyxzmc", 2,0, false, "营业性质名称" )))
					.addNode(new FieldNode("qyxxbxjeqdfs", new MsgField(ContentEnum.MessageType.STRING.toString(), "qyxxbxjeqdfs", 250,0, false, "保险金额确定方式" )))
					.addNode(new FieldNode("fwxxbqcqh", new MsgField(ContentEnum.MessageType.STRING.toString(), "fwxxbqcqh", 200,0, false, "保险标的产权证号" )))
					.addNode(new FieldNode("fwxxfwlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "fwxxfwlx", 2,0, false, "房屋类型" )))
					.addNode(new FieldNode("fwxxjzmj", new MsgField(ContentEnum.MessageType.STRING.toString(), "fwxxjzmj", 100,0, false, "建筑面积" )))
					.addNode(new FieldNode("bxxxdkxzdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxdkxzdm", 10,0, false, "贷款性质代码" )))
					.addNode(new FieldNode("bxxxdkyhdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxdkyhdm", 10,0, false, "贷款银行代码" )))
					.addNode(new FieldNode("bxxxbddx", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxbddx", 8,0, false, "标的大小" )))
					.addNode(new StructNode("bxxxbdjg", false)
							).addNode(new FieldNode("bxxxsfbhfsss", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxsfbhfsss", 2,0, false, "是否含室内附属设备" )))
					.addNode(new FieldNode("bxxxzwbl", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxzwbl", 2,0, false, "投保房屋性质" )))
					.addNode(new FieldNode("bxxxqfbz", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxqfbz", 10,0, false, "期房现房标志" )))
					.addNode(new FieldNode("bxxxqfjfrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxqfjfrq", 8,0, false, "交房日期" )))
					.addNode(new FieldNode("bxxxbddz", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxbddz", 100,0, false, "标的地址" )))
					.addNode(new FieldNode("bxxxzyjjfs", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxzyjjfs", 20,0, false, "争议解决方式" )))
					.addNode(new FieldNode("bxxxtbfa", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxxxtbfa", 20,0, false, "投保方案" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODF510015_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Ctrl", true)
					.addNode(new FieldNode("errorCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "errorCode", 8,0, false, "错误代码" )))
					.addNode(new FieldNode("errorMsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "errorMsg", 255,0, false, "错误信息" )))
					.addNode(new FieldNode("workdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "workdate", 8,0, false, "综合前置日期" )))
					.addNode(new FieldNode("worktime", new MsgField(ContentEnum.MessageType.STRING.toString(), "worktime", 6,0, false, "综合前置时间" )))
					.addNode(new FieldNode("serialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "serialno", 10,0, false, "综合前置流水" )))
					.addNode(new FieldNode("sverretcod", new MsgField(ContentEnum.MessageType.STRING.toString(), "sverretcod", 7,0, false, "响应码" )))
					.addNode(new FieldNode("sverretmsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "sverretmsg", 50,0, false, "响应信息" )))
					.addNode(new FieldNode("sverworkdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "sverworkdate", 8,0, false, "帐务日期" )))
					.addNode(new FieldNode("sverserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "sverserialno", 24,0, false, "平台流水号" )))
					)
			.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("zbf", new MsgField(ContentEnum.MessageType.STRING.toString(), "zbf", 15,0, false, "保费总额" )))
					.addNode(new FieldNode("insure_serial", new MsgField(ContentEnum.MessageType.STRING.toString(), "insure_serial", 30,0, false, "保险公司流水号" )))
					.addNode(new FieldNode("resultcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "resultcode", 10,0, false, "错误码" )))
					.addNode(new FieldNode("err_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "err_info", 50,0, false, "错误描述" )))
					.addNode(new FieldNode("bxje", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxje", 17,0, false, "保额" )))
					.addNode(new FieldNode("bdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bdh", 30,0, false, "保单号" )))
					.addNode(new FieldNode("bxgsjydm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxgsjydm", 8,0, false, "保险公司端交易代码" )))
					.addNode(new FieldNode("jydm", new MsgField(ContentEnum.MessageType.STRING.toString(), "jydm", 30,0, false, "银行端交易代码" )))
					.addNode(new FieldNode("insure_serial", new MsgField(ContentEnum.MessageType.STRING.toString(), "insure_serial", 30,0, false, "保险公司端的交易流水号" )))
					.addNode(new FieldNode("ptlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptlsh", 30,0, false, "银行端的交易流水号" )))
					.addNode(new FieldNode("jyrq", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyrq", 30,0, false, "银行交易执行日期" )))
					.addNode(new FieldNode("jysj", new MsgField(ContentEnum.MessageType.STRING.toString(), "jysj", 15,0, false, "银行交易执行时间" )))
					.addNode(new FieldNode("tbdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbdh", 15,0, false, "投保单号/保单号" )))
					.addNode(new FieldNode("sqzbf", new MsgField(ContentEnum.MessageType.STRING.toString(), "sqzbf", 8,0, false, "首期总保费" )))
					.addNode(new FieldNode("cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpdm", 4,0, false, "险种代码" )))
					.addNode(new FieldNode("tbfs", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbfs", 4,0, false, "险种份数" )))
					.addNode(new FieldNode("jfnqlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "jfnqlx", 4,0, false, "缴费年期类型" )))
					.addNode(new FieldNode("jfnx", new MsgField(ContentEnum.MessageType.STRING.toString(), "jfnx", 4,0, false, "缴费年期" )))
					.addNode(new FieldNode("bznqlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "bznqlx", 4,0, false, "保障年期类型" )))
					.addNode(new FieldNode("bznq", new MsgField(ContentEnum.MessageType.STRING.toString(), "bznq", 4,0, false, "保障年期" )))
					.addNode(new FieldNode("lqnqlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "lqnqlx", 4,0, false, "领取年期类型" )))
					.addNode(new FieldNode("lqqsnl", new MsgField(ContentEnum.MessageType.STRING.toString(), "lqqsnl", 4,0, false, "领取起始年龄" )))
					.addNode(new FieldNode("lqjsnl", new MsgField(ContentEnum.MessageType.STRING.toString(), "lqjsnl", 15,0, false, "领取结束年龄" )))
					.addNode(new FieldNode("bxje", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxje", 15,0, false, "保额" )))
					.addNode(new FieldNode("zxbf", new MsgField(ContentEnum.MessageType.STRING.toString(), "zxbf", 30,0, false, "保费" )))
					.addNode(new FieldNode("bxsxsj", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxsxsj", 30,0, false, "保险生效时间" )))
					.addNode(new FieldNode("bxjssj", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxjssj", 8,0, false, "保险结束时间" )))
					.addNode(new FieldNode("resultcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "resultcode", 100,0, false, "交易结果" )))
					.addNode(new FieldNode("err_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "err_info", 1024,0, false, "交易结果描述" )))
					.addNode(new FieldNode("cpgs", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpgs", 4,0, false, "产品个数" )))
					.addNode(new StructNode("cplb", true)
							.addNode(new FieldNode("cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpdm", 10,0, false, "产品代码" )))
							.addNode(new FieldNode("tbfs", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbfs", 3,0, false, "投保份数" )))
							.addNode(new FieldNode("bf", new MsgField(ContentEnum.MessageType.STRING.toString(), "bf", 15,0, false, "保费" )))
							.addNode(new FieldNode("bxje", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxje", 15,0, false, "保额" )))
							.addNode(new FieldNode("cpmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpmc", 250,0, false, "产品名称" )))
							.addNode(new FieldNode("zfxbz", new MsgField(ContentEnum.MessageType.STRING.toString(), "zfxbz", 1,0, false, "主副险标志" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
