package cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.po.ExitCtrlDtsy.csis_exitctrldtsy;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 岗位受控系统表Bean
 * @author maoxc
 */
@Getter
@Setter
@ToString
@Table(csis_exitctrldtsy.class)
public class ExitCtrlDtsy implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String dutyNo;//岗位类型
	private String sysIdBuf;//日终受控系统
	private String status;//状态 0-关闭,1-正常
	private String note1;//备注1
	private String note2;//备注2
	private String upddate;//更新日期
	private String updtime;//更新时间

    public static class csis_exitctrldtsy {
        
    }
    
    public static Map<String, Object> getMap(ExitCtrlDtsy exitCtrlDtsy) {
    	Map<String, Object> map = new HashMap<>();
    	map.put("dutyNo", exitCtrlDtsy.getDutyNo());
    	map.put("sysIdBuf", exitCtrlDtsy.getSysIdBuf());
    	map.put("status", exitCtrlDtsy.getStatus());
    	map.put("note1", exitCtrlDtsy.getNote1());
    	map.put("note2", exitCtrlDtsy.getNote2());
    	map.put("upddate", exitCtrlDtsy.getUpddate());
    	map.put("updtime", exitCtrlDtsy.getUpdtime());
    	return map;
    }
    
}
