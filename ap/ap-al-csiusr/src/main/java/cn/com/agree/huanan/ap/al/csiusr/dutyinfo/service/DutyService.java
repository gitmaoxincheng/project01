package cn.com.agree.huanan.ap.al.csiusr.dutyinfo.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.branch.dao.BranchDao;
import cn.com.agree.huanan.ap.al.csiusr.branch.exception.BranchNotFoundException;
import cn.com.agree.huanan.ap.al.csiusr.branch.po.Branch;
import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.dao.DutyinfoDao;
import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.dao.DutyinfoInitDao;
import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.exception.DeleteDutyInfoFailException;
import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.exception.DutyAddException;
import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.exception.DutyInitException;
import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.exception.DutyQueryException;
import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.exception.StatusQueryException;
import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.po.DutyInfo;
import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.po.DutyInfoInit;
import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.vo.DutyVo;
import cn.com.agree.huanan.ap.al.csiusr.entduty.dao.EntdutyDao;
import cn.com.agree.huanan.ap.al.csiusr.entduty.po.Entduty;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;


/**
 * 岗位服务层
 * @author lixq
 */
@Service
public class DutyService {

	@Autowired DutyinfoDao dutyinfoDao;
	@Autowired BranchDao branchDao;
	@Autowired DutyinfoInitDao dutyinfoInitDao;
	@Autowired Logger logger;
	@Autowired DbOperator dbo;
	@Autowired EntdutyDao entdutyDao;
	/**
	 * 岗位类别初始化
	 * @param brno
	 * @return
	 */
	public Map<String, Object> dutyInit(String brno) {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		logger.info("----------检查该分行----------");
		Branch branch = branchDao.queryBranchByNo(brno);
		if (null == branch || StringUtils.isEmpty(branch.getType()) || !("1|01").contains(branch.getType())) {
			throw new BranchNotFoundException("分行:"+brno);	
		}
		if (!"1".equals(branch.getBrsta())) {
			throw new DutyInitException("分行"+brno+"状态不正常");
		}

		logger.info("----------该分行号是否已存在岗位类别----------");
		List<DutyInfo> list = dutyinfoDao.queryByBrno(brno);
		if (null != list && list.size() > 0) {
			throw new DutyInitException("该分行号已存在岗位类别，不允许提交");
		}

		String max = dutyinfoDao.getMaxNo(brno);
		String bankFlag = "0";
		if (!"001".equals(brno.substring(0, 3))) {
			bankFlag = "1";
		}
		List<DutyInfoInit> paraList = dutyinfoInitDao.queryList(bankFlag);
		List<DutyVo> voList = new ArrayList<>();
		if (null != paraList && paraList.size() > 0) {

			for (int i = 0; i < paraList.size(); i++) {

				DutyInfoInit dutyInfoInit = paraList.get(i);

				DutyInfo info = new DutyInfo();
				info.setType(dutyInfoInit.getType());
				info.setDutyNo(max + dutyInfoInit.getDutyNo());
				info.setDutyName(branch.getBrna() + dutyInfoInit.getDutyName());
				info.setStatus(dutyInfoInit.getStatus());
				info.setCityNo(brno);
				
				info.setBranchType(dutyInfoInit.getBranchType());
				info.setCashFlg(dutyInfoInit.getCashFlg());
				info.setCshBoxFlg(dutyInfoInit.getCshBoxFlg());
				info.setDutyLevel(dutyInfoInit.getDutyLevel());
				info.setMobmktflg(dutyInfoInit.getMobmktflg());
				info.setPropty(dutyInfoInit.getPropty());
				info.setSpecialFlg(dutyInfoInit.getSpecialFlg());
				info.setUpDutyNo(max + dutyInfoInit.getUpDutyNo());
				info.setVchBoxFlg(dutyInfoInit.getVchBoxFlg());
				info.setWarehouserFlg(dutyInfoInit.getWarehouserFlg());
				info.setCashFlg(dutyInfoInit.getCashFlg());
				
				info.setUpdDate(DateTimeUtil.getSysDate());
				info.setUpdTime(DateTimeUtil.getSysTime());
				logger.info("----------岗位类型初始化----------");
				int count = dutyinfoDao.insertDutyInfo(info);
				if (0 == count) {
					dbo.rollback();
					throw new DutyInitException("岗位类型初始化失败");
				}

				DutyVo vo = new DutyVo();
				vo.setDutyNo(max + dutyInfoInit.getDutyNo());
				vo.setDutyName(branch.getBrna() + dutyInfoInit.getDutyName());
				voList.add(vo);
			}
		}

		dbo.commit();

		resultMap.put("brno", branch.getBrno());
		resultMap.put("brna", branch.getBrna());
		resultMap.put("prefix", max);
		resultMap.put("rowcnt", voList.size());
		resultMap.put("listnm", voList.size());
		resultMap.put("bodrcd_list", voList);

		return resultMap;
	}

