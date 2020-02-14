package cn.com.agree.huanan.ap.al.csiopr.service.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.service.po.ServiceCenter.csis_service_center;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 服务中心表Bean
 * @author Maoxc
 */
@Getter
@Setter
@ToString
@Table(csis_service_center.class)
public class ServiceCenter implements Serializable {
	private static final long serialVersionUID = 1L;	
	private String svcCentCode;//服务中心码
	private String svcCentName;//服务中心名称
	private String remark;//备注


	public static class csis_service_center {
	}

	/**
	 *
	 * @param serviceCenter 服务中心信息
	 * @return map 数据map
	 */
	public static Map<String, Object> getMap(ServiceCenter serviceCenter) {
	    Map<String, Object> map = new HashMap<>();
	    map.put("svccentcode",serviceCenter.getSvcCentCode());
	    map.put("svccentname",serviceCenter.getSvcCentName());
		map.put("remark",serviceCenter.getRemark());
		return map;
	}	

}
