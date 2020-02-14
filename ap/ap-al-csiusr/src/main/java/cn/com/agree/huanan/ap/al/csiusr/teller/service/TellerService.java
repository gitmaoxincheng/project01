package cn.com.agree.huanan.ap.al.csiusr.teller.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;

import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.huanan.ap.al.csiusr.branch.dao.BranchDao;
import cn.com.agree.huanan.ap.al.csiusr.branch.exception.BranchNotFoundException;
import cn.com.agree.huanan.ap.al.csiusr.branch.po.Branch;
import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.dao.DevInfoDao;
import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po.DevInfo;
import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.dao.DutyinfoDao;
import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.exception.DutyMobmktException;
import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.po.DutyInfo;
import cn.com.agree.huanan.ap.al.csiusr.entduty.dao.EntdutyDao;
import cn.com.agree.huanan.ap.al.csiusr.entduty.exception.CheckNoDataException;
import cn.com.agree.huanan.ap.al.csiusr.entduty.exception.EntdutyEmptyException;
import cn.com.agree.huanan.ap.al.csiusr.entduty.exception.EntdutyNotExistException;
import cn.com.agree.huanan.ap.al.csiusr.entduty.exception.EntdutyOnException;
import cn.com.agree.huanan.ap.al.csiusr.entduty.po.Entduty;
import cn.com.agree.huanan.ap.al.csiusr.exitbrno.dao.ExitBrnoDao;
import cn.com.agree.huanan.ap.al.csiusr.exitbrno.exception.ExitBrnoAddFailException;
import cn.com.agree.huanan.ap.al.csiusr.exitbrno.exception.ExitBrnoUpdateFailException;
import cn.com.agree.huanan.ap.al.csiusr.exitbrno.po.ExitBrno;
import cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.dao.ExitCtrlDtsyDao;
import cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.po.ExitCtrlDtsy;
import cn.com.agree.huanan.ap.al.csiusr.exittellerno.dao.ExitTellerNoDao;
import cn.com.agree.huanan.ap.al.csiusr.exittellerno.exception.ExitTellerAddFailException;
import cn.com.agree.huanan.ap.al.csiusr.exittellerno.exception.ExitTellerDelFailException;
import cn.com.agree.huanan.ap.al.csiusr.exittellerno.exception.ExitTellerNotFinishedException;
import cn.com.agree.huanan.ap.al.csiusr.exittellerno.po.ExitTellerNo;
import cn.com.agree.huanan.ap.al.csiusr.mutitable.dao.EntdutyMutiDao;
import cn.com.agree.huanan.ap.al.csiusr.mutitable.dao.TellerMutiDao;
import cn.com.agree.huanan.ap.al.csiusr.parasyn.dao.ParasynDao;
import cn.com.agree.huanan.ap.al.csiusr.parasyn.po.Parasyn;
import cn.com.agree.huanan.ap.al.csiusr.purp.dao.PurpDao;
import cn.com.agree.huanan.ap.al.csiusr.purp.exception.tellerLoginRandomGenException;
import cn.com.agree.huanan.ap.al.csiusr.purp.po.Purp;
import cn.com.agree.huanan.ap.al.csiusr.staffinfo.dao.StaffInfoDao;
import cn.com.agree.huanan.ap.al.csiusr.staffinfo.po.StaffInfo;
import cn.com.agree.huanan.ap.al.csiusr.teller.dao.TellerDao;
import cn.com.agree.huanan.ap.al.csiusr.teller.dao.TellerLogDao;
import cn.com.agree.huanan.ap.al.csiusr.teller.dao.TellerSysDao;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.CheckedNoDataError;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.LastTellerCallOutException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.NotUpdateTellerException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerAddFailException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerBranchNotSubjectionException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerCallOutException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerDelFailException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerExistMulBrno;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerLoginException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerModifyException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerNotExistException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerSysAddFailException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerSysNotExistException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerTheSameException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerTmpExitFailException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerTransException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerTransOperFlagException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerUpdateError;
import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerInfo;
import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerLog;
import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerSys;
import cn.com.agree.huanan.ap.al.csiusr.teller.vo.TellerVO;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

/**
 * 柜员服务层
 * @author HCP
 */
@Service
public class TellerService {
	@Autowired PurpDao purpDao;
	@Autowired TellerDao tellerDao;
	@Autowired TellerLogDao tellerLogDao;
	@Autowired TellerSysDao tellerSysDao;
	@Autowired EntdutyDao entdutyDao;
	@Autowired DutyinfoDao dutyinfoDao;
	@Autowired BranchDao branchDao;
	@Autowired StaffInfoDao staffInfoDao;
	@Autowired ExitTellerNoDao exitTellerNoDao;
	@Autowired ExitCtrlDtsyDao exitCtrlDtsyDao;
	@Autowired ExitBrnoDao exitBrnoDao;
	@Autowired TellerMutiDao tellerMutiDao;
	@Autowired EntdutyMutiDao entdutyMutiDao;
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	@Autowired DevInfoDao devInfoDao;
	@Autowired ParasynDao parasynDao;

	public TellerInfo getTellerByNo(String tellerNo) {
		List<TellerInfo> tellerInfoList = tellerDao.selectTellerByTellerNo(tellerNo);
		TellerInfo tellerInfo = new TellerInfo();
		if (null == tellerInfoList || 0 == tellerInfoList.size()) {
			tellerInfo = null;
		} else {
			tellerInfo = tellerInfoList.get(0);
		}
		return tellerInfo;
	}
	
	public TellerInfo getTellerInfoByNo(String tellerNo, String brNo) {
		TellerInfo tellerInfo = tellerDao.queryTellerByNo(tellerNo, brNo);
		return tellerInfo;
	}
	
	public List<Entduty> getEntdutyByTellerNo(String tellerNo) {
		List<Entduty> entdutyList = entdutyDao.queryEntdutysByTellerNo(tellerNo, "1");
		return entdutyList;
	}
	
	public void addTeller(TellerInfo tellerInfo) {
		int count =tellerDao.insertTeller(tellerInfo);
		if (count != 1 ) {
			throw new TellerAddFailException("新增柜员失败");
		}
	}
	
	/**
	 * 登录检查服务
	 * @param strtellerno	柜员号
	 * @param checkpwdmode  支持验密方式 0-密码 1-指纹 2-声纹 3-生物认证
	 * @param dctlra 认证值
	 * @param mybank 法人号
	 * @param strbrno 登陆机构号
	 * @param entdutyno 登陆实体岗编号
	 */
	public Map<String, Object> loginCheck(String strtellerno,String checkpwdmode,String sysid,String mybank,String strbrno,String entdutyno,boolean mobmktflg){
		
		if (StringUtils.isEmpty(sysid)) {
			sysid = "0005";
		}

		Map<String, Object> resultMap = new HashMap<>();

		logger.info("----------柜员是否存在----------");
		List<TellerInfo> tellerInfoList = tellerDao.selectTellerByTellerNo(strtellerno);
		if (null == tellerInfoList || tellerInfoList.size() < 0) {
			throw new TellerNotExistException(strtellerno);
		} 
		
		logger.info("----------检查柜员是否注册综合业务系统----------");
		TellerSys tellerSys = tellerSysDao.queryTellerSys(strtellerno, sysid);
		if(null == tellerSys) {
			throw new TellerSysNotExistException("柜员未注册综合业务系统");		
		}
		
		logger.info("----------柜员是否上岗----------");
		List<Entduty> entdutyList = entdutyDao.queryEntdutysByTellerNo(strtellerno,"1");
		if (null == entdutyList || entdutyList.size() == 0) {
			throw new EntdutyEmptyException("柜员为未上岗状态");	
		}

		Map<String, Object> map = tellerMutiDao.queryLoginTellerList(strtellerno,strbrno);
//		if (null == map || map.size() == 0 || null == map.get("rowcnt") || "0".equals(String.valueOf(map.get("rowcnt"))) ) {
//			throw new TellerNotExistException(strtellerno);			
//		}
		
		int rowcnt = Integer.parseInt(String.valueOf(map.get("rowcnt")));
		List<Map<String, Object>> list = (List<Map<String, Object>>)map.get("list");

		//一人多岗
		if (rowcnt > 1) {
			logger.info("----------一人多岗----------");
			List<TellerVO> bodrcd_list = new ArrayList<>();
			
			if (!mobmktflg) {
				for (Map<String, Object> teller : list) {
					
					TellerVO vo = new TellerVO();
					Branch branch = branchDao.queryBranchByNo(String.valueOf(teller.get("brNo")));
					if (null == branch || !"0".equals(branch.getBrgp())) {
						throw new TellerLoginException("柜员所属机构" + String.valueOf(teller.get("brNo")) + "信息有误");
					}
					if (StringUtils.isEmpty(branch.getBrsta()) || "0".equals(branch.getBrsta())) {
						throw new TellerLoginException("柜员所属机构" + String.valueOf(teller.get("brNo")) + "状态无效");
					}
					Entduty entduty = entdutyDao.queryEntdutyByCond(strtellerno, String.valueOf(teller.get("brNo")));
					DutyInfo dutyInfo = dutyinfoDao.queryByDutyNo(entduty.getDutyNo());
					vo.setBrno(String.valueOf(teller.get("brNo")));
					vo.setBrnoname(branch.getBrna());
					vo.setDutyno(dutyInfo.getDutyNo());
					vo.setDutyname(dutyInfo.getDutyName());
					vo.setEntdutyno(entduty.getEntDutyNo());
					vo.setEntdutyname(entduty.getEntDutyName());
					vo.setMybank(String.valueOf(teller.get("myBank")));
					bodrcd_list.add(vo);
				}
				
				resultMap.put("rowcnt", list.size());
				resultMap.put("bodrcd_list", bodrcd_list);
				return resultMap;
			}else {
				
				logger.info("-----------移动营销登录--------------");
				for (Map<String, Object> teller : list) {
					
					TellerVO vo = new TellerVO();
					Entduty entduty = entdutyDao.queryEntdutyByCond(strtellerno, String.valueOf(teller.get("brNo")));
					DutyInfo dutyInfo = dutyinfoDao.queryByDutyNo(entduty.getDutyNo());
					logger.info("-----------移动营销登录dutyInfo--------------"+dutyInfo);
					if (null == dutyInfo || StringUtils.isEmpty(dutyInfo.getMobmktflg()) || "0".equals(dutyInfo.getMobmktflg())) {
						continue;
					}
				
					Branch branch = branchDao.queryBranchByNo(String.valueOf(teller.get("brNo")));
					if (null == branch || !"0".equals(branch.getBrgp())) {
						throw new TellerLoginException("柜员所属机构" + String.valueOf(teller.get("brNo")) + "信息有误");
					}
					if (StringUtils.isEmpty(branch.getBrsta()) || "0".equals(branch.getBrsta())) {
						throw new TellerLoginException("柜员所属机构" + String.valueOf(teller.get("brNo")) + "状态无效");
					}
					vo.setBrno(String.valueOf(teller.get("brNo")));
					vo.setBrnoname(branch.getBrna());
					vo.setDutyno(dutyInfo.getDutyNo());
					vo.setDutyname(dutyInfo.getDutyName());
					vo.setEntdutyno(entduty.getEntDutyNo());
					vo.setEntdutyname(entduty.getEntDutyName());
					vo.setMybank(String.valueOf(teller.get("myBank")));
					vo.setVchBoxNo1(entduty.getVchBoxNo1());
					vo.setCshBoxNo1(entduty.getCshBoxNo1());
					bodrcd_list.add(vo);
				}
				
				if (bodrcd_list.size() > 1) {
					resultMap.put("rowcnt", list.size());
					resultMap.put("bodrcd_list", bodrcd_list);
					return resultMap;
				}else if(bodrcd_list.size() == 1){
					
					TellerVO tmpVO =  bodrcd_list.get(0);
					strbrno = tmpVO.getBrno();
					
					String vchBoxNo1 = tmpVO.getVchBoxNo1();
					String cshBoxNo1 = tmpVO.getCshBoxNo1();
					
					resultMap.put("vchBoxNo1", vchBoxNo1);
					resultMap.put("cshBoxNo1", cshBoxNo1);
				}else {
					throw new TellerLoginException("柜员不是移动营销柜员");		
				}
			}
		}
		
		if (StringUtils.isEmpty(strbrno)) {
			strbrno = String.valueOf(list.get(0).get("brNo"));
		}
		
		// 综合后管同步登记机构合并
		List<Parasyn> parasynList = parasynDao.queryByBrNoAndOptType(strbrno, "6");
		if (null != parasynList && 1 == parasynList.size()) {
			String currDate = DateTimeUtil.getSysDate();
			String brDateString = parasynList.get(0).getBrDate();
			int date =  Integer.parseInt(brDateString) - Integer.parseInt(currDate);
			if (date >= 0) {
				throw new TellerLoginException(strbrno + "机构合并");
			}
		} else if (parasynList.size() > 1) {
			throw new TellerLoginException("综合后管同步数据异常");
		}
		
		resultMap.put("strbrno", strbrno);
		
		Branch branch = branchDao.queryBranchByNo(strbrno);
		if (null != branch && "0".equals(branch.getType())) {
			
		}else {
			logger.info("----------检查柜员所属机构状态----------");
			if (null == branch || !"0".equals(branch.getBrgp())) {
				throw new TellerLoginException("柜员所属机构" + strbrno + "信息有误");
			}
			if (StringUtils.isEmpty(branch.getBrsta()) || "0".equals(branch.getBrsta())) {
				throw new TellerLoginException("柜员所属机构" + strbrno + "状态无效");
			}
		}

		Entduty entduty = null;
		if (!StringUtils.isEmpty(entdutyno)) {
			entduty = entdutyDao.queryEntdutyByEntdutyNo(entdutyno);
		}else {
			entduty = entdutyList.get(0);
		}
		logger.info("----------检查柜员上岗类型----------");
		DutyInfo dutyInfo = dutyinfoDao.queryByDutyNo(entduty.getDutyNo());
		
		if (!mobmktflg) {
			
			if (null == dutyInfo || StringUtils.isEmpty(dutyInfo.getMobmktflg()) || "1".equals(dutyInfo.getMobmktflg())) {
				throw new DutyMobmktException("柜员上岗类型为移动营销岗，无法登录");	
			}
		}else {

			if (null == dutyInfo || StringUtils.isEmpty(dutyInfo.getMobmktflg()) || "0".equals(dutyInfo.getMobmktflg())) {
				throw new DutyMobmktException("柜员上岗类型要移动营销岗才能登录");	
			}
		}
		
		return resultMap;
	}
	
