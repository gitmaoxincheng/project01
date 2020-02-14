package cn.com.agree.huanan.ap.al.csiopr.keep.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.keep.po.Keep;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

public interface KeepDao {
	
	/**
	 * 获取代保管编号
	 * */
	public String getKeepNo(String keepDate);

	public int insertKeep(Keep keep);

	public Keep queryKeepByKeepNo(String keepNo);

	public int updateKeep(Keep keep);

	public IPage<Map<String, Object>> getKeepParaList(Integer pageflag, Integer maxnum, String keepno, String keeptype,
			String keepname, String strstatus, String begkeepdate, String endkeepdate, String strbrno);
	
	public String queryTypeofBranch(String brno);
	
	public String queryBrnoFromSysPara();
	
	public List<Keep> queryKeepByKeepType(String keeptype);
	
	public int updateKeepTlrNoByKeepNo(String keepNo,String keeptlrno);

}
