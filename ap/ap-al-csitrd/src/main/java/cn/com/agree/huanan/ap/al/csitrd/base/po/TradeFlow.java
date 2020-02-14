package cn.com.agree.huanan.ap.al.csitrd.base.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.base.po.TradeFlow.CSIS_TRADE_FLOW;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;

/**
 * 渠道整合交易流水表
 * 
 * @author guyulong
 */
@Data
@Table(CSIS_TRADE_FLOW.class)
public class TradeFlow implements Serializable {
	private static final long serialVersionUID = -2677098250223239313L;

	private String reqserialno;// 请求方流水号
	private String reqsysid;// 请求方系统标识
	private String reqdate;// 请求方日期
	private String reqtime;// 请求方时间
	private String gloseqno;// 全局流水号
	private String reqcalcod;// 请求方渠道编码
	private String tradedate;// 平台交易日期
	private String serialno;// 平台返回流水
	private String tradetime;// 平台交易时间
	private String bussceno;// 业务场景流水号
	private String svcoutcode;// 外部服务码
	private String scnoutcode;// 外部场景码
	private String svccode;// 服务码
	private String scncode;// 场景码
	private String scrsysid;// 源请求方系统标识
	private String scrcalcod;// 源请求方渠道编码
	private String tellerno;// 柜员号
	private String tellertp;// 柜员类型
	private String mybank;// 法人号
	private String zoneno;// 分行号
	private String mbrno;// 支行号
	private String brno;// 网点号
	private String devno;// 设备编号
	private String authtellerno;// 授权柜员
	private String isPass;// 是否交易透传，0-否 1-是 
	private String respsts;// 交易状态
	private String errorcode;// 消息码
	private String errormsg;// 消息码描述
	private String upddate;// 更新日期
	private String updtime;// 更新时间
	private String tottime;// 交易耗时

	public static class CSIS_TRADE_FLOW {
	}

	public static Map<String, Object> getMap(TradeFlow tradeFlow) {
		Map<String, Object> map = new HashMap<>();
		map.put("reqserialno", tradeFlow.getReqserialno());
		map.put("reqsysid", tradeFlow.getReqsysid());
		map.put("reqdate", tradeFlow.getReqdate());
		map.put("reqtime", tradeFlow.getReqtime());
		map.put("gloseqno", tradeFlow.getGloseqno());
		map.put("reqcalcod", tradeFlow.getReqcalcod());
		map.put("tradedate", tradeFlow.getTradedate());
		map.put("serialno", tradeFlow.getSerialno());
		map.put("tradetime", tradeFlow.getTradetime());
		map.put("bussceno", tradeFlow.getBussceno());
		map.put("svcoutcode", tradeFlow.getSvcoutcode());
		map.put("scnoutcode", tradeFlow.getScnoutcode());
		map.put("svccode", tradeFlow.getSvccode());
		map.put("scncode", tradeFlow.getScncode());
		map.put("srcsysid", tradeFlow.getScrsysid());
		map.put("srccalcod", tradeFlow.getScrcalcod());
		map.put("tellerno", tradeFlow.getTellerno());
		map.put("tellertp", tradeFlow.getTellertp());
		map.put("mybank", tradeFlow.getMybank());
		map.put("zoneno", tradeFlow.getZoneno());
		map.put("mbrno", tradeFlow.getMbrno());
		map.put("brno", tradeFlow.getBrno());
		map.put("devno", tradeFlow.getDevno());
		map.put("authtellerno", tradeFlow.getAuthtellerno());
		map.put("ispass", tradeFlow.getIsPass());
		map.put("respsts", tradeFlow.getRespsts());
		map.put("errorcode", tradeFlow.getErrorcode());
		map.put("errormsg", tradeFlow.getErrormsg());
		map.put("upddate", tradeFlow.getUpddate());
		map.put("updtime", tradeFlow.getUpdtime());
		map.put("toltime", tradeFlow.getTottime());
		return map;
	}
}
