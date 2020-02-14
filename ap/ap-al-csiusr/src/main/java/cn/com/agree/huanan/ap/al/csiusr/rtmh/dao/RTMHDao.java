package cn.com.agree.huanan.ap.al.csiusr.rtmh.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.rtmh.po.RTMHTradInfo;

/**
 * 回单机其他P交易流水表Dao层
 * @author bodadmin
 *
 */
public interface RTMHDao {
	
/**
 * 登记其他P交易流水表
 * @param rtmhMap
 * @return
 */
public int 	insertRTMH(Map<String, Object> rtmhMap);
/**
 * 通过交易日期和交易流水查询交易表记录
 * @param tradeDate
 * @param serialNo
 * @return
 */
public RTMHTradInfo query(String tradeDate,String serialNo);


/**
 * 根据交易日期和交易流水更新交易记录
 * @param tradeDate
 * @param serialNo
 * @param rtmhTrad
 * @return
 */
public int updateTtmhTrad(String tradeDate,String serialNo,Map<String, Object> rtmhTrad);
	


/**
 * 更新数据
 * @param paramMap
 * @return
 */
public int updateTradinfo(Map<String, Object> paramMap);


/**
 * 根据用户编号查询用户
 * userCode 用户编号
 * userno 
 */
	public List<RTMHTradInfo> queryListUserByNo(String userCode, String userno);


}
