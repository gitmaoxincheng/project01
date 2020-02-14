package cn.com.agree.huanan.ap.al.csiusr.chldevinfo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.branch.dao.BranchDao;
import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.dao.DevInfoDao;
import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.exception.CheckNotDataException;
import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.exception.DevInfoAddFailException;
import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.exception.SelectDataException;
import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po.DevInfo;
import cn.com.agree.huanan.ap.al.csiusr.staffinfo.dao.StaffInfoDao;
import cn.com.agree.huanan.ap.al.csiusr.staffinfo.po.StaffInfo;
import cn.com.agree.huanan.ap.al.csiusr.teller.dao.TellerDao;
import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerInfo;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

@Service
public class DevInfoService{
	@Autowired DevInfoDao devInfoDao;
	@Autowired TellerDao tellerDao;
	@Autowired Logger logger;
	@Autowired DbOperator dbo;
	@Autowired BranchDao branchDao;
	@Autowired StaffInfoDao staffInfoDao;
	
	/**
	 * 特殊自助设备查询
	 * @param pageFlag
	 * @param pageSize
	 * @param status
	 * @param dev
	 * @param devtellerno
	 * @param devip
	 * @param admbrno
	 * @param dstbrno
	 * @param cshboxflg
	 * @param vchboxflg
	 * @param areacode
	 * @param offlineflg
	 * @param admtellerno
	 * @param telephone
	 * @return
	 */
	public Map<String, Object> queryDevInfo(int pageFlag, int pageSize, String devtype, String devno, String status,
	String devtellerno, String admbrno, String dstbrno, String applyid, String myBank) {	
		//查询
        IPage<Map<String,Object>> pageInfo = devInfoDao.selectDevInfo(pageFlag, pageSize, devtype, devno, status,devtellerno, admbrno, dstbrno,myBank);
        Map<String, Object> result = new HashMap<>();
		result.put("rowcnt", pageInfo.getTotal());// 总笔数
		result.put("listnm", pageInfo.getSize());// 返回记录数
		result.put("dev_list", pageInfo.getRecords());// 返回数据		
		//根据APPlyId 查询
		if (!StringUtils.isEmpty(applyid)) {
			DevInfo devInfo = devInfoDao.queryDevInfo(applyid);
			if(devInfo == null) {
				logger.info("设备标识不存在！！");
				throw new SelectDataException("设备标识不存在！！");
			}
			result.put("admbrno", devInfo.getAdmBrno());
			result.put("brname", devInfo.getBrName());
			result.put("devno", devInfo.getDevNo());
			result.put("devtellerno", devInfo.getDevTellerNo());
			result.put("applyid", devInfo.getApplyId());
			result.put("devtypeno", devInfo.getDevTypeNo());
			result.put("admtellerno", devInfo.getDevTellerNo());
			result.put("devtype", devInfo.getDevType());
			result.put("termtp", devInfo.getTerMtp());
			result.put("authcode", devInfo.getAuthCode());
			result.put("devip", devInfo.getDevIp());
			result.put("status", devInfo.getStatus());
		}
		//返回数据
		return result;		
	}
	
	/**
	 * 自助设备查询
	 * @param pageFlag
	 * @param pageSize
	 * @param status
	 * @param dev
	 * @param devtellerno
	 * @param devip
	 * @param admbrno
	 * @param dstbrno
	 * @param cshboxflg
	 * @param vchboxflg
	 * @param areacode
	 * @param offlineflg
	 * @param admtellerno
	 * @param telephone
	 * @return
	 */
	public Map<String,Object> queryDevInfoMy(int pageFlag, int pageSize, String devtype, String devno,
	String status , String devtellerno, String admbrno, String dstbrno, String myBank){ 		
		//查询
        IPage<Map<String,Object>> pageInfo = devInfoDao.selectDevInfo(pageFlag, pageSize, devtype, devno,status,devtellerno, admbrno, dstbrno,myBank);
        Map<String, Object> result = new HashMap<>();
		result.put("rowcnt", Long.toString(pageInfo.getTotal()));// 总笔数
		result.put("listnm", Long.toString(pageInfo.getSize()));// 返回记录数
		result.put("dev_list", pageInfo.getRecords());// 返回数据
		//返回数据
		return result;		
	}
	
	

	/**
	 * @summary 自助设备新增
	 * @param map 要插入的字段信息
	 */
	public void selfDevAdd(Map<String, Object> map) {
		//
		
		//插入设备信息至设备信息表
		   
		
	}
	
