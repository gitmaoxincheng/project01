package cn.com.agree.huanan.ap.al.csiusr.advinfo.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.advinfo.po.AdvInfo.csis_channel_advinfo;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 广告文件信息表Bean
 * @author Maoxc
 */
@Getter
@Setter
@ToString
@Table(csis_channel_advinfo.class)
public class AdvInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String adId;//广告编号
	private String fileName;//广告文件名，全文件名
	private String filePath;//广告文件路径，绝对路径
	private String fileDesc;//文件信息描述
	private String startDate;//起始日期
	private String endDate;//终止日期
	private String startTime;//开始播放时间
	private String endTime;//结束播放时间
	private String isenAbled;//是否启用
	private String updTime;//更新时间
	private String updDate;//更新日期

	public static class csis_channel_advinfo {

	}

	/**
	 * @param advInfo
	 * @return
	 */
	public static Map<String, Object> getMap(AdvInfo advInfo) {
		Map<String, Object> map = new HashMap<>();
		map.put("adId",advInfo.getAdId());
		map.put("fileName",advInfo.getFileName());
		map.put("filePath",advInfo.getFilePath());
		map.put("fileDesc",advInfo.getFileDesc());
		map.put("startDate",advInfo.getStartDate());
		map.put("endDate",advInfo.getEndDate());
		map.put("startTime",advInfo.getStartTime());
		map.put("endTime",advInfo.getEndTime());
		map.put("isenAbled",advInfo.getIsenAbled());
		map.put("updTime",advInfo.getUpdTime());
		map.put("updDate",advInfo.getUpdDate());
		return map;
	}

}