	/**
	 * 登录整理数据
	 * @param strtellerno 柜员号
	 * @param strbrno 机构号
	 * @return
	 */
	public Map<String, Object> login(String strtellerno,String strbrno){
		
		Map<String, Object> resultMap = new HashMap<>();
		Entduty entduty = entdutyDao.queryEntdutyByCond(strtellerno,strbrno);
		
		TellerInfo tellerInfo = tellerDao.queryTellerByNo(strtellerno,strbrno);
		resultMap.put("zoneno", tellerInfo.getZoneNo());
		resultMap.put("zonenoname", branchDao.queryBranchByNo(tellerInfo.getZoneNo()).getBrna());
		resultMap.put("mbrno", tellerInfo.getMBrNo());
		resultMap.put("mbrnoname", branchDao.queryBranchByNo(tellerInfo.getMBrNo()).getBrna());
		resultMap.put("brno", strbrno);
		resultMap.put("brnoname", branchDao.queryBranchByNo(strbrno).getBrna());
		resultMap.put("tellerno", strtellerno);
		resultMap.put("tellernoname", tellerInfo.getName());
		resultMap.put("cshboxno", entduty.getCshBoxNo1());
		resultMap.put("vchboxno", entduty.getVchBoxNo1());
		resultMap.put("dutyno", entduty.getDutyNo());
		resultMap.put("dutyname", dutyinfoDao.getEntdutyName(entduty.getDutyNo()));
		resultMap.put("entdutyno", entduty.getEntDutyNo());
		resultMap.put("entdutyname", entduty.getEntDutyName());
		resultMap.put("mybank", tellerInfo.getMyBank());
		resultMap.put("sysworkdate", DateTimeUtil.getSysDate());
		resultMap.put("pstatus", "1");
		resultMap.put("rowcnt", "1");
		resultMap.put("cashflg", dutyinfoDao.queryByDutyNo(entduty.getDutyNo()).getCashFlg());
		
		return resultMap;
	}
	
	/**
	 * 柜员调动查询
	 * @param strTellerNo 柜员号
	 * @return 岗位信息记录
	 */
	public Map<String, Object> tellerTransCheck(String strTellerNo, String brNo) {
		List<Map<String, Object>> bodrcd_list = new ArrayList<>();
		String operFlag;
		int listnm;
		
		// 柜员信息是否存在
		TellerInfo tellerInfo = tellerDao.queryTellerByNo(strTellerNo, brNo);
		if (null == tellerInfo) {
			throw new TellerNotExistException(strTellerNo);
		}
		
		// 判断柜员上岗或撤岗
		List<Entduty> entdutyList = entdutyDao.queryEntdutyByTelNoAndBrNo(strTellerNo, brNo, "1");
		if (1 == entdutyList.size()) {
			operFlag = "E";
			listnm = 1;
		} else if (0 == entdutyList.size()) {
			operFlag = "A";
			// 操作机构空岗位查询
			entdutyList = entdutyDao.queryEntdutyBybrNo(tellerInfo.getBrNo(),"2");
			listnm = entdutyList.size();
		} else {
			throw new TellerTransException(strTellerNo + "柜员在" + brNo + "有多个岗位");
		}
		
		for (Entduty entduty : entdutyList) {
			Map<String, Object> map = new HashMap<>();
			map.put("entdutyno", entduty.getEntDutyNo());
			map.put("entdutyname", entduty.getEntDutyName());
			bodrcd_list.add(map);
		}
		
		Map<String, Object> result = new HashMap<>();
		result.put("operflag", operFlag);
		result.put("bodrcd_list", bodrcd_list);
		result.put("listnm", listnm);

		return result;
	}
		
	/**
	 * 柜员临时签退
	 * @param strtellerno	柜员号
	 * @param strbrno 登陆机构号
	 */
	public Map<String, Object> tellerTmpExit(String strtellerno,String strbrno){
		Map<String, Object> resultMap = new HashMap<>();
		
		logger.info("----------柜员是否存在----------");
		TellerInfo tellerInfo = tellerDao.queryTellerByNo(strtellerno,strbrno);
		if (null == tellerInfo) {
			throw new TellerNotExistException(strtellerno);			
		}
		
		logger.info("----------柜员临时签退----------");
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("loginstatus", "0");
		paramMap.put("optdate", DateTimeUtil.getSysDate());
		paramMap.put("opttime", DateTimeUtil.getSysTime());
		int count = tellerDao.updateTelInfoByTeNoABrNo(strtellerno, strbrno, paramMap);
		if (count < 1) {
			dbo.rollback();
			throw new TellerTmpExitFailException("柜员临时签退失败");	
		}
		dbo.commit();
		
		return resultMap;
	}
	
	/**
	 * 查找柜员姓名
	 * @param strtellerno 柜员号
	 * @return
	 */
	public StaffInfo getTellerName(String strtellerno) {
		StaffInfo staffInfo = staffInfoDao.queryTellerByNo(strtellerno);
		if (null == staffInfo) {
			throw new TellerAddFailException("注册失败，行员号错误");	
		}
		return staffInfo;
	}
	
	/**
	 * 柜员注册
	 * @param strtellerno	柜员号
	 * @param strsysid 系统标识
	 * @param strbrno 登陆机构号
	 * @param tellertype 柜员类别
	 */
	public void tellerReg(String strtellerno,String strsysid,String strbrno,String tellertype){
		
		String tradeDate = DateTimeUtil.getSysDate();
		String tradeTime = DateTimeUtil.getSysTime();
		logger.info("----------是否存在柜员注册记录----------");
		StaffInfo staffInfo = staffInfoDao.queryTellerByNo(strtellerno);
		Branch brNo = branchDao.queryBranchOfNetWork(strbrno, "0", "1");
		if (null == brNo) {
			throw new BranchNotFoundException(strbrno);	
		}
		TellerInfo dbInfos = tellerDao.queryTellerByNo(strtellerno, strbrno);
		
		if (null == dbInfos) {
			TellerInfo saveInfo = new TellerInfo();
			saveInfo.setTellerNo(strtellerno);
			Branch mBrNo = branchDao.queryBranchByCondBrsta(brNo.getUpBrno(), "1");
			if (null == mBrNo || StringUtils.isEmpty(mBrNo.getType()) || !("2|02|12").contains(mBrNo.getType())) {
				throw new TellerAddFailException("网点没有上级支行");
			}
			
			Branch zoneNo = branchDao.queryBranchByCondBrsta(mBrNo.getUpBrno(), "1");
			if (null == zoneNo || StringUtils.isEmpty(zoneNo.getType()) || !("1|01").contains(zoneNo.getType())) {
				throw new TellerAddFailException("网点没有上级分行");
			}
			saveInfo.setBrNo(strbrno);
			saveInfo.setMBrNo(mBrNo.getBrno());
			saveInfo.setZoneNo(zoneNo.getBrno());
	
			saveInfo.setName(staffInfo.getName());
			saveInfo.setTellerType(tellertype);
			saveInfo.setMangType("3");
			saveInfo.setMyBank(strtellerno.substring(0, 3));
			saveInfo.setOptDate(tradeDate);
			saveInfo.setOptTime(tradeTime);
			saveInfo.setLoginStatus("0");
			saveInfo.setStatus("1");
			int count = tellerDao.insertTeller(saveInfo);
			if (0 == count) {
				dbo.rollback();
				throw new TellerAddFailException("注册失败，保存信息错误");	
			}
		}else {
			Map<String, Object> tellerMap = new HashMap<>();
			tellerMap.put("status", "1");
			tellerMap.put("optdate", tradeDate);
			tellerMap.put("opttime", tradeTime);
			int count1 = tellerDao.updateTelInfoByTeNoABrNo(strtellerno, strbrno, tellerMap);
			if (0 == count1) {
				dbo.rollback();
				throw new TellerAddFailException("注册失败，更新信息错误");	
			}
		}
		
		logger.info("----------是否存在柜员受控系统记录----------");
		TellerSys dbSys = tellerSysDao.selectTellerSys(strtellerno);
		
		if (null == dbSys || StringUtils.isEmpty(dbSys.getSysId()) || !"0005".equals(dbSys.getSysId())) {
			
			TellerSys tellerSys = new TellerSys();
			tellerSys.setTellerNo(strtellerno);
			tellerSys.setSysId(strsysid);
			tellerSys.setStatus("1");
			tellerSys.setOptDate(tradeDate);
			tellerSys.setOptTime(tradeTime);
			tellerSys.setRegistDate(tradeDate);
			int count = tellerSysDao.insertTellerSys(tellerSys);
			if (0 == count) {
				dbo.rollback();
				throw new TellerSysAddFailException("注册失败，保存信息错误");	
			}
		}else {
			
			Map<String, Object> map = new HashMap<>();
			map.put("status", "1");
			map.put("optdate", tradeDate);
			map.put("opttime", tradeTime);
			int count = tellerSysDao.updateTellerInfo(dbSys.getTellerNo(), dbSys.getSysId(), map);
			if (0 == count) {
				dbo.rollback();
				throw new TellerSysAddFailException("注册失败，保存信息错误");	
			}
		}
		dbo.commit();
	}
	
