package cn.com.agree.huanan.ap.al.csitrd.base.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.base.po.OccuCode.TRADEINFO_OCCU_CODE;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 职业代码表bean
 * @author liaowen
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_OCCU_CODE.class)
public class OccuCode implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1394511480350807945L;
	                              
	private String occucode;      //职业编码
	private String occuname;      //职业名称
	private String occulevel;     //层级
	private String upoccucode;    //父级职业编码
	private String isvalid;       //是否生效
	private String occode;        //
	private String int1;          //
	private String tacode;        //保险公司代码
	
	public static class TRADEINFO_OCCU_CODE{
		
	}

	public static Map<String, Object> getMap(OccuCode occu){
		Map<String, Object> map = new HashMap<>();
		
		map.put("occucode",occu.getOccucode());
		map.put("occuname",occu.getOccuname());
		map.put("occulevel",occu.getOcculevel());
		map.put("upoccucode",occu.getUpoccucode());
		map.put("isvalid",occu.getIsvalid());
		map.put("occode",occu.getOccode());
		map.put("int1",occu.getInt1());
		map.put("tacode",occu.getTacode());


		return map;
	}
}
