package cn.com.agree.huanan.ap.al.csiopr.keeppara.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.keeppara.po.KeepPara;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

public interface KeepParaDao {

	/**
	 * 查询最大的代保管品种类编号
	 * */
	public String getMaxKeepTypeNo();


	/**
	 * 插入代保管物品参数记录
	 * 
	 * */
	public int insertKeepPara(KeepPara keepPara);

	/**
	 * 根据原代保管品种类编号修改代保管物品参数记录
	 * 
	 * */
	public int modifyKeepPara(KeepPara keepPara,String oldkeeptypeno);
	
	/**
	 * 根据原代保管品种类编号查找代保管物品参数记录
	 * 
	 * */
	public KeepPara queryKeepParaByKeeptypeno(String keeptypeno);
	
	/**
	 * 根据原代保管品种类编号删除代保管物品参数记录
	 * 
	 * */
	public int deleteKeepParaByKeepTypeNo(String keeptypeno);


	public IPage<Map<String, Object>> getKeepParaList(int pageflag, int maxnum, String keeptypeno, String keeptype,
			String recorddate ,String myBank);
	


}
