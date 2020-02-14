package cn.com.agree.huanan.ap.al.csitrd.dpst.dao;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.dpst.po.TraInfoDpst;
/**	
 * 
 * @author HZP
 *	存款业务登记簿Dao接口
 */
public interface TradeinfoDepositDao {
	//登记到存款业务登记簿
	public int insertTraInfoDpst(TraInfoDpst traInfoDpst);
	//更新到存款业务登记簿
	public int updateTraInfoDpst(Map<String, Object> paramMap);
//=======================以下接口废弃==========================================
//	//新增-定活互转-通知存款支取
//	public int insertNoticeMoneyWay(TraInfoDpst traInfoDpst);
//	//更新-定活互转-通知存款支取
//	public int updateNoticeMoneyWay(Map<String, Object> paramMap);
//	
//	//新增-定活互转-定期支取
//	public int insertRegularWay(TraInfoDpst traInfoDpst);
//	//更新-定活互转-定期支取
//	public int updateRegularWay(Map<String, Object> paramMap);
//	
//	//新增-大额存单预约购买
//	public int insertLargeAmount(TraInfoDpst traInfoDpst);
//	//更新-大额存单预约购买
//	public int updateLargeAmount(Map<String, Object> paramMap);
//	
//	//新增-大额存单支取
//	public int insertLargeAmountGet(TraInfoDpst traInfoDpst);
//	//更新-大额存单支取
//	public int updateLargeAmountGet(Map<String, Object> paramMap);
//	
//	//新增-结构性存款认购
//	public int insertStructMoney(TraInfoDpst traInfoDpst);
//	//更新-结构性存款认购
//	public int updateStructMoney(Map<String, Object> paramMap);
//	
//	//新增-定活莞家-资金存入
//	public int insertDhgjMoney(TraInfoDpst traInfoDpst);
//	//更新-定活莞家-资金存入
//	public int updateDhgjMoney(Map<String, Object> paramMap);
//	
//	//新增-定活莞家-资金支取
//	public int insertDhgjMoneyGet(TraInfoDpst traInfoDpst);
//	//更新-定活莞家-资金支取
//	public int updateDhgjMoneyGet(Map<String, Object> paramMap);
}
