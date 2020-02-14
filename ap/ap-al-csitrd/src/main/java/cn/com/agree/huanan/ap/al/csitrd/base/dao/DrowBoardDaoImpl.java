package cn.com.agree.huanan.ap.al.csitrd.base.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import cn.com.agree.huanan.ap.al.csitrd.base.po.Drowboard;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.logging.Logger;
/**
 * 画板文件查询dao实现类
 * @author lanshaojun
 *
 */
@Component
public class DrowBoardDaoImpl implements DrowBoardDao {
	private static String TABLE = "TRADEINFO_DROW_BOARD";
	@Autowired DbOperator dbOperator;
	
	public final Logger logger = Logger.getLogger(DrowBoardDaoImpl.class);

	@Override
	public Map<String, Object> findDrowBoard(String strtellerno, String begdate, String enddate, Integer pageflag,
			Integer maxnum) {
		logger.info("画板文件查询sql语句开始");
		Map<String,Object> result=new HashMap<String,Object>();
		// 查询总记录数
				long rowcnt = dbOperator.getSelecter().from(TABLE).where(w -> {
					// 查询条件
					if (!StringUtils.isEmpty(strtellerno) && !"".equals(strtellerno)) {
						w.eq("TELLERNO", strtellerno);
					}
					w.between("createdate", begdate,enddate);
				}).count();
		// 查询返回记录
		Selecter selecter = dbOperator.getSelecter();
		List<Map<String, Object>> mapList = selecter.select("createdate","imagepath","rmarks","tellerno strtellerno","brno strbrno","createtime")
				.from(TABLE).where(w -> {
			if (!StringUtils.isEmpty(strtellerno) && !"".equals(strtellerno)) {
				w.eq("TELLERNO", strtellerno);
			}
			w.between("createdate", begdate,enddate);
			
		}).orderBy("createdate").fetch((pageflag-1)*maxnum, maxnum);
		result.put("image_list", mapList);
		result.put("rowcnt", rowcnt);
		// 返回记录数
		result.put("listnm", rowcnt<=maxnum ? rowcnt:maxnum);
		
		logger.info("画板文件查询sql语句结束");
		return result;
	}

	@Override
	public int delDrowBoard(String imagepath) {
		// TODO 自动生成的方法存根
		logger.info("画板文件刪除sql语句开始");
		int count = dbOperator.getDeleter().deleteFrom(TABLE).where(w -> {
			w.eq("imagepath", imagepath);
		}).execute();
		logger.info("画板文件刪除sql语句结束");
		return count;
	}

	@Override
	public int insertDrowBoard(Drowboard drowboard) {
		// TODO 自动生成的方法存根
		logger.info("画板文件新增sql语句开始");
		int count = dbOperator.getInserter().insertInto(TABLE).values(Drowboard.getMap(drowboard)).execute();
		logger.info("画板文件新增sql语句结束");
		return count;
	}
}
