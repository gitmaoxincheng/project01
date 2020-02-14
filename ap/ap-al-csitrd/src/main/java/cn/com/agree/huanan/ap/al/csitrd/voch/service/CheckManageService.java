package cn.com.agree.huanan.ap.al.csitrd.voch.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.voch.dao.CheckManageDao;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApSelectNotFoundException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class CheckManageService {
	@Autowired DbOperator dbOperator;
	@Autowired CheckManageDao checkManageDao;
	private Logger logger = Logger.getLogger(CheckManageService.class);
	public Map<String, Object> checkReceQuery(String tradedate, String devno,String brno) {
		Map<String,Object> result = checkManageDao.checkReceQuery(tradedate, devno,brno);
		return result;
	}
	public Map<String, Object> checkDetailQuery(Integer pageflag, Integer maxnum, String startdate, String enddate, String busitype,
			String devno, String status,String brno) {
		if(pageflag < 1) {
			throw new ApIllegalParamException("页码"+pageflag+"输入有误");
		}
		if (maxnum < 1) {
			throw new ApIllegalParamException("查询记录数"+maxnum+"不正确");	
		}
		if (status == null || status.equals("")) {
			throw new ApIllegalParamException("status不可为空");
		}
		if (startdate == null || startdate.equals("")) {
			throw new ApIllegalParamException("起始交易日期不可为空");
		}
		if (enddate == null || enddate.equals("")) {
			throw new ApIllegalParamException("截止交易日期不可为空");
		}
		if (busitype == null || busitype.equals("")) {
			throw new ApIllegalParamException("业务类型不可为空");
		}
		Map<String,Object> result = checkManageDao.checkDetailQuery(pageflag, maxnum, startdate,enddate, busitype, devno, status,brno);
		if(String.valueOf(result.get("detail_list")).equals("[]")) {
			throw new ApSelectNotFoundException("支票受理信息");
		}
		return result;
	}
	
	public Map<String, Object> checkSoldQuery(Integer pageflag, Integer maxnum, String startdate, String enddate, String devno,
			String status,String brno) {
		if(pageflag < 1) {
			throw new ApIllegalParamException("页码"+pageflag+"输入有误");
		}
		if (maxnum < 1) {
			throw new ApIllegalParamException("查询记录数"+maxnum+"不正确");	
		}
		if (status == null || status.equals("")) {
			throw new ApIllegalParamException("status不可为空");
		}
		if (startdate == null || startdate.equals("")) {
			throw new ApIllegalParamException("起始交易日期不可为空");
		}
		if (enddate == null || enddate.equals("")) {
			throw new ApIllegalParamException("截止交易日期不可为空");
		}
		Map<String,Object> result = checkManageDao.checkSoldQuery(pageflag, maxnum, startdate,enddate, devno, status,brno);
		if(String.valueOf(result.get("detail_list")).equals("[]")) {
			throw new ApSelectNotFoundException("支票受理信息");
		}
		return result;
	}
}
