package cn.com.agree.huanan.ap.al.csitrd.base.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.huanan.ap.al.csitrd.base.dao.TradeInfoImageListDao;
import cn.com.agree.huanan.ap.al.csitrd.base.dao.TradeInfoImageMainDao;
import cn.com.agree.huanan.ap.al.csitrd.base.po.TradeInfoImageList;
import cn.com.agree.huanan.ap.al.csitrd.base.po.TradeInfoImageMain;
import cn.com.agree.huanan.ap.al.csitrd.fina.exception.TradeModificationException;
import cn.com.agree.huanan.ap.rl.bank.base.dao.DictDao;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

@Service
public class IasService {
	@Autowired private Logger logger;
	@Autowired private DbOperator dbo;
	@Autowired private TradeInfoImageListDao tradeInfoImageListDao;
	@Autowired private TradeInfoImageMainDao tradeInfoImageMainDao;
	@Autowired private DictDao dictDao;


	/**
	 * 登记到影像登记簿
	 * */
	public int insertTradeInfoImageMain(TradeInfoImageMain tradeInfoImageMain) {
		logger.info("登记到影像登记簿");
		int count = tradeInfoImageMainDao.insertTradeInfoImageMain(tradeInfoImageMain);
		logger.info("count:"+count);
		if(count < 1) {
			logger.error("登记影像登记簿失败");
			dbo.rollback();
		}
		dbo.commit();
		logger.info("提交");
		return count;
	}


	/**
	 * 更新影像登记簿
	 * */
	public int updateTradeInfoImageMain(Map<String, Object> paramMap) {

		logger.info("更新影像登记簿开始");
		int count = tradeInfoImageMainDao.updateTradeInfoImageMain(paramMap);
		logger.info("count:"+count);
		if(count < 1) {
			logger.error("更新影像登记簿失败");
			dbo.rollback();
		}
		dbo.commit();
		logger.info("提交");
		return count;
	}

	/**
	 * 登记到影像信息列表
	 * */
	public int insertTradeInfoImageList(TradeInfoImageList tradeInfoImageList) {
		logger.info("登记到影像信息列表");
		int count = tradeInfoImageListDao.insertTRADEINFO_IMAGE_LIST(tradeInfoImageList);
		logger.info("count:"+count);
		if(count < 1) {
			logger.error("登记影像信息列表失败");
			dbo.rollback();
		}
		dbo.commit();
		logger.info("提交");
		return count;
	}

	/**
	 * 更新影像信息列表
	 * */
	public int updateTradeInfoImageList(Map<String, Object> paramMap) {
		logger.info("更新影像信息列表开始");
		int count = tradeInfoImageListDao.updateTRADEINFO_IMAGE_LIST(paramMap);
		logger.info("count:"+count);
		if(count < 1) {
			logger.error("更新影像信息列表失败");
			dbo.rollback();
		}
		dbo.commit();
		logger.info("提交");
		return count;
	}

	/**
	 * 拼接路径
	 * */
	public JavaList packFileList(ArrayList<Map<String, String>> file_List ,String srcCalCod) {
		JavaList resList = new JavaList();
		if("STM".equals(srcCalCod)) {
			String filePrefix = dictDao.getStringItem("TC_FILE_DIR","TC_FILE_DIR_001");
			for (int i = 0; i < file_List.size(); i++) {
				Map<String, String> fileMap = (Map<String, String>) file_List.get(i);
				String absPath = filePrefix+"Check/"+DateTimeUtil.getSysDate()+fileMap.get("filepath");
				logger.info("拼接绝对路径："+absPath);
				resList.add(absPath);
			}
		}else if("MMP".equals(srcCalCod)) {
			String filePrefix = dictDao.getStringItem("IAS","mobileUpload");
			for (int i = 0; i < file_List.size(); i++) {
				Map<String, String> fileMap = (Map<String, String>) file_List.get(i);
				String absPath = filePrefix+"/"+fileMap.get("filepath");
				logger.info("拼接绝对路径："+absPath);
				resList.add(absPath);
			}
		}

		return resList;
	}
	
	/**
	 * 拼接路径
	 * */
	public ArrayList<Map<String, String>> packFileListOfUpadte(ArrayList<Map<String, String>> file_List ,String srcCalCod) {
		
		if("STM".equals(srcCalCod)) {
			String filePrefix = dictDao.getStringItem("TC_FILE_DIR","TC_FILE_DIR_001");
			for (int i = 0; i < file_List.size(); i++) {
				Map<String, String> fileMap = (Map<String, String>) file_List.get(i);
				String absPath = filePrefix+"Check/"+DateTimeUtil.getSysDate()+fileMap.get("filepath");
				file_List.get(i).put("filepath", absPath);
				logger.info("拼接绝对路径："+absPath);
			}
		}else if("MMP".equals(srcCalCod)) {
			String filePrefix = dictDao.getStringItem("IAS","mobileUpload");
			for (int i = 0; i < file_List.size(); i++) {
				Map<String, String> fileMap = (Map<String, String>) file_List.get(i);
				String absPath = filePrefix+"/"+fileMap.get("filepath");
				file_List.get(i).put("filepath", absPath);
				logger.info("拼接绝对路径："+absPath);
			}
		}

		return file_List;
	}

}







