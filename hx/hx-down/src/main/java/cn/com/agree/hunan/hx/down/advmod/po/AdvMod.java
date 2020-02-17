package cn.com.agree.hunan.hx.down.advmod.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.hunan.hx.down.advmod.po.AdvMod.csis_channel_advmod;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(csis_channel_advmod.class)
public class AdvMod implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8180163220352766855L;
	
	private String adtempid;            //广告模板编号
	private String tempname;            //广告模板名称
	private String type;                //类别
	private String adid;                //广告编号
	private String tempdesc;            //广告模板描述
	private String upddate;             //更新日期
	private String updtime;             //更新时间

	public static class csis_channel_advmod{	
		
	}
	
	public static Map<String, Object> getMap(AdvMod advMod){
		 Map<String, Object> map = new HashMap<>();
		 map.put("adtempid", advMod.getAdtempid());
		 map.put("tempname", advMod.getTempname());
		 map.put("type", advMod.getType());
		 map.put("adid", advMod.getAdid());
		 map.put("tempdesc", advMod.getTempdesc());
		 map.put("upddate", advMod.getUpddate());
		 map.put("updtime", advMod.getUpdtime());
		 return map;
	}
	

}
