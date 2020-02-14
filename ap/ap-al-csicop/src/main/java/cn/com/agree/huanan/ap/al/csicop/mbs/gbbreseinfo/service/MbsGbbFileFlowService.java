package cn.com.agree.huanan.ap.al.csicop.mbs.gbbreseinfo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csicop.mbs.exception.SelectException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.InsertException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.UpdateException;
import cn.com.agree.huanan.ap.al.csicop.mbs.gbbreseinfo.dao.MbsGbbFileFlowDao;
import cn.com.agree.huanan.ap.al.csicop.mbs.gbbreseinfo.dao.MbsGbbReseInfoDao;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.FileUtil;

/**
 * 文件处理流水表Service
 * 
 * @author guyulong
 */
@Service
public class MbsGbbFileFlowService {
	@Autowired
	MbsGbbFileFlowDao mbsGbbFileFlowDao;
	@Autowired
	MbsGbbReseInfoDao mbsGbbReseInfoDao;
	@Autowired
	DbOperator dbo;
	@Autowired
	Logger logger;

	/**
	 * 批量更新领卡状态
	 * 
	 * @param sdate
	 *            亲子卡申请时间
	 * @param filedate
	 *            文件入库时间(范围)
	 * @param fileendate
	 *            文件入库时间(范围)
	 * @param status
	 *            文件状态
	 * @param filepathInfo
	 *            插入时文件信息
	 * @param updateInfo
	 *            更新时文件信息
	 * @throws FileNotFoundException
	 */
	public void updateGetCardStatus(String sdate, String filedate, String fileendate, Map<String, Object> filepathInfo,
			Map<String, Object> updateInfo) throws FileNotFoundException {
		logger.info("查询当天文件是否有处理");
		int count = mbsGbbFileFlowDao.findFilepathCount(filedate);
		if (count == 0) {
			logger.info("插入当天记录");
			count = mbsGbbFileFlowDao.insertFilepath(filepathInfo);
			dbo.commit();
			if (count != 1) {
				logger.info("插入记录失败");
				throw new InsertException("插入记录失败");
			}
		}
		logger.info("查询十天内的记录");
		List<Map<String, Object>> filepath = mbsGbbFileFlowDao.findFilepath(filedate, fileendate);
		if (count == 0) {
			logger.info("查询失败");
			throw new SelectException("查询失败");
		}
		for (int i = 0; i < filepath.size(); i++) {
			String path = (String) filepath.get(i).get("filepath");
			String date = (String) filepath.get(i).get("filedate");
			File file = new File(path + ".ok");
			if (!file.exists()) {
				logger.info("ok文件不存在");
				updateInfo.put("stat", "3");
				updateInfo.put("errormsg", "ODS_QZKST_" + date + "_001.ok文件不存在");
				mbsGbbFileFlowDao.updateFilepath(date, updateInfo);
				dbo.commit();
				throw new FileNotFoundException("ok文件不存在");
			}
			file = new File(path + ".dat");
			if (!file.exists()) {
				logger.info("dat文件不存在");
				updateInfo.put("stat", "3");
				updateInfo.put("errormsg", "ODS_QZKST_" + date + "_001.dat文件不存在");
				mbsGbbFileFlowDao.updateFilepath(date, updateInfo);
				dbo.commit();
				throw new FileNotFoundException("dat文件不存在");
			}
			logger.info("取文件内容");
			String fileLine = FileUtil.readFileLine(path + ".dat", "UTF-8", "\n");
			if (fileLine == null) {
				updateInfo.put("stat", "1");
				updateInfo.put("errormsg", "");
				mbsGbbFileFlowDao.updateFilepath(date, updateInfo);
				dbo.commit();
			}
			String[] infos = fileLine.split("\n");
			logger.info("批量更新亲子卡领卡状态");
			for (String info : infos) {
				String[] gbbString = info.split("#&");
				count = mbsGbbReseInfoDao.updateStatus(gbbString[0], gbbString[1], filedate, sdate);
				if (count != 1) {
					logger.info("更新失败");
					dbo.rollback();
					updateInfo.put("stat", "2");
					updateInfo.put("errormsg", "更新无满足条件记录");
					mbsGbbFileFlowDao.updateFilepath(date, updateInfo);
					dbo.commit();
					throw new UpdateException("更新亲子卡信息失败");
				}
				dbo.commit();
			}
			updateInfo.put("stat", "1");
			updateInfo.put("errormsg", "");
			mbsGbbFileFlowDao.updateFilepath(date, updateInfo);
			dbo.commit();
		}
	}

}
