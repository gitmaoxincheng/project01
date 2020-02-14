package cn.com.agree.huanan.ap.al.csitrd.rcpt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.dao.TradeBillImageInfoDao;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.exception.InsertTradeBillImageFailException;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.exception.NoBillMakeException;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.exception.UpdateTradeBillImageFailException;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.po.TradeBillImageInfo;
import cn.com.agree.huanan.ap.rl.bank.base.dao.DictDao;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;



/**
 * 单据图片表服务层
 * @author WB
 *
 */
@Service
public class TradeBillImageInfoService {
	@Autowired
	private TradeBillImageInfoDao tradeBillImageDao;
	@Autowired
	DbOperator dbo;
	@Autowired
	Logger logger;
	@Autowired DictDao dictDao;
	//插入数据
	public void addTradeBillInfo(TradeBillImageInfo tradeBillInfo) {	
		logger.info("登记对单据图片表开始");	
		int count=tradeBillImageDao.insertTradeBillImageInfo(tradeBillInfo);
		if (count == 1) {
			dbo.commit();
			logger.info("登记到单据图片表开始结束");
		} else {
			dbo.rollback();
			logger.info("登记到单据图片表失败...事务回滚");
			throw new InsertTradeBillImageFailException("登记到图片登记表失败");
		}
	}

	public void updateTradeBillInfo(Map<String,Object> map ) {
		logger.info("更新对单据图片表开始");		
		int count =tradeBillImageDao.updateTradeBillImageInfo(map);		
		if(count != 1) {
			dbo.rollback();
			logger.info("更新单据图片表失败!");
			throw new UpdateTradeBillImageFailException("登记到图片登记表失败");
		}
		dbo.commit();		
		logger.info("更新单据图片表结束");
	}
	public List<TradeBillImageInfo> queryTradeBillImagesByBill(String bill) {
		return tradeBillImageDao.queryTradeBillImageInfos(bill);
	}
	public void addBatchTradeBillImages(String bill,List<Map<String,Object>> list) {
		logger.info("批量插入单据图片开始");
		int count=tradeBillImageDao.insertBatchTradeBillImageInfo(list,bill);
		if (count == list.size()) {
			dbo.commit();
			logger.info("批量登记到单据图片表开始结束");
		} else {
			dbo.rollback();
			logger.info("批量登记到单据图片表失败...事务回滚");
			throw new InsertTradeBillImageFailException("批量登记到图片登记表失败");
		}
	}

	/**根据单据号查询单据图片表
	 * 
	 * @param bill
	 * @return
	 */
	public JavaList queryBillImage (String bill) {
		List<TradeBillImageInfo> imagelist = tradeBillImageDao.queryTradeBillImageInfos(bill);
		JavaList imagePaths = new JavaList();

		for(TradeBillImageInfo tradeBillImageInfo : imagelist) {
			imagePaths.add(tradeBillImageInfo.getImagePath());
		}
		logger.info("图片路径："+imagePaths.toString());
		return imagePaths;
	}
	/**根据单据号和图片类型查询单据图片表
	 * 
	 * @param bill
	 * @return
	 */
	public TradeBillImageInfo queryTradeBillImageInfoByType(String bill,String type) {
		TradeBillImageInfo image=tradeBillImageDao.queryTradeBillImageInfoByType(bill, type);
		return image;
	}

	/**
	 * @param bill
	 * @author chents
	 * 
	 * */
	public JavaList queryBillImageAndPagck(String bill) {
		
		if(StringUtils.isEmpty(bill)) {
			throw new NoBillMakeException("没有单据号");
		}
		
		List<TradeBillImageInfo> imagelist = tradeBillImageDao.queryTradeBillImageInfos(bill);
		JavaList imagePaths = new JavaList();
		String filePahth = dictDao.getStringItem("TC_FILE_DIR" , "TC_FILE_DIR_002");
		String imageListPathString = "";
		for(TradeBillImageInfo tradeBillImageInfo : imagelist) {
			imageListPathString = filePahth+tradeBillImageInfo.getImagePath();
			imagePaths.add(imageListPathString);
		}
		logger.info("图片绝对路径："+imagePaths.toString());
		return imagePaths;
	}

}
