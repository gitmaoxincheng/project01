package cn.com.agree.huanan.ap.al.csitrd.base.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.base.po.TradeInfoImageList;

public interface TradeInfoImageListDao {

	/**
	 * 登记到影像信息列表
	 * */
	public int insertTRADEINFO_IMAGE_LIST(TradeInfoImageList tradeInfoImageList);
	
	/**
	 * 更新影像信息列表
	 * */
	public int updateTRADEINFO_IMAGE_LIST(Map<String, Object> paramMap);
}
