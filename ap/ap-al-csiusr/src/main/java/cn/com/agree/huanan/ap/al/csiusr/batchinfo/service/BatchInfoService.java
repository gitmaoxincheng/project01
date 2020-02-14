package cn.com.agree.huanan.ap.al.csiusr.batchinfo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.batchinfo.dao.BatchInfoDao;
import cn.com.agree.huanan.ap.al.csiusr.batchinfo.po.BatchInfo;
import cn.com.agree.huanan.ap.al.csiusr.rtmh.exception.InsertInfoException;
import cn.com.agree.huanan.ap.rl.bank.base.dao.DictDao;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class BatchInfoService {
	@Autowired Logger logger;
	@Autowired BatchInfoDao batchInfoDao;
	@Autowired DictDao dictDao;
	@Autowired DbOperator dbo;
	
	/**
	 * 登记批次流水表
	 * @param batchInfo 
	 */
	public Map<String, String> insertBathchInfo(BatchInfo batchInfo,String reqNo) {

		String fileName = ""; //文件名前缀
		String keyName = ""; //路径查询标识
		switch (batchInfo.getScenecode()) {
		case "BRCH0008":
			fileName = "branch";
			keyName = "TC_FILE_DIR_007";
			break;
		case "TELR0029":
			fileName = "teller";
			keyName = "TC_FILE_DIR_008";
			break;
		default:
			break;
		}
		//查询文件生成路径
		logger.info("查询文件生成路径");
		String filePath = (String) dictDao.queryPath(keyName).get("keyValue");  //文件存放目录
		logger.info("filePath:"+filePath);
		
		String filename ;  //文件名全称
		String srcFile ;  //源文件名称
		if(batchInfo.getSrccalcod().equals("STV")) {
			filename = fileName+"_"+reqNo+".txt";
			srcFile = filePath.substring(filePath.lastIndexOf("/")+1)+"/"+filename;
		}else {
			filename = fileName+"_"+batchInfo.getUpddate()+".txt";
			srcFile = filePath.substring(filePath.lastIndexOf("/")+1)+"/"+filename;
		}
		String filepath = filePath+filename;   //文件路径（包含文件名）

		batchInfo.setFilename(filepath);
		
		logger.info("登记批次信息表开始");
		int count = batchInfoDao.insertTradeinfo(batchInfo);
		if(count < 1) {
			logger.error("登记批次信息表失败");
			dbo.rollback();
			throw new InsertInfoException("登记批次信息表失败");
		}
		dbo.commit();
		logger.info("登记批次信息表成功");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("filepath", filepath);
		map.put("filename", filename);
		map.put("srcFile", srcFile);  
		
		return map;
	}

	/**
	 * 更新批次信息表
	 * @param paramMap
	 */
	public void updateBathchInfo(Map<String, Object> paramMap) {

		logger.info("更新批次信息表开始");
		int count = batchInfoDao.updateTradeinfo(paramMap);
		if(count < 1) {
			logger.error("更新批次信息表失败");
			dbo.rollback();
			throw new InsertInfoException("更新批次信息表失败");
		}
		dbo.commit();
		logger.info("更新批次信息表成功");
	}

	
	/**
	 * 信息生成查询
	 * @param srcdate  请求方日期
	 * @param srcsysid  源请求方系统标识
	 * @param reqno   上送流水号
	 * @return 
	 */
	public Map<String, Object> QueryInfoGenerate(String srcsysid, String gloseqno) {

		if (StringUtils.isEmpty(srcsysid)) {
			logger.error("源请求方系统标识不能为空");
			throw new ApIllegalParamException("srcsysid");	
		}
		if (StringUtils.isEmpty(gloseqno)) {
			logger.error("源全局流水号不能为空");
			throw new ApIllegalParamException("reqno");	
		}
		
		Map<String, Object> result = batchInfoDao.QueryGenerateInfo(srcsysid , gloseqno);
		if(result.isEmpty()) {
			logger.error("查询信息为空");
			return null;
		}
		String filePath = result.get("filename").toString();
		String filename = filePath.substring(filePath.lastIndexOf("/")+1);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.putAll(result);
		hashMap.put("filename",filename);
		return hashMap;
	}
	
	
}
