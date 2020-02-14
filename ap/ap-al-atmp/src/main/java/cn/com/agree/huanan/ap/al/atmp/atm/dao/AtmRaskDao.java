package cn.com.agree.huanan.ap.al.atmp.atm.dao;

import java.util.List;
import java.util.Map;

/**
 * 本代本延时入账定时任务
 * @author superman
 *
 */
public interface AtmRaskDao {

	List<Map<String,Object>> delayedPaid();



	int updateRaskSerino(Map<String, Object> map);

}
