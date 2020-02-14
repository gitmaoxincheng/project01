package cn.com.agree.huanan.ap.al.csitrd.mide.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.mide.po.IntermediateMain;

public interface TuitionPaymentDao {
	/**
	 * 保存信息入库
	 * */
	public int insertIntermediateMain(IntermediateMain intermediateMain);

	/**
	 * 更新信息入库
	 * */
	public int updateIntermediateMain(Map<String,Object> paramMap);
	
	
}
