
package cn.com.agree.huanan.ap.al.csiopr.chlinfo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao.ChlInfoDao;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao.ChlSvcAuthDao;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao.ChlSvcAuthOperDao;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.DeleteSvrAuthFailException;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.ProcessErrorException;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.SvrAuthAlreadyAuditException;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.SvrAuthExistException;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.SvrAuthNotExistException;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.SvrAuthOperExistException;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlInfo;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlSvcAuth;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlSvcAuthOper;
import cn.com.agree.huanan.ap.al.csiopr.service.po.TranMapp;
import cn.com.agree.huanan.ap.al.csiopr.service.service.TranMapService;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApInsertFailException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApSelectNotFoundException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApUpdateFailException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 渠道服务service
 * @author lanshaojun
 *
 */
@Service
public class ChlSvcAuthService {
	@Autowired private ChlSvcAuthDao svcAuthDao;
	@Autowired private ChlInfoDao chlInfoDao;
	@Autowired private ChlSvcAuthOperDao svcAuthOperDao;
	@Autowired private TranMapService tranMapService;

	@Autowired private DbOperator dbo;
	@Autowired private Logger logger;

	/**
	 * 查询渠道授权信息
	 * @param sysId
	 * @param svcOutCode
	 * @param scnOutCode
	 * @return
	 */
	public ChlSvcAuth getChlSvcAuth(String sysId, String svcOutCode, String scnOutCode) {
		return svcAuthDao.selectChlSvcAuth(sysId,svcOutCode,scnOutCode);
	}

	/**
	 * 操作渠道服务记录
	 * @param sysId 系统标识
	 * @param chnlCode 渠道代码
	 * @param svcOutCode 对外发布服务码
	 * @param scnOutCode 对外发布场景码
	 * @param optType 操作类型
	 * @return 
	 *
	 */
	public void OperChlSvcAuth(String sysId, String chnlCode, String svcOutCode, String scnOutCode, String optType){
		CheckChlSvc(sysId, chnlCode, svcOutCode, scnOutCode, optType);
		UpdateChlSvcAuth(sysId, chnlCode, svcOutCode, scnOutCode, optType);
	}

	/**
	 * 检查渠道服务权限状态
	 * @param sysId 系统标识
	 * @param chnlCode 渠道代码
	 * @param svcOutCode 对外发布服务码
	 * @param scnOutCode 对外发布场景码
	 * @param optType 操作类型
	 * @return ChlInfo 渠道信息记录
	 *
	 */
	public ChlInfo CheckChlSvc(String sysId, String chnlCode, String svcOutCode, String scnOutCode, String optType) {
		boolean flag1 = "1".equals(optType);//1-申请
		boolean flag2 = "2".equals(optType);//2-取消
		boolean flag3 = "3".equals(optType);//3-停用
		boolean flag4 = "4".equals(optType);//4-启用
		
		//检查参数是否合格
		if(!flag1&&!flag2&&!flag3&&!flag4) {
			logger.error("渠道服务申请操作参数出错"); 
			throw new ApIllegalParamException("opt_type");
		}
		//检查是否存在渠道信息记录
		ChlInfo chlInfo = chlInfoDao.queryChlInfoBySysIdAndChnlCode(sysId, chnlCode);
		if(null == chlInfo) {
			logger.error("渠道信息记录不存在:"+sysId); 
			throw new ApSelectNotFoundException("渠道信息");
		}
		//检查是否存在交易映射对应的服务码和场景码
		TranMapp tranMapp = tranMapService.querTranMap(svcOutCode, scnOutCode);
		if(null == tranMapp) {
			logger.error("该服务码和场景码对应的记录不存在"); 
			throw new ApSelectNotFoundException("服务码和场景码");
		}
		//检查是否存在渠道服务权限记录
		ChlSvcAuth svrAuth = svcAuthDao.selectChlSvcAuth(sysId,svcOutCode,scnOutCode);

		if(null != svrAuth) {
			if(flag1) {
				logger.error("该渠道已拥有此服务权限");
				throw new SvrAuthExistException("'"+sysId+"','"+svcOutCode+":"+scnOutCode+"'");
			}
			else if(flag3&&svrAuth.getStatus().equals("1")){
				logger.error("该渠道已停用此服务权限");
				throw new SvrAuthNotExistException("'"+sysId+"','"+svcOutCode+":"+scnOutCode+"'");
			}
			else if(flag4&&svrAuth.getStatus().equals("0")) {
				logger.error("该渠道已启用此服务权限");
				throw new SvrAuthExistException("'"+sysId+"','"+svcOutCode+":"+scnOutCode+"'");
			}
		}
		else if(flag2||flag3||flag4){
			logger.error("该渠道未拥有此服务权限");
			throw new SvrAuthNotExistException("'"+sysId+"','"+svcOutCode+":"+scnOutCode+"'");
		}
		return chlInfo;
	}

