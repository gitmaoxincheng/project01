package cn.com.agree.huanan.ap.tl.communicate.comm.manager;
import cn.com.agree.huanan.ap.tl.communicate.comm.adapter.CommunicateAdapter;
import cn.com.agree.huanan.ap.tl.communicate.comm.adapter.context.AdapterContext;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.Const;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.ConstMapAndList;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.CommunicateProtocolErrorException;
import cn.com.agree.huanan.ap.tl.communicate.comm.params.CommParam;
import cn.com.agree.huanan.ap.tl.exception.tech.ApIllegalArgumentException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.message.base.BeanPath;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

// 通信管理
/**
 * @author luo.hp
 * 通信适配器管理器
 *
 */
public class CommunicateAdapterManager {
	
	/**
	 * 日志句柄
	 */
	public static Logger logger =  Logger.getLogger(CommunicateAdapterManager.class);
	
	/**
	 * @param appId 应用ID
	 * @param commItem 通信配置项
	 * @return 通信适配器
	 */
	public static AdapterContext getCommAdapter(String appId, String commItem){
		String nodeName=SpringUtil.getBean(BeanPath.class).getNodeName(); //节点信息由配置文件application.yml 提供
		nodeName = nodeName != null ? nodeName:Const.DEFAULT_NODE_NAME;
	    // need to implements node fetch
		return getCommAdapter(appId, commItem, nodeName);
	}
	
	/**
     * @param appId 应用ID
     * @param commItem 通信配置项
	 * @param nodeName 通信节点名称
     * @return 通信适配器
	 */
	public static AdapterContext getCommAdapter(String appId, String commItem, String nodeName){
		// 获取通信方式（加载基本通信参数）
		logger.info("加载通信适配器配置");
		CommParam param = new CommParam();
		param.init(appId, commItem, nodeName);

		// 检查是否支持通信方式
		if (!ConstMapAndList.COMMUNICATE_SUPPORT.keySet().contains(param.getCommType())){
			logger.error("通信协议非%s类型", param.getCommType());
			throw new CommunicateProtocolErrorException();
		}
		// 加载通信适配器
		BeanPath cfg = (BeanPath) SpringUtil.getBean(BeanPath.class);
		CommunicateAdapter adpater;
        try {
            logger.debug("Param:%s",param);
            logger.debug("CommType:%s",cfg.getCommAdapter().get(param.getCommType().toUpperCase()));
            adpater = (CommunicateAdapter) SpringUtil.getBean(Class.forName(cfg.getCommAdapter().get(param.getCommType().toUpperCase())));
            logger.debug("Adpater:%s",adpater.getClass().getName());
            return new AdapterContext(adpater, param);
        } catch (ClassNotFoundException e) {
            // TODO 自动生成的 catch 块
            throw new ApIllegalArgumentException(e);
        }
	}
}
