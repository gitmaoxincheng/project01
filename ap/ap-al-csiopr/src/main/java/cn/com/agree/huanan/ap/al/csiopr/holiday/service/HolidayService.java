package cn.com.agree.huanan.ap.al.csiopr.holiday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiopr.holiday.dao.HolidayDao;
import cn.com.agree.huanan.ap.al.csiopr.holiday.po.Holiday;
//import cn.com.agree.huanan.ap.rl.bank.base.dao.SysParaDao;
//import cn.com.agree.huanan.ap.rl.bank.base.po.Syspara;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApInsertFailException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;
import cn.com.agree.huanan.ap.tl.util.FileUtil;

@Service
public class HolidayService {
	@Autowired Logger logger;
	//@Autowired SysParaDao sysParaDao;
	@Autowired HolidayDao holidayDao;
	@Autowired DbOperator dbo;

	/**
	 * 节假日同步
	 * @param split  分隔标识
	 * @param charset  编码格式
	 * @param paraItem  参数类别
	 * @param paraCode  参数码
	 * @param filename  文件名
	 */
	public void holidaySyn(String split, String charset, String paraItem, String paraCode, String filename) {
		//查询文件路径
		
		//List<Syspara> queryList = sysParaDao.queryList(paraItem,paraCode);
		//Syspara syspara = queryList.get(0);
		//String fp = syspara.getParaValue1();
		String fp ="syspara.getParaValue1()";
		//获取当天时间
		String sysDate = DateTimeUtil.getSysDate();
		//获取文件名
//		String fn = filename + sysDate;
		String fn = filename + "20200104";
		String fpn = fp + "/" + fn + ".txt";  //拼接目录
		logger.info("文件路径:%s,文件名:%s，目录：%s",fp,fn,fpn);
		//得到文件内容
		String conten = FileUtil.readFileLine(fpn, charset, "|");
		//同步数据前先清除数据表需更新的数据
		holidayDao.delectHoliday(sysDate);
		//得到文件内容的每行数据
		String[] rows = conten.split("\\|");
		for (String row : rows) {
			//得到当前行的列内容
			String[] column = row.split(split);
			//对节假日对象进行赋值
			Holiday holiday = new Holiday();
			holiday.setWorkdate(column[1]);  //日期
			holiday.setWorkflag(column[2]);  //是否工作日
			holiday.setRemarks(column[6]);   //备注说明
			holiday.setUpddate(column[5].substring(0,8));   //更新日期 
			holiday.setUpdtime(column[5].substring(8));   //更新时间 
			holiday.setUpdtlrno(column[4]);   //更新柜员
			//数据入库
			int inscount = holidayDao.insertHoliday(holiday);
			if(inscount == 0) {
				dbo.rollback();
				logger.error("节假日同步信息时新增失败");
				throw new ApInsertFailException("节假日同步信息");
			}
		}                                     
		dbo.commit();
		
	}

}