	/**
	 * 插入渠道服务权限记录
	 * @param sysId 系统标识
	 * @param chnlCode 渠道代码
	 * @param svcOutCode 对外发布服务码
	 * @param scnOutCode 对外发布场景码
	 * @param optType 操作类型
	 * @return 
	 */
	public void UpdateChlSvcAuth(String sysId,String chnlCode,String svcOutCode,String scnOutCode,String optType) {

		//封装实体类
		ChlSvcAuth svrAuthTemp = new ChlSvcAuth();
		svrAuthTemp.setSysId(sysId);
		svrAuthTemp.setChnlCode(chnlCode);
		svrAuthTemp.setSvcOutCode(svcOutCode);
		svrAuthTemp.setScnOutCode(scnOutCode);
		
		//申请
		if(optType.equals("1")) {
			//插入渠道服务权限记录
			svrAuthTemp.setStatus("0");
			int count = svcAuthDao.insertChlSvcAuth(svrAuthTemp);
			if (count!=1) {
				dbo.rollback();
				logger.error("插入渠道服务权限记录失败"); 
				throw new ApInsertFailException("渠道服务权限记录");
			}
			dbo.commit();
			logger.info("插入渠道服务权限记录成功");
		}
		//取消
		else if(optType.equals("2")) {
			//删除渠道服务权限记录
			int count = svcAuthDao.deleteChlSvcAuth(svrAuthTemp);
			if (count!=1) {
				dbo.rollback();
				logger.error("删除渠道服务权限记录失败");
				throw new DeleteSvrAuthFailException();
			}
			dbo.commit();
			logger.info("删除渠道服务权限记录成功");
		}
		//停用
		if(optType.equals("3")) {
			//更新渠道服务权限记录状态为1
			svrAuthTemp.setStatus("1");
			int count = svcAuthDao.updateChlSvcAuth(svrAuthTemp);
			if (count!=1) {
				dbo.rollback();
				logger.error("更新渠道服务权限记录状态为1失败"); 
				throw new ApUpdateFailException("渠道服务权限记录");
			}
			dbo.commit();
			logger.info("更新渠道服务权限记录状态为1成功");
		}
		//启用
		else if(optType.equals("4")) {
			//更新渠道服务权限记录状态为0
			svrAuthTemp.setStatus("0");
			int count = svcAuthDao.updateChlSvcAuth(svrAuthTemp);
			if (count!=1) {
				dbo.rollback();
				logger.error("更新渠道服务权限记录状态为0失败");
				throw new ApUpdateFailException("渠道服务权限记录");
			}
			dbo.commit();
			logger.info("更新渠道服务权限记录状态为0成功");
		}
	}

