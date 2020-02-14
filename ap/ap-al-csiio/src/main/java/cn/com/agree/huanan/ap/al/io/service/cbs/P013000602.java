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
 * 
 * @author zhuzc
 * BASESVC P013000602 个人账户客户信息综合查询
 * P013000602 qracct
 * ATM
 */
@Component
public class P013000602 extends EsbCoreChannelService{
	private static P013000602_I i = new P013000602_I();
	private static P013000602_O o = new P013000602_O();
	public P013000602() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class P013000602_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
			.addNode(new FieldNode("prcscd", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcscd", 6,0, true, "处理码" )))
			.addNode(new FieldNode("AcctNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "AcctNo", 40,0, true, "账号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class P013000602_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("AcctNo",new MsgField(ContentEnum.MessageType.STRING.toString(),"AcctNo",40,0,false,"账号")))
					.addNode(new FieldNode("AcctNa",new MsgField(ContentEnum.MessageType.STRING.toString(),"AcctNa",80,0,false,"账户名")))
					.addNode(new FieldNode("avblam",new MsgField(ContentEnum.MessageType.STRING.toString(),"avblam",21,0,false,"可用余额")))
					.addNode(new FieldNode("pmodtg",new MsgField(ContentEnum.MessageType.STRING.toString(),"pmodtg",20,0,false,"透支许可标志")))
					.addNode(new FieldNode("ovdfam",new MsgField(ContentEnum.MessageType.STRING.toString(),"ovdfam",8,0,false,"透支额度")))
					.addNode(new FieldNode("ovdrir",new MsgField(ContentEnum.MessageType.STRING.toString(),"ovdrir",20,0,false,"透支利率")))
					.addNode(new FieldNode("ovmtdt",new MsgField(ContentEnum.MessageType.STRING.toString(),"ovmtdt",25,0,false,"透支到期日")))
					.addNode(new FieldNode("ovmlbl",new MsgField(ContentEnum.MessageType.STRING.toString(),"ovmlbl",16,0,false,"透支积数")))
					.addNode(new FieldNode("CustNo",new MsgField(ContentEnum.MessageType.STRING.toString(),"CustNo",32,0,false,"客户号")))
					.addNode(new FieldNode("lastdt",new MsgField(ContentEnum.MessageType.STRING.toString(),"lastdt",6,0,false,"上日余额日期")))
					.addNode(new FieldNode("lastbl",new MsgField(ContentEnum.MessageType.STRING.toString(),"lastbl",34,0,false,"上日余额")))
					.addNode(new FieldNode("onlnbl",new MsgField(ContentEnum.MessageType.STRING.toString(),"onlnbl",100,0,false,"联机余额")))
					.addNode(new FieldNode("acctbr",new MsgField(ContentEnum.MessageType.STRING.toString(),"acctbr",3,0,false,"账户部门")))
					.addNode(new FieldNode("grupno",new MsgField(ContentEnum.MessageType.STRING.toString(),"grupno",21,0,false,"柜组")))
					.addNode(new FieldNode("CrcyCd",new MsgField(ContentEnum.MessageType.STRING.toString(),"CrcyCd",2,0,false,"币种")))
					.addNode(new FieldNode("ItemCd",new MsgField(ContentEnum.MessageType.STRING.toString(),"ItemCd",20,0,false,"科目代码")))
					.addNode(new FieldNode("AcctSt",new MsgField(ContentEnum.MessageType.STRING.toString(),"AcctSt",1,0,false,"账户状态")))
					.addNode(new FieldNode("AcctTp",new MsgField(ContentEnum.MessageType.STRING.toString(),"AcctTp",1,0,false,"账户类别")))
					.addNode(new FieldNode("OpenDt",new MsgField(ContentEnum.MessageType.STRING.toString(),"OpenDt",8,0,false,"开户日期")))
					.addNode(new FieldNode("trandt",new MsgField(ContentEnum.MessageType.STRING.toString(),"trandt",8,0,false,"上次交易日期")))
					.addNode(new FieldNode("acmldt",new MsgField(ContentEnum.MessageType.STRING.toString(),"acmldt",20,0,false,"积数日期")))
					.addNode(new FieldNode("ioflag",new MsgField(ContentEnum.MessageType.STRING.toString(),"ioflag",1,0,false,"表内外标志")))
					.addNode(new FieldNode("drtsnm",new MsgField(ContentEnum.MessageType.STRING.toString(),"drtsnm",16,0,false,"借方交易笔数")))
					.addNode(new FieldNode("crtsnm",new MsgField(ContentEnum.MessageType.STRING.toString(),"crtsnm",3,0,false,"贷方交易笔数")))
					.addNode(new FieldNode("blncdn",new MsgField(ContentEnum.MessageType.STRING.toString(),"blncdn",6,0,false,"余额方向")))
					.addNode(new FieldNode("billtp",new MsgField(ContentEnum.MessageType.STRING.toString(),"billtp",34,0,false,"帐单类别")))
					.addNode(new FieldNode("billln",new MsgField(ContentEnum.MessageType.STRING.toString(),"billln",100,0,false,"帐单行")))
					.addNode(new FieldNode("billpg",new MsgField(ContentEnum.MessageType.STRING.toString(),"billpg",3,0,false,"帐单页")))
					.addNode(new FieldNode("bearbl",new MsgField(ContentEnum.MessageType.STRING.toString(),"bearbl",21,0,false,"帐单承前余额")))
					.addNode(new FieldNode("termcd",new MsgField(ContentEnum.MessageType.STRING.toString(),"termcd",34,0,false,"期限码")))
					.addNode(new FieldNode("daabtg",new MsgField(ContentEnum.MessageType.STRING.toString(),"daabtg",100,0,false,"通存通兑标志")))
					.addNode(new FieldNode("inrttp",new MsgField(ContentEnum.MessageType.STRING.toString(),"inrttp",3,0,false,"利率类别")))
					.addNode(new FieldNode("matudt",new MsgField(ContentEnum.MessageType.STRING.toString(),"matudt",21,0,false,"到期日期")))
					.addNode(new FieldNode("bgindt",new MsgField(ContentEnum.MessageType.STRING.toString(),"bgindt",24,0,false,"起息日期")))
					.addNode(new FieldNode("sleptg",new MsgField(ContentEnum.MessageType.STRING.toString(),"sleptg",8,0,false,"睡眠户标志")))
					.addNode(new FieldNode("acmlbl",new MsgField(ContentEnum.MessageType.STRING.toString(),"acmlbl",20,0,false,"利息积数")))
					.addNode(new FieldNode("rlacml",new MsgField(ContentEnum.MessageType.STRING.toString(),"rlacml",25,0,false,"实际利息积数")))
					.addNode(new FieldNode("InstRt",new MsgField(ContentEnum.MessageType.STRING.toString(),"InstRt",6,0,false,"利率")))
					.addNode(new FieldNode("ccintg",new MsgField(ContentEnum.MessageType.STRING.toString(),"ccintg",3,0,false,"计息标志")))
					.addNode(new FieldNode("svdptg",new MsgField(ContentEnum.MessageType.STRING.toString(),"svdptg",6,0,false,"储蓄对公标志")))
					.addNode(new FieldNode("lwstbl",new MsgField(ContentEnum.MessageType.STRING.toString(),"lwstbl",34,0,false,"最低余额")))
					.addNode(new FieldNode("suspam",new MsgField(ContentEnum.MessageType.STRING.toString(),"suspam",100,0,false,"止付金额")))
					.addNode(new FieldNode("suspst",new MsgField(ContentEnum.MessageType.STRING.toString(),"suspst",3,0,false,"止付状态")))
					.addNode(new FieldNode("frspbl",new MsgField(ContentEnum.MessageType.STRING.toString(),"frspbl",21,0,false,"冻结+止付金额")))
					.addNode(new FieldNode("noclst",new MsgField(ContentEnum.MessageType.STRING.toString(),"noclst",34,0,false,"禁止销户标志")))
					.addNode(new FieldNode("instam",new MsgField(ContentEnum.MessageType.STRING.toString(),"instam",100,0,false,"应付利息")))
					.addNode(new FieldNode("inactg",new MsgField(ContentEnum.MessageType.STRING.toString(),"inactg",3,0,false,"第三方入息账号标志")))
					.addNode(new FieldNode("inacct",new MsgField(ContentEnum.MessageType.STRING.toString(),"inacct",21,0,false,"第三方入息账号")))
					.addNode(new FieldNode("accttx",new MsgField(ContentEnum.MessageType.STRING.toString(),"accttx",24,0,false,"账户注解")))
					.addNode(new FieldNode("DebtTp",new MsgField(ContentEnum.MessageType.STRING.toString(),"DebtTp",3,0,false,"储种代码")))
					.addNode(new FieldNode("slcktg",new MsgField(ContentEnum.MessageType.STRING.toString(),"slcktg",20,0,false,"帐户出售支票限制")))
					.addNode(new FieldNode("csdwfl",new MsgField(ContentEnum.MessageType.STRING.toString(),"csdwfl",25,0,false,"临时/专户提现批准文号")))
					.addNode(new FieldNode("opauno",new MsgField(ContentEnum.MessageType.STRING.toString(),"opauno",16,0,false,"账户开户核准号")))
					.addNode(new FieldNode("acrdam",new MsgField(ContentEnum.MessageType.STRING.toString(),"acrdam",3,0,false,"协定金额")))
					.addNode(new FieldNode("acrdal",new MsgField(ContentEnum.MessageType.STRING.toString(),"acrdal",6,0,false,"协定积数")))
					.addNode(new FieldNode("CsexTg",new MsgField(ContentEnum.MessageType.STRING.toString(),"CsexTg",1,0,false,"钞汇标志")))
					.addNode(new FieldNode("autham",new MsgField(ContentEnum.MessageType.STRING.toString(),"autham",100,0,false,"外币限额")))
					.addNode(new FieldNode("aucycd",new MsgField(ContentEnum.MessageType.STRING.toString(),"aucycd",3,0,false,"限额币种")))
					.addNode(new FieldNode("auamid",new MsgField(ContentEnum.MessageType.STRING.toString(),"auamid",21,0,false,"限额id")))
					.addNode(new FieldNode("authno",new MsgField(ContentEnum.MessageType.STRING.toString(),"authno",34,0,false,"核准件号")))
					.addNode(new FieldNode("authdt",new MsgField(ContentEnum.MessageType.STRING.toString(),"authdt",100,0,false,"核准件有效期")))
					.addNode(new FieldNode("accpty",new MsgField(ContentEnum.MessageType.STRING.toString(),"accpty",3,0,false,"账户性质")))
					.addNode(new FieldNode("crtsam",new MsgField(ContentEnum.MessageType.STRING.toString(),"crtsam",21,0,false,"贷方累计金额")))
					.addNode(new FieldNode("auamtp",new MsgField(ContentEnum.MessageType.STRING.toString(),"auamtp",24,0,false,"限额类型")))
					.addNode(new FieldNode("ovlidt",new MsgField(ContentEnum.MessageType.STRING.toString(),"ovlidt",8,0,false,"已超限天数")))
					.addNode(new FieldNode("etddam",new MsgField(ContentEnum.MessageType.STRING.toString(),"etddam",20,0,false,"每次存取金额")))
					.addNode(new FieldNode("dfltam",new MsgField(ContentEnum.MessageType.STRING.toString(),"dfltam",25,0,false,"违约金额")))
					.addNode(new FieldNode("dfltal",new MsgField(ContentEnum.MessageType.STRING.toString(),"dfltal",16,0,false,"违约积数")))
					.addNode(new FieldNode("dpabam",new MsgField(ContentEnum.MessageType.STRING.toString(),"dpabam",3,0,false,"应存金额")))
					.addNode(new FieldNode("dflttg",new MsgField(ContentEnum.MessageType.STRING.toString(),"dflttg",6,0,false,"违约标志")))
					.addNode(new FieldNode("dpedmh",new MsgField(ContentEnum.MessageType.STRING.toString(),"dpedmh",34,0,false,"已存月数")))
					.addNode(new FieldNode("todamh",new MsgField(ContentEnum.MessageType.STRING.toString(),"todamh",100,0,false,"累计应存月数")))
					.addNode(new FieldNode("thdamh",new MsgField(ContentEnum.MessageType.STRING.toString(),"thdamh",3,0,false,"本次应存月数")))
					.addNode(new FieldNode("tmdamh",new MsgField(ContentEnum.MessageType.STRING.toString(),"tmdamh",21,0,false,"累计到期应存月数")))
					.addNode(new FieldNode("tmdaam",new MsgField(ContentEnum.MessageType.STRING.toString(),"tmdaam",34,0,false,"累计到期应存金额")))
					.addNode(new FieldNode("mtdaam",new MsgField(ContentEnum.MessageType.STRING.toString(),"mtdaam",100,0,false,"当前到期应存金额")))
					.addNode(new FieldNode("etddmh",new MsgField(ContentEnum.MessageType.STRING.toString(),"etddmh",3,0,false,"存取间隔月数")))
					.addNode(new FieldNode("nxpidt",new MsgField(ContentEnum.MessageType.STRING.toString(),"nxpidt",21,0,false,"下一付息日")))
					.addNode(new FieldNode("etpiam",new MsgField(ContentEnum.MessageType.STRING.toString(),"etpiam",24,0,false,"每次付息金额")))
					.addNode(new FieldNode("pyedin",new MsgField(ContentEnum.MessageType.STRING.toString(),"pyedin",8,0,false,"已付息")))
					.addNode(new FieldNode("pyblin",new MsgField(ContentEnum.MessageType.STRING.toString(),"pyblin",20,0,false,"应付息")))
					.addNode(new FieldNode("drawmh",new MsgField(ContentEnum.MessageType.STRING.toString(),"drawmh",25,0,false,"取款间隔")))
					.addNode(new FieldNode("openpl",new MsgField(ContentEnum.MessageType.STRING.toString(),"openpl",16,0,false,"开户本金")))
					.addNode(new FieldNode("todrct",new MsgField(ContentEnum.MessageType.STRING.toString(),"todrct",3,0,false,"总取款次数")))
					.addNode(new FieldNode("drblct",new MsgField(ContentEnum.MessageType.STRING.toString(),"drblct",6,0,false,"应取款次数")))
					.addNode(new FieldNode("etdram",new MsgField(ContentEnum.MessageType.STRING.toString(),"etdram",34,0,false,"每次取款金额")))
					.addNode(new FieldNode("drblam",new MsgField(ContentEnum.MessageType.STRING.toString(),"drblam",100,0,false,"本次应取款金额")))
					.addNode(new FieldNode("prdrct",new MsgField(ContentEnum.MessageType.STRING.toString(),"prdrct",3,0,false,"提前支取次数")))
					.addNode(new FieldNode("ovdram",new MsgField(ContentEnum.MessageType.STRING.toString(),"ovdram",21,0,false,"逾期支取金额")))
					.addNode(new FieldNode("ovdral",new MsgField(ContentEnum.MessageType.STRING.toString(),"ovdral",34,0,false,"逾期积数")))
					.addNode(new FieldNode("frozbl",new MsgField(ContentEnum.MessageType.STRING.toString(),"frozbl",100,0,false,"部分冻结金额")))
					.addNode(new FieldNode("pmtdtg",new MsgField(ContentEnum.MessageType.STRING.toString(),"pmtdtg",3,0,false,"允许转存标志")))
					.addNode(new FieldNode("pmtdct",new MsgField(ContentEnum.MessageType.STRING.toString(),"pmtdct",21,0,false,"允许转存次数")))
					.addNode(new FieldNode("tdedct",new MsgField(ContentEnum.MessageType.STRING.toString(),"tdedct",24,0,false,"已转存次数")))
					.addNode(new FieldNode("tdblct",new MsgField(ContentEnum.MessageType.STRING.toString(),"tdblct",8,0,false,"还需转存次数")))
					.addNode(new FieldNode("opctno",new MsgField(ContentEnum.MessageType.STRING.toString(),"opctno",20,0,false,"开户核准号")))
					.addNode(new FieldNode("validt",new MsgField(ContentEnum.MessageType.STRING.toString(),"validt",25,0,false,"有效日期")))
					.addNode(new FieldNode("spectp",new MsgField(ContentEnum.MessageType.STRING.toString(),"spectp",16,0,false,"帐户属性")))
					.addNode(new FieldNode("intrcd",new MsgField(ContentEnum.MessageType.STRING.toString(),"intrcd",3,0,false,"挂帐项目代码")))
					.addNode(new FieldNode("sttlam",new MsgField(ContentEnum.MessageType.STRING.toString(),"sttlam",6,0,false,"结帐期间发生额")))
					.addNode(new FieldNode("openpr",new MsgField(ContentEnum.MessageType.STRING.toString(),"openpr",34,0,false,"挂帐处理码")))
					.addNode(new FieldNode("fundtp",new MsgField(ContentEnum.MessageType.STRING.toString(),"fundtp",100,0,false,"资金来源")))
					.addNode(new FieldNode("fundac",new MsgField(ContentEnum.MessageType.STRING.toString(),"fundac",3,0,false,"来源账号")))
					.addNode(new FieldNode("fundna",new MsgField(ContentEnum.MessageType.STRING.toString(),"fundna",21,0,false,"来源户名")))
					.addNode(new FieldNode("fundbk",new MsgField(ContentEnum.MessageType.STRING.toString(),"fundbk",34,0,false,"来源开户行号")))
					.addNode(new FieldNode("taskno",new MsgField(ContentEnum.MessageType.STRING.toString(),"taskno",100,0,false,"当前任务序号")))
					.addNode(new FieldNode("userbr",new MsgField(ContentEnum.MessageType.STRING.toString(),"userbr",3,0,false,"可使用机构")))
					.addNode(new FieldNode("subsac",new MsgField(ContentEnum.MessageType.STRING.toString(),"subsac",21,0,false,"系统内部序号")))
					.addNode(new FieldNode("acctpt",new MsgField(ContentEnum.MessageType.STRING.toString(),"acctpt",24,0,false,"对公存款户支取方式")))
					.addNode(new FieldNode("transq",new MsgField(ContentEnum.MessageType.STRING.toString(),"transq",8,0,false,"最后交易流水")))
					.addNode(new FieldNode("ProdCd",new MsgField(ContentEnum.MessageType.STRING.toString(),"ProdCd",8,0,false,"产品代码")))
					.addNode(new FieldNode("fnpdtp",new MsgField(ContentEnum.MessageType.STRING.toString(),"fnpdtp",25,0,false,"产品种类")))
					.addNode(new FieldNode("CustTp",new MsgField(ContentEnum.MessageType.STRING.toString(),"CustTp",1,0,false,"客户类型")))
					.addNode(new FieldNode("CustLv",new MsgField(ContentEnum.MessageType.STRING.toString(),"CustLv",2,0,false,"取客户级别")))
					.addNode(new FieldNode("DcmtTp",new MsgField(ContentEnum.MessageType.STRING.toString(),"DcmtTp",3,0,false,"凭证类型")))
					.addNode(new FieldNode("DcmtNo",new MsgField(ContentEnum.MessageType.STRING.toString(),"DcmtNo",20,0,false,"凭证号码")))
					.addNode(new FieldNode("dcmtst",new MsgField(ContentEnum.MessageType.STRING.toString(),"dcmtst",1,0,false,"凭证状态")))
					.addNode(new FieldNode("DrawFs",new MsgField(ContentEnum.MessageType.STRING.toString(),"DrawFs",3,0,false,"支取方式")))
					.addNode(new FieldNode("affist",new MsgField(ContentEnum.MessageType.STRING.toString(),"affist",21,0,false,"凭证支付方式状态")))
					.addNode(new FieldNode("crrldp",new MsgField(ContentEnum.MessageType.STRING.toString(),"crrldp",34,0,false,"关联凭证类型")))
					.addNode(new FieldNode("crrldc",new MsgField(ContentEnum.MessageType.STRING.toString(),"crrldc",100,0,false,"关联凭证号码")))
					.addNode(new FieldNode("spvsbr",new MsgField(ContentEnum.MessageType.STRING.toString(),"spvsbr",3,0,false,"监管部门")))
					.addNode(new FieldNode("spvsam",new MsgField(ContentEnum.MessageType.STRING.toString(),"spvsam",21,0,false,"监管金额")))
					.addNode(new FieldNode("spvsdt",new MsgField(ContentEnum.MessageType.STRING.toString(),"spvsdt",24,0,false,"监管到期日")))
					.addNode(new FieldNode("spvsmk",new MsgField(ContentEnum.MessageType.STRING.toString(),"spvsmk",8,0,false,"监管原因")))
					.addNode(new FieldNode("dcmtfs",new MsgField(ContentEnum.MessageType.STRING.toString(),"dcmtfs",20,0,false,"凭证形式")))
					.addNode(new FieldNode("ckbktg",new MsgField(ContentEnum.MessageType.STRING.toString(),"ckbktg",25,0,false,"对帐折标志")))
					.addNode(new FieldNode("itemna",new MsgField(ContentEnum.MessageType.STRING.toString(),"itemna",16,0,false,"科目名称")))
					.addNode(new FieldNode("ClosDt",new MsgField(ContentEnum.MessageType.STRING.toString(),"ClosDt",8,0,false,"销户日期")))
					.addNode(new FieldNode("dispno",new MsgField(ContentEnum.MessageType.STRING.toString(),"dispno",6,0,false,"显示号码")))
					.addNode(new FieldNode("crdpno",new MsgField(ContentEnum.MessageType.STRING.toString(),"crdpno",34,0,false,"卡显示号码")))
					.addNode(new FieldNode("crrldf",new MsgField(ContentEnum.MessageType.STRING.toString(),"crrldf",100,0,false,"关联凭证形式")))
					.addNode(new FieldNode("feettg",new MsgField(ContentEnum.MessageType.STRING.toString(),"feettg",3,0,false,"账户免费标志")))
					.addNode(new FieldNode("freetp",new MsgField(ContentEnum.MessageType.STRING.toString(),"freetp",21,0,false,"免费类型")))
					.addNode(new FieldNode("insptg",new MsgField(ContentEnum.MessageType.STRING.toString(),"insptg",34,0,false,"账户年检信息标志")))
					.addNode(new FieldNode("inspdt",new MsgField(ContentEnum.MessageType.STRING.toString(),"inspdt",100,0,false,"账户年检到期日")))
					.addNode(new FieldNode("fnpdna",new MsgField(ContentEnum.MessageType.STRING.toString(),"fnpdna",3,0,false,"产品名称")))
					.addNode(new FieldNode("lccpbl",new MsgField(ContentEnum.MessageType.STRING.toString(),"lccpbl",21,0,false,"理财产品的余额")))
					.addNode(new FieldNode("intrtp",new MsgField(ContentEnum.MessageType.STRING.toString(),"intrtp",24,0,false,"利率类型")))
					.addNode(new FieldNode("drawfg",new MsgField(ContentEnum.MessageType.STRING.toString(),"drawfg",8,0,false,"提起支取标志")))
					.addNode(new FieldNode("irpytp",new MsgField(ContentEnum.MessageType.STRING.toString(),"irpytp",20,0,false,"付息周期标志")))
					.addNode(new FieldNode("prirst",new MsgField(ContentEnum.MessageType.STRING.toString(),"prirst",25,0,false,"提前支取利率")))
					.addNode(new FieldNode("dpsmdt",new MsgField(ContentEnum.MessageType.STRING.toString(),"dpsmdt",16,0,false,"同业定期存款天数")))
					.addNode(new FieldNode("nra_tg",new MsgField(ContentEnum.MessageType.STRING.toString(),"nra_tg",3,0,false,"NRA标注")))
					.addNode(new FieldNode("frintp",new MsgField(ContentEnum.MessageType.STRING.toString(),"frintp",6,0,false,"境外机构类别")))
					.addNode(new FieldNode("nra_ac",new MsgField(ContentEnum.MessageType.STRING.toString(),"nra_ac",34,0,false,"NRA账号")))
					.addNode(new FieldNode("dferdt",new MsgField(ContentEnum.MessageType.STRING.toString(),"dferdt",100,0,false,"账户延期到期日")))
					.addNode(new FieldNode("lwided",new MsgField(ContentEnum.MessageType.STRING.toString(),"lwided",3,0,false,"身份证件有效期")))
					.addNode(new FieldNode("cropdt",new MsgField(ContentEnum.MessageType.STRING.toString(),"cropdt",21,0,false,"组织机构代码代码证有效期")))
					.addNode(new FieldNode("cif_validt",new MsgField(ContentEnum.MessageType.STRING.toString(),"cif_validt",34,0,false,"证明文件有效期")))
					.addNode(new FieldNode("others",new MsgField(ContentEnum.MessageType.STRING.toString(),"others",100,0,false,"组织机构代码证年检月mm")))
					.addNode(new FieldNode("brchna",new MsgField(ContentEnum.MessageType.STRING.toString(),"brchna",3,0,false,"机构全称")))
					.addNode(new FieldNode("CustNa",new MsgField(ContentEnum.MessageType.STRING.toString(),"CustNa",256,0,false,"客户名称")))
					.addNode(new FieldNode("unsltg",new MsgField(ContentEnum.MessageType.STRING.toString(),"unsltg",24,0,false,"免不动户标志")))
					.addNode(new FieldNode("actvtg",new MsgField(ContentEnum.MessageType.STRING.toString(),"actvtg",24,0,false,"激活标志")))
					.addNode(new FieldNode("AcctSt",new MsgField(ContentEnum.MessageType.STRING.toString(),"AcctSt",1,0,false,"账户状态")))

					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
