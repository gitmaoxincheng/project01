package cn.com.agree.huanan.ap.al.csicop.mbs.reservednew.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;

/**
 * 微网点预约登记信息表Bean
 */
@Data
@Table(NewReseInfo.CSIS_MBS_RESERVED_INFO_NEW.class)
public class NewReseInfo implements Serializable {
	private static final long serialVersionUID = 8294137370489448041L;

	private String serialno;// 交易流水号
	private String tradedate;// 交易日期
	private String tradetime;// 交易时间
	private String custno;// 客户号
	private String acctno;// 账号
	private String applytp;// 申请类型
	private String tobrno;// 开户网点
	private String compname;// 企业名称
	private String operphone;// 开户经办人手机号
	private String opername;// 经办人姓名
	private String operidtype;// 经办人证件类型
	private String operidno;// 经办人证件号码
	private String operchkcode;// 经办人身份核查结果码
	private String operchkmsg;// 经办人身份核查结果信息
	private String operidvaldate;// 经办人证件有效期,YYYYMMDD
	private String custname;// 客户名称
	private String custidtype;// 客户证件类型
	private String custidno;// 客户证件号码
	private String custchkcode;// 客户身份核查结果码
	private String custchkmsg;// 客户身份核查结果信息
	private String custidvaldate;// 客户证件有效期
	private String fladna; // 财务负责人姓名
	private String fdidtp; // 财务负责人证件类型
	private String fdidno; // 财务负责人证件号码
	private String fladchkcoke; // 财务负责人身份核查结果码
	private String fladchkmsg; // 财务负责人身份核查结果信息
	private String fdctdt; // 财务负责人证件有效期
	private String bussdata;// 业务数据
	private String status;// 状态
	private String checktellerno;// 审核柜员号
	private String checkdate;// 审核日期
	private String checktime;// 审核时间
	private String checkreason;// 审核不通过原因, 以|分隔
	private String checkmark;// 审核批注/申请失败原因
	private String appnumber;// 申请编号
	private String appvaldate;// 申请有效截止日期
	private String appisval;// 申请有效标识
	private String blackchkcode;// 黑名单检查结果代码
	private String blackchkmsg;// 黑名单检查结果信息
	private String exclistret;// 企业异常名录检查结果
	private String corpstatusret;// 企业状态检查
	private String checknote;// 审核记录要素,用于记录柜面的审核要素
	private String lockedtellerno;// 锁定柜员号
	private String upddate;// 更新日期
	private String updtime;// 更新时间
	private String sysid;// 系统标识
	private String sendtype;// 是否成功发送集中作业部
	private String taskid;// 集中处理业务平台任务号
	private String contentno;// 证件图片批次号
	private String modelno;// 证件图片模型号
	private String mybank; // 法人号
	private String lastdaysendst; // 失效前一天短信通知状态 默认N未通知 Y已通知
	private String afterdaysendst;// 失效后一天短信通知状态 默认N未通知 Y已通知
	private String busistartdate;// 影像上传时间

	public static class CSIS_MBS_RESERVED_INFO_NEW {
	}

	public static Map<String, Object> getMap(NewReseInfo reseInfo) {
		Map<String, Object> map = new HashMap<>();
		map.put("serialno", reseInfo.getSerialno());
		map.put("tradedate", reseInfo.getTradedate());
		map.put("tradetime", reseInfo.getTradetime());
		map.put("custno", reseInfo.getCustno());
		map.put("acctno", reseInfo.getAcctno());
		map.put("applytp", reseInfo.getApplytp());
		map.put("tobrno", reseInfo.getTobrno());
		map.put("compname", reseInfo.getCompname());
		map.put("operphone", reseInfo.getOperphone());
		map.put("opername", reseInfo.getOpername());
		map.put("operidtype", reseInfo.getOperidtype());
		map.put("operidno", reseInfo.getOperidno());
		map.put("operchkcode", reseInfo.getOperchkcode());
		map.put("operchkmsg", reseInfo.getOperchkmsg());
		map.put("operidvaldate", reseInfo.getOperidvaldate());
		map.put("custname", reseInfo.getCustname());
		map.put("custidtype", reseInfo.getCustidtype());
		map.put("custidno", reseInfo.getCustidno());
		map.put("custchkcode", reseInfo.getCustchkcode());
		map.put("custchkmsg", reseInfo.getCustchkmsg());
		map.put("custidvaldate", reseInfo.getCustidvaldate());
		map.put("fladna ", reseInfo.getFladna());
		map.put("fdidtp", reseInfo.getFdidtp());
		map.put("fdidno", reseInfo.getFdidno());
		map.put("fladchkcoke", reseInfo.getFladchkcoke());
		map.put("fladchkmsg", reseInfo.getFladchkmsg());
		map.put("fdctdt", reseInfo.getFdctdt());
		map.put("bussdata", reseInfo.getBussdata());
		map.put("status", reseInfo.getStatus());
		map.put("checktellerno", reseInfo.getChecktellerno());
		map.put("checkdate", reseInfo.getCheckdate());
		map.put("checktime", reseInfo.getChecktime());
		map.put("checkreason", reseInfo.getCheckreason());
		map.put("checkmark", reseInfo.getCheckmark());
		map.put("appnumber", reseInfo.getAppnumber());
		map.put("appvaldate", reseInfo.getAppvaldate());
		map.put("appisval", reseInfo.getAppisval());
		map.put("blackchkcode", reseInfo.getBlackchkcode());
		map.put("blackchkmsg", reseInfo.getBlackchkmsg());
		map.put("exclistret", reseInfo.getExclistret());
		map.put("corpstatusret", reseInfo.getCorpstatusret());
		map.put("checknote", reseInfo.getChecknote());
		map.put("lockedtellerno", reseInfo.getLockedtellerno());
		map.put("upddate", reseInfo.getUpddate());
		map.put("updtime", reseInfo.getUpdtime());
		map.put("sysid", reseInfo.getSysid());
		map.put("sendtype", reseInfo.getSendtype());
		map.put("taskid", reseInfo.getTaskid());
		map.put("contentno", reseInfo.getContentno());
		map.put("modelno", reseInfo.getModelno());
		map.put("mybank", reseInfo.getMybank());
		map.put("lastdaysendst", reseInfo.getLastdaysendst());
		map.put("afterdaysendst", reseInfo.getAfterdaysendst());
		map.put("busistartdate", reseInfo.getBusistartdate());
		return map;
	}
}
