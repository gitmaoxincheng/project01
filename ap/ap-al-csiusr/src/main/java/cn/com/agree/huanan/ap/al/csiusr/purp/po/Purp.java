package cn.com.agree.huanan.ap.al.csiusr.purp.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import cn.com.agree.huanan.ap.al.csiusr.purp.po.Purp.csis_purp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 随机数Bean
 * @author HWW
 */
@Getter
@Setter
@ToString
@Table(csis_purp.class)
public class Purp implements Serializable {
	private static final long serialVersionUID = 9081414180398781574L;
	
	private String chnlCode; //渠道代码
	private String serialNo; //流水号
	private String randomNum; //随机数
	private String tellerNo; //柜员号
	private String workDate; //交易日期
	private String workTime; //交易时间
	
    public static class csis_purp {
    	
    }
    
    public static Map<String, Object> getMap(Purp purp) {
    	Map<String, Object> map = new HashMap<>();
    	map.put("chnlCode", purp.getChnlCode());
    	map.put("serialNo", purp.getSerialNo());
    	map.put("randomNum", purp.getRandomNum());
    	map.put("tellerNo", purp.getTellerNo());
    	map.put("workDate", purp.getWorkDate());
    	map.put("workTime", purp.getWorkTime());
    	return map;
    }
}
