package cn.com.agree.huanan.ap.al.csitrd.base.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.base.po.CertarCode.TRADEINFO_CERTAR_CODE;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 发证机关代码表bean
 * @author liaowen
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_CERTAR_CODE.class)
public class CertarCode implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6429863833759899400L;
	
	private String certarcode;  //发证机关代码
	private String certarname;  //发证机关名称
	
	public static class TRADEINFO_CERTAR_CODE{
		
	}

	public static Map<String, Object> getMap(CertarCode certar){
		Map<String, Object> map = new HashMap<>();
		
		map.put("certarcode",certar.getCertarcode());
		map.put("certarname",certar.getCertarname());
		
		return map;
	}
}
