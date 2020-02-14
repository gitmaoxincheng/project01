package cn.com.agree.huanan.ap.al.csitrd.base.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.base.po.Drowboard;

public interface DrowBoardDao {
	Map<String,Object> findDrowBoard(String strtellerno,String begdate,String enddate,Integer pageflag,Integer maxnum);
	int delDrowBoard(String imagepath);
	int insertDrowBoard(Drowboard drowboard);
}
