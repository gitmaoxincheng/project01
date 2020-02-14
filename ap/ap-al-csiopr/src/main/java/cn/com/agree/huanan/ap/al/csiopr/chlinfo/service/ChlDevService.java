package cn.com.agree.huanan.ap.al.csiopr.chlinfo.service;


import cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao.ChlDevDao;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao.ChlDevOperDao;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.*;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlDev;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlDevOper;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @summary 渠道设备信息（白名单）服务层
 * 
 */
@Service
public class ChlDevService {
	@Autowired
	ChlDevDao chlDevDao;
	@Autowired
	ChlDevOperDao chlDevOperDao;
	@Autowired
	DbOperator dbo;
	@Autowired Logger logger;

	/**
	 * 根据渠道请求IP查询渠道设备信息
	 * @param chlCode
	 * @param devIp
	 * @param status
	 * @return
	 */
	public ChlDev getChlDevByIp(String sysId,String devIp,String status) {
		if (StringUtils.isEmpty(devIp)){
			throw new ApNullArgsException("devIp","渠道请求IP");
		}
		return chlDevDao.findChlDev(sysId,devIp,null,status);
	}

	/**
	 * 根据渠道设备号查询渠道设备信息
	 * @param chlCode
	 * @param devNo
	 * @param status
	 * @return
	 */
	public ChlDev getChlDevByNo(String sysId,String devNo,String status) {
		if (StringUtils.isEmpty(devNo)){
			throw new ApNullArgsException("devNo","渠道设备号");
		}
		return chlDevDao.findChlDev(sysId,null,devNo,status);	}



