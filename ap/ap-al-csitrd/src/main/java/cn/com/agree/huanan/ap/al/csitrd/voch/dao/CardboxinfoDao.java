package cn.com.agree.huanan.ap.al.csitrd.voch.dao;

import java.util.Map;

public interface CardboxinfoDao {
	/**
	 * 更新数据
	 * @param paramMap
	 * @return
	 */
	public int updateCardboxinfo(String devid,String cardboxnum,String totnum,String strtnum,String endnum);
}
