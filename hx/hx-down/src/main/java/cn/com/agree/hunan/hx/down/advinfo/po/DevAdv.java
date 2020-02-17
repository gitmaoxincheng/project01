package cn.com.agree.hunan.hx.down.advinfo.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.hunan.hx.down.advinfo.po.DevAdv.csis_channel_devadv;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 广告发布表Bean
 * @author Maoxc
 */
@Getter
@Setter
@ToString
@Table(csis_channel_devadv.class)
public class DevAdv implements Serializable {
	private static final long serialVersionUID = 1L;
	private String devId;//设备编号
	private String adTempId;//广告模板编号
	private String jsonString;//生成的JSON
	private String updTime;//更新时间
	private String updDate;//更新日期


	public static class csis_channel_devadv {

	}

	/**
	 * @param devAdv
	 * @return
	 */
	public static Map<String, Object> getMap(DevAdv devAdv) {
		Map<String, Object> map = new HashMap<>();
		map.put("devId",devAdv.getDevId());
		map.put("adTempId",devAdv.getAdTempId());
		map.put("jsonString",devAdv.getJsonString());		
		map.put("updTime",devAdv.getUpdTime());
		map.put("updDate",devAdv.getUpdDate());
		return map;
	}

}
