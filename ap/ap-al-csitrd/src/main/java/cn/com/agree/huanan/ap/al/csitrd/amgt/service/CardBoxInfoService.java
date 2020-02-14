package cn.com.agree.huanan.ap.al.csitrd.amgt.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.amgt.dao.CardBoxInfoDaoImp;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApSelectNotFoundException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApUpdateFailException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 卡箱信息表service层
 * 
 * @author czp
 */

@Service
public class CardBoxInfoService {

	@Autowired
	CardBoxInfoDaoImp cardBoxInfoDaoImp;
	@Autowired
	Logger logger;
	@Autowired
	DbOperator dbo;

	/**
	 * 卡箱数减1
	 * @param devid
	 * @param cardboxnum
	 * @param card
	 */
	public void updateTakeCard(String devid, String cardboxnum, String card) {
		//参数校验
		if (StringUtils.isEmpty(devid)) {
			throw new ApIllegalParamException("devid");
		}
		if (StringUtils.isEmpty(cardboxnum)) {
			throw new ApIllegalParamException("cardboxnum");
		}
		if (StringUtils.isEmpty(card)) {
			throw new ApIllegalParamException("card");
		}
		
		// 组装参数
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("devid", devid);
		paramMap.put("cardboxnum", cardboxnum);
		paramMap.put("boxtype", "0");
		paramMap.put("card", card.substring(6, card.length()-1));
		
		Map<String, Object> selectMap = cardBoxInfoDaoImp.selectTakeCard(paramMap);
		
		if(selectMap.isEmpty()) {
			logger.info("不存在卡箱信息");
			throw new ApSelectNotFoundException("不存在卡箱信息");
		}
		
		if("0".equals((String)selectMap.get("totNum"))) {
			logger.info("卡箱总数[totNum]为0");
			throw new ApSelectNotFoundException("卡箱总数[totNum]为0");
		}

		int count = cardBoxInfoDaoImp.updateTakeCard(paramMap);
		if (count < 1) {
			logger.info("记数卡箱失败!");
			dbo.rollback();
			throw new ApUpdateFailException("记数卡箱失败");
		}
		dbo.commit();
	}
}
