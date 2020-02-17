package tc.bank.communicate.util;
import cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.ServiceBeanConfig;
import cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.service.IOService;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

/**
 * @author xqq,hcp
 * 渠道服务公共类
 */
public class ChannelServiceUtil {
	private static Logger logger = Logger.getLogger(ChannelServiceUtil.class);
	
	public static  IOService newIOInstance(String systemID, String serviceName, String tradeName){
		String serviceBeanName = new StringBuffer(ServiceBeanConfig.SERVICEPATH).append(".").append(systemID.toLowerCase()).append(".").append(tradeName).toString();
		IOService ioService = null;
		try {
			logger.debug("获取实例对象:" + serviceBeanName);
			ioService = (IOService)SpringUtil.getBean(Class.forName(serviceBeanName));
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			logger.debug("获取服务实例失败:" + e.getMessage());
			throw ExceptionUtil.convert(e);
		}
		return ioService;
	}
	

}
