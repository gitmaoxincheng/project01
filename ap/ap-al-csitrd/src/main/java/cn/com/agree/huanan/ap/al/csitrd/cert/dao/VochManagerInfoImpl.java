package cn.com.agree.huanan.ap.al.csitrd.cert.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.csitrd.cert.po.VochManagerInfo;
import cn.com.agree.huanan.ap.al.csitrd.fina.dao.TradfinamainDaoImpl;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
/**
 * 凭证管理信息明细 实现类
 * @author Zengs
 *
 */
@Component
public class VochManagerInfoImpl implements VochManagerInfoDao {
	public final Logger logger = Logger.getLogger(TradfinamainDaoImpl.class);
	
	private static String TABLE = "TRADEINFO_CERT_DETAIL";
	@Autowired DbOperator dbOperator;
	
	@Override
	public int insertVochManagerInfoDap(VochManagerInfo vochManagerInfo) {
		int count = dbOperator.getInserter().insertInto(TABLE).values(VochManagerInfo.getMap(vochManagerInfo)).execute();
		return count;
	}

	@Override
	public int updateTVochManagerInfoDap(Map<String, Object> paramMap) {
		int count = dbOperator.getUpdater().update(TABLE).where(w->{
			w.eq("SERIALNO", paramMap.get("serialNo"));
			w.eq("TRADEDATE", paramMap.get("tradeDate"));
		}).set(paramMap).execute();
		return count;
	}

	@Override
	public List<Map<String, Object>> selectVochDetials(String tradedate, String serialno) {
		logger.info("柜员尾箱凭证明细查询sql语句开始");

		
		// 查询返回结果
		Selecter selecter = dbOperator.getSelecter();
		List<Map<String, Object>> mapList = selecter.select("certtype", "parval", "brcode", "certunit", "totnum",
				"strtnum", "endnum", "certnum").from(TABLE).where(w -> {

					w.eq("tradedate", tradedate);
					w.eq("serialNo", serialno);
					
				}).orderBy("tradedate").fetchAll();
		if(mapList.size()==0) {
			throw new ApIllegalParamException("查询无对应记录");
		}
		
		logger.info("柜员尾箱凭证明细查询sql语句结束");
		return mapList;
	}

}
