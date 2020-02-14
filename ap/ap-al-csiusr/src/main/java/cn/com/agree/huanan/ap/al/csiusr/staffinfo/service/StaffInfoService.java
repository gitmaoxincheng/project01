package cn.com.agree.huanan.ap.al.csiusr.staffinfo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiusr.parasyn.service.ParasynService;
import cn.com.agree.huanan.ap.al.csiusr.staffinfo.dao.StaffInfoDao;
import cn.com.agree.huanan.ap.al.csiusr.staffinfo.po.StaffInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.ApException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

/**
 * 行员服务层
 * @author HCP
 */
@Service
public class StaffInfoService {
	@Autowired StaffInfoDao staffinfoDao;
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	@Autowired ParasynService parasynService;
	/**
	 * 行员同步操作
	 * @param pulltype
	 * @param tellerno
	 * @param name
	 * @param tellertype
	 * @param mybank
	 * @param idtype
	 * @param idcode
	 * @param status
	 * @param isps
	 * @param otps
	 * @param phone
	 */
	public Map<String,Object> staffinfoSynchronization(String pulltype,String tellerno,String name,String tellertype,String mybank,String idtype,String idcode,String status,String isps,String otps,String phone,String serialno) {
		//先判断推送类型是否存在
		if(!(pulltype.equals("1")||pulltype.equals("2")||pulltype.equals("3")||pulltype.equals("4")||pulltype.equals("5"))) {
			logger.info("不存在该推送类型:("+pulltype+")");
			throw new ApIllegalParamException("不存在该推送类型:("+pulltype+")");
		}
		else {
			//先到表csis_parasyn综合后管同步登记表插入一条数据
			Map<String,Object> parasynMap=new HashMap(); 
			parasynMap.put("serialno", serialno); 
			parasynMap.put("optdate", DateTimeUtil.getSysDate());
			parasynMap.put("synType", "2");
			parasynMap.put("optType", pulltype);
			parasynMap.put("tellerNo", tellerno);
			parasynMap.put("brNo", "");
			parasynMap.put("unBranchNo", "");
			parasynMap.put("brDate", "");
			parasynMap.put("status", "1");
			parasynMap.put("wtStat", 0);
			parasynMap.put("wtNum", "0");
			parasynMap.put("rspCode", "");
			parasynMap.put("rspMsg", "");
			parasynMap.put("updDate", DateTimeUtil.getSysDate());
			parasynMap.put("updTime", DateTimeUtil.getSysTime());
			parasynService.addNewRecord(parasynMap);
			//根据传进来的tellerno查询行员
			StaffInfo staffInfo=staffinfoDao.queryTellerByNo(tellerno);
			//记录是否有该行员
			int flag=0;
			if(staffInfo==null) {
				staffInfo=new StaffInfo();
				staffInfo.setTellerNo(tellerno);
				logger.info("该行员号不存在");
				flag++;
			}
			staffInfo.setName(name);
			staffInfo.setTellerType(tellertype);
			staffInfo.setMyBank(mybank);
			staffInfo.setIdType(idtype);
			staffInfo.setIdCode(idcode);
			staffInfo.setStatus(status);
			staffInfo.setIsps(isps);
			staffInfo.setOtps(otps);
			staffInfo.setPhone(phone);
			int count=0;
			//判断推送类型
			try {
			if(pulltype.equals("1")&&flag==1) {
				//新增行员信息操作
				logger.info("解析推送类型为："+pulltype+",新增行员信息操作");
				staffInfo.setRegisDate(DateTimeUtil.getSysDate());
				count=addStaffInfo(staffInfo);
			}else if(pulltype.equals("2")&&flag==0) {
				//修改行员信息操作
				logger.info("解析推送类型为："+pulltype+",修改行员信息操作");
				staffInfo.setUpddate(DateTimeUtil.getSysDate());
				staffInfo.setUpdtime(DateTimeUtil.getSysTime());
				count=modifyStaffInfo(StaffInfo.getMap(staffInfo));	
			}else if(pulltype.equals("3")&&flag==0) {
				//注销操作
				logger.info("解析推送类型为："+pulltype+",行员注销操作");
				staffInfo.setCancelDate(DateTimeUtil.getSysDate());
				staffInfo.setStatus("2");
				count=modifyStaffInfo(StaffInfo.getMap(staffInfo));
			}else if(pulltype.equals("4")&&flag==0) {
				//停用操作
				logger.info("解析推送类型为："+pulltype+",行员停用操作");
				staffInfo.setOffDate(DateTimeUtil.getSysDate());
				staffInfo.setStatus("0");
				count=modifyStaffInfo(StaffInfo.getMap(staffInfo));
			}else if(pulltype.equals("5")&&flag==0) {
				//判断是否该行员状态是否为停用状态
				if(staffinfoDao.queryTellerByNo(tellerno).getStatus().equals("0")) {
					//激活操作
					logger.info("解析推送类型为："+pulltype+",行员激活操作");
					staffInfo.setOnDate(DateTimeUtil.getSysDate());
					staffInfo.setStatus("1");
					count=modifyStaffInfo(StaffInfo.getMap(staffInfo));
				}else {
					//该行员不是停用状态，不能激活
					logger.info("该行员不是停用状态，不能激活");
				}
			}else {
				logger.error("行员同步操作处理失败");
			}
			}catch(ApException e) {
				logger.error(e.getErrorMsg()+"行员同步操作处理失败");
			}
			/*catch(NullPointerException e) {
				logger.error(e.getMessage()+"行员同步操作处理失败");
			}*/
			//处理完毕到表csis_parasyn综合后管同步登记表更新数据
			if(count==1) {
				//处理成功
				parasynMap.put("status", "3");
			}
			else {
				//处理失败
				parasynMap.put("status", "4");
			}
			if(parasynService.changeParasynInfo(serialno, parasynMap)==1) {
				//回写次数+1
				logger.info("综合后管同步登记表更新数据成功");
			}
			return parasynMap;
		}
	}
	
	/**
	 * 新增行员信息操作
	 * @param staffInfo
	 */
	public int addStaffInfo(StaffInfo staffInfo) {
		int count=0;
		if(staffinfoDao.insertStaff(staffInfo)==1) {
			//返回数据库操作数为1，则打印成功信息
			dbo.commit();
			logger.info("行员信息插入成功");
			count++;
		}else {
			dbo.rollback();
		}
		return count;
	}
	
	/**
	 * 行员信息修改操作
	 * @param map
	 */
	public int modifyStaffInfo(Map<String, Object> map) {
		int count =0;
		Map<String,Object> tellermap=new HashMap(); 
		tellermap.put("tellerNo", map.get("tellerNo"));
		tellermap.put("name", map.get("name"));
		if((staffinfoDao.updateStaffInfo(map)==1)) {
			//返回数据库操作数为1，则打印成功信息
			
			logger.info("行员信息修改成功");
			staffinfoDao.updateTellerInfo(tellermap);
			dbo.commit();
			count++;
		}else {
			dbo.rollback();
		}
		return count;
	}

	
	/**
	 * 行员信息生成
	 * 
	 */
	public Boolean staffInfoGenerate(String filename) {
		//查询出机构信息
		List<Map<String, Object>> staffInfo = staffinfoDao.findStaffInfoGenerate();
		
		File file = new File(filename);
		
		if(!file.exists()) {
			file.getParentFile().mkdirs();
		}
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			
			//遍历打印
			for(Map<String, Object> map : staffInfo) {
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
		}finally {
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


	
}
