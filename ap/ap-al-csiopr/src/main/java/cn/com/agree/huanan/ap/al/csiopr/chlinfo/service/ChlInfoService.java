package cn.com.agree.huanan.ap.al.csiopr.chlinfo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao.ChlInfoDao;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao.ChlInfoOperDao;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.CheckNotDataException;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.ChlInfoExistException;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.ChlInfoNotExistException;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.ChlInfoOperExistException;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.HandleChlInfoFailException;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.InsertChlInfoOperFailException;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.NotDeleteChannelException;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.UpdateChlInfoOperFailException;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlInfo;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlInfoOper;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApInsertFailException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApUpdateFailException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

@Service
public class ChlInfoService {
	@Autowired ChlInfoDao chlInfoDao;
	@Autowired ChlInfoOperDao chlInfoOperDao;
	@Autowired DbOperator dbo;
	@Autowired Logger logger;

	/**
	 * 插入渠道信息新增待审批记录
	 * @param sysid      系统标识
	 * @param chnlCode   渠道代码
	 * @param chnlName   渠道名称
	 * @param status     渠道状态
	 * @param chkFlag    渠道设备检查标识
	 * @param crtBrNo    操作行所
	 * @param crtTlr     操作柜员
	 */
	public void insertAddChlInfoOper(String sysId,String chnlCode,String chnlName,String Status,String chkFlag,
			String crtBrNo,String crtTlr) {
		// 检查是否已存在渠道信息
		ChlInfo chlInfo = chlInfoDao.selectChlInfoById(sysId);
		if (null != chlInfo) {
			throw new ChlInfoExistException(sysId);
		}
		// 检查是否已存在渠道信息审批记录
		ChlInfoOper chlInfoOper = chlInfoOperDao.queryChlInfoOperById(sysId);
		if (null != chlInfoOper) {
			throw new ChlInfoOperExistException(chlInfoOper.getSeriNo());
		}
		// 插入渠道信息新增审批记录
		ChlInfoOper chlInfoOperTemp = new ChlInfoOper();
		//chlInfoOperTemp.setSeriNo(SernoGenUtil.getSerno(CommParam.OPR_SEQ));
		chlInfoOperTemp.setSeriNo("SernoGenUtil.getSerno(CommParam.OPR_SEQ)");
		chlInfoOperTemp.setOptType("0");
		chlInfoOperTemp.setSysId(sysId);
		chlInfoOperTemp.setChnlCode(chnlCode);
		chlInfoOperTemp.setChnlName(chnlName);
		chlInfoOperTemp.setStatus(Status);
		chlInfoOperTemp.setChkFlag(chkFlag);
		chlInfoOperTemp.setCrtDate(DateTimeUtil.getSysDate());
		chlInfoOperTemp.setCrtTime(DateTimeUtil.getSysTime());
		chlInfoOperTemp.setCrtBrNo(crtBrNo);
		chlInfoOperTemp.setCrtTlr(crtTlr);
		chlInfoOperTemp.setAudStatus("0");
		int count = chlInfoOperDao.insertChlInfoOper(chlInfoOperTemp);
		if (count != 1 ) {
			logger.error("插入渠道信息新增待审批记录失败");
			throw new InsertChlInfoOperFailException();
		}
		dbo.commit();
		logger.info("插入渠道信息新增待审批记录成功");
	}

