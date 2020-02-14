package cn.com.agree.huanan.ap.al.csiusr.advmod.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiusr.advinfo.dao.AdvInfoDao;
import cn.com.agree.huanan.ap.al.csiusr.advinfo.po.DevAdv;
import cn.com.agree.huanan.ap.al.csiusr.advmod.dao.AdvModDao;
import cn.com.agree.huanan.ap.al.csiusr.advmod.po.AdvMod;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApDataExistException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApSelectNotFoundException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApUpdateFailException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

@Service
public class AdvModService {
	@Autowired AdvModDao advModDao;
	@Autowired AdvInfoDao advInfoDao ;
	@Autowired Logger logger;
	@Autowired DbOperator dbo;
	
	
	/**
	 * 广告模板新增
	 * @param adtempid           //广告模板编号
	 * @param listnm             //总笔数
	 * @param advt_list           //广告信息列表
	 * @param tempdesc           //广告模板描述
	 */
	public void addAdvMod(String adtempid, String tempname,String listnm, List<Map<String, String>> advt_list, String tempdesc) {
	
		AdvMod advMod = new AdvMod();
		advMod.setAdtempid(adtempid);
		advMod.setTempname(tempname);
		advMod.setTempdesc(tempdesc);
		advMod.setUpddate(DateTimeUtil.getSysDate());
		advMod.setUpdtime(DateTimeUtil.getSysTime());
		for(Map<String , String> map : advt_list) {
			String type = map.get("type");
			String adid = map.get("adid");
			advMod.setType(type);
			advMod.setAdid(adid);
			
			//查询新增信息是否已经存在
			AdvMod am = advModDao.findAdvMod(adtempid,type,adid);
			if (am != null) {
				dbo.rollback();
				logger.error("广告模板表中已存在广告模板编号为:%s,类别为:%s,广告编号为:%s的信息,无法新增",adtempid,type,adid);
				throw new ApDataExistException("广告模板表中已存在该广告模板信息,无法新增");
			}
			
			int count = advModDao.addAdvMod(advMod);
			if(count != 1) {
				dbo.rollback();
				logger.error("广告模板表新增信息失败");
				throw new ApUpdateFailException("广告模板表新增信息失败");
			}
		}
		dbo.commit();
	}


	/**
	 * 广告模板修改
	 * @param adtempid        //广告模板编号    
	 * @param tempname        //广告模板名称       
	 * @param tempdesc        //广告模板描述    
	 * @param advt_list       //广告信息列表    
	 */
	public void updateAdvMod(String adtempid, String tempname, String tempdesc, List<Map<String, String>> advt_list) {
		
		
		List<AdvMod> advMod = advModDao.findAdvModByAdtempId(adtempid);
		if (advMod == null || advMod.size() == 0) {
			logger.debug("广告模板表中没有该广告模板编号:%s的信息存在,无法修改",adtempid);
			throw new ApSelectNotFoundException("广告模板表中没有该广告模板信息存在,无法修改");
		}
		//通过先删除再新增完成修改操作
		logger.info("广告模板表删除开始");
		advModDao.deleteAdvMod(adtempid);
		logger.info("广告模板表新增开始");
		AdvMod advModTemp = new AdvMod();
		advModTemp.setAdtempid(adtempid);
		advModTemp.setTempname(tempname);
		advModTemp.setTempdesc(tempdesc);
		advModTemp.setUpddate(DateTimeUtil.getSysDate());
		advModTemp.setUpdtime(DateTimeUtil.getSysTime());
		
		for(Map<String , String> map : advt_list) {
			String type = map.get("type");
			String adid = map.get("adid");
			advModTemp.setType(type);
			advModTemp.setAdid(adid);
			
			//查询新增信息是否已经存在
			AdvMod am = advModDao.findAdvMod(adtempid,type,adid);
			if (am != null) {
				dbo.rollback();
				logger.error("修改异常：不能修改为相同的信息");
				throw new ApUpdateFailException("修改异常：不能修改为相同的信息");
			}
				
			int count = advModDao.addAdvMod(advModTemp);
			if(count != 1) {
				dbo.rollback();
				logger.error("广告模板表修改信息失败");
				throw new ApUpdateFailException("广告模板表修改信息失败");
			}
		}
		dbo.commit();
	}

	/**
	 * 广告模板删除
	 * @param adtempid  广告模板编号  
	 */
	public void delectAdvMod(String adtempid) {
		List<AdvMod> advMod = advModDao.findAdvModByAdtempId(adtempid);
		if (advMod == null || advMod.size() == 0) {
			logger.error("广告模板表中没有该广告模板编号:%s的信息存在,无法删除",adtempid);
			throw new ApSelectNotFoundException("广告模板表中没有该广告模板编号信息存在,无法删除");
		}
		
		//判断广告发布表中是否有该广告模板编号的数据
		DevAdv devAdv = advInfoDao.queryAdvByAdtempid(adtempid);
		if(devAdv != null) {
			logger.error("广告发布表中存在该广告模板编号的信息，无法删除");
			throw new ApDataExistException("广告发布表中存在该广告模板编号的信息，无法删除");
		}
		
		int count = advModDao.deleteAdvMod(adtempid);
		if(count < advMod.size()) {
			dbo.rollback();
			logger.error("广告模板表删除信息失败");
			throw new ApUpdateFailException("广告模板表删除信息失败");
		}
		dbo.commit();
	}





	
	
	

}
