package cn.com.agree.huanan.ap.al.csitrd.rtmh.po;

import java.io.Serializable; 
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.rtmh.po.RtmhModelInfo.csis_sbm_devmodelinfo;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 设备信息表Bean
 * @author 
 */
@Getter
@Setter
@ToString
@Table(csis_sbm_devmodelinfo.class)
public class RtmhModelInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String modelId;  //设备模块ID
	private String modelName; //设备模块名称
	private String modelSx;//设备模块缩写
	private String modelSp;//设备模块拼写
	private String modelStatus;//设备模块状态
	private String remark1;//备注
	private String remark2;//备注
	private String remark3;//备注
	private String modStatPath;//机具模块信息报文对应的节点名称
	private String dbField;//机具状态表对应的数据库字段
	
	public static class csis_sbm_devmodelinfo {		
	}
	
	/**
	 * @param map 数据map，key:属性名(全大写) value：属性值
	 * @return DutyInfo
	 */
	public static Map<String, Object> getMap(RtmhModelInfo ModelInfo) {
	    Map<String, Object> map = new HashMap<>();
	    map.put("modelId",ModelInfo.getModelId());
	    map.put("modelName",ModelInfo.getModelName());
	    map.put("modelSX",ModelInfo.getModelSx());
	    map.put("modelSP",ModelInfo.getModelSp());
	    map.put("modelStatus",ModelInfo.getModelStatus());
	    map.put("remark1",ModelInfo.getRemark1());
	    map.put("remark2",ModelInfo.getRemark2());
	    map.put("remark3",ModelInfo.getRemark3());
	    map.put("modStatPath",ModelInfo.getModStatPath());
	    map.put("dbField",ModelInfo.getDbField());
	    
	    return map;
	}	
	
}
