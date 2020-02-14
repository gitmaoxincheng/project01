package cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.server;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.dao.DutyinfoDao;
import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.po.DutyInfo;
import cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.dao.ExitCtrlDtsyDao;
import cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.exception.DataIsExistException;
import cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.exception.DataIsNotExistException;
import cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.exception.DtsyDutyIsNotException;
import cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.exception.ExitCtrlDtsyException;
import cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.exception.NotDeleteException;
import cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.exception.NotInsertException;
import cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.exception.NotUpdateException;
import cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.exception.StatusIsNotException;
import cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.po.ExitCtrlDtsy;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

@Service
public class ExitCtrlDtsyService {
	@Autowired ExitCtrlDtsyDao exitCtrlDtsyDao;
	@Autowired DutyinfoDao dutyinfoDao;
	@Autowired Logger logger;
	@Autowired DbOperator dbo;
	
	//多表查询
	public Map<String, Object> queryExitBrnoInfo(int pageFlag, int pageSize,String dutyno, String myBank) {
		if (pageSize < 1 || pageFlag < 1) {
			throw new ApIllegalParamException("maxNum/pageFlag 要大于 1");
		}
		
		Map<String, Object> map = exitCtrlDtsyDao.selectExitCtrlDtsy(pageFlag, pageSize, dutyno, myBank);
		return map;	
	}
	
	//增加	
    public void addExitBrnoInfo(String strdutyno,String strsysid) {	
    	String tradeDate = DateTimeUtil.getSysDate();
    	String tradeTime = DateTimeUtil.getSysTime();
		logger.info("----------岗位类型编号是否存在----------");
    	DutyInfo dutyInfo = dutyinfoDao.queryByDutyNo(strdutyno);
    	if(null == dutyInfo) {
    		throw new DataIsNotExistException();
    	}

		logger.info("----------岗位是否为特殊操作柜员应用岗----------");
    	if("1".equals(dutyInfo.getSpecialFlg())) {
    		throw new ExitCtrlDtsyException("岗位为特殊操作柜员应用岗，无需设置岗位签退受控系统");
    	}
    	
		logger.info("----------是否已存在受控系统记录----------");
    	ExitCtrlDtsy exitCtrlDtsy = exitCtrlDtsyDao.selectExitCtrlDtsy(strdutyno);   	
    	if(null != exitCtrlDtsy && "1".equals(exitCtrlDtsy.getStatus())) {
    		throw new DataIsExistException();
    	}
    	
    	if (null != exitCtrlDtsy && "0".equals(exitCtrlDtsy.getStatus())) {
    		Map<String, Object> paramMap = new HashMap<>();
        	paramMap.put("sysidbuf", strsysid);
        	paramMap.put("status", "1");
        	paramMap.put("upddate", tradeDate);
        	paramMap.put("updtime", tradeTime);
    		int count = exitCtrlDtsyDao.updateExitCtrlDtsy(strdutyno, paramMap);
        	if(1 != count) {
             	dbo.rollback();
             	throw new NotUpdateException();
            }
		} else {
	    	ExitCtrlDtsy exit = new ExitCtrlDtsy();
	    	exit.setDutyNo(strdutyno);
	    	exit.setSysIdBuf(strsysid);
	    	exit.setStatus("1");
	    	exit.setUpddate(tradeDate);
	    	exit.setUpdtime(tradeTime);
	    	int count = exitCtrlDtsyDao.insertExitCtrlDtsy(exit);
	    	if(count != 1) {
	            dbo.rollback();
	            throw new NotInsertException();
	        }
		}
    	dbo.commit();
    }
    
    //修改
    public void changeExitBrnoInfo(String strdutyno, String strsysid) {
    	
		logger.info("----------签退受控表是否存在该岗位类型编号----------");
    	ExitCtrlDtsy exitCtrlDtsy = exitCtrlDtsyDao.selectExitCtrlDtsy(strdutyno);   	
    	if(null == exitCtrlDtsy) {
    		throw new DtsyDutyIsNotException();
    	}
    	
    	//查询系统受控状态    	
		logger.info("----------岗位类型信息是否为失效状态----------");	
    	if("0".equals(exitCtrlDtsy.getStatus())) {
    		throw new ExitCtrlDtsyException("修改失败，岗位类型信息为失效状态");
    	}
    	Map<String, Object> paramMap = new HashMap<>();
    	paramMap.put("sysidbuf", strsysid);
    	paramMap.put("upddate", DateTimeUtil.getSysDate());
    	paramMap.put("updtime", DateTimeUtil.getSysTime());
    	int count = exitCtrlDtsyDao.updateExitCtrlDtsy(strdutyno, paramMap);
    	if(1 != count) {
         	dbo.rollback();
         	throw new NotUpdateException();
        }
    	dbo.commit();
    }
    
    //假删除（修改）
    public void decExitBrnoInfo(String strdutyno) {

		logger.info("----------签退受控表是否存在该岗位类型编号----------");
    	ExitCtrlDtsy exitCtrlDtsy = exitCtrlDtsyDao.selectExitCtrlDtsy(strdutyno);   	
    	if(exitCtrlDtsy == null) {
    		throw new DtsyDutyIsNotException();
    	}
    	
    	logger.info("----------岗位类型信息是否为失效状态----------");
    	if("0".equals(exitCtrlDtsy.getStatus())) {
    		throw new StatusIsNotException("删除失败，岗位类型信息为失效状态");
    	}
    	//修改状态
    	Map<String, Object> paramMap = new HashMap<>();
    	paramMap.put("dutyno", strdutyno);
    	paramMap.put("status", "0");
    	paramMap.put("upddate", DateTimeUtil.getSysDate());
    	paramMap.put("updtime", DateTimeUtil.getSysTime());
    	int count = exitCtrlDtsyDao.updateExitCtrlDtsy(strdutyno, paramMap);
    	if(count != 1) {
         	dbo.rollback();
         	throw new NotDeleteException();
        }
    	dbo.commit();
    }
	
	
	
}
