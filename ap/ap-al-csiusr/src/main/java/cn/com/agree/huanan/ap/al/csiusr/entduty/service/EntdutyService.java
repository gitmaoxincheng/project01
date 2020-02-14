package cn.com.agree.huanan.ap.al.csiusr.entduty.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.branch.dao.BranchDao;
import cn.com.agree.huanan.ap.al.csiusr.branch.po.Branch;
import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.dao.DutyinfoDao;
import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.po.DutyInfo;
import cn.com.agree.huanan.ap.al.csiusr.entduty.dao.EntdutyDao;
import cn.com.agree.huanan.ap.al.csiusr.entduty.exception.CheckNoDataException;
import cn.com.agree.huanan.ap.al.csiusr.entduty.exception.EntdutyCreateException;
import cn.com.agree.huanan.ap.al.csiusr.entduty.exception.EntdutyDeleteError;
import cn.com.agree.huanan.ap.al.csiusr.entduty.exception.EntdutyEmptyException;
import cn.com.agree.huanan.ap.al.csiusr.entduty.exception.EntdutyInsertError;
import cn.com.agree.huanan.ap.al.csiusr.entduty.exception.WareHouserExistException;
import cn.com.agree.huanan.ap.al.csiusr.entduty.po.Entduty;
import cn.com.agree.huanan.ap.al.csiusr.teller.dao.TellerDao;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

/**
 * 实体岗服务层
 */
@Service
public class EntdutyService {
	
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	@Autowired EntdutyDao entdutyDao;
	@Autowired DutyinfoDao dutyinfoDao;
	@Autowired BranchDao branchDao;
	@Autowired TellerDao tellerDao;
	
	/**
	 * @ summary 判断网点是否存在上级支行，有则获取上级支行
	 * @param brno 网点号
	 */
	public String getSuperBranch(String strbrno) {
		String mbrno = branchDao.getSuperBranch(strbrno);
		return mbrno;
	}
	
	/**
	 * @summary 判断网点是否存在上级分行，有则获取上级分行
	 * @param mbrno 上级支行
	 * @return
	 */
	public String getLastSuperBranch(String mbrno) {
		String zoneno = branchDao.getLastSuperBranch(mbrno);
		if(null == zoneno) {
			zoneno="";
		}
		return zoneno;
	}
	
	/**
	 * @summary 根据岗位类型编号获取岗位类型信息
	 * @param dutyno 岗位类型编号
	 * @return
	 */
	public DutyInfo getBox(String dutyno) {
		DutyInfo list = dutyinfoDao.queryByDutyNo(dutyno);
		if(list==null) {
			throw new CheckNoDataException("没有数据");
		}
		return list;
	}
	
	/**
	 * @summary 实体岗新增入库
	 * @param brno 机构号（网点号）
	 * @param dutyno （岗位类型）
	 * @param entdutydesc （实体岗描述）
	 * @param mbrno （所属支行）
	 * @param zoneno （所属分行）
	 * @param cshboxno1	现金尾箱
	 * @param vchboxno1	凭证尾箱
	 * @param  entdutyno 实体岗编号
	 * @param entdutyname 实体岗名称
	 * @return
	 */
	public int insertEntduty(String entdutyno, String entdutyname, String entdutydesc, String dutyno, String cshboxno1,
			String vchboxno1, String brno, String mbrno, String zoneno,String tellerno, String warehouserflg) {
		Entduty entdutyMap=new Entduty();
		entdutyMap.setEntDutyNo(entdutyno);
		entdutyMap.setEntDutyName(entdutyname);
		entdutyMap.setBrNo(brno);
		entdutyMap.setDutyNo(dutyno);
		entdutyMap.setEntDutyDesc(entdutydesc);
		entdutyMap.setMBrNo(mbrno);
		entdutyMap.setZoneNo(zoneno);
		entdutyMap.setCshBoxNo1(cshboxno1);
		entdutyMap.setVchBoxNo1(vchboxno1);
		entdutyMap.setWareHouserFlg(warehouserflg);
		if("".equals(tellerno)) {
			entdutyMap.setStatus("2");
		}else {
			entdutyMap.setStatus("1");
		}
		entdutyMap.setUpdDate(DateTimeUtil.getSysDate());
		entdutyMap.setUpdTime(DateTimeUtil.getSysTime());
		entdutyMap.setTellerNo(tellerno);
		int count=entdutyDao.insertEntduty(entdutyMap);
		if(count!=1) {
			throw new EntdutyInsertError("实体岗新增失败！");
		}
		return count;
	}
	
