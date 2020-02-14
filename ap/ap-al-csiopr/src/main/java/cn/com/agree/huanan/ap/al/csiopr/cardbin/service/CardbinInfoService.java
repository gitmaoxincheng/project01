package cn.com.agree.huanan.ap.al.csiopr.cardbin.service;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiopr.cardbin.dao.CardbinInfoDao;
import cn.com.agree.huanan.ap.al.csiopr.cardbin.dao.CardbinOperDao;
import cn.com.agree.huanan.ap.al.csiopr.cardbin.exception.InsertCardbinOperFailException;
import cn.com.agree.huanan.ap.al.csiopr.cardbin.po.CardbinDetail;
import cn.com.agree.huanan.ap.al.csiopr.cardbin.po.CardbinInfo;
import cn.com.agree.huanan.ap.al.csiopr.cardbin.po.CardbinOper;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.CheckNotDataException;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;
/**
 * 
 * @author bodadmin
 * @summary 卡bin服务层
 */
@Service
public class CardbinInfoService {
	@Autowired CardbinInfoDao cardbinInfoDao;
	@Autowired CardbinOperDao cardbinOperDao;
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	
	//根据cardbin获取卡bin信息
	public CardbinInfo getCardbinInfoByCardbin(String cardbin) {
		return cardbinInfoDao.FindCardbinInfoByCardbin(cardbin);
		
	}
	
	//根据cardbin和审批状态获取卡bin审批信息
	public CardbinOper getCardbinOperByCardbin(String cardbin,String audStatus) {
		return cardbinOperDao.FindCardbinOperByCardbin(cardbin,audStatus);
		
	}
	
	//插入卡bin信息到审批表中
	public void insertCardbinToOper(CardbinOper card ) {
		int count=cardbinOperDao.insertCardbinToOper(card);
		if(count!=1) {
			dbo.rollback();
			logger.info("插入卡bin信息到审批表失败");
			throw new InsertCardbinOperFailException();
		}
		dbo.commit();
	}
	
	//获取卡bin信息列表
	public Map<String, Object> getCardbinInfoList(String pageFlag, String maxNum, String cardbin,
			String cardType, String bankCode, String bankName) {
		logger.info("获取卡bin信息开始");

		Map<String, Object> result =cardbinInfoDao.getCardbinInfoList( pageFlag,  maxNum,  cardbin,
				 cardType,  bankCode,  bankName);
		if (0 == ((List) result.get("chnl_list")).size()) {
			logger.info("查询数据为空");
			throw new CheckNotDataException("查询数据为空");
		}
		logger.info("获取卡bin信息 结束");
		return result;
	}
	//获取卡bin变更审批信息列表
	public Map<String, Object> getCardbinOperList(String pageFlag, String maxNum, String cardbin,
			String beginDate, String endDate, String optType, String bankCode, String audStatus) {
		logger.info("获取卡bin变更审批信息列表  开始");

		Map<String, Object>result=cardbinOperDao.getCardbinOperList(pageFlag,maxNum,cardbin,beginDate,
				endDate,optType,bankCode,audStatus);
		if (0 == ((List) result.get("oper_list")).size()) {
			logger.info("没有对应的记录");
			throw new CheckNotDataException("没有对应的记录");
		}
		logger.info("获取卡bin变更审批信息列表   结束");
		return result;
	}
	//根据流水号查询卡bin审批信息
	public CardbinOper getCardbinOperStatus(String seriNo) {
		CardbinOper cardbinOperInfo = cardbinOperDao.getCardbinOperStatus(seriNo);
		return cardbinOperInfo;
	}
	
	//根据操作类型进行卡bin信息的操作
	public int doExcuteByOptType(CardbinOper cardInfoOper) {
		CardbinInfo cardInfo = new CardbinInfo();
		cardInfo.setCardbin(cardInfoOper.getCardbin());
		cardInfo.setCardType(cardInfoOper.getCardType());
		cardInfo.setCardbinStByte(cardInfoOper.getCardbinStByte());
		cardInfo.setCrdbinLen(cardInfoOper.getCrdbinLen());
		cardInfo.setCardbinTrack(cardInfoOper.getCardbinTrack());
		cardInfo.setChgFlag(cardInfoOper.getChgFlag());
		cardInfo.setBankCode(cardInfoOper.getBankCode());
		cardInfo.setBankName(cardInfoOper.getBankName());
		cardInfo.setCardName(cardInfoOper.getCardName());
		cardInfo.setAmtFlag(cardInfoOper.getAmtFlag());
		cardInfo.setPosFlag(cardInfoOper.getPosFlag());
		cardInfo.setTrackNo(cardInfoOper.getTrackNo());
		cardInfo.setTrackStByte(cardInfoOper.getTrackStByte());
		cardInfo.setTrackLen(cardInfoOper.getTrackLen());
		cardInfo.setCardStByte(cardInfoOper.getCardStByte());
		cardInfo.setCardLen(cardInfoOper.getCardLen());
		cardInfo.setCardNo(cardInfoOper.getCardNo());
		cardInfo.setCardTrack(cardInfoOper.getCardTrack());
		int result = 0;
		//检查操作类型 "0"-新增 "1"-修改 "2"-删除
		if("0".equals(cardInfoOper.getOptType())) {
			result=cardbinInfoDao.insertCardbinInfo(cardInfo);
		}else if("1".equals(cardInfoOper.getOptType())) {
			result=cardbinInfoDao.updateCardbinInfo(cardInfo);
		}else if("2".equals(cardInfoOper.getOptType())) {
			result=cardbinInfoDao.deleteCardbinInfo(cardInfoOper.getCardbin());
		}
		return result;
	}
	