	/**
	 * @summary 自助设备检查
	 * @param map 要插入的字段信息
	 */
	public void selfDevCheck(Map<String, Object> map) {
		//根据主键 devno 查询数据库是否存在此设备信息，存在则报错
		String devno = (String) map.get("devno");
		DevInfo info = devInfoDao.SelectDevInfo(devno);
		if(info != null) {
			logger.info("自助设备[%s]已存在!",devno);
			throw new CheckNotDataException("自助设备["+devno+"]已存在!");
		}
		
	}
	
	public void saveDevInfo(DevInfo devInfo){  
		
//		List<TellerInfo> list = tellerDao.queryListTellerByNo(devInfo.getDevTellerNo(), devInfo.getAdmBrno());
//		if (null == list || list.size() == 0) {
//			
//			throw new DevInfoAddFailException("自助设备尚未注册");
//		}else {
//			
//			TellerInfo tellerInfo = list.get(0);
//			if (null == tellerInfo || StringUtils.isEmpty(tellerInfo.getTellerType()) || "Z".equals(tellerInfo.getTellerType())) {
//				throw new DevInfoAddFailException("注册柜员不是虚拟柜员");
//			}
//			
//		}

		int count = devInfoDao.saveDevInfo(devInfo);
		if (0 == count) {
			logger.info("自助设备添加失败异常");
			dbo.rollback();
			throw new DevInfoAddFailException("新增自助设备失败");
		}
		dbo.commit();
	}

	/**
	 * @summary 更新尾箱的信息为解绑状态
	 * @param devno  设备号
	 * @param devtype 设备类型
	 * @param devTellerno  虚拟柜员号
	 * @param admBrno  管理机构号
	 */
	public void updateDevInfo(String devno,String devtype,String devTellerno,String admBrno) {
		int updateDevInfo = devInfoDao.updateDevInfo(devno,devtype);
		if(updateDevInfo != 1) {
			dbo.rollback();
			logger.info("更新尾箱状态失败");
			throw new CheckNotDataException("更新尾箱状态失败");
		}
		//更新柜员状态
		int deleteByCon = tellerDao.updateTellerInfo(devTellerno,admBrno);
		if(deleteByCon != 1) {
			dbo.rollback();
			logger.info("虚拟柜员注销失败！");
			throw new CheckNotDataException("虚拟柜员注销失败！");
		}
		dbo.commit();
	}
 
	/**
	 * @summary 自助设备修改
	 * @param map 修改字段
	 */
	public void selfDevUpdate(Map<String, Object> map,String devno,String devtype) {
		//查询设备信息
		getSelfDevBoxInfo(devno,devtype);
		//修改设备信息
		int count = devInfoDao.updateSelfDev(map,devno,devtype);
		if(count != 1) {
			dbo.rollback();
			logger.info("自助设备修改失败");
			throw new CheckNotDataException("自助设备修改失败");
		}
		dbo.commit();
	}

	/**
	 * @summary 自助设备改为启用状态
	 * @param status 状态
	 */
	public void selfdevUsing(String status) {
		int count = devInfoDao.selfdevUsing(status);
		if(count != 1) {
			dbo.rollback();
			logger.info("自助设备改为启用状态失败");
			throw new CheckNotDataException("自助设备改为启用状态失败");
		}
		dbo.commit();
	}


	/**
	 * @summary 查询设备信息
	 * @param devno 设备号
	 * @param devtype  设备类型
	 * @return 
	 */
	public DevInfo getSelfDevBoxInfo(String devno, String devtype) {
		DevInfo info = devInfoDao.CheckDevInfo(devno,devtype);
		if(info == null) {
			logger.info("自助设备不存在！");
			throw new CheckNotDataException("自助设备不存在！");
		}
		return info;
	}

	/**
	 * @summary 自助设备删除
	 * @param devno 设备号
	 * @param devtype 设备类型
	 * @param tellerno 柜员号
	 * @param admBrno 机构号
	 */
	public void selfDevDelete(String devno, String devtype,String tellerno,String admBrno) {
		//查询设备信息
		getSelfDevBoxInfo(devno,devtype);
		//删除自助设备
		int result = devInfoDao.selfDevDelete(devno,devtype);
		if(result != 1) {
			dbo.rollback();
			logger.info("自助设备删除失败！");
			throw new CheckNotDataException("自助设备删除失败");
		}
		//注销柜员信息
		int deleteByCon = tellerDao.updateTellerInfo(tellerno,admBrno);
		if(deleteByCon != 1) {
			dbo.rollback();
			logger.info("虚拟柜员注销失败！");
			throw new CheckNotDataException("虚拟柜员注销失败！");
		}
		dbo.commit();
	}