	/**
	 * @summary 查询本机构最大的并生成岗位名称
	 * @param brno 机构号
	 * @param dutyName 岗位名称
	 * @return
	 */
	public String getMaxEntName(String brno,String entdutyName) {
		String substring = brno.substring(brno.length()-5,brno.length());
		int maxNum = entdutyDao.getMaxEntName(entdutyName,substring);
		String result = null;
		if(maxNum > 0) {
			int num = 0;
			if(maxNum < 10) {
				num = maxNum + 1;
				if(num < 10) {
					result = entdutyName + substring + "0" + num;
				}else {
					result = entdutyName + substring + num;
				}
			} else {
				num = maxNum + 1;
				result = entdutyName + substring + num;
			}
			return result;
		}else {
			return entdutyName + substring + "01";
		}
		
	}
	
	/**
	 * @summary 根据岗位类型编号查询岗位名称
	 * @param dutyno 岗位类型编号
	 * @return
	 */
	public String getEntdutyName(String dutyno) {
		String entdutyName=dutyinfoDao.getEntdutyName(dutyno);
		return entdutyName;
	}
	
	/**
	 * @summary 生成岗位类型编号
	 * @param brno 机构号
	 */
	public String getEntNumber(String brno) {
		//获取最大的岗位类型编号的后四位
		String entNumber = entdutyDao.getEntNumber(brno);
		//初始化岗位类型编号
		String result = null;
		logger.info("entNumber:"+entNumber);
		if(null != entNumber && !"".equals(entNumber)) {
			int num = Integer.parseInt(entNumber) + 1;
			String numString = String.valueOf(num);
			while (numString.length() < 4) {
				numString = "0" + numString;
			}
			result = brno + numString;
			logger.info("岗位类型编号："+result);
			return result;   
		}else {
			result = brno + "0001";
			logger.info("岗位类型编号：" + result);
			return result;
		}
		
	}
	/**
	 * @summary 查询实体岗信息
	 * @param entdutyno 实体岗编号
	 */
	public Entduty getEntdutyInfo(String entdutyno) {
		Entduty result = entdutyDao.queryEntdutyByEntdutyNo(entdutyno);
		if(result==null) {
			throw new EntdutyEmptyException("查询的实体岗信息不存在！");
		}
		return result;
		
	}
	  
