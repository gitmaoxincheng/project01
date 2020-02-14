package cn.com.agree.huanan.ap.al.csicop.mbs.reserved.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;

/**
 * 微网点预约登记信息表Bean
 */
@Data
@Table(MbsReservedInfo.CSIS_MBS_RESERVED_INFO.class)
public class MbsReservedInfo implements Serializable {
	private static final long serialVersionUID = 8294137370489448041L;

	private String serialno; //交易流水号
	private String tradedate; //交易日期
	private String tradetime; //交易时间
	private String opermantype; //开户经办人类型 0同法定代表人/负责人 1同财务负责人 2其他
	private String operphone; //开户经办人手机号
	private String status; //状态 0待自动审核,1待人工审核,2审核不通过,3审核通过,4申请失败,5撤销、6快速开户成功
	private String autochkstep; //自动审批步骤 1企业异常名录检查,2企业状态检查,3黑名单检查,4法定代表人/单位负责人联网核查,5财务负责人联网核查,6开户经办人联网核查,7控股股东或实际控制人联网核查,8企业网银管理员联网核查,9单位结算卡持卡人联网核查,Z完成
	private String checktellerno; //审核柜员号
	private String checkdate; //审核日期
	private String checktime; //审核时间
	private String checkreason; //审核不通过原因, 以|分隔
	private String checkmark; //审核批注/申请失败原因
	private String acctype; //账户性质 0基本账户,1一般账户
	private String tocity; //开户城市
	private String tobrno; //开户网点
	private String usccode; //社会信用代码
	private String orgcode; //组织机构代码
	private String compname; //企业名称
	private String comptelephone; //企业电话
	private String compofficeaddrtype; //企业办工/邮寄地址类型 0同注册地址 1其他
	private String compofficeaddr; //企业办工/邮寄地址,企业办工/邮寄地址类型为1时有值, 否则为空
	private String compaddr; //企业详细地址
	private String accusagetype; //用途类型 0结算,1贷款,2其他
	private String accusage; //其他用途 用途类型为2其他时必填,否则为空
	private String corpname; //授权人/代理人姓名
	private String corpidtype; //授权人/代理人证件类型
	private String corpidno; //授权人/代理人证件号码
	private String corpchkcode; //授权人/代理人身份核查结果码
	private String corpchkmsg; //授权人/代理人身份核查结果信息
	private String corpidvaldate; //授权人/代理人证件有效期
	private String corptelephone; //授权人/代理人手机号
	private String finaname; //财务负责人姓名
	private String finaidtype; //财务负责人证件类型
	private String finaidno; //财务负责人证件号码
	private String finachkcode; //财务负责人身份核查结果码
	private String finachkmsg; //财务负责人身份核查结果信息
	private String finaidvaldate; //财务负责人证件有效期,YYYYMMDD
	private String finatelephone; //财务负责人手机号
	private String opername; //开户经办人姓名
	private String operidtype; //开户经办人证件类型
	private String operidno; //开户经办人证件号码
	private String operchkcode; //开户经办人身份核查结果码
	private String operchkmsg; //开户经办人身份核查结果信息
	private String operidvaldate; //开户经办人证件有效期,YYYYMMDD
	private String authvaldate; //授权有效期
	private String taxtype; //税收居民机构类型 0其他非金融机构 1消极非金融机构
	private String taxinfo; //税收居民身份信息 0仅主中国税收居民 1仅为非居民 2既是中国税居民又是其他国家(地区)税收居民
	private String issbm; //是否开通回单机 Y是,N否
	private String isncb; //是否开通企业网银 Y是,N否
	private String isict; //是否开通银信通 Y是,N否
	private String isubc; //是否开通单位结算卡 Y是,N否
	private String isebd; //是否开通电子商业汇票签约 Y是,N否
	private String istaxsb; //是否开通扣税/社保服务 Y是,N否
	private String isonecert; //是否三证合一 Y是,N否
	private String busino; //营业执照号码
	private String appnumber; //申请编号
	private String appvaldate; //申请有效截止日期
	private String appisval; //申请有效性标识 Y有效 N已失效
	private String contname; //控股股东或实际控制人名称
	private String contidtype; //控股股东或实际控制人证件类型
	private String contidno; //控股股东或实际控制人证件号码
	private String contchkcode; //控股股东或实际控制人身份核查结果码
	private String contchkmsg; //控股股东或实际控制人身份核查结果信息
	private String contidvaldate; //控股股东或实际控制人证件有效期
	private String contsuperior; //控股股东或实际控制人上级法人或主管单位名称
	private String contseal; //控股股东或实际控制人预留印鉴 0预留新印鉴,1预留新印鉴授权预留受托人签章,2与其他账号共用一套印鉴
	private String trusteesealname; //受托人印鉴名称
	private String trusteeidno; //受托人证件号码
	private String sealacctno; //印鉴账号
	private String sealcardno; //印鉴卡号
	private String ncbmantype; //企业网银管理员类型 0同法定代表人/负责人 1同财务负责人 2同代办人 3其他
	private String ncbname; //企业网银管理员姓名 当企业网银管理员类型为3时必填,否则为空
	private String ncbidtype; //企业网银管理员证件类型 当企业网银管理员类型为3时必填,否则为空
	private String ncbidno; //企业网银管理员证件号码 当企业网银管理员类型为3时必填,否则为空
	private String ncbchkcode; //企业网银管理员身份核查结果码
	private String ncbchkmsg; //企业网银管理员身份核查结果信息
	private String ncbtelephone; //企业网银管理员手机号码 当企业网银管理员类型为3时必填,否则为空
	private String ncbcode; //企业网银管理员代码
	private String ncbusbkeynum; //企业网银购买USBKEY数量
	private String ncbonelim; //企业网银非柜面渠道账户单笔限额
	private String ncbdaylim; //企业网银非柜面渠道账户日累计限额
	private String ictphoneno1; //银信通接收手机号1 同法定代表人/负责人手机号码 Y/N
	private String ictphoneno2; //银信通接收手机号2 同财务负责人手机号码 Y/N
	private String ictphoneno3; //银信通接收手机号3 同代办人手机号码 Y/N
	private String ictphoneno4; //银信通接收手机号4 其他手机号码1
	private String ictphoneno5; //银信通接收手机号5 其他手机号码2
	private String ubcmantype; //单位结算卡持卡人信息类型 0同法定代表人/负责人 1同财务负责人 2同代办人 3其他
	private String ubcname; //单位结算卡持卡人姓名
	private String ubcidtype; //单位结算卡持卡人证件类型
	private String ubcidno; //单位结算卡持卡人证件号码
	private String ubcidvaldate; //单位结算卡持卡人证件有效期,YYYYMMDD
	private String ubctelephone; //单位结算卡持卡人手机号码
	private String blretcode; //黑名单检查结果代码
	private String blretmsg; //黑名单检查结果信息
	private String exclistret; //企业异常名录检查结果
	private String corpstatusret; //企业状态检查
	private String checknote; //审核记录要素,用于记录柜面的审核要素
	private String lockedtellerno; //锁定柜员号
	private String upddate; //更新日期
	private String updtime; //更新时间
	private String openmbr; //开户支行
	private String openzone; //开户分行
	private String openbrname; //开户网点名称
	private String iselec; //是否开通电子对账 Y是,N否
	private String elecname1; //电子对账第一联系人名称
	private String electelephone1; //电子对账第一联系人手机号码
	private String elecname2; //电子对账第二联系人名称
	private String electelephone2; //电子对账第二联系人手机号码
	private String lastdaysendst; //失效前一天短信通知状态 默认N未通知 Y已通知
	private String postcode; //邮编
	private String cutonelim; //客户单笔限额
	private String cutdaylim; //客户日累计限额
	private String ncbtype; //企业网银签约类型:0-标准版;1-单人版;2-查询版
	private String ncbukeytype; //UKEY类型:0-二代U-KEY;1-蓝牙U-KEY
	private String depotp; //存款人类别:1-企业法人;13-个体工商户
	private String sendtype; //是否成功发送集中作业部 1-是;2-否
	private String taskid; //集中处理业务平台任务号
	private String contentno; //证件图片批次号
	private String modelno; //证件图片模型号
	private String mybank; //法人号
	private String applytp; //申请类型
	private String deponame; //存款人姓名
	private String oplicimg; //开户许可证,文件存放路径,若为空,则代表无
	private String operidbkimg; //人证件反面照,文件存放路径,若为空,则代表无
	private String operidfrimg; //经办人证件正面照,文件存放路径,若为空,则代表无
	private String finaidbkimg; //财务负责人证件反面照,文件存放路径,若为空,则代表无
	private String finaidfrimg; //财务负责人证件正面照,文件存放路径,若为空,则代表无
	private String corpidbkimg; //法人证件反面照,文件存放路径,若为空,则代表无
	private String corpidfrimg; //法人证件正面照,文件存放路径,若为空,则代表无
	private String taximg; //税务登记证,文件存放路径,若为空,则代表无
	private String organimg; //组织机构代码证,文件存放路径,若为空,则代表无
	private String busiimg; //营业执照信息,文件存放路径,若为空,则代表无
	private String audit_channels; //审核渠道
	private String corp_cert_result; //发证机关（结果）法定代表人/单位负责人
	private String corp_check_result; //核查结果（结果）法定代表人/单位负责人
	private String fina_cert_result; //发证机关（结果）财务负责人
	private String fina_check_result; //核查结果（结果）财务负责人
	private String oper_cert_result; //发证机关（结果）经办人
	private String oper_check_result; //核查结果（结果）经办人
	private String if_account; //是否存在久悬账户
	private String if_depotp_name; //存款人名称是否一致
	private String if_depotp_type; //存款人类别是否一致
	private String if_address; //地址是否一致
	private String if_corp; //法定代表人或单位负责人的姓名、证件种类、证件名称是否一致
	private String if_registered; //注册资金是否一致
	private String if_business_scope; //经营范围是否一致
	private String file_number; //证明文件种类与编号是否一致
	private String taxation; //税务登记证号是否一致
	private String account_one; //是否符合开立一般户条件
	private String other; //其他说明
	private String establish_date; //成立日期
	private String busid_stadate; //营业期限自
	private String busid_enddate; //营业期限至
	private String enterprise_state; //企业状态
	private String registered; //注册资本
	private String business_scope; //经营范围
	private String residence; //住所
	private String annual_year; //最近一年年报年份
	private String annual_daty; //最近一年年报日期
	private String annualreport; //最近一年年报结果判断
	private String directory_in_time; //最新经营异常名录列出时间
	private String directory_out_time; //最新经营异常名录列入时间
	private String directory; //最新经营异常名录判断
	private String delict_namelist; //严重违法失信企业名单列入时间
	private String lncluded_wh; //列入作出决定文号
	private String lncluded_office; //列入作出决定机关
	private String lncluded_reason; //列入原因
	private String moveout_time; //移出时间
	private String moveout_wh; //移出作出决定文号
	private String moveout_office; //移出作出决定机关
	private String moveout_reason; //移出原因
	private String breakfaith_name; //严重失信名单判断 
	private String inspect_result; //检索结果
	private String risk; //最高风险等级
	private String inspect_result_id; //检索结果ID
	private String black_type_result; //黑名单查证结果
	private String gs_usccode; //统一社会信用代码
	private String gs_corpidfr; //法定代表人
	private String gs_compname; //企业名称
	private String gs_orgcode; //组织机构代码
	private String respcode; //工商查证审核结果0-拒绝1-通过
	private String busistartdate; //影像上传时间