	/**
	 * 
	 * @return
	 */
	public String findDevInfo(String devno) {
		Map<String, Object> devInfo=devInfoDao.findDevInfo(devno);
		if(null == devInfo.get("admbrno")) {
			logger.info("设备所在机构号为空"); 
			throw new CheckNotDataException("设备所在机构号为空");
		}
		return (String)devInfo.get("admbrno");
	}

	public  Map<String,Object> getBrnoByDevno(String devno) {
		 Map<String, Object> devinfo = devInfoDao.findDevInfo(devno);
			if(null==devinfo.get("admbrno")) {
				logger.info("设备所在机构号为空"); 
				throw new CheckNotDataException("设备所在机构号为空");
			}
		 String brno = (String)devinfo.get("admbrno");
		 String superBranch = branchDao.getSuperBranch(brno);
		 Map<String,Object> map = new HashMap<String, Object>();
		 map.put("brno", brno);
		 map.put("superBranch", superBranch);
		return map;
	}


	public boolean checkTellerExist(String tellerno,String brno) {
		//查询虚拟柜员是否已经绑定设备信息
		int count = devInfoDao.findDevInfoByTellerno(tellerno);
		if(count != 0) {
			logger.info("该柜员["+tellerno+"]已经绑定自助设备");
			throw new CheckNotDataException("该柜员["+tellerno+"]已经绑定自助设备");
		}
		//检查柜员是否为虚拟柜员
		StaffInfo staffInfo = staffInfoDao.queryTellerByNo(tellerno);
		if(staffInfo == null ) {
			throw new CheckNotDataException("柜员号["+tellerno+"]的行员信息不存在");
		}
		if(!"04".equals(staffInfo.getTellerType())) {
			throw new CheckNotDataException("柜员号["+tellerno+"]不是虚拟柜员！");
		}
		//检查机构和柜员信息是否一致
		TellerInfo tellerInfo = tellerDao.queryTellerByNo(tellerno, brno);
		if (null == tellerInfo) {	
			logger.info("该机构["+brno+"]不存在此柜员号["+tellerno+"]！");
			throw new DevInfoAddFailException("该机构["+brno+"]不存在此柜员号["+tellerno+"]！");
		}
		//检查虚拟柜员是否正常  0-注销   1-正常
		if("0".equals(tellerInfo.getStatus())) {
			throw new CheckNotDataException("该柜员["+tellerno+"]已经被注销！");
		}
		
		return true;
	}
	/**
	 * @summary 自助设备变更资产归属机构
	 * @param devno
	 * @param devtype
	 * @param dstbrno  资产机构
	 */
	public void selfDevProperty(String devno, String devtype, String dstbrno) {
		//查询设备信息
		getSelfDevBoxInfo(devno,devtype);
		//更新字段
		Map<String ,Object> map = new HashMap<>();
		map.put("dstbrno",dstbrno);
		map.put("updatedate", DateTimeUtil.getSysDate() );
		map.put("updatetime", DateTimeUtil.getSysTime() );
		//自助设备变更管理归属机构
		int count = devInfoDao.selfDevProperty(devno,devtype,map);
		if(count != 1) {
			dbo.rollback();
			logger.info("自助设备变更资产归属机构  失败");
			throw new CheckNotDataException("自助设备变更资产归属机构  失败");
		}
		dbo.commit();
	}
	/**
	 * @summary 自助设备变更管理归属机构
	 * @param map 更新字段
	 * @param devtype 
	 * @param devno 
	 */
	public void selfDevManage(Map<String, Object> map, String devno, String devtype) {
		//查询设备信息
		getSelfDevBoxInfo(devno,devtype);
		//自助设备变更管理归属机构
		int count = devInfoDao.selfDevManage(map,devno,devtype);
		if(count != 1) {
			dbo.rollback();
			logger.info("自助设备变更管理归属机构  失败");
			throw new CheckNotDataException("自助设备变更管理归属机构  失败");
		}
		dbo.commit();
	}



	public void dataRollback() {
		dbo.rollback();
		
	}

	/**
	 * 检查虚拟柜员是否存在于此机构
	 * @param admBrno 管理机构
	 * @param devTellerno  虚拟柜员号

	 */
	public void checkAmdBrnoExist(String admBrno, String devTellerno) {
		TellerInfo tellerInfo = tellerDao.queryTellerByNo(devTellerno, admBrno);
		if(null == tellerInfo) {
			throw new CheckNotDataException("柜员号["+devTellerno+"]不属于此机构["+admBrno+"]");
		}
		
	}
	
	
}
