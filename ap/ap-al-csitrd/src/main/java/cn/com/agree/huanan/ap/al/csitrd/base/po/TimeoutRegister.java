package cn.com.agree.huanan.ap.al.csitrd.base.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.base.po.TimeoutRegister.TRADEINFO_TRADE_TIMEOUT;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ** 超时登记表
 * @author Zhonggp
 *
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_TRADE_TIMEOUT.class)
public class TimeoutRegister implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1773252337195090616L;

	private String tradeDate;    //平台交易日期
	private String serialNo;    //平台流水
	private String tradeTime;    //平台交易时间
	private String reqSerialNo;    //请求方流水号
	private String reqSysId;    //请求方系统标识
	private String reqDate;    //请求方日期
	private String reqTime;    //请求方时间
	private String gloSeqNo;    //全局流水号
	private String reqCalcod;    //请求方渠道编码
	private String busSceNo;    //业务场景流水号
	private String svcoutCode;    //外部服务码
	private String scnoutCode;    //外部场景码
	private String svcCode;    //服务码
	private String scnCode;    //场景码
	private String srcSysId;    //源请求方系统标识
	private String srcCalcod;    //源请求方渠道编码
	private String tellerNo;    //柜员号
	private String tellerTp;    //柜员类型
	private String myBank;    //法人号
	private String zoneNo;    //分行号
	private String mbrNo;    //支行号
	private String brNo;    //网点号
	private String devNo;    //设备编号
	private String authTellerNo;    //授权柜员
	private String respsts;    //交易状态
	private String errorCode;    //消息码
	private String errorMsg;    //消息码描述
	private String updDate;    //更新日期
	private String updTime;    //更新时间
	private String tolTime;    //交易耗时
	private String tranName;    //交易名称
	private String custNo;    //客户号
	private String custName;    //客户名称
	private String acctNo;    //账号
	private String acctName;    //账户名称
	private String amount;    //金额
	private String billNo;    //单据号
	private String billType;    //交易类型
	
	public static class TRADEINFO_TRADE_TIMEOUT {
	}

	public static Map<String, Object> getMap(TimeoutRegister timeoutRegister) {
		Map<String, Object> map = new HashMap<>();
		map.put("tradeDate",timeoutRegister.getTradeDate());
		map.put("serialNo",timeoutRegister.getSerialNo());
		map.put("tradeTime",timeoutRegister.getTradeTime());
		map.put("reqSerialNo",timeoutRegister.getReqSerialNo());
		map.put("reqSysId",timeoutRegister.getReqSysId());
		map.put("reqDate",timeoutRegister.getReqDate());
		map.put("reqTime",timeoutRegister.getReqTime());
		map.put("gloSeqNo",timeoutRegister.getGloSeqNo());
		map.put("reqCalcod",timeoutRegister.getReqCalcod());
		map.put("busSceNo",timeoutRegister.getBusSceNo());
		map.put("svcoutCode",timeoutRegister.getSvcoutCode());
		map.put("scnoutCode",timeoutRegister.getScnoutCode());
		map.put("svcCode",timeoutRegister.getSvcCode());
		map.put("scnCode",timeoutRegister.getScnCode());
		map.put("srcSysId",timeoutRegister.getSrcSysId());
		map.put("srcCalcod",timeoutRegister.getSrcCalcod());
		map.put("tellerNo",timeoutRegister.getTellerNo());
		map.put("tellerTp",timeoutRegister.getTellerTp());
		map.put("myBank",timeoutRegister.getMyBank());
		map.put("zoneNo",timeoutRegister.getZoneNo());
		map.put("mbrNo",timeoutRegister.getMbrNo());
		map.put("brNo",timeoutRegister.getBrNo());
		map.put("devNo",timeoutRegister.getDevNo());
		map.put("authTellerNo",timeoutRegister.getAuthTellerNo());
		map.put("respsts",timeoutRegister.getRespsts());
		map.put("errorCode",timeoutRegister.getErrorCode());
		map.put("errorMsg",timeoutRegister.getErrorMsg());
		map.put("updDate",timeoutRegister.getUpdDate());
		map.put("updTime",timeoutRegister.getUpdTime());
		map.put("tolTime",timeoutRegister.getTolTime());
		map.put("billNo",timeoutRegister.getBillNo());
		map.put("custNo",timeoutRegister.getCustNo());
		map.put("custName",timeoutRegister.getCustName());
		map.put("acctNo",timeoutRegister.getAcctNo());
		map.put("acctName",timeoutRegister.getAcctName());
		map.put("amount",timeoutRegister.getAmount());
		map.put("tranName",timeoutRegister.getTranName());
		map.put("billType",timeoutRegister.getBillType());

		return map;
	}
	
}
