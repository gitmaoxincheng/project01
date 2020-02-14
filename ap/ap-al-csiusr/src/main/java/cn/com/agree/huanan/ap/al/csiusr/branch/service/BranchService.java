package cn.com.agree.huanan.ap.al.csiusr.branch.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import cn.com.agree.huanan.ap.al.csiusr.branch.dao.BranchDao;
import cn.com.agree.huanan.ap.al.csiusr.branch.exception.BranchHasExistException;
import cn.com.agree.huanan.ap.al.csiusr.branch.exception.BranchInitException;
import cn.com.agree.huanan.ap.al.csiusr.branch.exception.BranchInsertException;
import cn.com.agree.huanan.ap.al.csiusr.branch.exception.BranchNotFoundException;
import cn.com.agree.huanan.ap.al.csiusr.branch.exception.BranchUpdateException;
import cn.com.agree.huanan.ap.al.csiusr.branch.po.Branch;
import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.dao.DevInfoDao;
import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.dao.DutyinfoDao;
import cn.com.agree.huanan.ap.al.csiusr.entduty.dao.EntdutyDao;
import cn.com.agree.huanan.ap.al.csiusr.entduty.exception.EntdutyEmptyException;
import cn.com.agree.huanan.ap.al.csiusr.entduty.po.Entduty;
import cn.com.agree.huanan.ap.al.csiusr.entduty.service.EntdutyService;
import cn.com.agree.huanan.ap.al.csiusr.exitbrno.dao.ExitBrnoDao;
import cn.com.agree.huanan.ap.al.csiusr.parasyn.dao.ParasynDao;
import cn.com.agree.huanan.ap.al.csiusr.parasyn.service.ParasynService;
import cn.com.agree.huanan.ap.al.csiusr.teller.dao.TellerDao;
import cn.com.agree.huanan.ap.al.csiusr.teller.dao.TellerSysDao;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerNotExistException;
import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerInfo;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.ApException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class BranchService {
	//机构同步
	private static final String ADD_BRANCH = "1";//机构新增
	private static final String UPDATE_BRANCH_INFO = "2";//机构修改
	private static final String BRANCH_LOGOUT = "3";//机构注销
	//机构数同步
	private static final String INSERT_BRANCH = "1";
	private static final String UPDATE_BRANCH = "2";
	private static final String DELETE_BRANCH = "3";
	@Autowired BranchDao branchDao;
	@Autowired TellerDao tellerDao;
	@Autowired TellerSysDao tellerSysDao;
	@Autowired EntdutyDao entdutyDao;
	@Autowired DutyinfoDao dutyinfoDao;
	@Autowired ExitBrnoDao exitBrnoDao;
	@Autowired EntdutyService entdutyService;
	@Autowired ParasynService parasynService;
	@Autowired DevInfoDao devInfoDao;
	@Autowired ParasynDao parasynDao;
	@Autowired Logger logger;
	@Autowired DbOperator dbo;

	public Branch getBranchByNo(String brNo) {
		return branchDao.queryBranchByNo(brNo);
	}

	public Map<String, Object> initBranchDuty(String tellerNo, String brno, String dutyNo) {
		//Map<String, Object> resultMap = new HashMap<>();
		
		boolean isExist = false;
		List<Entduty> entduties = entdutyDao.queryEntdutyBybrNo(brno,"1");
		if (null != entduties && entduties.size() > 0) {
			
			for (Entduty entduty : entduties) {
				if (null != entduty && !StringUtils.isEmpty(entduty.getTellerNo())) {
					isExist = true;
					break;
				}
			}
		}
		
		logger.info("----------检查机构是否已初始化----------");
		if (isExist) {
			throw new BranchInitException("机构已初始化，无需操作");
		}
		
		logger.info("----------柜员是否存在----------");
		TellerInfo tellerInfo = tellerDao.queryTellerByNo(tellerNo, brno);
		if (null == tellerInfo) {
			throw new TellerNotExistException(tellerNo);
		}

		logger.info("----------网点号是否存在----------");
		Branch branch = branchDao.queryBranchOfNetWork(brno, "0", "1");
		if (null == branch) {
			throw new BranchNotFoundException(brno);
		}

		logger.info("----------检查柜员是否为上岗状态----------");
		Entduty entduty = entdutyDao.queryEntdutyByCond(tellerNo, brno);
		if (null != entduty) {
			throw new EntdutyEmptyException("柜员为上岗状态");
		}

		return entdutyService.entdutyAdd(brno, dutyNo, "", tellerNo);

	}

	/**
	 * 机构信息查询
	 * 
	 * @param pageFlag 当前页码
	 * @param pageSize 每页最多记录数
	 * @param quryType 查询类型
	 * @param strBrNo 查询机构号
	 * @param myBank 法人号
	 * @return 总笔数，返回记录数，循环体
	 */
	public Map<String, Object> queryBranchInfo(int pageFlag, int pageSize, String quryType, String strBrNo, String myBank) {
		Map<String, Object> result = new HashMap<>();
		if ("1".equals(quryType)) {
			if (StringUtils.isEmpty(strBrNo)) {
				throw new ApIllegalParamException("上送机构号不能为空");
			}
			Branch branch = branchDao.queryBranchByNo(strBrNo);
			if (null == branch || !myBank.equals(branch.getMyBank())) {
				throw new BranchNotFoundException(strBrNo);
			}
			Map<String, Object> mapList = new HashMap<String, Object>();
			mapList.put("strbrno", branch.getBrno());
			mapList.put("mybank", branch.getMyBank());
			mapList.put("strtype", branch.getType());
			mapList.put("upbrno", branch.getUpBrno());
			mapList.put("brnonames", branch.getBrnas());
			mapList.put("bustat", branch.getBusta());
			mapList.put("brnostat", branch.getBrsta());
			mapList.put("brnoname", branch.getBrna());
			mapList.put("brnopry", branch.getBrpry());
			mapList.put("brnotype", branch.getBrtp());
			mapList.put("loginstatus", branch.getLoginStatus());
			mapList.put("braddr", branch.getBrAddr());//机构详细地址
			mapList.put("bankcode", branch.getBkcod());
			
			//微网点业务需要
			mapList.put("outphone", branch.getOutPhone());
			mapList.put("starttime", branch.getStrTime());
			mapList.put("endtime", branch.getEndTime());
			mapList.put("sattime", branch.getSatTime());
			mapList.put("satendtime", branch.getSatendTime());
			mapList.put("suntime", branch.getSunTime());
			mapList.put("sunendtime", branch.getSunendTime());
			mapList.put("branchlong", branch.getBranchLong());
			mapList.put("branchlang", branch.getBranchLang());
			
			result.put("rowcnt", "1");
			result.put("bodrcd_list", mapList);
			result.put("listnm", "1");
			return result;

		} else if ("2".equals(quryType)) {

			if (pageSize < 1 || pageFlag < 1) {
				throw new ApIllegalParamException("maxNum/pageFlag 要大于 1");
			}
			
			if (!myBank.equals(strBrNo.substring(0, 3))) {
				throw new BranchNotFoundException(strBrNo);
			}
			
			IPage<Map<String, Object>> pageInfo = branchDao.queryBranchInfo(pageFlag, pageSize, strBrNo);
			result.put("rowcnt", pageInfo.getTotal());// 总笔数
			result.put("listnm", pageInfo.getSize());// 返回记录数
			result.put("bodrcd_list", pageInfo.getRecords());// 返回数据
			return result;
		} else if ("3".equals(quryType)) {

			if (pageSize < 1 || pageFlag < 1) {
				throw new ApIllegalParamException("maxNum/pageFlag 要大于 1");
			}

			IPage<Map<String, Object>> pageInfo = branchDao.queryZoneBranchInfo(pageFlag, pageSize, myBank);
			result.put("rowcnt", pageInfo.getTotal());// 总笔数
			result.put("listnm", pageInfo.getSize());// 返回记录数
			result.put("bodrcd_list", pageInfo.getRecords());// 返回数据
			return result;
		} else {
			throw new ApIllegalParamException("quryType");
		}
	}

	/**
	 * 机构同步
	 * 
	 * @param branchMap 机构信息
	 * @param pullType= 推送类型
	 * @param serialNo= 操作流水号
	 * @throws Exception 
	 */
	public int branchSync(Map<String, Object> branchMap, String pullType) throws ApException {
		logger.info("机构同步");
		int count = 0;
		Map<String, Object> branch = null ;
		// 判断推送类型
		switch (pullType) {
		// 推送类型为新增,执行新增机构
		case ADD_BRANCH:
			logger.info("推送类型为新增,执行新增机构");
			count = addBranch(branchMap);
			break;
		// 推送类型为修改,执行更新机构信息
		case UPDATE_BRANCH_INFO:
			logger.info("推送类型为修改,执行更新机构信息");
			count = changeBranchInfoByNo(branchMap.get("brno")+"", branchMap);
			break;
		// 推送类型为注销,执行更新机构状态为注销
		case BRANCH_LOGOUT:
			logger.info("推送类型为注销,执行更新机构状态为注销");
			branch = new HashMap<>();
			branch.put("brSta", "0");
			count = changeBranchInfoByNo(branchMap.get("brno")+"", branch);
			break;
		}
		return count;
	}

	/**
	 * 机构撤并未处理事项检查
	 * @param strBrNo 被并机构
	 * @param unBrNo 并入机构
	 * @return
	 */
	public Map<String,Object> branchRemoveAndMergeCheck(String strBrNo,String unBrNo){
		logger.debug("机构撤并未处理事项检查");
		//机构未处理事项
		List<Map<String,Object>>info_list = new ArrayList<>();
		//查询被并机构信息
		Branch branch = branchDao.queryBranchByNo(strBrNo);
		if(branch==null) {
			throw new BranchNotFoundException(strBrNo);
		}
		//检查被并机构状态
		if("0".equals(branch.getBrsta())) {
			logger.debug("被并机构状态异常");
			Map<String,Object>hintInfo = new HashMap<>();
			hintInfo.put("hintinfo", "被并机构状态异常");
			info_list.add(hintInfo);
		}
		//检查被并机构签到状态
		if(!"0".equals(branch.getLoginStatus())) {
			logger.debug("被并机构未签退");
			Map<String,Object>hintInfo = new HashMap<>();
			hintInfo.put("hintinfo", "被并机构未签退");
			info_list.add(hintInfo);
		}
		//查询并入机构信息
		Branch unBranch = branchDao.queryBranchByNo(unBrNo);
		if(unBranch==null) {
			throw new BranchNotFoundException(unBrNo);
		}
		//检查并入机构状态
		if("0".equals(unBranch.getBrsta())) {
			logger.debug("并入机构状态异常");
			Map<String,Object>hintInfo = new HashMap<>();
			hintInfo.put("hintinfo", "并入机构状态异常");
			info_list.add(hintInfo);
		}
		//检查并入机构签到状态
		if(!"0".equals(unBranch.getLoginStatus())) {
			logger.debug("并入机构未签退");
			Map<String,Object>hintInfo = new HashMap<>();
			hintInfo.put("hintinfo", "并入机构未签退");
			info_list.add(hintInfo);
		}
		//检查被并是否存在多条待处理合并记录
		int count = parasynDao.queryParaInfoNum(strBrNo);
		if(count>1) {
			logger.debug("被并机构存在两笔或以上的待处理合并记录");
			Map<String,Object>hintInfo = new HashMap<>();
			hintInfo.put("hintinfo", "被并机构存在两笔或以上的待处理合并记录");
			info_list.add(hintInfo);
		}
		//检查被并机构下是否有设备
		int num = devInfoDao.queryDevCountByAdmBrNo(strBrNo);
		int num1 = devInfoDao.queryDevCountByDstBrNo(strBrNo);
		if(num>0||num1>0) {
			logger.debug("被并机构存在自助设备“管理归属机构”、“资产归属机构”为本机构的自助设备");
			Map<String,Object>hintInfo = new HashMap<>();
			hintInfo.put("hintinfo", "被并机构存在自助设备“管理归属机构”、“资产归属机构”为本机构的自助设备");
			info_list.add(hintInfo);
		}
		//检查被并机构是否有正常状态柜员
		int tellerCount = tellerDao.queryNormalTellerByBrNo(strBrNo);
		if(tellerCount>0) {
			logger.debug("被并机构存在有效柜员(虚拟柜员或实体柜员)");
			Map<String,Object>hintInfo = new HashMap<>();
			hintInfo.put("hintinfo", "被并机构存在有效柜员(虚拟柜员或实体柜员)");
			info_list.add(hintInfo);
		}
		//检查被并机构是否存在有效实体岗
		int entdutyCount = entdutyDao.SelectEntdutyCountByBrno(strBrNo);
		if(entdutyCount>0) {
			logger.debug("被并机构存在有效实体岗");
			Map<String,Object>hintInfo = new HashMap<>();
			hintInfo.put("hintinfo", "被并机构存在有效实体岗");
			info_list.add(hintInfo);
		}
		Map<String,Object>rspMap = new HashMap<>();
		rspMap.put("listnm", info_list.size());
		rspMap.put("info_list", info_list);
		return rspMap;
	}
	
	/**
	 * 新增机构
	 * 
	 * @param branchMap 机构信息
	 */
	public int addBranch(Map<String, Object> branchMap) {
		// 判断机构是否已经存在
		Branch branch = branchDao.queryBranchByNo(branchMap.get("brno")+"");
		if (!StringUtils.isEmpty(branch)) {
			throw new BranchHasExistException("机构已存在，不能新增");
		}

		// 新增机构
		int count = branchDao.insertBranch(branchMap);
		if (count != 1) {
			dbo.rollback();
			throw new BranchInsertException("插入数据异常，新增机构失败");
		}
		dbo.commit();
		return count;
	}


	/**
	 * 根据机构号更新机构信息
	 * 
	 * @param brNo 机构号
	 * @param paramMap 机构信息
	 */
	public int changeBranchInfoByNo(String brNo, Map<String, Object> paramMap) {
		// 判断机构是否存在
		Branch branch = branchDao.queryBranchByNo(brNo);
		if (StringUtils.isEmpty(branch)) {
			throw new BranchNotFoundException(brNo);
		}
		// 更新机构信息
		int count = branchDao.updateBranchInfo(brNo, paramMap);
		if (count != 1) {
			dbo.rollback();
			throw new BranchUpdateException("更新机构信息操作失败");
		}
		dbo.commit();
		return count;
	}
	

	

	
	/** 机构树同步
	 * @param branchMap 机构信息
	 * @param pullType  推送类型
	 * @param serialNo  操作流水号
	 */
	public int branchTree(Map<String, Object> branchMap, String pullType) throws ApException {
		logger.info("---执行机构树同步---");
					
			int count = 0;
		    // 判断推送类型
			switch(pullType) {
			// 推送类型为新增,执行修改机构号和管辖机构号
			case INSERT_BRANCH:
				dbo.rollback();
				logger.info("1推送类型为新增,根据机构号修改机构类型和管辖机构号");
				count = updateBranchType(branchMap);
				break;
			// 推送类型为修改,执行修改机构号和管辖机构号
			case UPDATE_BRANCH:
				logger.info("2推送类型为修改,根据机构号修改机构类型和管辖机构号");
				count = updateBranchType(branchMap);								     
				break;
			// 推送类型为删除,执行删除机构信息
			case DELETE_BRANCH:
				logger.info("3推送类型为删除,根据机构号删除机构类型和管辖机构号");
				count = updateBranchType(branchMap);
				break;
		  }
		return count;
	}
	

	/**根据机构号 修改 机构类型和管辖机构号 
	 * @param branchMap 修改信息
	 * @param brNo		机构号
	 * @Param type      机构类型
	 * @param upBrno    管辖机构号
	 */
	public int updateBranchType(Map<String, Object> branchMap) {
		Branch branch = branchDao.queryBranchByNo(String.valueOf(branchMap.get("brno")));
		if (StringUtils.isEmpty(branch)) {
			logger.error("机构号不存在，不能修改信息");
			throw new BranchNotFoundException(String.valueOf(branchMap.get("brno")));
		}		
		// 根据机构号  执行修改机构类型和管辖机构号 
		int count = branchDao.updateBranchNo(branchMap);
		if (count != 1) {
			logger.error("修改机构类型和管辖机构号失败");
			dbo.rollback();
			throw new BranchInsertException("修改机构类型和管辖机构号失败");
		}
		dbo.commit();
		logger.info("修改机构类型和管辖机构号成功！");
		return count;
	}
	
	
	/**推送类型为删除,根据机构号删除机构类型和管辖机构号
	 * @param type 机构信息
	 * @param upBrno管辖机构号
	 */
	public int deleteBranch(Map<String, Object> branchMap){
		Branch branch = branchDao.queryBranchByNo(String.valueOf(branchMap.get("brno")));
		if (StringUtils.isEmpty(branch)) {
			logger.error("机构号不存在，不能删除信息");
			throw new BranchNotFoundException(String.valueOf(branchMap.get("brno")));
		}
		//执行删除机构类型和管辖机构号
		int count = branchDao.deleteBranchByNo(branchMap);
		if (count != 1) {
			logger.error("删除机构类型和管辖机构号失败!");
			dbo.rollback();
			throw new BranchUpdateException("删除机构类型和管辖机构号失败!");
		}
		logger.info("删除机构类型和管辖机构号成功！");
		return count;
	}	
	
	
	/**
	 * 机构信息生成
	 * 
	 */
	public Boolean branchInfoGenerate(String filepath) {
		//查询出机构信息
		List<Map<String, Object>> branchInfo = branchDao.findBranchInfoGenerate();
		
		File file = new File(filepath);
		
		if(!file.exists()) {
			file.getParentFile().mkdirs();
		}

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			
			//遍历打印
			for(Map<String, Object> map : branchInfo) {
				StringBuffer sbuf = new StringBuffer();
				for(Object value : map.values()) {
					sbuf.append((String)value);
					sbuf.append("|");
				}
				sbuf.append("\n");
				pw.write(sbuf.toString());
				pw.flush();
			}
			
			
		} catch (FileNotFoundException e) {
			return false;
		} finally {
			if(pw != null) {
				pw.close();
			}
		}
		logger.info("打印结束");
		if(file.exists()) {
			logger.info("生成文件成功");
			return true;
		}else {
			logger.info("生成文件失败");
			return false;
		}
		
		
	}
	
	/**
	 * 未签退查询
	 * @param brNo 查询机构
	 * @param pageSize 页大小
	 * @param pageFlag 当前页
	 * @param logBrNo 登录机构
	 * @return
	 */
	public Map<String, Object> queryBranchExitInfo(String brNo, int pageSize, int pageFlag, String logBrNo) {
		if (pageSize < 1 || pageFlag < 1) {
			throw new ApIllegalParamException("maxNum/pageFlag 要大于 1");
		}
	
		return exitBrnoDao.selectBranchExitInfo(brNo, pageSize, pageFlag, logBrNo);
	}
	
}
