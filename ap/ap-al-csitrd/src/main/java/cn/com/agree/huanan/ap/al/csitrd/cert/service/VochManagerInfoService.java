package cn.com.agree.huanan.ap.al.csitrd.cert.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.cert.dao.VochManagerInfoDao;
import cn.com.agree.huanan.ap.al.csitrd.cert.exception.InsertVochManaInfoFailException;
import cn.com.agree.huanan.ap.al.csitrd.cert.exception.UpdateVochManaInfoFailException;
import cn.com.agree.huanan.ap.al.csitrd.cert.po.VochManagerInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 凭证管理信息明细 服务层
 * @author Zengs
 *
 */
@Service
public class VochManagerInfoService {
	@Autowired DbOperator dbOperator;
	@Autowired VochManagerInfoDao tradeInfoCertDao;
	private Logger logger = Logger.getLogger(VochManagerInfoService.class);
	
	/**
	 * 插入凭证管理信息明细
	 * @param tradeInfoCert
	 * @return
	 */
	public int insertVochManagerInfo(VochManagerInfo vochManagerInfo) {
		int count = tradeInfoCertDao.insertVochManagerInfoDap(vochManagerInfo);
		if(count == 0) {
			dbOperator.rollback();
			logger.error("插入凭证管理信息明细失败！");
			throw new InsertVochManaInfoFailException();
		}
		dbOperator.commit();
		return count;
	}
	
	/**
	 * 更新凭证管理信息明细
	 * @param paramMap
	 * @return 
	 */
	public int updateVochManagerInfo(Map<String, Object> paramMap) {
		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}
		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		int count = tradeInfoCertDao.updateTVochManagerInfoDap(paramMap);
		if(count == 0) {
			dbOperator.rollback();
			logger.error("更新凭证管理信息明细失败！");
			throw new UpdateVochManaInfoFailException();
		}
		dbOperator.commit();
		return count;
	}
	
	/**
	 * 批量插入凭证管理信息明细
	 * @param tradeInfoCert
	 * @return
	 */
	public void insertVochManagerInfoes(ArrayList<Map<String, String>> infoList,Map<String, String> map) {
		VochManagerInfo vochManagerInfo = new VochManagerInfo();
		
		vochManagerInfo.setTradeDate(map.get("tradeDate")); // 添加平台交易日期
		vochManagerInfo.setTradeTime(map.get("tradeTime")); // 添加平台交易时间
		vochManagerInfo.setSerialNo(map.get("serialNo")); // 添加平台交易流水

		for (Map<String, String> infoMap : infoList) {
			vochManagerInfo.setCertType(infoMap.get("vchr_catg")); //凭证种类
			vochManagerInfo.setParval(infoMap.get("par_val")); //面值
			vochManagerInfo.setBrCode(infoMap.get("br_code")); //分行代码
			vochManagerInfo.setCertUnit(infoMap.get("vchr_unit")); //凭证单位
			vochManagerInfo.setTotNum(infoMap.get("qty")); //数量
			vochManagerInfo.setStrtNum(infoMap.get("strt_vchr_serl_num")); //起始凭证序号
			vochManagerInfo.setEndNum(infoMap.get("end_vchr_serl_num")); //终止凭证序号
			vochManagerInfo.setCertNum(infoMap.get("vchr_vol")); //凭证张数
			
			int count = tradeInfoCertDao.insertVochManagerInfoDap(vochManagerInfo);	//添加数据
			if(count == 0) {
				dbOperator.rollback();
				logger.error("插入凭证管理信息明细失败！");
				throw new InsertVochManaInfoFailException();
			} 
		 }
		
		
		dbOperator.commit();
	}
}
