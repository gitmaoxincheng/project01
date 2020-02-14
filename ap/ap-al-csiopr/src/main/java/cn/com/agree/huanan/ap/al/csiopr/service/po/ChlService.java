package cn.com.agree.huanan.ap.al.csiopr.service.po;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.HashMap;
import java.util.Map;

/**
 * 渠道服务Bean
 * @author wb
 *
 */
@Getter
@Setter
@ToString
@Table(ChlService.csis_service.class)
public class ChlService {
	private String id;//服务标识
	private String svcCode;//服务码
	private String scnCode;//场景码
	private String svcName;//场景名称
	private String scnName;//服务中心码
	private String svcGroup;//服务分组
	private String type;//服务类型（0-转发服务，1-组合服务，0-本地服务，）
	private String status;//状态码
	private String timeOut;//调用超时时间
	private String remark;//备注

	public static class csis_service{}
        

    public static Map<String, Object> getMap(ChlService chlService) {
    	Map<String, Object> map = new HashMap<>();
    	map.put("id", chlService.getId());
    	map.put("svcCode", chlService.getSvcCode());
    	map.put("scnCode", chlService.getScnCode());
    	map.put("svcName", chlService.getSvcName());
    	map.put("scnName", chlService.getScnName());
		map.put("svcGroup", chlService.getSvcGroup());
		map.put("status", chlService.getStatus());
		map.put("timeOut", chlService.getTimeOut());
		map.put("remark", chlService.getRemark());
		return map;
    }
}
