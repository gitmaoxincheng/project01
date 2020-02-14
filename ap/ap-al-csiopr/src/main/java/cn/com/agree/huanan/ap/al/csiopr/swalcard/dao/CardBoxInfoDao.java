package cn.com.agree.huanan.ap.al.csiopr.swalcard.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.swalcard.po.CardBoxInfo;

public interface CardBoxInfoDao {
		
	/**
	 * 设备卡箱卡类型查询
	 * @param paramMap
	 * @return
	 * @author Maoxc
	 */
	public Map<String, Object> selectCardBoxInfo( Map<String, Object> paramMap);
	
	/**
	 * 查询id是否存在
	 * @param devid
	 * @param cardboxnum
	 * @return
	 */
	public CardBoxInfo selectCardBoxInfoById(String devid,String cardboxnum);
	
	/**
	 * 更新数据
	 * @param map
	 * @return
	 * @author Maoxc
	 */
	public int updateCardBoxInfo(Map<String, Object> map);
	
	/**
	 * 调出卡箱更新
	 * @param card
	 * @return
	 * @author jiangzf
	 */
	public int updateTakeCard(Map<String, Object> card);
	
}
