package cn.com.agree.huanan.ap.al.csiopr.keep.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.keep.po.KeepFlow;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

public interface KeepFlowDao {
	
	/**
	 * 登记代保管物品交接流水表
	 * */
	public int insertKeepFlow(KeepFlow keepFlow);
	
	/**
	 * 查询保管物品交接流水表
	 * */
	public IPage<Map<String, Object>> getKeepFlowList(String pageflag, String maxnum, String keepno);

	
}
