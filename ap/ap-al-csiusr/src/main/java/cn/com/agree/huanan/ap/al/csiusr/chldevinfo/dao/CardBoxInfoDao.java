package cn.com.agree.huanan.ap.al.csiusr.chldevinfo.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po.CardBoxInfo;

public interface CardBoxInfoDao {
		
	/**
	 * 设备卡箱卡类型查询
	 * @param paramMap
	 * @return
	 * @author Maoxc
	 */
	public Map<String, Object> selectCardBoxInfo( Map<String, Object> paramMap);
	
	
	
	/**
	 * 插入数据
	 * @param map
	 * @return
	 * @author Maoxc
	 */
	public int insertCardBoxInfo(CardBoxInfo cardBoxInfo);	
	

   
   /**
    * 删除数据
    * @param map
    * @return
    */
   public int deleteCardBoxInfo(Map<String, Object> map);
   
   /**
	 * 卡箱库存修改
	 * @param card
	 * @param optype
	 * @return
	 * @author chenzhipeng
	 */
	public int updateTakeCard(Map<String, Object> card, String optype);
	
	/**
	 * 查询卡箱总数
	 * @param card
	 * @return
	 * @author chenzhipeng
	 */
	public Map<String, Object> selectTakeCard(Map<String, Object> card);
   	
	
}
