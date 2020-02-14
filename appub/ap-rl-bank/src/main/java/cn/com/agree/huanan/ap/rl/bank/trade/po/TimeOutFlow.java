package cn.com.agree.huanan.ap.rl.bank.trade.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.rl.bank.trade.po.TimeOutFlow.CSIS_TIMEOUT_FLOW;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;

/**
 * 平台超时交易流水表
 * 
 * @author GYL
 */
@Data
@Table(CSIS_TIMEOUT_FLOW.class)
public class TimeOutFlow implements Serializable {
	private static final long serialVersionUID = -6221235441302730519L;

	private String reqSerialNo;// 请求方流水号
	private String reqSysId;// 请求方系统标识
	private String reqDate;// 请求方日期
	private String reqTime;// 请求方时间
	private String gloSeqNo;// 全局流水号
	private String reqCalCod;// 请求方渠道编码
	private String serialNo;// 平台交易流水
	private String tradeDate;// 平台交易日期
	private String tradeTime;// 平台交易时间
	private String traceId;// 链路ID
	private String bussCeNo;// 业务场景流水号
	private String svcOutCode;// 外部服务码
	private String scnOutCode;// 外部场景码
	private String svcCode;// 服务码
	private String scnCode;// 场景码
	private String srcSysId;// 源请求方系统标识
	private String srcCalCod;// 源请求方渠道编码
	private String tellerNo;// 柜员号
	private String tellerTp;// 柜员类型
	private String myBank;// 法人号
	private String zoneNo;// 分行号
	private String mbrNo;// 支行号
	private String brNo;// 网点号
	private String devNo;// 设备编号
	private String authTellerNo;// 授权柜员
	private String isPass;// 是否交易透传，0-否 1-是
	private String respSts;// 交易状态
	private String errorCode;// 消息码
	private String errorMsg;// 消息码描述
	private String updTime;// 更新时间
	private String updDate;// 更新日期
	private int totTime; // 交易耗时
	// 扩充字段
	private String tradeName; // 交易名称
	private String custNo; // 客户号
	private String custName; // 客户名称
	private String idType; // 客户名称
	private String idNo; // 客户名称
	private String billNo; // 单据号
	private String billType; // 交易类型	
	private String acctNo; // 账号
	private String oppAcctNo; // 对方账号
	private String amount; // 金额

	public static class CSIS_TIMEOUT_FLOW {
	}

	public static Map<String, Object> getMap(TimeOutFlow timeOutFlow) {
		Map<String, Object> map = new HashMap<>();
		map.put("reqserialno", timeOutFlow.getReqSerialNo());
		map.put("reqsysid", timeOutFlow.getReqSysId());
		map.put("reqdate", timeOutFlow.getReqDate());
		map.put("reqtime", timeOutFlow.getReqTime());
		map.put("gloseqno", timeOutFlow.getGloSeqNo());
		map.put("reqcalcod", timeOutFlow.getReqCalCod());
		map.put("tradedate", timeOutFlow.getTradeDate());
		map.put("serialno", timeOutFlow.getSerialNo());
		map.put("tradetime", timeOutFlow.getTradeTime());
		map.put("traceId", timeOutFlow.getTraceId());
		map.put("bussceno", timeOutFlow.getBussCeNo());
		map.put("svcoutcode", timeOutFlow.getSvcOutCode());
		map.put("scnoutcode", timeOutFlow.getScnOutCode());
		map.put("svccode", timeOutFlow.getSvcCode());
		map.put("scncode", timeOutFlow.getScnCode());
		map.put("scrsysId", timeOutFlow.getSrcSysId());
		map.put("scrcalcod", timeOutFlow.getSrcCalCod());
		map.put("tellerNo", timeOutFlow.getTellerNo());
		map.put("tellertp", timeOutFlow.getTellerTp());
		map.put("mybank", timeOutFlow.getMyBank());
		map.put("zoneno", timeOutFlow.getZoneNo());
		map.put("mbrno", timeOutFlow.getMbrNo());
		map.put("brno", timeOutFlow.getBrNo());
		map.put("devno", timeOutFlow.getDevNo());
		map.put("authtellerno", timeOutFlow.getAuthTellerNo());
		map.put("ispass", timeOutFlow.getIsPass());
		map.put("respsts", timeOutFlow.getRespSts());
		map.put("errorcode", timeOutFlow.getErrorCode());
		map.put("errormsg", timeOutFlow.getErrorMsg());
		map.put("upddate", timeOutFlow.getUpdDate());
		map.put("updtime", timeOutFlow.getUpdTime());
		map.put("tottime", timeOutFlow.getTotTime());
		map.put("tradeName", timeOutFlow.getTradeName());
		map.put("custNo", timeOutFlow.getCustNo());
		map.put("custName", timeOutFlow.getCustName());
		map.put("billNo", timeOutFlow.getBillNo());
		map.put("billType", timeOutFlow.getBillType());
		map.put("acctNo", timeOutFlow.getAcctNo());
		map.put("oppAcctNo", timeOutFlow.getOppAcctNo());
		map.put("amount", timeOutFlow.getAmount());
		return map;
	}
}
