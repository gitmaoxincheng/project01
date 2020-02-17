package tc.bank.base.io;

import cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.ServiceBeanConfig;
import cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.service.IOService;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

/**
 * @author HCP
 * IO工具类
 */
public class IOServiceUtil {
	private static Logger logger = Logger.getLogger(IOServiceUtil.class);
	
	public static  IOService newServiceInstance(String systemID, String serviceName, String tradeName){
//		String serviceBeanName = new StringBuffer(ServiceBeanConfig.SERVICEPATH).append(".").append(systemID.toLowerCase())
//				.append(".").append(serviceName.toLowerCase()).append(".").append(tradeName).toString();
		String serviceBeanName = new StringBuffer(ServiceBeanConfig.SERVICEPATH)
		.append(".").append(serviceName.toLowerCase()).append(".").append(tradeName).toString();
		IOService ioService = null;
		try {
			logger.debug("获取实例对象:" + serviceBeanName);
			ioService = (IOService)SpringUtil.getBean(Class.forName(serviceBeanName));
		} catch (ClassNotFoundException e) {
			logger.error("获取服务实例失败:" + e.getMessage());
			throw ExceptionUtil.convert(e);
		}
		return ioService;
	}
	
	
}
