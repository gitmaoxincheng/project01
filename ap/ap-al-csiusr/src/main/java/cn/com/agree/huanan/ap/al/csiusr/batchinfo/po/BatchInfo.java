package cn.com.agree.huanan.ap.al.csiusr.batchinfo.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.batchinfo.po.BatchInfo.csis_batch_info;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(csis_batch_info.class)
public class BatchInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3521541834144762666L;
	
	private String batno;//流水号
	private String workdate;//交易日期
	private String worktime;//交易时间
	private String servecodeout;//外部服务码
	private String scenecodeout;//外部场景码
	private String servecode;//服务码
	private String scenecode;//场景码
	private String srcdate;//请求方日期
	private String srcsysid;//源请求方系统标识
	private String srccalcod;//源请求方渠道编号
	private String gloseqno;//源全局流水号
	private String filename;//文件名
	private String status;//状态
	private String remarks;//备注
	private String upddate;//更新日期
	private String updtime;//更新时间
	private String brno;//行所
	private String tellerno;//柜员
	private String exittlrno;//被签退柜员


	public static class csis_batch_info {
        
    }
	
	 public static Map<String, Object> getMap(BatchInfo batchInfo){
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("batno",batchInfo.getBatno());
	    	map.put("workdate",batchInfo.getWorkdate());
	    	map.put("worktime",batchInfo.getWorktime());
	    	map.put("servecodeout",batchInfo.getServecodeout());
	    	map.put("servecode",batchInfo.getServecode());
	    	map.put("scenecode",batchInfo.getScenecode());
	    	map.put("srcdate",batchInfo.getSrcdate());
	    	map.put("scenecodeout",batchInfo.getScenecodeout());
	    	map.put("srccalcod",batchInfo.getSrccalcod());
	    	map.put("gloseqno",batchInfo.getGloseqno());
	    	map.put("filename",batchInfo.getFilename());
	    	map.put("status",batchInfo.getStatus());
	    	map.put("remarks",batchInfo.getRemarks());
	    	map.put("srcsysid",batchInfo.getSrcsysid());
	    	map.put("upddate",batchInfo.getUpddate());
	    	map.put("updtime",batchInfo.getUpdtime());
	    	map.put("brno",batchInfo.getBrno());
	    	map.put("tellerno",batchInfo.getTellerno());
	    	map.put("exittlrno",batchInfo.getExittlrno());

	    	return map;
	    }

}
