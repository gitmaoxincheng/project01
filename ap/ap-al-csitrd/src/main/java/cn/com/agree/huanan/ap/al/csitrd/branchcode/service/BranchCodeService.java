package cn.com.agree.huanan.ap.al.csitrd.branchcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.branchcode.dao.BranchCodeDao;
import cn.com.agree.huanan.ap.al.csitrd.branchcode.exception.CheckNotDataException;
import cn.com.agree.huanan.ap.al.csitrd.branchcode.po.BranchCode;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 机构身份识别码service
 * @author lanshaojun
 *
 */
@Service
public class BranchCodeService {
	@Autowired BranchCodeDao branchCodeDao;
	@Autowired DbOperator dbo;
	@Autowired Logger logger;

	/**
	 * 查询机构身份识别码记录
	 * @param strbranch 网点号
	 * @return 机构身份识别码记录
	 *
	 */
	public BranchCode getBranchCode(String strbranch) {
		// TODO 自动生成的方法存根

		//检验参数
		if (null == strbranch || StringUtils.isEmpty(strbranch)) {
			throw new ApIllegalParamException("strbranch");	
		}
		
		BranchCode branchCode = branchCodeDao.getBranchCode(strbranch);
		
		if(null == branchCode) {
			logger.error("查询结果为空");
			throw new CheckNotDataException();
		}
		return branchCode;
	}
}
