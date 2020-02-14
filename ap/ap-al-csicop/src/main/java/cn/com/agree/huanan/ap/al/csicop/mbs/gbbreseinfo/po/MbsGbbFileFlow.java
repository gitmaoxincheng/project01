package cn.com.agree.huanan.ap.al.csicop.mbs.gbbreseinfo.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;

/**
 * 文件处理流水表
 * 
 * @author guyulong
 */
@Data
@Table(MbsGbbFileFlow.CSIS_MBS_GBB_FILE_FLOW.class)
public class MbsGbbFileFlow implements Serializable {
	private static final long serialVersionUID = -5607723428319171618L;

	private String filedate;// 文件日期
	private String filepath;// 文件路径
	private String stat;// 状态 0-待处理;1-成功;2-失败;3-异常
	private String errormsg;// 错误信息
	private String upddate;// 处理日期
	private String updtime;// 处理时间

	public static class CSIS_MBS_GBB_FILE_FLOW {
	}

	public static Map<String, Object> getMap(MbsGbbFileFlow mbsGbbFileFlow) {
		Map<String, Object> map = new HashMap<>();
		map.put("filedate", mbsGbbFileFlow.getFiledate());
		map.put("filepath", mbsGbbFileFlow.getFilepath());
		map.put("stat", mbsGbbFileFlow.getStat());
		map.put("errormsg", mbsGbbFileFlow.getErrormsg());
		map.put("upddate", mbsGbbFileFlow.getUpddate());
		map.put("updtime", mbsGbbFileFlow.getUpdtime());
		return map;
	}
}
