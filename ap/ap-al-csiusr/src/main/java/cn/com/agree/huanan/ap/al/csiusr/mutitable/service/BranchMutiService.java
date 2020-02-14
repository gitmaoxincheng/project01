package cn.com.agree.huanan.ap.al.csiusr.mutitable.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.mutitable.dao.BranchMutiDao;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class BranchMutiService {

	@Autowired BranchMutiDao branchMutiDao;
	@Autowired Logger logger;
	public Map<String, Object> queryBranchExitInfo(String brNo,String idxBrno, int pageSize, int pageFlag) {
		if (pageSize < 1) {
			logger.error("每页查询记录数不可小于1");
			throw new ApIllegalParamException("pageSize");	//XXX
		}
		
		if (StringUtils.isEmpty(idxBrno)) {
			idxBrno = "00000000";
		}
		
		return branchMutiDao.selectBranchExitInfo(brNo, idxBrno, pageSize, pageFlag);
	}
}
