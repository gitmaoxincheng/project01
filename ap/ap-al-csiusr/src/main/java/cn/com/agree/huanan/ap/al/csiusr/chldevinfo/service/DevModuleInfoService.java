package cn.com.agree.huanan.ap.al.csiusr.chldevinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.dao.DevMoudleInfoDao;
import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po.DevModuleInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApDataExistException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApDeleteFailException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApInsertFailException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApSelectNotFoundException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApUpdateFailException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

@Service 
public class DevModuleInfoService {
	@Autowired DevMoudleInfoDao dmiDao;
	@Autowired Logger logger;
	@Autowired DbOperator dbo;
	
	
	/**
	 * 
	 * @param optype 操作类型
	 * @param devmodulenum 设备模块id
	 * @param devmodulename 设备模块名称
	 * @param devmodulestapath 设备状态映射
	 */
	public void stmMoudleManage(String optype, String devmodulenum, String devmodulename, String devmodulestapath) {
		
		//判断操作类型:0-新增,1-修改,2-删除
		switch (optype) {
		case "0":
			DevModuleInfo dmi0 = dmiDao.queryModuleinfoByID(devmodulenum);
			if(dmi0 != null) {
				logger.error("该设备模块id已存在，无法新增");
				throw new ApDataExistException("devmodulenum");
			}
			DevModuleInfo devModule0 = new DevModuleInfo();
			devModule0.setDevmodulenum(devmodulenum);
			devModule0.setDevmodulename(devmodulename);
			devModule0.setDevmodulestapath(devmodulestapath);
			devModule0.setUpddate(DateTimeUtil.getSysDate());
			devModule0.setUpdtime(DateTimeUtil.getSysTime());
			
			int count0 = dmiDao.addModuleinfo(devModule0);
			if(count0 != 1) {
				logger.error("设备模块信息新增失败");
				throw new ApInsertFailException("设备模块信息");
			}
			break;
		case "1":
			DevModuleInfo dmi1 = dmiDao.queryModuleinfoByID(devmodulenum);
			if(dmi1 == null) {
				logger.error("该设备模块id不存在，无法修改");
				throw new ApSelectNotFoundException("devmodulenum");
			}
			DevModuleInfo devModule1 = new DevModuleInfo();
			devModule1.setDevmodulenum(devmodulenum);
			devModule1.setDevmodulename(devmodulename);
			devModule1.setDevmodulestapath(devmodulestapath);
			devModule1.setUpddate(DateTimeUtil.getSysDate());
			devModule1.setUpdtime(DateTimeUtil.getSysTime());
			
			int count1 = dmiDao.updataModuleinfo(devModule1);
			if(count1 != 1) {
				logger.error("设备模块信息修改失败");
				throw new ApUpdateFailException("设备模块信息");
			}
			break;
		case "2":
			DevModuleInfo dmi2 = dmiDao.queryModuleinfoByID(devmodulenum);
			if(dmi2 == null) {
				logger.error("该设备模块id不存在，无法删除");
				throw new ApSelectNotFoundException("devmodulenum");
			}
			
			int count2 = dmiDao.deleteModuleinfo(devmodulenum);
			if(count2 != 1) {
				logger.error("设备模块信息删除失败");
				throw new ApDeleteFailException("设备模块信息");
			}
			break;
		default:
			logger.error("操作类型错误");
			throw new ApIllegalParamException("optype");
		}

	}

}
