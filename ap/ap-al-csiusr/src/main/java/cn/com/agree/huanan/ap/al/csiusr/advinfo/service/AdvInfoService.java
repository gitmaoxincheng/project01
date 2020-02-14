package cn.com.agree.huanan.ap.al.csiusr.advinfo.service;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiusr.advinfo.dao.AdvInfoDaoImp;
import cn.com.agree.huanan.ap.al.csiusr.advinfo.exception.AdvInfoDataException;
import cn.com.agree.huanan.ap.al.csiusr.advinfo.po.AdvInfo;
import cn.com.agree.huanan.ap.al.csiusr.advinfo.po.DevAdv;
import cn.com.agree.huanan.ap.al.csiusr.advmod.po.AdvMod;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class AdvInfoService{
	@Autowired AdvInfoDaoImp advInfoDaoImp;
	@Autowired Logger logger;
	@Autowired DbOperator dbo;
	
	//增加数据
	public void addAdvInfo(AdvInfo advInfo) {     
		logger.info("--@Service增加数据advInfo--"+advInfo);
		int  count  = advInfoDaoImp.insertAdvInfo(advInfo);
		if (count != 1) {
			dbo.rollback();
			logger.error("增加数据失败");
			throw new AdvInfoDataException("增加数据失败");
		}
		
	}

	//更新字段
	public void changeAdvInfo(Map<String, Object> advMap) {
		int count = advInfoDaoImp.updateAdvInfo(advMap);
		if (count != 1) {
			dbo.rollback();
			logger.error("数据更新失败");
			throw new AdvInfoDataException("维护失败");
		}else {
			dbo.commit();
			logger.info("数据更新成功");
		}
	}
	
    //删除数据
	public void removeAdvInfo(String adid) {
		int count = advInfoDaoImp.deleteAdvInfo(adid);
		if (count != 1) {
			dbo.rollback();
			logger.error("数据删除失败");
			throw new AdvInfoDataException("数据删除失败");
		}else {
			dbo.commit();
			logger.info("数据删除成功");
		}	
	}
	
	 //查询数据
	public AdvInfo queryAdvInfo(String adId) {
		return advInfoDaoImp.selectAdvInfo(adId);
		
	}
	
	//数据全部插入成功后，提交数据
	public void Commit() {
		dbo.commit();
		logger.info("提交数据！");
	}
	
	public void rollBack() {
		dbo.rollback();
		logger.info("回滚数据！");
	}
	
	//增加数据,广告发布表
	public void addDevAdv(DevAdv devAdv) {
		int  count  = advInfoDaoImp.insertDevAdv(devAdv);
		if (count != 1) {	
			dbo.rollback();
			logger.error("添加失败");
			throw new AdvInfoDataException("添加失败");
		}
	}

	public DevAdv queryDevAdv(String devId, String adTempId) {
		return advInfoDaoImp.selectDevAdv(devId, adTempId);
	}
	
	
    //删除数据,广告发布表
    public void removeDevAdv(String devid) {
		advInfoDaoImp.deleteDevAdv(devid);
		
	}
    
    //根据设备id查询广告jsonName
	public String getDevAdvJsonNameByDevid(String devid) {
		 DevAdv devAdv=advInfoDaoImp.getDevAdvByDevid(devid);
		 if(devAdv==null)
			 return null;
		 else
			 return devAdv.getJsonString();
	}

	// 根据adid查询 广告模板表
	public AdvMod queryAdvmodByAdid(String adid) {
		return advInfoDaoImp.selectAdvmodByAdid(adid);	
		
	}
	
	// 根据adid查询 广告模板表
	public AdvMod queryAdvmodByAdtempid(String adtempid) {
		return advInfoDaoImp.selectAdvmodByAdtempid(adtempid);	
	}

	
}
