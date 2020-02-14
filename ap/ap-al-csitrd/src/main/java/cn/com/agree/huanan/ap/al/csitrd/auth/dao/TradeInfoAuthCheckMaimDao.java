package cn.com.agree.huanan.ap.al.csitrd.auth.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.auth.po.DutyInfo;
import cn.com.agree.huanan.ap.al.csitrd.auth.po.Entduty;
import cn.com.agree.huanan.ap.al.csitrd.auth.po.TradeInfoAuthCheckMaim;

public interface TradeInfoAuthCheckMaimDao {

	/**
	 * 更新信息    根据tradeDate和serialNo进行更新
	 * @param paramMap
	 * @return
	 */
	public int updateByDate(Map<String, Object> paramMap);
	
	/**
	 * 更新信息    根据Taskid 任务号进行更新
	 * @param paramMap
	 * @return
	 */
	public int updateByTaskid(Map<String, Object> paramMap);
	
   /**
 	 * 保存信息入库
 	 * @param tradeMessageInfo
 	 * @return
 	 */
     public int insertTradeInfoAuthCheckMaim(TradeInfoAuthCheckMaim tradeInfoAuthCheckMaim);
	
     /**
      * 根据柜员号和网点号查询实体岗位
      * */
     public Entduty queryEntdutyByCond(String tellerNo, String brno);
     
     /**
      * 根据所属岗位类型编号查询岗位类型表
      * */
     public DutyInfo queryByDutyNo(String dutyNo);
	
}
