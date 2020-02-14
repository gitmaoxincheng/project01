package cn.com.agree.huanan.ap.al.csitrd.fina.dao;

import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradfinamain;

/**
 * 标准的理财保险业务登记簿数据接入层
 * @author bodadmin
 */
public interface BaseTradfinamainDao {
	
	/**
	 * 插入一条记录
	 * @param tFina
	 * @return
	 */
	public int stdInsertTradfinamain(Tradfinamain tFina);
	
	/**
	 * 更新一条记录
	 * @return
	 */
	public int stdUpdataTradfinamain(Tradfinamain tFina);
}
