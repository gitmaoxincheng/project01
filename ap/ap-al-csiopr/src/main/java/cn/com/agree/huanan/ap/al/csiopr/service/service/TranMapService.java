package cn.com.agree.huanan.ap.al.csiopr.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiopr.service.dao.TranMapDao;
import cn.com.agree.huanan.ap.al.csiopr.service.exception.ServiceCataException;
import cn.com.agree.huanan.ap.al.csiopr.service.po.TranMapp;
//import cn.com.agree.huanan.ap.tl.exception.busi.ApNullArgsException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 交易映射服务
 * @author hcp
 *
 */
@Service
public class TranMapService {
	
	@Autowired private Logger logger;
	@Autowired private TranMapDao tranMapDao;

	
	public TranMapp querTranMap(String svcCodeOut , String scnCodeOut) {
		if (StringUtils.isEmpty(svcCodeOut) || StringUtils.isEmpty(scnCodeOut)){
			//throw new ApNullArgsException("svcCodeOut或scnCodeOut","对外服务码或场景码");
			throw new ServiceCataException("svcCodeOut或scnCodeOut");
		}

		return  tranMapDao.selectTranMap(svcCodeOut, scnCodeOut);
	}
}