	/**
	 * 插入渠道服务权限审批记录
	 * @param seriNo 流水号
	 * @param crtDate 操作日期
	 * @param crtTime 操作时间
	 * @param crtBrNo 操作行所
	 * @param crtTlr 操作柜员
	 * @param sysId 系统标识
	 * @param svcOutCode 对外发布服务码
	 * @param scnOutCode 对外发布场景码
	 * @param optType 操作类型
	 * @return 
	 *
	 */
	public synchronized void addChlSvcAuthInsertOper(String seriNo,String crtDate,String crtTime,String crtBrNo,String crtTlr, String sysId, 
			String chnlCode, String svcOutCode, String scnOutCode, String optType){
		
		ChlInfo chlInfo = CheckChlSvc(sysId, chnlCode, svcOutCode, scnOutCode, optType);
		
		//检查是否存在渠道服务权限审批记录
		ChlSvcAuthOper svrAuthOper = svcAuthOperDao.queryChlSvcAuthOper(sysId,svcOutCode,scnOutCode);
		if(null != svrAuthOper) {
			logger.error("该系统标识及对应服务场景码信息存在已申请未审核记录");
			throw new SvrAuthOperExistException(svrAuthOper.getSeriNo());
		}
		//插入渠道服务权限审批记录
		ChlSvcAuthOper svrAuthTemp = new ChlSvcAuthOper();
		svrAuthTemp.setSeriNo(seriNo);
		svrAuthTemp.setCrtDate(crtDate);
		svrAuthTemp.setCrtTime(crtTime);
		svrAuthTemp.setCrtBrNo(crtBrNo);
		svrAuthTemp.setCrtTlr(crtTlr);
		svrAuthTemp.setSysId(sysId);
		svrAuthTemp.setChnlCode(chlInfo.getChnlCode());
		svrAuthTemp.setChnlName(chlInfo.getChnlName());
		svrAuthTemp.setSvcOutCode(svcOutCode);
		svrAuthTemp.setScnOutCode(scnOutCode);
		svrAuthTemp.setOptType(optType);
		svrAuthTemp.setAudStatus("0");
		int count = svcAuthOperDao.insertChlSvcAuthOper(svrAuthTemp);
		if (count!=1) {
			dbo.rollback();
			logger.error("插入渠道服务权限审批记录失败"); 
			throw new ApInsertFailException("渠道服务权限审批记录");
		}
		dbo.commit();
		logger.info("插入渠道服务权限审批记录成功");
	}



	/**
	 * 分页查询渠道访问服务记录
	 * @param curpage 页码
	 * @param pageSize 页大小
	 * @param sysId 系统标识
	 * @param svcOutCode 对外发布服务码
	 * @param scnOutCode 对外发布场景码
	 * @param svrType 服务类型
	 * @return 渠道访问服务待审批记录
	 *
	 */
	public Map<String, Object> getChlSvcAuthList(int curpage, int pageSize, String sysId, String svcOutCode, String scnOutCode) {
		//检验参数
		if(pageSize<1) {
			logger.error("渠道信息记录每页查询记录数不可小于1"); 
			throw new ApIllegalParamException("maxnum");
		}
		
		Map<String, Object> result = new HashMap<>();
		IPage<Map<String, Object>> iPage = svcAuthDao.getChlSvcAuth(curpage, pageSize, sysId, svcOutCode, scnOutCode);
		
		if(iPage.getSize() == 0) {
			logger.error("查询结果为空"); 
			throw new ApSelectNotFoundException("渠道信息记录");
		}
		
		result.put("rowcnt", iPage.getTotal());
		result.put("listnm", iPage.getSize());
		result.put("service_list", iPage.getRecords());
		return result;
	}

	/**
	 * 分页查询渠道访问服务待审批记录
	 * @param curpage 页码
	 * @param pageSize 页大小
	 * @param sysId 系统标识
	 * @param beginDate 起始日期
	 * @param endDate 截止日期
	 * @param optType 操作类型
	 * @param audStatus 审批状态
	 * @return 渠道访问服务待审批记录
	 *
	 */
	public Map<String, Object> getChlSvcAuthOperList(int curpage, int pageSize, String sysId, String chnlCode, String beginDate, String endDate, 
			String optType, String audStatus) {
		//检验参数
		if(pageSize<1) {
			logger.error("渠道信息待审批记录每页查询记录数不可小于1"); 
			throw new ApIllegalParamException("maxnum");
		}
		
		Map<String, Object> result = new HashMap<>();
		IPage<Map<String, Object>> iPage = svcAuthOperDao.getChlSvcAuthOper(curpage, pageSize, sysId, chnlCode, beginDate, endDate, optType, audStatus);
		
		if(iPage.getSize() == 0) {
			logger.error("查询结果为空");  
			throw new ApSelectNotFoundException("渠道信息待审批记录");
		}
		
		result.put("rowcnt", iPage.getTotal());
		result.put("listnm", iPage.getSize());
		result.put("oper_list", iPage.getRecords());
		return result;
	}