	/**
	 * @summary 实体岗新增服务层
	 * @param brNo 机构号
	 * @param dutyNo 岗位类型编号
	 * @param entdutyDesc 实体岗描述
	 * @param tellerNo 柜员号
	 */
	public Map<String, Object> entdutyAdd(String brNo, String dutyNo, String entdutyDesc,String tellerNo) {
		//判断网点是否存在上级支行，有则获取上级支行
		logger.info("----------获取上级支行----------");   
		String mBrNo = getSuperBranch(brNo);
		if (StringUtils.isEmpty(mBrNo)) {
			throw new EntdutyCreateException(brNo + "无对应支行");
		}
		
		//定义上级分行
		String zoneNo = getLastSuperBranch(mBrNo);
		if (StringUtils.isEmpty(zoneNo)) {
			throw new EntdutyCreateException(brNo + "无对应分行");
		} 
		
		//先查询岗位类型表中是否有钱箱，根据现金尾箱和凭证尾箱的数量进行核心通讯，返回尾箱号（包括现金尾箱和凭证尾箱）
		logger.info("----------查询岗位类型表中是否有钱箱----------");
		DutyInfo dutyInfo = getBox(dutyNo);
		
		//判断岗位类型是否有效
		logger.info("----------判断岗位类型是否有效----------");
		if(!"1".equals(dutyInfo.getStatus())) {
			throw new EntdutyCreateException("岗位类型无效");
		}
		
		//一个机构只允许有一个库管员，即新增实体岗时岗位属性“是否库管员”为是时，需判断本机构是否已存有有效的具有库管员属性的实体岗，若已存在，则限制新增；
		logger.info("----------判断本机构是否已存有有效的具有库管员属性的实体岗----------");
		String wareHouseFlg = dutyInfo.getWarehouserFlg();
		if (StringUtils.isEmpty(wareHouseFlg)) {
			throw new EntdutyCreateException(dutyNo + "无是否库管员标识");
		}
		if ("1".equals(wareHouseFlg)) {
			Entduty whfEntduty = entdutyDao.queryEntdutyByBrNoAndWarFlg(brNo, "1");
			if (null != whfEntduty) {
				throw new WareHouserExistException(brNo);
			}
		}
		
		Map<String, Object> rspMap = new HashMap<String, Object>();
		if ("1".equals(dutyInfo.getCshBoxFlg())) {
			if("1".equals(dutyInfo.getVchBoxFlg())) {
				rspMap.put("boot_flg", "4");
			}else {
				rspMap.put("boot_flg", "1");
			}
		}else {
			if("1".equals(dutyInfo.getVchBoxFlg())) {
				rspMap.put("boot_flg", "2");
			}else {
				rspMap.put("boot_flg", "0");
			}
		}
		
		String bootClass="GY" ;
		if(null != dutyInfo && !StringUtils.isEmpty(dutyInfo.getWarehouserFlg()) && "1".equals(dutyInfo.getWarehouserFlg())){
			bootClass="KG";
		}
		
		 //实体岗新增，返回实体岗编号，实体岗名称，尾箱号
		// 1.根据岗位类型编号获取岗位类型名称
/*		String dutyName = getEntdutyName(dutyno);
		String cshboxno1 = "000";
		String vchboxno1 = "001";
		 //2.生成实体岗名称
		String entdutyname = getMaxEntName(brno, dutyName);
		// 3.生成实体岗编号
		String entdutyno = getEntNumber(brno);
		 //4.实体岗新增
		int count = insertEntduty(entdutyno, entdutyname, entdutydesc, dutyno, cshboxno1, vchboxno1,brno, mbrno, zoneno,tellerno);*/
		//返回容器赋值
		rspMap.put("dutyno",dutyNo);
		rspMap.put("brno",brNo);
		rspMap.put("entdutydesc", entdutyDesc);
		rspMap.put("mbrno",mBrNo);
		rspMap.put("zoneno",zoneNo);
		rspMap.put("tellerno",tellerNo );
		rspMap.put("boot_class",bootClass );
		rspMap.put("warehouserflg", wareHouseFlg);
		rspMap.put("specialflg", dutyInfo.getSpecialFlg());
		rspMap.put("authlevel", dutyInfo.getAuthLevel());
		
		return rspMap;
		
	}
	
	/**
	 * 实体岗新增后章
	 * @param map
	 * @return
	 */
	public Map<String, Object> entdutyAddLast(Map<String, Object> map) {
		//获取参数
		String dutyno = (String)map.get("dutyno");
		String brno = (String)map.get("brno");
		String entdutydesc = (String)map.get("entdutydesc");
		String cshboxno1 = (String)map.get("cshboxno1");
		String vchboxno1 = (String)map.get("vchboxno1");
		String mbrno = (String)map.get("mbrno");
		String zoneno = (String)map.get("zoneno");
		String tellerno = (String)map.get("tellerno");
		String warehouserflg = (String)map.get("warehouserflg");
		String specialflg = (String)map.get("specialflg");
		String authlevel = (String)map.get("authlevel");

		// 1.根据岗位类型编号获取岗位类型名称
		logger.info("----------根据岗位类型编号获取岗位类型名称----------");
		String dutyName = getEntdutyName(dutyno);

		//2.生成实体岗名称
		logger.info("----------生成实体岗名称----------");
		String entdutyname = getMaxEntName(brno, dutyName);
		if(null == entdutyname || "".equals(entdutyname)) {
			throw new EntdutyCreateException("生成实体岗名称为空");
		}
		
		// 3.生成实体岗编号
		logger.info("----------生成实体岗编号----------");
		String entdutyno = getEntNumber(brno);
		if(null == entdutyno || "".equals(entdutyno)) {
			throw new EntdutyCreateException("生成实体岗编号为空");
		}
		
		 //4.实体岗新增
		logger.info("----------实体岗新增----------");
		int count = insertEntduty(entdutyno, entdutyname, entdutydesc, dutyno, cshboxno1, vchboxno1, brno, mbrno, zoneno, tellerno, warehouserflg);
		if (1 != count) {
			throw new EntdutyCreateException("实体岗新增失败");
		}
		dbo.commit();
		
		//返回容器赋值
		Map<String, Object> rspMap = new HashMap<String, Object>();
		rspMap.put("entdutyname", entdutyname);
		rspMap.put("entdutyno", entdutyno);
		rspMap.put("cshboxno1", cshboxno1);
		rspMap.put("vchboxno1", vchboxno1);
		rspMap.put("warehouserflg", warehouserflg);
		rspMap.put("specialflg", specialflg);
		rspMap.put("authlevel", authlevel);
		return rspMap;
	}
	

	
	/**
	 * @summary 实体岗删除
	 * @param entdutyno
	 */
	public Map<String,Object> entdutyDelete(String entdutyno, String brno) {
		logger.info("----------实体岗信息是否存在----------");
		// 查询实体岗位表是否有钱箱和尾箱
		Entduty entdutyInfo = getEntdutyInfo(entdutyno);
		if(null==entdutyInfo) {
			throw new CheckNoDataException("实体岗信息不存在");
		}
		if (!brno.equals(entdutyInfo.getBrNo())) {
			throw new CheckNoDataException("非本机构岗位");
		}
		
		//判断实体岗是否空岗,在岗则不能删除
		logger.info("----------判断实体岗是否空岗----------");
		if("1".equals(entdutyInfo.getStatus())) {
			throw new EntdutyDeleteError("此实体岗处于在岗状态,不能被删除！");
		}

		Map<String,Object> map = new HashMap<>();
		//赋值返回参数
		map.put("oprtg_org", entdutyInfo.getBrNo());
		map.put("entdutyno", entdutyno);
		if(null!=entdutyInfo.getCshBoxNo1()) {
			map.put("cshboxno1", entdutyInfo.getCshBoxNo1());
		}else {
			map.put("cshboxno1", "");
		}
		if(null!=entdutyInfo.getVchBoxNo1()) {
			map.put("vchboxno1", entdutyInfo.getVchBoxNo1());
		}else {
			map.put("vchboxno1", "");
		}
		String dutyno = entdutyInfo.getDutyNo();
		DutyInfo dutyInfo = dutyinfoDao.queryByDutyNo(dutyno);
		String bootClass="GY" ;
		if(null != dutyInfo && !StringUtils.isEmpty(dutyInfo.getWarehouserFlg()) && "1".equals(dutyInfo.getWarehouserFlg())){
			bootClass="KG";
		}
		map.put("boot_class", bootClass);
		return map;
	}
	
