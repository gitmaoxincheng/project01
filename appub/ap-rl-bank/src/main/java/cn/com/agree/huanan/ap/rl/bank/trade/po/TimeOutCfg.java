package cn.com.agree.huanan.ap.rl.bank.trade.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.rl.bank.trade.po.TimeOutCfg.CSIS_TIMEOUT_CFG;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;

/**
 * 超时交易配置表
 * 
 * @author guyulong
 */
@Data
@Table(CSIS_TIMEOUT_CFG.class)
public class TimeOutCfg implements Serializable {
	private static final long serialVersionUID = 8044011127084150365L;

	private String tradeCode; // 交易码
	private String tradeName; // 交易名称
	private String tradeType; // 交易类型 0-原子;1-组合
	private String interType; // 接口目标类型 1-ECI 2-ESB 3-CSIS
	private String toSvcCode; // 超时接口服务码
	private String toScnCode; // 超时接口场景码
	private String mainTable; // 数据库主表
	private String subTable; // 数据库子表
	private String dealType; // 0-正常处理 1-特殊处理（返回应答报文）

	public static class CSIS_TIMEOUT_CFG {
	}

	public static Map<String, Object> getMap(TimeOutCfg timeoutCgf) {
		Map<String, Object> map = new HashMap<>();
		map.put("tradecode", timeoutCgf.getTradeCode());
		map.put("tradename", timeoutCgf.getTradeName());
		map.put("tradetype", timeoutCgf.getTradeType());
		map.put("intertype", timeoutCgf.getInterType());
		map.put("tosvccode", timeoutCgf.getToSvcCode());
		map.put("toscncode", timeoutCgf.getToScnCode());
		map.put("maintable", timeoutCgf.getMainTable());
		map.put("subtable", timeoutCgf.getSubTable());
		map.put("dealtype", timeoutCgf.getDealType());
		return map;
	}
}