	public String dutyAdd(String dutyName, String dutyDesc, String propty, String dutyLevel, String upDutyNo, String strZoneNo, 
			String branchType, String cshBoxFlg, String vchBoxFlg, String cashFlg, String specialFlg, String warehouserFlg, 
			String mobmktflg, String authLevel, String adminflg) {
		
		// 检查上级岗位是否存在，将系统编号用|分隔
		String[] upDutyNoList = upDutyNo.split("\\|"); 
		for (String upDutyNoTemp : upDutyNoList) {
			DutyInfo upDutyInfo = dutyinfoDao.queryByDutyNo(upDutyNoTemp);
			if (null == upDutyInfo) {
				throw new DutyAddException("上级岗位是不存在");
			}
		}

		// “岗位类型编号”系统自动生成
		String dutyNo = dutyinfoDao.getMaxParaCode(upDutyNo);

		// 检查岗位是否存在
		DutyInfo dutyInfo = dutyinfoDao.queryByDutyNo(dutyNo);
		if (null != dutyInfo) {
			if ("1".equals(dutyInfo.getStatus())) {
				throw new DutyAddException("存在有效的重复岗位编号");
			} else {
				// 删除原交易
			}
		}

		// 新增岗位类型基本信息
		DutyInfo addDutyInfo = new DutyInfo();
		addDutyInfo.setType("C");
		addDutyInfo.setDutyNo(dutyNo);
		addDutyInfo.setDutyName(dutyName);
		addDutyInfo.setDutyDesc(dutyDesc);
		addDutyInfo.setStatus("1");
		addDutyInfo.setPropty(propty);
		addDutyInfo.setDutyLevel(dutyLevel.toUpperCase());
		addDutyInfo.setUpDutyNo(upDutyNo);
		addDutyInfo.setCityNo(strZoneNo);
		addDutyInfo.setBranchType(branchType);
		addDutyInfo.setCshBoxFlg(cshBoxFlg);
		addDutyInfo.setVchBoxFlg(vchBoxFlg);
		
		addDutyInfo.setCashFlg(cashFlg);
		addDutyInfo.setSpecialFlg(specialFlg);
		addDutyInfo.setWarehouserFlg(warehouserFlg);
		addDutyInfo.setMobmktflg(mobmktflg);
		addDutyInfo.setAuthLevel(authLevel);
		addDutyInfo.setAdminFlg(adminflg);
		
		addDutyInfo.setUpdDate(DateTimeUtil.getSysDate());
		addDutyInfo.setUpdTime(DateTimeUtil.getSysTime());
		int count = dutyinfoDao.dutyAdd(addDutyInfo);
		if (1 != count) {
			throw new DutyAddException("插入数据库错误");
		}
		return dutyNo;
	}
	
	/**
	 * 检查岗位类型状态是否有效
	 * @param strdutyno 岗位类型编号
	 * @return
	 */
	public DutyInfo getDutyinfoByStrdutyno(String strdutyno) {
		return dutyinfoDao.queryByDutyNo(strdutyno);
	}
	
	/**
	 * 删除岗位信息
	 * @param strdutyno 岗位类型编号
	 */
	public void deleteDutyInfo(String strdutyno) {
		
		// 检查岗位类型是否存在实体岗
		logger.info("----------检查岗位类型是否存在实体岗----------");
		List<Entduty> list =  entdutyDao.queryByStrdutyno(strdutyno);
		if(0 != list.size()) {
			throw new DutyQueryException("岗位存在实体岗");
		}
		
		//判断岗位类型状态是否为失效
		logger.info("----------判断岗位类型状态是否为失效----------");
		DutyInfo dutyInfo = dutyinfoDao.queryByDutyNo(strdutyno);
		if(null == dutyInfo || !"1".equals(dutyInfo.getStatus())) {
			throw new StatusQueryException("岗位类型状态为无效状态");
		}
		
		//删除岗位信息
		logger.info("----------删除岗位信息----------");
		Map<String, Object> paraMap = new HashMap<>();
		paraMap.put("status", "0");
		paraMap.put("upddate", DateTimeUtil.getSysDate());
		paraMap.put("updtime", DateTimeUtil.getSysTime());
		int count = dutyinfoDao.updateDutyInfo(strdutyno, paraMap);
		if (1 != count) {
			dbo.rollback();
			throw new DeleteDutyInfoFailException("删除岗位信息失败");
		}
		
		dbo.commit();
	}
		
	
	/**
	 * 查询岗位基本信息
	 * @param pageFlag 页码
	 * @param maxNum 每页最多记录数
	 * @param strZoneno 分行号
	 * @param strDutyno 岗位类型编号
	 * @param status 状态
	 * @param strupdutyno 上级岗位编号
	 * @return
	 */
	public Map<String, Object> getDutyInfoPageList(int pageFlag, int maxNum, String strZoneno,
			String strDutyno, String status, String strupdutyno, String myBank) {
		
		if (maxNum < 1 || pageFlag < 1) {
			throw new ApIllegalParamException("maxNum/pageFlag 要大于 1");
		}
		
		String branchType = "";
		//岗位类型属性中的“机构类型”（1非社区/小微、2社区/小微、3通用）进行匹配
		if (!StringUtils.isEmpty(strupdutyno)) {
			DutyInfo dutyInfo = dutyinfoDao.queryByDutyNo(strupdutyno);
			branchType = dutyInfo.getBranchType();
		}
		
		IPage<Map<String, Object>> iPage = dutyinfoDao.getDutyInfoPageList(pageFlag, maxNum, strZoneno, strDutyno, status, strupdutyno, myBank, branchType);
		Map<String, Object> resultMap = new HashMap<String, Object>();	
		
		resultMap.put("rowcnt", iPage.getTotal());// 总笔数
		resultMap.put("listnm", iPage.getSize());// 返回记录数
		resultMap.put("bodrcd_list", iPage.getRecords());// 返回数据
		return resultMap;

	}
	/**
	 * 坐班岗位类型查询
	 * @param pageflag 页码
	 * @param maxNum 每页最多记录数
	 * @param strbmo 机构号
	 */
	public Map<String,Object> getDutyInfoOnList(String strbrno){
		Map<String, Object> result = dutyinfoDao.getDutyInfoOnPageList(strbrno);
		if(0 == ((List)result.get("bodrcd_list")).size()) {
			logger.debug("查询记录为空");
		}
		return result;
	}
}
