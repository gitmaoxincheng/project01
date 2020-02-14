package cn.com.agree.huanan.ap.al.csitrd.base.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.base.po.TimeoutCfg.CSIS_TIMEOUT_CFG;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;

/**
 * 超时交易配置表
 * 
 * @author guyulong
 */
@Data
@Table(CSIS_TIMEOUT_CFG.class)
public class TimeoutCfg implements Serializable {
	private static final long serialVersionUID = 8044011127084150365L;

	private String trancode;// 交易码（服务码+场景号）
	private String tranname;// 交易名称
	private String trantype;// 交易类型
	private String paravalue2;// 接口目标类型
	private String svccode;// 超时接口服务码
	private String scncode;// 超时接口场景码
	private String tablename;// 对应场景需要使用的数据库表
	private String tablenamesub;// 对应场景需要使用的数据库表子表

	public static class CSIS_TIMEOUT_CFG {
	}

	public static Map<String, Object> getMap(TimeoutCfg timeoutCfg) {
		Map<String, Object> map = new HashMap<>();
		map.put("trancode", timeoutCfg.getTrancode());
		map.put("tranname", timeoutCfg.getTranname());
		map.put("trantype", timeoutCfg.getTrantype());
		map.put("paravalue2", timeoutCfg.getParavalue2());
		map.put("svccode", timeoutCfg.getSvccode());
		map.put("scncode", timeoutCfg.getScncode());
		map.put("tablename", timeoutCfg.getTablename());
		map.put("tablenamesub", timeoutCfg.getTablenamesub());
		return map;
	}
}