	public static class CSIS_MBS_RESERVED_INFO {

	}

	public static Map<String, Object> getMap(MbsReservedInfo mbsReservedInfo) {
		Map<String, Object> map = new HashMap<>();
		map.put("serialno", mbsReservedInfo.getSerialno());
		map.put("tradedate", mbsReservedInfo.getTradedate());
		map.put("tradetime", mbsReservedInfo.getTradetime());
		map.put("opermantype", mbsReservedInfo.getOpermantype());
		map.put("operphone", mbsReservedInfo.getOperphone());
		map.put("status", mbsReservedInfo.getStatus());
		map.put("autochkstep", mbsReservedInfo.getAutochkstep());
		map.put("checktellerno", mbsReservedInfo.getChecktellerno());
		map.put("checkdate", mbsReservedInfo.getCheckdate());
		map.put("checktime", mbsReservedInfo.getChecktime());
		map.put("checkreason", mbsReservedInfo.getCheckreason());
		map.put("checkmark", mbsReservedInfo.getCheckmark());
		map.put("acctype", mbsReservedInfo.getAcctype());
		map.put("tocity", mbsReservedInfo.getTocity());
		map.put("tobrno", mbsReservedInfo.getTobrno());
		map.put("usccode", mbsReservedInfo.getUsccode());
		map.put("orgcode", mbsReservedInfo.getOrgcode());
		map.put("compname", mbsReservedInfo.getCompname());
		map.put("comptelephone", mbsReservedInfo.getComptelephone());
		map.put("compofficeaddrtype", mbsReservedInfo.getCompofficeaddrtype());
		map.put("compofficeaddr", mbsReservedInfo.getCompofficeaddr());
		map.put("compaddr", mbsReservedInfo.getCompaddr());
		map.put("accusagetype", mbsReservedInfo.getAccusagetype());
		map.put("accusage", mbsReservedInfo.getAccusage());
		map.put("corpname", mbsReservedInfo.getCorpname());
		map.put("corpidtype", mbsReservedInfo.getCorpidtype());
		map.put("corpidno", mbsReservedInfo.getCorpidno());
		map.put("corpchkcode", mbsReservedInfo.getCorpchkcode());
		map.put("corpchkmsg", mbsReservedInfo.getCorpchkmsg());
		map.put("corpidvaldate", mbsReservedInfo.getCorpidvaldate());
		map.put("corptelephone", mbsReservedInfo.getCorptelephone());
		map.put("finaname", mbsReservedInfo.getFinaname());
		map.put("finaidtype", mbsReservedInfo.getFinaidtype());
		map.put("finaidno", mbsReservedInfo.getFinaidno());
		map.put("finachkcode", mbsReservedInfo.getFinachkcode());
		map.put("finachkmsg", mbsReservedInfo.getFinachkmsg());
		map.put("finaidvaldate", mbsReservedInfo.getFinaidvaldate());
		map.put("finatelephone", mbsReservedInfo.getFinatelephone());
		map.put("opername", mbsReservedInfo.getOpername());
		map.put("operidtype", mbsReservedInfo.getOperidtype());
		map.put("operidno", mbsReservedInfo.getOperidno());
		map.put("operchkcode", mbsReservedInfo.getOperchkcode());
		map.put("operchkmsg", mbsReservedInfo.getOperchkmsg());
		map.put("operidvaldate", mbsReservedInfo.getOperidvaldate());
		map.put("authvaldate", mbsReservedInfo.getAuthvaldate());
		map.put("taxtype", mbsReservedInfo.getTaxtype());
		map.put("taxinfo", mbsReservedInfo.getTaxinfo());
		map.put("issbm", mbsReservedInfo.getIssbm());
		map.put("isncb", mbsReservedInfo.getIsncb());
		map.put("isict", mbsReservedInfo.getIsict());
		map.put("isubc", mbsReservedInfo.getIsubc());
		map.put("isebd", mbsReservedInfo.getIsebd());
		map.put("istaxsb", mbsReservedInfo.getIstaxsb());
		map.put("isonecert", mbsReservedInfo.getIsonecert());
		map.put("busino", mbsReservedInfo.getBusino());
		map.put("appnumber", mbsReservedInfo.getAppnumber());
		map.put("appvaldate", mbsReservedInfo.getAppvaldate());
		map.put("appisval", mbsReservedInfo.getAppisval());
		map.put("contname", mbsReservedInfo.getContname());
		map.put("contidtype", mbsReservedInfo.getContidtype());
		map.put("contidno", mbsReservedInfo.getContidno());
		map.put("contchkcode", mbsReservedInfo.getContchkcode());
		map.put("contchkmsg", mbsReservedInfo.getContchkmsg());
		map.put("contidvaldate", mbsReservedInfo.getContidvaldate());
		map.put("contsuperior", mbsReservedInfo.getContsuperior());
		map.put("contseal", mbsReservedInfo.getContseal());
		map.put("trusteesealname", mbsReservedInfo.getTrusteesealname());
		map.put("trusteeidno", mbsReservedInfo.getTrusteeidno());
		map.put("sealacctno", mbsReservedInfo.getSealacctno());
		map.put("sealcardno", mbsReservedInfo.getSealcardno());
		map.put("ncbmantype", mbsReservedInfo.getNcbmantype());
		map.put("ncbname", mbsReservedInfo.getNcbname());
		map.put("ncbidtype", mbsReservedInfo.getNcbidtype());
		map.put("ncbidno", mbsReservedInfo.getNcbidno());
		map.put("ncbchkcode", mbsReservedInfo.getNcbchkcode());
		map.put("ncbchkmsg", mbsReservedInfo.getNcbchkmsg());
		map.put("ncbtelephone", mbsReservedInfo.getNcbtelephone());
		map.put("ncbcode", mbsReservedInfo.getNcbcode());
		map.put("ncbusbkeynum", mbsReservedInfo.getNcbusbkeynum());
		map.put("ncbonelim", mbsReservedInfo.getNcbonelim());
		map.put("ncbdaylim", mbsReservedInfo.getNcbdaylim());
		map.put("ictphoneno1", mbsReservedInfo.getIctphoneno1());
		map.put("ictphoneno2", mbsReservedInfo.getIctphoneno2());
		map.put("ictphoneno3", mbsReservedInfo.getIctphoneno3());
		map.put("ictphoneno4", mbsReservedInfo.getIctphoneno4());
		map.put("ictphoneno5", mbsReservedInfo.getIctphoneno5());
		map.put("ubcmantype", mbsReservedInfo.getUbcmantype());
		map.put("ubcname", mbsReservedInfo.getUbcname());
		map.put("ubcidtype", mbsReservedInfo.getUbcidtype());
		map.put("ubcidno", mbsReservedInfo.getUbcidno());
		map.put("ubcidvaldate", mbsReservedInfo.getUbcidvaldate());
		map.put("ubctelephone", mbsReservedInfo.getUbctelephone());
		map.put("blretcode", mbsReservedInfo.getBlretcode());
		map.put("blretmsg", mbsReservedInfo.getBlretmsg());
		map.put("exclistret", mbsReservedInfo.getExclistret());
		map.put("corpstatusret", mbsReservedInfo.getCorpstatusret());
		map.put("checknote", mbsReservedInfo.getChecknote());
		map.put("lockedtellerno", mbsReservedInfo.getLockedtellerno());
		map.put("upddate", mbsReservedInfo.getUpddate());
		map.put("updtime", mbsReservedInfo.getUpdtime());
		map.put("openmbr", mbsReservedInfo.getOpenmbr());
		map.put("openzone", mbsReservedInfo.getOpenzone());
		map.put("openbrname", mbsReservedInfo.getOpenbrname());
		map.put("iselec", mbsReservedInfo.getIselec());
		map.put("elecname1", mbsReservedInfo.getElecname1());
		map.put("electelephone1", mbsReservedInfo.getElectelephone1());
		map.put("elecname2", mbsReservedInfo.getElecname2());
		map.put("electelephone2", mbsReservedInfo.getElectelephone2());
		map.put("lastdaysendst", mbsReservedInfo.getLastdaysendst());
		map.put("postcode", mbsReservedInfo.getPostcode());
		map.put("cutonelim", mbsReservedInfo.getCutonelim());
		map.put("cutdaylim", mbsReservedInfo.getCutdaylim());
		map.put("ncbtype", mbsReservedInfo.getNcbtype());
		map.put("ncbukeytype", mbsReservedInfo.getNcbukeytype());
		map.put("depotp", mbsReservedInfo.getDepotp());
		map.put("sendtype", mbsReservedInfo.getSendtype());
		map.put("taskid", mbsReservedInfo.getTaskid());
		map.put("contentno", mbsReservedInfo.getContentno());
		map.put("modelno", mbsReservedInfo.getModelno());
		map.put("mybank", mbsReservedInfo.getMybank());
		map.put("applytp", mbsReservedInfo.getApplytp());
		map.put("deponame", mbsReservedInfo.getDeponame());
		map.put("oplicimg", mbsReservedInfo.getOplicimg());
		map.put("operidbkimg", mbsReservedInfo.getOperidbkimg());
		map.put("operidfrimg", mbsReservedInfo.getOperidfrimg());
		map.put("finaidbkimg", mbsReservedInfo.getFinaidbkimg());
		map.put("finaidfrimg", mbsReservedInfo.getFinaidfrimg());
		map.put("corpidbkimg", mbsReservedInfo.getCorpidbkimg());
		map.put("corpidfrimg", mbsReservedInfo.getCorpidfrimg());
		map.put("taximg", mbsReservedInfo.getTaximg());
		map.put("organimg", mbsReservedInfo.getOrganimg());
		map.put("busiimg", mbsReservedInfo.getBusiimg());
		map.put("audit_channels", mbsReservedInfo.getAudit_channels());
		map.put("corp_cert_result", mbsReservedInfo.getCorp_cert_result());
		map.put("corp_check_result", mbsReservedInfo.getCorp_check_result());
		map.put("fina_cert_result", mbsReservedInfo.getFina_cert_result());
		map.put("fina_check_result", mbsReservedInfo.getFina_check_result());
		map.put("oper_cert_result", mbsReservedInfo.getOper_cert_result());
		map.put("oper_check_result", mbsReservedInfo.getOper_check_result());
		map.put("if_account", mbsReservedInfo.getIf_account());
		map.put("if_depotp_name", mbsReservedInfo.getIf_depotp_name());
		map.put("if_depotp_type", mbsReservedInfo.getIf_depotp_type());
		map.put("if_address", mbsReservedInfo.getIf_address());
		map.put("if_corp", mbsReservedInfo.getIf_corp());
		map.put("if_registered", mbsReservedInfo.getIf_registered());
		map.put("if_business_scope", mbsReservedInfo.getIf_business_scope());
		map.put("file_number", mbsReservedInfo.getFile_number());
		map.put("taxation", mbsReservedInfo.getTaxation());
		map.put("account_one", mbsReservedInfo.getAccount_one());
		map.put("other", mbsReservedInfo.getOther());
		map.put("establish_date", mbsReservedInfo.getEstablish_date());
		map.put("busid_stadate", mbsReservedInfo.getBusid_stadate());
		map.put("busid_enddate", mbsReservedInfo.getBusid_enddate());
		map.put("enterprise_state", mbsReservedInfo.getEnterprise_state());
		map.put("registered", mbsReservedInfo.getRegistered());
		map.put("business_scope", mbsReservedInfo.getBusiness_scope());
		map.put("residence", mbsReservedInfo.getResidence());
		map.put("annual_year", mbsReservedInfo.getAnnual_year());
		map.put("annual_daty", mbsReservedInfo.getAnnual_daty());
		map.put("annualreport", mbsReservedInfo.getAnnualreport());
		map.put("directory_in_time", mbsReservedInfo.getDirectory_in_time());
		map.put("directory_out_time", mbsReservedInfo.getDirectory_out_time());
		map.put("directory", mbsReservedInfo.getDirectory());
		map.put("delict_namelist", mbsReservedInfo.getDelict_namelist());
		map.put("lncluded_wh", mbsReservedInfo.getLncluded_wh());
		map.put("lncluded_office", mbsReservedInfo.getLncluded_office());
		map.put("lncluded_reason", mbsReservedInfo.getLncluded_reason());
		map.put("moveout_time", mbsReservedInfo.getMoveout_time());
		map.put("moveout_wh", mbsReservedInfo.getMoveout_wh());
		map.put("moveout_office", mbsReservedInfo.getMoveout_office());
		map.put("moveout_reason", mbsReservedInfo.getMoveout_reason());
		map.put("breakfaith_name", mbsReservedInfo.getBreakfaith_name());
		map.put("inspect_result", mbsReservedInfo.getInspect_result());
		map.put("risk", mbsReservedInfo.getRisk());
		map.put("inspect_result_id", mbsReservedInfo.getInspect_result_id());
		map.put("black_type_result", mbsReservedInfo.getBlack_type_result());
		map.put("gs_usccode", mbsReservedInfo.getGs_usccode());
		map.put("gs_corpidfr", mbsReservedInfo.getGs_corpidfr());
		map.put("gs_compname", mbsReservedInfo.getGs_compname());
		map.put("gs_orgcode", mbsReservedInfo.getGs_orgcode());
		map.put("respcode", mbsReservedInfo.getRespcode());
		map.put("busistartdate", mbsReservedInfo.getBusistartdate());
		return map;
	}

}
