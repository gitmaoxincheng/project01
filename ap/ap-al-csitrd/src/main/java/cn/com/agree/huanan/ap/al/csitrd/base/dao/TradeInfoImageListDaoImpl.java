package cn.com.agree.huanan.ap.al.csitrd.base.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.base.po.TradeInfoImageList;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class TradeInfoImageListDaoImpl implements TradeInfoImageListDao{
	
	private static String TABLE_TRADEINFO_IMAGE_LIST = "tradeinfo_image_list";
	public final Logger logger = Logger.getLogger(TradeInfoImageListDaoImpl.class);
	@Autowired private DbOperator dbo;
	
	/**
	 * 登记到影像信息列表
	 * */
	public int insertTRADEINFO_IMAGE_LIST(TradeInfoImageList tradeInfoImageList) {
		int count = dbo.getInserter().insertInto(TABLE_TRADEINFO_IMAGE_LIST).values(TradeInfoImageList.getMap(tradeInfoImageList)).execute();
		return count;
	}
	
	/**
	 * 更新影像信息列表
	 * */
	public int updateTRADEINFO_IMAGE_LIST(Map<String, Object> paramMap) {
		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}
		
		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		
		int count = dbo.getUpdater().update(TABLE_TRADEINFO_IMAGE_LIST).where(w -> {
			w.eq("tradeDate", paramMap.get("tradeDate"));
			w.eq("serialNo", paramMap.get("serialNo"));
			w.eq("imageNum", paramMap.get("imageNum"));
		}).set(paramMap).execute();
		
		return count;
	}
}
