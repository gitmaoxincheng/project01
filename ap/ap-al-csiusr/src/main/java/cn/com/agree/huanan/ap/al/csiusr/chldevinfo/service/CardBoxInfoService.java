package cn.com.agree.huanan.ap.al.csiusr.chldevinfo.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.dao.CardBoxInfoDaoImp;
import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.exception.CheckNotDataException;
import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po.CardBoxInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApSelectNotFoundException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApUpdateFailException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class CardBoxInfoService{
	@Autowired CardBoxInfoDaoImp cardBoxInfoDaoImp;
	@Autowired Logger logger;
	@Autowired DbOperator dbo;
	
	// 设备卡箱卡类型查询
	public Map<String, Object> queryCardBoxInfo(Map<String, Object> paramMap) {
		return cardBoxInfoDaoImp.selectCardBoxInfo(paramMap);		
	}
		 
	//插入字段
	public void addCardBoxInfoByNo(CardBoxInfo cardBoxInfo) {
		int  count  = cardBoxInfoDaoImp.insertCardBoxInfo(cardBoxInfo);
		if (count != 1) {
			dbo.rollback();
			logger.error("数据插入失败");
			throw new CheckNotDataException("维护失败");
		}
	}
	
	// 提交数据
	public void getCommit() {
		dbo.commit();
		logger.info("数据插入成功");
	}
		
    // 删除数据，不立即提交
	public void removeCardBoxInfoByNo(Map<String, Object> deleteMap) {
		int count = cardBoxInfoDaoImp.deleteCardBoxInfo(deleteMap);
		String optype = (String) deleteMap.get("optype");
		// 1=清机立即删除，0=加卡不立即删除，加卡成功才删除
		if("1".equals(optype)) {
			if (count != 1) {
				dbo.rollback();
				logger.error("数据删除失败");
				throw new CheckNotDataException("数据删除失败");
			}else {
				dbo.commit();
				logger.info("数据删除成功");
			}
		}		
	}
	
	/**
	 * 卡箱库存修改
	 * @param cardBoxlist  凭证列表
	 * @param optype	操作类型
	 */
	public void updateTakeCard(ArrayList cardBoxlist, String optype) {
		
		for (int i = 0; i < cardBoxlist.size(); i++) {
			Map<String, Object> paramMap = (Map<String, Object>) cardBoxlist.get(i);
			//参数校验
			if (StringUtils.isEmpty(paramMap.get("cardboxnum"))) {
				throw new ApIllegalParamException("cardboxnum");
			}
			if (StringUtils.isEmpty(paramMap.get("boxtype"))) {
				throw new ApIllegalParamException("boxtype");
			}
			Map<String, Object> selectMap = cardBoxInfoDaoImp.selectTakeCard(paramMap);
			if(selectMap.isEmpty()) {	//判断是否存在卡箱
				logger.info("不存在卡箱信息");
				throw new ApSelectNotFoundException("不存在卡箱信息");
			}
			if("1".equals(optype)) {	//1-减凭证时判断总数是否为0
				if("0".equals((String)selectMap.get("totNum"))) {
					logger.info("卡箱总数[totNum]为0");
					throw new ApSelectNotFoundException("卡箱总数[totNum]为0");
				}
			}
			int count = cardBoxInfoDaoImp.updateTakeCard(paramMap,optype);
			if (count < 1) {
				logger.info("记数卡箱失败!");
				dbo.rollback();
				throw new ApUpdateFailException("记数卡箱失败");
			}
		}
		dbo.commit();
	}

	
}