	/**
	 * 渠道白名单新增
	 * @param serino      流水号      
	 * @param chnlcode    渠道代码     
	 * @param devip       Ip地址     
	 * @param devno       设备编号     
	 * @param devname     设备名称     
	 * @param devaddr     设备地址     
	 * @param status      状态       
	 * @param crtdate     操作日期     
	 * @param crttime     操作时间     
	 * @param crtbrno     操作行所     
	 * @param crttlr      操作柜员     
	 * @param audate      审批日期     
	 * @param audtime     审批时间     
	 * @param audbrno     审批行所     
	 * @param audtlr      审批柜员     
	 * @param authremarks 审批意见     
	 */
	public void addChlDev(String serino, String sysId, String devip, String devno, String devname,
			String devaddr, String status, String crtdate, String crttime, String crtbrno, String crttlr,
			String audate,String audtime,String audbrno,String audtlr,String authremarks) {
		// 检查渠道白名单信息是否存在
		if (null == devip ||null== devno)
		{
			throw new ApNullArgsException("devIp或devNo","渠道请求IP或渠道设备号");
		}
		ChlDev chlDev = chlDevDao.findChlDev(sysId,devip,devno,status);
		if (chlDev != null) {
			logger.info("渠道白名单信息已经存在,不能新增");
			throw new ChlDevExistException("渠道白名单信息已经存在,不能新增");
		}
		// 检查渠道白名单审批表是否存在待审批的记录
		ChlDevOper chlDevOper= chlDevOperDao.findChlDevOperBySysId(sysId,"0");
		if (chlDevOper != null) {
			logger.info("渠道白名单审批信息已经存在");
			throw new ChlDevOperExistException("渠道白名单审批信息已经存在");
		} 
		
		// 插入渠道白名单新增审批记录
		ChlDevOper chlDevOperTemp = new ChlDevOper();
		chlDevOperTemp.setSeriNo(serino);
		chlDevOperTemp.setOptType("0");
		chlDevOperTemp.setChnlCode(sysId);
		chlDevOperTemp.setDevIp(devip);
		chlDevOperTemp.setDevNo(devno);
		chlDevOperTemp.setDevName(devname);
		chlDevOperTemp.setDevAddr(devaddr);
		chlDevOperTemp.setStatus(status);
		chlDevOperTemp.setCrtDate(crtdate);
		chlDevOperTemp.setCrtTime(crttime);
		chlDevOperTemp.setCrtBrno(crtbrno);    
		chlDevOperTemp.setCrtTlr(crttlr);     
		chlDevOperTemp.setAuDate(audate);     
		chlDevOperTemp.setAudTime(audtime);  
		chlDevOperTemp.setAudBrno(audbrno); 
		chlDevOperTemp.setAudTlr(audtlr);    
		chlDevOperTemp.setAuthStatus("0"); 
		chlDevOperTemp.setAuthRemarks(authremarks);
		
		int count = chlDevOperDao.insertChlDevToOper(chlDevOperTemp);
		
		if(count!=1) {
			logger.info("添加渠道白名单新增信息到审批表失败");
			throw new InsertChlDevOperException("添加渠道白名单新增信息到审批表失败");
		}
		
	}
	/**
	 * 渠道白名单修改
	 * @param serino      流水号      
	 * @param chnlcode    渠道代码     
	 * @param devip       Ip地址     
	 * @param devno       设备编号     
	 * @param devname     设备名称     
	 * @param devaddr     设备地址     
	 * @param status      状态       
	 * @param crtdate     操作日期     
	 * @param crttime     操作时间     
	 * @param crtbrno     操作行所     
	 * @param crttlr      操作柜员     
	 * @param audate      审批日期     
	 * @param audtime     审批时间     
	 * @param audbrno     审批行所     
	 * @param audtlr      审批柜员     
	 * @param authremarks 审批意见     
	 */
	public void updateChlDev(String serino, String sysId, String devip, String devno, String devname,
			String devaddr, String status, String crtdate, String crttime, String crtbrno, String crttlr,
			String audate,String audtime,String audbrno,String audtlr,String authremarks) {
		// 检查渠道白名单信息是否存在
		if (null == devip ||null== devno)
		{
			throw new ApNullArgsException("devIp或devNo","渠道请求IP或渠道设备号");
		}
		ChlDev chlDev = chlDevDao.findChlDev(sysId,devip,devno,status);
		if (chlDev == null) {
			logger.info("渠道白名单不存在,不能修改");
			throw new ChlDevNotExistException("渠道白名单不存在,不能修改");
		}
		// 检查渠道白名单审批表是否存在待审批的记录
		ChlDevOper chlDevOper= chlDevOperDao.findChlDevOperBySysId(sysId,"0");
		if (chlDevOper != null) {
			logger.info("渠道白名单审批信息已经存在");
			throw new ChlDevOperExistException("渠道白名单审批信息已经存在");
		} 
		
		// 插入渠道白名单修改审批记录
		ChlDevOper chlDevOperTemp = new ChlDevOper();
		chlDevOperTemp.setSeriNo(serino);
		chlDevOperTemp.setOptType("1");
		chlDevOperTemp.setSysId(sysId);
		chlDevOperTemp.setDevIp(devip);
		chlDevOperTemp.setDevNo(devno);
		chlDevOperTemp.setDevName(devname);
		chlDevOperTemp.setDevAddr(devaddr);
		chlDevOperTemp.setStatus(status);
		chlDevOperTemp.setCrtDate(crtdate);
		chlDevOperTemp.setCrtTime(crttime);
		chlDevOperTemp.setCrtBrno(crtbrno);    
		chlDevOperTemp.setCrtTlr(crttlr);     
		chlDevOperTemp.setAuDate(audate);     
		chlDevOperTemp.setAudTime(audtime);  
		chlDevOperTemp.setAudBrno(audbrno); 
		chlDevOperTemp.setAudTlr(audtlr);    
		chlDevOperTemp.setAuthStatus("0"); 
		chlDevOperTemp.setAuthRemarks(authremarks);
		
		int count = chlDevOperDao.insertChlDevToOper(chlDevOperTemp);
		
		if(count!=1) {
			logger.info("添加渠道白名单修改信息到审批表失败");
			throw new InsertChlDevOperException("添加渠道白名单修改信息到审批表失败");
		}
	}

