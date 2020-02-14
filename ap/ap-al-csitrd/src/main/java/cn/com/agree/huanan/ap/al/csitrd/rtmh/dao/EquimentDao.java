package cn.com.agree.huanan.ap.al.csitrd.rtmh.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.rtmh.po.RtmhModelInfo;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

public interface EquimentDao {


	public Map<String,Object> selectModelInfo(int pageFlag,int pageSize,String modelid,String modelstatus);
	
	
	/**
	 * 获取设备信息
	 */
	public RtmhModelInfo queryModelInfo(String modelid,String modelstatus);
	
}
