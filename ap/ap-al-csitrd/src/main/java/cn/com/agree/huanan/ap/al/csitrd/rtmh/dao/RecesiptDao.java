package cn.com.agree.huanan.ap.al.csitrd.rtmh.dao;




public interface RecesiptDao {

	/**
	 * 根据流水号代码查询订单信息
	 * @param serialno 回单流水
	 * @return 回单信息
	 */
	public String selectRecesipt(String serialNo);
	
}
