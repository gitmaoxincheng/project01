package cn.com.agree.huanan.ap.tl.communicate.comm.base;

import java.util.HashMap;
import java.util.Map;
/**
 * @author luo.hp
 * @category 通信Map和List常量定义
 */
public class ConstMapAndList {
	
	/**
	 * 支持的通信类型
	 */
	// Communicate Method
	public final static Map<String, String> COMMUNICATE_SUPPORT = new HashMap<String, String>(){
	/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
		put("SOCK", "Soecket");
		put("NATP", "Natp");
		put("HTTP", "Http");
		put("HTTPS", "Https");
		put("IBMMQ", "IbmMq");
		put("ESBTCP", "ESBTCP");
	}};
}