	/**
	 * 插入渠道信息修改待审批记录
	 * @param sysid      系统标识
	 * @param chnlCode   渠道代码
	 * @param chnlName   渠道名称
	 * @param status     渠道状态
	 * @param chkFlag    渠道设备检查标识
	 * @param crtBrNo    操作行所
	 * @param crtTlr     操作柜员
	 */
	public void insertUpdateChlInfoOper(String sysId,String chnlCode,String chnlName,String Status,String chkFlag,
			String crtBrNo,String crtTlr) {
		// 检查是否已存在渠道信息
		ChlInfo chlInfo = chlInfoDao.selectChlInfoById(sysId);
		if (null == chlInfo) {
			throw new ChlInfoNotExistException(sysId);
		}
		// 检查是否已存在渠道信息审批记录
		ChlInfoOper chlInfoOper = chlInfoOperDao.queryChlInfoOperById(sysId);
		if (null != chlInfoOper) {
			throw new ChlInfoOperExistException(chlInfoOper.getSeriNo());
		}
		// 插入渠道信息修改审批记录
		ChlInfoOper chlInfoOperTemp = new ChlInfoOper();
		//chlInfoOperTemp.setSeriNo(SernoGenUtil.getSerno(CommParam.OPR_SEQ));
		chlInfoOperTemp.setOptType("1");
		chlInfoOperTemp.setSysId(sysId);
		chlInfoOperTemp.setChnlCode(chnlCode);
		chlInfoOperTemp.setChnlName(chnlName);
		chlInfoOperTemp.setStatus(Status);
		chlInfoOperTemp.setChkFlag(chkFlag);
		chlInfoOperTemp.setCrtDate(DateTimeUtil.getSysDate());
		chlInfoOperTemp.setCrtTime(DateTimeUtil.getSysTime());
		chlInfoOperTemp.setCrtBrNo(crtBrNo);
		chlInfoOperTemp.setCrtTlr(crtTlr);
		chlInfoOperTemp.setAudStatus("0");
		int count = chlInfoOperDao.insertChlInfoOper(chlInfoOperTemp);
		if (count != 1 ) {
			logger.error("插入渠道信息修改待审批记录失败");
			throw new InsertChlInfoOperFailException();
		}
		dbo.commit();
		logger.info("插入渠道信息修改待审批记录成功");
	}
	
	/**
	 * 插入渠道信息删除待审批记录
	 * @param sysId     系统标识
	 * @param crtBrNo   操作行所
	 * @param crtTlr    操作柜员
	 */
	public void insertDeleteChlInfoOper(String sysId,String crtBrNo,String crtTlr) {
		// 检查是否已存在渠道信息
		ChlInfo chlInfo = chlInfoDao.selectChlInfoById(sysId);
		if (null == chlInfo) {
			throw new ChlInfoNotExistException(sysId);
		}
		// 检查是否已存在渠道信息审批记录
		ChlInfoOper chlInfoOper = chlInfoOperDao.queryChlInfoOperById(sysId);
		if (null != chlInfoOper) {
			throw new ChlInfoOperExistException(chlInfoOper.getSeriNo());
		}
		// 插入渠道信息删除审批记录
		ChlInfoOper chlInfoOperTemp = new ChlInfoOper();
		//chlInfoOperTemp.setSeriNo(SernoGenUtil.getSerno(CommParam.OPR_SEQ));
		chlInfoOperTemp.setOptType("2");
		chlInfoOperTemp.setSysId(sysId);
		chlInfoOperTemp.setChnlCode(chlInfo.getChnlCode());
		chlInfoOperTemp.setChnlName(chlInfo.getChnlName());
		chlInfoOperTemp.setStatus(chlInfo.getStatus());
		chlInfoOperTemp.setChkFlag(chlInfo.getChkFlag());
		chlInfoOperTemp.setCrtDate(DateTimeUtil.getSysDate());
		chlInfoOperTemp.setCrtTime(DateTimeUtil.getSysTime());
		chlInfoOperTemp.setCrtBrNo(crtBrNo);
		chlInfoOperTemp.setCrtTlr(crtTlr);
		chlInfoOperTemp.setAudStatus("0");
		int count = chlInfoOperDao.insertChlInfoOper(chlInfoOperTemp);
		if (count != 1 ) {
			logger.error("插入渠道信息删除待审批记录失败");
			throw new InsertChlInfoOperFailException();
		}
		dbo.commit();
		logger.info("插入渠道信息删除待审批记录成功");
	}
	
	
	/**
	 * 获取渠道信息分页列表
	 * @param curpage 页码
	 * @param pageSize 每页最多记录数
	 * @param sysid 系统标识
	 * @param chnlCode 渠道代码
	 * @param chnlName 渠道名称
	 * @param status 渠道状态
	 * @return 总笔数，返回记录数，循环体
	 */
	public Map<String, Object> getChlInfoPageList(int curpage, int pageSize, String sysId ,String chnlCode, String chnlName, String status) {

		//检验参数
		if(pageSize<1) {
			logger.error("每页查询记录数不可小于1");
			throw new HandleChlInfoFailException("pageSize");
		}
		
		Map<String, Object> result = new HashMap<>();
		IPage<Map<String,Object>> pageInfo = chlInfoDao.getChlInfoPageList(curpage, pageSize, sysId, chnlCode, chnlName, status);

		if (0 == pageInfo.getSize()) {
			throw new CheckNotDataException();
		}

		result.put("rowcnt", pageInfo.getTotal());// 总笔数
		result.put("listnm", pageInfo.getSize());// 返回记录数
		result.put("chnl_list", pageInfo.getRecords());// 返回数据
		return result;
	}
	
