package cn.com.agree.huanan.ap.al.csitrd.chlclrdtl.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.chlclrdtl.dao.ChlclrdtlDao;
import cn.com.agree.huanan.ap.al.csitrd.chlclrdtl.exception.CheckNotDataException;
import cn.com.agree.huanan.ap.al.csitrd.chlclrdtl.po.Chlclrdtl;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class ChlclrdtlService {
	@Autowired
	ChlclrdtlDao chlClrdtlDao;
	@Autowired
	DbOperator dbo;
	@Autowired
	Logger logger;

	/**
	 * 清机维护明细数据删除
	 * 
	 * @param atmtellerno
	 *            ATM柜员号
	 * @param devno
	 *            ATM设备号
	 * @param cleandate
	 *            清机日期
	 *
	 */
	public void chlClrdtlInfoDelete(String atmtellerno, String devno, String cleandate) {
		logger.info("获取清机维护明细删除开始");
		long count = chlClrdtlDao.checkChannelclrdtlInfo(cleandate, devno,atmtellerno);
		if (count <1) {
			logger.info("清机日期不正确或ATM设备号ATM柜员号不存在");
			throw new CheckNotDataException("清机日期不正确或ATM设备号ATM柜员号不存在");
		}
		int deleteCount = chlClrdtlDao.deleteChannelclrdtlInfo(atmtellerno, devno, cleandate);
		if(deleteCount==1) {
			logger.info("删除数据成功!");
			dbo.commit();
		}else {
			logger.info("删除数据失败!");
			dbo.rollback();
		}
		logger.info("获取清机维护明细删除结束");
	
	} 

	/**
	 * 清机维护明细数据查询
	 * 
	 * @param pageflag
	 *            页码
	 * @param maxnum
	 *            每页最多记录数
	 * @param cleandate
	 *            起始清机日期
	 * @param lastcleantime
	 *            截止清机日期
	 * @param atmtellerno
	 *            ATM柜员号
	 * @param devno
	 *            ATM设备号
	 * @return map 
	 */
	public Map<String, Object> chlClrdtlInfoSelcet(String pageflag, String maxnum, String begcleandate,
			String endcleandate, String atmtellerno, String devno) {
		logger.info("获取清机维护明细数据开始");
		Map<String, Object> result = chlClrdtlDao.selectChannelclrdtlInfo(pageflag, maxnum, begcleandate, endcleandate,
				atmtellerno, devno);
		if (0 == ((List) result.get("bodrcd_list")).size()) {
			logger.info("查询数据为空");
			throw new CheckNotDataException("查询数据为空");
		}
		logger.info("获取清机维护明细数据 结束");
		return result;
	}

	/**
	 * 清机维护明细修改服务 devno与cleanTime确定一条记录
	 * @param newCrl 代修改的清机数据体，数据体中的devno不能为空
	 * @param oldCleanTime 代修改的清机明细记录的清机时间
	 */
	public void doEditChlclrdtl(Map<String, Object> newCrl,String oldCleanTime) {
		logger.info("清机维护明细修改开始");
		
		//日期格式校验
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		SimpleDateFormat YMD = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat HMS = new SimpleDateFormat("HH:mm:ss");
		
		try {
			Date oldCleanDate = format.parse(oldCleanTime);
			oldCleanTime = YMD.format(oldCleanDate);
		}catch(ParseException e) {
			throw new CheckNotDataException("清机日期格式不正确");
		}
		try {
			newCrl.put("lastcleantime", newCrl.get("cleantime"));
			Date clearDate = format.parse((String) newCrl.get("cleantime"));
			newCrl.put("cleandate",YMD.format(clearDate));
			newCrl.put("cleantime",HMS.format(clearDate));
		}catch(ParseException e) {
			throw new CheckNotDataException("清机日期格式不正确");
		}
		
		Map<String, Object> cleanResult = chlClrdtlDao.selectChannelclrdtlInfo("1","1",oldCleanTime,oldCleanTime,(String)newCrl.get("atmtellerno"),(String)newCrl.get("devno"));
		if ((Long)cleanResult.get("rowcnt") < 1) {
			throw new CheckNotDataException("没有该条清机记录");
		}
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> result = (List<Map<String, Object>>) cleanResult.get("bodrcd_list");
		Map<String, Object> tag = result.get(0);
		if (tag.get("status").equals("1")) {
			throw new CheckNotDataException("此清机记录已挂账，不允许修改");
		}
		
		//更新开始
		int effectLine = chlClrdtlDao.updateChlclrdtl( newCrl , oldCleanTime);
		if(effectLine == 1) {
			dbo.commit();
		}else {
			dbo.rollback();
			throw new CheckNotDataException("清机维护明细修改失败");
		}
		return;
	}
	//清机维护明细数据新增
	public void insertChlClrdtl(Chlclrdtl chlclrdtl) {
		logger.info("清机维护明细新增开始");
		
		//日期格式校验
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		try {
			format.parse(chlclrdtl.getCleantime());
		} catch (ParseException e) {
			logger.info("清机日期格式不为yyyyMMdd");
			throw new CheckNotDataException("清机日期格式不为yyyyMMdd HH:mm:ss");
		}
		if(!StringUtils.isEmpty(chlclrdtl.getLastcleantime())) {
			try {
				format.parse(chlclrdtl.getLastcleantime());
			} catch (ParseException e) {
				throw new CheckNotDataException("上次清机时间格式不为 yyyyMMDD HH:MM:SS");
			}
		}
//		//清机时间录入为非当天日期
//		String nowTime = format.format(new java.util.Date());
//		if(!cleanTime.equals(nowTime)) {
//			throw new CheckNotDataException("请确认是否当天清机");
//		}
		long count = chlClrdtlDao.checkChannelclrdtlInfo(chlclrdtl.getTradedate(), chlclrdtl.getDevno(), chlclrdtl.getAtmtellerno());
		if (count ==1) {
			logger.info("无法新增！ ATM柜员号已存在");
			throw new CheckNotDataException("无法新增！ ATM柜员号已存在");
		}
		chlClrdtlDao.insertChlClrdtl(chlclrdtl);
		logger.info("插入清机维护明细数据成功");
	}
	//上次清机时间查询
	public Map<String, Object> getLastCleanTimeAndDevno(String atmtellerno) {
		Map<String,Object> map =chlClrdtlDao.getLastCleanTimeAndDevno(atmtellerno);
		logger.info("map : "+map+"  map.size "+map.size());
		
		return map;
		
		
	}
}
