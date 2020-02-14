package cn.com.agree.huanan.ap.al.csiusr.tellerSchedule.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.branch.po.Branch;
import cn.com.agree.huanan.ap.al.csiusr.entduty.po.Entduty;
import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerInfo;
import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerLog;
import cn.com.agree.huanan.ap.al.csiusr.tellerSchedule.dao.TellerScheduleDao;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 柜员调出服务层
 * @author xzf
 */
@Service
public class TellerScheduleService {
	@Autowired DbOperator dbo;
	@Autowired TellerScheduleDao tellerscheduleDao;
	@Autowired Logger logger;
	private Map<String, Object> resultMap=new HashMap<>();
	/**
	 * 柜员调出预受理处理
	 * @return
	 */
	public Map<String, Object> schedule() {
		
		//执行定时查询任务-柜员操作流水表 --调出日期为：当天系统日期 --服务id为：CSISU02006 --状态为：0-待处理
		List<TellerLog> tellerLogList=findByAdjdateSvridAndTransstatus();
		if(tellerLogList==null) {
			//没有符合条件的操作
			return resultMap;
		}
		for(TellerLog tellerLog:tellerLogList) {
			String chgtellerno=tellerLog.getChgTellerNo();//变更柜员
			String chgtellernobrno=tellerLog.getChgTellernoBrno();//变更柜员所属机构
			logger.info("检查校验 "+chgtellerno+":"+chgtellernobrno);
			//检查校验 --柜员综合业务系统签到状态必须为：0-签退 --机构状态必须为：1-有效 --柜员状态为2空岗
			List<Branch> branches=check(chgtellerno,chgtellernobrno);
			if(branches==null) {
				//没有符合校验条件的机构信息
				continue;
			}
			//调出柜员自动调入到调入网点
			//更新柜员所属机构信息
			updateTellerInfo(branches, chgtellerno);
			
			//更新柜员流水操作表处理结果为已处理
			updateTellerLog(tellerLog);
		}
		if(resultMap==null) {
			resultMap.put("statusCode",0);
			resultMap.put("statusInfo","成功");
		}
		return resultMap;
	}
	
	private Map<String, Object> setError(Map<String, Object> resultMap, String msg) {
		msg=StringUtils.isEmpty(msg)?"":msg;
		resultMap.put("statusCode",1);
		resultMap.put("statusInfo","调度失败 "+msg);
		return resultMap;
	}
	/**
	 * 更新csis_tellerlog-柜员操作流水表处理结果为:1-已处理
	 * @param tellerLog
	 */
	private void updateTellerLog(TellerLog tellerLog) {
		String serialno=tellerLog.getSerialNo();
		String transstatus="1";
		int row=tellerscheduleDao.upDateBySerialNo(serialno, transstatus);
		if(row!=1) {
			//更新数据失败
			setError(resultMap,"更新柜员操作流水表失败");
			logger.info("更新柜员操作流水表失败"+serialno);
			dbo.rollback();
		}
		dbo.commit();
	}
	
	/**
	 * 校验通过后将被调出柜员自动调入到调入网点更新柜员所属机构信息（取csis_tellerlog的tellerbrno-调动机构取其分行、支行）：zoneno-分行号、mbrno-支行号、brno-网点号，
	 * @param tellerBrno
	 * @param zoneno
	 * @param mbrno
	 * @param brno
	 */
	private void updateTellerInfo(List<Branch> branches,String tellerNo) {
//		String tellerBrno=tellerLog.getTellerBrNo();//调动机构
		String zoneno=null;//操作地区号
		String mbrno=null;//操作支行号
		String brno=null;//操作网点号
		for(Branch branch:branches) {
			if("1".equals(branch.getType())) {
				zoneno=branch.getBrno();
			}
			if("2".equals(branch.getType())) {
				mbrno=branch.getBrno();
			}
			if("3".equals(branch.getType())) {
				brno=branch.getBrno();
			}
		}
		//查询柜员综合业务系统为签退(存在一人多网点)
		List<TellerInfo> tellerInfo=checkTellerInfo(tellerNo);
		for(TellerInfo t:tellerInfo) {
			//查询机构状态为有效
			List<Branch> branchesOut=checkBranch(t.getBrNo());
			//检查调出实体岗位状态为空岗
			branchesOut=checkEntduty(tellerNo,branchesOut);
//			String zonenoFrom=null;//地区号
			String mbrnoFrom=null;//支行号
			String brnoFrom=null;//网点号
			for(Branch b:branchesOut) {
//				if("1".equals(b.getType())) {
//					zonenoFrom=b.getBrno();
//				}
				if("2".equals(b.getType())) {
					mbrnoFrom=b.getBrno();
				}
				if("3".equals(b.getType())) {
					brnoFrom=b.getBrno();
				}
			}
			//查找修改内容是否已存在
			List<TellerInfo> tellers=findByTellerNoAndBrno(tellerNo, brno);
			if(tellers.size()!=0) {
				//此数据已有，主键不能重复
				break;
			}
			if(!mbrnoFrom.equals(mbrno)) {
				//柜员存在一人多网点注册关系，不允许跨分行调出
				continue;
			}
			int row=tellerscheduleDao.upDateByTellerNo(brnoFrom, tellerNo, zoneno, mbrno, brno);
			if(row<1) {
				//更新数据失败
				setError(resultMap,"更新柜员表失败"+tellerNo);
				logger.info("更新柜员表失败"+tellerNo);
				dbo.rollback();
			}
			dbo.commit();
		}
		
	}
	
