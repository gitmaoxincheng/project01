package cn.com.agree.huanan.ap.al.csitrd.rever.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.rever.po.Rever;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
/**
 * 统一冲正登记簿 实现类
 * @author ZengS
 *
 */
@Component
public class ReverDaoImpl implements ReverDao {
	private static String TABLE = "TRADEINFO_REVER_MAIN";
	public final Logger logger = Logger.getLogger(ReverDaoImpl.class);
	@Autowired
	DbOperator dbo;
	
	// 插入数据
	@Override
	public int insertReverMain(Rever rever) {
		int count = dbo.getInserter().insertInto(TABLE).values(Rever.getMap(rever)).execute();
		return count;
	}
	
	// 更新数据
	@Override
	public int updateReverMain(Map<String, Object> paramMap) {
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