	/**
	 * 渠道白名单删除
	 * @param serino      流水号      
	 * @param chnlcode    渠道代码     
	 * @param devip       Ip地址     
	 * @param devno       设备编号     
	 * @param devname     设备名称     
	 * @param devaddr     设备地址     
	 * @param status      状态       
	 * @param crtdate     操作日期     
	 * @param crttime     操作时间     
	 * @param crtbrno     操作行所     
	 * @param crttlr      操作柜员     
	 * @param audate      审批日期     
	 * @param audtime     审批时间     
	 * @param audbrno     审批行所     
	 * @param audtlr      审批柜员     
	 * @param authremarks 审批意见     
	 */
	public void deleteChlDev(String serino, String sysId, String devip, String devno, String devname,
			String devaddr, String status, String crtdate, String crttime, String crtbrno, String crttlr,
			String audate,String audtime,String audbrno,String audtlr,String authremarks) {
		// 检查渠道白名单信息是否存在
		if (null == devip ||null== devno)
		{
			throw new ApNullArgsException("devIp或devNo","渠道请求IP或渠道设备号");
		}
		ChlDev chlDev = chlDevDao.findChlDev(sysId,devip,devno,status);
		if (chlDev == null) {
			logger.info("渠道白名单信息不存在,不能删除");
			throw new ChlDevNotExistException("渠道白名单信息不存在,不能删除");
		}
		// 检查渠道白名单审批表是否存在待审批的记录
		ChlDevOper chlDevOper= chlDevOperDao.findChlDevOperBySysId(sysId,"0");
		if (chlDevOper != null) {
			logger.info("渠道白名单审批信息已经存在");
			throw new ChlDevOperExistException("渠道白名单审批信息已经存在");
		}
		
		// 插入渠道白名单删除审批记录
		ChlDevOper chlDevOperTemp = new ChlDevOper();
		chlDevOperTemp.setSeriNo(serino);
		chlDevOperTemp.setOptType("2");
		chlDevOperTemp.setSysId(sysId);
		chlDevOperTemp.setDevIp(devip);
		chlDevOperTemp.setDevNo(devno);
		chlDevOperTemp.setDevName(chlDev.getDevName());
		chlDevOperTemp.setDevAddr(chlDev.getDevAddr());
		chlDevOperTemp.setStatus(chlDev.getStatus());
		chlDevOperTemp.setCrtDate(crtdate);
		chlDevOperTemp.setCrtTime(crttime);
		chlDevOperTemp.setCrtBrno(crtbrno);    
		chlDevOperTemp.setCrtTlr(crttlr);     
		chlDevOperTemp.setAuDate(audate);     
		chlDevOperTemp.setAudTime(audtime);  
		chlDevOperTemp.setAudBrno(audbrno); 
		chlDevOperTemp.setAudTlr(audtlr);    
		chlDevOperTemp.setAuthStatus("0"); 
		chlDevOperTemp.setAuthRemarks(authremarks);
		
		int count = chlDevOperDao.insertChlDevToOper(chlDevOperTemp);
		
		if(count!=1) {
			logger.info("添加渠道白名单删除信息到审批表失败");
			throw new InsertChlDevOperException("添加渠道白名单删除信息到审批表失败");
		}
	}


	/**
	 * 渠道白名单查询
	 * @param curPage   页码
	 * @param pageSize  每页数据量
	 * @param chnlcode  渠道代码 
	 * @param devip     IP地址
	 * @param devno     设备编号
	 * @param status    状态
	 * @return
	 */
	public Map<String, Object> queryChlDev(int curPage, int pageSize, String chnlcode, String devip, String devno,
			String status) {
		//检验参数
		if(curPage < 1) {
			logger.error("查询渠道白名单的页码不能小于1");
			throw new ParamFailException();
		}else if(pageSize<1) {
			logger.error("每页查询记录数不可小于1");
			throw new ParamFailException("pageSize");
		}
		
		IPage<Map<String,Object>> pageInfo = chlDevDao.queryChlDev(curPage,pageSize,chnlcode,devip,devno,status);
		
		if (pageInfo.getSize() == 0) {
			logger.info("渠道白名单查询数据为空");
			throw new ChlDevNotExistException("渠道白名单查询数据为空");
		}
		
		Map<String, Object> result = new HashMap<>();
		result.put("rowcnt", pageInfo.getTotal());    // 总笔数
		result.put("dev_list", pageInfo.getRecords());  // 返回数据
		result.put("listnm", pageInfo.getSize());     // 返回记录数

		return result;
	}
	

