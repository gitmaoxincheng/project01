package cn.com.agree.huanan.ap.al.csitrd.voch.dao;

import java.util.Map;

public interface CheckManageDao {
	Map<String,Object> checkReceQuery(String tradedate,String devno,String brno);
	Map<String,Object> checkDetailQuery(Integer pageflag,Integer maxnum,String startdate, String enddate,String busitype,String devno,String status,String brno);
	Map<String,Object> checkSoldQuery(Integer pageflag,Integer maxnum,String startdate, String enddate,String devno,String status,String brno);
}