	//更新审批表中的数据
	public int doUpdateCardbinOper(String audStatus, String audRemarks, String audBrno, String audTlr,String seriNo) {
		String auDate=DateTimeUtil.getSysDate();
		String audTime=DateTimeUtil.getSysTime();
		CardbinOper cardbinOper = new CardbinOper();
		cardbinOper.setAudStatus(audStatus);
		cardbinOper.setAudRemarks(audRemarks);
		cardbinOper.setAudBrno(audBrno);
		cardbinOper.setAudTlr(audTlr);
		cardbinOper.setSeriNo(seriNo);
		cardbinOper.setAuDate(auDate);
		cardbinOper.setAudTime(audTime);
		int count=cardbinOperDao.doUpdateCardbinOper(cardbinOper);
		if (count != 1) {
			dbo.rollback();
			throw new CheckNotDataException();
		}
		dbo.commit();
		return count;
	}
	
	// 查询卡bin批量导入信息列表
	public Map<String, Object> getCardbinMulOperList(String pageFlag, String maxNum, String cardbin,
			String beginDate, String endDate, String audStatus) {
		logger.info("获取卡bin批量导入信息列表  开始");

		Map<String, Object>result=cardbinOperDao.getCardbinMulOperList(pageFlag,maxNum,cardbin,beginDate,
				endDate,audStatus);
		if (0 == ((List) result.get("oper_list")).size()) {
			throw new CheckNotDataException();
		}
		logger.info("获取卡bin批量导入信息列表   结束");
		
		return result;
	}
	
	//查询卡bin批量导入明细信息
	public Map<String, Object> getCardMulDetailList(String pageflag, String maxNum, String audSeriNo) {
		logger.info("查询卡bin批量导入明细信息");
		Map<String, Object> resultMap = cardbinOperDao.findCardMulDetailInfo(pageflag,maxNum,audSeriNo);
		if (0 == ((List) resultMap.get("cardbin_list")).size()) {
			logger.info("查询无记录");
			throw new CheckNotDataException("查询无记录");
		}
		return resultMap;
	}
	
	/**
	 * 卡bin批量导入审批
	 * @param serino 流水号
	 * @param audstatus 审批状态
	 * @param audremarks 审批意见
	 */
	public int cardbinMulOper(String serino, String audstatus, String audremarks,String audbrno,String audtlr) {
		//查询出审批表中的审批状态是否为“待审批”
		CardbinOper cardInfo = cardbinOperDao.getCardbinOperInfo(serino);
		if(!"0".equals(cardInfo.getAudStatus())) {
			logger.info("审批状态不正确！");
			throw new CheckNotDataException("审批状态不正确！");
		}
		//判断传入的审批状态，若为“2”，则直接更新审批表
		//若为“1”,判断操作类型是否为“3”-批量导入
		if("1".equals(audstatus)) {
			if("3".equals(cardInfo.getOptType())) {
				//删除卡bin信息表中的所有数据
				int count = cardbinInfoDao.deleteCardbinInfoAll();
				//查询获取明细表中所有数据信息
				List<Map<String, Object>> list = cardbinOperDao.getCardbinDetailList(serino);
				if(list==null) {
					logger.info("获取卡bin明细信息失败");
					throw new CheckNotDataException("获取卡bin明细信息失败");
				}
				//插入卡bin明细表中的数据到卡bin信息表中
				for(int i=0;i<list.size();i++) {
					//遍历插入卡bin信息
					Map<String, Object> map = list.get(i);
					int info = cardbinInfoDao.insertAllDetailToCardbin(map);
					if(info!=1) {
						logger.info("插入卡bin信息失败");
						throw new CheckNotDataException("插入卡bin信息失败");
					}
				}
			}
		}
		//更新审批表中的数据
		CardbinOper cardbinOper = new CardbinOper();
		cardbinOper.setSeriNo(serino);
		cardbinOper.setAudStatus(audstatus);
		cardbinOper.setAudRemarks(audremarks);
		cardbinOper.setAudBrno(audbrno);
		cardbinOper.setAudTlr(audtlr);
		cardbinOper.setAuDate(DateTimeUtil.getSysDate());
		cardbinOper.setAudTime(DateTimeUtil.getSysTime());
		int count = cardbinOperDao.doUpdateCardbinOper(cardbinOper);
		//若更新记录为“0”，则进行回滚，否则，提交事务
		if(count!=1) {
			dbo.rollback();
			logger.info("审批表数据更新失败");
			throw new CheckNotDataException("审批表数据更新失败");
		}
		dbo.commit();
		return count;
	}

}
