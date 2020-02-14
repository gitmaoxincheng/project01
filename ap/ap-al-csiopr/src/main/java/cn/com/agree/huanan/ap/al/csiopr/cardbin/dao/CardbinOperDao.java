package cn.com.agree.huanan.ap.al.csiopr.cardbin.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.cardbin.po.CardbinDetail;
import cn.com.agree.huanan.ap.al.csiopr.cardbin.po.CardbinOper;

public interface CardbinOperDao {
	
	//根据cardbin和审批状态获取卡bin审批信息
	public  CardbinOper FindCardbinOperByCardbin(String cardbin, String audStatus) ;
	//插入卡bin信息到审批表中
	public int insertCardbinToOper(CardbinOper card);
	//查询获取卡bin变更审批信息列表
	public Map<String, Object> getCardbinOperList(String pageFlag, String maxNum, String cardbin, String beginDate, String endDate,
			String optType, String bankCode, String audStatus);
	//根据流水号获取卡bin审批信息
	public CardbinOper getCardbinOperStatus(String seriNo);
	//更新卡bin审批表中的信息
	public int doUpdateCardbinOper(CardbinOper cardbinOper);
	//查询获取卡bin批量导入信息列表
	public Map<String, Object> getCardbinMulOperList(String pageFlag, String maxNum, String cardbin, String beginDate,
			String endDate, String audStatus);
	
	//查询卡bin批量导入明细信息
	public Map<String, Object> findCardMulDetailInfo(String pageflag, String maxNum, String audSeriNo);
	
	//根据流水号获取审批表中的信息
	public CardbinOper getCardbinOperInfo(String serino);
	
	//获取卡bin明细信息
	public List<Map<String, Object>> getCardbinDetailList(String serino);

}
