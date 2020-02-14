/**
 * 
 */
package cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.po;

import java.util.Map;

import lombok.Data;

/**
 * @author xqq
 * 请求外围系统日志表
 */
@Data
public class EctipRequestOutsyslogBean {
	public String tradeSerno;
	public String serNo;
	public String workDate;
	public String workTime;
	public String svcReqsysid;
	public String svcReqserno;
	public String svcReqdate;
	public String svcReqtime;
	public String chlSysid;
	public String chlSerno;
	public String preChlserno;
	public String chlDate;
	public String chlTime;
	public String chlCode;
	public String chlSubcode;
	public String commSys;
	public String commType;
	public String oriSysid;
	public String reqSysid;
	public String busiSerno;
	public String preBusiserno;
	public String atSvccode;
	public String atScncode;
	public String sysSvccode;
	public String sysScncode;
	public String status;
	public String errorCode;
	public String errorMsg;
	
	public void initBean(Map<String, Object> beanData) {
		this.tradeSerno = beanData.getOrDefault("tradeSerno", "").toString();
		this.serNo = beanData.getOrDefault("serNo", "").toString();
		this.workDate = beanData.getOrDefault("workDate", "").toString();
		this.workTime = beanData.getOrDefault("workTime", "").toString();
		this.svcReqsysid = beanData.getOrDefault("svcReqsysid", "").toString();
		this.svcReqserno = beanData.getOrDefault("svcReqserno", "").toString();
		this.svcReqdate = beanData.getOrDefault("svcReqdate", "").toString();
		this.svcReqtime = beanData.getOrDefault("svcReqtime", "").toString();
		this.chlSysid = beanData.getOrDefault("chlSysid", "").toString();
		this.chlSerno = beanData.getOrDefault("chlSerno", "").toString();
		this.preChlserno = beanData.getOrDefault("preChlserno", "").toString();
		this.chlDate = beanData.getOrDefault("chlDate", "").toString();
		this.chlTime = beanData.getOrDefault("chlTime", "").toString();
		this.chlCode = beanData.getOrDefault("chlCode", "").toString();
		this.chlSubcode = beanData.getOrDefault("chlSubcode", "").toString();
		this.commSys = beanData.getOrDefault("commSys", "").toString();
		this.commType = beanData.getOrDefault("commType", "").toString();
		this.oriSysid = beanData.getOrDefault("oriSysid", "").toString();
		this.reqSysid = beanData.getOrDefault("reqSysid", "").toString();
		this.busiSerno = beanData.getOrDefault("busiSerno", "").toString();
		this.preBusiserno = beanData.getOrDefault("preBusisern", "").toString();
		this.atSvccode = beanData.getOrDefault("atSvccode", "").toString();
		this.atScncode = beanData.getOrDefault("atScncode", "").toString();
		this.sysSvccode = beanData.getOrDefault("sysSvccode", "").toString();
		this.sysScncode = beanData.getOrDefault("sysScncode", "").toString();
		this.status = beanData.getOrDefault("status", "").toString();
		this.errorCode = beanData.getOrDefault("errorCode", "").toString();
		this.errorMsg = beanData.getOrDefault("errorMsg", "").toString();
	}
	
	public static String getTableName(){
		return "ECTIP_REQUEST_OUTSYSLOG";
	}
}
