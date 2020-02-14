package cn.com.agree.huanan.ap.al.csiopr.service.po;

import cn.com.agree.huanan.ap.al.csiopr.service.po.TranMapp.csis_tran_mapp;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * 交易映射表
 * @author HCP
 *
 */
@Getter
@Setter
@ToString
@Table(csis_tran_mapp.class)
public class TranMapp {
	private String svcOutCode;//对外发布服务码
	private String scnOutCode;//对外发布场景码
	private String svcOutName;//对外发布服务名
	private String scnOutName;//对外发布场景名
	private String svcCode;//内部服务码
	private String scnCode;//内部场景码
	private String svcGroup;//服务分组
	private String type;//交易类型
	private String regFlag;//流水登记超时，0-登记，1-不登记，2-超时登记
	private String status;//状态，0-启用，1-停用
	private String timeOut;//超时时间
	private String remark;//描述

	public static class csis_tran_mapp {

	}


	/**
	 *
	 * @param tranMapp 交易映射记录
	 * @return map 数据map
	 */
	public static Map<String, Object> getMap(TranMapp tranMapp) {
		Map<String, Object> map = new HashMap<>();
		map.put("svcoutcode", tranMapp.getSvcOutCode());
		map.put("scnoutcode", tranMapp.getScnOutCode());
		map.put("svcoutname", tranMapp.getSvcOutName());
		map.put("scnoutname", tranMapp.getScnOutName());
		map.put("svccode", tranMapp.getSvcCode());
		map.put("scncode", tranMapp.getScnCode());
		map.put("svcgroup", tranMapp.getSvcGroup());
		map.put("type", tranMapp.getType());
		map.put("regflag", tranMapp.getRegFlag());
		map.put("status", tranMapp.getStatus());
		map.put("timeout", tranMapp.getTimeOut());
		map.put("remark", tranMapp.getRemark());
		return map;
	}
    

}