	/**
	 * 柜员一人多网点添加
	 * @param strtellerno	柜员号
	 * @param strbrno 登陆机构号
	 * @param tellertype 柜员类别
	 */
	public Map<String, Object> tellerMultiReg(String strtellerno,String strbrno,String tellertype){
		Map<String, Object> resultMap = new HashMap<>();
		String tradeDate = DateTimeUtil.getSysDate();
		String tradeTime = DateTimeUtil.getSysTime();
		
		logger.info("----------柜员号是否存在----------");
		List<TellerInfo> list = tellerDao.selectTellerByTellerNo(strtellerno);
		if (null == list || 0 == list.size()) {
			throw new TellerNotExistException(strtellerno);			
		}
		
		logger.info("----------网点是否存在----------");
		Branch branch = branchDao.queryBranchOfNetWork(strbrno, "0", "1");
		if (null == branch) {
			throw new BranchNotFoundException(strbrno);	
		}
		
		logger.info("----------虚拟柜员检查----------");
		StaffInfo staffInfo = staffInfoDao.queryTellerByNo(strtellerno);
		if(staffInfo.getTellerType().equals("04")) {
			throw new TellerAddFailException("柜员["+strtellerno+"]为虚拟柜员，不允许注册多网点");
		}
		
		logger.info("----------柜员是否已在此机构注册----------");
		String status = null; 
		TellerInfo tellerInfo = tellerDao.queryTellerByNo(strtellerno,strbrno);
		if (null != tellerInfo) {	
			if ("1".equals(tellerInfo.getStatus())) {
				throw new TellerAddFailException("注册失败，柜员已在此机构注册");		
			} else {
				status = "0";
			}
		}
		
		logger.info("----------柜员是否注册综合业务系统----------");
		TellerSys tellerSys = tellerSysDao.queryTellerSys(strtellerno, "0005");
		if(null == tellerSys) {
			throw new TellerAddFailException("注册失败，柜员未注册综合业务系统");		
		}
		
		logger.info("----------检查分行是否存在----------");
		TellerInfo saveInfo = new TellerInfo();
		saveInfo.setTellerNo(strtellerno);
		saveInfo.setBrNo(strbrno);
		// 检查支行
		Branch mBranch = branchDao.queryBranchByCondBrsta(branch.getUpBrno(), "1");
		if (null == mBranch || StringUtils.isEmpty(mBranch.getType()) || !("2|02|12").contains(mBranch.getType())) {
			throw new BranchNotFoundException("支行:" + branch.getUpBrno());	
		}
		saveInfo.setMBrNo(mBranch.getBrno());
		
		// 检查分行
		Branch zBranch = branchDao.queryBranchByCondBrsta(mBranch.getUpBrno(), "1");
		if (null == zBranch || StringUtils.isEmpty(zBranch.getType()) || !("1|01").contains(zBranch.getType())) {
			throw new BranchNotFoundException("分行:" + mBranch.getUpBrno());	
		}
		saveInfo.setZoneNo(zBranch.getBrno());
		
		logger.info("----------检查是否跨分行添加网点----------");
		String zoneNo = "";
		if (!"0010102301|0019901391".contains(strbrno)) {
			for (TellerInfo teller : list) {
				if (!"0010102301|0019901391".contains(teller.getBrNo())) {
					zoneNo = teller.getZoneNo();
				}
			}
			if (!StringUtils.isEmpty(zoneNo) && !zoneNo.equals(mBranch.getUpBrno())) {
				throw new TellerAddFailException("不能跨分行添加网点");
			}	
		}
		
		if ("0".equals(status)) {
			logger.info("----------更新柜员信息----------");
			Map<String, Object> tellerMap = new HashMap<>();
			tellerMap.put("status", "1");
			tellerMap.put("optdate", tradeDate);
			tellerMap.put("opttime", tradeTime);
			int count1 = tellerDao.updateTelInfoByTeNoABrNo(strtellerno, strbrno, tellerMap);
			if (0 == count1) {
				dbo.rollback();
				throw new TellerAddFailException("注册失败，更新信息错误");	
			}
		} else {
			logger.info("----------插入柜员信息----------");
			saveInfo.setZoneNo(mBranch.getUpBrno());
			saveInfo.setName(list.get(0).getName());
			saveInfo.setTellerType(tellertype);
			saveInfo.setMangType("3");
			saveInfo.setMyBank(strtellerno.substring(0, 3));
			saveInfo.setOptDate(tradeDate);
			saveInfo.setOptTime(tradeTime);
			saveInfo.setStatus("1");
			int count = tellerDao.insertTeller(saveInfo);
			if (0 == count) {
				dbo.rollback();
				throw new TellerAddFailException("注册失败，保存信息错误");	
			}
		}
		
		resultMap.put("tellerno", strtellerno);
		resultMap.put("tellertype", tellertype);
		resultMap.put("name", list.get(0).getName());
		resultMap.put("brno", strbrno);
		resultMap.put("brname", branch.getBrna());
		resultMap.put("realFlag", "1");
		
		return resultMap;
	}
	
	/**
	 * 柜员注销
	 * @param strtellerno	柜员号
	 * @param strbrno 登陆机构号
	 * @param tellertype 柜员类别
	 */
	public void tellerCancel(String strtellerno,String strbrno,String brno){
		String tradeDate = DateTimeUtil.getSysDate();
		String tradeTime = DateTimeUtil.getSysTime();
		List<TellerInfo> list = tellerDao.selectTellerByTellerNo(strtellerno);
		TellerInfo dbInfo = list.get(0);
		
		logger.info("----------更新柜员信息----------");
		Map<String, Object> tellerMap = new HashMap<>();
		tellerMap.put("status", "0");
		tellerMap.put("optdate", tradeDate);
		tellerMap.put("opttime", tradeTime);
		int count1 = tellerDao.updateTelInfoByTeNoABrNo(dbInfo.getTellerNo(), dbInfo.getBrNo(), tellerMap);
		if (0 == count1) {
			dbo.rollback();
			throw new TellerDelFailException("更新信息错误");	
		}
		
		logger.info("----------更新柜员受控系统信息----------");
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("status", "0");
		paramMap.put("optdate", tradeDate);
		paramMap.put("opttime", tradeTime);
		paramMap.put("canceldate", tradeDate);
		
		int count = tellerSysDao.updateTellerInfo(strtellerno, "0005", paramMap);
		if (0 == count) {
			dbo.rollback();
			throw new TellerDelFailException("更新信息错误");	
		}
		dbo.commit();
	}
	