	/**
	 * 插入渠道服务权限记录
	 * @param seriNo 流水号
	 * @param audDate 审核日期
	 * @param audTime 审核时间
	 * @param audStatus 审核状态
	 * @param audRemark 审核意见
	 * @param audBrNo 审核行所
	 * @param audTlr 审核柜员
	 */
	public void addChlSvcAuthInsert(String seriNo,String audDate,String audTime,String audStatus, String audRemark,String audTlr, String audBrNo){
		
		//检查参数是否合格
		if(!"1".equals(audStatus)&&!"2".equals(audStatus)) {
			logger.error("渠道服务审核操作参数出错"); 
			throw new ApIllegalParamException("audstatus");
		}
		//检查并更新渠道服务权限审批记录
		ChlSvcAuthOper svrAuthOper = checkChlSvcAuthOper(seriNo,audDate,audTime,audStatus, audRemark,audTlr, audBrNo);
		//同意审批操作
		if(audStatus.equals("1")) {
			UpdateChlSvcAuth(svrAuthOper.getSysId(),svrAuthOper.getChnlCode(),svrAuthOper.getSvcOutCode(),
					svrAuthOper.getScnOutCode(),svrAuthOper.getOptType());
		}
		else 
			dbo.commit();
	}
	
	public synchronized ChlSvcAuthOper checkChlSvcAuthOper(String seriNo,String audDate,String audTime,String audStatus, String audRemark,String audTlr, String audBrNo) {
		//检查是否已经通过渠道服务权限审批记录
		ChlSvcAuthOper svrAuthOper = svcAuthOperDao.queryChlSvcAuthOperBySeriNo(seriNo);
		if(!"0".equals(svrAuthOper.getAudStatus())) {
			logger.error("渠道服务权限审批记录已经审批");
			throw new SvrAuthAlreadyAuditException(svrAuthOper.getSeriNo());
		}
		//检查审批人是否为申请人
		if(svrAuthOper.getCrtTlr().equals(audTlr)) {
			logger.error("审批人不能为申请人");
			throw new ProcessErrorException("审批人不能为申请人:申请["+svrAuthOper.getCrtTlr()+"],审批["+audTlr+"]");
		}
		
		svrAuthOper.setAudDate(audDate);
		svrAuthOper.setAudTime(audTime);
		svrAuthOper.setAudStatus(audStatus);
		svrAuthOper.setAudRemark(audRemark);
		svrAuthOper.setAudTlr(audTlr);
		svrAuthOper.setAudBrNo(audBrNo);
		//更新渠道服务权限审批记录
		int result = svcAuthOperDao.updateChlSvcAuthOper(svrAuthOper);
		if (result!=1) {
			dbo.rollback();
			logger.error("更新渠道服务权限审批记录失败"); 
			throw new ApUpdateFailException("渠道服务权限审批记录");
		}
		dbo.commit();
		logger.info("更新渠道服务权限审批记录成功");
		return svrAuthOper;
	}
	
	
	/**
	 * 根据流水号,删除渠道服务权限审批表
	 * @param serino 流水号
	 */
	public void removeChlSvcAuthOper(String serino) {
		int count = svcAuthOperDao.deleteChlSvcAuthOper(serino);
		if (count != 1) {
			dbo.rollback();
			logger.error("数据删除失败");
			throw new DeleteSvrAuthFailException("数据删除失败");
		}else {
			dbo.commit();
			logger.info("数据删除成功");
		}	
	}
}