	/**
	 * @summary 实体岗删除后章
	 * @return
	 */
	public int entdutyDeleteLast(Map<String,Object> map) {
		//获取参数信息
		String entdutyno = (String) map.get("entdutyno");
		
		// 删除实体岗信息
		logger.info("----------删除实体岗信息----------");
		int count = entdutyDao.entdutyDelete(entdutyno);
		if(1 != count) {
			dbo.rollback();
			throw new EntdutyDeleteError("实体岗删除失败！");
		}
		return count;
	}
	
	/**
	 * @summary 实体岗查询信息列表
	 * @param pageFlag 翻页标志
	 * @param maxNum   每页记录数
	 * @param zoneNo	分行号
	 * @param mBrNo		支行号
	 * @param brNo		网点号
	 * @param userst	在线状态
	 * @param status	岗位状态
	 * @param entdutyNo	实体岗编号
	 * @param logBrNo	登录机构
	 * @param tellerno	在岗柜员号
	 */
	public Map<String, Object> FindEntdutyList(String pageFlag, String maxNum, String zoneNo, String mBrNo, String brNo, 
			String userst, String status,String entdutyNo, String logBrno, String tellerno) {
		//总记录数
	    int startPage = Integer.parseInt(pageFlag);
	    int pageSize = Integer.parseInt(maxNum);
	    if (pageSize < 1 || startPage < 1) {
			throw new ApIllegalParamException("maxNum/pageFlag 要大于 1");
		}
	    
	    String myBank = logBrno.substring(0,3);
		Branch logBranch = branchDao.queryBranchByNo(logBrno);
		if (null != logBranch && "4".equals(logBranch.getBrtp())) {
			if (StringUtils.isEmpty(brNo)) {	
				brNo = "";
			}
		} else {
			if (!StringUtils.isEmpty(brNo)) {
				if (!logBrno.equals(brNo)) {
					throw new ApIllegalParamException("不能查询非本机构岗位");
				}
			}
			brNo = logBrno;
		}
		//实体岗查询信息列表
	    IPage<Map<String, Object>> iPage = entdutyDao.FindEntdutyList(pageFlag, maxNum, zoneNo, mBrNo,
	    		brNo, userst, status, entdutyNo, myBank,tellerno);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("rowcnt", iPage.getTotal());// 总笔数
		resultMap.put("listnm", iPage.getSize());// 返回记录数
		resultMap.put("bodrcd_list", iPage.getRecords());// 返回数据
		return resultMap;
		
	}



}
