package cn.com.agree.huanan.ap.al.csitrd.cert.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.cert.po.VochManagerInfo;

/**
 * 凭证管理信息明细 dao
 * @author Zengs
 *
 */
public interface VochManagerInfoDao {
	
	/**
	 * 插入凭证管理信息明细数据
	 * @param vochManagerInfo 凭证管理信息明细bean
	 * @return 操作状态
	 */
	int insertVochManagerInfoDap(VochManagerInfo vochManagerInfo);

	/**
	 * 更新凭证管理信息明细数据
	 * @param paramMap 核心返回值map
	 * @return 操作状态
	 */
	int updateTVochManagerInfoDap(Map<String, Object> paramMap);
	
	/**
	 * 柜员尾箱凭证明细查询
	 * @param tradedate 平台交易日期
	 * @param serialno  平台交易流水
	 * @return 查询结果
	 */
	List<Map<String,Object>> selectVochDetials(String tradedate,String serialno);
}
