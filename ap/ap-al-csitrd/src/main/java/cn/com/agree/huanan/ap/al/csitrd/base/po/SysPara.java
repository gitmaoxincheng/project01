package cn.com.agree.huanan.ap.al.csitrd.base.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.rl.bank.base.po.Syspara.csis_syspara;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
* 参数表Bean
* @author maowei
*/
@Getter
@Setter
@ToString
@Table(csis_syspara.class)
public class SysPara implements Serializable {

	private String paraItem;//参数类别
	private String paraName;//参数名
	private String paraCode;//参数码
	private String paraValue1;//参数值1
	private String paraValue2;//参数值2

	public static class csis_syspara {
		        
	   }
	    
	public static Map<String, Object> getMap(SysPara sysPara) {
	    Map<String, Object> map = new HashMap<>();
	    map.put("paraitem", sysPara.getParaItem());
	    map.put("paraname", sysPara.getParaName());
	    map.put("paracode", sysPara.getParaCode());
	    map.put("paravalue1", sysPara.getParaValue1());
	    map.put("paravalue2", sysPara.getParaValue2());
	    return map;
	  }
}