	/**
	 * 获取渠道信息审批记录分页列表
	 * @param curpage 页码
	 * @param pageSize 每页最多记录数
	 * @param chnlCode 系统标识
	 * @param beginDate 起始日期
	 * @param endDate 截止日期
	 * @param optType 操作类型
	 * @param audStatus 审批状态
	 * @return 总笔数，返回记录数，循环体
	 *
	 */
	public Map<String, Object> getChlInfoOperPageList(int curpage, int pageSize, String sysId, String beginDate, String endDate, 
			String optType, String audStatus) {
		//检验参数
		if(pageSize<1) {
			logger.error("每页查询记录数不可小于1");
			throw new HandleChlInfoFailException("pageSize");
		}
		
		Map<String, Object> result = new HashMap<>();
		IPage<Map<String, Object>> pageInfo = chlInfoOperDao.getChlInfoOperPageList(curpage, pageSize, sysId, beginDate, endDate, optType, audStatus);

		if (0 == pageInfo.getSize()) {
			throw new CheckNotDataException();
		}
		
		result.put("rowcnt", pageInfo.getTotal());// 总笔数
		result.put("listnm", pageInfo.getSize());// 返回记录数
		result.put("oper_list", pageInfo.getRecords());// 返回数据
		return result;
	}

	
	/**
	 * 检查审批状态是否为待审批
	 * @param seriNo 全局流水号
	 * @return 渠道信息审批记录
	 */
	public ChlInfoOper getChlInfoOperBySeriNo(String seriNo) {
		return chlInfoOperDao.queryChlInfoOperByseriNo(seriNo);
	}


	/**
	 * 完成渠道信息处理
	 * @param chlInfoOper 渠道信息审批记录
	 * @param audStatus 审批状态
	 * @param audRemark 审批意见
	 * @param audBrNo 审批行所
	 * @param audTlr 审批柜员
	 * @param audDate 审批日期
	 * @param audTime 审批时间
	 * @return 
	 */
	public void handle(ChlInfoOper chlInfoOper, String audStatus, String audRemark, String audBrNo, String audTlr) {
		// 渠道信息审核表更新
		chlInfoOper.setAudStatus(audStatus);
		chlInfoOper.setAudRemark(audRemark);
		chlInfoOper.setAudBrNo(audBrNo);
		chlInfoOper.setAudTlr(audTlr);
		chlInfoOper.setAudDate(DateTimeUtil.getSysDate());
		chlInfoOper.setAudTime(DateTimeUtil.getSysTime());
		
		int count = chlInfoOperDao.updateChlInfoOper(chlInfoOper);
		if (1 != count) {
			logger.info("更新渠道信息待审批记录失败");
			throw new UpdateChlInfoOperFailException(chlInfoOper.getSeriNo());
		}
		logger.info("更新渠道信息待审批记录成功");
		
		// 完成渠道信息处理
		if ("1".equals(audStatus)) {
			logger.info("渠道信息处理");
			ChlInfo chlInfo = new ChlInfo();
			int resultCount = 0;
			chlInfo.setSysId(chlInfoOper.getSysId());
			chlInfo.setChnlCode(chlInfoOper.getChnlCode());
			chlInfo.setChnlName(chlInfoOper.getChnlName());
			chlInfo.setStatus(chlInfoOper.getStatus());
			chlInfo.setChkFlag(chlInfoOper.getChkFlag());
			if ("0".equals(chlInfoOper.getOptType())) {
				resultCount = chlInfoDao.addChlInfo(chlInfo);
			} else if ("1".equals(chlInfoOper.getOptType())) {
				resultCount = chlInfoDao.updateChlInfo(chlInfo);
			} else if ("2".equals(chlInfoOper.getOptType())) {
				resultCount = chlInfoDao.deleteChlInfo(chlInfo);
			}
			
			if (1 != resultCount) {
				dbo.rollback();
				throw new HandleChlInfoFailException(chlInfoOper.getSysId());
			}
		}
		dbo.commit();
	}

