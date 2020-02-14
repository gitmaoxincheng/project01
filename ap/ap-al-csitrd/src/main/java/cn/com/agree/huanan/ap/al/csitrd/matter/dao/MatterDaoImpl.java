package cn.com.agree.huanan.ap.al.csitrd.matter.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.al.csitrd.matter.po.Matter;

/**
 * 
 * @author Maoxc
 *	事故事项操作Dao实现类
 */
@Component
public class MatterDaoImpl implements MatterDao{
	private static String TABLE = "tradeinfo_matter_main";
	public final Logger logger = Logger.getLogger(MatterDaoImpl.class);
	@Autowired
	DbOperator dbo;
	
	//插入数据
	@Override
	public int insertMatter(Matter matter) {
		int count = dbo.getInserter().insertInto(TABLE).values(Matter.getMap(matter)).execute();
		return count;
	}
	
	//更新数据
	@Override
	public int updateMatter(Map<String, Object> paramMap) {
		// 校验参数
		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}else if(null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		// 更新数据
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("tradeDate", paramMap.get("tradeDate"));
			w.eq("serialNo", paramMap.get("serialNo"));
		}).set(paramMap).execute();
		return count;
	}
	

	
}