	/**
	 * 渠道白名单审批查询
	 * @param curPage     页码
	 * @param pageSize    每页最多记录
	 * @param chnlCode    系统标识  
	 * @param beginDate   起始日期  
	 * @param endDate     截止日期  
	 * @param optType     操作类型  
	 * @param authStatus   审批状态
	 * @return
	 */
	public Map<String, Object> queryChlDevOper(int curPage, int pageSize, String chnlCode, String beginDate, String endDate,
			String optType, String authStatus) {
		
		//检验参数
		if(curPage < 1) {
			logger.error("查询渠道白名单待审批记录的页码不能小于1");
			throw new ParamFailException();
		}else if(pageSize<1) {
			logger.error("每页查询记录数不可小于1");
			throw new ParamFailException("pageSize");
		}
		
		IPage<Map<String,Object>> pageInfo = chlDevOperDao.queryChlDevOper(curPage,pageSize,chnlCode,beginDate,endDate,optType,authStatus);

		if (pageInfo.getSize() == 0) {
			logger.info("渠道白名单审批查询数据为空");
			throw new ChlDevOperNotExistException("渠道白名单审批查询数据为空");
		}
		
		Map<String, Object> result = new HashMap<>();
		result.put("rowcnt", pageInfo.getTotal());    // 总笔数
		result.put("oper_list", pageInfo.getRecords());  // 返回数据
		result.put("listnm", pageInfo.getSize());     // 返回记录数

		return result;
	}
	
	/**
	 * 渠道白名单变更审批
	 * @param seriNo      流水号
	 * @param authStatus   审批状态
	 * @param authRemarks  审批意见
	 * @param audBrNo     审批行所
	 * @param audTlr      审批柜员
	 * @param audDate     审批日期
	 * @param audTime     审批时间
	 */
	public void chlDevChangeOper(String seriNo, String authStatus, String authRemarks, String audBrNo, String audTlr, 
			String audDate, String audTime) {
		// 检查审批状态是否为待审批
		ChlDevOper chlDevOper = chlDevOperDao.queryChlDevOperByseriNo(seriNo);
		if (chlDevOper == null) {
			logger.info("渠道白名单待审批信息不存在");
			throw new ChlDevOperNotExistException("渠道白名单待审批信息不存在");
		}
		//检查审批柜员是否为操作柜员
		if (chlDevOper.getCrtTlr().equals(audTlr)) {
			logger.info("审批柜员与操作柜员不能相同");
			throw new ApIllegalParamException("审批柜员与操作柜员不能相同");
		}
		
		//渠道白名单审核表更新
		chlDevOper.setAuthStatus(authStatus);
		chlDevOper.setAuthRemarks(authRemarks);
		chlDevOper.setAudBrno(audBrNo);
		chlDevOper.setAudTlr(audTlr);
		chlDevOper.setAuDate(audDate);
		chlDevOper.setAudTime(audTime);
		
		int count = chlDevOperDao.updataChlDevOper(chlDevOper);
		if (1 != count) {
			logger.info("更新渠道白名单待审批记录失败");
			throw new UpdateChlDevOperFailException(chlDevOper.getSeriNo());
		}
		logger.info("更新渠道白名单待审批记录成功");
		
		// 完成渠道白名单处理
		if (authStatus.equals("1")) {
			logger.info("渠道白名单处理");
			ChlDev chlDev = new ChlDev();
			int resultCount = 0;
			chlDev.setChnlCode(chlDevOper.getChnlCode());
			chlDev.setDevIp(chlDevOper.getDevIp());
			chlDev.setDevNo(chlDevOper.getDevNo());
			chlDev.setDevName(chlDevOper.getDevName());
			chlDev.setDevAddr(chlDevOper.getDevAddr());
			chlDev.setStatus(chlDevOper.getStatus());
			
			if ("0".equals(chlDevOper.getOptType())) {
				resultCount = chlDevDao.addChlDev(chlDev);
			} else if ("1".equals(chlDevOper.getOptType())) {
				resultCount = chlDevDao.updateChlDev(chlDev);
			} else if ("2".equals(chlDevOper.getOptType())) {
				resultCount = chlDevDao.deleteChlDev(chlDev);
			}
			if (resultCount != 1) {
				dbo.rollback();
				logger.info("更新渠道白名单失败");
				throw new UpdateChlDevFailException(chlDevOper.getChnlCode());
			}
			logger.info("更新渠道白名单成功");
		}
		dbo.commit();
	}




	



}
