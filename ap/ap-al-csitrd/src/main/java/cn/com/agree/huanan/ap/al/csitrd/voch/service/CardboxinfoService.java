package cn.com.agree.huanan.ap.al.csitrd.voch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.voch.dao.CardboxinfoDao;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApUpdateFailException;

@Service
public class CardboxinfoService {
	@Autowired DbOperator dbOperator;
	@Autowired CardboxinfoDao cardboxinfoDao;
	@Autowired
	DbOperator dbo;
	public void updateCardboxinfo(String devid,String cardboxnum,String totnum,String strtnum,String endnum) {
		//参数校验
		if (StringUtils.isEmpty(devid)) {
			throw new ApIllegalParamException("devid");
		}
		if (StringUtils.isEmpty(cardboxnum)) {
			throw new ApIllegalParamException("cardboxnum");
		}
		if (StringUtils.isEmpty(strtnum)) {
			throw new ApIllegalParamException("strtnum");
		}
		if (StringUtils.isEmpty(endnum)) {
			throw new ApIllegalParamException("endnum");
		}
		if (StringUtils.isEmpty(endnum)) {
			throw new ApIllegalParamException("qty");
		}
		int num = cardboxinfoDao.updateCardboxinfo(devid, cardboxnum, totnum, strtnum, endnum);
		if (num < 1) {
			dbo.rollback();
			throw new ApUpdateFailException("记数卡箱失败");
		}
		dbo.commit();
	}
}
