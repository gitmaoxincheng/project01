package cn.com.agree.huanan.ap.al.csiopr.mutitable.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.CheckNotDataException;
import cn.com.agree.huanan.ap.al.csiopr.mutitable.dao.ChlServiceMutiDao;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
@Service
public class ChlServiceMutiService {
	@Autowired ChlServiceMutiDao chlServiceMutiDao;
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	/**
	 * 分页查询渠道服务信息
	 * @param pageFlag
	 * @param maxNum
	 * @param platCode
	 * @param svrCode
	 * @param svrName
	 * @param svrType
	 * @param svrCentCode
	 * @param svrStatus
	 * @return
	 */
	public Map<String, Object> getChlServicePageList(String pageflag, String maxnum, String svccodeout, String scncodeout,
			String status) {
		int curPage=Integer.parseInt(pageflag);
		int pageSize=Integer.parseInt(maxnum);
		if (curPage < 1) {
			logger.error("页码不可小于1");
			throw new ApIllegalParamException("curPage");
		}
		if (pageSize < 1) {
			logger.error("每页查询记录数不可小于1");
			throw new ApIllegalParamException("pageflag");
		}
		IPage<Map<String, Object>> pageInfo=chlServiceMutiDao.getChlServicePageList(curPage, pageSize, svccodeout, scncodeout, status);
		if (0 == pageInfo.getSize()) {
			throw new CheckNotDataException();
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("rowcnt", pageInfo.getTotal());// 总笔数
		result.put("listnm", pageInfo.getSize());// 返回记录数
		result.put("service_list", pageInfo.getRecords());// 返回数据
		return result;
	}
}
