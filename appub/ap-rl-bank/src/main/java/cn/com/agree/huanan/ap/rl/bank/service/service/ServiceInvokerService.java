package cn.com.agree.huanan.ap.rl.bank.service.service;


import cn.com.agree.huanan.ap.rl.bank.service.dao.ServiceRelationDao;
import cn.com.agree.huanan.ap.rl.bank.service.exception.ServiceInvokeFailException;
import cn.com.agree.huanan.ap.rl.bank.service.po.ServiceRelation;
import cn.com.agree.huanan.ap.tl.exception.busi.ApNullArgsException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ServiceInvokerService {
	@Autowired
	private ServiceRelationDao serviceDao;
	@Autowired private Logger logger;

	//查询服务调度关系记录
	public ServiceRelation queryServiceRelation(String serviceId, String srcSvc,String srcScn){
		if (StringUtils.isEmpty(serviceId)) {
			throw new ApNullArgsException("serviceId", "请求服务标识");
		}
		if (StringUtils.isEmpty(srcSvc)) {
			throw new ApNullArgsException("srcSvc", "消费方服务码");
		}
		if (StringUtils.isEmpty(srcScn)) {
			throw new ApNullArgsException("srcScn", "消费方场景码");
		}
		ServiceRelation serviceRelation = serviceDao.selectServiceRelation(serviceId, srcSvc, srcScn);
		if (serviceRelation == null) {
			logger.error("查询服务调用关系失败，服务标识：%s, 消费方服务码：%s, 消费方场景码：%s",serviceId,srcSvc,srcScn);
//			throw new ServiceInvokeFailException(serviceId, srcSvc+"."+srcScn);// XXXX
		}
		return serviceRelation;
	}





}
