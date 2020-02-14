package cn.com.agree.huanan.ap.al.csicop.mbs.cardinfo.dao;

import java.util.List;
import java.util.Map;

/**
 * 卡信息表dao
 * 
 * @author guyulong
 *
 */
public interface MbsCardInfoDao {
	/**
	 * 卡产品信息查询
	 * 
	 * @param product_type
	 *            分类标识
	 * @param findDate
	 *            查询日期
	 * @return
	 */
	List<Map<String, Object>> findCardInformations(String product_type, String findDate);

	/**
	 * 卡产品信息总数查询
	 * 
	 * @param product_type
	 *            分类标识
	 * @param findDate
	 *            查询日期
	 * @return
	 */
	int findCardInformationsCount(String product_type, String findDate);
}
