package cn.com.agree.huanan.ap.al.csiopr.cardbin.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.cardbin.po.CardbinInfo;
import cn.com.agree.huanan.ap.al.csiopr.cardbin.po.CardbinOper;

public interface CardbinInfoDao {
	//根据cardbin获取卡bin信息
	public CardbinInfo FindCardbinInfoByCardbin(String cardbin) ;
	
	//获取卡bin信息列表
	public Map<String, Object> getCardbinInfoList(String pageFlag, String maxNum, String cardbin, String cardType, String bankCode,
			String bankName);
	
	//将审批表中的卡bin信息插入到卡bin表中
	public int insertCardbinInfo(CardbinInfo cardInfo);
	
	//将审批表中的卡bin信息更新到卡bin表中
	public int updateCardbinInfo(CardbinInfo cardInfo);

	//删除卡bin信息
	public int deleteCardbinInfo(String cardbin);

	//删除卡bin所有信息
	public int deleteCardbinInfoAll();

	//将批量导入信息插入卡bin表中
	public int insertAllDetailToCardbin(Map map);
	
	

}