	/**
	 * 根据系统ID查询渠道信息
	 * @param sysId 渠道ID
	 * @return 渠道信息审批记录
	 */
	public ChlInfo getChlInfo(String sysId) {
		logger.info("查询渠道信息，ID: "+sysId);
		return chlInfoDao.selectChlInfoById(sysId);
	}

	/**
	 * 根据流水号删除渠道信息审批表
	 * @param serino 流水号
	 */
	public void removeAdvInfo(String serino) {
		int count = chlInfoOperDao.deleteChlInfoOper(serino);
		if (count != 1) {
			dbo.rollback();
			logger.error("数据删除失败");
			throw new NotDeleteChannelException("数据删除失败");
		}else {
			dbo.commit();
			logger.info("数据删除成功");
		}	
	}

	/**
	 * 	更新渠道认证方式
	 */
	public void updateChangeChalAuth(String chnlCode, String authType,String serino, String audstatus,String audremark) {
/*		//参数检验
		if(StringUtils.isEmpty(chnlCode)) {
			throw new ApIllegalParamException("chnlCode");
		}else if(StringUtils.isEmpty(authType)) {
			throw new ApIllegalParamException("authType");
		}else if(StringUtils.isEmpty(serino)) {
			throw new ApIllegalParamException("serino");
		}else if(StringUtils.isEmpty(audstatus)) {
			throw new ApIllegalParamException("audstatus");
		}

		//信息表删除数据
		int count1 = chlAuthDao.deleteChlAuth(chnlCode, authType);
		if(count1 != 1) {
			logger.info("删除信息表失败,数据回滚");
			dbo.rollback();
			throw new NotDeleteChannelException();
		}

		//信息审批表修改参数
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("serino", serino);
		paramMap.put("audstatus", audstatus);
		paramMap.put("audremarks", audremarks);
		int count2 = chlAuthOperDao.updateChlAuthOper(paramMap);
		if(count2 != 1) {
			logger.info("失败修改信息审批表,数据回滚");
			dbo.rollback();
			throw new NotUpdateChannelException();
		}

		//提交数据
		if(count1 == 1 && count2 == 1) {
			dbo.commit();
		}*/
	}

	/**
	 * 渠道信息新增
	 * @param chlInfo  渠道信息实体bean
	 */
	public void addChlInfo(ChlInfo chlInfo) {
		int resultCount = chlInfoDao.addChlInfo(chlInfo);
		if (1 != resultCount) {
			dbo.rollback();
			throw new ApInsertFailException("渠道信息");
		}
		dbo.commit();
	}
	
	/**
	 * 渠道信息修改
	 * @param chlInfo  渠道信息实体bean
	 */
	public void updateChlInfo(ChlInfo chlInfo) {
		int resultCount = chlInfoDao.updateChlInfo(chlInfo);
		if (1 != resultCount) {
			dbo.rollback();
			throw new ApUpdateFailException("渠道信息");
		}
		dbo.commit();
	}
	
	/**
	 * 渠道信息删除
	 * @param chlInfo  渠道信息实体bean
	 */
	public void deleteChlInfo(ChlInfo chlInfo) {
		int resultCount = chlInfoDao.deleteChlInfo(chlInfo);
		if (1 != resultCount) {
			dbo.rollback();
			throw new ApUpdateFailException("渠道信息");
		}
		dbo.commit();
	}



}
