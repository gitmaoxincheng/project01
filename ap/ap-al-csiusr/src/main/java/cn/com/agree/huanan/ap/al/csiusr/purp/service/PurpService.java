package cn.com.agree.huanan.ap.al.csiusr.purp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiusr.purp.dao.PurpDao;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 随机数服务层
 * @author HWW
 */
@Service
public class PurpService {
	@Autowired PurpDao PurpDao;
	@Autowired Logger logger;
	@Autowired DbOperator dbo;
}