	/**
	 * 执行定时任务查询csis_tellerlog-柜员操作流水表：adjdate-调出日期为：当天系统日期、svrid-服务id为：CSISU02006、transstatus-状态为：0-待处理的记录。
	 * @return
	 */
	private List<TellerLog> findByAdjdateSvridAndTransstatus() {
//		String nowDate=DateTimeUtil.getSysDate();
		String nowDate="20190918";
		String svrId="CSISU02006";
		String transStatus="0";
		List<TellerLog> tellerLogList=tellerscheduleDao.queryByAdjdateSvridAndTransstatus(nowDate,svrId,transStatus);
		return tellerLogList;
	}
	
	/***
	 * 检查：柜员综合业务系统签到状态必须为：0-签退、柜员状态为空岗（在调出机构没有挂对应的实体岗）、状态必须为：1-有效。
	 * @param tellerLog
	 * @param req
	 */
	private List<Branch> check(String chgtellerno,String chgtellernobrno) {
		//检查柜员综合业务系统为签退(存在一人多网点)
		List<TellerInfo> tellerInfo=checkTellerInfo(chgtellerno);
		if(tellerInfo==null) {
			//找不到柜员信息或者状态为签退
			return null;
		}
		//检查机构状态为有效
		List<Branch> branches=checkBranch(chgtellernobrno);
		if(branches==null) {
			//找不到机构信息或者状态为无效
			return null;
		}
		//检查调入实体岗位状态为空岗
		branches=checkEntduty(chgtellerno,branches);
		
		if(branches==null) {
			//找不到实体岗位状态为空岗
			return null;
		}
		return branches;
	}
	
	private List<Branch> checkEntduty(String chgtellerno, List<Branch> brno) {
		String status=null;
		List<Branch> branch=new ArrayList<>();
		// 检查实体岗位是否空岗
		for(Branch br:brno) {
			if("3".equals(br.getType())) {
				//网点
				status=findByTellernoAndBrno(chgtellerno,br.getBrno(),3);
			}
			if("2".equals(br.getType())) {
				//支行
				status=findByTellernoAndBrno(chgtellerno,br.getBrno(),2);
			}
			if("1".equals(br.getType())) {
				//分行
				status=findByTellernoAndBrno(chgtellerno,br.getBrno(),1);
			}
			if(!"1".equals(status)) {
				//不为在岗
				branch.add(br);
			}
		}
		return branch;
	}
	
	private List<TellerInfo> checkTellerInfo(String chgtellerno) {
		List<TellerInfo> newtellerInfo=new ArrayList<>();
		// 查找柜员信息的状态
		List<TellerInfo> tellerInfo=findByTellerNo(chgtellerno);
		if(tellerInfo==null) {
			return null;
		}
		for(TellerInfo t:tellerInfo) {
			if("0".equals(t.getLoginStatus())) {
				//签退状态
				newtellerInfo.add(t);
			}
		}
		return newtellerInfo;
	}
	
	private List<Branch> checkBranch(String chgtellernobrno) {
		List<Branch> brno=new ArrayList<>();
		//查找机构
		Branch branch=finByBrno(chgtellernobrno);
		if(StringUtils.isEmpty(branch))
			return null;
		if("1".equals(branch.getBrsta())) {
			//有效
			brno.add(branch);
		}
		if("3".equals(branch.getType())) {
			//查找上级机构（支行，分行，总行）
			branch=finByBrno(branch.getUpBrno());
			if(StringUtils.isEmpty(branch))
				return null;
			if("1".equals(branch.getBrsta())) {
				//有效
				brno.add(branch);
			}
		}
		if("2".equals(branch.getType())) {
			//查找上级机构（分行，总行）
			branch=finByBrno(branch.getUpBrno());
			if(StringUtils.isEmpty(branch))
				return null;
			if("1".equals(branch.getBrsta())) {
				//有效
				brno.add(branch);
			}
		}
		if("1".equals(branch.getType())) {
			//查找上级机构（总行）
			branch=finByBrno(branch.getUpBrno());
			if(StringUtils.isEmpty(branch))
				return null;
			if("1".equals(branch.getBrsta())) {
				//有效
				brno.add(branch);
			}
		}
		return brno;
	}
	
	private Branch finByBrno(String chgtellernobrno) {
		return tellerscheduleDao.queryByBrno(chgtellernobrno);
	}
	
	private String findByTellernoAndBrno(String tellerno,String brno,int i) {
		Entduty entDuty=tellerscheduleDao.queryByTellernoAndBrno(tellerno,brno,i);
		if(entDuty==null) {
			return null;
		}
		return entDuty.getStatus();
	}
	private List<TellerInfo> findByTellerNo(String tellerNo) {
		List<TellerInfo> tellerInfo=tellerscheduleDao.queryByTellerNo(tellerNo);
		if(tellerInfo==null) {
			return null;
		}
		return tellerInfo;
	}
	
	private List<TellerInfo> findByTellerNoAndBrno(String tellerNo,String Brno){
		return tellerscheduleDao.queryByTellerNoAndBrno(tellerNo,Brno);
	}
}