	/**
	 * 柜员岗位调动
	 * @param strTellerNo 变动柜员
	 * @param operFlag 操作类型
	 * @param entdutyNo 实体岗编号
	 * @param tellerNo 操作柜员
	 * @param brNo 操作网点
	 */
	public Map<String, Object> tellerEntdutyTrans(String strTellerNo, String operFlag, String entdutyNo, String tellerNo, String brNo) {

		// 操作柜员与被操作柜员不能相同
		logger.info("----------检查操作柜员与被操作柜员不能相同----------");
		if (tellerNo.equals(strTellerNo)) {
			throw new TellerTheSameException(strTellerNo);
		}
		
		// 只能操作本机构的柜员
		logger.info("----------检查只能操作本机构的柜员----------");
		TellerInfo tellerInfo = tellerDao.queryTellerByNo(strTellerNo, brNo);
		if (null == tellerInfo) {
			throw new TellerBranchNotSubjectionException(strTellerNo);
		}
		
		// 1)若柜员为虚拟柜员，则限制并提示“柜员<柜员号>为虚拟柜员，只能在虚拟岗位上岗”；
		logger.info("----------检查柜员是否为虚拟柜员----------");
		String tellerType = tellerInfo.getTellerType();
		if (tellerType.isEmpty()) {
			throw new TellerTransException(strTellerNo + "柜员的操作员属性不能为空");
		}
		StaffInfo staffInfo = staffInfoDao.queryTellerByNo(strTellerNo);
		if ("04".equals(staffInfo.getTellerType())) {
			throw new TellerTransException("柜员" + strTellerNo + "为虚拟柜员，只能在虚拟岗位上岗");
		}
		
		// 检查调动岗位是否存在
		logger.info("----------检查调动岗位是否存在----------");
		Entduty entduty = entdutyDao.queryEntdutyByEntdutyNo(entdutyNo);
		if (null == entduty) {
			throw new EntdutyNotExistException(entdutyNo);
		}
		
		String dutyno = entduty.getDutyNo();
		DutyInfo dutyInfo = dutyinfoDao.queryByDutyNo(dutyno);
		String bootClass="GY" ;
		if(null != dutyInfo && !StringUtils.isEmpty(dutyInfo.getWarehouserFlg()) && "1".equals(dutyInfo.getWarehouserFlg())){
			bootClass="KG";
		}
		
		logger.info("----------检查操作类型----------");
		List<Entduty> entdutyList = entdutyDao.queryEntdutysByTellerNo(strTellerNo,"1");
		if ("A".equals(operFlag)) { // 上岗
			
			logger.info("----------检查是否已经在岗----------");
			Entduty entdutyTemp = entdutyDao.queryEntdutyByCond(strTellerNo, entduty.getBrNo());
			if (null != entdutyTemp) {
				throw new TellerTransOperFlagException("上岗失败，柜员目前已在岗");
			}
			
			logger.info("----------检查是否特殊岗位 ----------");
			String specialFlg = dutyInfo.getSpecialFlg();
			// 若柜员类型为“特殊操作柜员”，则只能上岗具有特殊操作柜员岗应用标识的岗位（即岗位属性“是否特殊操作柜员应用岗”标识为“是”的岗位）
			if("Z".equals(tellerType) && !("1".equals(specialFlg))) {
				throw new TellerTransException(strTellerNo + "柜员为特殊操作柜员，只能上岗具有特殊操作柜员岗应用标识的岗位");
			}
			
			// 若柜员类型为“普通操作柜员”，则只能上岗非特殊操作柜员岗应用标识的岗位（即岗位属性“是否特殊操作柜员应用岗”标识为“否”的岗位）
			if("C".equals(tellerType) && !("0".equals(specialFlg))) {
				throw new TellerTransException(strTellerNo + "柜员为普通操作柜员，只能上岗非特殊操作柜员岗应用标识的岗位");
			}
			
			// 检查柜员状态必须为“正常”
			logger.info("----------检查柜员状态必须为正常----------");
			if (!"1".equals(tellerInfo.getStatus())) {
				throw new TellerTransException("检查柜员状态必须为正常");
			}

			//对调出日期为非当前日期的指令生成柜员调出“待处理”状态记录，在调出记录处理前，限制被调柜员再上岗
			logger.info("----------检查是否存在柜员调出“待处理”状态记录----------");
			List<TellerLog> selectInfo = tellerLogDao.selectInfo("TELR0008", strTellerNo, "W", tellerNo, brNo);
			if (null != selectInfo && selectInfo.size() > 0) {
				throw new TellerCallOutException("存在待处理状态柜员调出记录,限制被调柜员再上岗");
			}
		} else if ("E".equals(operFlag)) { // 撤岗
			
			if (null == entdutyList || 0 == entdutyList.size()) {
				throw new TellerTransOperFlagException("撤岗失败，柜员不在岗");
			}
			
			logger.info("----------被调动柜员必须已完成柜员日终签退----------");
			// 被调动柜员必须已完成“柜员日终签退”，且柜员状态为“不在线”
			List<ExitTellerNo> exitTellerNoList = exitTellerNoDao.queryExitTellerNoByNo(DateTimeUtil.getSysDate(), strTellerNo, "", entdutyNo, "1");
			if (null != exitTellerNoList && exitTellerNoList.size() > 0) {
				throw new ExitTellerNotFinishedException(strTellerNo);
			}
			
			logger.info("----------柜员状态需要为不在线----------");
			if (!"0".equals(tellerInfo.getLoginStatus())) {
				throw new TellerTransException("柜员状态需要'不在线'");
			}
			
		} else {
			throw new ApIllegalParamException("操作类型有误");
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("cshboxno1", entduty.getCshBoxNo1());
		map.put("vchboxno1", entduty.getVchBoxNo1());
		map.put("boot_class", bootClass);
		return map;
	}

	/**
	 * 柜员调出
	 * @param strTellerNo 调出柜员
	 * @param strBrNo 调入网点
	 * @param strDate 调出日期
	 * @param tellerNo 操作柜员
	 * @param brNo 操作机构
	 * @param srcSysId 系统标识
	 * @param zoneNo 分行号
	 * @param srcCalCod 系统编码
	 * @param mBrNo 支行号
	 * @param authNo 授权柜员
	 * @param dutyNo 实体岗位
	 * @param serialNo 流水号
	 * @param tradeName 交易名称
	 * @param srcDate 请求方日期
	 * @param reqNo 请求方流水
	 */
	public void tellerCallOut(String strTellerNo, String strBrNo, String strDate, String tellerNo, String brNo, String srcSysId,String zoneNo, 
			String srcCalCod, String mBrNo, String authNo, String dutyNo, String serialNo, String tradeName, String srcDate, String reqNo) {
		// 检查柜员是否存在
		// 只能操作本机构的柜员
		logger.info("----------检查柜员是否存在----------");
		TellerInfo tellerInfo = tellerDao.queryTellerByNo(strTellerNo, brNo);
		if (null == tellerInfo) {
			throw new TellerNotExistException(strTellerNo);
		}

		//支持无关联自助设备的虚拟柜员调出，当已关联自助设备的虚拟柜员于本交易进行柜员调出时需作出限制
		logger.info("----------检查已关联自助设备的虚拟柜员----------");
		List<DevInfo> devInfoList = devInfoDao.queryDevInfoByDeTelNo(strTellerNo);
		if (null != devInfoList && devInfoList.size() > 0) {
			throw new TellerTransException("虚拟柜员已关联自助设备");
		}
		
		// 被调柜员必须为“正常”状态
		logger.info("----------检查被调柜员状态必须为正常----------");
		if (!"1".equals(tellerInfo.getStatus())) {
			throw new TellerTransException("检查柜员状态必须为正常");
		}
		
		// 检查网点号是否存在
		logger.info("----------检查网点号是否存在----------");
		Branch branch = branchDao.queryBranchOfNetWork(strBrNo, "0", "1");
		if (null == branch) {
			throw new BranchNotFoundException(strBrNo);
		}
		
		// 只允许调入实体网点机构
		logger.info("----------检查只允许调入实体网点机构----------");
		if (!"3".equals(branch.getType())) {
			throw new TellerCallOutException("只允许调入实体网点机构");
		}
		
		// 柜员是否已注册调入的网点
		logger.info("----------检查柜员是否已注册调入的网点----------");
		TellerInfo strTellerInfo = tellerDao.queryTellerByNo(strTellerNo, strBrNo);
		if (null != strTellerInfo) {
			throw new TellerCallOutException("柜员已注册调入的网点");
		}
		
		// 调出柜员所在调出网点必须不在岗状态
		logger.info("----------检查调出柜员所在调出网点必须不在岗状态----------");
		List<Entduty> entdutyList = entdutyDao.queryEntdutyByTelNoAndBrNo(strTellerNo, brNo, "1");
		if (entdutyList.size() > 0) {
			throw new TellerCallOutException("调出柜员所在调出网点必须是不在岗状态");
		}
		
		
		// 需判断调出柜员是否存在一人多网点注册关系
		logger.info("----------需判断调出柜员是否存在一人多网点注册关系----------");
		List<TellerInfo> tellerInfoList = tellerDao.selectTellerByTellerNo(strTellerNo);
		
		// 检查支行
		Branch branchMBrNo = branchDao.queryBranchByCondBrsta(branch.getUpBrno(), "1");
		if (null == branchMBrNo || StringUtils.isEmpty(branchMBrNo.getType()) || !("12|2|02").contains(branchMBrNo.getType())) {
			throw new TellerCallOutException("调入网点没有上级支行");
		}
		
		// 检查分行
		Branch CallOnZoneNo = branchDao.queryBranchByCondBrsta(branchMBrNo.getUpBrno(), "1");
		if (null == CallOnZoneNo || StringUtils.isEmpty(CallOnZoneNo.getType()) || !("01|1").contains(CallOnZoneNo.getType())) {
			throw new TellerCallOutException("调入网点没有上级分行");
		}
		
		if (tellerInfoList.size() > 1) {
			// 若存在，则需判断调出网点与调入网点是否同一分行
			// 若不同分行则限制并提示“柜员存在一人多网点注册关系，不允许跨分行调出”
			logger.info("----------检查是否为跨分行调出----------");
			if (!zoneNo.equals(CallOnZoneNo.getBrno())) {
				throw new TellerCallOutException("柜员存在一人多网点注册关系，不允许跨分行调出");
			}
		}
		// 交易成功后，柜员自动调入新机构，状态为“正常”
		
		// 8.调出预受理规则：
		TellerLog tellerLog = new TellerLog();
		tellerLog.setSerialNo(serialNo);
		String currentDate = DateTimeUtil.getSysDate();
		tellerLog.setOptDate(currentDate);
		tellerLog.setOptTime(DateTimeUtil.getSysTime());
		tellerLog.setOptZoneNo(zoneNo);
		tellerLog.setOptMbrNo(mBrNo);
		tellerLog.setOptBrNo(brNo);
		tellerLog.setOptTellerNo(tellerNo);
		tellerLog.setAuthTellerNo(authNo);
		tellerLog.setSysId(srcSysId);
		tellerLog.setChnlCode(srcCalCod);
		tellerLog.setSvrId("CSISU02006");
		tellerLog.setScnCode("142");
		tellerLog.setPlatCode("USRCNTER");
		tellerLog.setSvrCode("TELR0008");
		tellerLog.setTellerBrNo(strBrNo);
		tellerLog.setChgTellerNo(strTellerNo);
		tellerLog.setOptDutyNo(dutyNo);
		tellerLog.setChgTellernoBrno(strBrNo);
		tellerLog.setChgTellernoName(tellerInfo.getName());
		tellerLog.setAdjDate(strDate);
		tellerLog.setTransStatus("S");
		tellerLog.setTradeName(tradeName);
		tellerLog.setBfData0(brNo);
		tellerLog.setAfData0(strBrNo);
		tellerLog.setSrcDate(srcDate);
		tellerLog.setReqNo(reqNo);
		
		Map<String,Object> updateInfo = new HashMap<>();
		updateInfo.put("brno",strBrNo);
		updateInfo.put("mbrno",branchMBrNo.getBrno());
		updateInfo.put("zoneno",branchMBrNo.getUpBrno());
		
		List<TellerLog> selectInfo = tellerLogDao.selectInfo("TELR0008", strTellerNo, "W", tellerNo, brNo);
		if (selectInfo.size() > 1) {
			throw new TellerCallOutException("柜员流水信息存在两条以上记录");
		}
		
		int date =  Integer.parseInt(strDate) - Integer.parseInt(currentDate);
		if (date > 0) { // 调出日期大于当前日期时，插入一条‘待处理’的记录
			
			if (null == selectInfo || 0 == selectInfo.size()) {
				// 插入待处理的记录到流水表
				tellerLog.setTransStatus("W");
				logger.info("----------插入待处理状态柜员操作流水记录----------");
				int countLog = tellerLogDao.insertTellerLog(tellerLog);
				if (1 != countLog) {
					dbo.rollback();
					throw new TellerCallOutException("插入柜员操作流水记录出错");
				}
			} else {
				throw new TellerCallOutException("已存在待处理状态柜员调出记录");
			}
			
		} else if (0 == date) { // 调出日期与当前日期相等时进行调出操作
			// 判断当前请求是否为柜员操作流水表的记录
			if (1 == selectInfo.size()) {
				if (!currentDate.equals(selectInfo.get(0).getAdjDate())) {
					throw new TellerCallOutException("已存在待处理状态柜员调出记录");
				}
				// 更新柜员表
				logger.info("----------预受理更新柜员表----------");
				int count = tellerDao.updateTelInfoByTeNoABrNo(strTellerNo, brNo, updateInfo);
				if (1 != count) {
					dbo.rollback();
					throw new TellerCallOutException("更新柜员表出错");
				}

				// 调出柜员，并将流水表的记录状态改为‘成功’
				int updateTellerStatus = tellerLogDao.updateTellerStatus("S", selectInfo.get(0).getSerialNo(), selectInfo.get(0).getOptDate());
				if (1 != updateTellerStatus) {
					dbo.rollback();
					throw new TellerCallOutException("更新柜员操作流水表出错");
				}
			} else if (0 == selectInfo.size()) {
				
				logger.info("----------更新柜员表----------");
				int count = tellerDao.updateTelInfoByTeNoABrNo(strTellerNo, brNo, updateInfo);
				if (1 != count) {
					dbo.rollback();
					throw new TellerCallOutException("更新柜员表出错");
				}
				
				// 插入柜员操作流水记录
				logger.info("----------插入柜员操作流水记录----------");
				int countLog = tellerLogDao.insertTellerLog(tellerLog);
				if (1 != countLog) {
					dbo.rollback();
					throw new TellerCallOutException("插入柜员操作流水记录出错");
				}
			}
		} else { // 检查调出日期合理性，是否大于当前系统日期
			throw new TellerCallOutException("调出日期不能小于当前系统日期");
		}
//		
//		// 1）如柜员当天无发生业务操作的，“调出日期”默认置灰，系统实时执行指令，柜员调出成功，记录状态为“已处理”。
//		List<TellerLog> tellerLogList = tellerLogDao.queryTLByTelNoAndODate(strTellerNo, currentDate);
//		if (null == tellerLogList || 0 == tellerLogList.size()) {
//			logger.info("----------检查柜员当天有发生业务操作----------");
//			tellerLog.setTransStatus("1");
//			
//			
//		}
//		// 2）如柜员当天有发生业务操作的，系统报“柜员XXX今天发生了交易，不允许调动”后，（仅在这个报错的情况）界面放开“调出日期”录入，且系统检测调出日期必须大于当前系统日期；
//		if (tellerLogList.size() > 0) {
//			logger.info("----------检查柜员当天无发生业务操作----------");
//			if (1 != strDate.compareTo(currentDate)) {
//				throw new TellerHappenTransException(strTellerNo);
//			}
//		}
//		// 5）已存在待处理调出记录的柜员号限制再次调出，已处理完成的可重复调出；
//		logger.info("----------检查是否存在待处理调出记录的柜员号限制再次调出----------");
//		List<TellerLog> tellerLogPendingList = tellerLogDao.queryTLByChaTelNoAndSta(strTellerNo, "0");
//		if (tellerLogPendingList.size() > 0) {
//			throw new TellerCallOutException("已存在待处理调出记录的柜员号限制再次调出");
//		}
//		// 插入柜员操作流水记录
//		logger.info("----------插入柜员操作流水记录----------");
//		int countLog = tellerLogDao.insertTellerLog(tellerLog);
//		if (1 != countLog) {
//			dbo.rollback();
//			throw new TellerCallOutException("插入柜员操作流水记录出错");
//		}
		dbo.commit();
	}


	/**
	 * @summary 末位柜员撤岗调出
	 * @param tellerno  柜员号
	 * @param strbrno	调出网点号
	 * @param adjbrno	调入网点号
	 */
	public void lastTellerDeparture(String tellerno, String strbrno, String adjbrno) {
		//查询柜员信息表该柜员是否一人多网点,若存在，return false
		logger.info("----------检查柜员是否存在----------");
		List<TellerInfo> tellerInfo = tellerDao.selectTellerByTellerNo(tellerno);
		if(StringUtils.isEmpty(tellerInfo)) {
			throw new TellerNotExistException(tellerno);
		}
		
		//查询柜员信息是否存在，返回柜员号和网点信息
		logger.info("----------查询柜员信息是否存在，返回柜员号和网点信息----------");
		TellerInfo queryTeller = tellerDao.queryTellerByNo(tellerno,strbrno);
		//判断柜员是否在此网点
		if(null == queryTeller) {
			throw new CheckedNoDataError("该柜员不在此网点");
		}
		
		//查询调入网点是否存在
		logger.info("----------查询调入网点是否存在----------");
		Branch existBranch = branchDao.queryBranchOfNetWork(adjbrno, "0", "1");
		if(null == existBranch) {
			throw new BranchNotFoundException(adjbrno);
		}
		
		int count = tellerInfo.size();
		
		//调出网点
		Branch strBrNo = branchDao.queryBranchOfNetWork(strbrno, "0", "1");
		
		if(count > 1) {
			//检查该柜员是否已存在于调入网点
			TellerInfo info = tellerDao.queryTellerByNo(tellerno,adjbrno);
			if(null != info) {
				throw new LastTellerCallOutException("此柜员["+tellerno+"]已存在于此机构["+adjbrno+"],不可调出");
			}
			
			//调出网点的支行分行检查
			Branch strMBrNo = branchDao.queryBranchByCondBrsta(strBrNo.getUpBrno(), "1");
			if (null == strMBrNo || StringUtils.isEmpty(strMBrNo.getType()) || !("2|02|12").contains(strMBrNo.getType())) {
				throw new LastTellerCallOutException("调出网点没有上级支行");
			}
			
			Branch strZoneNo = branchDao.queryBranchByCondBrsta(strMBrNo.getUpBrno(), "1");
			if (null == strZoneNo || StringUtils.isEmpty(strZoneNo.getType()) || !("1|01").contains(strZoneNo.getType())) {
				throw new LastTellerCallOutException("调出网点没有上级分行");
			}
			
			//调入网点的支行分行检查
			Branch adjBrNo = branchDao.queryBranchByCondBrsta(adjbrno, "1");
			Branch adjMBrNo = branchDao.queryBranchByCondBrsta(adjBrNo.getUpBrno(), "1");
			if (null == adjMBrNo || StringUtils.isEmpty(adjMBrNo.getType()) || !("2|02|12").contains(adjMBrNo.getType())) {
				throw new LastTellerCallOutException("调入网点没有上级支行");
			}
			
			Branch adjZoneNo = branchDao.queryBranchByCondBrsta(adjMBrNo.getUpBrno(), "1");
			if (null == adjZoneNo || StringUtils.isEmpty(adjZoneNo.getType()) || !("1|01").contains(adjZoneNo.getType())) {
				throw new LastTellerCallOutException("调入网点没有上级分行");
			}
			
			//检查是否为跨分行调出
			logger.info("----------检查是否为跨分行调出----------");
			if(!(strMBrNo.getUpBrno().equals(adjMBrNo.getUpBrno()))) {
				throw new TellerExistMulBrno(tellerno);
			}
		}
		
		//查询实体岗信息，返回柜员号，网点号，岗位类型编号，状态，钱箱，实体岗编号
		//判断是否在岗
		logger.info("----------查询实体岗信息，返回柜员号，网点号，岗位类型编号，状态，钱箱，实体岗编号----------");
		Entduty entdutyInfo = entdutyDao.queryEntdutyByCond(tellerno, strbrno);
		if(null == entdutyInfo) {
			throw new LastTellerCallOutException("该柜员不在岗");
		}
		
		//岗位类型编号
		String dutyno = entdutyInfo.getDutyNo();
		//岗位状态
		String status = entdutyInfo.getStatus();
		//现金钱箱
		String cshboxno1 =entdutyInfo.getCshBoxNo1();
		//凭证尾箱
		String vchboxno1 = entdutyInfo.getVchBoxNo1();
		//实体岗编号
		String entdutyno = entdutyInfo.getEntDutyNo();
		
		//根据岗位类型编号查询岗位类型信息，返回，岗位类型编号，岗位类型级别，
		logger.info("----------根据岗位类型编号查询岗位类型信息，返回，岗位类型编号，岗位类型级别----------");
		DutyInfo dutyInfo = dutyinfoDao.queryByDutyNo(dutyno);
		if(StringUtils.isEmpty(dutyInfo)) {
			throw new CheckedNoDataError("岗位类型信息为空！");
		}
		
		//判断岗位状态是否有效
		if(!"1".equals(dutyInfo.getStatus())){
			throw new LastTellerCallOutException("该岗位类型状态无效");
		}
		
		//岗位类型级别
		String dutylevel = dutyInfo.getDutyLevel();
		//判断岗位类型级别是否为授权岗
		if(!"A".equals(dutylevel)) {
			throw new LastTellerCallOutException("柜员[" + tellerno + "] 非本网点最后一位坐班主任，无法操作");
		}
		
		//根据网点号查询实体岗位表，获取该网点岗位数量
		logger.info("----------根据网点号查询实体岗位表，获取该网点岗位数量----------");
		int entdutyCount = entdutyDao.SelectEntdutyCountByBrno(strbrno);
		//判断网点岗位数量是否只剩一个
		if(1 != entdutyCount) {
			throw new LastTellerCallOutException("网点存在其他实体岗，请先删除");
		}
		
		//根据网点号查询柜员信息表，获取该网点的柜员数量
		logger.info("----------根据网点号查询柜员信息表，获取该网点的柜员数量----------");
		List<TellerInfo> tellerInfoList = tellerDao.selectTellerByBrNo(strbrno);
		
		List<String> tellerNoList = new ArrayList<>();
		
		if (null != tellerInfoList || tellerInfoList.size() > 0 ) {
			for (TellerInfo teller : tellerInfoList) {
				if (!tellerno.equals(teller.getTellerNo())) {
					tellerNoList.add(teller.getTellerNo());
				}
			}
		}
		//判断该网点柜员数量是否只剩一个
		if(1 != tellerInfoList.size()) {
			throw new LastTellerCallOutException("网点存在空岗柜员[" + tellerNoList + "]，请先调出网点");
		}
		

		//被调出的末位柜员所在机构必须为机构签退状态
		if (!"0".equals(strBrNo.getLoginStatus())) {
			throw new LastTellerCallOutException("被调出的末位柜员所在机构必须为机构签退状态");
		}
	}

	/**
	 * @summary 柜员日终签退
	 * @param strtellerno  	柜员号
	 * @param strsysid		系统标识
	 * @param strbrno		网点号
	 * @param tellerno		操作柜员号
	 * @param brno		操作网点号
	 */
	public Map<String, Object> checkExit(String strtellerno, String strsysid,String strbrno,String tellerno,String brno) {
		
		Map<String, Object> resultMap = new HashMap<>();
		// 当前日期
		String tradeDate = DateTimeUtil.getSysDate();
		
		// 需检查待签退柜员是否存在，若不存在则提示柜员不存在；
		logger.info("----------检查待签退柜员是否存在----------");
		TellerInfo info = tellerDao.queryTellerByNo(strtellerno, strbrno);
		if (null == info) {
			throw new TellerNotExistException(strtellerno);			
		}
		
		// 若柜员已完成日终签退，则无需再次签退，系统提示“柜员[**（柜员号）]已完成日终签退，无需重复签退”；
		logger.info("----------检查柜员是否已完成日终签退----------");
		List<Map<String, Object>> exitTellerNoList = entdutyMutiDao.getExitTellerNoList(tradeDate, strtellerno, "", "1");
		if (null == exitTellerNoList || 0 == exitTellerNoList.size()) {
			//不限制关联岗位受控系统为空的柜员进行日终签退
			if ("0".equals(info.getLoginStatus())) {
				throw new ExitTellerAddFailException("柜员[" + strtellerno + "]已完成日终签退，无需重复签退");
			}
		}
		
//		List<Map<String, Object>> exitBrnoList = new ArrayList<Map<String, Object>>();
//		Set<String> exitBrnoSet = new HashSet<>();
//		if (null != exitTellerNoList && exitTellerNoList.size() > 0) {
//			for (Map<String, Object> exitTellerNo : exitTellerNoList) {
//				if (!strbrno.equals(exitTellerNo.get("brno"))) {
//					exitBrnoSet.add((String)exitTellerNo.get("brno"));
//				}
//			}
//			List exitBrnoSetList = new ArrayList<>(exitBrnoSet);
//			for (int i = 0; i < exitBrnoSetList.size(); i++) {
//				Map<String, Object> map = new HashMap<>();
//				map.put("strbrno", exitBrnoSetList.get(i));
//				exitBrnoList.add(map);
//			}
//		} else {
//			//不限制关联岗位受控系统为空的柜员进行日终签退
//			if ("0".equals(info.getLoginStatus())) {
//				throw new ExitTellerAddFailException("柜员[" + strtellerno + "]已完成日终签退，无需重复签退");
//			}
//		}
//		resultMap.put("branchnm", exitBrnoList.size());
//		resultMap.put("branch_list", exitBrnoList);
		
		// 是否为最后柜员
		boolean isLastTeller = false;
		
		// 普通柜员仅能签退自身受控系统，若是代办签退，只能由坐班代办本机构柜员签退，若代办签退操作柜员不是坐班主任，则提示签退失败，只能有坐班待办签退操作；
		// “是否管理员”属性为“是”的柜员可对全行柜员代理进行日终签退，岗位类型为“A”（授权岗）的为坐班；
		
        // 操作柜员与被检查柜员是否同一个
		boolean isSame = false;
        if (strtellerno.equals(tellerno)) {
        	isSame = true;
		}else {
			isSame = false;
			// 查询操作柜员是否为坐班
			logger.info("----------操作柜员是否为坐班----------");
			Entduty entduty = entdutyDao.queryEntdutyByCond(tellerno, brno);
			String dutyNo = entduty.getDutyNo();
			Boolean isAdmin = false;
			DutyInfo dutyInfo = dutyinfoDao.queryByDutyNo(dutyNo);
			if("A".equals(dutyInfo.getDutyLevel()) || "1".equals(dutyInfo.getAdminFlg())){
	        	isAdmin = true;
	        }
			
			// 授权岗坐班不能对其他机构柜员代签
			if (!brno.equals(strbrno) && !"1".equals(dutyInfo.getAdminFlg())) {
				throw new ExitTellerAddFailException("要日终的柜员非本部门柜员");	
			}
			
	    	// 如果操作柜员与检查柜员不一致,检查一下该柜员是否为坐班,如不是报错
	        if(!isSame && !isAdmin) {
				throw new ExitTellerAddFailException("只有坐班柜员才有权限");
	        }
		}

        logger.info("----------签退柜员是否为坐班----------");
        // 查询签退柜员是否为坐班
		Entduty strEntduty = entdutyDao.queryEntdutyByCond(strtellerno, strbrno);
		String strDutyNo = strEntduty.getDutyNo();
		resultMap.put("dutyNo", strDutyNo);
		Boolean isStrAdmin = false;
		DutyInfo dutyInfo = dutyinfoDao.queryByDutyNo(strDutyNo);
		if("A".equals(dutyInfo.getDutyLevel()) || "1".equals(dutyInfo.getAdminFlg())){
			isStrAdmin = true;
        }
		
		if (isStrAdmin) {
			logger.info("----------检查柜员是否为最后一个坐班柜员----------");
			List<Map<String, Object>> isAdminList = tellerMutiDao.queryTellerTypeList(tradeDate, strbrno, "1", "A");
			List<Map<String, Object>> newIsAdminList = new ArrayList<>();
			for (Map<String, Object> isAdminMap : isAdminList) {
				if (!"0".equals(isAdminMap.get("status"))  && strbrno.equals(isAdminMap.get("brno"))) {
					newIsAdminList.add(isAdminMap);
				}
			}
			if (1 == newIsAdminList.size()) {
				logger.info("----------检查该机构是否还有未签退的柜员----------");
				List<Map<String, Object>> exitTellerBrNoList = entdutyMutiDao.getExitTellerNoList(tradeDate, "", strbrno, "1");
				Set<String> exitTellerSet = new HashSet<>();
				if (null != exitTellerBrNoList && exitTellerBrNoList.size() > 0) {
					for (Map<String, Object> exitTellerBrNo : exitTellerBrNoList) {
						if (!strtellerno.equals(exitTellerBrNo.get("tellerno"))) {
							exitTellerSet.add((String)exitTellerBrNo.get("tellerno"));
						}
					}
					if (exitTellerSet.size() > 0) {
						throw new ExitTellerAddFailException("其他普通柜员必须都签退才能做最后一个坐班柜员签退");
					} else {
						isLastTeller = true;
					}
				}
			}
		}
//		if (!isSame && isLastTeller) {
//			throw new ExitTellerAddFailException("该机构最后一个进行日终签退的柜员必须是柜员本人签退");
//		}
		resultMap.put("isLastTeller", isLastTeller);
		
		/*boolean isWei = false;
        if (dutyNo.endsWith("045") || dutyNo.endsWith("046") || dutyNo.endsWith("048") || dutyNo.endsWith("049")
	            || dutyNo.equals("100014")|| dutyNo.equals("100015")|| dutyNo.equals("100017")|| dutyNo.equals("100018")) {
        	isWei = true;
		}else {
			isWei = false;
		}*/
        
		//this.tellerSysExit(strtellerno, strsysid, strbrno, tellerno, brno);
        //如果是坐班且操作柜员与被检查柜员不同,直接修改成不在线
        //坐班要到网点签退时才改
        /*if(strsysid.contains("0005") && (!isAdmin || !isSame)) {
        	if (!isWei) {
        		//更新在线状态为不在线 
            	Map<String, Object> paramMap1 = new HashMap<>();
            	paramMap1.put("tellerno", strtellerno);
            	paramMap1.put("loginstatus", "0");
            	paramMap1.put("sysoperdate", DateTimeUtil.getSysDate());
        		int count = tellerDao.updateTellerInfo(paramMap1);
        		
        		if (count < 1) {
        			logger.error("更新信息失败");
        			throw new ExitTellerAddFailException("更新信息失败");
				}
			}
        }*/
		return resultMap;
	}


	/**
	 * 柜员日终签退前检查应用系统
	 * @param request	
	 * @throws DBException
	 */
	public boolean tellerSysExit(String strtellerno, String strsysid,String strbrno,String tellerno,String brno){
		
		logger.info("----------更新信息----------");
		String tradeDate = DateTimeUtil.getSysDate();
		String tradeTime = DateTimeUtil.getSysTime();
		Map<String, Object> paramMap1 = new HashMap<>();
    	paramMap1.put("loginstatus", "0");
    	paramMap1.put("optdate", tradeDate);
    	paramMap1.put("opttime", tradeTime);
		int count1 = tellerDao.updateTelInfoByTeNoABrNo(strtellerno, strbrno, paramMap1);
		if (count1 < 1) {
			dbo.rollback();
			throw new ExitTellerAddFailException("更新信息失败");
		}
		
//		if (!StringUtils.isEmpty(strsysid)) {
//			String[] strArr = strsysid.split("\\|");
//			if (null != strArr && strArr.length > 0) {
//				
//				for (String sysId : strArr) {
//					if (StringUtils.isEmpty(sysId)) {
//						continue;
//					}
//					logger.info("----------更新日终系统----------");
//					Map<String, Object> paramMap2 = new HashMap<>();
//					paramMap2.put("status", "0");
//				    int count2 = exitTellerNoDao.updateExitTellerInfo(strtellerno, strbrno, tradedate, sysId, paramMap2);
//				    if (count2 < 1) {
//				    	dbo.rollback();
//						throw new ExitTellerAddFailException("更新日终系统失败");	
//					}
//				}
//			}
//		}
		
        //最后到01时
		logger.info("----------更新注册系统----------");
        if(strsysid.contains("0005")) {
        	Map<String, Object> paramMap3 = new HashMap<>();
        	paramMap3.put("loginstatus", "0");
        	paramMap3.put("sysusoudate", tradeDate);
        	paramMap3.put("sysusoutime", tradeTime);
        	int count3 = tellerSysDao.updateTellerInfo(tellerno, "0005", paramMap3);
        	if (count3 < 1) {
    	    	dbo.rollback();
    			throw new TellerSysAddFailException("更新注册系统失败");	
    		}
        }
	
        return true;
	}
	
	/**
	 * 日终签退
	 * @param strbrno 网点号
	 * @return
	 * @throws DBException
	 */
	public boolean brnoSysExit(String strbrno){
		AppLogger.info("--------------- brnoSysExit------------");
		
		//核心系统放在最后
		//String[] sysArr = {"0227","0010","0005","0165"};
		String tradeDate = DateTimeUtil.getSysDate();
		String tradeTime = DateTimeUtil.getSysTime();

		//更新网点状态
		logger.info("----------更新网点状态----------");
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("loginstatus", "0");
		paramMap.put("upddate", tradeDate);
		paramMap.put("updtime", tradeTime);
		int count = branchDao.updateBranchInfo(strbrno, paramMap);
		if (count < 1) {
	    	dbo.rollback();
			throw new TellerSysAddFailException("更新网点状态失败");	
		}
		
//		logger.info("----------更新登录状态----------");
//		Map<String, Object> paramMap1 = new HashMap<>();
//		paramMap1.put("tellerno",strtellerno);
//		paramMap1.put("sysid",strsysid);
//		paramMap1.put("loginstatus","0");
//		paramMap1.put("sysoperdate",tradedate);
//    	int count1 = tellerSysDao.updateTellerInfo(paramMap1);
//    	
//    	if (count1 < 1) {
//	    	dbo.rollback();
//			throw new TellerSysNotExistException("更新登录状态失败");	
//		}
    	
		//更新网点受控状态
//    	logger.info("----------更新网点受控状态----------");
//		ExitBrno eb = new ExitBrno();
//		eb.setBrno(strbrno);
//		eb.setTradeDate(tradedate);
//		eb.setStatus("0");
//		int count2 = exitBrnoDao.updateInfo(eb);
//		if (count2 < 1) {
//	    	dbo.rollback();
//			throw new ExitBrnoUpdateFailException("更新网点受控状态失败");	
//		}

        return true;
	}
	/**
	 * 
	 * @param strtellerno 柜员号
	 * @param tellertype 柜员类别
	 * @param strbrno 柜员员所属网点
	 * @exception
	 */
	public Map<String, Object> changeTellerByTellerNo(String strtellerno, String tellertype, String strbrno) {
		logger.info("----------判断柜员号是否存在----------");
		TellerInfo tellerInfo = tellerDao.queryTellerByNo(strtellerno, strbrno);
		if (null == tellerInfo) {
			throw new TellerNotExistException(strtellerno);
		} 
		
		// 被调整的柜员状态必须为正常且非在岗状态
		logger.info("----------被调整的柜员状态必须为正常且非在岗状态----------");
		
		// 若柜员状态为已注销，则限制修改并提示“柜员[**(柜员号)]不存在”
		if ("0".equals(tellerInfo.getStatus())) {
			throw new TellerNotExistException(strtellerno);
		}

		// 若为虚拟柜员则不允许修改柜员类型，只允许实体柜员修改柜员类型
		logger.info("----------判断该柜员类别（实体/虚拟）----------");
		StaffInfo staffInfo = staffInfoDao.queryTellerByNo(strtellerno);
		if("04".equals(staffInfo.getTellerType())) {
			throw new TellerModifyException("虚拟柜员不允许修改柜员类型");
		}
		
		//需检查柜员是否在岗，若在岗则不允许修改柜员类型，限制并提示“该柜员在岗，不能进行维护”
		Entduty entduty = entdutyDao.queryEntdutyByCond(strtellerno, strbrno);
		if(null != entduty) {
			throw new TellerModifyException("该柜员在岗，不能进行维护");
		}
		
		Map<String, Object> map=new HashMap<>();
		map.put("tellerno", strtellerno);
		if(tellertype.equals("Z")) {
			map.put("specialFlg", "2");
			map.put("tellertype", "1");
		}else {
		map.put("specialFlg", "1");
		map.put("tellertype", "0");
		}
		map.put("strbrno", strbrno);
		map.put("name", staffInfo.getName());
		return map;
	}

	/**
	 * 柜员岗位调动更新数据
	 * @param entdutyNo 调动岗位
	 * @param strTellerNo 变更柜员
	 * @param status 状态
	 */
	public void tellerEntdutyTransUpdate(String entdutyNo, String strTellerNo, String status) {
		Map<String, Object> map = new HashMap<>();
		map.put("tellerno", strTellerNo);
		map.put("status", status);
		map.put("upddate", DateTimeUtil.getSysDate());
		map.put("updtime", DateTimeUtil.getSysTime());
		int count = entdutyDao.updateEntduty(entdutyNo, map);
		if (1 != count) {
			dbo.rollback();
			throw new EntdutyOnException("更新实体岗信息失败");
		}
		dbo.commit();
	}

	
	/**
	 * 是否要网点开机
	 * @param strtellerno  	柜员号
	 * @param strbrno		网点号
	 * @return
	 */
	public boolean checkBrnoOpen(String strbrno){
		AppLogger.info("--------------- checkBrnoOpen------------");
		
		List<ExitBrno> list = exitBrnoDao.queryExitBrNoByDate(DateTimeUtil.getSysDate(), strbrno);
		
		List<ExitTellerNo> exitList = exitTellerNoDao.queryInfoByBrno(DateTimeUtil.getSysDate(), strbrno);
		
		if (null != list && list.size() > 0 && !StringUtils.isEmpty(list.get(0).getStatus()) && "0".equals(list.get(0).getStatus())) {
			return true;
		}else {
			if (null == exitList || 0 == exitList.size()) {
				return true;
			}else {
				return false;
			}
			
		}
		
	}
	
	/**
	 * 是否最后一个柜员签退
	 * @param strtellerno  	柜员号
	 * @param strbrno		网点号
	 * @return
	 */
	public boolean checkLastTeller(String strtellerno,String strbrno){
		AppLogger.info("--------------- checkLastTeller------------");
				
		List<ExitTellerNo> exitList = exitTellerNoDao.queryInfoByBrnoAndStatus(DateTimeUtil.getSysDate(), strbrno, "1");
		
		if (null != exitList && exitList.size() == 1) {
			
			ExitTellerNo temp = exitList.get(0);
			if (!StringUtils.isEmpty(temp.getTellerNo()) && strtellerno.equals(temp.getTellerNo())) {
				return true;
			}
			
		}
		
		return false;
		
		
	}


	/**
	 * @summary 末位柜员撤岗调出信息查询
	 * @param tellerno 柜员号
	 * @param strbrno  调出网点
	 * @return
	 */
	public Map<String,Object> lastTellerDepartureInfo(String tellerno, String strbrno) {
		//查询实体岗信息，返回柜员号，网点号，岗位类型编号，状态，钱箱，实体岗编号
		logger.info("查询实体岗信息，返回柜员号，网点号，岗位类型编号，状态，钱箱，实体岗编号");
		Entduty entdutyInfo = entdutyDao.queryEntdutyByCond(tellerno, strbrno);
		if(null==entdutyInfo) {
			throw new CheckNoDataException("实体岗信息为空");
		}
		Map<String,Object> map = new HashMap<>();
		
		String dutyno = entdutyInfo.getDutyNo();
		DutyInfo dutyInfo = dutyinfoDao.queryByDutyNo(dutyno);
		String bootClass="GY" ;
		if(null != dutyInfo && !StringUtils.isEmpty(dutyInfo.getWarehouserFlg()) && "1".equals(dutyInfo.getWarehouserFlg())){
			bootClass="KG";
		}
		
		map.put("boot_class", bootClass);
		map.put("cshboxno1", entdutyInfo.getCshBoxNo1());
		map.put("vchboxno1", entdutyInfo.getVchBoxNo1());
		return map;
		
	}
	
	/**
	 * 校验柜员是否有授权岗
	 * @param strtellerno  	柜员号
	 * @return
	 */
	public boolean checkTellerAdmin(String strtellerno){
		AppLogger.info("--------------- checkTellerAdmin------------");
						
		List<TellerInfo> list = tellerDao.selectTellerByTellerNo(strtellerno);
		
		if (null == list || list.size() == 0) {
			return false;		
		}
		
		for (TellerInfo tellerInfo : list) {
			Entduty entduty = entdutyDao.queryEntdutyByCond(tellerInfo.getTellerNo(), tellerInfo.getBrNo());
		
			//查询操作柜员是否为坐班
			boolean isAdmin = dutyinfoDao.isBrnoAdmin(entduty.getDutyNo());
			if (isAdmin) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 柜员登陆随机数生成
	 * @param srcSysId 系统标识
	 * @param tellerNo 柜员号
	 * @param serialno 流水号
	 * @return
	 */
	public String tellerLoginRandomGen(String srcSysId, String tellerNo, String serialno) {
		// 4位系统标识+日期+时间+外围请求流水+12位随机数然后MD5加密
		String currentDate = DateTimeUtil.getSysDate();
		String currentTime = DateTimeUtil.getSysDate();
		Purp purp = new Purp();
		purp.setChnlCode(srcSysId);
		int count = purpDao.insertPurp(purp);
		if (1 != count) {
			throw new tellerLoginRandomGenException("插入随机数记录有误");
		}
		return "";
	}


	public void dboCommit() {
		dbo.commit();
		
	}

	public void dboRollBack() {
		dbo.rollback();
		
	}


	public void checkExitTellerno(Map totalData, Map ticketData, Map frData, Map hostData, String isExit,
			boolean isLastTeller, String strtellerno, String strbrno) {

//		List<Map<String, String>> rspList = new ArrayList<Map<String, String>>();
		String tradeDate = DateTimeUtil.getSysDate();
		
		if (!"1".equals(isExit)) {
			Map<String, Object> paramMap = new HashMap<>();
			if (null != totalData) {
				if (totalData.size() > 0) {
					// TODO 总账系统
					logger.info("总账totalData- :" + totalData);
					Map<String, Object> csisHeader1 = (Map<String, Object>) totalData.get("CsisHeader");
					Map<String, Object> appBody1 = (HashMap<String, Object>) totalData.get("APPBody");
					String errorCode1 = String.valueOf(csisHeader1.get("ErrorCode"));
					if (null != appBody1 && appBody1.size() > 0 && "AAAAAAAAAA".equals(errorCode1)) {
	
						List<Map<String, String>> tmpList1 = (List<Map<String, String>>) appBody1.get("info_list");
						if (null != tmpList1 && tmpList1.size() > 0) {
							List<String> hintInfoList = new ArrayList<>();
							for (Map<String, String> map : tmpList1) {
								if ("F".equals(map.get("limits"))) {
									paramMap.put("exitdesc", map.get("htinfo"));
									int count = exitTellerNoDao.updateExitTellerInfo(strtellerno, strbrno, tradeDate, "0010", paramMap);
									if (1 != count) {
										dbo.rollback();
									}
									dbo.commit();
									throw new ExitTellerAddFailException("总账限制：" + map.get("htinfo"));
								}
								hintInfoList.add(map.get("htinfo"));
//								Map<String, String> tmpMap = new HashMap<>();
//								tmpMap.put("hintInfo", map.get("htinfo"));
//								tmpMap.put("sysid", "0010");
//								rspList.add(tmpMap);
							}
							paramMap.put("exitdesc", JSON.toJSONString(hintInfoList));
							int count = exitTellerNoDao.updateExitTellerInfo(strtellerno, strbrno, tradeDate, "0010", paramMap);
							if (1 != count) {
								dbo.rollback();
							}
						}
					}
				}
			} else {
				paramMap.put("exitdesc", "调用总账系统异常");
				int count = exitTellerNoDao.updateExitTellerInfo(strtellerno, strbrno, tradeDate, "0010", paramMap);
				if (1 != count) {
					dbo.rollback();
				}
				dbo.commit();
				throw new ExitTellerAddFailException("调用总账系统异常");
			}

			if (null != ticketData) {
				if (ticketData.size() > 0) {
					// TODO 票据系统
					logger.info("票据ticketData- :" + ticketData);
					Map<String, Object> csisHeader2 = (Map<String, Object>) ticketData.get("CsisHeader");
					Map<String, Object> appBody2 = (HashMap<String, Object>) ticketData.get("APPBody");
					String errorCode2 = String.valueOf(csisHeader2.get("ErrorCode"));
					if (null != appBody2 && appBody2.size() > 0 && "AAAAAAAAAA".equals(errorCode2)) {
						List<Map<String, String>> tmpList2 = (List<Map<String, String>>) appBody2.get("info_list");
						List<String> infoList = new ArrayList<>();
						for (Map<String, String> map : tmpList2) {
							infoList.add(map.get("hintinfo"));
						}
//						String erorcd = String.valueOf(appBody2.get("erorcd"));
//						if (!StringUtils.isEmpty(erorcd) && "99999999".equals(erorcd)) {
//							String ercotx = String.valueOf(appBody2.get("ercotx"));
//							Map<String, String> tmpMap = new HashMap<>();
//							tmpMap.put("hintInfo", ercotx);
//							tmpMap.put("sysid", "0227");
//							rspList.add(tmpMap);
//						}
						paramMap.put("exitdesc", JSON.toJSONString(infoList));
						int count = exitTellerNoDao.updateExitTellerInfo(strtellerno, strbrno, tradeDate, "0227", paramMap);
						if (1 != count) {
							dbo.rollback();
						}
					}
				}
			} else {
				paramMap.put("exitdesc", "调用票据系统异常");
				int count = exitTellerNoDao.updateExitTellerInfo(strtellerno, strbrno, tradeDate, "0227", paramMap);
				if (1 != count) {
					dbo.rollback();
				}
				dbo.commit();
				throw new ExitTellerAddFailException("调用票据系统异常");
			}

			if (null != frData) {
				if (frData.size() > 0) {
					// TODO 前置系统
					logger.info("前置frData- :" + frData);
					Map<String, Object> csisHeader3 = (Map<String, Object>) frData.get("CsisHeader");
					Map<String, Object> appBody3 = (HashMap<String, Object>) frData.get("APPBody");
					String errorCode3 = String.valueOf(csisHeader3.get("ErrorCode"));
					if (null != csisHeader3 && csisHeader3.size() > 0 && "AAAAAAAAAA".equals(errorCode3)) {
						
						List<Map<String, String>> tmpList3 = (List<Map<String, String>>) appBody3.get("bodrcd_list");
						if (null != tmpList3 && tmpList3.size() > 0) {
							List<String> strmsginfoList = new ArrayList<>();
							for (Map<String, String> map : tmpList3) {
								if ("F".equals(map.get("limits"))) {
									paramMap.put("exitdesc", map.get("strmsginfo"));
									int count = exitTellerNoDao.updateExitTellerInfo(strtellerno, strbrno, tradeDate, "0165", paramMap);
									if (1 != count) {
										dbo.rollback();
									}
									dbo.commit();
									throw new ExitTellerAddFailException("前置限制：" + map.get("strmsginfo"));
								}
								strmsginfoList.add(map.get("strmsginfo"));
//								Map<String, String> tmpMap = new HashMap<>();
//								tmpMap.put("hintInfo", map.get("strmsginfo"));
//								tmpMap.put("sysid", "0165");
//								rspList.add(tmpMap);
							}
							paramMap.put("exitdesc", JSON.toJSONString(strmsginfoList));
							int count = exitTellerNoDao.updateExitTellerInfo(strtellerno, strbrno, tradeDate, "0165", paramMap);
							if (1 != count) {
								dbo.rollback();
							}
						}
					}
				}
			} else {
				paramMap.put("exitdesc", "调用前置系统异常");
				int count = exitTellerNoDao.updateExitTellerInfo(strtellerno, strbrno, tradeDate, "0165", paramMap);
				if (1 != count) {
					dbo.rollback();
				}
				dbo.commit();
				throw new ExitTellerAddFailException("调用前置系统异常");
			}

			if (null != hostData) {
				if (hostData.size() > 0) {
					// TODO 核心系统
					logger.info("核心hostData- :" + hostData);
					Map<String, Object> csisHeader = (Map<String, Object>) hostData.get("CsisHeader");
					Map<String, Object> appBody4 = (HashMap<String, Object>) hostData.get("APPBody");
					String hostErrorCode = String.valueOf(csisHeader.get("ErrorCode"));
					if (null != appBody4 && appBody4.size() > 0 && "AAAAAAAAAA".equals(hostErrorCode)) {
						List<String> chinsComtList = new ArrayList<>();
						List<Map<String, String>> list = (List<Map<String, String>>) appBody4.get("lstBr5364out_list");
						for (Map<String, String> map : list) {
							chinsComtList.add(map.get("chins_comt"));
//							Map<String, String> tmpMap = new HashMap<>();
//							tmpMap.put("hintInfo", map.get("chins_comt"));
//							tmpMap.put("sysid", "0005");
//							rspList.add(tmpMap);
						}
						paramMap.put("exitdesc", JSON.toJSONString(chinsComtList));
						int count = exitTellerNoDao.updateExitTellerInfo(strtellerno, strbrno, tradeDate, "0005", paramMap);
						if (1 != count) {
							dbo.rollback();
						}
					}
				}
			} else {
				paramMap.put("exitdesc", "调用核心系统异常");
				int count = exitTellerNoDao.updateExitTellerInfo(strtellerno, strbrno, tradeDate, "0005", paramMap);
				if (1 != count) {
					dbo.rollback();
				}
				dbo.commit();
				throw new ExitTellerAddFailException("调用核心系统异常");
			}

//			if (isLastTeller) {
//				Map<String, String> tmpMap = new HashMap<>();
//				tmpMap.put("hintInfo", "柜员[" + strtellerno + "]为本机构最后一个签退柜员，系统将同步完成机构平账及机构关机，请确认是否继续操作？");
//				rspList.add(tmpMap);
//			}
		}
		
//		Map<String, Object> resultMap = new HashMap<>();
//		resultMap.put("rowcnt", rspList.size());
//		resultMap.put("bodrcd_list", rspList);
//		return resultMap;
	}
	

	public void loginDataUpdate(String strTellerNo, String strBrNo, Boolean openBrNo) {
		String tradeDate = DateTimeUtil.getSysDate();
		String tradeTime = DateTimeUtil.getSysTime();
		Map<String, String> sysMap = new HashMap<>();
		sysMap.put("0005", "核心系统");
		sysMap.put("0010", "总账系统");
		sysMap.put("0227", "票据系统");
		sysMap.put("0165", "综合前置");
		
		logger.info("----------登录更新柜员状态----------");
		List<TellerInfo> tellerInfoList = tellerDao.selectTellerByTellerNo(strTellerNo);
		for (TellerInfo tellerInfo : tellerInfoList) {
			if ("1".equals(tellerInfo.getLoginStatus())) {
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("loginstatus", "0");
				paramMap.put("optdate", tradeDate);
				paramMap.put("opttime", tradeTime);
				int count = tellerDao.updateTelInfoByTeNoABrNo(strTellerNo, tellerInfo.getBrNo(), paramMap);
				if (count < 1) {
					dbo.rollback();
					throw new TellerTmpExitFailException("登录更新柜员状态失败");	
				}
			}
		}
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("loginstatus", "1");
		paramMap.put("optdate", tradeDate);
		paramMap.put("opttime", tradeTime);
		int count = tellerDao.updateTelInfoByTeNoABrNo(strTellerNo, strBrNo, paramMap);
		if (count < 1) {
			dbo.rollback();
			throw new TellerTmpExitFailException("登录更新柜员状态失败");	
		}
		
		logger.info("----------柜员日终签退删除----------");
		List<ExitTellerNo> exitTellerNoList = exitTellerNoDao.queryInfoByDateTellerBrno(DateTimeUtil.getSysDate(), strTellerNo, strBrNo);
		if (null != exitTellerNoList && exitTellerNoList.size() > 0) {
			int count1 = exitTellerNoDao.deleteByNoAndDate(DateTimeUtil.getSysDate(), strTellerNo, strBrNo);
			if (count1 < 1) {
				dbo.rollback();
				throw new ExitTellerDelFailException("柜员日终签退删除失败");	
			}
		}
		
		Entduty entduty = entdutyDao.queryEntdutyByCond(strTellerNo,strBrNo);
		
		ExitCtrlDtsy exitCtrlDtsy = exitCtrlDtsyDao.queryByNoAndStatus(entduty.getDutyNo(), "1");
		
		if (null != exitCtrlDtsy && !StringUtils.isEmpty(exitCtrlDtsy.getSysIdBuf())) {
			
			logger.info("----------更新注册系统----------");
	        if(exitCtrlDtsy.getSysIdBuf().contains("0005")) {
	        	Map<String, Object> paramMap3 = new HashMap<>();
	        	paramMap3.put("loginstatus", "0");
	        	paramMap3.put("sysoperdate", tradeDate);
	        	paramMap3.put("sysopertime", tradeTime);
	        	int count3 = tellerSysDao.updateTellerInfo(strTellerNo, "0005", paramMap3);
	        	if (count3 < 1) {
	    	    	dbo.rollback();
	    			throw new TellerSysAddFailException("更新注册系统失败");	
	    		}
	        }
	        
			String[] sysidbuf = exitCtrlDtsy.getSysIdBuf().split("\\|");
			
			if (null != sysidbuf && sysidbuf.length > 0) {

				for (String str : sysidbuf) {
					
					logger.info("----------柜员日终签退保存----------");
					ExitTellerNo exitTellerNo = new ExitTellerNo();
					exitTellerNo.setTradeDate(tradeDate);
					exitTellerNo.setTellerNo(strTellerNo);
					exitTellerNo.setSysId(str);
					exitTellerNo.setSyscName(sysMap.get(str));
					exitTellerNo.setStatus("1");
					exitTellerNo.setZoneNo(entduty.getZoneNo());
					exitTellerNo.setMBrNo(entduty.getMBrNo());
					exitTellerNo.setBrNo(strBrNo);
					exitTellerNo.setDutyNo(entduty.getDutyNo());
					exitTellerNo.setNote1("");
					exitTellerNo.setNote2("");
					exitTellerNo.setUpdDate(tradeDate);
					exitTellerNo.setUpdTime(tradeTime);
					exitTellerNo.setEntDutyNo(entduty.getEntDutyNo());
			
					int count2 = exitTellerNoDao.insertExitTellerInfo(exitTellerNo);
					if (count2 < 1) {
						dbo.rollback();
						throw new ExitTellerAddFailException("柜员日终签退保存失败");	
					}
				}
				
				List<ExitBrno> exitBrnoList = exitBrnoDao.queryExitBrNoByDate(DateTimeUtil.getSysDate(),strBrNo);
				if (null == exitBrnoList || exitBrnoList.size() == 0) {
					logger.info("----------网点日终签退保存----------");
					for (int i = 0; i < sysidbuf.length; i++) {
						String string = sysidbuf[i];
						ExitBrno exitBrno = new ExitBrno();
						exitBrno.setTradeDate(tradeDate);
						exitBrno.setBrno(strBrNo);
						exitBrno.setSysId(string);
						exitBrno.setSyscName(sysMap.get(string));
						exitBrno.setStatus("1");
						exitBrno.setZoneNo(entduty.getZoneNo());
						exitBrno.setMBrno(entduty.getMBrNo());
						exitBrno.setNote1("");
						exitBrno.setNote2("");
						exitBrno.setUpdDate(tradeDate);
						exitBrno.setUpdTime(tradeTime);
						int count3 = exitBrnoDao.insertExitBrnoInfo(exitBrno);
						if (count3 < 1) {
							dbo.rollback();
							throw new ExitBrnoAddFailException("网点日终签退保存失败");	
						}
					}
					
				}else {
					logger.info("----------网点日终签退更新----------");
					for (int i = 0; i < exitBrnoList.size(); i++) {
						ExitBrno tmp = exitBrnoList.get(i);
						tmp.setStatus("1");
						tmp.setUpdDate(tradeDate);
						tmp.setUpdTime(tradeTime);
						int count4 = exitBrnoDao.updateInfo(tmp);
						if (count4 < 1) {
							dbo.rollback();
							throw new ExitBrnoUpdateFailException("网点日终签退更新失败");	
						}
					}
				}
			}
		}
		
		if (openBrNo) {
			logger.info("----------更新网点状态----------");
			Map<String, Object> updateMap = new HashMap<>();
			updateMap.put("loginStatus","1");
			paramMap.put("upddate", tradeDate);
			paramMap.put("updtime", tradeTime);
			int count5 = branchDao.updateBranchInfo(strBrNo, updateMap);
			if (count5 < 1) {
		    	dbo.rollback();
				throw new TellerSysAddFailException("更新网点状态失败");	
			}
		}
		
		dbo.commit();
	}

	/**
	 * 柜员注册信息检查
	 * @param strtellerno	柜员号
	 * @param strsysid 系统标识
	 * @param strbrno 登陆机构号
	 * @param tellertype 柜员类别
	 */
	public Map<String,Object> tellerRegisterCheck(String strtellerno, String strsysid, String strbrno, String tellertype) {
		Map<String,Object> resultMap = new HashMap<>();

		logger.info("----------行员查询----------");
		StaffInfo staffInfo = staffInfoDao.queryTellerByNo(strtellerno);
		if (null == staffInfo) {
			throw new TellerAddFailException("注册失败，行员号错误");	
		}
		
		logger.info("----------检查柜员类型与岗位类型是否符合----------");
		if(staffInfo.getTellerType().equals("04")) {
			if(tellertype.equals("Z")) {
				throw new TellerAddFailException("注册失败，虚拟柜员不允许注册为非综合前台业务柜员");
			}
		}
		
		logger.info("----------网点号是否存在----------");
		Branch brNo = branchDao.queryBranchOfNetWork(strbrno, "0", "1");
		if (null == brNo) {
			throw new BranchNotFoundException("网点:" + strbrno);	
		}
		
		Branch mBrNo = branchDao.queryBranchByCondBrsta(brNo.getUpBrno(), "1");
		if (null == mBrNo || StringUtils.isEmpty(mBrNo.getType()) || !("2|02|12").contains(mBrNo.getType())) {
			throw new BranchNotFoundException("支行:" + brNo.getUpBrno());	
		}
		
		Branch zoneNo = branchDao.queryBranchByCondBrsta(mBrNo.getUpBrno(), "1");
		if (null == zoneNo || StringUtils.isEmpty(zoneNo.getType()) || !("1|01").contains(zoneNo.getType())) {
			throw new BranchNotFoundException("分行:" + mBrNo.getUpBrno());	
		}
		
		logger.info("----------该柜员是否已注册综合业务系统----------");
		TellerSys tellerSys = tellerSysDao.queryTellerSys(strtellerno, strsysid);
		if(null != tellerSys && "1".equals(tellerSys.getStatus())) {
			throw new TellerAddFailException("注册失败，该柜员已注册综合业务系统");		
		}
		
		String tlrTp = "";
		if ("Z".equals(tellertype)) {
			tlrTp = "2";
		}
		if ("C".equals(tellertype)) {
			tlrTp = "1";
		}
		resultMap.put("tellerno", strtellerno);
		resultMap.put("tellertype", tellertype);
		resultMap.put("name", staffInfo.getName());
		resultMap.put("brno", strbrno);
		resultMap.put("brname", brNo.getBrna());
		resultMap.put("realFlag", "1");
		resultMap.put("tlrTp", tlrTp);
		
		return resultMap;
		
	}

	/**
	 * 柜员注销信息检查
	 * @param strtellerno	柜员号
	 * @param strbrno 登陆机构号
	 * @param tellertype 柜员类别
	 */
	public Map<String, Object> tellerLogOutCheck(String strtellerno, String strbrno, String brno) {

		Map<String, Object> resultMap = new HashMap<>();
		logger.info("----------柜员号是否存在----------");
		List<TellerInfo> list = tellerDao.selectTellerByTellerNo(strtellerno);
		if (null == list || 0 == list.size()) {
			throw new TellerNotExistException(strtellerno);			
		}
		
		logger.info("----------注销柜员是否在岗----------");
		Entduty entduty = entdutyDao.queryEntdutyByCond(strtellerno, strbrno);
		if (null != entduty && "1".equals(entduty.getStatus())) {
			throw new EntdutyOnException("注销失败，注销柜员在岗");	
		}
		
		String isReal = "0";
		logger.info("----------检查柜员是否为虚拟柜员----------");
		StaffInfo staffInfo = staffInfoDao.queryTellerByNo(strtellerno);
		if ("04".equals(staffInfo.getTellerType())) {
			isReal = "1";
			logger.info("----------检查柜员是否绑定绑定自助设备----------");
			List<DevInfo> devInfoList = devInfoDao.queryDevInfoByDeTelNo(strtellerno);
			if (null != devInfoList && devInfoList.size() > 0) {
				throw new TellerDelFailException("注销柜员绑定自助设备");
			}
		}
		int size = list.size();
		if (size > 1) {
			logger.info("----------柜员删除----------");
			int count = tellerDao.deleteByCon(strtellerno, strbrno);
			if (0 == count) {
				dbo.rollback();
				throw new TellerDelFailException("柜员删除失败");	
			}
			
			resultMap.put("result", "2");
			dbo.commit();
		}else {
			logger.info("----------柜员是否已注销----------");
			TellerInfo dbInfo = list.get(0);
			if (null != dbInfo && !StringUtils.isEmpty(dbInfo.getStatus()) && "0".equals(dbInfo.getStatus())) {
				throw new TellerDelFailException("柜员已注销，无需操作");	
			}
			resultMap.put("result", "1");
			String tlrTp = "";
			String tellerType = dbInfo.getTellerType();
			
			if ("Z".equals(tellerType)) {
				tlrTp = "2";
			}
			if ("C".equals(tellerType)) {
				tlrTp = "1";
			}
			resultMap.put("tlrTp", tlrTp);
			resultMap.put("tlrAttr", isReal);
		}
		return resultMap;
	}

	/**
	 * 柜员类别维护更新
	 * @param strtellerno 柜员号
	 * @param tellertype 柜员类型
	 * @param strbrno 柜员所属网点
	 * @exception
	 */
	public void tellerCategoryMaintainUpdate(String strtellerno, String tellertype, String strbrno) {
		logger.info("----------更新柜员类型----------");
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("tellertype", tellertype);
		paramMap.put("optdate", DateTimeUtil.getSysDate());
		paramMap.put("opttime", DateTimeUtil.getSysTime());
		int count = tellerDao.updateTelInfoByTeNoABrNo(strtellerno, strbrno, paramMap);
		if (0 == count) {
			dbo.rollback();
			throw new NotUpdateTellerException("更新柜员类型失败");
		}
		dbo.commit();
	}

	/**
	 * @summary 末位柜员撤岗调出
	 * @param tellerno  柜员号
	 * @param strbrno	调出网点号
	 * @param adjbrno	调入网点号
	 */
	public void lastTellerDepartureCheck(String tellerno, String strbrno, String adjbrno) {
		logger.info("----------查询实体岗信息，返回柜员号，网点号，岗位类型编号，状态，钱箱，实体岗编号----------");
		Entduty entdutyInfo = entdutyDao.queryEntdutyByCond(tellerno, strbrno);
		
		//调入网点的支行分行检查
		Branch adjBrNo = branchDao.queryBranchByCondBrsta(adjbrno, "1");
		if (null == adjBrNo.getUpBrno()) {
			throw new LastTellerCallOutException("调入网点没有上级支行");
		}
		Branch adjMBrNo = branchDao.queryBranchByCondBrsta(adjBrNo.getUpBrno(), "1");
		if (null == adjMBrNo.getUpBrno()) {
			throw new LastTellerCallOutException("调入网点没有上级分行");
		}
		
		//实体岗编号
		String entdutyno = entdutyInfo.getEntDutyNo();
		
		//删除该柜员实体岗信息
		logger.info("----------删除该柜员实体岗信息----------");
		int entdutyDelete = entdutyDao.entdutyDelete(entdutyno);
		if(1 != entdutyDelete) {
			dbo.rollback();
			throw new TellerDelFailException("删除柜员实体岗信息失败");
		}
		
		logger.info("----------更新柜员信息----------");
		//更新柜员信息
		Map<String, Object> map = new HashMap<>();
		map.put("brno", adjbrno);
		map.put("mbrno", adjBrNo.getUpBrno());
		map.put("zoneno", adjMBrNo.getUpBrno());
		map.put("loginstatus", "0");
		map.put("optdate", DateTimeUtil.getSysDate());
		map.put("opttime", DateTimeUtil.getSysTime());
		int updateCount = tellerDao.updateTelInfoByTeNoABrNo(tellerno, strbrno, map);
		if(1 != updateCount) {
			dbo.rollback();
			throw new TellerUpdateError("更新柜员信息失败");
		}
		
		dbo.commit();
	}

	public List<TellerLog> selectCurrTellerLog() {
		List<TellerLog> tellerLogList = tellerLogDao.selectCurrTellerLog("TELR0008", "W");
		List<TellerLog> overDueList = new ArrayList<>();// 逾期调出记录
		List<TellerLog> currDateList = new ArrayList<>();// 当天调出记录
		String currentDate = DateTimeUtil.getSysDate();// 当天日期
		
		// 整理当天调出记录和逾期调出记录
		for (TellerLog tellerLog : tellerLogList) {
			int date =  Integer.parseInt(tellerLog.getAdjDate()) - Integer.parseInt(currentDate);
			if (0 == date) {
				currDateList.add(tellerLog);
			} else if (date < 0) {
				overDueList.add(tellerLog);
			}
		}
		
		// 逾期调出记录状态改为失败
		Map<String, Object> paraMap = new HashMap<>();
		paraMap.put("transstatus", "F");
		for (TellerLog overTellerLog : overDueList) {
			int count = tellerLogDao.updateTellerLogMap(overTellerLog.getSerialNo(), overTellerLog.getOptDate(), paraMap);
			if (1 != count) {
				dbo.rollback();
				throw new TellerCallOutException("更新柜员操作流水表出错");
			}
		}
		
		return currDateList;
	}
	
	public void updateExitTelNo(String strTellerNo, String strBrNo, String sysId, String exitDesc, String respSts) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("status", "1");
		if ("S".equals(respSts)) {
			paramMap.put("status", "0");
		}
		paramMap.put("upddate", DateTimeUtil.getSysDate());
		paramMap.put("updtime", DateTimeUtil.getSysTime());
		paramMap.put("exitdesc", exitDesc);
		int count = exitTellerNoDao.updateExitTellerInfo(strTellerNo, strBrNo, DateTimeUtil.getSysDate(), sysId, paramMap);
		if (1 != count) {
			dbo.rollback();
			throw new ExitTellerAddFailException("更新柜员受控系统失败");
		}
		dbo.commit();
	}
	
	public void updateExitBrNo(String strBrNo, String sysId, String exitDesc, String respSts) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("status", "1");
		if ("S".equals(respSts)) {
			paramMap.put("status", "0");
		}
		paramMap.put("upddate", DateTimeUtil.getSysDate());
		paramMap.put("updtime", DateTimeUtil.getSysTime());
		paramMap.put("exitdesc", exitDesc);
		int count = exitBrnoDao.updateExitBrNoInfo(strBrNo, DateTimeUtil.getSysDate(), sysId, paramMap);
		if (1 != count) {
			dbo.rollback();
			throw new ExitTellerAddFailException("更新机构受控系统失败");
		}
		dbo.commit();
	}

	public Map<String, Object> queryExitTellerInfo(String strTellerNo, String strBrNo, String strDate, String myBank, String brNo) {
		Map<String, Object> resultMap = new HashMap<>();
		
		// 法人号隔离
		if (!myBank.equals(strTellerNo.substring(0, 3))) {
			throw new ApIllegalParamException("不能查询其他法人号柜员");
		}
		
		// 只有运营管理中心权限才能查其他机构柜员
		Branch logBranch = branchDao.queryBranchByNo(brNo);
		if (!brNo.equals(strBrNo) && null != logBranch && !"4".equals(logBranch.getBrtp())) {
			resultMap.put("exit_list", new ArrayList<>() );
			resultMap.put("branch_list", new ArrayList<>());
			return resultMap;
		}
		
		// 签退结果列表
		List<ExitTellerNo> exitResultList = exitTellerNoDao.queryInfoByDateTellerBrno(strDate, strTellerNo, strBrNo);
		List<Map<String, Object>> exitTellerNoList = new ArrayList<>();
		for (ExitTellerNo exitTellerNo : exitResultList) {
			Map<String, Object> map = new HashMap<>();
			map.put("strsysid", exitTellerNo.getSysId());
			map.put("status", exitTellerNo.getStatus());
			map.put("exitdesc", exitTellerNo.getExitDesc());
			exitTellerNoList.add(map);
		}
		
		// 未签退机构列表
		List<Map<String, Object>> exitBrNoList = entdutyMutiDao.getExitTellerBrNoList(strDate, strTellerNo, strBrNo, "1");
		resultMap.put("exit_list", exitTellerNoList);
		resultMap.put("branch_list", exitBrNoList);
		
		return resultMap;
	}
}
